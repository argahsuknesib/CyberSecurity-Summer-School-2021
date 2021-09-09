package com.xiaomi.idm.tap.dispatcher;

import _m_j.dww;
import android.content.Context;

public interface ExecutorFactory {
    ActionExecutor createExecutor(Context context, int i, dww dww);
}
