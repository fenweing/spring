package com.tuanbaol.spring.demo.classLoader;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        Iterator<FruitService> iterator = ServiceLoader.load(FruitService.class, null).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().printName());
        }
    }
}
