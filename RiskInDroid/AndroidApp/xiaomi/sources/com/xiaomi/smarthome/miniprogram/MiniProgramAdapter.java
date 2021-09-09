package com.xiaomi.smarthome.miniprogram;

import _m_j.gqg;
import _m_j.gym;
import _m_j.gyo;
import _m_j.gyp;
import _m_j.gyr;
import _m_j.gys;
import _m_j.hxi;
import _m_j.hyq;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.ArrayList;
import java.util.List;

public final class MiniProgramAdapter extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    public gyp f9968O000000o;
    public gyo O00000Oo;
    public XQProgressDialog O00000o;
    public List<gys> O00000o0 = new ArrayList();
    public CommonActivity O00000oO;
    private LayoutInflater O00000oo;

    public final long getItemId(int i) {
        return 0;
    }

    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ViewHolder f9975O000000o;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f9975O000000o = viewHolder;
            viewHolder.title = (TextView) Utils.findRequiredViewAsType(view, R.id.device_name, "field 'title'", TextView.class);
            viewHolder.send = (TextView) Utils.findRequiredViewAsType(view, R.id.btn_share, "field 'send'", TextView.class);
            viewHolder.shareState = (TextView) Utils.findRequiredViewAsType(view, R.id.share_flag, "field 'shareState'", TextView.class);
            viewHolder.deviceImg = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.device_img, "field 'deviceImg'", SimpleDraweeView.class);
            viewHolder.checkbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ckb_edit_selected, "field 'checkbox'", CheckBox.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.f9975O000000o;
            if (viewHolder != null) {
                this.f9975O000000o = null;
                viewHolder.title = null;
                viewHolder.send = null;
                viewHolder.shareState = null;
                viewHolder.deviceImg = null;
                viewHolder.checkbox = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public MiniProgramAdapter(CommonActivity commonActivity) {
        this.O00000oO = commonActivity;
        this.O00000oo = LayoutInflater.from(commonActivity);
        this.O00000o = new XQProgressDialog(commonActivity);
        this.O00000o.setMessage(commonActivity.getString(R.string.mj_loading));
        this.O00000o.setCancelable(true);
        this.O00000o.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.miniprogram.MiniProgramAdapter.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                gym.O000000o().O0000oO = null;
            }
        });
    }

    public final void O000000o() {
        this.O00000o0.clear();
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.O00000o0.size();
    }

    public final Object getItem(int i) {
        if (i < 0 || i >= this.O00000o0.size()) {
            return null;
        }
        return this.O00000o0.get(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.O00000oo.inflate((int) R.layout.item_mini_program, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        view.setBackgroundResource(i == getCount() - 1 ? R.drawable.mj_rs_common_white_list_padding_no_left_margin : R.drawable.mj_rs_common_white_list_padding);
        if (hyq.O000000o().f997O000000o == 1) {
            viewHolder.send.setVisibility(0);
            viewHolder.checkbox.setVisibility(8);
        } else {
            viewHolder.send.setVisibility(8);
            viewHolder.checkbox.setVisibility(0);
        }
        if (hyq.O000000o().O00000o0.get(i)) {
            viewHolder.checkbox.setChecked(true);
        } else {
            viewHolder.checkbox.setChecked(false);
        }
        gys gys = this.O00000o0.get(i);
        viewHolder.title.setText(gys.O00000o0.getName());
        viewHolder.title.setTextColor(view.getContext().getResources().getColor(R.color.mj_color_black_100_transparent));
        DeviceFactory.O00000Oo(gys.O00000o0.model, viewHolder.deviceImg);
        if (!gys.f18585O000000o || gys.O00000Oo <= 0) {
            viewHolder.shareState.setText((int) R.string.not_auth_program);
            viewHolder.shareState.setTextColor(view.getContext().getResources().getColor(R.color.mj_color_gray_normal));
        } else {
            viewHolder.shareState.setText((int) R.string.already_auth_program);
            viewHolder.shareState.setTextColor(view.getContext().getResources().getColor(R.color.mj_color_green_normal));
        }
        viewHolder.send.setTextColor(view.getContext().getResources().getColorStateList(R.color.selector_common_text));
        viewHolder.send.setBackgroundResource(R.drawable.selector_common_btn);
        float f = view.getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (15.0f * f);
        int i3 = (int) (f * 7.0f);
        viewHolder.send.setPadding(i2, i3, i2, i3);
        viewHolder.send.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miniprogram.MiniProgramAdapter.AnonymousClass2 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gym.O000000o(_m_j.gys, java.lang.String, boolean, boolean, _m_j.gyr):void
             arg types: [_m_j.gys, java.lang.String, int, int, com.xiaomi.smarthome.miniprogram.MiniProgramAdapter$2$1]
             candidates:
              _m_j.gym.O000000o(com.xiaomi.smarthome.device.Device, java.lang.String, java.lang.String, boolean, boolean):void
              _m_j.gym.O000000o(_m_j.gys, java.lang.String, boolean, boolean, _m_j.gyr):void */
            public final void onClick(View view) {
                if (ServiceApplication.getIWXAPI().isWXAppInstalled()) {
                    if (MiniProgramAdapter.this.O00000o != null && !MiniProgramAdapter.this.O00000o.isShowing() && MiniProgramAdapter.this.O00000oO.isValid()) {
                        MiniProgramAdapter.this.O00000o.show();
                    }
                    gym.O000000o().O000000o(MiniProgramAdapter.this.O00000o0.get(i), "", true, true, (gyr) new gyr(MiniProgramAdapter.this.O00000o0.get(i).O00000o0.did) {
                        /* class com.xiaomi.smarthome.miniprogram.MiniProgramAdapter.AnonymousClass2.AnonymousClass1 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.hxk.O000000o(java.lang.String, boolean):void
                         arg types: [java.lang.String, int]
                         candidates:
                          _m_j.hxk.O000000o(int, int):void
                          _m_j.hxk.O000000o(java.lang.String, int):void
                          _m_j.hxk.O000000o(java.lang.String, long):void
                          _m_j.hxk.O000000o(java.lang.String, java.lang.String):void
                          _m_j.hxk.O000000o(java.lang.String, org.json.JSONObject):void
                          _m_j.hxk.O000000o(boolean, java.lang.String):void
                          _m_j.hxk.O000000o(java.lang.String, boolean):void */
                        public final void O000000o() {
                            if (MiniProgramAdapter.this.O00000o != null && MiniProgramAdapter.this.O00000o.isShowing() && MiniProgramAdapter.this.O00000oO.isValid()) {
                                MiniProgramAdapter.this.O00000o.dismiss();
                            }
                            gys gys = MiniProgramAdapter.this.O00000o0.get(i);
                            if (gys != null && gys.O00000o0 != null) {
                                hxi.O00000o.O000000o(gys.O00000o0.model, true);
                            }
                        }

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.hxk.O000000o(java.lang.String, boolean):void
                         arg types: [java.lang.String, int]
                         candidates:
                          _m_j.hxk.O000000o(int, int):void
                          _m_j.hxk.O000000o(java.lang.String, int):void
                          _m_j.hxk.O000000o(java.lang.String, long):void
                          _m_j.hxk.O000000o(java.lang.String, java.lang.String):void
                          _m_j.hxk.O000000o(java.lang.String, org.json.JSONObject):void
                          _m_j.hxk.O000000o(boolean, java.lang.String):void
                          _m_j.hxk.O000000o(java.lang.String, boolean):void */
                        public final void O00000Oo() {
                            if (MiniProgramAdapter.this.O00000o != null && MiniProgramAdapter.this.O00000o.isShowing() && MiniProgramAdapter.this.O00000oO.isValid()) {
                                MiniProgramAdapter.this.O00000o.dismiss();
                            }
                            gqg.O00000Oo((int) R.string.share_failed);
                            gys gys = MiniProgramAdapter.this.O00000o0.get(i);
                            if (gys != null && gys.O00000o0 != null) {
                                hxi.O00000o.O000000o(gys.O00000o0.model, false);
                            }
                        }
                    });
                    return;
                }
                gqg.O00000Oo((int) R.string.mj_wx_not_installed);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miniprogram.MiniProgramAdapter.AnonymousClass3 */

            public final void onClick(View view) {
                ViewHolder viewHolder = (ViewHolder) view.getTag();
                boolean z = hyq.O000000o().O00000o0.get(i);
                if (hyq.O000000o().f997O000000o == 0) {
                    if (z) {
                        viewHolder.checkbox.setChecked(false);
                        hyq.O000000o().O00000o0.delete(i);
                    } else {
                        viewHolder.checkbox.setChecked(true);
                        hyq.O000000o().O00000o0.put(i, true);
                    }
                    if (MiniProgramAdapter.this.O00000Oo != null) {
                        MiniProgramAdapter.this.O00000Oo.onCheck(hyq.O000000o().O00000o0.size());
                    }
                    MiniProgramAdapter.this.notifyDataSetChanged();
                }
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.xiaomi.smarthome.miniprogram.MiniProgramAdapter.AnonymousClass4 */

            public final boolean onLongClick(View view) {
                if (MiniProgramAdapter.this.f9968O000000o != null && MiniProgramAdapter.this.f9968O000000o.allowPerformLongClick()) {
                    MiniProgramAdapter.this.f9968O000000o.onLongClick();
                    ((ViewHolder) view.getTag()).checkbox.setChecked(true);
                    hyq.O000000o().O00000o0.put(i, true);
                    MiniProgramAdapter.this.notifyDataSetChanged();
                }
                return true;
            }
        });
        return view;
    }

    class ViewHolder {
        @BindView(5075)
        CheckBox checkbox;
        @BindView(5162)
        SimpleDraweeView deviceImg;
        @BindView(5016)
        TextView send;
        @BindView(5865)
        TextView shareState;
        @BindView(5168)
        TextView title;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
