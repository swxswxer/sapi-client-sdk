package com.swx.sapiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

public class SignUtils {


    /**
     * 生成签名
     *
     * @param body
     * @param secretKey
     * @return
     */
    public static String genSign(String body, String secretKey) {


        Digester md5 = new Digester(DigestAlgorithm.MD5);
        String content = body + "." + secretKey;
        long startTime = System.currentTimeMillis();
        String s = md5.digestHex(content);
        long endTime = System.currentTimeMillis();
        // 计算并打印方法执行时间
        long executionTime = endTime - startTime;
        System.out.println("Method executed in: " + executionTime + " ms");

        return s;
    }

}
