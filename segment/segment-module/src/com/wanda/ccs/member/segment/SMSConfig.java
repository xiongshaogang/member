package com.wanda.ccs.member.segment;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SMSConfig {

	public static String smsUrl = null;
	public static String smsProxyUrl = null;
	public static String smsFromsys = null;
	public static String smsTitle = null;
	public static String msgMqIp = null;
	public static String msgSvcIp = null;
	public static String msgChannelId= null;
	public void initSMSConfig() {
		Properties prop = new Properties();
		InputStream in = null;
		try {
//			in = new BufferedInputStream(new FileInputStream(
//					"messageConfig.properties"));
//			in = getClass().getClassLoader().getResourceAsStream("messageConfig.properties");
//			prop.load(in);
//			smsUrl = prop.getProperty("SMS_URL");
//			smsProxyUrl = prop.getProperty("HP_SMS_PROXY_URL");
//			smsFromsys = prop.getProperty("SMS_FROMSYS");
//			smsTitle = prop.getProperty("CARD_SMS_TITLE");
//			msgMqIp = prop.getProperty("msgMqIp");
//			msgSvcIp = prop.getProperty("msgSvcIp");
//			smsUrl = prop.getProperty("NEW_SMS_URL");
//			msgChannelId= prop.getProperty("msgChannelId");
			smsProxyUrl = "http://10.199.90.26:8080/voucherSMS/sendSMSMsg.do";
			smsFromsys = "YXZBXT001";
			smsTitle = "RUNCONTROL";
			msgMqIp = "10.199.2.33";
			msgSvcIp = "10.199.2.33";
			smsUrl = "http://10.199.90.26:8080/WDService/sms/sendSMS";
			msgChannelId= "00001";
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] agrs){
		System.out.println(smsTitle);
	}
}
