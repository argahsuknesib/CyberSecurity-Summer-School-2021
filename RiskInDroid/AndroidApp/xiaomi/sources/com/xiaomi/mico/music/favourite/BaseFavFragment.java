package com.xiaomi.mico.music.favourite;

import com.xiaomi.mico.common.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

public abstract class BaseFavFragment<T> extends BasePersonalFragment<T> {
    /* access modifiers changed from: protected */
    public abstract Observable<List<T>> getInfo(List<Object> list);

    /* access modifiers changed from: protected */
    public Observable<List<T>> getListObservable() {
        Observable<List<Object>> observable;
        String stationType = getStationType();
        FavouriteManager instance = FavouriteManager.getInstance();
        if (stationType == null) {
            observable = instance.getLikeList(getFavType());
        } else {
            observable = instance.getLikeList(stationType);
        }
        return observable.flatMap(new Func1() {
            /* class com.xiaomi.mico.music.favourite.$$Lambda$BaseFavFragment$k6iXxUdbR3g2T_I9PjtfKzpDpw */

            public final Object call(Object obj) {
                return BaseFavFragment.this.lambda$getListObservable$0$BaseFavFragment((List) obj);
            }
        });
    }

    public /* synthetic */ Observable lambda$getListObservable$0$BaseFavFragment(List list) {
        if (list.isEmpty()) {
            return Observable.just(Collections.emptyList());
        }
        return getInfo(CollectionUtils.convert(list, new ArrayList(list.size())));
    }
}
