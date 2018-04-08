import cn.e3.common.utils.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * Created by YangYuFan on 2018/4/7.
 */
public class FastDfsTest {
    //测试FastDFS文件上传服务器
    @Test
    public void fun() throws Exception{
        //创建配置文件。文件任意
        //使用全局对象加载文件
        ClientGlobal.init("D:/java/IDEA/e3-manager-web/src/main/testResources/conf/client.conf");
        //创建TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient获得TrackerServer
        TrackerServer trackerServer = trackerClient.getConnection();
        //StorageServer,可以为null
        StorageServer storageServer =null;
        //创建一个StorageClient，参数需要trackerServer和storageServer
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
        //使用StrorageClient上传文件
        String[] jpgs = storageClient.upload_appender_file("C:/Users/Administrator/Desktop/新建文件夹 (2)/2012-10-16-0864.jpg", "jpg", null);
        for (String jpg : jpgs) {
            System.out.print(jpg);
        }
    }



    @Test
    public void fun2() throws Exception{
        FastDFSClient fastDFSClient = new FastDFSClient("D:/java/IDEA/e3-manager-web/src/main/testResources/conf/client.conf");
        String s = fastDFSClient.uploadFile("C:/Users/Administrator/Desktop/新建文件夹 (2)/2012-10-16-0866.jpg");
        System.out.println(s);
    }
}
