package org.crazyit.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaClient
public class FirstServiceProvider {
    public static void main(String[] args) {
        //读取控制台输入作为端口参数
        Scanner scanner=new Scanner(System.in);
        String port=scanner.nextLine();
        //设置启动的服务器端口
        new SpringApplicationBuilder(FirstServiceProvider.class).properties("server.port=" + port).run(args);


    }
}
