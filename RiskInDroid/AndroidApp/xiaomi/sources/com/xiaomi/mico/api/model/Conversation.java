package com.xiaomi.mico.api.model;

import com.google.gson.annotations.SerializedName;
import com.xiaomi.mico.api.model.DialogRecordV3;
import com.xiaomi.mico.common.util.ContainerUtil;
import java.util.ArrayList;
import java.util.List;

public class Conversation {
    public long nextTimestamp;
    public List<MicoRecordString> records;

    public static class Cover {
        public String description;
        public List<Sources> sources;
    }

    public static class Header {
        public String dialog_id;
        public String id;
        public String name;
        public String namespace;
    }

    public static class Item {
        public String audio_id;
        public Cover cover;
        public long duration_in_ms;
        public Provider provider;
        public Title title;
    }

    public static class MicoRecordData {
        public RecordGroup recordGroup;
        public long timestamp;
    }

    public static class MicoRecordString {
        public String recordGroup;
        public long timestamp;
    }

    public static class Payload {
        public String behavior;
        public List<Item> items;
        public String name;
        public String query;
        public String text;
        public String value;
    }

    public static class Provider {
        public Cover logo;
        public String name;
    }

    public static class RecordGroup {
        public Role user;
        public Role xiaoai;
    }

    public static class Sources {
        public String url;
    }

    public static class Title {
        public String main_title;
        public String sub_title;
    }

    public static class Widget {
        public String artist;
        public String cp;
        public String id;
        public String originSong;
        public String text;
        public String title;
        public String type;
    }

    public static class Role {
        public String content;
        @SerializedName("instructions")
        public String instructionJson;
        public List<Instruction> instructionList;
        public String speaker;
        @SerializedName("widget")
        public String widgetJson;
        public List<Widget> widgetList;

        public Role(String str) {
            this.content = str;
            this.speaker = "User";
        }

        public Role(List<DialogRecordV3.Answer> list) {
            if (!ContainerUtil.isEmpty(list)) {
                for (DialogRecordV3.Answer next : list) {
                    String str = next.type;
                    char c = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != 83411) {
                        if (hashCode == 62628790 && str.equals("AUDIO")) {
                            c = 0;
                        }
                    } else if (str.equals("TTS")) {
                        c = 1;
                    }
                    if (c == 0) {
                        List<DialogRecordV3.AudioInfo> audioInfoList = next.getAudioInfoList();
                        ArrayList arrayList = new ArrayList(audioInfoList.size());
                        arrayList.add(new Instruction(audioInfoList));
                        this.instructionList = arrayList;
                    } else if (c == 1) {
                        this.content = next.getTtsText();
                    }
                }
            }
        }
    }

    public static class Instruction {
        public Header header;
        public Payload payload;

        Instruction(List<DialogRecordV3.AudioInfo> list) {
            ArrayList arrayList = new ArrayList();
            for (DialogRecordV3.AudioInfo next : list) {
                Item item = new Item();
                item.title = new Title();
                item.title.main_title = next.title;
                item.title.sub_title = next.getSubTitle();
                arrayList.add(item);
            }
            this.payload = new Payload();
            this.payload.items = arrayList;
        }
    }
}
