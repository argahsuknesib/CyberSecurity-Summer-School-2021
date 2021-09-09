package com.xiaomi.mico.music;

import _m_j.gsy;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.IncompleteApiListener;
import com.xiaomi.mico.api.model.AudioSourceInterface;
import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.SingleAdapter;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.transformation.BlurTransformation;
import com.xiaomi.mico.common.transformation.CircleTransformation;
import com.xiaomi.mico.common.transformation.CropSquareTransformation;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.RatioImageView;
import com.xiaomi.mico.common.widget.dialog.InputViewDialog;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.cache.MusicCache;
import com.xiaomi.mico.music.channel.ChannelManager;
import com.xiaomi.mico.music.detail.AlbumDetailActivity;
import com.xiaomi.mico.music.detail.ArtistDetailActivity;
import com.xiaomi.mico.music.detail.ChannelDetailActivity;
import com.xiaomi.mico.music.detail.SheetDetailActivity;
import com.xiaomi.mico.music.detail.StationDetailActivity;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.mico.music.viewholder.SimpleViewHolder;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MusicHelper {
    private static final Map<String, Integer> CP_TO_NAME = new HashMap<String, Integer>() {
        /* class com.xiaomi.mico.music.MusicHelper.AnonymousClass1 */
        private static final long serialVersionUID = -5820401825011438334L;

        {
            Integer valueOf = Integer.valueOf((int) R.string.music_cp_miui);
            put("miui", valueOf);
            put("miuiv2", valueOf);
            put("xiaoai", valueOf);
            put("mi", Integer.valueOf((int) R.string.music_cp_mi));
            put("kuwo", Integer.valueOf((int) R.string.music_cp_kuwo));
            put("beiwa", Integer.valueOf((int) R.string.music_cp_beiwa));
            put("xiami", Integer.valueOf((int) R.string.music_cp_xiami));
            put("kuke", Integer.valueOf((int) R.string.music_cp_kuke));
            put("leting", Integer.valueOf((int) R.string.music_cp_leting));
            put("tingwen", Integer.valueOf((int) R.string.music_cp_tingwen));
            put("ximalaya", Integer.valueOf((int) R.string.music_cp_ximalaya));
            put("qingting", Integer.valueOf((int) R.string.music_cp_qingting));
            put("cn", Integer.valueOf((int) R.string.music_cp_cn));
            put("dedao", Integer.valueOf((int) R.string.music_cp_dedao));
            put("xinhua", Integer.valueOf((int) R.string.music_cp_xinhua));
            put("qqnews", Integer.valueOf((int) R.string.music_cp_qqnews));
            put("boyakids", Integer.valueOf((int) R.string.music_cp_boyakids));
            put("qqfm", Integer.valueOf((int) R.string.music_cp_qqfm));
            put("kaishu", Integer.valueOf((int) R.string.music_cp_kaishu));
            put("beiwaradio", Integer.valueOf((int) R.string.music_cp_beiwaradio));
            put("ifeng", Integer.valueOf((int) R.string.music_cp_ifeng));
            put("jingyasiting", Integer.valueOf((int) R.string.music_cp_jingyasiting));
            put("haijiaoquan", Integer.valueOf((int) R.string.music_cp_haijiaoquan));
            put("dedaotingshu", Integer.valueOf((int) R.string.music_cp_dedaotingshu));
            put("storysuperman", Integer.valueOf((int) R.string.music_cp_storysuperman));
            put("dedaocolumn", Integer.valueOf((int) R.string.music_cp_dedaocolumn));
            put("gongba", Integer.valueOf((int) R.string.music_cp_gongba));
            put("haobai", Integer.valueOf((int) R.string.music_cp_haobai));
            put("hujiang", Integer.valueOf((int) R.string.music_cp_hujiang));
            put("lanrentingshu", Integer.valueOf((int) R.string.music_cp_lanrentingshu));
            put("dedaocourse", Integer.valueOf((int) R.string.music_cp_dedaocourse));
            put("xiaowei", Integer.valueOf((int) R.string.music_cp_xiaowei));
        }
    };
    public static final Map<String, String> CP_TO_NAME_SERVER = new HashMap();

    public interface OnPlayingListener {
        void onPlaying(String str);
    }

    public static int getPlayingStationType(int i, int i2) {
        if (i == 4) {
            return 2;
        }
        if (i == 5) {
            return 0;
        }
        if (i == 6) {
            return 1;
        }
        return i2;
    }

    public static boolean isPlayingAlbum(int i) {
        return i == 8;
    }

    public static boolean isPlayingDirective(int i) {
        return i == 15;
    }

    public static boolean isPlayingRadioStation(int i) {
        return i == 6;
    }

    public static boolean isPlayingSheet(int i) {
        return i == 9;
    }

    public static boolean isPlayingStation(int i) {
        return i == 4 || i == 5 || i == 6;
    }

    static /* synthetic */ void lambda$playSong$1(Throwable th) {
    }

    public static void loadDefaultCoverBackground(ImageView imageView) {
        Context context = imageView.getContext();
        Picasso.get().load((int) R.drawable.bg_title_bar).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder((int) R.drawable.bg_title_bar).transform(new BlurTransformation(context, 8)).into(imageView);
    }

    public static void loadCoverBackground(String str, ImageView imageView, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
            loadDefaultCoverBackground(imageView);
            return;
        }
        Context context = imageView.getContext();
        RequestCreator load = Picasso.get().load(str);
        if (z) {
            load.placeholder((int) R.drawable.bg_title_bar);
        } else {
            load.noPlaceholder();
        }
        load.error((int) R.drawable.bg_title_bar).transform(new BlurTransformation(context, 4)).into(imageView);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void
     arg types: [java.lang.String, android.widget.ImageView, ?, ?, ?, boolean, int]
     candidates:
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void */
    public static void loadPlayerCover(String str, ImageView imageView, boolean z) {
        loadCover(str, imageView, (int) R.dimen.music_cover_size_player, (int) R.dimen.music_cover_size_player, (int) R.drawable.img_cover_player, z, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void
     arg types: [java.lang.String, android.widget.ImageView, ?, ?, ?, boolean, int]
     candidates:
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void */
    public static void loadLargeCover(String str, ImageView imageView, boolean z) {
        loadCover(str, imageView, (int) R.dimen.music_cover_size_large, (int) R.dimen.music_cover_size_large, (int) R.drawable.img_cover_default, z, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void
     arg types: [java.lang.String, android.widget.ImageView, ?, ?, int, boolean, int]
     candidates:
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void */
    public static void loadLargeCover(String str, ImageView imageView, int i, boolean z) {
        loadCover(str, imageView, (int) R.dimen.music_cover_size_large, (int) R.dimen.music_cover_size_large, i, z, false);
    }

    private static void loadMediumCover(String str, ImageView imageView, boolean z) {
        loadCover(str, imageView, (int) R.dimen.music_cover_size_medium, (int) R.dimen.music_cover_size_medium, (int) R.drawable.img_cover_default, z, new CropSquareTransformation());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void
     arg types: [java.lang.String, android.widget.ImageView, ?, ?, ?, boolean, int]
     candidates:
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void */
    private static void loadSmallCover(String str, ImageView imageView, boolean z) {
        loadCover(str, imageView, (int) R.dimen.music_cover_size_small, (int) R.dimen.music_cover_size_small, (int) R.drawable.img_cover_default_small, z, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void
     arg types: [java.lang.String, android.widget.ImageView, ?, ?, int, boolean, int]
     candidates:
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void */
    private static void loadSmallCover(String str, ImageView imageView, int i, boolean z) {
        loadCover(str, imageView, (int) R.dimen.music_cover_size_small, (int) R.dimen.music_cover_size_small, i, z, false);
    }

    public static void loadCover(String str, ImageView imageView, int i, int i2, int i3, boolean z, boolean z2) {
        RequestCreator requestCreator;
        imageView.getContext();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
            requestCreator = Picasso.get().load(i3).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder(i3);
        } else {
            requestCreator = Picasso.get().load(str);
            if (z) {
                requestCreator.placeholder(i3);
            } else {
                requestCreator.noPlaceholder();
            }
            requestCreator.error(i3);
        }
        requestCreator.resizeDimen(i, i2).centerCrop();
        if (z2) {
            requestCreator.transform(new CircleTransformation());
        }
        requestCreator.into(imageView);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void
     arg types: [java.lang.String, android.widget.ImageView, ?, ?, ?, int, com.xiaomi.mico.common.transformation.CircleTransformation]
     candidates:
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void */
    public static void loadCover(String str, ImageView imageView, int i, int i2, int i3, boolean z) {
        loadCover(str, imageView, (int) R.dimen.music_cover_size_84, (int) R.dimen.music_cover_size_84, (int) R.drawable.cover_patchwall_default_circle, true, (Transformation) new CircleTransformation());
    }

    public static void loadCover(String str, ImageView imageView, int i, int i2, int i3, boolean z, Transformation transformation) {
        RequestCreator requestCreator;
        imageView.getContext();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
            requestCreator = Picasso.get().load(i3).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder(i3);
        } else {
            requestCreator = Picasso.get().load(str);
            if (z) {
                requestCreator.placeholder(i3);
            } else {
                requestCreator.noPlaceholder();
            }
            requestCreator.error(i3);
        }
        requestCreator.noFade();
        requestCreator.resizeDimen(i, i2).centerCrop();
        if (transformation != null) {
            requestCreator.transform(transformation);
        }
        requestCreator.into(imageView);
    }

    public static void loadCover(String str, ImageView imageView, int i, int i2) {
        RequestCreator requestCreator;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str.trim())) {
                    requestCreator = Picasso.get().load(str);
                    requestCreator.placeholder(i);
                    requestCreator.error(i);
                    requestCreator.noFade();
                    requestCreator.resize(imageView.getWidth(), imageView.getHeight()).centerCrop();
                    requestCreator.transform(new CropSquareTransformation(DisplayUtils.dip2px(imageView.getContext(), (float) i2)));
                    requestCreator.into(imageView);
                }
            }
            requestCreator = Picasso.get().load(i).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder(i);
            requestCreator.noFade();
            requestCreator.resize(imageView.getWidth(), imageView.getHeight()).centerCrop();
            requestCreator.transform(new CropSquareTransformation(DisplayUtils.dip2px(imageView.getContext(), (float) i2)));
            requestCreator.into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadSectionCover(String str, ImageView imageView) {
        imageView.getContext();
        float ratio = imageView instanceof RatioImageView ? ((RatioImageView) imageView).getRatio() : 1.0f;
        double d = (double) ratio;
        int i = (d < 0.75d || d > 1.25d) ? (d <= 1.25d || ratio > 2.0f) ? (ratio <= 2.0f || ratio > 3.0f) ? -1 : R.drawable.img_banner_music : R.drawable.img_cover_default_rectangle : R.drawable.img_cover_default;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
            RequestCreator fit = Picasso.get().load(str).fit();
            if (i != -1) {
                fit.placeholder(i).error(i);
            }
            fit.into(imageView);
        } else if (i != -1) {
            Picasso.get().load(i).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder(i).into(imageView);
        }
    }

    public static void loadPatchWallCover(String str, ImageView imageView, boolean z) {
        RequestCreator requestCreator;
        imageView.getContext();
        if (TextUtils.isEmpty(str)) {
            requestCreator = Picasso.get().load((int) R.drawable.img_cover_patchwall).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder((int) R.drawable.img_cover_patchwall);
        } else {
            requestCreator = Picasso.get().load(str).placeholder((int) R.drawable.img_cover_patchwall).error((int) R.drawable.img_cover_patchwall).fit();
        }
        if (z) {
            requestCreator.transform(new CircleTransformation());
        }
        requestCreator.into(imageView);
    }

    public static void loadPatchWallCircleCover(String str, ImageView imageView, int i) {
        loadPatchWallCover(str, i, i, imageView, new CircleTransformation(), false);
    }

    public static void loadPatchWallCropSquareCover(String str, ImageView imageView, int i, int i2) {
        loadPatchWallCover(str, R.drawable.img_cover_error_corner, i, imageView, new CropSquareTransformation(i2), false);
    }

    public static void loadPatchWallCropSquareCover(String str, ImageView imageView, int i, int i2, int i3) {
        loadPatchWallCover(str, i, i2, imageView, new CropSquareTransformation(i3), false);
    }

    public static void loadPatchWallCropSquareCover(String str, ImageView imageView, int i, int i2, boolean z) {
        loadPatchWallCover(str, R.drawable.img_cover_error_corner, i, imageView, new CropSquareTransformation(i2), true);
    }

    private static void loadPatchWallCover(String str, int i, int i2, ImageView imageView, Transformation transformation, boolean z) {
        RequestCreator requestCreator;
        imageView.getContext();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
            requestCreator = Picasso.get().load(i).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder(i);
        } else {
            requestCreator = Picasso.get().load(str).placeholder(i2).error(i).fit();
        }
        if (z) {
            requestCreator.centerInside();
        }
        if (transformation != null) {
            requestCreator.transform(transformation);
        }
        requestCreator.into(imageView);
    }

    public static void loadCenterCover(String str, int i, int i2, ImageView imageView, Transformation transformation, int i3) {
        RequestCreator requestCreator;
        imageView.getContext();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
            requestCreator = Picasso.get().load(i).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder(i).resize(i3, i3).centerCrop();
        } else {
            requestCreator = Picasso.get().load(str).placeholder(i2).error(i).resize(i3, i3).centerCrop();
        }
        if (transformation != null) {
            requestCreator.transform(transformation);
        }
        requestCreator.into(imageView);
    }

    public static boolean isFavoriteEnableV3(Serializable serializable) {
        if (!(serializable instanceof Music.Song)) {
            return false;
        }
        String str = ((Music.Song) serializable).audioType;
        if ("MUSIC".equals(str) || "RADIO_STATION".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean isCollectedV3(Serializable serializable) {
        return serializable instanceof Music.Song ? ((Music.Song) serializable).collection == 1 : (serializable instanceof Music.Station) && ((Music.Station) serializable).collection == 1;
    }

    public static boolean isPlayingSong(int i) {
        return i == 3 || isPlayingAlbum(i) || isPlayingSheet(i);
    }

    public static String getPlayingMusicID(Remote.Response.PlayerStatus playerStatus) {
        if (playerStatus == null || playerStatus.play_song_detail == null) {
            return null;
        }
        if (MicoManager.getInstance().currentMicoIsAiProtocolV3()) {
            return String.valueOf(playerStatus.play_song_detail.audio_id);
        }
        if (isPlayingSong(playerStatus.media_type)) {
            return String.valueOf(playerStatus.play_song_detail.musicID);
        }
        if (isPlayingStation(playerStatus.media_type)) {
            return playerStatus.play_song_detail.cpID;
        }
        return null;
    }

    public static String getPlayingMusicID(int i, Remote.Response.TrackData trackData) {
        if (isPlayingSong(i) && trackData != null) {
            return String.valueOf(trackData.musicID);
        }
        if (!isPlayingStation(i) || trackData == null) {
            return null;
        }
        return trackData.cpID;
    }

    public static long getPlayingSongID(int i, Remote.Response.TrackData trackData) {
        if (!isPlayingSong(i) || trackData == null) {
            return -1;
        }
        return trackData.musicID;
    }

    public static String getPlayingStationID(int i, Remote.Response.TrackData trackData) {
        if (!isPlayingStation(i) || trackData == null) {
            return null;
        }
        return trackData.cpID;
    }

    public static boolean isPlaying(Remote.Response.PlayerStatus playerStatus) {
        return playerStatus != null && playerStatus.status == 1;
    }

    public static boolean isPlayingValid(Remote.Response.TrackData trackData) {
        if (trackData != null) {
            return trackData.musicID > 0 || !TextUtils.isEmpty(trackData.cpID) || !TextUtils.isEmpty(trackData.title);
        }
        return false;
    }

    public static int getType(Serializable serializable) {
        if (serializable instanceof Music.Song) {
            return 1;
        }
        if (serializable instanceof Music.Album) {
            return 2;
        }
        if (serializable instanceof Music.Artist) {
            return 3;
        }
        if (serializable instanceof Music.Sheet) {
            return 5;
        }
        return serializable instanceof Music.Station ? 4 : -1;
    }

    public static String getIDV3(Serializable serializable) {
        if (serializable instanceof Music.Song) {
            return String.valueOf(((Music.Song) serializable).audioID);
        }
        if (serializable instanceof Music.Station) {
            return ((Music.Station) serializable).audioID;
        }
        return null;
    }

    public static String getID(Serializable serializable) {
        if (MicoManager.getInstance().currentMicoIsAiProtocolV3()) {
            return getIDV3(serializable);
        }
        if (serializable instanceof Music.Song) {
            return String.valueOf(((Music.Song) serializable).songID);
        }
        if (serializable instanceof Music.Album) {
            return String.valueOf(((Music.Album) serializable).albumID);
        }
        if (serializable instanceof Music.Artist) {
            return String.valueOf(((Music.Artist) serializable).artistID);
        }
        if (serializable instanceof Music.Sheet) {
            return String.valueOf(((Music.Sheet) serializable).sheetID);
        }
        if (serializable instanceof Music.Station) {
            return ((Music.Station) serializable).stationID;
        }
        if (serializable instanceof Music.Channel) {
            return String.valueOf(((Music.Channel) serializable).id);
        }
        if (serializable instanceof AudioSourceInterface) {
            return String.valueOf(((AudioSourceInterface) serializable).getID());
        }
        return null;
    }

    public static String getLikeID(Serializable serializable) {
        if (serializable instanceof Music.Station) {
            return String.valueOf(((Music.Station) serializable).globalID);
        }
        return getID(serializable);
    }

    public static CharSequence getTitle(Serializable serializable) {
        if (serializable instanceof Music.Song) {
            return ((Music.Song) serializable).name;
        }
        if (serializable instanceof Music.Album) {
            return ((Music.Album) serializable).name;
        }
        if (serializable instanceof Music.Artist) {
            return ((Music.Artist) serializable).name;
        }
        if (serializable instanceof Music.Sheet) {
            return ((Music.Sheet) serializable).name;
        }
        if (serializable instanceof Music.Station) {
            return ((Music.Station) serializable).title;
        }
        if (serializable instanceof Music.Channel) {
            Music.Channel channel = (Music.Channel) serializable;
            if (!channel.isDefault) {
                return channel.name;
            }
            if (AccountProfile.current().isMiMusicSource()) {
                return CommonApplication.getAppContext().getString(R.string.music_channel_default_mi);
            }
            return CommonApplication.getAppContext().getString(R.string.music_channel_default);
        } else if (serializable instanceof AudioSourceInterface) {
            return ((AudioSourceInterface) serializable).getTitle();
        } else {
            return null;
        }
    }

    public static CharSequence getDescription2(Serializable serializable) {
        if ((serializable instanceof Music.Album) || (serializable instanceof Music.Sheet)) {
            return getDescription(serializable);
        }
        if (serializable instanceof Music.Station) {
            Music.Station station = (Music.Station) serializable;
            return getDescription(station.cpNameOrBoradcaster(), station.category);
        } else if (serializable instanceof Music.Artist) {
            return CommonApplication.getAppContext().getString(R.string.music_type_artist);
        } else {
            if (serializable instanceof Music.Channel) {
                if (((Music.Channel) serializable).isQQCollection) {
                    return CommonApplication.getAppContext().getString(R.string.music_channel_qq_collection);
                }
                return CommonApplication.getAppContext().getString(R.string.music_channel);
            } else if (serializable instanceof AudioSourceInterface) {
                return ((AudioSourceInterface) serializable).getDescription();
            } else {
                return null;
            }
        }
    }

    public static CharSequence getDescription(Serializable serializable) {
        if (serializable instanceof Music.Song) {
            Music.Song song = (Music.Song) serializable;
            return getDescription(song.getArtistName(), song.albumName);
        } else if (serializable instanceof Music.Album) {
            return ((Music.Album) serializable).getArtistName();
        } else {
            if (serializable instanceof Music.Sheet) {
                return ((Music.Sheet) serializable).subtitle;
            }
            if (serializable instanceof Music.Station) {
                Music.Station station = (Music.Station) serializable;
                return getDescription(station.broadcaster, station.category);
            } else if (!(serializable instanceof Music.Channel)) {
                return null;
            } else {
                Music.Channel channel = (Music.Channel) serializable;
                return getDescription(channel.subtitle, CommonApplication.getAppContext().getResources().getQuantityString(R.plurals.music_total_song, channel.songCount, Integer.valueOf(channel.songCount)));
            }
        }
    }

    public static boolean isVipSong(Serializable serializable) {
        if (serializable instanceof Music.Song) {
            return ((Music.Song) serializable).isVipSong();
        }
        return false;
    }

    public static CharSequence getSinger(Serializable serializable) {
        if (serializable instanceof Music.Song) {
            return getSingerV3((Music.Song) serializable);
        }
        if (serializable instanceof Music.Album) {
            return ((Music.Album) serializable).getArtistName();
        }
        if (serializable instanceof Music.Station) {
            return ((Music.Station) serializable).albumName;
        }
        return null;
    }

    public static CharSequence getSingerV3(Music.Song song) {
        if (TextUtils.isEmpty(song.audioType)) {
            return song.getArtistName();
        }
        String str = song.audioType;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 63384202) {
            if (hashCode == 73725445 && str.equals("MUSIC")) {
                c = 0;
            }
        } else if (str.equals("BOOKS")) {
            c = 1;
        }
        if (c == 0) {
            return song.getArtistName();
        }
        if (c != 1) {
            return null;
        }
        return song.albumName;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getDefaultLrcTextV3(Music.Song song) {
        char c;
        String str = song.audioType;
        switch (str.hashCode()) {
            case -1805550780:
                if (str.equals("WHITE_NOISE")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1758903120:
                if (str.equals("RADIO_STATION")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 83411:
                if (str.equals("TTS")) {
                    c = 9;
                    break;
                }
                c = 65535;
                break;
            case 2282847:
                if (str.equals("JOKE")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 2392787:
                if (str.equals("NEWS")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 63384202:
                if (str.equals("BOOKS")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 73725445:
                if (str.equals("MUSIC")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 81848594:
                if (str.equals("VOICE")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 312313489:
                if (str.equals("TRANSLATION")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case 991180846:
                if (str.equals("ANCIENT_POEM")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return R.string.music_no_lyric;
            case 1:
            case 2:
                return R.string.music_no_lyric_for_station;
            case 3:
                return R.string.music_no_lyric_for_directive;
            case 4:
                return R.string.music_no_lyric_for_joke;
            case 5:
                return R.string.music_no_lyric_for_ancient_poem;
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
                return R.string.music_no_lyric_for_other;
            default:
                return R.string.music_no_lyric;
        }
    }

    public static CharSequence getDescription(CharSequence charSequence, CharSequence charSequence2) {
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence2;
        }
        if (TextUtils.isEmpty(charSequence2)) {
            return charSequence;
        }
        return ((Object) charSequence) + " | " + ((Object) charSequence2);
    }

    public static String getCover(Serializable serializable) {
        if (serializable instanceof Music.Song) {
            return ((Music.Song) serializable).coverURL;
        }
        if (serializable instanceof Music.Album) {
            return ((Music.Album) serializable).coverURL;
        }
        if (serializable instanceof Music.Artist) {
            return ((Music.Artist) serializable).iconURL;
        }
        if (serializable instanceof Music.Sheet) {
            return ((Music.Sheet) serializable).cover;
        }
        if (serializable instanceof Music.Station) {
            return ((Music.Station) serializable).cover;
        }
        if (serializable instanceof Music.Channel) {
            return ((Music.Channel) serializable).cover;
        }
        if (serializable instanceof AudioSourceInterface) {
            return ((AudioSourceInterface) serializable).getCover();
        }
        return null;
    }

    public static int getChannelDefaultCover(Serializable serializable) {
        return (!(serializable instanceof Music.Channel) || !((Music.Channel) serializable).isDefault) ? R.drawable.img_cover_default_small : R.drawable.img_cover_qq_default_small_crop;
    }

    public static String getCpName(Serializable serializable) {
        String str;
        if (serializable instanceof Music.Song) {
            Music.Song song = (Music.Song) serializable;
            if (!TextUtils.isEmpty(song.originName)) {
                return song.originName;
            }
            str = song.origin;
        } else if (serializable instanceof Music.Sheet) {
            str = ((Music.Sheet) serializable).cpName;
        } else if (serializable instanceof Music.Station) {
            Music.Station station = (Music.Station) serializable;
            if (!TextUtils.isEmpty(station.originName)) {
                return station.originName;
            }
            str = station.cp;
        } else {
            str = null;
        }
        return getCpName(str);
    }

    public static String getCpName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (CP_TO_NAME_SERVER.containsKey(str)) {
            return CP_TO_NAME_SERVER.get(str);
        }
        for (Map.Entry next : CP_TO_NAME.entrySet()) {
            if (str.equalsIgnoreCase((String) next.getKey())) {
                return CommonApplication.getAppContext().getResources().getString(((Integer) next.getValue()).intValue());
            }
        }
        return null;
    }

    public static int convertStationType(String str) {
        if ("album".equals(str)) {
            return 0;
        }
        return "radio".equals(str) ? 1 : 2;
    }

    public static boolean isLegal(Serializable serializable) {
        if (serializable instanceof Music.Song) {
            return ((Music.Song) serializable).isLegal();
        }
        if (serializable instanceof Music.Station) {
            return ((Music.Station) serializable).isLegal();
        }
        if (serializable instanceof AudioSourceInterface) {
            return ((AudioSourceInterface) serializable).isLegal();
        }
        return true;
    }

    public static void fillItem(Serializable serializable, TextView textView, TextView textView2) {
        fillItem(serializable, textView, textView2, (ImageView) null);
    }

    public static void fillItem(Serializable serializable, TextView textView, TextView textView2, ImageView imageView) {
        fillItem(serializable, textView, textView2, imageView, false);
    }

    public static void fillItem(Serializable serializable, TextView textView, TextView textView2, ImageView imageView, boolean z) {
        fillItem(getTitle(serializable), getDescription(serializable), getCover(serializable), textView, textView2, imageView, z, getChannelDefaultCover(serializable), isVipSong(serializable));
    }

    public static void fillItem(Music.SectionData sectionData, TextView textView, TextView textView2, ImageView imageView) {
        fillItem(sectionData.name, null, sectionData.squareImageURL, textView, textView2, imageView, false);
    }

    public static void fillItem(PatchWall.Item item, TextView textView, TextView textView2, ImageView imageView) {
        fillItem(item.title, null, (item.images == null || item.images.poster == null) ? null : item.images.poster.url, textView, textView2, imageView, false);
    }

    private static void fillItem(CharSequence charSequence, CharSequence charSequence2, String str, TextView textView, TextView textView2, ImageView imageView, boolean z, int i, boolean z2) {
        Drawable drawable;
        if (textView != null) {
            if (!TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
            } else {
                textView.setText((int) R.string.mico_music_directive_default_title);
            }
        }
        if (textView2 != null) {
            if (!TextUtils.isEmpty(charSequence2)) {
                textView2.setVisibility(0);
                textView2.setText(charSequence2);
            } else {
                textView2.setVisibility(8);
            }
            if (z2) {
                drawable = CommonApplication.getAppContext().getResources().getDrawable(R.drawable.mico_icon_vip);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            } else {
                drawable = null;
            }
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        if (imageView == null) {
            return;
        }
        if (z) {
            loadSmallCover(str, imageView, i, true);
        } else {
            loadMediumCover(str, imageView, true);
        }
    }

    public static void fillItem(CharSequence charSequence, CharSequence charSequence2, String str, TextView textView, TextView textView2, ImageView imageView, boolean z) {
        if (textView != null) {
            if (!TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
            } else {
                textView.setText((int) R.string.mico_music_directive_default_title);
            }
        }
        if (textView2 != null) {
            if (!TextUtils.isEmpty(charSequence2)) {
                textView2.setVisibility(0);
                textView2.setText(charSequence2);
            } else {
                textView2.setVisibility(8);
            }
        }
        if (imageView == null) {
            return;
        }
        if (z) {
            loadSmallCover(str, imageView, true);
        } else {
            loadMediumCover(str, imageView, true);
        }
    }

    public static void processBanner(Context context, Banner.Data data) {
        SchemaManager.handleSchema(context, data.url);
    }

    public static void processSectionData(Context context, Music.SectionData sectionData) {
        SchemaManager.handleSchema(context, sectionData.action);
    }

    public static void processBlockItem(Context context, PatchWall.Item item) {
        SchemaManager.handleSchema(context, item.target);
    }

    public static void processMusic(Context context, Serializable serializable) {
        processMusic(context, serializable, null);
    }

    public static void processMusic(Context context, Serializable serializable, OnPlayingListener onPlayingListener) {
        if (serializable instanceof Music.Song) {
            playSong((Music.Song) serializable, onPlayingListener);
        } else if (serializable instanceof Music.Album) {
            processAlbum(context, (Music.Album) serializable);
        } else if (serializable instanceof Music.Artist) {
            processArtist(context, (Music.Artist) serializable);
        } else if (serializable instanceof Music.Sheet) {
            processSheet(context, (Music.Sheet) serializable);
        } else if (serializable instanceof Music.Station) {
            processStation(context, null, (Music.Station) serializable, onPlayingListener);
        } else if (serializable instanceof Music.Channel) {
            processChannel(context, (Music.Channel) serializable);
        }
    }

    public static void playSong(String str, OnPlayingListener onPlayingListener) {
        try {
            MusicCache.getSong(Long.parseLong(str)).subscribe(new Action1() {
                /* class com.xiaomi.mico.music.$$Lambda$MusicHelper$LOfdmdwN28UZUYAg0nXYTui0fM */

                public final void call(Object obj) {
                    MusicHelper.playSong((Music.Song) obj, MusicHelper.OnPlayingListener.this);
                }
            }, $$Lambda$MusicHelper$OX9fV7narlOERXUOGgXpc2e4wo.INSTANCE);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static void playSong(final Music.Song song, final OnPlayingListener onPlayingListener) {
        if (!song.isLegal()) {
            ToastUtil.showToast((int) R.string.music_play_illegal);
        } else {
            PlayerManager.getInstance().playSong(song, new IncompleteApiListener() {
                /* class com.xiaomi.mico.music.MusicHelper.AnonymousClass2 */

                public final void onFailure(ApiError apiError) {
                }

                public final void onSuccess() {
                    OnPlayingListener onPlayingListener = onPlayingListener;
                    if (onPlayingListener != null) {
                        onPlayingListener.onPlaying(String.valueOf(song.songID));
                    }
                }
            });
        }
    }

    public static void playSongs(List<Music.Song> list, int i, OnPlayingListener onPlayingListener) {
        playSongs(-1, -1, list, i, onPlayingListener);
    }

    public static void playSongs(int i, long j, List<Music.Song> list, int i2, final OnPlayingListener onPlayingListener) {
        long j2;
        if (!ContainerUtil.isEmpty(list)) {
            if (i2 <= 0) {
                i2 = 0;
                int size = list.size();
                while (i2 < size && !list.get(i2).isLegal()) {
                    i2++;
                }
                if (i2 == size) {
                    ToastUtil.showToast((int) R.string.music_play_illegal);
                    return;
                }
                j2 = list.get(i2).songID;
            } else {
                Music.Song song = list.get(i2);
                if (!song.isLegal()) {
                    ToastUtil.showToast((int) R.string.music_play_illegal);
                    return;
                }
                j2 = song.songID;
            }
            final String valueOf = String.valueOf(j2);
            AnonymousClass3 r1 = new IncompleteApiListener() {
                /* class com.xiaomi.mico.music.MusicHelper.AnonymousClass3 */

                public final void onFailure(ApiError apiError) {
                }

                public final void onSuccess() {
                    OnPlayingListener onPlayingListener = onPlayingListener;
                    if (onPlayingListener != null) {
                        onPlayingListener.onPlaying(valueOf);
                    }
                }
            };
            if ((i == 0 || i == 1) && j > 0) {
                PlayerManager.getInstance().playList(i, j, list, i2, r1);
            } else {
                PlayerManager.getInstance().playSongs(j, list, i2, r1);
            }
        }
    }

    private static void playStation(final Music.Station station, final OnPlayingListener onPlayingListener) {
        PlayerManager.getInstance().playStation(station, new IncompleteApiListener() {
            /* class com.xiaomi.mico.music.MusicHelper.AnonymousClass4 */

            public final void onFailure(ApiError apiError) {
            }

            public final void onSuccess() {
                OnPlayingListener onPlayingListener = onPlayingListener;
                if (onPlayingListener != null) {
                    onPlayingListener.onPlaying(station.stationID);
                }
            }
        });
    }

    public static void playStations(List<Music.Station> list, int i, final OnPlayingListener onPlayingListener, String str, String str2) {
        final String str3;
        int i2;
        if (!ContainerUtil.isEmpty(list)) {
            if (i < 0) {
                int size = list.size();
                i2 = 0;
                while (i2 < size && !list.get(i2).isLegal()) {
                    i2++;
                }
                if (i2 == size) {
                    ToastUtil.showToast((int) R.string.music_play_illegal);
                    Object[] objArr = {"getStationSoundList start %s, size %s", Integer.valueOf(i2), Integer.valueOf(size)};
                    return;
                }
                str3 = getID(list.get(i2));
            } else if (!list.get(i).isLegal()) {
                new Object[1][0] = "getStationSoundList isLegal false";
                ToastUtil.showToast((int) R.string.music_play_illegal);
                return;
            } else {
                i2 = i;
                str3 = getID(list.get(i));
            }
            PlayerManager.getInstance().playStations(str, list, i2, str2, new IncompleteApiListener() {
                /* class com.xiaomi.mico.music.MusicHelper.AnonymousClass5 */

                public final void onFailure(ApiError apiError) {
                }

                public final void onSuccess() {
                    OnPlayingListener onPlayingListener = onPlayingListener;
                    if (onPlayingListener != null) {
                        onPlayingListener.onPlaying(str3);
                    }
                }
            });
        }
    }

    public static void processAlbum(Context context, String str) {
        Music.Album album = new Music.Album();
        try {
            album.albumID = Long.parseLong(str);
            processAlbum(context, album);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void processAlbum(Context context, Music.Album album) {
        Intent intent = new Intent(context, AlbumDetailActivity.class);
        intent.putExtra("music", album);
        context.startActivity(intent);
    }

    public static void processArtist(Context context, String str) {
        Music.Artist artist = new Music.Artist();
        try {
            artist.artistID = Long.parseLong(str);
            processArtist(context, artist);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void processArtist(Context context, Music.Artist artist) {
        Intent intent = new Intent(context, ArtistDetailActivity.class);
        intent.putExtra("music", artist);
        context.startActivity(intent);
    }

    public static void processSheet(Context context, String str) {
        Music.Sheet sheet = new Music.Sheet();
        try {
            sheet.sheetID = Long.parseLong(str);
            processSheet(context, sheet);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void processSheet(Context context, Music.Sheet sheet) {
        Intent intent = new Intent(context, SheetDetailActivity.class);
        intent.putExtra("music", sheet);
        context.startActivity(intent);
    }

    public static void processStation(Context context, Uri uri, String str, String str2, String str3, String str4, String str5, String str6, String str7, OnPlayingListener onPlayingListener) {
        Music.Station station = new Music.Station();
        station.stationID = str2;
        station.origin = str3;
        station.category = str4;
        station.type = str5;
        if (!TextUtils.isEmpty(str)) {
            station.globalID = Long.parseLong(str);
        }
        if (!TextUtils.isEmpty(str6)) {
            station.saleType = Integer.parseInt(str6);
        }
        if (ContainerUtil.hasData(str7)) {
            station.fromAddBabySchedule = true;
        }
        Object[] objArr = {"processStation globalId=%d,stationId=%s, origin=%s category=%s, type=%s", Long.valueOf(station.globalID), station.stationID, station.origin, station.category, station.type};
        processStation(context, uri, station, onPlayingListener);
    }

    public static void processStation(Context context, Uri uri, Music.Station station, OnPlayingListener onPlayingListener) {
        String str;
        if (!station.isLegal()) {
            ToastUtil.showToast((int) R.string.music_play_illegal);
        } else if ("album".equals(station.type) || TextUtils.isEmpty(station.type)) {
            Intent intent = new Intent(context, StationDetailActivity.class);
            if (uri == null) {
                str = "";
            } else {
                str = uri.toString();
            }
            intent.putExtra("INTENT_KEY_ACTION", str);
            intent.putExtra("music", station);
            context.startActivity(intent);
        } else {
            playStation(station, onPlayingListener);
        }
    }

    public static void processChannel(Context context, String str) {
        Music.Channel channel = new Music.Channel();
        try {
            channel.id = Long.parseLong(str);
            processChannel(context, channel);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void processChannel(Context context, Music.Channel channel) {
        processChannel(context, channel, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void processChannel(Context context, Music.Channel channel, boolean z) {
        Intent intent = new Intent(context, ChannelDetailActivity.class);
        intent.putExtra("music", channel);
        if (z) {
            intent.putExtra("new_create", true);
        }
        context.startActivity(intent);
    }

    public static Observable<Long> createChannel(Context context) {
        return Observable.create(new Observable.OnSubscribe(context) {
            /* class com.xiaomi.mico.music.$$Lambda$MusicHelper$T0fXxjAhpTGhkEsm2LmAe2pdOhk */
            private final /* synthetic */ Context f$0;

            {
                this.f$0 = r1;
            }

            public final void call(Object obj) {
                new InputViewDialog(this.f$0).setTitle((int) R.string.music_channel_new).setHintText((int) R.string.music_channel_new_hint).setListener(new InputViewDialog.Listener() {
                    /* class com.xiaomi.mico.music.$$Lambda$MusicHelper$uVTAItEQG8lhPqECoamffkBABZ4 */

                    public final void onFinish(String str) {
                        MusicHelper.lambda$null$2(Subscriber.this, str);
                    }
                }).show();
            }
        }).flatMap($$Lambda$MusicHelper$Cnlp9sNQQR3Rj6fSdmbGpxvrC70.INSTANCE);
    }

    static /* synthetic */ void lambda$null$2(Subscriber subscriber, String str) {
        subscriber.onNext(str);
        subscriber.onCompleted();
    }

    public static void addToChannel(Context context, Music.Song song) {
        Observable.create(new Observable.OnSubscribe(context) {
            /* class com.xiaomi.mico.music.$$Lambda$MusicHelper$jt9TdOQMkkbvqt7CYKk0K1m5kg */
            private final /* synthetic */ Context f$0;

            {
                this.f$0 = r1;
            }

            public final void call(Object obj) {
                MusicHelper.lambda$addToChannel$5(this.f$0, (Subscriber) obj);
            }
        }).flatMap(new Func1(context) {
            /* class com.xiaomi.mico.music.$$Lambda$MusicHelper$qgEXb2dXELxPzTMJTg3WXpUV18c */
            private final /* synthetic */ Context f$1;

            {
                this.f$1 = r2;
            }

            public final Object call(Object obj) {
                return MusicHelper.lambda$addToChannel$6(Music.Song.this, this.f$1, (Music.Channel) obj);
            }
        }).subscribe(new Action1(context) {
            /* class com.xiaomi.mico.music.$$Lambda$MusicHelper$iIj5nlzSwZUSNZxOyjmvGRRE_N4 */
            private final /* synthetic */ Context f$0;

            {
                this.f$0 = r1;
            }

            public final void call(Object obj) {
                ToastUtil.showToast(this.f$0.getString(R.string.music_channel_add_song_success, (String) obj));
            }
        }, $$Lambda$MusicHelper$iiTuXAj85cKgW3fI0gUSnWUsyDM.INSTANCE);
    }

    static /* synthetic */ void lambda$addToChannel$5(Context context, Subscriber subscriber) {
        MLAlertDialog O00000o = new MLAlertDialog.Builder(context).O00000o();
        Window window = O00000o.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            window.getDecorView().setPadding(0, 0, 0, 0);
        }
        O00000o.setView(getChannelListView(context, subscriber, O00000o), 0, 0, 0, 0);
        O00000o.show();
        if (window != null) {
            ((ViewGroup.MarginLayoutParams) window.findViewById(R.id.parentPanel).getLayoutParams()).setMargins(0, 0, 0, 0);
        }
    }

    static /* synthetic */ Observable lambda$addToChannel$6(Music.Song song, Context context, Music.Channel channel) {
        List singletonList = Collections.singletonList(song);
        if (channel == null) {
            return createChannelAndAddSongs(context, singletonList);
        }
        return ChannelManager.getInstance().addSongs(channel.id, singletonList);
    }

    static /* synthetic */ void lambda$addToChannel$8(Throwable th) {
        if (!(th instanceof ApiError.ApiErrorException) || ((ApiError.ApiErrorException) th).getCode() != 215) {
            gsy.O00000Oo(12000, "12000.4.6", "");
            ToastUtil.showToast((int) R.string.music_channel_add_song_failed);
            return;
        }
        ToastUtil.showToast((int) R.string.music_channel_qq_create_tip);
    }

    private static View getChannelListView(Context context, Subscriber<? super Music.Channel> subscriber, DialogInterface dialogInterface) {
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.view_music_channel_add, (ViewGroup) null);
        inflate.findViewById(R.id.music_channel_add).setOnClickListener(new View.OnClickListener(dialogInterface) {
            /* class com.xiaomi.mico.music.$$Lambda$MusicHelper$QBnIaIO0tgdbsH7C06u3jzVmGkI */
            private final /* synthetic */ DialogInterface f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                MusicHelper.lambda$getChannelListView$9(Subscriber.this, this.f$1, view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.linear_recycle_view);
        recyclerView.setHasFixedSize(true);
        AnonymousClass6 r1 = new SingleAdapter<ItemClickableAdapter.ViewHolder, Music.Channel>() {
            /* class com.xiaomi.mico.music.MusicHelper.AnonymousClass6 */

            public final ItemClickableAdapter.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i) {
                return new SimpleViewHolder.Normal(viewGroup, this.onItemClickListener);
            }

            public final void onBindItemViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
                super.onBindItemViewHolder(viewHolder, i);
                ((SimpleViewHolder.Normal) viewHolder).bindView((Serializable) getData(i));
            }
        };
        r1.setOnItemClickListener(new ItemClickableAdapter.OnItemClickListener(r1, dialogInterface) {
            /* class com.xiaomi.mico.music.$$Lambda$MusicHelper$eIRqOuIuWF2lv3Z08yDuHR0iT5U */
            private final /* synthetic */ SingleAdapter f$1;
            private final /* synthetic */ DialogInterface f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
                MusicHelper.lambda$getChannelListView$10(Subscriber.this, this.f$1, this.f$2, viewHolder, i);
            }
        });
        r1.updateDataList(ChannelManager.getInstance().getChannelList());
        recyclerView.setAdapter(r1);
        return inflate;
    }

    static /* synthetic */ void lambda$getChannelListView$9(Subscriber subscriber, DialogInterface dialogInterface, View view) {
        subscriber.onNext(null);
        subscriber.onCompleted();
        dialogInterface.dismiss();
    }

    static /* synthetic */ void lambda$getChannelListView$10(Subscriber subscriber, SingleAdapter singleAdapter, DialogInterface dialogInterface, ItemClickableAdapter.ViewHolder viewHolder, int i) {
        subscriber.onNext(singleAdapter.getData(i));
        subscriber.onCompleted();
        dialogInterface.dismiss();
    }

    private static Observable<String> createChannelAndAddSongs(Context context, List<Music.Song> list) {
        return createChannel(context).flatMap(new Func1(list) {
            /* class com.xiaomi.mico.music.$$Lambda$MusicHelper$H0PUL60G8tRCtdRgIMEyAnPRKU */
            private final /* synthetic */ List f$0;

            {
                this.f$0 = r1;
            }

            public final Object call(Object obj) {
                return ChannelManager.getInstance().addSongs(((Long) obj).longValue(), this.f$0);
            }
        });
    }

    public static void processPlaySheetSongs(String str, String str2) {
        if ("recommendation".equals(str2) || "radio".equals(str2) || "artist".equals(str2) || "category".equals(str2) || "kkbox_toplist".equals(str2) || "kkbox_songlist".equals(str2)) {
            ApiHelper.getQQMusicSheetSongs(str, str2, new ApiRequest.Listener<Music.SongBook>() {
                /* class com.xiaomi.mico.music.MusicHelper.AnonymousClass7 */

                public final void onFailure(ApiError apiError) {
                }

                public final void onSuccess(Music.SongBook songBook) {
                    if (songBook != null && ContainerUtil.hasData(songBook.songList)) {
                        PlayerManager.getInstance().playSongs(-1, songBook.songList, 0, new IncompleteApiListener() {
                            /* class com.xiaomi.mico.music.MusicHelper.AnonymousClass7.AnonymousClass1 */

                            public void onFailure(ApiError apiError) {
                            }

                            public void onSuccess() {
                            }
                        });
                    }
                }
            });
            return;
        }
        long j = 0;
        try {
            j = Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        final long j2 = j;
        if (MicoManager.getInstance().currentMicoIsAiProtocolV3()) {
            ChannelManager.getInstance().getChannelInfo(j2, 0, 20, new ApiRequest.Listener<Music.Channel>() {
                /* class com.xiaomi.mico.music.MusicHelper.AnonymousClass8 */

                public final void onFailure(ApiError apiError) {
                }

                public final void onSuccess(Music.Channel channel) {
                    PlayerManager.getInstance().playList(1, j2, channel.songList, 0, new IncompleteApiListener() {
                        /* class com.xiaomi.mico.music.MusicHelper.AnonymousClass8.AnonymousClass1 */

                        public void onFailure(ApiError apiError) {
                        }

                        public void onSuccess() {
                        }
                    });
                }
            });
            return;
        }
        PlayerManager.getInstance().playList(1, j2, null, 0, new IncompleteApiListener() {
            /* class com.xiaomi.mico.music.MusicHelper.AnonymousClass9 */

            public final void onFailure(ApiError apiError) {
            }

            public final void onSuccess() {
            }
        });
    }

    public static void processPlaySongBox(final String str, String str2, String str3) {
        ApiHelper.getStationSoundList(str, str2, str3, 0, 20, "NOT_REVERSE", null, new ApiRequest.Listener<Music.StationSoundList>() {
            /* class com.xiaomi.mico.music.MusicHelper.AnonymousClass10 */

            public final void onFailure(ApiError apiError) {
            }

            public final void onSuccess(Music.StationSoundList stationSoundList) {
                if (stationSoundList != null && ContainerUtil.hasData(stationSoundList.soundList)) {
                    PlayerManager.getInstance().playStations(str, stationSoundList.soundList, 0, "NOT_REVERSE", null);
                }
            }
        });
    }

    public static int getDefaultCornerRadius(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.radius_12dp);
    }
}
