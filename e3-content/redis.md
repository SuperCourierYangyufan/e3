redis的使用
先maven中
<!--jedis-->
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
             <version>2.7.2</version>
        </dependency>
        
#若单独使用
https://github.com/SuperCourierYangyufan/e3/blob/master/e3-content/e3-content-service/src/main/Test/TestJedis.java
</br>


#与spring整合，先需要下的三个文件
https://github.com/SuperCourierYangyufan/e3/tree/master/e3-common/src/main/java/cn/e3/common/jedis  
</br>
#在便是spring整合文件：
https://github.com/SuperCourierYangyufan/e3/blob/master/e3-content/e3-content-service/src/main/resources/spring/applicationContext-redis.xml
</br>
#使用方法：
https://github.com/SuperCourierYangyufan/e3/blob/master/e3-content/e3-content-service/src/main/Test/JedisClientTest.java
</br>


缓冲的同步：解决方法 当对缓冲保存的数据 进行添加 删除 修改时候 将缓冲文件删除就行！

设置过期时间 jedisClient.expire（key,time(s));

设置key时，若以：号分割，在图形界面上，则会有文件夹的格式分割
