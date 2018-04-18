#ActiveMQ安装与使用

#安装<br>
 解压即可，进入bin/<br>
 ./activemq start 启动   ./activemq stop停止  ./activemq status 查看状态<br>
 http:/111.230.204.184:8161/admin 账号密码：admin<br>



#单机版：<br>
https://github.com/SuperCourierYangyufan/e3/blob/master/e3-manager/e3-manager-service/src/main/test/ActiveMQTest/MqTest.java

#与spring整合<br>
         ==》生产者：<br>
                    =》发送消息  https://github.com/SuperCourierYangyufan/e3/blob/master/e3-manager/e3-manager-service/src/main/java/cn/e3/service/Impl/ItemServiceImpl.java<br>
                    =》spring文件 https://github.com/SuperCourierYangyufan/e3/blob/master/e3-manager/e3-manager-service/src/main/resources/spring/applicationContext-activemq.xml<br>
     <br>    ==>消费者：<br>
                    =》监听器  https://github.com/SuperCourierYangyufan/e3/blob/master/e3-search/e3-search-service/src/main/java/cn/e3/search/Listener/ActiveMqListenerAdd.java<br>
                    =》spring文件 https://github.com/SuperCourierYangyufan/e3/blob/master/e3-search/e3-search-service/src/main/resources/spring/applicationContext-activemq.xml<br>
      
        
        <!--MQ-->
        <dependency>
            <groupId>>org.apache.activemq</groupId>
            <artifactId>activemq-all</artifactId>
             <version>>5.11.2</version>
        </dependency>
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


