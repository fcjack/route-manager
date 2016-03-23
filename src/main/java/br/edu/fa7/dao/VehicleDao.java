package br.edu.fa7.dao;

import br.edu.fa7.domain.Vehicle;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jackson on 3/23/16.
 */
@Repository
public class VehicleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Vehicle> list() {
        Session sesssion = sessionFactory.getCurrentSession();
        Criteria criteria = sesssion.createCriteria(Vehicle.class);

        return criteria.list();
    }
}
