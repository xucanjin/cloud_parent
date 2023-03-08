package com.xu.test;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xucanjin
 * @date 2022/09/28
 * @description
 */
public class Test3 {
    public static void main(String[] args) {

        createSql("C:\\Users\\92780\\Desktop\\桌面文件\\9998下机构信息.xlsx");
        //createOrgSql("C:\\Users\\admin\\Desktop\\机构数据(1).xls","C:\\Users\\admin\\Desktop\\核心机构信息2.xlsx");
        //create2("C:\\Users\\admin\\Desktop\\机构数据(1).xls");
        /*System.out.println(crypt2("5400_01", "a666666"));
        System.out.println(crypt2("5400_02", "a666666"));
        System.out.println(crypt2("5400_03", "a666666"));
        System.out.println(crypt2("5400_04", "a666666"));
        System.out.println(crypt2("5400_05", "a666666"));
        System.out.println(crypt2("5400_06", "a666666"));*/
    }

    public static String crypt2(String operatorID, String plainPass) {
        int[] idx = new int[13];

        String cryptPass = "";

        idx[0] = 13;
        idx[1] = 41;
        idx[2] = 7;
        idx[3] = 17;
        idx[4] = 29;
        idx[5] = 5;
        idx[6] = 19;
        idx[7] = 37;
        idx[8] = 11;
        idx[9] = 47;
        idx[10] = 31;
        idx[11] = 23;
        idx[12] = 53;

        if ((operatorID == null) || (plainPass == null))
            return "";
        if (operatorID.length() < 7)
            operatorID = operatorID + "       ";
        if (plainPass.length() < 12) {
            plainPass = plainPass + "            ";
        }

        String rr = operatorID.substring(0, 7) + " CMIS" + plainPass.substring(0, 12);
        int xx = 0;
        int k = 24;

        while (k != 0)
            xx += (rr.charAt(--k) & 0x7F);
        for (int i = 0; i < 12; i++) {
            int j = ((rr.charAt(i) & 0x7F) + (rr.charAt(23 - i) & 0x7F)) / 2;
            k = (xx % j * idx[i] + idx[i]) % j;
            while (k < 48)
                k += idx[i];
            while ((k > 57) && (k < 65))
                k += i + 1;
            while (k > 90)
                k -= i + 1;
            while ((k > 57) && (k < 65))
                k += i;
            cryptPass = cryptPass + String.valueOf((char) k);
        }

        return cryptPass;
    }

    private static final String S1 = "INSERT INTO ECS_USER (USER_ID, VERSION, OPER_ID, USER_NAME, REAL_NAME, GENDER, PASSWORD, LOGIN_FLAG, LOGIN_IP_ADDRESS, PROCESS_STATUS, LAST_LOGIN_TIME, EXPIRE_DATE, LAST_CHANGEPWD_DATE, QUESTION, ANSWER, EMAIL, MAKER_ON, MAKER_BY, CHECKER_ON, CHECKER_BY, CREATE_ON, CREATE_BY, MODIFY_ON, MODIFY_BY, USER_STATUS, LOGIN_FAILURE_TIMES, BACK_UP_PASSWORD, LEFT_PASSWORD, RIGHT_PASSWORD, ADMIN_FLAG, LOCALE, USER_IP, BRANCH_ID, ROLE_ID) ";

    private static final String S2 = "'0', NULL, 'ZA', TIMESTAMP '2022-12-01 17:18:46.296000', NULL, TIMESTAMP '2022-11-04 00:00:00.000000', NULL, NULL, NULL, TIMESTAMP '2022-11-04 09:45:59.571000', 'admin', TIMESTAMP '2022-11-04 09:46:28.356000', 'admin2', TIMESTAMP '2022-11-04 09:45:59.571000', 'admin', TIMESTAMP '2022-11-04 09:45:59.571000', 'admin', 'NORMAL', 0, NULL, NULL, NULL, NULL, 'zh_CN', NULL,";

    private static final String S3 = "(SELECT BRANCH_ID FROM ECS_BRANCH WHERE BRANCH_CODE";

