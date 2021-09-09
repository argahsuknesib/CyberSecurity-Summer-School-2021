package com.imagepicker.utils;

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
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public class SimpleListDialog extends MLAlertDialog {

    /* renamed from: O000000o  reason: collision with root package name */
    public O00000Oo f4478O000000o;
    public CharSequence[] O00000Oo;
    public O000000o O00000o;
    public String O00000o0;
    public View.OnClickListener O00000oO;
    public View.OnClickListener O00000oo;
    public int O0000O0o;
    public int O0000OOo;
    private ListView O0000Oo;
    private TextView O0000Oo0;
    private LinearLayout O0000OoO;
    private Button O0000Ooo;
    private int O0000o0;
    private Button O0000o00;
    private int O0000o0O;

    public interface O000000o {
        void O000000o(int i);
    }

    public SimpleListDialog(Context context) {
        this(context, (byte) 0);
    }

    private SimpleListDialog(Context context, byte b) {
        super(context, 2132739282);
    }

    public void onCreate(Bundle bundle) {
        View inflate = LayoutInflater.from(this.mContext).inflate((int) R.layout.simple_list_dialog, (ViewGroup) null);
        this.O0000OoO = (LinearLayout) inflate.findViewById(R.id.buttonPanel);
        this.O0000o00 = (Button) inflate.findViewById(R.id.button2);
        int i = this.O0000o0O;
        if (i > 0) {
            this.O0000o00.setText(i);
        }
        this.O0000o00.setOnClickListener(new View.OnClickListener() {
            /* class com.imagepicker.utils.SimpleListDialog.AnonymousClass1 */

            public final void onClick(View view) {
                if (SimpleListDialog.this.O00000oo != null) {
                    SimpleListDialog.this.O00000oo.onClick(view);
                }
                SimpleListDialog.this.dismiss();
            }
        });
        this.O0000Ooo = (Button) inflate.findViewById(R.id.button1);
        int i2 = this.O0000o0;
        if (i2 > 0) {
            this.O0000Ooo.setText(i2);
        }
        this.O0000Ooo.setOnClickListener(new View.OnClickListener() {
            /* class com.imagepicker.utils.SimpleListDialog.AnonymousClass2 */

            public final void onClick(View view) {
                if (SimpleListDialog.this.O00000oO != null) {
                    SimpleListDialog.this.O00000oO.onClick(view);
                }
                SimpleListDialog.this.dismiss();
            }
        });
        this.O0000Oo0 = (TextView) inflate.findViewById(R.id.title);
        this.O0000Oo = (ListView) inflate.findViewById(R.id.listview);
        this.f4478O000000o = new O00000Oo(this, (byte) 0);
        this.O0000Oo.setAdapter((ListAdapter) this.f4478O000000o);
        if (!TextUtils.isEmpty(this.O00000o0)) {
            this.O0000Oo0.setVisibility(0);
            this.O0000Oo0.setText(this.O00000o0);
        } else {
            this.O0000Oo0.setVisibility(8);
        }
        int i3 = this.O0000O0o;
        if (i3 == 0) {
            this.O0000OoO.setVisibility(8);
        } else if (i3 == 1) {
            this.O0000OoO.setVisibility(0);
        }
        setView(inflate);
        super.onCreate(bundle);
    }

    class O00000Oo extends BaseAdapter {
        public final long getItemId(int i) {
            return (long) i;
        }

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(SimpleListDialog simpleListDialog, byte b) {
            this();
        }

        public final int getCount() {
            return SimpleListDialog.this.O00000Oo.length;
        }

        public final Object getItem(int i) {
            return SimpleListDialog.this.O00000Oo[i];
        }

        class O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f4483O000000o;
            ImageView O00000Oo;

            private O000000o() {
            }

            /* synthetic */ O000000o(O00000Oo o00000Oo, byte b) {
                this();
            }
        }

        public final int getItemViewType(int i) {
            return SimpleListDialog.this.O0000O0o;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            O000000o o000000o;
            int itemViewType = getItemViewType(i);
            int i2 = itemViewType != 0 ? itemViewType != 1 ? 0 : R.layout.dialog_list_item_single_choice : R.layout.simple_list_dialog_item;
            if (view == null) {
                view = LayoutInflater.from(SimpleListDialog.this.getContext()).inflate(i2, (ViewGroup) null);
                o000000o = new O000000o(this, (byte) 0);
                o000000o.f4483O000000o = (TextView) view.findViewById(R.id.textview);
                o000000o.O00000Oo = (ImageView) view.findViewById(R.id.icon);
                view.setTag(o000000o);
            } else {
                o000000o = (O000000o) view.getTag();
            }
            o000000o.f4483O000000o.setText((CharSequence) getItem(i));
            if (SimpleListDialog.this.O0000O0o == 0) {
                o000000o.f4483O000000o.setTextColor(SimpleListDialog.this.mContext.getResources().getColor(R.color.mj_color_gray_heavier));
            } else if (SimpleListDialog.this.O0000O0o == 1) {
                o000000o.f4483O000000o.setTextColor(SimpleListDialog.this.mContext.getResources().getColor(R.color.select_dialog_single_color));
                if (i == SimpleListDialog.this.O0000OOo) {
                    o000000o.O00000Oo.setVisibility(0);
                } else {
                    o000000o.O00000Oo.setVisibility(4);
                }
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.imagepicker.utils.SimpleListDialog.O00000Oo.AnonymousClass1 */

                public final void onClick(View view) {
                    if (SimpleListDialog.this.O00000o != null) {
                        SimpleListDialog.this.O00000o.O000000o(i);
                    }
                    if (SimpleListDialog.this.O0000O0o == 0) {
                        SimpleListDialog.this.dismiss();
                    } else if (SimpleListDialog.this.O0000O0o == 1) {
                        SimpleListDialog.this.O0000OOo = i;
                        SimpleListDialog.this.f4478O000000o.notifyDataSetChanged();
                    } else {
                        throw new IllegalArgumentException("unknown list mode");
                    }
                }
            });
            return view;
        }
    }
}
