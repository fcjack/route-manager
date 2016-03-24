package br.edu.fa7.domain;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class DeleteAuditing extends AbstractEntity {
    private String entity;
    private Integer entityId;
    private Date deleteDate;

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }
}
