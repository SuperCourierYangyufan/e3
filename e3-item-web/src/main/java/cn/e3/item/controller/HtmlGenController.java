package cn.e3.item.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成静态页面
 * Created by YangYuFan on 2018/4/19.
 */
@Controller
public class HtmlGenController {
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;



    @RequestMapping("/genhtml")
    @ResponseBody
    public String genHtml() throws Exception{
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        //加载模板
        Template template = configuration.getTemplate("hello.ftl");
        //创建数据集
        Map map = new HashMap<>();
        map.put("hello","123456");
        //指定文件输出的路径及文件名
        Writer writer = new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\hello.html"));
        //输出
        template.process(map,writer);
        //关闭流
        writer.close();

        return "ok";
    }

}
