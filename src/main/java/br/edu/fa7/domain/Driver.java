package br.edu.fa7.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by jackson on 3/23/16.
 */
@Entity
public class Driver extends AbstractEntity {

    private String name;
    private String registation;

    @OneToMany(mappedBy = "plate")
    private Set<Vehicle> vehicles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistation() {
        return registation;
    }

    public void setRegistation(String registation) {
        this.registation = registation;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
