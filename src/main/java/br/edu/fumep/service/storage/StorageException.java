package br.edu.fumep.service.storage;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
