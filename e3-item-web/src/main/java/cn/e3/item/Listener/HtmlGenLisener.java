package cn.e3.item.Listener;

import cn.e3.item.pojo.Item;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.service.ItemService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**监听商品添加消息，生成静态页面
 * Created by YangYuFan on 2018/4/19.
 */
public class HtmlGenLisener implements MessageListener {
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Autowired
    private ItemService itemService;

    @Value("${HTML_GEN_PATH}")
    private String HTML_GEN_PATH;

    @Override
    public void onMessage(Message message) {
        try {
            //创建模板
            //获得id
            TextMessage textMessage = (TextMessage) message;
            String textid = textMessage.getText();
            Long id = new Long(textid);
            //等待事务提交
            Thread.sleep(1000);
            //根据id查询商品
            TbItem tbItem = itemService.getItemById(id);
            Item item = new Item(tbItem);
            //取商品描述
            TbItemDesc tbItemDesc = itemService.getTbItemDescByID(id);
            //创建一个数据集，封装
            Map map = new HashMap<>();
            map.put("item",item);
            map.put("itemDesc",tbItemDesc);
            //加载模板对象
            Configuration configuration = freeMarkerConfigurer.getConfiguration();
            Template template = configuration.getTemplate("item.ftl");
            //创建一个输出流，指定输出目录及其文件名
            Writer writer = new FileWriter(new File(HTML_GEN_PATH+id+".html"));
            //生成静态页面
            template.process(map,writer);
            //关闭流
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
