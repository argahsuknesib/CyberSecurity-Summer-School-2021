package _m_j;

import _m_j.ggb;
import _m_j.hah;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.ArrayList;
import java.util.List;

public final class haf {

    /* renamed from: O000000o  reason: collision with root package name */
    public static List<String> f18690O000000o = new ArrayList();

    public interface O000000o {
        void onSuccess(String str);
    }

    public static void O000000o(final Context context, final List<String> list, final O000000o o000000o) {
        final MLAlertDialog O000000o2 = hah.O000000o(context, "", context.getString(R.string.room_name_update), context.getString(R.string.input_tag_name_hint), new hah.O000000o() {
            /* class _m_j.haf.AnonymousClass3 */

            public final void O000000o(final String str) {
                ggb.O00000Oo().O000000o(str, list, (String) null, new ggb.O00000o() {
                    /* class _m_j.haf.AnonymousClass3.AnonymousClass1 */

                    public final void O000000o() {
                        if (!(context instanceof BaseActivity) || ((BaseActivity) context).isValid()) {
                            gqg.O00000Oo((int) R.string.create_success);
                            if (o000000o != null) {
                                o000000o.onSuccess(str);
                            }
                            hxi.O00000o.O00000o(str);
                        }
                    }

                    public final void O000000o(int i, fso fso) {
                        if ((context instanceof BaseActivity) && !((BaseActivity) context).isValid()) {
                            return;
                        }
                        if (fso == null || fso.f17063O000000o != -35) {
                            gqg.O00000Oo((int) R.string.add_failed);
                        } else {
                            gqg.O00000Oo((int) R.string.name_repeat);
                        }
                    }
                });
                hxi.O00000o.O0000Oo();
            }

            public final String O00000Oo(String str) {
                if (ggb.O00000Oo().O000000o((Room) null, str, (String) null)) {
                    return context.getString(R.string.room_name_duplicate);
                }
                return null;
            }
        });
        O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class _m_j.haf.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                hxi.O00000o.O0000Oo0();
            }
        });
        O000000o2.getButton(-2).setOnClickListener(new View.OnClickListener() {
            /* class _m_j.haf.AnonymousClass5 */

            public final void onClick(View view) {
                O000000o2.dismiss();
                hxi.O00000o.O0000Oo0();
            }
        });
    }

    public static void O000000o(final String str, final Context context, final List<String> list, final O000000o o000000o) {
        final MLAlertDialog O000000o2 = hah.O000000o(context, "", context.getString(R.string.room_name_update), context.getString(R.string.input_tag_name_hint), new hah.O000000o() {
            /* class _m_j.haf.AnonymousClass6 */

            public final void O000000o(final String str) {
                ggb.O00000Oo().O000000o(str, str, list, null, new ggb.O00000o() {
                    /* class _m_j.haf.AnonymousClass6.AnonymousClass1 */

                    public final void O000000o() {
                        if (!(context instanceof BaseActivity) || ((BaseActivity) context).isValid()) {
                            gqg.O00000Oo((int) R.string.create_success);
                            if (o000000o != null) {
                                o000000o.onSuccess(str);
                            }
                            hxi.O00000o.O00000o(str);
                            hxi.O00000o.O0000Oo0(1);
                        }
                    }

                    public final void O000000o(int i, fso fso) {
                        if ((context instanceof BaseActivity) && !((BaseActivity) context).isValid()) {
                            return;
                        }
                        if (fso == null || fso.f17063O000000o != -35) {
                            gqg.O00000Oo((int) R.string.add_failed);
                        } else {
                            gqg.O00000Oo((int) R.string.name_repeat);
                        }
                    }
                });
                hxi.O00000o.O0000Oo();
            }

            public final String O00000Oo(String str) {
                if (ggb.O00000Oo().O000000o((Room) null, str, str)) {
                    return context.getString(R.string.room_name_duplicate);
                }
                return null;
            }
        });
        O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class _m_j.haf.AnonymousClass7 */

            public final void onCancel(DialogInterface dialogInterface) {
                hxi.O00000o.O0000Oo0();
                hxi.O00000o.O0000Oo0(0);
            }
        });
        O000000o2.getButton(-2).setOnClickListener(new View.OnClickListener() {
            /* class _m_j.haf.AnonymousClass1 */

            public final void onClick(View view) {
                O000000o2.dismiss();
                hxi.O00000o.O0000Oo0();
                hxi.O00000o.O0000Oo0(0);
            }
        });
    }

    public static void O000000o(final Context context, final O000000o o000000o) {
        MLAlertDialog O000000o2 = hah.O000000o(context, "", context.getString(R.string.room_name_update), context.getString(R.string.input_tag_name_hint), new hah.O000000o() {
            /* class _m_j.haf.AnonymousClass2 */

            public final void O000000o(String str) {
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onSuccess(str);
                }
            }

            public final String O00000Oo(String str) {
                if (ggb.O00000Oo().O000000o((Room) null, str, (String) null)) {
                    return context.getString(R.string.room_name_duplicate);
                }
                return null;
            }
        });
        O000000o2.getButton(-2).setOnClickListener(new View.OnClickListener() {
            /* class _m_j.$$Lambda$haf$1MNvwouNAq9EmHc1WAeGXkDJmKU */

            public final void onClick(View view) {
                MLAlertDialog.this.dismiss();
            }
        });
    }
}
