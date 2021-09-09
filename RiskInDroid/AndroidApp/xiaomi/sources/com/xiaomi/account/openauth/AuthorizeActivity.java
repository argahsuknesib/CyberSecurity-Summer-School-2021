package com.xiaomi.account.openauth;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class AuthorizeActivity extends AuthorizeActivityBase {
    @Deprecated
    public static int RESULT_CANCEL = AuthorizeActivityBase.RESULT_CANCEL;
    @Deprecated
    public static int RESULT_FAIL = AuthorizeActivityBase.RESULT_FAIL;
    @Deprecated
    public static int RESULT_SUCCESS = AuthorizeActivityBase.RESULT_SUCCESS;
    private ProgressBar mProgressBar;
    private MenuItem mRefreshItem;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing() && !super.isMiddleActivityMode()) {
            WebView webView = super.getWebView();
            RelativeLayout relativeLayout = new RelativeLayout(this);
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            relativeLayout.addView(webView, new ViewGroup.LayoutParams(-1, -1));
            this.mProgressBar = new ProgressBar(this, null, 16842872);
            relativeLayout.addView(this.mProgressBar, new ViewGroup.LayoutParams(-1, -2));
            setContentView(relativeLayout);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (!isFinishing() && !super.isMiddleActivityMode()) {
            this.mRefreshItem = menu.add("refresh");
            this.mRefreshItem.setIcon(17301629);
            this.mRefreshItem.setShowAsActionFlags(2);
            this.mRefreshItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                /* class com.xiaomi.account.openauth.AuthorizeActivity.AnonymousClass1 */

                public boolean onMenuItemClick(MenuItem menuItem) {
                    AuthorizeActivity.this.refreshWebView();
                    return true;
                }
            });
            this.mRefreshItem.setVisible(false);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onShowErrorUI() {
        MenuItem menuItem = this.mRefreshItem;
        if (menuItem != null) {
            menuItem.setVisible(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onHideErrorUI() {
        MenuItem menuItem = this.mRefreshItem;
        if (menuItem != null) {
            menuItem.setVisible(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onUpdateProgress(int i) {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onHideProgress() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onShowProgress() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }
}
