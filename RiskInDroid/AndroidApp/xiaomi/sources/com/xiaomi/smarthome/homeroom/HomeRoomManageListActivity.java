package com.xiaomi.smarthome.homeroom;

import _m_j.awq;
import _m_j.axl;
import _m_j.axx;
import _m_j.fso;
import _m_j.ft;
import _m_j.ggb;
import _m_j.ghl;
import _m_j.gqg;
import _m_j.gwg;
import _m_j.hxi;
import _m_j.hzf;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.ArrayList;
import java.util.List;

public class HomeRoomManageListActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    protected RecyclerView f8898O000000o;
    protected RecyclerViewExpandableItemManager O00000Oo;
    protected axl O00000o;
    protected axx O00000o0;
    protected RecyclerView.O000000o O00000oO;
    protected LinearLayoutManager O00000oo;
    protected TextView O0000O0o;
    private View O0000OOo;
    private View O0000Oo;
    private ImageView O0000Oo0;
    private View O0000OoO;
    private TextView O0000Ooo;
    private boolean O0000o0 = false;
    private BroadcastReceiver O0000o00 = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("operation");
            if (TextUtils.equals(stringExtra, "home_room_room_deleted") || TextUtils.equals(stringExtra, "home_room_room_added")) {
                HomeRoomManageListActivity.this.updateUI();
                return;
            }
            HomeRoomManageListActivity.this.mHandler.removeCallbacksAndMessages(null);
            HomeRoomManageListActivity.this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeRoomManageListActivity$1$8YHLCRX7VwTlzRXqN198TQQnk10 */

                public final void run() {
                    HomeRoomManageListActivity.AnonymousClass1.this.O000000o();
                }
            }, 1000);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o() {
            HomeRoomManageListActivity.this.updateUI();
        }
    };
    public ghl mAdapter;
    public ImageView mBtnEditCancel;
    public ImageView mBtnEditSelectAll;
    public boolean mEnterSort = false;
    public long mEnterSortTime;
    public String mHomeID = null;
    public View titleBar;

    public static void startActivity(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, HomeRoomManageListActivity.class);
            intent.putExtra("home_id", str);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_manage_home_room_list);
        this.mHomeID = getIntent().getStringExtra("home_id");
        if (TextUtils.isEmpty(this.mHomeID)) {
            this.mHomeID = ggb.O00000Oo().O0000OOo();
        }
        ft.O000000o(this).O000000o(this.O0000o00, new IntentFilter("home_room_updated"));
        this.O0000Oo0 = (ImageView) findViewById(R.id.module_a_3_right_img_btn);
        this.O0000Oo0.setOnClickListener(this);
        this.O0000Oo0.setContentDescription(getString(R.string.edit));
        this.O0000Oo = findViewById(R.id.add_room);
        this.O0000Oo.setOnClickListener(this);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.home_manager);
        this.O0000OOo = findViewById(R.id.module_a_3_return_btn);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass4 */

            public final void onClick(View view) {
                HomeRoomManageListActivity.this.finish();
            }
        });
        this.O0000OoO = findViewById(R.id.empty);
        this.O0000Ooo = (TextView) findViewById(R.id.no_login_tv);
        ((ImageView) findViewById(R.id.iv_empty_image)).setImageResource(R.drawable.emptypage_icon_empty_nor);
        this.f8898O000000o = (RecyclerView) findViewById(R.id.recycler_view);
        this.f8898O000000o.setOnScrollListener(new RecyclerView.O00oOooO() {
            /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass6 */

            public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                View currentFocus;
                super.onScrollStateChanged(recyclerView, i);
                if (i != 0 && HomeRoomManageListActivity.this.isValid() && (currentFocus = HomeRoomManageListActivity.this.getCurrentFocus()) != null) {
                    currentFocus.clearFocus();
                }
            }
        });
        this.O00000Oo = new RecyclerViewExpandableItemManager();
        this.O00000o = new axl();
        this.mAdapter = new ghl(this);
        this.mAdapter.O00000oO = new ghl.O000000o() {
            /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass7 */

            public final void O000000o() {
                HomeRoomManageListActivity homeRoomManageListActivity = HomeRoomManageListActivity.this;
                homeRoomManageListActivity.mEnterSort = true;
                homeRoomManageListActivity.enterEditMode();
                HomeRoomManageListActivity.this.mAdapter.O00000Oo();
                HomeRoomManageListActivity.this.mBtnEditSelectAll.setImageResource(R.drawable.title_right_tick_drawable);
                HomeRoomManageListActivity.this.O0000O0o.setText((int) R.string.menu_edit_sort);
                HomeRoomManageListActivity.this.mBtnEditCancel.setImageResource(R.drawable.title_cancel_selector);
                HomeRoomManageListActivity.this.mEnterSortTime = hxi.O00000o0.O00000oO(0L);
            }
        };
        this.mAdapter.O00000oo = new ghl.O00000Oo() {
            /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass8 */

            public final void O000000o() {
                HomeRoomManageListActivity.this.showDeleteDialog();
            }
        };
        this.O00000oO = this.O00000Oo.O000000o(this.mAdapter);
        this.O00000oO = this.O00000o.O000000o(this.O00000oO);
        this.O00000oo = new LinearLayoutManager(this);
        awq awq = new awq();
        awq.O0000o00 = false;
        this.f8898O000000o.setLayoutManager(this.O00000oo);
        this.f8898O000000o.setAdapter(this.O00000oO);
        this.f8898O000000o.setItemAnimator(awq);
        this.f8898O000000o.setHasFixedSize(false);
        this.O00000o0 = new axx();
        axx axx = this.O00000o0;
        axx.O0000OOo = true;
        axx.O00000Oo();
        this.O00000o0.O000000o(this.f8898O000000o);
        this.O00000o.O000000o(this.f8898O000000o);
        axl axl = this.O00000o;
        axl.O0000o00 = true;
        axl.O0000Oo0 = (NinePatchDrawable) getContext().getResources().getDrawable(R.drawable.std_list_item_drag_shadow);
        axl axl2 = this.O00000o;
        axl2.O0000o0 = true;
        axl2.O0000o0O = (int) (((float) ViewConfiguration.getLongPressTimeout()) * 1.5f);
        this.O00000o.O00oOooO = new axl.O00000Oo() {
            /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass9 */
        };
        this.f8898O000000o.setBackgroundColor(getResources().getColor(R.color.mj_color_white));
        this.O00000Oo.O000000o(this.f8898O000000o);
        this.O00000Oo.O000000o();
        ggb O00000Oo2 = ggb.O00000Oo();
        if (O00000Oo2.O0000Oo0() == null || O00000Oo2.O0000Oo0().getRoomList().size() > 0) {
            z = false;
        } else {
            SharedPreferences sharedPreferences = ServiceApplication.getAppContext().getSharedPreferences("home_room_transfer_state", 0);
            z = sharedPreferences.getBoolean("multihome_first_guide" + O00000Oo2.O0000OOo(), false);
        }
        if (z && ggb.O00000Oo().O0000OoO.O00000Oo.size() > 1) {
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass5 */

                public final void run() {
                    new MLAlertDialog.Builder(HomeRoomManageListActivity.this).O00000o0().O00000Oo((int) R.string.setting_after, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass5.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).O000000o((int) R.string.setting_now, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass5.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            HomeRoomRecommendActivity.startActivity(HomeRoomManageListActivity.this.getContext(), HomeRoomManageListActivity.this.mHomeID);
                        }
                    }).O00000Oo((int) R.string.message_multihome_guide).O00000oo();
                }
            }, 350);
            SharedPreferences.Editor edit = CommonApplication.getAppContext().getSharedPreferences("home_room_transfer_state", 0).edit();
            edit.remove("multihome_first_guide" + ggb.O00000Oo().O0000OOo()).commit();
        }
        updateUI();
        ggb.O00000Oo().O00000o0();
    }

    public void updateUI() {
        this.mAdapter.O000000o(ggb.O00000Oo().O00000o(this.mHomeID));
        if (this.mAdapter.O000000o() == 0) {
            this.O0000OoO.setVisibility(0);
            this.O0000Ooo.setText(Html.fromHtml(getResources().getString(R.string.empty_room_hint)));
            this.O0000Ooo.setOnClickListener(this);
            this.f8898O000000o.setVisibility(8);
            this.O0000Oo0.setEnabled(false);
            return;
        }
        this.O0000OoO.setVisibility(8);
        this.f8898O000000o.setVisibility(0);
        this.O0000Oo0.setEnabled(true);
    }

    public void onResume() {
        super.onResume();
        if (this.mAdapter != null) {
            updateUI();
        }
        hxi.O00000o0.O00000o(0L);
    }

    public void onDestroy() {
        super.onDestroy();
        ft.O000000o(this).O000000o(this.O0000o00);
    }

    public void onBackPressed() {
        if (this.O0000o0) {
            exitEditMode();
        } else {
            finish();
        }
    }

    public void onPause() {
        super.onPause();
        hxi.O00000o0.O00000o(this.mEnterTime);
    }

    public void enterEditMode() {
        if (!this.O0000o0 && this.mAdapter.O00000o() > 0) {
            try {
                this.O0000Oo.setVisibility(8);
                if (this.titleBar == null) {
                    this.titleBar = ((ViewStub) findViewById(R.id.title_bar_choose_device_stub)).inflate();
                    this.titleBar.setBackgroundResource(R.color.mj_color_white);
                    this.mBtnEditCancel = (ImageView) this.titleBar.findViewById(16908314);
                    this.mBtnEditCancel.setOnClickListener(this);
                    this.mBtnEditCancel.setContentDescription(getString(R.string.sh_common_cancel));
                    this.mBtnEditSelectAll = (ImageView) this.titleBar.findViewById(16908313);
                    this.mBtnEditSelectAll.setContentDescription(getString(R.string.confirm_button));
                    this.mBtnEditSelectAll.setOnClickListener(this);
                    this.O0000O0o = (TextView) this.titleBar.findViewById(R.id.module_a_4_return_more_title);
                    gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), findViewById(R.id.title_bar_choose_device));
                }
                this.titleBar.setVisibility(0);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.titleBar, View.Y, -getResources().getDimension(R.dimen.titlebar_height), 0.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.play(ofFloat);
                animatorSet.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.O0000o0 = true;
            ghl ghl = this.mAdapter;
            ghl.O0000O0o = true;
            ghl.O00000o0.clear();
            ghl.O00000o.clear();
            ghl.notifyDataSetChanged();
        }
    }

    public void exitEditMode() {
        if (this.O0000o0) {
            this.O0000Oo.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.titleBar, View.Y, 0.0f, (float) (-this.titleBar.getHeight()));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            if (this.mEnterSort) {
                animatorSet.play(ofFloat);
                this.mAdapter.O000000o(false);
                hxi.O00000o0.O00000oO(this.mEnterSortTime);
            }
            animatorSet.start();
            animatorSet.addListener(new Animator.AnimatorListener() {
                /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass10 */

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    HomeRoomManageListActivity.this.titleBar.clearAnimation();
                    HomeRoomManageListActivity.this.titleBar.setVisibility(8);
                }
            });
            this.O0000o0 = false;
            this.mEnterSort = false;
            ghl ghl = this.mAdapter;
            ghl.O0000O0o = false;
            ghl.O0000OOo = false;
            ghl.O00000o0.clear();
            ghl.O00000o.clear();
            ghl.notifyDataSetChanged();
        }
    }

    public void showDeleteDialog() {
        new MLAlertDialog.Builder(this).O00000Oo(getString(R.string.room_remove_confirm)).O00000o0().O000000o((int) R.string.tag_remove, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ArrayList arrayList = new ArrayList(HomeRoomManageListActivity.this.mAdapter.O00000o0);
                if (arrayList.size() == 1) {
                    ggb.O00000Oo().O000000o(ggb.O00000Oo().O00000o0((String) arrayList.get(0)), new ggb.O00000o() {
                        /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass3.AnonymousClass1 */

                        public final void O000000o() {
                        }

                        public final void O000000o(int i, fso fso) {
                            gqg.O00000Oo((int) R.string.room_delete_failed);
                        }
                    });
                } else if (arrayList.size() > 1) {
                    ggb.O00000Oo().O000000o(arrayList, new ggb.O00000o() {
                        /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass3.AnonymousClass2 */

                        public final void O000000o() {
                        }

                        public final void O000000o(int i, fso fso) {
                            gqg.O00000Oo((int) R.string.room_delete_failed);
                        }
                    });
                }
                hxi.O00000o.f952O000000o.O000000o("page_roomadjust_confirm", new Object[0]);
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                hxi.O00000o.O00000oO();
            }
        }).O000000o(getResources().getColor(R.color.mj_color_red_normal), -1).O000000o(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.homeroom.HomeRoomManageListActivity.AnonymousClass11 */

            public final void onCancel(DialogInterface dialogInterface) {
                HomeRoomManageListActivity.this.mAdapter.O00000o0();
                hxi.O00000o.O00000oO();
            }
        }).O00000oo().getButton(-1).setBackgroundResource(R.drawable.normal_denied_button);
    }

    public void onClick(View view) {
        if (view == this.mBtnEditCancel) {
            exitEditMode();
        } else if (view == this.mBtnEditSelectAll) {
            if (this.mEnterSort) {
                this.mAdapter.O000000o(true);
                exitEditMode();
            }
        } else if (view == this.O0000Oo0) {
            this.mEnterSort = true;
            enterEditMode();
            this.mAdapter.O00000Oo();
            this.mBtnEditSelectAll.setImageResource(R.drawable.title_right_tick_drawable);
            this.O0000O0o.setText("");
            this.mBtnEditCancel.setImageResource(R.drawable.title_cancel_selector);
            this.mEnterSortTime = hxi.O00000o0.O00000oO(0L);
            hxi.O00000o.f952O000000o.O000000o("room_edit_sort", new Object[0]);
            hxi.O00000o.O0000oo("1");
        } else if (view == this.O0000Oo || view == this.O0000Ooo) {
            hxi.O00000o.f952O000000o.O000000o("page_room_add", new Object[0]);
            List<Room> O00000o2 = ggb.O00000Oo().O00000o();
            if (O00000o2 == null || O00000o2.size() < 50) {
                HomeRoomRecommendActivity.startActivity(getContext(), this.mHomeID);
            } else {
                gqg.O00000Oo((int) R.string.exceed_room_max_count);
            }
        }
    }
}
