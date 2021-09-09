package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.smartconfig.ChooseCameraActivity;
import java.util.ArrayList;
import java.util.List;

public final class hti extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f623O000000o;
    List<ChooseCameraActivity.O000000o> O00000Oo = new ArrayList();
    public Handler O00000o0 = new Handler(Looper.getMainLooper());

    public interface O000000o {
        Context getContext();

        void onCameraChoose(ChooseCameraActivity.O000000o o000000o);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public hti(O000000o o000000o) {
        this.f623O000000o = o000000o;
    }

    public final int getCount() {
        return this.O00000Oo.size();
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ChooseCameraActivity.O000000o getItem(int i) {
        return this.O00000Oo.get(i);
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        SimpleDraweeView f627O000000o;
        TextView O00000Oo;
        ImageView O00000o0;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        O00000Oo o00000Oo;
        if (view == null) {
            view = LayoutInflater.from(this.f623O000000o.getContext()).inflate((int) R.layout.choose_camera_item, (ViewGroup) null);
            o00000Oo = new O00000Oo((byte) 0);
            o00000Oo.f627O000000o = (SimpleDraweeView) view.findViewById(R.id.image);
            o00000Oo.O00000Oo = (TextView) view.findViewById(R.id.name);
            o00000Oo.O00000o0 = (ImageView) view.findViewById(R.id.signal);
            view.setTag(o00000Oo);
        } else {
            o00000Oo = (O00000Oo) view.getTag();
        }
        final ChooseCameraActivity.O000000o O000000o2 = getItem(i);
        SimpleDraweeView simpleDraweeView = o00000Oo.f627O000000o;
        simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setPlaceholderImage(simpleDraweeView.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build());
        DeviceFactory.O000000o(DeviceFactory.O00000Oo(O000000o2.f11424O000000o), simpleDraweeView, (int) R.drawable.device_list_phone_no);
        o00000Oo.O00000Oo.setText(DeviceFactory.O0000OoO(O000000o2.f11424O000000o));
        int i2 = O000000o2.O00000Oo.rssi;
        if (i2 >= -30) {
            o00000Oo.O00000o0.setImageResource(R.drawable.tag_ble_04);
        } else if (i2 >= -50) {
            o00000Oo.O00000o0.setImageResource(R.drawable.tag_ble_03);
        } else if (i2 >= -70) {
            o00000Oo.O00000o0.setImageResource(R.drawable.tag_ble_02);
        } else {
            o00000Oo.O00000o0.setImageResource(R.drawable.tag_ble_01);
        }
        view.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.hti.AnonymousClass3 */

            public final void onClick(View view) {
                hti.this.f623O000000o.onCameraChoose(O000000o2);
            }
        });
        return view;
    }
}
