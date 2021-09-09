package com.mi.global.shop.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.adapter.ArrayAdapter;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public class ReviewTipsDialog extends Dialog {

    public class Builder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private Builder f5019O000000o;

        public Builder_ViewBinding(Builder builder, View view) {
            this.f5019O000000o = builder;
            builder.lvTips = (ListView) Utils.findRequiredViewAsType(view, R.id.lv_tips, "field 'lvTips'", ListView.class);
            builder.btnOk = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.btn_ok, "field 'btnOk'", CustomButtonView.class);
        }

        public void unbind() {
            Builder builder = this.f5019O000000o;
            if (builder != null) {
                this.f5019O000000o = null;
                builder.lvTips = null;
                builder.btnOk = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public ReviewTipsDialog(Context context) {
        super(context);
    }

    public ReviewTipsDialog(Context context, byte b) {
        super(context, R.style.Dialog);
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public Context f5016O000000o;
        public TipsAdapter O00000Oo;
        @BindView(2131493034)
        public CustomButtonView btnOk;
        @BindView(2131493702)
        public ListView lvTips;

        public Builder(Context context) {
            this.f5016O000000o = context;
        }

        public static class TipsAdapter extends ArrayAdapter<String> {
            O000000o O00000o;

            public final /* synthetic */ void O000000o(View view, Object obj) {
                String str = (String) obj;
                O000000o o000000o = (O000000o) view.getTag();
                if (!str.contains("#")) {
                    o000000o.f5018O000000o.setText(str);
                } else if (str.split("#").length == 3) {
                    CustomTextView customTextView = o000000o.f5018O000000o;
                    customTextView.setText(Html.fromHtml(str.split("#")[0] + "<font color='#424242' style='font-weight:bold'><b>" + str.split("#")[1] + "</b></font>" + str.split("#")[2]));
                } else if (str.split("#").length == 2) {
                    CustomTextView customTextView2 = o000000o.f5018O000000o;
                    customTextView2.setText(Html.fromHtml(str.split("#")[0] + "<font color='#424242' style='font-weight:bold'><b>" + str.split("#")[1] + "</b></font>"));
                }
            }

            public TipsAdapter(Context context) {
                super(context);
            }

            static class O000000o {

                /* renamed from: O000000o  reason: collision with root package name */
                CustomTextView f5018O000000o;

                O000000o() {
                }
            }

            public final /* synthetic */ View O000000o() {
                View inflate = LayoutInflater.from(this.f4566O000000o).inflate((int) R.layout.shop_item_review_tips, (ViewGroup) null);
                this.O00000o = new O000000o();
                this.O00000o.f5018O000000o = (CustomTextView) inflate.findViewById(R.id.tv_tip);
                inflate.setTag(this.O00000o);
                return inflate;
            }
        }
    }
}
