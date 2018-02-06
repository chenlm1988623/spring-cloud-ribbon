package org.crazyit.cloud.config;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import org.crazyit.cloud.util.MyPing;
import org.crazyit.cloud.util.MyRule;
import org.springframework.context.annotation.Bean;

public class MyConfig {
    @Bean
    public IRule getRule(){
        return new MyRule();
    }
    public IPing getPing(){
        return new MyPing();
    }
}
