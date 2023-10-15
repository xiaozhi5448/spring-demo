package org.learn.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private final static Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Test
    void add() {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User)context.getBean("user");
        user.add();
        logger.info("completed");
        user = context.getBean(User.class);
        System.out.println(String.format("根据类型获取bean: %s", user));
        user = context.getBean("user", User.class);
        System.out.println("根据ID和类型获取：" + user);
    }

    @Test
    void testReflection() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("org.learn.demo.User");
        User o = (User)aClass.getDeclaredConstructor().newInstance();
        System.out.println(o);
    }
}