# 笔记
<H3>这是我的笔记本仓库，其中有我的学习资料</H3>

电商项目实战 <br/>
e3-parent (e3商城项目的所有父类) <br/>
https://github.com/SuperCourierYangyufan/e3-parent <br/>
e3-common （工具类） <br/>
https://github.com/SuperCourierYangyufan/e3-common <br/>
e3-manager （实现） <br/>
https://github.com/SuperCourierYangyufan/e3-manager <br/>








<H5>zookeepe使用</H5>
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
