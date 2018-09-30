package com.huibo.demo.mapper;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarMapperTest {

    @Test
    public void aTest() {
        System.out.println("a " + new Date());
    }

    @Test
    public void cTest() {
        System.out.println("c " + new Date());
    }

    @Test
    public void bTest() {
        System.out.println("b " + new Date());
    }

    @Test
    public void dTest() {
        System.out.println("d " + new Date());
    }
}