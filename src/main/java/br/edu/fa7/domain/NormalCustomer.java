package br.edu.fa7.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by jackson on 3/23/16.
 */
@Entity
@Table(name = "normal_customer")
@PrimaryKeyJoinColumn(name = "customer_id")
public class NormalCustomer extends Customer {

    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
