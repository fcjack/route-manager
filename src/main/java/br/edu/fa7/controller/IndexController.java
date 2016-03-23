package br.edu.fa7.controller;

import br.edu.fa7.dao.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private VehicleDao vehicleDao;

    @RequestMapping("/")
    public String home() {
        vehicleDao.list();
        return "Hello Word";
    }
}
