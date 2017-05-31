package br.edu.fumep.service.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    private String location = "static/files";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
