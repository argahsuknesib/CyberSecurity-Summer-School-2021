package _m_j;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class gul {

    /* renamed from: O000000o  reason: collision with root package name */
    private long f18305O000000o;
    public MessageRecord O00000oo;
    protected JSONObject O0000O0o = null;

    public void O000000o(Activity activity) {
    }

    public abstract void O000000o(TextView textView);

    public abstract void O000000o(SimpleDraweeView simpleDraweeView);

    public abstract void O000000o(XQProgressDialog xQProgressDialog);

    public abstract void O00000Oo(TextView textView);

    public abstract boolean O00000Oo();

    public abstract String O00000o0();

    public abstract void O00000o0(TextView textView);

    public void O00000oO(TextView textView) {
    }

    public long O000000o() {
        return this.f18305O000000o;
    }

    public boolean O00000oo() {
        JSONObject jSONObject = this.O0000O0o;
        if (jSONObject == null) {
            return false;
        }
        long optLong = jSONObject.optLong("expire_time", -1);
        if (optLong == -1 || optLong == 0 || System.currentTimeMillis() <= optLong * 1000) {
            return false;
        }
        return true;
    }

    public boolean O00000o() {
        MessageRecord messageRecord = this.O00000oo;
        if (messageRecord == null || TextUtils.isEmpty(messageRecord.is_new) || O000000o() < 1479106800 || !TextUtils.equals(this.O00000oo.is_new, "1")) {
            return false;
        }
        return true;
    }

    public final boolean O0000O0o() {
        MessageRecord messageRecord = this.O00000oo;
        if (messageRecord == null || TextUtils.isEmpty(messageRecord.is_new) || O000000o() < 1479106800 || !TextUtils.equals(this.O00000oo.is_new, "1")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean O0000OOo() {
        MessageRecord messageRecord;
        if (this.O0000O0o == null && (messageRecord = this.O00000oo) != null && !TextUtils.isEmpty(messageRecord.params)) {
            try {
                this.O0000O0o = new JSONObject(this.O00000oo.params);
            } catch (JSONException unused) {
            }
        }
        JSONObject jSONObject = this.O0000O0o;
        return jSONObject != null && !jSONObject.isNull("is_new_message") && this.O0000O0o.optInt("is_new_message") == 1;
    }

    public boolean O00000o(TextView textView) {
        JSONObject jSONObject;
        if (!O0000OOo() || (jSONObject = this.O0000O0o) == null) {
            return false;
        }
        return O000000o(this, jSONObject.optString("user_name"), this.O0000O0o.optString("title"), textView, 5);
    }

    public final boolean O000000o(TextView textView, String str) {
        JSONObject jSONObject;
        if (!O0000OOo() || (jSONObject = this.O0000O0o) == null) {
            return false;
        }
        return O000000o(this, jSONObject.optString("user_name"), str, textView, 12);
    }

    private static boolean O000000o(gul gul, String str, String str2, TextView textView, int i) {
        String str3;
        if (!gul.O0000OOo()) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String O000000o2 = gqb.O000000o(textView.getContext(), str, textView.getTextSize(), textView, i);
            if (str2.contains("%s")) {
                str3 = str2.replace("%s", O000000o2);
            } else {
                str3 = O000000o2 + str2;
            }
            textView.setText(str3);
            return true;
        } else if (TextUtils.isEmpty(str2)) {
            return false;
        } else {
            textView.setText(str2);
            return true;
        }
    }
}
