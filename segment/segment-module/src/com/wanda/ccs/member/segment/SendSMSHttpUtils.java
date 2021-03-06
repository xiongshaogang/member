package com.wanda.ccs.member.segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import com.hp.smsplatform.server.ServiceClient;
import com.hp.smsplatform.server.ServiceUrl;
import com.hp.smsplatform.server.rabbitmq.WriteToQueue;
import com.hp.smsplatform.server.webservice.bean.Settle;
import com.hp.smsplatform.server.webservice.bean.SettleResult;

public class SendSMSHttpUtils  {
	 /**
     * 向指定URL发送GET方法的请求
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    
    /**
     * 万达集团
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),"UTF-8"));
            
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream() , "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("发送 POST 请求出现异常！"+e);
            result = e.getLocalizedMessage(); 
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    /**
     * 万达影城短信通道调用
     * @param   conn  数据库连接
     * @param msgMqIp	短信代理Mq地址
	 * @param msgSvcIp	短信代理svc地址
	 * @param msgChannelId	通道号
	 * @param mobileNo	手机号
	 * @param systemId	系统编号 001
	 * @param msgContent	短信内容
	 */
	public static boolean sendMsgCheckCode(String msgMqIp, String msgSvcIp,String msgChannelId,String mobileNo,String systemId,String msgContent){
		boolean isOk = false;
		ServiceUrl.setMqUrl(msgMqIp);
		ServiceUrl.setWebServiceUrl("http://"+msgSvcIp+"/SmsPlatform/messagePlatform/smsService?wsdl");
		SettleResult sr;
		String settleId = "";
		try {
			sr = ServiceClient.getSettleInfo(systemId);
			if ("00".equals(sr.getStatus())) {
				for (Settle stl : sr.getSettles()) {
					settleId = stl.getSettleId();
				}
			} else {
				System.out.println("获取商户信息失败，错误码：" + sr.getStatus());
			}
			//发送短信
			WriteToQueue wq=new WriteToQueue();
			wq.sendBulkSmsToQueue(
					msgChannelId,
					mobileNo, 
					"001", 
					settleId, 
					msgContent, 
					0
					);
			isOk = wq.isSendSeccess;
			if(wq.isSendSeccess){
				System.out.println("发送成功");
				return isOk;
			}
			System.out.println(wq.sendSuccessCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isOk;
	}
	/**
	 * 
	 * @param url 短信服务url
	 * @param mobile 接收短信手机号
	 * @param sendcontent 短信内容
	 * @return 发送结果 
	 * "success","S001"," the mobile param is null ","S002",
    " the send data param is null ","S003"," send faild ","S004"," no param ","S005";
	 */
    public static String sendSMSNew(String url, String mobile,String sendContent,String smstype) {
        PrintWriter out = null;
        String result = "";
        try {
        	StringBuffer jsonstr = new StringBuffer();
    		jsonstr.append("{").append("\"mobile\"").append(":\"").append(mobile).append("\",").append("\"smsdata\"").append(":\"").append(sendContent).append("\",").append("\"smstype\"").append(":\"").append(smstype).append("\"}");
    		System.out.println(jsonstr.toString());
    		url += "/"+jsonstr.toString();
            URL urlconn = new URL(url);
			//使用代理打开网页
			HttpURLConnection action = (HttpURLConnection) urlconn.openConnection(); 
			BufferedReader br = new BufferedReader(new InputStreamReader(action.getInputStream(),"UTF-8"));
			String line = "";
			 while ((line = br.readLine()) != null) {
	                result += line;
	            }
			br.close();
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("发送 POST 请求出现异常！"+e);
            result = e.getLocalizedMessage(); 
        }
        //使用finally块来关闭输出流、输入流
        finally{
            if(out!=null){
			    out.close();
			}
        }
        System.out.println("sms send resut is " + result + "send mobile is " + mobile);
        return result;
    }
	/**
	 * 随机6位密码
	 * @param n
	 * @return
	 */
	public static String random(int n) {
		String tex = "";
		for (int i = 1; i <= n; i++) {
			tex += "" + (int) (Math.random() * 10);
		}
		return tex;
	}
}
