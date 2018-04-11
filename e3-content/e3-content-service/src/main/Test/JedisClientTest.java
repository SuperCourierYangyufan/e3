import cn.e3.common.jedis.JedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by YangYuFan on 2018/4/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-redis.xml")
public class JedisClientTest {
    @Autowired
    private JedisClient jedisClient;

    @Test
    public void TestJedis(){
        jedisClient.set("1","99");

        System.out.println(jedisClient.get("1"));
    }
}
