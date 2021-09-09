package com.xiaomi.mico.api;

import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.api.model.MiBrain;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public class ObservableApiHelper {

    public interface ApiRequestProvider<T> {
        ApiRequest<T> getApiRequest(ApiRequest.Listener<T> listener);
    }

    private static Subscription newUnsubscribeAction(final ApiRequest apiRequest) {
        return Subscriptions.create(new Action0() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass1 */

            public final void call() {
                apiRequest.cancel();
            }
        });
    }

    public static <T> Observable<T> getObservable(ApiRequestProvider<T> apiRequestProvider) {
        return Observable.unsafeCreate(new Observable.OnSubscribe() {
            /* class com.xiaomi.mico.api.$$Lambda$ObservableApiHelper$h5LflthBpxZylep_cEAtte6KeHo */

            public final void call(Object obj) {
                ((Subscriber) obj).add(ObservableApiHelper.newUnsubscribeAction(ObservableApiHelper.ApiRequestProvider.this.getApiRequest(new ApiRequest.Listener<T>((Subscriber) obj) {
                    /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass2 */

                    public final void onSuccess(T t) {
                        if (!r2.isUnsubscribed()) {
                            r2.onNext(t);
                            r2.onCompleted();
                        }
                    }

                    public final void onFailure(ApiError apiError) {
                        if (!r2.isUnsubscribed()) {
                            r2.onError(apiError.toThrowable());
                        }
                    }
                })));
            }
        });
    }

    public static <T> Observable<T> remote(String str, String str2, String str3, String str4, Class<T> cls) {
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        final Class<T> cls2 = cls;
        return getObservable(new ApiRequestProvider<T>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass3 */

            public final ApiRequest<T> getApiRequest(ApiRequest.Listener<T> listener) {
                return ApiHelper.remote(str5, str6, str7, str8, listener, cls2);
            }
        });
    }

    public static Observable<Banner> getBanner(final int i) {
        return getObservable(new ApiRequestProvider<Banner>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass4 */

            public final ApiRequest<Banner> getApiRequest(ApiRequest.Listener<Banner> listener) {
                return ApiHelper.getBanner(i, listener);
            }
        });
    }

    public static Observable<List<Music.Section>> getSectionList() {
        return getObservable(new ApiRequestProvider<List<Music.Section>>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass5 */

            public final ApiRequest<List<Music.Section>> getApiRequest(ApiRequest.Listener<List<Music.Section>> listener) {
                return ApiHelper.getSectionList(listener);
            }
        });
    }

    public static Observable<PatchWall> getPatchWallFlow(final int i, final int i2) {
        return getObservable(new ApiRequestProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass6 */

            public final ApiRequest<PatchWall> getApiRequest(ApiRequest.Listener<PatchWall> listener) {
                return ApiHelper.getPatchWallFlow(i, i2, listener);
            }
        });
    }

    public static Observable<PatchWall> getDedaoPatchWallFlow(final int i, final int i2) {
        return getObservable(new ApiRequestProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass7 */

            public final ApiRequest<PatchWall> getApiRequest(ApiRequest.Listener<PatchWall> listener) {
                return ApiHelper.getDeDaoPathWallFlow(i, i2, listener);
            }
        });
    }

    public static Observable<MiBrain.OAuthInfo> getDedaoAuth(final String str) {
        return getObservable(new ApiRequestProvider<MiBrain.OAuthInfo>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass8 */

            public final ApiRequest<MiBrain.OAuthInfo> getApiRequest(ApiRequest.Listener<MiBrain.OAuthInfo> listener) {
                return ApiHelper.getOAuthInfo(str, listener);
            }
        });
    }

    public static Observable<PatchWall> getNovelPatchWallFlow(final int i, final int i2) {
        return getObservable(new ApiRequestProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass9 */

            public final ApiRequest<PatchWall> getApiRequest(ApiRequest.Listener<PatchWall> listener) {
                return ApiHelper.getNovelPatchWallFlow(i, i2, listener);
            }
        });
    }

    public static Observable<PatchWall> getTopQualityPatchWallFlow(final int i, final int i2) {
        return getObservable(new ApiRequestProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass10 */

            public final ApiRequest<PatchWall> getApiRequest(ApiRequest.Listener<PatchWall> listener) {
                return ApiHelper.getTopQualityPatchWallFlow(i, i2, listener);
            }
        });
    }

    public static Observable<PatchWall> getQQPatchWallFlow(final int i, final int i2) {
        return getObservable(new ApiRequestProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass11 */

            public final ApiRequest<PatchWall> getApiRequest(ApiRequest.Listener<PatchWall> listener) {
                return ApiHelper.getQQPathWallFlow(i, i2, listener);
            }
        });
    }

    public static Observable<PatchWall> getQQPatchWallFlowV2(final int i, final int i2) {
        return getObservable(new ApiRequestProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass12 */

            public final ApiRequest<PatchWall> getApiRequest(ApiRequest.Listener<PatchWall> listener) {
                return ApiHelper.getQQPathWallFlowV2(i, i2, listener);
            }
        });
    }

    public static Observable<PatchWall> getMiPatchWallFlow(final int i, final int i2) {
        return getObservable(new ApiRequestProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass13 */

            public final ApiRequest<PatchWall> getApiRequest(ApiRequest.Listener<PatchWall> listener) {
                return ApiHelper.getMiPathWallFlow(i, i2, listener);
            }
        });
    }

    public static Observable<PatchWall> getKidsPatchWallFlow(final int i, final int i2) {
        return getObservable(new ApiRequestProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass14 */

            public final ApiRequest<PatchWall> getApiRequest(ApiRequest.Listener<PatchWall> listener) {
                return ApiHelper.getKaishuFlow(i, i2, listener);
            }
        });
    }

    public static Observable<Music.Song> getSongInfo(final long j) {
        return getObservable(new ApiRequestProvider<Music.Song>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass15 */

            public final ApiRequest<Music.Song> getApiRequest(ApiRequest.Listener<Music.Song> listener) {
                return ApiHelper.getSongInfo(j, listener);
            }
        });
    }

    public static Observable<Music.Station> getStationInfo(final Music.Station.Simple simple) {
        return getObservable(new ApiRequestProvider<Music.Station>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass16 */

            public final ApiRequest<Music.Station> getApiRequest(ApiRequest.Listener<Music.Station> listener) {
                return ApiHelper.getStationInfo(simple, listener);
            }
        });
    }

    public static Observable<List<Music.Station>> getStationInfo(final List<Music.Station.Simple> list) {
        return getObservable(new ApiRequestProvider<List<Music.Station>>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass17 */

            public final ApiRequest<List<Music.Station>> getApiRequest(ApiRequest.Listener<List<Music.Station>> listener) {
                return ApiHelper.getStationInfo(list, listener);
            }
        });
    }

    public static Observable<List<Object>> getLikeList(final int i) {
        return getObservable(new ApiRequestProvider<List<Object>>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass18 */

            public final ApiRequest<List<Object>> getApiRequest(final ApiRequest.Listener<List<Object>> listener) {
                int i = i;
                return i == 4 ? ApiHelper.getStationLikeList(new ApiRequest.Listener<List<Music.Station>>() {
                    /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass18.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((List<Music.Station>) ((List) obj));
                    }

                    public void onSuccess(List<Music.Station> list) {
                        listener.onSuccess(CollectionUtils.convert(list, new ArrayList(list.size())));
                    }

                    public void onFailure(ApiError apiError) {
                        listener.onFailure(apiError);
                    }
                }) : ApiHelper.getLikeList(i, new ApiRequest.Listener<List<Long>>() {
                    /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass18.AnonymousClass2 */

                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((List<Long>) ((List) obj));
                    }

                    public void onSuccess(List<Long> list) {
                        listener.onSuccess(CollectionUtils.convert(list, new ArrayList(list.size())));
                    }

                    public void onFailure(ApiError apiError) {
                        listener.onFailure(apiError);
                    }
                });
            }
        });
    }

    public static Observable<List<Object>> getLikeList(String str) {
        return getObservable(new ApiRequestProvider(str) {
            /* class com.xiaomi.mico.api.$$Lambda$ObservableApiHelper$RW4vPnvzG9eZhoqxSZp6ZBIXNM */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final ApiRequest getApiRequest(ApiRequest.Listener listener) {
                return ApiHelper.getStationLikeList(this.f$0, new ApiRequest.Listener<List<Music.Station>>(listener) {
                    /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass19 */

                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((List<Music.Station>) ((List) obj));
                    }

                    public final void onSuccess(List<Music.Station> list) {
                        r2.onSuccess(CollectionUtils.convert(list, new ArrayList(list.size())));
                    }

                    public final void onFailure(ApiError apiError) {
                        r2.onFailure(apiError);
                    }
                });
            }
        });
    }

    public static Observable<Long> createChannel(final String str) {
        return getObservable(new ApiRequestProvider<Long>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass20 */

            public final ApiRequest<Long> getApiRequest(ApiRequest.Listener<Long> listener) {
                return ApiHelper.createChannel(str, listener);
            }
        });
    }

    public static Observable<Boolean> deleteChannel(final long j) {
        return getObservable(new ApiRequestProvider<Boolean>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass21 */

            public final ApiRequest<Boolean> getApiRequest(ApiRequest.Listener<Boolean> listener) {
                return ApiHelper.deleteChannel(j, listener);
            }
        });
    }

    public static Observable<Boolean> renameChannel(final long j, final String str) {
        return getObservable(new ApiRequestProvider<Boolean>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass22 */

            public final ApiRequest<Boolean> getApiRequest(ApiRequest.Listener<Boolean> listener) {
                return ApiHelper.renameChannel(j, str, listener);
            }
        });
    }

    public static Observable<Boolean> addSongs(final long j, final List<Music.Song> list) {
        return getObservable(new ApiRequestProvider<Boolean>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass23 */

            public final ApiRequest<Boolean> getApiRequest(ApiRequest.Listener<Boolean> listener) {
                return ApiHelper.addSongs(j, list, listener);
            }
        });
    }

    public static Observable<Boolean> deleteSongs(final long j, final List<Music.Song> list) {
        return getObservable(new ApiRequestProvider<Boolean>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass24 */

            public final ApiRequest<Boolean> getApiRequest(ApiRequest.Listener<Boolean> listener) {
                return ApiHelper.deleteSongs(j, list, listener);
            }
        });
    }

    public static Observable<Music.SongBook> getQQMusicSheetSongs(final String str, final String str2) {
        return getObservable(new ApiRequestProvider<Music.SongBook>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass25 */

            public final ApiRequest<Music.SongBook> getApiRequest(ApiRequest.Listener<Music.SongBook> listener) {
                return ApiHelper.getQQMusicSheetSongs(str, str2, listener);
            }
        });
    }

    public static Observable<List<String>> unbindDevice(final String str) {
        return getObservable(new ApiRequestProvider<List<String>>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass26 */

            public final ApiRequest<List<String>> getApiRequest(ApiRequest.Listener<List<String>> listener) {
                return ApiHelper.unbindDevice(str, listener);
            }
        });
    }

    public static Observable<String> renameDevice(final String str, final String str2) {
        return getObservable(new ApiRequestProvider<String>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass27 */

            public final ApiRequest<String> getApiRequest(ApiRequest.Listener<String> listener) {
                return ApiHelper.renameDevice(str, str2, listener);
            }
        });
    }

    public static Observable<Music.StationSoundList> getStationSoundList(String str, String str2, String str3, int i, int i2, String str4, Integer num) {
        return getObservable(new ApiRequestProvider(str, str2, str3, i, i2, str4, num) {
            /* class com.xiaomi.mico.api.$$Lambda$ObservableApiHelper$uYSmEiHxEmLzN7uYL3wI4Bwj4Q */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ int f$3;
            private final /* synthetic */ int f$4;
            private final /* synthetic */ String f$5;
            private final /* synthetic */ Integer f$6;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
            }

            public final ApiRequest getApiRequest(ApiRequest.Listener listener) {
                return ApiHelper.getStationSoundList(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, listener);
            }
        });
    }

    public static Observable<String> postStatLog(final String str) {
        return getObservable(new ApiRequestProvider<String>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass28 */

            public final ApiRequest<String> getApiRequest(ApiRequest.Listener<String> listener) {
                return ApiHelper.postStatLog(str, listener);
            }
        });
    }

    public static Observable<String> requestDecryptRc4(final String str) {
        return getObservable(new ApiRequestProvider<String>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass29 */

            public final ApiRequest<String> getApiRequest(ApiRequest.Listener<String> listener) {
                return ApiHelper.requestDecryptRc4(str, listener);
            }
        });
    }

    public static Observable<String> bindUploadedVideo(String str, String str2) {
        return getObservable(new ApiRequestProvider(str, str2) {
            /* class com.xiaomi.mico.api.$$Lambda$ObservableApiHelper$qhH4jYQv5Aldjx7f5M0k8GoWRQM */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final ApiRequest getApiRequest(ApiRequest.Listener listener) {
                return ApiHelper.bindUploadedVideo(this.f$0, this.f$1, listener);
            }
        });
    }

    public static Observable<List<Music.Song>> getSongInfoV3(final ArrayList<Long> arrayList) {
        return getObservable(new ApiRequestProvider<List<Music.Song>>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass30 */

            public final ApiRequest<List<Music.Song>> getApiRequest(ApiRequest.Listener<List<Music.Song>> listener) {
                return ApiHelper.getAudioInfoV3(arrayList, listener);
            }
        });
    }

    public static Observable<Boolean> addCollectSongV3(final String str, final String str2) {
        return getObservable(new ApiRequestProvider<Boolean>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass31 */

            public final ApiRequest<Boolean> getApiRequest(ApiRequest.Listener<Boolean> listener) {
                return ApiHelper.addCollectV3(str, str2, listener);
            }
        });
    }

    public static Observable<Boolean> delCollectSongV3(final String str, final String str2) {
        return getObservable(new ApiRequestProvider<Boolean>() {
            /* class com.xiaomi.mico.api.ObservableApiHelper.AnonymousClass32 */

            public final ApiRequest<Boolean> getApiRequest(ApiRequest.Listener<Boolean> listener) {
                return ApiHelper.delCollectV3(str, str2, listener);
            }
        });
    }
}
