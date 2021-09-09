package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi;

import _m_j.fzh;
import _m_j.gbj;
import _m_j.gbu;
import _m_j.grs;
import android.text.TextUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.tiqiaa.client.IRemoteClient;
import com.tiqiaa.client.ITvClient;
import com.tiqiaa.client.impl.TvClient;
import com.tiqiaa.icontrol.util.LanguageUtils;
import com.tiqiaa.irdnasdk.IrDnaSdkHelper;
import com.tiqiaa.remote.entity.AirRemoteState;
import com.tiqiaa.remote.entity.Brand;
import com.tiqiaa.remote.entity.Infrared;
import com.tiqiaa.remote.entity.Key;
import com.tiqiaa.remote.entity.MatchPage;
import com.tiqiaa.remote.entity.Page;
import com.tiqiaa.remote.entity.Remote;
import com.tiqiaa.tv.entity.City;
import com.tiqiaa.tv.entity.CityProvider;
import com.tiqiaa.tv.entity.CityProviderRemote;
import com.tiqiaa.tv.entity.Province;
import com.tiqiaa.tv.entity.TvProvider;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class CmTJInfraModule extends ReactContextBaseJavaModule {
    private String mCurrentClient;
    private Map<String, fzh> mInfraredDataProviderMap = new HashMap();

    public String getName() {
        return "TJInfra";
    }

    public CmTJInfraModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("MachineType_TV", 2);
        hashMap.put("MachineType_AirCond", 7);
        hashMap.put("MachineType_Fan", 6);
        hashMap.put("MachineType_Projector", 5);
        hashMap.put("MachineType_STB", 1);
        hashMap.put("MachineType_DVD", 3);
        hashMap.put("MachineType_Camera", 200);
        hashMap.put("MachineType_IRSwitch", 11);
        hashMap.put("MachineType_Amplifier", 201);
        hashMap.put("MachineType_IPTV", 4);
        hashMap.put("MachineType_OTTBox", 10);
        hashMap.put("MachineType_Other", 0);
        hashMap.put("deviceLanguage", "");
        hashMap.put("fetchCurrentLang", Integer.valueOf(LanguageUtils.getLang()));
        return super.getConstants();
    }

    @ReactMethod
    public void createClient(String str) {
        if (this.mInfraredDataProviderMap.get(str) == null) {
            this.mCurrentClient = str;
            this.mInfraredDataProviderMap.put(str, new fzh());
        }
    }

    @ReactMethod
    public void destroyClient(String str) {
        if (this.mInfraredDataProviderMap.get(str) != null) {
            this.mInfraredDataProviderMap.remove(str);
            this.mCurrentClient = null;
        }
    }

    @ReactMethod
    public void exactMatchRemote(String str, String str2, final Callback callback) {
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(str);
            if (fzh == null) {
                callBackBundle(-1, false, "client not found for ".concat(String.valueOf(str)), callback);
                return;
            }
            try {
                MatchPage matchPage = (MatchPage) gbj.O000000o(str2, MatchPage.class);
                AnonymousClass1 r5 = new fzh.O000O00o() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass1 */

                    public final void O000000o(int i, List<Remote> list) {
                        ArrayList arrayList = new ArrayList();
                        if (list != null && list.size() > 0) {
                            for (Remote paraseRemoteToJsRemote : list) {
                                arrayList.add(CmTJInfraModule.this.paraseRemoteToJsRemote(paraseRemoteToJsRemote));
                            }
                        }
                        CmTJInfraModule.this.callBackBundle(i, true, gbj.O000000o(arrayList), callback);
                    }

                    public final void O000000o(int i, String str) {
                        CmTJInfraModule.this.callBackBundle(i, false, str, callback);
                    }
                };
                fzh.O000000o();
                fzh.f17433O000000o.exactMatchReomtes(matchPage, new IRemoteClient.CallbackOnMatchDone(r5) {
                    /* class _m_j.fzh.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ O000O00o f17434O000000o;

                    {
                        this.f17434O000000o = r2;
                    }

                    public final void onMatchDone(int i, List<Remote> list) {
                        if (i == 0) {
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            this.f17434O000000o.O000000o(i, list);
                            return;
                        }
                        this.f17434O000000o.O000000o(i, "exactMatchRemote is error, errcoCode is ".concat(String.valueOf(i)));
                    }
                });
            } catch (Exception e) {
                callBackBundle(-1, false, e.toString(), callback);
            }
        }
    }

    @ReactMethod
    public void exactMatchRemoteIfPower(String str, boolean z, String str2, final Callback callback) {
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(str);
            if (fzh == null) {
                callBackBundle(-1, false, "client not found for".concat(String.valueOf(str)), callback);
                return;
            }
            try {
                MatchPage matchPage = (MatchPage) gbj.O000000o(str2, MatchPage.class);
                AnonymousClass12 r6 = new fzh.O000O00o() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass12 */

                    public final void O000000o(int i, List<Remote> list) {
                        ArrayList arrayList = new ArrayList();
                        if (list != null && list.size() > 0) {
                            for (Remote paraseRemoteToJsRemote : list) {
                                arrayList.add(CmTJInfraModule.this.paraseRemoteToJsRemote(paraseRemoteToJsRemote));
                            }
                        }
                        CmTJInfraModule.this.callBackBundle(i, true, gbj.O000000o(arrayList), callback);
                    }

                    public final void O000000o(int i, String str) {
                        CmTJInfraModule.this.callBackBundle(i, false, str, callback);
                    }
                };
                fzh.O000000o();
                fzh.f17433O000000o.exactMatchReomtes(matchPage, z, new IRemoteClient.CallbackOnMatchDone(r6) {
                    /* class _m_j.fzh.AnonymousClass6 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ O000O00o f17443O000000o;

                    {
                        this.f17443O000000o = r2;
                    }

                    public final void onMatchDone(int i, List<Remote> list) {
                        if (i == 0) {
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            this.f17443O000000o.O000000o(i, list);
                            return;
                        }
                        this.f17443O000000o.O000000o(i, "exactMatchRemoteIfPower is error, errcoCode is ".concat(String.valueOf(i)));
                    }
                });
            } catch (Exception e) {
                callBackBundle(-1, false, e.toString(), callback);
            }
        }
    }

    @ReactMethod
    public void searchDiy(String str, String str2, Callback callback) {
        search(2, str, str2, callback);
    }

    @ReactMethod
    public void searchOfficial(String str, String str2, Callback callback) {
        search(0, str, str2, callback);
    }

    @ReactMethod
    public void searchAirRemote(String str, String str2, Callback callback) {
        search(1, str, str2, callback);
    }

    private void search(int i, String str, String str2, final Callback callback) {
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(str);
            if (fzh == null) {
                callBackBundle(-1, false, "client not found for".concat(String.valueOf(str)), callback);
                return;
            }
            try {
                Page page = (Page) gbj.O000000o(str2, Page.class);
                AnonymousClass13 r6 = new fzh.O000O0o0() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass13 */

                    public final void O000000o(int i, List<Remote> list) {
                        ArrayList arrayList = new ArrayList();
                        if (list != null && list.size() > 0) {
                            for (Remote paraseRemoteToJsRemote : list) {
                                arrayList.add(CmTJInfraModule.this.paraseRemoteToJsRemote(paraseRemoteToJsRemote));
                            }
                        }
                        CmTJInfraModule.this.callBackBundle(i, true, gbj.O000000o(arrayList), callback);
                    }

                    public final void O000000o(int i, String str) {
                        CmTJInfraModule.this.callBackBundle(i, false, str, callback);
                    }
                };
                if (i == 0) {
                    fzh.O000000o();
                    fzh.f17433O000000o.searchOfficial(page, new IRemoteClient.CallbackOnSearchDone(r6) {
                        /* class _m_j.fzh.AnonymousClass7 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ O000O0o0 f17444O000000o;

                        {
                            this.f17444O000000o = r2;
                        }

                        public final void onSearchDone(int i, List<Remote> list) {
                            if (i == 0) {
                                if (list == null) {
                                    list = new ArrayList<>();
                                }
                                this.f17444O000000o.O000000o(i, list);
                                return;
                            }
                            this.f17444O000000o.O000000o(i, "searchOfficial is error, errcoCode is ".concat(String.valueOf(i)));
                        }
                    });
                } else if (i == 2) {
                    fzh.O000000o();
                    fzh.f17433O000000o.searchDiy(page, new IRemoteClient.CallbackOnSearchDone(r6) {
                        /* class _m_j.fzh.AnonymousClass8 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ O000O0o0 f17445O000000o;

                        {
                            this.f17445O000000o = r2;
                        }

                        public final void onSearchDone(int i, List<Remote> list) {
                            if (i == 0) {
                                if (list == null) {
                                    list = new ArrayList<>();
                                }
                                this.f17445O000000o.O000000o(i, list);
                                return;
                            }
                            this.f17445O000000o.O000000o(i, "searchDiy is error, errcoCode is ".concat(String.valueOf(i)));
                        }
                    });
                } else if (i == 1) {
                    fzh.O000000o();
                    fzh.f17433O000000o.searchAirRemote(page, new IRemoteClient.CallbackOnSearchDone(r6) {
                        /* class _m_j.fzh.AnonymousClass9 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ O000O0o0 f17446O000000o;

                        {
                            this.f17446O000000o = r2;
                        }

                        public final void onSearchDone(int i, List<Remote> list) {
                            if (i == 0) {
                                if (list == null) {
                                    list = new ArrayList<>();
                                }
                                this.f17446O000000o.O000000o(i, list);
                                return;
                            }
                            this.f17446O000000o.O000000o(i, "searchAirRemote is error, errcoCode is ".concat(String.valueOf(i)));
                        }
                    });
                }
            } catch (Exception e) {
                callBackBundle(-1, false, e.toString(), callback);
            }
        }
    }

    @ReactMethod
    public void downloadRemote(String str, String str2, final Callback callback) {
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(str);
            if (fzh == null) {
                callBackBundle(-1, false, "client not found for".concat(String.valueOf(str)), callback);
                return;
            }
            AnonymousClass14 r3 = new fzh.O00oOooO() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass14 */

                public final void O000000o(int i, Remote remote) {
                    CmTJInfraModule.this.callBackBundle(i, true, gbj.O000000o(CmTJInfraModule.this.paraseRemoteToJsRemote(remote)), callback);
                }

                public final void O000000o(int i, String str) {
                    CmTJInfraModule.this.callBackBundle(i, false, str, callback);
                }
            };
            fzh.O000000o();
            fzh.f17433O000000o.download_reomte(str2, new IRemoteClient.CallBackOnRemoteDownloaded(r3) {
                /* class _m_j.fzh.AnonymousClass10 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O00oOooO f17435O000000o;

                {
                    this.f17435O000000o = r2;
                }

                public final void onRemoteDownloaded(int i, Remote remote) {
                    if (i == 0) {
                        this.f17435O000000o.O000000o(i, remote);
                    } else {
                        this.f17435O000000o.O000000o(i, "downloadRemote is error, errcoCode is ".concat(String.valueOf(i)));
                    }
                }
            });
        }
    }

    public Remote paraseRemoteToJsRemote(Remote remote) {
        List<Key> keys;
        if (!(remote == null || remote == null || (keys = remote.getKeys()) == null || keys.size() <= 0)) {
            int size = keys.size();
            for (int i = 0; i < size; i++) {
                Key key = keys.get(i);
                if (!(key == null || key.getInfrareds() == null || key.getInfrareds().size() <= 0)) {
                    List<Infrared> infrareds = key.getInfrareds();
                    int size2 = infrareds.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        Infrared infrared = infrareds.get(i2);
                        if (TextUtils.isEmpty(infrared.getData_str())) {
                            infrared.setData_Str(base64Encode(infrared.getData()));
                        }
                        infrared.setData(null);
                    }
                }
            }
        }
        return remote;
    }

    private String base64Encode(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            return grs.O000000o(bArr);
        }
        gbu.O000000o("TJInfra  byte array data is null or length is 0");
        return "";
    }

    @ReactMethod
    public void loadBrands(String str, final Callback callback) {
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(str);
            if (fzh == null) {
                callBackBundle(-1, false, "client not found for".concat(String.valueOf(str)), callback);
                return;
            }
            AnonymousClass15 r4 = new fzh.O000O0OO() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass15 */

                public final void O000000o(int i, List<Brand> list) {
                    CmTJInfraModule.this.callBackBundle(i, true, gbj.O000000o(list), callback);
                }

                public final void O000000o(int i, String str) {
                    CmTJInfraModule.this.callBackBundle(i, false, str, callback);
                }
            };
            fzh.O000000o();
            fzh.f17433O000000o.load_brands(new IRemoteClient.CallbackOnBrandLoaded(r4) {
                /* class _m_j.fzh.AnonymousClass11 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O000O0OO f17436O000000o;

                {
                    this.f17436O000000o = r2;
                }

                public final void onBrandLoaded(int i, List<Brand> list) {
                    if (i == 0) {
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        this.f17436O000000o.O000000o(i, list);
                        return;
                    }
                    this.f17436O000000o.O000000o(i, "loadBrands is error, errcoCode is ".concat(String.valueOf(i)));
                }
            });
        }
    }

    @ReactMethod
    public void autoMatchRemote(String str, String str2, final Callback callback) {
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(str);
            if (fzh == null) {
                callBackBundle(-1, false, "client not found for".concat(String.valueOf(str)), callback);
                return;
            }
            AnonymousClass16 r4 = new fzh.O0000o0() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass16 */

                public final void O000000o(int i, List<Remote> list) {
                    ArrayList arrayList = new ArrayList();
                    if (list != null && list.size() > 0) {
                        for (Remote paraseRemoteToJsRemote : list) {
                            arrayList.add(CmTJInfraModule.this.paraseRemoteToJsRemote(paraseRemoteToJsRemote));
                        }
                    }
                    CmTJInfraModule.this.callBackBundle(i, true, gbj.O000000o(arrayList), callback);
                }

                public final void O000000o(int i, String str) {
                    CmTJInfraModule.this.callBackBundle(i, false, str, callback);
                }
            };
            fzh.O000000o();
            fzh.f17433O000000o.autoMatchRemotes((Page) gbj.O000000o(str2, Page.class), new IRemoteClient.CallbackOnAutoMatchDone(r4) {
                /* class _m_j.fzh.AnonymousClass12 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O0000o0 f17437O000000o;

                {
                    this.f17437O000000o = r2;
                }

                public final void onAutoMatchDone(int i, List<Remote> list) {
                    if (i == 0) {
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        this.f17437O000000o.O000000o(i, list);
                        return;
                    }
                    this.f17437O000000o.O000000o(i, "autoMatchRemote is error, errcoCode is ".concat(String.valueOf(i)));
                }
            });
        }
    }

    @ReactMethod
    public void missModel(String str, int i, long j, String str2) {
        fzh fzh = this.mInfraredDataProviderMap.get(str);
        if (fzh != null) {
            fzh.O000000o();
            fzh.f17433O000000o.miss_model(i, j, str2);
        }
    }

    @ReactMethod
    public void getIRCode(int i, String str, final Callback callback) {
        if (callback != null) {
            if (this.mInfraredDataProviderMap.get(this.mCurrentClient) == null) {
                new fzh();
            }
            AnonymousClass17 r0 = new fzh.O0000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass17 */

                public final void O000000o(String str, String str2) {
                    callback.invoke(Boolean.TRUE, str, str2);
                }

                public final void O000000o(String str) {
                    CmTJInfraModule.this.callBackBundle(-1, false, str, callback);
                }
            };
            byte[] irCode = IrDnaSdkHelper.getIrCode(i, grs.O000000o(str));
            if (irCode == null || irCode.length < 8) {
                r0.O000000o("IrCode result is null or length < 8");
                return;
            }
            byte[] bArr = new byte[8];
            System.arraycopy(irCode, 0, bArr, 0, 8);
            byte[] bArr2 = new byte[(irCode.length - 8)];
            System.arraycopy(irCode, 8, bArr2, 0, irCode.length - 8);
            r0.O000000o(grs.O000000o(bArr), grs.O000000o(bArr2));
        }
    }

    @ReactMethod
    public void buildIRCode(int i, String str, final Callback callback) {
        if (callback != null) {
            if (this.mInfraredDataProviderMap.get(this.mCurrentClient) == null) {
                new fzh();
            }
            AnonymousClass18 r0 = new fzh.O0000o00() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass18 */

                public final void O000000o(String str) {
                    CmTJInfraModule.this.callBackBundle(0, true, str, callback);
                }

                public final void O00000Oo(String str) {
                    CmTJInfraModule.this.callBackBundle(-1, false, str, callback);
                }
            };
            try {
                r0.O000000o(grs.O000000o(IrDnaSdkHelper.buildIrCode(i, ByteBuffer.wrap(grs.O000000o(str)).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().array()).data));
            } catch (Exception e) {
                r0.O00000Oo(e.toString());
            }
        }
    }

    @ReactMethod
    public void fetchRemoteInfrared(String str, String str2, final Callback callback) {
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(this.mCurrentClient);
            if (fzh == null) {
                fzh = new fzh();
            }
            try {
                Remote remote = (Remote) gbj.O000000o(str, Remote.class);
                Key key = (Key) gbj.O000000o(str2, Key.class);
                AnonymousClass19 r1 = new fzh.O00000Oo() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass19 */

                    public final void O000000o(List<Infrared> list) {
                        CmTJInfraModule.this.callBackBundle(0, true, gbj.O000000o(CmTJInfraModule.this.paraseListInfrared(list)), callback);
                    }

                    public final void O000000o(String str) {
                        CmTJInfraModule.this.callBackBundle(-1, false, str, callback);
                    }
                };
                fzh.O00000Oo();
                try {
                    List fetchNoAirInfrareds = fzh.O00000Oo.fetchNoAirInfrareds(remote, key);
                    if (fetchNoAirInfrareds == null) {
                        fetchNoAirInfrareds = new ArrayList();
                    }
                    r1.O000000o(fetchNoAirInfrareds);
                } catch (Exception e) {
                    r1.O000000o(e.toString());
                }
            } catch (Exception e2) {
                callBackBundle(-1, false, e2.toString(), callback);
            }
        }
    }

    public List<Infrared> paraseListInfrared(List<Infrared> list) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Infrared infrared = list.get(i);
                if (TextUtils.isEmpty(infrared.getData_str())) {
                    infrared.setData_Str(base64Encode(infrared.getData()));
                }
                infrared.setData(null);
            }
        }
        return list;
    }

    @ReactMethod
    public void fetchAirRemoteInfrared(String str, String str2, String str3, final Callback callback) {
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(this.mCurrentClient);
            if (fzh == null) {
                fzh = new fzh();
            }
            try {
                Remote remote = (Remote) gbj.O000000o(str, Remote.class);
                Key key = (Key) gbj.O000000o(str2, Key.class);
                final AirRemoteState airRemoteState = (AirRemoteState) gbj.O000000o(str3, AirRemoteState.class);
                AnonymousClass2 r1 = new fzh.O00000Oo() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass2 */

                    public final void O000000o(List<Infrared> list) {
                        List<Infrared> paraseListInfrared = CmTJInfraModule.this.paraseListInfrared(list);
                        String O000000o2 = gbj.O000000o(airRemoteState);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("AirRemoteState", O000000o2);
                            jSONObject.putOpt("Infrareds", gbj.O000000o(paraseListInfrared));
                        } catch (JSONException e) {
                            gbu.O000000o("CmTJInfraModule:  " + e.toString());
                        }
                        CmTJInfraModule.this.callBackBundle(0, true, jSONObject.toString(), callback);
                    }

                    public final void O000000o(String str) {
                        CmTJInfraModule.this.callBackBundle(-1, false, str, callback);
                    }
                };
                fzh.O00000Oo();
                try {
                    List fetchAirInfrareds = fzh.O00000Oo.fetchAirInfrareds(remote, key, airRemoteState);
                    if (fetchAirInfrareds == null) {
                        fetchAirInfrareds = new ArrayList();
                    }
                    r1.O000000o(fetchAirInfrareds);
                } catch (Exception e) {
                    r1.O000000o(e.toString());
                }
            } catch (Exception e2) {
                callBackBundle(-1, false, e2.toString(), callback);
            }
        }
    }

    @ReactMethod
    public void fetchAirTimerInfrared(String str, String str2, int i, final Callback callback) {
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(this.mCurrentClient);
            if (fzh == null) {
                fzh = new fzh();
            }
            try {
                Key key = (Key) gbj.O000000o(str, Key.class);
                AirRemoteState airRemoteState = (AirRemoteState) gbj.O000000o(str2, AirRemoteState.class);
                AnonymousClass3 r1 = new fzh.O00000Oo() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass3 */

                    public final void O000000o(List<Infrared> list) {
                        CmTJInfraModule.this.callBackBundle(0, true, gbj.O000000o(CmTJInfraModule.this.paraseListInfrared(list)), callback);
                    }

                    public final void O000000o(String str) {
                        CmTJInfraModule.this.callBackBundle(-1, false, str, callback);
                    }
                };
                fzh.O00000Oo();
                try {
                    List fetchAirTimeInfrareds = fzh.O00000Oo.fetchAirTimeInfrareds(key, i, airRemoteState);
                    if (fetchAirTimeInfrareds == null) {
                        fetchAirTimeInfrareds = new ArrayList();
                    }
                    r1.O000000o(fetchAirTimeInfrareds);
                } catch (Exception e) {
                    r1.O000000o(e.toString());
                }
            } catch (Exception e2) {
                callBackBundle(-1, false, e2.toString(), callback);
            }
        }
    }

    @ReactMethod
    public void getAirRemoteState(String str, final Callback callback) {
        Remote remote;
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(this.mCurrentClient);
            if (fzh == null) {
                fzh = new fzh();
            }
            try {
                remote = (Remote) gbj.O000000o(str, Remote.class);
            } catch (Exception e) {
                callBackBundle(-1, false, e.toString(), callback);
                remote = null;
            }
            AnonymousClass4 r1 = new fzh.O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass4 */

                public final void O000000o(AirRemoteState airRemoteState) {
                    CmTJInfraModule.this.callBackBundle(0, true, gbj.O000000o(airRemoteState), callback);
                }

                public final void O000000o(String str) {
                    CmTJInfraModule.this.callBackBundle(-1, false, str, callback);
                }
            };
            fzh.O00000Oo();
            try {
                r1.O000000o(fzh.O00000Oo.getAirRemoteStatus(remote));
            } catch (Exception e2) {
                r1.O000000o(e2.toString());
            }
        }
    }

    @ReactMethod
    public void isMemoryKey(String str, Callback callback) {
        callBackBundle(-1, false, "this method is not support for android", callback);
    }

    @ReactMethod
    public void isCustomKey(String str, Callback callback) {
        callBackBundle(-1, false, "this method is not support for android", callback);
    }

    @ReactMethod
    public void getAllProvincesCallback(final Callback callback) {
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(this.mCurrentClient);
            if (fzh == null) {
                fzh = new fzh();
            }
            new TvClient(XmPluginHostApi.instance().context()).load_provinces_from_server(new ITvClient.CallBackOnProvincesLoaded(new fzh.O0000Oo0() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass5 */

                public final void O000000o(int i, List<Province> list) {
                    CmTJInfraModule.this.callBackBundle(i, true, gbj.O000000o(list), callback);
                }

                public final void O000000o(int i, String str) {
                    CmTJInfraModule.this.callBackBundle(i, false, str, callback);
                }
            }) {
                /* class _m_j.fzh.AnonymousClass13 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O0000Oo0 f17438O000000o;

                {
                    this.f17438O000000o = r2;
                }

                public final void onProviceLoaded(int i, List<Province> list) {
                    if (i == 0) {
                        this.f17438O000000o.O000000o(i, list);
                    } else {
                        this.f17438O000000o.O000000o(i, "load_provinces_from_server error, error code is ".concat(String.valueOf(i)));
                    }
                }
            });
        }
    }

    @ReactMethod
    public void getAllCitiesCallback(final Callback callback) {
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(this.mCurrentClient);
            if (fzh == null) {
                fzh = new fzh();
            }
            new TvClient(XmPluginHostApi.instance().context()).load_cities_from_server(new ITvClient.CallBackOnCitiesLoaded(new fzh.O00000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass6 */

                public final void O000000o(int i, List<City> list) {
                    CmTJInfraModule.this.callBackBundle(i, true, gbj.O000000o(list), callback);
                }

                public final void O000000o(int i, String str) {
                    CmTJInfraModule.this.callBackBundle(i, false, str, callback);
                }
            }) {
                /* class _m_j.fzh.AnonymousClass2 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O00000o f17439O000000o;

                {
                    this.f17439O000000o = r2;
                }

                public final void onCityLoaded(int i, List<City> list) {
                    if (i == 0) {
                        this.f17439O000000o.O000000o(i, list);
                    } else {
                        this.f17439O000000o.O000000o(i, "load_cities_from_server error, error code is ".concat(String.valueOf(i)));
                    }
                }
            });
        }
    }

    @ReactMethod
    public void getAllProvidersCallback(final Callback callback) {
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(this.mCurrentClient);
            if (fzh == null) {
                fzh = new fzh();
            }
            new TvClient(XmPluginHostApi.instance().context()).load_cityproviders_from_server(new ITvClient.CallBackOnCityProvidersLoaded(new fzh.O0000OOo() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass7 */

                public final void O000000o(int i, List<CityProvider> list) {
                    CmTJInfraModule.this.callBackBundle(i, true, gbj.O000000o(list), callback);
                }

                public final void O000000o(int i, String str) {
                    CmTJInfraModule.this.callBackBundle(i, false, str, callback);
                }
            }) {
                /* class _m_j.fzh.AnonymousClass3 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O0000OOo f17440O000000o;

                {
                    this.f17440O000000o = r2;
                }

                public final void onCityProviderLoaded(int i, List<CityProvider> list) {
                    if (i == 0) {
                        this.f17440O000000o.O000000o(i, list);
                    } else {
                        this.f17440O000000o.O000000o(i, "load_cityproviders_from_server error, error code is ".concat(String.valueOf(i)));
                    }
                }
            });
        }
    }

    @ReactMethod
    public void loadProviderRemotesByCity(int i, int i2, final Callback callback) {
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(this.mCurrentClient);
            if (fzh == null) {
                fzh = new fzh();
            }
            new TvClient(XmPluginHostApi.instance().context()).load_provider_remotes(i, i2, new ITvClient.CallBackOnCityProviderRemotesLoaded(new fzh.O0000O0o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass8 */

                public final void O000000o(int i, List<CityProviderRemote> list) {
                    CmTJInfraModule.this.callBackBundle(i, true, gbj.O000000o(list), callback);
                }

                public final void O000000o(int i, String str) {
                    CmTJInfraModule.this.callBackBundle(i, false, str, callback);
                }
            }) {
                /* class _m_j.fzh.AnonymousClass4 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O0000O0o f17441O000000o;

                {
                    this.f17441O000000o = r2;
                }

                public final void onLoaded(int i, List<CityProviderRemote> list) {
                    if (i == 0) {
                        this.f17441O000000o.O000000o(i, list);
                    } else {
                        this.f17441O000000o.O000000o(i, "load_provider_remotes error, error code is ".concat(String.valueOf(i)));
                    }
                }
            });
        }
    }

    @ReactMethod
    public void loadCityProvidersCallback(final Callback callback) {
        if (callback != null) {
            fzh fzh = this.mInfraredDataProviderMap.get(this.mCurrentClient);
            if (fzh == null) {
                fzh = new fzh();
            }
            new TvClient(XmPluginHostApi.instance().context()).load_cityproviders_from_server(new ITvClient.CallBackOnCityProvidersLoaded(new fzh.O00000o0() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass9 */

                public final void O000000o(int i, List<CityProvider> list) {
                    CmTJInfraModule.this.callBackBundle(i, true, gbj.O000000o(list), callback);
                }

                public final void O000000o(int i, String str) {
                    CmTJInfraModule.this.callBackBundle(i, false, str, callback);
                }
            }) {
                /* class _m_j.fzh.AnonymousClass5 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O00000o0 f17442O000000o;

                {
                    this.f17442O000000o = r2;
                }

                public final void onCityProviderLoaded(int i, List<CityProvider> list) {
                    if (i == 0) {
                        this.f17442O000000o.O000000o(i, list);
                    } else {
                        this.f17442O000000o.O000000o(i, "load_cityproviders_from_server error, error code is ".concat(String.valueOf(i)));
                    }
                }
            });
        }
    }

    @ReactMethod
    public void getProviderInCity(int i, final Callback callback) {
        if (callback != null) {
            if (this.mInfraredDataProviderMap.get(this.mCurrentClient) == null) {
                new fzh();
            }
            AnonymousClass10 r0 = new fzh.O0000Oo() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass10 */

                public final void O000000o(List<TvProvider> list) {
                    CmTJInfraModule.this.callBackBundle(0, true, gbj.O000000o(list), callback);
                }
            };
            List providersFromCity = new TvClient(XmPluginHostApi.instance().context()).getProvidersFromCity(i);
            if (providersFromCity == null) {
                providersFromCity = new ArrayList();
            }
            r0.O000000o(providersFromCity);
        }
    }

    @ReactMethod
    public void getCityInProvince(int i, final Callback callback) {
        if (callback != null) {
            if (this.mInfraredDataProviderMap.get(this.mCurrentClient) == null) {
                new fzh();
            }
            AnonymousClass11 r0 = new fzh.O00000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.chuangmi.CmTJInfraModule.AnonymousClass11 */

                public final void O000000o(int i, List<City> list) {
                    CmTJInfraModule.this.callBackBundle(i, true, gbj.O000000o(list), callback);
                }

                public final void O000000o(int i, String str) {
                    CmTJInfraModule.this.callBackBundle(i, false, str, callback);
                }
            };
            List provinceCities = new TvClient(XmPluginHostApi.instance().context()).getProvinceCities(i);
            if (provinceCities == null) {
                provinceCities = new ArrayList();
            }
            r0.O000000o(0, provinceCities);
        }
    }

    public void callBackBundle(int i, boolean z, String str, Callback callback) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("result", str);
        createMap.putInt("code", i);
        callback.invoke(Boolean.valueOf(z), createMap);
    }
}
