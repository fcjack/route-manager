package br.edu.fa7.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jackson on 3/23/16.
 */
@Entity
@Table(name = "driver")
public class Driver extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    private String registration;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "driver_vehicle", joinColumns = @JoinColumn(name = "driver_id"), inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private Set<Vehicle> vehicles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
