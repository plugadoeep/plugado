package br.edu.fumep.service.storage;

import br.edu.fumep.entity.Mensagem;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
public interface StorageService {

    void init();

    void store(Mensagem mensagem, MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

}