    private static final String admin = "INSERT INTO ECS_USER (USER_ID, VERSION, OPER_ID, USER_NAME, REAL_NAME, GENDER, PASSWORD, LOGIN_FLAG, LOGIN_IP_ADDRESS, PROCESS_STATUS, LAST_LOGIN_TIME, EXPIRE_DATE, LAST_CHANGEPWD_DATE, QUESTION, ANSWER, EMAIL, MAKER_ON, MAKER_BY, CHECKER_ON, CHECKER_BY, CREATE_ON, CREATE_BY, MODIFY_ON, MODIFY_BY, USER_STATUS, LOGIN_FAILURE_TIMES, BACK_UP_PASSWORD, LEFT_PASSWORD, RIGHT_PASSWORD, ADMIN_FLAG, LOCALE, USER_IP, BRANCH_ID, ROLE_ID) " +
            "VALUES(ECS_USER_SEQ.nextval, 0, '00000001', 'admin', 'administrator', '1', '3W13L43RFXFY', '0', NULL, 'ZA', TIMESTAMP '2023-02-08 17:12:23.228000', TIMESTAMP '2099-01-01 00:00:00.000000', TIMESTAMP '2022-11-03 00:00:00.000000', NULL, NULL, 'admin@cast.com', NULL, 'admin', NULL, NULL, NULL, 'admin', TIMESTAMP '2022-11-03 17:15:21.000000', 'admin', 'NORMAL', 0, 'H10362G145J7', '0F', '4F', 'R', 'zh_CN', '182.119.109.162', (SELECT BRANCH_ID FROM ECS_BRANCH WHERE BRANCH_CODE ='0001'), (SELECT ROLE_ID FROM ECS_ROLE WHERE ROLE_NAME ='admin'));";

    private static final String admin2 = "INSERT INTO ECS_USER (USER_ID, VERSION, OPER_ID, USER_NAME, REAL_NAME, GENDER, PASSWORD, LOGIN_FLAG, LOGIN_IP_ADDRESS, PROCESS_STATUS, LAST_LOGIN_TIME, EXPIRE_DATE, LAST_CHANGEPWD_DATE, QUESTION, ANSWER, EMAIL, MAKER_ON, MAKER_BY, CHECKER_ON, CHECKER_BY, CREATE_ON, CREATE_BY, MODIFY_ON, MODIFY_BY, USER_STATUS, LOGIN_FAILURE_TIMES, BACK_UP_PASSWORD, LEFT_PASSWORD, RIGHT_PASSWORD, ADMIN_FLAG, LOCALE, USER_IP, BRANCH_ID, ROLE_ID) " +
            "VALUES(ECS_USER_SEQ.nextval, 0, '00000002', 'admin2', 'administrator2', '1', '7B13H2CK82Q5', '0', NULL, 'ZA', TIMESTAMP '2023-02-06 16:30:28.255000', TIMESTAMP '2099-01-01 00:00:00.000000', TIMESTAMP '2022-11-03 00:00:00.000000', NULL, NULL, 'admin2@cast.com', NULL, 'admin', NULL, NULL, NULL, 'admin', TIMESTAMP '2022-11-03 17:15:21.000000', 'admin', 'NORMAL', 0, 'H10362G145J7', '0F', '4F', 'L', 'zh_CN', '182.119.109.162', (SELECT BRANCH_ID FROM ECS_BRANCH WHERE BRANCH_CODE ='0001'), (SELECT ROLE_ID FROM ECS_ROLE WHERE ROLE_NAME ='admin2'));";


    private static final String TC1 = "INSERT INTO ecs_user select ecs_user_seq.nextval, 0, '00000003', 'TCGL', '陈希', '1', '" + crypt2("TCGL", "123456") + "', '0', null, 'ZA', sysdate, to_date('2099-01-01','YYYY-MM-DD'),sysdate,  null, null, 'admin@cast.com', null, 'admin', null, null, null, 'admin', sysdate, 'admin', 'NORMAL', '0', 'H10362G145J7', '0F', '4F', 'R', 'zh_CN', '182.119.109.162', branch_id,role_id from ecs_role,ecs_branch where role_name='Authorization' and branch_code='0001';";

