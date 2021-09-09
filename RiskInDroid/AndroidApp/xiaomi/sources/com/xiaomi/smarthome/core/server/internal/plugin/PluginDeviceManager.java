package com.xiaomi.smarthome.core.server.internal.plugin;

import _m_j.ba;
import _m_j.fcn;
import _m_j.fcx;
import _m_j.fde;
import _m_j.fdg;
import _m_j.fdh;
import _m_j.fdt;
import _m_j.fju;
import _m_j.fkn;
import _m_j.fko;
import _m_j.fkp;
import _m_j.fks;
import _m_j.fkw;
import _m_j.fkx;
import _m_j.fky;
import _m_j.flk;
import _m_j.gow;
import _m_j.grr;
import _m_j.gsy;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public enum PluginDeviceManager {
    instance;
    
    public static final Integer STATE_CACHE_ASSET = 1;
    private static final Integer STATE_CACHE_PARCEL = 2;
    public static final Integer STATE_REQUEST_LANGUAGE = 1;
    public static final Integer STATE__REQUEST_UPDATE = 2;
    public boolean hasLoadDevice = false;
    private final Context mAppContext = CommonApplication.getAppContext();
    private String mAppFilesDir;
    private long mDeveloperInfoLastModify = 0;
    private final Map<Long, String> mDeveloperInfoMap = Collections.synchronizedMap(new HashMap(1024));
    private long mDeviceInfoLastModify = 0;
    public final Map<String, PluginDeviceInfo> mDeviceInfoMap = Collections.synchronizedMap(new HashMap(4192));
    private final Map<String, PluginDeviceInfo> mExtraDeviceInfoMap = Collections.synchronizedMap(new HashMap());
    private boolean mHasInited = false;
    public String mLastCheckTime;
    public int mUpdateState = 0;

    public final void init() {
    }

    private String getAppFilesDir() {
        if (TextUtils.isEmpty(this.mAppFilesDir)) {
            this.mAppFilesDir = fkw.O000000o(this.mAppContext) + File.separator + "PluginDeviceManager";
            new File(this.mAppFilesDir).mkdirs();
        }
        return this.mAppFilesDir;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:60|61|62|63|64|65|66) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x01bf */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0117 A[Catch:{ Exception -> 0x0215 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0125 A[Catch:{ Exception -> 0x0215 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x015a A[Catch:{ Exception -> 0x0215 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0160 A[Catch:{ Exception -> 0x0215 }] */
    private void initPluginConfigFromLocal(final ba<Integer> baVar) {
        int i;
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        if (!this.mHasInited || this.mDeviceInfoMap.isEmpty() || this.mDeveloperInfoMap.isEmpty()) {
            try {
                ServerBean O00000o = fju.O000000o().O00000o();
                Locale O0000O0o = fju.O000000o().O0000O0o();
                if (O0000O0o == null) {
                    O0000O0o = flk.O00000Oo();
                }
                if (O0000O0o != null) {
                    if (O00000o != null) {
                        String[] list = this.mAppContext.getAssets().list("device_config");
                        if (list == null) {
                            writeLog("PluginManager.initPluginConfigFromLocal cache deviceConfigs = null");
                            baVar.accept(0);
                            return;
                        }
                        int length = list.length;
                        int i2 = 0;
                        while (true) {
                            i = 1;
                            if (i2 >= length) {
                                str = null;
                                break;
                            }
                            String str2 = list[i2];
                            if (str2 != null) {
                                if (str2.startsWith("plugin_config_" + O00000o.f7546O000000o)) {
                                    str = fkw.O000000o(this.mAppContext, "device_config" + File.separator + str2);
                                    if (str2.split("-")[1].equals((O0000O0o.getLanguage() + "_" + O0000O0o.getCountry()).toLowerCase(Locale.ENGLISH)) || str2.equals(O0000O0o.getLanguage().toLowerCase(Locale.ENGLISH))) {
                                        z = true;
                                    }
                                }
                            }
                            i2++;
                        }
                        z = false;
                        if (TextUtils.isEmpty(str)) {
                            writeLog("PluginManager.initPluginConfigFromLocal cache no content empty deviceConfigs:" + Arrays.toString(list));
                            baVar.accept(0);
                            return;
                        }
                        JSONObject optJSONObject = new JSONObject(str).optJSONObject("result");
                        if (!this.mDeviceInfoMap.isEmpty()) {
                            if (this.mHasInited) {
                                z2 = false;
                                if (!this.mDeveloperInfoMap.isEmpty()) {
                                    if (this.mHasInited) {
                                        z3 = false;
                                        fks O000000o2 = fks.O000000o(optJSONObject, z2, z3);
                                        if (z) {
                                            i = 3;
                                        }
                                        parseConfigInfo(O000000o2, i, null);
                                        this.mLastCheckTime = null;
                                        writeLog("PluginManager.initPluginConfigFromLocal cache assets mDeviceInfoMap:" + this.mDeviceInfoMap.size() + " mDeveloperInfoMap:" + this.mDeveloperInfoMap.size() + " matchLanguage:" + z);
                                        if (z) {
                                            baVar.accept(STATE_CACHE_ASSET);
                                            return;
                                        }
                                        this.mUpdateState |= STATE_REQUEST_LANGUAGE.intValue();
                                        fko O000000o3 = fko.O000000o();
                                        grr.O000000o();
                                        int O00000o0 = grr.O00000o0(this.mAppContext);
                                        grr.O000000o();
                                        String O0000o0O = grr.O0000o0O();
                                        AnonymousClass1 r4 = new fde<HashMap<String, fkp>, fdg>() {
                                            /* class com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager.AnonymousClass1 */

                                            public final /* synthetic */ void onSuccess(Object obj) {
                                                HashMap hashMap = (HashMap) obj;
                                                if ((PluginDeviceManager.this.mUpdateState & PluginDeviceManager.STATE_REQUEST_LANGUAGE.intValue()) == 0) {
                                                    onFailure(new fdg(-1, "error updateState:" + PluginDeviceManager.this.mUpdateState));
                                                } else if (hashMap.size() >= PluginDeviceManager.this.mDeviceInfoMap.size()) {
                                                    for (Map.Entry next : PluginDeviceManager.this.mDeviceInfoMap.entrySet()) {
                                                        fkp fkp = (fkp) hashMap.get(next.getKey());
                                                        if (fkp == null) {
                                                            onFailure(new fdg(-1, "deviceInfo = null model:" + ((String) next.getKey())));
                                                            return;
                                                        }
                                                        fky.O000000o(fkp, 2, (PluginDeviceInfo) next.getValue());
                                                    }
                                                    PluginDeviceManager pluginDeviceManager = PluginDeviceManager.this;
                                                    pluginDeviceManager.saveDeviceInfoPrefInternal(pluginDeviceManager.mDeviceInfoMap);
                                                    PluginDeviceManager.this.mUpdateState &= PluginDeviceManager.STATE__REQUEST_UPDATE.intValue();
                                                    PluginDeviceManager.this.writeLog("PluginManager.initPluginConfigFromLocal getLanguageConfig onSuccess");
                                                    baVar.accept(PluginDeviceManager.STATE_CACHE_ASSET);
                                                } else {
                                                    onFailure(new fdg(-1, "size different language:" + hashMap.size() + " deviceInfo:" + PluginDeviceManager.this.mDeviceInfoMap.size()));
                                                }
                                            }

                                            public final void onFailure(fdg fdg) {
                                                PluginDeviceManager.this.writeLog("PluginManager.initPluginConfigFromLocal getLanguageConfig fail error:".concat(String.valueOf(fdg)));
                                                PluginDeviceManager.this.clearDeveloperInfoInternal();
                                                PluginDeviceManager.this.clearDeviceInfoInternal();
                                                PluginDeviceManager.this.mUpdateState &= PluginDeviceManager.STATE__REQUEST_UPDATE.intValue();
                                                baVar.accept(0);
                                            }
                                        };
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("models", new JSONArray());
                                        jSONObject.put("keys", new JSONArray().put("cate_name").put("desc").put("name").put("icon_bluetooth_pairing"));
                                        jSONObject.put("app_version", O00000o0);
                                        jSONObject.put("app_platform", O0000o0O);
                                        fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/productconfig/single_pull").O000000o(Collections.singletonList(new KeyValuePair("data", jSONObject.toString()))).O000000o(), new fdh<NetResult, NetError>(r4) {
                                            /* class _m_j.fko.AnonymousClass2 */

                                            /* renamed from: O000000o  reason: collision with root package name */
                                            final /* synthetic */ fde f16541O000000o;

                                            {
                                                this.f16541O000000o = r2;
                                            }

                                            public final /* synthetic */ void onFailure(Error error) {
                                                NetError netError = (NetError) error;
                                                this.f16541O000000o.sendFailureMessage(new fdg(netError.f6718O000000o, netError.O00000Oo));
                                            }

                                            public final /* synthetic */ void onSuccess(Object obj) {
                                                fdw.O000000o().O000000o((NetResult) obj, $$Lambda$fko$2$JNDxW_80d4Q81XC1riwEnhWPW_Q.INSTANCE, this.f16541O000000o);
                                            }
                                        });
                                        return;
                                    }
                                }
                                z3 = true;
                                fks O000000o22 = fks.O000000o(optJSONObject, z2, z3);
                                if (z) {
                                }
                                parseConfigInfo(O000000o22, i, null);
                                this.mLastCheckTime = null;
                                writeLog("PluginManager.initPluginConfigFromLocal cache assets mDeviceInfoMap:" + this.mDeviceInfoMap.size() + " mDeveloperInfoMap:" + this.mDeveloperInfoMap.size() + " matchLanguage:" + z);
                                if (z) {
                                }
                            }
                        }
                        z2 = true;
                        if (!this.mDeveloperInfoMap.isEmpty()) {
                        }
                        z3 = true;
                        fks O000000o222 = fks.O000000o(optJSONObject, z2, z3);
                        if (z) {
                        }
                        parseConfigInfo(O000000o222, i, null);
                        this.mLastCheckTime = null;
                        writeLog("PluginManager.initPluginConfigFromLocal cache assets mDeviceInfoMap:" + this.mDeviceInfoMap.size() + " mDeveloperInfoMap:" + this.mDeveloperInfoMap.size() + " matchLanguage:" + z);
                        if (z) {
                        }
                    }
                }
                writeLog("PluginManager.initPluginConfigFromLocal return locale:" + O0000O0o + " server:" + O00000o);
                baVar.accept(0);
            } catch (Exception unused) {
                baVar.accept(0);
            }
        } else {
            baVar.accept(STATE_CACHE_PARCEL);
        }
    }

    private void initMiuiModelInfo() {
        Parcel O000000o2;
        byte[] O000000o3 = fkw.O000000o(new File(CommonApplication.getAppContext().getFilesDir(), "miui_cache_plugin_device_info"));
        if (O000000o3 != null && (O000000o2 = fkw.O000000o(O000000o3)) != null) {
            try {
                ArrayList readArrayList = O000000o2.readArrayList(PluginDeviceInfo.class.getClassLoader());
                if (readArrayList != null && readArrayList.size() > 0) {
                    Iterator it = readArrayList.iterator();
                    while (it.hasNext()) {
                        PluginDeviceInfo pluginDeviceInfo = (PluginDeviceInfo) it.next();
                        if (pluginDeviceInfo != null && !TextUtils.isEmpty(pluginDeviceInfo.O00000Oo())) {
                            this.mDeviceInfoMap.put(pluginDeviceInfo.O00000Oo(), pluginDeviceInfo);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            } finally {
                O000000o2.recycle();
            }
        }
    }

    public final void saveMiuiModelInfo(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (String str : list) {
                PluginDeviceInfo pluginDeviceInfo = this.mDeviceInfoMap.get(str);
                if (pluginDeviceInfo != null) {
                    arrayList.add(pluginDeviceInfo);
                }
            }
        }
        File file = new File(CommonApplication.getAppContext().getFilesDir(), "miui_cache_plugin_device_info");
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeList(arrayList);
            fkw.O000000o(file, obtain.marshall());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            obtain.recycle();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        return;
     */
    public final synchronized void updateConfig(boolean z, fkn fkn) {
        String O00000Oo = fcn.O000000o().O00000Oo();
        if (this.mUpdateState == 0 && !TextUtils.isEmpty(O00000Oo)) {
            if (!"0".equals(O00000Oo)) {
                readDeviceBasefInternal();
                readDeveloperInfoPrefInternal();
                initPluginConfigFromLocal(new ba(z, fkn) {
                    /* class com.xiaomi.smarthome.core.server.internal.plugin.$$Lambda$PluginDeviceManager$XWYFUK0xNZ6uS53VTaeV5WmQ */
                    private final /* synthetic */ boolean f$1;
                    private final /* synthetic */ fkn f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void accept(Object obj) {
                        PluginDeviceManager.this.lambda$updateConfig$0$PluginDeviceManager(this.f$1, this.f$2, (Integer) obj);
                    }
                });
                this.mHasInited = true;
                return;
            }
        }
        writeLog("updatePluginConfigInternal perpare login or language updating:" + this.mUpdateState + " miId:" + O00000Oo);
        if (fkn != null) {
            fkn.O000000o(new fdg(-1, "perpare login or language"));
        }
    }

    public final void parseConfigInfo(fks fks, int i, fkn fkn) {
        boolean z;
        if (fks == null) {
            if (fkn != null) {
                fkn.O000000o(new fdg(-1, "result is null"));
            }
            writeLog("parseConfigInfo result is null");
            return;
        }
        boolean z2 = false;
        if (fks.f16551O000000o == null || fks.f16551O000000o.O00000o0 == null || fks.f16551O000000o.O00000o0.size() == 0) {
            z = false;
        } else {
            if (fks.f16551O000000o == null ? true : "full".equalsIgnoreCase(fks.f16551O000000o.f16550O000000o)) {
                clearDeviceInfoInternal();
            }
            double size = (double) fks.f16551O000000o.O00000o0.size();
            Double.isNaN(size);
            HashMap hashMap = new HashMap((int) (size / 0.75d));
            for (Map.Entry<String, fkp> value : fks.f16551O000000o.O00000o0.entrySet()) {
                fkp fkp = (fkp) value.getValue();
                PluginDeviceInfo pluginDeviceInfo = this.mDeviceInfoMap.get(fkp.f16547O000000o);
                if (pluginDeviceInfo == null) {
                    String str = fkp.f16547O000000o;
                    PluginDeviceInfo pluginDeviceInfo2 = new PluginDeviceInfo();
                    hashMap.put(str, pluginDeviceInfo2);
                    pluginDeviceInfo = pluginDeviceInfo2;
                } else {
                    hashMap.put(fkp.f16547O000000o, pluginDeviceInfo);
                }
                fky.O000000o(fkp, i, pluginDeviceInfo);
            }
            addDeviceInfoInternal(hashMap, fks.f16551O000000o.O00000Oo);
            if (i == 3) {
                saveDeviceInfoPrefInternal(hashMap);
            }
            z = true;
        }
        if (!(fks.O00000Oo == null || fks.O00000Oo.O00000o0 == null || fks.O00000Oo.O00000o0.size() == 0)) {
            if (fks.O00000Oo == null ? true : "full".equalsIgnoreCase(fks.O00000Oo.f16549O000000o)) {
                clearDeveloperInfoInternal();
            }
            double size2 = (double) fks.O00000Oo.O00000o0.size();
            Double.isNaN(size2);
            HashMap hashMap2 = new HashMap((int) (size2 / 0.75d));
            for (Map.Entry next : fks.O00000Oo.O00000o0.entrySet()) {
                hashMap2.put(next.getKey(), next.getValue());
            }
            addDeveloperInfoInternal(hashMap2, fks.O00000Oo.O00000Oo);
            saveDeveloperInfoPrefInternal(hashMap2);
            z2 = true;
        }
        writeLog("parseConfigInfo mDeviceInfoMap:" + this.mDeviceInfoMap.size() + " mDeveloperInfoMap:" + this.mDeveloperInfoMap.size() + " deviceLastModify:" + this.mDeviceInfoLastModify + " developerLastModify:" + this.mDeveloperInfoLastModify + " parseLanguage:" + i);
        onPluginChanged(z, z2);
        if (fkn != null) {
            fkn.O000000o(z, z2);
        }
    }

    private void addDeviceInfoInternal(Map<String, PluginDeviceInfo> map, long j) {
        this.mDeviceInfoMap.putAll(map);
        this.mDeviceInfoLastModify = j;
    }

    public final void clearDeviceInfoInternal() {
        this.mDeviceInfoMap.clear();
        this.mDeviceInfoLastModify = 0;
        this.mUpdateState = 0;
        writeLog("clearDeviceInfoInternal");
    }

    public final boolean saveDeviceInfoPrefInternal(Map<String, PluginDeviceInfo> map) {
        PluginDeviceManager pluginDeviceManager = this;
        long currentTimeMillis = System.currentTimeMillis();
        Parcel obtain = Parcel.obtain();
        File configFile = pluginDeviceManager.getConfigFile(true, "_pdb_x0kk6w");
        int size = pluginDeviceManager.mDeviceInfoMap.size();
        SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(pluginDeviceManager.getConfigFile(true, "_pdo_x0kk6w"), (SQLiteDatabase.CursorFactory) null);
        openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS OtherConfig (a TEXT PRIMARY KEY , b TEXT, c TEXT,d TEXT, e TEXT, f TEXT);");
        openOrCreateDatabase.beginTransaction();
        try {
            obtain.writeInt(size);
            for (Map.Entry next : pluginDeviceManager.mDeviceInfoMap.entrySet()) {
                try {
                    PluginDeviceInfo pluginDeviceInfo = (PluginDeviceInfo) next.getValue();
                    obtain.writeString(pluginDeviceInfo.f6737O000000o);
                    obtain.writeInt(pluginDeviceInfo.O00000Oo);
                    obtain.writeInt(pluginDeviceInfo.O00000o0);
                    obtain.writeString(pluginDeviceInfo.O00000oo);
                    obtain.writeInt(pluginDeviceInfo.O0000O0o);
                    obtain.writeInt(pluginDeviceInfo.O0000OOo);
                    obtain.writeInt(pluginDeviceInfo.O0000Oo);
                    obtain.writeInt(pluginDeviceInfo.O0000OoO);
                    obtain.writeInt(pluginDeviceInfo.O0000Ooo);
                    obtain.writeInt(pluginDeviceInfo.O0000o00);
                    obtain.writeInt(pluginDeviceInfo.O0000o0);
                    obtain.writeInt(pluginDeviceInfo.O0000o0O);
                    obtain.writeInt(pluginDeviceInfo.O0000o0o);
                    obtain.writeInt(pluginDeviceInfo.O0000o);
                    obtain.writeInt(pluginDeviceInfo.O0000ooo);
                    obtain.writeInt(pluginDeviceInfo.O00oOooO);
                    fkx.O000000o(obtain, pluginDeviceInfo.O00oOooo);
                    obtain.writeInt(pluginDeviceInfo.O0000oO0);
                    obtain.writeInt(pluginDeviceInfo.O0000oO);
                    fkx.O000000o(obtain, pluginDeviceInfo.O000O00o);
                    obtain.writeByte((byte) (pluginDeviceInfo.O000O0OO ? 1 : 0));
                    obtain.writeInt(pluginDeviceInfo.O0000oo0);
                    fkx.O00000Oo(obtain, pluginDeviceInfo.O000O0Oo);
                    obtain.writeInt(pluginDeviceInfo.O00oOoOo);
                    obtain.writeInt(pluginDeviceInfo.O000O0o0);
                    obtain.writeInt(pluginDeviceInfo.O0000oOO);
                    obtain.writeByte(pluginDeviceInfo.O0000oOo);
                    obtain.writeInt(pluginDeviceInfo.O000O0o);
                    obtain.writeString(pluginDeviceInfo.O00000o);
                    obtain.writeString(pluginDeviceInfo.O00000oO);
                    obtain.writeString(pluginDeviceInfo.O0000Oo0);
                    obtain.writeLong(pluginDeviceInfo.O0000oo);
                    fkx.O000000o(obtain, pluginDeviceInfo.O0000ooO);
                    if (map.get(next.getKey()) != null) {
                        openOrCreateDatabase.execSQL("INSERT OR REPLACE INTO OtherConfig ( a, b, c, d,e, f ) VALUES (?,?,?,?,?,?);", new String[]{pluginDeviceInfo.O00000Oo(), pluginDeviceInfo.O0000o0o(), pluginDeviceInfo.O0000Oo(), pluginDeviceInfo.O0000OoO(), pluginDeviceInfo.O0000Ooo(), pluginDeviceInfo.O0000o00()});
                    }
                    pluginDeviceManager = this;
                } catch (Throwable th) {
                    th = th;
                    pluginDeviceManager = this;
                    obtain.recycle();
                    openOrCreateDatabase.endTransaction();
                    openOrCreateDatabase.close();
                    pluginDeviceManager.writeLog("saveDeviceInfoPrefInternal size:" + size + " file:" + configFile + " time:" + (System.currentTimeMillis() - currentTimeMillis));
                    throw th;
                }
            }
            obtain.writeLong(pluginDeviceManager.mDeviceInfoLastModify);
            obtain.writeString(pluginDeviceManager.mLastCheckTime);
            byte[] marshall = obtain.marshall();
            openOrCreateDatabase.setTransactionSuccessful();
            boolean O000000o2 = fkw.O000000o(configFile, marshall);
            obtain.recycle();
            openOrCreateDatabase.endTransaction();
            openOrCreateDatabase.close();
            pluginDeviceManager.writeLog("saveDeviceInfoPrefInternal size:" + size + " file:" + configFile + " time:" + (System.currentTimeMillis() - currentTimeMillis));
            return O000000o2;
        } catch (Throwable th2) {
            th = th2;
            obtain.recycle();
            openOrCreateDatabase.endTransaction();
            openOrCreateDatabase.close();
            pluginDeviceManager.writeLog("saveDeviceInfoPrefInternal size:" + size + " file:" + configFile + " time:" + (System.currentTimeMillis() - currentTimeMillis));
            throw th;
        }
    }

    private void readDeviceBasefInternal() {
        if (!this.mHasInited || this.mDeviceInfoMap.isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis();
            File configFile = getConfigFile(true, "_pdo_x0kk6w");
            if (!configFile.exists()) {
                writeLog("readDeviceInfoPrefInternal not exit ".concat(String.valueOf(configFile)));
                return;
            }
            File configFile2 = getConfigFile(true, "_pdb_x0kk6w");
            if (!configFile2.exists()) {
                writeLog("readDeviceInfoPrefInternal not exit ".concat(String.valueOf(configFile2)));
                return;
            }
            byte[] O000000o2 = fkw.O000000o(configFile2);
            if (O000000o2 != null) {
                Parcel O000000o3 = fkw.O000000o(O000000o2);
                if (O000000o3 != null) {
                    try {
                        int readInt = O000000o3.readInt();
                        double d = (double) readInt;
                        Double.isNaN(d);
                        HashMap hashMap = new HashMap((int) (d / 0.75d));
                        for (int i = 0; i < readInt; i++) {
                            PluginDeviceInfo pluginDeviceInfo = new PluginDeviceInfo();
                            pluginDeviceInfo.f6737O000000o = O000000o3.readString();
                            pluginDeviceInfo.O00000Oo = O000000o3.readInt();
                            pluginDeviceInfo.O00000o0 = O000000o3.readInt();
                            pluginDeviceInfo.O00000oo = O000000o3.readString();
                            pluginDeviceInfo.O0000O0o = O000000o3.readInt();
                            pluginDeviceInfo.O0000OOo = O000000o3.readInt();
                            pluginDeviceInfo.O0000Oo = O000000o3.readInt();
                            pluginDeviceInfo.O0000OoO = O000000o3.readInt();
                            pluginDeviceInfo.O0000Ooo = O000000o3.readInt();
                            pluginDeviceInfo.O0000o00 = O000000o3.readInt();
                            pluginDeviceInfo.O0000o0 = O000000o3.readInt();
                            pluginDeviceInfo.O0000o0O = O000000o3.readInt();
                            pluginDeviceInfo.O0000o0o = O000000o3.readInt();
                            pluginDeviceInfo.O0000o = O000000o3.readInt();
                            pluginDeviceInfo.O0000ooo = O000000o3.readInt();
                            pluginDeviceInfo.O00oOooO = O000000o3.readInt();
                            pluginDeviceInfo.O00oOooo = fkx.O000000o(O000000o3);
                            pluginDeviceInfo.O0000oO0 = O000000o3.readInt();
                            pluginDeviceInfo.O0000oO = O000000o3.readInt();
                            pluginDeviceInfo.O000O00o = fkx.O000000o(O000000o3);
                            pluginDeviceInfo.O000O0OO = O000000o3.readInt() != 0;
                            pluginDeviceInfo.O0000oo0 = O000000o3.readInt();
                            pluginDeviceInfo.O000O0Oo = fkx.O00000Oo(O000000o3);
                            pluginDeviceInfo.O00oOoOo = O000000o3.readInt();
                            pluginDeviceInfo.O000O0o0 = O000000o3.readInt();
                            pluginDeviceInfo.O0000oOO = O000000o3.readInt();
                            pluginDeviceInfo.O0000oOo = O000000o3.readByte();
                            pluginDeviceInfo.O000O0o = O000000o3.readInt();
                            pluginDeviceInfo.O00000o = O000000o3.readString();
                            pluginDeviceInfo.O00000oO = O000000o3.readString();
                            pluginDeviceInfo.O0000Oo0 = O000000o3.readString();
                            pluginDeviceInfo.O0000oo = O000000o3.readLong();
                            pluginDeviceInfo.O0000ooO = fkx.O000000o(O000000o3);
                            hashMap.put(pluginDeviceInfo.O00000Oo(), pluginDeviceInfo);
                        }
                        addDeviceInfoInternal(hashMap, O000000o3.readLong());
                        if (this.mDeviceInfoLastModify > this.mDeveloperInfoLastModify) {
                            this.mLastCheckTime = O000000o3.readString();
                        }
                        onPluginChanged(true, false);
                        writeLog("readDeviceInfoPrefInternal mDeviceInfoMap.size:" + this.mDeviceInfoMap.size() + " mDeviceInfoLastModify:" + this.mDeviceInfoLastModify + " file:" + configFile2 + " time:" + (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    } catch (Throwable th) {
                        writeLog("error readDeviceInfoPrefInternal parcel " + Log.getStackTraceString(th));
                    } finally {
                        O000000o3.recycle();
                    }
                } else {
                    writeLog("error readDeviceInfoPrefInternal parcel.unmarshall error");
                }
            } else {
                writeLog("error readDeviceInfoPrefInternal md5 notmatch");
            }
            fkw.O00000o0(configFile2);
            clearDeviceInfoInternal();
        }
    }

    public final void readDeviceOtherfInternal(String str) {
        SQLiteDatabase sQLiteDatabase;
        long currentTimeMillis = System.currentTimeMillis();
        File configFile = getConfigFile(true, "_pdo_x0kk6w");
        if (!configFile.exists()) {
            writeLog("error readDeviceOtherfInternal not exists " + configFile + " model:" + str);
            return;
        }
        try {
            sQLiteDatabase = SQLiteDatabase.openDatabase(configFile.getPath(), null, 1);
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT   b, c, d, e, f FROM OtherConfig WHERE a='" + str + "';", null);
                PluginDeviceInfo pluginDeviceInfo = this.mDeviceInfoMap.get(str);
                if (!(pluginDeviceInfo == null || rawQuery == null)) {
                    if (rawQuery.moveToFirst()) {
                        pluginDeviceInfo.O0000Oo0(rawQuery.getString(0));
                        pluginDeviceInfo.O00000o0(rawQuery.getString(1));
                        pluginDeviceInfo.O00000o(rawQuery.getString(2));
                        pluginDeviceInfo.O00000oO(rawQuery.getString(3));
                        pluginDeviceInfo.O00000oo(rawQuery.getString(4));
                        writeLog("readDeviceOtherfInternal pluginDeviceInfo success model:" + pluginDeviceInfo.O000O0o0() + " time:" + (System.currentTimeMillis() - currentTimeMillis));
                        gow.O00000Oo(rawQuery, sQLiteDatabase);
                    }
                }
                fkw.O00000o0(configFile);
                writeLog("error readDeviceOtherfInternal no pluginDeviceInfo:" + pluginDeviceInfo + " or cursor:" + rawQuery + " model:" + str);
                gow.O00000Oo(rawQuery, sQLiteDatabase);
            } catch (Exception e) {
                e = e;
                try {
                    writeLog("error readDeviceOtherfInternal Exception:" + Log.getStackTraceString(e));
                    gow.O00000Oo(null, sQLiteDatabase);
                } catch (Throwable th) {
                    th = th;
                    gow.O00000Oo(null, sQLiteDatabase);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            sQLiteDatabase = null;
            writeLog("error readDeviceOtherfInternal Exception:" + Log.getStackTraceString(e));
            gow.O00000Oo(null, sQLiteDatabase);
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
            gow.O00000Oo(null, sQLiteDatabase);
            throw th;
        }
    }

    private void addDeveloperInfoInternal(Map<Long, String> map, long j) {
        this.mDeveloperInfoMap.putAll(map);
        this.mDeveloperInfoLastModify = j;
    }

    public final void clearDeveloperInfoInternal() {
        this.mDeveloperInfoMap.clear();
        this.mDeveloperInfoLastModify = 0;
        this.mUpdateState = 0;
        writeLog("clearDeveloperInfoInternal");
    }

    private boolean saveDeveloperInfoPrefInternal(Map<Long, String> map) {
        long currentTimeMillis = System.currentTimeMillis();
        File configFile = getConfigFile(false, "_dlp_xwxz3n");
        Parcel obtain = Parcel.obtain();
        int size = this.mDeveloperInfoMap.size();
        try {
            obtain.writeInt(size);
            for (Map.Entry next : this.mDeveloperInfoMap.entrySet()) {
                obtain.writeLong(((Long) next.getKey()).longValue());
                obtain.writeString((String) next.getValue());
            }
            obtain.writeLong(this.mDeveloperInfoLastModify);
            obtain.writeString(this.mLastCheckTime);
            return fkw.O000000o(configFile, obtain.marshall());
        } finally {
            obtain.recycle();
            writeLog("saveDeveloperInfoPrefInternal size:" + size + " file:" + configFile + " time:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private void readDeveloperInfoPrefInternal() {
        if (!this.mHasInited || this.mDeveloperInfoMap.isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis();
            File configFile = getConfigFile(false, "_dlp_xwxz3n");
            if (!configFile.exists()) {
                writeLog("readDeveloperInfoPrefInternal not exit ".concat(String.valueOf(configFile)));
                return;
            }
            byte[] O000000o2 = fkw.O000000o(configFile);
            if (O000000o2 != null) {
                Parcel O000000o3 = fkw.O000000o(O000000o2);
                if (O000000o3 != null) {
                    try {
                        int readInt = O000000o3.readInt();
                        double d = (double) readInt;
                        Double.isNaN(d);
                        HashMap hashMap = new HashMap((int) (d / 0.75d));
                        for (int i = 0; i < readInt; i++) {
                            hashMap.put(Long.valueOf(O000000o3.readLong()), O000000o3.readString());
                        }
                        addDeveloperInfoInternal(hashMap, O000000o3.readLong());
                        if (this.mDeveloperInfoLastModify > this.mDeviceInfoLastModify) {
                            this.mLastCheckTime = O000000o3.readString();
                        }
                        onPluginChanged(false, true);
                        writeLog("readDeveloperInfoPrefInternal mDeveloperInfoMap.size:" + this.mDeveloperInfoMap.size() + " mDeveloperInfoLastModify:" + this.mDeveloperInfoLastModify + " file:" + configFile + " time:" + (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    } catch (Throwable th) {
                        writeLog("error readDeveloperInfoPrefInternal parcel " + Log.getStackTraceString(th));
                    } finally {
                        O000000o3.recycle();
                    }
                } else {
                    writeLog("error readDeveloperInfoPrefInternal parcel.unmarshall error");
                }
            } else {
                writeLog("error readDeveloperInfoPrefInternal md5 notmatch");
            }
            fkw.O00000o0(configFile);
            clearDeveloperInfoInternal();
        }
    }

    private File getConfigFile(boolean z, String str) {
        ServerBean O00000o = fju.O000000o().O00000o();
        String O00000Oo = fcn.O000000o().O00000Oo();
        if (O00000o == null) {
            writeLog("error getPluginDeviceFile server == null");
            String appFilesDir = getAppFilesDir();
            return new File(appFilesDir, O00000Oo + str);
        } else if (z) {
            Locale O0000O0o = fju.O000000o().O0000O0o();
            if (O0000O0o == null) {
                O0000O0o = flk.O00000Oo();
            }
            if (O0000O0o == null) {
                writeLog("error getPluginDeviceFile locale = null");
                String appFilesDir2 = getAppFilesDir();
                return new File(appFilesDir2, O00000Oo + str);
            }
            String appFilesDir3 = getAppFilesDir();
            return new File(appFilesDir3, O00000Oo + O00000o.f7546O000000o + "_" + O0000O0o.getLanguage() + "_" + O0000O0o.getCountry() + str);
        } else {
            String appFilesDir4 = getAppFilesDir();
            return new File(appFilesDir4, O00000Oo + O00000o.f7546O000000o + str);
        }
    }

    public final void clearConfig() {
        this.mLastCheckTime = null;
        clearDeviceInfoInternal();
        clearDeveloperInfoInternal();
    }

    public final PluginDeviceInfo getPluginInfo(String str) {
        return this.mDeviceInfoMap.get(str);
    }

    public final PluginDeviceInfo getExtraPluginInfo(String str) {
        initExtraDeviceInfoMap(this.mExtraDeviceInfoMap);
        return this.mExtraDeviceInfoMap.get(str);
    }

    private static void initExtraDeviceInfoMap(Map<String, PluginDeviceInfo> map) {
        if (map.isEmpty()) {
            PluginDeviceInfo pluginDeviceInfo = new PluginDeviceInfo();
            pluginDeviceInfo.O000000o("yeelink.uwb.tag1");
            pluginDeviceInfo.O000000o(5662);
            pluginDeviceInfo.O00000Oo(0);
            pluginDeviceInfo.O000000o(false);
            pluginDeviceInfo.O0000O0o("https://cnbj1.fds.api.xiaomi.com/iotweb-product-center/28c8409c6a076becfb24461f8da7f7ae_1620632902445.png?GalaxyAccessKeyId=AKVGLQWBOVIRQ3XLEW&Expires=9223372036854775807&Signature=VNDnxNTSGHhDo6Gzlr+hCPttXVk=");
            map.put(pluginDeviceInfo.O00000Oo(), pluginDeviceInfo);
        }
    }

    public final Map<String, PluginDeviceInfo> getPluginInfoMap() {
        return this.mDeviceInfoMap;
    }

    public final String getModelByProductId(int i) {
        String O000000o2 = fky.O000000o(i, this.mDeviceInfoMap);
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = fky.O000000o(i, this.mExtraDeviceInfoMap);
        }
        if (TextUtils.isEmpty(O000000o2)) {
            writeLog("getModelByProductId model =null productId:" + i + " size:" + this.mDeviceInfoMap.size());
        }
        return O000000o2;
    }

    public final int getProductIdByModel(String str) {
        return fky.O000000o(str, this.mDeviceInfoMap);
    }

    public final String getModelBySSID(String str) {
        for (Map.Entry next : this.mDeviceInfoMap.entrySet()) {
            String O0000o0O = ((PluginDeviceInfo) next.getValue()).O0000o0O();
            if (!TextUtils.isEmpty(O0000o0O) && Pattern.compile(O0000o0O).matcher(str).matches()) {
                return (String) next.getKey();
            }
        }
        return null;
    }

    public final void dumpPlugin() {
        gsy.O000000o(3, "PluginDeviceManager", "-----------------------------dumpPlugin PluginDeviceInfo--------------------------");
        for (Map.Entry<String, PluginDeviceInfo> value : this.mDeviceInfoMap.entrySet()) {
            gsy.O000000o(3, "PluginDeviceManager", ((PluginDeviceInfo) value.getValue()).O000O0o0());
        }
    }

    public final String getDeveloperInfo(long j) {
        return this.mDeveloperInfoMap.get(Long.valueOf(j));
    }

    public final void writeLog(String str) {
        gsy.O00000o0(LogType.PLUGIN, "PluginManager", "PluginDeviceManager", str);
    }

    private void onPluginChanged(boolean z, boolean z2) {
        fcx.f16092O000000o.O000000o(z, z2, (String) null);
    }
}
