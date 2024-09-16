package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;


    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        String result = cat.getSound();
        assertEquals(result, "Мяу");
    }

    @Test
    public void getFoodExceptionTest() {
        Cat cat = new Cat(feline);
        try {
            Mockito.when(cat.getFood()).thenThrow(Exception.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(cat.getFood()).thenReturn( List.of("Мясо"));
        assertEquals(cat.getFood(), List.of("Мясо"));
    }
}

