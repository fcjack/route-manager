package br.edu.fa7.dao;

import br.edu.fa7.domain.AbstractEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by jackson on 3/23/16.
 */
@Transactional
public class GenericDao<T extends AbstractEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    private Class getRecordType() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public List<T> list() {
        Criteria criteria = getCurrentSession().createCriteria(getRecordType());
        return criteria.list();
    }

    public T findById(Integer id) {
        Criteria criteria = getCurrentSession().createCriteria(getRecordType());
        criteria.add(Restrictions.idEq(id));

        T object = (T) getRecordType().cast(criteria.uniqueResult());
        getCurrentSession().evict(object);

        return object;
    }

    public void save(T entity) {
        getCurrentSession().saveOrUpdate(entity);
        getCurrentSession().flush();
    }

    public void remove(Integer id) {
        Session session = getCurrentSession();

        Criteria criteria = session.createCriteria(getRecordType());
        criteria.add(Restrictions.idEq(id));

        session.delete(criteria.uniqueResult());
        session.flush();
    }

}
