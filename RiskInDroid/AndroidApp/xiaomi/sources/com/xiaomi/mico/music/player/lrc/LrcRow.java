package com.xiaomi.mico.music.player.lrc;

import _m_j.gsy;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

class LrcRow implements Comparable<LrcRow> {
    private final String mContent;
    private final int mTimeMillis;
    private final String mTimeString;
    private int mTotalTime;

    static List<LrcRow> createRows(String str) {
        if (!str.startsWith("[")) {
            return null;
        }
        if (str.indexOf("]") != 9 && str.indexOf("]") != 10) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("]") + 1;
        String substring = str.substring(lastIndexOf, str.length());
        String[] split = str.substring(0, lastIndexOf).replace("[", "-").replace("]", "-").split("-");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2.trim()) && !TextUtils.isEmpty(substring.trim())) {
                try {
                    if (substring.contains("&apos;")) {
                        substring = substring.replace("&apos;", "'");
                    }
                    arrayList.add(new LrcRow(str2, formatTime(str2), substring));
                } catch (Exception e) {
                    gsy.O000000o(5, "LrcRow", e.getMessage());
                }
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    private static int formatTime(String str) {
        String[] split = str.replace('.', ':').split(":");
        return (Integer.parseInt(split[0]) * 60 * 1000) + (Integer.parseInt(split[1]) * 1000) + Integer.parseInt(split[2]);
    }

    private LrcRow(String str, int i, String str2) {
        this.mTimeString = str;
        this.mTimeMillis = i;
        this.mContent = str2;
    }

    public String getTimeString() {
        return this.mTimeString;
    }

    public int getTimeMillis() {
        return this.mTimeMillis;
    }

    public String getContent() {
        return this.mContent;
    }

    public long getTotalTime() {
        return (long) this.mTotalTime;
    }

    public void setTotalTime(int i) {
        this.mTotalTime = i;
    }

    public int compareTo(LrcRow lrcRow) {
        return this.mTimeMillis - lrcRow.mTimeMillis;
    }

    public String toString() {
        return "LrcRow [timeString=" + this.mTimeString + ", timeMillis=" + this.mTimeMillis + ", content=" + this.mContent + "]";
    }
}
