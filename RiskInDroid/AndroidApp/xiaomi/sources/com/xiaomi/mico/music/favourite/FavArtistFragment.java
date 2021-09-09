package com.xiaomi.mico.music.favourite;

import _m_j.gsy;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

public class FavArtistFragment extends BaseFavFragment<Music.Artist> {
    /* access modifiers changed from: protected */
    public int getFavType() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public Observable<List<Music.Artist>> getInfo(final List<Object> list) {
        return Observable.unsafeCreate(new Observable.OnSubscribe<List<Music.Artist>>() {
            /* class com.xiaomi.mico.music.favourite.FavArtistFragment.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super List<Music.Artist>>) ((Subscriber) obj));
            }

            public void call(final Subscriber<? super List<Music.Artist>> subscriber) {
                ApiHelper.getArtistInfo(CollectionUtils.convert(list, new ArrayList()), new ApiRequest.Listener<List<Music.Artist>>() {
                    /* class com.xiaomi.mico.music.favourite.FavArtistFragment.AnonymousClass1.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((List<Music.Artist>) ((List) obj));
                    }

                    public void onSuccess(List<Music.Artist> list) {
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onNext(list);
                            subscriber.onCompleted();
                        }
                    }

                    public void onFailure(ApiError apiError) {
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onError(apiError.toThrowable());
                        }
                        gsy.O00000Oo(12000, "12000.4.3", "remote fav artist fail");
                    }
                });
            }
        });
    }
}
