package androidx.appcompat.view.menu;

import _m_j.OO0OOOO;
import _m_j.OO0o00;
import _m_j.Oo;
import _m_j.cb;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class ListMenuItemView extends LinearLayout implements OO0o00.O000000o, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: O000000o  reason: collision with root package name */
    private OO0OOOO f2679O000000o;
    private ImageView O00000Oo;
    private TextView O00000o;
    private RadioButton O00000o0;
    private CheckBox O00000oO;
    private TextView O00000oo;
    private ImageView O0000O0o;
    private ImageView O0000OOo;
    private Drawable O0000Oo;
    private LinearLayout O0000Oo0;
    private int O0000OoO;
    private Context O0000Ooo;
    private boolean O0000o;
    private Drawable O0000o0;
    private boolean O0000o00;
    private boolean O0000o0O;
    private LayoutInflater O0000o0o;

    public boolean prefersCondensedTitle() {
        return false;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.Oo.O000000o(int, boolean):boolean
     arg types: [int, int]
     candidates:
      _m_j.Oo.O000000o(int, int):int
      _m_j.Oo.O000000o(int, boolean):boolean */
    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Oo O000000o2 = Oo.O000000o(getContext(), attributeSet, new int[]{16842926, 16843052, 16843053, 16843054, 16843055, 16843056, 16843057, R.attr.preserveIconSpacing, R.attr.subMenuArrow}, i, 0);
        this.O0000Oo = O000000o2.O000000o(5);
        this.O0000OoO = O000000o2.O0000O0o(1, -1);
        this.O0000o00 = O000000o2.O000000o(7, false);
        this.O0000Ooo = context;
        this.O0000o0 = O000000o2.O000000o(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, R.attr.dropDownListViewStyle, 0);
        this.O0000o0O = obtainStyledAttributes.hasValue(0);
        O000000o2.f12340O000000o.recycle();
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        cb.O000000o(this, this.O0000Oo);
        this.O00000o = (TextView) findViewById(R.id.title);
        int i = this.O0000OoO;
        if (i != -1) {
            this.O00000o.setTextAppearance(this.O0000Ooo, i);
        }
        this.O00000oo = (TextView) findViewById(R.id.shortcut);
        this.O0000O0o = (ImageView) findViewById(R.id.submenuarrow);
        ImageView imageView = this.O0000O0o;
        if (imageView != null) {
            imageView.setImageDrawable(this.O0000o0);
        }
        this.O0000OOo = (ImageView) findViewById(R.id.group_divider);
        this.O0000Oo0 = (LinearLayout) findViewById(R.id.content);
    }

    public void initialize(OO0OOOO oo0oooo, int i) {
        String str;
        this.f2679O000000o = oo0oooo;
        int i2 = 0;
        setVisibility(oo0oooo.isVisible() ? 0 : 8);
        setTitle(oo0oooo.O000000o((OO0o00.O000000o) this));
        setCheckable(oo0oooo.isCheckable());
        boolean O00000o2 = oo0oooo.O00000o();
        oo0oooo.O00000o0();
        if (!O00000o2 || !this.f2679O000000o.O00000o()) {
            i2 = 8;
        }
        if (i2 == 0) {
            TextView textView = this.O00000oo;
            OO0OOOO oo0oooo2 = this.f2679O000000o;
            char O00000o02 = oo0oooo2.O00000o0();
            if (O00000o02 == 0) {
                str = "";
            } else {
                Resources resources = oo0oooo2.O00000o.getContext().getResources();
                StringBuilder sb = new StringBuilder();
                if (ViewConfiguration.get(oo0oooo2.O00000o.getContext()).hasPermanentMenuKey()) {
                    sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
                }
                int i3 = oo0oooo2.O00000o.isQwertyMode() ? oo0oooo2.O00000o0 : oo0oooo2.O00000Oo;
                OO0OOOO.O000000o(sb, i3, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
                OO0OOOO.O000000o(sb, i3, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
                OO0OOOO.O000000o(sb, i3, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
                OO0OOOO.O000000o(sb, i3, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
                OO0OOOO.O000000o(sb, i3, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
                OO0OOOO.O000000o(sb, i3, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
                if (O00000o02 == 8) {
                    sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
                } else if (O00000o02 == 10) {
                    sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
                } else if (O00000o02 != ' ') {
                    sb.append(O00000o02);
                } else {
                    sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
                }
                str = sb.toString();
            }
            textView.setText(str);
        }
        if (this.O00000oo.getVisibility() != i2) {
            this.O00000oo.setVisibility(i2);
        }
        setIcon(oo0oooo.getIcon());
        setEnabled(oo0oooo.isEnabled());
        setSubMenuArrowVisible(oo0oooo.hasSubMenu());
        setContentDescription(oo0oooo.getContentDescription());
    }

    private void O000000o(View view, int i) {
        LinearLayout linearLayout = this.O0000Oo0;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    public void setForceShowIcon(boolean z) {
        this.O0000o = z;
        this.O0000o00 = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.O00000o.setText(charSequence);
            if (this.O00000o.getVisibility() != 0) {
                this.O00000o.setVisibility(0);
            }
        } else if (this.O00000o.getVisibility() != 8) {
            this.O00000o.setVisibility(8);
        }
    }

    public OO0OOOO getItemData() {
        return this.f2679O000000o;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.O00000o0 != null || this.O00000oO != null) {
            if (this.f2679O000000o.O00000oO()) {
                if (this.O00000o0 == null) {
                    O000000o();
                }
                compoundButton2 = this.O00000o0;
                compoundButton = this.O00000oO;
            } else {
                if (this.O00000oO == null) {
                    O00000Oo();
                }
                compoundButton2 = this.O00000oO;
                compoundButton = this.O00000o0;
            }
            if (z) {
                compoundButton2.setChecked(this.f2679O000000o.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.O00000oO;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.O00000o0;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f2679O000000o.O00000oO()) {
            if (this.O00000o0 == null) {
                O000000o();
            }
            compoundButton = this.O00000o0;
        } else {
            if (this.O00000oO == null) {
                O00000Oo();
            }
            compoundButton = this.O00000oO;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.O0000O0o;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    private void setShortcut$25d965e(boolean z) {
        String str;
        int i = (!z || !this.f2679O000000o.O00000o()) ? 8 : 0;
        if (i == 0) {
            TextView textView = this.O00000oo;
            OO0OOOO oo0oooo = this.f2679O000000o;
            char O00000o02 = oo0oooo.O00000o0();
            if (O00000o02 == 0) {
                str = "";
            } else {
                Resources resources = oo0oooo.O00000o.getContext().getResources();
                StringBuilder sb = new StringBuilder();
                if (ViewConfiguration.get(oo0oooo.O00000o.getContext()).hasPermanentMenuKey()) {
                    sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
                }
                int i2 = oo0oooo.O00000o.isQwertyMode() ? oo0oooo.O00000o0 : oo0oooo.O00000Oo;
                OO0OOOO.O000000o(sb, i2, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
                OO0OOOO.O000000o(sb, i2, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
                OO0OOOO.O000000o(sb, i2, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
                OO0OOOO.O000000o(sb, i2, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
                OO0OOOO.O000000o(sb, i2, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
                OO0OOOO.O000000o(sb, i2, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
                if (O00000o02 == 8) {
                    sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
                } else if (O00000o02 == 10) {
                    sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
                } else if (O00000o02 != ' ') {
                    sb.append(O00000o02);
                } else {
                    sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
                }
                str = sb.toString();
            }
            textView.setText(str);
        }
        if (this.O00000oo.getVisibility() != i) {
            this.O00000oo.setVisibility(i);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, androidx.appcompat.view.menu.ListMenuItemView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void setIcon(Drawable drawable) {
        boolean z = this.f2679O000000o.O00000o.getOptionalIconsVisible() || this.O0000o;
        if (!z && !this.O0000o00) {
            return;
        }
        if (this.O00000Oo != null || drawable != null || this.O0000o00) {
            if (this.O00000Oo == null) {
                this.O00000Oo = (ImageView) getInflater().inflate((int) R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                O000000o(this.O00000Oo, 0);
            }
            if (drawable != null || this.O0000o00) {
                ImageView imageView = this.O00000Oo;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.O00000Oo.getVisibility() != 0) {
                    this.O00000Oo.setVisibility(0);
                    return;
                }
                return;
            }
            this.O00000Oo.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.O00000Oo != null && this.O0000o00) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.O00000Oo.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, androidx.appcompat.view.menu.ListMenuItemView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O000000o() {
        this.O00000o0 = (RadioButton) getInflater().inflate((int) R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        O000000o(this.O00000o0, -1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, androidx.appcompat.view.menu.ListMenuItemView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O00000Oo() {
        this.O00000oO = (CheckBox) getInflater().inflate((int) R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        O000000o(this.O00000oO, -1);
    }

    private LayoutInflater getInflater() {
        if (this.O0000o0o == null) {
            this.O0000o0o = LayoutInflater.from(getContext());
        }
        return this.O0000o0o;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.O0000OOo;
        if (imageView != null) {
            imageView.setVisibility((this.O0000o0O || !z) ? 8 : 0);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.O0000OOo;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.O0000OOo.getLayoutParams();
            rect.top += this.O0000OOo.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }
}
