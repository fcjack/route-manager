package br.edu.fa7.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by jackson on 3/23/16.
 */
@Entity
@Table(name = "vehicle")
public class Vehicle extends AbstractEntity {

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String plate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
