package com.xiaomi.mico.module.update;

import _m_j.ahg;
import _m_j.ahh;
import _m_j.gfr;
import _m_j.gsy;
import _m_j.jgc;
import _m_j.jgi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.application.MicoEvent;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.micobuild.BuildSettings;
import com.xiaomi.mico.common.util.PreferenceUtils;
import com.xiaomi.mico.common.util.VersionUtils;
import com.xiaomi.mico.common.util.jobqueue.JobQueueManager;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.module.update.UpdateItemView;
import com.xiaomi.mico.module.update.UpdatePresenter;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class UpdateAssistantActivity extends MicoBaseActivity implements UpdateItemView.OnUpdateRefreshListener, UpdatePresenter.IUpdateView {
    TextView checkBtn;
    private String description;
    private boolean forceUpgrade;
    ahg loggerNew = new ahg();
    private UpdateAdapter mAdapter;
    private boolean mHasConflict;
    private UpdatePresenter mPresenter;
    TitleBar mTitleBar;
    public List<UpdatePresenter.UpdateInfo> mUpdateInfos;
    TextView updateBtn;
    TextView upgradeHint;
    ImageView upgradeIcon;
    ListView upgradeListview;

    public UpdateAssistantActivity() {
        new ahh();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jgc.O000000o().O000000o(this);
        setContentView((int) R.layout.update_assistant_activity);
        this.upgradeIcon = (ImageView) findViewById(R.id.upgrade_icon);
        this.upgradeListview = (ListView) findViewById(R.id.upgrade_listview);
        this.updateBtn = (TextView) findViewById(R.id.update_btn);
        this.updateBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.module.update.$$Lambda$UpdateAssistantActivity$fqIGQBnJPMk0VngycGtNQjBOEWw */

            public final void onClick(View view) {
                UpdateAssistantActivity.this.lambda$onCreate$0$UpdateAssistantActivity(view);
            }
        });
        this.checkBtn = (TextView) findViewById(R.id.check_btn);
        this.checkBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.module.update.$$Lambda$UpdateAssistantActivity$xzxB7K7Au_HbiRHnbsYq80eeLIs */

            public final void onClick(View view) {
                UpdateAssistantActivity.this.lambda$onCreate$1$UpdateAssistantActivity(view);
            }
        });
        this.mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        this.upgradeHint = (TextView) findViewById(R.id.upgrade_hint);
        Intent intent = getIntent();
        if (intent != null) {
            this.forceUpgrade = intent.getBooleanExtra("force_upgrade", false);
        }
        this.mTitleBar.showLeftIcon(!this.forceUpgrade);
        this.mTitleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.module.update.UpdateAssistantActivity.AnonymousClass1 */

            public void onLeftIconClick() {
                UpdateAssistantActivity.this.onBackPressed();
            }
        });
        this.mPresenter = new UpdatePresenter(this, this);
        this.mAdapter = new UpdateAdapter();
        this.upgradeListview.setAdapter((ListAdapter) this.mAdapter);
        gsy.O000000o(3, "JiangLiang", "oncreate start check");
        this.mPresenter.startCheck();
        jgc.O000000o().O00000o(new MicoEvent.UpdateAssistant(false));
        PreferenceUtils.setSettingBoolean(this, "key_neepupdate_track_point_state", false);
    }

    public /* synthetic */ void lambda$onCreate$0$UpdateAssistantActivity(View view) {
        onUpdateBtnClick();
    }

    public /* synthetic */ void lambda$onCreate$1$UpdateAssistantActivity(View view) {
        onCheckBtnClick();
    }

    /* access modifiers changed from: package-private */
    public void onCheckBtnClick() {
        this.mPresenter.startCheck();
        gsy.O000000o(3, "JiangLiang", "onCheckBtnClick start check");
    }

    /* access modifiers changed from: package-private */
    public void onUpdateBtnClick() {
        this.mPresenter.upgradeAll();
        this.mAdapter.notifyDataSetChanged();
        this.updateBtn.setEnabled(false);
        this.mTitleBar.showLeftIcon(true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mTitleBar.getLeftIcon().getVisibility() == 0 || i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void onCheckComplete(boolean z, List<UpdatePresenter.UpdateInfo> list) {
        boolean z2 = true;
        ahg.O00000Oo("UpdateAssistantActivity onCheckComplete");
        dismissProgressDialog();
        if (this.description == null) {
            if (list != null) {
                Iterator<UpdatePresenter.UpdateInfo> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    UpdatePresenter.UpdateInfo next = it.next();
                    if (next.hasUpdate() && next.getOnlineStatus() == UpdatePresenter.OnlineStatus.ONLINE) {
                        break;
                    }
                }
            }
            z2 = false;
            if (!z2) {
                if (!JobQueueManager.instance().hasJob(RomUpgradeJob.class)) {
                    Toast.makeText(getContext(), (int) R.string.update_no_update, 0).show();
                }
                this.updateBtn.setVisibility(8);
                this.checkBtn.setVisibility(0);
            } else {
                this.updateBtn.setVisibility(0);
                this.checkBtn.setVisibility(8);
            }
            this.mHasConflict = z;
            if (z) {
                this.upgradeIcon.setImageResource(R.drawable.update_tips_icon_attention);
                this.upgradeHint.setVisibility(0);
                this.upgradeHint.setText((int) R.string.tool_update_conflict);
                return;
            }
            this.upgradeIcon.setImageResource(R.drawable.update_tips_icon_update);
            this.upgradeHint.setVisibility(8);
        }
    }

    public void onCheckStart() {
        showProgressDialog(getString(R.string.update_device_checking), true, null);
    }

    public void onRefreshUpdateInfo(boolean z, List<UpdatePresenter.UpdateInfo> list) {
        this.mUpdateInfos = list;
        for (UpdatePresenter.UpdateInfo versionInfo : list) {
            ThirdPartyResponse.VersionInfo versionInfo2 = versionInfo.getVersionInfo();
        }
        this.mAdapter.notifyDataSetChanged();
    }

    public void onDestroy() {
        super.onDestroy();
        jgc.O000000o().O00000o0(this);
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onMessageEvent(UpgradeEvent upgradeEvent) {
        this.updateBtn.setEnabled(this.mPresenter.hasUpdate());
    }

    public void onRefreshLeftIcon() {
        if (this.mTitleBar.getLeftIcon().getVisibility() == 8) {
            this.mTitleBar.showLeftIcon(true);
        }
    }

    public void onUpdateSuccess() {
        this.upgradeIcon.setImageResource(R.drawable.update_tips_icon_update);
        this.upgradeHint.setVisibility(8);
    }

    public void onUpgrading(boolean z) {
        String str = this.description;
        if (str != null && z) {
            this.upgradeHint.setText(str);
            this.upgradeHint.setVisibility(0);
            this.description = null;
        }
    }

    class UpdateAdapter extends BaseAdapter {
        public long getItemId(int i) {
            return 0;
        }

        UpdateAdapter() {
        }

        public int getCount() {
            if (UpdateAssistantActivity.this.mUpdateInfos == null) {
                return 0;
            }
            return UpdateAssistantActivity.this.mUpdateInfos.size();
        }

        public Object getItem(int i) {
            return UpdateAssistantActivity.this.mUpdateInfos.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(UpdateAssistantActivity.this.getContext()).inflate((int) R.layout.update_assistant_item_view, viewGroup, false);
            }
            UpdateItemView updateItemView = (UpdateItemView) view;
            UpdatePresenter.UpdateInfo updateInfo = (UpdatePresenter.UpdateInfo) getItem(i);
            ThirdPartyResponse.VersionInfo versionInfo = updateInfo.getVersionInfo();
            if (versionInfo != null && versionInfo.forceOta) {
                updateItemView.setOnRefreshUIListener(UpdateAssistantActivity.this);
            }
            updateItemView.bindData(updateInfo);
            return view;
        }
    }

    public static void showUpdateDlg(Context context, ThirdPartyResponse.GrayUpgradeResponse grayUpgradeResponse) {
        new MLAlertDialog.Builder(context).O000000o((int) R.string.update_has_update).O00000Oo(grayUpgradeResponse.data.updateInfo.description).O00000Oo((int) R.string.common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.module.update.UpdateAssistantActivity.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).O000000o((int) R.string.mico_update_upgrade, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.module.update.UpdateAssistantActivity.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).O00000o().show();
    }

    public static void checkConflict(final Context context) {
        String str;
        if (gfr.O0000OOo) {
            ApiHelper.getDailyAppUpgradeInfo("", "", "", "", "").observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<ThirdPartyResponse.GrayUpgradeResponse>() {
                /* class com.xiaomi.mico.module.update.UpdateAssistantActivity.AnonymousClass4 */

                public final void call(ThirdPartyResponse.GrayUpgradeResponse grayUpgradeResponse) {
                    if (Integer.valueOf(grayUpgradeResponse.data.updateInfo.version).intValue() > VersionUtils.getVersionCode(context)) {
                        UpdateAssistantActivity.showUpdateDlg(context, grayUpgradeResponse);
                        jgc.O000000o().O00000o(new MicoEvent.UpdateAssistant(true));
                    }
                }
            }, new Action1<Throwable>() {
                /* class com.xiaomi.mico.module.update.UpdateAssistantActivity.AnonymousClass5 */

                public final void call(Throwable th) {
                    Object[] objArr = {"", th};
                }
            });
        }
        try {
            str = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception e) {
            Object[] objArr = {"", e};
            e.printStackTrace();
            str = "0";
        }
        if (MicoManager.getInstance().getMicoList() != null) {
            ArrayList arrayList = new ArrayList();
            for (Admin.Mico next : MicoManager.getInstance().getMicoList()) {
                if (next.isOnline()) {
                    arrayList.add(next.deviceID);
                }
            }
            ApiHelper.getUpdateInfo(BuildSettings.getReleaseChannelNew(context), str, LoginManager.getInstance().getPassportInfo().getUserId(), context.getResources().getConfiguration().locale.toString(), arrayList).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<ThirdPartyResponse.UpdateResponse>() {
                /* class com.xiaomi.mico.module.update.UpdateAssistantActivity.AnonymousClass6 */

                public final void call(ThirdPartyResponse.UpdateResponse updateResponse) {
                    boolean needForceUpgrade = updateResponse.data.needForceUpgrade();
                    if (updateResponse.data.conflict || needForceUpgrade) {
                        Intent intent = new Intent(context, UpdateAssistantActivity.class);
                        intent.putExtra("force_upgrade", needForceUpgrade);
                        context.startActivity(intent);
                    }
                    jgc.O000000o().O00000o(new MicoEvent.UpdateAssistant(updateResponse.data.hasUpgrade()));
                }
            }, new Action1<Throwable>() {
                /* class com.xiaomi.mico.module.update.UpdateAssistantActivity.AnonymousClass7 */

                public final void call(Throwable th) {
                    ahh.O000000o(th);
                }
            });
        }
    }
}
