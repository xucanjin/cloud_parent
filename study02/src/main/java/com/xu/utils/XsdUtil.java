package com.xu.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xucanjin
 * @date 2022/09/28
 * @description
 */
public class XsdUtil {

    private static String complexType = "<xs:complexType";
    private static String simpleType = "<xs:simpleType";
    private static String complexType2 = "</xs:complexType>";
    private static String simpleType2 = "</xs:simpleType>";
    private static String abs = "abstract";
    private static String document = "<xs:complexType name=\"Document\">";
    private static String annotation = "xs:annotation";
    private static String appinfo = "xs:appinfo";
    private static String FinFormat = "info:FinFormat";
    private static String restriction = "xs:restriction";
    private static String minLength = "<xs:minLength";
    private static String maxLength = "<xs:maxLength";
    private static String pattern = "<xs:pattern";
    private static String complexContent = "xs:complexContent";
    private static String extension = "xs:extension";
    private static String choice = "xs:choice";
    private static String Tag = "info:Tag";
    private static String sequence1 = "<xs:sequence>";
    private static String element = "<xs:element";
    private static String maxOccurs = "<xs:element maxOccurs";

    private static String docu = "<xs:element name=\"Document\" type=\"Document\"/>";

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        writeFile1("C:\\Users\\admin\\Desktop\\test1.xsd", "C:\\Users\\admin\\Desktop\\中投swift升级\\xsd\\test2.xsd");
        //excel路径
        readExcel(map, "C:\\Users\\admin\\Desktop\\中投swift升级\\pacs004001\\CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_004_001_09_PaymentReturn_20220730_0949.xlsx", "Light_View");
        // 第一个参数是 writeFile1生成的xsd路径，第二个参数是新xsd路径
        writeFile2(map,"C:\\Users\\admin\\Desktop\\中投swift升级\\writexsd\\test2.xsd", "C:\\Users\\admin\\Desktop\\中投swift升级\\writexsd\\test4.xsd");
    }

    /**
     * 读取excel数据放到map中
     *
     * @param map   Map<String, String> map
     * @param name  文件路径
     * @param sheet sheet页名字
     */
    public static void readExcel(Map<String, String> map, String name, String sheet) {
        ExcelReader reader = ExcelUtil.getReader(new File(name), sheet);
        List<List<Object>> read = reader.read(7, reader.getRowCount());

        for (List<Object> objects : read) {
            //读取某行第4列数据
            String key = objects.get(3).toString();
            String value = objects.get(2).toString();
            if (!map.containsKey(key)) {
                if (value.length() > 1) {
                    value = value.trim();
                }
                map.put(key, value);
            }
        }
    }

    /**
     * 
     * @param name 旧xsd路径
     * @param fileName 新生成的xsd路径
     */
    private static void writeFile1(String name, String fileName) {
        File file = new File(fileName);
        List<String> list = FileUtil.readUtf8Lines(name);

        String s1 = "";
        // 是否需要修改
        boolean flag = false;
        List<String> list1 = new ArrayList<>();
        for (String s : list) {
            if (StrUtil.isEmpty(s)) {
                continue;
            }
            if (s.contains(document) || (!s.contains(complexType) && !flag)) {
                if (s1.length() > 1 && s.contains(sequence1)) {
                } else {
                    append(s + "\r\n", file);
                }
            }
            if (s.contains(complexType) && !s.contains(document)) {
                s1 = s;
                append(s + "\r\n", file);
                continue;
            }
            // 第一个是<xs:complexType 且第二个是<xs:sequence>
            if (s1.length() > 1 && s.contains(sequence1)) {
                flag = true;
                System.out.println(s1);
            } else {
                s1 = "";
            }
            if (flag && s.contains(element)) {
                list1.add(s);
            }
            if (flag && s.contains(complexType2)) {
                StringBuilder builder = new StringBuilder();
                builder.append("\t\t<xs:complexContent>\r\n" +
                        "\t\t\t<xs:extension base=\"CompositeField\">\r\n");
                builder.append("\t\t\t\t<xs:sequence>\r\n");
                for (String ele : list1) {
                    builder.append("\t\t" + ele + "\r\n");
                }
                builder.append("\t\t\t\t</xs:sequence>\r\n").append("\t\t\t</xs:extension>\r\n").append("\t\t</xs:complexContent>\r\n")
                        .append("\t</xs:complexType>\r\n");
                append(builder.toString(), file);
                list1.clear();
                flag = false;
                s1 = "";
            }
        }
    }

    /**
     * 修改 maxOccurs>"1"的数据
     *
     * @param name 旧xsd路径
     * @param fileName 新xsd路径
     */
    public static void writeFile2(Map<String, String> map, String name, String fileName) {
        File file = new File(fileName);
        /*if (file.exists()) {
            FileUtil.del(file);
        }*/
        List<String> list = FileUtil.readUtf8Lines(name);
        int count = 1;
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            if (StrUtil.isEmpty(s)) {
                continue;
            }
            if (s.contains(maxOccurs)) {
                String str = s;
                String[] strs = StrUtil.subBetweenAll(s, "\"");
                String s1 = strs[0];
                // maxOccurs 值大于1
                if (s1.equals("unbounded") || Integer.valueOf(s1) > 1) {
                    String name2 = map.get("<" + strs[2] + ">").replace(" ", "_");
                    String type = "Loop" + count + "_" + name2 + "_Type";
                    str = "\t\t            <xs:element maxOccurs=\"" + strs[0] + "\" minOccurs=\"" + strs[1] + "\" name=\"" + name2 + "\" type=\"" + type + "\"/>";

                    builder.append("\t<xs:complexType name=\"" + type + "\">\r\n");
                    builder.append("\t\t<xs:complexContent>\r\n" +
                            "\t\t\t<xs:extension base=\"Loop\">\r\n" +
                            "\t\t\t\t<xs:sequence>\r\n");
                    builder.append("\t\t\t\t\t<xs:element name=\"" + strs[2] + "\" type=\"" + strs[3] + "\"/>\r\n");
                    builder.append("\t\t\t\t</xs:sequence>\r\n" +
                            "\t\t\t</xs:extension>\r\n" +
                            "\t\t</xs:complexContent>\r\n" +
                            "\t</xs:complexType>\r\n");
                    count++;
                }
                append(str + "\r\n", file);
            } else {
                append(s + "\r\n", file);
            }
        }
        append(builder.toString(),file);
    }

    public static void append(String content, File file) {
        FileUtil.appendUtf8String(content, file);
    }

    public static void appendLines(List<String> list , File file) {
        FileUtil.appendUtf8Lines(list,file);
    }

}
