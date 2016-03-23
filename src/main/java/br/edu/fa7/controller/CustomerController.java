package br.edu.fa7.controller;

import br.edu.fa7.domain.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class CustomerController {

    @RequestMapping("/customer")
    public List<Customer> list() {
        return null;
    }

    @RequestMapping("/customer/{id}")
    public Customer get(@PathVariable("id") Integer id) {
        return null;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer create(Customer customer) {
        return null;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public Customer update(Customer customer) {
        return null;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable("id") Integer id) {
        return null;
    }
}
