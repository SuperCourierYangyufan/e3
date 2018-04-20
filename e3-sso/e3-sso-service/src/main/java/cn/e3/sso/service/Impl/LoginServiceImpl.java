package cn.e3.sso.service.Impl;

import cn.e3.common.jedis.JedisClient;
import cn.e3.common.utils.E3Result;
import cn.e3.common.utils.JsonUtils;
import cn.e3.mapper.TbUserMapper;
import cn.e3.pojo.TbUser;
import cn.e3.pojo.TbUserExample;
import cn.e3.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

/**
 * Created by YangYuFan on 2018/4/20.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public E3Result userLogin(String username, String passwrod) {
        //判断用户
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);

        List<TbUser> users = tbUserMapper.selectByExample(tbUserExample);
        if(users==null&&users.size()==0){
            //错误
            return E3Result.build(400,"用户名或密码错误");
        }

        //密码
        TbUser tbUser = users.get(0);
        String md5 = DigestUtils.md5DigestAsHex(passwrod.getBytes());
        if(!(md5.equals(tbUser.getPassword()))){
            return E3Result.build(400,"用户名或密码错误");
        }

//        --------------------------------------登入成功--------------------------------------------
        //生产token
        String token = UUID.randomUUID().toString();
        //存入redis
        tbUser.setPassword(null); //清空密码
        jedisClient.set("SESSION:"+token, JsonUtils.objectToJson(tbUser));
        jedisClient.expire("SESSION:"+token,SESSION_EXPIRE);
//        -------------------------------------写入session完毕------------------------------------------
        return E3Result.ok(token);
    }
}
