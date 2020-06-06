package com.katruk.domain.enumeration;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeekConverterTest {

    private WeekConverter weekConverter;

    @Before
    public void setUp() {
        this.weekConverter = new WeekConverter();
    }

    @Test
    public void testNumberSet0() {
        //given
        Integer days = 12;

        //when
        String result = this.weekConverter.convert(days);

        //then
        System.out.println(result);
        assertEquals("1-2", result);
    }

    @Test
    public void testNumberSet1() {
        //given
        Integer days = 123;

        //when
        String result = this.weekConverter.convert(days);

        //then
        System.out.println(result);
        assertEquals("1-3", result);
    }

    @Test
    public void testNumberSet2() {
        //given
        Integer days = 135;

        //when
        String result = this.weekConverter.convert(days);

        //then
        System.out.println(result);
        assertEquals("1,3,5", result);
    }

    @Test
    public void testNumberSet3() {
        //given
        Integer days = 125;

        //when
        String result = this.weekConverter.convert(days);

        //then
        System.out.println(result);
        assertEquals("1-2,5", result);
    }

    @Test
    public void testNumberSet4() {
        //given
        Integer days = 12367;

        //when
        String result = this.weekConverter.convert(days);

        //then
        System.out.println(result);
        assertEquals("1-3,6-7", result);
    }

    @Test
    public void testNumberSet5() {
        //given
        Integer days = 134567;

        //when
        String result = this.weekConverter.convert(days);

        //then
        System.out.println(result);
        assertEquals("1,3-7", result);
    }

}