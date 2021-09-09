package com.mibi.sdk.mvp;

import android.content.Context;
import android.os.Bundle;

public interface IPresenter {
    void attach(IView iView);

    void detach();

    Context getContext();

    String getId();

    void handleResult(int i, int i2, Bundle bundle);

    void init(Context context, Bundle bundle, Bundle bundle2);

    void pause();

    void release();

    void resume(IView iView);

    void save(Bundle bundle);
}
