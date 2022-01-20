package com.tuanbaol.spring.demo;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.DefaultPropertiesPersister;

import java.io.IOException;

import static org.junit.Assert.*;

public class Properties {
    public static void main(String[] args) throws IOException {
        test_with_util();
    }

    public static void test() throws IOException {
        String path = "D:\\project\\common\\gitlab\\spring\\target\\classes\\application.properties";
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        assertTrue(fileSystemResource.exists());
        DefaultPropertiesPersister defaultPropertiesPersister = new DefaultPropertiesPersister();
        java.util.Properties properties = new java.util.Properties();
        defaultPropertiesPersister.load(properties, fileSystemResource.getInputStream());
        assertEquals(properties.get("sex"), "male female");
        assertEquals(properties.get("name"), "tom,jim susan");
        assertEquals(properties.get("fruit"), "apple;orange");

        String copyPath = "D:\\project\\common\\gitlab\\spring\\target\\classes\\application1.properties";
        String copyXmlPath = "D:\\project\\common\\gitlab\\spring\\target\\classes\\application.xml";
        FileSystemResource copyFileSystemResource = new FileSystemResource(copyPath);
        FileSystemResource copyXmlFileSystemResource = new FileSystemResource(copyXmlPath);
        properties.store(copyFileSystemResource.getOutputStream(), "copy properties");
        properties.storeToXML(copyXmlFileSystemResource.getOutputStream(), "copy properties");

    }

    public static void test_with_util() throws IOException {
        String path = "D:\\project\\common\\gitlab\\spring\\target\\classes\\application.properties";
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        assertTrue(fileSystemResource.exists());
        java.util.Properties properties = PropertiesLoaderUtils.loadProperties(fileSystemResource);
        assertEquals(properties.get("sex"), "male female");
        assertEquals(properties.get("name"), "tom,jim susan");
        assertEquals(properties.get("fruit"), "apple;orange");

        String copyPath = "D:\\project\\common\\gitlab\\spring\\target\\classes\\application1.properties";
        String copyXmlPath = "D:\\project\\common\\gitlab\\spring\\target\\classes\\application.xml";
        FileSystemResource copyFileSystemResource = new FileSystemResource(copyPath);
        FileSystemResource copyXmlFileSystemResource = new FileSystemResource(copyXmlPath);
        properties.store(copyFileSystemResource.getOutputStream(), "copy properties");
        properties.storeToXML(copyXmlFileSystemResource.getOutputStream(), "copy properties");

    }
}
