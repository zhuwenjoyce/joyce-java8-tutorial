package com.joyce.java8;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo12_ReadFile {
    @Test
    public void test_一行一行读取内容(){
        Path filePath = Paths.get("C:/Users/joyce/Desktop/","test1.json");
        //try-with-resources
        try (Stream<String> lines = Files.lines( filePath )) {
            lines.forEach(System.out::println); // 打印出每一行内容
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_读取文件内容并过滤(){
        Path filePath = Paths.get("C:/Users/joyce/Desktop/","test1.json");
        try (Stream<String> lines = Files.lines(filePath)) {
            List<String> filteredLines = lines
                    .filter(s -> s.contains("password")) // 过滤出含有“password”的行
                    .collect(Collectors.toList());
            filteredLines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_Java7文件读取代码() throws IOException {
        File file = new File("C:/Users/joyce/Desktop/test1.json");

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while((line = br.readLine()) != null) {
            if(line.contains("password")){
                System.out.println(line);
            }
        }
        br.close();
        fr.close();
    }

}
