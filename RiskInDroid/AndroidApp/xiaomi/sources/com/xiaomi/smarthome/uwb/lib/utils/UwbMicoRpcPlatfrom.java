package com.xiaomi.smarthome.uwb.lib.utils;

import com.xiaomi.smarthome.library.log.LogType;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class UwbMicoRpcPlatfrom {
    private static volatile UwbMicoRpcPlatfrom PLATFORM;

    public abstract String nextPayload();

    public abstract String prevPayload();

    private UwbMicoRpcPlatfrom() {
    }

    public static UwbMicoRpcPlatfrom get() {
        if (PLATFORM == null) {
            init(false);
        }
        return PLATFORM;
    }

    public static void init(boolean z) {
        UwbLogUtil.writeLogOnAll(LogType.LOG_UWB, "zxtUwbMicoRpcPlatfrom", "init hasScreen ".concat(String.valueOf(z)));
        if (PLATFORM == null) {
            synchronized (UwbMicoRpcPlatfrom.class) {
                if (PLATFORM == null) {
                    PLATFORM = findPlatform(z);
                } else {
                    UwbLogUtil.writeLogOnAll(LogType.LOG_UWB, "zxtUwbMicoRpcPlatfrom", "already init: ".concat(String.valueOf(z)));
                }
            }
        }
    }

    private static UwbMicoRpcPlatfrom findPlatform(boolean z) {
        if (z) {
            return new Android();
        }
        return new Linux();
    }

    public String setVolumePayload(int i) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(i);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", "set_speaker_SpeakerVolume");
            jSONObject.put("params", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String playOrPausePayload(boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(z ? 1 : 0);
        try {
            jSONObject.put("method", "set_speaker_SpeakerRate");
            jSONObject.put("params", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String getPropPayload() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("speaker_SpeakerVolume");
        jSONArray.put("speaker_SpeakerRate");
        try {
            jSONObject.put("method", "get_prop");
            jSONObject.put("params", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    static class Linux extends UwbMicoRpcPlatfrom {
        Linux() {
            super();
        }

        public String nextPayload() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", "play_next");
                jSONObject.put("params", new JSONArray());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        public String prevPayload() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", "play_prev");
                jSONObject.put("params", new JSONArray());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    static class Android extends UwbMicoRpcPlatfrom {
        Android() {
            super();
        }

        public String nextPayload() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", "act_player_prev");
                jSONObject.put("params", new JSONArray());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        public String prevPayload() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", "act_player_next");
                jSONObject.put("params", new JSONArray());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }
}
