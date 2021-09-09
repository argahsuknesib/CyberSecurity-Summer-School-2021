package com.xiaomi.smarthome.framework.plugin.mpk;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.gnn;
import _m_j.gof;
import _m_j.gor;
import _m_j.gsy;
import _m_j.izb;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.ByteArrayOutputStream;

public class SharesActivity extends BaseActivity {
    final String TAG = "SharesActivity";
    protected Context mContext;
    View mEmpty;
    boolean mFinishing;
    View mMainview = null;
    View mMainviewFrame = null;
    String mShareContent;
    String mShareImageUrl;
    String mShareThumbUrl;
    String mShareTitle;
    String mShareUrl;
    public Bitmap mThumb;
    boolean miliaoEnable = false;
    boolean sinaweiboEnable = false;
    ImageView weibo;
    ImageView weixin;
    boolean weixinEnable = false;
    IWXAPI wxapi;
    ImageView wxpyq;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        this.mFinishing = false;
        if (!checkValidate()) {
            izb.O000000o(this.mContext, (int) R.string.device_shop_share_no_app, 1).show();
            finish();
            return;
        }
        setContentView((int) R.layout.shares_activity);
        Intent intent = getIntent();
        this.mShareTitle = intent.getStringExtra("shareTitle");
        this.mShareContent = intent.getStringExtra("shareContent");
        this.mShareUrl = intent.getStringExtra("shareUrl");
        this.mShareImageUrl = intent.getStringExtra("shareImageUrl");
        this.mShareThumbUrl = intent.getStringExtra("shareThumbUrl");
        this.wxapi = CommonApplication.getSHIWXAPI();
        this.mMainviewFrame = findViewById(R.id.device_more_frame);
        this.mMainview = findViewById(R.id.device_more);
        this.mEmpty = findViewById(R.id.empty);
        this.mEmpty.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.SharesActivity.AnonymousClass1 */

