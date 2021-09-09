package _m_j;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.base.imageloader.Option;
import com.xiaomi.smarthome.R;

public final class evi extends RecyclerView.O000000o<O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public ewr f15849O000000o;
    public eum O00000Oo;
    private Context O00000o0;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, final int i) {
        O000000o o000000o = (O000000o) o000OOo0;
        ewr ewr = this.f15849O000000o;
        if (ewr != null && !ewr.O0000oo0.isEmpty()) {
            String str = this.f15849O000000o.O0000oo0.get(i % this.f15849O000000o.O0000oo0.size()).O00000Oo;
            ImageView imageView = o000000o.f15851O000000o;
            Option option = new Option();
            option.O00000Oo = R.drawable.default_pic_small_inverse;
            option.O0000O0o = dul.O000000o(imageView.getContext(), 10.0f);
            duh.O000000o().O000000o(str, imageView, option);
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.evi.AnonymousClass1 */

                public final void onClick(View view) {
                    String str = evi.this.f15849O000000o.O0000oo0.get(i).O00000o0;
                    if (evi.this.O00000Oo != null && str != null && !TextUtils.isEmpty(str)) {
                        evi.this.O00000Oo.O000000o(evi.this.f15849O000000o.O00000Oo, evi.this.f15849O000000o.O0000oo0.get(i), "");
                    }
                }
            });
            eum eum = this.O00000Oo;
            if (eum != null) {
                eum.O000000o(this.f15849O000000o.O00000Oo, this.f15849O000000o.O0000oo0.get(i));
            }
        }
    }

    public evi(Context context, ewr ewr, eum eum) {
        this.O00000o0 = context;
        this.f15849O000000o = ewr;
        this.O00000Oo = eum;
    }

    public final int getItemCount() {
        ewr ewr = this.f15849O000000o;
        if (ewr != null) {
            return ewr.O0000oo0.size();
        }
        return 0;
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        ImageView f15851O000000o;

        O000000o(View view) {
            super(view);
            this.f15851O000000o = (ImageView) view.findViewById(R.id.image);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_discover_gallery, viewGroup, false));
    }
}
