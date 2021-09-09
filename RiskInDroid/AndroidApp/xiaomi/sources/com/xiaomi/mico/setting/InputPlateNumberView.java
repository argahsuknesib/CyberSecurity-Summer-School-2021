package com.xiaomi.mico.setting;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ToggleButton;
import com.xiaomi.mico.common.util.KeyboardUtils;
import com.xiaomi.smarthome.R;

public class InputPlateNumberView extends LinearLayout {
    private String[] districts;
    GridView gridview;
    ImageView inputViewClear;
    EditText inputViewEditor;
    private String plateNumber;
    ToggleButton toggleButton;

    public InputPlateNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.toggleButton = (ToggleButton) findViewById(R.id.toggle);
        this.toggleButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$InputPlateNumberView$pcC9iCk9MPSkwtMA4468eofGlrU */

            public final void onClick(View view) {
                InputPlateNumberView.this.lambda$onFinishInflate$0$InputPlateNumberView(view);
            }
        });
        this.inputViewEditor = (EditText) findViewById(R.id.input_view_editor);
        this.inputViewClear = (ImageView) findViewById(R.id.input_view_clear);
        this.inputViewClear.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$InputPlateNumberView$mTuoRv8RAZ52RtqHg1U5455O3a8 */

            public final void onClick(View view) {
                InputPlateNumberView.this.lambda$onFinishInflate$1$InputPlateNumberView(view);
            }
        });
        this.gridview = (GridView) findViewById(R.id.gridview);
        this.districts = getResources().getStringArray(R.array.province_short_name);
        this.toggleButton.setText(this.districts[0]);
        this.toggleButton.setTextOn(this.districts[0]);
        this.toggleButton.setTextOff(this.districts[0]);
        this.toggleButton.requestFocus();
        this.gridview.setAdapter((ListAdapter) new ArrayAdapter(getContext(), (int) R.layout.input_plate_number_district, this.districts));
        this.gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.mico.setting.InputPlateNumberView.AnonymousClass1 */

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                InputPlateNumberView.this.toggleButton.setTextOn((String) adapterView.getItemAtPosition(i));
                InputPlateNumberView.this.toggleButton.setTextOff((String) adapterView.getItemAtPosition(i));
                InputPlateNumberView.this.toggleButton.toggle();
                InputPlateNumberView inputPlateNumberView = InputPlateNumberView.this;
                inputPlateNumberView.lambda$onFinishInflate$1$InputPlateNumberView(inputPlateNumberView.toggleButton);
            }
        });
        InputFilter[] filters = this.inputViewEditor.getFilters();
        InputFilter[] inputFilterArr = new InputFilter[(filters.length + 1)];
        System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
        inputFilterArr[filters.length] = new InputFilter.AllCaps();
        this.inputViewEditor.setFilters(inputFilterArr);
    }

    /* renamed from: onViewClicked */
    public void lambda$onFinishInflate$1$InputPlateNumberView(View view) {
        int id = view.getId();
        if (id == R.id.toggle) {
            this.gridview.setVisibility(this.toggleButton.isChecked() ? 0 : 8);
            if (this.toggleButton.isChecked()) {
                this.toggleButton.requestFocus();
                KeyboardUtils.hideKeyboard(this.inputViewEditor);
                return;
            }
            this.inputViewEditor.requestFocus();
            KeyboardUtils.showKeyboard(this.inputViewEditor);
        } else if (id == R.id.input_view_clear) {
            this.inputViewEditor.setText("");
        }
    }

    public boolean isNumberValid() {
        return this.inputViewEditor.getText().toString().matches("[A-Za-z][A-Z0-9a-z]{5,6}$");
    }

    public String getPlateNumber() {
        return String.format("%s%s", this.toggleButton.getText().toString(), this.inputViewEditor.getText().toString()).toUpperCase();
    }

    public void setPlateNumber(String str) {
        this.plateNumber = str;
        if (str.length() > 0) {
            int i = 1;
            String substring = str.substring(0, 1);
            String[] strArr = this.districts;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i = 0;
                    break;
                } else if (strArr[i2].equals(substring)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i != 0) {
                this.toggleButton.setText(substring);
                this.toggleButton.setTextOff(substring);
                this.toggleButton.setTextOn(substring);
            }
            this.inputViewEditor.setText(str.substring(i, str.length()));
            this.inputViewEditor.requestFocus();
            KeyboardUtils.showKeyboard(this.inputViewEditor);
        }
    }
}
