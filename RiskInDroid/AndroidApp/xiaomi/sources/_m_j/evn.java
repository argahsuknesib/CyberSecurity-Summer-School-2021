package _m_j;

import _m_j.ewr;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.Gson;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.smarthome.R;

public final class evn extends vx<ewr, vr> {
    private eum O00000o0;

    public final int O000000o() {
        return 15;
    }

    public final int O00000Oo() {
        return R.layout.discover_article_list_item;
    }

    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        TextView textView;
        TextView textView2;
        String O000000o2;
        final ewr ewr = (ewr) obj;
        View view = vrVar.itemView;
        TextView textView3 = (TextView) view.findViewById(R.id.tv_title);
        TextView textView4 = (TextView) view.findViewById(R.id.tv_content);
        TextView textView5 = (TextView) view.findViewById(R.id.tv_addtime);
        TextView textView6 = (TextView) view.findViewById(R.id.tv_viewCount);
        ImageView imageView = (ImageView) view.findViewById(R.id.id_discover_article_iv);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.id_discover_gallery_1);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.id_discover_gallery_2);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.id_discover_gallery_3);
        ((ImageView) view.findViewById(R.id.id_video_player_btn)).setVisibility(8);
        imageView2.setVisibility(0);
        imageView3.setVisibility(0);
        imageView4.setVisibility(0);
        ewr.O000000o o000000o = ewr.O0000oo0.get(0);
        if (o000000o.O0000oO0 != null && !TextUtils.isEmpty(o000000o.O0000oO0)) {
            ewf ewf = (ewf) new Gson().fromJson(o000000o.O0000oO0, ewf.class);
            if (ewf != null) {
                String str = ewf.O00000o;
                if (str != null && !TextUtils.isEmpty(str)) {
                    textView6.setText(ewf.O00000o);
                }
                if (!(ewf.f15882O000000o == null || (O000000o2 = eww.O000000o(ewf.f15882O000000o.longValue())) == null || TextUtils.isEmpty(O000000o2))) {
                    textView5.setText(O000000o2);
                }
            }
            if (!(ewf == null || ewf.O00000Oo == null)) {
                if (ewf.O00000Oo.size() == 1 || ewf.O00000Oo.size() == 2) {
                    imageView.setVisibility(0);
                    imageView2.setVisibility(4);
                    imageView3.setVisibility(8);
                    imageView4.setVisibility(8);
                    Option option = new Option();
                    option.O00000Oo = R.drawable.default_pic_small_inverse;
                    option.O0000O0o = dul.O000000o(imageView.getContext(), 10.0f);
                    option.O0000Ooo = true;
                    option.O0000OoO = true;
                    int i2 = Resources.getSystem().getDisplayMetrics().widthPixels;
                    if (i2 != 0) {
                        double O000000o3 = (double) (i2 - dul.O000000o(imageView.getContext(), 30.0f));
                        Double.isNaN(O000000o3);
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = (int) (O000000o3 / 2.1d);
                        imageView.setLayoutParams(layoutParams);
                    }
                    duh.O000000o().O000000o(ewf.O00000Oo.get(0).f3929O000000o, imageView, option);
                }
                if (ewf.O00000Oo.size() >= 3) {
                    Option option2 = new Option();
                    option2.O00000Oo = R.drawable.default_pic_small_inverse;
                    option2.O0000O0o = dul.O000000o(imageView2.getContext(), 10.0f);
                    option2.O0000OoO = true;
                    option2.O0000Ooo = true;
                    option2.O0000Oo = true;
                    Option option3 = new Option();
                    option3.O00000Oo = R.drawable.default_pic_small_inverse;
                    option3.O0000O0o = dul.O000000o(imageView3.getContext(), 10.0f);
                    option3.O0000OoO = true;
                    option3.O0000Ooo = true;
                    option3.O0000Oo0 = true;
                    Option option4 = new Option();
                    option4.O00000Oo = R.drawable.default_pic_small_inverse;
                    option4.O0000O0o = dul.O000000o(imageView4.getContext(), 10.0f);
                    option4.O0000OoO = true;
                    option4.O0000Ooo = true;
                    option4.O0000Oo0 = true;
                    option4.O0000Oo = true;
                    int i3 = Resources.getSystem().getDisplayMetrics().widthPixels;
                    if (i3 != 0) {
                        double O000000o4 = (double) (i3 - dul.O000000o(imageView2.getContext(), 30.0f));
                        Double.isNaN(O000000o4);
                        int i4 = (int) (O000000o4 / 2.1d);
                        int O000000o5 = dul.O000000o(imageView2.getContext(), 100.0f);
                        TextView textView7 = textView3;
                        textView2 = textView4;
                        double d = (double) i4;
                        Double.isNaN(d);
                        int i5 = (int) (d / 2.05d);
                        textView = textView7;
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) imageView2.getLayoutParams();
                        layoutParams2.width = (i3 - dul.O000000o(imageView2.getContext(), 34.0f)) - O000000o5;
                        layoutParams2.height = i4;
                        imageView2.setLayoutParams(layoutParams2);
                        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) imageView3.getLayoutParams();
                        layoutParams3.width = O000000o5;
                        layoutParams3.height = i5;
                        imageView3.setLayoutParams(layoutParams3);
                        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) imageView4.getLayoutParams();
                        layoutParams4.width = O000000o5;
                        layoutParams4.height = i5;
                        imageView4.setLayoutParams(layoutParams4);
                    } else {
                        textView = textView3;
                        textView2 = textView4;
                    }
                    duh.O000000o().O000000o(ewf.O00000Oo.get(0).f3929O000000o, imageView2, option2);
                    duh.O000000o().O000000o(ewf.O00000Oo.get(1).f3929O000000o, imageView3, option3);
                    duh.O000000o().O000000o(ewf.O00000Oo.get(2).f3929O000000o, imageView4, option4);
                    if (o000000o.O00000o != null && !TextUtils.isEmpty(o000000o.O00000o)) {
                        textView.setText(o000000o.O00000o);
                    }
                    if (o000000o.O0000Oo0 != null && !TextUtils.isEmpty(o000000o.O0000Oo0)) {
                        textView2.setText(o000000o.O0000Oo0);
                    }
                    if (!(this.O00000o0 == null || ewr.O0000oo0.get(0).f15902O000000o == null || TextUtils.isEmpty(ewr.O0000oo0.get(0).f15902O000000o))) {
                        this.O00000o0.O000000o(ewr.O00000Oo, ewr.O0000oo0.get(0));
                    }
                    final vr vrVar2 = vrVar;
                    vrVar2.O000000o(R.id.id_discover_gallery_1);
                    vrVar2.O000000o(R.id.id_discover_gallery_2);
                    vrVar2.O000000o(R.id.id_discover_gallery_3);
                    final int i6 = i;
                    imageView2.setOnClickListener(new View.OnClickListener() {
                        /* class _m_j.evn.AnonymousClass1 */

                        public final void onClick(View view) {
                            evn.this.O000000o(ewr);
                        }
                    });
                    imageView3.setOnClickListener(new View.OnClickListener() {
                        /* class _m_j.evn.AnonymousClass2 */

                        public final void onClick(View view) {
                            evn.this.O000000o(ewr);
                        }
                    });
                    imageView4.setOnClickListener(new View.OnClickListener() {
                        /* class _m_j.evn.AnonymousClass3 */

                        public final void onClick(View view) {
                            evn.this.O000000o(ewr);
                        }
                    });
                }
            }
        }
        textView = textView3;
        textView2 = textView4;
        textView.setText(o000000o.O00000o);
        textView2.setText(o000000o.O0000Oo0);
        this.O00000o0.O000000o(ewr.O00000Oo, ewr.O0000oo0.get(0));
        final vr vrVar22 = vrVar;
        vrVar22.O000000o(R.id.id_discover_gallery_1);
        vrVar22.O000000o(R.id.id_discover_gallery_2);
        vrVar22.O000000o(R.id.id_discover_gallery_3);
        final int i62 = i;
        imageView2.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.evn.AnonymousClass1 */

            public final void onClick(View view) {
                evn.this.O000000o(ewr);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.evn.AnonymousClass2 */

            public final void onClick(View view) {
                evn.this.O000000o(ewr);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.evn.AnonymousClass3 */

            public final void onClick(View view) {
                evn.this.O000000o(ewr);
            }
        });
    }

    public final /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        O000000o((ewr) obj);
    }

    public evn(eum eum) {
        this.O00000o0 = eum;
    }

    public evn() {
    }

    public final void O000000o(ewr ewr) {
        if (this.O00000o0 != null) {
            if (ewr.O0000oo0.get(0).O0000oO0 != null && !TextUtils.isEmpty(ewr.O0000oo0.get(0).O0000oO0)) {
                new Gson().fromJson(ewr.O0000oo0.get(0).O0000oO0, ewf.class);
            }
            ewr.O0000oo0.get(0);
            ewr.O0000oo0.get(0);
        }
    }
}
