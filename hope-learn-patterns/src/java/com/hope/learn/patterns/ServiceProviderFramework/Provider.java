package com.hope.learn.patterns.ServiceProviderFramework;

/**
 * Created by dongchao on 2017/12/15.
 * 服务提供者接口 提供者负责创建其服务实现的实例
 */
public interface Provider {
    Service newService();
}
