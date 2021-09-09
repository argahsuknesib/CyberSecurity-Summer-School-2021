package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import _m_j.fsp;
import _m_j.iit;
import _m_j.iiw;
import _m_j.iix;
import _m_j.ikd;
import _m_j.ilk;
import android.os.RemoteException;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MIOTXimalayaModule extends ReactContextBaseJavaModule {
    private static String lastAppKey;
    private List<Long> programs = null;

    public String getName() {
        return "MIOTXimalaya";
    }

    public MIOTXimalayaModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private static boolean is_ready() {
        return lastAppKey != null;
    }

    private void init(String str, String str2, String str3) {
        if (!str.equals(lastAppKey)) {
            iit O000000o2 = iit.O000000o();
            O000000o2.O00000oO = str3;
            O000000o2.O00000o = str;
            O000000o2.O000000o(getCurrentActivity(), str2);
            lastAppKey = str;
        }
    }

    public static void releasePlayer() {
        if (lastAppKey != null) {
            lastAppKey = null;
            player().O0000Oo0();
            ikd player = player();
            if (player.O00000Oo()) {
                try {
                    player.f1381O000000o.resetPlayer();
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static class O000000o extends iix {
        static iit.O000000o<O000000o> O00000Oo = new iit.O000000o<O000000o>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTXimalayaModule.O000000o.AnonymousClass1 */

            public final /* synthetic */ Object O000000o(String str) throws Exception {
                O000000o o000000o = new O000000o((byte) 0);
                o000000o.f8381O000000o = str;
                return o000000o;
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public String f8381O000000o;

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        static iiw<O000000o> O000000o(final Callback callback) {
            return new iiw<O000000o>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTXimalayaModule.O000000o.AnonymousClass2 */

                public final /* synthetic */ void O000000o(Object obj) {
                    O000000o o000000o = (O000000o) obj;
                    Callback callback = callback;
                    if (callback != null) {
                        callback.invoke(o000000o.f8381O000000o, null);
                    }
                }

                public final void O000000o(int i, String str) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("code", Integer.valueOf(i));
                    hashMap.put("msg", str);
                    Gson gson = new Gson();
                    callback.invoke(null, gson.toJson(hashMap));
                }
            };
        }
    }

    @ReactMethod
    public void requestXMData(String str, String str2, String str3, Callback callback) {
        Map map = (Map) new Gson().fromJson(str3, Map.class);
        if ("post".equalsIgnoreCase(str)) {
            iit.O00000Oo(str2, map, O000000o.O000000o(callback), O000000o.O00000Oo);
        } else {
            iit.O000000o(str2, map, O000000o.O000000o(callback), O000000o.O00000Oo);
        }
    }

    private static final ikd player() {
        return ikd.O000000o(fsp.O00000Oo());
    }

    @ReactMethod
    public void registry(String str, String str2, String str3) {
        init(str, str2, str3);
    }

    @ReactMethod
    public void setPlayMode(int i) {
        if (is_ready()) {
            ikd player = player();
            XmPlayListControl.PlayMode index = XmPlayListControl.PlayMode.getIndex(i);
            if (player.O00000Oo()) {
                try {
                    player.f1381O000000o.setPlayMode(index.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @ReactMethod
    public void setTrackPlayMode(int i) {
        setPlayMode(i);
    }

    @ReactMethod
    public void setVolume(float f) {
        if (is_ready()) {
            ikd player = player();
            if (player.O00000Oo()) {
                try {
                    player.f1381O000000o.setVolume(f, f);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @ReactMethod
    public void playWithTrack(String str, int i) {
        if (is_ready()) {
            List list = (List) new Gson().fromJson(str, new TypeToken<List<Track>>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTXimalayaModule.AnonymousClass1 */
            }.getType());
            ikd player = player();
            if (!player.O00000Oo()) {
                return;
            }
            if (list == null || list.size() == 0) {
                ilk.O00000Oo("XmPlayerServiceManager", "Empty TrackList");
            } else {
                player.O000000o(null, list, i, true);
            }
        }
    }

    @ReactMethod
    public void pauseTrackPlay() {
        if (is_ready()) {
            player().O0000OOo();
        }
    }

    @ReactMethod
    public void resumeTrackPlay() {
        if (is_ready()) {
            player().O0000O0o();
        }
    }

    @ReactMethod
    public void stopTrackPlay() {
        if (is_ready()) {
            player().O0000Oo0();
        }
    }

    @ReactMethod
    public void replacePlayList(String str) {
        if (is_ready()) {
            List list = (List) new Gson().fromJson(str, new TypeToken<List<Track>>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTXimalayaModule.AnonymousClass2 */
            }.getType());
            ikd player = player();
            if (player.O000000o()) {
                try {
                    player.f1381O000000o.resetPlayList();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ikd player2 = player();
            if (player2.O00000Oo() && list != null && list.size() != 0) {
                player2.O000000o(null, list, 0, false);
            }
        }
    }

    @ReactMethod
    public void playNextTrackWithCallback(Callback callback) {
        if (!is_ready()) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        ikd player = player();
        if (player.O00000Oo()) {
            try {
                player.f1381O000000o.playNext();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (callback != null) {
            callback.invoke(Boolean.TRUE);
        }
    }

    @ReactMethod
    public void playPrevTrackWithCallback(Callback callback) {
        if (!is_ready()) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        ikd player = player();
        if (player.O00000Oo()) {
            try {
                player.f1381O000000o.playPre();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (callback != null) {
            callback.invoke(Boolean.TRUE);
        }
    }

    @ReactMethod
    public void setAutoNexTrack(boolean z) {
        if (is_ready()) {
            ikd player = player();
            if (player.O000000o()) {
                try {
                    player.f1381O000000o.setDLNAState(z);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @ReactMethod
    public void playListWithCallback(Callback callback) {
        if (is_ready() && callback != null) {
            callback.invoke(new Gson().toJson(player().O0000OoO()).toString());
        }
    }

    @ReactMethod
    public void nextTrackWithCallback(Callback callback) {
        if (is_ready() && callback != null) {
            Gson gson = new Gson();
            Track O000000o2 = player().O000000o(player().O00000oO() + 1);
            Object[] objArr = new Object[1];
            objArr[0] = O000000o2 == null ? null : gson.toJson(O000000o2).toString();
            callback.invoke(objArr);
        }
    }

    @ReactMethod
    public void prevTrackWithCallback(Callback callback) {
        if (is_ready() && callback != null) {
            Gson gson = new Gson();
            Track O000000o2 = player().O000000o(player().O00000oO() - 1);
            Object[] objArr = new Object[1];
            objArr[0] = O000000o2 == null ? null : gson.toJson(O000000o2).toString();
            callback.invoke(objArr);
        }
    }

    @ReactMethod
    public void seekToTime(float f) {
        if (is_ready()) {
            ikd player = player();
            player.O00000Oo((int) (((float) player.O0000Ooo()) * f));
        }
    }

    @ReactMethod
    public void clearCacheSafely() {
        if (is_ready()) {
            player().O0000o00();
        }
    }

    @ReactMethod
    public void currentTrackWithCallback(Callback callback) {
        if (is_ready() && callback != null) {
            Gson gson = new Gson();
            Track O000000o2 = player().O000000o(player().O00000oO());
            Object[] objArr = new Object[1];
            objArr[0] = O000000o2 == null ? null : gson.toJson(O000000o2).toString();
            callback.invoke(objArr);
        }
    }

    @ReactMethod
    public void startLivePlayWithRadio(String str) {
        Radio radio;
        if (is_ready() && (radio = (Radio) new Gson().fromJson(str, Radio.class)) != null) {
            player().O000000o(radio);
        }
    }

    @ReactMethod
    public void pauseLivePlay() {
        if (is_ready()) {
            player().O0000OOo();
        }
    }

    @ReactMethod
    public void resumeLivePlay() {
        if (is_ready()) {
            player().O0000O0o();
        }
    }

    @ReactMethod
    public void stopLivePlay() {
        if (is_ready()) {
            player().O0000Oo0();
        }
    }

    @ReactMethod
    public void startHistoryLivePlayWithRadio(String str, long j) {
        if (is_ready()) {
            Radio radio = (Radio) new Gson().fromJson(str, Radio.class);
            radio.O0000oOO = j;
            player().O000000o(radio);
        }
    }

    @ReactMethod
    public void startHistoryLivePlayWithRadioInProgramList(String str, long j, String str2) {
        if (is_ready()) {
            Gson gson = new Gson();
            Radio radio = (Radio) gson.fromJson(str, Radio.class);
            this.programs = (List) gson.fromJson(str2, new TypeToken<List<Long>>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTXimalayaModule.AnonymousClass3 */
            }.getType());
            radio.O0000oOO = j;
            player().O000000o(radio);
        }
    }

    @ReactMethod
    public void seekHistoryLivePlay(int i, Callback callback) {
        if (is_ready()) {
            player().O00000Oo(i);
            if (callback != null) {
                callback.invoke(new Object[0]);
            }
        }
    }

    @ReactMethod
    public void playNextProgram() {
        if (is_ready()) {
            PlayableModel O00000oo = player().O00000oo();
            List<Long> list = this.programs;
            if (list != null && list.size() > 0 && (O00000oo instanceof Radio)) {
                Radio radio = (Radio) O00000oo;
                int indexOf = this.programs.indexOf(Long.valueOf(radio.O0000oOO)) + 1;
                if (indexOf >= this.programs.size()) {
                    indexOf = 0;
                }
                radio.O0000oOO = this.programs.get(indexOf).longValue();
            }
        }
    }

    @ReactMethod
    public void playPreProgram() {
        if (is_ready()) {
            PlayableModel O00000oo = player().O00000oo();
            List<Long> list = this.programs;
            if (list != null && list.size() > 0 && (O00000oo instanceof Radio)) {
                Radio radio = (Radio) O00000oo;
                int indexOf = this.programs.indexOf(Long.valueOf(radio.O0000oOO)) - 1;
                if (indexOf < 0) {
                    indexOf = this.programs.size() - 1;
                }
                radio.O0000oOO = this.programs.get(indexOf).longValue();
            }
        }
    }

    @ReactMethod
    public void forceClearCacheDataForPath(String str, Callback callback) {
        if (is_ready()) {
            player().O0000o00();
            if (callback != null) {
                callback.invoke(new Object[0]);
            }
        }
    }

    @ReactMethod
    public void currentPlayingRadioWithCallback(Callback callback) {
        if (is_ready()) {
            PlayableModel O00000oo = player().O00000oo();
            if (callback != null) {
                callback.invoke(new Gson().toJson(O00000oo));
            }
        }
    }

    @ReactMethod
    public void currentPlayingProgramWithCallback(Callback callback) {
        if (is_ready() && callback != null) {
            PlayableModel O00000oo = player().O00000oo();
            if (O00000oo instanceof Radio) {
                callback.invoke(Long.valueOf(((Radio) O00000oo).O0000oOO));
                return;
            }
            callback.invoke(0);
        }
    }
}
