package com.mi.util;

import _m_j.ccr;
import _m_j.cdw;
import _m_j.cdy;
import _m_j.cec;
import _m_j.cee;
import _m_j.ceg;
import _m_j.cej;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.cundong.utils.PatchUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.mi.model.UpdaterInfo;
import com.mi.widget.BaseAlertDialog;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class AppUpdater {
    public Context mContext;
    private Handler mHandler = new Handler();
    private String mMd5;
    private String mPatchUrl;
    public String mURL;
    public Timer mUpdateTimer;
    private int mVersionCode;

    public interface O00000Oo {
    }

    protected static void installApk(Context context, Uri uri) {
    }

    public AppUpdater(Context context) {
        this.mContext = context;
    }

    public AppUpdater(Context context, UpdaterInfo updaterInfo) {
        this.mContext = context;
        this.mURL = updaterInfo.O00000Oo;
        this.mMd5 = updaterInfo.O00000o0;
        this.mVersionCode = updaterInfo.O00000oo;
        this.mPatchUrl = updaterInfo.O00000o;
    }

    public boolean needCheck() {
        long currentTimeMillis = System.currentTimeMillis();
        long O000000o2 = cej.O00000Oo.O000000o(this.mContext, "pref_last_check_update");
        ccr.O00000Oo("AppUpdater", "lastCheck:" + O000000o2 + ", now:" + currentTimeMillis);
        if (currentTimeMillis - O000000o2 < DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
            return false;
        }
        cej.O00000Oo.O000000o(this.mContext, "pref_last_check_update", Long.valueOf(currentTimeMillis));
        long O000000o3 = cej.O00000Oo.O000000o(this.mContext, "pref_last_update_is_ok");
        ccr.O00000Oo("AppUpdater", "lastUpdate:".concat(String.valueOf(O000000o3)));
        if (currentTimeMillis - O000000o3 < 3600000) {
            return false;
        }
        return true;
    }

    public void sendCheckApkUpdateService(boolean z) {
        if (z) {
            sendCheckApkUpdateService();
        } else if (needCheck()) {
            this.mHandler.postDelayed(new Runnable() {
                /* class com.mi.util.AppUpdater.AnonymousClass1 */

                public final void run() {
                    AppUpdater.this.sendCheckApkUpdateService();
                }
            }, 10000);
        }
    }

    public void sendCheckApkUpdateService() {
        if (this.mContext == null) {
        }
    }

    public void download(String str) {
        download(str, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
      _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
    public void download(String str, boolean z) {
        ccr.O00000Oo("AppUpdater", "download url:".concat(String.valueOf(str)));
        if (!TextUtils.isEmpty(str) && str.startsWith("https://play.google.com/")) {
            this.mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } else if (!Environment.getExternalStorageState().equals("mounted")) {
            cec.O000000o(this.mContext, (int) R.string.update_no_sd, 0);
        } else {
            long O000000o2 = cej.O00000Oo.O000000o(this.mContext, "pref_download_id");
            int downloadStatusById = getDownloadStatusById(this.mContext, O000000o2);
            if (downloadStatusById != 2 && downloadStatusById != 1) {
                if (downloadStatusById == 4) {
                    ((DownloadManager) this.mContext.getSystemService("download")).remove(O000000o2);
                }
                cej.O00000Oo.O000000o(this.mContext, "pref_download_md5", this.mMd5);
                cej.O00000Oo.O000000o(this.mContext, "pref_download_url", this.mURL);
                cej.O00000Oo.O00000Oo(this.mContext, "pref_download_version", this.mVersionCode);
                if (TextUtils.isEmpty(this.mPatchUrl)) {
                    cej.O00000Oo.O00000Oo(this.mContext, "pref_download_patch_update", false);
                } else {
                    cej.O00000Oo.O00000Oo(this.mContext, "pref_download_patch_update", true);
                    str = this.mPatchUrl;
                }
                new O000000o(this.mContext, this.mVersionCode, this.mMd5, str, false, z).execute(new String[0]);
            }
        }
    }

    public int getDownloadStatusById(Context context, long j) {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(j);
        Cursor query2 = ((DownloadManager) context.getSystemService("download")).query(query);
        int i = -1;
        if (query2 == null) {
            return -1;
        }
        try {
            int columnIndex = query2.getColumnIndex("status");
            if (query2.moveToFirst()) {
                i = query2.getInt(columnIndex);
            }
            return i;
        } finally {
            query2.close();
        }
    }

    public static boolean canDownloadState(Context context) {
        try {
            int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
            return (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
    public static void requestDownload(Context context, String str, boolean z, boolean z2) {
        String str2;
        ccr.O00000Oo("AppUpdater", "requestDownload url:".concat(String.valueOf(str)));
        if (!z) {
            cec.O000000o(context, (int) R.string.start_download, 1);
        }
        try {
            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.allowScanningByMediaScanner();
            request.setVisibleInDownloadsUi(true);
            request.setNotificationVisibility(z2 ? 0 : 2);
            int O000000o2 = cej.O00000Oo.O000000o(context, "pref_download_version", 0);
            if (cej.O00000Oo.O000000o(context, "pref_download_patch_update", false)) {
                str2 = String.format("%s_%s_patch.apk", Device.O0000o, Integer.valueOf(O000000o2));
            } else {
                str2 = String.format("%s_%s.apk", Device.O0000o, Integer.valueOf(O000000o2));
            }
            request.setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, str2);
            request.setTitle(context.getResources().getString(R.string.app_name));
            request.setDescription(context.getResources().getString(R.string.self_confirm_dowloading));
            cej.O00000Oo.O000000o(context, "pref_download_id", Long.valueOf(downloadManager.enqueue(request)));
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void loadVersionLogAndPopDialog(UpdaterInfo updaterInfo) {
        this.mURL = updaterInfo.O00000Oo;
        this.mMd5 = updaterInfo.O00000o0;
        this.mVersionCode = updaterInfo.O00000oo;
        this.mPatchUrl = updaterInfo.O00000o;
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setPadding(0, 0, 0, cdy.O000000o(13.0f));
        linearLayout.setOrientation(1);
        linearLayout.removeAllViews();
        ArrayList<UpdaterInfo.DescType> arrayList = updaterInfo.f5088O000000o;
        for (int i = 0; i < arrayList.size(); i++) {
            View inflate = LayoutInflater.from(this.mContext).inflate((int) R.layout.update_list_item, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(R.id.update_log_type);
            TextView textView2 = (TextView) inflate.findViewById(R.id.update_log_desc);
            textView.setText(arrayList.get(i).mDescType);
            if (TextUtils.isEmpty(arrayList.get(i).mDescType)) {
                textView.setVisibility(8);
            }
            textView2.setText(arrayList.get(i).mDesc);
            linearLayout.addView(inflate);
        }
        if (updaterInfo.O0000O0o) {
            ccr.O00000Oo("AppUpdater", "forceUpdate");
            popForceUpdateDialog(linearLayout);
            return;
        }
        popUpdateDialog(linearLayout);
    }

    @TargetApi(16)
    private void popForceUpdateDialog(View view) {
        final BaseAlertDialog baseAlertDialog = new BaseAlertDialog(this.mContext);
        baseAlertDialog.setTitle((int) R.string.update_log_title);
        baseAlertDialog.O000000o(view);
        baseAlertDialog.setCanceledOnTouchOutside(false);
        baseAlertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.mi.util.AppUpdater.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                ccr.O00000Oo("AppUpdater", "CANCEL DIALOG");
                dialogInterface.cancel();
                dialogInterface.dismiss();
                cej.O00000Oo.O000000o(AppUpdater.this.mContext, "pref_last_check_update", Long.valueOf(System.currentTimeMillis() - DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS));
                if (Build.VERSION.SDK_INT >= 16) {
                    ((Activity) AppUpdater.this.mContext).finishAffinity();
                } else {
                    System.exit(0);
                }
            }
        });
        AnonymousClass3 r1 = new View.OnClickListener() {
            /* class com.mi.util.AppUpdater.AnonymousClass3 */

            public final void onClick(View view) {
                cej.O00000Oo.O000000o(AppUpdater.this.mContext, "pref_last_check_update", Long.valueOf(System.currentTimeMillis() - DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS));
                AppUpdater appUpdater = AppUpdater.this;
                appUpdater.download(appUpdater.mURL);
            }
        };
        baseAlertDialog.O0000Oo0.setVisibility(0);
        baseAlertDialog.O0000OOo.setVisibility(8);
        baseAlertDialog.O00000oo.setText((int) R.string.immediately_update);
        baseAlertDialog.O00000oo.setOnClickListener(new BaseAlertDialog.O000000o(r1));
        this.mHandler.postDelayed(new Runnable() {
            /* class com.mi.util.AppUpdater.AnonymousClass4 */

            public final void run() {
                if (AppUpdater.this.mContext != null && !((Activity) AppUpdater.this.mContext).isFinishing()) {
                    baseAlertDialog.show();
                }
            }
        }, 1000);
    }

    private void popUpdateDialog(View view) {
        final BaseAlertDialog baseAlertDialog = new BaseAlertDialog(this.mContext);
        baseAlertDialog.setTitle((int) R.string.update_log_title);
        baseAlertDialog.O000000o(view);
        baseAlertDialog.setCanceledOnTouchOutside(true);
        AnonymousClass5 r5 = new View.OnClickListener() {
            /* class com.mi.util.AppUpdater.AnonymousClass5 */

            public final void onClick(View view) {
                AppUpdater appUpdater = AppUpdater.this;
                appUpdater.download(appUpdater.mURL);
            }
        };
        baseAlertDialog.O0000OOo.setVisibility(0);
        baseAlertDialog.O00000o.setVisibility(0);
        baseAlertDialog.O00000oO.getVisibility();
        baseAlertDialog.O00000o.setText((int) R.string.immediately_update);
        baseAlertDialog.O00000o.setOnClickListener(new BaseAlertDialog.O000000o(r5));
        AnonymousClass6 r52 = new View.OnClickListener() {
            /* class com.mi.util.AppUpdater.AnonymousClass6 */

            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis() + 3600000;
                cej.O00000Oo.O000000o(AppUpdater.this.mContext, "pref_last_check_update", Long.valueOf(currentTimeMillis));
                ccr.O00000Oo("AppUpdater", "cancel update, set last_check_update_time::" + currentTimeMillis);
            }
        };
        baseAlertDialog.O00000oO.setVisibility(0);
        baseAlertDialog.O0000OOo.setVisibility(0);
        baseAlertDialog.O00000o.getVisibility();
        baseAlertDialog.O00000oO.setText((int) R.string.cancel_update);
        baseAlertDialog.O00000oO.setOnClickListener(new BaseAlertDialog.O000000o(r52));
        this.mHandler.postDelayed(new Runnable() {
            /* class com.mi.util.AppUpdater.AnonymousClass7 */

            public final void run() {
                if (AppUpdater.this.mContext != null && !((Activity) AppUpdater.this.mContext).isFinishing()) {
                    baseAlertDialog.show();
                }
            }
        }, 1000);
    }

    public static class DownloadCompletedReceiver extends BroadcastReceiver {
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean
         arg types: [android.content.Context, java.lang.String, int]
         candidates:
          _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, int):int
          _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.Long):void
          _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, java.lang.String):void
          _m_j.cej.O00000Oo.O000000o(android.content.Context, java.lang.String, boolean):boolean */
        public void onReceive(Context context, Intent intent) {
            Uri uri;
            String action = intent.getAction();
            ccr.O00000Oo("AppUpdater", "receive download broadcast");
            if ("android.intent.action.DOWNLOAD_COMPLETE".equals(action)) {
                long O000000o2 = cej.O00000Oo.O000000o(context, "pref_download_id");
                long longExtra = intent.getLongExtra("extra_download_id", 0);
                if (longExtra == O000000o2) {
                    String O000000o3 = O000000o(context, longExtra);
                    if (TextUtils.isEmpty(O000000o3)) {
                        return;
                    }
                    if (cej.O00000Oo.O000000o(context, "pref_download_patch_update", false)) {
                        new O00000o0(context, O000000o3, longExtra).execute(new String[0]);
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        try {
                            uri = FileProvider.getUriForFile(context, cee.O000000o("file_provider_authorities"), new File(new URI(O000000o3)));
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                            cec.O000000o(context, e.getMessage(), 0);
                            return;
                        }
                    } else {
                        uri = Uri.parse(O000000o3);
                    }
                    AppUpdater.installApk(context, uri);
                }
            }
        }

        private static String O000000o(Context context, long j) {
            boolean z;
            String str;
            Notification notification;
            Notification.Builder builder;
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(j);
            Cursor query2 = ((DownloadManager) context.getSystemService("download")).query(query);
            String str2 = null;
            if (query2 == null) {
                return null;
            }
            try {
                int columnIndex = query2.getColumnIndex("status");
                int columnIndex2 = query2.getColumnIndex("local_uri");
                if (query2.moveToFirst()) {
                    while (true) {
                        if (8 != query2.getInt(columnIndex)) {
                            if (16 != query2.getInt(columnIndex)) {
                                if (!query2.moveToNext()) {
                                    break;
                                }
                            } else {
                                str = null;
                                z = true;
                                break;
                            }
                        } else {
                            str2 = query2.getString(columnIndex2);
                            break;
                        }
                    }
                    str = str2;
                    z = false;
                    if (z) {
                        String string = context.getString(R.string.download_failed_title);
                        String string2 = context.getString(R.string.download_failed_tips);
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW_DOWNLOADS");
                        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
                        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                        if (Build.VERSION.SDK_INT >= 16) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                builder = new Notification.Builder(context, "message");
                            } else {
                                builder = new Notification.Builder(context);
                            }
                            notification = builder.setContentTitle(string).setContentText(string2).setSmallIcon((int) R.drawable.app_icon).setAutoCancel(true).setDefaults(1).setContentIntent(activity).build();
                        } else {
                            NotificationCompat.Builder O00000Oo = new NotificationCompat.Builder(context, "message").O000000o(string).O00000Oo(string2).O000000o((int) R.drawable.app_icon).O00000Oo().O00000Oo(1);
                            O00000Oo.O00000oo = activity;
                            notification = O00000Oo.O00000o();
                        }
                        notificationManager.notify(R.string.download_failed_id, notification);
                    }
                    str2 = str;
                }
                return str2;
            } finally {
                query2.close();
            }
        }
    }

    static class O00000o0 extends AsyncTask<String, Void, Integer> {

        /* renamed from: O000000o  reason: collision with root package name */
        private Context f5098O000000o;
        private String O00000Oo;
        private int O00000o;
        private long O00000o0;
        private String O00000oO;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return O000000o();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void
         arg types: [android.content.Context, java.lang.String, int]
         candidates:
          _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, java.lang.String):java.lang.String
          _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, int):void
          _m_j.cej.O00000Oo.O00000Oo(android.content.Context, java.lang.String, boolean):void */
        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Integer num = (Integer) obj;
            super.onPostExecute(num);
            if (num.intValue() != 1) {
                cej.O00000Oo.O00000Oo(this.f5098O000000o, "pref_download_patch_update", false);
                new O000000o(this.f5098O000000o, this.O00000o, this.O00000oO, cej.O00000Oo.O00000Oo(this.f5098O000000o, "pref_download_url", (String) null), true, true).execute(new String[0]);
            }
        }

        public O00000o0(Context context, String str, long j) {
            this.f5098O000000o = context;
            this.O00000Oo = str;
            this.O00000o0 = j;
            this.O00000oO = cej.O00000Oo.O00000Oo(context, "pref_download_md5", (String) null);
            this.O00000o = cej.O00000Oo.O000000o(context, "pref_download_version", 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x006b  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00a3  */
        private Integer O000000o() {
            int i;
            Uri uri;
            Context context = this.f5098O000000o;
            String O00000Oo2 = cdw.O00000Oo(context, context.getPackageName());
            if (TextUtils.isEmpty(O00000Oo2)) {
                return -3;
            }
            String format = String.format("%s/%s_%s.apk", this.f5098O000000o.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), Device.O0000o, Integer.valueOf(this.O00000o));
            File file = null;
            try {
                file = new File(new URI(this.O00000Oo));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            if (file != null) {
                try {
                    i = PatchUtils.patch(O00000Oo2, format, file.getAbsolutePath());
                } catch (UnsatisfiedLinkError e2) {
                    e2.printStackTrace();
                }
                ((DownloadManager) this.f5098O000000o.getSystemService("download")).remove(this.O00000o0);
                if (i == 0) {
                    return -2;
                }
                if (!ceg.O000000o(format, this.O00000oO)) {
                    return -1;
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    uri = FileProvider.getUriForFile(this.f5098O000000o, cee.O000000o("file_provider_authorities"), new File(format));
                } else {
                    uri = Uri.fromFile(new File(format));
                }
                AppUpdater.installApk(this.f5098O000000o, uri);
                return 1;
            }
            i = -1;
            ((DownloadManager) this.f5098O000000o.getSystemService("download")).remove(this.O00000o0);
            if (i == 0) {
            }
        }
    }

    public void updateViews(final O00000Oo o00000Oo) {
        Timer timer = this.mUpdateTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mUpdateTimer = new Timer();
        final DownloadManager downloadManager = (DownloadManager) this.mContext.getSystemService("download");
        this.mUpdateTimer.schedule(new TimerTask() {
            /* class com.mi.util.AppUpdater.AnonymousClass8 */

            public final void run() {
                int i;
                long O000000o2 = cej.O00000Oo.O000000o(AppUpdater.this.mContext, "pref_download_id");
                int i2 = 0;
                Cursor query = downloadManager.query(new DownloadManager.Query().setFilterById(O000000o2));
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            i2 = query.getInt(query.getColumnIndex("bytes_so_far"));
                            i = query.getInt(query.getColumnIndex("total_size"));
                            if (16 == query.getInt(query.getColumnIndex("status"))) {
                                AppUpdater.this.updateProgressFailed(o00000Oo);
                            }
                        } else {
                            i = 0;
                        }
                        query.close();
                        if (i != 0 && (i2 * 100) / i == 100) {
                            AppUpdater.this.mUpdateTimer.cancel();
                        }
                    } catch (Exception e) {
                        Log.d("", e.toString());
                    }
                }
            }
        }, 0, 300);
    }

    public void updateProgressFailed(O00000Oo o00000Oo) {
        Timer timer = this.mUpdateTimer;
        if (timer != null) {
            timer.cancel();
        }
    }

    static class O000000o extends AsyncTask<String, Void, Boolean> {

        /* renamed from: O000000o  reason: collision with root package name */
        private Context f5097O000000o;
        private int O00000Oo;
        private String O00000o;
        private String O00000o0;
        private boolean O00000oO;
        private boolean O00000oo;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Boolean bool = (Boolean) obj;
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                return;
            }
            if (!AppUpdater.canDownloadState(this.f5097O000000o)) {
                cec.O000000o(this.f5097O000000o, (int) R.string.open_download, 1);
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:".concat("com.android.providers.downloads")));
                this.f5097O000000o.startActivity(intent);
                return;
            }
            AppUpdater.requestDownload(this.f5097O000000o, this.O00000o, this.O00000oO, this.O00000oo);
        }

        public O000000o(Context context, int i, String str, String str2, boolean z, boolean z2) {
            this.f5097O000000o = context;
            this.O00000Oo = i;
            this.O00000o0 = str;
            this.O00000o = str2;
            this.O00000oO = z;
            this.O00000oo = z2;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            Uri uri;
            String format = String.format("%s/%s_%s.apk", this.f5097O000000o.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), Device.O0000o, Integer.valueOf(this.O00000Oo));
            File file = new File(format);
            if (file.exists() && file.isFile()) {
                if (TextUtils.isEmpty(this.O00000o0) || !ceg.O000000o(format, this.O00000o0)) {
                    file.delete();
                } else {
                    if (Build.VERSION.SDK_INT >= 24) {
                        uri = FileProvider.getUriForFile(this.f5097O000000o, cee.O000000o("file_provider_authorities"), file);
                    } else {
                        uri = Uri.fromFile(file);
                    }
                    AppUpdater.installApk(this.f5097O000000o, uri);
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
    }

    static {
        try {
            System.loadLibrary("ApkPatchLibrary");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }
}
