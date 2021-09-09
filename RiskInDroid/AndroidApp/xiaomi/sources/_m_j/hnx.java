package _m_j;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.ArrayList;
import java.util.List;

public final class hnx extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f398O000000o = ServiceApplication.getAppContext();
    LayoutInflater O00000Oo;
    List<hpy> O00000o0 = new ArrayList();

    public final long getItemId(int i) {
        return (long) i;
    }

    public hnx(List<hpy> list) {
        this.O00000o0.clear();
        this.O00000o0.addAll(list);
        this.O00000Oo = LayoutInflater.from(this.f398O000000o);
    }

    public final int getCount() {
        return this.O00000o0.size();
    }

    public final Object getItem(int i) {
        return this.O00000o0.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        O000000o o000000o;
        if (view == null) {
            view = this.O00000Oo.inflate((int) R.layout.choose_good_item, (ViewGroup) null);
            o000000o = new O000000o(view);
            view.setTag(o000000o);
        } else {
            o000000o = (O000000o) view.getTag();
        }
        final hpy hpy = this.O00000o0.get(i);
        TextView textView = o000000o.O00000o0;
        textView.setText("￥" + (hpy.O00000Oo / 100.0f));
        o000000o.O00000Oo.setText(hpy.f513O000000o);
        o000000o.f400O000000o.setHierarchy(new GenericDraweeHierarchyBuilder(this.f398O000000o.getResources()).setPlaceholderImage(this.f398O000000o.getResources().getDrawable(R.drawable.device_list_phone_no)).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
        o000000o.f400O000000o.setImageURI(Uri.parse(hpy.O00000o));
        o000000o.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.hnx.AnonymousClass1 */

            public final void onClick(View view) {
                hjp.O000000o(hpy.O00000o0);
                hpu O000000o2 = hpu.O000000o();
                MLAlertDialog mLAlertDialog = O000000o2.O0000Oo == null ? null : O000000o2.O0000Oo.get();
                if (mLAlertDialog != null) {
                    mLAlertDialog.dismiss();
                }
            }
        });
        return view;
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        SimpleDraweeView f400O000000o;
        TextView O00000Oo;
        TextView O00000o;
        TextView O00000o0;
        View O00000oO;

        public O000000o(View view) {
            this.O00000oO = view;
            this.f400O000000o = (SimpleDraweeView) view.findViewById(R.id.good_icon);
            this.O00000Oo = (TextView) view.findViewById(R.id.device_name);
            this.O00000o0 = (TextView) view.findViewById(R.id.device_price);
            this.O00000o = (TextView) view.findViewById(R.id.buy_tv);
        }
    }
}
