package com.xiaomi.mico.api.model;

import java.util.List;

public class PatchWall {
    public List<Block> blocks;
    public int status;

    public static class Artist {
        public String name;
    }

    public static class Block {
        public BlockStat blockStat;
        public BlockUIType blockUiType;
        public int categoryType;
        public List<String> cpList;
        public String description;
        public boolean displayMore;
        public long id;
        public List<Item> items;
        public int status;
        public String title;
    }

    public static class BlockStat {
        public String traceid;
    }

    public static class BlockUIType {
        public int columns;
        public String name;
        public float ratio;
        public boolean unitary;
    }

    public static class Image {
        public Poster poster;
    }

    public static class Item {
        public String groupName;
        public int groupTypeId;
        public Image images;
        public ItemUIType itemUiType;
        public long playCount;
        public int saleType;
        public String shortDescription;
        public List<Song> songs;
        public String target;
        public String title;
        public long updateTime;
    }

    public static class ItemUIType {
        public String name;
        public Pos pos;
    }

    public static class Pos {
        public int h;
        public int w;
        public int x;
        public int y;
    }

    public static class Poster {
        public String url;
    }

    public static class Song {
        public Artist artist;
        public String name;
    }
}
