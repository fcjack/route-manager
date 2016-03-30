package br.edu.fa7.interceptor;

import br.edu.fa7.domain.AbstractEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;

/**
 * Created by Rubens Pinheiro on 3/23/16
 */
public class DeleteAuditingInterceptor extends EmptyInterceptor {

    private Logger logger = LogManager.getLogger(getClass());

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        AbstractEntity abstractEntity = (AbstractEntity) entity;
        Class<?> entityClass = abstractEntity.getClass();

        logger.info(String.format("Deleting entity [%s] with id [%d] by user", entityClass.getCanonicalName(), abstractEntity.getId()));
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        AbstractEntity abstractEntity = (AbstractEntity) entity;
        Class<?> entityClass = abstractEntity.getClass();

        if (abstractEntity.getId() != null) {
            logger.info(String.format("Updating entity [%s] with id [%d] by user", entityClass.getCanonicalName(), abstractEntity.getId()));
        } else {
            logger.info(String.format("Creating entity [%s] with id [%d] by user", entityClass.getCanonicalName(), abstractEntity.getId()));
        }

        return super.onSave(entity, id, state, propertyNames, types);
    }
}
