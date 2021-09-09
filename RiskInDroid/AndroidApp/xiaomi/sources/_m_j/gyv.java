package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.miui.AutoMaskLinearLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class gyv extends RecyclerView.O000000o<RecyclerView.O000OOo0> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f18590O000000o;
    public static int O00000Oo;
    public final WeakReference<AutoMaskLinearLayout> O00000o;
    public Context O00000o0;
    public List<GridViewData> O00000oO = new ArrayList();
    public hfq O00000oo;
    public boolean O0000O0o = false;
    public BroadcastReceiver O0000OOo = new BroadcastReceiver() {
        /* class _m_j.gyv.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "common_used_device_updated")) {
                if (!TextUtils.equals(intent.getStringExtra("common_use_device_operation"), "operation_sync")) {
                    gyv.this.O0000O0o = true;
                }
            } else if (gyv.this.O00000o.get() != null) {
                gyv.this.O00000o.get().setShowLoading(false);
            }
            gyv.this.O000000o();
            gyv.this.notifyDataSetChanged();
        }
    };
    private boolean O0000Oo = false;
    public boolean O0000Oo0 = true;
    private int O0000OoO = 0;

    public class O000000o extends RecyclerView.O000OOo0 {
    }

    public gyv(Context context, AutoMaskLinearLayout autoMaskLinearLayout, boolean z, int i) {
        this.O00000o0 = context;
        this.O00000o = new WeakReference<>(autoMaskLinearLayout);
        IntentFilter intentFilter = new IntentFilter("common_used_device_updated");
        intentFilter.addAction("force_update_data_completed");
        ft.O000000o(this.O00000o0).O000000o(this.O0000OOo, intentFilter);
        setHasStableIds(true);
        this.O0000Oo = z;
        O00000Oo = i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.O00000o0);
        if (i == GridViewData.GridType.TYPE_TIPS.ordinal()) {
            return new O00000Oo(from.inflate((int) R.layout.common_device_edit_tips_item, viewGroup, false));
        }
        return new O00000o0(from.inflate((int) R.layout.common_device_edit_item, viewGroup, false));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
        r0 = r6.O00000Oo;
     */
    public final void onBindViewHolder(final RecyclerView.O000OOo0 o000OOo0, int i) {
        final Device device;
        o000OOo0.itemView.setVisibility(0);
        GridViewData gridViewData = this.O00000oO.get(i);
        if (gridViewData != null) {
            if (gridViewData.f8988O000000o == GridViewData.GridType.TYPE_IR) {
                O00000o0 o00000o0 = (O00000o0) o000OOo0;
                o00000o0.f18598O000000o.setText((int) R.string.phone_ir_device);
                o00000o0.O00000Oo.setImageResource(R.drawable.device_icon_ir_nor);
                final Device O00000Oo2 = gridViewData.O00000Oo != null ? gridViewData.O00000Oo : fqw.O00000Oo();
                o00000o0.O00000o.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.gyv.AnonymousClass4 */

                    public final void onClick(View view) {
                        gyw.O000000o(gyv.this.O00000o0, O00000Oo2);
                    }
                });
                o00000o0.O00000oo.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class _m_j.gyv.AnonymousClass5 */

                    public final boolean onLongClick(View view) {
                        if (gyv.this.O00000oo == null) {
                            return false;
                        }
                        gyv.this.O00000oo.onStartDrag(o000OOo0);
                        return false;
                    }
                });
            } else if ((o000OOo0 instanceof O00000o0) && device != null) {
                O00000o0 o00000o02 = (O00000o0) o000OOo0;
                DeviceFactory.O00000Oo(device.model, o00000o02.O00000Oo);
                o00000o02.f18598O000000o.setText(gridViewData.O00000o0);
                o00000o02.O00000oo.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class _m_j.gyv.AnonymousClass2 */

                    public final boolean onLongClick(View view) {
                        if (gyv.this.O00000oo != null) {
                            gyv.this.O00000oo.onStartDrag(o000OOo0);
                        }
                        gyv.this.O0000Oo0 = true;
                        return false;
                    }
                });
                o00000o02.O00000o.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.gyv.AnonymousClass3 */

                    public final void onClick(View view) {
                        gyw.O000000o(gyv.this.O00000o0, device);
                    }
                });
            }
        }
    }

    public final long getItemId(int i) {
        int ordinal;
        if (this.O00000oO.get(i).f8988O000000o == GridViewData.GridType.TYPE_TIPS || this.O00000oO.get(i).f8988O000000o == GridViewData.GridType.TYPE_IR) {
            ordinal = this.O00000oO.get(i).f8988O000000o.ordinal();
        } else {
            ordinal = this.O00000oO.get(i).O00000Oo.did.hashCode();
        }
        return (long) ordinal;
    }

    public final int getItemCount() {
        return this.O00000oO.size();
    }

    public final int getItemViewType(int i) {
        return this.O00000oO.get(i).f8988O000000o.ordinal();
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.O00000Oo() {
                /* class _m_j.gyv.AnonymousClass6 */

                public final int getSpanSize(int i) {
                    if (gyv.this.getItemViewType(i) == GridViewData.GridType.TYPE_TIPS.ordinal()) {
                        return gridLayoutManager.getSpanCount();
                    }
                    return 1;
                }
            });
        }
    }

    public final boolean O000000o(int i, int i2) {
        try {
            if (this.O00000oO.get(i).f8988O000000o == GridViewData.GridType.TYPE_TIPS || this.O00000oO.get(i2).f8988O000000o == GridViewData.GridType.TYPE_TIPS) {
                return false;
            }
            if (i < i2) {
                int i3 = i;
                for (int i4 = i + 1; i4 <= i2; i4++) {
                    if (this.O00000oO.get(i4).f8988O000000o != GridViewData.GridType.TYPE_TIPS) {
                        Collections.swap(this.O00000oO, i3, i4);
                        i3 = i4;
                    }
                }
            } else {
                int i5 = i;
                for (int i6 = i - 1; i6 >= i2; i6--) {
                    if (this.O00000oO.get(i6).f8988O000000o != GridViewData.GridType.TYPE_TIPS) {
                        Collections.swap(this.O00000oO, i5, i6);
                        i5 = i6;
                    }
                }
            }
            gsy.O000000o(6, "CommonDeviceEditAdapter", "item moved from " + i + " to " + i2);
            notifyItemMoved(i, i2);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void O000000o() {
        List<GridViewData> O0000o0 = ggb.O00000Oo().O0000o0();
        this.O0000OoO = O0000o0.size();
        if (this.O00000o.get() != null) {
            this.O00000o.get().setDeviceCount(O0000o0.size());
            if (O0000o0.size() > 0) {
                this.O00000o.get().setShowLoading(false);
            }
        }
        this.O00000oO = O0000o0;
    }

    class O00000o0 extends RecyclerView.O000OOo0 implements hhm {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f18598O000000o;
        SimpleDraweeView O00000Oo;
        View O00000o;
        ImageView O00000o0;
        View O00000oO;
        RelativeLayout O00000oo;

        public O00000o0(View view) {
            super(view);
            this.O00000oO = view;
            this.O00000oo = (RelativeLayout) view.findViewById(R.id.rv_content);
            this.f18598O000000o = (TextView) view.findViewById(R.id.tv_device_name);
            this.O00000o0 = (ImageView) view.findViewById(R.id.iv_edit);
            this.O00000o = view.findViewById(R.id.fl_edit);
            this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.icon);
            Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
            if (O0000Oo0 != null) {
                this.O00000o.setVisibility(O0000Oo0.isOwner() ? 0 : 8);
            }
        }

        public final void O000000o() {
            this.itemView.setSelected(true);
        }

        public final void O00000Oo() {
            this.itemView.setSelected(false);
        }
    }

    class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f18597O000000o;

        public O00000Oo(View view) {
            super(view);
            this.f18597O000000o = view;
        }
    }
}
