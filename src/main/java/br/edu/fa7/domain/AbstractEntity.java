package br.edu.fa7.domain;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@SuppressWarnings("serial")
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "MANAGER_SEQ")
    @TableGenerator(name = "MANAGER_SEQ", table = "TABLE_OF_SEQUENCE",
            pkColumnName = "ENTITY", valueColumnName = "NEXT_ID",
            allocationSize = 1, schema = "routeManager")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
