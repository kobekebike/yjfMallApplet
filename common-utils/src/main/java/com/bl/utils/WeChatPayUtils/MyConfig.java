package com.bl.utils.WeChatPayUtils;

import com.bl.utils.WeChatPayUtils.WXPayConfig;
import java.io.*;

public class MyConfig extends WXPayConfig {

	private byte[] certData;

	@Override
	public String getAppID() {
		return "wxfcf3cfb9d5747968";
	}

	@Override
	public String getMchID() {
		return "1480432552";
	}

	@Override
	public String getKey() {
		return "80A21BFBDA5E0642A0B38CCE783D190F";
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