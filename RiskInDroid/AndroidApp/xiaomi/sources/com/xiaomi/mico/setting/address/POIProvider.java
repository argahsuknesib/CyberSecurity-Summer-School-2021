package com.xiaomi.mico.setting.address;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.sdu.didi.openapi.DIOpenSDK;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public enum POIProvider implements IPOIProvider {
    BAIDU {
        public final Observable<List<POIInfoWrapper>> search(Context context, final String str, final String str2) {
            return Observable.unsafeCreate(new Observable.OnSubscribe<List<ThirdPartyResponse.POIResponse>>() {
                /* class com.xiaomi.mico.setting.address.POIProvider.AnonymousClass1.AnonymousClass1 */

                public /* bridge */ /* synthetic */ void call(Object obj) {
                    call((Subscriber<? super List<ThirdPartyResponse.POIResponse>>) ((Subscriber) obj));
                }

                public void call(final Subscriber<? super List<ThirdPartyResponse.POIResponse>> subscriber) {
                    ApiHelper.getPOISuggest(str2, str, new ApiRequest.Listener<List<ThirdPartyResponse.POIResponse>>() {
                        /* class com.xiaomi.mico.setting.address.POIProvider.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                            onSuccess((List<ThirdPartyResponse.POIResponse>) ((List) obj));
                        }

                        public void onSuccess(List<ThirdPartyResponse.POIResponse> list) {
                            subscriber.onNext(list);
                            subscriber.onCompleted();
                        }

                        public void onFailure(ApiError apiError) {
                            subscriber.onNext(null);
                            subscriber.onCompleted();
                        }
                    });
                }
            }).map($$Lambda$POIProvider$1$spvChSNrMnxTfzrP8GgkTxl5Cl8.INSTANCE);
        }

        static /* synthetic */ List lambda$search$0(List list) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new BaiduPOIInfoWrapper((ThirdPartyResponse.POIResponse) it.next()));
            }
            return arrayList;
        }

        public final POIInfoWrapper getWrapper(Serializable serializable) {
            return new BaiduPOIInfoWrapper((ThirdPartyResponse.POIResponse) serializable);
        }
    },
    DIDI {
        public final Observable<List<POIInfoWrapper>> search(final Context context, final String str, final String str2) {
            return Observable.unsafeCreate(new Observable.OnSubscribe<List<ThirdPartyResponse.DidiPOIResponse>>() {
                /* class com.xiaomi.mico.setting.address.POIProvider.AnonymousClass2.AnonymousClass2 */

                public /* bridge */ /* synthetic */ void call(Object obj) {
                    call((Subscriber<? super List<ThirdPartyResponse.DidiPOIResponse>>) ((Subscriber) obj));
                }

                public void call(final Subscriber<? super List<ThirdPartyResponse.DidiPOIResponse>> subscriber) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("city", str);
                    hashMap.put("sug", str2);
                    DIOpenSDK.asynCallDDApi(context, "getPoi", hashMap, new DIOpenSDK.DDCallBack() {
                        /* class com.xiaomi.mico.setting.address.POIProvider.AnonymousClass2.AnonymousClass2.AnonymousClass1 */

                        public void onFinish(Map<String, String> map) {
                            new Object[1][0] = map;
                            if (Integer.valueOf(map.get("errno")).intValue() > 0) {
                                subscriber.onNext(new ArrayList());
                                subscriber.onCompleted();
                                return;
                            }
                            int size = map.keySet().size() - 2;
                            ArrayList arrayList = new ArrayList(size);
                            Gson gson = new Gson();
                            for (int i = 1; i <= size; i++) {
                                ThirdPartyResponse.DidiPOIResponse didiPOIResponse = (ThirdPartyResponse.DidiPOIResponse) gson.fromJson(map.get(String.valueOf(i)), ThirdPartyResponse.DidiPOIResponse.class);
                                didiPOIResponse.city = str;
                                arrayList.add(didiPOIResponse);
                            }
                            subscriber.onNext(arrayList);
                            subscriber.onCompleted();
                        }
                    });
                }
            }).map(new Func1<List<ThirdPartyResponse.DidiPOIResponse>, List<POIInfoWrapper>>() {
                /* class com.xiaomi.mico.setting.address.POIProvider.AnonymousClass2.AnonymousClass1 */

                public /* bridge */ /* synthetic */ Object call(Object obj) {
                    return call((List<ThirdPartyResponse.DidiPOIResponse>) ((List) obj));
                }

                public List<POIInfoWrapper> call(List<ThirdPartyResponse.DidiPOIResponse> list) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (ThirdPartyResponse.DidiPOIResponse didiPOIInfoWrapper : list) {
                        arrayList.add(new DidiPOIInfoWrapper(didiPOIInfoWrapper));
                    }
                    return arrayList;
                }
            });
        }

        public final POIInfoWrapper getWrapper(Serializable serializable) {
            return new DidiPOIInfoWrapper((ThirdPartyResponse.DidiPOIResponse) serializable);
        }
    };

    static class BaiduPOIInfoWrapper implements POIInfoWrapper {
        private final ThirdPartyResponse.POIResponse mPOIInfo;

        public BaiduPOIInfoWrapper(ThirdPartyResponse.POIResponse pOIResponse) {
            this.mPOIInfo = pOIResponse;
        }

        public Serializable getOrigin() {
            return this.mPOIInfo;
        }

        public String getDisplayAddress() {
            if (TextUtils.isEmpty(this.mPOIInfo.district)) {
                return this.mPOIInfo.name;
            }
            return String.format("%s %s", this.mPOIInfo.district, this.mPOIInfo.name);
        }

        public String getCity() {
            return this.mPOIInfo.city;
        }

        public String getName() {
            return this.mPOIInfo.name;
        }

        public String getDesc() {
            return this.mPOIInfo.district;
        }
    }

    class DidiPOIInfoWrapper implements POIInfoWrapper {
        private final ThirdPartyResponse.DidiPOIResponse mPOIInfo;

        public DidiPOIInfoWrapper(ThirdPartyResponse.DidiPOIResponse didiPOIResponse) {
            this.mPOIInfo = didiPOIResponse;
        }

        public Serializable getOrigin() {
            return this.mPOIInfo;
        }

        public String getName() {
            return this.mPOIInfo.name;
        }

        public String getDesc() {
            return this.mPOIInfo.address;
        }

        public String getDisplayAddress() {
            return this.mPOIInfo.name;
        }

        public String getCity() {
            return this.mPOIInfo.city;
        }
    }
}
