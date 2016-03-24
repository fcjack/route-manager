package br.edu.fa7.domain;

import br.edu.fa7.enums.RouteStatus;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jackson on 3/23/16.
 */
@Entity
public class Route extends AbstractEntity {

    private String code;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RouteStatus routeStatus;

    @OneToOne
    private Vehicle vehicle;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PATH", joinColumns = @JoinColumn(name = "ROUTE_ID"))
    @OrderColumn(name = "IDX")
    private List<Position> path;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "stops",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public RouteStatus getRouteStatus() {
        return routeStatus;
    }

    public void setRouteStatus(RouteStatus routeStatus) {
        this.routeStatus = routeStatus;
    }

    public List<Position> getPath() {
        return path;
    }

    public void setPath(List<Position> path) {
        this.path = path;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
