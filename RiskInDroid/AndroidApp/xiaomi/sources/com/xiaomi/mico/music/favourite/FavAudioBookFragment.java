package com.xiaomi.mico.music.favourite;

import _m_j.gsy;
import android.os.Bundle;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

public class FavAudioBookFragment extends BaseFavFragment<Music.Station> {
    /* access modifiers changed from: protected */
    public int getFavType() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public String getStationType() {
        return "all";
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    /* access modifiers changed from: protected */
    public Observable<List<Music.Station>> getInfo(List<Object> list) {
        return Observable.create(new Observable.OnSubscribe(list) {
            /* class com.xiaomi.mico.music.favourite.$$Lambda$FavAudioBookFragment$XWJiNpRLe_Tn3OCDWFaspoNRBEI */
            private final /* synthetic */ List f$0;

            {
                this.f$0 = r1;
            }

            public final void call(Object obj) {
                FavAudioBookFragment.lambda$getInfo$0(this.f$0, (Subscriber) obj);
            }
        });
    }

    static /* synthetic */ void lambda$getInfo$0(List list, Subscriber subscriber) {
        subscriber.onNext(CollectionUtils.convert(list, new ArrayList()));
        subscriber.onCompleted();
    }

    /* access modifiers changed from: protected */
    public void handleFetchFailed() {
        super.handleFetchFailed();
        gsy.O00000Oo(12000, "12000.4.3", "remote fav audio fail");
    }
}
