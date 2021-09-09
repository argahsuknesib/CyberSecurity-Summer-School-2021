package com.xiaomi.mico.music.favourite;

import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

public class FavStationFragment extends BaseFavFragment<Music.Artist> {
    /* access modifiers changed from: protected */
    public int getFavType() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public Observable<List<Music.Artist>> getInfo(final List<Object> list) {
        return Observable.create(new Observable.OnSubscribe<List<Music.Artist>>() {
            /* class com.xiaomi.mico.music.favourite.FavStationFragment.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super List<Music.Artist>>) ((Subscriber) obj));
            }

            public void call(Subscriber<? super List<Music.Artist>> subscriber) {
                subscriber.onNext(CollectionUtils.convert(list, new ArrayList()));
                subscriber.onCompleted();
            }
        });
    }
}
