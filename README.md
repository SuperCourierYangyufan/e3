# 笔记
<H3>这是我的笔记本仓库，其中有我的学习资料</H3>

电商项目实战 <br/>
e3-parent (e3商城项目的所有父类) <br/>
https://github.com/SuperCourierYangyufan/e3-parent <br/>
e3-common （工具类） <br/>
https://github.com/SuperCourierYangyufan/e3-common <br/>
e3-manager （实现） <br/>
https://github.com/SuperCourierYangyufan/e3-manager <br/>









对zookeeper解压缩后 在conf文件夹中 对zoo_sample.cfg改名为zoo.cfg</br>并且在上级目录创建data文件夹改为以下结构：</BR>
# The number of milliseconds of each tick</br>
tickTime=2000</br>
# The number of ticks that the initial</br>
# synchronization phase can take</br>
initLimit=10</br>
# The number of ticks that can pass between</br>
# sending a request and getting an acknowledgement</br>
syncLimit=5</br>
# the directory where the snapshot is stored.</br>
# do not use /tmp for storage, /tmp here is just</br>
# example sakes.</br>
dataDir=/usr/local/zookeeper-3.4.6/data</br>
# the port at which the clients will connect</br>
clientPort=2181</br>
# the maximum number of client connections.</br>
# increase this if you need to handle more clients</br>
#maxClientCnxns=60</br>
#</br>
# Be sure to read the maintenance section of the</br>
# administrator guide before turning on autopurge.</br>
#</br>
# http://zookeeper.apache.org/doc/current/zookeeperAdmin.html#sc_maintenance</br>
#</br>
# The number of snapshots to retain in dataDir</br>
#autopurge.snapRetainCount=3</br>
# Purge task interval in hours</br>
# Set to "0" to disable auto purge feature</br>
#autopurge.purgeInterval=1</br>

