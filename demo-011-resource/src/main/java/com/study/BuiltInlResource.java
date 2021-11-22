package com.study;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 内置实现的Resource
 * 也就url和classpath的用处较大
 *
 * @author fjding
 * @date 2021/10/24
 */
public class BuiltInlResource {


    public static void testUrlResource() throws IOException {
        // 支持http: file: ftp: 协议
        String url = "http://www.baidu.com";
        UrlResource urlResource = new UrlResource(url);
        System.out.println(urlResource.getDescription());
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlResource.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void testClassPathResource() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("application.yaml");
        System.out.println(classPathResource.getPath());
        BufferedReader reader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void testInputStreamResource(InputStream in) {
        InputStreamResource inputStreamResource = new InputStreamResource(in);
    }

    public static void testByteArrayResource(byte[] bytes) {
        ByteArrayResource byteArrayResource = new ByteArrayResource(bytes);
    }
}
