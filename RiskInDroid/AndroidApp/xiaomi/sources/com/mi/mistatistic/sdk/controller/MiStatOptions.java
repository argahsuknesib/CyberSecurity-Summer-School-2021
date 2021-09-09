package com.mi.mistatistic.sdk.controller;

import java.io.Serializable;
import java.util.ArrayList;

public class MiStatOptions implements Serializable {
    public String appId;
    public String channel;
    public boolean disableStat;
    public boolean enableLog;
    public String gaId;
    public boolean isForSdk = false;
    public ArrayList<String> needUploadPackageNameList = null;
    public boolean openBlockCanary;
    public boolean selfStat;
    public boolean serverCn = false;
    public boolean serverIndia = false;
    public boolean serverRussia = false;
    public boolean test;
    public int uploadInteval = 0;
    public int uploadPolicy = 0;
    public String userId;
    public String versionSpan;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public MiStatOptions f5062O000000o = new MiStatOptions();
    }
}