            public void onClick(View view) {
                SharesActivity.this.onBackPressed();
            }
        });
        if (this.mThumb == null && !TextUtils.isEmpty(this.mShareThumbUrl)) {
            gor.O000000o(new AsyncTask<String, Void, Bitmap>() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.SharesActivity.AnonymousClass2 */
                XQProgressDialog dialog;

                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    this.dialog = XQProgressDialog.O000000o(SharesActivity.this.mContext, null, SharesActivity.this.mContext.getString(R.string.device_shop_dialog_loading));
                }

                /* access modifiers changed from: protected */
                public Bitmap doInBackground(String... strArr) {
                    Bitmap decodeByteArray;
                    String str = strArr[0];
                    Bitmap bitmap = null;
                    if (str == null) {
                        return null;
                    }
                    byte[] O000000o2 = gof.O000000o(str);
                    if (!(O000000o2 == null || (decodeByteArray = BitmapFactory.decodeByteArray(O000000o2, 0, O000000o2.length)) == null || (bitmap = Bitmap.createScaledBitmap(decodeByteArray, 150, 150, true)) == decodeByteArray)) {
                        decodeByteArray.recycle();
                    }
                    return bitmap;
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Bitmap bitmap) {
                    XQProgressDialog xQProgressDialog = this.dialog;
                    if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
                        this.dialog.dismiss();
                    }
                    SharesActivity sharesActivity = SharesActivity.this;
                    sharesActivity.mThumb = bitmap;
                    if (sharesActivity.mThumb == null) {
                        izb.O000000o(SharesActivity.this.mContext, (int) R.string.device_shop_share_download_pic_failed, 0).show();
                    }
                }
            }, this.mShareThumbUrl);
        }
        this.weixin = (ImageView) findViewById(R.id.wx_share);
        this.wxpyq = (ImageView) findViewById(R.id.friends_share);
        this.weibo = (ImageView) findViewById(R.id.weibo_share);
        this.weixin.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.SharesActivity.AnonymousClass3 */

            public void onClick(View view) {
                if (!SharesActivity.this.weixinEnable) {
                    izb.O000000o(SharesActivity.this.mContext, (int) R.string.device_shop_share_no_weixin, 1).show();
                    return;
                }
                WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXWebpageObject(SharesActivity.this.mShareUrl));
                wXMediaMessage.title = SharesActivity.this.mShareTitle;
                wXMediaMessage.description = SharesActivity.this.mShareContent;
                if (SharesActivity.this.mThumb != null) {
                    SharesActivity sharesActivity = SharesActivity.this;
                    wXMediaMessage.thumbData = sharesActivity.bmpToByteArray(sharesActivity.mThumb, false);
                }
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = String.valueOf(System.currentTimeMillis());
                req.message = wXMediaMessage;
                req.scene = 0;
                gsy.O000000o(LogType.GENERAL, "SharesActivity", "sendReq return ".concat(String.valueOf(SharesActivity.this.wxapi.sendReq(req))));
            }
        });
        this.wxpyq.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.SharesActivity.AnonymousClass4 */

            public void onClick(View view) {
                if (!SharesActivity.this.weixinEnable) {
                    izb.O000000o(SharesActivity.this.mContext, (int) R.string.device_shop_share_no_weixin, 1).show();
                    return;
                }
                WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXWebpageObject(SharesActivity.this.mShareUrl));
                wXMediaMessage.title = SharesActivity.this.mShareContent;
                wXMediaMessage.description = SharesActivity.this.mShareContent;
                if (SharesActivity.this.mThumb != null) {
                    SharesActivity sharesActivity = SharesActivity.this;
                    wXMediaMessage.thumbData = sharesActivity.bmpToByteArray(sharesActivity.mThumb, false);
                }
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = String.valueOf(System.currentTimeMillis());
                req.message = wXMediaMessage;
                req.scene = 1;
                gsy.O000000o(LogType.GENERAL, "SharesActivity", "sendReq return ".concat(String.valueOf(SharesActivity.this.wxapi.sendReq(req))));
            }
        });
        this.weibo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.SharesActivity.AnonymousClass5 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
             arg types: [java.lang.String, android.graphics.Bitmap]
             candidates:
              _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
              _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
            public void onClick(View view) {
                if (!SharesActivity.this.sinaweiboEnable) {
                    izb.O000000o(SharesActivity.this.mContext, (int) R.string.device_shop_share_no_weibo, 1).show();
                } else if (SharesActivity.this.mThumb != null) {
                    fbt fbt = new fbt(SharesActivity.this.mContext, "DeviceShopWeiboShareActivity");
                    fbt.O000000o("appid", "916875316");
                    fbt.O000000o("title", SharesActivity.this.mShareTitle);
                    fbt.O000000o("text", SharesActivity.this.mShareContent);
                    fbt.O000000o("url", SharesActivity.this.mShareUrl);
                    fbt.O000000o("imageUrl", SharesActivity.this.mShareImageUrl);
                    fbt.O000000o("thumb", (Parcelable) SharesActivity.this.mThumb);
                    fbs.O000000o(fbt);
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mThumb = null;
    }

    public void onBackPressed() {
        setResult(0);
        finishPage();
    }

    public void finishFinal() {
        this.mFinishing = true;
        finish();
        overridePendingTransition(0, 0);
    }

    private void finishPage() {
        this.mFinishing = true;
        if (gnn.f18048O000000o) {
            ObjectAnimator ofObject = ObjectAnimator.ofObject(this.mMainviewFrame, "backgroundColor", new ArgbEvaluator(), Integer.valueOf(getResources().getColor(R.color.mj_color_black_30_transparent)), Integer.valueOf(getResources().getColor(R.color.mj_color_black_00_transparent)));
            ofObject.setDuration(300L);
            ofObject.start();
        } else {
            this.mMainviewFrame.setBackgroundColor(getResources().getColor(R.color.mj_color_black_00_transparent));
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.SharesActivity.AnonymousClass6 */

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                SharesActivity.this.finishFinal();
            }
        });
        this.mMainview.startAnimation(loadAnimation);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.mFinishing) {
            if (gnn.f18048O000000o) {
                ObjectAnimator ofObject = ObjectAnimator.ofObject(this.mMainviewFrame, "backgroundColor", new ArgbEvaluator(), Integer.valueOf(getResources().getColor(R.color.mj_color_black_00_transparent)), Integer.valueOf(getResources().getColor(R.color.mj_color_black_30_transparent)));
                ofObject.setDuration(300L);
                ofObject.start();
            } else {
                this.mMainviewFrame.setBackgroundColor(getResources().getColor(R.color.mj_color_black_30_transparent));
            }
            this.mMainview.setVisibility(0);
            this.mMainview.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom));
        }
    }

    public byte[] bmpToByteArray(Bitmap bitmap, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 30, byteArrayOutputStream);
        if (z) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception unused) {
        }
        return byteArray;
    }

    private boolean checkValidate() {
        PackageInfo packageInfo;
        PackageInfo packageInfo2;
        PackageInfo packageInfo3 = null;
        try {
            packageInfo = this.mContext.getPackageManager().getPackageInfo("com.xiaomi.channel", 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            this.miliaoEnable = true;
        } else {
            this.miliaoEnable = false;
        }
        try {
            packageInfo2 = this.mContext.getPackageManager().getPackageInfo("com.tencent.mm", 0);
        } catch (PackageManager.NameNotFoundException unused2) {
            packageInfo2 = null;
        }
        if (packageInfo2 != null) {
            this.weixinEnable = true;
        } else {
            this.weixinEnable = false;
        }
        try {
            packageInfo3 = this.mContext.getPackageManager().getPackageInfo("com.sina.weibo", 0);
        } catch (PackageManager.NameNotFoundException unused3) {
        }
        if (packageInfo3 != null) {
            this.sinaweiboEnable = true;
        } else {
            this.sinaweiboEnable = false;
        }
        return this.miliaoEnable || this.weixinEnable || this.sinaweiboEnable;
    }
}
