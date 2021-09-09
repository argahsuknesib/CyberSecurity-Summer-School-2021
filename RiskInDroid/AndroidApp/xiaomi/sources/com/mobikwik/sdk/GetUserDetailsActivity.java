package com.mobikwik.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.mobikwik.sdk.lib.User;
import com.mobikwik.sdk.lib.utils.Utils;
import com.xiaomi.smarthome.R;

public class GetUserDetailsActivity extends Activity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private User f5273a;

    public void onClick(View view) {
        EditText editText = (EditText) findViewById(R.id.editEmail);
        if (Utils.isValidEmail(editText)) {
            EditText editText2 = (EditText) findViewById(R.id.editPhone);
            if (Utils.isValidMobile(editText2)) {
                String obj = editText.getText().toString();
                String obj2 = editText2.getText().toString();
                User user = this.f5273a;
                if (user == null) {
                    this.f5273a = new User(obj, obj2);
                } else {
                    user.setEmail(obj);
                    this.f5273a.setCell(obj2);
                }
                Intent intent = new Intent();
                intent.putExtra("user", this.f5273a);
                setResult(-1, intent);
                finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView((int) R.layout.mk_activity_get_userdetails);
        this.f5273a = (User) getIntent().getSerializableExtra("user");
        findViewById(R.id.btnGetDetailsOk).setOnClickListener(this);
        EditText editText = (EditText) findViewById(R.id.editEmail);
        EditText editText2 = (EditText) findViewById(R.id.editPhone);
        User user = this.f5273a;
        if (user != null) {
            if (user.isEmailValid()) {
                editText.setText(this.f5273a.getEmail());
            }
            if (this.f5273a.isCellValid()) {
                editText2.setText(this.f5273a.getCell());
            }
        }
    }
}
