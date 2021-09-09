package com.hzy.tvmao.interf;

public interface IRequestResult<T> {
    void onFail(Integer num, String str);

    void onSuccess(String str, T t);
}
