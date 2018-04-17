package cn.e3.search.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YangYuFan on 2018/4/17.
 */
public class GlobalException implements HandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //打印控制
        ex.printStackTrace();
        //写日志
        logger.error("系统发生异常",ex);
        //联系人
        //jmail工具包
        //展示错误页面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/exception");
        return modelAndView;
    }
}
