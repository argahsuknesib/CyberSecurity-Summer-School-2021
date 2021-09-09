package com.xiaomi.mico.api.model;

import com.xiaomi.mico.common.util.ContainerUtil;
import java.util.ArrayList;
import java.util.List;

public class DialogRecordV3 {
    public String deviceId;
    public List<RecordV3Facade> records;
    public String userId;

    public static class AlertParam {
        public String circle;
        public String circleExtra;
        public String datetime;
        public String offset;
        public String type;
    }

    public static class AnswerType {
    }

    public static class AudioParam {
        List<AudioInfo> audioInfoList;
    }

    public static class ErrorParam {
        public String text;
    }

    public static class RecordV3Facade {
        public List<Answer> answers;
        public String query;
        public long time;
    }

    public static class TTSParam {
        public String text;
    }

    public static class Answer {
        public AlertParam alert;
        public AudioParam audio;
        public ErrorParam error;
        public TTSParam tts;
        public String type;

        /* access modifiers changed from: package-private */
        public String getTtsText() {
            TTSParam tTSParam = this.tts;
            if (tTSParam == null) {
                return "";
            }
            return tTSParam.text;
        }

        /* access modifiers changed from: package-private */
        public List<AudioInfo> getAudioInfoList() {
            AudioParam audioParam = this.audio;
            if (audioParam == null) {
                return new ArrayList();
            }
            return audioParam.audioInfoList;
        }
    }

    public static class AudioInfo {
        private String artist;
        private String cpName;
        public String title;

        /* access modifiers changed from: package-private */
        public String getSubTitle() {
            if (ContainerUtil.hasData(this.cpName)) {
                return this.cpName;
            }
            return this.artist;
        }
    }
}
