package com.xiaomi.smarthome.scene.activity;

import _m_j.axs;
import _m_j.axy;
import _m_j.eys;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.gof;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwr;
import _m_j.gwu;
import _m_j.hnw;
import _m_j.hob;
import _m_j.hod;
import _m_j.hpp;
import _m_j.hpr;
import _m_j.hpu;
import _m_j.hqa;
import _m_j.izb;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.plugin.mpk.MpkPluginApi;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.ExpandableItemIndicator;
import com.xiaomi.smarthome.scene.MySceneFragmentNew;
import com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import com.xiaomi.smarthome.scene.model.RecommendSceneDetailInfo;
import com.xiaomi.smarthome.scene.view.ExpandableListViewWithScrollView;
import com.xiaomi.smarthome.scene.view.HomeSceneScrollView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class SmarthomeRecommendDetailActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    O00000Oo f11039O000000o;
    O00000Oo O00000Oo;
    LayoutInflater O00000o;
    Context O00000o0;
    File O00000oO;
    RecommendSceneDetailInfo O00000oo = new RecommendSceneDetailInfo();
    hqa.O00000Oo O0000O0o;
    int O0000OOo = 0;
    Handler O0000Oo = new Handler() {
        /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass3 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 100) {
                SmarthomeRecommendDetailActivity.this.startSaveScene(null);
            } else if (i == 101) {
                SmarthomeRecommendDetailActivity.this.onFinishSaved(false);
            }
        }
    };
    SceneApi.O000OOOo O0000Oo0;
    private Unbinder O0000OoO;
    private HomeSceneScrollView.O000000o O0000Ooo = new HomeSceneScrollView.O000000o() {
        /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass15 */

        public final void onScrollY(int i) {
            float measuredHeight = ((float) i) / ((float) SmarthomeRecommendDetailActivity.this.mRecommendDetailRL.getMeasuredHeight());
            if (measuredHeight > 0.8f) {
                SmarthomeRecommendDetailActivity.this.mTitleTV.setTextColor(SmarthomeRecommendDetailActivity.this.getResources().getColor(R.color.mj_color_gray_heavier));
            } else {
                SmarthomeRecommendDetailActivity.this.mTitleTV.setTextColor(SmarthomeRecommendDetailActivity.this.getResources().getColor(R.color.mj_color_white));
            }
            SmarthomeRecommendDetailActivity.this.mTitleBarItem.setAlpha(measuredHeight);
            float f = 1.0f - measuredHeight;
            if (f <= 0.0f) {
                f = 0.0f;
            }
            gsy.O00000Oo("SmarthomeRecommendDetailActivity", "alpha" + measuredHeight + "   detailAlpha" + f);
        }
    };
    @BindView(5117)
    ExpandableListViewWithScrollView mActionLV;
    @BindView(5119)
    ExpandableListViewWithScrollView mContionLV;
    @BindView(5773)
    View mMaskView;
    public XQProgressDialog mPD;
    @BindView(6053)
    SimpleDraweeView mPlaceHolder;
    @BindView(6054)
    RelativeLayout mRecommendDetailRL;
    @BindView(5822)
    ImageView mReturnIV;
    @BindView(5576)
    HomeSceneScrollView mScrollView;
    @BindView(6060)
    TextView mStartBtn;
    @BindView(6370)
    FrameLayout mTitleBar;
    @BindView(6379)
    TextView mTitleBarItem;
    @BindView(5826)
    TextView mTitleTV;
    @BindView(6055)
    VideoView mVideoView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_recommend_detail_layout);
        this.O0000OoO = ButterKnife.bind(this);
        this.O00000o0 = this;
        this.O00000o = LayoutInflater.from(this);
        this.O0000O0o = hpu.O000000o().O00000oo;
        if (this.O0000O0o == null) {
            finish();
        }
        O00000oO();
        O000000o();
    }

    private void O000000o() {
        this.mTitleTV.setText((int) R.string.scene_recommend_title);
        this.mTitleBarItem.setText(this.O00000oo.O00000oo);
        this.mTitleBar.getBackground().setAlpha(0);
        if (this.mStartBtn != null) {
            if (this.O00000oo.O00000Oo()) {
                this.mStartBtn.setEnabled(true);
            } else {
                this.mStartBtn.setEnabled(false);
            }
        }
        O00000o0();
        O00000o();
        O00000Oo();
    }

    private void O00000Oo() {
        TextView textView = this.mStartBtn;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    SmarthomeRecommendDetailActivity smarthomeRecommendDetailActivity = SmarthomeRecommendDetailActivity.this;
                    smarthomeRecommendDetailActivity.O0000Oo0 = smarthomeRecommendDetailActivity.getSmarthomeScene();
                    SmarthomeRecommendDetailActivity.this.saveNewScene();
                }
            });
        }
        this.mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass9 */

            public final void onScrollChanged() {
                float scrollY = ((float) SmarthomeRecommendDetailActivity.this.mScrollView.getScrollY()) / ((float) SmarthomeRecommendDetailActivity.this.mRecommendDetailRL.getMeasuredHeight());
                if (scrollY > 0.5f) {
                    SmarthomeRecommendDetailActivity.this.mTitleTV.setTextColor(SmarthomeRecommendDetailActivity.this.getResources().getColor(R.color.mj_color_gray_heavier));
                } else {
                    SmarthomeRecommendDetailActivity.this.mTitleTV.setTextColor(SmarthomeRecommendDetailActivity.this.getResources().getColor(R.color.mj_color_white));
                }
                int intValue = new Float(255.0f * scrollY).intValue();
                if (intValue >= 255) {
                    intValue = 255;
                }
                SmarthomeRecommendDetailActivity.this.mTitleBar.getBackground().setAlpha(intValue);
                SmarthomeRecommendDetailActivity.this.mTitleBarItem.setAlpha(scrollY);
                float f = 1.2f * scrollY;
                SmarthomeRecommendDetailActivity.this.mMaskView.setAlpha(f);
                gsy.O00000Oo("SmarthomeRecommendDetailActivity", "alpha" + scrollY + "  titleBarAlpha" + intValue + "  maskAlpha" + f);
            }
        });
        this.mReturnIV.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass10 */

            public final void onClick(View view) {
                SmarthomeRecommendDetailActivity.this.finish();
            }
        });
    }

    private void O00000o0() {
        this.f11039O000000o = new O00000Oo(0);
        this.O00000Oo = new O00000Oo(1);
        this.mContionLV.setAdapter(this.f11039O000000o);
        this.mActionLV.setAdapter(this.O00000Oo);
        this.mContionLV.setGroupIndicator(null);
        this.mActionLV.setGroupIndicator(null);
        this.f11039O000000o.O000000o(this.O00000oo.f11162O000000o);
        this.O00000Oo.O00000Oo(this.O00000oo.O00000Oo);
    }

    private void O00000o() {
        if (!TextUtils.isEmpty(this.O00000oo.O00000o0)) {
            this.mVideoView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVideoView.getLayoutParams();
            layoutParams.width = gpc.O00000Oo(this);
            gsy.O00000Oo("SmarthomeRecommendDetailActivity", "params.width" + layoutParams.width);
            this.mVideoView.setLayoutParams(layoutParams);
            String str = this.O00000oo.O00000o0;
            hpu.O000000o();
            if (!hpu.O000000o(str)) {
                GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(this.O00000o0.getResources()).setFadeDuration(200).setPlaceholderImage(this.O00000o0.getResources().getDrawable(R.drawable.recommend_scene_list_default_icon)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build();
                this.mPlaceHolder.setVisibility(0);
                this.mPlaceHolder.setHierarchy(build);
                this.mPlaceHolder.setImageURI(Uri.parse(this.O00000oo.O00000o));
            }
            hpu.O000000o().O000000o(str, new hpu.O00000Oo() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass11 */

                public final void O000000o(File file) {
                    SmarthomeRecommendDetailActivity smarthomeRecommendDetailActivity = SmarthomeRecommendDetailActivity.this;
                    smarthomeRecommendDetailActivity.O00000oO = file;
                    smarthomeRecommendDetailActivity.play();
                }
            });
            this.mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass12 */

                public final void onCompletion(MediaPlayer mediaPlayer) {
                    SmarthomeRecommendDetailActivity.this.play();
                }
            });
            this.mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass13 */

                public final void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                        /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass13.AnonymousClass1 */

                        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                            if (i != 3) {
                                return true;
                            }
                            SmarthomeRecommendDetailActivity.this.mVideoView.setBackgroundColor(0);
                            return true;
                        }
                    });
                }
            });
            this.mVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass14 */

                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    try {
                        if (SmarthomeRecommendDetailActivity.this.O0000OOo < 3) {
                            new Handler().postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass14.AnonymousClass1 */

                                public final void run() {
                                    SmarthomeRecommendDetailActivity.this.play();
                                }
                            }, 2000);
                            SmarthomeRecommendDetailActivity.this.O0000OOo++;
                        } else if (SmarthomeRecommendDetailActivity.this.O00000oO != null && SmarthomeRecommendDetailActivity.this.O00000oO.exists()) {
                            SmarthomeRecommendDetailActivity.this.O00000oO.delete();
                        }
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return true;
                    }
                }
            });
        }
    }

    public void onPause() {
        super.onPause();
        VideoView videoView = this.mVideoView;
        if (videoView != null && videoView.getVisibility() == 0) {
            this.mVideoView.stopPlayback();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.mVideoView != null) {
            play();
        }
    }

    public void play() {
        File file;
        if (isValid() && this.mPlaceHolder != null && this.mVideoView != null && (file = this.O00000oO) != null && file.exists()) {
            if (this.mPlaceHolder.getVisibility() == 0) {
                ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass16 */

                    public final void run() {
                        SmarthomeRecommendDetailActivity.this.mPlaceHolder.setVisibility(8);
                    }
                }, 200);
            }
            if (this.mVideoView.getVisibility() == 8) {
                this.mVideoView.setVisibility(0);
            }
            this.mVideoView.setVideoURI(Uri.parse(this.O00000oO.getAbsolutePath()));
            this.mVideoView.start();
            gsy.O00000Oo("SmarthomeRecommendDetailActivity", "height" + this.mVideoView.getMeasuredHeight() + "*" + this.mVideoView.getMeasuredWidth());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mVideoView.stopPlayback();
        hpu.O000000o().O00000oo = null;
        Unbinder unbinder = this.O0000OoO;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    private void O00000oO() {
        hqa.O00000Oo o00000Oo = this.O0000O0o;
        if (o00000Oo == null) {
            finish();
        } else {
            this.O00000oo.O000000o(o00000Oo);
        }
    }

    class O00000Oo extends BaseExpandableListAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        List<RecommendSceneDetailInfo.O00000Oo> f11064O000000o = new ArrayList();
        List<RecommendSceneDetailInfo.O000000o> O00000Oo = new ArrayList();
        private int O00000o = 0;

        public final int getGroupTypeCount() {
            return 2;
        }

        public final boolean hasStableIds() {
            return false;
        }

        public final boolean isChildSelectable(int i, int i2) {
            return false;
        }

        public final void O000000o(List<RecommendSceneDetailInfo.O00000Oo> list) {
            this.f11064O000000o.clear();
            this.f11064O000000o.addAll(list);
            notifyDataSetChanged();
        }

        public final void O00000Oo(List<RecommendSceneDetailInfo.O000000o> list) {
            this.O00000Oo.clear();
            this.O00000Oo.addAll(list);
            notifyDataSetChanged();
        }

        public O00000Oo(int i) {
            this.O00000o = i;
        }

        public final int getGroupCount() {
            if (this.O00000o == 0) {
                return this.f11064O000000o.size();
            }
            return this.O00000Oo.size();
        }

        public final int getChildrenCount(int i) {
            if (this.O00000o == 0) {
                if (this.f11064O000000o.get(i).O00000Oo.size() <= 1) {
                    return 0;
                }
                return this.f11064O000000o.get(i).O00000Oo.size();
            } else if (this.O00000Oo.get(i).O00000Oo.size() <= 1) {
                return 0;
            } else {
                return this.O00000Oo.get(i).O00000Oo.size();
            }
        }

        public final Object getGroup(int i) {
            int i2 = this.O00000o;
            if (i2 == 1) {
                return this.O00000Oo.get(i);
            }
            if (i2 == 0) {
                return this.f11064O000000o.get(i);
            }
            return null;
        }

        public final Object getChild(int i, int i2) {
            int i3 = this.O00000o;
            if (i3 == 1) {
                return this.O00000Oo.get(i).O00000Oo.get(i2);
            }
            if (i3 == 0) {
                return this.f11064O000000o.get(i).O00000Oo.get(i2);
            }
            return null;
        }

        public final long getGroupId(int i) {
            int hashCode;
            int i2 = this.O00000o;
            if (i2 == 0) {
                hashCode = this.f11064O000000o.get(i).hashCode();
            } else if (i2 != 1) {
                return 0;
            } else {
                hashCode = this.O00000Oo.get(i).hashCode();
            }
            return (long) hashCode;
        }

        public final long getChildId(int i, int i2) {
            int hashCode;
            int i3 = this.O00000o;
            if (i3 == 0) {
                hashCode = this.f11064O000000o.get(i).O00000Oo.get(i2).hashCode();
            } else if (i3 != 1) {
                return 0;
            } else {
                hashCode = this.O00000Oo.get(i).O00000Oo.get(i2).hashCode();
            }
            return (long) hashCode;
        }

        public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
            View view2;
            O000000o o000000o;
            O00000o0 o00000o0;
            int i2;
            int i3 = i;
            boolean z2 = z;
            int groupType = getGroupType(i);
            if (groupType == 0) {
                View inflate = SmarthomeRecommendDetailActivity.this.O00000o.inflate((int) R.layout.recommend_scene_group_item, (ViewGroup) null);
                view2 = inflate;
                o00000o0 = new O00000o0(inflate);
                o000000o = null;
            } else if (groupType == 1) {
                View inflate2 = SmarthomeRecommendDetailActivity.this.O00000o.inflate((int) R.layout.recommend_scene_child_item, (ViewGroup) null);
                o000000o = new O000000o(inflate2);
                view2 = inflate2;
                o00000o0 = null;
            } else {
                view2 = view;
                o00000o0 = null;
                o000000o = null;
            }
            int i4 = this.O00000o;
            if (i4 == 0) {
                if (groupType == 1) {
                    final RecommendSceneDetailInfo.O00000Oo o00000Oo = this.f11064O000000o.get(i3);
                    o000000o.O00000oO.setHierarchy(new GenericDraweeHierarchyBuilder(SmarthomeRecommendDetailActivity.this.getResources()).setPlaceholderImage((int) R.drawable.device_list_phone_no).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
                    hnw.O000000o(o000000o.O00000oO, o00000Oo.f11164O000000o);
                    if (o00000Oo.f11164O000000o != null && o00000Oo.f11164O000000o.f11121O000000o == LAUNCH_TYPE.DEVICE) {
                        o000000o.O00000o0.setText(SmarthomeRecommendDetailActivity.this.getConditionDeviceName(o00000Oo.f11164O000000o));
                        if (o00000Oo.O00000Oo.size() == 0 || !fno.O000000o().O0000Oo(o00000Oo.O00000Oo.get(0).did)) {
                            if (!TextUtils.isEmpty(o00000Oo.O0000OOo)) {
                                o000000o.O00000o0.setText(o00000Oo.O0000OOo);
                            }
                            o000000o.O00000o.setText((int) R.string.lack_device_click_to_view);
                            o000000o.O00000o.setVisibility(0);
                            o000000o.O00000oo.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.O00000Oo.AnonymousClass1 */

                                public final void onClick(View view) {
                                    hpu.O000000o().O000000o(SmarthomeRecommendDetailActivity.this, o00000Oo.O00000o0);
                                }
                            });
                            o000000o.O00000o.setTextColor(SmarthomeRecommendDetailActivity.this.getResources().getColor(R.color.mj_color_choose_connect_device_error_link));
                        } else {
                            final Device device = o00000Oo.O00000Oo.get(0);
                            hpu.O000000o();
                            String str = o00000Oo.O0000Oo0;
                            hpu.O000000o();
                            if (!hpu.O000000o(str, hpu.O000000o(device))) {
                                o000000o.O00000o.setText((int) R.string.model_version_not_support);
                                o000000o.O00000o.setOnClickListener(new View.OnClickListener() {
                                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.O00000Oo.AnonymousClass6 */

                                    public final void onClick(View view) {
                                        SmarthomeRecommendDetailActivity.this.showModelUpgradeDialog(device);
                                    }
                                });
                            } else {
                                Room O0000o00 = ggb.O00000Oo().O0000o00(device.did);
                                String string = O0000o00 == null ? SmarthomeRecommendDetailActivity.this.getResources().getString(R.string.room_default) : O0000o00.getName();
                                o000000o.O00000o.setVisibility(0);
                                o000000o.O00000o.setText(string);
                                o000000o.O00000o.setOnClickListener(null);
                                o000000o.O00000o.setTextColor(SmarthomeRecommendDetailActivity.this.getResources().getColor(R.color.mj_color_gray_normal));
                            }
                        }
                        o000000o.O00000Oo.setText(SmarthomeRecommendDetailActivity.this.getConditionName(o00000Oo.f11164O000000o));
                    } else if (o00000Oo.f11164O000000o == null || !o00000Oo.f11164O000000o.O00000Oo()) {
                        o000000o.O00000o0.setText(SmarthomeRecommendDetailActivity.this.getConditionDeviceName(o00000Oo.f11164O000000o));
                        o000000o.O00000o.setVisibility(8);
                        o000000o.O00000Oo.setText(SmarthomeRecommendDetailActivity.this.getConditionName(o00000Oo.f11164O000000o));
                    } else {
                        if (!TextUtils.isEmpty(o00000Oo.f11164O000000o.O0000OoO.O00000oo)) {
                            o000000o.O00000o0.setText(o00000Oo.f11164O000000o.O0000OoO.O00000oo);
                        } else {
                            o000000o.O00000o0.setText((int) R.string.scene_rec_detail_select_city);
                        }
                        o000000o.O00000o.setVisibility(8);
                        o000000o.O00000Oo.setText(SmarthomeRecommendDetailActivity.this.getConditionName(o00000Oo.f11164O000000o));
                        o000000o.itemView.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.O00000Oo.AnonymousClass7 */

                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                             method: _m_j.gwu.O000000o(android.app.Activity, _m_j.gwu$O000000o):void
                             arg types: [com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity, com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity$O00000Oo$7$1]
                             candidates:
                              _m_j.gwu.O000000o(android.content.Context, android.location.Address):_m_j.gwr
                              _m_j.gwu.O000000o(java.util.Map<java.lang.String, java.lang.String>, java.lang.String):java.lang.String
                              _m_j.gwu.O000000o(android.content.Context, _m_j.gwu$O000000o):void
                              _m_j.gwu.O000000o(android.content.Context, java.lang.String):void
                              _m_j.gwu.O000000o(android.app.Activity, _m_j.gwu$O000000o):void */
                            public final void onClick(View view) {
                                gwu.O000000o((Activity) SmarthomeRecommendDetailActivity.this, (gwu.O000000o) new gwu.O000000o() {
                                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.O00000Oo.AnonymousClass7.AnonymousClass1 */

                                    public final void O000000o(String str, String str2) {
                                        if (o00000Oo != null && o00000Oo.f11164O000000o != null && o00000Oo.f11164O000000o.O00000Oo()) {
                                            o00000Oo.f11164O000000o.O0000OoO.O00000oO = str2;
                                            o00000Oo.f11164O000000o.O0000OoO.O00000oo = str;
                                            SceneApi.O0000o00 o0000o00 = o00000Oo.f11164O000000o.O0000OoO;
                                            o0000o00.O0000O0o = o00000Oo.f11164O000000o.O0000OoO.O00000oo + " " + o00000Oo.f11164O000000o.O0000OoO.O00000Oo;
                                            SmarthomeRecommendDetailActivity.this.f11039O000000o.notifyDataSetChanged();
                                        }
                                    }

                                    public final void O000000o(Context context, Address address) {
                                        if (o00000Oo != null && o00000Oo.f11164O000000o != null && o00000Oo.f11164O000000o.O00000Oo()) {
                                            gwr O000000o2 = gwu.O000000o(context, address);
                                            o00000Oo.f11164O000000o.O0000OoO.O00000oO = O000000o2.O00000oo;
                                            o00000Oo.f11164O000000o.O0000OoO.O00000oo = O000000o2.O00000oO;
                                            SceneApi.O0000o00 o0000o00 = o00000Oo.f11164O000000o.O0000OoO;
                                            o0000o00.O0000O0o = o00000Oo.f11164O000000o.O0000OoO.O00000oo + " " + o00000Oo.f11164O000000o.O0000OoO.O00000Oo;
                                            SmarthomeRecommendDetailActivity.this.f11039O000000o.notifyDataSetChanged();
                                        }
                                    }
                                });
                            }
                        });
                    }
                } else if (groupType == 0) {
                    RecommendSceneDetailInfo.O00000Oo o00000Oo2 = this.f11064O000000o.get(i3);
                    o00000o0.getExpandStateFlags();
                    o00000o0.O00000o0.setText(SmarthomeRecommendDetailActivity.this.getConditionName(o00000Oo2.f11164O000000o));
                    if (o00000Oo2 == null || o00000Oo2.O00000o == null) {
                        i2 = 0;
                    } else {
                        i2 = 0;
                        for (Boolean booleanValue : o00000Oo2.O00000o.values()) {
                            if (booleanValue.booleanValue()) {
                                i2++;
                            }
                        }
                    }
                    gsy.O00000Oo("SmarthomeRecommendDetailActivity", "selectCount".concat(String.valueOf(i2)));
                    if (o00000Oo2 == null || o00000Oo2.O00000o == null || i2 != 1) {
                        if (!TextUtils.isEmpty(o00000Oo2.O0000OOo)) {
                            o00000o0.f11079O000000o.setText(o00000Oo2.O0000OOo);
                        } else {
                            o00000o0.f11079O000000o.setText(SmarthomeRecommendDetailActivity.this.getConditionDeviceName(o00000Oo2.f11164O000000o));
                        }
                        o00000o0.O00000Oo.setText(SmarthomeRecommendDetailActivity.this.getResources().getString(R.string.one, Integer.valueOf(i2)));
                    } else {
                        for (int i5 = 0; i5 < o00000Oo2.O00000Oo.size(); i5++) {
                            Device device2 = o00000Oo2.O00000Oo.get(i5);
                            if (o00000Oo2.O00000o.get(device2.did) != null && o00000Oo2.O00000o.get(device2.did).booleanValue()) {
                                if (!TextUtils.isEmpty(device2.name)) {
                                    o00000o0.f11079O000000o.setText(device2.name);
                                } else {
                                    o00000o0.f11079O000000o.setText(o00000Oo2.O0000OOo);
                                }
                                Room O0000o002 = ggb.O00000Oo().O0000o00(device2.did);
                                o00000o0.O00000Oo.setText(O0000o002 == null ? SmarthomeRecommendDetailActivity.this.getResources().getString(R.string.room_default) : O0000o002.getName());
                            }
                        }
                    }
                    if (o00000o0.O00000o != null) {
                        o00000o0.O00000o.setExpandedState$25decb5(z2);
                    }
                }
            } else if (i4 == 1) {
                if (groupType == 1) {
                    final RecommendSceneDetailInfo.O000000o o000000o2 = this.O00000Oo.get(i3);
                    o000000o.O00000oO.setHierarchy(new GenericDraweeHierarchyBuilder(SmarthomeRecommendDetailActivity.this.getResources()).setPlaceholderImage((int) R.drawable.device_list_phone_no).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
                    hnw.O000000o(o000000o.O00000oO, o000000o.O00000Oo, o000000o2.f11163O000000o);
                    o000000o.O00000Oo.setText(SmarthomeRecommendDetailActivity.this.getActionName(o000000o2.f11163O000000o));
                    if (o000000o2 == null || o000000o2.f11163O000000o == null || o000000o2.f11163O000000o.O0000O0o == null || !(o000000o2.f11163O000000o.O0000O0o instanceof SceneApi.O000OO0o)) {
                        o000000o.O00000o.setVisibility(8);
                    } else if (o000000o2.O00000Oo == null || o000000o2.O00000Oo.size() <= 0 || !fno.O000000o().O0000Oo(o000000o2.O00000Oo.get(0).did)) {
                        o000000o.O00000o0.setText(o000000o2.O0000O0o);
                        o000000o.O00000o.setText((int) R.string.lack_device_click_to_view);
                        o000000o.O00000o.setVisibility(0);
                        o000000o.O00000oo.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.O00000Oo.AnonymousClass8 */

                            public final void onClick(View view) {
                                hpu.O000000o().O000000o(SmarthomeRecommendDetailActivity.this, o000000o2.O00000o0);
                            }
                        });
                        o000000o.O00000o.setTextColor(SmarthomeRecommendDetailActivity.this.getResources().getColor(R.color.mj_color_choose_connect_device_error_link));
                    } else {
                        final Device device3 = o000000o2.O00000Oo.get(0);
                        hpu.O000000o();
                        String str2 = o000000o2.O0000OOo;
                        hpu.O000000o();
                        if (!hpu.O000000o(str2, hpu.O000000o(device3))) {
                            o000000o.O00000o.setText((int) R.string.model_version_not_support);
                            o000000o.O00000o.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.O00000Oo.AnonymousClass9 */

                                public final void onClick(View view) {
                                    SmarthomeRecommendDetailActivity.this.showModelUpgradeDialog(device3);
                                }
                            });
                        } else {
                            o000000o.O00000o0.setText(SmarthomeRecommendDetailActivity.this.getActionDeviceName(o000000o2.f11163O000000o, o000000o2.O00000Oo.get(0).did));
                            Room O0000o003 = ggb.O00000Oo().O0000o00(o000000o2.O00000Oo.get(0).did);
                            String string2 = O0000o003 == null ? SmarthomeRecommendDetailActivity.this.getResources().getString(R.string.room_default) : O0000o003.getName();
                            o000000o.O00000o.setVisibility(0);
                            o000000o.O00000o.setText(string2);
                            o000000o.O00000o.setOnClickListener(null);
                            o000000o.O00000o.setTextColor(SmarthomeRecommendDetailActivity.this.getResources().getColor(R.color.mj_color_gray_normal));
                        }
                    }
                } else if (groupType == 0) {
                    RecommendSceneDetailInfo.O000000o o000000o3 = this.O00000Oo.get(i3);
                    o00000o0.O00000o0.setText(SmarthomeRecommendDetailActivity.this.getActionName(o000000o3.f11163O000000o));
                    O000000o(o00000o0, o000000o3);
                    if (o00000o0.O00000o != null) {
                        o00000o0.O00000o.setExpandedState$25decb5(z2);
                    }
                }
            }
            return view2;
        }

        public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            List<Device> list;
            View inflate = SmarthomeRecommendDetailActivity.this.O00000o.inflate((int) R.layout.recommend_scene_child_item, (ViewGroup) null);
            final O000000o o000000o = new O000000o(inflate);
            if (this.O00000o == 0) {
                list = this.f11064O000000o.get(i).O00000Oo;
            } else {
                list = this.O00000Oo.get(i).O00000Oo;
            }
            o000000o.f11063O000000o.setVisibility(0);
            o000000o.O00000Oo.setVisibility(8);
            o000000o.O00000o0.setText(((Device) list.get(i2)).getName());
            DeviceFactory.O00000Oo(((Device) list.get(i2)).model, o000000o.O00000oO);
            int i3 = this.O00000o;
            if (i3 == 0) {
                final RecommendSceneDetailInfo.O00000Oo o00000Oo = this.f11064O000000o.get(i);
                final Device device = o00000Oo.O00000Oo.get(i2);
                final HashMap<String, Boolean> hashMap = o00000Oo.O00000o;
                o000000o.f11063O000000o.setChecked(hashMap.get(device.did) == null ? false : hashMap.get(device.did).booleanValue());
                o000000o.f11063O000000o.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.O00000Oo.AnonymousClass10 */

                    public final void onClick(View view) {
                        gsy.O00000Oo("SmarthomeRecommendDetailActivity", "onClick" + o000000o.f11063O000000o.isChecked());
                    }
                });
                o000000o.O0000O0o.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.O00000Oo.AnonymousClass11 */

                    public final void onClick(View view) {
                        hpu.O000000o();
                        String str = o00000Oo.O0000Oo0;
                        hpu.O000000o();
                        if (!hpu.O000000o(str, hpu.O000000o(device))) {
                            gqg.O00000Oo((int) R.string.model_version_not_support);
                        } else {
                            o000000o.f11063O000000o.setChecked(!o000000o.f11063O000000o.isChecked());
                        }
                    }
                });
                o000000o.f11063O000000o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.O00000Oo.AnonymousClass12 */

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        O00000Oo o00000Oo = O00000Oo.this;
                        HashMap hashMap = hashMap;
                        String str = device.did;
                        gsy.O00000Oo("SmarthomeRecommendDetailActivity", "onConditionCheckBoxSingleChange");
                        if (hashMap != null) {
                            for (String str2 : hashMap.keySet()) {
                                hashMap.put(str2.toString(), Boolean.FALSE);
                            }
                            hashMap.put(str, Boolean.TRUE);
                            o00000Oo.notifyDataSetChanged();
                        }
                    }
                });
                if (o00000Oo.f11164O000000o.f11121O000000o == LAUNCH_TYPE.DEVICE) {
                    hpu.O000000o();
                    String str = o00000Oo.O0000Oo0;
                    hpu.O000000o();
                    if (!hpu.O000000o(str, hpu.O000000o(device))) {
                        o000000o.O00000o.setText((int) R.string.model_version_not_support);
                        o000000o.f11063O000000o.setEnabled(false);
                        o000000o.O00000o.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.O00000Oo.AnonymousClass13 */

                            public final void onClick(View view) {
                                SmarthomeRecommendDetailActivity.this.showModelUpgradeDialog(device);
                            }
                        });
                    } else {
                        Room O0000o00 = ggb.O00000Oo().O0000o00(device.did);
                        String string = O0000o00 == null ? SmarthomeRecommendDetailActivity.this.O00000o0.getString(R.string.room_default) : O0000o00.getName();
                        o000000o.O00000o.setVisibility(0);
                        o000000o.O00000o.setText(string);
                    }
                } else {
                    o000000o.O00000o0.setText("");
                    o000000o.O00000o.setVisibility(8);
                }
            } else if (i3 == 1) {
                final RecommendSceneDetailInfo.O000000o o000000o2 = this.O00000Oo.get(i);
                final Device device2 = o000000o2.O00000Oo.get(i2);
                final HashMap<String, Boolean> hashMap2 = o000000o2.O00000o;
                o000000o.f11063O000000o.setChecked(hashMap2.get(device2.did) == null ? false : hashMap2.get(device2.did).booleanValue());
                o000000o.f11063O000000o.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.O00000Oo.AnonymousClass2 */

                    public final void onClick(View view) {
                        gsy.O00000Oo("SmarthomeRecommendDetailActivity", "onClick" + o000000o.f11063O000000o.isChecked());
                    }
                });
                o000000o.f11063O000000o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.O00000Oo.AnonymousClass3 */

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        gsy.O00000Oo("SmarthomeRecommendDetailActivity", "onCheckedChanged".concat(String.valueOf(z)));
                        hashMap2.put(device2.did, Boolean.valueOf(z));
                        SmarthomeRecommendDetailActivity.this.O00000Oo.notifyDataSetChanged();
                    }
                });
                o000000o.O0000O0o.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.O00000Oo.AnonymousClass4 */

                    public final void onClick(View view) {
                        hpu.O000000o();
                        String str = o000000o2.O0000OOo;
                        hpu.O000000o();
                        if (!hpu.O000000o(str, hpu.O000000o(device2))) {
                            gqg.O00000Oo((int) R.string.model_version_not_support);
                        } else {
                            o000000o.f11063O000000o.setChecked(!o000000o.f11063O000000o.isChecked());
                        }
                    }
                });
                if (o000000o2.f11163O000000o.O0000O0o instanceof SceneApi.O000OO0o) {
                    hpu.O000000o();
                    String str2 = o000000o2.O0000OOo;
                    hpu.O000000o();
                    if (!hpu.O000000o(str2, hpu.O000000o(device2))) {
                        o000000o.O00000o.setText((int) R.string.model_version_not_support);
                        o000000o.f11063O000000o.setEnabled(false);
                        o000000o.O00000o.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.O00000Oo.AnonymousClass5 */

                            public final void onClick(View view) {
                                SmarthomeRecommendDetailActivity.this.showModelUpgradeDialog(device2);
                            }
                        });
                    } else {
                        Room O0000o002 = ggb.O00000Oo().O0000o00(device2.did);
                        String string2 = O0000o002 == null ? SmarthomeRecommendDetailActivity.this.getString(R.string.room_default) : O0000o002.getName();
                        o000000o.O00000o.setVisibility(0);
                        o000000o.O00000o.setText(string2);
                    }
                } else {
                    o000000o.O00000o0.setText("");
                    o000000o.O00000o.setVisibility(8);
                }
            }
            return inflate;
        }

        public final int getGroupType(int i) {
            int i2 = this.O00000o;
            return i2 == 0 ? this.f11064O000000o.get(i).O00000Oo.size() <= 1 ? 1 : 0 : (i2 != 1 || this.O00000Oo.get(i).O00000Oo.size() <= 1) ? 1 : 0;
        }

        public final void onGroupExpanded(int i) {
            gsy.O00000Oo("SmarthomeRecommendDetailActivity", "onGroupExpanded".concat(String.valueOf(i)));
            super.onGroupExpanded(i);
        }

        public final void onGroupCollapsed(int i) {
            gsy.O00000Oo("SmarthomeRecommendDetailActivity", "onGroupCollapsed".concat(String.valueOf(i)));
            super.onGroupCollapsed(i);
        }

        private void O000000o(O00000o0 o00000o0, RecommendSceneDetailInfo.O000000o o000000o) {
            int i;
            if (o000000o == null || o000000o.O00000o == null) {
                i = 0;
            } else {
                i = 0;
                for (Boolean booleanValue : o000000o.O00000o.values()) {
                    if (booleanValue.booleanValue()) {
                        i++;
                    }
                }
            }
            gsy.O00000Oo("SmarthomeRecommendDetailActivity", "selectCount".concat(String.valueOf(i)));
            if (o000000o == null || o000000o.O00000o == null || i != 1) {
                if (!TextUtils.isEmpty(o000000o.O0000O0o)) {
                    o00000o0.f11079O000000o.setText(o000000o.O0000O0o);
                } else {
                    o00000o0.f11079O000000o.setText(SmarthomeRecommendDetailActivity.this.getActionDeviceName(o000000o.f11163O000000o, null));
                }
                o00000o0.O00000Oo.setText(SmarthomeRecommendDetailActivity.this.getResources().getString(R.string.one, Integer.valueOf(i)));
                return;
            }
            for (int i2 = 0; i2 < o000000o.O00000Oo.size(); i2++) {
                Device device = o000000o.O00000Oo.get(i2);
                if (o000000o.O00000o.get(device.did) != null && o000000o.O00000o.get(device.did).booleanValue()) {
                    if (!TextUtils.isEmpty(device.name)) {
                        o00000o0.f11079O000000o.setText(device.name);
                    } else {
                        o00000o0.f11079O000000o.setText(o000000o.O0000O0o);
                    }
                    Room O0000o00 = ggb.O00000Oo().O0000o00(device.did);
                    o00000o0.O00000Oo.setText(O0000o00 == null ? SmarthomeRecommendDetailActivity.this.getResources().getString(R.string.room_default) : O0000o00.getName());
                }
            }
        }
    }

    public void showModelUpgradeDialog(final Device device) {
        new MLAlertDialog.Builder(this).O000000o((int) R.string.model_version_no_support_dialog_title).O000000o((int) R.string.confirm, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                fbt fbt = new fbt(SmarthomeRecommendDetailActivity.this.getContext(), "MiioUpgradeActivity");
                fbt.O000000o("miio_upgrade_did", device.did);
                fbt.O000000o("miio_upgrade_pid", device.pid);
                fbt.O000000o("miio_upgrade_name", device.name);
                fbt.O000000o(1);
                fbs.O000000o(fbt);
            }
        }).O00000o().show();
    }

    class O00000o0 extends axy implements axs {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f11079O000000o;
        TextView O00000Oo;
        ExpandableItemIndicator O00000o;
        TextView O00000o0;
        private int O00000oo;

        public O00000o0(View view) {
            super(view);
            this.f11079O000000o = (TextView) view.findViewById(R.id.device_name);
            this.O00000Oo = (TextView) view.findViewById(R.id.device_count_tv);
            this.O00000o0 = (TextView) view.findViewById(R.id.name);
            this.O00000o = (ExpandableItemIndicator) view.findViewById(R.id.expandable_item_indicator);
        }

        public final void setExpandStateFlags(int i) {
            this.O00000oo = i;
        }

        public final int getExpandStateFlags() {
            return this.O00000oo;
        }
    }

    class O000000o extends axy implements axs {

        /* renamed from: O000000o  reason: collision with root package name */
        CheckBox f11063O000000o;
        TextView O00000Oo;
        TextView O00000o;
        TextView O00000o0;
        SimpleDraweeView O00000oO;
        LinearLayout O00000oo;
        View O0000O0o;
        private int O0000Oo0;

        public O000000o(View view) {
            super(view);
            this.O0000O0o = view;
            this.f11063O000000o = (CheckBox) view.findViewById(R.id.recommend_scene_checkbox);
            this.O00000Oo = (TextView) view.findViewById(R.id.name);
            this.O00000o0 = (TextView) view.findViewById(R.id.device_name);
            this.O00000o = (TextView) view.findViewById(R.id.device_room_name);
            this.O00000oO = (SimpleDraweeView) view.findViewById(R.id.image);
            this.O00000oo = (LinearLayout) view.findViewById(R.id.device_name_ll);
        }

        public final void setExpandStateFlags(int i) {
            this.O0000Oo0 = i;
        }

        public final int getExpandStateFlags() {
            return this.O0000Oo0;
        }
    }

    public String getConditionDeviceName(SceneApi.O000000o o000000o) {
        return hnw.O00000Oo(ServiceApplication.getAppContext(), o000000o);
    }

    public String getConditionName(SceneApi.O000000o o000000o) {
        if (o000000o == null) {
            return "";
        }
        if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE) {
            return o000000o.O00000o0.O00000Oo;
        }
        if (o000000o.f11121O000000o == LAUNCH_TYPE.CLICK) {
            return getResources().getString(R.string.click_condition_name);
        }
        if (o000000o.O00000Oo()) {
            return o000000o.O0000OoO.O00000Oo;
        }
        if (o000000o.f11121O000000o != LAUNCH_TYPE.TIMER) {
            return "";
        }
        return SmartHomeSceneTimerActivity.getTimerHint(this, o000000o.O00000Oo != null ? o000000o.O00000Oo : null);
    }

    public String getActionDeviceName(SceneApi.Action action, String str) {
        if (!(action.O0000O0o instanceof SceneApi.O000OO0o)) {
            return action.O00000Oo;
        }
        if (TextUtils.isEmpty(str)) {
            return DeviceFactory.O0000o0O(action.O00000oO).name;
        }
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 == null) {
            O000000o2 = fno.O000000o().O00000Oo(str);
        }
        return O000000o2 != null ? O000000o2.name : "";
    }

    public String getActionName(SceneApi.Action action) {
        return action == null ? "" : action.O00000Oo;
    }

    public SceneApi.O000OOOo getSmarthomeScene() {
        SceneApi.Action O000000o2;
        SceneApi.O000000o O00000Oo2;
        SceneApi.O000OOOo o000OOOo = new SceneApi.O000OOOo();
        o000OOOo.O0000oO = new SceneApi.O0000o0();
        o000OOOo.O00000Oo = this.O00000oo.O00000oo;
        o000OOOo.O0000Oo0 = this.O00000oo.O0000O0o == 1;
        o000OOOo.O0000Oo = this.O00000oo.O0000OOo == 1;
        o000OOOo.O00000o = Integer.valueOf(this.O00000oo.O00000oO).intValue();
        if (this.O00000oo.O0000Oo0 == 30) {
            o000OOOo.O0000oO0 = true;
        } else {
            o000OOOo.O0000oO0 = false;
        }
        if (this.O00000oo.f11162O000000o != null) {
            for (int i = 0; i < this.O00000oo.f11162O000000o.size(); i++) {
                RecommendSceneDetailInfo.O00000Oo o00000Oo = this.O00000oo.f11162O000000o.get(i);
                if (o00000Oo.O00000oo.equalsIgnoreCase("device")) {
                    if (o00000Oo.O00000Oo.size() != 0) {
                        for (int i2 = 0; i2 < o00000Oo.O00000Oo.size(); i2++) {
                            Device device = o00000Oo.O00000Oo.get(i2);
                            if (!(o00000Oo.O00000o.get(device.did) == null || !o00000Oo.O00000o.get(device.did).booleanValue() || (O00000Oo2 = RecommendSceneDetailInfo.O00000Oo(device.model, o00000Oo.O00000oO.optString(device.model))) == null || O00000Oo2.O00000o0 == null || o000OOOo.O0000O0o == null)) {
                                O00000Oo2.O00000o0.f11122O000000o = device.did;
                                o000OOOo.O0000O0o.add(O00000Oo2);
                            }
                        }
                    }
                } else if (!(o00000Oo.f11164O000000o == null || o000OOOo.O0000O0o == null)) {
                    o000OOOo.O0000O0o.add(o00000Oo.f11164O000000o);
                }
            }
        }
        if (this.O00000oo.O00000Oo != null) {
            for (int i3 = 0; i3 < this.O00000oo.O00000Oo.size(); i3++) {
                RecommendSceneDetailInfo.O000000o o000000o = this.O00000oo.O00000Oo.get(i3);
                if (o000000o.O00000oo == SceneApi.Action.ACTION_TYPE.TYPE_DEVICE.value) {
                    if (o000000o.O00000Oo.size() != 0) {
                        for (int i4 = 0; i4 < o000000o.O00000Oo.size(); i4++) {
                            Device device2 = o000000o.O00000Oo.get(i4);
                            if (!(o000000o.O00000o.get(device2.did) == null || !o000000o.O00000o.get(device2.did).booleanValue() || (O000000o2 = RecommendSceneDetailInfo.O000000o(device2.model, o000000o.O00000oO.optString(device2.model))) == null || O000000o2.O0000O0o == null)) {
                                O000000o2.O0000O0o.O00000o = device2.did;
                                SceneApi.O000OO00 o000oo00 = O000000o2.O0000O0o;
                                o000oo00.O00000o0 = device2.model + "." + O000000o2.O0000O0o.O00000o0;
                                O000000o2.O00000Oo = device2.name;
                                o000OOOo.O00000oo.add(O000000o2);
                            }
                        }
                    }
                } else if (o000000o.f11163O000000o != null) {
                    o000OOOo.O00000oo.add(o000000o.f11163O000000o);
                }
            }
        }
        return o000OOOo;
    }

    public void saveNewScene() {
        Device O00000o02;
        String str;
        Device O00000o03;
        String str2;
        if (!gof.O00000o0()) {
            gqg.O00000Oo((int) R.string.network_fake_connected);
        } else if (this.O0000Oo0.O0000O0o.size() == 0 || this.O0000Oo0.O00000oo.size() == 0) {
            gqg.O00000Oo(getString(R.string.condition_action_count_err));
        } else {
            this.mPD = XQProgressDialog.O000000o(this.O00000o0, null, getString(R.string.smarthome_scene_saving_scene));
            String str3 = null;
            boolean z = false;
            for (SceneApi.O000000o next : this.O0000Oo0.O0000O0o) {
                if (!(next.O00000o0 == null || next.O00000o0.O00000o == null || (O00000o03 = fno.O000000o().O00000o0(next.O00000o0.f11122O000000o)) == null)) {
                    if (O00000o03.isSubDevice()) {
                        str2 = O00000o03.parentId;
                    } else {
                        str2 = O00000o03.did;
                    }
                    if (hnw.O000000o(fno.O000000o().O00000o0(str2))) {
                        str3 = str2;
                        z = true;
                    }
                }
            }
            if (!z) {
                for (SceneApi.Action next2 : this.O0000Oo0.O00000oo) {
                    if (!(next2.O00000oO == null || next2.O0000O0o.O00000o == null || (O00000o02 = fno.O000000o().O00000o0(next2.O0000O0o.O00000o)) == null)) {
                        if (O00000o02.isSubDevice()) {
                            str = O00000o02.parentId;
                        } else {
                            str = O00000o02.did;
                        }
                        if (hnw.O000000o(fno.O000000o().O00000o0(str))) {
                            str3 = str;
                            z = true;
                        }
                    }
                }
            }
            if (!z || str3 == null) {
                startSaveScene(null);
                return;
            }
            final Device O00000o04 = fno.O000000o().O00000o0(str3);
            if (O00000o04 == null || O00000o04.isOnline) {
                Intent intent = new Intent();
                SceneApi.O000000o(this.O0000Oo0);
                SceneInfo O00000o2 = hod.O00000o(this.O0000Oo0);
                intent.putExtra("scene_info", O00000o2);
                this.O0000Oo.sendEmptyMessageDelayed(100, 1000);
                gsy.O000000o(4, "lumiscene", "is rn plugin, scene in app exec..");
                hpp.O000000o().O000000o(O00000o2, new Callback<SceneInfo>() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass4 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        SceneInfo sceneInfo = (SceneInfo) obj;
                        if (SmarthomeRecommendDetailActivity.this.O0000Oo.hasMessages(100)) {
                            SmarthomeRecommendDetailActivity.this.O0000Oo.removeMessages(100);
                            if (sceneInfo != null) {
                                for (int i = 0; i < sceneInfo.mLaunchList.size(); i++) {
                                    if (SmarthomeRecommendDetailActivity.this.O0000Oo0.O0000O0o.get(i).O00000o0 != null && (SmarthomeRecommendDetailActivity.this.O0000Oo0.O0000O0o.get(i).O00000o0 instanceof SceneApi.O00000o0)) {
                                        ((SceneApi.O00000o0) SmarthomeRecommendDetailActivity.this.O0000Oo0.O0000O0o.get(i).O00000o0).O0000o00 = sceneInfo.mLaunchList.get(i).mExtra;
                                    }
                                }
                                for (int i2 = 0; i2 < sceneInfo.mActions.size(); i2++) {
                                    if (SmarthomeRecommendDetailActivity.this.O0000Oo0.O00000oo.get(i2).O0000O0o != null && (SmarthomeRecommendDetailActivity.this.O0000Oo0.O00000oo.get(i2).O0000O0o instanceof SceneApi.O000OO0o)) {
                                        ((SceneApi.O000OO0o) SmarthomeRecommendDetailActivity.this.O0000Oo0.O00000oo.get(i2).O0000O0o).f11130O000000o = sceneInfo.mActions.get(i2).mExtra;
                                    }
                                }
                            }
                            SmarthomeRecommendDetailActivity.this.startSaveScene(O00000o04.did);
                        }
                    }

                    public final void onFailure(int i, String str) {
                        gsy.O000000o(6, "lumiscene", str);
                        if (SmarthomeRecommendDetailActivity.this.O0000Oo.hasMessages(100)) {
                            SmarthomeRecommendDetailActivity.this.O0000Oo.removeMessages(100);
                        }
                        SmarthomeRecommendDetailActivity.this.O0000Oo.post(new Runnable() {
                            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SmarthomeRecommendDetailActivity$4$kgz30c_ysuRveCX7xiY6v6Iks0 */

                            public final void run() {
                                SmarthomeRecommendDetailActivity.AnonymousClass4.this.O000000o();
                            }
                        });
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O000000o() {
                        if (SmarthomeRecommendDetailActivity.this.isValid()) {
                            SmarthomeRecommendDetailActivity.this.mPD.dismiss();
                        }
                        izb.O000000o(SmarthomeRecommendDetailActivity.this.O00000o0, (int) R.string.smarthome_scene_set_fail, 0).show();
                    }
                });
                return;
            }
            this.mPD.dismiss();
            izb.O000000o(this.O00000o0, (int) R.string.smarthome_scene_getway_offline, 0).show();
        }
    }

    public void startSaveScene(final String str) {
        if (eys.f15955O000000o) {
            hob.O000000o().O000000o(this, this.O0000Oo0, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass5 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    SmarthomeRecommendDetailActivity.this.processSaveResponse(str, (JSONObject) obj);
                }

                public final void onFailure(fso fso) {
                    SmarthomeRecommendDetailActivity.this.mPD.dismiss();
                    if (fso.f17063O000000o == -23) {
                        izb.O000000o(SmarthomeRecommendDetailActivity.this.O00000o0, (int) R.string.dead_loop_error, 0).show();
                    } else if (fso.f17063O000000o == -1) {
                        izb.O000000o(SmarthomeRecommendDetailActivity.this.getContext(), (int) R.string.smarthome_scene_has_deleted_device, 0).show();
                    } else {
                        izb.O000000o(SmarthomeRecommendDetailActivity.this.O00000o0, (int) R.string.smarthome_scene_set_fail, 0).show();
                    }
                }
            });
        } else {
            this.mPD.dismiss();
        }
    }

    public void onFinishSaved(final boolean z) {
        this.O0000Oo.post(new Runnable() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass6 */

            public final void run() {
                if (z) {
                    if (SmarthomeRecommendDetailActivity.this.O0000Oo0.O0000oO0) {
                        SmarthomeRecommendDetailActivity.this.mPD.dismiss();
                        hpr.O00000o0().O000000o(SmarthomeRecommendDetailActivity.this.O0000Oo0, new fsm() {
                            /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass6.AnonymousClass1 */

                            public final void onSuccess(Object obj) {
                                SmarthomeRecommendDetailActivity.this.mPD.dismiss();
                                ServiceApplication.getGlobalWorkerHandler().post(new Runnable() {
                                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass6.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        hpr.O00000o0().O00000Oo();
                                    }
                                });
                                izb.O000000o(SmarthomeRecommendDetailActivity.this.O00000o0, (int) R.string.recommend_scene_add_success, 0).show();
                            }

                            public final void onFailure(fso fso) {
                                SmarthomeRecommendDetailActivity.this.mPD.dismiss();
                            }
                        });
                    } else {
                        hod.O0000OoO().O00000o0(SmarthomeRecommendDetailActivity.this.O0000Oo0);
                        CoreApi.O000000o().O00oOoOo();
                        hod.O0000OoO().O00000o();
                        ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass6.AnonymousClass2 */

                            public final void run() {
                                SmarthomeRecommendDetailActivity.this.mPD.dismiss();
                                izb.O000000o(SmarthomeRecommendDetailActivity.this.O00000o0, (int) R.string.recommend_scene_add_success, 0).show();
                            }
                        }, 500);
                    }
                    if (SmarthomeRecommendDetailActivity.this.mStartBtn != null) {
                        SmarthomeRecommendDetailActivity.this.mStartBtn.setText((int) R.string.go_look_at);
                        SmarthomeRecommendDetailActivity.this.mStartBtn.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass6.AnonymousClass3 */

                            public final void onClick(View view) {
                                MySceneFragmentNew mySceneFragmentNew;
                                SmarthomeRecommendDetailActivity.this.finish();
                                SmarthomeRecommendDetailActivity.this.overridePendingTransition(0, 0);
                                hpu.O000000o().O00000o = SmarthomeRecommendDetailActivity.this.O0000Oo0.f11131O000000o;
                                hpu O000000o2 = hpu.O000000o();
                                boolean z = SmarthomeRecommendDetailActivity.this.O0000Oo0.O0000oO0;
                                if (O000000o2.O0000OoO != null && O000000o2.O0000OoO.O000000o() && (mySceneFragmentNew = O000000o2.O0000OoO.O0000o0) != null) {
                                    mySceneFragmentNew.O000000o(z);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                SmarthomeRecommendDetailActivity.this.mPD.dismiss();
                izb.O000000o(SmarthomeRecommendDetailActivity.this.O00000o0, (int) R.string.local_sync_failed, 0).show();
            }
        });
    }

    public void processSaveResponse(String str, JSONObject jSONObject) {
        String optString = jSONObject.optString("us_id");
        boolean optBoolean = jSONObject.optBoolean("local");
        String optString2 = jSONObject.optString("local_dev");
        this.O0000Oo0.f11131O000000o = optString;
        if (TextUtils.isEmpty(optString2) || !optBoolean) {
            onFinishSaved(true);
            return;
        }
        Device O00000o02 = fno.O000000o().O00000o0(optString2);
        if (O00000o02 == null) {
            onFinishSaved(false);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("extra", jSONObject.optJSONObject("data").toString());
        MpkPluginApi.callPlugin(O00000o02.did, 14, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O00000o02), new SendMessageCallback() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass7 */

            public final void onMessageSuccess(Intent intent) {
                hob.O000000o();
                hob.O00000Oo(SmarthomeRecommendDetailActivity.this.O00000o0, SmarthomeRecommendDetailActivity.this.O0000Oo0, new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass7.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        SmarthomeRecommendDetailActivity.this.onFinishSaved(false);
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        SmarthomeRecommendDetailActivity.this.onFinishSaved(true);
                    }
                });
            }

            public final void onMessageFailure(int i, String str) {
                SmarthomeRecommendDetailActivity.this.onFinishSaved(false);
            }

            public final void onMessageHandle(boolean z) {
                if (!z) {
                    SmarthomeRecommendDetailActivity.this.onFinishSaved(false);
                }
            }
        });
        this.O0000Oo.sendEmptyMessageDelayed(101, 10000);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            O00000oO();
            O000000o();
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(new ContextWrapper(context) {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity.AnonymousClass8 */

            public final Object getSystemService(String str) {
                if ("audio".equals(str)) {
                    return getApplicationContext().getSystemService(str);
                }
                return super.getSystemService(str);
            }
        });
    }
}
