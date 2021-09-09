package com.xiaomi.smarthome.scene.adapter;

import _m_j.gqg;
import _m_j.hpq;
import _m_j.hpu;
import _m_j.hqa;
import _m_j.hxi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity;
import com.xiaomi.smarthome.scene.activity.SmarthomeRecommendDetailActivity;

public class RecommendSceneAdapter extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f11116O000000o;
    public hqa O00000Oo = new hqa();
    private LayoutInflater O00000o0;

    public long getItemId(int i) {
        return (long) i;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public RecommendSceneAdapter(Context context) {
        this.f11116O000000o = context;
        this.O00000o0 = LayoutInflater.from(context);
    }

    public final boolean O000000o(int i) {
        return TextUtils.equals("-1001", this.O00000Oo.O00000o0.get(i).f517O000000o);
    }

    public int getCount() {
        hqa hqa = this.O00000Oo;
        if (hqa == null || hqa.O00000o0 == null) {
            return 0;
        }
        return this.O00000Oo.O00000o0.size();
    }

    public Object getItem(int i) {
        return this.O00000Oo.O00000o0.get(i);
    }

    public int getItemViewType(int i) {
        return O000000o(i) ? 0 : 1;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        O000000o o000000o;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            if (itemViewType == 1) {
                view = this.O00000o0.inflate((int) R.layout.recommend_scene_new_item, (ViewGroup) null);
                o000000o = new O000000o(view);
            } else {
                view = this.O00000o0.inflate((int) R.layout.item_recommend_scene_nfc, (ViewGroup) null);
                o000000o = new O00000Oo(view);
            }
            view.setTag(o000000o);
        } else {
            o000000o = (O000000o) view.getTag();
        }
        if (itemViewType == 1) {
            final hqa.O00000Oo o00000Oo = this.O00000Oo.O00000o0.get(i);
            o000000o.f11119O000000o.setHierarchy(new GenericDraweeHierarchyBuilder(this.f11116O000000o.getResources()).setFadeDuration(200).setPlaceholderImage(this.f11116O000000o.getResources().getDrawable(R.drawable.recommend_scene_list_default_icon)).setRoundingParams(RoundingParams.fromCornersRadius(20.0f)).setActualImageScaleType(ScalingUtils.ScaleType.CENTER).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
            if (!TextUtils.isEmpty(o00000Oo.O0000O0o)) {
                o000000o.f11119O000000o.setImageURI(Uri.parse(o00000Oo.O0000O0o));
            } else {
                o000000o.f11119O000000o.setImageURI("");
            }
            o000000o.O00000Oo.setText(o00000Oo.O00000Oo);
            o000000o.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.adapter.RecommendSceneAdapter.AnonymousClass1 */

                public final void onClick(View view) {
                    if (!hpu.O000000o().O0000O0o) {
                        gqg.O00000Oo((int) R.string.recommend_scenem_not_update_success);
                        return;
                    }
                    Intent intent = new Intent(RecommendSceneAdapter.this.f11116O000000o, SmarthomeRecommendDetailActivity.class);
                    hpu.O000000o().O00000oo = o00000Oo;
                    RecommendSceneAdapter.this.f11116O000000o.startActivity(intent);
                }
            });
        } else {
            o000000o.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.adapter.RecommendSceneAdapter.AnonymousClass2 */

                public final void onClick(View view) {
                    hxi.O00000o.O0000o0O();
                    RecommendSceneAdapter.this.f11116O000000o.startActivity(new Intent(RecommendSceneAdapter.this.f11116O000000o, NFCActionListActivity.class));
                    hpq.O000000o().O00000o0();
                }
            });
        }
        return view;
    }

    class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        SimpleDraweeView f11119O000000o;
        TextView O00000Oo;

        public O000000o(View view) {
            super(view);
            this.f11119O000000o = (SimpleDraweeView) view.findViewById(R.id.recommend_sdv);
            this.O00000Oo = (TextView) view.findViewById(R.id.recommend_tv);
        }
    }

    class O00000Oo extends O000000o {
        public O00000Oo(View view) {
            super(view);
        }
    }
}
