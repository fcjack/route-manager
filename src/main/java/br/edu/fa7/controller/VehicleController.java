package br.edu.fa7.controller;

import br.edu.fa7.dao.VehicleDao;
import br.edu.fa7.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jackson on 3/23/16.
 */
@RestController
@RequestMapping("vehicle")
public class VehicleController {

    @Autowired
    private VehicleDao vehicleDao;

    @RequestMapping
    public List<Vehicle> findAll() {
        return vehicleDao.list();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Vehicle vehicle) {
        vehicleDao.save(vehicle);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Vehicle vehicle) {
        vehicleDao.save(vehicle);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer id) {
        vehicleDao.remove(id);
    }

    @RequestMapping(value = "/{id}")
    public void findById(@PathVariable Integer id) {
        vehicleDao.findById(id);
    }
}
