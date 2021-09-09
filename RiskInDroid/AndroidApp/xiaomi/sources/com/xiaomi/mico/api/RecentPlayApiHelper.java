package com.xiaomi.mico.api;

import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.music.cache.MusicCache;
import com.xiaomi.mico.music.player.PlayerManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import rx.Observable;

public class RecentPlayApiHelper {
    public static ApiRequest getRecentPlay(final ApiRequest.Listener<List<Long>> listener) {
        if (MicoManager.getInstance().currentMicoIsAiProtocolV3()) {
            return ApiHelper.getHistoryV3(listener);
        }
        return PlayerManager.getInstance().getRecent(new ApiRequest.Listener<Remote.Response.Recent>() {
            /* class com.xiaomi.mico.api.RecentPlayApiHelper.AnonymousClass1 */

            public final void onSuccess(Remote.Response.Recent recent) {
                listener.onSuccess(recent.track_list);
            }

            public final void onFailure(ApiError apiError) {
                if (apiError.getCode() == 1) {
                    listener.onSuccess(new ArrayList());
                } else {
                    listener.onFailure(apiError);
                }
            }
        });
    }

    public static Observable<List<Music.Song>> getRecentPlayListObservable() {
        return ObservableApiHelper.getObservable($$Lambda$hoI0DZ8RWY_OE2dVLSfHevBHk7A.INSTANCE).flatMap($$Lambda$RecentPlayApiHelper$tQTtUC13PLcoAcOAmu5iwJB4tug.INSTANCE);
    }

    static /* synthetic */ Observable lambda$getRecentPlayListObservable$0(List list) {
        if (ContainerUtil.isEmpty(list)) {
            return Observable.just(new ArrayList());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            if (l.longValue() != 0) {
                linkedHashSet.add(l);
            }
        }
        return MusicCache.getSongs(new ArrayList(linkedHashSet));
    }

    public static Observable<List<Music.Station>> getRecentPlayAudioBookObservable(String str) {
        return ObservableApiHelper.getObservable(new ObservableApiHelper.ApiRequestProvider(str) {
            /* class com.xiaomi.mico.api.$$Lambda$RecentPlayApiHelper$6L89MqUuNLam0zQLoPLV9_DzwQ8 */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final ApiRequest getApiRequest(ApiRequest.Listener listener) {
                return ApiHelper.getHistory(MicoManager.getInstance().getCurrentMico().hardware, 50, this.f$0, listener);
            }
        });
    }
}
