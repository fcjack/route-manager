package br.edu.fa7.controller;

import org.postgresql.Driver;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {

    @RequestMapping("/driver")
    public List<Driver> list() {
        return null;
    }

    @RequestMapping("/driver/{id}")
    public Driver get(@PathVariable("id") Integer id) {
        return null;
    }

    @RequestMapping(value = "/driver", method = RequestMethod.POST)
    public Driver create(Driver driver) {
        return null;
    }

    @RequestMapping(value = "/driver", method = RequestMethod.PUT)
    public Driver update(Driver driver) {
        return null;
    }

    @RequestMapping(value = "/driver/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable("id") Integer id) {
        return null;
    }
}
