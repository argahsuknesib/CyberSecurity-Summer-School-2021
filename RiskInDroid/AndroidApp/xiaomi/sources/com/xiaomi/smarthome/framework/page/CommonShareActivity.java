package com.xiaomi.smarthome.framework.page;

import _m_j.fkw;
import _m_j.fla;
import _m_j.fro;
import _m_j.frp;
import _m_j.ft;
import _m_j.ftn;
import _m_j.fws;
import _m_j.go;
import _m_j.gof;
import _m_j.gpc;
import _m_j.gpg;
import _m_j.gpj;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.gzl;
import _m_j.gzm;
import _m_j.hag;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import _m_j.izb;
import _m_j.vh;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.framework.page.CommonShareActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CommonShareActivity extends BaseActivity implements WbShareCallback {

    /* renamed from: O000000o  reason: collision with root package name */
    String f7650O000000o;
    String O00000Oo;
    String O00000o;
    String O00000o0;
    Bitmap O00000oO;
    Bitmap O00000oo;
    byte[] O0000O0o;
    String O0000OOo;
    String O0000Oo;
    boolean O0000Oo0 = false;
    String O0000OoO;
    Handler O0000Ooo = new Handler();
    private String O0000o;
    private View O0000o0;
    XQProgressDialog O0000o00;
    private String O0000o0O = "";
    private WbShareHandler O0000o0o;
    private final List<O000000o> O0000oO = Arrays.asList(new O000000o(CHANNELS.wechat, R.string.smarthome_share_wecaht, R.drawable.std_shop_details_share_icon_wxhy, new Runnable() {
        /* class com.xiaomi.smarthome.framework.page.$$Lambda$w2WqBQqUiIXhXiMHYOfRf4xmQaQ */

        public final void run() {
            CommonShareActivity.this.shareWeixin();
        }
    }), new O000000o(CHANNELS.wechat_timeline, R.string.smarthome_share_wxcircle, R.drawable.std_shop_details_share_icon_pyq, new Runnable() {
        /* class com.xiaomi.smarthome.framework.page.$$Lambda$xuwwDozTXURx7ZeMYWMCDgYNOF0 */

        public final void run() {
            CommonShareActivity.this.shareWeixinPyq();
        }
    }), new O000000o(CHANNELS.weibo, R.string.smarthome_share_sinaweibo, R.drawable.std_shop_details_share_icon_xlwb, new Runnable() {
        /* class com.xiaomi.smarthome.framework.page.$$Lambda$Lt9QRSDj8dLMtZA_lqEhjbKTHk */

        public final void run() {
            CommonShareActivity.this.shareWeibo();
        }
    }), new O000000o(CHANNELS.copy, R.string.smarthome_share_copyurl, R.drawable.std_shop_details_share_icon_fzlj, new Runnable() {
        /* class com.xiaomi.smarthome.framework.page.CommonShareActivity.AnonymousClass1 */

        public final void run() {
            ((ClipboardManager) CommonShareActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newRawUri("", Uri.parse(CommonShareActivity.this.O00000o0)));
            izb.O000000o(CommonShareActivity.this, (int) R.string.share_url_copy_success, 0).show();
            CommonShareActivity.this.sendShareResult(CHANNELS.copy.name(), 0);
        }
    }));
    private View O0000oO0;
    private final List<O000000o> O0000oOO = Arrays.asList(new O000000o(CHANNELS.facebook, R.string.smarthome_share_facebook, R.drawable.share_facebook, new Runnable() {
        /* class com.xiaomi.smarthome.framework.page.$$Lambda$geU9kSffBKURU41picDj2USt6A */

        public final void run() {
            CommonShareActivity.this.shareFacebook();
        }
    }), new O000000o(CHANNELS.line, R.string.smarthome_share_line, R.drawable.share_line, new Runnable() {
        /* class com.xiaomi.smarthome.framework.page.$$Lambda$QaSLupkd7EDZJ96nqU4qFwcdW4o */

        public final void run() {
            CommonShareActivity.this.shareLine();
        }
    }), new O000000o(CHANNELS.whatsapp, R.string.smarthome_share_whatsapp, R.drawable.share_whatsapp, new Runnable() {
        /* class com.xiaomi.smarthome.framework.page.$$Lambda$CommonShareActivity$C__LvemDaQt7oZ4w54nkrCPq6I8 */

        public final void run() {
            CommonShareActivity.this.O00000Oo();
        }
    }), new O000000o(CHANNELS.copy, R.string.smarthome_share_copyurl, R.drawable.std_shop_details_share_icon_fzlj, new Runnable() {
        /* class com.xiaomi.smarthome.framework.page.CommonShareActivity.AnonymousClass2 */

        public final void run() {
            try {
                ((ClipboardManager) CommonShareActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newRawUri("", Uri.parse(CommonShareActivity.this.O00000o0)));
                CommonShareActivity.this.sendShareResult(CHANNELS.copy.name(), 0);
                izb.O000000o(CommonShareActivity.this, (int) R.string.share_url_copy_success_v2, 0).show();
            } catch (Resources.NotFoundException unused) {
                CommonShareActivity.this.sendShareResult(CHANNELS.copy.name(), 1);
                izb.O000000o(CommonShareActivity.this, (int) R.string.share_url_copy_fail_v2, 0).show();
            }
        }
    }));
    private final BroadcastReceiver O0000oOo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.framework.page.CommonShareActivity.AnonymousClass8 */

        public final void onReceive(Context context, Intent intent) {
            if ("wechat".equals(intent.getStringExtra("share.channel"))) {
                boolean booleanExtra = intent.getBooleanExtra("share.is_success", false);
                String stringExtra = intent.getStringExtra("transcation");
                intent.getStringExtra("share.code");
                intent.getStringExtra("share.err_msg");
                if (stringExtra != null && stringExtra.equals(CommonShareActivity.this.transaction)) {
                    CommonShareActivity.this.sendShareResult((CommonShareActivity.this.shareWxPyq ? CHANNELS.wechat_timeline : CHANNELS.wechat).name(), booleanExtra ^ true ? 1 : 0);
                }
            }
        }
    };
    public boolean shareWxPyq = true;
    public String transaction = null;

    enum CHANNELS {
        wechat,
        wechat_timeline,
        weibo,
        save_to_album,
        copy,
        line,
        facebook,
        whatsapp,
        more,
        no_interest
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(View view) {
    }

    public void onCreate(Bundle bundle) {
        ArrayList<O000000o> arrayList;
        boolean z;
        gpc.O00000o(this);
        super.onCreate(bundle);
        gwg.O00000o(this);
        setContentView((int) R.layout.comm_share_activity);
        Intent intent = getIntent();
        this.f7650O000000o = intent.getStringExtra("ShareTitle");
        this.O00000Oo = intent.getStringExtra("ShareContent");
        this.O00000o0 = intent.getStringExtra("ShareUrl");
        this.O00000o = intent.getStringExtra("ThumbUrl");
        this.O00000oO = (Bitmap) intent.getParcelableExtra("Thumb");
        this.O00000oo = (Bitmap) intent.getParcelableExtra("Image");
        this.O0000O0o = intent.getByteArrayExtra("ImageByteArray");
        this.O0000o0O = intent.getStringExtra("StartActivityFrom");
        this.O0000OOo = intent.getStringExtra("SHARE_IMAGE_FILE_ZIP_URL");
        if (TextUtils.isEmpty(this.f7650O000000o)) {
            this.f7650O000000o = intent.getStringExtra("title");
        }
        if (TextUtils.isEmpty(this.O00000Oo)) {
            this.O00000Oo = intent.getStringExtra("content");
        }
        if (TextUtils.isEmpty(this.O0000OOo)) {
            this.O0000OOo = intent.getStringExtra("pics");
        }
        if (TextUtils.isEmpty(this.O0000OOo)) {
            this.O0000OOo = intent.getStringExtra("ShareImageUrlNotZip");
            this.O0000Oo0 = !TextUtils.isEmpty(this.O0000OOo);
        }
        if (TextUtils.isEmpty(this.O00000o0)) {
            this.O00000o0 = intent.getStringExtra("jump");
        }
        this.O0000o = intent.getStringExtra("share_device_model");
        if (!TextUtils.isEmpty(this.O0000OOo)) {
            this.O0000o00 = new XQProgressDialog(this);
            this.O0000o00.setMessage(getString(R.string.refreshing));
            this.O0000o00.setCancelable(true);
            this.O0000o00.show();
            new Thread() {
                /* class com.xiaomi.smarthome.framework.page.CommonShareActivity.AnonymousClass5 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
                 arg types: [int, int]
                 candidates:
                  ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
                  ClspMth{java.lang.String.replace(char, char):java.lang.String} */
                public final void run() {
                    String str;
                    CommonShareActivity commonShareActivity = CommonShareActivity.this;
                    if (TextUtils.isEmpty(commonShareActivity.O0000OOo)) {
                        commonShareActivity.O000000o();
                    } else if (commonShareActivity.O0000OOo.startsWith("http")) {
                        File externalCacheDir = commonShareActivity.getExternalCacheDir();
                        int lastIndexOf = commonShareActivity.O0000OOo.lastIndexOf(47);
                        if (lastIndexOf > 0) {
                            str = commonShareActivity.O0000OOo.substring(lastIndexOf + 1);
                            int indexOf = str.indexOf(63);
                            if (indexOf > 0) {
                                str = Uri.encode(str.substring(0, indexOf)).replace('%', '_');
                            }
                        } else {
                            str = "tmp.zip";
                        }
                        String str2 = externalCacheDir.getAbsolutePath() + File.separator + str;
                        if (gof.O000000o(CommonApplication.getAppContext(), commonShareActivity.O0000OOo, new File(str2), null).O00000Oo != 3) {
                            commonShareActivity.O000000o();
                        } else if (commonShareActivity.O0000Oo0) {
                            commonShareActivity.O00000Oo(str2);
                        } else {
                            commonShareActivity.O000000o(str2);
                        }
                    } else if (!new File(commonShareActivity.O0000OOo).exists()) {
                        commonShareActivity.O000000o();
                    } else if (commonShareActivity.O0000OOo.endsWith(".zip")) {
                        commonShareActivity.O000000o(commonShareActivity.O0000OOo);
                    } else {
                        commonShareActivity.O00000Oo(commonShareActivity.O0000OOo);
                    }
                }
            }.start();
        } else {
            Bitmap bitmap = this.O00000oo;
            if (bitmap == null) {
                byte[] bArr = this.O0000O0o;
                if (bArr != null) {
                    this.O00000oo = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (this.O00000oO == null) {
                        this.O00000oO = gpj.O000000o(this.O00000oo);
                    }
                } else {
                    finish();
                    return;
                }
            } else if (this.O00000oO == null) {
                this.O00000oO = gpj.O000000o(bitmap);
            }
        }
        if (ftn.O00000oo(this)) {
            try {
                WbSdk.checkInit();
                z = true;
            } catch (Exception unused) {
                z = false;
            }
            if (z) {
                this.O0000o0o = new WbShareHandler(this);
                this.O0000o0o.setProgressColor(getResources().getColor(R.color.mj_color_green_normal));
                this.O0000o0o.registerApp();
            }
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("share_channels");
        if (ftn.O00000oo(this)) {
            arrayList = new ArrayList<>(this.O0000oO);
        } else {
            arrayList = new ArrayList<>(this.O0000oOO);
        }
        if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (O000000o o000000o : arrayList) {
                if (stringArrayListExtra.indexOf(o000000o.f7659O000000o.name()) != -1) {
                    arrayList2.add(o000000o);
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList = arrayList2;
            }
        }
        if (TextUtils.isEmpty(this.O00000o0)) {
            int i = 0;
            while (true) {
                if (i >= arrayList.size()) {
                    i = -1;
                    break;
                } else if (CHANNELS.copy.name().equals(((O000000o) arrayList.get(i)).f7659O000000o.name())) {
                    break;
                } else {
                    i++;
                }
            }
            arrayList.remove(i);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext()) {
            /* class com.xiaomi.smarthome.framework.page.CommonShareActivity.AnonymousClass3 */

            public final boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        go goVar = new go();
        goVar.O0000o00 = false;
        recyclerView.setItemAnimator(goVar);
        gzl gzl = new gzl();
        gzl.O000000o(new O00000Oo(arrayList));
        recyclerView.setAdapter(gzl);
        this.O0000o0 = findViewById(R.id.mask);
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.$$Lambda$CommonShareActivity$JoAv6TGAMFYV9bWBmmjUu9oo5LA */

            public final void onClick(View view) {
                CommonShareActivity.this.O00000o0(view);
            }
        });
        this.O0000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.$$Lambda$CommonShareActivity$PaOshSwb4BEHfsGFqrQC3FNPAuo */

            public final void onClick(View view) {
                CommonShareActivity.this.O00000Oo(view);
            }
        });
        this.O0000oO0 = findViewById(R.id.share_dialog_container);
        this.O0000oO0.setOnClickListener($$Lambda$CommonShareActivity$yHykye40qeUReg2z3T3hOH0zqWQ.INSTANCE);
        this.O0000o0.setAlpha(0.0f);
        this.O0000o0.animate().alpha(1.0f);
        this.O0000oO0.animate().translationY(0.0f);
        if (this.O00000oO == null && !TextUtils.isEmpty(this.O00000o)) {
            new vh();
            Picasso.get().load(this.O00000o).error((int) R.drawable.device_shop_image_default_logo).resize(150, 150).into(new Target() {
                /* class com.xiaomi.smarthome.framework.page.CommonShareActivity.AnonymousClass7 */

                public final void onBitmapFailed(Exception exc, Drawable drawable) {
                }

                public final void onPrepareLoad(Drawable drawable) {
                }

                public final void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                    CommonShareActivity.this.O00000oO = bitmap;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        finish();
    }

    class O00000Oo extends gzm {
        private List<O000000o> O00000Oo;
        private Paint O00000o0 = new Paint();

        public final int O000000o() {
            return 4;
        }

        public O00000Oo(List<O000000o> list) {
            this.O00000Oo = list;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O000000o(LayoutInflater.from(CommonShareActivity.this.getContext()).inflate((int) R.layout.item_common_share, viewGroup, false));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O000000o o000000o = (O000000o) o000OOo0;
            O000000o o000000o2 = this.O00000Oo.get(i);
            o000000o.f7661O000000o.setCompoundDrawablesWithIntrinsicBounds(0, o000000o2.O00000o0, 0, 0);
            o000000o.f7661O000000o.setText(o000000o.itemView.getResources().getText(o000000o2.O00000Oo));
            o000000o.itemView.setOnClickListener(new View.OnClickListener(o000000o2) {
                /* class com.xiaomi.smarthome.framework.page.CommonShareActivity.O00000Oo.O000000o.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O000000o f7662O000000o;

                {
                    this.f7662O000000o = r2;
                }

                public final void onClick(View view) {
                    CommonShareActivity.this.playClickAnim(view);
                    this.f7662O000000o.O00000o.run();
                }
            });
        }

        public final int getItemCount() {
            return this.O00000Oo.size();
        }

        class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f7661O000000o;

            public O000000o(View view) {
                super(view);
                this.f7661O000000o = (TextView) view.findViewById(R.id.menu);
            }
        }

        public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            super.O000000o(rect, view, i, recyclerView, o000OO0o);
        }

        public final void O000000o(Canvas canvas, RecyclerView recyclerView, View view, int i, RecyclerView.O000OO0o o000OO0o) {
            if (i != 0 && i % 4 == 0) {
                int O000000o2 = gpc.O000000o(24.0f);
                int top = view.getTop();
                this.O00000o0.setColor(recyclerView.getContext().getResources().getColor(R.color.mj_color_separator));
                this.O00000o0.setStrokeWidth((float) gpc.O000000o(1.0f));
                float f = (float) top;
                canvas.drawLine((float) O000000o2, f, (float) (recyclerView.getMeasuredWidth() - O000000o2), f, this.O00000o0);
            }
        }
    }

    public void playClickAnim(View view) {
        hag hag = new hag(0.9f);
        hag.setDuration(360);
        hag.setInterpolator(new LinearInterpolator());
        view.startAnimation(hag);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str) {
        Bitmap decodeFile;
        File externalCacheDir = getExternalCacheDir();
        fws.O00000Oo(externalCacheDir.getAbsolutePath());
        externalCacheDir.mkdirs();
        fla.O000000o(str, externalCacheDir.getAbsolutePath(), null);
        File[] listFiles = externalCacheDir.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    String lowerCase = listFiles[i].getPath().toLowerCase();
                    if (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".png")) {
                        int lastIndexOf = lowerCase.lastIndexOf(File.separator);
                        if (lastIndexOf >= 0) {
                            String substring = lowerCase.substring(lastIndexOf + 1, lowerCase.lastIndexOf("."));
                            if ("thumb".equals(substring)) {
                                this.O0000Oo = listFiles[i].getAbsolutePath();
                            } else if ("pic".equals(substring)) {
                                this.O0000OoO = listFiles[i].getAbsolutePath();
                            }
                        }
                        arrayList.add(listFiles[i].getAbsolutePath());
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(this.O0000Oo) && (decodeFile = BitmapFactory.decodeFile(this.O0000Oo)) != null) {
            this.O00000oO = gpj.O000000o(decodeFile);
        }
        if (!TextUtils.isEmpty(this.O0000OoO)) {
            this.O00000oo = BitmapFactory.decodeFile(this.O0000OoO);
        }
        O000000o();
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(String str) {
        Bitmap bitmap;
        Bitmap decodeFile;
        if (!TextUtils.isEmpty(this.O0000Oo) && this.O00000oO == null && (decodeFile = BitmapFactory.decodeFile(this.O0000Oo)) != null) {
            this.O00000oO = gpj.O000000o(decodeFile);
        }
        if (!TextUtils.isEmpty(this.O0000OoO)) {
            this.O00000oo = BitmapFactory.decodeFile(this.O0000OoO);
        }
        if (this.O00000oO == null) {
            if (gpg.O000000o(str).equals("png")) {
                bitmap = O000000o(BitmapFactory.decodeFile(str), str);
            } else {
                bitmap = BitmapFactory.decodeFile(str);
            }
            this.O00000oo = bitmap;
            this.O00000oO = gpj.O000000o(bitmap);
        }
        O000000o();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        this.O0000Ooo.post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.page.CommonShareActivity.AnonymousClass6 */

            public final void run() {
                CommonShareActivity.this.O0000Ooo.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.page.$$Lambda$CommonShareActivity$6$vM_erfVMsNi9fdq8fErVqZBS9w */

                    public final void run() {
                        CommonShareActivity.AnonymousClass6.this.O000000o();
                    }
                }, 500);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o() {
                if (CommonShareActivity.this.O0000o00 != null) {
                    CommonShareActivity.this.O0000o00.dismiss();
                    CommonShareActivity.this.O0000o00 = null;
                }
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        this.O00000oO = null;
        this.O00000oo = null;
        ft.O000000o(this).O000000o(this.O0000oOo);
    }

    public void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(this.O0000o)) {
            hxp hxp = hxi.O00000o0;
            String str = this.O0000o;
            hxp.f957O000000o.O000000o("plugin_share_show", "model", str);
        }
    }

    /* access modifiers changed from: private */
    public void O00000Oo() {
        if (!checkAppValidate("com.whatsapp")) {
            izb.O000000o(this, getResources().getString(R.string.device_shop_share_no_whatsapp), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setPackage("com.whatsapp");
        if (this.O00000oo != null) {
            intent.putExtra("android.intent.extra.STREAM", Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), this.O00000oo, (String) null, (String) null)));
            intent.setType("image/jpeg");
        } else if (this.O00000o0 != null) {
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", this.O00000o0);
        }
        startActivity(Intent.createChooser(intent, "Share to"));
        if (!TextUtils.isEmpty(this.O0000o)) {
            hxk hxk = hxi.O00000o;
            String str = this.O0000o;
            hxk.f952O000000o.O000000o("plugin_share_whatsapp", "model", str);
        }
    }

    public void shareLine() {
        ComponentName componentName;
        if (!checkAppValidate("jp.naver.line.android")) {
            izb.O000000o(this, getResources().getString(R.string.device_shop_share_no_line), 0).show();
            return;
        }
        try {
            if (O00000oO()) {
                componentName = new ComponentName("jp.naver.line.android", "jp.naver.line.android.activity.selectchat.SelectChatActivity");
            } else {
                componentName = new ComponentName("jp.naver.line.android", "jp.naver.line.android.activity.selectchat.SelectChatActivityLaunchActivity");
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            if (this.O00000oo != null) {
                String insertImage = MediaStore.Images.Media.insertImage(getContentResolver(), this.O00000oo, (String) null, (String) null);
                if (insertImage != null) {
                    intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                    intent.setType("image/jpeg");
                }
            } else if (this.O00000o0 != null) {
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", this.O00000o0);
            }
            intent.setComponent(componentName);
            startActivity(Intent.createChooser(intent, ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.O0000o)) {
            hxk hxk = hxi.O00000o;
            String str = this.O0000o;
            hxk.f952O000000o.O000000o("plugin_share_line", "model", str);
        }
    }

    public void shareFacebook() {
        if (!checkAppValidate("com.facebook.katana")) {
            izb.O000000o(this, getResources().getString(R.string.device_shop_share_no_facebook), 0).show();
            return;
        }
        frp O000000o2 = fro.O000000o();
        if (O000000o2 != null) {
            O000000o2.shareFacebook(this, this.O00000oo, false, "", this.O00000o0);
        }
        if (!TextUtils.isEmpty(this.O0000o)) {
            hxk hxk = hxi.O00000o;
            String str = this.O0000o;
            hxk.f952O000000o.O000000o("plugin_share_facebook", "model", str);
        }
    }

    public void shareWeixin() {
        if (!checkAppValidate("com.tencent.mm")) {
            izb.O000000o(this, (int) R.string.device_shop_share_no_weixin, 1).show();
            return;
        }
        if (this.O00000oO == null && this.O00000oo == null) {
            Bitmap O00000o02 = O00000o0();
            this.O00000oo = O00000o02;
            this.O00000oO = O00000o02;
        } else {
            Bitmap bitmap = this.O00000oO;
            if (bitmap == null) {
                this.O00000oO = this.O00000oo;
            } else if (this.O00000oo == null) {
                this.O00000oo = bitmap;
            }
        }
        this.shareWxPyq = false;
        O00000o();
        IWXAPI shiwxapi = CommonApplication.getSHIWXAPI();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = this.f7650O000000o;
        wXMediaMessage.description = this.O00000Oo;
        wXMediaMessage.setThumbImage(this.O00000oO);
        if (!TextUtils.isEmpty(this.O00000o0)) {
            wXMediaMessage.mediaObject = new WXWebpageObject(this.O00000o0);
        } else {
            Bitmap bitmap2 = this.O00000oo;
            if (bitmap2 != null) {
                wXMediaMessage.mediaObject = new WXImageObject(bitmap2);
            }
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = wXMediaMessage;
        req.scene = 0;
        gsy.O000000o(LogType.GENERAL, "CommonShareActivity", "sendReq return ".concat(String.valueOf(shiwxapi.sendReq(req))));
        if (!TextUtils.isEmpty(this.O0000o)) {
            hxk hxk = hxi.O00000o;
            String str = this.O0000o;
            hxk.f952O000000o.O000000o("plugin_share_wx", "model", str);
        }
    }

    private Bitmap O00000o0() {
        try {
            return BitmapFactory.decodeResource(getResources(), R.drawable.mj_ic_launcher);
        } catch (Exception unused) {
            return null;
        }
    }

    public void shareWeixinPyq() {
        if (!checkAppValidate("com.tencent.mm")) {
            izb.O000000o(this, (int) R.string.device_shop_share_no_weixin, 1).show();
            return;
        }
        if (this.O00000oO == null && this.O00000oo == null) {
            Bitmap O00000o02 = O00000o0();
            this.O00000oo = O00000o02;
            this.O00000oO = O00000o02;
        } else {
            Bitmap bitmap = this.O00000oO;
            if (bitmap == null) {
                this.O00000oO = this.O00000oo;
            } else if (this.O00000oo == null) {
                this.O00000oo = bitmap;
            }
        }
        this.shareWxPyq = true;
        O00000o();
        IWXAPI shiwxapi = CommonApplication.getSHIWXAPI();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = this.f7650O000000o;
        wXMediaMessage.description = this.O00000Oo;
        wXMediaMessage.setThumbImage(this.O00000oO);
        if (!TextUtils.isEmpty(this.O00000o0)) {
            wXMediaMessage.mediaObject = new WXWebpageObject(this.O00000o0);
        } else {
            Bitmap bitmap2 = this.O00000oo;
            if (bitmap2 != null) {
                wXMediaMessage.mediaObject = new WXImageObject(bitmap2);
            }
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        String valueOf = String.valueOf(System.currentTimeMillis());
        this.transaction = valueOf;
        req.transaction = valueOf;
        req.message = wXMediaMessage;
        req.scene = 1;
        gsy.O000000o(LogType.GENERAL, "CommonShareActivity", "sendReq return ".concat(String.valueOf(shiwxapi.sendReq(req))));
        if (!TextUtils.isEmpty(this.O0000o)) {
            hxk hxk = hxi.O00000o;
            String str = this.O0000o;
            hxk.f952O000000o.O000000o("plugin_share_wx_pyq", "model", str);
        }
    }

    private void O00000o() {
        ft.O000000o(this).O000000o(this.O0000oOo);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("share.sdk");
        ft.O000000o(this).O000000o(this.O0000oOo, intentFilter);
    }

    public void shareWeibo() {
        if (this.O0000o0o == null || !checkAppValidate("com.sina.weibo")) {
            izb.O000000o(this, (int) R.string.device_shop_share_no_weibo, 1).show();
            return;
        }
        this.O0000o0o.registerApp();
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (this.O00000oo != null) {
            ImageObject imageObject = new ImageObject();
            if (this.O00000oo.getByteCount() > 2097152) {
                double byteCount = (double) this.O00000oo.getByteCount();
                Double.isNaN(byteCount);
                double sqrt = Math.sqrt((byteCount * 1.0d) / 2097152.0d);
                double width = (double) this.O00000oo.getWidth();
                Double.isNaN(width);
                double height = (double) this.O00000oo.getHeight();
                Double.isNaN(height);
                imageObject.setImageObject(Bitmap.createScaledBitmap(this.O00000oo, (int) (width / sqrt), (int) (height / sqrt), true));
            } else {
                imageObject.setImageObject(this.O00000oo);
            }
            weiboMultiMessage.imageObject = imageObject;
        }
        TextObject textObject = new TextObject();
        textObject.text = "";
        if (!TextUtils.isEmpty(this.f7650O000000o)) {
            textObject.text = "#" + this.f7650O000000o + "#";
            weiboMultiMessage.textObject = textObject;
        }
        if ("rn".equalsIgnoreCase(this.O0000o0O) && !TextUtils.isEmpty(this.O00000Oo)) {
            weiboMultiMessage.textObject = textObject;
            textObject.text += this.O00000Oo + " ";
        }
        if (!TextUtils.isEmpty(this.O00000o0)) {
            textObject.text += this.O00000o0;
        }
        this.O0000o0o.shareMessage(weiboMultiMessage, false);
        if (!TextUtils.isEmpty(this.O0000o)) {
            hxi.O00000o.f952O000000o.O000000o("plugin_share_weibo", "model", this.O0000o);
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        WbShareHandler wbShareHandler = this.O0000o0o;
        if (wbShareHandler != null) {
            wbShareHandler.doResultIntent(intent, this);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        WbShareHandler wbShareHandler = this.O0000o0o;
        if (wbShareHandler != null) {
            wbShareHandler.doResultIntent(intent, this);
        }
    }

    public boolean checkAppValidate(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    private boolean O00000oO() {
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

    public void share(String[] strArr, String[] strArr2, String str, String str2) {
        Intent intent;
        File file;
        File parentFile;
        if (strArr != null && strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            String str3 = strArr2.length > 1 ? "android.intent.action.SEND_MULTIPLE" : "android.intent.action.SEND";
            Intent intent2 = new Intent();
            intent2.setAction(str3).setType("image/*");
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
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            if (next.activityInfo.name.contains(strArr[i])) {
                                intent = new Intent(str3);
                                intent.setType("image/*");
                                intent.setClassName(next.activityInfo.packageName, next.activityInfo.name);
                                intent.addFlags(268435457);
                                break loop0;
                            }
                            i++;
                        }
                    }
                }
            }
            intent = null;
            if (intent == null) {
                izb.O000000o(getContext(), (int) R.string.mj_share_score_share_no_install, 0).show();
                return;
            }
            if (!TextUtils.isEmpty(this.f7650O000000o)) {
                intent.putExtra("android.intent.extra.SUBJECT", str);
            }
            if (!TextUtils.isEmpty(this.O00000Oo)) {
                intent.putExtra("android.intent.extra.TEXT", str2);
            }
            if (strArr2.length > 1) {
                ArrayList arrayList = new ArrayList();
                for (String valueOf : strArr2) {
                    arrayList.add(Uri.parse("file://".concat(String.valueOf(valueOf))));
                }
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            } else {
                String str4 = strArr2[0];
                if (str4.startsWith(fkw.O000000o(this))) {
                    int lastIndexOf = str4.lastIndexOf(File.separator);
                    if (lastIndexOf <= 0) {
                        file = new File(str4);
                    } else {
                        int lastIndexOf2 = str4.lastIndexOf(46);
                        File file2 = new File(getExternalCacheDir().getAbsolutePath(), "temp_share");
                        fws.O00000Oo(file2.getAbsolutePath());
                        String absolutePath = file2.getAbsolutePath();
                        StringBuilder sb = new StringBuilder("p");
                        sb.append(lastIndexOf2 > lastIndexOf ? str4.substring(lastIndexOf2) : "");
                        File file3 = new File(absolutePath, sb.toString());
                        String absolutePath2 = file3.getAbsolutePath();
                        if (!TextUtils.isEmpty(absolutePath2) && (parentFile = new File(absolutePath2).getParentFile()) != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        fws.O000000o(str4, file3.getAbsolutePath());
                        file = file3;
                    }
                } else {
                    file = new File(str4);
                }
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
            }
            getContext().startActivity(intent);
        }
    }

    private Bitmap O000000o(Bitmap bitmap, String str) {
        if (!this.O0000Oo0 || bitmap == null) {
            return null;
        }
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(copy);
        canvas.drawColor(-1);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            if (!copy.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
                return copy;
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            return copy;
        } catch (IOException e) {
            e.printStackTrace();
            return copy;
        }
    }

    public void onWbShareSuccess() {
        sendShareResult(CHANNELS.weibo.name(), 0);
    }

    public void onWbShareCancel() {
        sendShareResult(CHANNELS.weibo.name(), 2);
    }

    public void onWbShareFail() {
        sendShareResult(CHANNELS.weibo.name(), 1);
    }

    public void sendShareResult(String str, int i) {
        Intent intent = new Intent("ACTION_SHARE_RESULT");
        intent.putExtra("result_code", i);
        intent.putExtra("result_channel", str);
        ft.O000000o(this).O000000o(intent);
        finish();
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public CHANNELS f7659O000000o;
        public int O00000Oo;
        public Runnable O00000o;
        public int O00000o0;

        O000000o(CHANNELS channels, int i, int i2, Runnable runnable) {
            this.f7659O000000o = channels;
            this.O00000Oo = i;
            this.O00000o0 = i2;
            this.O00000o = runnable;
        }
    }

    public void finish() {
        this.O0000o0.animate().alpha(0.0f);
        this.O0000oO0.animate().translationY((float) gpc.O000000o(365.0f)).withEndAction(new Runnable() {
            /* class com.xiaomi.smarthome.framework.page.CommonShareActivity.AnonymousClass4 */

            public final void run() {
                CommonShareActivity.super.finish();
            }
        });
    }
}
