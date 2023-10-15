package org.learn;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void testSetter(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Book book = context.getBean("book", Book.class);
        showBean(book);
        book = (Book)context.getBean("book2");
        showBean(book);


    }

    private void showBean(Object book){
        Gson gson = new Gson();
        System.out.println(gson.toJson(book));
    }

    @Test
    public void testDal(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dal.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource);
        System.out.println(dataSource.getUrl());
    }

}