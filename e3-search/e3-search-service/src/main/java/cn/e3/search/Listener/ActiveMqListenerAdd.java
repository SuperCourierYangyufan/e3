package cn.e3.search.Listener;

import cn.e3.common.pojo.SearchItem;
import cn.e3.search.mapper.ItemMapper;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 监听商品添加信息 ，同步索引
 * Created by YangYuFan on 2018/4/18.
 */
public class ActiveMqListenerAdd implements MessageListener {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private SolrServer solrServer;

    @Override
    public void onMessage(Message message) {
        try {
            //从消息获得id
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            Long itemid = new Long(text);
            //等待商品事务提交
            Thread.sleep(1000);
            //根据商品id查询商品信息
            SearchItem searchItem = itemMapper.getItemById(itemid);
            //创建一个文档对象，向文档添加域，写入，提交
            SolrInputDocument document = new SolrInputDocument();

            document.addField("id", searchItem.getId());
            document.addField("item_title", searchItem.getTitle());
            document.addField("item_sell_point", searchItem.getSell_point());
            document.addField("item_price", searchItem.getPrice());
            document.addField("item_image", searchItem.getImage());
            document.addField("item_category_name", searchItem.getCategory_name());

            solrServer.add(document);

            solrServer.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
