package com.api.realtime.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.realtime.demo.entity.news;

//@Repository
public interface NewsRepository extends JpaRepository<news, Long> {
//    @Autowired
//    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
}
