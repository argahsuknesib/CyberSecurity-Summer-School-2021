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

public class FavAlbumFragment extends BaseFavFragment<Music.Album> {
    /* access modifiers changed from: protected */
    public int getFavType() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public Observable<List<Music.Album>> getInfo(final List<Object> list) {
        return Observable.create(new Observable.OnSubscribe<List<Music.Album>>() {
            /* class com.xiaomi.mico.music.favourite.FavAlbumFragment.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super List<Music.Album>>) ((Subscriber) obj));
            }

            public void call(final Subscriber<? super List<Music.Album>> subscriber) {
                List list = list;
                ApiHelper.getAlbumInfo(CollectionUtils.convert(list, new ArrayList(list.size())), new ApiRequest.Listener<List<Music.Album>>() {
                    /* class com.xiaomi.mico.music.favourite.FavAlbumFragment.AnonymousClass1.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((List<Music.Album>) ((List) obj));
                    }

                    public void onSuccess(List<Music.Album> list) {
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onNext(list);
                            subscriber.onCompleted();
                        }
                    }

                    public void onFailure(ApiError apiError) {
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onError(apiError.toThrowable());
                        }
                        gsy.O00000Oo(12000, "12000.4.3", "remote fav album fail");
                    }
                });
            }
        });
    }
}
