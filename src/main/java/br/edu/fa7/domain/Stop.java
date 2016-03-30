package br.edu.fa7.domain;

import br.edu.fa7.enums.StopStatus;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * Created by jackson on 3/25/16.
 */
@Entity
@Table(name = "stop")
public class Stop extends AbstractEntity {

    @OneToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Route route;

    @OneToOne
    private Customer customer;

    @OrderBy
    private Integer idx;

    @Enumerated(EnumType.STRING)
    private StopStatus status;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public StopStatus getStatus() {
        return status;
    }

    public void setStatus(StopStatus status) {
        this.status = status;
    }

    public void setRouteId(Integer routeId) {
        Route route = new Route();
        route.setId(routeId);
        this.route = route;
    }
}
