package com.xiaomi.mico.setting.address;

import android.content.Context;
import java.io.Serializable;
import java.util.List;
import rx.Observable;

public interface IPOIProvider {
    POIInfoWrapper getWrapper(Serializable serializable);

    Observable<List<POIInfoWrapper>> search(Context context, String str, String str2);
}
