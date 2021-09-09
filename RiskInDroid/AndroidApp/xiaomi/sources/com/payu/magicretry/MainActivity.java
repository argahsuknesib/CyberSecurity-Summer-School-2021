package com.payu.magicretry;

import _m_j.ee;
import _m_j.ei;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import com.payu.magicretry.WebClient.MerchantsWebViewClient;
import com.xiaomi.smarthome.R;

public class MainActivity extends AppCompatActivity {
    MagicRetryFragment fragment;
    WebView wv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.magicretry_main);
        this.wv = (WebView) findViewById(R.id.wv1);
        ee supportFragmentManager = getSupportFragmentManager();
        this.fragment = new MagicRetryFragment();
        supportFragmentManager.O000000o().O000000o(R.id.magic_retry_container, this.fragment, "magicRetry");
        this.wv.setWebChromeClient(new WebChromeClient());
        this.wv.setWebViewClient(new MerchantsWebViewClient(this.fragment));
        this.fragment.setWebView(this.wv);
        this.wv.loadUrl("http://google.com");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void toggleFragmentVisibility() {
        ei O000000o2 = getSupportFragmentManager().O000000o();
        if (this.fragment.isVisible()) {
            O000000o2.O00000Oo(this.fragment);
        } else {
            O000000o2.O00000o0(this.fragment);
        }
    }
}
