package com.jp.prestamosjava.dao;

import com.jp.prestamosjava.model.DebtEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DebtDao {
    private final EntityManager entityManager;

    public DebtDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(DebtEntity debt){
        this.entityManager.persist(debt);
    }
    public List<DebtEntity> debtsList(Long lender){
        String jpql = "SELECT d FROM DebtEntity d WHERE d.lender = :lender";
        TypedQuery<DebtEntity> query = entityManager.createQuery(jpql, DebtEntity.class);
        query.setParameter("lender", lender);
        return query.getResultList();
    }
}
