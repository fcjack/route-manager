package br.edu.fa7.controller;

import br.edu.fa7.dao.RouteDao;
import br.edu.fa7.dao.StopDao;
import br.edu.fa7.domain.Route;
import br.edu.fa7.domain.Stop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RouteController {

    @Autowired
    private RouteDao routeDao;

    @Autowired
    private StopDao stopDao;

    @RequestMapping("/route")
    public List<Route> list() {
        return routeDao.list();
    }

    @RequestMapping("/route/{id}")
    public Route get(@PathVariable("id") Integer id) {
        return routeDao.findById(id);
    }

    @RequestMapping(value = "/route", method = RequestMethod.POST)
    public void create(@RequestBody Route route) {
        routeDao.save(route);
        updateStops(route);
    }

    @RequestMapping(value = "/route", method = RequestMethod.PUT)
    public void update(@RequestBody Route route) {
        routeDao.save(route);
        updateStops(route);
    }

    @RequestMapping(value = "/route/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        routeDao.remove(id);
    }

    private void updateStops(Route route) {
        for (Stop stop : route.getStops()) {
            stop.setRouteId(route.getId());
            stopDao.save(stop);
        }
    }
}
