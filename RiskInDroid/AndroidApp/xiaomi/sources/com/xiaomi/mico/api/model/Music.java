package com.xiaomi.mico.api.model;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.xiaomi.mico.common.util.ContainerUtil;
import java.io.Serializable;
import java.util.List;

public class Music {

    public static class ArtistHomepage {
        @SerializedName("albumIdList")
        public List<Long> albumIDList;
        public Artist artist;
        @SerializedName("hotSongList")
        public List<Long> songIDList;
    }

    public static class CategoryItem {
        public List<String> cpList;
        public String imageUrl;
        public String name;
        public String parentImageUrl;
        public String parentName;
        public String queryExample;
        public int stationCategoryType;
    }

    public static class CategoryItemParent implements Serializable {
        public String imgUrl;
        public List<CategoryItem> items;
        public String name;
    }

    public static class HomeButton {
        public String action;
        public String albumId;
        public long globalId;
        public String imageUrl;
        public String name;
        public int saleType;
        public String smallButtonAction;
        public String type;
    }

    public static class SearchResult {
        public List<Album> albumList;
        public List<Artist> artistList;
        @SerializedName("playLists")
        public List<Sheet> sheetList;
        public List<Song> songList;
        public List<Station> stationList;
    }

    public static class Section implements Serializable {
        private static final long serialVersionUID = -2813318509200704834L;
        @SerializedName("sectionItems")
        public List<SectionData> dataList;
        @SerializedName("sectionIcon")
        public String icon;
        public long sectionID;
        @SerializedName("sectionStyle")
        public String style;
        public String title;
    }

    public static class SongBook {
        public String cover;
        public long id;
        public String intro;
        public String name;
        public String origin;
        public List<Song> songList;
        public String subtitle;
    }

    public static class StationSoundList {
        public boolean isEnd;
        public List<Station> soundList;
    }

    public static class TagsArtist implements Serializable {
        public List<Artist> artists;
        public List<String> tags;
    }

