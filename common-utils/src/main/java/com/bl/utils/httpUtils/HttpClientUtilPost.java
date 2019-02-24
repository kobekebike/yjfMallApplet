package com.bl.utils.httpUtils;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;


public class HttpClientUtilPost implements RequestExecutors<String, String> {

    public static Logger logger = Logger.getLogger(HttpClientUtilPost.class);

    public String httpData(String data, String url) throws ClientProtocolException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response2 = null;

        httpPost.setEntity(new ByteArrayEntity(data.getBytes(Charset.forName("utf-8"))));
        try {
            response2 = httpclient.execute(httpPost);
            logger.info("------------报文信息-------------");
            logger.info("请求报文:");
            logger.info(data);
            HttpEntity entity2 = response2.getEntity();
            logger.info("响应报文:");
            String responseText = EntityUtils.toString(entity2, "UTF-8");
            logger.info(responseText);
            logger.info("------------");
            EntityUtils.consume(entity2);
            return responseText;

        } finally {
            try {
                response2.close();
            } catch (IOException e) {
                logger.warn("发送http请求时发生异常:" + e.getMessage());
            }
        }

    }


}
