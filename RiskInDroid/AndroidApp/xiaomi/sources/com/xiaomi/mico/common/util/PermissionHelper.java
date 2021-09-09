package com.xiaomi.mico.common.util;

import _m_j.ahg;
import _m_j.ahh;
import _m_j.oOOO00o0;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.HashMap;
import java.util.Map;

public class PermissionHelper {
    private static volatile Map<String, Integer> PRIVACY_PERMISSION_MAP = new HashMap<String, Integer>() {
        /* class com.xiaomi.mico.common.util.PermissionHelper.AnonymousClass1 */
        private static final long serialVersionUID = -9111435974584422670L;

        {
            put("android.permission.BLUETOOTH_ADMIN", Integer.valueOf((int) R.string.permission_privacy_hint_bluetooth));
            put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf((int) R.string.permission_privacy_hint_location));
            put("android.permission.CAMERA", Integer.valueOf((int) R.string.permission_privacy_hint_camera));
            put("android.permission.READ_CONTACTS", Integer.valueOf((int) R.string.permission_privacy_hint_contacts));
            put("android.permission.RECORD_AUDIO", Integer.valueOf((int) R.string.permission_privacy_hint_microphone));
        }
    };
    private static ahg loggerNew = new ahg();
    private final Activity mActivity;
    public boolean mIsShowingRequestDlg;
    public Listener mListener;
    private HashMap<String, PermissionInfo> mPermissions = new HashMap<>();
    private int permissionIndex = 0;

    public interface Listener {
        void onAllPermissionGranted();

        void onGoToSetting();

        void onPermissionDenied(String str);
    }

    public PermissionHelper(Activity activity) {
        this.mActivity = activity;
    }

    public PermissionHelper listener(Listener listener) {
        this.mListener = listener;
        return this;
    }

    public PermissionHelper withPermission(String str, int i, int i2) {
        withPermission(str, i, i2, false);
        return this;
    }

    public PermissionHelper withPermission(String str, int i, int i2, boolean z) {
        this.permissionIndex++;
        this.mPermissions.put(str, new PermissionInfo(str, this.permissionIndex, i, i2, z));
        return this;
    }

    public void check() {
        if (!this.mIsShowingRequestDlg) {
            for (PermissionInfo next : this.mPermissions.values()) {
                if (!next.skipCheck && checkPermission(next.permission, next.requestMsg, next.requestCode) != 0) {
                    return;
                }
            }
            Listener listener = this.mListener;
            if (listener != null) {
                listener.onAllPermissionGranted();
            }
        }
    }

    public MLAlertDialog.Builder buildPermissionDenyDialog(final String str, int i) {
        return new MLAlertDialog.Builder(this.mActivity).O000000o((int) R.string.permission_request).O00000Oo(i).O000000o(false).O00000Oo((int) R.string.common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.common.util.PermissionHelper.AnonymousClass3 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                PermissionHelper permissionHelper = PermissionHelper.this;
                permissionHelper.mIsShowingRequestDlg = false;
                if (permissionHelper.mListener != null) {
                    PermissionHelper.this.mListener.onPermissionDenied(str);
                }
            }
        }).O000000o((int) R.string.permission_go_setting, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.common.util.PermissionHelper.AnonymousClass2 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                PermissionHelper permissionHelper = PermissionHelper.this;
                permissionHelper.mIsShowingRequestDlg = false;
                if (permissionHelper.mListener != null) {
                    PermissionHelper.this.mListener.onGoToSetting();
                }
            }
        });
    }

    public MLAlertDialog.Builder buildPrivacyPermissionDialog(String str, int i) {
        return new MLAlertDialog.Builder(this.mActivity).O000000o((int) R.string.permission_request).O00000Oo(PRIVACY_PERMISSION_MAP.get(str).intValue()).O000000o(false).O00000Oo((int) R.string.common_cancel, new DialogInterface.OnClickListener(str) {
            /* class com.xiaomi.mico.common.util.$$Lambda$PermissionHelper$LlvppRmLYOZuzyjuCykjlyUc */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                PermissionHelper.this.lambda$buildPrivacyPermissionDialog$0$PermissionHelper(this.f$1, dialogInterface, i);
            }
        }).O000000o((int) R.string.common_confirm, new DialogInterface.OnClickListener(str) {
            /* class com.xiaomi.mico.common.util.$$Lambda$PermissionHelper$rpYbgjxIk7IcvoMAhgm0HHHR2Y */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                PermissionHelper.this.lambda$buildPrivacyPermissionDialog$1$PermissionHelper(this.f$1, dialogInterface, i);
            }
        });
    }

    public /* synthetic */ void lambda$buildPrivacyPermissionDialog$0$PermissionHelper(String str, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onPermissionDenied(str);
        }
    }

    public /* synthetic */ void lambda$buildPrivacyPermissionDialog$1$PermissionHelper(String str, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        setPrivcyPermissionAuth(str, true);
        check();
    }

    public static void gotoPermissionSetting(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addFlags(268435456);
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        context.startActivity(intent);
    }

    private int checkPermission(String str, int i, int i2) {
        int O000000o2 = ContextCompat.O000000o(this.mActivity, str);
        ahg.O00000Oo("%s %d", str, Integer.valueOf(O000000o2));
        if (O000000o2 != 0) {
            if (!hasPrivcyPermissionAuth(str)) {
                buildPrivacyPermissionDialog(str, i).O00000oo();
                return O000000o2;
            } else if (oOOO00o0.O000000o(this.mActivity, str)) {
                ahg.O00000Oo("showRequestPermissionRationale");
                buildPermissionDenyDialog(str, i).O00000oo();
                this.mIsShowingRequestDlg = true;
            } else {
                oOOO00o0.O000000o(this.mActivity, new String[]{str}, i2);
                ahg.O00000Oo("requestPermissions");
            }
        }
        return O000000o2;
    }

    private boolean checkOpsPermission(Context context, String str) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            String str2 = null;
            if (Build.VERSION.SDK_INT >= 23) {
                str2 = AppOpsManager.permissionToOp(str);
            }
            if (str2 == null || appOpsManager.checkOpNoThrow(str2, Process.myUid(), context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr != null && strArr.length != 0) {
            ahg.O00000Oo("onRequestPermissionsResult %s %s", strArr[0], Integer.valueOf(iArr[0]));
            for (PermissionInfo next : this.mPermissions.values()) {
                if (next.requestCode == i) {
                    if (iArr.length <= 0 || iArr[0] != 0) {
                        PermissionInfo permissionInfo = this.mPermissions.get(strArr[0]);
                        if (permissionInfo.optional) {
                            permissionInfo.skipCheck = true;
                            check();
                        } else {
                            buildPermissionDenyDialog(strArr[0], next.denyMsg).O00000oo();
                            this.mIsShowingRequestDlg = true;
                        }
                    } else {
                        check();
                    }
                }
            }
        }
    }

    private boolean hasPrivcyPermissionAuth(String str) {
        if (PRIVACY_PERMISSION_MAP.containsKey(str)) {
            return PreferenceUtils.getSettingBoolean(CommonApplication.getAppContext(), str, false);
        }
        return true;
    }

    private void setPrivcyPermissionAuth(String str, boolean z) {
        PreferenceUtils.setSettingBoolean(CommonApplication.getAppContext(), str, z);
    }

    class PermissionInfo {
        public int denyMsg;
        public boolean optional = false;
        public String permission;
        public final int requestCode;
        public int requestMsg;
        public boolean skipCheck;

        public PermissionInfo(String str, int i, int i2, int i3, boolean z) {
            this.permission = str;
            this.requestMsg = i2;
            this.denyMsg = i3;
            this.optional = z;
            this.requestCode = i;
        }
    }

    static {
        new ahh();
    }
}
