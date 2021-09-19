package com.api.realtime.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.realtime.demo.entity.News;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
//    @Autowired
//    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
}
