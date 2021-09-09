package com.xiaomi.smarthome.multikey;

import _m_j.fnn;
import _m_j.fno;
import _m_j.fqv;
import _m_j.fso;
import _m_j.ggb;
import _m_j.ggx;
import _m_j.gno;
import _m_j.gof;
import _m_j.gpc;
import _m_j.gqb;
import _m_j.gqg;
import _m_j.gqn;
import _m_j.gzo;
import _m_j.hah;
import _m_j.hgx;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.utils.ClientRemarkInputView;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.CommonFlowGroup;
import java.util.ArrayList;
import java.util.List;

public class PowerItemkeyActivity extends BaseActivity implements View.OnClickListener, CommonFlowGroup.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    private Device f10044O000000o;
    private XQProgressDialog O00000Oo;
    private gzo O00000o = new gzo();
    private PowerMultikeyBean O00000o0;
    @BindView(5134)
    EditText etKeyname;
    @BindView(5005)
    TextView inputRemarkView;
    @BindView(5584)
    CommonFlowGroup mDeviceFlowView;
    public List<String> mDeviceTagList = new ArrayList();
    @BindView(5585)
    View mRecommendNoimg;
    @BindView(5407)
    ImageView mReturnBtn;
    @BindView(5416)
    ImageView mRightImage;
    @BindView(5586)
    CommonFlowGroup mRoomFlowView;
    public List<String> mRoomTagList = new ArrayList();
    @BindView(5825)
    View mTitleBar;
    @BindView(5411)
    TextView mTitleTv;
    @BindView(5003)
    View mViewClear;
    @BindView(5907)
    TextView tvRoomadd;
    @BindView(5892)
    TextView tv_keyname;
    @BindView(5908)
    TextView tv_roomname;

    public View onAddCreate(Context context) {
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_poweritemkey);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("device_id");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f10044O000000o = fno.O000000o().O000000o(stringExtra);
        }
        this.O00000o0 = (PowerMultikeyBean) intent.getParcelableExtra("extra_entity");
        if (this.O00000o0 == null) {
            finish();
            return;
        }
        if (this.f10044O000000o == null) {
            String stringExtra2 = intent.getStringExtra("device_mac");
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.f10044O000000o = fno.O000000o().O00000o(stringExtra2);
            }
        }
        if (this.f10044O000000o == null) {
            finish();
        } else if (!fno.O000000o().O0000o00() || this.f10044O000000o != null) {
            Typeface O000000o2 = gno.O000000o(CommonApplication.getAppContext(), "fonts/MI-LANTING--GBK1-Thin.ttf");
            this.tv_keyname.setTypeface(O000000o2);
            this.tv_roomname.setTypeface(O000000o2);
            this.mRightImage.setImageResource(R.drawable.std_titlebar_icon_confirm);
            this.mReturnBtn.setImageResource(R.drawable.mj_webp_titlebar_cancel_nor);
            this.mRightImage.setOnClickListener(this);
            this.mViewClear.setOnClickListener(this);
            this.mRightImage.setVisibility(0);
            this.mReturnBtn.setOnClickListener(this);
            this.etKeyname.setFilters(new InputFilter[]{new InputFilter.LengthFilter(41)});
            this.etKeyname.addTextChangedListener(new TextWatcher() {
                /* class com.xiaomi.smarthome.multikey.PowerItemkeyActivity.AnonymousClass1 */

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (gqb.O00000o0(PowerItemkeyActivity.this.etKeyname.getText().toString())) {
                        gqg.O00000Oo(PowerItemkeyActivity.this.getString(R.string.tag_save_data_description).replace("\n", ""));
                        PowerItemkeyActivity.this.mRightImage.setVisibility(8);
                        return;
                    }
                    PowerItemkeyActivity.this.mRightImage.setVisibility(0);
                }

                public final void afterTextChanged(Editable editable) {
                    String obj = editable.toString();
                    int indexOf = PowerItemkeyActivity.this.mDeviceTagList.indexOf(obj);
                    if (indexOf < 0) {
                        PowerItemkeyActivity.this.mDeviceFlowView.setSelectIndex(-1);
                    } else if (indexOf != PowerItemkeyActivity.this.mDeviceFlowView.getSelectIndex()) {
                        PowerItemkeyActivity.this.mDeviceFlowView.setSelectIndex(indexOf);
                    }
                    if (ggb.O0000oO(obj)) {
                        PowerItemkeyActivity.this.inputRemarkView.setVisibility(8);
                        return;
                    }
                    PowerItemkeyActivity.this.inputRemarkView.setText((int) R.string.room_name_too_long);
                    PowerItemkeyActivity.this.inputRemarkView.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(this.O00000o0.O00000o)) {
                this.etKeyname.setText(this.O00000o0.O00000o);
                this.etKeyname.setSelection(this.O00000o0.O00000o.length());
            }
            this.mTitleTv.setText(intent.getStringExtra("extra_title"));
            this.mRoomTagList.addAll(gzo.O000000o());
            if (this.mRoomTagList.size() == 0) {
                this.mRoomFlowView.setVisibility(8);
                this.mRecommendNoimg.setVisibility(0);
            } else {
                this.mRoomFlowView.setVisibility(0);
                this.mRecommendNoimg.setVisibility(8);
                this.mRoomFlowView.setData(this.mRoomTagList);
                this.mRoomFlowView.O000000o(Boolean.FALSE);
                Room O00000o02 = ggb.O00000Oo().O00000o0(this.O00000o0.O00000Oo);
                if (O00000o02 != null) {
                    this.mRoomFlowView.setSelectIndex(this.mRoomTagList.indexOf(O00000o02.getName()));
                }
            }
            this.mDeviceFlowView.setOnTagClickListener(new CommonFlowGroup.O000000o() {
                /* class com.xiaomi.smarthome.multikey.PowerItemkeyActivity.AnonymousClass2 */

                public final void O000000o() {
                }

                public final void O000000o(int i) {
                    String str;
                    if (i >= 0 && i < PowerItemkeyActivity.this.mDeviceTagList.size() && (str = PowerItemkeyActivity.this.mDeviceTagList.get(i)) != null && !str.equals(PowerItemkeyActivity.this.etKeyname.getText().toString())) {
                        PowerItemkeyActivity.this.etKeyname.setText(str);
                        PowerItemkeyActivity.this.etKeyname.setSelection(str.length());
                    }
                }
            });
            this.mDeviceFlowView.setOnTagCreateListener(this);
            this.mDeviceFlowView.O000000o(Boolean.FALSE);
            new ggx().O000000o(this.f10044O000000o.model, new ggx.O000000o() {
                /* class com.xiaomi.smarthome.multikey.PowerItemkeyActivity.AnonymousClass3 */

                public final void onRecommendName(String str, List<String> list) {
                    PowerItemkeyActivity.this.setDeviceRecommend(list);
                }
            });
            this.tvRoomadd.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.multikey.PowerItemkeyActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    fnn.O000000o().O00000Oo();
                    final List<String> O0000o = fqv.O0000o();
                    O0000o.removeAll(PowerItemkeyActivity.this.mRoomTagList);
                    PowerItemkeyActivity powerItemkeyActivity = PowerItemkeyActivity.this;
                    ClientRemarkInputView clientRemarkInputView = (ClientRemarkInputView) hah.O000000o(powerItemkeyActivity, "", powerItemkeyActivity.getString(R.string.tag_add_title), PowerItemkeyActivity.this.getString(R.string.input_tag_name_hint), new hah.O000000o() {
                        /* class com.xiaomi.smarthome.multikey.PowerItemkeyActivity.AnonymousClass4.AnonymousClass1 */

                        public final void O000000o(final String str) {
                            int indexOf = PowerItemkeyActivity.this.mRoomTagList.indexOf(str);
                            if (indexOf >= 0) {
                                PowerItemkeyActivity.this.mRoomFlowView.setSelectIndex(indexOf);
                            } else if (!gof.O00000o0()) {
                                gqg.O00000Oo((int) R.string.popup_select_loc_no_network);
                            } else {
                                PowerItemkeyActivity.this.showDialog();
                                ggb.O00000Oo().O000000o(str, new ArrayList(), (String) null, new ggb.O00000o() {
                                    /* class com.xiaomi.smarthome.multikey.PowerItemkeyActivity.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                    public final void O000000o() {
                                        if (PowerItemkeyActivity.this.isValid()) {
                                            PowerItemkeyActivity.this.dismissDialog();
                                            PowerItemkeyActivity.this.mRoomTagList.add(0, str);
                                            PowerItemkeyActivity.this.mRecommendNoimg.setVisibility(8);
                                            PowerItemkeyActivity.this.mRoomFlowView.setVisibility(0);
                                            PowerItemkeyActivity.this.mRoomFlowView.setData(PowerItemkeyActivity.this.mRoomTagList);
                                            PowerItemkeyActivity.this.mRoomFlowView.setSelectIndex(0);
                                        }
                                    }

                                    public final void O000000o(int i, fso fso) {
                                        if (PowerItemkeyActivity.this.isValid()) {
                                            PowerItemkeyActivity.this.dismissDialog();
                                        }
                                    }
                                });
                            }
                        }

                        public final String O00000Oo(String str) {
                            if (str == null || !PowerItemkeyActivity.this.mRoomTagList.contains(str.trim())) {
                                return null;
                            }
                            return PowerItemkeyActivity.this.getString(R.string.room_name_duplicate);
                        }
                    }).getView();
                    final CommonFlowGroup commonFlowGroup = clientRemarkInputView.getCommonFlowGroup();
                    final EditText editText = clientRemarkInputView.getEditText();
                    if (!(commonFlowGroup == null || editText == null)) {
                        commonFlowGroup.setVisibility(0);
                        commonFlowGroup.setMinWidth(64.0f);
                        commonFlowGroup.O000000o(Boolean.FALSE);
                        commonFlowGroup.setOnTagCreateListener(new CommonFlowGroup.O00000Oo() {
                            /* class com.xiaomi.smarthome.multikey.PowerItemkeyActivity.AnonymousClass4.AnonymousClass2 */

                            public final View onAddCreate(Context context) {
                                return null;
                            }

                            public final TextView onTagCreate(Context context, int i) {
                                TextView onTagCreate = PowerItemkeyActivity.this.onTagCreate(context, i);
                                onTagCreate.setTextSize(14.0f);
                                return onTagCreate;
                            }
                        });
                        commonFlowGroup.setData(O0000o);
                        commonFlowGroup.setOnTagClickListener(new CommonFlowGroup.O000000o() {
                            /* class com.xiaomi.smarthome.multikey.PowerItemkeyActivity.AnonymousClass4.AnonymousClass3 */

                            public final void O000000o() {
                            }

                            public final void O000000o(int i) {
                                String str;
                                if (i >= 0 && i < O0000o.size() && (str = (String) O0000o.get(i)) != null && !str.equals(editText.getText().toString())) {
                                    editText.setText(str);
                                    editText.setSelection(str.length());
                                }
                            }
                        });
                        editText.addTextChangedListener(new hgx() {
                            /* class com.xiaomi.smarthome.multikey.PowerItemkeyActivity.AnonymousClass4.AnonymousClass4 */

                            public final void afterTextChanged(Editable editable) {
                                int indexOf = O0000o.indexOf(editable.toString());
                                if (indexOf < 0) {
                                    commonFlowGroup.setSelectIndex(-1);
                                } else if (indexOf != commonFlowGroup.getSelectIndex()) {
                                    commonFlowGroup.setSelectIndex(indexOf);
                                }
                            }
                        });
                    }
                    TextView titleRoomRecommend = clientRemarkInputView.getTitleRoomRecommend();
                    if (titleRoomRecommend != null) {
                        titleRoomRecommend.setVisibility(0);
                        titleRoomRecommend.setText((int) R.string.multikey_room_recommend);
                    }
                }
            });
            ggb.O00000Oo().O000000o((ggb.O00000o) null);
        } else {
            finish();
        }
    }

    public void setDeviceRecommend(List<String> list) {
        if (!this.mDeviceTagList.equals(list) && list.size() != 0) {
            this.mDeviceTagList.clear();
            this.mDeviceTagList.addAll(list);
            this.mDeviceFlowView.setData(this.mDeviceTagList);
            int indexOf = this.mDeviceTagList.indexOf(this.etKeyname.getText().toString());
            if (indexOf >= 0) {
                this.mDeviceFlowView.setSelectIndex(indexOf);
            }
        }
    }

    public void dismissDialog() {
        XQProgressDialog xQProgressDialog = this.O00000Oo;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O00000Oo.dismiss();
        }
    }

    public void showDialog() {
        XQProgressDialog xQProgressDialog = this.O00000Oo;
        if (xQProgressDialog == null || !xQProgressDialog.isShowing()) {
            this.O00000Oo = new XQProgressDialog(this);
            this.O00000Oo.setCancelable(true);
            this.O00000Oo.setMessage(getResources().getString(R.string.loading_share_info));
            this.O00000Oo.show();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_right_iv_setting_btn) {
            String obj = this.etKeyname.getText().toString();
            if (!ggb.O0000oO(obj)) {
                gqg.O00000Oo((int) R.string.save_fail);
            } else if (gqb.O00000Oo(obj)) {
                gqg.O00000Oo((int) R.string.tag_save_data_description);
            } else {
                int selectIndex = this.mDeviceFlowView.getSelectIndex();
                if (selectIndex < 0 || selectIndex >= this.mDeviceTagList.size()) {
                    this.O00000o0.O00000o = obj;
                } else {
                    this.O00000o0.O00000o = this.mDeviceTagList.get(selectIndex);
                }
                int selectIndex2 = this.mRoomFlowView.getSelectIndex();
                String O0000OOo = ggb.O00000Oo().O0000OOo();
                if (selectIndex2 >= 0 && selectIndex2 < this.mRoomTagList.size()) {
                    List<Room> O000000o2 = ggb.O00000Oo().O000000o(O0000OOo);
                    String str = this.mRoomTagList.get(selectIndex2);
                    for (Room next : O000000o2) {
                        if (TextUtils.equals(next.getName(), str)) {
                            this.O00000o0.O00000Oo = next.getId();
                            this.O00000o0.O00000o0 = O0000OOo;
                        }
                    }
                }
                if (TextUtils.isEmpty(this.O00000o0.O00000Oo)) {
                    PowerMultikeyBean powerMultikeyBean = this.O00000o0;
                    powerMultikeyBean.O00000Oo = O0000OOo;
                    powerMultikeyBean.O00000o0 = O0000OOo;
                }
                setResult(-1, getIntent().putExtra("extra_entity", this.O00000o0));
                onBackPressed();
            }
        } else if (id == R.id.module_a_3_return_btn) {
            onBackPressed();
        } else if (id == R.id.client_remark_input_view_clear) {
            this.etKeyname.setText("");
        }
    }

    public TextView onTagCreate(Context context, int i) {
        TextView textView = (TextView) LayoutInflater.from(context).inflate((int) R.layout.common_flow_tag_item, (ViewGroup) null);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, new gqn.O000000o(-1907998));
        stateListDrawable.addState(new int[]{0}, new gqn.O000000o(-526345));
        textView.setBackground(stateListDrawable);
        textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842919}, new int[]{0}}, new int[]{-10066330, -10066330}));
        int O000000o2 = gpc.O000000o(6.0f);
        textView.setPadding(textView.getPaddingLeft(), O000000o2, textView.getPaddingRight(), O000000o2);
        return textView;
    }
}
