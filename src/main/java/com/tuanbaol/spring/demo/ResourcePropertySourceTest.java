package com.tuanbaol.spring.demo;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

import static org.junit.Assert.*;

public class ResourcePropertySourceTest {
    public static void main(String[] args) throws IOException {
        String path = "D:\\project\\common\\gitlab\\spring\\target\\classes\\application.properties";
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        assertTrue(fileSystemResource.exists());
        ResourcePropertySource resourcePropertySource = new ResourcePropertySource("rps",fileSystemResource);
        assertEquals(resourcePropertySource.getProperty("sex"), "male female");
        assertEquals(resourcePropertySource.getProperty("name"), "tom,jim susan");
        assertEquals(resourcePropertySource.getProperty("fruit"), "apple;orange");
        assertEquals(resourcePropertySource.getName(), "rps");
    }
}