    private static final String TC2 = "INSERT INTO ecs_user select ecs_user_seq.nextval, 0, '00000004', 'YHW', '姚宏伟', '1', '" + crypt2("YHW", "123456") + "', '0', null, 'ZA', sysdate, to_date('2099-01-01','YYYY-MM-DD'),sysdate,  null, null, 'admin2@cast.com', null, 'admin', null, null, null, 'admin', sysdate, 'admin', 'NORMAL', '0', 'H10362G145J7', '0F', '4F', 'L', 'zh_CN', '182.119.109.162',branch_id,role_id  from ecs_role,ecs_branch where role_name='check' and branch_code='0001';";

    /**
     * 生成用户sql
     */
    private static void createSql(String path) {
        List<String> list = new ArrayList<>();
        list.add("truncate TABLE ECS_USER;");
        list.add(admin);
        list.add(admin2);
        list.add(TC1);
        list.add(TC2);
        ExcelReader reader1 = ExcelUtil.getReader(new File(path), 0);
        List<String> orgList = reader1.read(1, reader1.getRowCount()).stream().map(o -> o.get(0).toString()).collect(Collectors.toList());
        //List<String> orgList = FileUtil.readUtf8Lines(file);

        Integer num = 1;
        for (String s : orgList) {
            String opeId = "0000" + num;
            if (s.equals("0001")) {
                String sql1 = S1 + "VALUES(ECS_USER_SEQ.nextval, 0, '" + opeId + "', '0001_03', '0001_03', NULL, '" + crypt2("0001_03", "123456") + "'," + S2 + S3 + " ='" + s + "'), (SELECT ROLE_ID FROM ECS_ROLE WHERE ROLE_NAME ='Authorization'));";
                list.add(sql1);
            } else {
                String name1 = s + "_01";
                String name2 = s + "_02";
                String sql1 = S1 + "VALUES(ECS_USER_SEQ.nextval, 0, '" + opeId + "', '" + name1 + "', '" + name1 + "', NULL, '" + crypt2(name1, "123456") + "'," + S2 + S3 + " ='" + s + "'), (SELECT ROLE_ID FROM ECS_ROLE WHERE ROLE_NAME ='Creation'));";
                list.add(sql1);
                num++;
                opeId = "0000" + num;
                String sql2 = S1 + "VALUES(ECS_USER_SEQ.nextval, 0, '" + opeId + "', '" + name2 + "', '" + name2 + "', NULL, '" + crypt2(name2, "123456") + "'," + S2 + S3 + " ='" + s + "'), (SELECT ROLE_ID FROM ECS_ROLE WHERE ROLE_NAME ='Approval'));";
                list.add(sql2);
            }
            num++;
        }

        File newFile = new File("C:\\Users\\admin\\Desktop\\user_sql.txt");
        if (newFile.exists()) {
            newFile.delete();
        }
        // 写入文件
        FileUtil.appendUtf8Lines(list, newFile);
        System.out.println("success");
    }

    private static final String s1 = "INSERT INTO ECS_BRANCH (BRANCH_ID,VERSION,BRANCH_CODE,BIC,SHORT_NAME,LONG_NAME,ENGLISH_NAME,CENTRALIZED_ID,PARENT_BANK,PROCESS_STATUS,MAKER_ON,MAKER_BY,CHECKER_ON,CHECKER_BY,CREATE_ON,CREATE_BY,MODIFY_ON,MODIFY_BY,DOCUMENT_CENTER,ISSEND_FILTER,ISSEND_INTERCEPT,ISRECE_FILTER,BACK_ID,ISRECE_INTERCEPT,REAL_BIC) VALUES ";

    private static final String s3 = "'ZA',TIMESTAMP'2023-02-07 17:19:36.49',NULL,NULL,NULL,TIMESTAMP'2023-02-07 17:19:36.49',NULL,NULL,NULL,0,0,0,0,NULL,0,0);";

