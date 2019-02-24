package com.bl.utils.httpUtils;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface RequestExecutors<T, E> {

	T httpData(E data, String url) throws ClientProtocolException, IOException;
	
}