    public static class Artist implements Serializable {
        private static final long serialVersionUID = 153011036252764364L;
        public long artistID;
        public String iconURL;
        public String name;
        public boolean selected;

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Artist) && this.artistID == ((Artist) obj).artistID;
            }
            return true;
        }
    }

    public static class Album implements Serializable {
        private static final long serialVersionUID = -8009311371502390555L;
        public long albumID;
        public Artist artist;
        public String coverURL;
        public String name;
        public List<Song> songList;

        public String getArtistName() {
            Artist artist2 = this.artist;
            if (artist2 != null) {
                return artist2.name;
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Album) && this.albumID == ((Album) obj).albumID;
            }
            return true;
        }
    }

    public static class Song implements Serializable {
        private static final long serialVersionUID = -661694326758003726L;
        public String albumID;
        public String albumName;
        public Artist artist;
        @SerializedName(alternate = {"artistName"}, value = "artistDisplayName")
        public String artistDisplayName;
        @SerializedName(alternate = {"audioId"}, value = "audioID")
        public String audioID;
        public String audioType;
        public boolean authentication;
        public int collection;
        @SerializedName(alternate = {"cover"}, value = "coverURL")
        public String coverURL;
        public long duration;
        public String lyricURL;
        public String name;
        public int offsetInMs;
        @SerializedName(alternate = {"cpName"}, value = "origin")
        public String origin;
        @SerializedName(alternate = {"cpDisplayName"}, value = "originName")
        public String originName;
        @SerializedName(alternate = {"cpId"}, value = "originSongID")
        public String originSongID;
        public String playUrl;
        public long songID;
        @SerializedName(alternate = {"qqUnplayableCode"}, value = "unplayableCode")
        public int unplayableCode;
        @SerializedName(alternate = {"qqVip"}, value = "vip")
        public int vip;

        public static class Simple {
            public long global_id;
            public String origin;
            public String origin_id;
        }

        public String getArtistName() {
            if (!TextUtils.isEmpty(this.artistDisplayName)) {
                return this.artistDisplayName;
            }
            Artist artist2 = this.artist;
            if (artist2 != null) {
                return artist2.name;
            }
            return null;
        }

        public Artist newArtist(String str) {
            Artist artist2 = new Artist();
            artist2.name = str;
            return artist2;
        }

        public boolean isLegal() {
            return !TextUtils.isEmpty(this.origin) && !TextUtils.isEmpty(this.originSongID);
        }

        public boolean isLegalV3() {
            return !TextUtils.isEmpty(this.playUrl) && !TextUtils.isEmpty(this.audioID) && !this.audioID.equals("0");
        }

        public boolean isVipSong() {
            return this.vip == 1;
        }

        public boolean needToBeVip() {
            return this.unplayableCode == 2;
        }

        public Simple toSimple() {
            Simple simple = new Simple();
            simple.global_id = this.songID;
            simple.origin = this.origin;
            simple.origin_id = this.originSongID;
            return simple;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Song) && this.songID == ((Song) obj).songID;
            }
            return true;
        }

        public int hashCode() {
            return (int) (this.songID + 527);
        }
    }

    public static class Sheet implements Serializable {
        private static final long serialVersionUID = -8554258027169356112L;
        public String cover;
        public String cpName;
        public String intro;
        public String name;
        @SerializedName("id")
        public long sheetID;
        @SerializedName("songList")
        public List<Long> songIDList;
        public String subtitle;
        public List<String> tags;

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Sheet) && this.sheetID == ((Sheet) obj).sheetID;
            }
            return true;
        }
    }

    public static class Station implements Serializable {
        private static final long serialVersionUID = -4790373810258482459L;
        public String albumAbstract;
        public String albumGlobalID;
        public String albumId;
        public String albumName;
        public String audioID;
        public boolean authentication;
        public boolean bought;
        public String broadcaster;
        public String category;
        public int collection;
        public String cover;
        public String cp;
        public long duration;
        public int episodes;
        public int episodesNum;
        public float fee;
        public boolean fromAddBabySchedule;
        public long globalID;
        public String h5Url;
        public boolean isFeature;
        public String isReverse;
        public String origin;
        public String originName;
        public String originalFee;
        public String parentID;
        public String paymentUrl;
        public long playCount;
        public String playSequence;
        public String playUrl;
        public boolean playable;
        public int purchasePrice;
        public int saleType;
        public long salesPrice;
        public int sequence;
        public String snippetTitle;
        @SerializedName("id")
        public String stationID;
        public String stationOrigin;
        public String summaryUrl;
        public String title;
        public String titleAlias;
        public String type;
        public long updateTime;

        public boolean supportSingleEpisodePurchase() {
            return this.saleType == 1;
        }

        public boolean needOverall() {
            return this.saleType == 2;
        }

        public static class Simple {
            public long globalId;
            public String id;
            public String origin;
            public int type;

            public Simple(long j, String str, String str2, int i) {
                this.globalId = j;
                this.id = str;
                this.origin = str2;
                this.type = i;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Station)) {
                return false;
            }
            Station station = (Station) obj;
            return Util.equals(this.stationID, station.stationID) && Util.equals(this.type, station.type) && Util.equals(this.origin, station.origin);
        }

        public boolean needPurchase(Station station) {
            if (station.isFree()) {
                return false;
            }
            if (station.supportSingleEpisodePurchase()) {
                if (!this.bought) {
                    return true;
                }
                return false;
            } else if (!station.bought) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isLegal() {
            return this.playable || ContainerUtil.hasData(this.origin);
        }

        public String cpNameOrBoradcaster() {
            if (!TextUtils.isEmpty(this.originName)) {
                return this.originName;
            }
            if (!TextUtils.isEmpty("")) {
                return "";
            }
            return this.broadcaster;
        }

        public boolean isChild() {
            return ContainerUtil.hasData(this.category) && this.category.contains("儿童");
        }

        public boolean isFree() {
            return this.saleType <= 0;
        }

        public String getOriginToGetStationList() {
            return this.stationOrigin;
        }
    }

    public static class SectionData implements Serializable {
        private static final long serialVersionUID = -2813318509200704834L;
        public String action;
        public String imageURL;
        public String name;
        public String squareImageURL;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SectionData)) {
                return false;
            }
            SectionData sectionData = (SectionData) obj;
            return Util.equals(this.name, sectionData.name) && Util.equals(this.imageURL, sectionData.imageURL) && Util.equals(this.squareImageURL, sectionData.squareImageURL) && Util.equals(this.action, sectionData.action);
        }
    }

    public static class Channel implements Serializable {
        private static final long serialVersionUID = -3484722954077939507L;
        public String cover;
        public long id;
        public String intro;
        public boolean isDefault;
        public boolean isQQCollection;
        public String name;
        public boolean operable;
        public String origin;
        public int songCount;
        public List<Song> songList;
        public String subtitle;
        public List<String> tags;
        public String type;

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Channel) && this.id == ((Channel) obj).id;
            }
            return true;
        }

        public boolean isSelfBuild() {
            return "SELF_OWNED".equals(this.type);
        }
    }

    public static class Favourite {
        public boolean isFavourite;
        public String origin;
        public String originSongID;

        public boolean isSameSong(Song song) {
            String str = this.origin;
            return str != null && this.originSongID != null && str.equals(song.origin) && this.originSongID.equals(song.originSongID);
        }
    }
}
