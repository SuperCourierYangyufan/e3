# 笔记这是我的笔记本仓库，其中有我的学习资料

电商项目实战 
e3-parent (e3商城项目的所有父类) 
https://github.com/SuperCourierYangyufan/e3-parent 
e3-common （工具类） 
https://github.com/SuperCourierYangyufan/e3-common 
e3-manager （实现） 
https://github.com/SuperCourierYangyufan/e3-manager 








#zookeeper使用
第一步：安装jdk<br/>
第二步：把zookeeper的压缩包上传到linux系统。<br/>
第三步：解压缩压缩包<br/>
tar -zxvf zookeeper-3.4.6.tar.gz<br/>
第四步：进入zookeeper-3.4.6目录，创建data文件夹。<br/>
第五步：把zoo_sample.cfg改名为zoo.cfg<br/>
[root@localhost conf]# mv zoo_sample.cfg zoo.cfg<br/>
第六步：修改data属性：dataDir=/root/zookeeper-3.4.6/data<br/>
第七步：启动zookeeper<br/>
[root@localhost bin]# ./zkServer.sh start<br/>
关闭：[root@localhost bin]# ./zkServer.sh stop<br/>
查看状态：[root@localhost bin]# ./zkServer.sh status<br/>
<br/>
注意：需要关闭防火墙。<br/>
service iptables stop<br/>
永久关闭修改配置开机不启动防火墙：<br/>
chkconfig iptables off<br/>
如果不能成功启动zookeeper，需要删除data目录下的zookeeper_server.pid文件。<br/>

#dubbo与zookeeper整合
导入以下包(提供方与消费方均要)
  <!-- dubbo相关 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>dubbo</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework</groupId>
                    <artifactId>spring</artifactId>
                </exclusion>
                <exclusion>
                    <groupId>org.jboss.netty</groupId>
                    <artifactId>netty</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
        </dependency>
        <dependency>
            <groupId>com.github.sgroschupf</groupId>
            <artifactId>zkclient</artifactId>
        </dependency>
        
提供方spring代码如下(service)：
<!-- 使用dubbo发布服务 -->
	<!-- 提供方应用信息，用于计算依赖关系 -->
	<dubbo:application name="e3-manager" /> //特别注意  这里应该与web.xml中的name名字一致（大坑）
	<dubbo:registry protocol="zookeeper" address="192.168.220.131:2181" />
	<!-- 用dubbo协议在20880端口暴露服务 -->
	<dubbo:protocol name="dubbo" port="20880" />
	<!-- 声明需要暴露的服务接口 -->
	<dubbo:service interface="cn.e3.service.ItemService" ref="itemServiceImpl"  timeout="600000" />
  
 消费方spring(controller):
  <!-- 引用dubbo服务 -->
    <dubbo:application name="e3-manager-web"/>
    <dubbo:registry protocol="zookeeper" address="192.168.220.131:2181"/>
    <dubbo:reference interface="cn.e3.service.ItemService" id="itemService" />
    
    
    
#pageHelper使用
mavan引入
<dependency>
        <groupId>com.github.pagehelper</groupId>
        <artifactId>pagehelper</artifactId>
        <version>${pagehelper.version}</version>
 </dependency>
 
 mybatis设置文件中
 <plugins>
        <!-- com.github.pagehelper为PageHelper类所在包名 -->
        <plugin interceptor="com.github.pagehelper.PageHelper">
            <!-- 设置数据库类型 Oracle,Mysql,MariaDB,SQLite,Hsqldb,PostgreSQL六种数据库-->
            <property name="dialect" value="mysql"/>
        </plugin>
  </plugins>
  
  实现方法：
   //设置分页信息
  	 PageHelper.startPage(page, rows);
   //执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = tm.selectByExample(example);
   //取分页结果
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
	
pageinfo中有多个属性：
     rivate int pageNum;  
    //每页的数量  
    private int pageSize;  
    //当前页的数量  
    private int size;  
  
    //由于startRow和endRow不常用，这里说个具体的用法  
    //可以在页面中"显示startRow到endRow 共size条数据"  
  
    //当前页面第一个元素在数据库中的行号  
    private int startRow;  
    //当前页面最后一个元素在数据库中的行号  
    private int endRow;  
    //总记录数  
    private long total;  
    //总页数  
    private int pages;  
    //结果集  
    private List<T> list;  
    //前一页  
    private int prePage;  
    //下一页  
    private int nextPage;  
    //是否为第一页  
    private boolean isFirstPage = false;  
    //是否为最后一页  
    private boolean isLastPage = false;  
    //是否有前一页  
    private boolean hasPreviousPage = false;  
    //是否有下一页  
    private boolean hasNextPage = false;  
    //导航页码数  
    private int navigatePages;  
    //所有导航页号  
    private int[] navigatepageNums;  
    //导航条上的第一页  
    private int navigateFirstPage;  
    //导航条上的最后一页  
    private int navigateLastPage;  
    
    
    ps:eazyUI中 对初始显示需要严格定义{total:”2”,rows:[{“id”:”1”,”name”:”张三”},{“id”:”2”,”name”:”李四”}]}   total  rows
    
    
    
   #Nginx的安装
   一：linux安装Nginx需要环境，如下安装
   yum install gcc-c++
   yum install -y pcre pcre-devel
   yum install -y zlib zlib-devel
   yum install -y openssl openssl-devel
   
   二 ：把nginx的源码包上传到linux系统
   	tar zxf nginx-1.8.0.tar.gz （解压）
   三：进入解压文件夹中
	./configure \
	--prefix=/usr/local/nginx \
	--pid-path=/var/run/nginx/nginx.pid \
	--lock-path=/var/lock/nginx.lock \
	--error-log-path=/var/log/nginx/error.log \
	--http-log-path=/var/log/nginx/access.log \
	--with-http_gzip_static_module \
	--http-client-body-temp-path=/var/temp/nginx/client \
	--http-proxy-temp-path=/var/temp/nginx/proxy \
	--http-fastcgi-temp-path=/var/temp/nginx/fastcgi \
	--http-uwsgi-temp-path=/var/temp/nginx/uwsgi \
	--http-scgi-temp-path=/var/temp/nginx/scgi
    四：注意：启动nginx之前，上边将临时文件目录指定为/var/temp/nginx，需要在/var下创建temp及nginx目录
	 mkdir /var/temp/nginx/client -p
    五：在解压文件夹中
    	make
	make install
	
	#Nginux的使用
	进入sbin目录
	[root@localhost sbin]# ./nginx  //启动
	关闭nginx：
	[root@localhost sbin]# ./nginx -s stop
	推荐使用：
	[root@localhost sbin]# ./nginx -s quit

	重启nginx：
	1、先关闭后启动。
	2、刷新配置文件：
	[root@localhost sbin]# ./nginx -s reload



