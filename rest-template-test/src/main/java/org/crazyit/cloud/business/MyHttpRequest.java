package org.crazyit.cloud.business;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 自定义的请求类，用于转换URI
 */
public class MyHttpRequest implements HttpRequest {

    private HttpRequest sourceRequest;

    public MyHttpRequest(HttpRequest sourceRequest){
        this.sourceRequest=sourceRequest;
    }
    @Override
    public HttpMethod getMethod() {
        return sourceRequest.getMethod();
    }
    /**
     * 将URI转换
     * @return
     */
    @Override
    public URI getURI() {
        System.out.println("转换URI开始。。。。。。。。。。。。");
        try {
            String oldUri=sourceRequest.getURI().toString();
            URI newUri=new URI("http://localhost:8080/hello");
            return newUri;
        } catch (Exception e) {
            System.out.println(e.getMessage()+":异常信息");
            e.printStackTrace();
        }
        return sourceRequest.getURI();
    }


    @Override
    public HttpHeaders getHeaders() {

        return sourceRequest.getHeaders();
    }
}
