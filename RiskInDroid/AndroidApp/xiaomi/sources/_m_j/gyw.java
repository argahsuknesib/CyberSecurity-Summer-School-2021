package _m_j;

import _m_j.fno;
import _m_j.gpa;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.utils.ClientRemarkInputView;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.ArrayList;
import java.util.Arrays;

public final class gyw {
    public static void O000000o(final Context context, final Device device) {
        if (device != null && context != null) {
            final MLAlertDialog O00000oo = new MLAlertDialog.Builder(context).O000000o(new O000000o(context, device), (DialogInterface.OnClickListener) null).O000000o(device.getName()).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000oo();
            O00000oo.getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class _m_j.gyw.AnonymousClass1 */

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    String str;
                    if (i == 0) {
                        Context context = context;
                        Device device = device;
                        gpa.AnonymousClass6 r2 = new ClientRemarkInputView.O000000o(context, device) {
                            /* class _m_j.gpa.AnonymousClass6 */

                            /* renamed from: O000000o */
                            final /* synthetic */ Context f18110O000000o;
                            final /* synthetic */ Device O00000Oo;

                            {
                                this.f18110O000000o = r1;
                                this.O00000Oo = r2;
                            }

                            public final void modifyBackName(String str) {
                                XQProgressDialog xQProgressDialog = new XQProgressDialog(this.f18110O000000o);
                                xQProgressDialog.setMessage(this.f18110O000000o.getString(R.string.changeing_back_name));
                                xQProgressDialog.setCancelable(false);
                                xQProgressDialog.show();
                                Device device = this.O00000Oo;
                                if (device != null) {
                                    gpa.O000000o(this.f18110O000000o, device, str, xQProgressDialog, null, false);
                                }
                            }
                        };
                        ClientRemarkInputView clientRemarkInputView = (ClientRemarkInputView) LayoutInflater.from(context).inflate((int) R.layout.client_remark_input_view, (ViewGroup) null);
                        MLAlertDialog O00000oo = new MLAlertDialog.Builder(context).O00000o0().O000000o((int) R.string.change_back_name).O000000o(clientRemarkInputView).O00000Oo(false).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener(clientRemarkInputView) {
                            /* class _m_j.gpa.AnonymousClass3 */

                            /* renamed from: O000000o */
                            final /* synthetic */ ClientRemarkInputView f18107O000000o;

                            {
                                this.f18107O000000o = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.f18107O000000o.O000000o(dialogInterface);
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                            /* class _m_j.gpa.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                            }
                        }).O000000o(new DialogInterface.OnCancelListener() {
                            /* class _m_j.gpa.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        }).O00000oo();
                        gpa.AnonymousClass4 r3 = new ClientRemarkInputView.O000000o(r2) {
                            /* class _m_j.gpa.AnonymousClass4 */

                            /* renamed from: O000000o */
                            final /* synthetic */ ClientRemarkInputView.O000000o f18108O000000o;

                            {
                                this.f18108O000000o = r1;
                            }

                            public final void modifyBackName(String str) {
                                ClientRemarkInputView.O000000o o000000o = this.f18108O000000o;
                                if (o000000o != null) {
                                    o000000o.modifyBackName(str);
                                }
                            }
                        };
                        if (device == null) {
                            str = "";
                        } else {
                            str = device.name;
                        }
                        clientRemarkInputView.O000000o(r3, O00000oo, str);
                        clientRemarkInputView.setNeedVerifyConfirm(false);
                        EditText editText = clientRemarkInputView.getEditText();
                        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(41)});
                        Button button = O00000oo.getButton(-1);
                        button.setEnabled(false);
                        button.setTextColor(context.getResources().getColor(R.color.mj_color_dialog_button1_bg_nor));
                        clientRemarkInputView.getEditText().addTextChangedListener(new TextWatcher(clientRemarkInputView, button, editText, context) {
                            /* class _m_j.gpa.AnonymousClass5 */

                            /* renamed from: O000000o */
                            final /* synthetic */ ClientRemarkInputView f18109O000000o;
                            final /* synthetic */ Button O00000Oo;
                            final /* synthetic */ Context O00000o;
                            final /* synthetic */ EditText O00000o0;

                            public final void afterTextChanged(Editable editable) {
                            }

                            {
                                this.f18109O000000o = r1;
                                this.O00000Oo = r2;
                                this.O00000o0 = r3;
                                this.O00000o = r4;
                            }

                            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                this.f18109O000000o.setAlertText("");
                                this.O00000Oo.setEnabled(true);
                            }

                            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                String obj = this.O00000o0.getText().toString();
                                if (obj.length() > 0) {
                                    if (gqb.O00000o0(obj)) {
                                        this.f18109O000000o.setAlertText(this.O00000o.getString(R.string.tag_save_data_description));
                                    } else if (!hah.O000000o(obj)) {
                                        this.f18109O000000o.setAlertText(this.O00000o.getString(R.string.room_name_too_long));
                                    } else {
                                        this.f18109O000000o.setAlertText("");
                                        this.O00000Oo.setEnabled(true);
                                        return;
                                    }
                                }
                                this.O00000Oo.setEnabled(false);
                            }
                        });
                    } else if (i == 1) {
                        Context context2 = context;
                        Device device2 = device;
                        if (CoreApi.O000000o().O0000Ooo()) {
                            fbt fbt = new fbt(context2, "/share/ShareDeviceActivity");
                            Bundle bundle = new Bundle();
                            bundle.putString("user_id", CoreApi.O000000o().O0000o0());
                            bundle.putString("did", device2.did);
                            fbt.O000000o(bundle);
                            fbs.O000000o(fbt);
                        } else {
                            izb.O000000o(context2, (int) R.string.loggin_first, 0).show();
                        }
                    } else if (i == 2) {
                        Context context3 = context;
                        new MLAlertDialog.Builder(context3).O00000Oo((int) R.string.delete_common_device).O000000o((int) R.string.tag_remove, new DialogInterface.OnClickListener(context3, device) {
                            /* class _m_j.gyw.AnonymousClass2 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ Context f18600O000000o;
                            final /* synthetic */ Device O00000Oo;

                            {
                                this.f18600O000000o = r1;
                                this.O00000Oo = r2;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (goy.O00000o()) {
                                    gqg.O000000o((int) R.string.smarthome_device_mijia_cant_delete);
                                    return;
                                }
                                final XQProgressDialog xQProgressDialog = new XQProgressDialog(this.f18600O000000o);
                                xQProgressDialog.setMessage(this.f18600O000000o.getString(R.string.smarthome_deleting));
                                xQProgressDialog.setCancelable(false);
                                xQProgressDialog.show();
                                new ArrayList().add(this.O00000Oo);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(this.O00000Oo.did);
                                fno.O000000o().O000000o(arrayList, this.f18600O000000o, new fno.O00000Oo() {
                                    /* class _m_j.gyw.AnonymousClass2.AnonymousClass1 */

                                    public final void O000000o() {
                                        xQProgressDialog.dismiss();
                                        gqg.O00000Oo(AnonymousClass2.this.f18600O000000o.getResources().getString(R.string.common_used_device_del, AnonymousClass2.this.O00000Oo.getName()));
                                    }

                                    public final void O000000o(fso fso) {
                                        Device O000000o2 = fno.O000000o().O000000o(fso.O00000Oo.substring(fso.O00000Oo.indexOf("did:") + 4));
                                        if (O000000o2 == null || !ggb.O0000o.contains(O000000o2.model)) {
                                            gqg.O00000Oo((int) R.string.bind_error);
                                        } else {
                                            gqg.O00000Oo((int) R.string.miband_remove_warning);
                                        }
                                        xQProgressDialog.dismiss();
                                    }
                                });
                                dialogInterface.dismiss();
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000oo().getButton(-1).setTextColor(context3.getResources().getColor(R.color.mj_color_red_normal));
                    }
                    O00000oo.dismiss();
                }
            });
        }
    }

    static class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        private Context f18602O000000o;
        private Device O00000Oo;
        private String[] O00000o0;

        public final long getItemId(int i) {
            return (long) i;
        }

        public O000000o(Context context, Device device) {
            this.f18602O000000o = context;
            this.O00000o0 = context.getResources().getStringArray(R.array.common_edit_item_name);
            String[] strArr = this.O00000o0;
            this.O00000o0 = (String[]) Arrays.copyOf(strArr, strArr.length - 1);
            this.O00000Oo = device;
        }

        public final int getCount() {
            return this.O00000o0.length;
        }

        public final boolean isEnabled(int i) {
            if (fqw.O000000o(this.O00000Oo.did)) {
                return false;
            }
            if (i == 0) {
                return DeviceRouterFactory.getDeviceWrapper().canRename(this.O00000Oo);
            }
            if (i == 1) {
                return DeviceRouterFactory.getDeviceWrapper().canBeShared(this.O00000Oo);
            }
            if (i != 2) {
                return super.isEnabled(i);
            }
            return DeviceRouterFactory.getDeviceWrapper().canBeDeleted(this.O00000Oo);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            C0111O000000o o000000o;
            if (view == null) {
                view = LayoutInflater.from(this.f18602O000000o).inflate((int) R.layout.common_device_edit_item_layout, viewGroup, false);
                o000000o = new C0111O000000o();
                o000000o.f18603O000000o = (TextView) view.findViewById(R.id.tv_name);
                view.setTag(o000000o);
            } else {
                o000000o = (C0111O000000o) view.getTag();
            }
            o000000o.f18603O000000o.setText(this.O00000o0[i]);
            o000000o.f18603O000000o.setEnabled(isEnabled(i));
            return view;
        }

        /* renamed from: _m_j.gyw$O000000o$O000000o  reason: collision with other inner class name */
        class C0111O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f18603O000000o;

            C0111O000000o() {
            }
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i) {
            return this.O00000o0[i];
        }
    }
}
