package com.xiaomi.mico.api.model;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SkillStore {

    public static class Category implements Serializable {
        private static final long serialVersionUID = -516989655075738930L;
        public String action;
        public int imageID;
        public String imageURL;
        public String name;
    }

    public static class Section implements Serializable {
        private static final long serialVersionUID = 7435277533142056835L;
        public String name;
        @SerializedName("skillItems")
        public List<Skill> skills;
        public String type;
    }

    public static class SectionV2 implements Serializable {
        private static final long serialVersionUID = -3493281744182290817L;
        public String action;
        public List<SkillV2> skills;
        public String title;
        public String topicIconUrl;
        public String topicId;
        public String trackKey;
    }

    @JsonAdapter(SkillDetailJsonAdapter.class)
    public static class SkillDetail implements Serializable {
        private static final long serialVersionUID = -3971999535940172858L;
        public String icon;
        public String name;
        public List<SkillDetailSection> sections;
        public float userAvgRating;
        public long userRatingCount;
    }

    public static class SkillDetailSection implements Serializable {
        private static final long serialVersionUID = 5160313151220702733L;
        public String name;
        public String type;
    }

    public static class SkillDetailSectionIntro extends SkillDetailSection implements Serializable {
        private static final long serialVersionUID = -1428463383534891258L;
        public String intro;
    }

    public static class SkillDetailSectionTips extends SkillDetailSection implements Serializable {
        private static final long serialVersionUID = 3820110736168049029L;
        public List<SkillTip> tipsList;
    }

    public static class SkillDetailSectionVideo extends SkillDetailSection {
        public String intro;
    }

    public static class Stock implements Serializable {
        private static final long serialVersionUID = -8155516769121493099L;
        @SerializedName("subscriptionCode")
        public String code;
        public String dataType;
        public String name;
        public String status;
        public String subscriptionId;
        public String type;
    }

    public static class Tip implements Serializable {
        private static final long serialVersionUID = -9217887709886408022L;
        public List<String> tips;

        public String say() {
            if (this.tips.size() > 0) {
                return this.tips.get(0);
            }
            return null;
        }

        public String knowledge() {
            if (this.tips.size() >= 2) {
                return this.tips.get(1);
            }
            return null;
        }
    }

    public static class Skill implements Serializable {
        private static final long serialVersionUID = -1653543707717983444L;
        public String action;
        public String author;
        public String description;
        public SkillDetail detail;
        public String icon;
        public boolean isLab;
        public boolean isPending;
        @SerializedName(alternate = {"skillName", "displayName"}, value = "name")
        public String name;
        public String providerID;
        public String skillID;
        public SkillPrivacy skillPrivacy;
        public List<String> tips;
        public String type;

        public boolean needAuth() {
            return !TextUtils.isEmpty(this.providerID);
        }
    }

    public class SubCategory {
        public String categoryID;
        public List<Skill> skillItems;

        public SubCategory() {
        }
    }

    public class SkillDetailJsonAdapter extends TypeAdapter<SkillDetail> {
        public void write(JsonWriter jsonWriter, SkillDetail skillDetail) throws IOException {
        }

        public SkillDetailJsonAdapter() {
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.Class):T
         arg types: [com.google.gson.JsonObject, java.lang.Class]
         candidates:
          com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.reflect.Type):T
          com.google.gson.Gson.fromJson(com.google.gson.stream.JsonReader, java.lang.reflect.Type):T
          com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T
          com.google.gson.Gson.fromJson(java.io.Reader, java.lang.reflect.Type):T
          com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T
          com.google.gson.Gson.fromJson(java.lang.String, java.lang.reflect.Type):T
          com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.Class):T */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00cb  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00f2  */
        public SkillDetail read(JsonReader jsonReader) throws IOException {
            char c;
            char c2;
            SkillDetail skillDetail = new SkillDetail();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                switch (nextName.hashCode()) {
                    case -2000803673:
                        if (nextName.equals("userRatingCount")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3226745:
                        if (nextName.equals("icon")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3373707:
                        if (nextName.equals("name")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 947936814:
                        if (nextName.equals("sections")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1592097668:
                        if (nextName.equals("userAvgRating")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c == 0) {
                    skillDetail.name = jsonReader.nextString();
                } else if (c == 1) {
                    skillDetail.icon = jsonReader.nextString();
                } else if (c == 2) {
                    skillDetail.userAvgRating = (float) jsonReader.nextDouble();
                } else if (c == 3) {
                    skillDetail.userRatingCount = jsonReader.nextLong();
                } else if (c != 4) {
                    jsonReader.skipValue();
                } else {
                    skillDetail.sections = new ArrayList();
                    for (JsonObject jsonObject : (List) new Gson().fromJson(jsonReader, new TypeToken<List<JsonObject>>() {
                        /* class com.xiaomi.mico.api.model.SkillStore.SkillDetailJsonAdapter.AnonymousClass1 */
                    }.getType())) {
                        String asString = jsonObject.get("type").getAsString();
                        int hashCode = asString.hashCode();
                        if (hashCode != -938102371) {
                            if (hashCode != 3560248) {
                                if (hashCode == 100361836 && asString.equals("intro")) {
                                    c2 = 0;
                                    if (c2 != 0) {
                                        skillDetail.sections.add(new Gson().fromJson((JsonElement) jsonObject, SkillDetailSectionIntro.class));
                                    } else if (c2 == 1) {
                                        skillDetail.sections.add(new Gson().fromJson((JsonElement) jsonObject, SkillDetailSectionTips.class));
                                    } else if (c2 == 2) {
                                        skillDetail.sections.add(new Gson().fromJson((JsonElement) jsonObject, SkillDetailSectionRating.class));
                                    }
                                }
                            } else if (asString.equals("tips")) {
                                c2 = 1;
                                if (c2 != 0) {
                                }
                            }
                        } else if (asString.equals("rating")) {
                            c2 = 2;
                            if (c2 != 0) {
                            }
                        }
                        c2 = 65535;
                        if (c2 != 0) {
                        }
                    }
                }
            }
            jsonReader.endObject();
            return skillDetail;
        }
    }

    public static class SkillTip implements Serializable {
        private static final long serialVersionUID = -5668294282700536291L;
        @SerializedName(alternate = {"tips"}, value = "contents")
        public List<String> tips;
        public String title;

        public SkillTip(String str, List<String> list) {
            this.title = str;
            this.tips = list;
        }
    }

    public static class SkillDetailSectionRating extends SkillDetailSection implements Serializable {
        private static final long serialVersionUID = 2090084581632960754L;
        public String skillId;
        public float userAvgRating;
        public long userRatingCount;

        public SkillDetailSectionRating() {
        }

        public SkillDetailSectionRating(String str, float f, long j) {
            this.type = "rating";
            this.skillId = str;
            this.userAvgRating = f;
            this.userRatingCount = j;
        }

        public float getUserAvgRating() {
            return this.userAvgRating;
        }

        public long getUserRatingCount() {
            return this.userRatingCount;
        }

        public String getSkillId() {
            return this.skillId;
        }
    }

    public class RssSkills {
        public List<RssSkill> disabledSkills;
        public List<RssSkill> enabledSkills;

        public RssSkills() {
        }
    }

    public class RssSkill {
        public String developerName;
        public String displayName;
        public boolean enabled;
        public List<RssSkillIcon> icons;
        public String skillId;
        public String skillName;
        public String summary;

        public RssSkill() {
        }

        public String getIcon() {
            List<RssSkillIcon> list = this.icons;
            if (list != null) {
                RssSkillIcon rssSkillIcon = null;
                for (RssSkillIcon next : list) {
                    if ("App".equals(next.storeType)) {
                        return next.icon;
                    }
                    if (next.storeType == null) {
                        rssSkillIcon = next;
                    }
                }
                if (rssSkillIcon != null) {
                    return rssSkillIcon.icon;
                }
            }
            return null;
        }
    }

    public class RssSkillIcon {
        public String icon;
        public String largetIcon;
        public String storeType;

        public RssSkillIcon() {
        }
    }

    public class RankingType implements Serializable {
        private static final long serialVersionUID = 5927655823899409531L;
        public String id;
        public String name;

        public RankingType() {
        }

        public boolean equals(Object obj) {
            RankingType rankingType = (RankingType) obj;
            return this.id.equals(rankingType.id) && this.name.equals(rankingType.name);
        }
    }

    public class Ranking extends RankingType implements Serializable {
        public List<SkillV2> skills;

        public Ranking() {
            super();
        }
    }

    public class SkillV2 implements Serializable {
        public String action;
        public String displayName;
        public List<SkillIcon> icons;
        public List<SkillTip> instructions;
        public float rating;
        public int ratingCount;
        public SkillIcon skillIcon;
        public String skillId;
        public String skillStatus;
        public String slogan;
        public List<String> tips;

        public SkillV2() {
        }

        public String getIcon() {
            List<SkillIcon> list = this.icons;
            if (list == null) {
                return null;
            }
            for (SkillIcon next : list) {
                if ("App".equals(next.storeType)) {
                    return next.icon;
                }
            }
            return null;
        }

        public String getLargeIcon() {
            List<SkillIcon> list = this.icons;
            if (list == null) {
                return null;
            }
            for (SkillIcon next : list) {
                if ("App".equals(next.storeType)) {
                    return next.largetIcon;
                }
            }
            return null;
        }

        public List<String> getContents() {
            List<SkillTip> list = this.instructions;
            if (list == null || list.size() <= 0) {
                return null;
            }
            return this.instructions.get(0).tips;
        }

        public String getFirstTip() {
            List<String> list;
            List<String> list2 = this.tips;
            if (list2 != null && list2.size() > 0) {
                return this.tips.get(0);
            }
            List<SkillTip> list3 = this.instructions;
            if (list3 == null || list3.size() <= 0 || (list = this.instructions.get(0).tips) == null || list.size() <= 0) {
                return null;
            }
            return list.get(0);
        }

        public String getSecondTip() {
            List<String> list;
            List<String> list2 = this.tips;
            if (list2 != null && list2.size() > 1) {
                return this.tips.get(1);
            }
            List<SkillTip> list3 = this.instructions;
            if (list3 == null || list3.size() <= 0 || (list = this.instructions.get(0).tips) == null || list.size() <= 1) {
                return null;
            }
            return list.get(1);
        }

        public boolean isLab() {
            String str = this.skillStatus;
            return str != null && "Beta".equalsIgnoreCase(str);
        }

        public boolean isPending() {
            String str = this.skillStatus;
            return str != null && "Created".equalsIgnoreCase(str);
        }
    }

    public class SkillDetailV2 extends SkillV2 implements Serializable {
        private static final long serialVersionUID = -3971999535940172858L;
        public String developerName;
        public SkillPrivacy privacy;
        @SerializedName("accountLinkId")
        public String providerID;
        public String skillType;
        public String summary;
        public String topRightAction;
        public String topRightLabel;

        public SkillDetailV2() {
            super();
        }
    }

    public class SkillIcon implements Serializable {
        public String icon;
        @SerializedName("large_icon")
        public String largetIcon;
        @SerializedName("store_type")
        public String storeType;

        public SkillIcon() {
        }
    }

    public class Privacy {
        @SerializedName("privacy_enabled")
        public boolean privacyEnabled;
        @SerializedName("privacy_list")
        public List<PrivacyInfo> privacyList;

        public Privacy() {
        }
    }

    public class PrivacyInfo {
        public String description;
        @SerializedName("display_name")
        public String displayName;
        @SerializedName("enum_name")
        public String enumName;

        public PrivacyInfo() {
        }
    }

    public class SkillPrivacy implements Serializable {
        @SerializedName("skill_data_privacy_list")
        public List<String> privacyList;

        public SkillPrivacy() {
        }
    }
}
