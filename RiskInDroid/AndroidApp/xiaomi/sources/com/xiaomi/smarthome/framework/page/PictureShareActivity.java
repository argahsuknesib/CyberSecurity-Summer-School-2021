package com.xiaomi.smarthome.framework.page;

import _m_j.fro;
import _m_j.frp;
import _m_j.ftn;
import _m_j.gnn;
import _m_j.goy;
import _m_j.gpj;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.izb;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import butterknife.BindView;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PictureShareActivity extends BaseActivity {
    public static final String TAG = "PictureShareActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f7772O000000o;
    String O00000Oo;
    String O00000o;
    String O00000o0;
    Bitmap O00000oO;
    Bitmap O00000oo;
    boolean O0000O0o = false;
    View O0000OOo;
    View O0000Oo = null;
    View O0000Oo0 = null;
    boolean O0000OoO;
    private FrameLayout O0000Ooo;
    private TextView O0000o0;
    private TextView O0000o00;
    private TextView O0000o0O;
    private WbShareHandler O0000o0o;
    @BindView(4750)
    TextView friendsShare;
    @BindView(5340)
    TextView weiboShare;
    @BindView(5348)
    TextView wxShare;

    public static void share(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, PictureShareActivity.class);
        intent.putExtra("SharePicFile", str3);
        intent.putExtra("ShareTitle", str);
        intent.putExtra("ShareContent", str2);
        context.startActivity(intent);
    }

    public static void share(Activity activity, String str, String str2, String str3, int i) {
        Intent intent = new Intent(activity, PictureShareActivity.class);
        intent.putExtra("SharePicFile", str3);
        intent.putExtra("ShareTitle", str);
        intent.putExtra("ShareContent", str2);
        activity.startActivityForResult(intent, i);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7772O000000o = this;
        this.O0000OoO = false;
        overridePendingTransition(0, 0);
        this.O00000Oo = getIntent().getStringExtra("ShareTitle");
        this.O00000o0 = getIntent().getStringExtra("ShareContent");
        this.O00000o = getIntent().getStringExtra("SharePicFile");
        if (!TextUtils.isEmpty(this.O00000o)) {
            if (this.O00000o.endsWith(".mp4")) {
                this.O0000O0o = true;
            }
            if (!this.O0000O0o) {
                this.O00000oO = goy.O000000o(this.O00000o);
                Bitmap bitmap = this.O00000oO;
                if (bitmap == null) {
                    setResult(0);
                    finish();
                    return;
                }
                this.O00000oo = gpj.O000000o(bitmap);
            }
            this.f7772O000000o = this;
            setContentView((int) R.layout.picture_share_dialog);
            this.O0000Oo0 = findViewById(R.id.share_btn_container);
            this.O0000Oo = findViewById(R.id.root_container);
            this.O0000Ooo = (FrameLayout) findViewById(R.id.international_share_container);
            this.O0000o00 = (TextView) findViewById(R.id.facebook_share);
            this.O0000o0 = (TextView) findViewById(R.id.line_share);
            this.O0000o0O = (TextView) findViewById(R.id.whatsapp_share);
            this.O0000OOo = findViewById(R.id.empty);
            this.O0000OOo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.PictureShareActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    PictureShareActivity.this.onBackPressed();
                }
            });
            findViewById(R.id.wx_share).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.PictureShareActivity.AnonymousClass2 */

                public final void onClick(View view) {
                    PictureShareActivity.this.shareWeixin();
                    PictureShareActivity.this.O000000o();
                }
            });
            if (this.O0000O0o) {
                findViewById(R.id.friends_share).setVisibility(8);
            }
            findViewById(R.id.friends_share).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.PictureShareActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    PictureShareActivity.this.shareWeixinPyq();
                    PictureShareActivity.this.O000000o();
                }
            });
            if (this.O0000O0o) {
                findViewById(R.id.weibo_share).setVisibility(8);
            }
            findViewById(R.id.weibo_share).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.PictureShareActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    PictureShareActivity.this.shareWeibo();
                    PictureShareActivity.this.O000000o();
                }
            });
            this.O0000o00.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.PictureShareActivity.AnonymousClass5 */

                public final void onClick(View view) {
                    PictureShareActivity.this.shareFacebook();
                    PictureShareActivity.this.O000000o();
                }
            });
            this.O0000o0.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.PictureShareActivity.AnonymousClass6 */

                public final void onClick(View view) {
                    PictureShareActivity.this.shareLine();
                    PictureShareActivity.this.O000000o();
                }
            });
            this.O0000o0O.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.PictureShareActivity.AnonymousClass7 */

                public final void onClick(View view) {
                    PictureShareActivity.this.shareWhatsapp();
                    PictureShareActivity.this.O000000o();
                }
            });
            if (this.O0000O0o) {
                this.O0000o0.setVisibility(8);
            }
            this.O0000Oo0.setVisibility(8);
            this.O0000Ooo.setVisibility(8);
            return;
        }
        setResult(0);
        finish();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onBackPressed() {
        setResult(0);
        O00000Oo();
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        setResult(-1);
        O00000Oo();
        overridePendingTransition(0, 0);
    }

    public void finishFinal() {
        this.O0000OoO = true;
        finish();
        overridePendingTransition(0, 0);
    }

    private void O00000Oo() {
        this.O0000OoO = true;
        if (gnn.f18048O000000o) {
            ObjectAnimator ofObject = ObjectAnimator.ofObject(this.O0000Oo, "backgroundColor", new ArgbEvaluator(), Integer.valueOf(getResources().getColor(R.color.mj_color_black_30_transparent)), Integer.valueOf(getResources().getColor(R.color.mj_color_black_00_transparent)));
            ofObject.setDuration(300L);
            ofObject.start();
        } else {
            this.O0000Oo.setBackgroundColor(getResources().getColor(R.color.mj_color_black_00_transparent));
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.framework.page.PictureShareActivity.AnonymousClass8 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                PictureShareActivity.this.finishFinal();
            }
        });
        if (this.O0000Oo0.getVisibility() == 0) {
            this.O0000Oo0.startAnimation(loadAnimation);
        } else if (this.O0000Ooo.getVisibility() == 0) {
            this.O0000Ooo.startAnimation(loadAnimation);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.O0000OoO) {
            if (gnn.f18048O000000o) {
                ObjectAnimator ofObject = ObjectAnimator.ofObject(this.O0000Oo, "backgroundColor", new ArgbEvaluator(), Integer.valueOf(getResources().getColor(R.color.mj_color_black_00_transparent)), Integer.valueOf(getResources().getColor(R.color.mj_color_black_30_transparent)));
                ofObject.setDuration(300L);
                ofObject.start();
            } else {
                this.O0000Oo.setBackgroundColor(getResources().getColor(R.color.mj_color_black_30_transparent));
            }
            if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                this.O0000Oo0.setVisibility(8);
                this.O0000Ooo.setVisibility(0);
            } else {
                this.O0000Ooo.setVisibility(8);
                this.O0000o0o = new WbShareHandler(this);
                this.O0000Oo0.setVisibility(0);
            }
            if (this.O0000Oo0.getVisibility() == 0) {
                this.O0000Oo0.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom));
            } else {
                this.O0000Ooo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom));
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.O00000oO;
        if (bitmap != null) {
            bitmap.recycle();
            this.O00000oO = null;
        }
        Bitmap bitmap2 = this.O00000oo;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.O00000oo = null;
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        gsy.O000000o(LogType.GENERAL, TAG, "onNewIntent");
        WbShareHandler wbShareHandler = this.O0000o0o;
        if (wbShareHandler != null) {
            wbShareHandler.doResultIntent(intent, new WbShareCallback() {
                /* class com.xiaomi.smarthome.framework.page.PictureShareActivity.AnonymousClass9 */

                public final void onWbShareSuccess() {
                    gqg.O00000Oo((int) R.string.device_shop_share_success);
                    PictureShareActivity.this.O000000o();
                }

                public final void onWbShareCancel() {
                    gqg.O00000Oo((int) R.string.device_shop_share_cancel);
                    PictureShareActivity.this.O000000o();
                }

                public final void onWbShareFail() {
                    gqg.O00000Oo((int) R.string.device_shop_share_failure);
                    PictureShareActivity.this.O000000o();
                }
            });
        }
    }

    public boolean checkAppValidate(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = this.f7772O000000o.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    private boolean O00000o0() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo("jp.naver.line.android", 0);
            if (packageInfo == null) {
                return false;
            }
            String[] split = packageInfo.versionName.split("\\.");
            if (split.length <= 0 || Integer.parseInt(split[0]) >= 8) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void shareWhatsapp() {
        if (!checkAppValidate("com.whatsapp")) {
            izb.O000000o(this, getResources().getString(R.string.device_shop_share_no_whatsapp), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setPackage("com.whatsapp");
        try {
            if (this.O00000oO != null) {
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), this.O00000oO, (String) null, (String) null)));
                intent.setType("image/jpeg");
            } else if (this.O0000O0o) {
                Uri fromFile = Uri.fromFile(new File(this.O00000o));
                intent.setType("video/*");
                intent.putExtra("android.intent.extra.STREAM", fromFile);
            } else {
                return;
            }
            startActivity(Intent.createChooser(intent, "Share to"));
        } catch (Exception e) {
            e.printStackTrace();
            gqg.O00000Oo((int) R.string.common_unknown_error);
        }
    }

    public void shareLine() {
        ComponentName componentName;
        if (!checkAppValidate("jp.naver.line.android")) {
            izb.O000000o(this, getResources().getString(R.string.device_shop_share_no_line), 0).show();
            return;
        }
        if (O00000o0()) {
            componentName = new ComponentName("jp.naver.line.android", "jp.naver.line.android.activity.selectchat.SelectChatActivity");
        } else {
            componentName = new ComponentName("jp.naver.line.android", "jp.naver.line.android.activity.selectchat.SelectChatActivityLaunchActivity");
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        try {
            if (this.O00000oO != null) {
                intent.putExtra("android.intent.extra.STREAM", Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), this.O00000oO, (String) null, (String) null)));
                intent.setType("image/jpeg");
            } else if (this.O0000O0o) {
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.O00000o)));
                intent.setType("video/*");
            } else {
                return;
            }
            intent.setComponent(componentName);
            startActivity(Intent.createChooser(intent, ""));
        } catch (Exception e) {
            e.printStackTrace();
            gqg.O00000Oo((int) R.string.common_unknown_error);
        }
    }

    public void shareFacebook() {
        if (!checkAppValidate("com.facebook.katana")) {
            izb.O000000o(this, getResources().getString(R.string.device_shop_share_no_facebook), 0).show();
            return;
        }
        frp O000000o2 = fro.O000000o();
        if (O000000o2 != null) {
            O000000o2.shareFacebook(this, this.O00000oO, this.O0000O0o, this.O00000o, "");
        }
    }

    public void shareWeixin() {
        if (!checkAppValidate("com.tencent.mm")) {
            izb.O000000o(this.f7772O000000o, (int) R.string.device_shop_share_no_weixin, 1).show();
        } else if (this.O0000O0o) {
            share(new String[]{"com.tencent.mm.ui.tools.ShareImgUI"}, new String[]{this.O00000o}, this.O00000Oo, this.O00000o0);
        } else {
            IWXAPI shiwxapi = CommonApplication.getSHIWXAPI();
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.title = this.O00000Oo;
            wXMediaMessage.description = this.O00000o0;
            wXMediaMessage.setThumbImage(this.O00000oo);
            if (this.O00000oO != null) {
                wXMediaMessage.mediaObject = new WXImageObject(O00000o());
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = String.valueOf(System.currentTimeMillis());
            req.message = wXMediaMessage;
            req.scene = 0;
            gsy.O000000o(LogType.GENERAL, TAG, "sendReq return ".concat(String.valueOf(shiwxapi.sendReq(req))));
        }
    }

    private byte[] O00000o() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.O00000oO.compress(Bitmap.CompressFormat.JPEG, 81, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void shareWeixinPyq() {
        if (!this.O0000O0o) {
            if (!checkAppValidate("com.tencent.mm")) {
                izb.O000000o(this.f7772O000000o, (int) R.string.device_shop_share_no_weixin, 1).show();
                return;
            }
            IWXAPI shiwxapi = CommonApplication.getSHIWXAPI();
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.title = this.O00000Oo;
            wXMediaMessage.description = this.O00000o0;
            wXMediaMessage.setThumbImage(this.O00000oo);
            if (this.O00000oO != null) {
                wXMediaMessage.mediaObject = new WXImageObject(O00000o());
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = String.valueOf(System.currentTimeMillis());
            req.message = wXMediaMessage;
            req.scene = 1;
            gsy.O000000o(LogType.GENERAL, TAG, "sendReq return ".concat(String.valueOf(shiwxapi.sendReq(req))));
        }
    }

    public void shareWeibo() {
        if (!this.O0000O0o) {
            if (this.O0000o0o == null || !checkAppValidate("com.sina.weibo")) {
                izb.O000000o(this.f7772O000000o, (int) R.string.device_shop_share_no_weibo, 1).show();
                return;
            }
            share(new String[]{"com.sina.weibo.EditActivity", "com.sina.weibo.ComposerDispatchActivity", "com.sina.weibo.composerinde.ComposerDispatchActivity"}, new String[]{this.O00000o}, this.O00000Oo, this.O00000o0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c  */
    public void share(String[] strArr, String[] strArr2, String str, String str2) {
        Intent intent;
        if (strArr != null && strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            String str3 = strArr2.length > 1 ? "android.intent.action.SEND_MULTIPLE" : "android.intent.action.SEND";
            boolean z = this.O0000O0o;
            Intent intent2 = new Intent();
            String str4 = z ? "video/*" : "image/*";
            intent2.setAction(str3).setType(str4);
            int i = 0;
            List<ResolveInfo> queryIntentActivities = getContext().getPackageManager().queryIntentActivities(intent2, 0);
            if (!queryIntentActivities.isEmpty()) {
                Iterator<ResolveInfo> it = queryIntentActivities.iterator();
                loop0:
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ResolveInfo next = it.next();
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            if (next.activityInfo.name.contains(strArr[i2])) {
                                intent = new Intent(str3);
                                intent.setType(str4);
                                intent.setClassName(next.activityInfo.packageName, next.activityInfo.name);
                                intent.addFlags(268435457);
                                break loop0;
                            }
                            i2++;
                        }
                    }
                }
                if (intent != null) {
                    izb.O000000o(getContext(), (int) R.string.mj_share_score_share_no_install, 0).show();
                    return;
                }
                if (!TextUtils.isEmpty(this.O00000Oo)) {
                    intent.putExtra("android.intent.extra.SUBJECT", str);
                }
                if (!TextUtils.isEmpty(this.O00000o0)) {
                    intent.putExtra("android.intent.extra.TEXT", str2);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    String str5 = getApplicationContext().getPackageName() + ".provider";
                    try {
                        if (strArr2.length > 1) {
                            ArrayList arrayList = new ArrayList();
                            int length2 = strArr2.length;
                            while (i < length2) {
                                arrayList.add(FileProvider.getUriForFile(getContext(), str5, new File(strArr2[i])));
                                i++;
                            }
                            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                        } else {
                            intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(getContext(), str5, new File(strArr2[0])));
                        }
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                } else if (strArr2.length > 1) {
                    ArrayList arrayList2 = new ArrayList();
                    int length3 = strArr2.length;
                    while (i < length3) {
                        arrayList2.add(Uri.parse("file://".concat(String.valueOf(strArr2[i]))));
                        i++;
                    }
                    intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList2);
                } else {
                    intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(strArr2[0])));
                }
                startActivity(intent);
                return;
            }
            intent = null;
            if (intent != null) {
            }
        }
    }
}
