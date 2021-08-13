package com.xu.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;


/**
 * @Author: canjin
 * @Date: 2021/8/12
 * 说明:AES加密解密工具类
 */
public class AESUtil {

    /****
     * AES加密/解密
     * @param buffer:密文/明文
     * @param appsecret:秘钥
     * @param mode:加密/解密模式  1 加密  2 解密
     * @return
     */
    public static byte[] encryptAndDecrypt(byte[] buffer,String appsecret,Integer mode) throws Exception{
        //1:加载加密解密算法处理对象（包含算法、秘钥管理）
        Security.addProvider(new BouncyCastleProvider());

        //2:根据不同算法创建秘钥   1）秘钥的字节数组   2）加密算法
        SecretKeySpec secretKeySpec = new SecretKeySpec(appsecret.getBytes("UTF-8"),"AES");

        //3:设置加密模式（无论是加密还是解析，模式一致）
        // 1): AES/ECB/KPS7Padding 设置算法
        // 2):指定算法库对象
        // BC是BouncyCastleProvider类的PROVIDER_NAME指定的
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding","BC");
        //4:初始化加密配置
        cipher.init(mode,secretKeySpec);
        //5:执行加密/解密
        return cipher.doFinal(buffer);
    }

    public static void main(String[] args) throws Exception{
        String content="hello world!";
        //16位秘钥
        String key ="1616161616161616";
        //加密
        byte[] bytes = encryptAndDecrypt(content.getBytes(), key, 1);
        System.out.println("加密后："+Base64Util.encode(bytes));
        
        //解密
        byte[] decrypt = encryptAndDecrypt(bytes, key, 2);
        String s = new String(decrypt, "UTF-8");
        System.out.println("解密:"+s);
    }
}
