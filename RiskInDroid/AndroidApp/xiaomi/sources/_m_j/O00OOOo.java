package _m_j;

import O000000o.O000000o.O00000Oo.d;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hannto.print.bean.PhotoBean;
import com.hannto.print.entity.PickPhotoEntity;
import com.hannto.print.pickimage.activity.CameraActivity;
import com.hannto.print.pickimage.activity.PickPhotoPreviewActivity;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class O00OOOo extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    public RecyclerView f6633O000000o;
    public LinearLayout O00000Oo;
    public d O00000o;
    public LinearLayout O00000o0;
    public List<O00O00o0> O00000oO;
    public Comparator<String> O00000oo = null;
    public int O0000O0o = 0;
    public ArrayList<PhotoBean> O0000OOo;
    public int O0000Oo;
    public O00O000o O0000Oo0;
    public int O0000OoO;
    public boolean O0000Ooo;
    public Handler O0000o0 = new Handler(new O000000o());
    public PickPhotoEntity O0000o00;

    public class O000000o implements Handler.Callback {
        public O000000o() {
        }

        public final boolean handleMessage(Message message) {
            if (message.what != 2) {
                return false;
            }
            O00OOOo.O000000o(O00OOOo.this);
            return false;
        }
    }

    public class O00000Oo implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ PhotoBean f6635O000000o;

        public O00000Oo(PhotoBean photoBean) {
            this.f6635O000000o = photoBean;
        }

        public final void onClick(View view) {
            O00OOOo.this.O000000o(this.f6635O000000o);
        }
    }

    /* access modifiers changed from: private */
    public void O000000o() {
        Intent intent = new Intent(getContext(), CameraActivity.class);
        intent.putExtra("intent_pick_photo_config", this.O0000o00);
        getActivity().startActivityForResult(intent, 3001);
        if (!this.O0000Ooo) {
            getActivity().overridePendingTransition(0, 0);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public static /* synthetic */ void O000000o(O00OOOo o00OOOo) {
        LinearLayout linearLayout;
        List<O00O00o0> list = o00OOOo.O00000oO;
        boolean z = true;
        if (list == null || list.size() == 0) {
            int i = o00OOOo.getResources().getDisplayMetrics().widthPixels / 4;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            o00OOOo.O00000o0 = new LinearLayout(o00OOOo.getActivity());
            o00OOOo.O00000o0.setOrientation(1);
            LinearLayout linearLayout2 = new LinearLayout(o00OOOo.getActivity());
            TextView textView = new TextView(o00OOOo.getActivity());
            textView.setPadding(20, 20, 20, 20);
            textView.setText((int) R.string.ht_photo_date_today_sub);
            textView.setTextColor(-16777216);
            textView.setTextSize(12.0f);
            linearLayout2.addView(textView, layoutParams2);
            o00OOOo.O00000Oo.addView(linearLayout2, layoutParams2);
            if (o00OOOo.O00000o0.getChildCount() != 0) {
                LinearLayout linearLayout3 = o00OOOo.O00000o0;
                linearLayout = (LinearLayout) linearLayout3.getChildAt(linearLayout3.getChildCount() - 1);
                if (linearLayout.getChildCount() < 4) {
                    z = false;
                }
            } else {
                linearLayout = null;
            }
            if (z) {
                linearLayout = new LinearLayout(o00OOOo.getActivity());
                linearLayout.setOrientation(0);
                o00OOOo.O00000o0.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
            }
            LinearLayout linearLayout4 = (LinearLayout) LayoutInflater.from(o00OOOo.getActivity()).inflate((int) R.layout.ht_layout_cameraview_item, (ViewGroup) null, false);
            linearLayout4.findViewById(R.id.view_alpha).setOnClickListener(new O00O00o(new O00Oo00(o00OOOo)));
            linearLayout.addView(linearLayout4, layoutParams);
            o00OOOo.O00000Oo.addView(o00OOOo.O00000o0, layoutParams2);
            return;
        }
        o00OOOo.O0000Oo0 = new O00O000o(o00OOOo.O00000oO.get(o00OOOo.O0000O0o).O00000o, o00OOOo.getActivity());
        o00OOOo.O0000Oo0.O0000O0o = new O00O0O0o(new O00OOo0(o00OOOo));
        o00OOOo.f6633O000000o.setAdapter(o00OOOo.O0000Oo0);
        o00OOOo.O0000Oo0.notifyDataSetChanged();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.ht_fragment_pick_photo, (ViewGroup) null);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6633O000000o = (RecyclerView) view.findViewById(R.id.photo_recycler_view);
        this.f6633O000000o.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        this.O00000Oo = (LinearLayout) view.findViewById(R.id.album_containter);
        view.findViewById(R.id.layout_noting);
        this.O0000o00 = (PickPhotoEntity) getActivity().getIntent().getParcelableExtra("intent_pick_photo_config");
        this.O0000Ooo = this.O0000o00.O00000oO;
        this.O0000Oo = this.O0000o00.O00000Oo;
        this.O0000OoO = this.O0000o00.O00000o0;
    }

    public static /* synthetic */ void O000000o(O00OOOo o00OOOo, PhotoBean photoBean) {
        if (o00OOOo.O0000OOo.contains(photoBean)) {
            o00OOOo.O0000OOo.remove(photoBean);
        } else {
            int i = d.O000000o().O0000Oo;
            if (o00OOOo.O0000OOo.size() >= i) {
                FragmentActivity activity = o00OOOo.getActivity();
                Toast.makeText(activity, "选择的照片数量不能超过" + i + "张", 0).show();
                return;
            } else if (ayy.O000000o(photoBean.imagePath, o00OOOo.O0000Oo, o00OOOo.O0000OoO)) {
                ayy.O000000o(o00OOOo.getActivity(), o00OOOo.O0000Oo, o00OOOo.O0000OoO, new O00OOo(o00OOOo, photoBean));
                return;
            } else {
                o00OOOo.O0000OOo.add(photoBean);
            }
        }
        o00OOOo.O0000Oo0.notifyDataSetChanged();
    }

    public static /* synthetic */ void O000000o(O00OOOo o00OOOo, PhotoBean photoBean, int i) {
        if (photoBean == null) {
            return;
        }
        if (photoBean.isCameraView) {
            o00OOOo.O000000o();
        } else if (d.O000000o().O0000Oo0 == d.a.Multiple) {
            Intent intent = new Intent(o00OOOo.getActivity(), PickPhotoPreviewActivity.class);
            intent.putExtra("intent_selected_album_num", o00OOOo.O0000O0o);
            intent.putExtra("intent_selected_position_in_all", i);
            intent.putExtra("intent_pick_photo_config", o00OOOo.O0000o00);
            o00OOOo.getActivity().startActivityForResult(intent, 2001);
            if (!o00OOOo.O0000Ooo) {
                o00OOOo.getActivity().overridePendingTransition(0, 0);
            }
        } else if (ayy.O000000o(photoBean.imagePath, o00OOOo.O0000Oo, o00OOOo.O0000OoO)) {
            ayy.O000000o(o00OOOo.getActivity(), o00OOOo.O0000Oo, o00OOOo.O0000OoO, new O00000Oo(photoBean));
        } else {
            o00OOOo.O000000o(photoBean);
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(PhotoBean photoBean) {
        Intent intent = new Intent();
        FragmentActivity activity = getActivity();
        intent.putExtra("photo_paths", new String[]{photoBean.imagePath});
        activity.setResult(1001, intent);
        activity.finish();
    }
}
