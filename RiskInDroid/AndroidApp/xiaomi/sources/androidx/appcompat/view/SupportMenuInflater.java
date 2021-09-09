package androidx.appcompat.view;

import _m_j.OO0OOOO;
import _m_j.OO0OOo0;
import _m_j.OOOOOo0;
import _m_j.Oo;
import _m_j.ah;
import _m_j.ai;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.ActionProvider;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SupportMenuInflater extends MenuInflater {

    /* renamed from: O000000o  reason: collision with root package name */
    static final Class<?>[] f2673O000000o;
    static final Class<?>[] O00000Oo;
    final Object[] O00000o = this.O00000o0;
    final Object[] O00000o0;
    Context O00000oO;
    Object O00000oo;

    static {
        Class<?>[] clsArr = {Context.class};
        f2673O000000o = clsArr;
        O00000Oo = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.O00000oO = context;
        this.O00000o0 = new Object[]{context};
    }

    public void inflate(int i, Menu menu) {
        if (!(menu instanceof ah)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.O00000oO.getResources().getLayout(i);
            O000000o(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e) {
            throw new InflateException("Error inflating menu XML", e);
        } catch (IOException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    private void O000000o(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        O00000Oo o00000Oo = new O00000Oo(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got ".concat(String.valueOf(name)));
                }
            }
        }
        int i = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                        } else if (name2.equals("group")) {
                            o00000Oo.O000000o();
                        } else if (name2.equals("item")) {
                            if (!o00000Oo.f2675O000000o) {
                                if (o00000Oo.O00000Oo == null || !o00000Oo.O00000Oo.O00000o0()) {
                                    o00000Oo.O00000Oo();
                                } else {
                                    o00000Oo.O00000o0();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        o00000Oo.O000000o(attributeSet);
                    } else if (name3.equals("item")) {
                        o00000Oo.O00000Oo(attributeSet);
                    } else if (name3.equals("menu")) {
                        O000000o(xmlPullParser, attributeSet, o00000Oo.O00000o0());
                    } else {
                        str = name3;
                        z2 = true;
                    }
                }
                i = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Object O000000o(Object obj) {
        while (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            obj = ((ContextWrapper) obj).getBaseContext();
        }
        return obj;
    }

    static class O000000o implements MenuItem.OnMenuItemClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final Class<?>[] f2674O000000o = {MenuItem.class};
        private Object O00000Oo;
        private Method O00000o0;

        public O000000o(Object obj, String str) {
            this.O00000Oo = obj;
            Class<?> cls = obj.getClass();
            try {
                this.O00000o0 = cls.getMethod(str, f2674O000000o);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.O00000o0.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.O00000o0.invoke(this.O00000Oo, menuItem)).booleanValue();
                }
                this.O00000o0.invoke(this.O00000Oo, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f2675O000000o;
        ActionProvider O00000Oo;
        private Menu O00000o;
        private int O00000oO;
        private int O00000oo;
        private int O0000O0o;
        private int O0000OOo;
        private boolean O0000Oo;
        private boolean O0000Oo0;
        private int O0000OoO;
        private int O0000Ooo;
        private int O0000o;
        private CharSequence O0000o0;
        private CharSequence O0000o00;
        private int O0000o0O;
        private char O0000o0o;
        private int O0000oO;
        private char O0000oO0;
        private int O0000oOO;
        private boolean O0000oOo;
        private boolean O0000oo;
        private boolean O0000oo0;
        private int O0000ooO;
        private int O0000ooo;
        private String O000O00o;
        private CharSequence O000O0OO;
        private CharSequence O000O0Oo;
        private PorterDuff.Mode O000O0o0 = null;
        private ColorStateList O00oOoOo = null;
        private String O00oOooO;
        private String O00oOooo;

        public O00000Oo(Menu menu) {
            this.O00000o = menu;
            O000000o();
        }

        public final void O000000o() {
            this.O00000oO = 0;
            this.O00000oo = 0;
            this.O0000O0o = 0;
            this.O0000OOo = 0;
            this.O0000Oo0 = true;
            this.O0000Oo = true;
        }

        public final void O000000o(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.O00000oO.obtainStyledAttributes(attributeSet, new int[]{16842766, 16842960, 16843156, 16843230, 16843231, 16843232});
            this.O00000oO = obtainStyledAttributes.getResourceId(1, 0);
            this.O00000oo = obtainStyledAttributes.getInt(3, 0);
            this.O0000O0o = obtainStyledAttributes.getInt(4, 0);
            this.O0000OOo = obtainStyledAttributes.getInt(5, 0);
            this.O0000Oo0 = obtainStyledAttributes.getBoolean(2, true);
            this.O0000Oo = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.Oo.O000000o(int, boolean):boolean
         arg types: [int, int]
         candidates:
          _m_j.Oo.O000000o(int, int):int
          _m_j.Oo.O000000o(int, boolean):boolean */
        public final void O00000Oo(AttributeSet attributeSet) {
            Oo O000000o2 = Oo.O000000o(SupportMenuInflater.this.O00000oO, attributeSet, new int[]{16842754, 16842766, 16842960, 16843014, 16843156, 16843230, 16843231, 16843233, 16843234, 16843235, 16843236, 16843237, 16843375, R.attr.actionLayout, R.attr.actionProviderClass, R.attr.actionViewClass, R.attr.alphabeticModifiers, R.attr.contentDescription, R.attr.iconTint, R.attr.iconTintMode, R.attr.numericModifiers, R.attr.showAsAction, R.attr.tooltipText});
            this.O0000OoO = O000000o2.O0000O0o(2, 0);
            this.O0000Ooo = (O000000o2.O000000o(5, this.O00000oo) & -65536) | (O000000o2.O000000o(6, this.O0000O0o) & 65535);
            this.O0000o00 = O000000o2.O00000o0(7);
            this.O0000o0 = O000000o2.O00000o0(8);
            this.O0000o0O = O000000o2.O0000O0o(0, 0);
            this.O0000o0o = O000000o(O000000o2.O00000o(9));
            this.O0000o = O000000o2.O000000o(16, 4096);
            this.O0000oO0 = O000000o(O000000o2.O00000o(10));
            this.O0000oO = O000000o2.O000000o(20, 4096);
            if (O000000o2.O0000O0o(11)) {
                this.O0000oOO = O000000o2.O000000o(11, false) ? 1 : 0;
            } else {
                this.O0000oOO = this.O0000OOo;
            }
            this.O0000oOo = O000000o2.O000000o(3, false);
            this.O0000oo0 = O000000o2.O000000o(4, this.O0000Oo0);
            boolean z = true;
            this.O0000oo = O000000o2.O000000o(1, this.O0000Oo);
            this.O0000ooO = O000000o2.O000000o(21, -1);
            this.O000O00o = O000000o2.O00000o(12);
            this.O0000ooo = O000000o2.O0000O0o(13, 0);
            this.O00oOooO = O000000o2.O00000o(15);
            this.O00oOooo = O000000o2.O00000o(14);
            if (this.O00oOooo == null) {
                z = false;
            }
            if (z && this.O0000ooo == 0 && this.O00oOooO == null) {
                this.O00000Oo = (ActionProvider) O000000o(this.O00oOooo, SupportMenuInflater.O00000Oo, SupportMenuInflater.this.O00000o);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.O00000Oo = null;
            }
            this.O000O0OO = O000000o2.O00000o0(17);
            this.O000O0Oo = O000000o2.O00000o0(22);
            if (O000000o2.O0000O0o(19)) {
                this.O000O0o0 = OOOOOo0.O000000o(O000000o2.O000000o(19, -1), this.O000O0o0);
            } else {
                this.O000O0o0 = null;
            }
            if (O000000o2.O0000O0o(18)) {
                this.O00oOoOo = O000000o2.O00000oO(18);
            } else {
                this.O00oOoOo = null;
            }
            O000000o2.f12340O000000o.recycle();
            this.f2675O000000o = false;
        }

        private static char O000000o(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private void O000000o(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.O0000oOo).setVisible(this.O0000oo0).setEnabled(this.O0000oo).setCheckable(this.O0000oOO > 0).setTitleCondensed(this.O0000o0).setIcon(this.O0000o0O);
            int i = this.O0000ooO;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.O000O00o != null) {
                if (!SupportMenuInflater.this.O00000oO.isRestricted()) {
                    SupportMenuInflater supportMenuInflater = SupportMenuInflater.this;
                    if (supportMenuInflater.O00000oo == null) {
                        supportMenuInflater.O00000oo = supportMenuInflater.O000000o(supportMenuInflater.O00000oO);
                    }
                    menuItem.setOnMenuItemClickListener(new O000000o(supportMenuInflater.O00000oo, this.O000O00o));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.O0000oOO >= 2) {
                if (menuItem instanceof OO0OOOO) {
                    ((OO0OOOO) menuItem).O000000o(true);
                } else if (menuItem instanceof OO0OOo0) {
                    OO0OOo0 oO0OOo0 = (OO0OOo0) menuItem;
                    try {
                        if (oO0OOo0.O00000oO == null) {
                            oO0OOo0.O00000oO = oO0OOo0.O00000o.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        oO0OOo0.O00000oO.invoke(oO0OOo0.O00000o, Boolean.TRUE);
                    } catch (Exception e) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
                    }
                }
            }
            String str = this.O00oOooO;
            if (str != null) {
                menuItem.setActionView((View) O000000o(str, SupportMenuInflater.f2673O000000o, SupportMenuInflater.this.O00000o0));
                z = true;
            }
            int i2 = this.O0000ooo;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            ActionProvider actionProvider = this.O00000Oo;
            if (actionProvider != null) {
                if (menuItem instanceof ai) {
                    ((ai) menuItem).O000000o(actionProvider);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            CharSequence charSequence = this.O000O0OO;
            boolean z2 = menuItem instanceof ai;
            if (z2) {
                ((ai) menuItem).O000000o(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.O000O0Oo;
            if (z2) {
                ((ai) menuItem).O00000Oo(charSequence2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setTooltipText(charSequence2);
            }
            char c = this.O0000o0o;
            int i3 = this.O0000o;
            if (z2) {
                ((ai) menuItem).setAlphabeticShortcut(c, i3);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setAlphabeticShortcut(c, i3);
            }
            char c2 = this.O0000oO0;
            int i4 = this.O0000oO;
            if (z2) {
                ((ai) menuItem).setNumericShortcut(c2, i4);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setNumericShortcut(c2, i4);
            }
            PorterDuff.Mode mode = this.O000O0o0;
            if (mode != null) {
                if (z2) {
                    ((ai) menuItem).setIconTintMode(mode);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintMode(mode);
                }
            }
            ColorStateList colorStateList = this.O00oOoOo;
            if (colorStateList == null) {
                return;
            }
            if (z2) {
                ((ai) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setIconTintList(colorStateList);
            }
        }

        public final void O00000Oo() {
            this.f2675O000000o = true;
            O000000o(this.O00000o.add(this.O00000oO, this.O0000OoO, this.O0000Ooo, this.O0000o00));
        }

        public final SubMenu O00000o0() {
            this.f2675O000000o = true;
            SubMenu addSubMenu = this.O00000o.addSubMenu(this.O00000oO, this.O0000OoO, this.O0000Ooo, this.O0000o00);
            O000000o(addSubMenu.getItem());
            return addSubMenu;
        }

        private <T> T O000000o(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.O00000oO.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: ".concat(String.valueOf(str)), e);
                return null;
            }
        }
    }
}
