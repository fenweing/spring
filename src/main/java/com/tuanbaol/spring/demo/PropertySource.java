package com.tuanbaol.spring.demo;

import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class PropertySource {
    public static void main(String[] args) {
        test_method();
    }

    public static void test_method() {
        String[] args = {"--name=tom", "--sex=\"man women\"", "--name=jim", "hello", "world"};
        SimpleCommandLinePropertySource sclps = new SimpleCommandLinePropertySource("sclps", args);
        sclps.setNonOptionArgsPropertyName("nonOpt");
        assertEquals(new HashSet<>(Arrays.asList(sclps.getPropertyNames())), new HashSet<>(Arrays.asList(new String[]{"name", "sex"})));
        assertEquals(new HashSet<>(Arrays.asList(sclps.getProperty("name").split(","))), new HashSet<>(Arrays.asList(new String[]{"tom", "jim"})));
        assertEquals(sclps.getName(), "sclps");
        assertTrue(new HashSet<>(Arrays.asList(sclps.getProperty("nonOpt").split(","))).equals(new HashSet<>(Arrays.asList(new String[]{"hello", "world"}))));
    }
}
