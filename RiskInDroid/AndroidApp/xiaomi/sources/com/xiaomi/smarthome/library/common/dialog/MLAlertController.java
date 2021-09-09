package com.xiaomi.smarthome.library.common.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.lang.ref.WeakReference;

public final class MLAlertController {

    /* renamed from: O000000o  reason: collision with root package name */
    final Context f9084O000000o;
    public final DialogInterface O00000Oo;
    final boolean O00000o;
    final Window O00000o0;
    CharSequence O00000oO;
    CharSequence O00000oo;
    SpannableStringBuilder O0000O0o;
    public ListView O0000OOo;
    int O0000Oo;
    public View O0000Oo0;
    int O0000OoO;
    int O0000Ooo;
    int O0000o;
    boolean O0000o0;
    int O0000o00;
    public Button O0000o0O;
    CharSequence O0000o0o;
    public Button O0000oO;
    public Message O0000oO0;
    CharSequence O0000oOO;
    int O0000oOo;
    public Button O0000oo;
    public Message O0000oo0;
    CharSequence O0000ooO;
    int O0000ooo;
    int O000O00o;
    Drawable O000O0OO;
    ImageView O000O0Oo;
    View O000O0o;
    TextView O000O0o0;
    boolean O000O0oO;
    public ListAdapter O000O0oo;
    public int O000OO;
    public int O000OO00;
    int O000OO0o;
    public int O000OOOo;
    public int O000OOo;
    public int O000OOo0;
    public int O000OOoO;
    public int O000OOoo;
    public Handler O000Oo0;
    int O000Oo00;
    public boolean O000Oo0O;
    public boolean O000Oo0o;
    View.OnClickListener O000OoO;
    boolean O000OoO0;
    MLAlertDialog.ButtonStyle O00O0Oo;
    TextView O00oOoOo;
    public Message O00oOooO;
    ScrollView O00oOooo;

    static final class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<DialogInterface> f9093O000000o;

