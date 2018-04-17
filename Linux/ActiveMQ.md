#ActiveMQ安装与使用

#安装<br>
 解压即可，进入bin/<br>
 activemq start 启动   ./activemq stop停止  ./activemq status 查看状态<br>
 http:/111.230.204.184:8161/admin 账号密码：admin<br>
 

#使用<br>

先请引入：<br>
        <!--MQ-->
        <dependency>
            <groupId>org.apache.activemq</groupId>
            <artifactId>activemq-all</artifactId>
        </dependency>



单机版：<br>
https://github.com/SuperCourierYangyufan/e3/blob/master/e3-manager/e3-manager-service/src/main/test/ActiveMQTest/MqTest.java
