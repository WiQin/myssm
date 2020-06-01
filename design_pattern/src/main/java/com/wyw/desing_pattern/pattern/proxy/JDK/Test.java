package com.wyw.desing_pattern.pattern.proxy.JDK;

public class Test {
    public static void main(String[] args) {
        JDKProxyExample jdk = new JDKProxyExample();
        //绑定关系，因为挂在接口JDKProxyService下，所以声明代理对象JDKProxyServiceImpl
        JDKProxyService proxy = (JDKProxyService)jdk.bind(new JDKProxyServiceImpl());
        //此时的proxy为代理对象，它会进入代理的逻辑方法invoke里
        proxy.sayHello();
    }
}
