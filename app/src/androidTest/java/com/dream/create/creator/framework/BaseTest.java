package com.dream.create.creator.framework;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BaseTest {

    @Before
    public void doPre(){
        System.out.println("do pre");
    }

    @After
    public void doAfter(){
        System.out.println("do after");
    }

}
