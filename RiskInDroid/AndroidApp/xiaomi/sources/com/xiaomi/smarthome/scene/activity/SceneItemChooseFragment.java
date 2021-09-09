package com.xiaomi.smarthome.scene.activity;

import _m_j.fvm;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.List;

public class SceneItemChooseFragment extends fvm {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<ItemData> f10831O000000o;
    public ListView O00000Oo;
    O000000o O00000o;
    public ItemData O00000o0;
    private TextView O00000oO;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.item_choose_layout, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O00000Oo = (ListView) view.findViewById(R.id.content_list_view);
        this.O00000oO = (TextView) view.findViewById(R.id.setting_page_category_title);
        this.O00000o = new O000000o(this, (byte) 0);
        this.O00000Oo.setAdapter((ListAdapter) this.O00000o);
    }

    public final void O000000o(String str) {
        TextView textView = this.O00000oO;
        if (textView != null && str != null) {
            textView.setText(str);
        }
    }

    class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f10833O000000o;

        public final long getItemId(int i) {
            return 0;
        }

        private O000000o() {
            this.f10833O000000o = -1;
        }

        /* synthetic */ O000000o(SceneItemChooseFragment sceneItemChooseFragment, byte b) {
            this();
        }

        public final int getCount() {
            if (SceneItemChooseFragment.this.f10831O000000o != null) {
                return SceneItemChooseFragment.this.f10831O000000o.size();
            }
            return 0;
        }

        public final Object getItem(int i) {
            if (SceneItemChooseFragment.this.f10831O000000o != null && i >= 0 && i < SceneItemChooseFragment.this.f10831O000000o.size()) {
                return SceneItemChooseFragment.this.f10831O000000o.get(i);
            }
            return null;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, ?[OBJECT, ARRAY], int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(final int i, View view, ViewGroup viewGroup) {
            final O00000Oo o00000Oo;
            if (view == null) {
                view = LayoutInflater.from(SceneItemChooseFragment.this.getContext()).inflate((int) R.layout.wifi_choose_list_item, (ViewGroup) null, false);
                o00000Oo = new O00000Oo();
                o00000Oo.f10835O000000o = (TextView) view.findViewById(R.id.wifi_text);
                o00000Oo.O00000Oo = (ImageView) view.findViewById(R.id.select_flag_image);
                view.setTag(o00000Oo);
            } else {
                o00000Oo = (O00000Oo) view.getTag();
            }
            final ItemData itemData = SceneItemChooseFragment.this.f10831O000000o.get(i);
            if (itemData != null) {
                o00000Oo.f10835O000000o.setText(itemData.O00000Oo);
                if (itemData.equals(SceneItemChooseFragment.this.O00000o0)) {
                    o00000Oo.O00000Oo.setImageResource(R.drawable.wifi_check_press);
                    this.f10833O000000o = i;
                } else {
                    o00000Oo.O00000Oo.setImageResource(R.drawable.wifi_check_normal);
                }
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.SceneItemChooseFragment.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    O00000Oo o00000Oo;
                    if (O000000o.this.f10833O000000o != i) {
                        if (!(O000000o.this.f10833O000000o == -1 || (o00000Oo = (O00000Oo) SceneItemChooseFragment.this.O00000Oo.getChildAt(O000000o.this.f10833O000000o).getTag()) == null)) {
                            o00000Oo.O00000Oo.setImageResource(R.drawable.wifi_check_normal);
                            o00000Oo.O00000Oo.invalidate();
                        }
                        o00000Oo.O00000Oo.setImageResource(R.drawable.wifi_check_press);
                        o00000Oo.O00000Oo.invalidate();
                        SceneItemChooseFragment.this.O00000o0 = itemData;
                        O000000o.this.f10833O000000o = i;
                    }
                }
            });
            return view;
        }
    }

    static class ItemData implements Parcelable {
        public static final Parcelable.Creator<ItemData> CREATOR = new Parcelable.Creator<ItemData>() {
            /* class com.xiaomi.smarthome.scene.activity.SceneItemChooseFragment.ItemData.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ItemData[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ItemData(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public String f10832O000000o;
        public String O00000Oo;

        public int describeContents() {
            return 0;
        }

        public ItemData() {
        }

        public ItemData(Parcel parcel) {
            this.f10832O000000o = parcel.readString();
            this.O00000Oo = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f10832O000000o);
            parcel.writeString(this.O00000Oo);
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f10835O000000o;
        public ImageView O00000Oo;

        O00000Oo() {
        }
    }
}
