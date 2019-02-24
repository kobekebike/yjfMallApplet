package com.bl.utils.httpUtils;

import java.io.IOException;

public interface RequestService {

    /**
     * 可以用这个，针对所有GET请求
     * @param url
     * @param getData
     * @return
     */
    String get(String url, String getData) throws IOException;

    /**
     * 可以用这个，针对所有POST请求
     * @param url
     * @param postData
     * @return
     */
    String post(String url, String postData) throws IOException;
}
