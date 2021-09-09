package com.xiaomi.smarthome.miio.page;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fuh;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gwc;
import _m_j.gwg;
import _m_j.gyl;
import _m_j.hsx;
import _m_j.hxi;
import _m_j.hys;
import _m_j.hzf;
import _m_j.izb;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.family.ShareDeviceActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;
import com.xiaomi.smarthome.miio.db.record.ShareUserRecord;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareDeviceDetail extends BaseActivity {
    private static int[] O00000o = {R.string.smarthome_device_delete_share};

    /* renamed from: O000000o  reason: collision with root package name */
    DateFormat f9854O000000o;
    XQProgressDialog O00000Oo;
    Device O00000o0;
    private View O00000oO;
    private ImageView O00000oo;
    private View O0000O0o;
    private TextView O0000OOo;
    public boolean isFromShareDeviceActivity = false;
    public boolean isLogEnterEvent = false;
    public O000000o mAdapter;
    public SparseBooleanArray mCheckedItems = new SparseBooleanArray();
    public String mDid;
    public boolean mEditMode = false;
    public View mEmptyView;
    public ImageView mIvSelectAll;
    public PullDownDragListView mList;
    public int mPid;
    public TextView mSelectedCntTv;
    public List<hsx> mShareUsers = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.share_device_detail_layout);
        this.mDid = getIntent().getExtras().getString("did");
        this.mPid = getIntent().getExtras().getInt("pid");
        this.isFromShareDeviceActivity = getIntent().getExtras().getBoolean("key_from_sharedeviceactivity", false);
        if (this.mDid == null) {
            finish();
            return;
        }
        this.O00000o0 = fno.O000000o().O000000o(this.mDid);
        if (this.O00000o0 == null) {
            finish();
            return;
        }
        try {
            this.f9854O000000o = gwc.O000000o((Activity) this);
        } catch (Exception unused) {
            finish();
        }
        this.mEmptyView = findViewById(R.id.common_white_empty_view);
        this.mEmptyView.setVisibility(8);
        this.mList = (PullDownDragListView) findViewById(R.id.share_user_list);
        this.mList.O00000Oo();
        this.mAdapter = new O000000o();
        this.mList.setAdapter((ListAdapter) this.mAdapter);
        ((TextView) findViewById(R.id.common_white_empty_text)).setText((int) R.string.share_no_user);
        ((TextView) findViewById(R.id.tv_add_scene)).setText((int) R.string.smarthome_add_share);
        findViewById(R.id.tv_add_scene).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.AnonymousClass2 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
             arg types: [java.lang.String, int]
             candidates:
              ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
              ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
            public final void onClick(View view) {
                hxi.O00000o.f952O000000o.O000000o("plugin_deviceshare_edit_add", new Object[0]);
                if (ShareDeviceDetail.this.isFromShareDeviceActivity) {
                    ShareDeviceDetail.this.finish();
                } else if (CoreApi.O000000o().O0000Ooo()) {
                    Intent intent = new Intent();
                    intent.putExtra("user_id", CoreApi.O000000o().O0000o0());
                    intent.putExtra("did", ShareDeviceDetail.this.mDid);
                    intent.setClass(ShareDeviceDetail.this, ShareDeviceActivity.class);
                    intent.putExtra("key_from_sharedevicedetail", true);
                    ShareDeviceDetail.this.startActivity(intent);
                } else {
                    izb.O000000o(ShareDeviceDetail.this, (int) R.string.loggin_first, 0).show();
                }
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(getString(R.string.smarthome_device_user_detail_title, new Object[]{this.O00000o0.name}));
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.AnonymousClass3 */

            public final void onClick(View view) {
                ShareDeviceDetail.this.finish();
                hxi.O00000o.f952O000000o.O000000o("plugin_deviceshare_edit_back", new Object[0]);
            }
        });
        this.O00000oO = findViewById(R.id.top_delete_bar);
        this.mSelectedCntTv = (TextView) this.O00000oO.findViewById(R.id.selected_cnt);
        this.O00000oo = (ImageView) this.O00000oO.findViewById(R.id.cancel_btn);
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.AnonymousClass4 */

            public final void onClick(View view) {
                ShareDeviceDetail.this.dismissEditMode();
            }
        });
        this.mIvSelectAll = (ImageView) this.O00000oO.findViewById(R.id.select_all_btn);
        this.mIvSelectAll.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.AnonymousClass5 */

            public final void onClick(View view) {
                if (ShareDeviceDetail.this.mCheckedItems.size() == ShareDeviceDetail.this.mShareUsers.size()) {
                    ShareDeviceDetail.this.unSelectAll();
                } else {
                    ShareDeviceDetail.this.selectAll();
                }
            }
        });
        this.O0000O0o = findViewById(R.id.bottom_delete_bar);
        this.O0000OOo = (TextView) this.O0000O0o.findViewById(R.id.delete_msg_btn);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.AnonymousClass6 */

            public final void onClick(View view) {
                ShareDeviceDetail.this.deleteSelected();
            }
        });
        if (gwg.O000000o((Activity) this)) {
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.O00000oO);
        }
    }

    public void onResume() {
        super.onResume();
        this.O00000Oo = new XQProgressDialog(this);
        this.O00000Oo.setCancelable(false);
        this.O00000Oo.setMessage(getResources().getString(R.string.loading_share_info));
        this.O00000Oo.show();
        this.mShareUsers.clear();
        fuh.O000000o().O000000o(this, this.mPid, this.mDid, new fsm<List<hsx>, fso>() {
            /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List list = (List) obj;
                ShareDeviceDetail.this.mShareUsers.addAll(list);
                ShareDeviceDetail.this.mAdapter.notifyDataSetChanged();
                ShareDeviceDetail.this.O00000Oo.dismiss();
                ShareUserRecord.insert(list);
                if (ShareDeviceDetail.this.mShareUsers.size() == 0) {
                    ShareDeviceDetail.this.mList.setVisibility(8);
                    ShareDeviceDetail.this.mEmptyView.setVisibility(0);
                }
                if (!ShareDeviceDetail.this.isLogEnterEvent) {
                    ShareDeviceDetail.this.isLogEnterEvent = true;
                    hxi.O00000o0.f957O000000o.O000000o("plugin_deviceshare_edit_show", "shared_users", Integer.valueOf(list.size()), "page_ref", Integer.valueOf(ShareDeviceDetail.this.getIntent().getBooleanExtra("key_from_page_ref", false) ? 2 : 1));
                }
            }

            public final void onFailure(fso fso) {
                ShareDeviceDetail.this.O00000Oo.dismiss();
                izb.O000000o(ShareDeviceDetail.this, (int) R.string.bind_error, 0).show();
            }
        });
    }

    public void onPause() {
        super.onPause();
        this.isLogEnterEvent = false;
    }

    public void deleteSelected() {
        if (this.mCheckedItems.size() == 0) {
            gqg.O000000o((int) R.string.not_select_deleted_msg);
            return;
        }
        new MLAlertDialog.Builder(this).O000000o((int) R.string.delete_msg_title).O00000Oo(getResources().getQuantityString(R.plurals.delete_msg, this.mCheckedItems.size(), Integer.valueOf(this.mCheckedItems.size()))).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < ShareDeviceDetail.this.mCheckedItems.size(); i2++) {
                    int keyAt = ShareDeviceDetail.this.mCheckedItems.keyAt(i2);
                    if (ShareDeviceDetail.this.mCheckedItems.get(keyAt) && ShareDeviceDetail.this.mShareUsers.size() > keyAt) {
                        hsx hsx = ShareDeviceDetail.this.mShareUsers.get(keyAt);
                        arrayList.add(hsx.f607O000000o);
                        arrayList2.add(hsx);
                    }
                }
                hys O000000o2 = hys.O000000o();
                ShareDeviceDetail shareDeviceDetail = ShareDeviceDetail.this;
                O000000o2.O000000o(shareDeviceDetail, arrayList, shareDeviceDetail.mPid, ShareDeviceDetail.this.mDid, new fsm<List<String>, fso>() {
                    /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.AnonymousClass7.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        for (String equalsIgnoreCase : (List) obj) {
                            if (equalsIgnoreCase.equalsIgnoreCase(ShareDeviceDetail.this.mDid)) {
                                izb.O000000o(ShareDeviceDetail.this, (int) R.string.smarthome_device_delete_fail, 0).show();
                                return;
                            }
                        }
                        ShareDeviceDetail.this.mShareUsers.removeAll(arrayList2);
                        ShareDeviceDetail.this.mAdapter.notifyDataSetChanged();
                        if (ShareDeviceDetail.this.mShareUsers.size() == 0) {
                            ShareDeviceDetail.this.mList.setVisibility(8);
                            ShareDeviceDetail.this.mEmptyView.setVisibility(0);
                        }
                        ShareDeviceDetail.this.dismissEditMode();
                        izb.O000000o(ShareDeviceDetail.this, (int) R.string.smarthome_device_delete_success, 0).show();
                    }

                    public final void onFailure(fso fso) {
                        izb.O000000o(ShareDeviceDetail.this, (int) R.string.smarthome_device_delete_fail, 0).show();
                    }
                });
            }
        }).O00000o().show();
    }

    public void selectAll() {
        int size = this.mShareUsers.size();
        for (int i = 0; i < size; i++) {
            this.mCheckedItems.put(i, true);
        }
        this.mIvSelectAll.setImageResource(R.drawable.un_select_selector);
        this.mIvSelectAll.setContentDescription(getString(R.string.unselect_all));
        this.mAdapter.notifyDataSetChanged();
        this.mSelectedCntTv.setVisibility(0);
        this.mSelectedCntTv.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, this.mCheckedItems.size(), Integer.valueOf(this.mCheckedItems.size())));
    }

    public void unSelectAll() {
        this.mCheckedItems.clear();
        this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
        this.mIvSelectAll.setContentDescription(getString(R.string.select_all));
        this.mAdapter.notifyDataSetChanged();
        this.mSelectedCntTv.setVisibility(8);
    }

    public void dismissEditMode() {
        this.mList.setPullDownEnabled(true);
        this.mEditMode = false;
        this.mCheckedItems.clear();
        hideDeleteBars();
        this.mAdapter.notifyDataSetChanged();
    }

    public void hideDeleteBars() {
        this.O00000oO.setVisibility(8);
        this.O0000O0o.setVisibility(8);
    }

    public void showDeleteBars() {
        this.O00000oO.setVisibility(0);
        this.O0000O0o.setVisibility(0);
        this.O00000oO.measure(0, 0);
        this.O0000O0o.measure(0, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O00000oO, View.Y, (float) (-this.O00000oO.getMeasuredHeight()), 0.0f);
        ViewGroup viewGroup = (ViewGroup) this.O0000O0o.getParent();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.O0000O0o, View.Y, (float) viewGroup.getHeight(), (float) (viewGroup.getHeight() - this.O0000O0o.getMeasuredHeight()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        View f9871O000000o;
        SimpleDraweeView O00000Oo;
        CheckBox O00000o;
        TextView O00000o0;
        TextView O00000oO;
        TextView O00000oo;

        O00000Oo() {
        }
    }

    class O000000o extends BaseAdapter {
        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        O000000o() {
        }

        public final int getCount() {
            return ShareDeviceDetail.this.mShareUsers.size();
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(ShareDeviceDetail.this).inflate((int) R.layout.message_item_new, (ViewGroup) null);
                O00000Oo o00000Oo = new O00000Oo();
                o00000Oo.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.device_icon);
                o00000Oo.O00000o0 = (TextView) view.findViewById(R.id.right_tv);
                o00000Oo.O00000o = (CheckBox) view.findViewById(R.id.ratio_btn);
                o00000Oo.O00000oO = (TextView) view.findViewById(R.id.device_item);
                o00000Oo.O00000oo = (TextView) view.findViewById(R.id.device_item_info);
                o00000Oo.f9871O000000o = view.findViewById(R.id.right_fl);
                view.setTag(o00000Oo);
            }
            O00000Oo o00000Oo2 = (O00000Oo) view.getTag();
            final hsx hsx = ShareDeviceDetail.this.mShareUsers.get(i);
            gyl.O000000o();
            gyl.O00000Oo(hsx.O00000o0, o00000Oo2.O00000Oo, null);
            ShareDeviceDetail shareDeviceDetail = ShareDeviceDetail.this;
            String str = shareDeviceDetail.getString(R.string.smarthome_shared_time_format, new Object[]{shareDeviceDetail.f9854O000000o.format(new Date(hsx.O00000o * 1000))}) + "  ";
            view.findViewById(R.id.arrow).setVisibility(8);
            int i2 = hsx.O00000oO;
            if (i2 == 0) {
                str = str + ShareDeviceDetail.this.getResources().getString(R.string.smarthome_to_user_status_waiting);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    str = str + ShareDeviceDetail.this.getResources().getString(R.string.smarthome_to_user_status_reject);
                }
            } else if (hsx.O00000oo == 0) {
                str = str + ShareDeviceDetail.this.getResources().getString(R.string.smarthome_to_user_status_accept);
            } else if (hsx.O00000oo == 1) {
                str = str + ShareDeviceDetail.this.getResources().getString(R.string.share_permission_cannot_control);
            } else if (hsx.O00000oo == 2) {
                str = str + ShareDeviceDetail.this.getResources().getString(R.string.share_permission_can_control);
            } else {
                str = str + ShareDeviceDetail.this.getResources().getString(R.string.smarthome_to_user_status_accept);
            }
            o00000Oo2.O00000oo.setText(str);
            o00000Oo2.O00000oO.setText(ShareDeviceDetail.this.getResources().getString(R.string.smarthome_has_shared_to_user, hsx.O00000Oo));
            o00000Oo2.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    if (!ShareDeviceDetail.this.mCheckedItems.get(i)) {
                        ShareDeviceDetail.this.mCheckedItems.put(i, true);
                    } else {
                        ShareDeviceDetail.this.mCheckedItems.delete(i);
                    }
                    if (ShareDeviceDetail.this.mCheckedItems.size() == ShareDeviceDetail.this.mShareUsers.size()) {
                        ShareDeviceDetail.this.mIvSelectAll.setImageResource(R.drawable.un_select_selector);
                        ShareDeviceDetail.this.mIvSelectAll.setContentDescription(ShareDeviceDetail.this.getString(R.string.unselect_all));
                    } else {
                        ShareDeviceDetail.this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
                        ShareDeviceDetail.this.mIvSelectAll.setContentDescription(ShareDeviceDetail.this.getString(R.string.select_all));
                    }
                    if (ShareDeviceDetail.this.mCheckedItems.size() > 0) {
                        ShareDeviceDetail.this.mSelectedCntTv.setVisibility(0);
                        ShareDeviceDetail.this.mSelectedCntTv.setText(ShareDeviceDetail.this.getResources().getQuantityString(R.plurals.selected_cnt_tips, ShareDeviceDetail.this.mCheckedItems.size(), Integer.valueOf(ShareDeviceDetail.this.mCheckedItems.size())));
                        return;
                    }
                    ShareDeviceDetail.this.mSelectedCntTv.setVisibility(0);
                    ShareDeviceDetail.this.mSelectedCntTv.setText(ShareDeviceDetail.this.getString(R.string.selected_0_cnt_tips));
                }
            });
            if (ShareDeviceDetail.this.mEditMode) {
                o00000Oo2.O00000o.setVisibility(0);
                o00000Oo2.O00000o0.setVisibility(8);
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.O000000o.AnonymousClass2 */

                    public final void onClick(View view) {
                        O00000Oo o00000Oo = (O00000Oo) view.getTag();
                        if (o00000Oo != null) {
                            o00000Oo.O00000o.performClick();
                        }
                    }
                });
                if (ShareDeviceDetail.this.mCheckedItems.get(i)) {
                    o00000Oo2.O00000o.setChecked(true);
                } else {
                    o00000Oo2.O00000o.setChecked(false);
                }
            } else {
                o00000Oo2.O00000o.setVisibility(8);
                o00000Oo2.O00000o0.setVisibility(0);
                o00000Oo2.O00000o0.setTextColor(ShareDeviceDetail.this.getResources().getColorStateList(R.color.selector_common_text));
                o00000Oo2.O00000o0.setBackgroundResource(R.drawable.selector_common_btn);
                o00000Oo2.O00000o0.setPadding(ShareDeviceDetail.this.getResources().getDimensionPixelSize(R.dimen.txt_padding_10), gpc.O000000o(6.0f), ShareDeviceDetail.this.getResources().getDimensionPixelSize(R.dimen.txt_padding_10), gpc.O000000o(6.0f));
                o00000Oo2.O00000o0.setText((int) R.string.tag_delete);
                o00000Oo2.O00000o0.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.O000000o.AnonymousClass3 */

                    public final void onClick(View view) {
                        hxi.O00000o.f952O000000o.O000000o("plugin_deviceshare_edit_delete", new Object[0]);
                        new MLAlertDialog.Builder(ShareDeviceDetail.this).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.O000000o.AnonymousClass3.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                hsx hsx = ShareDeviceDetail.this.mShareUsers.size() > i ? hsx : null;
                                if (hsx != null) {
                                    hys.O000000o().O000000o(ShareDeviceDetail.this, hsx.f607O000000o, ShareDeviceDetail.this.mPid, ShareDeviceDetail.this.mDid, new fsm<List<String>, fso>() {
                                        /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.O000000o.AnonymousClass3.AnonymousClass2.AnonymousClass1 */

                                        public final /* synthetic */ void onSuccess(Object obj) {
                                            List<String> list = (List) obj;
                                            if (ShareDeviceDetail.this.isValid() && ShareDeviceDetail.this.mShareUsers.size() > i) {
                                                for (String equalsIgnoreCase : list) {
                                                    if (equalsIgnoreCase.equalsIgnoreCase(ShareDeviceDetail.this.mDid)) {
                                                        izb.O000000o(ShareDeviceDetail.this, (int) R.string.smarthome_device_delete_fail, 0).show();
                                                        return;
                                                    }
                                                }
                                                ShareDeviceDetail.this.mShareUsers.remove(i);
                                                ShareDeviceDetail.this.mAdapter.notifyDataSetChanged();
                                                if (ShareDeviceDetail.this.mShareUsers.size() == 0) {
                                                    ShareDeviceDetail.this.mList.setVisibility(8);
                                                    ShareDeviceDetail.this.mEmptyView.setVisibility(0);
                                                }
                                                izb.O000000o(ShareDeviceDetail.this, (int) R.string.smarthome_device_delete_success, 0).show();
                                            }
                                        }

                                        public final void onFailure(fso fso) {
                                            if (ShareDeviceDetail.this.isValid()) {
                                                izb.O000000o(ShareDeviceDetail.this, (int) R.string.smarthome_device_delete_fail, 0).show();
                                            }
                                        }
                                    });
                                }
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.O000000o.AnonymousClass3.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).O000000o(true).O000000o(String.format(ShareDeviceDetail.this.getResources().getString(R.string.smarthome_device_delete_confirm), hsx.O00000Oo)).O00000oo();
                    }
                });
            }
            view.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.xiaomi.smarthome.miio.page.ShareDeviceDetail.O000000o.AnonymousClass4 */

                public final boolean onLongClick(View view) {
                    if (!ShareDeviceDetail.this.mEditMode) {
                        ShareDeviceDetail.this.mList.setPullDownEnabled(false);
                        if (!ShareDeviceDetail.this.mCheckedItems.get(i)) {
                            ((O00000Oo) view.getTag()).O00000o.performClick();
                        }
                        ShareDeviceDetail.this.showDeleteBars();
                        ShareDeviceDetail.this.mEditMode = true;
                        O000000o.this.notifyDataSetChanged();
                    }
                    return true;
                }
            });
            if (i != getCount() - 1) {
                view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding);
            } else {
                view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding_no_left_margin);
            }
            return view;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0 || !this.mEditMode) {
            return super.onKeyUp(i, keyEvent);
        }
        dismissEditMode();
        return true;
    }
}
