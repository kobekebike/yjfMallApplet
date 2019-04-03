package com.bl.utils.WeChatPayUtils;

import com.bl.utils.WeChatPayUtils.WXPayConfig;
import java.io.*;

public class MyConfig extends WXPayConfig {

	private byte[] certData;

	@Override
	public String getAppID() {
		return "wx77803bd44da8f25f";
	}

	@Override
	public String getMchID() {
		return "1529738961";
	}

	@Override
	public String getKey() {
		return "96e79218965eb72c92a549dd5a330112";
	}

	@Override
	public InputStream getCertStream() {
		ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
		return certBis;
	}

	@Override
	public IWXPayDomain getWXPayDomain() {
		return new MyWXPayDomain();
	}
}