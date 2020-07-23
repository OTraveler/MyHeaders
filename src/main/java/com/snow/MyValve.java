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
        httpResponse.setHeader("Content-Security-Policy", "default-src 'self' 'unsafe-inline' *.gacycu.cn *.eol.cn *.alicdn.com;" +
                "script-src 'self' 'unsafe-inline' 'unsafe-eval' *.baidu.com  *.bdimg.com *.eol.cn;" +
                "script-src-elem 'self' 'unsafe-inline' 'unsafe-eval' *.baidu.com  *.bdimg.com *.eol.cn;" +
                "img-src 'self' *.baidu.com *.bdimg.com *.eol.cn *.gacycu.cn data: blob:;" +
                "font-src 'self' data: *.alicdn.com *.gacycu.cn;" +
                "frame-ancestors 'self';");
        getNext().invoke(request, response);
    }
}
