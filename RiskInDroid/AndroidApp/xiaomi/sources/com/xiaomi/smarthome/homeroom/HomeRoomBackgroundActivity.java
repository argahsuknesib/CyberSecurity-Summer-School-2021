package com.xiaomi.smarthome.homeroom;

import _m_j.ggb;
import _m_j.ggf;
import _m_j.ggh;
import _m_j.gpc;
import _m_j.grk;
import _m_j.grl;
import _m_j.gsy;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.iuo;
import _m_j.ixe;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.sectionedrecyclerviewadapter.Section;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\"\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u0012\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity;", "Lcom/xiaomi/smarthome/framework/page/BaseActivity;", "()V", "mRoomBackgroundStyles", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/homeroom/RoomBackGroupStyle;", "Lkotlin/collections/ArrayList;", "getMRoomBackgroundStyles", "()Ljava/util/ArrayList;", "setMRoomBackgroundStyles", "(Ljava/util/ArrayList;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getBackgroundFlow", "", "initViews", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CustomSection", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HomeRoomBackgroundActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private ArrayList<ggf> f8865O000000o = new ArrayList<>();
    private RecyclerView O00000Oo;

    public final void _$_clearFindViewByIdCache() {
    }

    public final ArrayList<ggf> getMRoomBackgroundStyles() {
        return this.f8865O000000o;
    }

    public final void setMRoomBackgroundStyles(ArrayList<ggf> arrayList) {
        ixe.O00000o(arrayList, "<set-?>");
        this.f8865O000000o = arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.util.ArrayList<_m_j.ggf>]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void onCreate(Bundle bundle) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_room_background);
        initViews();
        JSONObject optJSONObject = ggh.O000000o().O00000Oo().optJSONObject("home_background_style");
        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("styles")) != null && (optJSONArray2 = optJSONObject.optJSONArray("backgroundNames")) != null) {
            int length = optJSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    String optString = optJSONArray.optString(i);
                    ArrayList arrayList = new ArrayList();
                    int length2 = optJSONArray2.length();
                    if (length2 > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            String optString2 = optJSONArray2.optString(i3);
                            StringBuilder sb = new StringBuilder();
                            sb.append((Object) optString);
                            sb.append('_');
                            sb.append((Object) optString2);
                            arrayList.add(sb.toString());
                            if (i4 >= length2) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    ArrayList<ggf> arrayList2 = this.f8865O000000o;
                    ixe.O00000Oo(optString, "style");
                    arrayList2.add(new ggf(optString, ixe.O000000o(getString(R.string.room_bg_style), (Object) Integer.valueOf(i2)), arrayList));
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            gsy.O00000o0(LogType.HOME_ROOM, "", ixe.O000000o("getBackgroundFlow: ", (Object) this.f8865O000000o));
            for (ggf o000000o : this.f8865O000000o) {
                O000000o o000000o2 = new O000000o(this, o000000o, new grk.O000000o(R.layout.device_tag_manager_layout).O000000o(R.layout.item_room_background_header).O000000o());
                RecyclerView recyclerView = this.O00000Oo;
                if (recyclerView != null) {
                    RecyclerView.O000000o adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        ((grl) adapter).O000000o(o000000o2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.library.common.widget.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter");
                    }
                } else {
                    ixe.O000000o("recyclerView");
                    throw null;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(HomeRoomBackgroundActivity homeRoomBackgroundActivity, View view) {
        ixe.O00000o(homeRoomBackgroundActivity, "this$0");
        homeRoomBackgroundActivity.onBackPressed();
    }

    public final void initViews() {
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeRoomBackgroundActivity$Am4VHfY1Wzk92AOU_LF1qFX16Y */

            public final void onClick(View view) {
                HomeRoomBackgroundActivity.O000000o(HomeRoomBackgroundActivity.this, view);
            }
        });
        findViewById(R.id.module_a_3_right_img_btn).setVisibility(8);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.input_tag_name_bg);
        View findViewById = findViewById(R.id.rl_room_background);
        ixe.O00000Oo(findViewById, "findViewById(R.id.rl_room_background)");
        this.O00000Oo = (RecyclerView) findViewById;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setItemPrefetchEnabled(false);
        linearLayoutManager.setInitialPrefetchItemCount(0);
        RecyclerView recyclerView = this.O00000Oo;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
            RecyclerView recyclerView2 = this.O00000Oo;
            if (recyclerView2 != null) {
                recyclerView2.setHasFixedSize(true);
                RecyclerView recyclerView3 = this.O00000Oo;
                if (recyclerView3 != null) {
                    recyclerView3.setItemViewCacheSize(0);
                    RecyclerView recyclerView4 = this.O00000Oo;
                    if (recyclerView4 != null) {
                        recyclerView4.setAdapter(new grl());
                    } else {
                        ixe.O000000o("recyclerView");
                        throw null;
                    }
                } else {
                    ixe.O000000o("recyclerView");
                    throw null;
                }
            } else {
                ixe.O000000o("recyclerView");
                throw null;
            }
        } else {
            ixe.O000000o("recyclerView");
            throw null;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0012H\u0016R(\u0010\u0007\u001a\u0010\u0012\f\u0012\n0\tR\u00060\u0000R\u00020\n0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity$CustomSection;", "Lcom/xiaomi/smarthome/library/common/widget/sectionedrecyclerviewadapter/Section;", "style", "Lcom/xiaomi/smarthome/homeroom/RoomBackGroupStyle;", "sectionParameters", "Lcom/xiaomi/smarthome/library/common/widget/sectionedrecyclerviewadapter/SectionParameters;", "(Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity;Lcom/xiaomi/smarthome/homeroom/RoomBackGroupStyle;Lcom/xiaomi/smarthome/library/common/widget/sectionedrecyclerviewadapter/SectionParameters;)V", "mAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity$CustomSection$BgViewHolder;", "Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity;", "getMAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setMAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "getStyle", "()Lcom/xiaomi/smarthome/homeroom/RoomBackGroupStyle;", "getContentItemsTotal", "", "getHeaderViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "getItemViewHolder", "onBindHeaderViewHolder", "", "holder", "onBindItemViewHolder", "position", "BgViewHolder", "ChildViewHolder", "HeaderViewHolder", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class O000000o extends Section {

        /* renamed from: O000000o  reason: collision with root package name */
        final ggf f8866O000000o;
        RecyclerView.O000000o<C0076O000000o> O00000Oo = new O00000o(this.O00000o0, this);
        final /* synthetic */ HomeRoomBackgroundActivity O00000o0;

        public final int O000000o() {
            return 1;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O000000o(HomeRoomBackgroundActivity homeRoomBackgroundActivity, ggf ggf, grk grk) {
            super(grk);
            ixe.O00000o(homeRoomBackgroundActivity, "this$0");
            ixe.O00000o(ggf, "style");
            this.O00000o0 = homeRoomBackgroundActivity;
            this.f8866O000000o = ggf;
        }

        public final RecyclerView.O000OOo0 O000000o(View view) {
            ixe.O00000o(view, "view");
            return new O00000o0(this, view);
        }

        public final RecyclerView.O000OOo0 O00000Oo(View view) {
            ixe.O00000o(view, "view");
            return new O00000Oo(this, view);
        }

        public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
            ixe.O00000o(o000OOo0, "holder");
            ((O00000o0) o000OOo0).f8871O000000o.setText(this.f8866O000000o.O00000Oo);
        }

        public final void O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "holder");
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            try {
                ViewGroup.LayoutParams layoutParams = o00000Oo.f8868O000000o.getLayoutParams();
                if (layoutParams != null) {
                    RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                    layoutParams2.height = gpc.O000000o(194.0f);
                    String str = o00000Oo.O00000Oo.f8866O000000o.f17737O000000o;
                    List mRoomBackgroundStyles = o00000Oo.O00000Oo.O00000o0.getMRoomBackgroundStyles();
                    ixe.O00000o0(mRoomBackgroundStyles, "receiver$0");
                    if (!mRoomBackgroundStyles.isEmpty()) {
                        layoutParams2.bottomMargin = ixe.O000000o(str, ((ggf) mRoomBackgroundStyles.get(iuo.O000000o(mRoomBackgroundStyles))).f17737O000000o) ? gpc.O000000o(100.0f) : 0;
                        o00000Oo.f8868O000000o.setLayoutParams(layoutParams2);
                        o00000Oo.f8868O000000o.addOnScrollListener(new O00000Oo.C0077O000000o(o00000Oo.O00000Oo.O00000o0, o00000Oo.O00000Oo));
                        return;
                    }
                    throw new NoSuchElementException("List is empty.");
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity$CustomSection$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity$CustomSection;Landroid/view/View;)V", "sectionNameTv", "Landroid/widget/TextView;", "getSectionNameTv", "()Landroid/widget/TextView;", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        final class O00000o0 extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final TextView f8871O000000o;
            final /* synthetic */ O000000o O00000Oo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O00000o0(O000000o o000000o, View view) {
                super(view);
                ixe.O00000o(o000000o, "this$0");
                ixe.O00000o(view, "view");
                this.O00000Oo = o000000o;
                View findViewById = view.findViewById(R.id.section_name);
                ixe.O00000Oo(findViewById, "view.findViewById(R.id.section_name)");
                this.f8871O000000o = (TextView) findViewById;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity$CustomSection$ChildViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity$CustomSection;Landroid/view/View;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "updateData", "", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public final class O00000Oo extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final RecyclerView f8868O000000o;
            final /* synthetic */ O000000o O00000Oo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O00000Oo(O000000o o000000o, View view) {
                super(view);
                ixe.O00000o(o000000o, "this$0");
                ixe.O00000o(view, "view");
                this.O00000Oo = o000000o;
                this.f8868O000000o = (RecyclerView) view;
                this.f8868O000000o.setLayoutManager(new LinearLayoutManager(this.f8868O000000o.getContext(), 0, false));
                this.f8868O000000o.setAdapter(this.O00000Oo.O00000Oo);
            }

            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity$CustomSection$ChildViewHolder$updateData$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* renamed from: com.xiaomi.smarthome.homeroom.HomeRoomBackgroundActivity$O000000o$O00000Oo$O000000o  reason: collision with other inner class name */
            public static final class C0077O000000o extends RecyclerView.O00oOooO {

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ HomeRoomBackgroundActivity f8869O000000o;
                final /* synthetic */ O000000o O00000Oo;

                C0077O000000o(HomeRoomBackgroundActivity homeRoomBackgroundActivity, O000000o o000000o) {
                    this.f8869O000000o = homeRoomBackgroundActivity;
                    this.O00000Oo = o000000o;
                }

                public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    ixe.O00000o(recyclerView, "recyclerView");
                    super.onScrolled(recyclerView, i, i2);
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.hxk.O000000o(java.lang.String, int, boolean, java.lang.String):void
                 arg types: [java.lang.String, int, int, java.lang.String]
                 candidates:
                  _m_j.hxk.O000000o(int, java.lang.String, java.lang.String, int):void
                  _m_j.hxk.O000000o(java.lang.String, int, boolean, java.lang.String):void */
                public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    ixe.O00000o(recyclerView, "recyclerView");
                    super.onScrollStateChanged(recyclerView, i);
                    if (i == 1) {
                        hxk hxk = hxi.O00000o;
                        String stringExtra = this.f8869O000000o.getIntent().getStringExtra("roomName");
                        if (stringExtra == null) {
                            stringExtra = "";
                        }
                        hxk.O000000o(stringExtra, this.f8869O000000o.getMRoomBackgroundStyles().indexOf(this.O00000Oo.f8866O000000o) + 1, false, this.O00000Oo.f8866O000000o.O00000Oo);
                    }
                }
            }
        }

        @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0003R\u00020\u00040\u00012\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n0\u0002R\u00060\u0003R\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J \u0010\u000f\u001a\n0\u0002R\u00060\u0003R\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, d2 = {"com/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity$CustomSection$mAdapter$1", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity$CustomSection$BgViewHolder;", "Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity$CustomSection;", "Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity;", "Landroid/view/View$OnClickListener;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "i", "onClick", "v", "Landroid/view/View;", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O00000o extends RecyclerView.O000000o<C0076O000000o> implements View.OnClickListener {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ HomeRoomBackgroundActivity f8870O000000o;
            final /* synthetic */ O000000o O00000Oo;

            O00000o(HomeRoomBackgroundActivity homeRoomBackgroundActivity, O000000o o000000o) {
                this.f8870O000000o = homeRoomBackgroundActivity;
                this.O00000Oo = o000000o;
            }

            public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                C0076O000000o o000000o = (C0076O000000o) o000OOo0;
                ixe.O00000o(o000000o, "viewHolder");
                ViewGroup.LayoutParams layoutParams = o000000o.f8867O000000o.getLayoutParams();
                if (layoutParams != null) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i < this.O00000Oo.f8866O000000o.O00000o0.size() + -1 ? 0 : gpc.O000000o(12.0f);
                    String str = this.O00000Oo.f8866O000000o.O00000o0.get(i);
                    ggb.O0000O0o.O000000o(o000000o.f8867O000000o, str, new boolean[0]);
                    o000000o.f8867O000000o.setTag(str);
                    o000000o.f8867O000000o.setOnClickListener(this);
                    SimpleDraweeView simpleDraweeView = o000000o.f8867O000000o;
                    simpleDraweeView.setContentDescription(this.O00000Oo.f8866O000000o.O00000Oo + ": " + i);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
             arg types: [?, android.view.ViewGroup, int]
             candidates:
              ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
              ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
            public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                ixe.O00000o(viewGroup, "viewGroup");
                View inflate = LayoutInflater.from(this.f8870O000000o.getContext()).inflate((int) R.layout.item_room_background_content, viewGroup, false);
                O000000o o000000o = this.O00000Oo;
                ixe.O00000Oo(inflate, "item");
                return new C0076O000000o(o000000o, inflate);
            }

            public final int getItemCount() {
                return this.O00000Oo.f8866O000000o.O00000o0.size();
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.hxk.O000000o(java.lang.String, int, boolean, java.lang.String):void
             arg types: [java.lang.String, int, int, java.lang.String]
             candidates:
              _m_j.hxk.O000000o(int, java.lang.String, java.lang.String, int):void
              _m_j.hxk.O000000o(java.lang.String, int, boolean, java.lang.String):void */
            public final void onClick(View view) {
                Object obj;
                Intent intent = new Intent(this.f8870O000000o.getContext(), HomeRoomBackgroundPreviewActivity.class);
                if (view == null) {
                    obj = null;
                } else {
                    obj = view.getTag();
                }
                if (obj != null) {
                    intent.putExtra("wallpaperNamePrefix", (String) obj);
                    intent.putExtra("roomName", this.f8870O000000o.getIntent().getStringExtra("roomName"));
                    this.f8870O000000o.startActivityForResult(intent, 1001);
                    int indexOf = this.f8870O000000o.getMRoomBackgroundStyles().indexOf(this.O00000Oo.f8866O000000o) + 1;
                    hxk hxk = hxi.O00000o;
                    String stringExtra = this.f8870O000000o.getIntent().getStringExtra("roomName");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    Object tag = view.getTag();
                    if (tag != null) {
                        hxk.O000000o(stringExtra, indexOf, true, (String) tag);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity$CustomSection$BgViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundActivity$CustomSection;Landroid/view/View;)V", "bg", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getBg", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* renamed from: com.xiaomi.smarthome.homeroom.HomeRoomBackgroundActivity$O000000o$O000000o  reason: collision with other inner class name */
        public final class C0076O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final SimpleDraweeView f8867O000000o;
            final /* synthetic */ O000000o O00000Oo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0076O000000o(O000000o o000000o, View view) {
                super(view);
                ixe.O00000o(o000000o, "this$0");
                ixe.O00000o(view, "view");
                this.O00000Oo = o000000o;
                View findViewById = view.findViewById(R.id.sd_room_bg);
                ixe.O00000Oo(findViewById, "view.findViewById(R.id.sd_room_bg)");
                this.f8867O000000o = (SimpleDraweeView) findViewById;
                PointF pointF = new PointF(0.0f, 0.0f);
                ((GenericDraweeHierarchy) this.f8867O000000o.getHierarchy()).setActualImageFocusPoint(pointF);
                ((GenericDraweeHierarchy) this.f8867O000000o.getHierarchy()).setPlaceholderImageFocusPoint(pointF);
            }
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1) {
            setResult(-1, intent);
            finish();
        }
    }
}
