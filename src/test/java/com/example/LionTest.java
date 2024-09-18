package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    private String sex= "Самка";

    @Test
    public void lionExceptionTest() throws Exception {
        String invalidSex = "Оно";
        Assert.assertThrows(Exception.class, () -> new Lion(invalidSex, feline));
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion= new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int result = lion.getKittens();
        assertEquals(1, result);

    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn( List.of("Животное", "Птицы", "Рыба"));
        assertEquals(List.of("Животное", "Птицы", "Рыба"), lion.getFood());


    }

}