package com.sankuai.waimai.router.exception;

public class DefaultServiceException extends RuntimeException {
    public DefaultServiceException(String str) {
        super(str);
    }

    public static DefaultServiceException foundMoreThanOneImpl(Class cls) {
        return new DefaultServiceException("因为" + cls.getCanonicalName() + "有多个实现类,Router无法决定默认使用哪个来构造实例;你可以通过@RouterService的defaultImpl参数设置一个默认的实现类");
    }
}
