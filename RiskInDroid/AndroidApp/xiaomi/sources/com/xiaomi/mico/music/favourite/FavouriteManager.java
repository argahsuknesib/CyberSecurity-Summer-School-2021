package com.xiaomi.mico.music.favourite;

import _m_j.gsy;
import android.text.TextUtils;
import android.view.View;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.IncompleteApiListener;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.WrappedIncompleteApiListener;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.common.util.CommonUtils;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.adapter.LovableDataSource;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import rx.Observable;

public class FavouriteManager {
    private static FavouriteManager sInstance = new FavouriteManager();

    public static FavouriteManager getInstance() {
        return sInstance;
    }

    public ApiRequest toggleLike(View view, Serializable serializable, IncompleteApiListener incompleteApiListener) {
        return toggleLike(view, serializable, null, incompleteApiListener);
    }

    public ApiRequest toggleLike(View view, Serializable serializable, LovableDataSource lovableDataSource, IncompleteApiListener incompleteApiListener) {
        int type = MusicHelper.getType(serializable);
        String likeID = MusicHelper.getLikeID(serializable);
        boolean isSelected = view.isSelected();
        final WeakReference weakReference = new WeakReference(view);
        final LovableDataSource lovableDataSource2 = lovableDataSource;
        final String str = likeID;
        final boolean z = isSelected;
        AnonymousClass1 r1 = new WrappedIncompleteApiListener<String>(incompleteApiListener) {
            /* class com.xiaomi.mico.music.favourite.FavouriteManager.AnonymousClass1 */

            public void onSuccess(String str) {
                Object tag;
                LovableDataSource lovableDataSource = lovableDataSource2;
                if (lovableDataSource != null) {
                    lovableDataSource.updateFavouriteData(str, !z);
                }
                View view = (View) weakReference.get();
                if (view != null && ((tag = view.getTag()) == null || (((tag instanceof String) && CommonUtils.equals(tag, str)) || ((tag instanceof Serializable) && CommonUtils.equals(MusicHelper.getID((Serializable) tag), str))))) {
                    view.setSelected(!z);
                }
                super.onSuccess((Object) str);
            }

            public void onFailure(ApiError apiError) {
                super.onFailure(apiError);
                gsy.O00000Oo(12000, "12000.4.7", "");
            }
        };
        if (TextUtils.isEmpty(likeID)) {
            return null;
        }
        if (!isSelected) {
            return ApiHelper.like(type, Long.parseLong(likeID), r1);
        }
        return ApiHelper.unlike(type, Long.parseLong(likeID), r1);
    }

    /* access modifiers changed from: package-private */
    public ApiRequest bulkUnlike(int i, List<Long> list, ApiRequest.Listener<String> listener) {
        return ApiHelper.bulkUnlike(i, list, listener);
    }

    public ApiRequest getLikeStatus(int i, long j, ApiRequest.Listener<Boolean> listener) {
        return ApiHelper.getLikeStatus(i, j, listener);
    }

    @Deprecated
    public ApiRequest getLikeStatus(int i, List<Long> list, ApiRequest.Listener<Map<String, Boolean>> listener) {
        return ApiHelper.getLikeStatus(i, list, listener);
    }

    public Observable<List<Object>> getLikeList(int i) {
        return ObservableApiHelper.getLikeList(i);
    }

    /* access modifiers changed from: package-private */
    public Observable<List<Object>> getLikeList(String str) {
        return ObservableApiHelper.getLikeList(str);
    }

    public ApiRequest getLikeStatus(Music.Song song, ApiRequest.Listener<List<Music.Favourite>> listener) {
        return ApiHelper.getFavouriteStatus(Remote.Request.buildSongListFavouriteMessage(Collections.singletonList(song)), listener);
    }

    public ApiRequest getLikeStatus(List<Music.Song> list, ApiRequest.Listener<List<Music.Favourite>> listener) {
        return ApiHelper.getFavouriteStatus(Remote.Request.buildSongListFavouriteMessage(list), listener);
    }
}
