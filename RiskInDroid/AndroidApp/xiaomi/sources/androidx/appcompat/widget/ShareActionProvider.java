package androidx.appcompat.widget;

import _m_j.OO0000o;
import _m_j.OOO0OO0;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.ActionProvider;
import com.xiaomi.smarthome.R;

public class ShareActionProvider extends ActionProvider {

    /* renamed from: O000000o  reason: collision with root package name */
    final Context f2748O000000o;
    String O00000Oo = "share_history.xml";
    private int O00000o0 = 4;
    private final O000000o O00000oo = new O000000o();

    public final boolean O00000o0() {
        return true;
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.f2748O000000o = context;
    }

    public final View O000000o() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.f2748O000000o);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(OOO0OO0.O000000o(this.f2748O000000o, this.O00000Oo));
        }
        TypedValue typedValue = new TypedValue();
        this.f2748O000000o.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(OO0000o.O00000Oo(this.f2748O000000o, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    public final void O000000o(SubMenu subMenu) {
        subMenu.clear();
        OOO0OO0 O000000o2 = OOO0OO0.O000000o(this.f2748O000000o, this.O00000Oo);
        PackageManager packageManager = this.f2748O000000o.getPackageManager();
        int O000000o3 = O000000o2.O000000o();
        int min = Math.min(O000000o3, this.O00000o0);
        for (int i = 0; i < min; i++) {
            ResolveInfo O000000o4 = O000000o2.O000000o(i);
            subMenu.add(0, i, i, O000000o4.loadLabel(packageManager)).setIcon(O000000o4.loadIcon(packageManager)).setOnMenuItemClickListener(this.O00000oo);
        }
        if (min < O000000o3) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.f2748O000000o.getString(R.string.abc_activity_chooser_view_see_all));
            for (int i2 = 0; i2 < O000000o3; i2++) {
                ResolveInfo O000000o5 = O000000o2.O000000o(i2);
                addSubMenu.add(0, i2, i2, O000000o5.loadLabel(packageManager)).setIcon(O000000o5.loadIcon(packageManager)).setOnMenuItemClickListener(this.O00000oo);
            }
        }
    }

    class O000000o implements MenuItem.OnMenuItemClickListener {
        O000000o() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            Intent O00000Oo = OOO0OO0.O000000o(ShareActionProvider.this.f2748O000000o, ShareActionProvider.this.O00000Oo).O00000Oo(menuItem.getItemId());
            if (O00000Oo == null) {
                return true;
            }
            String action = O00000Oo.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                ShareActionProvider.O000000o(O00000Oo);
            }
            ShareActionProvider.this.f2748O000000o.startActivity(O00000Oo);
            return true;
        }
    }

    static void O000000o(Intent intent) {
        if (Build.VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
        } else {
            intent.addFlags(524288);
        }
    }
}
