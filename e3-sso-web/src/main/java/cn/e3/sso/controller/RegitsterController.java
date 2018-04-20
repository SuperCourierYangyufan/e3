package cn.e3.sso.controller;

import cn.e3.common.utils.E3Result;
import cn.e3.pojo.TbUser;
import cn.e3.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 注册
 * Created by YangYuFan on 2018/4/19.
 */
@Controller
public class RegitsterController {

    @RequestMapping("/page/register")
    public String showRegister(){
        return "register";
    }


    @Autowired
    private RegisterService registerService;

    @RequestMapping("/user/check/{param}/{type}")
    @ResponseBody
    public E3Result checkData(@PathVariable String param,@PathVariable Integer type){
        E3Result e3Result = registerService.checkData(param, type);
        return e3Result;
    }

    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    @ResponseBody
    public E3Result register(TbUser tbUser){
        E3Result result = registerService.register(tbUser);
        return result;
    }

}
