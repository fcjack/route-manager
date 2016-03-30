package br.edu.fa7.domain;

import br.edu.fa7.enums.RouteStatus;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jackson on 3/23/16.
 */
@Entity
public class Route extends AbstractEntity {

    @Column(nullable = false)
    private String code;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private RouteStatus routeStatus;

    @OneToOne(optional = false)
    private Vehicle vehicle;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PATH", joinColumns = @JoinColumn(name = "route_id"))
    @OrderColumn(name = "IDX")
    private List<Position> path;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "route", cascade = CascadeType.REFRESH)
    private List<Stop> stops;

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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }
}
