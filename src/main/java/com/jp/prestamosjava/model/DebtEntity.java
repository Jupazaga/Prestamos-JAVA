package com.jp.prestamosjava.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "debt", schema = "prestamos")
public class DebtEntity {
    @Id
    @Column(name = "lender")
    private int lender;

    @Id
    @Column(name = "debtor")
    private int debtor;

    @Basic
    @Column(name = "last_payment")
    private Date lastPayment;

    @Basic
    @Column(name = "amount")
    private Long amount;

    @Basic
    @Column(name = "total_debt")
    private Long totalDebt;

    public DebtEntity() {

    }

    public DebtEntity(int lender, int debtor, Date lastPayment, Long amount) {
        this.lender = lender;
        this.debtor = debtor;
        this.lastPayment = lastPayment;
        this.amount = amount;
    }

    public int getLender() {
        return lender;
    }

    public void setLender(int lender) {
        this.lender = lender;
    }

    public int getDebtor() {
        return debtor;
    }

    public void setDebtor(int debtor) {
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

    public Long getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(Long totalDebt) {
        this.totalDebt = totalDebt;
    }

}
