package com.xu.util;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: canjin
 * @Date: 2021/7/10
 * 说明:
 */
public class PdfUtil {

    private static final Logger log= LoggerFactory.getLogger(PdfUtil.class);

    public static void exportPdf(HttpServletResponse response) {

        // 1.指定解析器
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        String filename = "车辆维修审批单.pdf";
        String path = "e:/";
        OutputStream os = null;
        PdfStamper ps = null;
        PdfReader reader = null;
        try {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment;fileName="
                    + URLEncoder.encode(filename, "UTF-8"));
            os = response.getOutputStream();
            // 2 读入pdf表单
            reader = new PdfReader(path + "/" + filename);
            // 3 根据表单生成一个新的pdf
            ps = new PdfStamper(reader, os);
            // 4 获取pdf表单
            AcroFields form = ps.getAcroFields();
            // 5给表单添加中文字体 这里采用系统字体。不设置的话，中文可能无法显示
            BaseFont bf = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1",
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            form.addSubstitutionFont(bf);
            // 6查询数据================================================
            Map data = new HashMap();
            data.put("commitTime", "");
            data.put("driver","");
            data.put("carId", "");
            data.put("carType", "");
            data.put("repairAddress", "");
            data.put("repairCost", "");
            data.put("project", "");
            data.put("fwbzzxfzrYj","");
            data.put("fgldspYj", "");
            data.put("remarks","");
            // 7遍历data 给pdf表单表格赋值
            for (Object key : data.keySet()) {
                form.setField(key.toString(), data.get(key).toString());
            }
            ps.setFormFlattening(true);
            log.info("*******************PDF导出成功***********************");
        } catch (Exception e) {
            log.error("*******************PDF导出失败***********************");
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                reader.close();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