        public O000000o(DialogInterface dialogInterface) {
            this.f9093O000000o = new WeakReference<>(dialogInterface);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f9093O000000o.get(), message.what);
            } else if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public MLAlertController(Context context, DialogInterface dialogInterface, Window window, int i) {
        this(context, dialogInterface, false, window, i);
    }

    public MLAlertController(Context context, DialogInterface dialogInterface, boolean z, Window window, int i) {
        this.O0000o0 = false;
        this.O0000o = -1;
        this.O0000oOo = -1;
        this.O0000ooo = -1;
        this.O000O00o = -1;
        this.O000OO00 = -1;
        this.O000Oo0O = false;
        this.O000Oo0o = true;
        this.O000OoO0 = false;
        this.O00O0Oo = MLAlertDialog.ButtonStyle.Normal;
        this.O000OoO = new View.OnClickListener() {
            /* class com.xiaomi.smarthome.library.common.dialog.MLAlertController.AnonymousClass1 */

            public final void onClick(View view) {
                Message message;
                if (view == MLAlertController.this.O0000o0O && MLAlertController.this.O0000oO0 != null) {
                    message = Message.obtain(MLAlertController.this.O0000oO0);
                } else if (view != MLAlertController.this.O0000oO || MLAlertController.this.O0000oo0 == null) {
                    message = (view != MLAlertController.this.O0000oo || MLAlertController.this.O00oOooO == null) ? null : Message.obtain(MLAlertController.this.O00oOooO);
                } else {
                    message = Message.obtain(MLAlertController.this.O0000oo0);
                }
                if (message != null) {
                    message.sendToTarget();
                }
                if (MLAlertController.this.O000Oo0o) {
                    MLAlertController.this.O000Oo0.obtainMessage(1, MLAlertController.this.O00000Oo).sendToTarget();
                }
            }
        };
        this.f9084O000000o = context;
        this.O00000Oo = dialogInterface;
        this.O00000o0 = window;
        this.O00000o = z;
        this.O000Oo0 = new O000000o(dialogInterface);
        this.O000OO0o = z ? R.layout.ml_alert_dialog_miui : R.layout.ml_alert_dialog;
        this.O000OO = R.layout.ml_select_dialog;
        this.O000OOOo = R.layout.ml_select_dialog_center;
        this.O000OOo0 = R.layout.ml_select_dialog_multichoice;
        this.O000OOo = R.layout.ml_select_dialog_singlechoice;
        this.O000OOoO = R.layout.ml_select_dialog_item;
        this.O000OOoo = i;
    }

    static boolean O000000o(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (O000000o(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final void O000000o(CharSequence charSequence) {
        this.O00000oO = charSequence;
        TextView textView = this.O00oOoOo;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void O00000Oo(CharSequence charSequence) {
        this.O00000oo = charSequence;
        TextView textView = this.O000O0o0;
        if (textView != null) {
            textView.setGravity(this.O000Oo00);
            this.O000O0o0.setText(charSequence);
        }
    }

    public final void O00000Oo(View view) {
        this.O0000Oo0 = view;
        this.O0000o0 = false;
    }

    public final void O000000o(View view, int i, int i2, int i3, int i4) {
        this.O0000Oo0 = view;
        this.O0000o0 = true;
        this.O0000Oo = i;
        this.O0000OoO = i2;
        this.O0000Ooo = i3;
        this.O0000o00 = i4;
    }

    public final void O000000o(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.O000Oo0.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.O0000ooO = charSequence;
            this.O00oOooO = message;
        } else if (i == -2) {
            this.O0000oOO = charSequence;
            this.O0000oo0 = message;
        } else if (i == -1) {
            this.O0000o0o = charSequence;
            this.O0000oO0 = message;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void O000000o(int i) {
        this.O000O00o = i;
        ImageView imageView = this.O000O0Oo;
        if (imageView == null) {
            return;
        }
        if (i > 0) {
            imageView.setImageResource(this.O000O00o);
        } else if (i == 0) {
            imageView.setVisibility(8);
        }
    }

    public final void O000000o(Drawable drawable) {
        this.O000O0OO = drawable;
        ImageView imageView = this.O000O0Oo;
        if (imageView != null && this.O000O0OO != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public final void O000000o(int i, int i2) {
        if (i == -3) {
            this.O0000ooo = i2;
        } else if (i == -2) {
            this.O0000oOo = i2;
        } else if (i == -1) {
            this.O0000o = i2;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(TextView textView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        textView.setLayoutParams(layoutParams);
        textView.setBackgroundResource(this.O00000o ? R.drawable.normal_confirm_button_23_radius : R.drawable.dialog_btn_selector);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"ResourceType"})
    public final void O000000o(LinearLayout linearLayout, LinearLayout linearLayout2, View view, boolean z, boolean z2, View view2) {
        ListAdapter listAdapter;
        int i;
        if (this.O000Oo0O) {
            int color = this.f9084O000000o.getResources().getColor(17170445);
            int color2 = this.f9084O000000o.getResources().getColor(17170445);
            int color3 = this.f9084O000000o.getResources().getColor(17170445);
            int color4 = this.f9084O000000o.getResources().getColor(17170445);
            int color5 = this.f9084O000000o.getResources().getColor(17170445);
            int color6 = this.f9084O000000o.getResources().getColor(17170445);
            int color7 = this.f9084O000000o.getResources().getColor(17170445);
            int color8 = this.f9084O000000o.getResources().getColor(17170445);
            int color9 = this.f9084O000000o.getResources().getColor(17170445);
            View[] viewArr = new View[4];
            boolean[] zArr = new boolean[4];
            if (z2) {
                viewArr[0] = linearLayout;
                zArr[0] = false;
                i = 1;
            } else {
                i = 0;
            }
            viewArr[i] = linearLayout2.getVisibility() == 8 ? null : linearLayout2;
            zArr[i] = this.O0000OOo != null;
            int i2 = i + 1;
            if (view != null) {
                viewArr[i2] = view;
                zArr[i2] = this.O000O0oO;
                i2++;
            }
            if (z) {
                viewArr[i2] = view2;
                zArr[i2] = true;
            }
            View view3 = null;
            boolean z3 = false;
            boolean z4 = false;
            for (int i3 = 0; i3 < 4; i3++) {
                View view4 = viewArr[i3];
                if (view4 != null) {
                    if (view3 != null) {
                        if (!z4) {
                            view3.setBackgroundResource(z3 ? color6 : color2);
                        } else {
                            view3.setBackgroundResource(z3 ? color7 : color3);
                        }
                        z4 = true;
                    }
                    z3 = zArr[i3];
                    view3 = view4;
                }
            }
            if (view3 != null) {
                if (z4) {
                    if (!z3) {
                        color8 = color4;
                    } else if (z) {
                        color8 = color9;
                    }
                    view3.setBackgroundResource(color8);
                } else {
                    if (z3) {
                        color = color5;
                    }
                    view3.setBackgroundResource(color);
                }
            }
        }
        ListView listView = this.O0000OOo;
        if (listView != null && (listAdapter = this.O000O0oo) != null) {
            listView.setAdapter(listAdapter);
            int i4 = this.O000OO00;
            if (i4 >= 0) {
                this.O0000OOo.setItemChecked(i4, true);
                this.O0000OOo.setSelection(this.O000OO00);
            }
        }
    }

    public static class RecycleListView extends ListView {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f9094O000000o = true;

        public RecycleListView(Context context) {
            super(context);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public RecycleListView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    public static class AlertParams {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Context f9086O000000o;
        public final LayoutInflater O00000Oo;
        public int O00000o = 80;
        public int O00000o0 = 0;
        public int O00000oO = 17;
        public boolean O00000oo = true;
        public Drawable O0000O0o;
        public CharSequence O0000OOo;
        public CharSequence O0000Oo;
        public View O0000Oo0;
        public SpannableStringBuilder O0000OoO;
        public boolean O0000Ooo = true;
        public CharSequence O0000o;
        public DialogInterface.OnClickListener O0000o0;
        public CharSequence O0000o00;
        public CharSequence O0000o0O;
        public DialogInterface.OnClickListener O0000o0o;
        public boolean O0000oO;
        public DialogInterface.OnClickListener O0000oO0;
        public DialogInterface.OnCancelListener O0000oOO;
        public DialogInterface.OnKeyListener O0000oOo;
        public ListAdapter O0000oo;
        public CharSequence[] O0000oo0;
        public DialogInterface.OnClickListener O0000ooO;
        public View O0000ooo;
        public int O000O00o;
        public int O000O0OO;
        public boolean O000O0Oo = false;
        public boolean O000O0o;
        public boolean O000O0o0;
        public boolean O000O0oO = true;
        public int O000O0oo = -1;
        public String O000OO;
        public DialogInterface.OnMultiChoiceClickListener O000OO00;
        public Cursor O000OO0o;
        public String O000OOOo;
        public AdapterView.OnItemSelectedListener O000OOo;
        public boolean O000OOo0;
        public boolean O000OOoO = true;
        public boolean O000OOoo = true;
        public CharSequence O000Oo0;
        public MLAlertDialog.O000000o O000Oo00;
        public boolean O000Oo0O = false;
        public int O000Oo0o = -1;
        public boolean O000OoO = true;
        public int O000OoO0 = -1;
        public MLAlertDialog.ButtonStyle O000OoOO = MLAlertDialog.ButtonStyle.Normal;
        public int O00O0Oo = -1;
        public boolean[] O00oOoOo;
        public int O00oOooO;
        public int O00oOooo;

        public AlertParams(Context context) {
            this.f9086O000000o = context;
            this.O0000oO = true;
            this.O00000Oo = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r13v0, types: [android.widget.ListAdapter] */
        /* JADX WARN: Type inference failed for: r13v2 */
        /* JADX WARN: Type inference failed for: r13v7 */
        /* JADX WARN: Type inference failed for: r0v55, types: [com.xiaomi.smarthome.library.common.dialog.MLAlertController$AlertParams$4] */
        /* JADX WARN: Type inference failed for: r0v56, types: [com.xiaomi.smarthome.library.common.dialog.MLAlertController$AlertParams$3] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        public final void O000000o(MLAlertController mLAlertController) {
            ? r13;
            ListAdapter listAdapter;
            final MLAlertController mLAlertController2 = mLAlertController;
            int i = this.O00000o;
            if (i != 80) {
                mLAlertController2.O000OOoo = i;
                if (mLAlertController2.O00000o0 != null) {
                    mLAlertController2.O00000o0.setGravity(i);
                }
            }
            mLAlertController2.O000Oo00 = this.O00000oO;
            View view = this.O0000Oo0;
            if (view != null) {
                mLAlertController2.O000O0o = view;
            } else {
                CharSequence charSequence = this.O0000OOo;
                if (charSequence != null) {
                    mLAlertController2.O000000o(charSequence);
                }
                Drawable drawable = this.O0000O0o;
                if (drawable != null) {
                    mLAlertController2.O000000o(drawable);
                }
                int i2 = this.O00000o0;
                if (i2 >= 0) {
                    mLAlertController2.O000000o(i2);
                }
            }
            CharSequence charSequence2 = this.O0000Oo;
            if (charSequence2 != null) {
                mLAlertController2.O00000Oo(charSequence2);
            }
            if (!this.O000O0oO) {
                mLAlertController2.O000OOo = R.layout.ml_dialog_singlechoice;
            }
            SpannableStringBuilder spannableStringBuilder = this.O0000OoO;
            if (spannableStringBuilder != null) {
                mLAlertController2.O0000O0o = spannableStringBuilder;
                if (mLAlertController2.O000O0o0 != null) {
                    mLAlertController2.O000O0o0.setGravity(mLAlertController2.O000Oo00);
                    mLAlertController2.O000O0o0.setText(mLAlertController2.O0000O0o);
                    mLAlertController2.O000O0o0.setHighlightColor(0);
                    mLAlertController2.O000O0o0.setText(spannableStringBuilder);
                    mLAlertController2.O000O0o0.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
            CharSequence charSequence3 = this.O0000o00;
            if (charSequence3 != null) {
                mLAlertController2.O000000o(-1, charSequence3, this.O0000o0, null);
            }
            CharSequence charSequence4 = this.O0000o0O;
            if (charSequence4 != null) {
                mLAlertController2.O000000o(-2, charSequence4, this.O0000o0o, null);
            }
            CharSequence charSequence5 = this.O0000o;
            if (charSequence5 != null) {
                mLAlertController2.O000000o(-3, charSequence5, this.O0000oO0, null);
            }
            if (this.O000OOo0) {
                mLAlertController2.O000O0oO = true;
            }
            mLAlertController2.O000Oo0O = false;
            if (!(this.O0000oo0 == null && this.O000OO0o == null && this.O0000oo == null)) {
                if (mLAlertController2.O000OOoo == 17) {
                    LinearLayout linearLayout = (LinearLayout) this.O00000Oo.inflate(mLAlertController2.O000OOOo, (ViewGroup) null);
                    final RecycleListView recycleListView = (RecycleListView) linearLayout.findViewById(R.id.select_dialog_listview);
                    Cursor cursor = this.O000OO0o;
                    if (cursor == null) {
                        listAdapter = this.O0000oo;
                        if (listAdapter == null) {
                            listAdapter = new ArrayAdapter(this.f9086O000000o, (int) R.layout.ml_center_item, (int) R.id.text1, this.O0000oo0);
                        }
                    } else {
                        listAdapter = new SimpleCursorAdapter(this.f9086O000000o, R.layout.ml_center_item, cursor, new String[]{this.O000OO}, new int[]{R.id.text1});
                    }
                    TextView textView = (TextView) linearLayout.findViewById(R.id.title);
                    if (TextUtils.isEmpty(this.O000Oo0)) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(this.O000Oo0);
                        textView.setVisibility(0);
                    }
                    mLAlertController2.O000O0oo = listAdapter;
                    recycleListView.setAdapter(listAdapter);
                    mLAlertController2.O000OO00 = this.O000O0oo;
                    if (this.O0000ooO != null) {
                        recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            /* class com.xiaomi.smarthome.library.common.dialog.MLAlertController.AlertParams.AnonymousClass1 */

                            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                                AlertParams.this.O0000ooO.onClick(mLAlertController2.O00000Oo, i);
                                if (!AlertParams.this.O000O0o) {
                                    mLAlertController2.O00000Oo.dismiss();
                                }
                            }
                        });
                    } else if (this.O000OO00 != null) {
                        recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            /* class com.xiaomi.smarthome.library.common.dialog.MLAlertController.AlertParams.AnonymousClass2 */

                            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                                if (AlertParams.this.O00oOoOo != null) {
                                    AlertParams.this.O00oOoOo[i] = recycleListView.isItemChecked(i);
                                }
                                AlertParams.this.O000OO00.onClick(mLAlertController2.O00000Oo, i, recycleListView.isItemChecked(i));
                            }
                        });
                    }
                    AdapterView.OnItemSelectedListener onItemSelectedListener = this.O000OOo;
                    if (onItemSelectedListener != null) {
                        recycleListView.setOnItemSelectedListener(onItemSelectedListener);
                    }
                    AdapterView.OnItemSelectedListener onItemSelectedListener2 = this.O000OOo;
                    if (onItemSelectedListener2 != null) {
                        recycleListView.setOnItemSelectedListener(onItemSelectedListener2);
                    }
                    if (this.O000O0o) {
                        recycleListView.setChoiceMode(1);
                    } else if (this.O000O0o0) {
                        recycleListView.setChoiceMode(2);
                    }
                    recycleListView.f9094O000000o = this.O000OOoO;
                    mLAlertController2.O0000Oo0 = linearLayout;
                    mLAlertController2.O000Oo0O = true;
                    mLAlertController2.O000OoO0 = this.O000Oo0O;
                } else {
                    final RecycleListView recycleListView2 = (RecycleListView) this.O00000Oo.inflate(mLAlertController2.O000OO, (ViewGroup) null);
                    if (this.O000O0o0) {
                        Cursor cursor2 = this.O000OO0o;
                        if (cursor2 == null) {
                            final RecycleListView recycleListView3 = recycleListView2;
                            r13 = new ArrayAdapter<CharSequence>(this.f9086O000000o, mLAlertController2.O000OOo0, this.O0000oo0) {
                                /* class com.xiaomi.smarthome.library.common.dialog.MLAlertController.AlertParams.AnonymousClass3 */

                                public final View getView(int i, View view, ViewGroup viewGroup) {
                                    View view2 = super.getView(i, view, viewGroup);
                                    if (AlertParams.this.O00oOoOo != null && AlertParams.this.O00oOoOo[i]) {
                                        recycleListView3.setItemChecked(i, true);
                                    }
                                    return view2;
                                }
                            };
                        } else {
                            final RecycleListView recycleListView4 = recycleListView2;
                            final MLAlertController mLAlertController3 = mLAlertController;
                            r13 = new CursorAdapter(this.f9086O000000o, cursor2) {
                                /* class com.xiaomi.smarthome.library.common.dialog.MLAlertController.AlertParams.AnonymousClass4 */
                                private final int O00000o;
                                private final int O00000oO;

                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                 method: ClspMth{android.widget.CursorAdapter.<init>(android.content.Context, android.database.Cursor, boolean):void}
                                 arg types: [android.content.Context, android.database.Cursor, int]
                                 candidates:
                                  ClspMth{android.widget.CursorAdapter.<init>(android.content.Context, android.database.Cursor, int):void}
                                  ClspMth{android.widget.CursorAdapter.<init>(android.content.Context, android.database.Cursor, boolean):void} */
                                {
                                    Cursor cursor = getCursor();
                                    this.O00000o = cursor.getColumnIndexOrThrow(AlertParams.this.O000OO);
                                    this.O00000oO = cursor.getColumnIndexOrThrow(AlertParams.this.O000OOOo);
                                }

                                public final void bindView(View view, Context context, Cursor cursor) {
                                    ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.O00000o));
                                    RecycleListView recycleListView = recycleListView4;
                                    int position = cursor.getPosition();
                                    boolean z = true;
                                    if (cursor.getInt(this.O00000oO) != 1) {
                                        z = false;
                                    }
                                    recycleListView.setItemChecked(position, z);
                                }

                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                 method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
                                 arg types: [int, android.view.ViewGroup, int]
                                 candidates:
                                  ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
                                  ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
                                public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                                    return AlertParams.this.O00000Oo.inflate(mLAlertController3.O000OOo0, viewGroup, false);
                                }
                            };
                        }
                    } else {
                        int i3 = this.O000O0o ? mLAlertController2.O000OOo : mLAlertController2.O000OOoO;
                        Cursor cursor3 = this.O000OO0o;
                        if (cursor3 == null) {
                            Object obj = this.O0000oo;
                            if (obj == null) {
                                obj = new ArrayAdapter(this.f9086O000000o, i3, (int) R.id.text1, this.O0000oo0);
                            }
                            r13 = obj;
                        } else {
                            r13 = new SimpleCursorAdapter(this.f9086O000000o, i3, cursor3, new String[]{this.O000OO}, new int[]{R.id.text1});
                        }
                    }
                    mLAlertController2.O000O0oo = r13;
                    mLAlertController2.O000OO00 = this.O000O0oo;
                    if (this.O0000ooO != null) {
                        recycleListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            /* class com.xiaomi.smarthome.library.common.dialog.MLAlertController.AlertParams.AnonymousClass5 */

                            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                                AlertParams.this.O0000ooO.onClick(mLAlertController2.O00000Oo, i);
                                if (!AlertParams.this.O000O0o) {
                                    mLAlertController2.O00000Oo.dismiss();
                                }
                            }
                        });
                    } else if (this.O000OO00 != null) {
                        recycleListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            /* class com.xiaomi.smarthome.library.common.dialog.MLAlertController.AlertParams.AnonymousClass6 */

                            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                                if (AlertParams.this.O00oOoOo != null) {
                                    AlertParams.this.O00oOoOo[i] = recycleListView2.isItemChecked(i);
                                }
                                AlertParams.this.O000OO00.onClick(mLAlertController2.O00000Oo, i, recycleListView2.isItemChecked(i));
                            }
                        });
                    }
                    AdapterView.OnItemSelectedListener onItemSelectedListener3 = this.O000OOo;
                    if (onItemSelectedListener3 != null) {
                        recycleListView2.setOnItemSelectedListener(onItemSelectedListener3);
                    }
                    if (this.O000O0o) {
                        recycleListView2.setChoiceMode(1);
                    } else if (this.O000O0o0) {
                        recycleListView2.setChoiceMode(2);
                    }
                    recycleListView2.f9094O000000o = this.O000OOoO;
                    mLAlertController2.O0000OOo = recycleListView2;
                    mLAlertController2.O000OoO0 = this.O000Oo0O;
                }
            }
            View view2 = this.O0000ooo;
            if (view2 != null) {
                if (this.O000O0Oo) {
                    mLAlertController.O000000o(view2, this.O00oOooO, this.O00oOooo, this.O000O00o, this.O000O0OO);
                } else {
                    mLAlertController2.O00000Oo(view2);
                }
            }
            mLAlertController2.O000Oo0o = this.O000OOoo;
            mLAlertController2.O000OoO0 = this.O000Oo0O;
            int i4 = this.O000Oo0o;
            if (i4 != -1) {
                mLAlertController2.O000000o(-1, i4);
            }
            if (this.O000OoO0 != -1) {
                mLAlertController2.O000000o(-2, this.O000Oo0o);
            }
            int i5 = this.O00O0Oo;
            if (i5 != -1) {
                mLAlertController2.O000000o(-3, i5);
            }
            mLAlertController2.O00O0Oo = this.O000OoOO;
        }
    }
}
