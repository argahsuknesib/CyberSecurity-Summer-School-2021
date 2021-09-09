package com.miui.tsmclient.entity;

import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import java.util.List;

public class BulletinResponseInfo extends CommonResponseInfo {
    @SerializedName("data")
    private List<BulletinInfo> mBulletinList;

    public List<BulletinInfo> getBulletinList() {
        return this.mBulletinList;
    }

    public static class BulletinInfo {
        @SerializedName("content")
        private String mContent;
        @SerializedName("iconUrl")
        private String mIconUrl;
        @SerializedName("id")
        private String mId;
        @SerializedName("negativeButton")
        private ButtonInfo mNegativeButton;
        @SerializedName("positiveButton")
        private ButtonInfo mPositiveButton;
        @SerializedName("tips")
        private String mTips;
        @SerializedName("title")
        private String mTitle;

        public String getId() {
            return this.mId;
        }

        public String getIconUrl() {
            return this.mIconUrl;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public String getContent() {
            return this.mContent;
        }

        public String getTips() {
            return this.mTips;
        }

        public ButtonInfo getPositiveButton() {
            return this.mPositiveButton;
        }

        public ButtonInfo getNegativeButton() {
            return this.mNegativeButton;
        }
    }

    public static class ButtonInfo {
        @SerializedName("link")
        private String mLink;
        @SerializedName("linkType")
        private int mLinkType;
        @SerializedName("noMorePrompt")
        private boolean mNoMorePrompt;
        @SerializedName("title")
        private String mTitle;

        public String getTitle() {
            return this.mTitle;
        }

        public int getLinkType() {
            return this.mLinkType;
        }

        public String getLink() {
            return this.mLink;
        }

        public boolean isNoMorePrompt() {
            return this.mNoMorePrompt;
        }
    }
}
