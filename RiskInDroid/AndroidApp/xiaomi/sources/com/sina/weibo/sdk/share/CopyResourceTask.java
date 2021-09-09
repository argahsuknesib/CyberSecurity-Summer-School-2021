package com.sina.weibo.sdk.share;

import _m_j.dbm;
import _m_j.dbr;
import _m_j.dbs;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.WbAppInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class CopyResourceTask extends AsyncTask<WeiboMultiMessage, Object, TransResourceResult> {
    private TransResourceCallback mCallback;
    private WeakReference<Context> mReference;

    public CopyResourceTask(Context context, TransResourceCallback transResourceCallback) {
        this.mReference = new WeakReference<>(context);
        this.mCallback = transResourceCallback;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
    }

    /* access modifiers changed from: protected */
    public TransResourceResult doInBackground(WeiboMultiMessage... weiboMultiMessageArr) {
        Uri uri;
        Context context = this.mReference.get();
        if (context == null) {
            return null;
        }
        WeiboMultiMessage weiboMultiMessage = weiboMultiMessageArr[0];
        TransResourceResult transResourceResult = new TransResourceResult();
        try {
            if (WbSdk.isWbInstall(context)) {
                WbAppInfo O00000Oo = dbm.O00000Oo(context);
                if (O00000Oo == null || O00000Oo.getSupportVersion() < 10772) {
                    weiboMultiMessage.multiImageObject = null;
                    weiboMultiMessage.videoSourceObject = null;
                } else {
                    if (!(weiboMultiMessage.imageObject == null || weiboMultiMessage.multiImageObject == null)) {
                        weiboMultiMessage.imageObject = null;
                    }
                    if (!(weiboMultiMessage.videoSourceObject == null || (weiboMultiMessage.multiImageObject == null && weiboMultiMessage.imageObject == null))) {
                        weiboMultiMessage.multiImageObject = null;
                        weiboMultiMessage.imageObject = null;
                    }
                }
                if (weiboMultiMessage.multiImageObject != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Uri> it = weiboMultiMessage.multiImageObject.getImageList().iterator();
                    while (it.hasNext()) {
                        Uri next = it.next();
                        if (next != null && dbr.O000000o(context, next)) {
                            String copyFileToWeiboTem = ShareUtils.copyFileToWeiboTem(context, next, 1);
                            if (!TextUtils.isEmpty(copyFileToWeiboTem)) {
                                arrayList.add(Uri.fromFile(new File(copyFileToWeiboTem)));
                            }
                        }
                    }
                    weiboMultiMessage.multiImageObject.setImageList(arrayList);
                }
                if (!(weiboMultiMessage.videoSourceObject == null || (uri = weiboMultiMessage.videoSourceObject.videoPath) == null || !dbr.O00000Oo(context, uri))) {
                    String copyFileToWeiboTem2 = ShareUtils.copyFileToWeiboTem(context, uri, 0);
                    weiboMultiMessage.videoSourceObject.videoPath = Uri.fromFile(new File(copyFileToWeiboTem2));
                    weiboMultiMessage.videoSourceObject.during = dbs.O000000o(copyFileToWeiboTem2);
                }
            }
            transResourceResult.message = weiboMultiMessage;
            transResourceResult.transDone = true;
        } catch (Exception unused) {
            transResourceResult.transDone = false;
        }
        return transResourceResult;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(TransResourceResult transResourceResult) {
        super.onPostExecute((Object) transResourceResult);
        TransResourceCallback transResourceCallback = this.mCallback;
        if (transResourceCallback != null) {
            transResourceCallback.onTransFinish(transResourceResult);
        }
    }
}
