package com.tiqiaa.client.impl;

import _m_j.bdf;
import _m_j.bdi;
import _m_j.bpu;
import _m_j.bpx;
import _m_j.bqi;
import _m_j.bqm;
import _m_j.dea;
import _m_j.jbq;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.imi.fastjson.JSONObject;
import com.imi.fastjson.parser.Feature;
import com.lidroid.xutils.exception.HttpException;
import com.tiqiaa.client.IRemoteClient;
import com.tiqiaa.database.DataBaseManager;
import com.tiqiaa.icontrol.util.LanguageUtils;
import com.tiqiaa.icontrol.util.LogUtil;
import com.tiqiaa.icontrol.util.NetUtils;
import com.tiqiaa.icontrol.util.PhoneHelper;
import com.tiqiaa.icontrol.util.TQResponse;
import com.tiqiaa.icontrol.util.TiqiaaService;
import com.tiqiaa.icontrol.util.Utils;
import com.tiqiaa.local.LocalIrDb;
import com.tiqiaa.remote.entity.AirRemoteState;
import com.tiqiaa.remote.entity.Brand;
import com.tiqiaa.remote.entity.IrMatchPageInfo;
import com.tiqiaa.remote.entity.IrMatchParam;
import com.tiqiaa.remote.entity.Key;
import com.tiqiaa.remote.entity.MatchKey;
import com.tiqiaa.remote.entity.MatchPage;
import com.tiqiaa.remote.entity.Page;
import com.tiqiaa.remote.entity.Remote;
import com.tiqiaa.remote.entity.Room;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class RemoteClient implements IRemoteClient {
    private static final String BASE_REMOTE_URL = (TiqiaaService.isLocalServer() ? "http://192.168.0.108:8080/tqir/tjtt/remote" : "https://irdna.izazamall.com/tqir/tjtt/remote");
    public static int localSearchPageIndex = -1;
    public NetUtils client = new NetUtils(this.context);
    public Context context;
    public LocalIrDb localDb;

    public interface CallBackOnAuthenFinished {
        void authenDone(String str);
    }

    public interface CallBackOnMatchKeyLoaded {
        void onMatchKeyLoaded(List<MatchKey> list);
    }

    public RemoteClient(Context context2) {
        this.context = context2;
        this.localDb = LocalIrDb.getIrDb(context2);
    }

    public void exactMatchReomtes(final MatchPage matchPage, final IRemoteClient.CallbackOnMatchDone callbackOnMatchDone) {
        if (matchPage == null) {
            callbackOnMatchDone.onMatchDone(1, null);
        } else {
            getMatchKey(matchPage.getAppliance_type(), new CallBackOnMatchKeyLoaded() {
                /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass1 */

                /* JADX WARNING: Removed duplicated region for block: B:41:0x00aa A[SYNTHETIC] */
                /* JADX WARNING: Removed duplicated region for block: B:44:0x0052 A[SYNTHETIC] */
                public void onMatchKeyLoaded(List<MatchKey> list) {
                    boolean z;
                    if (list == null || list.size() == 0) {
                        list = DataBaseManager.getInstance().getMatchKeyByType(matchPage.getAppliance_type());
                        LogUtil.e("RemoteClient", "list == null || list.size() == 0!");
                    }
                    boolean z2 = true;
                    if (list == null || list.size() == 0) {
                        callbackOnMatchDone.onMatchDone(1, null);
                        LogUtil.e("RemoteClient", "获取MatchKey为空！");
                        return;
                    }
                    Collections.sort(list);
                    if (matchPage.getOkMarks() == null && matchPage.getFailedKeys() == null) {
                        matchPage.setNext_key(list.get(0).getKey_type());
                    } else {
                        Iterator<MatchKey> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            MatchKey next = it.next();
                            if (matchPage.getFailedKeys() == null || !matchPage.getFailedKeys().contains(Integer.valueOf(next.getKey_type()))) {
                                if (matchPage.getOkMarks() != null) {
                                    Iterator<MatchPage.IRMark> it2 = matchPage.getOkMarks().iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            if (it2.next().getKey_type() == next.getKey_type()) {
                                                z = true;
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                    if (z) {
                                        LogUtil.i("RemoteClient", "Current match keyType:" + next.getKey_type());
                                        matchPage.setNext_key(next.getKey_type());
                                        break;
                                    }
                                }
                                z = false;
                                if (z) {
                                }
                            }
                        }
                        if (!z2) {
                            LogUtil.w("RemoteClient", "match completed!");
                            callbackOnMatchDone.onMatchDone(6001, null);
                            return;
                        }
                    }
                    RemoteClient.this.match(matchPage, callbackOnMatchDone);
                }
            });
        }
    }

    public void download_reomte(final String str, final IRemoteClient.CallBackOnRemoteDownloaded callBackOnRemoteDownloaded) {
        String str2 = String.valueOf(BASE_REMOTE_URL) + "/download";
        if (!PhoneHelper.checkNet()) {
            callBackOnRemoteDownloaded.onRemoteDownloaded(0, this.localDb.downloadReomte(str, 0));
        } else {
            this.client.doPost(str2, str, new bqm<String>() {
                /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass2 */

                public void onSuccess(bqi<String> bqi) {
                    LogUtil.d("RemoteClient", "downloadRemote......onSuccess..######..........response = " + ((String) bqi.f13200O000000o));
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null) {
                        Remote downloadReomte = RemoteClient.this.localDb.downloadReomte(str, 0);
                        if (downloadReomte != null) {
                            callBackOnRemoteDownloaded.onRemoteDownloaded(0, downloadReomte);
                            return;
                        }
                    } else {
                        TQResponse tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class);
                        if (tQResponse != null) {
                            if (tQResponse.getErrcode() == 10000) {
                                Remote remote = (Remote) tQResponse.getData(Remote.class);
                                if (remote != null) {
                                    callBackOnRemoteDownloaded.onRemoteDownloaded(0, remote);
                                    if (remote.getBrand() != null) {
                                        DataBaseManager.getInstance().saveBrand(remote.getBrand());
                                        return;
                                    }
                                    return;
                                }
                                callBackOnRemoteDownloaded.onRemoteDownloaded(1, null);
                                return;
                            } else if (tQResponse.getErrcode() == 10003) {
                                Remote downloadReomte2 = RemoteClient.this.localDb.downloadReomte(str, 0);
                                if (downloadReomte2 != null) {
                                    callBackOnRemoteDownloaded.onRemoteDownloaded(0, downloadReomte2);
                                    return;
                                } else {
                                    callBackOnRemoteDownloaded.onRemoteDownloaded(3, null);
                                    return;
                                }
                            } else if (tQResponse.getErrcode() == 10005) {
                                Remote downloadReomte3 = RemoteClient.this.localDb.downloadReomte(str, 0);
                                if (downloadReomte3 != null) {
                                    callBackOnRemoteDownloaded.onRemoteDownloaded(0, downloadReomte3);
                                    return;
                                } else {
                                    callBackOnRemoteDownloaded.onRemoteDownloaded(4, null);
                                    return;
                                }
                            } else if (tQResponse.getErrcode() == 10002 || tQResponse.getErrcode() == 10004) {
                                Remote downloadReomte4 = RemoteClient.this.localDb.downloadReomte(str, 0);
                                if (downloadReomte4 != null) {
                                    callBackOnRemoteDownloaded.onRemoteDownloaded(0, downloadReomte4);
                                    return;
                                } else {
                                    callBackOnRemoteDownloaded.onRemoteDownloaded(5, null);
                                    return;
                                }
                            } else if (tQResponse.getErrcode() == 10016) {
                                Remote downloadReomte5 = RemoteClient.this.localDb.downloadReomte(str, 0);
                                if (downloadReomte5 != null) {
                                    callBackOnRemoteDownloaded.onRemoteDownloaded(0, downloadReomte5);
                                    return;
                                } else {
                                    callBackOnRemoteDownloaded.onRemoteDownloaded(6, null);
                                    return;
                                }
                            } else if (tQResponse.getErrcode() == 10017) {
                                Remote downloadReomte6 = RemoteClient.this.localDb.downloadReomte(str, 0);
                                if (downloadReomte6 != null) {
                                    callBackOnRemoteDownloaded.onRemoteDownloaded(0, downloadReomte6);
                                    return;
                                } else {
                                    callBackOnRemoteDownloaded.onRemoteDownloaded(7001, null);
                                    return;
                                }
                            } else {
                                Remote downloadReomte7 = RemoteClient.this.localDb.downloadReomte(str, 0);
                                if (downloadReomte7 != null) {
                                    callBackOnRemoteDownloaded.onRemoteDownloaded(0, downloadReomte7);
                                    return;
                                } else {
                                    callBackOnRemoteDownloaded.onRemoteDownloaded(1, null);
                                    return;
                                }
                            }
                        }
                    }
                    callBackOnRemoteDownloaded.onRemoteDownloaded(1, null);
                }

                public void onFailure(HttpException httpException, String str) {
                    Remote downloadReomte = RemoteClient.this.localDb.downloadReomte(str, 0);
                    if (downloadReomte != null) {
                        callBackOnRemoteDownloaded.onRemoteDownloaded(0, downloadReomte);
                    } else {
                        callBackOnRemoteDownloaded.onRemoteDownloaded(1, null);
                    }
                }
            });
        }
    }

    public void uploadReomte(final Remote remote, final IRemoteClient.CallBackOnRemoteUploaded callBackOnRemoteUploaded) {
        String str = String.valueOf(BASE_REMOTE_URL) + "/upload";
        if (UserClient.getCurrentUser() == null) {
            LogUtil.e("RemoteClient", "未登陆");
            callBackOnRemoteUploaded.onUploaded(8001, null);
            return;
        }
        final String id = remote.getId();
        if (UserClient.getCurrentUser().getId() != remote.getAuthor_id()) {
            String replace = UUID.randomUUID().toString().replace("-", "");
            remote.setId(replace);
            if (remote.getAuthor_id() == 0) {
                remote.setAuthor_id(UserClient.getCurrentUser().getId());
                fillDiyBasicData(remote);
            } else {
                remote.setModifier_id(UserClient.getCurrentUser().getId());
            }
            for (Key remote_id : remote.getKeys()) {
                remote_id.setRemote_id(replace);
            }
        }
        this.client.doPost(str, remote, new bqm<String>() {
            /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass3 */

            public void onSuccess(bqi<String> bqi) {
                TQResponse tQResponse;
                if (bqi.O00000o != 200 || bqi.f13200O000000o == null || (tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class)) == null) {
                    callBackOnRemoteUploaded.onUploaded(1, null);
                } else if (tQResponse.getErrcode() == 10000) {
                    Brand brand = (Brand) tQResponse.getData(Brand.class);
                    if (brand != null) {
                        remote.setBrand(brand);
                    }
                    if (!id.equalsIgnoreCase(remote.getId())) {
                        final String str = id;
                        final Remote remote = remote;
                        new Thread(new Runnable() {
                            /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass3.AnonymousClass1 */

                            public void run() {
                                DataBaseManager.getInstance().refreshRemoteInDB(str, remote);
                            }
                        }).start();
                    }
                    callBackOnRemoteUploaded.onUploaded(0, remote);
                } else if (tQResponse.getErrcode() == 10003) {
                    callBackOnRemoteUploaded.onUploaded(3, null);
                } else if (tQResponse.getErrcode() == 10005) {
                    callBackOnRemoteUploaded.onUploaded(4, null);
                } else if (tQResponse.getErrcode() == 10002 || tQResponse.getErrcode() == 10004) {
                    callBackOnRemoteUploaded.onUploaded(5, null);
                } else {
                    callBackOnRemoteUploaded.onUploaded(1, null);
                }
            }

            public void onFailure(HttpException httpException, String str) {
                callBackOnRemoteUploaded.onUploaded(1, null);
            }
        });
    }

    private void fillDiyBasicData(Remote remote) {
        try {
            remote.setApp_ver(this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName);
            remote.setDiy_device(1);
            remote.setLang(LanguageUtils.getLang());
            remote.setDpi(Utils.getLocalResolution(this.context));
        } catch (Exception e) {
            LogUtil.printException(e);
        }
    }

    public void downloadRoomRemoteSettings(Long l, final IRemoteClient.CallBackOnRoomRemoteSettingsDownloaded callBackOnRoomRemoteSettingsDownloaded) {
        this.client.doPost(String.valueOf(BASE_REMOTE_URL) + "/download_scene_remote_settings", l, new bqm<String>() {
            /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass4 */

            public void onFailure(HttpException httpException, String str) {
                LogUtil.e("RemoteClient", "downloadRoomRemoteSettings......onFailure..######..........response = ".concat(String.valueOf(str)));
                callBackOnRoomRemoteSettingsDownloaded.onDownloaded(1, null);
            }

            public void onSuccess(bqi<String> bqi) {
                if (bqi.O00000o != 200 || bqi.f13200O000000o == null) {
                    LogUtil.e("RemoteClient", "downloadRoomRemoteSettings......onFailure..######..........response = " + ((String) bqi.f13200O000000o));
                    callBackOnRoomRemoteSettingsDownloaded.onDownloaded(1, null);
                    return;
                }
                TQResponse tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class);
                if (tQResponse == null) {
                    callBackOnRoomRemoteSettingsDownloaded.onDownloaded(1, null);
                } else if (tQResponse.getErrcode() == 10000) {
                    LogUtil.e("RemoteClient", "downloadRoomRemoteSettings......success");
                    callBackOnRoomRemoteSettingsDownloaded.onDownloaded(0, (List) tQResponse.getData(new bdi<List<Room>>() {
                        /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass4.AnonymousClass1 */
                    }));
                } else if (tQResponse.getErrcode() == 10003) {
                    callBackOnRoomRemoteSettingsDownloaded.onDownloaded(3, null);
                } else if (tQResponse.getErrcode() == 10005) {
                    callBackOnRoomRemoteSettingsDownloaded.onDownloaded(4, null);
                } else if (tQResponse.getErrcode() == 10002 || tQResponse.getErrcode() == 10004) {
                    callBackOnRoomRemoteSettingsDownloaded.onDownloaded(5, null);
                } else {
                    LogUtil.e("RemoteClient", "downloadRoomRemoteSettings......onFailure..######..........response = " + ((String) bqi.f13200O000000o));
                    callBackOnRoomRemoteSettingsDownloaded.onDownloaded(1, null);
                }
            }
        });
    }

    public void uploadRoomRemoteSettings(Long l, List<Room> list, final IRemoteClient.CallBackOnRoomRemoteSettingsUploaded callBackOnRoomRemoteSettingsUploaded) {
        this.client.doPost(String.valueOf(BASE_REMOTE_URL) + "/upload_scene_remote_settings", list, new bqm<String>() {
            /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass5 */

            public void onSuccess(bqi<String> bqi) {
                if (bqi.O00000o == 200 && bqi.f13200O000000o != null) {
                    TQResponse tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class);
                    if (tQResponse == null) {
                        LogUtil.e("RemoteClient", "uploadSceneRemoteSettings......onFailure..######..........response = ".concat(String.valueOf(bqi)));
                    } else if (tQResponse.getErrcode() == 10000) {
                        callBackOnRoomRemoteSettingsUploaded.onUploaded(0);
                        return;
                    } else if (tQResponse.getErrcode() == 10003) {
                        callBackOnRoomRemoteSettingsUploaded.onUploaded(3);
                        return;
                    } else if (tQResponse.getErrcode() == 10005) {
                        callBackOnRoomRemoteSettingsUploaded.onUploaded(4);
                        return;
                    } else if (tQResponse.getErrcode() == 10002 || tQResponse.getErrcode() == 10004) {
                        callBackOnRoomRemoteSettingsUploaded.onUploaded(5);
                        return;
                    } else {
                        callBackOnRoomRemoteSettingsUploaded.onUploaded(1);
                        return;
                    }
                }
                callBackOnRoomRemoteSettingsUploaded.onUploaded(1);
            }

            public void onFailure(HttpException httpException, String str) {
                LogUtil.e("RemoteClient", "uploadSceneRemoteSettings......onFailure..######..........response = ".concat(String.valueOf(str)));
                callBackOnRoomRemoteSettingsUploaded.onUploaded(1);
            }
        });
    }

    public void load_brands(final IRemoteClient.CallbackOnBrandLoaded callbackOnBrandLoaded) {
        String str = String.valueOf(BASE_REMOTE_URL) + "/load_brands";
        final List<Brand> brands = DataBaseManager.getInstance().getBrands();
        if (brands == null || brands.size() <= 0 || isBrandOverdue()) {
            this.client.doPost(str, null, new bqm<String>() {
                /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass6 */

                public void onFailure(HttpException httpException, String str) {
                    LogUtil.e("RemoteClient", "load_brands......onFailure..######..........response = ".concat(String.valueOf(str)));
                    List list = brands;
                    if (list == null || list.size() <= 0) {
                        callbackOnBrandLoaded.onBrandLoaded(1, null);
                    } else {
                        callbackOnBrandLoaded.onBrandLoaded(0, brands);
                    }
                }

                public void onSuccess(bqi<String> bqi) {
                    LogUtil.d("RemoteClient", "load_brands......onSuccess..######..........response = " + ((String) bqi.f13200O000000o));
                    if (bqi.O00000o == 200 && bqi.f13200O000000o != null) {
                        TQResponse tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class);
                        if (tQResponse == null) {
                            LogUtil.e("RemoteClient", "load_brands......onFailure..######..........response = ".concat(String.valueOf(bqi)));
                        } else if (tQResponse.getErrcode() == 10000) {
                            final List list = (List) tQResponse.getData(new bdi<List<Brand>>() {
                                /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass6.AnonymousClass1 */
                            });
                            if (list == null || list.size() <= 0) {
                                RemoteClient.this.returnLocalBrands(brands, callbackOnBrandLoaded);
                                return;
                            }
                            final IRemoteClient.CallbackOnBrandLoaded callbackOnBrandLoaded = callbackOnBrandLoaded;
                            new Thread(new Runnable() {
                                /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass6.AnonymousClass2 */

                                public void run() {
                                    DataBaseManager.getInstance().saveBrands(list);
                                    RemoteClient.this.refreshBrandSaveTime();
                                    callbackOnBrandLoaded.onBrandLoaded(0, list);
                                }
                            }).start();
                            return;
                        } else if (!(tQResponse.getErrcode() == 10003 || tQResponse.getErrcode() == 10005)) {
                            if (tQResponse.getErrcode() == 10002 || tQResponse.getErrcode() == 10004) {
                                RemoteClient.this.returnLocalBrands(brands, callbackOnBrandLoaded);
                                return;
                            } else {
                                RemoteClient.this.returnLocalBrands(brands, callbackOnBrandLoaded);
                                return;
                            }
                        }
                    }
                    RemoteClient.this.returnLocalBrands(brands, callbackOnBrandLoaded);
                }
            });
        } else {
            callbackOnBrandLoaded.onBrandLoaded(0, brands);
        }
    }

    public void returnLocalBrands(List<Brand> list, IRemoteClient.CallbackOnBrandLoaded callbackOnBrandLoaded) {
        if (list == null || list.size() <= 0) {
            callbackOnBrandLoaded.onBrandLoaded(1, null);
        } else {
            callbackOnBrandLoaded.onBrandLoaded(0, list);
        }
    }

    public void searchOfficial(final Page page, final IRemoteClient.CallbackOnSearchDone callbackOnSearchDone) {
        String str = String.valueOf(BASE_REMOTE_URL) + "/search_official";
        if (!PhoneHelper.checkNet()) {
            callbackOnSearchDone.onSearchDone(0, this.localDb.searchReomtes(page, false));
        } else {
            this.client.doPost(str, page, new bqm<String>() {
                /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass7 */

                public void onFailure(HttpException httpException, String str) {
                    callbackOnSearchDone.onSearchDone(0, RemoteClient.this.localDb.searchReomtes(page, true));
                }

                public void onSuccess(bqi<String> bqi) {
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null) {
                        callbackOnSearchDone.onSearchDone(1, null);
                        return;
                    }
                    TQResponse tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class);
                    if (tQResponse == null) {
                        LogUtil.e("RemoteClient", "search remote ......onFailure..######..........response = ".concat(String.valueOf(bqi)));
                        callbackOnSearchDone.onSearchDone(1, null);
                    } else if (tQResponse.getErrcode() == 10000) {
                        List list = (List) tQResponse.getData(new bdi<List<Remote>>() {
                            /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass7.AnonymousClass1 */
                        });
                        LogUtil.e("RemoteClient", "search remote ......onSuccess");
                        if (list == null || list.size() < 30) {
                            if (RemoteClient.localSearchPageIndex == -1) {
                                RemoteClient.localSearchPageIndex = page.getPage();
                            }
                            try {
                                Page page = (Page) page.clone();
                                page.setPage(page.getPage() - RemoteClient.localSearchPageIndex);
                                List<Remote> searchReomtes = RemoteClient.this.localDb.searchReomtes(page, false);
                                if (searchReomtes != null) {
                                    list.addAll(searchReomtes);
                                }
                            } catch (Exception e) {
                                LogUtil.printException(e);
                            }
                        } else {
                            RemoteClient.localSearchPageIndex = -1;
                        }
                        callbackOnSearchDone.onSearchDone(0, list);
                    } else if (tQResponse.getErrcode() == 10003) {
                        callbackOnSearchDone.onSearchDone(3, null);
                    } else if (tQResponse.getErrcode() == 10005) {
                        callbackOnSearchDone.onSearchDone(4, null);
                    } else if (tQResponse.getErrcode() == 10002 || tQResponse.getErrcode() == 10004) {
                        callbackOnSearchDone.onSearchDone(5, null);
                    } else {
                        callbackOnSearchDone.onSearchDone(1, null);
                    }
                }
            });
        }
    }

    public void searchDiy(final Page page, final IRemoteClient.CallbackOnSearchDone callbackOnSearchDone) {
        String str = String.valueOf(BASE_REMOTE_URL) + "/search_diy";
        LogUtil.e("RemoteClient", "searchDiy url=".concat(String.valueOf(str)));
        if (!PhoneHelper.checkNet()) {
            callbackOnSearchDone.onSearchDone(2, null);
        } else {
            this.client.doPost(str, page, new bqm<String>() {
                /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass8 */

                public void onFailure(HttpException httpException, String str) {
                    Log.e("RemoteClient", "searchDiy exception=".concat(String.valueOf(str)));
                    callbackOnSearchDone.onSearchDone(1, null);
                }

                public void onSuccess(bqi<String> bqi) {
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null) {
                        callbackOnSearchDone.onSearchDone(1, null);
                        return;
                    }
                    TQResponse tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class);
                    StringBuilder sb = new StringBuilder("tqResponse=");
                    sb.append(tQResponse == null ? "null" : bdf.O000000o(tQResponse));
                    LogUtil.e("RemoteClient", sb.toString());
                    if (tQResponse == null) {
                        LogUtil.e("RemoteClient", "search remote ......onFailure..######..........response = ".concat(String.valueOf(bqi)));
                        callbackOnSearchDone.onSearchDone(1, null);
                    } else if (tQResponse.getErrcode() == 10000) {
                        List<Remote> list = (List) tQResponse.getData(new bdi<List<Remote>>() {
                            /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass8.AnonymousClass1 */
                        });
                        LogUtil.e("RemoteClient", "search remote ......onSuccess");
                        if (list == null || list.size() == 0) {
                            if (RemoteClient.localSearchPageIndex == -1) {
                                RemoteClient.localSearchPageIndex = page.getPage();
                            }
                            try {
                                Page page = (Page) page.clone();
                                page.setPage(page.getPage() - RemoteClient.localSearchPageIndex);
                                list = RemoteClient.this.localDb.searchReomtes(page, false);
                            } catch (Exception e) {
                                LogUtil.printException(e);
                            }
                        } else {
                            RemoteClient.localSearchPageIndex = -1;
                        }
                        callbackOnSearchDone.onSearchDone(0, list);
                    } else if (tQResponse.getErrcode() == 10003) {
                        callbackOnSearchDone.onSearchDone(3, null);
                    } else if (tQResponse.getErrcode() == 10005) {
                        callbackOnSearchDone.onSearchDone(4, null);
                    } else if (tQResponse.getErrcode() == 10002 || tQResponse.getErrcode() == 10004) {
                        callbackOnSearchDone.onSearchDone(5, null);
                    } else {
                        callbackOnSearchDone.onSearchDone(1, null);
                    }
                }
            });
        }
    }

    public void match(final MatchPage matchPage, final IRemoteClient.CallbackOnMatchDone callbackOnMatchDone) {
        logMatchParam(matchPage);
        if (!PhoneHelper.checkNet()) {
            List<Remote> matchRemotes = this.localDb.matchRemotes(matchPage);
            if (matchRemotes != null) {
                LogUtil.i("RemoteClient", "match...local...onSuccess..remote size = " + matchRemotes.size());
            }
            callbackOnMatchDone.onMatchDone(0, matchRemotes);
            return;
        }
        this.client.doPost(String.valueOf(BASE_REMOTE_URL) + "/match_official", matchPage, new bqm<String>() {
            /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass9 */

            public void onFailure(HttpException httpException, String str) {
                callbackOnMatchDone.onMatchDone(0, RemoteClient.this.localDb.matchRemotes(matchPage, true));
            }

            public void onSuccess(bqi<String> bqi) {
                if (bqi.O00000o != 200 || bqi.f13200O000000o == null) {
                    callbackOnMatchDone.onMatchDone(1, null);
                    LogUtil.w("RemoteClient", "match.......!!!!!!!!!!!!........CallbackOnMatchDone.ERROR_CODE_FAILED, status code or result error!" + bqi.toString());
                    RemoteClient.this.getLocalMatch(matchPage, callbackOnMatchDone);
                    return;
                }
                TQResponse tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class);
                if (tQResponse == null) {
                    LogUtil.e("RemoteClient", "match.......!!!!!!!!!!!!.........tqResponse==null");
                    RemoteClient.this.getLocalMatch(matchPage, callbackOnMatchDone);
                } else if (tQResponse.getErrcode() == 10000) {
                    try {
                        List<Remote> list = (List) tQResponse.getData(new bdi<List<Remote>>() {
                            /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass9.AnonymousClass1 */
                        });
                        StringBuilder sb = new StringBuilder("match........######..........ErrorCode.ERRCODE_SUCCESS , remotes.size = ");
                        sb.append(list == null ? 0 : list.size());
                        LogUtil.d("RemoteClient", sb.toString());
                        if (list == null || list.size() < 5) {
                            LogUtil.i("RemoteClient", "从本地云获取匹配数据。");
                            try {
                                List<Remote> matchRemotes = RemoteClient.this.localDb.matchRemotes(matchPage);
                                if (list == null) {
                                    list = matchRemotes;
                                } else if (matchRemotes != null) {
                                    for (Remote next : matchRemotes) {
                                        if (!RemoteClient.this.containsIrMark(list, next)) {
                                            list.add(next);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                RemoteClient.this.getLocalMatch(matchPage, callbackOnMatchDone);
                                LogUtil.printException(e);
                                LogUtil.e("RemoteClient", "从本地解析remotes数据失败");
                                return;
                            }
                        }
                        callbackOnMatchDone.onMatchDone(0, list);
                    } catch (Exception unused) {
                        LogUtil.e("RemoteClient", "解析remotes数据失败");
                        RemoteClient.this.getLocalMatch(matchPage, callbackOnMatchDone);
                    }
                } else if (tQResponse.getErrcode() == 10003) {
                    callbackOnMatchDone.onMatchDone(3, null);
                } else if (tQResponse.getErrcode() == 10005) {
                    callbackOnMatchDone.onMatchDone(4, null);
                } else if (tQResponse.getErrcode() == 10002 || tQResponse.getErrcode() == 10004) {
                    callbackOnMatchDone.onMatchDone(5, null);
                } else {
                    callbackOnMatchDone.onMatchDone(1, null);
                    LogUtil.w("RemoteClient", "match.......!!!!!!!!!!!!........CallbackOnMatchDone.ERROR_CODE_FAILED,errcode err:" + tQResponse.getErrcode());
                    RemoteClient.this.getLocalMatch(matchPage, callbackOnMatchDone);
                }
            }
        });
    }

    public void getLocalMatch(MatchPage matchPage, IRemoteClient.CallbackOnMatchDone callbackOnMatchDone) {
        List<Remote> matchRemotes = this.localDb.matchRemotes(matchPage);
        if (matchRemotes != null) {
            LogUtil.i("RemoteClient", "match...local...onSuccess..remote size = " + matchRemotes.size());
        }
        callbackOnMatchDone.onMatchDone(0, matchRemotes);
    }

    private void logMatchParam(MatchPage matchPage) {
        try {
            LogUtil.e("RemoteClient", "matchpage:brand->" + matchPage.getBrand_id() + ",appliance->" + matchPage.getAppliance_type() + ",testkey->" + matchPage.getNext_key());
            if (matchPage.getFailedKeys() != null) {
                LogUtil.e("RemoteClient", ",\r\nfailedKeys->");
                for (Integer intValue : matchPage.getFailedKeys()) {
                    LogUtil.e("RemoteClient", String.valueOf(intValue.intValue()) + ",");
                }
            }
            if (matchPage.getOkMarks() != null) {
                LogUtil.e("RemoteClient", "\r\nokMarks->");
                for (MatchPage.IRMark next : matchPage.getOkMarks()) {
                    LogUtil.e("RemoteClient", String.valueOf(next.getKey_type()) + ":" + next.getIr_mark() + ",");
                }
            }
            if (matchPage.getWrongMarks() != null) {
                LogUtil.e("RemoteClient", "\r\nwrongMarks->");
                for (MatchPage.IRMark next2 : matchPage.getWrongMarks()) {
                    LogUtil.e("RemoteClient", String.valueOf(next2.getKey_type()) + ":" + next2.getIr_mark() + ",");
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public boolean containsIrMark(List<Remote> list, Remote remote) {
        if (list == null || remote == null) {
            return false;
        }
        for (Remote keys : list) {
            try {
                if (keys.getKeys().get(0).getInfrareds().get(0).getIr_mark() == remote.getKeys().get(0).getInfrareds().get(0).getIr_mark()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void load_match_keys(final int i, final CallBackOnMatchKeyLoaded callBackOnMatchKeyLoaded) {
        this.client.doPost(String.valueOf(BASE_REMOTE_URL) + "/load_match_keys", null, new bqm<String>() {
            /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass10 */

            public void onFailure(HttpException httpException, String str) {
                LogUtil.e("RemoteClient", "获取遥控器按键匹配序列失败。msg:".concat(String.valueOf(str)));
                callBackOnMatchKeyLoaded.onMatchKeyLoaded(null);
            }

            public void onSuccess(bqi<String> bqi) {
                if (bqi.O00000o != 200 || bqi.f13200O000000o == null) {
                    LogUtil.e("RemoteClient", "获取遥控器按键匹配序列失败。msg:".concat(String.valueOf(bqi)));
                    callBackOnMatchKeyLoaded.onMatchKeyLoaded(null);
                    return;
                }
                TQResponse tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class);
                if (tQResponse == null || tQResponse.getErrcode() != 10000) {
                    LogUtil.e("RemoteClient", "获取遥控器按键匹配序列失败。msg:tqResponse null or fail");
                    callBackOnMatchKeyLoaded.onMatchKeyLoaded(null);
                    return;
                }
                final List<MatchKey> list = (List) tQResponse.getData(new bdi<List<MatchKey>>() {
                    /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass10.AnonymousClass1 */
                });
                if (list == null || list.size() <= 0) {
                    LogUtil.e("RemoteClient", "获取遥控器按键匹配序列失败。msg:matchKeys null");
                    callBackOnMatchKeyLoaded.onMatchKeyLoaded(null);
                    return;
                }
                LogUtil.e("RemoteClient", "获取遥控器按键匹配序列成功");
                ArrayList arrayList = new ArrayList();
                for (MatchKey matchKey : list) {
                    if (matchKey.getAppliance_type() == i) {
                        arrayList.add(matchKey);
                    }
                }
                callBackOnMatchKeyLoaded.onMatchKeyLoaded(arrayList);
                new Thread(new Runnable() {
                    /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass10.AnonymousClass2 */

                    public void run() {
                        DataBaseManager.getInstance().updateMatchKeyTable(list);
                    }
                }).start();
            }
        });
    }

    private void getMatchKey(int i, CallBackOnMatchKeyLoaded callBackOnMatchKeyLoaded) {
        List<MatchKey> matchKeyByType;
        Date date = null;
        String string = this.context.getSharedPreferences("match_key_update_date", 0).getString("lastUpDateDate", null);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (string != null) {
            try {
                date = simpleDateFormat.parse(string);
            } catch (Exception e) {
                LogUtil.e("RemoteClient", "解析日期失败:".concat(String.valueOf(string)));
                LogUtil.printException(e);
            }
        }
        if (date == null || date2.getYear() != date.getYear() || date2.getMonth() != date.getMonth() || date2.getDay() - date.getDay() > 0 || (matchKeyByType = DataBaseManager.getInstance().getMatchKeyByType(i)) == null || matchKeyByType.size() <= 0) {
            load_match_keys(i, callBackOnMatchKeyLoaded);
        } else {
            callBackOnMatchKeyLoaded.onMatchKeyLoaded(matchKeyByType);
        }
    }

    private boolean isBrandOverdue() {
        long j = this.context.getSharedPreferences("Overdue", 0).getLong("BrandSaveDate", 0);
        Date date = new Date();
        if (j == 0) {
            refreshBrandSaveTime();
            return true;
        } else if (date.getTime() - j < 604800000) {
            return false;
        } else {
            return true;
        }
    }

    public void refreshBrandSaveTime() {
        this.context.getSharedPreferences("Overdue", 0).edit().putLong("BrandSaveDate", new Date().getTime()).commit();
    }

    public void authen(final CallBackOnAuthenFinished callBackOnAuthenFinished) {
        this.client.doPost(String.valueOf(BASE_REMOTE_URL) + "/auth", null, new bqm<String>() {
            /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass11 */

            public void onFailure(HttpException httpException, String str) {
                LogUtil.e("RemoteClient", "认证失败。msg:".concat(String.valueOf(str)));
                callBackOnAuthenFinished.authenDone(null);
            }

            public void onSuccess(bqi<String> bqi) {
                TQResponse tQResponse;
                LogUtil.e("RemoteClient", "认证成功");
                if (bqi.O00000o == 200 && bqi.f13200O000000o != null && (tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class)) != null && tQResponse.getErrcode() == 10000) {
                    try {
                        callBackOnAuthenFinished.authenDone((String) tQResponse.getData());
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                callBackOnAuthenFinished.authenDone(null);
            }
        });
    }

    public void searchAirRemote(Page page, final IRemoteClient.CallbackOnSearchDone callbackOnSearchDone) {
        boolean z;
        String str = String.valueOf(BASE_REMOTE_URL) + "/search_official";
        page.setPage(0);
        final List<Remote> matchReomtes = this.localDb.matchReomtes(page, true);
        if (matchReomtes == null || matchReomtes.size() == 0) {
            LogUtil.e("RemoteClient", "searchAirRemote本地获取到的数据为空！");
            z = false;
        } else {
            z = true;
        }
        int i = 5;
        while (z && i > 0) {
            i--;
            page.setPage(page.getPage() + 1);
            List<Remote> matchReomtes2 = this.localDb.matchReomtes(page, true);
            if (matchReomtes2 == null || matchReomtes2.size() == 0) {
                z = false;
            } else {
                matchReomtes.addAll(matchReomtes2);
            }
        }
        if (!PhoneHelper.checkNet()) {
            callbackOnSearchDone.onSearchDone(0, matchReomtes);
            return;
        }
        page.setPage(0);
        this.client.doPost(str, page, new bqm<String>() {
            /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass12 */

            public void onFailure(HttpException httpException, String str) {
                callbackOnSearchDone.onSearchDone(0, matchReomtes);
            }

            public void onSuccess(bqi<String> bqi) {
                List list;
                if (bqi.O00000o != 200 || bqi.f13200O000000o == null) {
                    callbackOnSearchDone.onSearchDone(0, matchReomtes);
                    return;
                }
                TQResponse tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class);
                if (tQResponse == null) {
                    LogUtil.e("RemoteClient", "search remote ......onFailure..######..........response = ".concat(String.valueOf(bqi)));
                    callbackOnSearchDone.onSearchDone(1, null);
                } else if (tQResponse.getErrcode() == 10000 && (list = (List) tQResponse.getData(new bdi<List<Remote>>() {
                    /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass12.AnonymousClass1 */
                })) != null && list.size() > 0) {
                    LogUtil.e("RemoteClient", "search remote ......onSuccess");
                    List list2 = matchReomtes;
                    if (list2 != null) {
                        list2.addAll(list);
                    } else {
                        callbackOnSearchDone.onSearchDone(0, list);
                        return;
                    }
                }
                callbackOnSearchDone.onSearchDone(0, matchReomtes);
            }
        });
    }

    public void exactMatchReomtes(final MatchPage matchPage, final boolean z, final IRemoteClient.CallbackOnMatchDone callbackOnMatchDone) {
        if (matchPage == null) {
            callbackOnMatchDone.onMatchDone(1, null);
        } else {
            getMatchKey(matchPage.getAppliance_type(), new CallBackOnMatchKeyLoaded() {
                /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass13 */

                /* JADX WARNING: Removed duplicated region for block: B:50:0x00c5 A[SYNTHETIC] */
                /* JADX WARNING: Removed duplicated region for block: B:53:0x006d A[SYNTHETIC] */
                public void onMatchKeyLoaded(List<MatchKey> list) {
                    boolean z;
                    if (list == null || list.size() == 0) {
                        list = DataBaseManager.getInstance().getMatchKeyByType(matchPage.getAppliance_type());
                    }
                    boolean z2 = true;
                    if (list == null || list.size() == 0) {
                        callbackOnMatchDone.onMatchDone(1, null);
                        LogUtil.e("RemoteClient", "获取MatchKey为空！");
                        return;
                    }
                    Collections.sort(list);
                    if (!z) {
                        Iterator<MatchKey> it = list.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().getKey_type() == 800) {
                                    it.remove();
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (matchPage.getOkMarks() == null && matchPage.getFailedKeys() == null) {
                        matchPage.setNext_key(list.get(0).getKey_type());
                    } else {
                        Iterator<MatchKey> it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z2 = false;
                                break;
                            }
                            MatchKey next = it2.next();
                            if (matchPage.getFailedKeys() == null || !matchPage.getFailedKeys().contains(Integer.valueOf(next.getKey_type()))) {
                                if (matchPage.getOkMarks() != null) {
                                    Iterator<MatchPage.IRMark> it3 = matchPage.getOkMarks().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (it3.next().getKey_type() == next.getKey_type()) {
                                                z = true;
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                    if (z) {
                                        LogUtil.i("RemoteClient", "Current match keyType:" + next.getKey_type());
                                        matchPage.setNext_key(next.getKey_type());
                                        break;
                                    }
                                }
                                z = false;
                                if (z) {
                                }
                            }
                        }
                        if (!z2) {
                            LogUtil.i("RemoteClient", "match completed!");
                            callbackOnMatchDone.onMatchDone(6001, null);
                            return;
                        }
                    }
                    RemoteClient.this.match(matchPage, callbackOnMatchDone);
                }
            });
        }
    }

    public void loadKeyInfrareds(String str, int i, AirRemoteState airRemoteState, IRemoteClient.CallBackOnKeyInfraredsLoaded callBackOnKeyInfraredsLoaded) {
        callBackOnKeyInfraredsLoaded.onInfraredsLoaded(0, null);
    }

    public void delete_remote(String str, final IRemoteClient.CallBackOnRemoteDeleted callBackOnRemoteDeleted) {
        String str2 = String.valueOf(BASE_REMOTE_URL) + "/delete_remote";
        if (UserClient.getCurrentUser() == null) {
            LogUtil.e("RemoteClient", "未登陆");
            callBackOnRemoteDeleted.onDeleted(9001);
        } else if (!PhoneHelper.checkNet()) {
            callBackOnRemoteDeleted.onDeleted(1);
        } else {
            long id = UserClient.getCurrentUser().getId();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("remote_id", str);
            jSONObject.put("user_id", Long.valueOf(id));
            this.client.doPost(str2, jSONObject, new bqm<String>() {
                /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass14 */

                public void onFailure(HttpException httpException, String str) {
                    callBackOnRemoteDeleted.onDeleted(1);
                }

                public void onSuccess(bqi<String> bqi) {
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null) {
                        callBackOnRemoteDeleted.onDeleted(1);
                    } else if (((TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class)).getErrcode() == 10000) {
                        callBackOnRemoteDeleted.onDeleted(0);
                    } else {
                        callBackOnRemoteDeleted.onDeleted(1);
                    }
                }
            });
        }
    }

    public void miss_model(int i, long j, String str) {
        String str2 = String.valueOf(BASE_REMOTE_URL) + "/miss_model";
        if (PhoneHelper.checkNet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appliant_type", Integer.valueOf(i));
            jSONObject.put("brand_id", Long.valueOf(j));
            jSONObject.put("model", str);
            this.client.doPost(str2, jSONObject, new bqm<String>() {
                /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass15 */

                public void onFailure(HttpException httpException, String str) {
                    LogUtil.e("RemoteClient", "onFailure...!" + RemoteClient.this.client.hashCode());
                }

                public void onSuccess(bqi<String> bqi) {
                    LogUtil.i("RemoteClient", "onSuccess...!");
                }
            });
        }
    }

    public void autoMatchRemotes(final Page page, final IRemoteClient.CallbackOnAutoMatchDone callbackOnAutoMatchDone) {
        String str = String.valueOf(BASE_REMOTE_URL) + "/search_official";
        page.setKeyword(null);
        if (page.getAppliance_type() == 2) {
            List matchReomtes = this.localDb.matchReomtes(page, true);
            if (page.getPage() == 0) {
                Object noScreenAirRemotes = this.localDb.getNoScreenAirRemotes(page.getBrand_id());
                if (matchReomtes == null) {
                    matchReomtes = new ArrayList();
                }
                if (noScreenAirRemotes == null) {
                    noScreenAirRemotes = new ArrayList();
                }
                if (matchReomtes.size() < 4) {
                    matchReomtes.addAll(noScreenAirRemotes);
                } else {
                    matchReomtes.addAll(4, noScreenAirRemotes);
                }
            }
            callbackOnAutoMatchDone.onAutoMatchDone(0, matchReomtes);
        } else if (!PhoneHelper.checkNet()) {
            callbackOnAutoMatchDone.onAutoMatchDone(0, this.localDb.matchReomtes(page, true));
        } else {
            this.client.doPost(str, page, new bqm<String>() {
                /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass16 */

                public void onFailure(HttpException httpException, String str) {
                    callbackOnAutoMatchDone.onAutoMatchDone(0, RemoteClient.this.localDb.matchReomtes(page, true));
                }

                public void onSuccess(bqi<String> bqi) {
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null) {
                        callbackOnAutoMatchDone.onAutoMatchDone(0, RemoteClient.this.localDb.matchReomtes(page, true));
                        return;
                    }
                    TQResponse tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class);
                    if (tQResponse == null) {
                        LogUtil.e("RemoteClient", "AutoMatchRemotes remote ......onFailure..######..........response = ".concat(String.valueOf(bqi)));
                        callbackOnAutoMatchDone.onAutoMatchDone(1, null);
                    } else if (tQResponse.getErrcode() == 10000) {
                        List list = (List) tQResponse.getData(new bdi<List<Remote>>() {
                            /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass16.AnonymousClass1 */
                        });
                        if (list == null || list.size() < 30) {
                            if (list == null) {
                                list = new ArrayList();
                            }
                            List<Remote> matchReomtes = RemoteClient.this.localDb.matchReomtes(page, false);
                            if (matchReomtes != null && matchReomtes.size() > 0) {
                                for (Remote next : matchReomtes) {
                                    if (!list.contains(next)) {
                                        list.add(next);
                                    }
                                }
                            }
                        }
                        callbackOnAutoMatchDone.onAutoMatchDone(0, list);
                    }
                }
            });
        }
    }

    public void irmatch(IrMatchParam irMatchParam, final IRemoteClient.CallBackOnIrMatchDone callBackOnIrMatchDone) {
        if (irMatchParam == null) {
            LogUtil.e("RemoteClient", "irmatch param is null!");
            callBackOnIrMatchDone.onMatched(1, 0, null);
        } else if (irMatchParam.getAppliance_type() == 2) {
            String[] airIRPNameAndRemotes = LocalIrDb.getIrDb(this.context).getAirIRPNameAndRemotes(irMatchParam.getData(), irMatchParam.getBrand_id());
            if (airIRPNameAndRemotes != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : airIRPNameAndRemotes) {
                    if (str != null && !str.equals("")) {
                        arrayList.add(str);
                    }
                }
                callBackOnIrMatchDone.onMatched(0, arrayList.size(), arrayList);
                return;
            }
            callBackOnIrMatchDone.onMatched(1, 0, null);
        } else if (!PhoneHelper.checkNet()) {
            LogUtil.e("RemoteClient", "irmatch param is null!");
            callBackOnIrMatchDone.onMatched(2, 0, null);
        } else {
            String str2 = String.valueOf(BASE_REMOTE_URL) + "/irmatch";
            IrMatchPageInfo irMatchPageInfo = new IrMatchPageInfo(irMatchParam);
            if (irMatchPageInfo.getMarks() == null || irMatchPageInfo.getMarks().size() <= 0 || irMatchPageInfo.getMarks().get(0).getMark() == null || irMatchPageInfo.getMarks().get(0).getMark().equals("")) {
                LogUtil.e("RemoteClient", "irmatch pageInfo error!");
                callBackOnIrMatchDone.onMatched(1, 0, null);
                return;
            }
            final LocalIrDb.PhysicalRemoteMatchResult physicalRemoteMatch = LocalIrDb.getIrDb(this.context).physicalRemoteMatch(irMatchPageInfo);
            if (!PhoneHelper.checkNet()) {
                callBackOnIrMatchDone.onMatched(0, physicalRemoteMatch.total_count, physicalRemoteMatch.ids);
            }
            this.client.doPost(str2, irMatchPageInfo, new bqm<String>() {
                /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass17 */

                public void onFailure(HttpException httpException, String str) {
                    LocalIrDb.PhysicalRemoteMatchResult physicalRemoteMatchResult = physicalRemoteMatch;
                    if (physicalRemoteMatchResult != null) {
                        callBackOnIrMatchDone.onMatched(0, physicalRemoteMatchResult.total_count, physicalRemoteMatch.ids);
                    } else {
                        callBackOnIrMatchDone.onMatched(1, 0, null);
                    }
                }

                public void onSuccess(bqi<String> bqi) {
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null) {
                        LocalIrDb.PhysicalRemoteMatchResult physicalRemoteMatchResult = physicalRemoteMatch;
                        if (physicalRemoteMatchResult != null) {
                            callBackOnIrMatchDone.onMatched(0, physicalRemoteMatchResult.total_count, physicalRemoteMatch.ids);
                        } else {
                            callBackOnIrMatchDone.onMatched(1, 0, null);
                        }
                    } else {
                        TQResponse tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class);
                        if (tQResponse == null) {
                            LogUtil.e("RemoteClient", "irmatch onFailure..######..........response = ".concat(String.valueOf(bqi)));
                            LocalIrDb.PhysicalRemoteMatchResult physicalRemoteMatchResult2 = physicalRemoteMatch;
                            if (physicalRemoteMatchResult2 != null) {
                                callBackOnIrMatchDone.onMatched(0, physicalRemoteMatchResult2.total_count, physicalRemoteMatch.ids);
                            } else {
                                callBackOnIrMatchDone.onMatched(1, 0, null);
                            }
                        } else if (tQResponse.getErrcode() == 10000) {
                            List<String> list = (List) tQResponse.getData(new bdi<List<String>>() {
                                /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass17.AnonymousClass1 */
                            });
                            LocalIrDb.PhysicalRemoteMatchResult physicalRemoteMatchResult3 = physicalRemoteMatch;
                            if (physicalRemoteMatchResult3 != null && physicalRemoteMatchResult3.ids != null) {
                                if (list != null) {
                                    for (String str : list) {
                                        if (str != null && !str.equals("") && !physicalRemoteMatch.ids.contains(str)) {
                                            physicalRemoteMatch.ids.add(str);
                                        }
                                    }
                                }
                                callBackOnIrMatchDone.onMatched(0, physicalRemoteMatch.ids.size(), physicalRemoteMatch.ids);
                            } else if (list != null) {
                                callBackOnIrMatchDone.onMatched(0, list.size(), list);
                            } else {
                                callBackOnIrMatchDone.onMatched(1, 0, null);
                            }
                        } else {
                            LocalIrDb.PhysicalRemoteMatchResult physicalRemoteMatchResult4 = physicalRemoteMatch;
                            if (physicalRemoteMatchResult4 != null) {
                                callBackOnIrMatchDone.onMatched(0, physicalRemoteMatchResult4.total_count, physicalRemoteMatch.ids);
                            } else {
                                callBackOnIrMatchDone.onMatched(1, 0, null);
                            }
                        }
                    }
                }
            });
        }
    }

    public List<Brand> getBrandByType(int i, String str) {
        int lang = LanguageUtils.getLang();
        bpx bpx = new bpx();
        switch (i) {
            case 1:
                bpx.O00000Oo("remarks", "like", "%tv%");
                break;
            case 2:
                bpx.O00000Oo("remarks", "like", "%air%");
                break;
            case 3:
                bpx.O00000Oo("remarks", "like", "%fan%");
                break;
            case 4:
                bpx.O00000Oo("remarks", "like", "%pjt%");
                break;
            case 5:
                bpx.O00000Oo("remarks", "like", "%stb%");
                break;
            case 6:
                bpx.O00000Oo("remarks", "like", "%dvd%").O00000o0("remarks", "like", "%dc%").O00000o0("remarks", "like", "%cd%").O00000o0("remarks", "like", "%cs%").O00000o0("remarks", "like", "%dv%");
                break;
            case 7:
                bpx.O00000Oo("remarks", "like", "%cam%");
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                bpx.O00000Oo("remarks", "like", "%light%");
                break;
            case 9:
                bpx.O00000Oo("remarks", "like", "%amp%");
                break;
            case 10:
                bpx.O00000Oo("remarks", "like", "%ipt%");
                break;
            case 11:
                bpx.O00000Oo("remarks", "like", "%box%");
                break;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                bpx.O00000Oo("remarks", "like", "%rsq%");
                break;
            case 13:
                bpx.O00000Oo("remarks", "like", "%jhq%");
                break;
        }
        String str2 = "pinyin";
        if (lang == 0) {
            bpx.O00000Oo("brand_cn", "!=", "").O00000Oo("brand_cn", "!=", null);
        } else if (lang != 1) {
            if (lang != 2) {
                bpx.O00000Oo("brand_en", "!=", "").O00000Oo("brand_en", "!=", null);
            } else {
                bpx.O00000Oo("brand_en", "!=", "").O00000Oo("brand_en", "!=", null);
            }
            str2 = "brand_en";
        } else {
            bpx.O00000Oo("brand_tw", "!=", "").O00000Oo("brand_tw", "!=", null);
        }
        bpu O000000o2 = bpu.O000000o(Brand.class);
        O000000o2.O000000o(bpx);
        if (str != null && !str.equals("")) {
            bpx O000000o3 = bpx.O000000o("brand_cn", "like", "%" + str + "%");
            bpx O00000o0 = O000000o3.O00000o0("brand_tw", "like", "%" + str + "%");
            bpx O00000o02 = O00000o0.O00000o0("brand_ja", "like", "%" + str + "%");
            bpx O00000o03 = O00000o02.O00000o0("brand_en", "like", "%" + str + "%");
            O000000o2.O00000Oo(O00000o03.O00000o0("brand_other", "like", "%" + str + "%"));
        }
        O000000o2.O000000o("upper(" + str2 + ")");
        return DataBaseManager.getInstance().getAllRecords(O000000o2);
    }

    public List<Brand> getBrandByIds(List<Long> list, String str) {
        List<Long> list2 = list;
        String str2 = str;
        String str3 = null;
        if (list2 == null || list.size() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SELECT * FROM tb_brand WHERE id in ");
        stringBuffer.append("(");
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append(list2.get(i));
            if (i != list.size() - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(")");
        if (str2 != null && !str2.equals("")) {
            String O000000o2 = dea.O000000o(str);
            if (!O000000o2.equalsIgnoreCase(str2)) {
                str3 = O000000o2;
            }
            String str4 = "'%" + str2.replaceAll("'", "''").replaceAll("%", "/%").replaceAll("_", "/_").replaceAll("/", "//") + "%' ESCAPE '/'";
            StringBuilder sb = new StringBuilder(" AND (brand_cn like ");
            sb.append(str4);
            sb.append(" OR brand_tw like ");
            sb.append(str4);
            String str5 = ")";
            sb.append(" OR brand_en like ");
            sb.append(str4);
            String str6 = " OR brand_en like ";
            sb.append(" OR brand_other like ");
            sb.append(str4);
            sb.append(" OR pinyin like ");
            sb.append(str4);
            stringBuffer.append(sb.toString());
            if (str3 != null) {
                String str7 = "'%" + str3.replaceAll("'", "''").replaceAll("%", "/%").replaceAll("_", "/_").replaceAll("/", "//") + "%' ESCAPE '/'";
                stringBuffer.append(" OR brand_cn like " + str7 + " OR brand_tw like " + str7 + str6 + str7 + " OR brand_other like " + str7 + " OR pinyin like " + str7);
            }
            stringBuffer.append(str5);
        }
        stringBuffer.append(" ORDER BY upper(pinyin) ASC");
        Cursor execQuery = DataBaseManager.getInstance().execQuery(stringBuffer.toString());
        ArrayList arrayList = new ArrayList();
        if (execQuery != null && execQuery.getCount() > 0) {
            while (execQuery.moveToNext()) {
                Brand brand = new Brand();
                brand.setBrand_cn(execQuery.getString(execQuery.getColumnIndex("brand_cn")));
                brand.setBrand_en(execQuery.getString(execQuery.getColumnIndex("brand_en")));
                brand.setBrand_other(execQuery.getString(execQuery.getColumnIndex("brand_other")));
                brand.setBrand_tw(execQuery.getString(execQuery.getColumnIndex("brand_tw")));
                brand.setId(execQuery.getLong(execQuery.getColumnIndex("id")));
                brand.setPinyin(execQuery.getString(execQuery.getColumnIndex("pinyin")));
                brand.setPy(execQuery.getString(execQuery.getColumnIndex("py")));
                brand.setRemarks(execQuery.getString(execQuery.getColumnIndex("remarks")));
                arrayList.add(brand);
            }
        }
        execQuery.close();
        return arrayList;
    }

    public void getDataBrands(int i, int i2, String str, IRemoteClient.CallbackOnBrandLoaded callbackOnBrandLoaded) {
        List<Brand> brandListOfMachineType;
        String str2 = String.valueOf(BASE_REMOTE_URL) + "/search_data_brand";
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", Integer.valueOf(i));
        jSONObject.put("flag", Integer.valueOf(i2));
        String O000000o2 = jbq.O000000o(this.context).O000000o(String.valueOf(i) + "&" + i2);
        if (O000000o2 != null) {
            try {
                callbackOnBrandLoaded.onBrandLoaded(0, getBrandByIds((List) bdf.O000000o(O000000o2, new bdi<List<Long>>() {
                    /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass18 */
                }, new Feature[0]), str));
                return;
            } catch (Exception unused) {
            }
        }
        if (i == 2 && (brandListOfMachineType = LocalIrDb.getIrDb(this.context).getBrandListOfMachineType(i, i2)) != null) {
            callbackOnBrandLoaded.onBrandLoaded(0, getBrandByIds(cacheIdsAndSaveBrands(brandListOfMachineType, i, i2), str));
        } else if (!PhoneHelper.checkNet()) {
            List<Brand> brandListOfMachineType2 = LocalIrDb.getIrDb(this.context).getBrandListOfMachineType(i, i2);
            if (brandListOfMachineType2 != null) {
                callbackOnBrandLoaded.onBrandLoaded(0, getBrandByIds(getIdsAndSaveBrands(brandListOfMachineType2), str));
            } else {
                callbackOnBrandLoaded.onBrandLoaded(1, null);
            }
        } else {
            final int i3 = i;
            final int i4 = i2;
            final String str3 = str;
            final IRemoteClient.CallbackOnBrandLoaded callbackOnBrandLoaded2 = callbackOnBrandLoaded;
            this.client.doPost(str2, jSONObject, new bqm<String>() {
                /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass19 */

                public void onFailure(HttpException httpException, String str) {
                    List<Brand> brandListOfMachineType = LocalIrDb.getIrDb(RemoteClient.this.context).getBrandListOfMachineType(i3, i4);
                    if (brandListOfMachineType != null) {
                        callbackOnBrandLoaded2.onBrandLoaded(0, RemoteClient.this.getBrandByIds(RemoteClient.this.getIdsAndSaveBrands(brandListOfMachineType), str3));
                        return;
                    }
                    callbackOnBrandLoaded2.onBrandLoaded(1, null);
                }

                public void onSuccess(bqi<String> bqi) {
                    TQResponse tQResponse;
                    if (bqi.O00000o != 200 || bqi.f13200O000000o == null || (tQResponse = (TQResponse) Utils.JsonParseObject((String) bqi.f13200O000000o, TQResponse.class)) == null || tQResponse.getErrcode() != 10000) {
                        callbackOnBrandLoaded2.onBrandLoaded(1, null);
                        return;
                    }
                    List list = (List) tQResponse.getData(new bdi<List<Brand>>() {
                        /* class com.tiqiaa.client.impl.RemoteClient.AnonymousClass19.AnonymousClass1 */
                    });
                    if (list == null) {
                        list = new ArrayList();
                    }
                    List<Brand> brandListOfMachineType = LocalIrDb.getIrDb(RemoteClient.this.context).getBrandListOfMachineType(i3, i4);
                    if (brandListOfMachineType != null && brandListOfMachineType.size() > 0) {
                        for (Brand next : brandListOfMachineType) {
                            if (!list.contains(next)) {
                                list.add(next);
                            }
                        }
                    }
                    callbackOnBrandLoaded2.onBrandLoaded(0, RemoteClient.this.getBrandByIds(RemoteClient.this.cacheIdsAndSaveBrands(list, i3, i4), str3));
                }
            });
        }
    }

    public List<Long> getIdsAndSaveBrands(List<Brand> list) {
        return cacheIdsAndSaveBrands(list, 0, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0086 A[SYNTHETIC, Splitter:B:27:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0099 A[SYNTHETIC, Splitter:B:33:0x0099] */
    public List<Long> cacheIdsAndSaveBrands(List<Brand> list, int i, int i2) {
        BufferedWriter bufferedWriter = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Brand next : list) {
            arrayList.add(Long.valueOf(next.getId()));
            if (next.getPinyin() == null || dea.O00000Oo(next.getPinyin())) {
                next.setPinyin(dea.O000000o(next.getBrand_cn()));
            }
        }
        DataBaseManager.getInstance().saveOrUpdataAll(list);
        if (i > 0 && i2 > 0) {
            jbq O000000o2 = jbq.O000000o(this.context);
            String str = i + "&" + i2;
            String str2 = String.valueOf(jbq.O00000Oo.O000000o(604800)) + bdf.O000000o(arrayList);
            File O00000Oo = O000000o2.f1741O000000o.O00000Oo(str);
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(O00000Oo), 1024);
                try {
                    bufferedWriter2.write(str2);
                    try {
                        bufferedWriter2.flush();
                        bufferedWriter2.close();
                    } catch (IOException e) {
                        e = e;
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    try {
                        e.printStackTrace();
                        if (bufferedWriter != null) {
                        }
                        O000000o2.f1741O000000o.O000000o(O00000Oo);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.flush();
                                bufferedWriter.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        O000000o2.f1741O000000o.O000000o(O00000Oo);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                    }
                    O000000o2.f1741O000000o.O000000o(O00000Oo);
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (IOException e5) {
                        e = e5;
                    }
                }
                O000000o2.f1741O000000o.O000000o(O00000Oo);
                return arrayList;
            }
            O000000o2.f1741O000000o.O000000o(O00000Oo);
        }
        return arrayList;
        e.printStackTrace();
        O000000o2.f1741O000000o.O000000o(O00000Oo);
        return arrayList;
    }
}
