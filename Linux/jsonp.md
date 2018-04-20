#登入注册问题（session,json等跨域问题）
<p>
session跨域解决办法：
    1.将session自生成，放入redis中
    2.key为uuid，而value为用户信息
    3.需要设置过期时间
    4.在表现层放入cookie中
        =》工具包： https://github.com/SuperCourierYangyufan/e3/blob/master/e3-common/src/main/java/cn/e3/common/utils/CookieUtils.java
    
    代码：
        =》service  https://github.com/SuperCourierYangyufan/e3/blob/master/e3-sso/e3-sso-service/src/main/java/cn/e3/sso/service/Impl/LoginServiceImpl.java
        =》web      https://github.com/SuperCourierYangyufan/e3/blob/master/e3-sso-web/src/main/java/cn/e3/sso/controller/LoginController.java
        
    
json跨域解决 =》jsonp
    1.采用ajax动态从单点登入系统中获取用户状态
        =》js  https://github.com/SuperCourierYangyufan/e3/blob/master/e3-portal-web/src/main/webapp/js/e3mall.js
            =>注意：获取session是通过jquery.cookie.js帮助
                  ：type:jsonp （单纯的json并不难跨域）
    2.表现层代码：https://github.com/SuperCourierYangyufan/e3/blob/master/e3-sso-web/src/main/java/cn/e3/sso/controller/TokenController.java
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     <p/>
