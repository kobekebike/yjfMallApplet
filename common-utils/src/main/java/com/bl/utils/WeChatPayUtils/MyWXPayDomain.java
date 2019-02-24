package com.bl.utils.WeChatPayUtils;

public class MyWXPayDomain implements IWXPayDomain{

	@Override
	public void report(String domain, long elapsedTimeMillis, Exception ex) {
		if(ex != null)
		ex.printStackTrace();
	}

	@Override
	public DomainInfo getDomain(WXPayConfig config) {
		IWXPayDomain.DomainInfo domainInfo = new DomainInfo("api.mch.weixin.qq.com", false);
		return domainInfo;
	}

}
