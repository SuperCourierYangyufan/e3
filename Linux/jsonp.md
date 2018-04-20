#登入注册问题（session,json等跨域问题）
<br>
session跨域解决办法：<br>
    1.将session自生成，放入redis中<br>
    2.key为uuid，而value为用户信息<br>
    3.需要设置过期时间<br>
    4.在表现层放入cookie中<br>
        =》工具包： https://github.com/SuperCourierYangyufan/e3/blob/master/e3-common/src/main/java/cn/e3/common/utils/CookieUtils.java<br>
    5.代码：<br>
        =》service  https://github.com/SuperCourierYangyufan/e3/blob/master/e3-sso/e3-sso-                         service/src/main/java/cn/e3/sso/service/Impl/LoginServiceImpl.java<br>
        =》web      https://github.com/SuperCourierYangyufan/e3/blob/master/e3-sso-web/src/main/java/cn/e3/sso/controller/LoginController.java<br>
        
    
json跨域解决 =》jsonp<br>
    1.采用ajax动态从单点登入系统中获取用户状态<br>
        =》js  https://github.com/SuperCourierYangyufan/e3/blob/master/e3-portal-web/src/main/webapp/js/e3mall.js<br>
            =>注意：获取session是通过jquery.cookie.js帮助<br>
                  ：type:jsonp （单纯的json并不能跨域）<br>
    2.表现层代码：https://github.com/SuperCourierYangyufan/e3/blob/master/e3-sso-web/src/main/java/cn/e3/sso/controller/TokenController.java<br>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