    /**
     * 生成机构sql
     *
     * @param path
     */
    private static void createOrgSql(String path, String path2) {
        ExcelReader reader1 = ExcelUtil.getReader(new File(path2), 0);
        List<List<Object>> read1 = reader1.read(1, reader1.getRowCount());
        List<String> collect = read1.stream().map(o -> o.get(0).toString()).collect(Collectors.toList());

        File file = new File(path);
        ExcelReader reader = ExcelUtil.getReader(file, 0);
        List<List<Object>> read = reader.read(1, reader.getRowCount());
        List<String> collect1 = read.stream().map(o -> o.get(0).toString()).collect(Collectors.toList());
        for (String s : collect) {
            if (!collect1.contains(s)) {
                System.out.println("org:" + s);
            }
        }
        /*List<String> list = new ArrayList<>();
        String s2 = "INSERT INTO ECS_BRANCH (BRANCH_ID,VERSION,BRANCH_CODE,BIC,SHORT_NAME,LONG_NAME,ENGLISH_NAME,CENTRALIZED_ID,PARENT_BANK,PROCESS_STATUS,MAKER_ON,MAKER_BY,CHECKER_ON,CHECKER_BY,CREATE_ON,CREATE_BY,MODIFY_ON,MODIFY_BY,DOCUMENT_CENTER,ISSEND_FILTER,ISSEND_INTERCEPT,ISRECE_FILTER,BACK_ID,ISRECE_INTERCEPT,REAL_BIC) VALUES " +
                " (ecs_branch_seq.nextval,0,'0001','CQCBCN22XXX','重庆银行总行本部','重庆银行总行本部',NULL,1,'0001','ZA',TIMESTAMP'2023-02-07 17:19:36.49',NULL,NULL,NULL,TIMESTAMP'2023-02-07 17:19:36.49',NULL,NULL,NULL,0,0,0,0,NULL,0,1);";
        for (List<Object> objects : read) {
            if (objects.get(0).equals("0001")) {
                list.add(s2);
            } else {
                String s = s1 + "(ecs_branch_seq.nextval,0,'" + objects.get(0) + "','CQCBCN22XXX','" + objects.get(2) + "','" + objects.get(3) + "',NULL,1,'" + objects.get(1) + "'," + s3;
                list.add(s);
            }
        }
        File newFile = new File("C:\\Users\\admin\\Desktop\\org_sql.txt");
        if (newFile.exists()) {
            newFile.delete();
        }
        // 写入文件
        FileUtil.appendUtf8Lines(list, newFile);*/
        System.out.println("success");
    }

    private static final String code1 = "9998";


    /**
     * 查看9998下子机构对应的子集
     *
     * @param path
     */
    private static void create2(String path) {
        File file = new File(path);
        ExcelReader reader = ExcelUtil.getReader(file, 0);
        List<List<Object>> read = reader.read(1, reader.getRowCount());
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Set<String>> map2 = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (List<Object> objects : read) {
            map.put(objects.get(0).toString(), objects.get(2).toString());
            // 父级
            String parCode = objects.get(1).toString();

            if (CollUtil.isEmpty(map2.get(parCode))) {
                Set<String> set = new HashSet<>();
                set.add(objects.get(0).toString());
                map2.put(parCode, set);
            } else {
                map2.get(parCode).add(objects.get(0).toString());
            }
        }

        Set<String> strings = map2.get(code1);
        for (Map.Entry<String, Set<String>> entry : map2.entrySet()) {
            if (entry.getKey().equals("0001") || entry.getKey().equals(code1)) {
                continue;
            }
            if (strings.contains(entry.getKey())) {
                list.add(entry.getKey() + "(" + code1 + "):");
            } else {
                list.add(entry.getKey() + "(NOT):");
            }
            for (String s : entry.getValue()) {
                list.add("     " + s);
            }
        }
        File newFile = new File("C:\\Users\\admin\\Desktop\\org2.txt");
        // 写入文件
        FileUtil.appendUtf8Lines(list, newFile);
        System.out.println("success");
    }

}
