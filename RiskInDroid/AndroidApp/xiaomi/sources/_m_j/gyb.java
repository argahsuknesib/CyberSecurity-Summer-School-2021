package _m_j;

import _m_j.gof;
import _m_j.gyc;
import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.core.app.NotificationCompat;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

@RouterService
public class gyb implements gyc {
    static gyb instance;
    final BroadcastReceiver appUpdateReceiver = new BroadcastReceiver() {
        /* class _m_j.gyb.AnonymousClass4 */

        public final void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("status");
            if (TextUtils.isEmpty(stringExtra) || gyb.this.mForceDialog == null) {
                return;
            }
            if (stringExtra.equals("progress")) {
                int intExtra = intent.getIntExtra("progress", 0);
                if (intExtra > 0 && intExtra < 100) {
                    Button button = gyb.this.mForceDialog.getButton(-1);
                    button.setText(gyb.this.mAppContext.getResources().getQuantityString(R.plurals.upgrade_pkg_downloaded_is_downloading, intExtra, Integer.valueOf(intExtra)) + "%");
                }
            } else if (stringExtra.equals("success")) {
                if (gyb.this.getmForceUpdate() == 1) {
                    gyb.this.mForceDialog.getButton(-1).setText((int) R.string.update_install);
                    gyb.this.mForceDialog.getButton(-1).setEnabled(true);
                    gyb.this.mForceDialog.getButton(-1).setOnClickListener(new View.OnClickListener() {
                        /* class _m_j.gyb.AnonymousClass4.AnonymousClass1 */

                        public final void onClick(View view) {
                            gyb.this.startInstallApkIntent(gyb.this.mAppContext);
                        }
                    });
                } else if (gyb.this.getmForceUpdate() == 2) {
                    gyb gyb = gyb.this;
                    gyb.closeDialog(gyb.mForceDialog);
                }
                gyb gyb2 = gyb.this;
                gyb2.startInstallApkIntent(gyb2.mAppContext);
            } else {
                gyb gyb3 = gyb.this;
                gyb3.closeDialog(gyb3.mForceDialog);
                izb.O000000o(gyb.this.mAppContext, (int) R.string.app_upgrade_failed_smarthome, 0).show();
            }
        }
    };
    private boolean isInstalling = false;
    Context mAppContext = CommonApplication.getAppContext();
    O00000Oo mAppDownloadTask = null;
    String mDownloadPath = null;
    MLAlertDialog mForceDialog = null;
    int mForceUpdate = 0;
    boolean mHasNewVersion = false;
    boolean mIsDownloading = false;
    int mNewVersionCode;
    String mNewVersionDesc;
    String mNewVersionName;
    String mNewVersionUrl;
    NotificationManager mNotificationManager;
    int mProgress = 0;
    JSONObject mResult;

    public interface O000000o {
        void O000000o();

        void O000000o(int i);

        void O00000Oo();
    }

    public void startInstallApkIntent(Context context) {
    }

    @cug
    public static gyb getInstance() {
        if (instance == null) {
            instance = new gyb();
        }
        return instance;
    }

    public boolean isNewVersionIgnore() {
        if (hasNewVersion() && gpv.O000000o(CommonApplication.getAppContext(), "app_ignore_version_code") != getNewVersionCode()) {
            return false;
        }
        return true;
    }

    public synchronized void ignoreThisNewVersion() {
        gpv.O000000o(CommonApplication.getAppContext(), "app_ignore_version_code", getNewVersionCode());
    }

    public boolean hasNewVersion() {
        return this.mHasNewVersion;
    }

    public boolean isForceUpdate() {
        return this.mForceUpdate == 1;
    }

    public String getNewVersionName() {
        return this.mNewVersionName;
    }

    public int getNewVersionCode() {
        return this.mNewVersionCode;
    }

    public String getNewVersionDesc() {
        return this.mNewVersionDesc;
    }

    public String getNewVersionUrl() {
        return this.mNewVersionUrl;
    }

    public int getmForceUpdate() {
        return this.mForceUpdate;
    }

    public void notifyUIRefresh(gyc.O000000o o000000o) {
        if (o000000o != null) {
            o000000o.O000000o();
        }
    }

    public void notifyFailed(gyc.O000000o o000000o) {
        if (o000000o != null) {
            o000000o.O00000Oo();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a  */
    public void checkUpdate(gyc.O000000o o000000o) {
        int i;
        String str;
        boolean z;
        Context appContext = CommonApplication.getAppContext();
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            i = packageInfo.versionCode;
            try {
                str = packageInfo.versionName;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            i = 0;
            str = null;
            z = true;
            fvo.O000000o();
            if (!fvo.O00000Oo()) {
            }
            if (!z) {
            }
        }
        z = true;
        if (gfr.O0000o0o || gfr.O0000OOo) {
            fvo.O000000o();
            if (!fvo.O00000Oo()) {
                i = 1000;
                str = "1.1.1";
            } else {
                z = false;
            }
        }
        if (!z) {
            getInstance().getGrayUpdateInfo(str, i, o000000o);
        } else {
            getInstance().getInnerUpdateInfo(str, i, o000000o);
        }
    }

    public void getGrayUpdateInfo(final String str, final int i, final gyc.O000000o o000000o) {
        String packageName = CommonApplication.getAppContext().getPackageName();
        gfb O000000o2 = gfb.O000000o();
        Context appContext = CommonApplication.getAppContext();
        O000000o2.O00000Oo(appContext, packageName + ".gray", str, i, new fsm<JSONObject, fso>() {
            /* class _m_j.gyb.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    Log.d("AppUpdateManger", "getGrayUpdateInfo  ---onsuccess:".concat(String.valueOf(jSONObject)));
                    if (jSONObject.optInt("new_version") >= 0) {
                        gyb gyb = gyb.this;
                        gyb.mHasNewVersion = true;
                        gyb.parseInfoFromJson(jSONObject);
                        gyb.this.notifyUIRefresh(o000000o);
                        return;
                    }
                    gyb.this.getNormalUpdateInfo(CommonApplication.getAppContext(), str, i, o000000o);
                }
            }

            public final void onFailure(fso fso) {
                Log.d("AppUpdateManger", "getGrayUpdateInfo:--onFailure");
                gyb.this.getNormalUpdateInfo(CommonApplication.getAppContext(), str, i, o000000o);
            }
        });
    }

    private void getInnerUpdateInfo(String str, int i, final gyc.O000000o o000000o) {
        CommonApplication.getAppContext().getPackageName();
        grr.O000000o();
        grr.O00000o0(CommonApplication.getAppContext());
        grr.O000000o();
        grr.O00000o(CommonApplication.getAppContext());
        gfb O000000o2 = gfb.O000000o();
        Context appContext = CommonApplication.getAppContext();
        AnonymousClass5 r5 = new fsm<gfd, fso>() {
            /* class _m_j.gyb.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str;
                String str2;
                gfd gfd = (gfd) obj;
                if (gfd == null) {
                    gyb.this.notifyFailed(o000000o);
                } else if (TextUtils.isEmpty(gfd.f17649O000000o) || TextUtils.isEmpty(gfd.O00000Oo) || TextUtils.isEmpty(gfd.O00000o0) || TextUtils.isEmpty(gfd.O00000o) || TextUtils.isEmpty(gfd.O00000oO) || TextUtils.isEmpty(gfd.O00000oo)) {
                    gyb.this.notifyFailed(o000000o);
                } else if (gfr.O00000o0 <= 0) {
                    gyb.this.notifyFailed(o000000o);
                } else {
                    if (gfr.O0000OOo) {
                        str2 = gfd.f17649O000000o;
                        str = gfd.O00000Oo;
                    } else if (gfr.O0000Oo) {
                        str2 = gfd.O00000o0;
                        str = gfd.O00000o;
                    } else if (gfr.O0000Oo0) {
                        str2 = gfd.O00000oO;
                        str = gfd.O00000oo;
                    } else {
                        gyb.this.notifyFailed(o000000o);
                        return;
                    }
                    String[] split = str2.split("-");
                    int parseInt = Integer.parseInt(split[2]);
                    String str3 = split[3];
                    int parseInt2 = Integer.parseInt(split[4]);
                    grr.O000000o();
                    int O00000o0 = grr.O00000o0(CommonApplication.getAppContext());
                    if (O00000o0 < parseInt || (O00000o0 == parseInt && gfr.O00000o0 < parseInt2)) {
                        gev gev = new gev();
                        gev.O00000Oo = true;
                        gev.O00000o0 = parseInt;
                        gev.O00000o = str3 + "-" + parseInt2 + "-DB";
                        gev.O00000oO = str;
                        gev.O00000oo = "";
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("download_url", gev.O00000oO);
                            jSONObject.put("change_log", "DB");
                            jSONObject.put("new_version_name", gev.O00000o);
                            jSONObject.put("new_version_code", gev.O00000o0);
                            gyb.this.mHasNewVersion = true;
                            gyb.this.parseInfoFromJson(jSONObject);
                            gyb.this.notifyUIRefresh(o000000o);
                        } catch (JSONException unused) {
                            gyb.this.notifyFailed(o000000o);
                        }
                    } else {
                        gyb.this.notifyFailed(o000000o);
                    }
                }
            }

            public final void onFailure(fso fso) {
                gyb.this.notifyFailed(o000000o);
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", new JSONObject().toString()));
        CoreApi.O000000o().O000000o(appContext, new NetRequest.O000000o().O000000o("POST").O00000Oo("/service/getdailybuild").O000000o(arrayList).O000000o(), new fss<gfd>() {
            /* class _m_j.gfb.AnonymousClass14 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) {
                gfd gfd = new gfd();
                JSONObject jSONObject2 = jSONObject.getJSONObject("debug");
                String string = jSONObject2.getString("version");
                String string2 = jSONObject2.getString("url");
                String string3 = jSONObject.getJSONObject("sdk").getString("version");
                String string4 = jSONObject2.getString("url");
                JSONObject jSONObject3 = jSONObject.getJSONObject("release");
                String string5 = jSONObject3.getString("version");
                String string6 = jSONObject3.getString("url");
                gfd.f17649O000000o = string;
                gfd.O00000Oo = string2;
                gfd.O00000o0 = string3;
                gfd.O00000o = string4;
                gfd.O00000oO = string5;
                gfd.O00000oo = string6;
                return gfd;
            }
        }, Crypto.RC4, r5);
    }

    public void getNormalUpdateInfo(Context context, String str, int i, final gyc.O000000o o000000o) {
        gfb.O000000o().O00000o(context, str, i, new fsm<JSONObject, fso>() {
            /* class _m_j.gyb.AnonymousClass6 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    Log.d("AppUpdateManger", "getNormalUpdateInfo:".concat(String.valueOf(jSONObject)));
                    if (jSONObject.optInt("new_version") >= 0) {
                        gyb gyb = gyb.this;
                        gyb.mHasNewVersion = true;
                        gyb.parseInfoFromJson(jSONObject);
                        gyb.this.notifyUIRefresh(o000000o);
                        return;
                    }
                    gyb gyb2 = gyb.this;
                    gyb2.mHasNewVersion = false;
                    gyb2.parseInfoFromJson(jSONObject);
                    gyb.this.notifyUIRefresh(o000000o);
                }
            }

            public final void onFailure(fso fso) {
                gyb.this.notifyFailed(o000000o);
            }
        });
    }

    public static class O00000Oo extends AsyncTask<Object, Long, gof.O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        ftt<Void> f18533O000000o;
        Bitmap O00000Oo;
        String O00000o;
        String O00000o0;
        NotificationManager O00000oO;
        O000000o O00000oo;
        int O0000O0o = 0;
        Context O0000OOo;
        boolean O0000Oo0 = false;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            gof.O000000o o000000o = (gof.O000000o) obj;
            if (this.O0000Oo0) {
                gyb.getInstance().cancelUpdateNotification();
            }
            if (o000000o.O00000Oo == 3) {
                O000000o o000000o2 = this.O00000oo;
                if (o000000o2 != null) {
                    o000000o2.O000000o();
                    return;
                }
                return;
            }
            O000000o o000000o3 = this.O00000oo;
            if (o000000o3 != null) {
                o000000o3.O00000Oo();
            }
            if (this.O0000Oo0) {
                izb.O000000o(this.O0000OOo, (int) R.string.app_upgrade_failed_smarthome, 0).show();
            }
        }

        O00000Oo(Context context, boolean z, String str, Bitmap bitmap, String str2, NotificationManager notificationManager, O000000o o000000o) {
            this.O0000OOo = context;
            this.O00000o0 = str;
            this.O00000Oo = bitmap;
            this.O00000o = str2;
            this.O00000oO = notificationManager;
            this.O00000oo = o000000o;
            this.O0000Oo0 = z;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onProgressUpdate(Object[] objArr) {
            O000000o o000000o;
            if (this.O0000Oo0 && (o000000o = this.O00000oo) != null) {
                o000000o.O000000o(this.O0000O0o);
            }
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            if (isCancelled()) {
                return null;
            }
            this.f18533O000000o = (ftt) objArr[0];
            gsc.O00000Oo(new File(this.O00000o));
            return gof.O000000o(this.O0000OOo, this.O00000o0, new File(this.O00000o), new gof.O00000o() {
                /* class _m_j.gyb.O00000Oo.AnonymousClass1 */
                private int O00000Oo = 0;

                public final void O000000o(long j, long j2) {
                    Notification notification;
                    Notification notification2;
                    int i = (int) ((100 * j) / j2);
                    if (i / 4 != this.O00000Oo / 4) {
                        this.O00000Oo = i;
                        Log.d("AppUpdateManger", String.format("before percent:%d  downloaded:%d  progress:%d", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(O00000Oo.this.O0000O0o)));
                        if (O00000Oo.this.O0000O0o != i) {
                            int abs = Math.abs(O00000Oo.this.O0000O0o - i);
                            O00000Oo o00000Oo = O00000Oo.this;
                            o00000Oo.O0000O0o = i;
                            if (abs > 0) {
                                o00000Oo.publishProgress(Long.valueOf((long) o00000Oo.O0000O0o));
                            }
                        }
                        Log.d("AppUpdateManger", String.format("after percent:%d  downloaded:%d  progress:%d", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(O00000Oo.this.O0000O0o)));
                        if (!O00000Oo.this.O0000Oo0) {
                            return;
                        }
                        if (gnn.O00000o) {
                            O00000Oo o00000Oo2 = O00000Oo.this;
                            Log.d("AppUpdateManger", "sendDownloadNotification");
                            if (o00000Oo2.O00000oO != null) {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    notification2 = new Notification.Builder(o00000Oo2.O0000OOo, fke.O000000o(o00000Oo2.O00000oO, o00000Oo2.O0000OOo)).build();
                                } else {
                                    NotificationCompat.Builder builder = new NotificationCompat.Builder(o00000Oo2.O0000OOo);
                                    builder.O00000Oo();
                                    builder.O0000o00 = false;
                                    builder.O000000o(o00000Oo2.O0000OOo.getString(R.string.upgrade_pkg_downloaded_title_smarthome) + o00000Oo2.O0000O0o + "%");
                                    builder.O00000Oo(o00000Oo2.O0000OOo.getString(R.string.upgrade_pkg_downloaded_title_smarthome) + o00000Oo2.O0000O0o + "%");
                                    builder.O000000o(o00000Oo2.O00000Oo);
                                    builder.O000000o((int) R.drawable.mj_notify_icon);
                                    notification2 = builder.O00000o();
                                }
                                if (o00000Oo2.O00000oO != null) {
                                    o00000Oo2.O00000oO.notify(257, notification2);
                                }
                            }
                        } else if (O00000Oo.this.O00000oO != null) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                notification = new Notification.Builder(O00000Oo.this.O0000OOo, fke.O000000o(O00000Oo.this.O00000oO, O00000Oo.this.O0000OOo)).build();
                            } else {
                                notification = new Notification();
                            }
                            notification.icon = R.drawable.mj_notify_icon;
                            notification.tickerText = O00000Oo.this.O0000OOo.getString(R.string.upgrade_pkg_downloaded_title_smarthome);
                            notification.flags &= -17;
                            O00000Oo.this.O00000oO.notify(R.drawable.mj_ic_launcher, notification);
                        }
                    }
                }
            });
        }
    }

    public void cancelDownloadTask() {
        O00000Oo o00000Oo = this.mAppDownloadTask;
        if (o00000Oo != null && !o00000Oo.isCancelled()) {
            Log.d("AppUpdateManger", "cancelDownloadTask");
            this.mAppDownloadTask.cancel(true);
        }
    }

    public void cancelUpdateNotification() {
        StringBuilder sb = new StringBuilder("cancelUpdateNotification");
        sb.append(this.mNotificationManager == null);
        Log.d("AppUpdateManger", sb.toString());
        NotificationManager notificationManager = this.mNotificationManager;
        if (notificationManager != null) {
            notificationManager.cancel(257);
            return;
        }
        NotificationManager notificationManager2 = (NotificationManager) CommonApplication.getAppContext().getSystemService("notification");
        if (notificationManager2 != null) {
            notificationManager2.cancel(257);
        }
    }

    public void showNorifyProgress(boolean z) {
        O00000Oo o00000Oo = this.mAppDownloadTask;
        if (o00000Oo != null) {
            o00000Oo.O0000Oo0 = z;
        }
    }

    public boolean hasDownloadedNewVersionApk(Context context, int i) {
        String str = getDownloadPath(context) + ".apk";
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return false;
        }
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, android.support.v4.app.NotificationCompat.FLAG_HIGH_PRIORITY);
            if (packageArchiveInfo != null && packageArchiveInfo.versionCode >= i) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static String getDownloadPath(Context context) {
        String path = ("mounted".equals(Environment.getExternalStorageState()) || !goa.O000000o()) ? goa.O000000o(context).getPath() : null;
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return path + "/new_version";
    }

    public void startDownloadApk(final Context context, boolean z, String str, Bitmap bitmap) {
        if (!this.mIsDownloading) {
            this.mDownloadPath = getDownloadPath(context);
            if (!TextUtils.isEmpty(this.mDownloadPath)) {
                AnonymousClass7 r8 = new O000000o() {
                    /* class _m_j.gyb.AnonymousClass7 */

                    public final void O000000o() {
                        gyb.this.mIsDownloading = false;
                        File file = new File(gyb.getDownloadPath(context));
                        if (file.exists()) {
                            File file2 = new File(file.getAbsolutePath() + ".apk");
                            if (file2.exists()) {
                                gsc.O00000Oo(file2);
                            }
                            file.renameTo(file2);
                            Intent intent = new Intent("action_update_progress");
                            intent.putExtra("status", "success");
                            context.sendBroadcast(intent);
                            return;
                        }
                        Intent intent2 = new Intent("action_update_progress");
                        intent2.putExtra("status", "failed");
                        context.sendBroadcast(intent2);
                    }

                    public final void O00000Oo() {
                        gyb.this.mIsDownloading = false;
                        Intent intent = new Intent("action_update_progress");
                        intent.putExtra("status", "failed");
                        context.sendBroadcast(intent);
                    }

                    public final void O000000o(int i) {
                        gyb.this.mProgress = i;
                        Intent intent = new Intent("action_update_progress");
                        intent.putExtra("status", "progress");
                        intent.putExtra("progress", i);
                        context.sendBroadcast(intent);
                    }
                };
                this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
                this.mAppDownloadTask = new O00000Oo(context, z, str, bitmap, this.mDownloadPath, this.mNotificationManager, r8);
                gor.O000000o(this.mAppDownloadTask, new ftt<Void>() {
                    /* class _m_j.gyb.AnonymousClass8 */

                    public final void O000000o(int i) {
                    }

                    public final void O000000o(int i, Object obj) {
                    }

                    public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                    }
                });
                this.mIsDownloading = true;
                if (z) {
                    izb.O000000o(context, (int) R.string.upgrade_pkg_downloading_title2_smarthome, 0).show();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void parseInfoFromJson(JSONObject jSONObject) {
        this.mResult = jSONObject;
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("new_version", -1);
            if (optInt == 0) {
                this.mForceUpdate = 0;
            } else if (optInt == 1) {
                this.mForceUpdate = 2;
            } else if (optInt == 2) {
                this.mForceUpdate = 1;
            }
            this.mNewVersionUrl = jSONObject.optString("download_url");
            this.mNewVersionDesc = jSONObject.optString("change_log");
            this.mNewVersionName = jSONObject.optString("new_version_name");
            this.mNewVersionCode = jSONObject.optInt("new_version_code");
        }
    }

    public void showStartInstallApkDialog(final Activity activity) {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity);
        builder.O000000o((int) R.string.dialog_title_apk_downloaded);
        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class _m_j.gyb.AnonymousClass9 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                Activity activity = activity;
                if (activity != null && !activity.isFinishing()) {
                    gyb.this.startInstallApkIntent(activity);
                }
            }
        });
        builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class _m_j.gyb.AnonymousClass10 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (gyb.this.getmForceUpdate() == 1) {
                    gyb.this.cancelDownloadTask();
                    gyb.this.cancelUpdateNotification();
                    System.exit(0);
                } else if (gyb.this.getmForceUpdate() == 0) {
                    gyb.this.ignoreThisNewVersion();
                } else {
                    gyb.this.getmForceUpdate();
                }
                dialogInterface.dismiss();
            }
        });
        builder.O00000o().show();
    }

    public void showForceUpdateDialog(final Activity activity) {
        Log.d("MessageCenter", "强制升级");
        if (this.mForceDialog == null) {
            MLAlertDialog.Builder O00000Oo2 = new MLAlertDialog.Builder(activity).O000000o((int) R.string.dialog_right_update, new DialogInterface.OnClickListener() {
                /* class _m_j.gyb.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Activity activity = activity;
                    if (activity != null && !activity.isFinishing()) {
                        gyb gyb = gyb.this;
                        gyb.keepDialogOpen(gyb.mForceDialog);
                        gyb gyb2 = gyb.this;
                        if (gyb2.hasDownloadedNewVersionApk(activity, gyb2.getNewVersionCode())) {
                            gyb.this.startInstallApkIntent(activity);
                        } else {
                            gyb.this.startDownloadAppApk();
                        }
                    }
                }
            }).O000000o(false).O00000Oo(this.mAppContext.getString(R.string.dialog_title_force_update));
            O00000Oo2.O00000Oo((int) R.string.exit, new DialogInterface.OnClickListener() {
                /* class _m_j.gyb.AnonymousClass12 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    gyb.this.cancelUpdateNotification();
                    gyb.this.cancelDownloadTask();
                    System.exit(0);
                }
            });
            this.mForceDialog = O00000Oo2.O00000o();
            if (!activity.isFinishing()) {
                this.mForceDialog.show();
            }
        }
    }

    public void showHalfForceUpdateDialog(final Activity activity) {
        Log.d("MessageCenter", "半强制升级");
        if (this.mForceDialog == null) {
            MLAlertDialog.Builder O00000Oo2 = new MLAlertDialog.Builder(activity).O000000o((int) R.string.dialog_right_update, new DialogInterface.OnClickListener() {
                /* class _m_j.gyb.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Activity activity = activity;
                    if (activity != null && !activity.isFinishing()) {
                        gyb gyb = gyb.this;
                        gyb.keepDialogOpen(gyb.mForceDialog);
                        gyb gyb2 = gyb.this;
                        if (gyb2.hasDownloadedNewVersionApk(activity, gyb2.getNewVersionCode())) {
                            gyb.this.startInstallApkIntent(activity);
                        } else {
                            gyb.this.startDownloadAppApk();
                        }
                    }
                }
            }).O000000o(false).O00000Oo(String.format(this.mAppContext.getResources().getString(R.string.dialog_title_half_force_update), this.mNewVersionName));
            O00000Oo2.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class _m_j.gyb.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    gyb.this.cancelDownloadTask();
                    gyb.this.cancelUpdateNotification();
                    gyb gyb = gyb.this;
                    gyb.closeDialog(gyb.mForceDialog);
                }
            });
            this.mForceDialog = O00000Oo2.O00000o();
            if (!activity.isFinishing()) {
                this.mForceDialog.show();
            }
        }
    }

    public void startDownloadAppApk() {
        startDownloadApk(this.mAppContext, true, getNewVersionUrl(), BitmapFactory.decodeResource(this.mAppContext.getResources(), R.drawable.mj_ic_launcher));
        Button button = this.mForceDialog.getButton(-1);
        button.setText(this.mAppContext.getResources().getQuantityString(R.plurals.upgrade_pkg_downloaded_is_downloading, 1, 1) + "%");
        this.mForceDialog.getButton(-1).setEnabled(false);
    }

    public void keepDialogOpen(Dialog dialog) {
        if (dialog != null) {
            try {
                Field declaredField = dialog.getClass().getSuperclass().getDeclaredField("mShowing");
                declaredField.setAccessible(true);
                declaredField.set(dialog, Boolean.FALSE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void closeDialog(Dialog dialog) {
        if (dialog != null) {
            try {
                Log.d("MessageCenter", "closeDialog");
                Field declaredField = dialog.getClass().getSuperclass().getDeclaredField("mShowing");
                declaredField.setAccessible(true);
                declaredField.set(dialog, Boolean.TRUE);
                dialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void unRegisterReceiver() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.mAppContext;
        if (context != null && (broadcastReceiver = this.appUpdateReceiver) != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void registerReceiver() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.mAppContext;
        if (context != null && (broadcastReceiver = this.appUpdateReceiver) != null) {
            context.registerReceiver(broadcastReceiver, new IntentFilter("action_update_progress"));
        }
    }

    public boolean isApkInstalling() {
        return this.isInstalling;
    }
}
