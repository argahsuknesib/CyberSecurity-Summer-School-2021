package _m_j;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;
import com.xiaomi.smarthome.library.common.widget.viewflow.LoadingMoreView;
import com.xiaomi.smarthome.miio.page.deviceshare.ShareDeviceInfoActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gxw extends fvm {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<O000000o> f18485O000000o = new ArrayList();
    public PullDownDragListView O00000Oo;
    public O00000Oo O00000o;
    public View O00000o0;
    public fsn O00000oO;
    View O00000oo;
    public ImageView O0000O0o;
    View O0000OOo;
    public boolean O0000Oo = false;
    public TextView O0000Oo0;
    public SparseBooleanArray O0000OoO = new SparseBooleanArray();
    XQProgressDialog O0000Ooo;
    private View O0000o;
    private LoadingMoreView O0000o0;
    private View O0000o00;
    private ImageView O0000o0O;
    private TextView O0000o0o;
    private boolean O0000oO = false;
    private boolean O0000oO0 = false;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.PullDownDragListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.O0000o00;
        if (view == null) {
            this.O0000o00 = layoutInflater.inflate((int) R.layout.receive_share_list, (ViewGroup) null);
            this.O0000o = getActivity().getWindow().findViewById(R.id.title_bar);
            this.O00000Oo = (PullDownDragListView) this.O0000o00.findViewById(R.id.share_message_list);
            this.O00000Oo.addHeaderView(LayoutInflater.from(getActivity()).inflate((int) R.layout.common_list_space_empty, (ViewGroup) this.O00000Oo, false));
            this.O0000o0 = new LoadingMoreView(getActivity());
            this.O0000o0.setVisibility(0);
            this.O00000Oo.setRefreshListener(new CustomPullDownRefreshListView.O00000o0() {
                /* class _m_j.gxw.AnonymousClass1 */

                public final void startRefresh() {
                    gxw.this.O00000Oo();
                }
            });
            this.O00000o0 = this.O0000o00.findViewById(R.id.common_white_empty_view);
            this.O00000o0.setVisibility(8);
            ((TextView) this.O0000o00.findViewById(R.id.common_white_empty_text)).setText((int) R.string.miio_no_message);
            this.O00000o = new O00000Oo(this, (byte) 0);
            this.O00000Oo.setAdapter((ListAdapter) this.O00000o);
            if (!(getActivity() == null || getActivity().findViewById(R.id.top_delete_bar) == null)) {
                this.O00000oo = getActivity().findViewById(R.id.top_delete_bar);
                this.O0000Oo0 = (TextView) this.O00000oo.findViewById(R.id.selected_cnt);
                this.O0000o0O = (ImageView) this.O00000oo.findViewById(R.id.cancel_btn);
                this.O0000O0o = (ImageView) this.O00000oo.findViewById(R.id.select_all_btn);
                this.O0000OOo = this.O0000o00.findViewById(R.id.bottom_delete_bar);
                this.O0000o0o = (TextView) this.O0000OOo.findViewById(R.id.delete_msg_btn);
                this.O0000o0o.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.gxw.AnonymousClass2 */

                    public final void onClick(View view) {
                        gxw gxw = gxw.this;
                        if (gxw.O0000OoO.size() == 0) {
                            gxw.getActivity();
                            gqg.O000000o((int) R.string.not_select_deleted_msg);
                            return;
                        }
                        new MLAlertDialog.Builder(gxw.getActivity()).O000000o((int) R.string.delete_msg_title).O00000Oo(gxw.getResources().getQuantityString(R.plurals.delete_msg, gxw.O0000OoO.size(), Integer.valueOf(gxw.O0000OoO.size()))).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
                            /* class _m_j.gxw.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ArrayList arrayList = new ArrayList();
                                ArrayList arrayList2 = new ArrayList();
                                for (int i2 = 0; i2 < gxw.this.O0000OoO.size(); i2++) {
                                    int keyAt = gxw.this.O0000OoO.keyAt(i2);
                                    if (gxw.this.O0000OoO.get(keyAt) && gxw.this.f18485O000000o.size() > keyAt) {
                                        O000000o o000000o = gxw.this.f18485O000000o.get(keyAt);
                                        if (!TextUtils.isEmpty(o000000o.f18495O000000o)) {
                                            arrayList.add(o000000o.f18495O000000o);
                                            arrayList2.add(o000000o.O00000o);
                                        }
                                    }
                                }
                                gxw gxw = gxw.this;
                                gxw.O0000Ooo = new XQProgressDialog(gxw.getActivity());
                                gxw.this.O0000Ooo.setCancelable(true);
                                gxw.this.O0000Ooo.setMessage(gxw.this.getResources().getString(R.string.loading_share_info));
                                gxw.this.O0000Ooo.show();
                                gxw.this.O0000Ooo.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                    /* class _m_j.gxw.AnonymousClass3.AnonymousClass1 */

                                    public final void onDismiss(DialogInterface dialogInterface) {
                                    }
                                });
                                fru.O000000o();
                                fru.O000000o(gxw.this.getActivity(), arrayList, arrayList2, new fsm<Void, fso>() {
                                    /* class _m_j.gxw.AnonymousClass3.AnonymousClass2 */

                                    public final void onFailure(fso fso) {
                                        if (gxw.this.isValid()) {
                                            if (gxw.this.O0000Ooo != null) {
                                                gxw.this.O0000Ooo.dismiss();
                                            }
                                            if (fso.f17063O000000o != -1 || !TextUtils.equals(fso.O00000Oo, "too much device")) {
                                                gqg.O00000Oo((int) R.string.smarthome_device_delete_fail);
                                            } else {
                                                gqg.O00000Oo((int) R.string.deldevicebatch_warring);
                                            }
                                        }
                                    }

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        if (gxw.this.isValid()) {
                                            gxw.this.O0000OoO.clear();
                                            gxw.this.O00000Oo();
                                            gxw.this.O0000Oo0.setVisibility(8);
                                            gxw.this.O0000O0o.setImageResource(R.drawable.all_select_selector);
                                            gxw.this.O0000O0o.setContentDescription(gxw.this.getString(R.string.select_all));
                                            gxw.this.O00000Oo.setSelectionAfterHeaderView();
                                            if (gxw.this.O0000Ooo != null) {
                                                gxw.this.O0000Ooo.dismiss();
                                            }
                                            fno.O000000o().O0000Oo0();
                                        }
                                    }
                                });
                            }
                        }).O00000o().show();
                    }
                });
            }
            O00000Oo();
            if (this.O0000oO && !this.O0000oO0) {
                this.O0000oO0 = true;
                onPageSelected();
            }
        } else if (view.getParent() != null) {
            ((ViewGroup) this.O0000o00.getParent()).removeView(this.O0000o00);
        }
        return this.O0000o00;
    }

    public final void O000000o() {
        this.O00000Oo.setPullDownEnabled(true);
        this.O0000Oo = false;
        this.O0000OoO.clear();
        this.O00000oo.setVisibility(8);
        this.O0000OOo.setVisibility(8);
        this.O00000o.notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        this.O00000oO = fru.O000000o().O000000o(getActivity().getApplicationContext(), CoreApi.O000000o().O0000o0(), new fsm<String, fso>() {
            /* class _m_j.gxw.AnonymousClass4 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str = (String) obj;
                if (gxw.this.isValid()) {
                    gxw gxw = gxw.this;
                    gxw.O00000oO = null;
                    FragmentActivity activity = gxw.getActivity();
                    if (activity != null && !activity.isFinishing()) {
                        if (gxw.this.O0000Ooo != null) {
                            gxw.this.O0000Ooo.dismiss();
                        }
                        gxw.this.O00000Oo.O00000Oo();
                        try {
                            ArrayList arrayList = new ArrayList();
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.isNull("result")) {
                                gxw.this.O00000o0.setVisibility(0);
                                gxw.this.O00000Oo.setVisibility(8);
                                return;
                            }
                            JSONArray optJSONArray = jSONObject.optJSONArray("result");
                            if (optJSONArray != null) {
                                if (optJSONArray.length() != 0) {
                                    gxw.this.O00000o0.setVisibility(8);
                                    gxw.this.O00000Oo.setVisibility(0);
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                        if (optJSONObject != null) {
                                            O000000o O000000o2 = O000000o.O000000o(optJSONObject);
                                            if (O000000o2.O0000O0o != 0 || O000000o2.O0000Oo0 != 0) {
                                                arrayList.add(O000000o2);
                                            }
                                        }
                                    }
                                    gxw.this.f18485O000000o = arrayList;
                                    Collections.sort(arrayList);
                                    gxw.this.O00000o.notifyDataSetChanged();
                                    if (arrayList.size() == 0) {
                                        gxw.this.O00000o0.setVisibility(0);
                                        gxw.this.O00000Oo.setVisibility(8);
                                        return;
                                    }
                                    return;
                                }
                            }
                            gxw.this.O00000o0.setVisibility(0);
                            gxw.this.O00000Oo.setVisibility(8);
                        } catch (JSONException unused) {
                        }
                    }
                }
            }

            public final void onFailure(fso fso) {
                if (gxw.this.isValid()) {
                    gxw.this.O00000Oo.O00000Oo();
                    gqg.O00000Oo((int) R.string.message_center_setting_load_err);
                    gxw.this.O00000o0.setVisibility(0);
                    gxw gxw = gxw.this;
                    gxw.O00000oO = null;
                    FragmentActivity activity = gxw.getActivity();
                    if (activity != null && !activity.isFinishing() && gxw.this.O0000Ooo != null) {
                        gxw.this.O0000Ooo.dismiss();
                    }
                }
            }
        });
    }

    public final void onDestroy() {
        super.onDestroy();
        fsn fsn = this.O00000oO;
        if (fsn != null) {
            fsn.cancel();
        }
    }

    public final void onResume() {
        super.onResume();
        PullDownDragListView pullDownDragListView = this.O00000Oo;
        if (pullDownDragListView != null) {
            pullDownDragListView.O000000o();
        }
    }

    class O00000Oo extends BaseAdapter {
        public final long getItemId(int i) {
            return 0;
        }

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(gxw gxw, byte b) {
            this();
        }

        public final int getCount() {
            return gxw.this.f18485O000000o.size();
        }

        public final Object getItem(int i) {
            if (i < 0 || i >= gxw.this.f18485O000000o.size()) {
                return null;
            }
            return gxw.this.f18485O000000o.get(i);
        }

        class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            View f18502O000000o;
            SimpleDraweeView O00000Oo;
            CheckBox O00000o;
            TextView O00000o0;
            TextView O00000oO;
            TextView O00000oo;

            private O000000o() {
            }

            /* synthetic */ O000000o(O00000Oo o00000Oo, byte b) {
                this();
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(final int i, View view, ViewGroup viewGroup) {
            O000000o o000000o;
            if (view == null) {
                view = LayoutInflater.from(gxw.this.getActivity()).inflate((int) R.layout.message_item_new, viewGroup, false);
                o000000o = new O000000o(this, (byte) 0);
                o000000o.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.device_icon);
                o000000o.O00000Oo.setHierarchy(new GenericDraweeHierarchyBuilder(o000000o.O00000Oo.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build());
                o000000o.O00000o0 = (TextView) view.findViewById(R.id.right_tv);
                o000000o.O00000o = (CheckBox) view.findViewById(R.id.ratio_btn);
                o000000o.O00000oO = (TextView) view.findViewById(R.id.device_item);
                o000000o.O00000oo = (TextView) view.findViewById(R.id.device_item_info);
                o000000o.f18502O000000o = view.findViewById(R.id.right_fl);
                view.findViewById(R.id.arrow).setVisibility(8);
                o000000o.O00000o.setVisibility(8);
                o000000o.O00000o0.setVisibility(0);
                view.setTag(o000000o);
            } else {
                o000000o = (O000000o) view.getTag();
            }
            final O000000o o000000o2 = (O000000o) getItem(i);
            if (i == getCount() - 1) {
                view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding_no_left_margin);
            } else {
                view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding);
            }
            if (o000000o.O00000Oo != null) {
                DeviceFactory.O00000Oo(o000000o2.O00000oo, o000000o.O00000Oo);
            }
            o000000o.O00000oO.setText(o000000o2.O00000oO);
            TextView textView = o000000o.O00000oo;
            StringBuilder sb = new StringBuilder();
            sb.append(gxw.this.getString(R.string.comefrom_device));
            sb.append(" ");
            sb.append(TextUtils.isEmpty(o000000o2.O00000o0) ? o000000o2.O0000Oo : o000000o2.O00000o0);
            textView.setText(sb.toString());
            o000000o.f18502O000000o.setVisibility(0);
            TextView textView2 = o000000o.O00000o0;
            int i2 = o000000o2.O0000O0o;
            if (i2 == 0) {
                textView2.setTextColor(gxw.this.getResources().getColor(R.color.mj_color_white));
                textView2.setBackgroundResource(R.drawable.std_button_important_selector);
                textView2.setPadding(gxw.this.getResources().getDimensionPixelSize(R.dimen.txt_padding_10), gxw.this.getResources().getDimensionPixelSize(R.dimen.txt_padding_3), gxw.this.getResources().getDimensionPixelSize(R.dimen.txt_padding_10), gxw.this.getResources().getDimensionPixelSize(R.dimen.txt_padding_3));
                textView2.setText((int) R.string.smarthome_share_accept);
                textView2.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.gxw.O00000Oo.AnonymousClass4 */

                    public final void onClick(View view) {
                        gxw.this.O0000Ooo = new XQProgressDialog(gxw.this.getActivity());
                        gxw.this.O0000Ooo.setCancelable(true);
                        gxw.this.O0000Ooo.setMessage(gxw.this.getResources().getString(R.string.loading_share_info));
                        gxw.this.O0000Ooo.show();
                        gxw.this.O0000Ooo.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            /* class _m_j.gxw.O00000Oo.AnonymousClass4.AnonymousClass1 */

                            public final void onDismiss(DialogInterface dialogInterface) {
                                gxw.this.O00000Oo();
                            }
                        });
                        gxw gxw = gxw.this;
                        O000000o o000000o = o000000o2;
                        fru.O000000o();
                        fru.O000000o(ServiceApplication.getAppContext(), "accept", "", o000000o.O00000Oo, new fsm<Void, fso>() {
                            /* class _m_j.gxw.AnonymousClass5 */

                            public final void onFailure(fso fso) {
                                if (gxw.this.isValid()) {
                                    if (gxw.this.O0000Ooo != null) {
                                        gxw.this.O0000Ooo.dismiss();
                                    }
                                    if (fso.f17063O000000o == -6) {
                                        izb.O000000o(ServiceApplication.getAppContext(), (int) R.string.smarthome_share_expired_toast, 0).show();
                                    } else {
                                        izb.O000000o(ServiceApplication.getAppContext(), (int) R.string.handle_error, 0).show();
                                    }
                                }
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                if (gxw.this.isValid()) {
                                    fno.O000000o().O0000Oo0();
                                    gxw.this.O00000Oo();
                                }
                            }
                        });
                    }
                });
            } else if (i2 == 1) {
                textView2.setTextColor(gxw.this.getResources().getColor(R.color.mj_color_gray_lighter));
                textView2.setPadding(0, gxw.this.getResources().getDimensionPixelSize(R.dimen.txt_padding_3), 0, gxw.this.getResources().getDimensionPixelSize(R.dimen.txt_padding_3));
                textView2.setBackgroundResource(0);
                if (o000000o2.O0000OoO == 0) {
                    textView2.setText((int) R.string.smarthome_share_accepted);
                } else if (o000000o2.O0000OoO == 1) {
                    textView2.setText((int) R.string.share_permission_cannot_control);
                } else if (o000000o2.O0000OoO == 2) {
                    textView2.setText((int) R.string.share_permission_can_control);
                } else {
                    textView2.setText((int) R.string.smarthome_share_accepted);
                }
            } else if (i2 == 2) {
                textView2.setTextColor(gxw.this.getResources().getColor(R.color.mj_color_gray_lighter));
                textView2.setPadding(0, gxw.this.getResources().getDimensionPixelSize(R.dimen.txt_padding_3), 0, gxw.this.getResources().getDimensionPixelSize(R.dimen.txt_padding_3));
                textView2.setBackgroundResource(0);
                textView2.setText((int) R.string.smarthome_share_rejected);
            } else {
                textView2.setTextColor(gxw.this.getResources().getColor(R.color.mj_color_gray_lighter));
                textView2.setPadding(0, gxw.this.getResources().getDimensionPixelSize(R.dimen.txt_padding_3), 0, gxw.this.getResources().getDimensionPixelSize(R.dimen.txt_padding_3));
                textView2.setBackgroundResource(0);
                textView2.setText("");
            }
            view.setOnLongClickListener(new View.OnLongClickListener() {
                /* class _m_j.gxw.O00000Oo.AnonymousClass1 */

                public final boolean onLongClick(View view) {
                    if (!gxw.this.O0000Oo) {
                        gxw.this.O00000Oo.setPullDownEnabled(false);
                        if (!gxw.this.O0000OoO.get(i)) {
                            ((O000000o) view.getTag()).O00000o.performClick();
                        }
                        gxw gxw = gxw.this;
                        gxw.O00000oo.setVisibility(0);
                        gxw.O0000OOo.setVisibility(0);
                        gxw.O00000oo.measure(0, 0);
                        gxw.O0000OOo.measure(0, 0);
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(gxw.O00000oo, View.Y, (float) (-gxw.O00000oo.getMeasuredHeight()), 0.0f);
                        ViewGroup viewGroup = (ViewGroup) gxw.O0000OOo.getParent();
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(gxw.O0000OOo, View.Y, (float) viewGroup.getHeight(), (float) (viewGroup.getHeight() - gxw.O0000OOo.getMeasuredHeight()));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.setDuration(200L);
                        animatorSet.play(ofFloat).with(ofFloat2);
                        animatorSet.start();
                        gxw.this.O0000Oo = true;
                        O00000Oo.this.notifyDataSetChanged();
                        ((ShareDeviceInfoActivity) gxw.this.getActivity()).setViewPagerSwipe(false);
                    }
                    return true;
                }
            });
            o000000o.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gxw.O00000Oo.AnonymousClass2 */

                public final void onClick(View view) {
                    if (!gxw.this.O0000OoO.get(i)) {
                        gxw.this.O0000OoO.put(i, true);
                    } else {
                        gxw.this.O0000OoO.delete(i);
                    }
                    if (gxw.this.O0000OoO.size() == gxw.this.f18485O000000o.size()) {
                        gxw.this.O0000O0o.setImageResource(R.drawable.un_select_selector);
                        gxw.this.O0000O0o.setContentDescription(gxw.this.getString(R.string.unselect_all));
                    } else {
                        gxw.this.O0000O0o.setImageResource(R.drawable.all_select_selector);
                        gxw.this.O0000O0o.setContentDescription(gxw.this.getString(R.string.select_all));
                    }
                    if (gxw.this.O0000OoO.size() > 0) {
                        gxw.this.O0000Oo0.setVisibility(0);
                        gxw.this.O0000Oo0.setText(gxw.this.getResources().getQuantityString(R.plurals.selected_cnt_tips, gxw.this.O0000OoO.size(), Integer.valueOf(gxw.this.O0000OoO.size())));
                        return;
                    }
                    gxw.this.O0000Oo0.setVisibility(0);
                    gxw.this.O0000Oo0.setText(gxw.this.getString(R.string.selected_0_cnt_tips));
                }
            });
            if (gxw.this.O0000Oo) {
                o000000o.f18502O000000o.setVisibility(0);
                o000000o.O00000o.setVisibility(0);
                o000000o.O00000o0.setVisibility(8);
                view.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.gxw.O00000Oo.AnonymousClass3 */

                    public final void onClick(View view) {
                        ((O000000o) view.getTag()).O00000o.performClick();
                    }
                });
                if (gxw.this.O0000OoO.get(i)) {
                    o000000o.O00000o.setChecked(true);
                } else {
                    o000000o.O00000o.setChecked(false);
                }
            } else {
                o000000o.f18502O000000o.setVisibility(0);
                o000000o.O00000o.setVisibility(8);
                o000000o.O00000o0.setVisibility(0);
            }
            return view;
        }
    }

    static class O000000o implements Comparable<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18495O000000o;
        public int O00000Oo;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;
        public String O00000oo;
        public int O0000O0o;
        public long O0000OOo;
        public String O0000Oo;
        public long O0000Oo0;
        public int O0000OoO = 0;

        private O000000o() {
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            O000000o o000000o = (O000000o) obj;
            if (o000000o == null) {
                return 1;
            }
            long j = this.O0000OOo;
            long j2 = o000000o.O0000OOo;
            if (j > j2) {
                return -1;
            }
            return j < j2 ? 1 : 0;
        }

        public static O000000o O000000o(JSONObject jSONObject) {
            O000000o o000000o = new O000000o();
            o000000o.O00000Oo = jSONObject.optInt("inv_id");
            o000000o.O00000o0 = jSONObject.optString("sender_name");
            o000000o.O00000o = jSONObject.optString("did");
            o000000o.O00000oO = jSONObject.optString("device_name");
            o000000o.O00000oo = jSONObject.optString("model");
            o000000o.O0000O0o = jSONObject.optInt("status", -1);
            o000000o.O0000OOo = jSONObject.optLong("ctime");
            o000000o.O0000Oo0 = jSONObject.optLong("expire_time");
            o000000o.O0000Oo = jSONObject.optString("sender");
            o000000o.f18495O000000o = jSONObject.optString("msgId");
            if (!jSONObject.isNull("isReadOnly")) {
                o000000o.O0000OoO = jSONObject.optBoolean("isReadOnly") ? 1 : 2;
            }
            return o000000o;
        }
    }

    public final boolean onBackPressed() {
        if (!this.O0000Oo) {
            return false;
        }
        O000000o();
        return true;
    }

    public final void onPageSelected() {
        ImageView imageView = this.O0000o0O;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gxw.AnonymousClass6 */

                public final void onClick(View view) {
                    ((ShareDeviceInfoActivity) gxw.this.getActivity()).setViewPagerSwipe(true);
                    gxw.this.O000000o();
                }
            });
        }
        ImageView imageView2 = this.O0000O0o;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gxw.AnonymousClass7 */

                public final void onClick(View view) {
                    if (gxw.this.O0000OoO.size() == gxw.this.f18485O000000o.size()) {
                        gxw gxw = gxw.this;
                        gxw.O0000OoO.clear();
                        gxw.O0000O0o.setImageResource(R.drawable.all_select_selector);
                        gxw.O0000O0o.setContentDescription(gxw.getString(R.string.select_all));
                        gxw.O00000o.notifyDataSetChanged();
                        gxw.O0000Oo0.setVisibility(8);
                        return;
                    }
                    gxw gxw2 = gxw.this;
                    int size = gxw2.f18485O000000o.size();
                    for (int i = 0; i < size; i++) {
                        gxw2.O0000OoO.put(i, true);
                    }
                    gxw2.O0000O0o.setImageResource(R.drawable.un_select_selector);
                    gxw2.O0000O0o.setContentDescription(gxw2.getString(R.string.unselect_all));
                    gxw2.O00000o.notifyDataSetChanged();
                    gxw2.O0000Oo0.setVisibility(0);
                    gxw2.O0000Oo0.setText(gxw2.getResources().getQuantityString(R.plurals.selected_cnt_tips, gxw2.O0000OoO.size(), Integer.valueOf(gxw2.O0000OoO.size())));
                }
            });
        }
    }

    public final void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        this.O0000oO = z;
        if (!z) {
            return;
        }
        if (getView() == null) {
            this.O0000oO0 = false;
            return;
        }
        onPageSelected();
        this.O0000oO0 = true;
    }
}
