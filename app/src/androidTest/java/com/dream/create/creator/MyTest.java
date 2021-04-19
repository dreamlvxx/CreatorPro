package com.dream.create.creator;

import com.dream.create.creator.framework.BaseTest;

import org.junit.Before;
import org.junit.Test;

public class MyTest extends BaseTest {

    @Before
    public void doPree(){
        System.out.println("do preee");
    }

    @Test
    public void simple(){
        System.out.println("doing test");
    }
}
