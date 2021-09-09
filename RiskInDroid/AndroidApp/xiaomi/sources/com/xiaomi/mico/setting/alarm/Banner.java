package com.xiaomi.mico.setting.alarm;

public class Banner {

    public static class Item {
        public int drawable;
        public String type;

        Item(String str, int i) {
            this.type = str;
            this.drawable = i;
        }
    }
}
