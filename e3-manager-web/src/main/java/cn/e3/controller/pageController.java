package cn.e3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YangYuFan on 2018/4/6.
 * 页面跳转
 */
@Controller
public class pageController {

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }


    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }


}
