# Backend(Spring Boot API using JPA)
* Version
  * Spring Boot 2.2.7
  * java 1.8
  * MySql 8
## Database(Mysql) Schema
<pre>
<code>
create table News(
news_id int not null,
title varchar(2000) not null,
url varchar(2000) not null,
date timestamp not null,
constraint pk_news primary key(news_id)
);

create table GenderAnalysis(
gender_id int not null,
news_id int not null,
male double not null,
female double not null,
constraint pk_gender primary key(gender_id),
constraint fk_gender foreign key(news_id) references News(news_id)
);

create table AgeAnalysis(
age_id int not null,
news_id int not null,
tens double not null,
twenties double not null,
thirties double not null,
fourties double not null,
fifties double not null,
sixties double not null,
constraint pk_age primary key(age_id),
constraint fk_age foreign key(news_id) references News(news_id)
);

create table Comments(
comments_id int not null,
news_id int not null,
contents varchar(3000) not null,
writer varchar(20) not null,
recommended int not null,
unrecommended int not null,
date timestamp not null,
constraint pk_comments primary key(comments_id),
constraint fk_comments foreign key(news_id) references News(news_id)
);
</code>
</pre>

## API URL
* /api/all
 * Return all tuples in News table 
* /api/join
 * Return Ageanalysis's tuple where newsId is same to News's newsId
** <API contents and URL will be changed depending on what to show on Vue.js> **
 


