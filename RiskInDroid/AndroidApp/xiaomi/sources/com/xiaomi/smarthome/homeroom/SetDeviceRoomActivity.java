package com.xiaomi.smarthome.homeroom;

import _m_j.fnn;
import _m_j.fno;
import _m_j.fqv;
import _m_j.fso;
import _m_j.ggb;
import _m_j.hah;
import _m_j.hgx;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.utils.ClientRemarkInputView;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.CommonFlowGroup;
import com.xiaomi.smarthome.ui.DeviceBigHeaderView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SetDeviceRoomActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private ArrayList<Device> f8940O000000o = new ArrayList<>();
    private Home O00000Oo;
    private XQProgressDialog O00000o;
    private String O00000o0;
    private MLAlertDialog O00000oO;
    private MLAlertDialog O00000oo;
    private boolean O0000O0o;
    public ArrayList<String> dids;
    @BindView(5810)
    TextView mChooseRoom;
    @BindView(4994)
    Button mComplete;
    public List<String> mCreateTagList = new ArrayList();
    public List<String> mDefaultTagList = new ArrayList();
    @BindView(5039)
    DeviceBigHeaderView mDeviceListContainer;
    @BindView(5060)
    TextView mDivider;
    @BindView(5533)
    CommonFlowGroup mRecommendFlowView;
    public List<String> mRecommendTagList = new ArrayList();
    @BindView(5357)
    View mReturnBtn;
    @BindView(5577)
    CommonFlowGroup mRoomFlowView;

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
    public static void startActivity(Context context, String str, ArrayList<String> arrayList, int i) {
        if (!TextUtils.isEmpty(str) && context != null && arrayList != null && !arrayList.isEmpty()) {
            Intent intent = new Intent(context, SetDeviceRoomActivity.class);
            intent.putExtra("home_id", str);
            intent.putStringArrayListExtra("device_list_id", arrayList);
            if (!(context instanceof Activity) || i < 0) {
                intent.addFlags(268435456);
                intent.putExtra("start_for_result", false);
                context.startActivity(intent);
                return;
            }
            intent.putExtra("start_for_result", true);
            ((Activity) context).startActivityForResult(intent, i);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_set_device_room);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent == null) {
            O00000Oo();
            return;
        }
        this.dids = intent.getStringArrayListExtra("device_list_id");
        ArrayList<String> arrayList = this.dids;
        if (arrayList == null || arrayList.isEmpty()) {
            O00000Oo();
            return;
        }
        Iterator<String> it = this.dids.iterator();
        while (it.hasNext()) {
            Device O000000o2 = fno.O000000o().O000000o(it.next());
            if (O000000o2 == null) {
                it.remove();
            } else {
                this.f8940O000000o.add(O000000o2);
            }
        }
        ArrayList<Device> arrayList2 = this.f8940O000000o;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            O00000Oo();
            return;
        }
        this.O00000o0 = intent.getStringExtra("home_id");
        this.O00000Oo = ggb.O00000Oo().O00000o(this.O00000o0);
        if (this.O00000Oo == null) {
            O00000Oo();
            return;
        }
        this.O0000O0o = intent.getBooleanExtra("start_for_result", false);
        setCompleteEnabled(false);
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.$$Lambda$SetDeviceRoomActivity$mm6X1xvTBrmMDoDh1Til7mq4cS4 */

            public final void onClick(View view) {
                SetDeviceRoomActivity.this.O00000Oo(view);
            }
        });
        this.mComplete.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.$$Lambda$SetDeviceRoomActivity$F24xxpm1upzcEgyqPwVgoWE0Rkw */

            public final void onClick(View view) {
                SetDeviceRoomActivity.this.O000000o(view);
            }
        });
        this.mRecommendFlowView.O000000o(Boolean.FALSE);
        this.mRoomFlowView.setOnTagClickListener(new CommonFlowGroup.O000000o() {
            /* class com.xiaomi.smarthome.homeroom.SetDeviceRoomActivity.AnonymousClass1 */

            public final void O000000o() {
                SetDeviceRoomActivity setDeviceRoomActivity = SetDeviceRoomActivity.this;
                setDeviceRoomActivity.showEditRoomNameDialog(setDeviceRoomActivity.mRecommendFlowView.getVisibility() != 0);
            }

            public final void O000000o(int i) {
                SetDeviceRoomActivity.this.setCompleteEnabled(true);
            }
        });
        this.mRoomFlowView.setOnTagCreateListener(new CommonFlowGroup.O00000Oo() {
            /* class com.xiaomi.smarthome.homeroom.SetDeviceRoomActivity.AnonymousClass3 */

            public final View onAddCreate(Context context) {
                return LayoutInflater.from(context).inflate((int) R.layout.common_flow_tag_add_item, (ViewGroup) null);
            }

            public final TextView onTagCreate(Context context, int i) {
                return (TextView) LayoutInflater.from(context).inflate((int) R.layout.common_flow_tag_item_v3, (ViewGroup) null);
            }
        });
        this.mRecommendFlowView.setOnTagClickListener(new CommonFlowGroup.O000000o() {
            /* class com.xiaomi.smarthome.homeroom.SetDeviceRoomActivity.AnonymousClass4 */

            public final void O000000o() {
            }

            public final void O000000o(int i) {
                if (SetDeviceRoomActivity.this.mRecommendTagList.get(i) != null) {
                    SetDeviceRoomActivity.this.mCreateTagList.add(0, SetDeviceRoomActivity.this.mRecommendTagList.get(i));
                    SetDeviceRoomActivity.this.refreshFlowView();
                    SetDeviceRoomActivity.this.mRecommendFlowView.setSelectIndex(-1);
                    SetDeviceRoomActivity.this.mRoomFlowView.setSelectIndex(0);
                    SetDeviceRoomActivity.this.setCompleteEnabled(true);
                }
            }
        });
        this.mRecommendFlowView.setOnTagCreateListener(new CommonFlowGroup.O00000Oo() {
            /* class com.xiaomi.smarthome.homeroom.SetDeviceRoomActivity.AnonymousClass5 */

            public final View onAddCreate(Context context) {
                return LayoutInflater.from(context).inflate((int) R.layout.common_flow_tag_add_item, (ViewGroup) null);
            }

            public final TextView onTagCreate(Context context, int i) {
                return (TextView) LayoutInflater.from(context).inflate((int) R.layout.common_flow_tag_item_v2, (ViewGroup) null);
            }
        });
        refreshFlowView();
        Room room = ggb.O00000Oo().O0000o0;
        if (room == null) {
            this.mRoomFlowView.setSelectIndex(-1);
        } else {
            int i = 0;
            while (true) {
                if (i >= this.mDefaultTagList.size()) {
                    break;
                } else if (this.mDefaultTagList.get(i).equals(room.getName())) {
                    this.mRoomFlowView.setSelectIndex(i);
                    setCompleteEnabled(true);
                    break;
                } else {
                    i++;
                }
            }
        }
        if (this.mDefaultTagList.size() > 0) {
            this.mChooseRoom.setVisibility(0);
            this.mDivider.setVisibility(8);
            this.mRecommendFlowView.setVisibility(8);
        } else {
            this.mChooseRoom.setVisibility(8);
            this.mDivider.setVisibility(0);
            this.mRecommendFlowView.setVisibility(0);
            this.mRecommendFlowView.setData(this.mRecommendTagList);
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<Device> it2 = this.f8940O000000o.iterator();
        while (it2.hasNext()) {
            Device next = it2.next();
            arrayList3.add(new DeviceBigHeaderView.O000000o(next.model, next.name));
        }
        this.mDeviceListContainer.setModel(arrayList3);
    }

    public void onBackPressed() {
        O00000Oo();
    }

    public void onDestroy() {
        MLAlertDialog mLAlertDialog = this.O00000oO;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.O00000oO.dismiss();
        }
        XQProgressDialog xQProgressDialog = this.O00000o;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O00000o.dismiss();
        }
        MLAlertDialog mLAlertDialog2 = this.O00000oo;
        if (mLAlertDialog2 != null && mLAlertDialog2.isShowing()) {
            this.O00000oo.dismiss();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        O000000o();
    }

    public void setCompleteEnabled(boolean z) {
        this.mComplete.setEnabled(z);
        this.mComplete.setAlpha(z ? 1.0f : 0.3f);
    }

    public static List<String> getRecommendRooms() {
        fnn.O000000o().O00000Oo();
        return fqv.O0000o();
    }

    public void showEditRoomNameDialog(boolean z) {
        this.O00000oo = hah.O000000o(this, "", getString(R.string.tag_add_title), getString(R.string.input_tag_name_hint), new hah.O000000o() {
            /* class com.xiaomi.smarthome.homeroom.SetDeviceRoomActivity.AnonymousClass6 */

            public final void O000000o(String str) {
                String trim = str == null ? "" : str.trim();
                if (SetDeviceRoomActivity.this.mDefaultTagList.contains(trim)) {
                    SetDeviceRoomActivity.this.mRoomFlowView.setSelectIndex(SetDeviceRoomActivity.this.mDefaultTagList.indexOf(trim));
                } else if (!TextUtils.isEmpty(trim)) {
                    SetDeviceRoomActivity.this.mCreateTagList.add(0, trim);
                    SetDeviceRoomActivity.this.refreshFlowView();
                    SetDeviceRoomActivity.this.mRecommendFlowView.setSelectIndex(-1);
                    SetDeviceRoomActivity.this.mRoomFlowView.setSelectIndex(0);
                    SetDeviceRoomActivity.this.setCompleteEnabled(true);
                }
            }

            public final String O00000Oo(String str) {
                if (str == null || !SetDeviceRoomActivity.this.mDefaultTagList.contains(str.trim())) {
                    return null;
                }
                return SetDeviceRoomActivity.this.getString(R.string.room_name_duplicate);
            }
        });
        ClientRemarkInputView clientRemarkInputView = (ClientRemarkInputView) this.O00000oo.getView();
        final CommonFlowGroup commonFlowGroup = clientRemarkInputView.getCommonFlowGroup();
        final EditText editText = clientRemarkInputView.getEditText();
        if (commonFlowGroup != null && editText != null && z) {
            commonFlowGroup.setVisibility(0);
            commonFlowGroup.setMinWidth(64.0f);
            commonFlowGroup.O000000o(Boolean.FALSE);
            commonFlowGroup.setOnTagCreateListener(new CommonFlowGroup.O00000Oo() {
                /* class com.xiaomi.smarthome.homeroom.SetDeviceRoomActivity.AnonymousClass7 */

                public final View onAddCreate(Context context) {
                    return null;
                }

                public final TextView onTagCreate(Context context, int i) {
                    return (TextView) LayoutInflater.from(context).inflate((int) R.layout.common_flow_tag_item_v2, (ViewGroup) null);
                }
            });
            commonFlowGroup.setData(this.mRecommendTagList);
            commonFlowGroup.setOnTagClickListener(new CommonFlowGroup.O000000o() {
                /* class com.xiaomi.smarthome.homeroom.SetDeviceRoomActivity.AnonymousClass8 */

                public final void O000000o() {
                }

                public final void O000000o(int i) {
                    String str;
                    if (i >= 0 && i < SetDeviceRoomActivity.this.mRecommendTagList.size() && (str = SetDeviceRoomActivity.this.mRecommendTagList.get(i)) != null && !str.equals(editText.getText().toString())) {
                        editText.setText(str);
                        editText.setSelection(str.length());
                    }
                }
            });
            editText.addTextChangedListener(new hgx() {
                /* class com.xiaomi.smarthome.homeroom.SetDeviceRoomActivity.AnonymousClass9 */

                public final void afterTextChanged(Editable editable) {
                    int indexOf = SetDeviceRoomActivity.this.mRecommendTagList.indexOf(editable.toString());
                    if (indexOf < 0) {
                        commonFlowGroup.setSelectIndex(-1);
                    } else if (indexOf != commonFlowGroup.getSelectIndex()) {
                        commonFlowGroup.setSelectIndex(indexOf);
                    }
                }
            });
            TextView titleRoomRecommend = clientRemarkInputView.getTitleRoomRecommend();
            if (titleRoomRecommend != null && this.mRecommendTagList.size() > 0) {
                titleRoomRecommend.setVisibility(0);
                titleRoomRecommend.setText((int) R.string.multikey_room_recommend);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
        O000000o();
    }

    private void O000000o() {
        final Room room;
        int selectIndex = this.mRoomFlowView.getSelectIndex();
        if (selectIndex < 0 || this.mDefaultTagList.get(selectIndex) == null) {
            onSetRoomFail();
            return;
        }
        String str = this.mDefaultTagList.get(selectIndex);
        XQProgressDialog xQProgressDialog = this.O00000o;
        if (xQProgressDialog == null || !xQProgressDialog.isShowing()) {
            this.O00000o = new XQProgressDialog(this);
            this.O00000o.setCancelable(true);
            this.O00000o.setMessage(getResources().getString(R.string.loading_share_info));
            this.O00000o.show();
        }
        List<Room> roomList = this.O00000Oo.getRoomList();
        ArrayList arrayList = new ArrayList();
        for (Room name : roomList) {
            arrayList.add(name.getName());
        }
        if (arrayList.contains(str)) {
            int indexOf = arrayList.indexOf(str);
            if (indexOf < 0 || indexOf >= roomList.size()) {
                room = null;
            } else {
                room = roomList.get(indexOf);
            }
            if (room == null || TextUtils.isEmpty(room.getId())) {
                onSetRoomFail();
            } else {
                ggb.O00000Oo().O000000o(room, this.dids, (List<String>) null, new ggb.O00000o() {
                    /* class com.xiaomi.smarthome.homeroom.SetDeviceRoomActivity.AnonymousClass2 */

                    public final void O000000o() {
                        if (SetDeviceRoomActivity.this.isValid()) {
                            SetDeviceRoomActivity.this.onSetRoomSuccess(room.getId());
                        }
                    }

                    public final void O000000o(int i, fso fso) {
                        if (SetDeviceRoomActivity.this.isValid()) {
                            SetDeviceRoomActivity.this.onSetRoomFail();
                        }
                    }
                });
            }
        } else {
            ggb.O00000Oo().O000000o(this.O00000o0, str, this.dids, null, new ggb.O00000o() {
                /* class com.xiaomi.smarthome.homeroom.SetDeviceRoomActivity.AnonymousClass10 */

                public final void O000000o() {
                    if (SetDeviceRoomActivity.this.isValid()) {
                        Room O0000o00 = ggb.O00000Oo().O0000o00(SetDeviceRoomActivity.this.dids.get(0));
                        if (O0000o00 == null || TextUtils.isEmpty(O0000o00.getId())) {
                            SetDeviceRoomActivity.this.onSetRoomFail();
                        } else {
                            SetDeviceRoomActivity.this.onSetRoomSuccess(O0000o00.getId());
                        }
                    }
                }

                public final void O000000o(int i, fso fso) {
                    if (SetDeviceRoomActivity.this.isValid()) {
                        SetDeviceRoomActivity.this.onSetRoomFail();
                    }
                }
            });
        }
    }

    public void onSetRoomSuccess(String str) {
        XQProgressDialog xQProgressDialog = this.O00000o;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O00000o.dismiss();
        }
        Intent intent = new Intent();
        intent.putStringArrayListExtra("device_list_id", this.dids);
        intent.putExtra("room_id", str);
        setResult(-1, intent);
        finish();
    }

    public void onSetRoomFail() {
        XQProgressDialog xQProgressDialog = this.O00000o;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O00000o.dismiss();
        }
        this.O00000oO = new MLAlertDialog.Builder(this).O00000Oo((int) R.string.set_room_fail).O00000Oo(true).O000000o((int) R.string.mj_retry, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.$$Lambda$SetDeviceRoomActivity$v2jcwNZ7XLe_wwFiQHhJo1EilY */

            public final void onClick(DialogInterface dialogInterface, int i) {
                SetDeviceRoomActivity.this.O000000o(dialogInterface, i);
            }
        }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000oo();
    }

    private void O00000Oo() {
        if (this.O0000O0o) {
            setResult(0, new Intent());
        }
        finish();
    }

    public void refreshFlowView() {
        List<Room> roomList = this.O00000Oo.getRoomList();
        ArrayList arrayList = new ArrayList();
        for (Room name : roomList) {
            arrayList.add(name.getName());
        }
        this.mCreateTagList.removeAll(arrayList);
        arrayList.addAll(0, this.mCreateTagList);
        this.mDefaultTagList = arrayList;
        List<String> recommendRooms = getRecommendRooms();
        recommendRooms.removeAll(this.mDefaultTagList);
        this.mRecommendTagList = recommendRooms;
        this.mRoomFlowView.setData(this.mDefaultTagList);
        this.mRecommendFlowView.setData(this.mRecommendTagList);
    }
}
