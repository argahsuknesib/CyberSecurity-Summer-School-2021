package com.xiaomi.smarthome.shop.activity;

import _m_j.ft;
import _m_j.gqg;
import _m_j.gsy;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.shop.share.ShareObject;
import java.io.File;
import java.util.UUID;

public class DeviceShopWeiboShareActivity extends DeviceShopBaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    static final String f11387O000000o = "DeviceShopWeiboShareActivity";
    private WbShareHandler O00000Oo;
    private boolean O00000o;
    private boolean O00000o0 = false;
    private String O00000oO;
    private ShareObject O00000oo;

    public void onCreate(Bundle bundle) {
        String str = "";
        super.onCreate(bundle);
        this.O00000oo = (ShareObject) getIntent().getParcelableExtra("share");
        this.O00000o = getIntent().getBooleanExtra("extra_handle_result", true);
        this.O00000oO = getIntent().getStringExtra("caller");
        this.O00000Oo = new WbShareHandler(this);
        this.O00000Oo.registerApp();
        try {
            WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
            TextObject textObject = new TextObject();
            if (TextUtils.equals(this.O00000oo.O00000o0, this.O00000oo.f11389O000000o)) {
                textObject.text = this.O00000oo.O00000o0;
            } else {
                textObject.text = "#" + this.O00000oo.f11389O000000o + "#" + this.O00000oo.O00000o0;
            }
            weiboMultiMessage.textObject = textObject;
            if (this.O00000oo.O00000oo != null) {
                ImageObject imageObject = new ImageObject();
                imageObject.setImageObject(decodeBitmapFile(this.O00000oo.O00000oo));
                weiboMultiMessage.imageObject = imageObject;
            }
            if (this.O00000oo.O00000oO != null) {
                Bitmap decodeBitmapFile = decodeBitmapFile(this.O00000oo.O00000oO);
                WebpageObject webpageObject = new WebpageObject();
                webpageObject.identify = UUID.randomUUID().toString().replace("-", str);
                if (weiboMultiMessage.imageObject == null) {
                    str = this.O00000oo.f11389O000000o;
                }
                webpageObject.title = str;
                webpageObject.setThumbImage(decodeBitmapFile);
                webpageObject.description = this.O00000oo.O00000Oo;
                webpageObject.actionUrl = this.O00000oo.O00000o;
                webpageObject.defaultText = this.O00000oo.O00000Oo;
                weiboMultiMessage.mediaObject = webpageObject;
            }
            this.O00000Oo.shareMessage(weiboMultiMessage, true);
        } catch (OutOfMemoryError unused) {
            gsy.O000000o(5, f11387O000000o, "bitmap decode failed!");
        } catch (Exception unused2) {
        }
    }

    public Bitmap decodeBitmapFile(Uri uri) throws OutOfMemoryError {
        if (uri == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeFile(new File(uri.getPath()).getAbsolutePath(), options);
    }

    public void onResume() {
        super.onResume();
        if (this.O00000o0) {
            finish();
        } else {
            this.O00000o0 = true;
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        gsy.O000000o(LogType.GENERAL, f11387O000000o, "onNewIntent");
        WbShareHandler wbShareHandler = this.O00000Oo;
        if (wbShareHandler != null) {
            wbShareHandler.doResultIntent(intent, new WbShareCallback() {
                /* class com.xiaomi.smarthome.shop.activity.DeviceShopWeiboShareActivity.AnonymousClass1 */

                public final void onWbShareSuccess() {
                    gqg.O00000Oo((int) R.string.device_shop_share_success);
                    DeviceShopWeiboShareActivity.this.notifyResult("com.xiaomi.smarthome.action.SHARE_RESULT", 0, "", null);
                    DeviceShopWeiboShareActivity.this.finish();
                }

                public final void onWbShareCancel() {
                    gqg.O00000Oo((int) R.string.device_shop_share_cancel);
                    DeviceShopWeiboShareActivity.this.notifyResult("com.xiaomi.smarthome.action.SHARE_RESULT", -100, "cancel", null);
                    DeviceShopWeiboShareActivity.this.finish();
                }

                public final void onWbShareFail() {
                    gqg.O00000Oo((int) R.string.device_shop_share_failure);
                    DeviceShopWeiboShareActivity.this.notifyResult("com.xiaomi.smarthome.action.SHARE_RESULT", -1, "", null);
                    DeviceShopWeiboShareActivity.this.finish();
                }
            });
        }
    }

    public void notifyResult(String str, int i, String str2, Bundle bundle) {
        ft O000000o2 = ft.O000000o(getApplicationContext());
        Intent intent = new Intent(str);
        intent.putExtra("result_code", i == 0 ? 0 : 2);
        intent.putExtra("message", str2);
        intent.putExtra("extras", bundle);
        O000000o2.O000000o(intent);
    }
}
