package br.edu.fa7.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by jackson on 3/23/16.
 */
@Entity
@Table(name = "enterprise_customer")
@PrimaryKeyJoinColumn(name = "customer_id")
public class EnterpriseCustomer {

    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
