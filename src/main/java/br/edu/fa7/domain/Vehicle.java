package br.edu.fa7.domain;

import javax.persistence.Entity;

/**
 * Created by jackson on 3/23/16.
 */
@Entity
public class Vehicle extends AbstractEntity {

    private String code;
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
