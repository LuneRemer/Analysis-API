package com.api.realtime.demo.domain;

import com.api.realtime.demo.entity.news;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import javax.persistence.*;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ApiController {

//    @Autowired
//    NewsRepository newsRepository;

    @RequestMapping(value = "/api/data", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<news> getData(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            TypedQuery<news> newsByNewsIdQuery = entityManager.createNamedQuery("News.byNewsId", news.class);
            newsByNewsIdQuery.setParameter(1, 8);
            for (com.api.realtime.demo.entity.news news : newsByNewsIdQuery.getResultList()) {
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
    public List<news> getDataRepo(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            TypedQuery<news> newsList = entityManager.createNamedQuery("findAllNews", news.class);


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

            String query = "select a, b.title from ageanalysis a, news b where a.newsId = b.newsId";
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

    @RequestMapping(value="/api/test", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
    public JSONArray testData(){
        JSONArray dataArray = new JSONArray();
        JSONObject one = new JSONObject();
        JSONObject two = new JSONObject();
        JSONObject three = new JSONObject();
        JSONObject four = new JSONObject();
        JSONObject five = new JSONObject();
        JSONObject six = new JSONObject();
        JSONObject seven = new JSONObject();
        JSONObject eight = new JSONObject();

        one.put("keyword", "Frozen Yogurt");
        two.put("keyword", "Ice cream sandwich");
        three.put("keyword", "Eclair");
        four.put("keyword", "Cupcake");
        five.put("keyword", "Gingerbread");
        six.put("keyword", "Jelly bean");
        seven.put("keyword", "Lollipop");
        eight.put("keyword", "Honeycomb");


        dataArray.add(one);
        dataArray.add(two);
        dataArray.add(three);
        dataArray.add(four);
        dataArray.add(five);
        dataArray.add(six);
        dataArray.add(seven);
        dataArray.add(eight);

        return dataArray;
    }
}
