package com.joyce.java8;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo13_WriteToFile {

    @Test
    public void test_写入文件(){
        Path path = Paths.get("C:/Users/joyce/Desktop/output.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("Hello World !!\n");
            writer.write("line::" + 10);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_写入文件第二种方式() throws IOException {
        String content = "Hello World !! Hi Joyce!!";
        Files.write(Paths.get("C:/Users/joyce/Desktop/output.txt"), content.getBytes());
    }

}
