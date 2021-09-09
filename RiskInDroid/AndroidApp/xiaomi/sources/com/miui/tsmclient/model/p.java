package com.miui.tsmclient.model;

import android.content.Context;
import com.miui.tsmclient.entity.UserExceptionLogInfo;
import com.miui.tsmclient.model.e.f;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.seitsm.a.a;
import com.miui.tsmclient.util.LogUtils;
import java.io.IOException;
import java.util.concurrent.Callable;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class p extends BaseModel {
    public static p a(Context context) {
        p pVar = new p();
        pVar.init(context, null);
        return pVar;
    }

    public void a(final UserExceptionLogInfo userExceptionLogInfo) {
        if (userExceptionLogInfo == null) {
            LogUtils.e("uploadUserExceptionLog failed. userLogInfo is null");
        } else {
            Observable.fromCallable(new Callable<BaseResponse>() {
                /* class com.miui.tsmclient.model.p.AnonymousClass1 */

                /* renamed from: a */
                public BaseResponse call() throws IOException, a {
                    TsmRpcModels.CommonResponse a2 = new com.miui.tsmclient.seitsm.a().a(p.this.getContext(), userExceptionLogInfo);
                    BaseResponse baseResponse = new BaseResponse(-1, new Object[0]);
                    if (a2 != null) {
                        baseResponse.mResultCode = f.a(a2.getResult());
                        baseResponse.mMsg = a2.getErrorDesc();
                    }
                    return baseResponse;
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new Subscriber<BaseResponse>() {
                /* class com.miui.tsmclient.model.p.AnonymousClass2 */

                /* renamed from: a */
                public void onNext(BaseResponse baseResponse) {
                    LogUtils.d("uploadUserExceptionLog errorCode:" + baseResponse.mResultCode + ", errorMsg:" + baseResponse.mMsg);
                }

                public void onCompleted() {
                    LogUtils.d("uploadUserExceptionLog onCompleted called.");
                }

                public void onError(Throwable th) {
                    LogUtils.e("uploadUserExceptionLog failed with an io exception.", th);
                }
            });
        }
    }
}
