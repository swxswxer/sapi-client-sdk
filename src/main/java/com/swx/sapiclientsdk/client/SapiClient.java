package com.swx.sapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;

import com.google.gson.Gson;


import java.util.HashMap;
import java.util.Map;

import static com.swx.sapiclientsdk.utils.SignUtils.genSign;

/**
 * 调用第三方接口的客户端
 */
public class SapiClient {

//    private static final String GATEWAY_HOST = "http://sapi-gateway:8090";
    private static final String GATEWAY_HOST = "http://10.15.25.23:8090";

    private String accessKey;
    private String secretKey;

    public SapiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }


    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        //密钥 一定不可以放在请求中
//        hashMap.put("secretKey",secretKey);

        String nonce = RandomUtil.randomNumbers(4);
        hashMap.put("nonce", nonce);
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(nonce, secretKey));
        return hashMap;
    }

    public String postInvoke (String url,String requestParams){
        HttpResponse httpResponse = HttpRequest.post(url)
                .addHeaders(getHeaderMap(requestParams))
                .body(requestParams)
                .execute();
        return httpResponse.body();
    }

    public String getInvoke (String url,String requestParams){
        HttpResponse httpResponse = HttpRequest.get(url)
                .addHeaders(getHeaderMap(requestParams))
                .body(requestParams)
                .execute();
        return httpResponse.body();
    }

}
