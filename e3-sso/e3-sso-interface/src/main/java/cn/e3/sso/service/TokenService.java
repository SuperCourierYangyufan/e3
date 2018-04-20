package cn.e3.sso.service;

import cn.e3.common.utils.E3Result;

/**
 * Created by YangYuFan on 2018/4/20.
 * 根据token查询用户信息
 */
public interface TokenService {
    E3Result getUserByToken(String token);
}
