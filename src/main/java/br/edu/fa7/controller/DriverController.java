package br.edu.fa7.controller;

import br.edu.fa7.dao.DriverDao;
import br.edu.fa7.domain.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverDao driverDao;

    @RequestMapping
    public List<Driver> list() {
        return driverDao.list();
    }

    @RequestMapping("/{id}")
    public Driver get(@PathVariable("id") Integer id) {
        return driverDao.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Driver driver) {
        driverDao.save(driver);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody Driver driver) {
        driverDao.save(driver);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        driverDao.remove(id);
    }
}
