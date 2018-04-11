import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by YangYuFan on 2018/4/11.
 */
public class TestJedis {
    @Test //单机版
    public void testjedis(){
        //创建jedis对象，参数host . port
        Jedis jedis = new Jedis("111.230.204.184",6379);
        //每个jedis方法对应一个操作
        jedis.set("test","my first jedis");

        String string = jedis.get("test");
        System.out.println(string);

        jedis.close();
    }


    @Test //单机连接池
    public void testJedisPool(){
        //创建连接池
        JedisPool pool = new JedisPool("111.230.204.184",6379);
        //获得连接
        Jedis jedis = pool.getResource();
        //使用
        jedis.set("a","123");

        System.out.println(jedis.get("a"));
        //关闭连接

        jedis.close();
        pool.close();
    }


    @Test //集群版
    public void testJedisCluster(){
        //创建JedisCluster 只有一个参数 nodes 是个set类型，包含若干个 host和port对象
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("123.206.32.230",7001));
        nodes.add(new HostAndPort("123.206.32.230",7002));
        nodes.add(new HostAndPort("123.206.32.230",7003));
        nodes.add(new HostAndPort("123.206.32.230",7004));
        nodes.add(new HostAndPort("111.230.204.184",7005));
        nodes.add(new HostAndPort("111.230.204.184",7006));

        JedisCluster jedisCluster = new JedisCluster(nodes);

        //直接使用jedisCluster对象操作redis 不用关闭
        jedisCluster.set("hello","word");

        System.out.println(jedisCluster.get("hello"));
        //关闭
        jedisCluster.close();
    }
}
