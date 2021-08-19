--2021.06.18 多线程发送消息
study\src\main\java\com\xu\util\ListUtil.java
study\src\main\java\com\xu\thread\UserThread.java
study\src\main\java\com\xu\bean\User.java

--判断某个日期是否小于当前日期减去天数
study\src\main\java\com\xu\util\DateUtil.java

--mybatis代码生成类实现
study\src\main\java\com\xu\config\GeneratorCodeConfig.java

--pdf导出
study\src\main\java\com\xu\util\PdfUtil.java

--2021.08.11 分布式事务
依赖：
 <dependency>
      <groupId>com.alibaba.cloud</groupId>
      <artifactId>spring-cloud-starter-alibaba-seata</artifactId>
      <version>2.1.0.RELEASE</version>
 </dependency>

seata数据源配置类：
study\src\main\java\com\xu\seata\SeataDataSourceProxy.java

在需要实现分布式事务的方法上添加@GlobalTransactional

--2021.08.12
rocketmq生产者发送half消息：
rocketMQ_producer\src\main\java\com\xu\mq\controller\RocketSendController.java

rocketmq生产者half消息发送成功的监听：
rocketMQ_producer\src\main\java\com\xu\mq\listener\TransactionListener.java

rocketmq消费者端的监听：
study\src\main\java\com\xu\mq\listener\RocketMqListener.java

--Base64和AES工具类
study\src\main\java\com\xu\util\AESUtil.java
study\src\main\java\com\xu\util\Base64Util.java

--得到微信支付的二维码
study\src\main\java\com\xu\wxpay\service\impl\WeixinPayServiceImpl.java

--支付安全处理工具类：解密、验签
study\src\main\java\com\xu\util\Signature.java

--2021.08.19 nginx配置
upstream canjin{
		#配置要负载的服务器
		server 127.0.0.1:8087 weight=1;
	}

    server {
        listen       80;
        server_name  localhost;

        location / {
            root   html;
            index  index.html index.htm;
			proxy_pass http://canjin/;
        }
    }
访问localhost/get即访问http://127.0.0.1:8087/get