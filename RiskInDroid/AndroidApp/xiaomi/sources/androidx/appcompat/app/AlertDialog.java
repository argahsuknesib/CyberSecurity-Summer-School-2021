package androidx.appcompat.app;

import _m_j.cb;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import com.xiaomi.smarthome.R;

public final class AlertDialog extends AppCompatDialog implements DialogInterface {

    /* renamed from: O000000o  reason: collision with root package name */
    public final AlertController f2647O000000o = new AlertController(getContext(), this, getWindow());

    protected AlertDialog(Context context, int i) {
        super(context, O000000o(context, i));
    }

    static int O000000o(Context context, int i) {
        if (((i >>> 24) & 255) > 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f2647O000000o.O000000o(charSequence);
    }

    public final void O000000o(View view) {
        this.f2647O000000o.O00000Oo(view);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        int i;
        View view;
        boolean z;
        View view2;
        View findViewById;
        View view3;
        View findViewById2;
        super.onCreate(bundle);
        AlertController alertController = this.f2647O000000o;
        if (alertController.O000OO0o == 0 || alertController.O000OOoo != 1) {
            i = alertController.O000OO00;
        } else {
            i = alertController.O000OO0o;
        }
        alertController.O00000Oo.setContentView(i);
        View findViewById3 = alertController.O00000o0.findViewById(R.id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R.id.topPanel);
        View findViewById5 = findViewById3.findViewById(R.id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.customPanel);
        int i2 = 0;
        if (alertController.O0000OOo != null) {
            view = alertController.O0000OOo;
        } else {
            view = alertController.O0000Oo0 != 0 ? LayoutInflater.from(alertController.f2634O000000o).inflate(alertController.O0000Oo0, viewGroup, false) : null;
        }
        boolean z2 = view != null;
        if (!z2 || !AlertController.O000000o(view)) {
            alertController.O00000o0.setFlags(131072, 131072);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) alertController.O00000o0.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (alertController.O0000o0) {
                frameLayout.setPadding(alertController.O0000Oo, alertController.O0000OoO, alertController.O0000Ooo, alertController.O0000o00);
            }
            if (alertController.O0000O0o != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).O0000O0o = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById7 = viewGroup.findViewById(R.id.topPanel);
        View findViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup O000000o2 = AlertController.O000000o(findViewById7, findViewById4);
        ViewGroup O000000o3 = AlertController.O000000o(findViewById8, findViewById5);
        ViewGroup O000000o4 = AlertController.O000000o(findViewById9, findViewById6);
        alertController.O00oOooo = (NestedScrollView) alertController.O00000o0.findViewById(R.id.scrollView);
        alertController.O00oOooo.setFocusable(false);
        alertController.O00oOooo.setNestedScrollingEnabled(false);
        alertController.O000O0o0 = (TextView) O000000o3.findViewById(16908299);
        if (alertController.O000O0o0 != null) {
            if (alertController.O00000oo != null) {
                alertController.O000O0o0.setText(alertController.O00000oo);
            } else {
                alertController.O000O0o0.setVisibility(8);
                alertController.O00oOooo.removeView(alertController.O000O0o0);
                if (alertController.O0000O0o != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.O00oOooo.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(alertController.O00oOooo);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(alertController.O0000O0o, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    O000000o3.setVisibility(8);
                }
            }
        }
        alertController.O0000o0O = (Button) O000000o4.findViewById(16908313);
        alertController.O0000o0O.setOnClickListener(alertController.O000Oo0);
        if (!TextUtils.isEmpty(alertController.O0000o0o) || alertController.O0000oO0 != null) {
            alertController.O0000o0O.setText(alertController.O0000o0o);
            if (alertController.O0000oO0 != null) {
                alertController.O0000oO0.setBounds(0, 0, alertController.O00000o, alertController.O00000o);
                alertController.O0000o0O.setCompoundDrawables(alertController.O0000oO0, null, null, null);
            }
            alertController.O0000o0O.setVisibility(0);
            z = true;
        } else {
            alertController.O0000o0O.setVisibility(8);
            z = false;
        }
        alertController.O0000oO = (Button) O000000o4.findViewById(16908314);
        alertController.O0000oO.setOnClickListener(alertController.O000Oo0);
        if (!TextUtils.isEmpty(alertController.O0000oOO) || alertController.O0000oo0 != null) {
            alertController.O0000oO.setText(alertController.O0000oOO);
            if (alertController.O0000oo0 != null) {
                alertController.O0000oo0.setBounds(0, 0, alertController.O00000o, alertController.O00000o);
                alertController.O0000oO.setCompoundDrawables(alertController.O0000oo0, null, null, null);
            }
            alertController.O0000oO.setVisibility(0);
            z |= true;
        } else {
            alertController.O0000oO.setVisibility(8);
        }
        alertController.O0000oo = (Button) O000000o4.findViewById(16908315);
        alertController.O0000oo.setOnClickListener(alertController.O000Oo0);
        if (!TextUtils.isEmpty(alertController.O0000ooO) || alertController.O00oOooO != null) {
            alertController.O0000oo.setText(alertController.O0000ooO);
            if (alertController.O00oOooO != null) {
                alertController.O00oOooO.setBounds(0, 0, alertController.O00000o, alertController.O00000o);
                view2 = null;
                alertController.O0000oo.setCompoundDrawables(alertController.O00oOooO, null, null, null);
            } else {
                view2 = null;
            }
            alertController.O0000oo.setVisibility(0);
            z |= true;
        } else {
            alertController.O0000oo.setVisibility(8);
            view2 = null;
        }
        Context context = alertController.f2634O000000o;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (z) {
                AlertController.O000000o(alertController.O0000o0O);
            } else if (z) {
                AlertController.O000000o(alertController.O0000oO);
            } else if (z) {
                AlertController.O000000o(alertController.O0000oo);
            }
        }
        if (!(z)) {
            O000000o4.setVisibility(8);
        }
        if (alertController.O000O0o != null) {
            O000000o2.addView(alertController.O000O0o, 0, new ViewGroup.LayoutParams(-1, -2));
            alertController.O00000o0.findViewById(R.id.title_template).setVisibility(8);
        } else {
            alertController.O000O0Oo = (ImageView) alertController.O00000o0.findViewById(16908294);
            if (!(!TextUtils.isEmpty(alertController.O00000oO)) || !alertController.O000OOoO) {
                alertController.O00000o0.findViewById(R.id.title_template).setVisibility(8);
                alertController.O000O0Oo.setVisibility(8);
                O000000o2.setVisibility(8);
            } else {
                alertController.O00oOoOo = (TextView) alertController.O00000o0.findViewById(R.id.alertTitle);
                alertController.O00oOoOo.setText(alertController.O00000oO);
                if (alertController.O000O00o != 0) {
                    alertController.O000O0Oo.setImageResource(alertController.O000O00o);
                } else if (alertController.O000O0OO != null) {
                    alertController.O000O0Oo.setImageDrawable(alertController.O000O0OO);
                } else {
                    alertController.O00oOoOo.setPadding(alertController.O000O0Oo.getPaddingLeft(), alertController.O000O0Oo.getPaddingTop(), alertController.O000O0Oo.getPaddingRight(), alertController.O000O0Oo.getPaddingBottom());
                    alertController.O000O0Oo.setVisibility(8);
                }
            }
        }
        boolean z3 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        int i3 = (O000000o2 == null || O000000o2.getVisibility() == 8) ? 0 : 1;
        boolean z4 = (O000000o4 == null || O000000o4.getVisibility() == 8) ? false : true;
        if (!(z4 || O000000o3 == null || (findViewById2 = O000000o3.findViewById(R.id.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (i3 != 0) {
            if (alertController.O00oOooo != null) {
                alertController.O00oOooo.setClipToPadding(true);
            }
            if (alertController.O00000oo == null && alertController.O0000O0o == null) {
                view3 = view2;
            } else {
                view3 = O000000o2.findViewById(R.id.titleDividerNoCustom);
            }
            if (view3 != null) {
                view3.setVisibility(0);
            }
        } else if (!(O000000o3 == null || (findViewById = O000000o3.findViewById(R.id.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        if (alertController.O0000O0o instanceof AlertController.RecycleListView) {
            AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) alertController.O0000O0o;
            if (!z4 || i3 == 0) {
                recycleListView.setPadding(recycleListView.getPaddingLeft(), i3 != 0 ? recycleListView.getPaddingTop() : recycleListView.f2646O000000o, recycleListView.getPaddingRight(), z4 ? recycleListView.getPaddingBottom() : recycleListView.O00000Oo);
            }
        }
        if (!z3) {
            View view4 = alertController.O0000O0o != null ? alertController.O0000O0o : alertController.O00oOooo;
            if (view4 != null) {
                if (z4) {
                    i2 = 2;
                }
                int i4 = i3 | i2;
                View findViewById10 = alertController.O00000o0.findViewById(R.id.scrollIndicatorUp);
                View findViewById11 = alertController.O00000o0.findViewById(R.id.scrollIndicatorDown);
                if (Build.VERSION.SDK_INT >= 23) {
                    cb.O000000o(view4, i4, 3);
                    if (findViewById10 != null) {
                        O000000o3.removeView(findViewById10);
                    }
                    if (findViewById11 != null) {
                        O000000o3.removeView(findViewById11);
                    }
                } else {
                    if (findViewById10 != null && (i4 & 1) == 0) {
                        O000000o3.removeView(findViewById10);
                        findViewById10 = view2;
                    }
                    if (findViewById11 != null && (i4 & 2) == 0) {
                        O000000o3.removeView(findViewById11);
                        findViewById11 = view2;
                    }
                    if (!(findViewById10 == null && findViewById11 == null)) {
                        if (alertController.O00000oo != null) {
                            alertController.O00oOooo.setOnScrollChangeListener(new NestedScrollView.O00000Oo(findViewById10, findViewById11) {
                                /* class androidx.appcompat.app.AlertController.AnonymousClass2 */

                                /* renamed from: O000000o */
                                final /* synthetic */ View f2636O000000o;
                                final /* synthetic */ View O00000Oo;

                                {
                                    this.f2636O000000o = r2;
                                    this.O00000Oo = r3;
                                }

                                public final void O000000o(NestedScrollView nestedScrollView) {
                                    AlertController.O000000o(nestedScrollView, this.f2636O000000o, this.O00000Oo);
                                }
                            });
                            alertController.O00oOooo.post(new Runnable(findViewById10, findViewById11) {
                                /* class androidx.appcompat.app.AlertController.AnonymousClass3 */

                                /* renamed from: O000000o */
                                final /* synthetic */ View f2637O000000o;
                                final /* synthetic */ View O00000Oo;

                                {
                                    this.f2637O000000o = r2;
                                    this.O00000Oo = r3;
                                }

                                public final void run() {
                                    AlertController.O000000o(AlertController.this.O00oOooo, this.f2637O000000o, this.O00000Oo);
                                }
                            });
                        } else if (alertController.O0000O0o != null) {
                            alertController.O0000O0o.setOnScrollListener(new AbsListView.OnScrollListener(findViewById10, findViewById11) {
                                /* class androidx.appcompat.app.AlertController.AnonymousClass4 */

                                /* renamed from: O000000o */
                                final /* synthetic */ View f2638O000000o;
                                final /* synthetic */ View O00000Oo;

                                public final void onScrollStateChanged(AbsListView absListView, int i) {
                                }

                                {
                                    this.f2638O000000o = r2;
                                    this.O00000Oo = r3;
                                }

                                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                                    AlertController.O000000o(absListView, this.f2638O000000o, this.O00000Oo);
                                }
                            });
                            alertController.O0000O0o.post(new Runnable(findViewById10, findViewById11) {
                                /* class androidx.appcompat.app.AlertController.AnonymousClass5 */

                                /* renamed from: O000000o */
                                final /* synthetic */ View f2639O000000o;
                                final /* synthetic */ View O00000Oo;

                                {
                                    this.f2639O000000o = r2;
                                    this.O00000Oo = r3;
                                }

                                public final void run() {
                                    AlertController.O000000o(AlertController.this.O0000O0o, this.f2639O000000o, this.O00000Oo);
                                }
                            });
                        } else {
                            if (findViewById10 != null) {
                                O000000o3.removeView(findViewById10);
                            }
                            if (findViewById11 != null) {
                                O000000o3.removeView(findViewById11);
                            }
                        }
                    }
                }
            }
        }
        ListView listView = alertController.O0000O0o;
        if (listView != null && alertController.O000O0oO != null) {
            listView.setAdapter(alertController.O000O0oO);
            int i5 = alertController.O000O0oo;
            if (i5 >= 0) {
                listView.setItemChecked(i5, true);
                listView.setSelection(i5);
            }
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AlertController alertController = this.f2647O000000o;
        if (alertController.O00oOooo != null && alertController.O00oOooo.O000000o(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        AlertController alertController = this.f2647O000000o;
        if (alertController.O00oOooo != null && alertController.O00oOooo.O000000o(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public static class Builder {
        private final AlertController.AlertParams P;
        private final int mTheme;

        public Builder(Context context) {
            this(context, AlertDialog.O000000o(context, 0));
        }

        public Builder(Context context, int i) {
            this.P = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.O000000o(context, i)));
            this.mTheme = i;
        }

        public Context getContext() {
            return this.P.f2640O000000o;
        }

        public Builder setTitle(int i) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O00000oo = alertParams.f2640O000000o.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.P.O00000oo = charSequence;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.P.O0000O0o = view;
            return this;
        }

        public Builder setMessage(int i) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000OOo = alertParams.f2640O000000o.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.P.O0000OOo = charSequence;
            return this;
        }

        public Builder setIcon(int i) {
            this.P.O00000o0 = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.P.O00000o = drawable;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.P.f2640O000000o.getTheme().resolveAttribute(i, typedValue, true);
            this.P.O00000o0 = typedValue.resourceId;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000Oo0 = alertParams.f2640O000000o.getText(i);
            this.P.O0000OoO = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000Oo0 = charSequence;
            alertParams.O0000OoO = onClickListener;
            return this;
        }

        public Builder setPositiveButtonIcon(Drawable drawable) {
            this.P.O0000Oo = drawable;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000Ooo = alertParams.f2640O000000o.getText(i);
            this.P.O0000o0 = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000Ooo = charSequence;
            alertParams.O0000o0 = onClickListener;
            return this;
        }

        public Builder setNegativeButtonIcon(Drawable drawable) {
            this.P.O0000o00 = drawable;
            return this;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000o0O = alertParams.f2640O000000o.getText(i);
            this.P.O0000o = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000o0O = charSequence;
            alertParams.O0000o = onClickListener;
            return this;
        }

        public Builder setNeutralButtonIcon(Drawable drawable) {
            this.P.O0000o0o = drawable;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.P.O0000oO0 = z;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.P.O0000oO = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.P.O0000oOO = onDismissListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.P.O0000oOo = onKeyListener;
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000oo0 = alertParams.f2640O000000o.getResources().getTextArray(i);
            this.P.O0000ooO = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000oo0 = charSequenceArr;
            alertParams.O0000ooO = onClickListener;
            return this;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000oo = listAdapter;
            alertParams.O0000ooO = onClickListener;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O000OO0o = cursor;
            alertParams.O000OO = str;
            alertParams.O0000ooO = onClickListener;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000oo0 = alertParams.f2640O000000o.getResources().getTextArray(i);
            AlertController.AlertParams alertParams2 = this.P;
            alertParams2.O000OO00 = onMultiChoiceClickListener;
            alertParams2.O000O0o0 = zArr;
            alertParams2.O000O0o = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000oo0 = charSequenceArr;
            alertParams.O000OO00 = onMultiChoiceClickListener;
            alertParams.O000O0o0 = zArr;
            alertParams.O000O0o = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O000OO0o = cursor;
            alertParams.O000OO00 = onMultiChoiceClickListener;
            alertParams.O000OOOo = str;
            alertParams.O000OO = str2;
            alertParams.O000O0o = true;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000oo0 = alertParams.f2640O000000o.getResources().getTextArray(i);
            AlertController.AlertParams alertParams2 = this.P;
            alertParams2.O0000ooO = onClickListener;
            alertParams2.O000O0oo = i2;
            alertParams2.O000O0oO = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O000OO0o = cursor;
            alertParams.O0000ooO = onClickListener;
            alertParams.O000O0oo = i;
            alertParams.O000OO = str;
            alertParams.O000O0oO = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000oo0 = charSequenceArr;
            alertParams.O0000ooO = onClickListener;
            alertParams.O000O0oo = i;
            alertParams.O000O0oO = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O0000oo = listAdapter;
            alertParams.O0000ooO = onClickListener;
            alertParams.O000O0oo = i;
            alertParams.O000O0oO = true;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.P.O000OOo = onItemSelectedListener;
            return this;
        }

        public Builder setView(int i) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O00oOooO = null;
            alertParams.O0000ooo = i;
            alertParams.O00oOoOo = false;
            return this;
        }

        public Builder setView(View view) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O00oOooO = view;
            alertParams.O0000ooo = 0;
            alertParams.O00oOoOo = false;
            return this;
        }

        @Deprecated
        public Builder setView(View view, int i, int i2, int i3, int i4) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.O00oOooO = view;
            alertParams.O0000ooo = 0;
            alertParams.O00oOoOo = true;
            alertParams.O00oOooo = i;
            alertParams.O000O00o = i2;
            alertParams.O000O0OO = i3;
            alertParams.O000O0Oo = i4;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z) {
            this.P.O000OOo0 = z;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.P.O000OOoO = z;
            return this;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r14v0, types: [android.widget.ListAdapter] */
        /* JADX WARN: Type inference failed for: r14v4 */
        /* JADX WARN: Type inference failed for: r14v5 */
        /* JADX WARN: Type inference failed for: r14v6 */
        /* JADX WARN: Type inference failed for: r4v30, types: [androidx.appcompat.app.AlertController$AlertParams$2] */
        /* JADX WARN: Type inference failed for: r4v31, types: [androidx.appcompat.app.AlertController$AlertParams$1] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        public AlertDialog create() {
            ? r14;
            int i;
            AlertDialog alertDialog = new AlertDialog(this.P.f2640O000000o, this.mTheme);
            AlertController.AlertParams alertParams = this.P;
            AlertController alertController = alertDialog.f2647O000000o;
            if (alertParams.O0000O0o != null) {
                alertController.O000O0o = alertParams.O0000O0o;
            } else {
                if (alertParams.O00000oo != null) {
                    alertController.O000000o(alertParams.O00000oo);
                }
                if (alertParams.O00000o != null) {
                    Drawable drawable = alertParams.O00000o;
                    alertController.O000O0OO = drawable;
                    alertController.O000O00o = 0;
                    if (alertController.O000O0Oo != null) {
                        if (drawable != null) {
                            alertController.O000O0Oo.setVisibility(0);
                            alertController.O000O0Oo.setImageDrawable(drawable);
                        } else {
                            alertController.O000O0Oo.setVisibility(8);
                        }
                    }
                }
                if (alertParams.O00000o0 != 0) {
                    alertController.O000000o(alertParams.O00000o0);
                }
                if (alertParams.O00000oO != 0) {
                    int i2 = alertParams.O00000oO;
                    TypedValue typedValue = new TypedValue();
                    alertController.f2634O000000o.getTheme().resolveAttribute(i2, typedValue, true);
                    alertController.O000000o(typedValue.resourceId);
                }
            }
            if (alertParams.O0000OOo != null) {
                CharSequence charSequence = alertParams.O0000OOo;
                alertController.O00000oo = charSequence;
                if (alertController.O000O0o0 != null) {
                    alertController.O000O0o0.setText(charSequence);
                }
            }
            if (!(alertParams.O0000Oo0 == null && alertParams.O0000Oo == null)) {
                alertController.O000000o(-1, alertParams.O0000Oo0, alertParams.O0000OoO, null, alertParams.O0000Oo);
            }
            if (!(alertParams.O0000Ooo == null && alertParams.O0000o00 == null)) {
                alertController.O000000o(-2, alertParams.O0000Ooo, alertParams.O0000o0, null, alertParams.O0000o00);
            }
            if (!(alertParams.O0000o0O == null && alertParams.O0000o0o == null)) {
                alertController.O000000o(-3, alertParams.O0000o0O, alertParams.O0000o, null, alertParams.O0000o0o);
            }
            if (!(alertParams.O0000oo0 == null && alertParams.O000OO0o == null && alertParams.O0000oo == null)) {
                AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) alertParams.O00000Oo.inflate(alertController.O000OO, (ViewGroup) null);
                if (!alertParams.O000O0o) {
                    if (alertParams.O000O0oO) {
                        i = alertController.O000OOo0;
                    } else {
                        i = alertController.O000OOo;
                    }
                    if (alertParams.O000OO0o != null) {
                        r14 = new SimpleCursorAdapter(alertParams.f2640O000000o, i, alertParams.O000OO0o, new String[]{alertParams.O000OO}, new int[]{16908308});
                    } else if (alertParams.O0000oo != null) {
                        r14 = alertParams.O0000oo;
                    } else {
                        r14 = new AlertController.O00000Oo(alertParams.f2640O000000o, i, alertParams.O0000oo0);
                    }
                } else if (alertParams.O000OO0o == null) {
                    r14 = new ArrayAdapter<CharSequence>(alertParams.f2640O000000o, alertController.O000OOOo, alertParams.O0000oo0, recycleListView) {
                        /* class androidx.appcompat.app.AlertController.AlertParams.AnonymousClass1 */

                        /* renamed from: O000000o */
                        final /* synthetic */ RecycleListView f2641O000000o;

                        {
                            this.f2641O000000o = r5;
                        }

                        public final View getView(int i, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i, view, viewGroup);
                            if (AlertParams.this.O000O0o0 != null && AlertParams.this.O000O0o0[i]) {
                                this.f2641O000000o.setItemChecked(i, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    r14 = new CursorAdapter(alertParams.f2640O000000o, alertParams.O000OO0o, recycleListView, alertController) {
                        /* class androidx.appcompat.app.AlertController.AlertParams.AnonymousClass2 */

                        /* renamed from: O000000o */
                        final /* synthetic */ RecycleListView f2642O000000o;
                        final /* synthetic */ AlertController O00000Oo;
                        private final int O00000o;
                        private final int O00000oO;

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: ClspMth{android.widget.CursorAdapter.<init>(android.content.Context, android.database.Cursor, boolean):void}
                         arg types: [android.content.Context, android.database.Cursor, int]
                         candidates:
                          ClspMth{android.widget.CursorAdapter.<init>(android.content.Context, android.database.Cursor, int):void}
                          ClspMth{android.widget.CursorAdapter.<init>(android.content.Context, android.database.Cursor, boolean):void} */
                        {
                            this.f2642O000000o = r4;
                            this.O00000Oo = r5;
                            Cursor cursor = getCursor();
                            this.O00000o = cursor.getColumnIndexOrThrow(AlertParams.this.O000OO);
                            this.O00000oO = cursor.getColumnIndexOrThrow(AlertParams.this.O000OOOo);
                        }

                        public final void bindView(View view, Context context, Cursor cursor) {
                            ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.O00000o));
                            RecycleListView recycleListView = this.f2642O000000o;
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
                            return AlertParams.this.O00000Oo.inflate(this.O00000Oo.O000OOOo, viewGroup, false);
                        }
                    };
                }
                alertController.O000O0oO = r14;
                alertController.O000O0oo = alertParams.O000O0oo;
                if (alertParams.O0000ooO != null) {
                    recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener(alertController) {
                        /* class androidx.appcompat.app.AlertController.AlertParams.AnonymousClass3 */

                        /* renamed from: O000000o */
                        final /* synthetic */ AlertController f2643O000000o;

                        {
                            this.f2643O000000o = r2;
                        }

                        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            AlertParams.this.O0000ooO.onClick(this.f2643O000000o.O00000Oo, i);
                            if (!AlertParams.this.O000O0oO) {
                                this.f2643O000000o.O00000Oo.dismiss();
                            }
                        }
                    });
                } else if (alertParams.O000OO00 != null) {
                    recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener(recycleListView, alertController) {
                        /* class androidx.appcompat.app.AlertController.AlertParams.AnonymousClass4 */

                        /* renamed from: O000000o */
                        final /* synthetic */ RecycleListView f2644O000000o;
                        final /* synthetic */ AlertController O00000Oo;

                        {
                            this.f2644O000000o = r2;
                            this.O00000Oo = r3;
                        }

                        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            if (AlertParams.this.O000O0o0 != null) {
                                AlertParams.this.O000O0o0[i] = this.f2644O000000o.isItemChecked(i);
                            }
                            AlertParams.this.O000OO00.onClick(this.O00000Oo.O00000Oo, i, this.f2644O000000o.isItemChecked(i));
                        }
                    });
                }
                if (alertParams.O000OOo != null) {
                    recycleListView.setOnItemSelectedListener(alertParams.O000OOo);
                }
                if (alertParams.O000O0oO) {
                    recycleListView.setChoiceMode(1);
                } else if (alertParams.O000O0o) {
                    recycleListView.setChoiceMode(2);
                }
                alertController.O0000O0o = recycleListView;
            }
            if (alertParams.O00oOooO != null) {
                if (alertParams.O00oOoOo) {
                    View view = alertParams.O00oOooO;
                    int i3 = alertParams.O00oOooo;
                    int i4 = alertParams.O000O00o;
                    int i5 = alertParams.O000O0OO;
                    int i6 = alertParams.O000O0Oo;
                    alertController.O0000OOo = view;
                    alertController.O0000Oo0 = 0;
                    alertController.O0000o0 = true;
                    alertController.O0000Oo = i3;
                    alertController.O0000OoO = i4;
                    alertController.O0000Ooo = i5;
                    alertController.O0000o00 = i6;
                } else {
                    alertController.O00000Oo(alertParams.O00oOooO);
                }
            } else if (alertParams.O0000ooo != 0) {
                int i7 = alertParams.O0000ooo;
                alertController.O0000OOo = null;
                alertController.O0000Oo0 = i7;
                alertController.O0000o0 = false;
            }
            alertDialog.setCancelable(this.P.O0000oO0);
            if (this.P.O0000oO0) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.P.O0000oO);
            alertDialog.setOnDismissListener(this.P.O0000oOO);
            if (this.P.O0000oOo != null) {
                alertDialog.setOnKeyListener(this.P.O0000oOo);
            }
            return alertDialog;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }
    }
}
