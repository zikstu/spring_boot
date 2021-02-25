package com.medsci.hello.spring.boot.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @description:
 * @author: 学长
 * @date: 2021/2/25 12:26
 */
public class TestBuffer {
    public static void main(String[] args) {
        wirter();
        fileWriter();
        bufferedWriter();
    }

    public static void wirter(){
        Writer writer = null;

        try {
            writer = new FileWriter("/Users/xuezhang/Java/spring_boot/file1.txt");

            long num = 1000_0000;

            long beginTime = System.currentTimeMillis();

            for (int i=1; i < num; i++){
                writer.write(i);
            }

            long endTime = System.currentTimeMillis();

            long time = endTime - beginTime;

            System.out.println("wirter：" + time);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileWriter() {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("/Users/xuezhang/Java/spring_boot/file2.txt");

            long num = 1000_0000;

            long beginTime = System.currentTimeMillis();

            for (int i=0; i<num; i ++){
                fileWriter.write(i);
            }

            long endTime = System.currentTimeMillis();

            long time = endTime - beginTime;

            System.out.println("fileWriter：" + time);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void bufferedWriter(){
        Writer writer = null;

        BufferedWriter bufferedWriter = null;

        try {
            writer = new FileWriter("/Users/xuezhang/Java/spring_boot/file3.txt");

            bufferedWriter = new BufferedWriter(writer);

            long num = 1000_0000;

            long beginTime = System.currentTimeMillis();

            for (int i=0; i<num; i ++){
                bufferedWriter.write(i);
            }

            long endTime = System.currentTimeMillis();

            long time = endTime - beginTime;

            System.out.println("bufferedWriter：" + time);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
