package cn.e3.sso.controller;

import cn.e3.common.utils.E3Result;
import cn.e3.common.utils.JsonUtils;
import cn.e3.sso.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by YangYuFan on 2018/4/20.
 * 根据用户查询用户信息
 */
@Controller
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/user/token/{token}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String getUserBytoken(@PathVariable String  token,String callback){
        E3Result userByToken = tokenService.getUserByToken(token);
        //响应结果之前 判断是否为jsonp请求
        if(StringUtils.isNotBlank(callback)){
            //把结果封装成js语句
            return callback+"("+ JsonUtils.objectToJson(userByToken)+");";

//            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userByToken);
//            mappingJacksonValue.setJsonpFunction(callback);
//            return mappingJacksonValue; //spring4.1可使用这种方式，返回类型为Object
        }
        return JsonUtils.objectToJson(userByToken);
    }
}
