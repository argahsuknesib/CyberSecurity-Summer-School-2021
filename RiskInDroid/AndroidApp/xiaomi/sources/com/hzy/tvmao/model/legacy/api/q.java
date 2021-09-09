package com.hzy.tvmao.model.legacy.api;

import android.text.TextUtils;
import com.hzy.tvmao.a.a;
import com.hzy.tvmao.model.legacy.api.data.UIProgramData;
import com.hzy.tvmao.utils.DataStoreUtil;
import com.kookong.app.data.ProgramData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f4437a = {"综艺", "新闻", "财经", "生活", "科教", "少儿", "其他"};
    public static short[] b = {15, 24};
    public static short[] c = {22};
    public static short[] d = {15, 27};
    public static short[] e = {18};
    public static short[] f = {8};
    public static short[] g = {9};
    public static short[] h = {2};
    public static short[] i = {17};
    public static short[] j = {4};
    public static short[] k = {5, 13};
    public static short[] l = {6, 7, 8, 15};
    public static short[] m = {1};
    public static short[] n = {3, 16, 19};
    private static String o = "CATAGORYPREFERENCE";

    public static UIProgramData a(ProgramData programData) {
        UIProgramData.CatItemData catItemData;
        String str;
        String str2;
        String str3;
        String str4;
        UIProgramData uIProgramData;
        String str5;
        ProgramData programData2 = programData;
        if (programData2 == null || programData2.pgs == null) {
            return null;
        }
        List<ProgramData.PairProgram> list = programData2.pgs;
        UIProgramData uIProgramData2 = new UIProgramData(programData2.nowTime);
        String str6 = "综艺";
        UIProgramData.CatItemData catItemData2 = new UIProgramData.CatItemData(str6);
        UIProgramData.CatItemData catItemData3 = new UIProgramData.CatItemData("电视剧");
        UIProgramData.CatItemData catItemData4 = new UIProgramData.CatItemData("体育");
        UIProgramData.CatItemData catItemData5 = new UIProgramData.CatItemData("电影");
        UIProgramData.CatItemData catItemData6 = new UIProgramData.CatItemData("少儿");
        String str7 = "新闻";
        UIProgramData.CatItemData catItemData7 = new UIProgramData.CatItemData(str7);
        UIProgramData.CatItemData catItemData8 = new UIProgramData.CatItemData("科教");
        UIProgramData.CatItemData catItemData9 = new UIProgramData.CatItemData("财经");
        String str8 = "少儿";
        UIProgramData.CatItemData catItemData10 = new UIProgramData.CatItemData("生活");
        String str9 = "科教";
        String str10 = "生活";
        UIProgramData.CatItemData catItemData11 = new UIProgramData.CatItemData("其他");
        String str11 = "其他";
        String str12 = "财经";
        int i2 = 0;
        while (i2 < list.size()) {
            ProgramData.PairProgram pairProgram = list.get(i2);
            List<ProgramData.PairProgram> list2 = list;
            if (pairProgram.flcate != null) {
                str5 = str7;
                if (pairProgram.flcate.equals("") || pairProgram.flcate.equals("null")) {
                    uIProgramData = uIProgramData2;
                    str4 = str6;
                } else {
                    String[] split = pairProgram.flcate.split(",");
                    uIProgramData = uIProgramData2;
                    int i3 = 0;
                    while (i3 < split.length) {
                        String str13 = str6;
                        if (split[i3].equals("5")) {
                            catItemData6.getSingleDataList().add(pairProgram);
                        }
                        if (split[i3].equals("3")) {
                            catItemData4.getSingleDataList().add(pairProgram);
                        }
                        if (split[i3].equals("7")) {
                            catItemData9.getSingleDataList().add(pairProgram);
                        }
                        if (split[i3].equals("8")) {
                            catItemData8.getSingleDataList().add(pairProgram);
                        }
                        if (split[i3].equals("6")) {
                            catItemData10.getSingleDataList().add(pairProgram);
                        }
                        if (split[i3].equals("9")) {
                            catItemData7.getSingleDataList().add(pairProgram);
                        }
                        if (split[i3].equals("4")) {
                            catItemData5.getSingleDataList().add(pairProgram);
                        }
                        if (split[i3].equals("1")) {
                            catItemData3.getSingleDataList().add(pairProgram);
                        }
                        if (split[i3].equals("2")) {
                            catItemData2.getSingleDataList().add(pairProgram);
                        }
                        if (split[i3].equals("10")) {
                            catItemData11.getSingleDataList().add(pairProgram);
                        }
                        i3++;
                        str6 = str13;
                    }
                    str4 = str6;
                    i2++;
                    list = list2;
                    str7 = str5;
                    uIProgramData2 = uIProgramData;
                    str6 = str4;
                }
            } else {
                uIProgramData = uIProgramData2;
                str4 = str6;
                str5 = str7;
            }
            catItemData11.getSingleDataList().add(pairProgram);
            i2++;
            list = list2;
            str7 = str5;
            uIProgramData2 = uIProgramData;
            str6 = str4;
        }
        UIProgramData uIProgramData3 = uIProgramData2;
        String str14 = str6;
        String str15 = str7;
        String[] a2 = a();
        int i4 = 0;
        while (i4 < a2.length) {
            String str16 = str14;
            if (str16.equals(a2[i4])) {
                uIProgramData3.getCatItemDatas().add(catItemData2);
                catItemData = catItemData2;
                str3 = str11;
                str = str12;
                str2 = str15;
            } else {
                str2 = str15;
                if (str2.equals(a2[i4])) {
                    uIProgramData3.getCatItemDatas().add(catItemData7);
                    catItemData = catItemData2;
                    str3 = str11;
                    str = str12;
                } else {
                    str = str12;
                    if (str.equals(a2[i4])) {
                        uIProgramData3.getCatItemDatas().add(catItemData9);
                        catItemData = catItemData2;
                    } else {
                        catItemData = catItemData2;
                        String str17 = str10;
                        if (str17.equals(a2[i4])) {
                            uIProgramData3.getCatItemDatas().add(catItemData10);
                            str10 = str17;
                        } else {
                            str10 = str17;
                            String str18 = str9;
                            if (str18.equals(a2[i4])) {
                                uIProgramData3.getCatItemDatas().add(catItemData8);
                                str9 = str18;
                            } else {
                                str9 = str18;
                                String str19 = str8;
                                if (str19.equals(a2[i4])) {
                                    uIProgramData3.getCatItemDatas().add(catItemData6);
                                    str8 = str19;
                                } else {
                                    str8 = str19;
                                    str3 = str11;
                                    if (str3.equals(a2[i4])) {
                                        uIProgramData3.getCatItemDatas().add(catItemData11);
                                    }
                                }
                            }
                        }
                    }
                    str3 = str11;
                }
            }
            i4++;
            str11 = str3;
            str14 = str16;
            str15 = str2;
            str12 = str;
            catItemData2 = catItemData;
        }
        uIProgramData3.getCatItemDatas().add(catItemData3);
        uIProgramData3.getCatItemDatas().add(catItemData5);
        uIProgramData3.getCatItemDatas().add(catItemData4);
        a(uIProgramData3);
        return uIProgramData3;
    }

    public static String[] a() {
        String[] stringArray = DataStoreUtil.i().getStringArray(o);
        return TextUtils.isEmpty(stringArray[0]) ? f4437a : stringArray;
    }

    private static void a(UIProgramData uIProgramData) {
        ArrayList<UIProgramData.CatItemData> catItemDatas = uIProgramData.getCatItemDatas();
        if (catItemDatas != null) {
            for (UIProgramData.CatItemData next : catItemDatas) {
                List<ProgramData.PairProgram> singleDataList = next.getSingleDataList();
                a(singleDataList);
                if (singleDataList != null) {
                    for (ProgramData.PairProgram next2 : singleDataList) {
                        if (!(next2 == null || next2.resId == null)) {
                            String str = next2.resId + next2.epi;
                            if (!TextUtils.isEmpty(str)) {
                                next.addProgramItem(str, next2);
                            } else {
                                next.addProgramItem(next2.sn, next2);
                            }
                        }
                    }
                    b(next.getProgramItemLists());
                }
            }
        }
    }

    private static void a(List<ProgramData.PairProgram> list) {
        if (DataStoreUtil.i().getBoolean(a.D, Boolean.TRUE)) {
            if (list != null && list.size() > 0) {
                Collections.sort(list, new r());
            }
        } else if (list != null && list.size() > 0) {
            Collections.sort(list, new s());
        }
    }

    private static void b(List<UIProgramData.ProgramItem> list) {
        if (list != null && list.size() > 0) {
            Collections.sort(list, new t());
        }
    }
}
