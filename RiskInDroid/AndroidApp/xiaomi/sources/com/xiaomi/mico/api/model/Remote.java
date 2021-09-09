package com.xiaomi.mico.api.model;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.PlayV3Pact;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.GsonUtil;
import com.xiaomi.mico.setting.alarm.AlarmHelper;
import com.xiaomi.smarthome.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Remote {
    public static Gson sGson = new GsonBuilder().disableHtmlEscaping().create();

    public static class Response {
        public int code;
        public String info;

        public static class AlarmResponse {
            public List<Alarm> alarm;
            public List<Alarm> timer;
        }

        public static class AuxInVol {
            public int vol;
        }

        public static class BluetoothScan {
            public int duration;
        }

        public static class CarrierType {
            public String type;
        }

        public static class DebugMessage {
            public Collection<Record> result;

            public static class Answer {
                public Collection<Nlp> answer;
            }

            public static class Asr implements Serializable {
                public Queries response;
            }

            public static class Content implements Serializable {
                public List<NlpDirective> directive;
                public boolean expanded;
                public Collection<Song> musics;
                @SerializedName(alternate = {"to_speak"}, value = "toSpeak")
                public String toSpeak;
            }

            public static class Intention implements Serializable {
                public String query;
            }

            public static class Nlp implements Serializable {
                public String action;
                public Content content;
                public String domain;
                public Intention intention;
                public String text;
                public String toSpeak;
            }

            public static class NlpDirective implements Serializable {
                private static final long serialVersionUID = 4725333447792293720L;
                public List<NlpDirectiveItem> items;
                public String type;
            }

            public static class NlpDirectiveItem implements Serializable {
                private static final long serialVersionUID = -8116697360913744085L;
                public String text;
                public String title;
                public String type;
            }

            public static class Queries implements Serializable {
                public Collection<Query> queries;
            }

            public static class Query implements Serializable {
                public boolean is_final;
                public String query;
                public String query_vendor;
            }

            public static class RawMessage {
                public Answer response;
            }

            public static class Record implements Serializable {
                private static final long serialVersionUID = 1519781112333164459L;
                public String asr;
                public String nlp;
                public long timestamp;
            }

            public static class Song implements Serializable {
                public String artist;
                public String origin;
                public String originSong;
            }
        }

        public static class Memo {
            public long id;
            public long timestamp;
            public String value;
        }

        public static class MiTvDevice {
            public String host;
            public String name;
            public int online;
            public int selected;
            public String udn;
        }

        public static class MiTvResponse {
            @SerializedName("device_list")
            public List<MiTvDevice> devices;
            public int enable;
        }

        public static class NullInfo {
            public int code;
        }

        public static class PairDevice implements Serializable {
            @SerializedName("bdaddr")
            public String addr;
            public boolean bind;
            public boolean connect;
            public String name;
        }

        public static class PlayerShutdownTimerResp {
            @SerializedName("remain_time")
            public int remainTime;
            public int type;
        }

        public static class Recent {
            public List<Long> track_list;
        }

        public static class ScreenMode {
            @SerializedName("key")
            public String mode;
            public boolean selected;
            @SerializedName("subtitle")
            public String subTitle;
            public String title;
            public String url;
        }

        public static class ScreenModes {
            public List<ScreenMode> modes;
        }

        public static class Tone {
            public Collection<ToneDetail> vendor;

            public static class ToneDetail implements Serializable {
                private static final long serialVersionUID = 1500932892296966843L;
                public String desc;
                public String name;
                public boolean selected;
            }
        }

        public static class VOIPStatus {
            public int status;
        }

        public static class VoicePrintStatus {
            public String nick_name;
            public String status;
        }

        public String toString() {
            return "Remote Response{code=" + this.code + ", info='" + this.info + '\'' + '}';
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T
         arg types: [java.lang.String, java.lang.Class<T>]
         candidates:
          com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.Class):T
          com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.reflect.Type):T
          com.google.gson.Gson.fromJson(com.google.gson.stream.JsonReader, java.lang.reflect.Type):T
          com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T
          com.google.gson.Gson.fromJson(java.io.Reader, java.lang.reflect.Type):T
          com.google.gson.Gson.fromJson(java.lang.String, java.lang.reflect.Type):T
          com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T */
        public <T> T parseInfo(Class<T> cls) {
            if (cls == NullInfo.class) {
                try {
                    return cls.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
            return Remote.sGson.fromJson(this.info, (Class) cls);
        }

        public static class Directive {
            public String cover;
            public String id;
            @Expose
            public int index;
            public String origin;
            public String title;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Directive)) {
                    return false;
                }
                Directive directive = (Directive) obj;
                return Util.equals(this.id, directive.id) && Util.equals(this.origin, directive.origin) && Util.equals(this.title, directive.title);
            }
        }

        public static class TrackData {
            public long audio_id;
            public String cover;
            @SerializedName("cp_id")
            public String cpID;
            @SerializedName("cp_origin")
            public String cpOrigin;
            @Expose
            public int index;
            @SerializedName("global_id")
            public long musicID;
            public String title;

            public Directive toDirective() {
                Directive directive = new Directive();
                directive.id = this.cpID;
                directive.origin = this.cpOrigin;
                directive.title = this.title;
                directive.cover = this.cover;
                directive.index = this.index;
                return directive;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof TrackData)) {
                    return false;
                }
                TrackData trackData = (TrackData) obj;
                return this.musicID == trackData.musicID && this.audio_id == trackData.audio_id && Util.equals(this.cpID, trackData.cpID) && Util.equals(this.cpOrigin, trackData.cpOrigin) && Util.equals(this.title, trackData.title);
            }
        }

        public static class PlayingData {
            public long audio_id;
            public String cover;
            @SerializedName("cp_id")
            public String cpID;
            @SerializedName("cp_origin")
            public String cpOrigin;
            public long duration;
            @SerializedName("global_id")
            public long musicID;
            public long position;
            public String title;

            public void update(TrackData trackData, long j, long j2) {
                this.audio_id = trackData.audio_id;
                this.musicID = trackData.musicID;
                this.cpID = trackData.cpID;
                this.cpOrigin = trackData.cpOrigin;
                this.title = trackData.title;
                this.cover = trackData.cover;
                this.position = j;
                this.duration = j2;
            }

            public TrackData getTrackingData() {
                TrackData trackData = new TrackData();
                trackData.audio_id = this.audio_id;
                trackData.musicID = this.musicID;
                trackData.cpID = this.cpID;
                trackData.cpOrigin = this.cpOrigin;
                trackData.title = this.title;
                trackData.cover = this.cover;
                return trackData;
            }
        }

        public static class PlayerStatus {
            public List<TrackData> extra_track_list;
            @SerializedName("album_playlist_id")
            public long list_id = -1;
            public int loop_type = -1;
            public int media_type = -1;
            public PlayingData play_song_detail;
            public int status;
            public List<Long> track_list;
            public int volume;

            public boolean playingAudioIdChanged(PlayerStatus playerStatus) {
                PlayingData playingData = playerStatus.play_song_detail;
                if (playingData == null || this.play_song_detail == null || playingData.audio_id != this.play_song_detail.audio_id) {
                    return true;
                }
                return false;
            }
        }

        public static class SoundBoxNetworkStatus {
            public String bssid;
            public String ip;
            public String ssid;

            public String toString() {
                return "bssid:" + this.bssid + " ssid:" + this.ssid + " ip:" + this.ip;
            }
        }

        public static class BluetoothResponse implements Serializable {
            public int connect;
            @SerializedName("devices_list")
            public List<PairDevice> devices;
            public int discover;
            public boolean enable;
            @SerializedName("btout_is_connect")
            public int isConnectBtout;
            @SerializedName("btname")
            public String name;
            @SerializedName("operation_result")
            public int operationResult;
            @SerializedName("operation_state")
            public int operationState = -1;
            @SerializedName("role")
            public int role = -1;

            public boolean hasDevices() {
                List<PairDevice> list = this.devices;
                return list != null && list.size() > 0;
            }

            public boolean isNewApi() {
                return this.role != -1;
            }
        }

        public static class BluetoothScanInfo {
            @SerializedName("is_complete")
            public int complete;
            @SerializedName("devices_list")
            public List<PairDevice> devices;

            public boolean isComplete() {
                return this.complete == 1;
            }
        }

        public static class Alarm implements Serializable {
            private static final long serialVersionUID = -6130413683622017587L;
            public AlarmRing alarmRing;
            public int circle;
            @SerializedName("display_txt")
            public String displayTxt;
            public String event;
            public String extra;
            public String id;
            @SerializedName("lazy_flag")
            public boolean lazyFlag;
            @SerializedName("ringtone_query")
            public String ringToneQuery;
            @SerializedName("ringtone_type")
            public String ringToneType;
            @SerializedName("ringtone_video")
            public String ringToneVideo;
            @SerializedName("ringtone_video_image")
            public String ringToneVideoImage;
            public int status;
            @SerializedName("time_reminder")
            public String timeReminder;
            public long timestamp;
            public String type;
            public int volume;

            public AlarmRing getAlarmRing() {
                if (this.alarmRing == null) {
                    this.alarmRing = AlarmHelper.getAlarmRing(this);
                }
                return this.alarmRing;
            }

            public static String getAlarmInJson(String str, long j, int i, String str2) {
                Alarm alarm = new Alarm();
                alarm.id = str;
                alarm.timestamp = j;
                alarm.circle = i;
                alarm.volume = MicoManager.getInstance().getCurrentMico().getHardwareType().getAlarmVolume();
                alarm.type = "baby_course";
                alarm.extra = str2;
                return GsonUtil.getGsonInstance().toJson(alarm);
            }

            public static String getRepeatStr(Context context, int i, long j, String str) {
                if (i == AlarmCircle.ONCE.getCircle() && j > 0) {
                    return AlarmHelper.formatAlarmDateTime(context, j);
                }
                if (i != AlarmCircle.CUSTOM.getCircle() || TextUtils.isEmpty(str)) {
                    return getRepeatOptionStr(context, AlarmCircle.circle2index(i, 2));
                }
                return context.getString(R.string.weekly, AlarmHelper.getCustomRepeatStr(context, str));
            }

            private static String getRepeatOptionStr(Context context, int i) {
                String[] stringArray = context.getResources().getStringArray(R.array.alarm_repeat_option_v2);
                return (i < 0 || i >= stringArray.length) ? "" : stringArray[i];
            }
        }

        public static class AlarmRing implements Serializable {
            public String display_name;
            public String display_tab;
            public String id;
            public String name;
            public String query;
            public String tab;
            public String video;
            public String videoImage;
            public transient Uri videoLocalPath;

            public String toString() {
                return "AlarmRing{tab='" + this.tab + '\'' + ", id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", query='" + this.query + '\'' + ", video='" + this.video + '\'' + ", videoImage='" + this.videoImage + '\'' + ", display_tab='" + this.display_tab + '\'' + ", display_name='" + this.display_name + '\'' + '}';
            }
        }

        public static class NightMode {
            public String light;
            public String start;
            public String stop;
            public String total;
            public String volume;

            public void setMode(boolean z) {
                this.total = z ? "night" : "normal";
            }

            public void setLight(boolean z) {
                this.light = z ? "night" : "normal";
            }

            public void setVolume(boolean z) {
                this.volume = z ? "night" : "normal";
            }

            public boolean isNightMode() {
                return "night".equals(this.total);
            }

            public boolean isNightLight() {
                return "night".equals(this.light);
            }

            public boolean isNightVolume() {
                return "night".equals(this.volume);
            }

            public String getStart() {
                if (TextUtils.isEmpty(this.start)) {
                    this.start = "23:00";
                }
                return this.start;
            }

            public String getStop() {
                if (TextUtils.isEmpty(this.stop)) {
                    this.stop = "08:00";
                }
                return this.stop;
            }

            public String getMode() {
                if (TextUtils.isEmpty(this.total)) {
                    this.total = "night";
                }
                return this.total;
            }

            public String getLight() {
                if (TextUtils.isEmpty(this.light)) {
                    this.light = "night";
                }
                return this.light;
            }

            public String getVolume() {
                if (TextUtils.isEmpty(this.volume)) {
                    this.volume = "night";
                }
                return this.volume;
            }
        }

        public static class VoiceInteraction {
            public String status;

            public boolean isOn() {
                return "on".equals(this.status);
            }
        }

        public static class ConnectTvState {
            public String status;

            public boolean isOn() {
                return "on".equals(this.status);
            }
        }

        public static class ChildModeStatus implements Serializable, Cloneable {
            private static final long serialVersionUID = -4497940862780700700L;
            @SerializedName("eyeProtection")
            public EyeProtection eyeProtection;
            @SerializedName("isChildMode")
            public boolean isChildMode;

            public boolean hasWatchTimeRestriction() {
                EyeProtection eyeProtection2 = this.eyeProtection;
                return eyeProtection2 != null && eyeProtection2.watchTimeRestricted;
            }

            public ChildModeStatus clone() {
                ChildModeStatus childModeStatus;
                CloneNotSupportedException e;
                try {
                    childModeStatus = (ChildModeStatus) super.clone();
                    try {
                        if (this.eyeProtection != null) {
                            childModeStatus.eyeProtection = this.eyeProtection.clone();
                        }
                    } catch (CloneNotSupportedException e2) {
                        e = e2;
                        e.printStackTrace();
                        return childModeStatus;
                    }
                } catch (CloneNotSupportedException e3) {
                    CloneNotSupportedException cloneNotSupportedException = e3;
                    childModeStatus = null;
                    e = cloneNotSupportedException;
                    e.printStackTrace();
                    return childModeStatus;
                }
                return childModeStatus;
            }
        }

        public static class EyeProtection implements Serializable, Cloneable {
            private static final long serialVersionUID = -4882397315470161000L;
            @SerializedName("forbidWatchVideoEndTime")
            public WallClockTime forbidWatchVideoEndTime;
            @SerializedName("forbidWatchVideoStartTime")
            public WallClockTime forbidWatchVideoStartTime;
            @SerializedName("watchMaxMinutesEachDay")
            public int watchMaxMinutesEachDay;
            @SerializedName("watchTimeMaxMinutesEachTime")
            public int watchTimeMaxMinutesEachTime;
            @SerializedName("watchTimeRestricted")
            public boolean watchTimeRestricted;

            public EyeProtection clone() {
                EyeProtection eyeProtection;
                CloneNotSupportedException e;
                try {
                    eyeProtection = (EyeProtection) super.clone();
                    try {
                        if (this.forbidWatchVideoStartTime != null) {
                            eyeProtection.forbidWatchVideoStartTime = this.forbidWatchVideoStartTime.clone();
                        }
                        if (this.forbidWatchVideoEndTime != null) {
                            eyeProtection.forbidWatchVideoEndTime = this.forbidWatchVideoEndTime.clone();
                        }
                    } catch (CloneNotSupportedException e2) {
                        e = e2;
                        e.printStackTrace();
                        return eyeProtection;
                    }
                } catch (CloneNotSupportedException e3) {
                    CloneNotSupportedException cloneNotSupportedException = e3;
                    eyeProtection = null;
                    e = cloneNotSupportedException;
                    e.printStackTrace();
                    return eyeProtection;
                }
                return eyeProtection;
            }
        }

        public static class WallClockTime implements Serializable, Cloneable {
            private static final long serialVersionUID = -1151059887044052900L;
            @SerializedName("hour")
            public int hour;
            @SerializedName("is24Hour")
            public boolean is24Hour;
            @SerializedName("minute")
            public int minute;

            public WallClockTime clone() {
                try {
                    return (WallClockTime) super.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

        public static class MeshStatus {
            public boolean mesh_is_enable;
            public boolean mesh_is_support;
            public String mesh_status;

            public boolean isEnable() {
                return this.mesh_is_support && this.mesh_is_enable;
            }
        }
    }

    public static class Builder<T> {
        private Class<T> mClassOf;
        private String mDeviceId;
        private final HashMap<String, Object> mHashMap = new HashMap<>();
        private ApiRequest.Listener<T> mListener;
        private String mMethod;
        private String mPath;

        public Builder<T> deviceId(String str) {
            this.mDeviceId = str;
            return this;
        }

        public Builder<T> path(String str) {
            this.mPath = str;
            return this;
        }

        public Builder<T> method(String str) {
            this.mMethod = str;
            return this;
        }

        public Builder<T> param(String str, String str2) {
            this.mHashMap.put(str, str2);
            return this;
        }

        public Builder<T> param(String str, long j) {
            this.mHashMap.put(str, Long.valueOf(j));
            return this;
        }

        public Builder<T> param(String str, int i) {
            this.mHashMap.put(str, Integer.valueOf(i));
            return this;
        }

        public Builder<T> param(String str, boolean z) {
            this.mHashMap.put(str, Boolean.valueOf(z));
            return this;
        }

        public Builder<T> listener(ApiRequest.Listener<T> listener) {
            this.mListener = listener;
            return this;
        }

        public Builder<T> classOf(Class<T> cls) {
            this.mClassOf = cls;
            return this;
        }

        public ApiRequest build() {
            return ApiHelper.remote(this.mDeviceId, this.mPath, this.mMethod, GsonUtil.getGsonInstance().toJson(this.mHashMap), this.mListener, this.mClassOf);
        }

        public ApiRequest build4Dts(ApiRequest.Listener listener) {
            return ApiHelper.remote4Dts(this.mDeviceId, this.mPath, this.mMethod, GsonUtil.getGsonInstance().toJson(this.mHashMap), listener);
        }
    }

    public static class Request {

        public static class ControlAction {
            public String action;
            public String media = "app_android";
        }

        public static class LoopType {
            public String media = "app_android";
            public int type;
        }

        public static class VOIPOperator {
            public int op;
        }

        static class SongFavorite {
            public String origin;
            public String originSongID;

            private SongFavorite() {
            }

            public static SongFavorite buildSongFavourite(Music.Song song) {
                SongFavorite songFavorite = new SongFavorite();
                songFavorite.origin = song.origin;
                songFavorite.originSongID = song.originSongID;
                return songFavorite;
            }
        }

        static class PlaylistSong {
            @SerializedName("artist_name")
            public String artistName;
            public String origin;
            @SerializedName("id")
            public String originSongID;
            @SerializedName("global_id")
            public long songID;
            @SerializedName("song")
            public String songName;

            private PlaylistSong() {
            }

            public static PlaylistSong buildSong(Music.Song song) {
                PlaylistSong playlistSong = new PlaylistSong();
                playlistSong.songID = song.songID;
                playlistSong.origin = song.origin;
                playlistSong.originSongID = song.originSongID;
                playlistSong.songName = song.name;
                playlistSong.artistName = song.getArtistName();
                return playlistSong;
            }
        }

        static class PlaylistSongList {
            public List<PlaylistSong> musics;

            private PlaylistSongList() {
            }

            public static PlaylistSongList buildSongList(List<Music.Song> list) {
                PlaylistSongList playlistSongList = new PlaylistSongList();
                playlistSongList.musics = new ArrayList(list.size());
                for (Music.Song buildSong : list) {
                    playlistSongList.musics.add(PlaylistSong.buildSong(buildSong));
                }
                return playlistSongList;
            }
        }

        static class PlaylistStation {
            public String albumId;
            public String albumName;
            public int episodesNum;
            private long global_id;
            public String id;
            public String origin;
            public String stationId;
            public String title;
            public String type;

            private PlaylistStation() {
            }

            public static PlaylistStation buildStation(Music.Station station) {
                PlaylistStation playlistStation = new PlaylistStation();
                playlistStation.id = station.stationID;
                playlistStation.type = station.type;
                playlistStation.origin = station.origin;
                playlistStation.title = station.title;
                playlistStation.albumId = station.albumGlobalID;
                playlistStation.global_id = station.globalID;
                playlistStation.episodesNum = station.episodesNum;
                playlistStation.albumName = station.albumName;
                return playlistStation;
            }

            public static PlaylistStation buildStation(Music.Station station, String str) {
                PlaylistStation buildStation = buildStation(station);
                buildStation.stationId = str;
                return buildStation;
            }
        }

        static class PlaylistStationList {
            public List<PlaylistStation> stations;

            private PlaylistStationList() {
            }

            public static PlaylistStationList buildStationList(List<Music.Station> list) {
                PlaylistStationList playlistStationList = new PlaylistStationList();
                playlistStationList.stations = new ArrayList(list.size());
                for (Music.Station buildStation : list) {
                    playlistStationList.stations.add(PlaylistStation.buildStation(buildStation));
                }
                return playlistStationList;
            }

            public static PlaylistStationList buildStationList(List<Music.Station> list, String str) {
                PlaylistStationList playlistStationList = new PlaylistStationList();
                playlistStationList.stations = new ArrayList(list.size());
                for (Music.Station buildStation : list) {
                    playlistStationList.stations.add(PlaylistStation.buildStation(buildStation, str));
                }
                return playlistStationList;
            }
        }

        public static class PlaylistMessage {
            public String dialog_id;
            public int loadMoreOffset;
            public String media;
            public String music;
            @SerializedName("startOffset")
            public int start;
            @SerializedName("startaudioid")
            public String startAudioid;

            private PlaylistMessage(PlaylistSongList playlistSongList, int i) {
                this.media = "app_android";
                this.start = i;
                if (needCompress(playlistSongList.musics)) {
                    playlistSongList.musics = compressList(playlistSongList.musics);
                } else {
                    this.loadMoreOffset = playlistSongList.musics.size();
                }
                this.music = Remote.sGson.toJson(playlistSongList);
            }

            private PlaylistMessage(PlayV3Pact playV3Pact, int i) {
                this.media = "app_android";
                this.start = i;
                if (needCompress(playV3Pact.payload.audio_items)) {
                    playV3Pact.payload.audio_items = compressList(playV3Pact.payload.audio_items);
                } else {
                    this.loadMoreOffset = playV3Pact.payload.audio_items.size();
                }
                this.dialog_id = "app_android_" + randomRequestId();
                List<PlayV3Pact.AudioItem> list = playV3Pact.payload.audio_items;
                int i2 = this.start;
                if (i2 >= 0 && i2 < ContainerUtil.getSize(list)) {
                    this.startAudioid = list.get(this.start).item_id.audio_id;
                }
                this.music = Remote.sGson.toJson(playV3Pact);
            }

            private static String randomRequestId() {
                Random random = new Random();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 20; i++) {
                    sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
                }
                return sb.toString();
            }

            private PlaylistMessage(PlaylistStationList playlistStationList, int i) {
                this.media = "app_android";
                this.start = i;
                if (needCompress(playlistStationList.stations)) {
                    playlistStationList.stations = compressList(playlistStationList.stations);
                } else {
                    this.loadMoreOffset = playlistStationList.stations.size();
                }
                this.music = Remote.sGson.toJson(playlistStationList);
            }

            private <T> List<T> compressList(List<T> list) {
                int i = this.start;
                int i2 = i - 100;
                int i3 = i + 100;
                int size = list.size();
                if (i2 < 0) {
                    i2 = 0;
                    i3 = 200;
                } else if (i3 > size) {
                    i2 = size - 200;
                    i3 = size;
                }
                this.start -= i2;
                this.loadMoreOffset = i3;
                return list.subList(i2, i3);
            }

            private boolean needCompress(List list) {
                return list != null && list.size() > 200 && MicoManager.getInstance().limitingPlayMusicSize();
            }
        }

        public static String buildSongListMessage(List<Music.Song> list, int i) {
            return Remote.sGson.toJson(new PlaylistMessage(PlaylistSongList.buildSongList(list), i));
        }

        public static String buildV3PlaySongJson(String str, List<Music.Song> list, long j, int i) {
            return Remote.sGson.toJson(new PlaylistMessage(PlayV3Pact.buildSongList(str, list, j, i), i));
        }

        public static String buildStationListMessage(String str, List<Music.Station> list, int i) {
            PlaylistStationList playlistStationList;
            if (str == null) {
                playlistStationList = PlaylistStationList.buildStationList(list);
            } else {
                playlistStationList = PlaylistStationList.buildStationList(list, str);
            }
            return Remote.sGson.toJson(new PlaylistMessage(playlistStationList, i));
        }

        public static String buildV3PlayStationListMessage(String str, List<Music.Station> list, int i, String str2) {
            return Remote.sGson.toJson(new PlaylistMessage(PlayV3Pact.buildStationList(list, str, i), i));
        }

        public static String buildSongListFavouriteMessage(List<Music.Song> list) {
            ArrayList arrayList = new ArrayList(list.size());
            for (Music.Song buildSongFavourite : list) {
                arrayList.add(SongFavorite.buildSongFavourite(buildSongFavourite));
            }
            return Remote.sGson.toJson(arrayList);
        }

        static class PlaylistSimple {
            public String id;
            public String media;
            @SerializedName("startOffset")
            public int start;
            public int type;

            private PlaylistSimple(int i, long j, int i2) {
                this.media = "app_android";
                this.type = i;
                this.id = String.valueOf(j);
                this.start = i2;
            }
        }

        public static String buildSimpleMessage(int i, long j, int i2) {
            return Remote.sGson.toJson(new PlaylistSimple(i, j, i2));
        }

        static class PlayerIndex {
            public int index;
            public String media;

            private PlayerIndex() {
                this.media = "app_android";
            }
        }

        public static String buildPlayerIndex(int i) {
            PlayerIndex playerIndex = new PlayerIndex();
            playerIndex.index = i;
            return Remote.sGson.toJson(playerIndex);
        }

        static class PlayerPosition {
            public String media;
            public long position;

            private PlayerPosition() {
                this.media = "app_android";
            }
        }

        public static String buildPlayerPosition(long j) {
            PlayerPosition playerPosition = new PlayerPosition();
            playerPosition.position = j;
            return Remote.sGson.toJson(playerPosition);
        }

        public static String buildControlActionMessage(String str) {
            ControlAction controlAction = new ControlAction();
            controlAction.action = str;
            return Remote.sGson.toJson(controlAction);
        }

        public static String buildLoopTypeMessage(int i) {
            LoopType loopType = new LoopType();
            loopType.type = i;
            return Remote.sGson.toJson(loopType);
        }

        public static String buildVOIPOperatorMessage(int i) {
            VOIPOperator vOIPOperator = new VOIPOperator();
            vOIPOperator.op = i;
            return Remote.sGson.toJson(vOIPOperator);
        }

        public static String buildOpenChildModeMessage(Response.ChildModeStatus childModeStatus) {
            return Remote.sGson.toJson(childModeStatus);
        }
    }
}
