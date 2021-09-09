package com.xiaomi.smarthome.library.common.dialog;

import _m_j.gnn;
import _m_j.gwg;
import _m_j.hzf;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;

public class MenuDialog extends Dialog {

    /* renamed from: O000000o  reason: collision with root package name */
    CharSequence[] f9097O000000o;
    DialogInterface.OnClickListener O00000Oo;
    BaseAdapter O00000o;
    ListView O00000o0;
    LayoutInflater O00000oO;
    int O00000oo = -1;

    public MenuDialog(Context context) {
        super(context, 2132739288);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(1);
        getWindow().addFlags(1024);
        getWindow().setGravity(48);
        if (!gnn.O00000oo) {
            gwg.O000000o(getWindow());
        }
        this.O00000oO = LayoutInflater.from(getContext());
        View inflate = this.O00000oO.inflate((int) R.layout.menu_dialog, (ViewGroup) null);
        getWindow().setContentView(inflate);
        int i = this.O00000oo;
        if (i > 0) {
            inflate.setBackgroundColor(i);
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.y = 0;
        attributes.width = -1;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        this.O00000o0 = (ListView) findViewById(R.id.select_dialog_listview);
        this.O00000o0.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.library.common.dialog.MenuDialog.AnonymousClass1 */

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (MenuDialog.this.O00000Oo != null) {
                    MenuDialog.this.dismiss();
                    MenuDialog.this.O00000Oo.onClick(null, i);
                }
            }
        });
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.library.common.dialog.MenuDialog.AnonymousClass2 */

            public final void onClick(View view) {
                MenuDialog.this.dismiss();
            }
        });
        if (this.O00000o == null && this.f9097O000000o != null) {
            this.O00000o = new BaseAdapter() {
                /* class com.xiaomi.smarthome.library.common.dialog.MenuDialog.AnonymousClass3 */

                public final long getItemId(int i) {
                    return 0;
                }

                public final int getCount() {
                    return MenuDialog.this.f9097O000000o.length;
                }

                public final Object getItem(int i) {
                    return MenuDialog.this.f9097O000000o[i];
                }

                public final View getView(int i, View view, ViewGroup viewGroup) {
                    if (view == null) {
                        view = MenuDialog.this.O00000oO.inflate((int) R.layout.menu_dialog_item, (ViewGroup) null);
                    }
                    ((TextView) view.findViewById(R.id.text1)).setText(MenuDialog.this.f9097O000000o[i]);
                    return view;
                }
            };
        }
        BaseAdapter baseAdapter = this.O00000o;
        if (baseAdapter != null) {
            this.O00000o0.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        dismiss();
    }

    public void onContentChanged() {
        super.onContentChanged();
        gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.O00000o0);
    }
}
