package com.xiaomi.mico.music.cache;

import android.util.LongSparseArray;
import android.util.LruCache;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class MusicCache {
    private static LruCache<Long, Music.Song> sLruCache = new LruCache<>(100);

    public static void addSong(Music.Song song) {
        sLruCache.put(Long.valueOf(song.songID), song);
    }

    public static void addSongs(List<Music.Song> list) {
        if (list != null && !list.isEmpty()) {
            for (Music.Song next : list) {
                sLruCache.put(Long.valueOf(next.songID), next);
            }
        }
    }

    public static Observable<Music.Song> getSong(long j) {
        Music.Song song = sLruCache.get(Long.valueOf(j));
        if (song != null) {
            return Observable.just(song);
        }
        if (!MicoManager.getInstance().currentMicoIsAiProtocolV3()) {
            return ObservableApiHelper.getSongInfo(j).map(new Func1<Music.Song, Music.Song>() {
                /* class com.xiaomi.mico.music.cache.MusicCache.AnonymousClass1 */

                public final Music.Song call(Music.Song song) {
                    MusicCache.addSong(song);
                    return song;
                }
            });
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        return ObservableApiHelper.getSongInfoV3(arrayList).map($$Lambda$MusicCache$pHfpk2KAj_dBSA2VJ1bf19SpiL4.INSTANCE);
    }

    static /* synthetic */ Music.Song lambda$getSong$0(List list) {
        Music.Song song = (Music.Song) list.get(0);
        addSong(song);
        return song;
    }

    public static Observable<List<Music.Song>> getSongs(final List<Long> list) {
        Observable observable;
        final LongSparseArray longSparseArray = new LongSparseArray(list.size());
        final ArrayList arrayList = new ArrayList();
        for (Long next : list) {
            Music.Song song = sLruCache.get(next);
            if (song != null) {
                longSparseArray.put(song.songID, song);
            } else {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            observable = Observable.just(longSparseArray);
        } else {
            observable = Observable.create(new Observable.OnSubscribe<LongSparseArray<Music.Song>>() {
                /* class com.xiaomi.mico.music.cache.MusicCache.AnonymousClass2 */

                public final /* bridge */ /* synthetic */ void call(Object obj) {
                    call((Subscriber<? super LongSparseArray<Music.Song>>) ((Subscriber) obj));
                }

                public final void call(final Subscriber<? super LongSparseArray<Music.Song>> subscriber) {
                    ApiHelper.getSongInfo(arrayList, new ApiRequest.Listener<List<Music.Song>>() {
                        /* class com.xiaomi.mico.music.cache.MusicCache.AnonymousClass2.AnonymousClass1 */

                        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                            onSuccess((List<Music.Song>) ((List) obj));
                        }

                        public void onSuccess(List<Music.Song> list) {
                            MusicCache.addSongs(list);
                            if (!subscriber.isUnsubscribed()) {
                                for (Music.Song next : list) {
                                    longSparseArray.put(next.songID, next);
                                }
                                subscriber.onNext(longSparseArray);
                                subscriber.onCompleted();
                            }
                        }

                        public void onFailure(ApiError apiError) {
                            if (subscriber.isUnsubscribed()) {
                                return;
                            }
                            if (longSparseArray.size() > 0) {
                                subscriber.onNext(longSparseArray);
                                subscriber.onCompleted();
                                return;
                            }
                            subscriber.onError(apiError.toThrowable());
                        }
                    });
                }
            });
        }
        return observable.map(new Func1<LongSparseArray<Music.Song>, List<Music.Song>>() {
            /* class com.xiaomi.mico.music.cache.MusicCache.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ Object call(Object obj) {
                return call((LongSparseArray<Music.Song>) ((LongSparseArray) obj));
            }

            public final List<Music.Song> call(LongSparseArray<Music.Song> longSparseArray) {
                ArrayList arrayList = new ArrayList(longSparseArray.size());
                for (Long longValue : list) {
                    Music.Song song = longSparseArray.get(longValue.longValue());
                    if (song != null) {
                        arrayList.add(song);
                    }
                }
                return arrayList;
            }
        });
    }

    public static Observable<List<Music.Song>> getSongsV3(final List<Long> list) {
        Observable observable;
        final LongSparseArray longSparseArray = new LongSparseArray(list.size());
        final ArrayList arrayList = new ArrayList();
        for (Long next : list) {
            Music.Song song = sLruCache.get(next);
            if (song != null) {
                longSparseArray.put(Long.parseLong(song.audioID), song);
            } else {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            new Object[1][0] = "MusicCache getSongsV3 unknownIDList is Empty";
            observable = Observable.just(longSparseArray);
        } else {
            observable = Observable.create(new Observable.OnSubscribe<LongSparseArray<Music.Song>>() {
                /* class com.xiaomi.mico.music.cache.MusicCache.AnonymousClass4 */

                public final /* bridge */ /* synthetic */ void call(Object obj) {
                    call((Subscriber<? super LongSparseArray<Music.Song>>) ((Subscriber) obj));
                }

                public final void call(final Subscriber<? super LongSparseArray<Music.Song>> subscriber) {
                    ApiHelper.getAudioInfoV3(arrayList, new ApiRequest.Listener<List<Music.Song>>() {
                        /* class com.xiaomi.mico.music.cache.MusicCache.AnonymousClass4.AnonymousClass1 */

                        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                            onSuccess((List<Music.Song>) ((List) obj));
                        }

                        public void onSuccess(List<Music.Song> list) {
                            MusicCache.addSongs(list);
                            if (!subscriber.isUnsubscribed()) {
                                for (Music.Song next : list) {
                                    longSparseArray.put(Long.parseLong(next.audioID), next);
                                }
                                subscriber.onNext(longSparseArray);
                                subscriber.onCompleted();
                            }
                        }

                        public void onFailure(ApiError apiError) {
                            if (subscriber.isUnsubscribed()) {
                                return;
                            }
                            if (longSparseArray.size() > 0) {
                                subscriber.onNext(longSparseArray);
                                subscriber.onCompleted();
                                return;
                            }
                            subscriber.onError(apiError.toThrowable());
                        }
                    });
                }
            });
        }
        return observable.map(new Func1<LongSparseArray<Music.Song>, List<Music.Song>>() {
            /* class com.xiaomi.mico.music.cache.MusicCache.AnonymousClass5 */

            public final /* bridge */ /* synthetic */ Object call(Object obj) {
                return call((LongSparseArray<Music.Song>) ((LongSparseArray) obj));
            }

            public final List<Music.Song> call(LongSparseArray<Music.Song> longSparseArray) {
                new Object[1][0] = "MusicCache getSongsV3 result songMapSize =" + longSparseArray.size() + " songIDListSize=" + list.size();
                ArrayList arrayList = new ArrayList(longSparseArray.size());
                for (Long longValue : list) {
                    Music.Song song = longSparseArray.get(longValue.longValue());
                    if (song != null) {
                        arrayList.add(song);
                    } else {
                        Music.Song song2 = new Music.Song();
                        song2.name = CommonApplication.getAppContext().getString(R.string.mico_music_directive_default_title);
                        arrayList.add(song2);
                    }
                }
                return arrayList;
            }
        });
    }

    public static void clearCache() {
        sLruCache.evictAll();
    }
}
