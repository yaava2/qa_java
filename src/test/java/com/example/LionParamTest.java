package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParamTest {
    private String sex;
    private Boolean haveMane;
    Feline feline;

    public LionParamTest(String sex, Boolean haveMane){
        this.haveMane=haveMane;
        this.sex=sex;
    }

    @Parameterized.Parameters
    public static Object[][] doesHaveMane() {
        return new Object[][] {
                { "Самец", true},
                { "Самка", false},
        };
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean result = lion.doesHaveMane();
        Assert.assertEquals(haveMane,result);
    }

}
