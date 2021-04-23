package com.xu.test;

import java.io.File;

/**
 * @Author: canjin
 * @Date: 2021/2/19
 * 说明:
 */
public class FileTest {
    public static void main(String[] args) {
        File file=new File("E:\\360downloads");
        bianLiFiles2(file);
    }

    //列出某个目录下的所有文件？
    static void bianLiFiles(File file){
        File[] files = file.listFiles();
        for(int i=0;i<files.length;i++){
            if(files[i].isFile()){
                System.out.println(files[i].getName());
            }
        }
    }

    //列出某个目录下的所有子目录？
    static void bianLiFiles2(File file){
        File[] files = file.listFiles();
        for(int i=0;i<files.length;i++){
            if(files[i].isDirectory()){
                System.out.println(files[i]);
            }
        }
    }

    //判断一个文件或目录是否存在？
    static void isExist(File file){
        if(file.exists()){
            System.out.println("存在");
        }else{
            System.out.println("不存在");
        }
    }
}
