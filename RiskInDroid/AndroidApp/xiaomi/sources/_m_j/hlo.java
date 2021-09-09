package _m_j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Parcelable;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.WebViewRouterFactory;
import com.xiaomi.smarthome.application.CommonApplication;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class hlo extends fm {

    /* renamed from: O000000o  reason: collision with root package name */
    final String f19051O000000o = "*/*";
    public ValueCallback<Uri> O00000Oo;
    private Uri O00000o;
    private ValueCallback<Uri[]> O00000o0;

    public static boolean O000000o(int i) {
        return i == 1 || i == 3;
    }

    public static hlo O000000o(FragmentActivity fragmentActivity) {
        return (hlo) fo.O000000o(fragmentActivity).O000000o(hlo.class);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(WebChromeClient.FileChooserParams fileChooserParams, Activity activity, ValueCallback valueCallback, Boolean bool) throws Exception {
        String[] acceptTypes = fileChooserParams.getAcceptTypes();
        boolean z = fileChooserParams.getMode() == 1;
        Intent createIntent = fileChooserParams.createIntent();
        boolean booleanValue = bool.booleanValue();
        this.O00000o0 = valueCallback;
        ArrayList arrayList = new ArrayList();
        if (booleanValue) {
            String[] O000000o2 = O000000o(acceptTypes);
            if (O00000Oo(O000000o2).booleanValue() || O000000o(O000000o2, "image").booleanValue()) {
                arrayList.add(O000000o());
            }
            String[] O000000o3 = O000000o(acceptTypes);
            if (O00000Oo(O000000o3).booleanValue() || O000000o(O000000o3, "video").booleanValue()) {
                arrayList.add(O00000Oo());
            }
        }
        createIntent.putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
        Intent intent = new Intent("android.intent.action.CHOOSER");
        intent.putExtra("android.intent.extra.INTENT", createIntent);
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivityForResult(intent, 1);
        } else {
            gsy.O000000o(5, "FileChooseHelper", "there is no Activity to handle this Intent");
        }
    }

    public final void O000000o(int i, int i2, Intent intent) {
        if (this.O00000o0 != null || this.O00000Oo != null) {
            if (i != 1) {
                if (i == 3) {
                    this.O00000Oo.onReceiveValue(i2 != -1 ? null : intent == null ? this.O00000o : intent.getData());
                }
            } else if (i2 != -1) {
                ValueCallback<Uri[]> valueCallback = this.O00000o0;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                Uri[] O000000o2 = O000000o(intent, i2);
                if (O000000o2 != null) {
                    this.O00000o0.onReceiveValue(O000000o2);
                } else {
                    Uri uri = this.O00000o;
                    if (uri != null) {
                        this.O00000o0.onReceiveValue(new Uri[]{uri});
                    } else {
                        this.O00000o0.onReceiveValue(null);
                    }
                }
            }
            this.O00000o0 = null;
            this.O00000Oo = null;
            this.O00000o = null;
        }
    }

    private static Uri[] O000000o(Intent intent, int i) {
        Uri[] uriArr = null;
        if (intent == null) {
            return null;
        }
        if (intent.getData() == null) {
            if (intent.getClipData() != null) {
                int itemCount = intent.getClipData().getItemCount();
                uriArr = new Uri[itemCount];
                for (int i2 = 0; i2 < itemCount; i2++) {
                    uriArr[i2] = intent.getClipData().getItemAt(i2).getUri();
                }
            }
            return uriArr;
        } else if (i != -1 || Build.VERSION.SDK_INT < 21) {
            return null;
        } else {
            return WebChromeClient.FileChooserParams.parseResult(i, intent);
        }
    }

    public final Intent O000000o() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        this.O00000o = O00000Oo("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", this.O00000o);
        return intent;
    }

    public final Intent O00000Oo() {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        this.O00000o = O00000Oo("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("output", this.O00000o);
        return intent;
    }

    private static Boolean O000000o(String[] strArr, String str) {
        for (String contains : strArr) {
            if (contains.contains(str)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private static String[] O000000o(String[] strArr) {
        if (O00000Oo(strArr).booleanValue()) {
            return new String[]{"*/*"};
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str.matches("\\.\\w+")) {
                strArr2[i] = O000000o(str.replace(".", ""));
            } else {
                strArr2[i] = str;
            }
        }
        return strArr2;
    }

    public static String O000000o(String str) {
        if (str != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        return null;
    }

    private static Boolean O00000Oo(String[] strArr) {
        boolean z = false;
        if (strArr.length == 0 || (strArr.length == 1 && strArr[0].length() == 0)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @SuppressLint({"CheckResult"})
    public final boolean O000000o(Activity activity, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Single.create(new SingleOnSubscribe(activity) {
            /* class _m_j.$$Lambda$hlo$jjg_7RgDzIrQdXF9ulmvuv1snuU */
            private final /* synthetic */ Activity f$0;

            {
                this.f$0 = r1;
            }

            public final void subscribe(SingleEmitter singleEmitter) {
                WebViewRouterFactory.getWebViewHelpManager().requestCapturePermissions(this.f$0, singleEmitter);
            }
        }).subscribe(new Consumer(fileChooserParams, activity, valueCallback) {
            /* class _m_j.$$Lambda$hlo$5GLePTnABsB32FNKwRuj8V7MtOw */
            private final /* synthetic */ WebChromeClient.FileChooserParams f$1;
            private final /* synthetic */ Activity f$2;
            private final /* synthetic */ ValueCallback f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void accept(Object obj) {
                hlo.this.O000000o(this.f$1, this.f$2, this.f$3, (Boolean) obj);
            }
        });
        return true;
    }

    private static Uri O00000Oo(String str) {
        File file;
        String str2;
        String str3;
        try {
            String str4 = "";
            if (str.equals("android.media.action.IMAGE_CAPTURE")) {
                str4 = "image-";
                str2 = ".jpg";
                str3 = Environment.DIRECTORY_PICTURES;
            } else if (str.equals("android.media.action.VIDEO_CAPTURE")) {
                str4 = "video-";
                str2 = ".mp4";
                str3 = Environment.DIRECTORY_MOVIES;
            } else {
                str2 = str4;
                str3 = str2;
            }
            String str5 = str4 + String.valueOf(System.currentTimeMillis()) + str2;
            if (Build.VERSION.SDK_INT < 23) {
                file = new File(Environment.getExternalStoragePublicDirectory(str3), str5);
            } else {
                file = File.createTempFile(str5, str2, CommonApplication.getApplication().getExternalFilesDir(str3));
            }
        } catch (IOException e) {
            Log.e("CREATE FILE", "Error occurred while creating the File", e);
            e.printStackTrace();
            file = null;
        }
        return Uri.fromFile(file);
    }
}
