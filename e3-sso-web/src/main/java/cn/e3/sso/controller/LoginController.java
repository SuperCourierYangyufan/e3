package cn.e3.sso.controller;

import cn.e3.common.utils.CookieUtils;
import cn.e3.common.utils.E3Result;
import cn.e3.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**登入
 * Created by YangYuFan on 2018/4/20.
 */
@Controller
public class LoginController {

    @RequestMapping("/page/login")
    public String showLogin(){
        return "login";
    }

    @Autowired
    private LoginService loginService;

    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @ResponseBody
    public E3Result login(String username, String password, HttpServletRequest request, HttpServletResponse response){
        E3Result e3Result = loginService.userLogin(username, password);
        //是否登入成功
        if(e3Result.getStatus()==200){
            String token = e3Result.getData().toString();
            //写入cookie
            CookieUtils.setCookie(request,response,TOKEN_KEY,token);
        }
        return e3Result;
    }
}
