package com.xiaomi.smarthome.homeroom;

import _m_j.ggb;
import _m_j.ggh;
import _m_j.gpc;
import _m_j.grk;
import _m_j.grl;
import _m_j.gsy;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.iuh;
import _m_j.ixe;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.HomeAllStyleListActivity;
import com.xiaomi.smarthome.library.common.widget.sectionedrecyclerviewadapter.Section;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\"\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u0012\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeAllStyleListActivity;", "Lcom/xiaomi/smarthome/framework/page/BaseActivity;", "()V", "mHomeStyles", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/homeroom/HomeStyle;", "Lkotlin/collections/ArrayList;", "getMHomeStyles", "()Ljava/util/ArrayList;", "setMHomeStyles", "(Ljava/util/ArrayList;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getHomeStyleFlow", "", "initViews", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CustomSection", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HomeAllStyleListActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private ArrayList<HomeStyle> f8835O000000o = new ArrayList<>();
    private RecyclerView O00000Oo;

    public final void _$_clearFindViewByIdCache() {
    }

    public final ArrayList<HomeStyle> getMHomeStyles() {
        return this.f8835O000000o;
    }

    public final void setMHomeStyles(ArrayList<HomeStyle> arrayList) {
        ixe.O00000o(arrayList, "<set-?>");
        this.f8835O000000o = arrayList;
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
     arg types: [java.lang.String, java.util.ArrayList<com.xiaomi.smarthome.homeroom.HomeStyle>]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void onCreate(Bundle bundle) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONObject optJSONObject;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_room_background);
        initViews();
        JSONObject optJSONObject2 = ggh.O000000o().O00000Oo().optJSONObject("home_background_style");
        if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("styles")) != null && (optJSONArray2 = optJSONObject2.optJSONArray("backgroundNames")) != null && (optJSONObject = optJSONObject2.optJSONObject("homeStyleConfig")) != null) {
            int length = optJSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    String optString = optJSONArray.optString(i);
                    Map linkedHashMap = new LinkedHashMap();
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject(optString);
                    if (optJSONObject3 == null) {
                        optJSONObject3 = new JSONObject();
                    }
                    JSONArray optJSONArray3 = optJSONObject3.optJSONArray("items");
                    if (optJSONArray3 == null) {
                        optJSONArray3 = new JSONArray();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(optString);
                    char c = '_';
                    sb.append('_');
                    sb.append((Object) optJSONObject3.optString("homeStylePreview", "favorites"));
                    String sb2 = sb.toString();
                    if (optJSONArray3.length() > 0) {
                        int length2 = optJSONArray3.length();
                        if (length2 > 0) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3 + 1;
                                JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i3);
                                String optString2 = optJSONObject4.optString("roomNameKey");
                                ixe.O00000Oo(optString2, "item.optString(\"roomNameKey\")");
                                linkedHashMap.put(optString2, optString + c + ((Object) optJSONObject4.optString("backgroundName")));
                                if (i4 >= length2) {
                                    break;
                                }
                                i3 = i4;
                                c = '_';
                            }
                        }
                    } else {
                        int length3 = optJSONArray2.length();
                        if (length3 > 0) {
                            int i5 = 0;
                            while (true) {
                                int i6 = i5 + 1;
                                String optString3 = optJSONArray2.optString(i5);
                                ixe.O00000Oo(optString3, "name");
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append((Object) optString);
                                sb3.append('_');
                                sb3.append((Object) optString3);
                                linkedHashMap.put(optString3, sb3.toString());
                                if (i6 >= length3) {
                                    break;
                                }
                                i5 = i6;
                            }
                        }
                    }
                    ArrayList<HomeStyle> arrayList = this.f8835O000000o;
                    ixe.O00000Oo(optString, "style");
                    arrayList.add(new HomeStyle(optString, ixe.O000000o(getString(R.string.room_bg_style), (Object) Integer.valueOf(i2)), sb2, linkedHashMap));
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            gsy.O00000o0(LogType.HOME_ROOM, "", ixe.O000000o("getHomeStyleFlow: ", (Object) this.f8835O000000o));
            for (HomeStyle o000000o : this.f8835O000000o) {
                O000000o o000000o2 = new O000000o(this, o000000o, new grk.O000000o(R.layout.home_room_wallpaper_preview_view).O000000o(R.layout.item_room_background_header).O000000o());
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

    public final void initViews() {
        findViewById(R.id.module_a_3_right_img_btn).setVisibility(8);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.input_tag_name_home_bg);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeAllStyleListActivity$8wgVXMB1I1SJREV1aWEV1W04xmY */

            public final void onClick(View view) {
                HomeAllStyleListActivity.O000000o(HomeAllStyleListActivity.this, view);
            }
        });
        View findViewById = findViewById(R.id.rl_room_background);
        RecyclerView recyclerView = (RecyclerView) findViewById;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setItemPrefetchEnabled(false);
        linearLayoutManager.setInitialPrefetchItemCount(0);
        iuh iuh = iuh.f1631O000000o;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(0);
        recyclerView.setAdapter(new grl());
        iuh iuh2 = iuh.f1631O000000o;
        ixe.O00000Oo(findViewById, "findViewById<RecyclerView>(R.id.rl_room_background).apply{\n            layoutManager = LinearLayoutManager(context).apply {\n                isItemPrefetchEnabled = false\n                initialPrefetchItemCount = 0\n            }\n            setHasFixedSize(true)\n            setItemViewCacheSize(0)\n            adapter = SectionedRecyclerViewAdapter()\n        }");
        this.O00000Oo = recyclerView;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(HomeAllStyleListActivity homeAllStyleListActivity, View view) {
        ixe.O00000o(homeAllStyleListActivity, "this$0");
        homeAllStyleListActivity.onBackPressed();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && i2 == -1) {
            setResult(-1, intent);
            finish();
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeAllStyleListActivity$CustomSection;", "Lcom/xiaomi/smarthome/library/common/widget/sectionedrecyclerviewadapter/Section;", "style", "Lcom/xiaomi/smarthome/homeroom/HomeStyle;", "sectionParameters", "Lcom/xiaomi/smarthome/library/common/widget/sectionedrecyclerviewadapter/SectionParameters;", "(Lcom/xiaomi/smarthome/homeroom/HomeAllStyleListActivity;Lcom/xiaomi/smarthome/homeroom/HomeStyle;Lcom/xiaomi/smarthome/library/common/widget/sectionedrecyclerviewadapter/SectionParameters;)V", "getStyle", "()Lcom/xiaomi/smarthome/homeroom/HomeStyle;", "getContentItemsTotal", "", "getHeaderViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "getItemViewHolder", "onBindHeaderViewHolder", "", "holder", "onBindItemViewHolder", "position", "ChildViewHolder", "HeaderViewHolder", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class O000000o extends Section {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ HomeAllStyleListActivity f8836O000000o;
        private final HomeStyle O00000Oo;

        public final int O000000o() {
            return 1;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O000000o(HomeAllStyleListActivity homeAllStyleListActivity, HomeStyle homeStyle, grk grk) {
            super(grk);
            ixe.O00000o(homeAllStyleListActivity, "this$0");
            ixe.O00000o(homeStyle, "style");
            this.f8836O000000o = homeAllStyleListActivity;
            this.O00000Oo = homeStyle;
        }

        public final RecyclerView.O000OOo0 O000000o(View view) {
            ixe.O00000o(view, "view");
            return new O00000Oo(this, view);
        }

        public final RecyclerView.O000OOo0 O00000Oo(View view) {
            ixe.O00000o(view, "view");
            return new C0075O000000o(this, view);
        }

        public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
            ixe.O00000o(o000OOo0, "holder");
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            o00000Oo.f8838O000000o.setText(this.O00000Oo.O00000Oo);
            o00000Oo.O00000Oo.setVisibility(0);
        }

        public final void O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "holder");
            C0075O000000o o000000o = (C0075O000000o) o000OOo0;
            ViewGroup.LayoutParams layoutParams = o000000o.f8837O000000o.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.bottomMargin = gpc.O000000o(14.0f);
                o000000o.f8837O000000o.setLayoutParams(marginLayoutParams);
                ggb.O0000O0o.O000000o(o000000o.f8837O000000o, this.O00000Oo.O00000o0, new boolean[0]);
                o000000o.f8837O000000o.setOnClickListener(new View.OnClickListener(this) {
                    /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeAllStyleListActivity$O000000o$4XYvgWIokSuFfFkTZnBBoXfVtiE */
                    private final /* synthetic */ HomeAllStyleListActivity.O000000o f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        HomeAllStyleListActivity.O000000o.O000000o(HomeAllStyleListActivity.this, this.f$1, view);
                    }
                });
                o000000o.f8837O000000o.setContentDescription(this.O00000Oo.O00000Oo);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }

        /* access modifiers changed from: private */
        public static final void O000000o(HomeAllStyleListActivity homeAllStyleListActivity, O000000o o000000o, View view) {
            ixe.O00000o(homeAllStyleListActivity, "this$0");
            ixe.O00000o(o000000o, "this$1");
            Intent intent = new Intent(homeAllStyleListActivity.getContext(), HomeStyleActivity.class);
            intent.putExtra("style", o000000o.O00000Oo);
            intent.putExtra("homeid", homeAllStyleListActivity.getIntent().getStringExtra("homeid"));
            homeAllStyleListActivity.startActivityForResult(intent, 1001);
            hxk hxk = hxi.O00000o;
            String str = o000000o.O00000Oo.O00000Oo;
            hxk.f952O000000o.O000000o("h2m_background_select", "clk", str);
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeAllStyleListActivity$CustomSection$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/homeroom/HomeAllStyleListActivity$CustomSection;Landroid/view/View;)V", "arrowRight", "getArrowRight", "()Landroid/view/View;", "sectionNameTv", "Landroid/widget/TextView;", "getSectionNameTv", "()Landroid/widget/TextView;", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        final class O00000Oo extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final TextView f8838O000000o;
            final View O00000Oo;
            final /* synthetic */ O000000o O00000o0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O00000Oo(O000000o o000000o, View view) {
                super(view);
                ixe.O00000o(o000000o, "this$0");
                ixe.O00000o(view, "view");
                this.O00000o0 = o000000o;
                View findViewById = view.findViewById(R.id.section_name);
                ixe.O00000Oo(findViewById, "view.findViewById(R.id.section_name)");
                this.f8838O000000o = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.arrow_right);
                ixe.O00000Oo(findViewById2, "view.findViewById(R.id.arrow_right)");
                this.O00000Oo = findViewById2;
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeAllStyleListActivity$CustomSection$ChildViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/homeroom/HomeAllStyleListActivity$CustomSection;Landroid/view/View;)V", "mSimpleDraweeView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getMSimpleDraweeView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* renamed from: com.xiaomi.smarthome.homeroom.HomeAllStyleListActivity$O000000o$O000000o  reason: collision with other inner class name */
        public final class C0075O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final SimpleDraweeView f8837O000000o;
            final /* synthetic */ O000000o O00000Oo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0075O000000o(O000000o o000000o, View view) {
                super(view);
                ixe.O00000o(o000000o, "this$0");
                ixe.O00000o(view, "view");
                this.O00000Oo = o000000o;
                View findViewById = view.findViewById(R.id.sd_room_bg);
                ixe.O00000Oo(findViewById, "view.findViewById(R.id.sd_room_bg)");
                this.f8837O000000o = (SimpleDraweeView) findViewById;
                PointF pointF = new PointF(0.5f, 0.19f);
                ((GenericDraweeHierarchy) this.f8837O000000o.getHierarchy()).setActualImageFocusPoint(pointF);
                ((GenericDraweeHierarchy) this.f8837O000000o.getHierarchy()).setPlaceholderImageFocusPoint(pointF);
            }
        }
    }
}
