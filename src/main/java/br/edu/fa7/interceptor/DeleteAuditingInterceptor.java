package br.edu.fa7.interceptor;

import br.edu.fa7.dao.DeleteAuditingDao;
import br.edu.fa7.domain.AbstractEntity;
import br.edu.fa7.domain.DeleteAuditing;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class DeleteAuditingInterceptor implements PostDeleteEventListener {

    @Autowired
    DeleteAuditingDao deleteAuditingDao;

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        AbstractEntity entity = (AbstractEntity) event.getEntity();
        Class<?> entityClass = event.getEntity().getClass();

        DeleteAuditing deleteAuditing = new DeleteAuditing();

        deleteAuditing.setEntity(entityClass.getName());
        deleteAuditing.setEntityId(entity.getId());
        deleteAuditing.setDeleteDate(new Date());

        deleteAuditingDao.save(deleteAuditing);
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister persister) {
        return true;
    }
}
