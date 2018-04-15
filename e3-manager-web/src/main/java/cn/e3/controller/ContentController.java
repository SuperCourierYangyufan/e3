package cn.e3.controller;

import cn.e3.common.utils.E3Result;
import cn.e3.content.service.ContentService;
import cn.e3.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by YangYuFan on 2018/4/9.
 */
@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value="/content/save",method = RequestMethod.POST)
    @ResponseBody
    public E3Result addContent(TbContent content){
        E3Result e3Result = contentService.addContent(content);
        return e3Result;
    }

}
