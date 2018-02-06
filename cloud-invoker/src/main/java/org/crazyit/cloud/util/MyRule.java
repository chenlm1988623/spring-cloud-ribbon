package org.crazyit.cloud.util;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRule implements IRule {

    private  ILoadBalancer iLoadBalancer;
    @Override
    public Server choose(Object o) {
        List<Server> servers=iLoadBalancer.getAllServers();
        System.out.println("这是自定义服务器定规则类，输出服务器信息：");
        for(Server server:servers){
            System.out.println("****"+server.getHostPort());
        }
        return servers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.iLoadBalancer=iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.iLoadBalancer;
    }
}
