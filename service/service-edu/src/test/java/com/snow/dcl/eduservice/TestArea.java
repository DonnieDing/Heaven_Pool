package com.snow.dcl.eduservice;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 身份证号解析demo
 */

public class TestArea {
    @Test
    public void idCard() {
        int count = 0;
        boolean flag = true;
        long begin = System.currentTimeMillis();
        for (int i = 2; i < 1000000; i++) {
//            for (int j = 2; j < i; j++) {
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                count++;
            }
            flag = true;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

    }

    @Test
    public void aVoid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();

        list.add(12);
//这里直接添加会报错
//        list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
//但是通过反射添加，是可以的
        add.invoke(list, "kl");

        System.out.println(list);

    }

}
