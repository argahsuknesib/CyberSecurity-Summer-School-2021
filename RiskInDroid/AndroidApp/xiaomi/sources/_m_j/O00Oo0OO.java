package _m_j;

import O000000o.O000000o.O00000Oo.d;
import _m_j.O00O0Oo;
import _m_j.ayy;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import java.util.Iterator;
import java.util.List;

public final class O00Oo0OO extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    public RecyclerView f6643O000000o;
    public LinearLayout O00000Oo;
    public RelativeLayout O00000o;
    public LinearLayout O00000o0;
    public d O00000oO;
    public List<O00O00o0> O00000oo;
    public Comparator<String> O0000O0o = null;
    public int O0000OOo = 0;
    public O00O000o O0000Oo;
    public ArrayList<PhotoBean> O0000Oo0;
    public int O0000OoO;
    public int O0000Ooo;
    public PickPhotoEntity O0000o0;
    public boolean O0000o00;
    public dz O0000o0O;
    public Handler O0000o0o = new Handler(new O000000o());

    public class O000000o implements Handler.Callback {
        public O000000o() {
        }

        public final boolean handleMessage(Message message) {
            if (message.what != 2) {
                return false;
            }
            O00Oo0OO.O000000o(O00Oo0OO.this);
            return false;
        }
    }

    public class O00000Oo implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ PhotoBean f6645O000000o;

        public O00000Oo(PhotoBean photoBean) {
            this.f6645O000000o = photoBean;
        }

        public final void onClick(View view) {
            O00Oo0OO.this.O000000o(this.f6645O000000o);
        }
    }

    public class O00000o0 implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ ArrayList f6646O000000o;
        public final /* synthetic */ FragmentActivity O00000Oo;

        public class O000000o implements ayy.O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            public final /* synthetic */ ArrayList f6647O000000o;

            public O000000o(ArrayList arrayList) {
                this.f6647O000000o = arrayList;
            }

            public final void O000000o(int i, String str) {
                O00Oo0OO.O000000o(O00Oo0OO.this, str);
            }

            public final void O000000o(String str) {
                this.f6647O000000o.add(str);
            }
        }

        public class O00000Oo implements Runnable {
            public O00000Oo() {
            }

            public final void run() {
                O00Oo0OO.this.O0000o0O.dismissAllowingStateLoss();
                O00000o0.this.O00000Oo.finish();
            }
        }

        public O00000o0(ArrayList arrayList, FragmentActivity fragmentActivity) {
            this.f6646O000000o = arrayList;
            this.O00000Oo = fragmentActivity;
        }

        public final void run() {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f6646O000000o.iterator();
            while (it.hasNext()) {
                FragmentActivity fragmentActivity = this.O00000Oo;
                ayy.O000000o(ayz.O000000o(fragmentActivity, O00Oo0OO.this.O0000o0.O000000o(), ayz.O00000o0(fragmentActivity, (String) it.next())).getPath(), O00Oo0OO.this.O0000o0.O000000o(), Long.toString(System.currentTimeMillis()), O00Oo0OO.this.O0000o0.O0000OOo, O00Oo0OO.this.O0000o0.O0000Oo0, O00Oo0OO.this.O0000o0.O0000Oo, new O000000o(arrayList));
            }
            Intent intent = new Intent();
            intent.putExtra("intent_pick_image_path", arrayList);
            this.O00000Oo.setResult(-1, intent);
            this.O00000Oo.runOnUiThread(new O00000Oo());
        }
    }

    /* access modifiers changed from: private */
    public void O000000o() {
        Intent intent = new Intent(getContext(), CameraActivity.class);
        intent.putExtra("intent_pick_photo_config", this.O0000o0);
        getActivity().startActivityForResult(intent, 3001);
        if (!this.O0000o00) {
            getActivity().overridePendingTransition(0, 0);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public static /* synthetic */ void O000000o(O00Oo0OO o00Oo0OO) {
        LinearLayout linearLayout;
        O00O00o0 o00O00o0;
        List<O00O00o0> list = o00Oo0OO.O00000oo;
        boolean z = true;
        if ((list == null || list.size() == 0 || (o00O00o0 = o00Oo0OO.O00000oo.get(0)) == null || !o00O00o0.O00000Oo.equals("Camera")) ? false : true) {
            o00Oo0OO.O0000Oo = new O00O000o(o00Oo0OO.O00000oo.get(o00Oo0OO.O0000OOo).O00000o, o00Oo0OO.getActivity());
            o00Oo0OO.O0000Oo.O0000O0o = new O00O0O0o(new O00Oo0o0(o00Oo0OO));
            o00Oo0OO.f6643O000000o.setAdapter(o00Oo0OO.O0000Oo);
            o00Oo0OO.O0000Oo.notifyDataSetChanged();
        } else if (!o00Oo0OO.O0000o0.O00000o) {
            o00Oo0OO.O00000o.setVisibility(0);
        } else {
            int i = o00Oo0OO.getResources().getDisplayMetrics().widthPixels / 4;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            o00Oo0OO.O00000o0 = new LinearLayout(o00Oo0OO.getActivity());
            o00Oo0OO.O00000o0.setOrientation(1);
            LinearLayout linearLayout2 = new LinearLayout(o00Oo0OO.getActivity());
            TextView textView = new TextView(o00Oo0OO.getActivity());
            textView.setPadding(20, 20, 20, 20);
            textView.setText((int) R.string.ht_photo_date_today_sub);
            textView.setTextColor(-16777216);
            textView.setTextSize(12.0f);
            linearLayout2.addView(textView, layoutParams2);
            o00Oo0OO.O00000Oo.addView(linearLayout2, layoutParams2);
            if (o00Oo0OO.O00000o0.getChildCount() != 0) {
                LinearLayout linearLayout3 = o00Oo0OO.O00000o0;
                linearLayout = (LinearLayout) linearLayout3.getChildAt(linearLayout3.getChildCount() - 1);
                if (linearLayout.getChildCount() < 4) {
                    z = false;
                }
            } else {
                linearLayout = null;
            }
            if (z) {
                linearLayout = new LinearLayout(o00Oo0OO.getActivity());
                linearLayout.setOrientation(0);
                o00Oo0OO.O00000o0.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
            }
            LinearLayout linearLayout4 = (LinearLayout) LayoutInflater.from(o00Oo0OO.getActivity()).inflate((int) R.layout.ht_layout_cameraview_item, (ViewGroup) null, false);
            linearLayout4.findViewById(R.id.view_alpha).setOnClickListener(new O00O00o(new O00OoOO0(o00Oo0OO)));
            linearLayout.addView(linearLayout4, layoutParams);
            o00Oo0OO.O00000Oo.addView(o00Oo0OO.O00000o0, layoutParams2);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.ht_fragment_pick_photo, (ViewGroup) null);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f6643O000000o = (RecyclerView) view.findViewById(R.id.photo_recycler_view);
        this.f6643O000000o.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        this.O00000Oo = (LinearLayout) view.findViewById(R.id.album_containter);
        this.O00000o = (RelativeLayout) view.findViewById(R.id.layout_noting);
        this.O0000o0 = (PickPhotoEntity) getActivity().getIntent().getParcelableExtra("intent_pick_photo_config");
        this.O0000o00 = this.O0000o0.O00000oO;
        this.O0000OoO = this.O0000o0.O00000Oo;
        this.O0000Ooo = this.O0000o0.O00000o0;
    }

    public static /* synthetic */ void O000000o(O00Oo0OO o00Oo0OO, PhotoBean photoBean) {
        if (o00Oo0OO.O0000Oo0.contains(photoBean)) {
            o00Oo0OO.O0000Oo0.remove(photoBean);
        } else {
            int i = d.O000000o().O0000Oo;
            if (o00Oo0OO.O0000Oo0.size() >= i) {
                FragmentActivity activity = o00Oo0OO.getActivity();
                Toast.makeText(activity, "选择的照片数量不能超过" + i + "张", 0).show();
                return;
            } else if (ayy.O000000o(photoBean.imagePath, o00Oo0OO.O0000OoO, o00Oo0OO.O0000Ooo)) {
                ayy.O000000o(o00Oo0OO.getActivity(), o00Oo0OO.O0000OoO, o00Oo0OO.O0000Ooo, new O00Oo(o00Oo0OO, photoBean));
                return;
            } else {
                o00Oo0OO.O0000Oo0.add(photoBean);
            }
        }
        o00Oo0OO.O0000Oo.notifyDataSetChanged();
    }

    public static /* synthetic */ void O000000o(O00Oo0OO o00Oo0OO, PhotoBean photoBean, int i) {
        if (photoBean == null) {
            return;
        }
        if (photoBean.isCameraView) {
            o00Oo0OO.O000000o();
        } else if (d.O000000o().O0000Oo0 == d.a.Multiple) {
            Intent intent = new Intent(o00Oo0OO.getActivity(), PickPhotoPreviewActivity.class);
            intent.putExtra("intent_selected_album_num", o00Oo0OO.O0000OOo);
            intent.putExtra("intent_selected_position_in_all", i);
            intent.putExtra("intent_pick_photo_config", o00Oo0OO.O0000o0);
            o00Oo0OO.getActivity().startActivityForResult(intent, 2001);
            if (!o00Oo0OO.O0000o00) {
                o00Oo0OO.getActivity().overridePendingTransition(0, 0);
            }
        } else if (ayy.O000000o(photoBean.imagePath, o00Oo0OO.O0000OoO, o00Oo0OO.O0000Ooo)) {
            ayy.O000000o(o00Oo0OO.getActivity(), o00Oo0OO.O0000OoO, o00Oo0OO.O0000Ooo, new O00000Oo(photoBean));
        } else {
            o00Oo0OO.O000000o(photoBean);
        }
    }

    public static /* synthetic */ void O000000o(O00Oo0OO o00Oo0OO, String str) {
        Intent intent = new Intent();
        intent.putExtra("intent_pick_image_error", str);
        o00Oo0OO.getActivity().setResult(1005, intent);
        o00Oo0OO.getActivity().finish();
    }

    /* access modifiers changed from: private */
    public void O000000o(PhotoBean photoBean) {
        FragmentActivity activity = getActivity();
        ArrayList arrayList = new ArrayList();
        arrayList.add(photoBean.imagePath);
        this.O0000o0O = new O00O0Oo.O000000o(getActivity()).O000000o(new O00OoO0o()).O00000Oo().O000000o().O00000o0();
        new Thread(new O00000o0(arrayList, activity)).start();
    }
}
