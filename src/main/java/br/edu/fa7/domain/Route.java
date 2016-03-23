package br.edu.fa7.domain;

import br.edu.fa7.enums.RouteStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by jackson on 3/23/16.
 */
@Entity
public class Route extends AbstractEntity {

    private String code;

    @Enumerated(EnumType.STRING)
    private RouteStatus routeStatus;

    private Date routeDate;

    private Vehicle vehicle;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PATH", joinColumns = @JoinColumn(name = "ROUTE_ID"))
    @OrderColumn(name = "IDX")
    private List<Position> path;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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

    public Date getRouteDate() {
        return routeDate;
    }

    public void setRouteDate(Date routeDate) {
        this.routeDate = routeDate;
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
}
