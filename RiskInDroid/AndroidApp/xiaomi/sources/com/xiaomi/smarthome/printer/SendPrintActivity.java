package com.xiaomi.smarthome.printer;

import _m_j.dn;
import _m_j.ezq;
import _m_j.ezt;
import _m_j.ezu;
import _m_j.fkw;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fsp;
import _m_j.ftn;
import _m_j.ggb;
import _m_j.grv;
import _m_j.gsf;
import _m_j.gsy;
import _m_j.gtx;
import _m_j.gty;
import _m_j.hlz;
import _m_j.hmc;
import _m_j.hme;
import _m_j.hte;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.controls.AllReadyCallback;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class SendPrintActivity extends BaseActivity implements hmc, View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    HashMap<String, String> f10539O000000o = new HashMap<>();
    private View O00000Oo;
    private TextView O00000o;
    private ImageView O00000o0;
    private TextView O00000oO;
    private View O00000oo;
    private O000000o O0000O0o;
    private fno.O000000o O0000OOo = new fno.O000000o() {
        /* class com.xiaomi.smarthome.printer.SendPrintActivity.AnonymousClass1 */

        public final void onRefreshClientDeviceSuccess(int i) {
            SendPrintActivity.this.openPrinter(fno.O000000o().O00000oO(), false);
        }

        public final void onRefreshClientDeviceChanged(int i, Device device) {
            SendPrintActivity.this.openPrinter(fno.O000000o().O00000oO(), false);
        }
    };
    public RecyclerView mRvContent;

    public void onLoadingStart() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_sendprint);
        this.O00000Oo = findViewById(R.id.rl_root);
        this.O00000o0 = (ImageView) findViewById(R.id.ivLoading);
        this.O00000Oo.setVisibility(8);
        this.mRvContent = (RecyclerView) findViewById(R.id.rv_content);
        this.mRvContent.setLayoutManager(new LinearLayoutManager(this));
        this.O0000O0o = new O000000o(new ArrayList());
        this.mRvContent.setAdapter(this.O0000O0o);
        this.O00000o = (TextView) findViewById(R.id.tvBuy);
        this.O00000oO = (TextView) findViewById(R.id.tvHint);
        ImageView imageView = (ImageView) findViewById(R.id.module_a_3_return_btn);
        this.O00000oo = findViewById(R.id.ll_content);
        imageView.setImageResource(R.drawable.title_cancel_selector);
        imageView.setOnClickListener(this);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.sendprint_title);
        showLoading();
        fno.O000000o().O000000o(this.O0000OOo);
        gsy.O00000o0(LogType.GENERAL, "SendPrintActivity", "onCreate");
        if (ezu.O000000o()) {
            gsy.O00000o0(LogType.GENERAL, "SendPrintActivity", "check login");
            CommonApplication.getApplication().onApplicationLifeCycleStart();
            checkLogin();
            return;
        }
        gsy.O00000o0(LogType.GENERAL, "SendPrintActivity", "isAllPass false");
        ezt.O000000o().startCheck(new ezq() {
            /* class com.xiaomi.smarthome.printer.SendPrintActivity.AnonymousClass2 */

            public final void O000000o() {
            }

            public final void O00000Oo() {
            }

            public final void O00000o0() {
                gsy.O00000o0(LogType.GENERAL, "GetDeviceTask", "pass cta");
                CommonApplication.getApplication().onApplicationLifeCycleStart();
                SendPrintActivity.this.checkLogin();
            }
        });
    }

    public void checkLogin() {
        new AllReadyCallback(4, new Runnable() {
            /* class com.xiaomi.smarthome.printer.SendPrintActivity.AnonymousClass3 */

            public final void run() {
                gsy.O00000o0(LogType.GENERAL, "SendPrintActivity", "onLoginSuccess onCoreReady onDeviceReady");
                SendPrintActivity.this.openPrinter(fno.O000000o().O00000oO(), true);
            }
        });
    }

    private void O000000o() {
        dismissLoading();
        this.O00000oo.setVisibility(0);
        this.mRvContent.setVisibility(8);
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            gsy.O00000o0(LogType.GENERAL, "SendPrintActivity", "nologin");
            this.O00000oO.setText((int) R.string.sendprint_nologin);
            this.O00000o.setText((int) R.string.sendprint_gologin);
            this.O00000o.setVisibility(0);
            this.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.printer.SendPrintActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    int i = ServiceApplication.getStateNotifier().f15923O000000o;
                    gsy.O00000o0(LogType.GENERAL, "SendPrintActivity", "onClick startLogin currentState:".concat(String.valueOf(i)));
                    if (i != 4) {
                        SendPrintActivity.this.showLoading();
                        gty.O000000o().startLogin(SendPrintActivity.this, 1, new gtx.O000000o() {
                            /* class com.xiaomi.smarthome.printer.SendPrintActivity.AnonymousClass4.AnonymousClass1 */

                            public final void O000000o() {
                                SendPrintActivity.this.checkLogin();
                            }
                        });
                        return;
                    }
                    SendPrintActivity.this.openPrinter(fno.O000000o().O00000oO(), false);
                }
            });
        } else if (ftn.O00000oO(this)) {
            gsy.O00000o0(LogType.GENERAL, "SendPrintActivity", "isInternationalServer");
            this.O00000oO.setText((int) R.string.sendprint_nodevicehint_internal);
            this.O00000o.setVisibility(8);
        } else {
            gsy.O00000o0(LogType.GENERAL, "SendPrintActivity", "showLoading buy");
            this.O00000oO.setText((int) R.string.sendprint_nodevicehint);
            this.O00000o.setText((int) R.string.sendprint_nodevicebuy);
            this.O00000o.setVisibility(0);
            final AppConfigHelper appConfigHelper = new AppConfigHelper(this);
            this.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.printer.SendPrintActivity.AnonymousClass5 */

                public final void onClick(View view) {
                    SendPrintActivity.this.showLoading();
                    appConfigHelper.O000000o("printer_buy_url", "1", "zh_CN", null, new AppConfigHelper.O000000o() {
                        /* class com.xiaomi.smarthome.printer.SendPrintActivity.AnonymousClass5.AnonymousClass1 */

                        /* renamed from: O000000o */
                        public final void onSuccess(String str, Response response) {
                            try {
                                SendPrintActivity.this.dismissLoading();
                                fsp.O000000o().O0000Oo.loadWebView(new JSONObject(str).optString("youpin_url"), "");
                            } catch (JSONException e) {
                                gsy.O00000o0(LogType.GENERAL, "SendPrintActivity", Log.getStackTraceString(e));
                            }
                        }

                        public final void onFailure(gsf gsf, Exception exc, Response response) {
                            SendPrintActivity.this.dismissLoading();
                        }
                    });
                }
            });
        }
    }

    public void openPrinter(Map<String, Device> map, boolean z) {
        Cursor query;
        int columnIndex;
        try {
            gsy.O00000o0(LogType.GENERAL, "SendPrintActivity", "openPrinter devices:".concat(String.valueOf(map)));
            Uri uri = (Uri) getIntent().getParcelableExtra("android.intent.extra.STREAM");
            if (uri != null) {
                String scheme = uri.getScheme();
                String str = null;
                if (scheme == null) {
                    str = uri.getPath();
                } else if ("file".equals(scheme)) {
                    str = uri.getPath();
                } else if ("content".equals(scheme) && (query = getContentResolver().query(uri, new String[]{"_data"}, null, null, null)) != null) {
                    if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) >= 0) {
                        str = query.getString(columnIndex);
                    }
                    query.close();
                }
                getIntent().putExtra("file", str);
            }
            Intent intent = getIntent();
            intent.getParcelableExtra("android.intent.extra.STREAM");
            intent.putExtra("source", 1);
            intent.putExtra("share_intent_data", O000000o(intent));
            intent.putExtra("share_intent_data_type", intent.getType());
            HashMap<String, PluginDeviceInfo> O00000Oo2 = O00000Oo();
            if (map != null) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, Device> value : map.entrySet()) {
                    Device device = (Device) value.getValue();
                    if (O00000Oo2.containsKey(device.model)) {
                        arrayList.add(device);
                    }
                }
                if (arrayList.size() == 0) {
                    gsy.O00000o0(LogType.GENERAL, "SendPrintActivity", "openPrinter size:0");
                    O000000o();
                    return;
                }
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "SendPrintActivity", "openPrinter  else size:" + arrayList.size());
                this.mRvContent.setVisibility(0);
                this.O00000oo.setVisibility(8);
                O000000o o000000o = this.O0000O0o;
                o000000o.f10548O000000o.clear();
                o000000o.f10548O000000o.addAll(arrayList);
                o000000o.notifyDataSetChanged();
                dismissLoading();
                if (arrayList.size() == 1 && z) {
                    gsy.O00000o0(LogType.GENERAL, "SendPrintActivity", "openPrinter  size:1");
                    DeviceStat newDeviceStat = DeviceRouterFactory.getDeviceWrapper().newDeviceStat((Device) arrayList.get(0));
                    hme.O000000o(this, newDeviceStat.model, getIntent(), newDeviceStat, this);
                    return;
                }
                return;
            }
            O000000o();
        } catch (Throwable unused) {
            hte.O000000o(this, getString(R.string.permission_tips_denied_msg, new Object[]{getString(R.string.permission_name_storage)}));
        }
    }

    /* JADX WARN: Type inference failed for: r10v10, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    private Uri O000000o(Intent intent) {
        if (intent == null) {
            return null;
        }
        Uri data = intent.getData();
        if (data == null) {
            data = intent.getParcelableExtra("android.intent.extra.STREAM");
        }
        if (data == null) {
            return null;
        }
        data.getScheme();
        data.getHost();
        String lastPathSegment = data.getLastPathSegment();
        String substring = lastPathSegment.substring(lastPathSegment.lastIndexOf("/") + 1);
        File file = new File(getExternalCacheDir(), "share_cache");
        dn O000000o2 = dn.O000000o(this, data);
        File file2 = new File(file, grv.O000000o(data.toString() + O000000o2.O00000o()));
        if (file.exists() && file.length() > 52428800) {
            file.delete();
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(file2, substring);
        if (file3.exists()) {
            return Uri.fromFile(file3);
        }
        try {
            file3.createNewFile();
        } catch (IOException e) {
            LogType logType = LogType.GENERAL;
            gsy.O00000o0(logType, "SendPrintActivity", "copyToAppCache  error:" + Log.getStackTraceString(e));
        }
        dn O000000o3 = dn.O000000o(file3);
        copyDocument(CommonApplication.getAppContext(), O000000o2, O000000o3);
        if (O000000o3.O00000o() > 0) {
            return O000000o3.O000000o();
        }
        O000000o3.O00000oO();
        return data;
    }

    public static void copyDocument(Context context, dn dnVar, dn dnVar2) {
        BufferedOutputStream bufferedOutputStream;
        if (dnVar != null && dnVar2 != null) {
            BufferedInputStream bufferedInputStream = null;
            try {
                Uri O000000o2 = dnVar.O000000o();
                Uri O000000o3 = dnVar2.O000000o();
                ParcelFileDescriptor O000000o4 = fkw.O000000o(context, O000000o2, 268435456);
                ParcelFileDescriptor O000000o5 = fkw.O000000o(context, O000000o3, 805306368);
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(O000000o4.getFileDescriptor()));
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(O000000o5.getFileDescriptor()));
                } catch (IOException e) {
                    e = e;
                    bufferedOutputStream = null;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        gsy.O000000o(6, "SendPrintActivity", "copyDocument error:" + Log.getStackTraceString(e));
                        fkw.O000000o((AutoCloseable) bufferedInputStream);
                        fkw.O000000o((AutoCloseable) bufferedOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        fkw.O000000o((AutoCloseable) bufferedInputStream);
                        fkw.O000000o((AutoCloseable) bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                    bufferedInputStream = bufferedInputStream2;
                    fkw.O000000o((AutoCloseable) bufferedInputStream);
                    fkw.O000000o((AutoCloseable) bufferedOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    fkw.O000000o((AutoCloseable) bufferedInputStream2);
                } catch (IOException e2) {
                    e = e2;
                    bufferedInputStream = bufferedInputStream2;
                    gsy.O000000o(6, "SendPrintActivity", "copyDocument error:" + Log.getStackTraceString(e));
                    fkw.O000000o((AutoCloseable) bufferedInputStream);
                    fkw.O000000o((AutoCloseable) bufferedOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = bufferedInputStream2;
                    fkw.O000000o((AutoCloseable) bufferedInputStream);
                    fkw.O000000o((AutoCloseable) bufferedOutputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream = null;
                gsy.O000000o(6, "SendPrintActivity", "copyDocument error:" + Log.getStackTraceString(e));
                fkw.O000000o((AutoCloseable) bufferedInputStream);
                fkw.O000000o((AutoCloseable) bufferedOutputStream);
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                fkw.O000000o((AutoCloseable) bufferedInputStream);
                fkw.O000000o((AutoCloseable) bufferedOutputStream);
                throw th;
            }
            fkw.O000000o((AutoCloseable) bufferedOutputStream);
        }
    }

    private HashMap<String, PluginDeviceInfo> O00000Oo() {
        HashMap<String, PluginDeviceInfo> hashMap = new HashMap<>();
        Map<String, PluginDeviceInfo> pluginInfoMap = PluginDeviceManager.instance.getPluginInfoMap();
        synchronized (pluginInfoMap) {
            for (Map.Entry<String, PluginDeviceInfo> value : pluginInfoMap.entrySet()) {
                PluginDeviceInfo pluginDeviceInfo = (PluginDeviceInfo) value.getValue();
                if (pluginDeviceInfo != null && pluginDeviceInfo.O0000oo0 == 124) {
                    hashMap.put(pluginDeviceInfo.O00000Oo(), pluginDeviceInfo);
                }
            }
        }
        final AtomicInteger atomicInteger = new AtomicInteger(hashMap.size());
        for (Map.Entry<String, PluginDeviceInfo> key : hashMap.entrySet()) {
            final String str = (String) key.getKey();
            hlz.O000000o(str, new fsm<hlz.O000000o, fso>() {
                /* class com.xiaomi.smarthome.printer.SendPrintActivity.AnonymousClass6 */

                public final void onFailure(fso fso) {
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    SendPrintActivity.this.f10539O000000o.put(str, ((hlz.O000000o) obj).f19057O000000o);
                    RecyclerView.O000000o adapter = SendPrintActivity.this.mRvContent.getAdapter();
                    if (atomicInteger.decrementAndGet() % 3 == 0 && adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                }
            });
        }
        return hashMap;
    }

    public void showLoading() {
        this.O00000o0.setVisibility(0);
        Drawable drawable = this.O00000o0.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    public void dismissLoading() {
        this.O00000Oo.setVisibility(0);
        Drawable drawable = this.O00000o0.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        this.O00000o0.setVisibility(8);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.module_a_3_return_btn) {
            onBackPressed();
        }
    }

    public void onLoadingFinish(boolean z) {
        if (z) {
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        fno.O000000o().O00000Oo(this.O0000OOo);
    }

    class O000000o extends RecyclerView.O000000o<O00000Oo> {

        /* renamed from: O000000o  reason: collision with root package name */
        final ArrayList<Device> f10548O000000o;
        private Home O00000o0 = ggb.O00000Oo().O0000Oo0();

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            final Device device = this.f10548O000000o.get(i);
            Home O0000o0 = ggb.O00000Oo().O0000o0(device.did);
            o00000Oo.f10550O000000o.setText(device.name);
            TextView textView = o00000Oo.O00000Oo;
            SendPrintActivity sendPrintActivity = SendPrintActivity.this;
            Object[] objArr = new Object[1];
            if (O0000o0 == null) {
                ggb.O00000Oo();
                O0000o0 = this.O00000o0;
            } else {
                ggb.O00000Oo();
            }
            objArr[0] = ggb.O000000o(O0000o0);
            textView.setText(sendPrintActivity.getString(R.string.app_printer_home, objArr));
            o00000Oo.O00000o0.setText(ggb.O00000Oo().O0000o0O(device.did));
            o00000Oo.O00000o.setImageURI(SendPrintActivity.this.f10539O000000o.get(device.model));
            o00000Oo.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.printer.SendPrintActivity.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    gsy.O00000o0(LogType.GENERAL, "SendPrintActivity", "openPrinter  clickItem");
                    Intent intent = SendPrintActivity.this.getIntent();
                    Bundle bundle = new Bundle();
                    bundle.putString("source_tag", "send_print");
                    intent.putExtras(bundle);
                    hme.O000000o(SendPrintActivity.this, device.model, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device), SendPrintActivity.this);
                }
            });
        }

        public O000000o(ArrayList<Device> arrayList) {
            this.f10548O000000o = arrayList;
            if (this.O00000o0 == null) {
                Home.O000000o o000000o = new Home.O000000o();
                o000000o.O0000O0o = SendPrintActivity.this.getString(R.string.default_home_name);
                this.O00000o0 = o000000o.O000000o();
            }
        }

        public final int getItemCount() {
            return this.f10548O000000o.size();
        }

        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O00000Oo(View.inflate(viewGroup.getContext(), R.layout.item_sendprint, null));
        }
    }

    class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f10550O000000o;
        TextView O00000Oo;
        SimpleDraweeView O00000o;
        TextView O00000o0;

        public O00000Oo(View view) {
            super(view);
            this.f10550O000000o = (TextView) view.findViewById(R.id.tv_name);
            this.O00000Oo = (TextView) view.findViewById(R.id.tv_device_desc);
            this.O00000o0 = (TextView) view.findViewById(R.id.tv_room);
            this.O00000o = (SimpleDraweeView) view.findViewById(R.id.ivImage);
        }
    }
}
