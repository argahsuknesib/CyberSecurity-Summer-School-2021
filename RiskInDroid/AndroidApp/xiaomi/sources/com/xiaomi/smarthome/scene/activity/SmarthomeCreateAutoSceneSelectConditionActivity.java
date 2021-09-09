package com.xiaomi.smarthome.scene.activity;

import _m_j.axy;
import _m_j.fno;
import _m_j.hos;
import _m_j.hou;
import _m_j.hoy;
import _m_j.hpb;
import _m_j.hpq;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SmarthomeCreateAutoSceneSelectConditionActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f11037O000000o;
    LayoutInflater O00000Oo;
    HashMap<hos, Boolean> O00000o = new HashMap<>();
    List<hos> O00000o0 = new ArrayList();
    int O00000oO = -1;
    int O00000oo = -1;
    SceneApi.O000OOOo O0000O0o;
    SceneApi.O000000o O0000OOo = null;

    public class ConditionViewHolder extends axy {
        @BindView(5285)
        TextView mContentTV;
        @BindView(5457)
        ImageView mExpandHint;
        @BindView(5480)
        TextView mFilterTV;
        @BindView(5289)
        SimpleDraweeView mIcon;
        @BindView(6424)
        View mRootView;
        @BindView(6393)
        RelativeLayout mTitleRl;
        @BindView(6366)
        TextView mTitleTV;
    }

    public class ConditionViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ConditionViewHolder f11038O000000o;

        public ConditionViewHolder_ViewBinding(ConditionViewHolder conditionViewHolder, View view) {
            this.f11038O000000o = conditionViewHolder;
            conditionViewHolder.mIcon = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.content_icon, "field 'mIcon'", SimpleDraweeView.class);
            conditionViewHolder.mRootView = Utils.findRequiredView(view, R.id.true_item_view, "field 'mRootView'");
            conditionViewHolder.mExpandHint = (ImageView) Utils.findRequiredViewAsType(view, R.id.expand_hint, "field 'mExpandHint'", ImageView.class);
            conditionViewHolder.mContentTV = (TextView) Utils.findRequiredViewAsType(view, R.id.content, "field 'mContentTV'", TextView.class);
            conditionViewHolder.mTitleRl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.title_rl, "field 'mTitleRl'", RelativeLayout.class);
            conditionViewHolder.mTitleTV = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'mTitleTV'", TextView.class);
            conditionViewHolder.mFilterTV = (TextView) Utils.findRequiredViewAsType(view, R.id.filter, "field 'mFilterTV'", TextView.class);
        }

        public void unbind() {
            ConditionViewHolder conditionViewHolder = this.f11038O000000o;
            if (conditionViewHolder != null) {
                this.f11038O000000o = null;
                conditionViewHolder.mIcon = null;
                conditionViewHolder.mRootView = null;
                conditionViewHolder.mExpandHint = null;
                conditionViewHolder.mContentTV = null;
                conditionViewHolder.mTitleRl = null;
                conditionViewHolder.mTitleTV = null;
                conditionViewHolder.mFilterTV = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        Device O000000o2;
        hos O000000o3;
        hos O000000o4;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_create_auto_scene_select_condition_layout);
        this.f11037O000000o = this;
        this.O00000Oo = LayoutInflater.from(this.f11037O000000o);
        this.O0000O0o = hpq.O000000o().O00000Oo;
        if (this.O0000O0o == null) {
            finish();
            return;
        }
        for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
            Device device = (Device) value.getValue();
            if (!device.isSubDevice() && (O000000o4 = hos.O000000o(device)) != null) {
                this.O00000o0.add(O000000o4);
            }
        }
        Iterator<Map.Entry<String, Device>> it = fno.O000000o().O00000Oo().entrySet().iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                break;
            }
            Device device2 = (Device) it.next().getValue();
            if (device2.isOwner() && (O000000o2 = fno.O000000o().O000000o(device2.parentId)) != null && O000000o2.isOwner() && (O000000o3 = hos.O000000o(device2)) != null) {
                int i = 0;
                while (true) {
                    if (i < this.O00000o0.size()) {
                        Device O00000o02 = this.O00000o0.get(i).O00000o0();
                        if (O00000o02 != null && !O00000o02.isSubDevice() && device2.parentId.equalsIgnoreCase(O00000o02.did)) {
                            this.O00000o0.add(i + 1, O000000o3);
                            z2 = true;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                if (!z2) {
                    this.O00000o0.add(O000000o3);
                }
            }
        }
        this.O00000o0.add(0, new hou());
        this.O00000o0.add(1, new hpb());
        this.O00000o0.add(4, new hoy());
        this.O0000OOo = hpq.O000000o().O00000oO;
        for (int i2 = 0; i2 < this.O0000O0o.O0000O0o.size(); i2++) {
            int size = this.O00000o0.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                int O000000o5 = this.O00000o0.get(size).O000000o(this.O0000O0o.O0000O0o.get(i2));
                if (O000000o5 != -1) {
                    SceneApi.O000000o o000000o = this.O0000OOo;
                    if (o000000o != null && o000000o.equals(this.O0000O0o.O0000O0o.get(i2))) {
                        this.O00000o0.get(size);
                        this.O00000oO = O000000o5;
                    } else if (!this.O00000o0.get(size).O00000oo()) {
                        this.O00000o.put(this.O00000o0.get(size), Boolean.FALSE);
                    } else {
                        this.O00000o0.get(size).O000000o(O000000o5);
                        if (this.O00000o0.get(size).O00000Oo()) {
                            this.O00000o.put(this.O00000o0.get(size), Boolean.FALSE);
                        }
                    }
                } else {
                    size--;
                }
            }
        }
        if (this.O00000oO != -1) {
            this.O00000oo = this.O0000O0o.O0000O0o.indexOf(this.O0000OOo);
            this.O0000O0o.O0000O0o.remove(this.O0000OOo);
            hpq.O000000o().O00000o(this.O0000O0o);
        }
        ArrayList arrayList = new ArrayList();
        for (int size2 = this.O00000o0.size() - 1; size2 >= 0; size2--) {
            if (this.O00000o0.get(size2).O00000oo()) {
                int[] O00000oO2 = this.O00000o0.get(size2).O00000oO();
                int length = O00000oO2.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = true;
                        break;
                    }
                    Integer valueOf = Integer.valueOf(O00000oO2[i3]);
                    if (hpq.O000000o().O00000Oo.O0000Ooo == 1 || hpq.O000000o().O000000o(Integer.valueOf(this.O00000o0.get(size2).O00000o0(valueOf.intValue())))) {
                        z = false;
                    } else {
                        i3++;
                    }
                }
                z = false;
                if (!z && this.O00000o0.get(size2).O00000Oo()) {
                    z = true;
                }
                if (z) {
                    this.O00000o.put(this.O00000o0.get(size2), Boolean.FALSE);
                    arrayList.add(this.O00000o0.remove(size2));
                }
            } else if (hpq.O000000o().O00000Oo.O0000Ooo == 1 || hpq.O000000o().O000000o(Integer.valueOf(this.O00000o0.get(size2).O00000o0(0)))) {
                this.O00000o.put(this.O00000o0.get(size2), Boolean.TRUE);
            } else {
                this.O00000o.put(this.O00000o0.get(size2), Boolean.FALSE);
                arrayList.add(this.O00000o0.remove(size2));
            }
        }
        this.O00000o0.addAll(arrayList);
    }
}
