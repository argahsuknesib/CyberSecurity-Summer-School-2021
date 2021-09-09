package _m_j;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import org.json.JSONObject;

public final class gur extends gum {

    public static class O000000o extends gul {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18319O000000o;
        public String O00000Oo;
        public String O00000o0;

        public final boolean O00000Oo() {
            return true;
        }

        public final void O00000o0(TextView textView) {
        }

        public O000000o(MessageRecord messageRecord, String str, String str2, String str3) {
            this.O00000oo = messageRecord;
            this.f18319O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = str3;
        }

        public final long O000000o() {
            return this.O00000oo.receiveTime;
        }

        public final void O000000o(SimpleDraweeView simpleDraweeView) {
            if (!TextUtils.isEmpty(this.O00000oo.img_url)) {
                gyl.O000000o();
                gyl.O00000Oo(this.O00000oo.img_url, simpleDraweeView, new gnz(simpleDraweeView.getResources().getColor(R.color.mj_color_black_30_transparent)));
            }
        }

        public final void O000000o(TextView textView) {
            if (!O00000o(textView)) {
                textView.setText(this.O00000oo.title);
            }
        }

        public final void O00000oO(TextView textView) {
            textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000) + " " + this.O00000oo.title);
        }

        public final void O00000Oo(TextView textView) {
            textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000));
        }

        public final void O000000o(XQProgressDialog xQProgressDialog) {
            xQProgressDialog.dismiss();
        }

        public final String O00000o0() {
            if (this.O00000oo == null) {
                return null;
            }
            return this.O00000oo.msgId;
        }

        public final void O000000o(Activity activity) {
            guq.O000000o(O00000o0());
        }
    }

    public final gul O000000o(MessageRecord messageRecord) {
        String str;
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject(messageRecord.params);
            String optString = jSONObject.optString("type", str2);
            JSONObject optJSONObject = jSONObject.optJSONObject("body");
            if (optJSONObject != null) {
                str = optJSONObject.optString("url");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("params");
                if (optJSONObject2 != null) {
                    str2 = optJSONObject2.optString("url");
                }
            } else {
                str = str2;
            }
            return new O000000o(messageRecord, optString, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
