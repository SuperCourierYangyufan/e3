#ActiveMQ安装与使用

#安装<br>
 解压即可，进入bin/<br>
 ./activemq start 启动   ./activemq stop停止  ./activemq status 查看状态<br>
 http:/111.230.204.184:8161/admin 账号密码：admin<br>
 

#使用
先请引入：
        <!--MQ-->
        <dependency>
            <groupId>>org.apache.activemq</groupId>
            <artifactId>activemq-all</artifactId>
             <version>>5.11.2</version>
        </dependency>


单机版：<br>
https://github.com/SuperCourierYangyufan/e3/blob/master/e3-manager/e3-manager-service/src/main/test/ActiveMQTest/MqTest.java

#与spring整合
首先引入spring整合包：
          <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jms</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
         <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        
        <!--MQ-->
        <dependency>
            <groupId>>org.apache.activemq</groupId>
            <artifactId>activemq-all</artifactId>
             <version>>5.11.2</version>
        </dependency>


