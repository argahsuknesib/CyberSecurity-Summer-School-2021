package com.xiaomi.idm.tap.dispatcher.impl;

import _m_j.dww;
import android.content.Context;
import com.xiaomi.idm.tap.dispatcher.ActionExecutor;
import com.xiaomi.idm.tap.dispatcher.ExecutorFactory;

public class DefaultExecutorFactory implements ExecutorFactory {
    private static final String TAG = "DefaultExecutorFactory";

    public ActionExecutor createExecutor(Context context, int i, dww dww) {
        if (i != 12) {
            return null;
        }
        return new EmptyNfcTagExecutor(context);
    }
}
