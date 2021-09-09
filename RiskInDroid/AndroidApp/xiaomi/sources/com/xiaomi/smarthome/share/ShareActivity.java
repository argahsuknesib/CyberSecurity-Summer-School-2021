package com.xiaomi.smarthome.share;

import _m_j.fno;
import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gqd;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gyl;
import _m_j.hxi;
import _m_j.hys;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.miio.db.record.ShareUserRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class ShareActivity extends BaseActivity {
    public static String ARG_KEYS_FROM = "jump_from";
    public static int FROM_XIAOMI_ACCOUNT = 1;
    public static int SHARE_FROM_FAMILY;

    /* renamed from: O000000o  reason: collision with root package name */
    int f11354O000000o = 0;
    View O00000Oo;
    private String O00000o = "";
    View O00000o0;
    private int O00000oO = -1;
    public boolean isLogConfirmBtn = false;
    public AutoCompleteTextView mAccountEditor;
    public TextView mAccountName;
    public ArrayList<String> mBatchDids;
    public TextView mButtonSearch;
    public Context mContext;
    public Device mDevice;
    public SimpleDraweeView mIcon;
    public List<String> mPhoneNums = new ArrayList();
    public boolean mShareNeedResult = false;
    public TextView mShareStateTxt;
    public UserInfo mUserInfo;

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        this.mContext = this;
        setContentView((int) R.layout.sh_share_activity);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            str = extras.getString("did");
            this.O00000o = extras.getString("share_type");
            this.O00000oO = extras.getInt(ARG_KEYS_FROM, -1);
            if (extras.containsKey("need_result")) {
                this.mShareNeedResult = extras.getBoolean("need_result", false);
            }
        } else {
            str = null;
        }
        if (str != null) {
            this.mDevice = fno.O000000o().O000000o(str);
        } else if (extras != null) {
            this.mBatchDids = extras.getStringArrayList("batch_dids");
        }
        this.f11354O000000o = 1;
        if (extras != null) {
            this.mUserInfo = (UserInfo) extras.getParcelable("user_INFO");
        }
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.share.ShareActivity.AnonymousClass1 */

            public final void onClick(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager) ShareActivity.this.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(ShareActivity.this.mAccountEditor.getWindowToken(), 0);
                }
                ShareActivity.this.finish();
                if (ShareActivity.this.mDevice != null) {
                    hxi.O00000o.f952O000000o.O000000o("plugin_deviceshare_mi_back", new Object[0]);
                }
                ShareActivity.this.isLogConfirmBtn = false;
            }
        });
        findViewById(R.id.module_a_3_right_img_btn).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        int i = this.O00000oO;
        if (i == SHARE_FROM_FAMILY) {
            textView.setText((int) R.string.share_to_family);
        } else if (i == FROM_XIAOMI_ACCOUNT) {
            textView.setText((int) R.string.smarthome_device_auth_xiaomi);
        } else if (this.mDevice == null) {
            textView.setText((int) R.string.smarthome_share_multiple_devices);
        } else {
            textView.setText(String.format(getString(R.string.sh_share_tile), this.mDevice.name));
        }
        this.O00000Oo = findViewById(R.id.scene_search);
        this.mAccountEditor = (AutoCompleteTextView) findViewById(R.id.account_editor);
        this.mAccountEditor.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.xiaomi.smarthome.share.ShareActivity.AnonymousClass2 */

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return (i == 6 || (keyEvent != null && keyEvent.getKeyCode() == 66)) && ShareActivity.this.processShareEnter();
            }
        });
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.device_image);
        simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setPlaceholderImage(simpleDraweeView.getResources().getDrawable(R.drawable.std_share_device_icon_small)).build());
        TextView textView2 = (TextView) findViewById(R.id.device_name);
        Device device = this.mDevice;
        String str3 = "";
        if (device != null) {
            DeviceFactory.O000000o(device.model, simpleDraweeView, (int) R.drawable.moredevice_yellowlight);
            textView2.setText(this.mDevice.name);
        } else {
            textView2.setText(str3);
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.std_share_device_icon_small));
        }
        ((ImageView) findViewById(R.id.btn_share_device)).setVisibility(8);
        this.mButtonSearch = (TextView) findViewById(R.id.button_search);
        this.mButtonSearch.setText((int) R.string.sh_confirm);
        this.mButtonSearch.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.share.ShareActivity.AnonymousClass3 */

            public final void onClick(View view) {
                ShareActivity shareActivity = ShareActivity.this;
                shareActivity.getUserInfo(shareActivity.mAccountEditor.getText().toString());
            }
        });
        this.mButtonSearch.setEnabled(!TextUtils.isEmpty(this.mAccountEditor.getText().toString()));
        this.mAccountEditor.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.share.ShareActivity.AnonymousClass4 */

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ShareActivity.this.mButtonSearch.setEnabled(!TextUtils.isEmpty(charSequence));
            }
        });
        this.O00000o0 = findViewById(R.id.scene_confirm);
        this.mIcon = (SimpleDraweeView) findViewById(R.id.icon_image);
        this.mAccountName = (TextView) findViewById(R.id.account_name);
        this.mShareStateTxt = (TextView) findViewById(R.id.share_state);
        this.mShareStateTxt.setVisibility(4);
        if (str3.equals(this.O00000o)) {
            str2 = getResources().getString(R.string.share_permission_can_control);
            this.mShareStateTxt.setVisibility(0);
        } else if ("readonly".equals(this.O00000o)) {
            str2 = getResources().getString(R.string.share_permission_cannot_control);
            this.mShareStateTxt.setVisibility(0);
        } else {
            this.mShareStateTxt.setVisibility(4);
            str2 = str3;
        }
        if (this.mUserInfo == null) {
            this.mShareStateTxt.setVisibility(4);
        }
        Device device2 = this.mDevice;
        if (device2 == null || TextUtils.isEmpty(device2.name)) {
            ArrayList<String> arrayList = this.mBatchDids;
            if (arrayList != null && arrayList.size() > 0) {
                str3 = fno.O000000o().O000000o(this.mBatchDids.get(0)).name;
                if (this.mBatchDids.size() > 1) {
                    str3 = getResources().getQuantityString(R.plurals.share_wx_device_title_2, this.mBatchDids.size(), fno.O000000o().O000000o(this.mBatchDids.get(0)).name, Integer.valueOf(this.mBatchDids.size()));
                }
            }
        } else {
            str3 = this.mDevice.name;
        }
        this.mShareStateTxt.setText(getResources().getString(R.string.share_permission_with_device_new, str2, str3));
        findViewById(R.id.button_confirm).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.share.ShareActivity.AnonymousClass5 */

            public final void onClick(View view) {
                if (ShareActivity.this.mDevice != null) {
                    ShareActivity.this.share();
                } else if (ShareActivity.this.mBatchDids != null) {
                    ShareActivity.this.shareBatch();
                }
            }
        });
        if (this.mUserInfo != null) {
            O000000o();
            this.mAccountName.setText(this.mUserInfo.O00000oO);
            gyl.O000000o().O000000o(this.mUserInfo.f7549O000000o, this.mIcon, (BasePostprocessor) null);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.mDevice != null) {
            hxi.O00000o0.f957O000000o.O000000o("plugin_deviceshare_mi_show", new Object[0]);
        }
    }

    public boolean processShareEnter() {
        TextView textView = this.mButtonSearch;
        if (textView == null || textView.getVisibility() != 0) {
            return false;
        }
        return this.mButtonSearch.performClick();
    }

    public void onPause() {
        super.onPause();
        this.isLogConfirmBtn = false;
    }

    public void getUserInfo(final String str) {
        if (TextUtils.isEmpty(str)) {
            gqg.O000000o((int) R.string.please_inpt_account);
        } else {
            hys.O000000o().O000000o(this, str, new fsm<UserInfo, fso>() {
                /* class com.xiaomi.smarthome.share.ShareActivity.AnonymousClass6 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.hxk.O000000o(boolean, java.lang.String):void
                 arg types: [int, java.lang.String]
                 candidates:
                  _m_j.hxk.O000000o(int, int):void
                  _m_j.hxk.O000000o(java.lang.String, int):void
                  _m_j.hxk.O000000o(java.lang.String, long):void
                  _m_j.hxk.O000000o(java.lang.String, java.lang.String):void
                  _m_j.hxk.O000000o(java.lang.String, org.json.JSONObject):void
                  _m_j.hxk.O000000o(java.lang.String, boolean):void
                  _m_j.hxk.O000000o(boolean, java.lang.String):void */
                public final /* synthetic */ void onSuccess(Object obj) {
                    UserInfo userInfo = (UserInfo) obj;
                    if (userInfo != null && !TextUtils.isEmpty(userInfo.f7549O000000o) && !userInfo.f7549O000000o.equalsIgnoreCase("-1") && !userInfo.f7549O000000o.equalsIgnoreCase("0")) {
                        ShareActivity.this.O000000o();
                        ShareActivity shareActivity = ShareActivity.this;
                        shareActivity.mUserInfo = userInfo;
                        shareActivity.mShareStateTxt.setVisibility(0);
                        ShareActivity.this.mAccountName.setText(ShareActivity.this.mUserInfo.O00000oO);
                        ShareUserRecord shareUserRecord = ShareUserRecord.get(str);
                        if (shareUserRecord != null) {
                            shareUserRecord.nickName = ShareActivity.this.mUserInfo.O00000oO;
                            ShareUserRecord.insert(shareUserRecord);
                        }
                        gyl.O000000o().O000000o(ShareActivity.this.mUserInfo.f7549O000000o, ShareActivity.this.mIcon, (BasePostprocessor) null);
                    } else if (ShareActivity.this.mPhoneNums.size() > 0) {
                        ShareActivity.this.getUserInfo(ShareActivity.this.mPhoneNums.remove(0));
                    } else {
                        gqg.O000000o((int) R.string.sh_user_not_exist);
                        ShareActivity shareActivity2 = ShareActivity.this;
                        shareActivity2.f11354O000000o = 1;
                        shareActivity2.O00000o0.setVisibility(8);
                        shareActivity2.O00000Oo.setVisibility(0);
                        shareActivity2.mButtonSearch.setText((int) R.string.sh_confirm);
                        shareActivity2.mAccountEditor.setText("");
                    }
                    if (!ShareActivity.this.isLogConfirmBtn) {
                        ShareActivity shareActivity3 = ShareActivity.this;
                        shareActivity3.isLogConfirmBtn = true;
                        if (shareActivity3.mDevice != null) {
                            hxi.O00000o.O000000o(true, str);
                        }
                    }
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.hxk.O000000o(boolean, java.lang.String):void
                 arg types: [int, java.lang.String]
                 candidates:
                  _m_j.hxk.O000000o(int, int):void
                  _m_j.hxk.O000000o(java.lang.String, int):void
                  _m_j.hxk.O000000o(java.lang.String, long):void
                  _m_j.hxk.O000000o(java.lang.String, java.lang.String):void
                  _m_j.hxk.O000000o(java.lang.String, org.json.JSONObject):void
                  _m_j.hxk.O000000o(java.lang.String, boolean):void
                  _m_j.hxk.O000000o(boolean, java.lang.String):void */
                public final void onFailure(fso fso) {
                    if (fso.f17063O000000o == ErrorCode.ERROR_NETWORK_ERROR.getCode()) {
                        gqg.O000000o((int) R.string.sh_network_not_available);
                    } else {
                        gqg.O000000o((int) R.string.sh_user_not_exist);
                    }
                    if (!ShareActivity.this.isLogConfirmBtn) {
                        ShareActivity shareActivity = ShareActivity.this;
                        shareActivity.isLogConfirmBtn = true;
                        if (shareActivity.mDevice != null) {
                            hxi.O00000o.O000000o(false, str);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        this.f11354O000000o = 2;
        if (Build.VERSION.SDK_INT >= 19) {
            Fade fade = new Fade();
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.setDuration(200L);
            transitionSet.addTransition(fade);
            TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.root), transitionSet);
        }
        this.O00000Oo.setVisibility(8);
        this.O00000o0.setVisibility(0);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.mAccountEditor.getWindowToken(), 0);
        }
    }

    private static String O000000o(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        int indexOf = sb.indexOf("1");
        if (indexOf == -1) {
            gsy.O000000o(6, "ShareActivity", "not a phone num");
            return null;
        }
        String substring = sb.substring(indexOf);
        if (substring.length() == 11) {
            return substring;
        }
        gsy.O000000o(6, "ShareActivity", "not a phone num");
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087 A[Catch:{ Exception -> 0x009b, all -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    public void onActivityResult(int i, int i2, Intent intent) {
        int columnIndex;
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            Cursor cursor = null;
            try {
                Cursor query = getContentResolver().query(intent.getData(), null, null, null, null);
                if (!(query == null || !query.moveToFirst() || (columnIndex = query.getColumnIndex("_id")) == -1)) {
                    Cursor query2 = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = ".concat(String.valueOf(query.getString(columnIndex))), null, null);
                    if (query2 != null) {
                        if (query2.moveToFirst()) {
                            while (!query2.isAfterLast()) {
                                String O000000o2 = O000000o(query2.getString(query2.getColumnIndex("data1")));
                                if (O000000o2 != null) {
                                    this.mPhoneNums.add(O000000o2);
                                }
                                query2.moveToNext();
                            }
                            if (!query2.isClosed()) {
                                query2.close();
                            }
                        }
                        if (this.mPhoneNums.size() > 0) {
                            getUserInfo(this.mPhoneNums.remove(0));
                        }
                        if (query == null) {
                            query.close();
                            return;
                        }
                        return;
                    }
                }
                gqg.O000000o((int) R.string.sh_user_not_exist);
                if (this.mPhoneNums.size() > 0) {
                }
                if (query == null) {
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public void share() {
        if (TextUtils.equals(CoreApi.O000000o().O0000o0(), this.mUserInfo.f7549O000000o)) {
            gqg.O00000Oo((int) R.string.sh_share_request_fail_owner);
        } else {
            fru.O000000o().O000000o(this, this.mDevice.did, this.mUserInfo.f7549O000000o, this.O00000o, new fsm<String, fso>() {
                /* class com.xiaomi.smarthome.share.ShareActivity.AnonymousClass7 */

                public final void onFailure(fso fso) {
                    if (ShareActivity.this.isValid()) {
                        if (fso.f17063O000000o == ErrorCode.ERROR_MAXIMAL_SHARE_REQUEST.getCode()) {
                            new MLAlertDialog.Builder(ShareActivity.this.mContext).O00000Oo(ShareActivity.this.mContext.getResources().getString(R.string.sh_share_fremax_request)).O000000o((int) R.string.sh_confirm, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.share.ShareActivity.AnonymousClass7.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).O00000o().show();
                        } else if (fso.f17063O000000o == ErrorCode.ERROR_FEQUENT_REQUEST.getCode()) {
                            new MLAlertDialog.Builder(ShareActivity.this.mContext).O00000Oo(ShareActivity.this.mContext.getResources().getString(R.string.sh_share_frequent_request)).O000000o((int) R.string.sh_confirm, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.share.ShareActivity.AnonymousClass7.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).O00000o().show();
                        } else if (fso.f17063O000000o == ErrorCode.ERROR_REPEATED_REQUEST.getCode()) {
                            new MLAlertDialog.Builder(ShareActivity.this.mContext).O00000Oo(ShareActivity.this.mContext.getResources().getString(R.string.sh_share_repeated_request)).O000000o((int) R.string.sh_confirm, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.share.ShareActivity.AnonymousClass7.AnonymousClass3 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).O00000o().show();
                        } else {
                            gqg.O000000o((int) R.string.sh_share_request_fail);
                        }
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (!ShareActivity.this.isValid()) {
                        return;
                    }
                    if (ShareActivity.this.mShareNeedResult) {
                        ShareActivity.this.setResult(-1);
                        ShareActivity.this.finish();
                        return;
                    }
                    gqg.O000000o((int) R.string.sh_share_request_success);
                    ShareActivity.this.finish();
                }
            });
        }
    }

    public void shareBatch() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mUserInfo.f7549O000000o);
        fru.O000000o().O000000o(this, this.mBatchDids, arrayList, this.O00000o, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.share.ShareActivity.AnonymousClass8 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject optJSONObject = ((JSONObject) obj).optJSONObject(ShareActivity.this.mUserInfo.f7549O000000o);
                boolean z = true;
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (true) {
                        if (keys.hasNext()) {
                            if (1 == optJSONObject.optInt(keys.next())) {
                                z = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (!z || optJSONObject == null) {
                    gqg.O000000o((int) R.string.sh_share_request_success);
                } else {
                    gqg.O000000o((int) R.string.sh_share_repeated_request);
                }
                ShareActivity.this.finish();
            }

            public final void onFailure(fso fso) {
                if (fso.f17063O000000o == ErrorCode.ERROR_MAXIMAL_SHARE_REQUEST.getCode()) {
                    new MLAlertDialog.Builder(ShareActivity.this.mContext).O00000Oo(ShareActivity.this.mContext.getResources().getString(R.string.sh_share_fremax_request)).O000000o((int) R.string.sh_confirm, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.share.ShareActivity.AnonymousClass8.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).O00000o().show();
                } else if (fso.f17063O000000o == ErrorCode.ERROR_FEQUENT_REQUEST.getCode()) {
                    new MLAlertDialog.Builder(ShareActivity.this.mContext).O00000Oo(ShareActivity.this.mContext.getResources().getString(R.string.sh_share_frequent_request)).O000000o((int) R.string.sh_confirm, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.share.ShareActivity.AnonymousClass8.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).O00000o().show();
                } else {
                    gqg.O000000o((int) R.string.sh_share_request_fail);
                }
            }
        });
    }
}
