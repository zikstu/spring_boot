package com.medsci.hello.spring.boot.utils;

import java.util.Map;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/16 17:32
 */
public class RsaTest {
    public static void main(String[] args) throws Exception {
        // 生成新的公私钥
        Map<String, Object> genKeyPair = RSAUtils.resetGenKeyPair();

        // 获取公钥
//        String publicKey = RSAUtils.getPublicKey(genKeyPair);
//        System.out.println("------- 公钥 -------");
//        System.out.println(publicKey);

        // 获取私钥
//        String privateKey = RSAUtils.getPrivateKey(genKeyPair);
//        System.out.println("------- 私钥 -------");
//        System.out.println(privateKey);

		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCv9qfNDmcwEgQbLGrK0K1XnMWWO2CpCcFIPkBJ+4K8FCn4CBp6hmrtwIit+h6dEs1fzP9OTyveNrt+aBXCwx3dVof2sUZNzOL60t0Ts7DeSHuTSDSNrOl706UlDSGeUmLN9luF/FNKW27iLIME23/2DUsbi3m0x5dwU2Zgy9N/LQIDAQAB";
        System.out.println("------- 公钥 -------");
        System.out.println(publicKey);

        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK/2p80OZzASBBssasrQrVecxZY7YKkJwUg+QEn7grwUKfgIGnqGau3AiK36Hp0SzV/M/05PK942u35oFcLDHd1Wh/axRk3M4vrS3ROzsN5Ie5NINI2s6XvTpSUNIZ5SYs32W4X8U0pbbuIsgwTbf/YNSxuLebTHl3BTZmDL038tAgMBAAECgYA7quklqH+nFkTcLgicc3yEG/4IPmQ9jbhD1hAYxjeDrVa5642HBLOXoVT3obvlyW1o0eu00zXt6SNU7tiKLX2fcx4OFR4+vfjwsv157DBkPW9GjA1QedhdhutKfT22Jb6GkzaY9yT10rncF6+ZyBSA+XxUvV2YPstlg/P71nNtJQJBAOPNzTiSyy53mXOb4aCeU+RlaKYlckaDAibvuwLlmC16nU8gHOMo39VXqxh/HpibEjNbGMJV9DmIAQD9ZiSBjq8CQQDFvjzVfN/YK70F1mjyOfecOidqUTkzCUcH/fW+V084IB0wKd04BBowkqZUApeky738jOe6yz11GfjCGSx7fCbjAkEAgM8AyIlwa+DimtU8mjaMVyvkJXYtDKPNVrjdNMEf8C9Rvcj5rJSTJC4DJ8HRShb9Dp7m/BPgGZvGfYnK9L9xLwJAO3F9rhu02rIDR571u2NLmQ4uTRqPnFT8ol1oo0hxywh0Xccn9i/dg56CG50P4v1QZnwhKRjxp6MgEZEpuxFOSwJACfZAtBlLKQKNocdYiy7raTAXe4VG/d+MLFic/q3s/eQ0BhfccryivdDlZKenI8HJ6XeODi++Vj7xr2PMQiNesQ==";
        System.out.println("------- 私钥 -------");
        System.out.println(privateKey);

        // 加密数据
        String data = "aaa";
        System.out.println("------- 加密字符串 -------");
        System.out.println(data);

        // 私钥加签
        String sign = RSAUtils.sign(data, privateKey);
//		String sign = "JAkJLORVds3LC8zv7eaJ3MCWkIzEuwnrlzs7y7zNXYZ8TXRXGJVFBuJ6bhYK5lZMvbHOANCTQSUBQgDUN9Rra38YJW+MG16DxdDvRZlZ8FszySH+5hPuQNGgKkwzdDhabH7/7VhemXWq9VRpkyHxPSnn69I3vhcmba+lGbq2HM4=";
        System.out.println("------- 数据签名 -------");
        System.out.println(sign);

        // 验证签名
        boolean verifySign = RSAUtils.verifySign(data, publicKey, sign);
        System.out.println("------- 验证签名 -------");
        System.out.println(verifySign);

        // 私钥加密
        String priEncrypt = RSAUtils.encryptByPrivateKey(data, privateKey);
        System.out.println("------- 私钥加密 -------");
        System.out.println(priEncrypt);

        // 公钥解密
        String pubDecrypt = RSAUtils.decryptByPublicKey(priEncrypt, publicKey);
        System.out.println("------- 公钥解密 -------");
        System.out.println(pubDecrypt);

        // 公钥加密
        String pubEncrypt = RSAUtils.encryptByPublicKey(data, publicKey);
        System.out.println("------- 公钥加密 -------");
        System.out.println(pubEncrypt);

        // 私钥解密
        String priDecrypt = RSAUtils.decryptByPrivateKey(pubEncrypt, privateKey);
        System.out.println("------- 私钥解密 -------");
        System.out.println(priDecrypt);
    }
}
