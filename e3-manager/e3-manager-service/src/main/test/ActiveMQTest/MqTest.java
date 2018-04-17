package ActiveMQTest;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * Created by YangYuFan on 2018/4/17.
 */
public class MqTest {
    @Test
    public void testQueueProducer() throws Exception{ //点对点生产 若没有接收 会保存
        //建立连接 创建一个连接工厂对象，需要指定服务的IP和端口
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://111.230.204.184:61616");
        //使用工厂对象 创建一个Connection对象
        Connection connection = connectionFactory.createConnection();
        //开启连接，调用Start方法
        connection.start();
        //创建一个session对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//1.是否开启事务(一般不开启)，开启第二参数没有意义 2.应答模式 一般两种自动或者手动
        //使用session，创建一个Destination对象 两种形式 queue topic
        Queue queue = session.createQueue("test-queue");
        //使用session对象创建一个producer对象
        MessageProducer producer = session.createProducer(queue);
        //创建一个Message对象 -》TextMessage
//        TextMessage textMessage = new ActiveMQTextMessage();
//        textMessage.setText("hello activemq");
        TextMessage message = session.createTextMessage("hello1 activemq");
        //发送
        producer.send(message);
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }
    @Test
    public void testConsumer() throws Exception{ //点对点消费者 接收后 只能接收一次 接收便删除
        //创建一个ConnectionFactory 对象 连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://111.230.204.184:61616");
        //创建连接对象
        Connection connection = connectionFactory.createConnection();
        //开启连接
        connection.start();
        //创建session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //使用session创建一个Destination对象
        Queue queue = session.createQueue("test-queue");
        //创建消费者
        MessageConsumer consumer = session.createConsumer(queue);
        //接收
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                //打印
                TextMessage textMessage = (TextMessage) message;
                String text;
                try {
                    text = textMessage.getText();
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //等待接收消息
        System.in.read();
        //关闭
        consumer.close();
        session.close();
        connection.close();
    }




    @Test
    public void testTopicProducer() throws Exception{ //广播生产者，若没有消费者，不会保存
        //建立连接 创建一个连接工厂对象，需要指定服务的IP和端口
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://111.230.204.184:61616");
        //使用工厂对象 创建一个Connection对象
        Connection connection = connectionFactory.createConnection();
        //开启连接，调用Start方法
        connection.start();
        //创建一个session对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//1.是否开启事务(一般不开启)，开启第二参数没有意义 2.应答模式 一般两种自动或者手动
        //使用session，创建一个Destination对象 两种形式 queue topic
        Topic topic = session.createTopic("test-Topic");
        //使用session对象创建一个producer对象
        MessageProducer producer = session.createProducer(topic);
        //创建一个Message对象 -》TextMessage
//        TextMessage textMessage = new ActiveMQTextMessage();
//        textMessage.setText("hello activemq");
        TextMessage message = session.createTextMessage("hello1 activemq");
        //发送
        producer.send(message);
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }


    @Test
    public void testTopicConsumer1() throws Exception{ //点对点消费者 接收后 只能接收一次 接收便删除
        //创建一个ConnectionFactory 对象 连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://111.230.204.184:61616");
        //创建连接对象
        Connection connection = connectionFactory.createConnection();
        //开启连接
        connection.start();
        //创建session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //使用session创建一个Destination对象
        Topic topic = session.createTopic("test-Topic");
        //创建消费者
        MessageConsumer consumer = session.createConsumer(topic);
        //接收
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                //打印
                TextMessage textMessage = (TextMessage) message;
                String text;
                try {
                    text = textMessage.getText();
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //等待接收消息
        System.in.read();
        //关闭
        consumer.close();
        session.close();
        connection.close();
    }

    @Test
    public void testTopicConsumer2() throws Exception{ //点对点消费者 接收后 只能接收一次 接收便删除
        //创建一个ConnectionFactory 对象 连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://111.230.204.184:61616");
        //创建连接对象
        Connection connection = connectionFactory.createConnection();
        //开启连接
        connection.start();
        //创建session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //使用session创建一个Destination对象
        Topic topic = session.createTopic("test-Topic");
        //创建消费者
        MessageConsumer consumer = session.createConsumer(topic);
        //接收
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                //打印
                TextMessage textMessage = (TextMessage) message;
                String text;
                try {
                    text = textMessage.getText();
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //等待接收消息
        System.in.read();
        //关闭
        consumer.close();
        session.close();
        connection.close();
    }
}
