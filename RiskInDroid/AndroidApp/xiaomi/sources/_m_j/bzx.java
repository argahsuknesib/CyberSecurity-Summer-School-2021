package _m_j;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.xiaomi.smarthome.R;

public final class bzx extends Fragment {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.shop_fragment_image_view, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        String string = getArguments().getString("image");
        if (!TextUtils.isEmpty(string)) {
            ((ImageView) view).setImageBitmap(cbb.O000000o(string, 360, 360));
        }
    }

    public static bzx O000000o(String str) {
        bzx bzx = new bzx();
        Bundle bundle = new Bundle();
        bundle.putString("image", str);
        bzx.setArguments(bundle);
        return bzx;
    }
}
