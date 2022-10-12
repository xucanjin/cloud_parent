package com.xu.utils;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xucanjin
 * @date 2022/10/12
 * @description
 */
public class XsdUtil2 {

    public static void main(String[] args) {
        // 交换annotation的位置
        //C:\Users\admin\Desktop\xsd
        trans("C:\\Users\\admin\\Desktop\\xsd", "C:\\Users\\admin\\Desktop\\newxsd");
    }

    private static String simpleType = "<xs:simpleType";
    private static String simpleType2 = "</xs:simpleType>";
    private static String annotation = "<xs:annotation>";
    private static String annotation2 = "</xs:annotation>";
    private static String restriction1 = "<xs:restriction";
    private static String restriction2 = "</xs:restriction>";

    /**
     * @param path  原xsd文件夹路径
     * @param path2 新xsd文件夹路径
     */
    private static void trans(String path, String path2) {
        File file = new File(path);
        if (file == null || !file.exists()) {
            return;
        }
        File[] files = file.listFiles();
        if (files.length > 0) {
            for (File file1 : files) {
                if (file1.isFile()) {
                    writeFile(file1, path2);
                }
            }
        }
    }

    private static void writeFile(File file, String path2) {
        List<String> list = FileUtil.readUtf8Lines(file);
        List<String> list1 = new ArrayList<>();
        File newFile = new File(path2 + "\\" + file.getName());
        String tag = "";
        // 存放 <xs:restriction
        List<String> list2 = new ArrayList<>();
        // 存放 <xs:annotation>
        List<String> list3 = new ArrayList<>();
        for (String s : list) {
            if (s.contains(simpleType)) {
                list1.add(s);
                tag = "1";
                continue;
            }
            if ("".equals(tag)) {
                list1.add(s);
            }
            // 是simple且第二行包含<xs:restriction
            if ("1".equals(tag) && s.contains(restriction1)) {
                list2.add(s);
                tag = "2";
                continue;
            }
            if ("2".equals(tag) && s.contains(simpleType2)) {
                list1.addAll(list2);
                list1.add(s);
                list2.clear();
                tag = "";
                continue;
            }
            if ("2".equals(tag) && !s.contains(restriction2)) {
                list2.add(s);
                continue;
            }
            if ("2".equals(tag) && s.contains(restriction2)) {
                list2.add(s);
                tag = "3";
                continue;
            }
            // tag 是3且包含</xs:simpleType>
            if ("3".equals(tag) && s.contains(simpleType2)) {
                list1.addAll(list2);
                list1.add(s);
                list2.clear();
                tag = "";
                continue;
            }
            if ("3".equals(tag) && s.contains(annotation)) {
                list3.add(s);
                tag = "4";
                continue;
            }
            if ("4".equals(tag)) {
                list3.add(s);
                if (s.contains(annotation2)) {
                    tag = "";
                    list1.addAll(list3);
                    list1.addAll(list2);
                    list2.clear();
                    list3.clear();
                }
            }
        }
        // 写入新文件
        FileUtil.appendUtf8Lines(list1, newFile);
        System.out.println("写入成功！");
    }
}
