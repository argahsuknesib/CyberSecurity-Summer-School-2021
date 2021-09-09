package com.xiaomi.mico.setting;

import _m_j.gsy;
import _m_j.hxi;
import _m_j.jgc;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.MiBrain;
import com.xiaomi.mico.api.model.Payment;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.transformation.CircleTransformation;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.music.OpenQQMusicVIPView;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.manager.MusicSourceManager;
import com.xiaomi.mico.setting.adapter.QqMusicVipPriceAdapter;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.List;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class MusicAccountAuthInfoActivity extends MicoBaseActivity implements QqMusicVipPriceAdapter.SupportContractListener {
    ImageView avatar;
    public String cp;
    CheckedTextView ctvRenewal;
    ImageView iconMusicIntro;
    ImageView ivGreenDiamondStatus;
    public QqMusicVipPriceAdapter musicAccountAdapter;
    TextView name;
    RecyclerView rlPrice;
    TextView time;
    TitleBar titleBar;
    TextView tvVipStatus;

    static /* synthetic */ void lambda$showLogoutAlert$2(DialogInterface dialogInterface, int i) {
    }

    public static void start(Context context, String str, String str2) {
        Intent intent = new Intent(context, MusicAccountAuthInfoActivity.class);
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        intent.putExtra("MUSIC_CP", str);
        intent.putExtra("FROM_PAGE", str2);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cp = getIntent().getStringExtra("MUSIC_CP");
        if ("kkbox".equals(this.cp)) {
            setContentView((int) R.layout.activity_kk_box_account);
        } else {
            setContentView((int) R.layout.activity_qq_music_account);
        }
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.avatar = (ImageView) findViewById(R.id.avatar);
        this.name = (TextView) findViewById(R.id.name);
        this.time = (TextView) findViewById(R.id.left_time);
        this.iconMusicIntro = (ImageView) findViewById(R.id.icon_music_intro);
        this.rlPrice = (RecyclerView) findViewById(R.id.rlPrice);
        this.ivGreenDiamondStatus = (ImageView) findViewById(R.id.ivGreenDiamondStatus);
        this.tvVipStatus = (TextView) findViewById(R.id.tvVipStatus);
        this.ctvRenewal = (CheckedTextView) findViewById(R.id.ctvRenewal);
        View findViewById = findViewById(R.id.tvOpenNow);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.setting.$$Lambda$MusicAccountAuthInfoActivity$bR3y2JReJz7qeTEm_CZU3uOY0 */

                public final void onClick(View view) {
                    MusicAccountAuthInfoActivity.this.lambda$onCreate$0$MusicAccountAuthInfoActivity(view);
                }
            });
        }
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$QESKostXRLeUkBtMbVCGVejhHSU */

            public final void onLeftIconClick() {
                MusicAccountAuthInfoActivity.this.finish();
            }
        });
        this.titleBar.setOnRightIconClickListener(new TitleBar.OnRightIconClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$MusicAccountAuthInfoActivity$LDKDtoiyl0GzC3y14bhtEZM1Q8 */

            public final void onRightIconClick() {
                MusicAccountAuthInfoActivity.this.showLogout();
            }
        });
        final AccountProfile current = AccountProfile.current();
        if ("kkbox".equals(this.cp)) {
            ImageView imageView = this.iconMusicIntro;
            if (imageView != null) {
                imageView.setBackgroundResource(R.drawable.account_kkbox_right);
            }
            current.getKkboxAccountInfo().observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() {
                /* class com.xiaomi.mico.setting.$$Lambda$MusicAccountAuthInfoActivity$oNcDPEo4zQIRfPktK3MpvfeXRYY */

                public final void call(Object obj) {
                    MusicAccountAuthInfoActivity.this.setAccountInfo((MiBrain.CPAccountInfo) obj);
                }
            }, $$Lambda$VwEsfx9iAZ1xxqB42DOjLprjGzg.INSTANCE);
        } else {
            initQQLeftTime();
            current.getQQAccountInfo().observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() {
                /* class com.xiaomi.mico.setting.$$Lambda$MusicAccountAuthInfoActivity$oNcDPEo4zQIRfPktK3MpvfeXRYY */

                public final void call(Object obj) {
                    MusicAccountAuthInfoActivity.this.setAccountInfo((MiBrain.CPAccountInfo) obj);
                }
            }, $$Lambda$VwEsfx9iAZ1xxqB42DOjLprjGzg.INSTANCE);
            if (this.rlPrice != null) {
                this.musicAccountAdapter = new QqMusicVipPriceAdapter(this);
                this.rlPrice.setAdapter(this.musicAccountAdapter);
            }
            getQQMusicVIPPriceList();
        }
        current.syncQQBindStatus(new ApiRequest.Listener<MiBrain.CPBindStatus>() {
            /* class com.xiaomi.mico.setting.MusicAccountAuthInfoActivity.AnonymousClass1 */

            public void onFailure(ApiError apiError) {
            }

            public void onSuccess(MiBrain.CPBindStatus cPBindStatus) {
                if ("kkbox".equals(MusicAccountAuthInfoActivity.this.cp)) {
                    if (!current.isKKBoxAuthValid()) {
                        MusicAccountAuthInfoActivity.this.finish();
                    }
                } else if (!current.isQQAccountAuthValid()) {
                    MusicAccountAuthInfoActivity.this.finish();
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        refreshQQMusicMemberStatus();
        hxi.O00000o0.f957O000000o.O000000o("content_qqmusic_buy", new Object[0]);
    }

    /* renamed from: onClick */
    public void lambda$onCreate$0$MusicAccountAuthInfoActivity(View view) {
        QqMusicVipPriceAdapter qqMusicVipPriceAdapter;
        if (view.getId() == R.id.tvOpenNow && (qqMusicVipPriceAdapter = this.musicAccountAdapter) != null) {
            qqMusicVipPriceAdapter.startPaymentWebActivity(this);
            hxi.O00000o.f952O000000o.O000000o("content_qqmusic_open now", new Object[0]);
        }
    }

    private void getQQMusicVIPPriceList() {
        ApiHelper.getQQMusicVIPPriceList(new ApiRequest.Listener<List<Payment.PriceItem>>() {
            /* class com.xiaomi.mico.setting.MusicAccountAuthInfoActivity.AnonymousClass2 */

            public void onFailure(ApiError apiError) {
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Payment.PriceItem>) ((List) obj));
            }

            public void onSuccess(List<Payment.PriceItem> list) {
                if (MusicAccountAuthInfoActivity.this.musicAccountAdapter != null) {
                    MusicAccountAuthInfoActivity.this.musicAccountAdapter.setData(list);
                }
            }
        });
    }

    private void refreshQQMusicMemberStatus() {
        if (!"kkbox".equals(this.cp)) {
            ApiHelper.getQQMusicMemberStatus(new ApiRequest.Listener<Payment.MemberStatus>() {
                /* class com.xiaomi.mico.setting.MusicAccountAuthInfoActivity.AnonymousClass3 */

                @SuppressLint({"StringFormatInvalid"})
                public void onSuccess(Payment.MemberStatus memberStatus) {
                    String str;
                    int i;
                    boolean isVipOpened = memberStatus.isVipOpened();
                    OpenQQMusicVIPView.cachedVipOpenStatus = Boolean.valueOf(isVipOpened);
                    if (isVipOpened) {
                        i = R.drawable.icon_green_diamond;
                        String vipEndTime = memberStatus.getVipEndTime();
                        if (ContainerUtil.isEmpty(vipEndTime)) {
                            str = "";
                        } else {
                            str = String.format(MusicAccountAuthInfoActivity.this.getContext().getResources().getString(R.string.qq_music_account_expire_date), vipEndTime);
                        }
                    } else {
                        i = R.drawable.icon_no_green_diamond;
                        str = MusicAccountAuthInfoActivity.this.getContext().getResources().getString(R.string.qq_music_account_vip_no_open);
                    }
                    if (MusicAccountAuthInfoActivity.this.tvVipStatus != null) {
                        MusicAccountAuthInfoActivity.this.tvVipStatus.setText(str);
                    }
                    if (MusicAccountAuthInfoActivity.this.ivGreenDiamondStatus != null) {
                        MusicAccountAuthInfoActivity.this.ivGreenDiamondStatus.setImageResource(i);
                    }
                }

                public void onFailure(ApiError apiError) {
                    if (MusicAccountAuthInfoActivity.this.tvVipStatus != null) {
                        MusicAccountAuthInfoActivity.this.tvVipStatus.setText((int) R.string.qq_music_account_vip_no_open);
                    }
                    if (MusicAccountAuthInfoActivity.this.ivGreenDiamondStatus != null) {
                        MusicAccountAuthInfoActivity.this.ivGreenDiamondStatus.setImageResource(R.drawable.icon_no_green_diamond);
                    }
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public void setAccountInfo(MiBrain.CPAccountInfo cPAccountInfo) {
        if ("kkbox".equals(this.cp)) {
            this.time.setText(MiBrain.KKBoxLevel.value(cPAccountInfo.memberLevel).getResid());
        }
        this.name.setText(cPAccountInfo.nickName);
        Picasso.get().load(cPAccountInfo.headImgUrl).transform(new CircleTransformation()).into(this.avatar);
    }

    private void initQQLeftTime() {
        final MiBrain.CPBindStatus qQBindStatus = AccountProfile.current().getQQBindStatus();
        if (qQBindStatus != null) {
            this.time.setText(String.format(getString(R.string.qq_account_rebind_tip), Integer.valueOf(qQBindStatus.willExpireDay())));
            return;
        }
        AccountProfile.current().syncQQBindStatus(new ApiRequest.Listener<MiBrain.CPBindStatus>() {
            /* class com.xiaomi.mico.setting.MusicAccountAuthInfoActivity.AnonymousClass4 */

            public void onFailure(ApiError apiError) {
            }

            public void onSuccess(MiBrain.CPBindStatus cPBindStatus) {
                MusicAccountAuthInfoActivity.this.time.setText(String.format(MusicAccountAuthInfoActivity.this.getString(R.string.qq_account_rebind_tip), Integer.valueOf(qQBindStatus.willExpireDay())));
            }
        });
    }

    /* access modifiers changed from: private */
    public void showLogout() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(getContext());
        $$Lambda$MusicAccountAuthInfoActivity$Lyv1p4ygEl_zYgmWZxC4ThZx5Yo r1 = new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$MusicAccountAuthInfoActivity$Lyv1p4ygEl_zYgmWZxC4ThZx5Yo */

            public final void onClick(DialogInterface dialogInterface, int i) {
                MusicAccountAuthInfoActivity.this.lambda$showLogout$1$MusicAccountAuthInfoActivity(dialogInterface, i);
            }
        };
        builder.f9096O000000o.O0000oo0 = builder.f9096O000000o.f9086O000000o.getResources().getTextArray(R.array.qq_music_delete_oath);
        builder.f9096O000000o.O0000ooO = r1;
        builder.O00000o().show();
    }

    public /* synthetic */ void lambda$showLogout$1$MusicAccountAuthInfoActivity(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            showLogoutAlert();
        }
    }

    private void deleteOAuto() {
        MiBrain.CPBindStatus cPBindStatus;
        this.cp = getIntent().getStringExtra("MUSIC_CP");
        if ("kkbox".equals(this.cp)) {
            cPBindStatus = AccountProfile.current().getKkboxBindStatus();
        } else {
            cPBindStatus = AccountProfile.current().getQQBindStatus();
        }
        if (cPBindStatus != null) {
            ApiHelper.deleteOAuthInfo(cPBindStatus.providerId(), new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.setting.MusicAccountAuthInfoActivity.AnonymousClass5 */

                public void onSuccess(String str) {
                    if ("kkbox".equals(MusicAccountAuthInfoActivity.this.cp)) {
                        AccountProfile.current().setKkboxBindStatus(null);
                        AccountProfile.current().setKkboxAccountInfo(null);
                    } else {
                        AccountProfile.current().setQQBindStatus(null);
                        AccountProfile.current().setQQAccountInfo(null);
                    }
                    jgc.O000000o().O00000oO(new MusicEvent.CPAccountBindStatusChanged(true));
                    MusicSourceManager.sendCpAccountBindStatusChanged(false);
                    AccountProfile.current().syncQQBindStatus();
                    MusicAccountAuthInfoActivity.this.finish();
                }

                public void onFailure(ApiError apiError) {
                    if (!"kkbox".equals(MusicAccountAuthInfoActivity.this.cp)) {
                        gsy.O00000Oo(12000, "12000.6.2", "");
                    }
                    ToastUtil.showToast((int) R.string.error_oauth_delete_error);
                }
            });
        }
    }

    private void syncQQBindStatus() {
        AccountProfile.current().syncQQBindStatus(new ApiRequest.Listener<MiBrain.CPBindStatus>() {
            /* class com.xiaomi.mico.setting.MusicAccountAuthInfoActivity.AnonymousClass6 */

            public void onSuccess(MiBrain.CPBindStatus cPBindStatus) {
                MusicAccountAuthInfoActivity.this.finish();
            }

            public void onFailure(ApiError apiError) {
                MusicAccountAuthInfoActivity.this.finish();
            }
        });
    }

    private void showLogoutAlert() {
        new MLAlertDialog.Builder(this).O000000o((int) R.string.mico_common_hint).O00000Oo((int) R.string.qq_account_logout_tip).O00000Oo((int) R.string.common_cancel, $$Lambda$MusicAccountAuthInfoActivity$zXZNyp6MNdaAJ8e3TJeop1Cz5I.INSTANCE).O000000o((int) R.string.common_confirm, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$MusicAccountAuthInfoActivity$PPL_6Ldzp8vbG60nMn37YsfbDN0 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                MusicAccountAuthInfoActivity.this.lambda$showLogoutAlert$3$MusicAccountAuthInfoActivity(dialogInterface, i);
            }
        }).O00000oo();
    }

    public /* synthetic */ void lambda$showLogoutAlert$3$MusicAccountAuthInfoActivity(DialogInterface dialogInterface, int i) {
        deleteOAuto();
    }

    public void onSupportContractChanged(Payment.PriceItem priceItem) {
        if (this.ctvRenewal != null) {
            boolean hasData = ContainerUtil.hasData(priceItem.contractDesc);
            this.ctvRenewal.setVisibility(hasData ? 0 : 4);
            if (hasData) {
                this.ctvRenewal.setText(priceItem.contractDesc);
            }
        }
    }
}
