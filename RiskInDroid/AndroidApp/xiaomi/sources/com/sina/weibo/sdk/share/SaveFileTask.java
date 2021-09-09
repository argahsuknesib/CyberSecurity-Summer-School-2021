package com.sina.weibo.sdk.share;

import _m_j.dbr;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
import java.lang.ref.WeakReference;

public class SaveFileTask extends AsyncTask<StoryMessage, Object, StoryObject> {
    private TransResourceCallback mCallback;
    private WeakReference<Context> mReference;

    public SaveFileTask(Context context, TransResourceCallback transResourceCallback) {
        this.mReference = new WeakReference<>(context);
        this.mCallback = transResourceCallback;
    }

    /* access modifiers changed from: protected */
    public StoryObject doInBackground(StoryMessage... storyMessageArr) {
        StoryMessage storyMessage = storyMessageArr[0];
        if (storyMessage == null) {
            return null;
        }
        Uri imageUri = storyMessage.getImageUri();
        Uri videoUri = storyMessage.getVideoUri();
        Context context = this.mReference.get();
        if (context == null) {
            return null;
        }
        if (imageUri != null && dbr.O000000o(context, imageUri)) {
            return copyFileToWeiboTem(context, imageUri, 1);
        }
        if (videoUri == null || !dbr.O00000Oo(context, videoUri)) {
            return null;
        }
        return copyFileToWeiboTem(context, videoUri, 0);
    }

    private StoryObject copyFileToWeiboTem(Context context, Uri uri, int i) {
        String copyFileToWeiboTem = ShareUtils.copyFileToWeiboTem(context, uri, i);
        if (TextUtils.isEmpty(copyFileToWeiboTem)) {
            return null;
        }
        StoryObject storyObject = new StoryObject();
        storyObject.sourcePath = copyFileToWeiboTem;
        storyObject.sourceType = i;
        storyObject.appId = WbSdk.getAuthInfo().getAppKey();
        storyObject.appPackage = context.getPackageName();
        return storyObject;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(StoryObject storyObject) {
        super.onPostExecute((Object) storyObject);
        TransResourceCallback transResourceCallback = this.mCallback;
        if (transResourceCallback != null) {
            transResourceCallback.onTransFinish(storyObject);
        }
    }
}
