package com.api.realtime.demo.domain;

import com.api.realtime.demo.entity.Ageanalysis;
import com.api.realtime.demo.entity.Comments;
import com.api.realtime.demo.repository.NewsRepository;
import com.api.realtime.demo.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.persistence.*;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ApiController {


    @RequestMapping(value = "/api/data", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<News> getData(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            TypedQuery<News> newsByNewsIdQuery = entityManager.createNamedQuery("News.byNewsId", News.class);
            newsByNewsIdQuery.setParameter(1, 8);
            for (News news : newsByNewsIdQuery.getResultList()) {
                System.out.println(news);
            }

            transaction.commit();
            return newsByNewsIdQuery.getResultList();

        } finally{
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @RequestMapping(value = "/api/all", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<News> getDataRepo(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            TypedQuery<News> newsList = entityManager.createNamedQuery("findAllNews", News.class);


            transaction.commit();
            return newsList.getResultList();

        } finally{
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @RequestMapping(value = "/api/join", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List getDataJoin(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            String query = "select a, b.title from Ageanalysis a, News b where a.newsId = b.newsId";
            List result = entityManager.createQuery(query).getResultList();


            transaction.commit();
            return result;

        } finally{
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
