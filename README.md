
### 动态更新服务器IP到DNSPOD进行解析 ###

一、说明

	个人用户很难获取固定IP,最多只能获取动态IP
	运行本项目必须
		1. 致电运营商设置网络猫的桥接模式和动态IP,记住宽带账号和密码
		2. 使用宽带账号和密码在路由器上进行拨号上网,服务器连接该路由器,在路由器上设置绑定服务器MAC地址和外部与内部端口映射,参考https://service.tp-link.com.cn/detail_article_2441.html 端口号不可使用80,22,443等常见端口号
		3. 在 https://www.dnspod.cn 购买便宜的域名,并进行解析
	运行本项目和可解决外网通过自己购买的域名访问内网服务器的问题

二、类介绍
	
	1. DnsInfo.java 解析DNSPOD返回的Json数据
	2. Fuction.java 访问网络获取返回的数据
	3. IPFile.java  读写文件
	4. RunMain.java 主函数

三、配置文件

	在jar文件运行目录下创建dnspod.properties文件
	dnspod.properties中的参数都是必备可少的,注意:该配置文件必须和运行的jar文件在同一路径下
	参数如下:
	path=运行目录(必须),如:/opt/soft
	url=IP获取地址(必须)如:https://api.ip.sb/ip
	login_token=你在DNSPOD的token(必须),详情访问https://www.dnspod.cn/login
	domain=你在DNSPOD的域名(必须)
	domain_id=你在DNSPOD的域名ID(可选)
	
四、运行
	
	git到本地后导入项目,生产jar文件,上传到服务器,在同一路径下创建dnspod.properties文件并设置参数,最后运行
