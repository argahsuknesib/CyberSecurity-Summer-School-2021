package com.xiaomi.mico.api.model;

import java.util.List;

public class IntelligentMoreModel {
    private int displayType;
    private List<ListBean> list;

    public List<ListBean> getList() {
        return this.list;
    }

    public void setList(List<ListBean> list2) {
        this.list = list2;
    }

    public int getDisplayType() {
        return this.displayType;
    }

    public void setDisplayType(int i) {
        this.displayType = i;
    }

    public static class ListBean {
        private int id;
        private String jumpLink;
        private int likeAmount;
        private String mainTitle;
        private String picContent;
        private String picTitle;
        private String picture;
        private int position;
        private int readAmount;
        private int voteUserAmount;

        public int getLikeAmount() {
            return this.likeAmount;
        }

        public void setLikeAmount(int i) {
            this.likeAmount = i;
        }

        public String getMainTitle() {
            return this.mainTitle;
        }

        public void setMainTitle(String str) {
            this.mainTitle = str;
        }

        public int getReadAmount() {
            return this.readAmount;
        }

        public void setReadAmount(int i) {
            this.readAmount = i;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int i) {
            this.id = i;
        }

        public int getPosition() {
            return this.position;
        }

        public void setPosition(int i) {
            this.position = i;
        }

        public int getVoteUserAmount() {
            return this.voteUserAmount;
        }

        public void setVoteUserAmount(int i) {
            this.voteUserAmount = i;
        }

        public String getPicture() {
            return this.picture;
        }

        public void setPicture(String str) {
            this.picture = str;
        }

        public String getJumpLink() {
            return this.jumpLink;
        }

        public void setJumpLink(String str) {
            this.jumpLink = str;
        }

        public String getPicTitle() {
            return this.picTitle;
        }

        public void setPicTitle(String str) {
            this.picTitle = str;
        }

        public String getPicContent() {
            return this.picContent;
        }

        public void setPicContent(String str) {
            this.picContent = str;
        }
    }
}
