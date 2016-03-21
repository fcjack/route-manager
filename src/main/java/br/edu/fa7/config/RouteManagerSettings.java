package br.edu.fa7.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by jackson on 3/21/16.
 */
@Component
public class RouteManagerSettings {

    @Value("${databaseUrl}")
    private String databaseUrl;

    @Value("${databaseUser}")
    private String databaseUser;

    @Value("${databasePassword}")
    private String databasePassword;

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
    }
}
