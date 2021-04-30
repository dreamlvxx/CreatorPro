package com.dream.create.creator;

import com.dream.create.creator.framework.BaseTest;
import com.dream.create.utils.TestUtils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyTest extends BaseTest {

    @Before
    public void doPree(){
        System.out.println("do preee");
        System.out.println("this is diff");
    }

    @Test
    public void simple(){
        System.out.println("doing test");
    }
}
