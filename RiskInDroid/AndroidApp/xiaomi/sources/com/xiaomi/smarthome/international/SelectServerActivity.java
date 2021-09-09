package com.xiaomi.smarthome.international;

import _m_j.cub;
import _m_j.ezo;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.flk;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.ftn;
import _m_j.fto;
import _m_j.gfr;
import _m_j.gft;
import _m_j.gfu;
import _m_j.gjg;
import _m_j.gjh;
import _m_j.gri;
import _m_j.grr;
import _m_j.gsc;
import _m_j.gsy;
import _m_j.gty;
import _m_j.gwg;
import _m_j.hje;
import _m_j.hxi;
import _m_j.ibh;
import _m_j.izb;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.ActivityStack;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.international.SelectServerActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.youpin.login.entity.Error;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class SelectServerActivity extends BaseActivity {
    @Deprecated
    public static final String DISPLAY_MODE = "display_mode";

    /* renamed from: O000000o  reason: collision with root package name */
    int f9046O000000o = -1;
    private ListView O00000Oo;
    private Disposable O00000o;
    private MLAlertDialog O00000o0;
    private View O00000oO;
    private View O00000oo;
    public String currentServerName = "";
    public boolean isInSearchMode = false;
    public O00000Oo mAdapter;
    public Context mContext;
    public ServerBean mCurrentServer;
    public String mFromWhere;
    public XQProgressDialog mProcessDialog;
    public ServerBean mRecommendServer;
    public View mSaveBtn;
    public EditText mSearchBox;
    public ServerBean mSelectedServerWhenNormal = null;
    public ServerBean mSelectedServerWhenSearch = null;
    public List<ServerBean> mTotalServers;

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000Oo(DialogInterface dialogInterface, int i) {
    }

    public boolean useActivityAsStat() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getApplicationContext();
        setContentView((int) R.layout.international_activity);
        if (getIntent() != null) {
            this.mFromWhere = getIntent().getStringExtra("from_where");
        }
        View findViewById = findViewById(R.id.nav_title);
        this.mSaveBtn = findViewById(R.id.save_btn);
        this.O00000oO = findViewById(R.id.finish_btn);
        this.mSearchBox = (EditText) findViewById(R.id.search_box);
        this.O00000oo = findViewById(R.id.normal_desc);
        this.O00000Oo = (ListView) findViewById(R.id.listview);
        ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).setMargins(0, gwg.O000000o((Context) this), 0, 0);
        this.mSaveBtn.setEnabled(false);
        this.mSaveBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.international.$$Lambda$SelectServerActivity$D_qpHk6PxI42wFLQLjRbfQLCBvw */

            public final void onClick(View view) {
                SelectServerActivity.this.O00000Oo(view);
            }
        });
        this.O00000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.international.$$Lambda$SelectServerActivity$rDc_6oFvIfS54WUw4_dffhXfgg */

            public final void onClick(View view) {
                SelectServerActivity.this.O000000o(view);
            }
        });
        this.mSearchBox.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.xiaomi.smarthome.international.$$Lambda$SelectServerActivity$IIY8mtvMg20JNYmTHhFUVDAXic */

            public final void onFocusChange(View view, boolean z) {
                SelectServerActivity.this.O000000o(view, z);
            }
        });
        this.mSearchBox.addTextChangedListener(new O000000o());
        this.mSearchBox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.xiaomi.smarthome.international.$$Lambda$SelectServerActivity$weIhfmaWdmnE6ByTQPwSyn5SY */

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return SelectServerActivity.this.O000000o(textView, i, keyEvent);
            }
        });
        ListView listView = this.O00000Oo;
        O00000Oo o00000Oo = new O00000Oo(this);
        this.mAdapter = o00000Oo;
        listView.setAdapter((ListAdapter) o00000Oo);
        this.O00000o = gjh.O000000o().O00000Oo().distinctUntilChanged().map(new Function<List<ServerBean>, List<ServerBean>>() {
            /* class com.xiaomi.smarthome.international.SelectServerActivity.AnonymousClass2 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                List list = (List) obj;
                if (list.isEmpty()) {
                    return list;
                }
                if (SelectServerActivity.this.mCurrentServer == null) {
                    SelectServerActivity.this.mCurrentServer = ftn.O000000o(ServiceApplication.getAppContext());
                }
                if (SelectServerActivity.this.mRecommendServer == null) {
                    SelectServerActivity.this.mRecommendServer = gjg.O000000o();
                }
                ArrayList arrayList = new ArrayList(list);
                boolean z = true;
                if (SelectServerActivity.this.mCurrentServer != null) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ServerBean serverBean = (ServerBean) it.next();
                        if (TextUtils.equals(serverBean.O00000Oo, SelectServerActivity.this.mCurrentServer.O00000Oo)) {
                            serverBean.O00000oO = true;
                            SelectServerActivity.this.currentServerName = serverBean.O00000o0;
                            break;
                        }
                    }
                }
                if (SelectServerActivity.this.mRecommendServer != null) {
                    Iterator it2 = arrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        ServerBean serverBean2 = (ServerBean) it2.next();
                        if (TextUtils.equals(serverBean2.O00000Oo, SelectServerActivity.this.mRecommendServer.O00000Oo)) {
                            serverBean2.O00000o = true;
                            break;
                        }
                    }
                }
                Locale O00000o0 = ftn.O00000o0(ServiceApplication.getAppContext());
                Context appContext = ServiceApplication.getAppContext();
                if (TextUtils.isEmpty(gsc.O000000o(appContext, "server_config" + File.separator + flk.O000000o(O00000o0).toLowerCase() + ".json"))) {
                    if (TextUtils.isEmpty(gsc.O000000o(appContext, "server_config" + File.separator + fto.O000000o(O00000o0.getLanguage().toLowerCase()) + ".json"))) {
                        z = false;
                    }
                }
                if (!z) {
                    O00000o0 = Locale.ENGLISH;
                } else if (flk.O000000o(O00000o0).equalsIgnoreCase("zh_tw") || flk.O000000o(O00000o0).equalsIgnoreCase("zh_hk")) {
                    O00000o0 = Locale.SIMPLIFIED_CHINESE;
                }
                Collections.sort(arrayList, new Comparator(Collator.getInstance(O00000o0)) {
                    /* class com.xiaomi.smarthome.international.$$Lambda$SelectServerActivity$2$ag754HK0lcUxoAFMHhpGnUQV67M */
                    private final /* synthetic */ Collator f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final int compare(Object obj, Object obj2) {
                        return this.f$0.compare(((ServerBean) obj).O00000o0, ((ServerBean) obj2).O00000o0);
                    }
                });
                ServerBean O0000Oo = ftn.O0000Oo();
                if ((gfr.O0000OOo || gfr.O0000o0o) && !arrayList.contains(O0000Oo)) {
                    O0000Oo.O00000o0 = ftn.O000000o(SelectServerActivity.this, O0000Oo.O00000Oo);
                    arrayList.add(O0000Oo);
                }
                return arrayList;
            }
        }).filter($$Lambda$SelectServerActivity$31H0UKI67hpz_tbPreMuNCpL0.INSTANCE).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<ServerBean>>() {
            /* class com.xiaomi.smarthome.international.SelectServerActivity.AnonymousClass1 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                int i;
                List<ServerBean> list = (List) obj;
                SelectServerActivity selectServerActivity = SelectServerActivity.this;
                selectServerActivity.mTotalServers = list;
                if (selectServerActivity.mRecommendServer == null || SelectServerActivity.this.mCurrentServer != null) {
                    i = SelectServerActivity.this.mCurrentServer != null ? SelectServerActivity.this.mTotalServers.indexOf(SelectServerActivity.this.mCurrentServer) : -1;
                } else {
                    i = SelectServerActivity.this.mTotalServers.indexOf(SelectServerActivity.this.mRecommendServer);
                    SelectServerActivity.this.mSaveBtn.setEnabled(true);
                    SelectServerActivity selectServerActivity2 = SelectServerActivity.this;
                    selectServerActivity2.mSelectedServerWhenNormal = selectServerActivity2.mRecommendServer;
                }
                SelectServerActivity selectServerActivity3 = SelectServerActivity.this;
                selectServerActivity3.f9046O000000o = i;
                selectServerActivity3.showServerList(list, i);
                gsy.O00000Oo("wangwei", "accept: " + list.size());
            }
        }, new Consumer() {
            /* class com.xiaomi.smarthome.international.$$Lambda$XXFE7TK16QiBoDbVw7gHm1Cj4vc */

            public final void accept(Object obj) {
                SelectServerActivity.this.showError((Throwable) obj);
            }
        });
        this.mCurrentServer = ftn.O000000o(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean O000000o(TextView textView, int i, KeyEvent keyEvent) {
        if (keyEvent == null || 66 != keyEvent.getKeyCode()) {
            return false;
        }
        if (keyEvent.getAction() != 1) {
            return true;
        }
        O000000o();
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean O000000o(List list) throws Exception {
        return !list.isEmpty();
    }

    private void O000000o() {
        if (this.isInSearchMode) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchBox.getWindowToken(), 2);
        }
        ServerBean serverBean = this.isInSearchMode ? this.mSelectedServerWhenSearch : this.mSelectedServerWhenNormal;
        if (serverBean == null) {
            this.mSaveBtn.setEnabled(false);
            return;
        }
        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
        if (O0000ooO == null) {
            doOK(serverBean, null);
        } else if (!TextUtils.equals(O0000ooO.O00000Oo, serverBean.O00000Oo)) {
            changeServerWithDialog(serverBean, O0000ooO);
        }
    }

    public void changeServerWithDialog(final ServerBean serverBean, final ServerBean serverBean2) {
        String str;
        String str2;
        String str3 = "";
        if (CoreApi.O000000o().O0000Ooo()) {
            AnonymousClass3 r0 = new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.international.SelectServerActivity.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    SelectServerActivity selectServerActivity = SelectServerActivity.this;
                    selectServerActivity.mProcessDialog = new XQProgressDialog(selectServerActivity);
                    SelectServerActivity.this.mProcessDialog.setCancelable(true);
                    SelectServerActivity.this.mProcessDialog.setMessage(SelectServerActivity.this.getString(R.string.kuailian_sub_main_title_waiting));
                    SelectServerActivity.this.mProcessDialog.show();
                    gty.O000000o().logoutWitoutCleanPluginRecord(new ibh<Void, Error>() {
                        /* class com.xiaomi.smarthome.international.SelectServerActivity.AnonymousClass3.AnonymousClass1 */

                        public final void onFailure(Error error) {
                            if (SelectServerActivity.this.mProcessDialog != null) {
                                SelectServerActivity.this.mProcessDialog.dismiss();
                            }
                            izb.O000000o(SelectServerActivity.this.mContext, (int) R.string.server_change_server_failure, 0).show();
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            if (SelectServerActivity.this.mProcessDialog != null) {
                                SelectServerActivity.this.mProcessDialog.dismiss();
                            }
                            SelectServerActivity.this.doOK(serverBean, new fsm<Void, fso>() {
                                /* class com.xiaomi.smarthome.international.SelectServerActivity.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                public final void onFailure(fso fso) {
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    Uri uri;
                                    SelectServerActivity.this.onChangeServerSuccessed(serverBean2, serverBean);
                                    Class O00000Oo = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.framework.navigate.SmartHomeLauncher");
                                    if (O00000Oo != null) {
                                        Intent intent = new Intent(ServiceApplication.getAppContext(), O00000Oo);
                                        if (gty.O000000o().hasMiSystemAccount()) {
                                            uri = Uri.parse("https://home.mi.com/main/login_mi_system?account_name=" + gty.O000000o().getMiSystemAccountId());
                                        } else if (ftn.O00000Oo(serverBean)) {
                                            uri = Uri.parse("https://home.mi.com/main/login_phone_pwd");
                                        } else {
                                            uri = Uri.parse("https://home.mi.com/main/login");
                                        }
                                        intent.putExtra("app_internal_source", 13);
                                        intent.setData(uri);
                                        SelectServerActivity.this.startActivity(intent);
                                        Process.killProcess(Process.myPid());
                                    }
                                }
                            });
                        }
                    });
                }
            };
            $$Lambda$SelectServerActivity$2SeTjtG_G_CDt7Z5sKwVFQfcJNY r10 = $$Lambda$SelectServerActivity$2SeTjtG_G_CDt7Z5sKwVFQfcJNY.INSTANCE;
            boolean equals = TextUtils.equals(serverBean2.f7546O000000o, serverBean.f7546O000000o);
            if (equals) {
                str2 = getString(R.string.confirm_switch_region);
            } else {
                str3 = getString(R.string.server_change_server_title_no_login);
                str2 = getString(R.string.server_change_server_message_common);
                gfu O000000o2 = gft.O000000o();
                if (O000000o2 != null && O000000o2.isShowGlobalShop(ServiceApplication.getApplication())) {
                    str2 = str2 + String.format(getString(R.string.server_change_server_message_shop_tip), new Object[0]);
                }
            }
            MLAlertDialog mLAlertDialog = this.O00000o0;
            if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
                this.O00000o0.dismiss();
            }
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            if (equals) {
                builder.O000000o((int) R.string.confirm_button, r0);
            } else {
                builder.O000000o(str3);
                builder.O000000o((int) R.string.confirm_changing, r0);
            }
            this.O00000o0 = builder.O00000Oo(str2).O00000Oo((int) R.string.sh_common_cancel, r10).O00000o();
            this.O00000o0.show();
            return;
        }
        AnonymousClass4 r02 = new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.international.SelectServerActivity.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                SelectServerActivity.this.doOK(serverBean, new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.international.SelectServerActivity.AnonymousClass4.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        SelectServerActivity.this.onChangeServerSuccessed(serverBean2, serverBean);
                        fbt fbt = new fbt(SelectServerActivity.this.mContext, "SmartHomeMainActivity");
                        fbt.O00000Oo(268468224);
                        Class O00000Oo = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.frame.login.ui.LoginTransitActivity");
                        if (!TextUtils.isEmpty(SelectServerActivity.this.mFromWhere) && O00000Oo != null && O00000Oo.getSimpleName().equals(SelectServerActivity.this.mFromWhere) && (!grr.O00000oO() || !gty.O000000o().hasMiSystemAccount())) {
                            fbt.O000000o("com.xiaomi.smarthome.request_code", 7);
                        }
                        fbs.O000000o(fbt);
                        Process.killProcess(Process.myPid());
                    }
                });
            }
        };
        $$Lambda$SelectServerActivity$pS9qiVl5Dxl665a1JWBXUkby0UA r102 = $$Lambda$SelectServerActivity$pS9qiVl5Dxl665a1JWBXUkby0UA.INSTANCE;
        boolean equals2 = TextUtils.equals(serverBean2.f7546O000000o, serverBean.f7546O000000o);
        if (equals2) {
            str = getString(R.string.confirm_switch_region);
        } else {
            str3 = getString(R.string.server_change_server_title_no_login);
            str = getString(R.string.server_change_server_message_common);
            gfu O000000o3 = gft.O000000o();
            if (O000000o3 != null && O000000o3.isShowGlobalShop(ServiceApplication.getApplication())) {
                str = str + String.format(getString(R.string.server_change_server_message_shop_tip), new Object[0]);
            }
        }
        MLAlertDialog mLAlertDialog2 = this.O00000o0;
        if (mLAlertDialog2 != null && mLAlertDialog2.isShowing()) {
            this.O00000o0.dismiss();
        }
        MLAlertDialog.Builder builder2 = new MLAlertDialog.Builder(this);
        if (equals2) {
            builder2.O000000o((int) R.string.confirm_button, r02);
        } else {
            builder2.O000000o(str3);
            builder2.O000000o((int) R.string.confirm_changing, r02);
        }
        this.O00000o0 = builder2.O00000Oo(str).O00000Oo((int) R.string.sh_common_cancel, r102).O00000o();
        this.O00000o0.show();
    }

    public void onChangeServerSuccessed(ServerBean serverBean, ServerBean serverBean2) {
        ActivityStack.instance.doClearOnServerChanged();
        gfu O000000o2 = gft.O000000o();
        if (O000000o2 != null) {
            O000000o2.onChangeServer(serverBean);
        }
    }

    private void O00000Oo() {
        if (this.isInSearchMode) {
            gsy.O00000Oo("SelectServerActivity", "exitSearchMode: " + this.f9046O000000o);
            this.isInSearchMode = false;
            if (Build.VERSION.SDK_INT >= 19) {
                AutoTransition autoTransition = new AutoTransition();
                autoTransition.setDuration(40L);
                TransitionManager.beginDelayedTransition((ViewGroup) getWindow().getDecorView(), autoTransition);
            }
            this.mSearchBox.setText("");
            this.O00000oo.setVisibility(0);
            showServerList(this.mTotalServers, this.f9046O000000o);
            if (this.mSelectedServerWhenNormal != null) {
                this.mSaveBtn.setEnabled(true);
            } else {
                this.mSaveBtn.setEnabled(false);
            }
        }
    }

    class O000000o implements TextWatcher {
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        O000000o() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (SelectServerActivity.this.mTotalServers == null || charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                SelectServerActivity.this.showServerList(Collections.EMPTY_LIST, -1);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (ServerBean next : SelectServerActivity.this.mTotalServers) {
                if (next.O00000o0.toLowerCase().contains(charSequence.toString().trim().toLowerCase())) {
                    arrayList.add(next);
                }
            }
            SelectServerActivity.this.showServerList(arrayList, -1);
        }

        public final void afterTextChanged(Editable editable) {
            if (SelectServerActivity.this.mSelectedServerWhenSearch != null) {
                boolean contains = SelectServerActivity.this.mAdapter.f9057O000000o.contains(SelectServerActivity.this.mSelectedServerWhenSearch);
                SelectServerActivity.this.mSaveBtn.setEnabled(contains);
                if (!contains) {
                    SelectServerActivity.this.mSelectedServerWhenSearch = null;
                }
            }
        }
    }

    public void showServerList(List<ServerBean> list, int i) {
        if (list != null) {
            this.O00000Oo.setAdapter((ListAdapter) this.mAdapter);
            O00000Oo o00000Oo = this.mAdapter;
            o00000Oo.f9057O000000o.clear();
            o00000Oo.f9057O000000o.addAll(list);
            o00000Oo.notifyDataSetChanged();
            this.O00000Oo.setSelection(i);
        }
    }

    public void showError(Throwable th) {
        th.printStackTrace();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.international.SelectServerActivity.O000000o(boolean, com.xiaomi.smarthome.frame.server_compact.ServerBean):void
     arg types: [int, com.xiaomi.smarthome.frame.server_compact.ServerBean]
     candidates:
      com.xiaomi.smarthome.international.SelectServerActivity.O000000o(android.content.DialogInterface, int):void
      com.xiaomi.smarthome.international.SelectServerActivity.O000000o(android.view.View, boolean):void
      com.xiaomi.smarthome.international.SelectServerActivity.O000000o(boolean, com.xiaomi.smarthome.frame.server_compact.ServerBean):void */
    public void onBackPressed() {
        if (this.isInSearchMode) {
            this.mSearchBox.clearFocus();
            ((ViewGroup) this.mSearchBox.getParent()).requestFocus();
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchBox.getWindowToken(), 2);
            ServerBean serverBean = this.mSelectedServerWhenSearch;
            if (serverBean != null) {
                O000000o(true, serverBean);
            } else {
                O00000Oo();
            }
        } else {
            ServerBean serverBean2 = this.mSelectedServerWhenNormal;
            if (serverBean2 == null || this.mCurrentServer == null) {
                super.onBackPressed();
            } else {
                O000000o(false, serverBean2);
            }
        }
    }

    private void O000000o(boolean z, final ServerBean serverBean) {
        MLAlertDialog mLAlertDialog = this.O00000o0;
        if (mLAlertDialog != null) {
            mLAlertDialog.dismiss();
        }
        this.O00000o0 = new MLAlertDialog.Builder(this).O00000Oo((int) R.string.save_previous_settings).O000000o((int) R.string.save, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.international.SelectServerActivity.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (SelectServerActivity.this.mCurrentServer == null) {
                    SelectServerActivity.this.doOK(serverBean, null);
                    return;
                }
                SelectServerActivity selectServerActivity = SelectServerActivity.this;
                selectServerActivity.changeServerWithDialog(serverBean, selectServerActivity.mCurrentServer);
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener(z) {
            /* class com.xiaomi.smarthome.international.$$Lambda$SelectServerActivity$FQJLhuN7Q2ZL4HOTBJuKdwrthkI */
            private final /* synthetic */ boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                SelectServerActivity.this.O000000o(this.f$1, dialogInterface, i);
            }
        }).O00000o();
        this.O00000o0.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(boolean z, DialogInterface dialogInterface, int i) {
        if (z) {
            if (this.mCurrentServer == null) {
                this.mSelectedServerWhenNormal = this.mRecommendServer;
            } else {
                this.mSelectedServerWhenNormal = null;
            }
            O00000Oo();
            return;
        }
        super.onBackPressed();
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f9058O000000o;
        ImageView O00000Oo;

        O00000o0() {
        }
    }

    class O00000Oo extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        public final List<ServerBean> f9057O000000o = new ArrayList();
        private Context O00000o;
        private final LayoutInflater O00000o0;

        public final long getItemId(int i) {
            return (long) i;
        }

        public O00000Oo(Context context) {
            this.O00000o = context;
            this.O00000o0 = LayoutInflater.from(this.O00000o);
        }

        public final int getCount() {
            return this.f9057O000000o.size();
        }

        public final Object getItem(int i) {
            return this.f9057O000000o.get(i);
        }

        private String O000000o(int i) {
            return this.O00000o.getResources().getString(i);
        }

        private int O00000Oo(int i) {
            return this.O00000o.getResources().getColor(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            O00000o0 o00000o0;
            if (view == null) {
                view = this.O00000o0.inflate((int) R.layout.international_item, viewGroup, false);
                o00000o0 = new O00000o0();
                o00000o0.f9058O000000o = (TextView) view.findViewById(R.id.text);
                o00000o0.O00000Oo = (ImageView) view.findViewById(R.id.selected_mark);
                view.setTag(o00000o0);
            } else {
                o00000o0 = (O00000o0) view.getTag();
                o00000o0.f9058O000000o.setText("");
                o00000o0.f9058O000000o.setTextColor(O00000Oo(R.color.mj_color_gray_normal));
            }
            ServerBean serverBean = this.f9057O000000o.get(i);
            String str = serverBean.O00000o0;
            if (serverBean.O00000oO) {
                str = str + " " + O000000o(R.string.inter_current);
            }
            if (SelectServerActivity.this.mCurrentServer == null && serverBean.O00000o) {
                str = str + " " + O000000o(R.string.inter_recommend);
            }
            if (SelectServerActivity.this.isInSearchMode && SelectServerActivity.this.mSelectedServerWhenSearch != null && TextUtils.equals(SelectServerActivity.this.mSelectedServerWhenSearch.O00000Oo, serverBean.O00000Oo)) {
                o00000o0.f9058O000000o.setTextColor(O00000Oo(R.color.mj_color_green_normal));
                o00000o0.O00000Oo.setVisibility(0);
            } else if (!SelectServerActivity.this.isInSearchMode && SelectServerActivity.this.mSelectedServerWhenNormal != null && TextUtils.equals(SelectServerActivity.this.mSelectedServerWhenNormal.O00000Oo, serverBean.O00000Oo)) {
                o00000o0.f9058O000000o.setTextColor(O00000Oo(R.color.mj_color_green_normal));
                o00000o0.O00000Oo.setVisibility(0);
            } else if (!serverBean.O00000oO || ((SelectServerActivity.this.isInSearchMode && SelectServerActivity.this.mSelectedServerWhenSearch != null) || (!SelectServerActivity.this.isInSearchMode && SelectServerActivity.this.mSelectedServerWhenNormal != null))) {
                o00000o0.f9058O000000o.setTextColor(O00000Oo(R.color.mj_color_gray_heavier));
                o00000o0.O00000Oo.setVisibility(4);
            } else {
                o00000o0.f9058O000000o.setTextColor(O00000Oo(R.color.mj_color_green_normal));
                o00000o0.O00000Oo.setVisibility(0);
            }
            o00000o0.f9058O000000o.setText(str);
            view.setOnClickListener(new View.OnClickListener(serverBean, i) {
                /* class com.xiaomi.smarthome.international.$$Lambda$SelectServerActivity$O00000Oo$W0_CZAdrduQEGuLTCA5oWKDWxF8 */
                private final /* synthetic */ ServerBean f$1;
                private final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    SelectServerActivity.O00000Oo.this.O000000o(this.f$1, this.f$2, view);
                }
            });
            ViewGroup.LayoutParams layoutParams = view.findViewById(R.id.divider).getLayoutParams();
            if (layoutParams != null) {
                if (i == getCount() - 1) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 0;
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = gri.O000000o(24.0f);
                }
            }
            return view;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(ServerBean serverBean, int i, View view) {
            boolean z = (SelectServerActivity.this.isInSearchMode && SelectServerActivity.this.mSelectedServerWhenSearch == null) || (!SelectServerActivity.this.isInSearchMode && SelectServerActivity.this.mSelectedServerWhenNormal == null);
            if (!z || SelectServerActivity.this.mCurrentServer == null || !TextUtils.equals(SelectServerActivity.this.mCurrentServer.O00000Oo, serverBean.O00000Oo)) {
                if (z || SelectServerActivity.this.mCurrentServer == null || !TextUtils.equals(SelectServerActivity.this.mCurrentServer.O00000Oo, serverBean.O00000Oo)) {
                    SelectServerActivity.this.mSaveBtn.setEnabled(true);
                    if (SelectServerActivity.this.isInSearchMode) {
                        SelectServerActivity.this.mSelectedServerWhenSearch = this.f9057O000000o.get(i);
                    } else {
                        SelectServerActivity.this.mSelectedServerWhenNormal = this.f9057O000000o.get(i);
                    }
                    notifyDataSetChanged();
                } else {
                    SelectServerActivity.this.mSaveBtn.setEnabled(false);
                    if (SelectServerActivity.this.isInSearchMode) {
                        SelectServerActivity.this.mSelectedServerWhenSearch = null;
                    } else {
                        SelectServerActivity.this.mSelectedServerWhenNormal = null;
                    }
                    notifyDataSetChanged();
                }
            }
            if (SelectServerActivity.this.isInSearchMode) {
                ((InputMethodManager) SelectServerActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(SelectServerActivity.this.mSearchBox.getWindowToken(), 2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        XQProgressDialog xQProgressDialog = this.mProcessDialog;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
        MLAlertDialog mLAlertDialog = this.O00000o0;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.O00000o0.dismiss();
        }
        ft.O000000o(this.mContext).O000000o(new Intent("action_select_server_local_broadcast_complete_final"));
        Disposable disposable = this.O00000o;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void doOK(final ServerBean serverBean, final fsm<Void, fso> fsm) {
        if (serverBean == null) {
            finish();
            ft O000000o2 = ft.O000000o(this.mContext);
            Intent intent = new Intent("action_select_server_local_broadcast_complete");
            intent.putExtra("param_key", 2);
            O000000o2.O000000o(intent);
            return;
        }
        hje.O000000o();
        hje.O00000o();
        if (CoreApi.O000000o().O0000O0o()) {
            hxi.O00000o.O000000o(this.currentServerName, serverBean.O00000o0);
            CoreApi.O000000o().O000000o(serverBean, fsm);
        } else {
            IntentFilter intentFilter = new IntentFilter("ClientApiStub.onCoreReady");
            ft.O000000o(ServiceApplication.getAppContext()).O000000o(new BroadcastReceiver() {
                /* class com.xiaomi.smarthome.international.SelectServerActivity.AnonymousClass6 */

                public final void onReceive(Context context, Intent intent) {
                    ft.O000000o(ServiceApplication.getAppContext()).O000000o(this);
                    hxi.O00000o.O000000o(SelectServerActivity.this.currentServerName, serverBean.O00000o0);
                    CoreApi.O000000o().O000000o(serverBean, fsm);
                }
            }, intentFilter);
        }
        ezo.O000000o().unregisterPushService();
        finish();
        ft O000000o3 = ft.O000000o(this.mContext);
        Intent intent2 = new Intent("action_select_server_local_broadcast_complete");
        intent2.putExtra("param_key", 1);
        O000000o3.O000000o(intent2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view, boolean z) {
        if (z && !this.isInSearchMode) {
            this.isInSearchMode = true;
            this.f9046O000000o = this.O00000Oo.getFirstVisiblePosition();
            gsy.O00000Oo("SelectServerActivity", "enterSearchMode: " + this.f9046O000000o);
            if (Build.VERSION.SDK_INT >= 19) {
                AutoTransition autoTransition = new AutoTransition();
                autoTransition.setDuration(70L);
                TransitionManager.beginDelayedTransition((ViewGroup) getWindow().getDecorView(), autoTransition);
            }
            this.mSelectedServerWhenSearch = null;
            this.O00000oo.setVisibility(8);
            this.mSaveBtn.setEnabled(false);
            showServerList(Collections.emptyList(), -1);
        }
    }
}
