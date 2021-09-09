package com.xiaomi.mico.api;

import _m_j.gqb;
import _m_j.gsy;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.api.model.DeviceState;
import com.xiaomi.mico.api.model.IntelligentModel;
import com.xiaomi.mico.api.model.IntelligentMoreModel;
import com.xiaomi.mico.api.model.LanGroupInfo;
import com.xiaomi.mico.api.model.MiBrain;
import com.xiaomi.mico.api.model.MicoLanGroup;
import com.xiaomi.mico.api.model.MinaResponse;
import com.xiaomi.mico.api.model.MultiRoomData;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.PairedGroupInfo;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.api.model.Payment;
import com.xiaomi.mico.api.model.QqMiniProgramResponse;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.api.model.SkillStore;
import com.xiaomi.mico.api.model.SoundEffect;
import com.xiaomi.mico.api.model.StereoData;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.api.service.DisplayService;
import com.xiaomi.mico.api.service.MiHomeService;
import com.xiaomi.mico.api.service.MinaService;
import com.xiaomi.mico.api.service.PaymentService;
import com.xiaomi.mico.api.service.SkillstoreService;
import com.xiaomi.mico.api.service.ThirdPartyService;
import com.xiaomi.mico.api.service.UserProfile;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.application.AreaCode;
import com.xiaomi.mico.common.threadpool.Threadpool;
import com.xiaomi.mico.common.util.Base64Coder;
import com.xiaomi.mico.common.util.GsonUtil;
import com.xiaomi.mico.main.MicoTabsInfo;
import com.xiaomi.mico.music.patchwall.micoselect.model.MicoHandpickInfo;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import retrofit2.Response;
import rx.Observable;
import rx.schedulers.Schedulers;

public class ApiHelper {
    private static ApiProviderWrapper apiProvider = new ApiProviderWrapper();
    public static Gson sGson = new Gson();

    public static void setApiProvider(ApiProviderWrapper apiProviderWrapper) {
        if (apiProviderWrapper != null) {
            apiProvider = apiProviderWrapper;
            gsy.O00000o0(LogType.MAIN_PAGE, "setApiProvider", "uwb api");
            return;
        }
        apiProvider = new ApiProviderWrapper();
        gsy.O00000o0(LogType.MAIN_PAGE, "setApiProvider", "normal api");
    }

    public static class ApiProviderWrapper {

        public static class Params {
            public String deviceId;
            public String message;
            public String method;
            public String path;

            public Params(String str, String str2, String str3, String str4) {
                this.deviceId = str;
                this.path = str2;
                this.method = str3;
                this.message = str4;
            }
        }

        public ApiProvider<Remote.Response> getApiProvider(final Params params) {
            return new ApiProvider<Remote.Response>() {
                /* class com.xiaomi.mico.api.ApiHelper.ApiProviderWrapper.AnonymousClass1 */

                public Observable<Response<MinaResponse<Remote.Response>>> observable(MinaService minaService) {
                    return minaService.remote(params.deviceId, params.path, params.method, params.message);
                }
            };
        }
    }

    public static <T> ApiRequest remote(String str, String str2, String str3, String str4, ApiRequest.Listener<T> listener, Class<T> cls) {
        return ApiManager.getInstance().enqueue(apiProvider.getApiProvider(new ApiProviderWrapper.Params(str, str2, str3, str4)), new RemoteApiListener(listener, cls));
    }

