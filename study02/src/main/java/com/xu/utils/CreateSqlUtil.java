package com.xu.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author xucanjin
 * @date 2022/11/14
 * @description
 */
public class CreateSqlUtil {

    public static void main(String[] args) {

        Map<String, List<IsoConfig>> map = read("C:\\Users\\admin\\Desktop\\中投swift升级\\excel");

        writeFile(map, "C:\\Users\\admin\\Desktop\\sql\\validation2.sql");
    }

    private static Map<String, String> nameMap = new TreeMap<>();

    static {
       //230570010 camt.057.001
        //230560010 camt.056.001	CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_056_001_08_FIToFIPaymentCancellationRequest
        //230540010 camt.054.001	CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_054_001_08_BankToCustomerDebitCreditNotification
        //230530010 camt.053.001	CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_053_001_08_BankToCustomerStatement
        //230520010 camt.052.001	CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_052_001_08_BankToCustomerAccountReport
        //230290010	CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_029_001_09_ResolutionOfInvestigation
        //220100010 pacs.010.001	CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_010_001_03_Interbank_Direct_Debit
        //220090012	CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_009_001_08_COV_FinancialInstitutionCreditTransfer
        //220090011	CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_009_001_08_ADV_FinancialInstitutionCreditTransfer
        //220090010	CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_009_001_08_FinancialInstitutionCreditTransfer
        //220080011	CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_008_001_08_STP_FIToFICustomerCreditTransfer
        //220080010	CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_008_001_08_FIToFICustomerCreditTransfer
        //220040010	CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_004_001_09_PaymentReturn
        //220020010	CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_002_001_10_FIToFIPaymentStatusReport
        //210010010	CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pain_001_001_09_CustomerCreditTransferInitiation
        nameMap.put("210010010", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pain_001_001_09_CustomerCreditTransferInitiation");
        nameMap.put("220020010", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_002_001_10_FIToFIPaymentStatusReport");
        nameMap.put("220040010", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_004_001_09_PaymentReturn");
        nameMap.put("220080010", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_008_001_08_FIToFICustomerCreditTransfer");
        nameMap.put("220080011", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_008_001_08_STP_FIToFICustomerCreditTransfer");
        nameMap.put("220090010", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_009_001_08_FinancialInstitutionCreditTransfer");
        nameMap.put("220090011", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_009_001_08_ADV_FinancialInstitutionCreditTransfer");
        nameMap.put("220090012", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_009_001_08_COV_FinancialInstitutionCreditTransfer");
        nameMap.put("220100010", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_010_001_03_Interbank_Direct_Debit");
        nameMap.put("230290010", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_029_001_09_ResolutionOfInvestigation");
        nameMap.put("230520010", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_052_001_08_BankToCustomerAccountReport");
        nameMap.put("230530010", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_053_001_08_BankToCustomerStatement");
        nameMap.put("230540010", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_054_001_08_BankToCustomerDebitCreditNotification");
        nameMap.put("230560010", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_056_001_08_FIToFIPaymentCancellationRequest");
        nameMap.put("230570010", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_057_001_06_NotificationToReceive");
        //230600010 camt.060.001
        nameMap.put("230600010", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_060_001_05_AccountReportingRequest");

    }

    /**
     * 将excel需要的数据放到map中
     *
     * @param path
     * @return
     */
    private static Map<String, List<IsoConfig>> read(String path) {
        File file = new File(path);
        if (file == null || !file.exists()) {
            return null;
        }
        Map<String, List<IsoConfig>> map = new TreeMap<>();

        File[] files = file.listFiles();
        if (files.length > 0) {
            for (File file1 : files) {
                if (file1.isFile()) {
                    String msgType = "";
                    for (Map.Entry<String, String> entry : nameMap.entrySet()) {
                        if (file1.getName().contains(entry.getValue())) {
                            msgType = entry.getKey();
                            break;
                        }
                    }
                    if ("".equals(msgType)) {
                        continue;
                    }
                    ExcelReader reader = ExcelUtil.getReader(file1, "Full_View");
                    List<List<Object>> read = reader.read(180, reader.getRowCount());
                    String type;
                    String minMand;
                    String tagPath;
                    List<IsoConfig> list = new ArrayList<>();
                    for (List<Object> objects : read) {
                        //读取第21列数据
                        tagPath = (String) objects.get(20);
                        if (StrUtil.isEmpty(tagPath) || tagPath.startsWith("/AppHdr")) {
                            continue;
                        }
                        //读取第6列数据
                        type = (String) objects.get(5);
                        //读取第18列数据
                        minMand = (String) objects.get(17);
                        if (("Choice".equals(type) || "".equals(type)) && "Yes".equals(minMand)) {
                            if (tagPath.endsWith("GrpHdr") || tagPath.endsWith("Assgnmt") || tagPath.endsWith("TxInf")
                            || tagPath.endsWith("PmtInf") || tagPath.endsWith("CdtTrfTxInf") || tagPath.endsWith("Stmt")
                                    || tagPath.endsWith("Ntfctn")) {
                                continue;
                            }
                            IsoConfig config = new IsoConfig();
                            config.setPath(tagPath);
                            config.setDesc((String) objects.get(21));
                            list.add(config);
                        }
                    }
                    map.put(msgType, list);
                }
            }
        }
        return map;
    }

    /**
     * 将生成的sql写入文件中
     *
     * @param map
     * @param path2
     */
    private static void writeFile(Map<String, List<IsoConfig>> map, String path2) {
        if (new File(path2).exists()) {
            FileUtil.del(new File(path2));
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, List<IsoConfig>> entry : map.entrySet()) {
            Integer num = 1;
            Integer msgType = Integer.valueOf(entry.getKey());
            for (IsoConfig config : entry.getValue()) {
                String idStr = entry.getKey() + String.format("%03d", num);
                String sql = "INSERT INTO SMS_validation VALUES (" + idStr + ", 0, '/" + config.getPath() + "', NULL, '1', NULL, NULL, '1', 'Blank', 'False', null, 'C25', 'C1', 1054, 0, '1', " + msgType + ");";
                if (num == 1) {
                    list.add("");
                    list.add("--" + msgType);
                }
                list.add(sql);
                num++;
            }
        }
        File newFile = new File(path2);
        // 写入文件
        FileUtil.appendUtf8Lines(list, newFile);
        System.out.println("写入成功！");
    }
}
