package com.xiaomi.smarthome.homeroom;

import _m_j.fnn;
import _m_j.fno;
import _m_j.fso;
import _m_j.ftt;
import _m_j.ggb;
import _m_j.ggh;
import _m_j.gqb;
import _m_j.gqg;
import _m_j.gud;
import _m_j.gue;
import _m_j.gwg;
import _m_j.hah;
import _m_j.hxi;
import _m_j.hzf;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HomeRoomEditorActivityV2 extends BaseActivity implements TextWatcher, View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    hah.O000000o f8891O000000o = new hah.O000000o() {
        /* class com.xiaomi.smarthome.homeroom.HomeRoomEditorActivityV2.AnonymousClass1 */

        public final void O000000o(String str) {
            if (!TextUtils.isEmpty(str)) {
                HomeRoomEditorActivityV2.this.mEditText.setText(str);
            }
        }

        public final String O00000Oo(String str) {
            if (ggb.O00000Oo().O000000o(HomeRoomEditorActivityV2.this.mLastDeviceTag, str, (String) null)) {
                return HomeRoomEditorActivityV2.this.getString(R.string.room_name_duplicate);
            }
            return null;
        }
    };
    private ViewGroup O00000Oo;
    private ImageView O00000o;
    private View O00000o0;
    private TextView O00000oO;
    private Map<String, Boolean> O00000oo = new HashMap();
    private String O0000O0o;
    private Dialog O0000OOo;
    private Set<String> O0000Oo = new HashSet();
    private boolean O0000Oo0 = false;
    public TextView mEditText;
    public Room mLastDeviceTag;
    public SimpleDraweeView mRoomBg;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void updateSelectedCountTip(String str) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_room_editor_v2);
        String stringExtra = getIntent().getStringExtra("room_id_param");
        this.O0000O0o = getIntent().getStringExtra("home_id_param");
        if (TextUtils.isEmpty(this.O0000O0o)) {
            this.O0000O0o = ggb.O00000Oo().O0000OOo();
        }
        if (ggb.O00000Oo().O00000o(this.O0000O0o) == null) {
            finish();
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            this.mLastDeviceTag = new Room();
            this.mLastDeviceTag.setDids(new ArrayList());
            this.mLastDeviceTag.setParentid(this.O0000O0o);
        } else {
            this.mLastDeviceTag = ggb.O00000Oo().O00000o0(stringExtra);
            if (this.mLastDeviceTag == null) {
                this.mLastDeviceTag = new Room();
                this.mLastDeviceTag.setDids(new ArrayList());
                this.mLastDeviceTag.setParentid(this.O0000O0o);
            }
            if (TextUtils.equals(stringExtra, "mijia.roomid.common")) {
                this.O0000Oo0 = true;
                this.mLastDeviceTag.setBackground(ggb.O00000Oo().O00000o(this.O0000O0o).getIcon());
                this.mLastDeviceTag.setName(getString(R.string.tag_common));
                this.mLastDeviceTag.setId("mijia.roomid.common");
            }
        }
        List<String> dids = this.mLastDeviceTag.getDids();
        if (dids != null) {
            for (int i = 0; i < dids.size(); i++) {
                this.O00000oo.put(dids.get(i), Boolean.TRUE);
                this.O0000Oo.add(dids.get(i));
            }
        } else {
            this.mLastDeviceTag.setDids(new ArrayList());
        }
        String stringExtra2 = getIntent().getStringExtra("room_name");
        gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), findViewById(R.id.title_bar_choose_device));
        this.O00000Oo = (ViewGroup) findViewById(R.id.bg_container);
        this.O00000Oo.setOnClickListener(this);
        this.mRoomBg = (SimpleDraweeView) findViewById(R.id.sd_room_bg);
        ((GenericDraweeHierarchy) this.mRoomBg.getHierarchy()).setPlaceholderImageFocusPoint(new PointF(0.5f, 0.19f));
        this.O00000o0 = findViewById(R.id.module_a_3_return_btn);
        this.O00000o0.setContentDescription(getString(R.string.sh_common_cancel));
        this.O00000o = (ImageView) findViewById(R.id.module_a_3_right_img_btn);
        this.O00000o.setContentDescription(getString(R.string.ok_button));
        this.O00000o.setImageResource(R.drawable.title_right_tick_drawable);
        this.O00000o.setEnabled(false);
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        this.mEditText = (TextView) findViewById(R.id.input_tag);
        this.O00000oO = (TextView) findViewById(R.id.room_name_tag);
        this.mEditText.setOnClickListener(this);
        if (TextUtils.isEmpty(this.mLastDeviceTag.getName())) {
            textView.setText((int) R.string.tag_add_title);
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.mEditText.setText(stringExtra2);
                this.O00000o.setEnabled(true);
            }
        } else {
            textView.setText((int) R.string.tag_editor_title);
            this.mEditText.setText(this.mLastDeviceTag.getName());
        }
        this.O00000o0.setOnClickListener(this);
        this.O00000o.setOnClickListener(this);
        this.mEditText.addTextChangedListener(this);
        if (this.O0000Oo0) {
            findViewById(R.id.arrow_right).setVisibility(4);
            this.O00000oO.setText((int) R.string.input_tag_name_common_room);
        }
        O000000o(this.mLastDeviceTag.getBackground());
    }

    private void O000000o(String str) {
        ((GenericDraweeHierarchy) this.mRoomBg.getHierarchy()).setActualImageFocusPoint(new PointF(0.5f, 0.19f));
        ggb.O0000O0o.O000000o(this.mRoomBg, str, new boolean[0]);
        if (ggh.O000000o().O000000o(str)) {
            this.mRoomBg.setTag(str);
        }
    }

    public void onResume() {
        super.onResume();
        hxi.O00000o0.O00000oo(0L);
    }

    public void onPause() {
        super.onPause();
        hxi.O00000o0.O00000oo(this.mEnterTime);
    }

    public void onDestroy() {
        super.onDestroy();
        Dialog dialog = this.O0000OOo;
        if (dialog != null && dialog.isShowing()) {
            this.O0000OOo.dismiss();
        }
    }

    public void onClick(View view) {
        if (view == this.O00000o0) {
            onBackPressed();
        } else if (view == this.O00000o) {
            try {
                hxi.O00000o.f952O000000o.O000000o("page_roomset_preserve", "room_name_edit", Boolean.valueOf(!TextUtils.equals(this.mEditText.getText().toString().trim(), this.mLastDeviceTag.getName())), "device_number_edit", Boolean.valueOf(!this.O0000Oo.equals(this.O00000oo.keySet())));
            } catch (Exception e) {
                e.printStackTrace();
            }
            onConfirm();
        } else if (view == this.O00000Oo) {
            Intent intent = new Intent(getContext(), HomeRoomBackgroundActivity.class);
            intent.putExtra("roomName", this.mEditText.getText());
            startActivityForResult(intent, 1001);
            hxi.O00000o.f952O000000o.O000000o("room_background_setting", "name", TextUtils.isEmpty(this.mEditText.getText()) ? "" : this.mEditText.getText().toString());
        } else if (view == this.mEditText && !this.O0000Oo0) {
            Dialog dialog = this.O0000OOo;
            if (dialog != null && dialog.isShowing()) {
                this.O0000OOo.dismiss();
            }
            this.O0000OOo = hah.O000000o(this, this.mEditText.getText().toString(), getString(R.string.room_name_update), getString(R.string.input_tag_name_hint), this.f8891O000000o);
            hxi.O00000o.f952O000000o.O000000o("page_roomset_name", "room_newname", this.mEditText.getText().toString());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (!TextUtils.isEmpty(this.mEditText.getText().toString())) {
                this.O00000o.setEnabled(true);
            }
            if (i == 1001) {
                O000000o(intent.getStringExtra("wallpaperNamePrefix"));
            }
        }
    }

    public void onConfirm() {
        List<Room> O00000o2;
        if (!TextUtils.isEmpty(this.mLastDeviceTag.getId()) || (O00000o2 = ggb.O00000Oo().O00000o()) == null || O00000o2.size() < 50) {
            String trim = this.mEditText.getText().toString().trim();
            if (!ggb.O0000oO(trim)) {
                gqg.O00000Oo((int) R.string.room_name_too_long);
            } else if (gqb.O00000Oo(trim)) {
                Dialog dialog = this.O0000OOo;
                if (dialog != null && dialog.isShowing()) {
                    this.O0000OOo.dismiss();
                }
                this.O0000OOo = new MLAlertDialog.Builder(this).O000000o(String.format(getString(R.string.tag_save_data_title), trim)).O00000Oo((int) R.string.tag_save_data_description).O00000o0((int) R.string.tag_roger, (DialogInterface.OnClickListener) null).O00000oo();
            } else {
                ArrayList arrayList = new ArrayList(this.O00000oo.keySet());
                if (ggb.O00000Oo().O000000o(this.mLastDeviceTag, trim)) {
                    this.O00000o.setEnabled(false);
                    String string = getString(R.string.name_duplicate);
                    if (TextUtils.isEmpty(string)) {
                        string = getResources().getString(R.string.name_duplicate);
                    }
                    new MLAlertDialog.Builder(this).O00000Oo(string).O000000o((int) R.string.confirm, new DialogInterface.OnClickListener() {
                        /* class _m_j.hah.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).O00000oo();
                    return;
                }
                if (TextUtils.isEmpty(this.mLastDeviceTag.getId())) {
                    ggb.O00000Oo().O000000o(TextUtils.isEmpty(this.O0000O0o) ? this.mLastDeviceTag.getParentid() : this.O0000O0o, trim, arrayList, (String) this.mRoomBg.getTag(), new ggb.O00000o() {
                        /* class com.xiaomi.smarthome.homeroom.HomeRoomEditorActivityV2.AnonymousClass2 */

                        public final void O000000o() {
                            HomeRoomEditorActivityV2.this.finish();
                        }

                        public final void O000000o(int i, fso fso) {
                            if (fso == null || fso.f17063O000000o != -35) {
                                gqg.O00000Oo((int) R.string.add_failed);
                            } else {
                                gqg.O00000Oo((int) R.string.name_repeat);
                            }
                        }
                    });
                    O000000o(this.O00000oo.keySet());
                } else if (TextUtils.equals(this.mLastDeviceTag.getId(), "mijia.roomid.common")) {
                    final Home O00000o3 = ggb.O00000Oo().O00000o(this.O0000O0o);
                    final String icon = O00000o3.getIcon();
                    O00000o3.setIcon((String) this.mRoomBg.getTag());
                    ggb.O00000Oo().O000000o(O00000o3, new ggb.O00000o() {
                        /* class com.xiaomi.smarthome.homeroom.HomeRoomEditorActivityV2.AnonymousClass3 */

                        public final void O000000o() {
                            HomeRoomEditorActivityV2.this.finish();
                            gud O000000o2 = gue.O000000o();
                            if (O000000o2 != null) {
                                O000000o2.setWallpaper((String) HomeRoomEditorActivityV2.this.mRoomBg.getTag());
                            }
                        }

                        public final void O000000o(int i, fso fso) {
                            gqg.O00000Oo((int) R.string.add_failed);
                            O00000o3.setIcon(icon);
                        }
                    });
                    return;
                } else {
                    final String name = this.mLastDeviceTag.getName();
                    final String background = this.mLastDeviceTag.getBackground();
                    this.mLastDeviceTag.setName(trim);
                    this.mLastDeviceTag.setBackground((String) this.mRoomBg.getTag());
                    ArrayList arrayList2 = new ArrayList();
                    for (String next : this.O0000Oo) {
                        if (!arrayList.contains(next)) {
                            arrayList2.add(next);
                        }
                    }
                    ggb.O00000Oo().O000000o(this.mLastDeviceTag, arrayList, arrayList2, new ggb.O00000o() {
                        /* class com.xiaomi.smarthome.homeroom.HomeRoomEditorActivityV2.AnonymousClass4 */

                        public final void O000000o() {
                            HomeRoomEditorActivityV2.this.finish();
                        }

                        public final void O000000o(int i, fso fso) {
                            if (fso == null || fso.f17063O000000o != -35) {
                                gqg.O00000Oo((int) R.string.add_failed);
                            } else {
                                gqg.O00000Oo((int) R.string.name_repeat);
                            }
                            HomeRoomEditorActivityV2.this.mLastDeviceTag.setName(name);
                            HomeRoomEditorActivityV2.this.mLastDeviceTag.setBackground(background);
                        }
                    });
                    O000000o(this.O00000oo.keySet());
                    if (getIntent().getBooleanExtra("result", false)) {
                        Intent intent = new Intent();
                        intent.putExtra("old_name", this.mLastDeviceTag.getName());
                        intent.putExtra("new_name", trim);
                        setResult(-1, intent);
                    }
                }
                fnn.O000000o().O00000Oo().O00000oO();
                fnn.O000000o().O00000Oo().O00000oo();
            }
        } else {
            gqg.O00000Oo((int) R.string.exceed_room_max_count);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fmr.setSubDeviceShownMode(boolean, java.util.Set<java.lang.String>, android.content.Context, _m_j.ftt<java.lang.Void>):void
     arg types: [int, java.util.HashSet, com.xiaomi.smarthome.homeroom.HomeRoomEditorActivityV2, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.fmr.setSubDeviceShownMode(boolean, java.lang.String, android.content.Context, _m_j.ftt<java.lang.Void>):void
      _m_j.fmr.setSubDeviceShownMode(boolean, java.util.Set<java.lang.String>, android.content.Context, _m_j.ftt<java.lang.Void>):void */
    private void O000000o(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (String O00000Oo2 : set) {
                Device O00000Oo3 = fno.O000000o().O00000Oo(O00000Oo2);
                if (O00000Oo3 != null && !O00000Oo3.isShowMainList()) {
                    hashSet.add(O00000Oo3.did);
                }
            }
            if (hashSet.size() > 0) {
                fno.O000000o().f16707O000000o.setSubDeviceShownMode(true, (Set<String>) hashSet, (Context) this, (ftt<Void>) null);
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.O00000o.setEnabled(!TextUtils.isEmpty(charSequence));
    }

    public Map<String, Boolean> getDeviceSelectedStatus() {
        return this.O00000oo;
    }

    public String getEditText() {
        CharSequence text = this.mEditText.getText();
        if (text == null) {
            return null;
        }
        return text.toString();
    }

    public Room getEditRoom() {
        return this.mLastDeviceTag;
    }

    public void onBackPressed() {
        if (this.O00000o.isEnabled()) {
            Dialog dialog = this.O0000OOo;
            if (dialog != null && dialog.isShowing()) {
                this.O0000OOo.dismiss();
            }
            this.O0000OOo = new MLAlertDialog.Builder(this).O00000o0().O000000o((int) R.string.tag_dump_data_prompt).O00000Oo((int) R.string.tag_dump_data_prompt_description).O000000o((int) R.string.save, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.homeroom.HomeRoomEditorActivityV2.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    HomeRoomEditorActivityV2.this.onConfirm();
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.homeroom.HomeRoomEditorActivityV2.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    HomeRoomEditorActivityV2.this.finish();
                }
            }).O00000oo();
            return;
        }
        try {
            super.onBackPressed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
