package com.xiaomi.mico.music.favourite;

import android.os.Bundle;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

public class FavStationFragmentV2 extends BaseFavFragment<Music.Station> {
    private String pageType;

    /* access modifiers changed from: protected */
    public int getFavType() {
        return 4;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getArguments() != null) {
            this.pageType = (String) getArguments().get("PAGE_TYPE");
        }
    }

    /* access modifiers changed from: protected */
    public String getStationType() {
        return this.pageType;
    }

    /* access modifiers changed from: protected */
    public Observable<List<Music.Station>> getInfo(List<Object> list) {
        return Observable.create(new Observable.OnSubscribe(list) {
            /* class com.xiaomi.mico.music.favourite.$$Lambda$FavStationFragmentV2$r1Imaq6bZCHnYTJuwLxkPZsux0 */
            private final /* synthetic */ List f$0;

            {
                this.f$0 = r1;
            }

            public final void call(Object obj) {
                FavStationFragmentV2.lambda$getInfo$0(this.f$0, (Subscriber) obj);
            }
        });
    }

    static /* synthetic */ void lambda$getInfo$0(List list, Subscriber subscriber) {
        subscriber.onNext(CollectionUtils.convert(list, new ArrayList()));
        subscriber.onCompleted();
    }
}
