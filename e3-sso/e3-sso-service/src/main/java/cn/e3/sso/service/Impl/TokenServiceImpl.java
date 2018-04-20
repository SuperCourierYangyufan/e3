package cn.e3.sso.service.Impl;

import cn.e3.common.jedis.JedisClient;
import cn.e3.common.utils.E3Result;
import cn.e3.common.utils.JsonUtils;
import cn.e3.pojo.TbUser;
import cn.e3.sso.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by YangYuFan on 2018/4/20.
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private JedisClient jedisClient;

    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    //根据用户取用户信息
    @Override
    public E3Result getUserByToken(String token) {
        String json = jedisClient.get("SESSION:"+token);
        //判断是否过期
        if(StringUtils.isBlank(json)){
            return E3Result.build(201,"用户登入已经过期");
        }
        //根性token过期时间
        TbUser tbUser = JsonUtils.jsonToPojo(json, TbUser.class);
        jedisClient.expire("SESSION:"+token,SESSION_EXPIRE);
        //返回结果，包含TbUser
        return E3Result.ok(tbUser);
    }
}
