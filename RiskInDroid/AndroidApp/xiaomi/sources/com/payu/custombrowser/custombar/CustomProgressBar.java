package com.payu.custombrowser.custombar;

import android.view.View;
import com.xiaomi.smarthome.R;

public class CustomProgressBar {
    public void showDialog(View view) {
        view.setVisibility(0);
        showProgressDialogNew(view);
    }

    private void showProgressDialogNew(View view) {
        DotsProgressBar dotsProgressBar = (DotsProgressBar) view.findViewById(R.id.dotsProgressBar);
        dotsProgressBar.setDotsCount(5);
        dotsProgressBar.start();
    }

    public void removeProgressDialog(View view) {
        view.setVisibility(8);
        ((DotsProgressBar) view.findViewById(R.id.dotsProgressBar)).stop();
    }

    public void removeDialog(View view) {
        view.setVisibility(8);
    }
}
