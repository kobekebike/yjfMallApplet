package com.bl.utils.httpUtils;

import java.io.IOException;

public class RequestServiceImpl implements RequestService {
    @Override
    public String get(String url, String getData) throws IOException {
        return new HttpClientUtilGet().httpData(getData, url);
    }

    @Override
    public String post(String url, String postData) throws IOException{
        return new HttpClientUtilPost().httpData(postData, url);
    }
}
