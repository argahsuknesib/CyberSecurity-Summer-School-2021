package _m_j;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.utils.ClientRemarkInputView;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.CommonFlowGroup;
import java.text.ParsePosition;
import java.util.List;

public final class hah {

    public interface O000000o {
        void O000000o(String str);

        String O00000Oo(String str);
    }

    public interface O00000Oo extends O000000o {
        void O000000o(ClientRemarkInputView clientRemarkInputView, String str);
    }

    public static MLAlertDialog O000000o(Context context, String str, String str2, String str3, O000000o o000000o) {
        return O00000Oo(context, str, str2, str3, o000000o);
    }

    private static MLAlertDialog O00000Oo(Context context, String str, String str2, String str3, O000000o o000000o) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        final ClientRemarkInputView clientRemarkInputView = (ClientRemarkInputView) LayoutInflater.from(context).inflate((int) R.layout.client_remark_input_view, (ViewGroup) null);
        EditText editText = clientRemarkInputView.getEditText();
        final CommonFlowGroup commonFlowGroup = clientRemarkInputView.getCommonFlowGroup();
        TextView titleRoomRecommend = clientRemarkInputView.getTitleRoomRecommend();
        final ParsePosition parsePosition = new ParsePosition(-1);
        commonFlowGroup.setVisibility(8);
        if (TextUtils.isEmpty(null)) {
            titleRoomRecommend.setVisibility(8);
        } else {
            titleRoomRecommend.setVisibility(0);
            titleRoomRecommend.setText((CharSequence) null);
        }
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(41)});
        MLAlertDialog O00000o = new MLAlertDialog.Builder(context).O00000o0().O000000o(str2).O000000o(clientRemarkInputView).O00000Oo(true).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener(o000000o, parsePosition, null, editText) {
            /* class _m_j.hah.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O000000o f18699O000000o;
            final /* synthetic */ ParsePosition O00000Oo;
            final /* synthetic */ EditText O00000o;
            final /* synthetic */ List O00000o0 = null;

            {
                this.f18699O000000o = r1;
                this.O00000Oo = r2;
                this.O00000o = r4;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                List list;
                if (this.f18699O000000o == null) {
                    return;
                }
                if (this.O00000Oo.getIndex() <= 0 || (list = this.O00000o0) == null) {
                    this.f18699O000000o.O000000o(this.O00000o.getText().toString());
                } else {
                    this.f18699O000000o.O000000o((String) list.get(this.O00000Oo.getIndex()));
                }
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class _m_j.hah.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }).O00000o();
        clientRemarkInputView.O000000o(null, O00000o, str, str3);
        O00000o.show();
        final Button button = O00000o.getButton(-1);
        button.setEnabled(false);
        final EditText editText2 = editText;
        final Context context2 = context;
        final O000000o o000000o2 = o000000o;
        editText.addTextChangedListener(new TextWatcher() {
            /* class _m_j.hah.AnonymousClass3 */

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                clientRemarkInputView.setAlertText("");
                button.setEnabled(true);
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String obj = editText2.getText().toString();
                if (obj.length() > 0) {
                    if (gqb.O00000o0(obj)) {
                        clientRemarkInputView.setAlertText(context2.getString(R.string.tag_save_data_description));
                    } else if (!hah.O000000o(obj)) {
                        clientRemarkInputView.setAlertText(context2.getString(R.string.room_name_too_long));
                    } else {
                        if (commonFlowGroup.getSelectIndex() >= 0) {
                            commonFlowGroup.setSelectIndex(-1);
                            parsePosition.setIndex(-1);
                        }
                        O000000o o000000o = o000000o2;
                        if (o000000o != null) {
                            String O00000Oo2 = o000000o.O00000Oo(obj);
                            if (!TextUtils.isEmpty(O00000Oo2)) {
                                button.setEnabled(false);
                                clientRemarkInputView.setAlertText(O00000Oo2);
                                return;
                            }
                            clientRemarkInputView.setAlertText("");
                            button.setEnabled(true);
                            return;
                        }
                        clientRemarkInputView.setAlertText("");
                        button.setEnabled(true);
                        return;
                    }
                }
                button.setEnabled(false);
            }
        });
        return O00000o;
    }

    public static boolean O000000o(String str) {
        if ((TextUtils.isEmpty(str) || str.length() <= 40) && gqb.O000000o((CharSequence) str) <= 40) {
            return true;
        }
        return false;
    }

    public static void O000000o(Context context, int i, String str, String str2, String str3, int i2, O00000Oo o00000Oo) {
        final ClientRemarkInputView clientRemarkInputView;
        int i3 = i;
        String str4 = "";
        String str5 = TextUtils.isEmpty(str2) ? str4 : str2;
        if (!TextUtils.isEmpty(str3)) {
            str4 = str3;
        }
        if (i3 == -1) {
            clientRemarkInputView = (ClientRemarkInputView) LayoutInflater.from(context).inflate((int) R.layout.client_remark_input_view, (ViewGroup) null);
        } else {
            clientRemarkInputView = (ClientRemarkInputView) LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        }
        final EditText editText = clientRemarkInputView.getEditText();
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter((i2 * 2) + 1)});
        final O00000Oo o00000Oo2 = o00000Oo;
        MLAlertDialog O00000o = new MLAlertDialog.Builder(context).O00000o0().O000000o(str5).O000000o(clientRemarkInputView).O00000Oo(true).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class _m_j.hah.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                O00000Oo o00000Oo = o00000Oo2;
                if (o00000Oo != null) {
                    o00000Oo.O000000o(clientRemarkInputView, editText.getText().toString());
                }
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class _m_j.hah.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }).O00000o();
        clientRemarkInputView.O000000o(null, O00000o, str, str4);
        O00000o.show();
        Button button = O00000o.getButton(-1);
        final ClientRemarkInputView clientRemarkInputView2 = clientRemarkInputView;
        O000000o(editText, clientRemarkInputView2, context, button, i2, o00000Oo);
        final Button button2 = button;
        final EditText editText2 = editText;
        final Context context2 = context;
        final int i4 = i2;
        final O00000Oo o00000Oo3 = o00000Oo;
        editText.addTextChangedListener(new TextWatcher() {
            /* class _m_j.hah.AnonymousClass6 */

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                clientRemarkInputView2.setAlertText("");
                button2.setEnabled(true);
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                hah.O000000o(editText2, clientRemarkInputView2, context2, button2, i4, o00000Oo3);
            }
        });
    }

    public static void O000000o(EditText editText, ClientRemarkInputView clientRemarkInputView, Context context, Button button, int i, O00000Oo o00000Oo) {
        String obj = editText.getText().toString();
        if (obj.length() > 0) {
            if (gqb.O000000o(obj, "[\"!$^*{}<>?|\\[\\]=\\\\]|--")) {
                clientRemarkInputView.setAlertText(context.getString(R.string.tag_save_data_description));
            } else if (gqb.O00000o0((CharSequence) obj) > i * 2) {
                clientRemarkInputView.setAlertText(context.getString(R.string.room_name_too_long));
            } else if (o00000Oo != null) {
                String O00000Oo2 = o00000Oo.O00000Oo(obj);
                if (!TextUtils.isEmpty(O00000Oo2)) {
                    button.setEnabled(false);
                    clientRemarkInputView.setAlertText(O00000Oo2);
                    return;
                }
                clientRemarkInputView.setAlertText("");
                button.setEnabled(true);
                return;
            } else {
                clientRemarkInputView.setAlertText("");
                button.setEnabled(true);
                return;
            }
        }
        button.setEnabled(false);
    }
}
