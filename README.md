
### 动态更新服务器IP地址到DNSPOD ###

一、类介绍
	
	1. DnsInfo.java 解析DNSPOD返回的Json数据
	2. Fuction.java 访问网络获取返回的数据
	3. IPFile.java  读写文件
	4. RunMain.java 主函数

二、配置文件

	dnspod.properties中的参数都是必备可少的,注意:该配置文件必须和运行的jar文件在同一路径下
		path=运行目录,如:/opt/soft
		url=IP获取地址(必须)如:https://api.ip.sb/ip
		login_token=你在DNSPOD的token(必须)
		domain=你在DNSPOD的域名(必须)
		domain_id=你在DNSPOD的域名ID(可选)
