package br.edu.fa7.controller;

import br.edu.fa7.domain.Route;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteController {

    @RequestMapping("/route")
    public List<Route> list() {
        return null;
    }

    @RequestMapping("/route/{id}")
    public Route get(@PathVariable("id") Integer id) {
        return null;
    }

    @RequestMapping(value = "/route", method = RequestMethod.POST)
    public Route create(Route route) {
        return null;
    }

    @RequestMapping(value = "/route", method = RequestMethod.PUT)
    public Route update(Route route) {
        return null;
    }

    @RequestMapping(value = "/route/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable("id") Integer id) {
        return null;
    }
}
