package com.xiaomi.smarthome.framework.page;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EmptyPlaceholderActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TextView textView = new TextView(this);
        textView.setText("组件解耦占位空页面");
        textView.setTextSize(20.0f);
        textView.setGravity(17);
        setContentView(textView);
    }
}
