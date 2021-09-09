package _m_j;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.XMPassportUtil;
import java.util.Locale;

public final class egg {

    /* renamed from: O000000o  reason: collision with root package name */
    public static O000000o f15249O000000o;

    static class O000000o extends AsyncTask<Void, Void, Intent> {

        /* renamed from: O000000o  reason: collision with root package name */
        private Activity f15250O000000o;
        private Runnable O00000Oo;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Intent intent = (Intent) obj;
            Activity activity = this.f15250O000000o;
            if (activity != null && !activity.isFinishing()) {
                try {
                    this.f15250O000000o.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    AccountLog.e("GetBackPasswordExecutor", "cannot find browser");
                    Toast.makeText(this.f15250O000000o, "Cannot find the Browser App", 1).show();
                }
            }
            this.f15250O000000o = null;
            egg.f15249O000000o = null;
            Runnable runnable = this.O00000Oo;
            if (runnable != null) {
                runnable.run();
            }
        }

        public O000000o(Activity activity) {
            this.f15250O000000o = activity;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            Intent intent = new Intent("android.intent.action.VIEW");
            String O000000o2 = ekq.O000000o();
            Locale locale = this.f15250O000000o.getResources().getConfiguration().locale;
            Uri.Builder buildUpon = Uri.parse(eip.f15324O000000o).buildUpon();
            if (O000000o2 != null) {
                buildUpon.appendQueryParameter("hint", O000000o2);
            }
            String iSOLocaleString = XMPassportUtil.getISOLocaleString(locale);
            if (iSOLocaleString != null) {
                buildUpon.appendQueryParameter("_locale", iSOLocaleString);
            }
            intent.setData(buildUpon.build());
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            return intent;
        }
    }
}
