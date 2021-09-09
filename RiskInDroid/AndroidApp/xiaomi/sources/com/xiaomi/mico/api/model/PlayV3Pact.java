package com.xiaomi.mico.api.model;

import android.text.TextUtils;
import com.xiaomi.mico.api.model.Music;
import java.util.ArrayList;
import java.util.List;

public class PlayV3Pact {
    public V3Payload payload;

    public static class V3Payload {
        public List<AudioItem> audio_items;
        public String audio_type;
        public ListParams list_params;
        public boolean needs_loadmore;
        public String play_behavior;
    }

    public static PlayV3Pact buildSongList(String str, List<Music.Song> list, long j, int i) {
        PlayV3Pact playV3Pact = new PlayV3Pact();
        V3Payload v3Payload = new V3Payload();
        v3Payload.audio_items = new ArrayList();
        for (Music.Song buildSong : list) {
            v3Payload.audio_items.add(AudioItem.buildSong(buildSong));
        }
        v3Payload.play_behavior = "REPLACE_ALL";
        v3Payload.audio_type = "MUSIC";
        v3Payload.needs_loadmore = str.equals("PLAYLIST");
        ListParams listParams = new ListParams();
        listParams.listId = String.valueOf(j);
        listParams.type = str;
        listParams.origin = list.get(0).origin;
        listParams.loadmore_offset = list.size();
        v3Payload.list_params = listParams;
        playV3Pact.payload = v3Payload;
        return playV3Pact;
    }

    public static PlayV3Pact buildStationList(List<Music.Station> list, String str, int i) {
        PlayV3Pact playV3Pact = new PlayV3Pact();
        V3Payload v3Payload = new V3Payload();
        v3Payload.audio_items = new ArrayList();
        String str2 = null;
        for (Music.Station next : list) {
            if (TextUtils.isEmpty(str2)) {
                str2 = next.type;
            }
            v3Payload.audio_items.add(AudioItem.buildStation(next, str));
        }
        v3Payload.play_behavior = "REPLACE_ALL";
        if ("radio".equals(str2)) {
            v3Payload.audio_type = "RADIO_STATION";
        } else if ("sound".equals(str2)) {
            v3Payload.audio_type = "BOOKS";
        } else {
            v3Payload.audio_type = "MUSIC";
        }
        v3Payload.needs_loadmore = true;
        ListParams listParams = new ListParams();
        listParams.type = "STATION";
        listParams.listId = str;
        listParams.origin = list.get(0).cp;
        listParams.loadmore_offset = list.size();
        v3Payload.list_params = listParams;
        playV3Pact.payload = v3Payload;
        return playV3Pact;
    }

    public static class AudioItem {
        public ItemId item_id;
        public Stream stream;

        public static AudioItem buildSong(Music.Song song) {
            AudioItem audioItem = new AudioItem();
            audioItem.item_id = new ItemId(song);
            audioItem.stream = new Stream(song);
            return audioItem;
        }

        public static AudioItem buildStation(Music.Station station, String str) {
            AudioItem audioItem = new AudioItem();
            audioItem.item_id = new ItemId(station);
            audioItem.stream = new Stream(station);
            return audioItem;
        }
    }

    public static class ItemId {
        public String audio_id;
        public ContentProvider cp;

        public ItemId(Music.Song song) {
            this.audio_id = song.audioID;
            this.cp = new ContentProvider(song);
        }

        public ItemId(Music.Station station) {
            this.audio_id = station.audioID;
            this.cp = new ContentProvider(station);
        }

        public static class ContentProvider {
            public String album_id;
            public int episode_index;
            public String id;
            public String label;
            public String label_id;
            public String name;

            public ContentProvider(Music.Song song) {
                this.name = song.origin;
                this.id = song.originSongID;
                this.album_id = song.albumID;
            }

            public ContentProvider(Music.Station station) {
                this.name = station.origin;
                this.id = station.stationID;
                this.episode_index = station.episodesNum;
                this.album_id = station.albumId;
            }
        }
    }

    public static class Stream {
        public boolean authentication;
        public long duration_in_ms;
        public int offset_in_ms;
        public boolean redirect;
        public String url;

        public Stream(Music.Song song) {
            this.authentication = song.authentication;
            this.duration_in_ms = song.duration;
            this.offset_in_ms = song.offsetInMs;
            this.url = song.playUrl;
        }

        public Stream(Music.Station station) {
            this.authentication = station.authentication;
            this.duration_in_ms = station.duration;
            this.offset_in_ms = 0;
            this.url = station.playUrl;
        }
    }

    public static class ListParams {
        public String listId;
        public int loadmore_offset;
        public String origin;
        public String type;

        public ListParams() {
        }

        public ListParams(Music.Song song) {
            this.type = "SONGBOOK";
            this.origin = song.origin;
        }

        public ListParams(Music.Station station) {
            this.origin = station.origin;
            this.loadmore_offset = station.episodesNum;
        }
    }
}
