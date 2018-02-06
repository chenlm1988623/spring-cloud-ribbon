package org.crazyit.cloud.interceptor;

import org.crazyit.cloud.business.MyHttpRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * 自定义拦截器
 */
public class MyInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        System.out.println("=========== 这是自定义拦截器实现");
        System.out.println("   原来的URI："+httpRequest.getURI());
        //换成新的请求对象(更换URI)
        MyHttpRequest myHttpRequest=new MyHttpRequest(httpRequest);
        System.out.println("拦截后httpRequest新的URI："+httpRequest.getURI());
        return clientHttpRequestExecution.execute(myHttpRequest,bytes);
    }
}
