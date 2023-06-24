package com.jp.prestamosjava.dao;

import com.jp.prestamosjava.model.UserEntity;
import jakarta.persistence.EntityManager;

public class UserDao {
    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(UserEntity userEntity){
        this.entityManager.persist(userEntity);
    }

    public void update(UserEntity usersEntity){
        this.entityManager.merge(usersEntity);
    }

    public UserEntity findUserById(String id){
        return entityManager.find(UserEntity.class, id);
    }
}
