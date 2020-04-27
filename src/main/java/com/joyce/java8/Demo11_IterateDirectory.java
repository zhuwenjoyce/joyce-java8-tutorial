package com.joyce.java8;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Demo11_IterateDirectory {

    @Test
    public void test_列出当前文件夹下的所有目录() throws IOException {
        Files.list(Paths.get("."))
                .forEach(System.out::println);
        // 控制台打印：
//        .\.classpath
//        .\.git
//        .\.gitignore
//        .\.idea
//        .\.project
//        .\.settings
//        .\joyce-jdk-tutorial.iml
//        .\pom.xml
//        .\README.md
//        .\src
//        .\target
    }

    @Test
    public void test_列出当前文件夹下的所有目录_并进行过滤() throws IOException {
        Files.list(Paths.get("."))
                .filter(Files::isRegularFile) // 过滤出文件，剔除文件夹目录
                .forEach(System.out::println);
        // 控制台打印：
//        .\.classpath
//        .\.gitignore
//        .\.project
//        .\joyce-jdk-tutorial.iml
//        .\pom.xml
//        .\README.md
    }

    @Test
    public void test_Java提供了一种更灵活的方法来使用newDirectoryStream遍历目录内容() throws IOException {
        Files.newDirectoryStream(Paths.get("."))
                .forEach(System.out::println);
    }

    @Test
    public void test_用newDirectoryStream方法只列出文件() throws IOException {
        Files.newDirectoryStream(Paths.get("."), path -> path.toFile().isFile())
                .forEach(System.out::println);
        // 控制台打印：
//        .\.classpath
//        .\.gitignore
//        .\.project
//        .\joyce-jdk-tutorial.iml
//        .\pom.xml
//        .\README.md
    }
    @Test
    public void test_列出当前文件夹下Java文件() throws IOException {
        Files.newDirectoryStream(Paths.get("."),
                path -> path.toString().endsWith(".java"))
                .forEach(System.out::println);
    }
    @Test
    public void test_列出隐藏文件() throws IOException {
        File[] f1 = new File(".").listFiles(file -> file.isHidden());
        //or
        File[] f2 = new File(".").listFiles(File::isHidden);

        Arrays.stream(f2).forEach(file -> {
            System.out.println("file.getName()====" + file.getName());
        });
    }

}
