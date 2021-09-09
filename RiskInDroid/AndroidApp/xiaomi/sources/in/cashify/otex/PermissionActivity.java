package in.cashify.otex;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

public class PermissionActivity extends FragmentActivity {

    public class O000000o implements DialogInterface.OnClickListener {
        public O000000o() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            PermissionActivity.this.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onStart() {
        super.onStart();
        new AlertDialog.Builder(this).setMessage("Please grant permission to Diagnose your device").setPositiveButton("OK", new O000000o()).show();
    }
}
