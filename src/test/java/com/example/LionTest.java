package com.example;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    private String sex= "Самка";

    @Test(expected = Exception.class)
    public void LionExceptionTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(new Lion("", feline), Exception.class);
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(lion.getKittens()).thenReturn(1);
        int result = 1;
        assertEquals(feline.getKittens(), result);
    }

    @Test
    public void getFoodExceptionTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        try {
            Mockito.when(lion.getFood()).thenThrow(Exception.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(lion.getFood()).thenReturn( List.of("Мясо"));
        assertEquals(lion.getFood(), List.of("Мясо"));
    }

}