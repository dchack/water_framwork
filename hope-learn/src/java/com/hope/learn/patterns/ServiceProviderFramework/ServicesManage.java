package com.hope.learn.patterns.ServiceProviderFramework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hope on 2017/12/15.
 * 提供者注册API 系统用来注册实现
 */
public class ServicesManage {
    private ServicesManage() {} // Prevents instantiation (Item 4)

    // Maps service names to services
    private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    // Provider registration API
    // 提供者注册API
    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    // Service access API
    // 服务访问API
    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }
    // 服务访问API
    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (p == null)
            throw new IllegalArgumentException("No provider registered with name: " + name);
        return p.newService();
    }
}
