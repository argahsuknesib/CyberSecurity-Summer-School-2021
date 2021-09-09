package _m_j;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;

public final class gux extends gum {

    public class O000000o extends gul {

        /* renamed from: O000000o  reason: collision with root package name */
        MessageRecord f18324O000000o;

        public final void O000000o(XQProgressDialog xQProgressDialog) {
        }

        public final boolean O00000Oo() {
            return false;
        }

        public O000000o() {
        }

        public final void O000000o(Activity activity) {
            Bundle bundle = new Bundle();
            bundle.putString("message_record", this.f18324O000000o.params);
            fvj.O000000o("/message/MessageCenterWifiChangePwdActivity", bundle, false, 67108864);
        }

        public final long O000000o() {
            return this.f18324O000000o.receiveTime;
        }

        public final void O000000o(SimpleDraweeView simpleDraweeView) {
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.wifi_icon));
        }

        public final void O000000o(TextView textView) {
            if (!O00000o(textView)) {
                textView.setText(this.f18324O000000o.title);
            }
        }

        public final void O00000Oo(TextView textView) {
            if (!O0000OOo()) {
                textView.setText(gou.O000000o(this.f18324O000000o.receiveTime * 1000) + " " + this.f18324O000000o.content);
            } else if (this.O0000O0o == null || this.O0000O0o.isNull("content")) {
                textView.setText(gou.O000000o(this.f18324O000000o.receiveTime * 1000) + " " + this.f18324O000000o.title);
            } else {
                textView.setText(gou.O000000o(this.f18324O000000o.receiveTime * 1000) + " " + this.O0000O0o.optString("content"));
            }
        }

        public final void O00000o0(TextView textView) {
            if (textView != null) {
                textView.setVisibility(8);
            }
        }

        public final String O00000o0() {
            MessageRecord messageRecord = this.f18324O000000o;
            if (messageRecord == null) {
                return null;
            }
            return messageRecord.msgId;
        }
    }

    public final gul O000000o(MessageRecord messageRecord) {
        O000000o o000000o = new O000000o();
        o000000o.f18324O000000o = messageRecord;
        return o000000o;
    }
}
