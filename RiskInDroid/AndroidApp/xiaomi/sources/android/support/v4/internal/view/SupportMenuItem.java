package android.support.v4.internal.view;

import android.support.annotation.RestrictTo;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.view.MenuItem;
import android.view.View;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface SupportMenuItem extends MenuItem {
    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    ActionProvider getSupportActionProvider();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);

    SupportMenuItem setSupportActionProvider(ActionProvider actionProvider);

    SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener onActionExpandListener);
}
