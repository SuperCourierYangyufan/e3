package cn.e3.sso.service;

import cn.e3.common.utils.E3Result;

/**
 * Created by YangYuFan on 2018/4/20.
 */
public interface LoginService {
    //登入
    E3Result userLogin(String username,String passwrod);
}
