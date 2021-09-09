package _m_j;

import com.xiaomi.smarthome.core.entity.Error;

public interface fdh<R, E extends Error> {
    void onFailure(Error error);

    void onSuccess(Object obj);
}
