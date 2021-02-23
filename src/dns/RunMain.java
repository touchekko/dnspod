package dns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * 
 * @author touch
 *
 */
public class RunMain {
	static String path; //ip.txt文件的根目录
	static String url = "https://api.ip.sb/ip"; //请求IP地址的服务器
	static String login_token; //dnspod的登陆验证码
	static String domain_id; //域名地址id,由dnspod返回
	static String domain; //域名地址，如 baidu.com
	static DnsInfo info = new DnsInfo();
	public static void main(String[] args) {
		boolean isExist = false;
		BufferedReader bufferedReader = null;
		try {
			Properties properties = new Properties();
			bufferedReader = new BufferedReader(new FileReader("./dnspod.properties"));
			properties.load(bufferedReader);
			path = properties.getProperty("path");
			url = properties.getProperty("url");
			login_token = properties.getProperty("login_token");
			domain_id = properties.getProperty("domain_id");
			domain = properties.getProperty("domain");
			bufferedReader.close();
			isExist = true;
		} catch (Exception e) {
			isExist = false;
		}
		if(isExist) {
			System.setProperty("logdir",path);
			Logger logger = Logger.getLogger(RunMain.class);
			logger.info("---成功读取配置文件---");
			String oldIP = IPFile.readTxt(path + "ip.txt");
			logger.info("旧IP为："+oldIP);
			String newIP = Fuction.getNewIP(url);
			logger.info("新IP为："+newIP);
			if(oldIP.equals(newIP)) {
				logger.info("---不用更新---");
			}else {
				logger.info("---IP需要更新，开始请求和解析DNS...");
				String[] getInfo = {"curl","-X", "POST",  "https://dnsapi.cn/Record.List", "-d","login_token="+login_token+"&format=json&domain="+domain+"&offset=0&length=3"};//必须分开写，不能有空格
				String json = Fuction.execCurl(getInfo);
				JSONObject outJson = JSONObject.parseObject(json);
				JSONObject status = outJson.getJSONObject("status");
				String code = status.getString("code");
				if(code.equals("1")) {
					logger.info("---状态正确，正在解析DNS...");
					JSONObject domain = outJson.getJSONObject("domain");
					int domain_id = domain.getInteger("id");
					
					JSONArray records = outJson.getJSONArray("records");
					String str = records.getString(0);
					JSONObject map = JSONObject.parseObject(str);
					String record_id = map.getString("id");
					String value = map.getString("value");
					String record_line_id = map.getString("line_id");
					String record_type = map.getString("type");
					String ttl = map.getString("ttl");
					String sub_domain = map.getString("name");
					String mx = map.getString("mx");
					String statu = map.getString("status");
					
					info.setRecord_id(record_id);
					info.setRecord_line_id(record_line_id);
					info.setRecord_type(record_type);
					info.setValue(value);
					info.setDomain_id(domain_id);
					info.setSub_domain(sub_domain);
					info.setTtl(ttl);
					info.setMx(mx);
					info.setStatu(statu);
					logger.info("DNS信息为:" + json);
				}else {
					logger.error("---状态错误，无法解析DNS！！！");
				}
				if(newIP.equals(info.getValue())) {
					IPFile.writeTxt(newIP, path + "ip.txt");
					logger.info("---不用更新---");
				}else {
					String[] update = {"curl","-X", "POST",  "https://dnsapi.cn/Record.Modify", "-d","login_token="+info.getLOGIN_TOKEN()+"&format=json&domain_id="+info.getDomain_id()+"&record_id="+info.getRecord_id()+"&sub_domain="+info.getSub_domain()+"&value="+newIP+"&record_type="+info.getRecord_type()+"&record_line_id="+info.getRecord_line_id()+"&ttl="+info.getTtl()};
					String result = Fuction.execCurl(update);
					logger.info("---正在保存最新IP到本地...");
					IPFile.writeTxt(newIP, path + "ip.txt");
					logger.info("---已经DNS更新和解析完成---");
					logger.info("最终结果是："+result);
				}
			}
		}else {
			System.out.println("---读取配置文件出错，请检查文件或必要值是否存在---");
		}

	}
}
