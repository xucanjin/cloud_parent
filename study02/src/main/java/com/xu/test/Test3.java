package com.xu.test;

/**
 * @author xucanjin
 * @date 2022/09/28
 * @description
 */
public class Test3 {
    public static void main(String[] args) {


        System.out.println(crypt2("5200_01","a666666"));
        System.out.println(crypt2("5200_02","a666666"));
        System.out.println(crypt2("5200_03","a666666"));
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

}
