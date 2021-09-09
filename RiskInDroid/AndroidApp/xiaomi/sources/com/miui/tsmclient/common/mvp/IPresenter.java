package com.miui.tsmclient.common.mvp;

import android.content.Context;
import android.os.Bundle;
import com.miui.tsmclient.common.mvp.IView;
import java.io.Serializable;

public interface IPresenter<T extends IView> extends Serializable {
    void attach(T t);

    void detach();

    void init(Context context, Bundle bundle);

    void release();

    void subscribe(IModel iModel);

    void unsubscribe(IModel iModel);
}
