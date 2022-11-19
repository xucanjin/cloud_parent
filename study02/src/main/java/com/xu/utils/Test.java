package com.xu.utils;

import java.math.BigDecimal;

/**
 * @author xucanjin
 * @date 2022/10/16
 * @description
 */
public class Test {

    public static void main(String[] args) {

        int a =0;
        int b =1;
        //test1(++a,b++);

        //sql();
    }

    //两个Double相减
    public static Double sub(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.subtract(b2).doubleValue();
    }
    public static void test1(int a,int b){
        System.out.println(a);
        System.out.println(b);
    }

    public static void sql(){
        String[] strs = new String[]{"2301","2303","2304","5901","2302","2702",
                "2803","9101","2805","0603","3402","3504","3802","3803","3908","4303","4501","4502","4503","4802","5166","2703","5103","5302"};

        int num = 13;
        int n = 50;
        for (String s : strs) {
            String s1 = "INSERT INTO FXCS_POSITION_TRADE_MSG_RMB" +
                    "(ID, VERSION, PAYMENT_PLATFORM_FLOAT, MATCH_NO, MATCH_DATE, MATCH_STATUS, PAY_CHANNEL, BRANCH_CODE, CURRENCY, ENTRUST_DATE, TRANS_AMOUNT, PAYER_ACCOUNT, PAYER_NAME, PAYEE_ACCOUNT, PAYEE_NAME, RECEIVING_BANK_NUM, RECEIVING_BANK_NAME, PROCESS_STATUS, REPLY_STATUS, ERROR_MSG, CREATE_ON, CREATE_BY, MODIFY_ON, MODIFY_BY, ATTRIBUTE_1, ATTRIBUTE_2, ATTRIBUTE_3, ATTRIBUTE_4, MONEY_DIRECTION, APPLY_TYPE)\n" +
                    "VALUES(" + num + ", 0, 'test004', NULL, TIMESTAMP '2022-11-09 00:00:00.000000', 'MATCH_SUCCESS', '02', '" + s + "', 'RMB', '2022-11-09', 1000, '100', 'PayerName', '100', 'PayeeName', 'ReceivingBankNum', 'ReceivingBankName', 'PROCESS_STATUS_AUTHORIZED', NULL, NULL, TIMESTAMP '2022-11-07 00:00:00.000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2');";
            System.out.println(s1);
            num++;
        }


        for (String s : strs) {
            String s2 = "INSERT INTO FXCS_POSITION_APPLY_RMB" +
                    "(ID, VERSION, PAY_CHANNEL, BRANCH_CODE, CURRENCY, AUTH_DATE, ENTRUST_DATE, APPLY_AMOUNT, PAYER_ACCOUNT, PAYER_NAME, PAYEE_ACCOUNT, PAYEE_NAME, RECEIVING_BANK_NUM, RECEIVING_BANK_NAME, APPLY_BY, APPLY_ON, CHECKED_BY, CHECKED_ON, APPROVED_BY, APPROVED_ON, BIZ_REMARK, PROCESS_STATUS, STATUS_REMARK, POSITION_OCCUPANCY_TYPE, CREATE_ON, CREATE_BY, MODIFY_ON, MODIFY_BY, ATTRIBUTE_1, ATTRIBUTE_2, ATTRIBUTE_3, ATTRIBUTE_4, LIQUIDATION_DATE, POSITION_TZ, APPLY_MONEY, WRITEOFF_STATUS, WRITEOFF_AMOUNT, PAY_DIRECTION, APPLY_TYPE)\n" +
                    "VALUES(" + n + ", 0, '02', '" + s + "', 'RMB', TIMESTAMP '2022-11-09 00:00:00.000000', NULL, 20000000, NULL, NULL, NULL, NULL, NULL, NULL, 'admin', TIMESTAMP '2022-11-09 09:18:32.669000', NULL, NULL, NULL, NULL, NULL, 'APPROVED', NULL, 'SINGLE', TIMESTAMP '2022-11-09 09:18:32.669000', 'admin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2');";
            System.out.println(s2);
            n++;
        }
    }
}
