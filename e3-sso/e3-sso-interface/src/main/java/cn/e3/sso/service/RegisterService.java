package cn.e3.sso.service;

import cn.e3.common.utils.E3Result;
import cn.e3.pojo.TbUser;

/**
 * Created by YangYuFan on 2018/4/20.
 */
public interface RegisterService {
    //检验用户名或电话是否存在
    E3Result checkData(String param,int type);

    //注册
    E3Result register(TbUser tbUser);
}
