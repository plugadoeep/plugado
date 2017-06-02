package br.edu.fumep.service.storage;

import br.edu.fumep.entity.Arquivo;
import br.edu.fumep.entity.Mensagem;
import br.edu.fumep.repository.ArquivoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Autowired
    private ArquivoRepositorio arquivoRepositorio;

    @Override
    public void store(Mensagem mensagem, MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return;
            }

            String name = file.getOriginalFilename();

            String extension = name.replaceAll("^.*\\.(.*)$", ".$1");

            Path f = Files.createTempFile(this.rootLocation,"", extension);

            Files.copy(file.getInputStream(), f, StandardCopyOption.REPLACE_EXISTING);

            Arquivo arquivo = new Arquivo(mensagem);

            arquivo.setNome(f.getFileName().toString());
            arquivo.setDataInclusao(LocalDate.now());
            arquivo.setFormato(extension);
            arquivo.setTamanho((double)file.getSize());

            arquivoRepositorio.save(arquivo);

        } catch (IOException e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
