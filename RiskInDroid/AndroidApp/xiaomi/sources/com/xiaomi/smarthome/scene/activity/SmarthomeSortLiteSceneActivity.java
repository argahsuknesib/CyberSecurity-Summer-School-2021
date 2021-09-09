package com.xiaomi.smarthome.scene.activity;

import _m_j.awq;
import _m_j.axe;
import _m_j.axj;
import _m_j.axl;
import _m_j.axx;
import _m_j.axz;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gqd;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hnw;
import _m_j.hpr;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.ArrayList;
import java.util.List;

public class SmarthomeSortLiteSceneActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    RecyclerView f11081O000000o;
    RecyclerView.O000000o<O000000o.C0090O000000o> O00000Oo;
    axl O00000o;
    O000000o O00000o0;
    RecyclerView.LayoutManager O00000oO;
    axx O00000oo;
    @BindView(5837)
    Button mCommitBtn;
    @BindView(5838)
    Button moduleA4ReturnBtn;
    @BindView(5842)
    TextView moduleA4ReturnTitle;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_sort_lite_scene);
        ButterKnife.bind(this);
        this.moduleA4ReturnTitle.setText((int) R.string.intelligent_sort);
        this.moduleA4ReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeSortLiteSceneActivity.AnonymousClass1 */

            public final void onClick(View view) {
                SmarthomeSortLiteSceneActivity.this.onBackPress();
            }
        });
        this.mCommitBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SmarthomeSortLiteSceneActivity.AnonymousClass2 */

            public final void onClick(View view) {
                hpr O00000o0 = hpr.O00000o0();
                List<SceneApi.O000OOOo> list = SmarthomeSortLiteSceneActivity.this.O00000o0.f11085O000000o;
                O00000o0.O0000O0o.clear();
                O00000o0.O0000O0o.addAll(list);
                hpr.O00000o0().O000000o(new fsm() {
                    /* class com.xiaomi.smarthome.scene.activity.SmarthomeSortLiteSceneActivity.AnonymousClass2.AnonymousClass1 */

                    public final void onSuccess(Object obj) {
                        gqg.O00000Oo((int) R.string.save_success);
                        SmarthomeSortLiteSceneActivity.this.setResult(-1);
                        SmarthomeSortLiteSceneActivity.this.finish();
                    }

                    public final void onFailure(fso fso) {
                        SmarthomeSortLiteSceneActivity.this.setResult(0);
                        gqg.O00000Oo((int) R.string.save_fail);
                    }
                });
            }
        });
        this.f11081O000000o = (RecyclerView) findViewById(R.id.scene_rv);
        this.O00000oo = new axx();
        axx axx = this.O00000oo;
        axx.O0000OOo = true;
        axx.O00000Oo();
        this.O00000o = new axl();
        this.O00000o.O0000Oo0 = (NinePatchDrawable) getContext().getResources().getDrawable(R.drawable.std_list_item_drag_shadow);
        axl axl = this.O00000o;
        axl.O0000o0 = true;
        axl.O0000o00 = true;
        axl.O0000o0o = true;
        axl.O0000o0O = (int) (((float) ViewConfiguration.getLongPressTimeout()) * 0.5f);
        this.O00000oO = new LinearLayoutManager(this);
        O000000o o000000o = new O000000o(this);
        this.O00000o0 = o000000o;
        this.O00000Oo = this.O00000o.O000000o(o000000o);
        awq awq = new awq();
        awq.O0000o00 = false;
        this.f11081O000000o.setLayoutManager(this.O00000oO);
        this.f11081O000000o.setAdapter(this.O00000Oo);
        this.f11081O000000o.setItemAnimator(awq);
        this.f11081O000000o.setHasFixedSize(true);
        this.O00000oo.O000000o(this.f11081O000000o);
        this.O00000o.O000000o(this.f11081O000000o);
        O000000o o000000o2 = this.O00000o0;
        List<SceneApi.O000OOOo> list = hpr.O00000o0().O0000O0o;
        o000000o2.f11085O000000o.clear();
        o000000o2.f11085O000000o.addAll(list);
        o000000o2.notifyDataSetChanged();
    }

    public void onBackPress() {
        setResult(0);
        finish();
    }

    public void onBackPressed() {
        onBackPress();
    }

    public class O000000o extends RecyclerView.O000000o<C0090O000000o> implements axe<C0090O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        List<SceneApi.O000OOOo> f11085O000000o = new ArrayList();
        private LayoutInflater O00000o;
        private Context O00000o0;
        private int O00000oO = 0;

        public final boolean O00000Oo(int i, int i2) {
            return true;
        }

        public final /* synthetic */ boolean O000000o(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3) {
            C0090O000000o o000000o = (C0090O000000o) o000OOo0;
            gsy.O00000Oo("LiteSceneRecyclerViewAdapter", "onCheckChildCanStartDrag");
            ImageView imageView = o000000o.O00000o0;
            if (imageView == null) {
                return false;
            }
            Rect rect = new Rect();
            o000000o.itemView.getGlobalVisibleRect(rect);
            Rect rect2 = new Rect();
            imageView.getGlobalVisibleRect(rect2);
            rect2.left -= rect.left;
            rect2.top -= rect.top;
            return rect2.contains(i2, i3);
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            boolean z;
            C0090O000000o o000000o = (C0090O000000o) o000OOo0;
            SceneApi.O000OOOo o000OOOo = this.f11085O000000o.get(i);
            o000000o.O00000Oo.setText(o000OOOo.O00000Oo);
            o000000o.O00000o0.setVisibility(0);
            o000000o.O00000oO.setVisibility(0);
            o000000o.O00000oO.setHierarchy(new GenericDraweeHierarchyBuilder(o000000o.O00000oO.getResources()).setFadeDuration(200).setPlaceholderImage(o000000o.O00000oO.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
            if (o000OOOo == null || o000OOOo.O0000O0o.size() <= 0) {
                o000000o.O00000oO.setImageURI(gqd.O000000o((int) R.drawable.intelligence_icon_default_nor));
            } else {
                hnw.O000000o(o000000o.O00000oO, o000OOOo.O0000O0o.get(0));
                if (o000OOOo.O0000O0o.size() > 1) {
                    o000000o.O0000Oo.setVisibility(0);
                } else {
                    o000000o.O0000Oo.setVisibility(8);
                }
            }
            int i2 = 0;
            for (int i3 = 0; i3 < o000OOOo.O00000oo.size(); i3++) {
                SceneApi.Action action = o000OOOo.O00000oo.get(i3);
                if (i2 == 0) {
                    o000000o.O0000O0o.setVisibility(0);
                    z = hnw.O000000o(action, o000OOOo, o000000o.O0000O0o);
                } else if (i2 == 1) {
                    o000000o.O0000OOo.setVisibility(0);
                    z = hnw.O000000o(action, o000OOOo, o000000o.O0000OOo);
                } else if (i2 == 2) {
                    o000000o.O0000Oo0.setVisibility(0);
                    z = hnw.O000000o(action, o000OOOo, o000000o.O0000Oo0);
                } else {
                    z = false;
                }
                if (z) {
                    i2++;
                }
            }
            if (i2 == 0) {
                o000000o.O0000O0o.setVisibility(8);
                o000000o.O0000OOo.setVisibility(8);
                o000000o.O0000Oo0.setVisibility(8);
            } else if (i2 == 1) {
                o000000o.O0000OOo.setVisibility(8);
                o000000o.O0000Oo0.setVisibility(8);
            } else if (i2 == 2) {
                o000000o.O0000Oo0.setVisibility(8);
            }
            int i4 = 0;
            for (int i5 = 0; i5 < o000OOOo.O00000oo.size(); i5++) {
                SceneApi.Action action2 = o000OOOo.O00000oo.get(i5);
                if (!(action2 == null || action2.O0000O0o == null)) {
                    i4++;
                }
            }
            if (i4 > 3) {
                o000000o.O00000oo.setVisibility(0);
            } else {
                o000000o.O00000oo.setVisibility(8);
            }
        }

        public O000000o(Context context) {
            this.O00000o0 = context;
            this.O00000o = LayoutInflater.from(context);
            setHasStableIds(true);
        }

        public final int getItemCount() {
            return this.f11085O000000o.size();
        }

        public final long getItemId(int i) {
            return (long) this.f11085O000000o.get(i).hashCode();
        }

        public final void b_(int i, int i2) {
            gsy.O00000Oo("LiteSceneRecyclerViewAdapter", "fromPosition" + i + "------>" + i2);
            this.f11085O000000o.add(i2, this.f11085O000000o.remove(i));
            notifyItemMoved(i, i2);
        }

        /* renamed from: com.xiaomi.smarthome.scene.activity.SmarthomeSortLiteSceneActivity$O000000o$O000000o  reason: collision with other inner class name */
        public class C0090O000000o extends axz {

            /* renamed from: O000000o  reason: collision with root package name */
            public View f11086O000000o;
            TextView O00000Oo;
            LinearLayout O00000o;
            ImageView O00000o0;
            SimpleDraweeView O00000oO;
            ImageView O00000oo;
            SimpleDraweeView O0000O0o;
            SimpleDraweeView O0000OOo;
            ImageView O0000Oo;
            SimpleDraweeView O0000Oo0;

            public C0090O000000o(View view) {
                super(view);
                this.f11086O000000o = view;
                this.O00000Oo = (TextView) view.findViewById(R.id.lite_scene_name_tv);
                this.O00000o0 = (ImageView) view.findViewById(R.id.img_handle);
                this.O00000o = (LinearLayout) view.findViewById(R.id.lite_scene_icon_ll);
                this.O00000oO = (SimpleDraweeView) view.findViewById(R.id.icon_condition);
                this.O0000Oo = (ImageView) view.findViewById(R.id.icon_condition_more);
                this.O00000oo = (ImageView) view.findViewById(R.id.scene_new_more_icon);
                this.O0000O0o = (SimpleDraweeView) view.findViewById(R.id.icon_actiion1);
                this.O0000OOo = (SimpleDraweeView) view.findViewById(R.id.icon_actiion2);
                this.O0000Oo0 = (SimpleDraweeView) view.findViewById(R.id.icon_actiion3);
            }

            public final View getSwipeableContainerView() {
                return this.f11086O000000o;
            }
        }

        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0090O000000o(this.O00000o.inflate((int) R.layout.myscene_fragment_recycleview_sort_item, (ViewGroup) null));
        }

        public final /* synthetic */ axj O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
            gsy.O00000Oo("LiteSceneRecyclerViewAdapter", "onGetGroupItemDraggableRange" + this.f11085O000000o.size());
            return null;
        }
    }
}
