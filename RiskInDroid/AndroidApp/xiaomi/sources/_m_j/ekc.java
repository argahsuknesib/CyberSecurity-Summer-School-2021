package _m_j;

import android.accounts.Account;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.exception.InvalidParameterException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.SharedPreferencesUtil;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.ui.settings.utils.UserDataProxy;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class ekc extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    private O00000Oo f15562O000000o;
    private File O00000Oo;
    private Uri O00000o0;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity().getPackageManager().hasSystemFeature("android.hardware.camera")) {
            AccountLog.i("UserAvatarUpdateFragment", "has camera");
        } else {
            AccountLog.i("UserAvatarUpdateFragment", "no camera");
        }
        String string = getArguments().getString("update_avatar_type");
        if ("camera".equals(string)) {
            final Activity activity = getActivity();
            if (ContextCompat.O000000o(activity, "android.permission.CAMERA") != 0) {
                int[] iArr = {R.string.request_camera_permission_message, R.string.i_know, R.string.open_settings};
                if (O000000o(iArr)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(Html.fromHtml(getString(iArr[0])));
                    boolean z = true;
                    builder.setPositiveButton(iArr[1], (DialogInterface.OnClickListener) null);
                    if (!new SharedPreferencesUtil(activity, "permission_request_history").getBoolean("android.permission.CAMERA", false) || oOOO00o0.O000000o(activity, "android.permission.CAMERA")) {
                        z = false;
                    }
                    if (z) {
                        builder.setNegativeButton(iArr[2], new DialogInterface.OnClickListener() {
                            /* class _m_j.ekc.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ekh.O000000o(activity);
                            }
                        });
                    }
                    builder.setCancelable(false);
                    builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        /* class _m_j.ekc.AnonymousClass3 */

                        public final void onDismiss(DialogInterface dialogInterface) {
                            ekc.this.O000000o();
                        }
                    });
                    builder.show();
                    return;
                }
                O000000o();
                return;
            }
            O00000o();
        } else if ("gallery".equals(string)) {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            startActivityForResult(intent, 1003);
        } else {
            O00000o0();
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (MiAccountManager.O00000Oo(getActivity()).O00000oo() == null) {
            AccountLog.w("UserAvatarUpdateFragment", "no xiaomi account");
            O00000o0();
        }
        View findViewById = getActivity().findViewById(16908290);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.ekc.AnonymousClass1 */

                public final void onClick(View view) {
                    ekc.this.O00000o0();
                }
            });
        }
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 100) {
            new SharedPreferencesUtil(getActivity(), "permission_request_history").saveBoolean("android.permission.CAMERA", true);
            if (iArr.length <= 0 || iArr[0] != 0) {
                O00000o0();
            } else {
                O00000o();
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Uri uri = null;
        boolean z = false;
        switch (i) {
            case 1002:
            case 1003:
                if (i2 == -1) {
                    if (intent != null) {
                        uri = intent.getData();
                    }
                    if (uri == null) {
                        uri = O00000oO();
                    }
                    if (uri == null) {
                        AccountLog.i("UserAvatarUpdateFragment", "inputUri is null");
                    } else {
                        try {
                            Intent intent2 = new Intent("com.android.camera.action.CROP");
                            Uri O00000oO = O00000oO();
                            intent2.setDataAndType(uri, "image/*");
                            intent2.putExtra("output", O00000oO);
                            intent2.addFlags(1);
                            intent2.putExtra("return-data", true);
                            Activity activity = getActivity();
                            for (ResolveInfo resolveInfo : activity.getPackageManager().queryIntentActivities(intent2, 0)) {
                                String str = resolveInfo.activityInfo.packageName;
                                activity.grantUriPermission(str, uri, 1);
                                activity.grantUriPermission(str, O00000oO, 2);
                            }
                            intent2.putExtra("tips", getString(R.string.account_crop_user_avatar));
                            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.upload_user_avatar_size);
                            intent2.putExtra("crop", "true");
                            intent2.putExtra("scale", true);
                            intent2.putExtra("scaleUpIfNeeded", true);
                            intent2.putExtra("aspectX", 1);
                            intent2.putExtra("aspectY", 1);
                            intent2.putExtra("outputX", dimensionPixelSize);
                            intent2.putExtra("outputY", dimensionPixelSize);
                            startActivityForResult(intent2, 1004);
                        } catch (Exception e) {
                            AccountLog.e("UserAvatarUpdateFragment", "Cannot crop image", e);
                            Toast.makeText(getActivity(), (int) R.string.photoPickerNotFoundText, 1).show();
                        }
                    }
                    z = true;
                    break;
                }
                break;
            case 1004:
                if (intent == null || intent.getExtras() == null) {
                    if (i2 == -1) {
                        O000000o((Bitmap) null);
                        z = true;
                        break;
                    }
                } else {
                    Object obj = intent.getExtras().get("data");
                    if (obj instanceof Bitmap) {
                        O000000o((Bitmap) obj);
                    }
                    z = true;
                }
                break;
            default:
                z = true;
                break;
        }
        if (!z) {
            O00000o0();
        }
    }

    public final void onDestroy() {
        O00000Oo o00000Oo = this.f15562O000000o;
        if (o00000Oo != null) {
            o00000Oo.cancel(true);
            this.f15562O000000o = null;
        }
        super.onDestroy();
    }

    public final void O000000o() {
        Activity activity = getActivity();
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 100);
        } else {
            oOOO00o0.O000000o(activity, new String[]{"android.permission.CAMERA"}, 100);
        }
    }

    private boolean O000000o(int[] iArr) {
        int i = 0;
        while (i < 3) {
            try {
                getString(iArr[i]);
                i++;
            } catch (Resources.NotFoundException unused) {
                return false;
            }
        }
        return true;
    }

    private void O00000o() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", O00000oO());
        intent.addFlags(2);
        startActivityForResult(intent, 1002);
    }

    private Uri O00000oO() {
        if (this.O00000o0 == null) {
            this.O00000o0 = FileProvider.getUriForFile(getActivity(), O00000oo(), O00000Oo());
        }
        return this.O00000o0;
    }

    private String O00000oo() {
        return getActivity().getPackageName() + ".passport.fileprovider";
    }

    public final File O00000Oo() {
        if (this.O00000Oo == null) {
            this.O00000Oo = new File(getActivity().getCacheDir(), "xiaomi_user_avatar_file");
        }
        return this.O00000Oo;
    }

    private void O000000o(Bitmap bitmap) {
        O00000Oo o00000Oo = this.f15562O000000o;
        if (o00000Oo != null) {
            o00000Oo.cancel(true);
            this.f15562O000000o = null;
        }
        this.f15562O000000o = new O00000Oo(getActivity(), bitmap);
        this.f15562O000000o.executeOnExecutor(ekx.O000000o(), new Void[0]);
    }

    class O00000Oo extends AsyncTask<Void, Void, O000000o> {
        private final Bitmap O00000Oo;
        private Context O00000o;
        private ProgressDialog O00000o0;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return O000000o();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onCancelled(Object obj) {
            O000000o o000000o = (O000000o) obj;
            if (!(o000000o == null || o000000o.O00000Oo == null)) {
                o000000o.O00000Oo.recycle();
            }
            super.onCancelled(o000000o);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            O000000o o000000o = (O000000o) obj;
            super.onPostExecute(o000000o);
            ekc.this.O00000o0();
            this.O00000o0.dismiss();
            if (o000000o != null && o000000o.O00000Oo == null) {
                Toast.makeText(this.O00000o, o000000o.f15566O000000o == -1 ? R.string.passport_error_unknown : o000000o.f15566O000000o, 0).show();
            }
        }

        O00000Oo(Context context, Bitmap bitmap) {
            this.O00000Oo = bitmap;
            this.O00000o = context.getApplicationContext();
            this.O00000o0 = new ProgressDialog(context);
            this.O00000o0.setMessage(ekc.this.getString(R.string.user_avatar_uploading));
            this.O00000o0.setCanceledOnTouchOutside(false);
            this.O00000o0.setOnDismissListener(new DialogInterface.OnDismissListener(ekc.this) {
                /* class _m_j.ekc.O00000Oo.AnonymousClass1 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    O00000Oo.this.cancel(true);
                }
            });
            this.O00000o0.show();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            r14.close();
         */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x0152 A[SYNTHETIC, Splitter:B:100:0x0152] */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x012d A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00d3 A[SYNTHETIC, Splitter:B:47:0x00d3] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00e2 A[SYNTHETIC, Splitter:B:55:0x00e2] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x00ef A[SYNTHETIC, Splitter:B:63:0x00ef] */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x010b A[SYNTHETIC, Splitter:B:74:0x010b] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0124 A[SYNTHETIC, Splitter:B:83:0x0124] */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0140 A[SYNTHETIC, Splitter:B:93:0x0140] */
        private O000000o O000000o() {
            File O00000Oo2;
            Bitmap bitmap;
            int i;
            Throwable th;
            IOException iOException;
            IOException iOException2;
            Bitmap bitmap2;
            Account O00000oo = MiAccountManager.O00000Oo(this.O00000o).O00000oo();
            FileInputStream fileInputStream = null;
            if (O00000oo == null) {
                AccountLog.w("UserAvatarUpdateFragment", "no xiaomi account");
                return null;
            }
            O00000Oo2 = ekc.this.O00000Oo();
            Bitmap bitmap3 = this.O00000Oo;
            if (bitmap3 != null) {
                try {
                    eim.O000000o(bitmap3, O00000Oo2.getAbsolutePath());
                    bitmap2 = this.O00000Oo;
                } catch (IOException e) {
                    e.printStackTrace();
                    bitmap = null;
                }
            } else {
                bitmap2 = BitmapFactory.decodeFile(O00000Oo2.getPath());
            }
            bitmap = bitmap2;
            if (bitmap == null) {
                ekc.O000000o(O00000Oo2);
                return null;
            }
            UserDataProxy userDataProxy = new UserDataProxy(this.O00000o);
            eez O000000o2 = eez.O000000o(ekc.this.getActivity(), "passportapi");
            int i2 = 0;
            Bitmap bitmap4 = null;
            i = -1;
            while (true) {
                if (i2 >= 2) {
                    break;
                }
                try {
                    userDataProxy.O000000o(O00000oo, "acc_avatar_url", XMPassport.uploadXiaomiUserIcon(O000000o2, bitmap));
                    bitmap4 = eim.O000000o(ekc.this.getActivity(), bitmap, ekc.this.getActivity().getResources().getDimensionPixelSize(R.dimen.passport_head_icon_size));
                    FileInputStream fileInputStream2 = new FileInputStream(O00000Oo2);
                    try {
                        String str = "xiaomi_user_avatar_" + O00000oo.name;
                        ein.O000000o(ekc.this.getActivity(), fileInputStream2, str);
                        userDataProxy.O000000o(O00000oo, "acc_avatar_file_name", str);
                        try {
                            break;
                        } catch (IOException e2) {
                            iOException = e2;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        fileInputStream = fileInputStream2;
                        AccountLog.e("UserAvatarUpdateFragment", "uploadInfoToServer error", e);
                        i = R.string.passport_error_network;
                        if (fileInputStream != null) {
                        }
                        ekc.O000000o(O00000Oo2);
                        bitmap.recycle();
                        return new O000000o(i, bitmap4);
                    } catch (AuthenticationFailureException e4) {
                        e = e4;
                        fileInputStream = fileInputStream2;
                        try {
                            AccountLog.e("UserAvatarUpdateFragment", "uploadInfoToServer error", e);
                            O000000o2.O000000o(ekc.this.getActivity());
                            i = R.string.passport_bad_authentication;
                            if (fileInputStream == null) {
                            }
                            ekc.O000000o(O00000Oo2);
                            bitmap.recycle();
                            i2++;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    AccountLog.i("UserAvatarUpdateFragment", "fileInputStream", e5);
                                }
                            }
                            ekc.O000000o(O00000Oo2);
                            bitmap.recycle();
                            throw th;
                        }
                    } catch (AccessDeniedException e6) {
                        e = e6;
                        fileInputStream = fileInputStream2;
                        AccountLog.e("UserAvatarUpdateFragment", "uploadInfoToServer error", e);
                        i = R.string.passport_access_denied;
                        if (fileInputStream != null) {
                        }
                        ekc.O000000o(O00000Oo2);
                        bitmap.recycle();
                        return new O000000o(i, bitmap4);
                    } catch (InvalidResponseException e7) {
                        e = e7;
                        fileInputStream = fileInputStream2;
                        AccountLog.e("UserAvatarUpdateFragment", "uploadInfoToServer error", e);
                        if (fileInputStream != null) {
                        }
                        ekc.O000000o(O00000Oo2);
                        bitmap.recycle();
                        i = R.string.passport_error_server;
                        return new O000000o(i, bitmap4);
                    } catch (CipherException e8) {
                        e = e8;
                        fileInputStream = fileInputStream2;
                        AccountLog.e("UserAvatarUpdateFragment", "uploadInfoToServer error", e);
                        if (fileInputStream != null) {
                        }
                        ekc.O000000o(O00000Oo2);
                        bitmap.recycle();
                        i = R.string.passport_error_server;
                        return new O000000o(i, bitmap4);
                    } catch (InvalidParameterException e9) {
                        e = e9;
                        fileInputStream = fileInputStream2;
                        AccountLog.e("UserAvatarUpdateFragment", "uploadInfoToServer error", e);
                        i = R.string.account_invalid_user_avatar;
                        if (fileInputStream != null) {
                        }
                        ekc.O000000o(O00000Oo2);
                        bitmap.recycle();
                        return new O000000o(i, bitmap4);
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        ekc.O000000o(O00000Oo2);
                        bitmap.recycle();
                        throw th;
                    }
                } catch (IOException e10) {
                    e = e10;
                    AccountLog.e("UserAvatarUpdateFragment", "uploadInfoToServer error", e);
                    i = R.string.passport_error_network;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e11) {
                            iOException = e11;
                        }
                    }
                    ekc.O000000o(O00000Oo2);
                    bitmap.recycle();
                    return new O000000o(i, bitmap4);
                } catch (AuthenticationFailureException e12) {
                    e = e12;
                    AccountLog.e("UserAvatarUpdateFragment", "uploadInfoToServer error", e);
                    O000000o2.O000000o(ekc.this.getActivity());
                    i = R.string.passport_bad_authentication;
                    if (fileInputStream == null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e13) {
                            AccountLog.i("UserAvatarUpdateFragment", "fileInputStream", e13);
                        }
                    }
                    ekc.O000000o(O00000Oo2);
                    bitmap.recycle();
                    i2++;
                } catch (AccessDeniedException e14) {
                    e = e14;
                    AccountLog.e("UserAvatarUpdateFragment", "uploadInfoToServer error", e);
                    i = R.string.passport_access_denied;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e15) {
                            iOException = e15;
                        }
                    }
                    ekc.O000000o(O00000Oo2);
                    bitmap.recycle();
                    return new O000000o(i, bitmap4);
                } catch (InvalidResponseException e16) {
                    e = e16;
                    AccountLog.e("UserAvatarUpdateFragment", "uploadInfoToServer error", e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e17) {
                            iOException2 = e17;
                        }
                    }
                    ekc.O000000o(O00000Oo2);
                    bitmap.recycle();
                    i = R.string.passport_error_server;
                    return new O000000o(i, bitmap4);
                } catch (CipherException e18) {
                    e = e18;
                    AccountLog.e("UserAvatarUpdateFragment", "uploadInfoToServer error", e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e19) {
                            iOException2 = e19;
                        }
                    }
                    ekc.O000000o(O00000Oo2);
                    bitmap.recycle();
                    i = R.string.passport_error_server;
                    return new O000000o(i, bitmap4);
                } catch (InvalidParameterException e20) {
                    e = e20;
                    AccountLog.e("UserAvatarUpdateFragment", "uploadInfoToServer error", e);
                    i = R.string.account_invalid_user_avatar;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e21) {
                            iOException = e21;
                        }
                    }
                    ekc.O000000o(O00000Oo2);
                    bitmap.recycle();
                    return new O000000o(i, bitmap4);
                }
                ekc.O000000o(O00000Oo2);
                bitmap.recycle();
                i2++;
            }
            return new O000000o(i, bitmap4);
            AccountLog.i("UserAvatarUpdateFragment", "fileInputStream", iOException2);
            ekc.O000000o(O00000Oo2);
            bitmap.recycle();
            i = R.string.passport_error_server;
            return new O000000o(i, bitmap4);
            AccountLog.i("UserAvatarUpdateFragment", "fileInputStream", iOException);
            ekc.O000000o(O00000Oo2);
            bitmap.recycle();
            return new O000000o(i, bitmap4);
        }
    }

    public final void O00000o0() {
        getActivity().overridePendingTransition(0, 0);
        getActivity().finish();
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f15566O000000o;
        public Bitmap O00000Oo;

        O000000o(int i, Bitmap bitmap) {
            this.f15566O000000o = i;
            this.O00000Oo = bitmap;
        }
    }

    public static void O000000o(File file) {
        if (file != null && file.exists() && file.isFile()) {
            file.delete();
        }
    }
}
