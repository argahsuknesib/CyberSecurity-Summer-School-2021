package com.xiaomi.mico.api.model;

import java.util.List;

public class IntelligentModel {
    private List<ListBean> list;

    public List<ListBean> getList() {
        return this.list;
    }

    public void setList(List<ListBean> list2) {
        this.list = list2;
    }

    public static class ListBean {
        private List<CardsBean> cards;
        private int displayType;
        private boolean more;
        private String name;
        private String type;
        private int typeId;

        public int getTypeId() {
            return this.typeId;
        }

        public void setTypeId(int i) {
            this.typeId = i;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public List<CardsBean> getCards() {
            return this.cards;
        }

        public void setCards(List<CardsBean> list) {
            this.cards = list;
        }

        public boolean isMore() {
            return this.more;
        }

        public void setMore(boolean z) {
            this.more = z;
        }

        public int getDisplayType() {
            return this.displayType;
        }

        public void setDisplayType(int i) {
            this.displayType = i;
        }

        public static class CardsBean {
            private long changeTime;
            private String contentType;
            private int displayType;
            private long id;
            private String infoStreamId;
            private String jumpLink;
            private int likeAmount;
            private String mainTitle;
            private String picContent;
            private String picTitle;
            private String picture;
            private int position;
            private int readAmount;
            private String subTitle;
            private int voteUserAmount;

            public String getSubTitle() {
                return this.subTitle;
            }

            public void setSubTitle(String str) {
                this.subTitle = str;
            }

            public String getMainTitle() {
                return this.mainTitle;
            }

            public void setMainTitle(String str) {
                this.mainTitle = str;
            }

            public long getChangeTime() {
                return this.changeTime;
            }

            public void setChangeTime(long j) {
                this.changeTime = j;
            }

            public long getId() {
                return this.id;
            }

            public void setId(long j) {
                this.id = j;
            }

            public int getPosition() {
                return this.position;
            }

            public void setPosition(int i) {
                this.position = i;
            }

            public String getJumpLink() {
                return this.jumpLink;
            }

            public void setJumpLink(String str) {
                this.jumpLink = str;
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

            public String getContentType() {
                return this.contentType;
            }

            public void setContentType(String str) {
                this.contentType = str;
            }

            public int getReadAmount() {
                return this.readAmount;
            }

            public void setReadAmount(int i) {
                this.readAmount = i;
            }

            public int getLikeAmount() {
                return this.likeAmount;
            }

            public void setLikeAmount(int i) {
                this.likeAmount = i;
            }

            public String getInfoStreamId() {
                return this.infoStreamId;
            }

            public void setInfoStreamId(String str) {
                this.infoStreamId = str;
            }

            public int getDisplayType() {
                return this.displayType;
            }

            public void setDisplayType(int i) {
                this.displayType = i;
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
}
