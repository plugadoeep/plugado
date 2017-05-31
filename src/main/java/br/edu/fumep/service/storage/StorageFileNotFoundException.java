package br.edu.fumep.service.storage;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}