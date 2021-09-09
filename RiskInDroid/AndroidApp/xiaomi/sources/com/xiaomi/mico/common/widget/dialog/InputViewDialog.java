package com.xiaomi.mico.common.widget.dialog;

import _m_j.jdd;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaomi.mico.common.util.KeyboardUtils;
import com.xiaomi.mico.common.widget.dialog.MLAlertDialog2;
import com.xiaomi.smarthome.R;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class InputViewDialog {
    private Context mContext;
    private Params mParams = new Params();

    public interface Listener {
        void onFinish(String str);
    }

    public enum Reason {
        REPETITION,
        SPECIAL_CHARS,
        CHARS_TOO_LONG,
        EMPTY,
        TOO_SHORT
    }

    public InputViewDialog(Context context) {
        this.mContext = context;
    }

    public InputViewDialog setTitle(int i) {
        this.mParams.title = this.mContext.getString(i);
        return this;
    }

    public InputViewDialog setTitle(String str) {
        this.mParams.title = str;
        return this;
    }

    public InputViewDialog setHintText(int i) {
        this.mParams.hintText = this.mContext.getString(i);
        return this;
    }

    public InputViewDialog setShowBelowHint(boolean z) {
        this.mParams.showBelowHint = z;
        return this;
    }

    public InputViewDialog setSpecialCharIllegal(boolean z) {
        this.mParams.specialCharIllegal = z;
        return this;
    }

    public InputViewDialog setBelowHintHeader(String str) {
        this.mParams.belowHintHeader = str;
        return this;
    }

    public InputViewDialog setTextToCompare(List<String> list) {
        this.mParams.textToCompare = list;
        return this;
    }

    public InputViewDialog setHintText(String str) {
        this.mParams.hintText = str;
        return this;
    }

    public InputViewDialog setInitText(int i) {
        this.mParams.initText = this.mContext.getString(i);
        return this;
    }

    public InputViewDialog setInitText(String str) {
        this.mParams.initText = str;
        return this;
    }

    public InputViewDialog setInputType(int i) {
        this.mParams.inputType = i;
        return this;
    }

    public InputViewDialog setMinInputLength(int i) {
        this.mParams.minInputLength = i;
        return this;
    }

    public InputViewDialog setMaxInputLength(int i) {
        this.mParams.maxInputLength = i;
        return this;
    }

    public InputViewDialog setLengthUnit(int i) {
        this.mParams.lengthUnit = i;
        return this;
    }

    public InputViewDialog setRegularExpression(String str) {
        this.mParams.regularExpression = str;
        return this;
    }

    public InputViewDialog setListener(Listener listener) {
        this.mParams.listener = listener;
        return this;
    }

    public void show() {
        final InputView inputView = (InputView) LayoutInflater.from(this.mContext).inflate((int) R.layout.widget_input_view, (ViewGroup) null);
        inputView.initialize(this.mParams.hintText, this.mParams.initText, this.mParams.listener);
        inputView.setInputType(this.mParams.inputType);
        inputView.setInputLength(this.mParams.minInputLength, this.mParams.maxInputLength, this.mParams.lengthUnit);
        inputView.setRegularExpression(this.mParams.regularExpression);
        inputView.setShowBelowHint(this.mParams.showBelowHint);
        inputView.setSpecialCharIllegal(this.mParams.specialCharIllegal);
        inputView.setBelowHintHeader(this.mParams.belowHintHeader);
        inputView.setTextToCompare(this.mParams.textToCompare);
        inputView.setAlertDialog(new MLAlertDialog2.Builder(this.mContext).setTitle(this.mParams.title).setView(inputView).setPositiveButton((int) R.string.common_confirm, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.dialog.InputViewDialog.AnonymousClass2 */

            public void onClick(DialogInterface dialogInterface, int i) {
                inputView.onConfirm(dialogInterface);
            }
        }).setNegativeButton((int) R.string.common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.dialog.InputViewDialog.AnonymousClass1 */

            public void onClick(DialogInterface dialogInterface, int i) {
                ((MLAlertDialog2) dialogInterface).setAudoDismiss(true);
            }
        }).show());
    }

    static class Params {
        public String belowHintHeader;
        public String hintText;
        public String initText;
        public int inputType;
        public int lengthUnit;
        public Listener listener;
        public int maxInputLength;
        public int minInputLength;
        public String regularExpression;
        public boolean showBelowHint;
        public boolean specialCharIllegal;
        public List<String> textToCompare;
        public String title;

        private Params() {
            this.minInputLength = 1;
            this.maxInputLength = Integer.MAX_VALUE;
            this.lengthUnit = 1;
            this.inputType = 1;
        }
    }

    public static class InputView extends LinearLayout {
        private MLAlertDialog2 alertDialog;
        private String belowHintHeader;
        ImageView clear;
        EditText editor;
        TextView hintBelow;
        private int lengthUnit;
        private Listener listener;
        private InputFilter.LengthFilter mLengthFilter;
        private int maxInputLength;
        private int minInputLength;
        private String regularExpression;
        private boolean showBelowHint;
        private boolean specialCharIllegal;
        private List<String> textToCompare;

        public InputView(Context context) {
            super(context);
        }

        public InputView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            this.editor = (EditText) findViewById(R.id.input_view_editor);
            this.clear = (ImageView) findViewById(R.id.input_view_clear);
            this.hintBelow = (TextView) findViewById(R.id.hint_below);
            this.editor.addTextChangedListener(new TextWatcher() {
                /* class com.xiaomi.mico.common.widget.dialog.InputViewDialog.InputView.AnonymousClass1 */

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    if (!TextUtils.isEmpty(editable.toString())) {
                        InputView.this.clear.setVisibility(0);
                    } else {
                        InputView.this.clear.setVisibility(8);
                    }
                    InputView.this.checkConfirmEnabled();
                }
            });
            this.editor.setText("");
            this.editor.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                /* class com.xiaomi.mico.common.widget.dialog.InputViewDialog.InputView.AnonymousClass2 */

                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        KeyboardUtils.showKeyboard(InputView.this.editor);
                    }
                }
            });
            this.clear.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.common.widget.dialog.InputViewDialog.InputView.AnonymousClass3 */

                public void onClick(View view) {
                    InputView.this.editor.setText("");
                }
            });
        }

        public void initialize(String str, String str2, Listener listener2) {
            if (str != null) {
                this.editor.setHint(str);
            }
            if (str2 != null) {
                this.editor.setText(str2);
                this.editor.setSelection(str2.length());
            }
            this.listener = listener2;
        }

        public void setInputType(int i) {
            this.editor.setInputType(i);
        }

        public void setInputLength(int i, int i2, int i3) {
            if (i2 >= i) {
                this.minInputLength = i;
                this.maxInputLength = i2;
                this.lengthUnit = i3;
                InputFilter[] inputFilterArr = (InputFilter[]) jdd.O000000o(this.editor.getFilters(), this.mLengthFilter);
                this.mLengthFilter = new InputFilter.LengthFilter(i2);
                int length = inputFilterArr.length;
                InputFilter[] inputFilterArr2 = new InputFilter[(length + 1)];
                System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
                inputFilterArr2[length] = this.mLengthFilter;
                this.editor.setFilters(inputFilterArr2);
            }
        }

        public void setRegularExpression(String str) {
            this.regularExpression = str;
        }

        public void setAlertDialog(MLAlertDialog2 mLAlertDialog2) {
            this.alertDialog = mLAlertDialog2;
            checkConfirmEnabled();
        }

        public void setShowBelowHint(boolean z) {
            this.showBelowHint = z;
        }

        public void setTextToCompare(List<String> list) {
            this.textToCompare = list;
        }

        public void setBelowHintHeader(String str) {
            this.belowHintHeader = str;
        }

        public void setSpecialCharIllegal(boolean z) {
            this.specialCharIllegal = z;
        }

        public void checkConfirmEnabled() {
            Button button;
            int i;
            MLAlertDialog2 mLAlertDialog2 = this.alertDialog;
            if (mLAlertDialog2 != null && (button = mLAlertDialog2.getButton(-1)) != null) {
                String obj = this.editor.getText().toString();
                Reason reason = null;
                boolean z = true;
                if (this.lengthUnit == 0) {
                    i = obj.getBytes(Charset.forName("UTF-8")).length;
                } else {
                    i = obj.length();
                }
                boolean z2 = false;
                if (i <= this.minInputLength) {
                    if (this.showBelowHint) {
                        if (i == 0) {
                            reason = Reason.EMPTY;
                        } else {
                            reason = Reason.TOO_SHORT;
                        }
                    }
                    z = false;
                }
                if (this.specialCharIllegal && InputViewDialog.isSpecialCharExist(obj)) {
                    if (this.showBelowHint) {
                        reason = Reason.SPECIAL_CHARS;
                    }
                    z = false;
                }
                if (i >= this.maxInputLength) {
                    if (this.showBelowHint) {
                        reason = Reason.CHARS_TOO_LONG;
                    }
                    z = false;
                }
                List<String> list = this.textToCompare;
                if (list != null) {
                    Iterator<String> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (it.next().equals(obj)) {
                            if (this.showBelowHint) {
                                reason = Reason.REPETITION;
                            }
                        }
                    }
                }
                z2 = z;
                setBelowHint(reason);
                button.setEnabled(z2);
            }
        }

        public void onConfirm(DialogInterface dialogInterface) {
            int i;
            if (this.listener != null) {
                String trim = this.editor.getText().toString().trim();
                if (TextUtils.isEmpty(this.regularExpression) || trim.matches(this.regularExpression)) {
                    if (this.lengthUnit == 0) {
                        i = trim.getBytes(Charset.forName("UTF-8")).length;
                    } else {
                        i = trim.length();
                    }
                    if (i == 0 && this.minInputLength > 0) {
                        Toast.makeText(getContext(), (int) R.string.common_input_is_empty, 0).show();
                    } else if (i > this.maxInputLength) {
                        Resources resources = getResources();
                        int i2 = this.maxInputLength;
                        Toast.makeText(getContext(), resources.getQuantityString(R.plurals.common_input_too_long, i2, Integer.valueOf(i2)), 0).show();
                    } else {
                        ((MLAlertDialog2) dialogInterface).setAudoDismiss(true);
                        this.listener.onFinish(trim);
                    }
                } else {
                    Toast.makeText(getContext(), (int) R.string.common_input_not_regular, 0).show();
                }
            }
        }

        public void setBelowHint(Reason reason) {
            if (reason == null) {
                this.hintBelow.setVisibility(8);
                return;
            }
            this.hintBelow.setVisibility(0);
            String str = this.belowHintHeader;
            int i = AnonymousClass3.$SwitchMap$com$xiaomi$mico$common$widget$dialog$InputViewDialog$Reason[reason.ordinal()];
            if (i == 1) {
                this.hintBelow.setText(str + ((Object) getResources().getText(R.string.name_too_short_not_allowed)));
            } else if (i == 2) {
                this.hintBelow.setText(str + ((Object) getResources().getText(R.string.name_empty_not_allowed)));
            } else if (i == 3) {
                this.hintBelow.setText(str + ((Object) getResources().getText(R.string.name_repetition_not_allowed)));
            } else if (i == 4) {
                this.hintBelow.setText(str + ((Object) getResources().getText(R.string.name_special_chars_not_allowed)));
            } else if (i == 5) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                Resources resources = getResources();
                int i2 = this.maxInputLength;
                sb.append(resources.getQuantityString(R.plurals.common_input_too_long, i2, Integer.valueOf(i2)));
                this.hintBelow.setText(sb.toString());
            }
        }
    }

    /* renamed from: com.xiaomi.mico.common.widget.dialog.InputViewDialog$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaomi$mico$common$widget$dialog$InputViewDialog$Reason = new int[Reason.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$xiaomi$mico$common$widget$dialog$InputViewDialog$Reason[Reason.TOO_SHORT.ordinal()] = 1;
            $SwitchMap$com$xiaomi$mico$common$widget$dialog$InputViewDialog$Reason[Reason.EMPTY.ordinal()] = 2;
            $SwitchMap$com$xiaomi$mico$common$widget$dialog$InputViewDialog$Reason[Reason.REPETITION.ordinal()] = 3;
            $SwitchMap$com$xiaomi$mico$common$widget$dialog$InputViewDialog$Reason[Reason.SPECIAL_CHARS.ordinal()] = 4;
            $SwitchMap$com$xiaomi$mico$common$widget$dialog$InputViewDialog$Reason[Reason.CHARS_TOO_LONG.ordinal()] = 5;
        }
    }

    public static boolean isSpecialCharExist(String str) {
        return Pattern.compile("[ _`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\\n|\\r|\\t").matcher(str).find();
    }
}
