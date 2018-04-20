package cn.e3.sso.service.Impl;

import cn.e3.common.utils.E3Result;
import cn.e3.mapper.TbUserMapper;
import cn.e3.pojo.TbUser;
import cn.e3.pojo.TbUserExample;
import cn.e3.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by YangYuFan on 2018/4/20.
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public E3Result checkData(String param, int type) {
        //根据 不同type查询不同条件
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        if(type == 1){
            criteria.andUsernameEqualTo(param);
        }else if(type ==2){
            criteria.andPhoneEqualTo(param);
        }else if(type == 3){
            criteria.andEmailEqualTo(param);
        }else{
            return E3Result.build(400,"数据类型错误");
        }
        //查询
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
        //判断结果是否包含数据
        if(tbUsers!=null&&tbUsers.size()>0){
            return E3Result.ok(false);
        }
        //有数据false 没有 true
        return E3Result.ok(true);
    }

    @Override
    public E3Result register(TbUser tbUser) {
        //数据有效性校验
        if("".equals(tbUser.getUsername())||"".equals(tbUser.getPassword())||"".equals(tbUser.getPhone())){
            return E3Result.build(400,"用户数据不完整，注册失败");//StringUtils.isBlank(tbUser.getUsername)
        }
        E3Result e3Result = checkData(tbUser.getUsername(), 1);
        if(!(boolean)e3Result.getData()){
            return e3Result.build(400,"用户名被占用");
        }
        e3Result = checkData(tbUser.getPhone(),2);
        if(!(boolean)e3Result.getData()){
            return e3Result.build(400,"手机号被占用");
        }
        //补充user属性
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());
        //对password md5加密
        String md5password = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());
        tbUser.setPassword(md5password);
        //插入
        tbUserMapper.insert(tbUser);
        //返回
        return E3Result.ok();
    }
}
