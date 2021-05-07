package com.snow;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyValve
 * @Author snow
 * @Date 2020/7/21 10:15
 */
public class MyValve extends ValveBase {

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        HttpServletResponse httpResponse = response.getResponse();
        httpResponse.setHeader("Content-Security-Policy", "default-src 'self' 'unsafe-inline' *.jxsycm.com *.qq.com;" +
                "script-src 'self' 'unsafe-inline' 'unsafe-eval' *.baidu.com *.baomitu.com *.qq.com;" +
                "script-src-elem 'self' 'unsafe-inline' 'unsafe-eval' *.baidu.com *.alicdn.com *.baomitu.com *.qq.com;" +
                "style-src-elem 'self' 'unsafe-inline' 'unsafe-eval' *.alicdn.com *.baomitu.com;" +
                "img-src 'self' *.baidu.com *.jxsycm.com data: blob: *.qq.com qzonestyle.gtimg.cn qzapp.qlogo.cn;" +
                "font-src 'self' data: *.jxsycm.com *.alicdn.com *.baomitu.com;" +
                "frame-src 'self' *.jxsycm.com *.qq.com;" +
                "frame-ancestors 'self' *.jxsycm.com *.qq.com;");
        httpResponse.setHeader("Access-Control-Allow-Origin","*");
        getNext().invoke(request, response);
    }
}
