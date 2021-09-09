package com.xiaomi.smarthome.library.common.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class SimpleListDialog extends MLAlertDialog {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f9101O000000o;
    public CharSequence[] O00000Oo;
    public View.OnClickListener O00000o;
    public View.OnClickListener O00000o0;
    public int O00000oO;
    public int O00000oo;
    private TextView O0000O0o;
    private ListView O0000OOo;
    private Button O0000Oo;
    private LinearLayout O0000Oo0;
    private Button O0000OoO;
    private String O0000Ooo;
    private int O0000o0;
    private int O0000o00;

    public SimpleListDialog(Context context) {
        this(context, (byte) 0);
    }

    private SimpleListDialog(Context context, byte b) {
        super(context, 2132739282);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        View inflate = LayoutInflater.from(this.mContext).inflate((int) R.layout.simple_list_dialog, (ViewGroup) null);
        this.O0000Oo0 = (LinearLayout) inflate.findViewById(R.id.buttonPanel);
        this.O0000OoO = (Button) inflate.findViewById(R.id.button2);
        int i = this.O0000o0;
        if (i > 0) {
            this.O0000OoO.setText(i);
        }
        this.O0000OoO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.library.common.dialog.SimpleListDialog.AnonymousClass1 */

            public final void onClick(View view) {
                if (SimpleListDialog.this.O00000o != null) {
                    SimpleListDialog.this.O00000o.onClick(view);
                }
                SimpleListDialog.this.dismiss();
            }
        });
        this.O0000Oo = (Button) inflate.findViewById(R.id.button1);
        int i2 = this.O0000o00;
        if (i2 > 0) {
            this.O0000Oo.setText(i2);
        }
        this.O0000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.library.common.dialog.SimpleListDialog.AnonymousClass2 */

            public final void onClick(View view) {
                if (SimpleListDialog.this.O00000o0 != null) {
                    SimpleListDialog.this.O00000o0.onClick(view);
                }
                SimpleListDialog.this.dismiss();
            }
        });
        this.O0000O0o = (TextView) inflate.findViewById(R.id.title);
        this.O0000OOo = (ListView) inflate.findViewById(R.id.listview);
        this.f9101O000000o = new O000000o(this, (byte) 0);
        this.O0000OOo.setAdapter((ListAdapter) this.f9101O000000o);
        if (!TextUtils.isEmpty(this.O0000Ooo)) {
            this.O0000O0o.setVisibility(0);
            this.O0000O0o.setText(this.O0000Ooo);
        } else {
            this.O0000O0o.setVisibility(8);
        }
        int i3 = this.O00000oO;
        if (i3 == 0) {
            this.O0000Oo0.setVisibility(8);
        } else if (i3 == 1) {
            this.O0000Oo0.setVisibility(0);
        }
        setView(inflate);
        super.onCreate(bundle);
    }

    class O000000o extends BaseAdapter {
        public final long getItemId(int i) {
            return (long) i;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(SimpleListDialog simpleListDialog, byte b) {
            this();
        }

        public final int getCount() {
            return SimpleListDialog.this.O00000Oo.length;
        }

        public final Object getItem(int i) {
            return SimpleListDialog.this.O00000Oo[i];
        }

        /* renamed from: com.xiaomi.smarthome.library.common.dialog.SimpleListDialog$O000000o$O000000o  reason: collision with other inner class name */
        class C0079O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f9106O000000o;
            ImageView O00000Oo;

            private C0079O000000o() {
            }

            /* synthetic */ C0079O000000o(O000000o o000000o, byte b) {
                this();
            }
        }

        public final int getItemViewType(int i) {
            return SimpleListDialog.this.O00000oO;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            C0079O000000o o000000o;
            int itemViewType = getItemViewType(i);
            int i2 = itemViewType != 0 ? itemViewType != 1 ? 0 : R.layout.dialog_list_item_single_choice : R.layout.simple_list_dialog_item;
            if (view == null) {
                view = LayoutInflater.from(SimpleListDialog.this.getContext()).inflate(i2, (ViewGroup) null);
                o000000o = new C0079O000000o(this, (byte) 0);
                o000000o.f9106O000000o = (TextView) view.findViewById(R.id.textview);
                o000000o.O00000Oo = (ImageView) view.findViewById(R.id.icon);
                view.setTag(o000000o);
            } else {
                o000000o = (C0079O000000o) view.getTag();
            }
            o000000o.f9106O000000o.setText((CharSequence) getItem(i));
            if (SimpleListDialog.this.O00000oO == 0) {
                o000000o.f9106O000000o.setTextColor(SimpleListDialog.this.mContext.getResources().getColor(R.color.mj_color_gray_heavier));
            } else if (SimpleListDialog.this.O00000oO == 1) {
                o000000o.f9106O000000o.setTextColor(SimpleListDialog.this.mContext.getResources().getColor(R.color.select_dialog_single_color));
                if (i == SimpleListDialog.this.O00000oo) {
                    o000000o.O00000Oo.setVisibility(0);
                } else {
                    o000000o.O00000Oo.setVisibility(4);
                }
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.library.common.dialog.SimpleListDialog.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    if (SimpleListDialog.this.O00000oO == 0) {
                        SimpleListDialog.this.dismiss();
                    } else if (SimpleListDialog.this.O00000oO == 1) {
                        SimpleListDialog.this.O00000oo = i;
                        SimpleListDialog.this.f9101O000000o.notifyDataSetChanged();
                    } else {
                        throw new IllegalArgumentException("unknown list mode");
                    }
                }
            });
            return view;
        }
    }
}
