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