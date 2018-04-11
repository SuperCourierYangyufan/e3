package cn.e3portal.controller;

import cn.e3.content.service.ContentService;
import cn.e3.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by YangYuFan on 2018/4/8.
 * 首页展示
 */
@Controller
public class IndexController {

    @Autowired
    private ContentService contentService;

    @Value("${CONTENT_LUOBO}")
    private Long CONTENT_LUOBO;
    //首页展示
    @RequestMapping("/index")
    public ModelAndView showIndex(ModelAndView modelAndView){
        //首页内容列表
        List<TbContent> ad1List = contentService.getContentListByCid(CONTENT_LUOBO);
        modelAndView.setViewName("index");
        modelAndView.addObject("ad1List",ad1List);
        return modelAndView;
    }
}
