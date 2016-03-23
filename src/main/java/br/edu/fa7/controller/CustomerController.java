package br.edu.fa7.controller;

import br.edu.fa7.dao.CustomerDao;
import br.edu.fa7.dao.EnterpriseCustomerDao;
import br.edu.fa7.dao.NormalCustomerDao;
import br.edu.fa7.domain.Customer;
import br.edu.fa7.domain.EnterpriseCustomer;
import br.edu.fa7.domain.NormalCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private NormalCustomerDao normalCustomerDao;

    @Autowired
    private EnterpriseCustomerDao enterpriseCustomerDao;

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/customer")
    public List<Customer> list() {
        return customerDao.list();
    }

    @RequestMapping("/customer/{id}")
    public Customer get(@PathVariable("id") Integer id) {
        return customerDao.findById(id);
    }

    @RequestMapping(value = "/customer/saveNormalCustomer", method = RequestMethod.POST)
    public void create(@RequestBody NormalCustomer customer) {
        normalCustomerDao.save(customer);
    }

    @RequestMapping(value = "/customer/saveEnterpriseCustomer", method = RequestMethod.POST)
    public void create(@RequestBody EnterpriseCustomer customer) {
        enterpriseCustomerDao.save(customer);
    }

    @RequestMapping(value = "/customer/saveNormalCustomer", method = RequestMethod.PUT)
    public void update(@RequestBody NormalCustomer customer) {
        normalCustomerDao.save(customer);
    }

    @RequestMapping(value = "/customer/saveEnterpriseCustomer", method = RequestMethod.PUT)
    public void update(@RequestBody EnterpriseCustomer customer) {
        enterpriseCustomerDao.save(customer);
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.DELETE)
    public void create(@PathVariable Integer customerId) {
        enterpriseCustomerDao.remove(customerId);
    }
}