    public static ApiRequest remote4Dts(final String str, final String str2, final String str3, final String str4, ApiRequest.Listener<SoundEffect> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<SoundEffect>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass1 */

            public final Observable<Response<MinaResponse<SoundEffect>>> observable(MinaService minaService) {
                return minaService.remote4Dts(str, str2, str3, str4);
            }
        }, listener);
    }

    public static ApiRequest getDeviceList(ApiRequest.Listener<List<Admin.Mico>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Admin.Mico>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass2 */

            public final Observable<Response<MinaResponse<List<Admin.Mico>>>> observable(MinaService minaService) {
                return minaService.getDeviceList();
            }
        }, listener);
    }

    public static ApiRequest bindDevice(final String str, final String str2, final String str3, ApiRequest.Listener<List<Admin.Mico>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Admin.Mico>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass3 */

            public final Observable<Response<MinaResponse<List<Admin.Mico>>>> observable(MinaService minaService) {
                return minaService.bindDevice(str, str2, str3);
            }
        }, listener);
    }

    public static ApiRequest requestDecryptRc4(final String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass4 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.requestDecryptRc4(str);
            }
        }, listener);
    }

    public static ApiRequest unbindDevice(final String str, ApiRequest.Listener<List<String>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<String>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass5 */

            public final Observable<Response<MinaResponse<List<String>>>> observable(MinaService minaService) {
                return minaService.unbindDevice(str);
            }
        }, listener);
    }

    public static ApiRequest renameDevice(final String str, final String str2, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass6 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.renameDevice(str, str2);
            }
        }, listener);
    }

    public static ApiRequest getBanner(final int i, ApiRequest.Listener<Banner> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Banner>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass7 */

            public final Observable<Response<MinaResponse<Banner>>> observable(MinaService minaService) {
                return minaService.getBanner(i, MicoManager.getInstance().getCurrentMico().hardware, AreaCode.getLocation().getCode());
            }
        }, listener);
    }

    public static ApiRequest getSectionList(ApiRequest.Listener<List<Music.Section>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Music.Section>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass8 */

            public final Observable<Response<MinaResponse<List<Music.Section>>>> observable(MinaService minaService) {
                return minaService.getSectionList();
            }
        }, listener);
    }

    public static ApiRequest getSection(final long j, final int i, final int i2, ApiRequest.Listener<Music.Section> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Music.Section>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass9 */

            public final Observable<Response<MinaResponse<Music.Section>>> observable(MinaService minaService) {
                return minaService.getSection(j, i, i2);
            }
        }, listener);
    }

    public static ApiRequest getPatchWallFlow(final int i, final int i2, ApiRequest.Listener<PatchWall> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass10 */

            public final Observable<Response<MinaResponse<PatchWall>>> observable(MinaService minaService) {
                if (ApiConstants.getAreaCode() == AreaCode.TW) {
                    return minaService.getKkboxAudiobooxPathWallFlow(i, i2);
                }
                return minaService.getAudioBooksFlow(i, 3);
            }
        }, listener);
    }

    public static ApiRequest getNovelPatchWallFlow(final int i, int i2, ApiRequest.Listener<PatchWall> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass11 */

            public final Observable<Response<MinaResponse<PatchWall>>> observable(MinaService minaService) {
                return minaService.getNovelFlow(i, 3);
            }
        }, listener);
    }

    public static ApiRequest getTopQualityPatchWallFlow(final int i, int i2, ApiRequest.Listener<PatchWall> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass12 */

            public final Observable<Response<MinaResponse<PatchWall>>> observable(MinaService minaService) {
                return minaService.getTopQualityFlow(i, 3);
            }
        }, listener);
    }

    public static ApiRequest getQQPathWallFlowV2(final int i, final int i2, ApiRequest.Listener<PatchWall> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass13 */

            public final Observable<Response<MinaResponse<PatchWall>>> observable(MinaService minaService) {
                return minaService.getQQPathWallFlowV2(i, i2);
            }
        }, listener);
    }

    public static ApiRequest getKkboxPathWallFlow(final int i, final int i2, ApiRequest.Listener<PatchWall> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass14 */

            public final Observable<Response<MinaResponse<PatchWall>>> observable(MinaService minaService) {
                return minaService.getKkboxPathWallFlow(i, i2);
            }
        }, listener);
    }

    public static ApiRequest getQQPathWallFlow(final int i, final int i2, ApiRequest.Listener<PatchWall> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass15 */

            public final Observable<Response<MinaResponse<PatchWall>>> observable(MinaService minaService) {
                return minaService.getQQPathWallFlow(i, i2);
            }
        }, listener);
    }

    public static ApiRequest getMiPathWallFlow(final int i, final int i2, ApiRequest.Listener<PatchWall> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass16 */

            public final Observable<Response<MinaResponse<PatchWall>>> observable(MinaService minaService) {
                return minaService.getMiPathWallFlow(i, i2);
            }
        }, listener);
    }

    public static ApiRequest getPatchWallBlock(long j, int i, ApiRequest.Listener<PatchWall.Block> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider(j, i) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$EyPUaRGSi8ZBTAD4wDDTo4EqA */
            private final /* synthetic */ long f$0;
            private final /* synthetic */ int f$1;

            {
                this.f$0 = r1;
                this.f$1 = r3;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.getPathWallBlock(this.f$0, this.f$1);
            }
        }, listener);
    }

    public static ApiRequest getNovelPatchWallBlock(long j, int i, ApiRequest.Listener<PatchWall.Block> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider(j, i) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$OwAVUtZDBE_wxNY66zrYYbgyrw8 */
            private final /* synthetic */ long f$0;
            private final /* synthetic */ int f$1;

            {
                this.f$0 = r1;
                this.f$1 = r3;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.getNovelPathWallBlock(this.f$0, this.f$1);
            }
        }, listener);
    }

    public static ApiRequest getKnowledgePathWallBlock(long j, int i, ApiRequest.Listener<PatchWall.Block> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider(j, i) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$OL3882UTOh6zc1gkVZa63J3x5C4 */
            private final /* synthetic */ long f$0;
            private final /* synthetic */ int f$1;

            {
                this.f$0 = r1;
                this.f$1 = r3;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.getKnowledgePathWallBlock(this.f$0, this.f$1);
            }
        }, listener);
    }

    public static ApiRequest getTopQualityPatchWallBlock(long j, int i, ApiRequest.Listener<PatchWall.Block> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider(j, i) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$TeiD21QnarqqJOP_bfAqTygF4w */
            private final /* synthetic */ long f$0;
            private final /* synthetic */ int f$1;

            {
                this.f$0 = r1;
                this.f$1 = r3;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.getTopQualityPathWallBlock(this.f$0, this.f$1);
            }
        }, listener);
    }

    public static ApiRequest getQQPathWallBlock(final long j, final int i, ApiRequest.Listener<PatchWall.Block> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<PatchWall.Block>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass17 */

            public final Observable<Response<MinaResponse<PatchWall.Block>>> observable(MinaService minaService) {
                return minaService.getQQPathWallBlock(j, i);
            }
        }, listener);
    }

    public static ApiRequest getKidsPathWallBlock(final long j, final int i, ApiRequest.Listener<PatchWall.Block> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<PatchWall.Block>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass18 */

            public final Observable<Response<MinaResponse<PatchWall.Block>>> observable(MinaService minaService) {
                return minaService.getPathWallKidsBlock(j, i);
            }
        }, listener);
    }

    public static ApiRequest getKKboxPathWallBlock(final boolean z, final long j, final int i, ApiRequest.Listener<PatchWall.Block> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<PatchWall.Block>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass19 */

            public final Observable<Response<MinaResponse<PatchWall.Block>>> observable(MinaService minaService) {
                if (z) {
                    return minaService.getKKboxPathWallAudioBookBlock(j, i);
                }
                return minaService.getKKboxPathWallBlock(j, i);
            }
        }, listener);
    }

    public static ApiRequest getQQMusicLyric(final String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass20 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.getQQMusicLyric(LoginManager.getInstance().getPassportInfo().getUserId(), str);
            }
        }, listener);
    }

    public static ApiRequest getHotKeys(ApiRequest.Listener<List<String>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<String>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass21 */

            public final Observable<Response<MinaResponse<List<String>>>> observable(MinaService minaService) {
                return minaService.getHotKeys();
            }
        }, listener);
    }

    public static ApiRequest searchMusic(String str, int i, int i2, int i3, boolean z, ApiRequest.Listener<Music.SearchResult> listener) {
        final String str2 = str;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z2 = z;
        return ApiManager.getInstance().enqueue(new ApiProvider<Music.SearchResult>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass22 */

            public final Observable<Response<MinaResponse<Music.SearchResult>>> observable(MinaService minaService) {
                return minaService.searchMusic(str2, i4, i5, i6, z2);
            }
        }, listener);
    }

    public static ApiRequest getArtistInfo(final long j, ApiRequest.Listener<Music.Artist> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Music.Artist>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass23 */

            public final Observable<Response<MinaResponse<Music.Artist>>> observable(MinaService minaService) {
                return minaService.getArtistInfo(j);
            }
        }, listener);
    }

    public static ApiRequest getOriginNameMap(ApiRequest.Listener<Map<String, String>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Map<String, String>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass24 */

            public final Observable<Response<MinaResponse<Map<String, String>>>> observable(MinaService minaService) {
                return minaService.getOriginNameMap();
            }
        }, listener);
    }

    public static ApiRequest getArtistInfo(final List<Long> list, ApiRequest.Listener<List<Music.Artist>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Music.Artist>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass25 */

            public final Observable<Response<MinaResponse<List<Music.Artist>>>> observable(MinaService minaService) {
                return minaService.getArtistInfo(ApiHelper.sGson.toJson(list));
            }
        }, listener);
    }

    public static ApiRequest getArtistHomepage(final long j, ApiRequest.Listener<Music.ArtistHomepage> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Music.ArtistHomepage>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass26 */

            public final Observable<Response<MinaResponse<Music.ArtistHomepage>>> observable(MinaService minaService) {
                return minaService.getArtistHomepage(j);
            }
        }, listener);
    }

    public static ApiRequest getAlbumInfo(final long j, ApiRequest.Listener<Music.Album> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Music.Album>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass27 */

            public final Observable<Response<MinaResponse<Music.Album>>> observable(MinaService minaService) {
                return minaService.getAlbumInfo(j);
            }
        }, listener);
    }

    public static ApiRequest getAlbumInfo(final List<Long> list, ApiRequest.Listener<List<Music.Album>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Music.Album>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass28 */

            public final Observable<Response<MinaResponse<List<Music.Album>>>> observable(MinaService minaService) {
                return minaService.getAlbumInfo(ApiHelper.sGson.toJson(list));
            }
        }, listener);
    }

    public static ApiRequest getSongInfo(final long j, ApiRequest.Listener<Music.Song> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Music.Song>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass29 */

            public final Observable<Response<MinaResponse<Music.Song>>> observable(MinaService minaService) {
                return minaService.getSongInfo(j);
            }
        }, listener);
    }

    public static ApiRequest getSongInfo(final List<Long> list, ApiRequest.Listener<List<Music.Song>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Music.Song>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass30 */

            public final Observable<Response<MinaResponse<List<Music.Song>>>> observable(MinaService minaService) {
                return minaService.getSongInfo(ApiHelper.sGson.toJson(list));
            }
        }, listener);
    }

    public static ApiRequest getStationInfo(final Music.Station.Simple simple, ApiRequest.Listener<Music.Station> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Music.Station>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass31 */

            public final Observable<Response<MinaResponse<Music.Station>>> observable(MinaService minaService) {
                return minaService.getStationInfoV2(simple.globalId, simple.id, simple.origin != null ? simple.origin : "", simple.type, ApiConstants.getAreaCode().getCode());
            }
        }, listener);
    }

    public static ApiRequest getStationInfo(final List<Music.Station.Simple> list, ApiRequest.Listener<List<Music.Station>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Music.Station>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass32 */

            public final Observable<Response<MinaResponse<List<Music.Station>>>> observable(MinaService minaService) {
                return minaService.getStationInfo(ApiHelper.sGson.toJson(list), ApiConstants.getAreaCode().getCode());
            }
        }, listener);
    }

    public static ApiRequest getStationSoundList(String str, String str2, String str3, int i, int i2, String str4, Integer num, ApiRequest.Listener<Music.StationSoundList> listener) {
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final int i3 = i;
        final int i4 = i2;
        final String str8 = str4;
        final Integer num2 = num;
        return ApiManager.getInstance().enqueue(new ApiProvider<Music.StationSoundList>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass33 */

            public final Observable<Response<MinaResponse<Music.StationSoundList>>> observable(MinaService minaService) {
                String str = str5;
                String str2 = str6;
                String str3 = str2 == null ? "" : str2;
                String str4 = str7;
                return minaService.getStationSoundList(str, str3, str4 == null ? "" : str4, i3, i4, str8, num2);
            }
        }, listener);
    }

    public static ApiRequest like(final int i, final long j, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass34 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                int i = i;
                if (i == 4) {
                    return minaService.stationLike(j);
                }
                return minaService.like(i, j);
            }
        }, listener);
    }

    public static ApiRequest unlike(final int i, final long j, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass35 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                int i = i;
                if (i == 4) {
                    return minaService.stationUnlike(j);
                }
                return minaService.unlike(i, j);
            }
        }, listener);
    }

    public static ApiRequest bulkUnlike(final int i, final List<Long> list, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass36 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                int i = i;
                if (i == 4) {
                    return minaService.bulkStationUnlike(ApiHelper.sGson.toJson(list));
                }
                return minaService.bulkUnlike(i, ApiHelper.sGson.toJson(list));
            }
        }, listener);
    }

    public static ApiRequest getLikeStatus(final int i, final long j, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Boolean>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass37 */

            public final Observable<Response<MinaResponse<Boolean>>> observable(MinaService minaService) {
                int i = i;
                if (i == 4) {
                    return minaService.getStationLikeStatus(j);
                }
                return minaService.getLikeStatus(i, j);
            }
        }, listener);
    }

    public static ApiRequest getLikeStatus(final int i, final List<Long> list, ApiRequest.Listener<Map<String, Boolean>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Map<String, Boolean>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass38 */

            public final Observable<Response<MinaResponse<Map<String, Boolean>>>> observable(MinaService minaService) {
                return minaService.getLikeStatus(i, ApiHelper.sGson.toJson(list));
            }
        }, listener);
    }

    public static ApiRequest getFavouriteStatus(final String str, ApiRequest.Listener<List<Music.Favourite>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Music.Favourite>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass39 */

            public final Observable<Response<MinaResponse<List<Music.Favourite>>>> observable(MinaService minaService) {
                return minaService.getFavouriteStatus(str);
            }
        }, listener);
    }

    public static ApiRequest getLikeList(final int i, ApiRequest.Listener<List<Long>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Long>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass40 */

            public final Observable<Response<MinaResponse<List<Long>>>> observable(MinaService minaService) {
                return minaService.getLikeList(i);
            }
        }, listener);
    }

    public static ApiRequest getStationLikeList(final String str, ApiRequest.Listener<List<Music.Station>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Music.Station>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass41 */

            public final Observable<Response<MinaResponse<List<Music.Station>>>> observable(MinaService minaService) {
                return minaService.getCollection(str);
            }
        }, listener);
    }

    public static ApiRequest getStationLikeList(ApiRequest.Listener<List<Music.Station>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Music.Station>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass42 */

            public final Observable<Response<MinaResponse<List<Music.Station>>>> observable(MinaService minaService) {
                return minaService.getStationCollected();
            }
        }, listener);
    }

    public static ApiRequest getChannelList(ApiRequest.Listener<List<Music.Channel>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Music.Channel>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass43 */

            public final Observable<Response<MinaResponse<List<Music.Channel>>>> observable(MinaService minaService) {
                return minaService.getChannelList();
            }
        }, listener);
    }

    public static ApiRequest createChannel(final String str, ApiRequest.Listener<Long> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Long>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass44 */

            public final Observable<Response<MinaResponse<Long>>> observable(MinaService minaService) {
                return minaService.createChannel(str);
            }
        }, listener);
    }

    public static ApiRequest deleteChannel(final long j, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Boolean>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass45 */

            public final Observable<Response<MinaResponse<Boolean>>> observable(MinaService minaService) {
                return minaService.deleteChannel(j);
            }
        }, listener);
    }

    public static ApiRequest renameChannel(final long j, final String str, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Boolean>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass46 */

            public final Observable<Response<MinaResponse<Boolean>>> observable(MinaService minaService) {
                return minaService.renameChannel(j, str);
            }
        }, listener);
    }

    public static ApiRequest getChannelInfo(final long j, final int i, final int i2, ApiRequest.Listener<Music.Channel> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Music.Channel>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass47 */

            public final Observable<Response<MinaResponse<Music.Channel>>> observable(MinaService minaService) {
                return minaService.getChannelInfo(j, i, i2);
            }
        }, listener);
    }

    public static ApiRequest getSongsInChannel(final long j, final int i, final int i2, ApiRequest.Listener<Music.Channel> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Music.Channel>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass48 */

            public final Observable<Response<MinaResponse<Music.Channel>>> observable(MinaService minaService) {
                return minaService.getSongsInChannel(j, i, i2);
            }
        }, listener);
    }

    public static String buildSimpleSongJsonArray(List<Music.Song> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Music.Song simple : list) {
            arrayList.add(simple.toSimple());
        }
        return sGson.toJson(arrayList);
    }

    public static ApiRequest addSongs(final long j, final List<Music.Song> list, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Boolean>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass49 */

            public final Observable<Response<MinaResponse<Boolean>>> observable(MinaService minaService) {
                return minaService.addSongs(j, ApiHelper.buildSimpleSongJsonArray(list));
            }
        }, listener);
    }

    public static ApiRequest deleteSongs(final long j, final List<Music.Song> list, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Boolean>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass50 */

            public final Observable<Response<MinaResponse<Boolean>>> observable(MinaService minaService) {
                return minaService.deleteSongs(j, ApiHelper.buildSimpleSongJsonArray(list));
            }
        }, listener);
    }

    public static ApiRequest bindTencentAccount(String str, String str2, String str3, String str4, String str5, long j, ApiRequest.Listener<String> listener) {
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        final long j2 = j;
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass51 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.bindTencentService(str6, str7, str8, str9, str10, j2);
            }
        }, listener);
    }

    public static ApiRequest uploadRomLog(final String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass52 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.uploadLog(str);
            }
        }, listener);
    }

    public static ApiRequest upgrade(final String str, final String str2, final String str3, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass53 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.upgrade(str, str2, str3);
            }
        }, listener);
    }

    public static ApiRequest upgradeV2(String str, String str2, String str3, String str4, String str5, String str6, ApiRequest.Listener<String> listener) {
        final String str7 = str;
        final String str8 = str2;
        final String str9 = str3;
        final String str10 = str4;
        final String str11 = str5;
        final String str12 = str6;
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass54 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.upgradeV2(str7, str8, str9, str10, str11, str12);
            }
        }, listener);
    }

    public static ApiRequest getRomUpgradeStatus(final String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass55 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.getDeviceStatus(str, "u");
            }
        }, listener);
    }

    public static ApiRequest setDeviceStatus(final String str, final String str2, final String str3, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass56 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.setDeviceStatus(str, str2, str3);
            }
        }, listener);
    }

    private static String getUpdateHash(String str, String str2, String str3, String str4, String str5, String str6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("model", str));
        arrayList.add(new Pair("version", str2));
        arrayList.add(new Pair("channel", str3));
        arrayList.add(new Pair("filterID", str4));
        arrayList.add(new Pair("locale", str5));
        arrayList.add(new Pair("time", str6));
        Collections.sort(arrayList, new Comparator<Pair<String, String>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass57 */

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return compare((Pair<String, String>) ((Pair) obj), (Pair<String, String>) ((Pair) obj2));
            }

            public final int compare(Pair<String, String> pair, Pair<String, String> pair2) {
                return ((String) pair.first).compareTo((String) pair2.first);
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z) {
                sb.append("&");
            }
            sb.append((String) pair.first);
            sb.append("=");
            sb.append((String) pair.second);
            z = false;
        }
        sb.append("&8007236f-a2d6-4847-ac83-c49395ad6d65");
        return gqb.O00000oO(Base64Coder.encode(gqb.O00000oo(sb.toString())));
    }

    public static ApiRequest enableBluetooth(boolean z, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("mibt").method("enable").param("btmode", "classic").param("action", z ? "open" : "close").listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest enableBluetooth(boolean z, boolean z2, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("mibt").method("enable").param("btmode", "classic").param("connect", z ? 1 : 0).param("discover", z2 ? 1 : 0).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest enableBluetoothConnectOnly(String str, boolean z, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(str).path("mibt").method("enable").param("btmode", "classic").param("connect", z ? 1 : 0).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest getBluetoothInfo(ApiRequest.Listener<Remote.Response.BluetoothResponse> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("mibt").method("status").param("btmode", "classic").listener(listener).classOf(Remote.Response.BluetoothResponse.class).build();
    }

    public static ApiRequest getBluetoothInfo(String str, ApiRequest.Listener<Remote.Response.BluetoothResponse> listener) {
        return new Remote.Builder().deviceId(str).path("mibt").method("status").param("btmode", "classic").listener(listener).classOf(Remote.Response.BluetoothResponse.class).build();
    }

    public static ApiRequest connectBluetoothDevice(String str, String str2, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("mibt").method("connect").param("mac", str).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest scanBluetooth(ApiRequest.Listener<Remote.Response.BluetoothScan> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("mibt").method("scan_bt").listener(listener).classOf(Remote.Response.BluetoothScan.class).build();
    }

    public static ApiRequest getBluetoothScanList(ApiRequest.Listener<Remote.Response.BluetoothScanInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("mibt").method("get_scan_bt").listener(listener).classOf(Remote.Response.BluetoothScanInfo.class).build();
    }

    public static ApiRequest switchBluetoothRole(String str, ApiRequest.Listener<Remote.Response.BluetoothResponse> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("mibt").method("switch_role").param("btrole", str).listener(listener).classOf(Remote.Response.BluetoothResponse.class).build();
    }

    public static ApiRequest connectBluetoothAndPlay(String str, ApiRequest.Listener<Remote.Response.BluetoothResponse> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("mibt").method("connect_and_play").param("mac", str).listener(listener).classOf(Remote.Response.BluetoothResponse.class).build();
    }

    public static ApiRequest disconnectBluetoothDevice(ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("mibt").method("disconnect").listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest unpairBluetoothDevice(String str, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("mibt").method("unpair").param("mac", str).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest setStereoNameToBluetooth(String str, String str2, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(str).path("mibt").method("set_device_info").param("name", str2).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest getMiTvList(ApiRequest.Listener<Remote.Response.MiTvResponse> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("upnp-disc").method("list").listener(listener).classOf(Remote.Response.MiTvResponse.class).build();
    }

    public static ApiRequest setDefaultMiTv(String str, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("upnp-disc").method("select").param("udn", str).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest setConnectTv(boolean z, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("pnshelper").method("event_notify").param("src", 2).param("event", z ? 4 : 5).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest queryConnectTv(ApiRequest.Listener<Remote.Response.ConnectTvState> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("pnshelper").method("event_notify").param("src", 2).param("event", 6).listener(listener).classOf(Remote.Response.ConnectTvState.class).build();
    }

    public static ApiRequest enableUpnpFeature(boolean z, ApiRequest.Listener<Remote.Response.MiTvResponse> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("upnp-disc").method("enable").param("enable", z ? 1 : 0).listener(listener).classOf(Remote.Response.MiTvResponse.class).build();
    }

    public static ApiRequest createOrUpdateAlarm(String str, long j, int i, int i2, String str2, String str3, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("alarm").method(TextUtils.isEmpty(str) ? "alarm_create" : "alarm_modify").param("id", str).param("type", "alarm").param("timestamp", j).param("circle", i).param("volume", i2).param("event", str2).param("extra", str3).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest createOrUpdateAlarmV2(Remote.Response.Alarm alarm, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        String str = "";
        Remote.Builder param = new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("alarm").method(TextUtils.isEmpty(alarm.id) ? "alarm_create" : "alarm_modify").param("id", alarm.id).param("type", "alarm").param("timestamp", alarm.timestamp / 1000).param("circle", alarm.circle).param("volume", alarm.volume).param("event", TextUtils.isEmpty(alarm.event) ? str : alarm.event).param("extra", alarm.extra).param("ringtone_type", TextUtils.isEmpty(alarm.ringToneType) ? str : alarm.ringToneType);
        if (!TextUtils.isEmpty(alarm.ringToneQuery)) {
            str = alarm.ringToneQuery;
        }
        return param.param("ringtone_query", str).param("display_txt", alarm.displayTxt).param("time_reminder", alarm.timeReminder).param("ringtone_video", alarm.ringToneVideo).param("ringtone_video_image", alarm.ringToneVideoImage).param("lazy_flag", alarm.lazyFlag).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest createOrUpdateTimer(String str, long j, int i, String str2, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("alarm").method(TextUtils.isEmpty(str) ? "alarm_create" : "alarm_modify").param("id", str).param("type", "timer").param("timestamp", j).param("volume", i).param("event", str2).param("circle", 0).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest getAlarm(ApiRequest.Listener<Remote.Response.AlarmResponse> listener) {
        return doGetAlarmOrTimer("alarm", listener);
    }

    public static ApiRequest getTimer(ApiRequest.Listener<Remote.Response.AlarmResponse> listener) {
        return doGetAlarmOrTimer("timer", listener);
    }

    private static ApiRequest doGetAlarmOrTimer(String str, ApiRequest.Listener<Remote.Response.AlarmResponse> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("alarm").method("alarm_query").param("type", str).listener(listener).classOf(Remote.Response.AlarmResponse.class).build();
    }

    public static ApiRequest enableAlarm(String str, boolean z, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return doEnableAlarmOrTimer("alarm", str, z, listener);
    }

    public static ApiRequest enableTimer(String str, boolean z, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return doEnableAlarmOrTimer("timer", str, z, listener);
    }

    private static ApiRequest doEnableAlarmOrTimer(String str, String str2, boolean z, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("alarm").method(z ? "alarm_open" : "alarm_close").param("type", str).param("id", str2).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest deleteAlarm(String str, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return doDeleteAlarmOrTimer("alarm", str, listener);
    }

    public static ApiRequest deleteTimer(String str, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return doDeleteAlarmOrTimer("timer", str, listener);
    }

    private static ApiRequest doDeleteAlarmOrTimer(String str, String str2, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("alarm").method("alarm_delete").param("type", str).param("id", str2).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest getMemoList(ApiRequest.Listener<List<Remote.Response.Memo>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Remote.Response.Memo>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass58 */

            public final Observable<Response<MinaResponse<List<Remote.Response.Memo>>>> observable(MinaService minaService) {
                return minaService.getMemoList(ApiConstants.localeIdentifierUppercase());
            }
        }, listener);
    }

    public static ApiRequest addMemo(final String str, ApiRequest.Listener<Long> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Long>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass59 */

            public final Observable<Response<MinaResponse<Long>>> observable(MinaService minaService) {
                return minaService.addMemo(str);
            }
        }, listener);
    }

    public static ApiRequest updateMemo(final long j, final String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass60 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.updateMemo(j, str);
            }
        }, listener);
    }

    public static ApiRequest deleteMemo(final long j, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass61 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.deleteMemo(j);
            }
        }, listener);
    }

    public static ApiRequest getArtistList(final int i, final int i2, ApiRequest.Listener<List<Music.Artist>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Music.Artist>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass62 */

            public final Observable<Response<MinaResponse<List<Music.Artist>>>> observable(MinaService minaService) {
                return minaService.getArtistList(i, i2);
            }
        }, listener);
    }

    public static ApiRequest getSelectedArtistList(ApiRequest.Listener<List<Long>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Long>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass63 */

            public final Observable<Response<MinaResponse<List<Long>>>> observable(MinaService minaService) {
                return minaService.getSelectedArtistList();
            }
        }, listener);
    }

    public static ApiRequest setSelectedArtistList(final List<Long> list, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass64 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.setSelectedArtistList(ApiHelper.sGson.toJson(list));
            }
        }, listener);
    }

    public static ApiRequest getMusicGenreList(final int i, final int i2, ApiRequest.Listener<List<String>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<String>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass65 */

            public final Observable<Response<MinaResponse<List<String>>>> observable(MinaService minaService) {
                return minaService.getMusicGenreList(i, i2);
            }
        }, listener);
    }

    public static ApiRequest setMusicGenreList(final List<String> list, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass66 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.setSelectedGenreList(ApiHelper.sGson.toJson(list));
            }
        }, listener);
    }

    public static ApiRequest getSelectedMusicGenreList(ApiRequest.Listener<List<String>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<String>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass67 */

            public final Observable<Response<MinaResponse<List<String>>>> observable(MinaService minaService) {
                return minaService.getSelectedGenreList();
            }
        }, listener);
    }

    public static ApiRequest removePlateInfo(int i, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider(i) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$cwKYDpt5O1UQ86bqog3FTHwwV1w */
            private final /* synthetic */ int f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.removePlateInfo(LoginManager.getInstance().getPassportInfo().getUserId(), this.f$0);
            }
        }, listener);
    }

    public static ApiRequest registerPushInfo(final String str, final String str2, final String str3, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass68 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.registerPushInfo(str, 2, str2, str3);
            }
        }, listener);
    }

    public static ApiRequest getMiBrainLevel(final String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass69 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.getMiBrainLevel(str);
            }
        }, listener);
    }

    public static ApiRequest setMiBrainLevel(final String str, final String str2, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass70 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.setMiBrainLevel(str, str2);
            }
        }, listener);
    }

    public static ApiRequest getUserRating(final String str, ApiRequest.Listener<Integer> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Integer>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass71 */

            public final Observable<Response<MinaResponse<Integer>>> observable(MinaService minaService) {
                return minaService.getUserRating(str);
            }
        }, listener);
    }

    public static ApiRequest setUserRating(final String str, final int i, final String str2, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Boolean>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass72 */

            public final Observable<Response<MinaResponse<Boolean>>> observable(MinaService minaService) {
                return minaService.setUserRating(str, i, str2);
            }
        }, listener);
    }

    public static ApiRequest setOAuthToken(String str, String str2, long j, String str3, String str4, ApiRequest.Listener<String> listener) {
        final String str5 = str;
        final String str6 = str2;
        final long j2 = j;
        final String str7 = str3;
        final String str8 = str4;
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass73 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.setOAuthToken(str5, str6, j2, str7, str8);
            }
        }, listener);
    }

    public static ApiRequest getOAuthInfo(final String str, ApiRequest.Listener<MiBrain.OAuthInfo> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<MiBrain.OAuthInfo>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass74 */

            public final Observable<Response<MinaResponse<MiBrain.OAuthInfo>>> observable(MinaService minaService) {
                return minaService.getOAuthInfo(str);
            }
        }, listener);
    }

    public static ApiRequest deleteOAuthInfo(final String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass75 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.deleteOAuthInfo(str);
            }
        }, listener);
    }

    public static ApiRequest getNlpResult(ApiRequest.Listener<Remote.Response.DebugMessage> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("mibrain").method("nlp_result_get").listener(listener).classOf(Remote.Response.DebugMessage.class).build();
    }

    public static ApiRequest getTone(ApiRequest.Listener<Remote.Response.Tone> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("mibrain").method("tts_vendor_show").listener(listener).classOf(Remote.Response.Tone.class).build();
    }

    public static ApiRequest sendToneSwitch(String str, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("mibrain").method("tts_vendor_switch").param("vendor_name", str).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest sendTTSText(String str, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("mibrain").method("text_to_speech").param("text", str).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest sendMusicSourceChange(String str, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(str).path("homepage").method("music_source_change").listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest sendMusicSourceChange(String str, String str2, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(str).path("homepage").method("music_source_change").param("source", str2).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest sendCpAccountBindStatusChanged(String str, boolean z, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(str).path("homepage").method("cp_account_bind_status_changed").param("bind", z).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest tencentWechatBind(final String str, final String str2, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass76 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.tencentWechatBind(str, "OAuth2Code", "com.tencent.weixin", str2);
            }
        }, listener);
    }

    public static ApiRequest tencentQQBind(String str, String str2, long j, String str3, ApiRequest.Listener<String> listener) {
        final String str4 = str;
        final String str5 = str2;
        final long j2 = j;
        final String str6 = str3;
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass77 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.tencentQQBind(str4, "OAuth2AccessToken", "com.tencent.qq", str5, j2, str6);
            }
        }, listener);
    }

    public static ApiRequest tencentQQUnbind(String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider(str) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$u7n4OH9IidyiO6WSM8sWNFLJibg */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.tencentQQUnbind(this.f$0);
            }
        }, listener);
    }

    public static ApiRequest getQQBindStatus(ApiRequest.Listener<MiBrain.CPBindStatus> listener) {
        return ApiManager.getInstance().enqueue($$Lambda$ApiHelper$uT4hkwIOkftT5BUuWmByAfGmRsk.INSTANCE, listener);
    }

    public static ApiRequest getQQAccountInfo(Long l, String str, ApiRequest.Listener<MiBrain.CPAccountInfo> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider(l, str) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$zqP7CjQFJFpSK5n3xGtKaKLlo8 */
            private final /* synthetic */ Long f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.getQQAccountInfo(this.f$0.longValue(), this.f$1);
            }
        }, listener);
    }

    public static ApiRequest setPlayerShutdownTimer(int i, int i2, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(PlayerManager.getInstance().getQueryDeviceId()).path("mediaplayer").method("player_set_shutdown_timer").param("action", "pause_later").param("hour", i).param("minute", i2).param("second", 0).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest cancelPlayerShutdownTimer(ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(PlayerManager.getInstance().getQueryDeviceId()).path("mediaplayer").method("player_set_shutdown_timer").param("action", "cancel_ending").listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest getPlayerShutdownTimer(ApiRequest.Listener<Remote.Response.PlayerShutdownTimerResp> listener) {
        return new Remote.Builder().deviceId(PlayerManager.getInstance().getQueryDeviceId()).path("mediaplayer").method("get_shutdown_timer").listener(listener).classOf(Remote.Response.PlayerShutdownTimerResp.class).build();
    }

    public static ApiRequest getNightModeStatus(ApiRequest.Listener<Remote.Response.NightMode> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("nightmode").method("status").listener(listener).classOf(Remote.Response.NightMode.class).build();
    }

    public static ApiRequest setNightMode(Remote.Response.NightMode nightMode, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("nightmode").method("set").param("total", nightMode.getMode()).param("light", nightMode.getLight()).param("volume", nightMode.getVolume()).param("start", nightMode.getStart()).param("stop", nightMode.getStop()).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest getNearbyWakeupStatus(ApiRequest.Listener<Remote.Response.VoiceInteraction> listener) {
        return buildVoiceInteractionGetRequest(listener, 2);
    }

    public static ApiRequest getContinuousConversationStatus(ApiRequest.Listener<Remote.Response.VoiceInteraction> listener) {
        return buildVoiceInteractionGetRequest(listener, 6);
    }

    private static ApiRequest buildVoiceInteractionGetRequest(ApiRequest.Listener<Remote.Response.VoiceInteraction> listener, int i) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("pnshelper").method("event_notify").param("src", 2).param("event", i).listener(listener).classOf(Remote.Response.VoiceInteraction.class).build();
    }

    public static ApiRequest setNearbyWakeupStatus(String str, int i, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return buildVoiceInteractionSetRequest(str, i, listener);
    }

    public static ApiRequest setContinuousConversationStatus(int i, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return buildVoiceInteractionSetRequest(MicoManager.getInstance().getCurrentMicoID(), i, listener);
    }

    private static ApiRequest buildVoiceInteractionSetRequest(String str, int i, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(str).path("pnshelper").method("event_notify").param("src", 2).param("event", i).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest getMicoLanGroup(String str, String str2, String str3, final ApiRequest.Listener<MicoLanGroup> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, str2, str3) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$PKplHR5COtQZNYwWVzs7kL96ObM */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).getMicoLanGroup(this.f$0, this.f$1, this.f$2);
            }
        }, MinaService.class, new ApiRequest.Listener<MicoLanGroup>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass78 */

            public final void onSuccess(MicoLanGroup micoLanGroup) {
                Threadpool.getSharedThreadPool().submit(new Runnable(listener) {
                    /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$78$FHx1Y6zYNouA4pTkZ0vCZq4Y0nw */
                    private final /* synthetic */ ApiRequest.Listener f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        ApiHelper.AnonymousClass78.lambda$onSuccess$0(MicoLanGroup.this, this.f$1);
                    }
                });
            }

            static /* synthetic */ void lambda$onSuccess$0(MicoLanGroup micoLanGroup, ApiRequest.Listener listener) {
                List<Admin.Mico> micoList = MicoManager.getInstance().getMicoList();
                if (micoList != null) {
                    ApiHelper.assignLanGroupData(micoLanGroup.lanGroupInfo.stereoLanList, micoList);
                    ApiHelper.assignLanGroupData(micoLanGroup.lanGroupInfo.multiRoomLanList, micoList);
                    ApiHelper.assignLanGroupData(micoLanGroup.lanGroupInfo.wakeUpLanList, micoList);
                    ApiHelper.assignPairedGroupData(micoLanGroup.pairedGroupInfo, micoList);
                }
                listener.onSuccess(micoLanGroup);
            }

            public final void onFailure(ApiError apiError) {
                listener.onFailure(apiError);
            }
        });
    }

    public static void assignLanGroupData(List<LanGroupInfo.LanGroup> list, List<Admin.Mico> list2) {
        for (LanGroupInfo.LanGroup next : list) {
            int size = next.devices.size();
            for (int i = 0; i < size; i++) {
                DeviceState deviceState = next.devices.get(i);
                for (Admin.Mico next2 : list2) {
                    if (i == size - 1 && !TextUtils.isEmpty(deviceState.deviceName)) {
                        break;
                    } else if (next2.isOnline() && deviceState.deviceId.equalsIgnoreCase(next2.deviceID)) {
                        deviceState.deviceName = next2.name;
                        deviceState.hardware = next2.hardware;
                    }
                }
            }
        }
        for (LanGroupInfo.LanGroup lanGroup : list) {
            Iterator<DeviceState> it = lanGroup.devices.iterator();
            while (it.hasNext()) {
                DeviceState next3 = it.next();
                if (TextUtils.isEmpty(next3.deviceName) || TextUtils.isEmpty(next3.hardware)) {
                    it.remove();
                }
            }
        }
    }

    public static void assignPairedGroupData(PairedGroupInfo pairedGroupInfo, List<Admin.Mico> list) {
        List<StereoData.StereoGroup> list2 = pairedGroupInfo.stereoList;
        if (!list2.isEmpty()) {
            for (StereoData.StereoGroup next : list2) {
                for (Admin.Mico next2 : list) {
                    if (!TextUtils.isEmpty(next.leftDeviceName) && !TextUtils.isEmpty(next.rightDeviceName)) {
                        break;
                    } else if (next2.isOnline()) {
                        if (next.leftDeviceId.equalsIgnoreCase(next2.deviceID)) {
                            next.leftDeviceName = next2.name;
                            next.leftDeviceHardware = next2.hardware;
                        }
                        if (next.rightDeviceId.equalsIgnoreCase(next2.deviceID)) {
                            next.rightDeviceName = next2.name;
                            next.rightDeviceHardware = next2.hardware;
                        }
                    }
                }
            }
            Iterator<StereoData.StereoGroup> it = list2.iterator();
            while (it.hasNext()) {
                StereoData.StereoGroup next3 = it.next();
                next3.leftUnknownError = TextUtils.isEmpty(next3.leftDeviceName);
                next3.rightUnknownError = TextUtils.isEmpty(next3.rightDeviceName);
                Admin.Mico currentMico = MicoManager.getInstance().getCurrentMico();
                if (currentMico != null && currentMico.isOnline()) {
                    String str = TextUtils.isEmpty(next3.server) ? next3.leftDeviceId : next3.server;
                    if (next3.leftDeviceId.equalsIgnoreCase(currentMico.deviceID) || next3.rightDeviceId.equalsIgnoreCase(currentMico.deviceID)) {
                        new Object[1][0] = "ApiHelper assignPairedGroupData stereo setQueryDeviceId ".concat(String.valueOf(str));
                        PlayerManager.getInstance().setQueryDeviceId(str);
                    }
                }
                String str2 = next3.leftDeviceId;
                String str3 = next3.rightDeviceId;
                if (MicoManager.getInstance().getMicoByDeviceId(str2) == null || MicoManager.getInstance().getMicoByDeviceId(str3) == null) {
                    it.remove();
                    deleteGroup(next3.groupId);
                }
            }
            MicoManager.getInstance().setStereoGroup(list2);
            MicoManager.getInstance().saveStereoGroupJson(GsonUtil.getGsonInstance().toJson(list2));
        } else {
            MicoManager.getInstance().clearStereoData(false);
            MicoManager.getInstance().setStereoGroup(null);
        }
        assignMultiDeviceData(pairedGroupInfo.multiRoom, list);
    }

    private static void deleteGroup(String str) {
        deleteStereoGroup(str, new ApiRequest.Listener<Boolean>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass79 */

            public final void onSuccess(Boolean bool) {
                new Object[1][0] = new StringBuilder("ReminderChecker deleteGroup success: %s 2132674920").toString();
            }

            public final void onFailure(ApiError apiError) {
                new Object[1][0] = "ReminderChecker deleteGroup : %s " + apiError.toString();
            }
        });
    }

    private static void assignMultiDeviceData(MultiRoomData multiRoomData, List<Admin.Mico> list) {
        Admin.Mico currentMico;
        if (multiRoomData != null) {
            List<MultiRoomData.MultiRoomGroup> list2 = multiRoomData.groups;
            if (list2 == null || list2.isEmpty()) {
                MicoManager.getInstance().clearMultiRoomJson();
                MicoManager.getInstance().setMultiRoomGroup(null);
                return;
            }
            Iterator<MultiRoomData.MultiRoomGroup> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MultiRoomData.MultiRoomGroup next = it.next();
                if (!next.members.isEmpty()) {
                    List<MultiRoomData.MultiRoomMember> list3 = next.members;
                    for (MultiRoomData.MultiRoomMember next2 : list3) {
                        for (Admin.Mico next3 : list) {
                            if (!TextUtils.isEmpty(next2.name)) {
                                break;
                            } else if (next3.isOnline() && next2.deviceId.equalsIgnoreCase(next3.deviceID)) {
                                next2.name = next3.name;
                                next2.hardWare = next3.hardware;
                            }
                        }
                    }
                    for (MultiRoomData.MultiRoomMember next4 : list3) {
                        next4.unKnownError = TextUtils.isEmpty(next4.name);
                    }
                }
            }
            multiRoomData.groups = list2;
            MultiRoomData.MultiRoomGroup multiRoomGroup = list2.get(0);
            MicoManager.getInstance().saveMultiRoomJson(GsonUtil.getGsonInstance().toJson(multiRoomGroup));
            MicoManager.getInstance().setMultiRoomGroup(multiRoomGroup);
            if (multiRoomGroup != null && (currentMico = MicoManager.getInstance().getCurrentMico()) != null && currentMico.isOnline()) {
                String str = multiRoomGroup.server;
                for (MultiRoomData.MultiRoomMember multiRoomMember : multiRoomGroup.members) {
                    if (multiRoomMember.deviceId.equalsIgnoreCase(currentMico.deviceID)) {
                        new Object[1][0] = "ApiHelper assignPairedGroupData MultiRoom setQueryDeviceId ".concat(String.valueOf(str));
                        PlayerManager.getInstance().setQueryDeviceId(str);
                        return;
                    }
                }
            }
        }
    }

    public static void assignStereoDeviceData(StereoData stereoData, List<Admin.Mico> list) {
        List<StereoData.StereoGroup> list2 = stereoData.stereoList;
        if (list2.isEmpty()) {
            List<LanGroupInfo.LanGroup> list3 = stereoData.lanDeviceInfoList;
            for (LanGroupInfo.LanGroup next : list3) {
                int size = next.devices.size();
                for (int i = 0; i < size; i++) {
                    DeviceState deviceState = next.devices.get(i);
                    for (Admin.Mico next2 : list) {
                        if (i == size - 1 && !TextUtils.isEmpty(deviceState.deviceName)) {
                            break;
                        } else if (next2.isOnline() && deviceState.deviceId.equalsIgnoreCase(next2.deviceID)) {
                            deviceState.deviceName = next2.name;
                            deviceState.hardware = next2.hardware;
                        }
                    }
                }
            }
            for (LanGroupInfo.LanGroup lanGroup : list3) {
                Iterator<DeviceState> it = lanGroup.devices.iterator();
                while (it.hasNext()) {
                    if (TextUtils.isEmpty(it.next().deviceName)) {
                        it.remove();
                    }
                }
            }
            stereoData.lanDeviceInfoList = list3;
            return;
        }
        for (StereoData.StereoGroup next3 : list2) {
            for (Admin.Mico next4 : list) {
                if (!TextUtils.isEmpty(next3.leftDeviceName) && !TextUtils.isEmpty(next3.rightDeviceName)) {
                    break;
                }
                if (next3.leftDeviceId.equalsIgnoreCase(next4.deviceID)) {
                    next3.leftDeviceName = next4.name;
                    next3.leftDeviceHardware = next4.hardware;
                }
                if (next3.rightDeviceId.equalsIgnoreCase(next4.deviceID)) {
                    next3.rightDeviceName = next4.name;
                    next3.rightDeviceHardware = next4.hardware;
                }
            }
        }
        for (StereoData.StereoGroup next5 : list2) {
            next5.leftUnknownError = TextUtils.isEmpty(next5.leftDeviceName);
            next5.rightUnknownError = TextUtils.isEmpty(next5.rightDeviceName);
        }
        stereoData.stereoList = list2;
        MicoManager.getInstance().saveStereoGroupJson(GsonUtil.getGsonInstance().toJson(list2));
        MicoManager.getInstance().setStereoGroup(list2);
    }

    @Deprecated
    public static ApiRequest getUserStereoGroup(String str, String str2, String str3, final ApiRequest.Listener<StereoData> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, str2, str3) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$B188A99zfga7HNWS3XUOM9HGL7k */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).getStereoGroup(this.f$0, this.f$1, this.f$2);
            }
        }, MinaService.class, new ApiRequest.Listener<StereoData>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass80 */

            public final void onSuccess(StereoData stereoData) {
                Threadpool.getSharedThreadPool().submit(new Runnable(listener) {
                    /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$80$1f7KBHFHoxECuGHE6VZGldWQNhs */
                    private final /* synthetic */ ApiRequest.Listener f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        ApiHelper.AnonymousClass80.lambda$onSuccess$0(StereoData.this, this.f$1);
                    }
                });
            }

            static /* synthetic */ void lambda$onSuccess$0(StereoData stereoData, ApiRequest.Listener listener) {
                List<Admin.Mico> micoList = MicoManager.getInstance().getMicoList();
                if (micoList != null) {
                    ApiHelper.assignStereoDeviceData(stereoData, micoList);
                }
                listener.onSuccess(stereoData);
            }

            public final void onFailure(ApiError apiError) {
                listener.onFailure(apiError);
            }
        });
    }

    public static ApiRequest createStereoGroup(String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$IiZp1qWJrZeAdDC3HB6G3j3eTTw */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).createStereoGroup(this.f$0);
            }
        }, MinaService.class, listener);
    }

    public static ApiRequest updateStereoGroup(String str, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$z15bBEMPpePwHhO4UKNE9LzgKVg */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).updateStereoGroup(this.f$0);
            }
        }, MinaService.class, listener);
    }

    public static ApiRequest deleteStereoGroup(String str, ApiRequest.Listener<Boolean> listener) {
        ArrayList arrayList = new ArrayList();
        String multiRoomJson = MicoManager.getInstance().getMultiRoomJson();
        if (!TextUtils.isEmpty(multiRoomJson)) {
            List<MultiRoomData.MultiRoomMember> list = ((MultiRoomData.MultiRoomGroup) GsonUtil.getGsonInstance().fromJson(multiRoomJson, MultiRoomData.MultiRoomGroup.class)).members;
            Gson create = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            for (MultiRoomData.MultiRoomMember json : list) {
                arrayList.add(create.toJson(json));
            }
        }
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, arrayList) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$qpIC7zH3U9fjNLVaOiojHzpNiZ8 */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ List f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).deleteStereoGroup(this.f$0, this.f$1.toString());
            }
        }, MinaService.class, listener);
    }

    @Deprecated
    public static ApiRequest getMultiRoomGroup(String str, String str2, String str3, final ApiRequest.Listener<MultiRoomData.MultiRoomGroup> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, str2, str3) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$h2SfevCiCyTNqIT_iBTIlryQc */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).getMultiRoomGroup(this.f$0, this.f$1, this.f$2);
            }
        }, MinaService.class, new ApiRequest.Listener<MultiRoomData>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass81 */

            public final void onSuccess(MultiRoomData multiRoomData) {
                Threadpool.getSharedThreadPool().submit(new Runnable(listener) {
                    /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$81$ZS1vq7nBBaRSiWK6HYfT0B0ZUWE */
                    private final /* synthetic */ ApiRequest.Listener f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        ApiHelper.AnonymousClass81.lambda$onSuccess$0(MultiRoomData.this, this.f$1);
                    }
                });
            }

            static /* synthetic */ void lambda$onSuccess$0(MultiRoomData multiRoomData, ApiRequest.Listener listener) {
                List<Admin.Mico> micoList = MicoManager.getInstance().getMicoList();
                boolean z = false;
                if (micoList != null) {
                    List<MultiRoomData.MultiRoomGroup> list = multiRoomData.groups;
                    if (!list.isEmpty()) {
                        Iterator<MultiRoomData.MultiRoomGroup> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            MultiRoomData.MultiRoomGroup next = it.next();
                            if (!next.members.isEmpty()) {
                                List<MultiRoomData.MultiRoomMember> list2 = next.members;
                                for (MultiRoomData.MultiRoomMember next2 : list2) {
                                    for (Admin.Mico next3 : micoList) {
                                        if (!TextUtils.isEmpty(next2.name)) {
                                            break;
                                        } else if (next3.isOnline() && next2.deviceId.equalsIgnoreCase(next3.deviceID)) {
                                            next2.name = next3.name;
                                            next2.hardWare = next3.hardware;
                                        }
                                    }
                                }
                                for (MultiRoomData.MultiRoomMember next4 : list2) {
                                    next4.unKnownError = TextUtils.isEmpty(next4.name);
                                }
                                listener.onSuccess(next);
                                z = true;
                            }
                        }
                        multiRoomData.groups = list;
                    }
                }
                if (!z) {
                    listener.onSuccess(null);
                }
            }

            public final void onFailure(ApiError apiError) {
                listener.onFailure(apiError);
            }
        });
    }

    public static ApiRequest createMultiRoomGroup(String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$nqhq4et2fM4D9xr5xpiieeEZIPg */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).createMultiRoomGroup(this.f$0);
            }
        }, MinaService.class, listener);
    }

    public static ApiRequest updateMultiRoomGroup(String str, String str2, List<String> list, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, str2, list) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$fYXeTMSGUm1DIEewu0lOWsWew */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ List f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).updateMultiRoomGroup(this.f$0, this.f$1, this.f$2.toString());
            }
        }, MinaService.class, listener);
    }

    public static ApiRequest deleteMultiRoomGroup(String str, List<String> list, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, list) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$D9rDcYc3Rmb0lRnct3buEmf2TBc */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ List f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).deleteMultiRoomGroup(this.f$0, this.f$1.toString());
            }
        }, MinaService.class, listener);
    }

    public static ApiRequest getMusicSource(ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue($$Lambda$ApiHelper$tyzSTXEWAR5hdFnu1XI6MjtrC4.INSTANCE, UserProfile.class, listener);
    }

    public static ApiRequest setMusicSource(String str, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$ZubxvuULhiEFs7Tc3fMppcbH3Q */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(Object obj) {
                return ((UserProfile) obj).setMusicSource(this.f$0);
            }
        }, UserProfile.class, listener);
    }

    public static ApiRequest getQQCollectionsList(ApiRequest.Listener<List<Music.Channel>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Music.Channel>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass82 */

            public final Observable<Response<MinaResponse<List<Music.Channel>>>> observable(MinaService minaService) {
                return minaService.getQQCollections();
            }
        }, listener);
    }

    public static ApiRequest getQQMusicSheetSongs(final String str, final String str2, ApiRequest.Listener<Music.SongBook> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Music.SongBook>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass83 */

            public final Observable<Response<MinaResponse<Music.SongBook>>> observable(MinaService minaService) {
                return minaService.getQQMusicSongs(str, str2);
            }
        }, listener);
    }

    public static ApiRequest revokePrivacy(ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass84 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.revokePrivacy();
            }
        }, listener);
    }

    public static ApiRequest getKaishuFlow(final int i, final int i2, ApiRequest.Listener<PatchWall> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<PatchWall>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass85 */

            public final Observable<Response<MinaResponse<PatchWall>>> observable(MinaService minaService) {
                return minaService.getKaishuFlow(i, i2);
            }
        }, listener);
    }

    public static ApiRequest acquireMembership(final String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass86 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.acquireMembership(str);
            }
        }, listener);
    }

    public static ApiRequest getQQMusicMemberStatus(ApiRequest.Listener<Payment.MemberStatus> listener) {
        return ApiManager.getInstance().enqueue($$Lambda$ho1Yl61PK_jhZUhAfzhRKfxGb9U.INSTANCE, PaymentService.class, listener);
    }

    public static ApiRequest getTransactionRecord(long j, long j2, ApiRequest.Listener<Payment.TransactionRecord> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(j, j2) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$lkNaNXLj0KhOSsNIUXWqvh2Uc */
            private final /* synthetic */ long f$0;
            private final /* synthetic */ long f$1;

            {
                this.f$0 = r1;
                this.f$1 = r3;
            }

            public final Observable observable(Object obj) {
                return ((PaymentService) obj).getTransactionRecord(this.f$0, "android", this.f$1);
            }
        }, PaymentService.class, listener);
    }

    public static ApiRequest postStatLog(final String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<String>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass87 */

            public final Observable<Response<MinaResponse<String>>> observable(MinaService minaService) {
                return minaService.statLog(str);
            }
        }, listener);
    }

    public static ApiRequest getScreenMode(ApiRequest.Listener<Remote.Response.ScreenModes> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("screenlockmode").method("get").listener(listener).classOf(Remote.Response.ScreenModes.class).build();
    }

    public static ApiRequest setScreenMode(String str, ApiRequest.Listener<Remote.Response.NullInfo> listener) {
        return new Remote.Builder().deviceId(MicoManager.getInstance().getCurrentMicoID()).path("screenlockmode").method("set").param("key", str).listener(listener).classOf(Remote.Response.NullInfo.class).build();
    }

    public static ApiRequest bindUploadedVideo(String str, String str2, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, str2) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$L7YOW4tOi7gqdq5vkRS5aMnFE */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Observable observable(Object obj) {
                return ((DisplayService) obj).bindUploadedVideo(this.f$0, this.f$1);
            }
        }, DisplayService.class, listener);
    }

    public static ApiRequest loadConfig(String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$Ga1qLZeKb4WOgQa4cbQMlFFu5Sg */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).config(this.f$0);
            }
        }, MinaService.class, listener);
    }

    public static ApiRequest qqMusicAuthEncrypt(String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$UY7mk8sCOFIqMtNCXOwuiSt0EzU */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).qqMusicAuthEncrypt(this.f$0);
            }
        }, MinaService.class, listener);
    }

    public static ApiRequest bindQQMusicAuth(String str, String str2, String str3, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, str2, str3) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$CH2Xmciagvx0Nc1SQRhHeKBGgEw */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).bindQQMusicAuth(this.f$0, "OAuth2OpenToken", "com.tencent.openid", "435808820829097984", this.f$1, this.f$2);
            }
        }, MinaService.class, listener);
    }

    public static ApiRequest kkboxSalesPromotion(String str, String str2, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider(str, str2) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$1dpy4Zz8menPaiQWE_baBj2Yvpk */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.kkboxSalesPromotion(this.f$0, this.f$1);
            }
        }, listener);
    }

    public static ApiRequest getAudioInfoV3(final List<Long> list, ApiRequest.Listener<List<Music.Song>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Music.Song>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass88 */

            public final Observable<Response<MinaResponse<List<Music.Song>>>> observable(MinaService minaService) {
                return minaService.getAudioInfoV3(ApiHelper.sGson.toJson(list));
            }
        }, listener);
    }

    public static ApiRequest addCollectV3(String str, String str2, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider(str2, str) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$zgp1WzRcR6p8vnPm5szxsI7aysY */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.addCollectV3(this.f$0, this.f$1);
            }
        }, listener);
    }

    public static ApiRequest delCollectV3(String str, String str2, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider(str2, str) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$txT8w216CAjlUQWOkMsxESiy9Jc */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.delCollectV3(this.f$0, this.f$1);
            }
        }, listener);
    }

    public static ApiRequest getHistoryV3(ApiRequest.Listener<List<Long>> listener) {
        return ApiManager.getInstance().enqueue($$Lambda$ApiHelper$YqQOaTyspNPZTRgGQwlqdiUhpE.INSTANCE, listener);
    }

    public static ApiRequest getQqMiniProgramAuthQrCode(Context context, String str, ApiRequest.Listener<QqMiniProgramResponse> listener) {
        HashMap hashMap = new HashMap();
        hashMap.put("qqmusic_open_appid", "31");
        hashMap.put("qqmusic_package_name", context.getPackageName());
        hashMap.put("qqmusic_encrypt_auth", str);
        hashMap.put("opi_cmd", "fcg_music_custom_sdk_get_qr_code.fcg");
        hashMap.put("qqmusic_qrcode_type", "qq");
        return ApiManager.getInstance().enqueue(new ApiProvider(GsonUtil.getGsonInstance().toJson(hashMap)) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$ybM1FQjz8xQyaPHCdwEX9109AH0 */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.getQqMiniProgramAuthQrCode(this.f$0);
            }
        }, listener);
    }

    public static ApiRequest getWXMiniProgramAuthQrCode(Context context, String str, ApiRequest.Listener<QqMiniProgramResponse> listener) {
        HashMap hashMap = new HashMap();
        hashMap.put("qqmusic_open_appid", "31");
        hashMap.put("qqmusic_package_name", context.getPackageName());
        hashMap.put("qqmusic_encrypt_auth", str);
        hashMap.put("opi_cmd", "fcg_music_custom_sdk_get_qr_code.fcg");
        hashMap.put("qqmusic_qrcode_type", "WX");
        return ApiManager.getInstance().enqueue(new ApiProvider(GsonUtil.getGsonInstance().toJson(hashMap)) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$W_v6pg1nanwsy17hfK6IODLtW8k */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.getQqMiniProgramAuthQrCode(this.f$0);
            }
        }, listener);
    }

    public static ApiRequest getQqMiniProgramAuthResult(String str, ApiRequest.Listener<QqMiniProgramResponse> listener) {
        HashMap hashMap = new HashMap();
        hashMap.put("qqmusic_open_appid", "31");
        hashMap.put("qqmusic_openid_authCode", str);
        hashMap.put("opi_cmd", "fcg_music_custom_qrcode_auth_poll.fcg");
        return ApiManager.getInstance().enqueue(new ApiProvider(GsonUtil.getGsonInstance().toJson(hashMap)) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$fvYQd0DICyEtA8jQ9Gh_JQzOsRM */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.getQqMiniProgramAuthQrCode(this.f$0);
            }
        }, listener);
    }

    public static ApiRequest getWXMiniProgramAuthResult(String str, ApiRequest.Listener<QqMiniProgramResponse> listener) {
        HashMap hashMap = new HashMap();
        hashMap.put("qqmusic_open_appid", "31");
        hashMap.put("qqmusic_openid_authCode", str);
        hashMap.put("opi_cmd", "fcg_music_custom_qrcode_auth_poll.fcg");
        return ApiManager.getInstance().enqueue(new ApiProvider(GsonUtil.getGsonInstance().toJson(hashMap)) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$8gvRqkbV9llNdEnLCcLb35SWA1w */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.getQqMiniProgramAuthQrCode(this.f$0);
            }
        }, listener);
    }

    public static ApiRequest getQQMusicVIPPriceList(ApiRequest.Listener<List<Payment.PriceItem>> listener) {
        return ApiManager.getInstance().enqueue($$Lambda$ApiHelper$7Na9Y8xzSyfHTuKBiun35zgdAZg.INSTANCE, PaymentService.class, listener);
    }

    public static ApiRequest getContractState(String str, String str2, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, str2) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$XhkkrVyfG7r0OuiNj42UMuD_is */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Observable observable(Object obj) {
                return ((PaymentService) obj).getContractState(this.f$0, this.f$1);
            }
        }, PaymentService.class, listener);
    }

    public static ApiRequest getUnpurchasedQuantity(String str, String str2, int i, String str3, ApiRequest.Listener<ArrayList<String>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, str2, str3, i) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$alxP6en9gWYePAdeGSXYlayBNKw */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ int f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Observable observable(Object obj) {
                return ((PaymentService) obj).getUnpurchasedQuantity(this.f$0, this.f$1, this.f$2, this.f$3);
            }
        }, PaymentService.class, listener);
    }

    public static ApiRequest getMiCoinBalance(ApiRequest.Listener<Long> listener) {
        return ApiManager.getInstance().enqueue($$Lambda$nm5y_FbUdCnkzliTUPdZEouLw.INSTANCE, PaymentService.class, listener);
    }

    public static ApiRequest setContractState(String str, String str2, String str3, String str4, boolean z, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, str2, str3, str4, z) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$E5wLLRaPeQStCDFrrUrpztZ8L4 */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ String f$3;
            private final /* synthetic */ boolean f$4;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final Observable observable(Object obj) {
                return ((PaymentService) obj).setContractState(this.f$0, this.f$1, this.f$2, "android", this.f$3, this.f$4);
            }
        }, PaymentService.class, listener);
    }

    static /* synthetic */ Observable lambda$setStationReverse$36(Music.Station station, UserProfile userProfile) {
        return userProfile.setStationReverse(station.stationID, station.origin != null ? station.origin : "", station.isReverse);
    }

    public static ApiRequest setStationReverse(Music.Station station, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2() {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$F0Dcw0aFbpC3jdsHSuD9CrJEctc */

            public final Observable observable(Object obj) {
                return ApiHelper.lambda$setStationReverse$36(Music.Station.this, (UserProfile) obj);
            }
        }, UserProfile.class, listener);
    }

    public static ApiRequest getHistory(String str, int i, String str2, ApiRequest.Listener<List<Music.Station>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, i, str2) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$qTkwqE85cP9j4a2BefPGhRsfMA */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ int f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).getHistory(this.f$0, this.f$1, this.f$2);
            }
        }, MinaService.class, listener);
    }

    public static ApiRequest getAudioBooksAll(String str, int i, List<String> list, String str2, int i2, int i3, String str3, ApiRequest.Listener<List<Music.Station>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, i, list, str2, i2, i3, str3) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$KVWjBxQSTySt5I_jk9D6AenRHQM */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ int f$1;
            private final /* synthetic */ List f$2;
            private final /* synthetic */ String f$3;
            private final /* synthetic */ int f$4;
            private final /* synthetic */ int f$5;
            private final /* synthetic */ String f$6;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).getAudioBooksAll(this.f$0, this.f$1, ApiHelper.sGson.toJson(this.f$2), this.f$3, this.f$4, this.f$5, this.f$6);
            }
        }, MinaService.class, listener);
    }

    public static ApiRequest getAudioBooksRandom(String str, int i, List<String> list, String str2, ApiRequest.Listener<List<Music.Station>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, i, list, str2) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$NHoWoJEgpYjzRWfmyFKOG5K_fWk */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ int f$1;
            private final /* synthetic */ List f$2;
            private final /* synthetic */ String f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).getAudioBooksRandom(this.f$0, this.f$1, ApiHelper.sGson.toJson(this.f$2), this.f$3);
            }
        }, MinaService.class, listener);
    }

    public static ApiRequest getChildrenProfile(ApiRequest.Listener<List<ThirdPartyResponse.ChildProfile>> listener) {
        return ApiManager.getInstance().enqueue($$Lambda$ApiHelper$_PpDOKReQ8GTle9Woyy9gmTeYM.INSTANCE, UserProfile.class, listener);
    }

    public static ApiRequest getAlarmVideoFileUrl(String str, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$pdfwvnB1AUx_kIbYkA3YfGrBUnE */
            private final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(Object obj) {
                return ((DisplayService) obj).getVideoFileUrl(this.f$0);
            }
        }, DisplayService.class, listener);
    }

    public static ApiRequest paymentOrderDedao(int i, int i2, int i3, ApiRequest.Listener<List<Music.Station>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(i, i2, i3) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$YYNa6eWwFwLasoJqQVkgRqChDFI */
            private final /* synthetic */ int f$0;
            private final /* synthetic */ int f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Observable observable(Object obj) {
                return ((PaymentService) obj).paymentOrderDedao(this.f$0, this.f$1, this.f$2);
            }
        }, PaymentService.class, listener);
    }

    public static ApiRequest getPathWallDedaoBlock(final List<String> list, final int i, final int i2, ApiRequest.Listener<List<Music.Station>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<Music.Station>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass89 */

            public final Observable<Response<MinaResponse<List<Music.Station>>>> observable(MinaService minaService) {
                return minaService.getPathWallDedaoBlock(ApiHelper.sGson.toJson(list), i, i2);
            }
        }, listener);
    }

    public static ApiRequest setChildrenProfile(List<ThirdPartyResponse.ChildProfile> list, ApiRequest.Listener<String> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(list) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$P4QEMrY2QDse6NCkOKt6h6GVuCk */
            private final /* synthetic */ List f$0;

            {
                this.f$0 = r1;
            }

            public final Observable observable(Object obj) {
                return ((UserProfile) obj).setChildrenProfile(ApiHelper.sGson.toJson(this.f$0));
            }
        }, UserProfile.class, listener);
    }

    public static ApiRequest searchCategoryItem(String str, int i, List<String> list, String str2, String str3, int i2, int i3, String str4, ApiRequest.Listener<List<Music.Station>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, i, list, str2, str3, i2, i3, str4) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$fqVPk4rGZ7sPFXPa47uXLjZe7U */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ int f$1;
            private final /* synthetic */ List f$2;
            private final /* synthetic */ String f$3;
            private final /* synthetic */ String f$4;
            private final /* synthetic */ int f$5;
            private final /* synthetic */ int f$6;
            private final /* synthetic */ String f$7;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
                this.f$7 = r8;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).searchCategoryItem(this.f$0, this.f$1, ApiHelper.sGson.toJson(this.f$2), this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
            }
        }, MinaService.class, listener);
    }

    public static ApiRequest updateAwakeStatus(DeviceState deviceState, int i, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(i) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$1H4BgmOPlWwiKEB4Rg2wSaqE__A */
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).updateAwakeStatus(DeviceState.this.deviceId, DeviceState.this.hardware, this.f$1, DeviceState.this.resource);
            }
        }, MinaService.class, listener);
    }

    public static ApiRequest lanAwakeGroup(ApiRequest.Listener<List<LanGroupInfo.LanGroup>> listener) {
        return ApiManager.getInstance().enqueue($$Lambda$ApiHelper$QQoISRl3VrYbWemJpSkVBJG7SQM.INSTANCE, MinaService.class, listener);
    }

    public static ApiRequest getPOISuggest(final String str, final String str2, ApiRequest.Listener<List<ThirdPartyResponse.POIResponse>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<ThirdPartyResponse.POIResponse>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass90 */

            public final Observable<Response<MinaResponse<List<ThirdPartyResponse.POIResponse>>>> observable(MinaService minaService) {
                return minaService.getPOISuggest(str, str2);
            }
        }, listener);
    }

    public static ApiRequest getPlateInfo(ApiRequest.Listener<List<ThirdPartyResponse.PlateInfo>> listener) {
        return ApiManager.getInstance().enqueue($$Lambda$ApiHelper$cIU_pmm941KhvOmNxyXzxhUYF0k.INSTANCE, listener);
    }

    public static ApiRequest updatePlateInfo(int i, ThirdPartyResponse.PlateInfo plateInfo, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider(i, plateInfo) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$D7ZTNG7vMpjzQ8s8YmYbLxXBw */
            private final /* synthetic */ int f$0;
            private final /* synthetic */ ThirdPartyResponse.PlateInfo f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Observable observable(MinaService minaService) {
                return minaService.updatePlateInfo(LoginManager.getInstance().getPassportInfo().getUserId(), this.f$0, ApiHelper.sGson.toJson(this.f$1));
            }
        }, listener);
    }

    public static ApiRequest getTrafficInfo(final String str, ApiRequest.Listener<ThirdPartyResponse.TrafficInfo> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<ThirdPartyResponse.TrafficInfo>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass91 */

            public final Observable<Response<MinaResponse<ThirdPartyResponse.TrafficInfo>>> observable(MinaService minaService) {
                return minaService.getTrafficeInfo(str);
            }
        }, listener);
    }

    public static ApiRequest setTrafficInfo(String str, ThirdPartyResponse.TrafficAddress trafficAddress, ThirdPartyResponse.TrafficAddress trafficAddress2, ThirdPartyResponse.TrafficAddress trafficAddress3, int i, String str2, int i2, int i3, ApiRequest.Listener<Object> listener) {
        final String str3 = str;
        final ThirdPartyResponse.TrafficAddress trafficAddress4 = trafficAddress;
        final ThirdPartyResponse.TrafficAddress trafficAddress5 = trafficAddress2;
        final ThirdPartyResponse.TrafficAddress trafficAddress6 = trafficAddress3;
        final int i4 = i;
        final String str4 = str2;
        final int i5 = i2;
        final int i6 = i3;
        return ApiManager.getInstance().enqueue(new ApiProvider<Object>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass92 */

            public final Observable<Response<MinaResponse<Object>>> observable(MinaService minaService) {
                String str = str3;
                ThirdPartyResponse.TrafficAddress trafficAddress = trafficAddress4;
                String trafficAddress2 = trafficAddress == null ? "" : trafficAddress.toString();
                ThirdPartyResponse.TrafficAddress trafficAddress3 = trafficAddress5;
                String trafficAddress4 = trafficAddress3 == null ? "" : trafficAddress3.toString();
                ThirdPartyResponse.TrafficAddress trafficAddress5 = trafficAddress6;
                return minaService.setTrafficeInfo(str, trafficAddress2, trafficAddress4, trafficAddress5 == null ? "" : trafficAddress5.toString(), i4, TextUtils.isEmpty(str4) ? "" : str4, i5, i6);
            }
        }, listener);
    }

    public static ApiRequest getDeDaoPathWallFlow(int i, int i2, ApiRequest.Listener<PatchWall> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(i, i2) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$M5vgQgm0ZFoxp4zJm2N0VusM4o */
            private final /* synthetic */ int f$0;
            private final /* synthetic */ int f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Observable observable(Object obj) {
                return ((MinaService) obj).getDeDaoPathWallFlow(this.f$0, this.f$1);
            }
        }, MinaService.class, listener);
    }

    public static ApiRequest setSkillPrivacy(final String str, final boolean z, ApiRequest.Listener<Boolean> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<Boolean>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass93 */

            public final Observable<Response<MinaResponse<Boolean>>> observable(MinaService minaService) {
                return minaService.setSkillPrivacy(str, z);
            }
        }, listener);
    }

    public static ApiRequest skillPrivacyDetail(final String str, ApiRequest.Listener<SkillStore.Privacy> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<SkillStore.Privacy>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass94 */

            public final Observable<Response<MinaResponse<SkillStore.Privacy>>> observable(MinaService minaService) {
                return minaService.getSkillPrivacy(str);
            }
        }, listener);
    }

    public static ApiRequest getMiotDeviceCmdDetailV2(final String str, final String str2, ApiRequest.Listener<SkillStore.SkillDetail> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<SkillStore.SkillDetail>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass95 */

            public final Observable<Response<MinaResponse<SkillStore.SkillDetail>>> observable(MinaService minaService) {
                return minaService.getMiotDeviceCmdDetailV2(str, str2);
            }
        }, listener);
    }

    public static ApiRequest getSkillDetail(final String str, ApiRequest.Listener<SkillStore.Skill> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<SkillStore.Skill>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass96 */

            public final Observable<Response<MinaResponse<SkillStore.Skill>>> observable(MinaService minaService) {
                return minaService.getSkillDetail(str);
            }
        }, listener);
    }

    public static ApiRequest skillDetail(String str, String str2, ApiRequest.Listener<SkillStore.SkillDetailV2> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2(str, str2) {
            /* class com.xiaomi.mico.api.$$Lambda$ApiHelper$h0caU0NmTduuLG81KQzNW7ncd0w */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Observable observable(Object obj) {
                return ((SkillstoreService) obj).skillDetail(this.f$0, this.f$1);
            }
        }, SkillstoreService.class, listener);
    }

    public static ApiRequest getStockSubscribtions(ApiRequest.Listener<List<SkillStore.Stock>> listener) {
        return ApiManager.getInstance().enqueue(new ApiProvider<List<SkillStore.Stock>>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass97 */

            public final Observable<Response<MinaResponse<List<SkillStore.Stock>>>> observable(MinaService minaService) {
                return minaService.stockSubscribtions("STOCK");
            }
        }, listener);
    }

    public static Observable<ThirdPartyResponse.GrayUpgradeResponse> getDailyAppUpgradeInfo(String str, String str2, String str3, String str4, String str5) {
        return getGreyUpgradeInfo("http://ci-miwifi.pt.xiaomi.com/jenkins/view/mico/job/MICO-Android-Daily/lastSuccessfulBuild/artifact/Archive/app.json", str, str2, str3, str4, str5);
    }

    private static Observable<ThirdPartyResponse.GrayUpgradeResponse> getGreyUpgradeInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        String valueOf = String.valueOf(System.currentTimeMillis());
        return ((ThirdPartyService) ApiManager.getThirdPartyInstance().getService(ThirdPartyService.class, null)).greyUpgrade(str, str2, str3, str4, str5, str6, valueOf, getUpdateHash(str2, str3, str4, str5, str6, valueOf)).subscribeOn(Schedulers.newThread());
    }

    public static Observable<ThirdPartyResponse.UpdateResponse> getUpdateInfo(String str, String str2, String str3, String str4, List<String> list) {
        return ((ThirdPartyService) ApiManager.getThirdPartyInstance().getService(ThirdPartyService.class, "")).getUpdateInfo(ApiConstants.getUpdateUrl(), str, str2, str3, "micoApp", "true", str4, TextUtils.join(",", list)).subscribeOn(Schedulers.newThread());
    }

    public static ApiRequest getIntelligentFlow(final String str, ApiRequest.Listener<IntelligentModel> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2<IntelligentModel, MiHomeService>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass98 */

            public final Observable<Response<MinaResponse<IntelligentModel>>> observable(MiHomeService miHomeService) {
                return miHomeService.getIntelligentFlow(str, 6, 0);
            }
        }, MiHomeService.class, listener);
    }

    public static ApiRequest getIntelligentFlow(final String str, final long j, ApiRequest.Listener<IntelligentModel> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2<IntelligentModel, MiHomeService>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass99 */

            public final Observable<Response<MinaResponse<IntelligentModel>>> observable(MiHomeService miHomeService) {
                return miHomeService.getIntelligentFlow(str, 6, j);
            }
        }, MiHomeService.class, listener);
    }

    public static ApiRequest getIntelligentMoreFlow(final int i, ApiRequest.Listener<IntelligentMoreModel> listener) {
        return ApiManager.getInstance().enqueue(new ApiProviderV2<IntelligentMoreModel, MiHomeService>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass100 */

            public final Observable<Response<MinaResponse<IntelligentMoreModel>>> observable(MiHomeService miHomeService) {
                return miHomeService.getIntelligentMoreFlow("PLATO_INTELLIGENT", i);
            }
        }, MiHomeService.class, listener);
    }

    public static ApiRequest getTabInfo(boolean z, String str, ApiRequest.Listener<MicoTabsInfo> listener) {
        if (!z) {
            return ApiManager.getInstance().enqueue(new ApiProviderV2<MicoTabsInfo, MiHomeService>() {
                /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass103 */

                public final Observable<Response<MinaResponse<MicoTabsInfo>>> observable(MiHomeService miHomeService) {
                    return miHomeService.getNoDeviceTabInfo();
                }
            }, MiHomeService.class, listener);
        }
        if (TextUtils.equals(str, "MI")) {
            return ApiManager.getInstance().enqueue(new ApiProviderV2<MicoTabsInfo, MiHomeService>() {
                /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass101 */

                public final Observable<Response<MinaResponse<MicoTabsInfo>>> observable(MiHomeService miHomeService) {
                    return miHomeService.getMiTabInfo();
                }
            }, MiHomeService.class, listener);
        }
        return ApiManager.getInstance().enqueue(new ApiProviderV2<MicoTabsInfo, MiHomeService>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass102 */

            public final Observable<Response<MinaResponse<MicoTabsInfo>>> observable(MiHomeService miHomeService) {
                return miHomeService.getQQTabInfo();
            }
        }, MiHomeService.class, listener);
    }

    public static ApiRequest getMicoSelectInfo(boolean z, ApiRequest.Listener<MicoHandpickInfo> listener) {
        if (z) {
            return ApiManager.getInstance().enqueue(new ApiProviderV2<MicoHandpickInfo, MiHomeService>() {
                /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass104 */

                public final Observable<Response<MinaResponse<MicoHandpickInfo>>> observable(MiHomeService miHomeService) {
                    return miHomeService.getHandpick();
                }
            }, MiHomeService.class, listener);
        }
        return ApiManager.getInstance().enqueue(new ApiProviderV2<MicoHandpickInfo, MiHomeService>() {
            /* class com.xiaomi.mico.api.ApiHelper.AnonymousClass105 */

            public final Observable<Response<MinaResponse<MicoHandpickInfo>>> observable(MiHomeService miHomeService) {
                return miHomeService.getNoDeviceHandpick();
            }
        }, MiHomeService.class, listener);
    }
}
