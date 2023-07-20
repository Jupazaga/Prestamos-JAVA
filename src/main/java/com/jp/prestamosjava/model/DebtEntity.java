package com.jp.prestamosjava.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "debt", schema = "prestamos")
public class DebtEntity {
    @Id
    @Column(name = "lender")
    private Long lender;

    @Id
    @Column(name = "debtor")
    private Long debtor;

    @Basic
    @Column(name = "last_payment")
    private Date lastPayment;

    @Basic
    @Column(name = "amount")
    private Long amount;


    public DebtEntity() {

    }

    public DebtEntity(Long lender, Long debtor, Date lastPayment, Long amount) {
        this.lender = lender;
        this.debtor = debtor;
        this.lastPayment = lastPayment;
        this.amount = amount;
    }

    public Long getLender() {
        return lender;
    }

    public void setLender(Long lender) {
        this.lender = lender;
    }

    public Long getDebtor() {
        return debtor;
    }

    public void setDebtor(Long debtor) {
        this.debtor = debtor;
    }

    public Date getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(Date lastPayment) {
        this.lastPayment = lastPayment;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
