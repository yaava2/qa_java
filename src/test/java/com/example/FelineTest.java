package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        assertEquals(feline.eatMeat(), List.of("Животное", "Птицы", "Рыба"));
    }

    @Test(expected = Exception.class)
    public void getFoodExceptionTest() throws Exception {
        Feline feline = new Feline();
        assertEquals(feline.getFood("Утканос"), Exception.class);
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        assertEquals(feline.getFamily(),"Кошачьи");
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        int result = feline.getKittens();
        assertEquals(1, result);
    }

    @Test
    public void testGetKittensTest() {
        Feline feline = new Feline();
        int result = feline.getKittens(7);
        assertEquals(7, result);

    }
}