package _m_j;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.family.ShareHomeActivity;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import com.xiaomi.smarthome.miio.db.record.ShareUserRecord;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class frs extends fvm {

    /* renamed from: O000000o  reason: collision with root package name */
    View f16982O000000o;
    AutoCompleteTextView O00000Oo;
    TextView O00000o;
    TextView O00000o0;
    LinearLayout O00000oO;
    SimpleDraweeView O00000oo;
    ConstraintLayout O0000O0o;
    String O0000OOo;
    public List<String> O0000Oo = new ArrayList();
    int O0000Oo0 = 0;
    public UserInfo O0000OoO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() instanceof ShareHomeActivity) {
            this.O0000OOo = ((ShareHomeActivity) getActivity()).getHomeId();
        }
        this.O0000Oo0 = 1;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f16982O000000o == null) {
            this.f16982O000000o = layoutInflater.inflate((int) R.layout.fragment_share_home_intput_uid, (ViewGroup) null);
        }
        return this.f16982O000000o;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O00000Oo = (AutoCompleteTextView) this.f16982O000000o.findViewById(R.id.account_editor);
        this.O00000o0 = (TextView) this.f16982O000000o.findViewById(R.id.button_search);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.frs.AnonymousClass1 */

            public final void onClick(View view) {
                frs frs = frs.this;
                if (frs.O0000Oo0 == 1) {
                    frs.O000000o(frs.O00000Oo.getText().toString());
                } else if (frs.O0000Oo0 == 2) {
                    frs.O00000o0.setEnabled(false);
                    ggc.O000000o().O000000o(frs.O0000OoO, frs.O0000OOo, new fsm<JSONObject, fso>() {
                        /* class _m_j.frs.AnonymousClass3 */

                        public final void onFailure(fso fso) {
                            if (fso != null && (fso.f17063O000000o == -11 || fso.f17063O000000o == -12)) {
                                gqg.O00000Oo((int) R.string.add_failed_duplicate);
                            } else if (fso == null || fso.f17063O000000o != -8) {
                                gqg.O00000Oo((int) R.string.toast_failed_retry);
                            } else {
                                gqg.O00000Oo((int) R.string.cant_share_to_owner);
                            }
                            frs.this.O00000o0.setEnabled(true);
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            if (frs.this.getActivity() != null) {
                                frs.this.getActivity().setResult(-1);
                                frs.this.getActivity().finish();
                            }
                        }
                    });
                }
                hxi.O00000o.f952O000000o.O000000o("homeshare_mi_confirm", new Object[0]);
            }
        });
        this.O00000o = (TextView) this.f16982O000000o.findViewById(R.id.tv_user_name);
        this.O00000oO = (LinearLayout) this.f16982O000000o.findViewById(R.id.linear_share_device);
        this.O00000oo = (SimpleDraweeView) this.f16982O000000o.findViewById(R.id.icon_image);
        this.O0000O0o = (ConstraintLayout) this.f16982O000000o.findViewById(R.id.root);
        this.O00000Oo.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class _m_j.frs.AnonymousClass2 */

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                    return false;
                }
                frs frs = frs.this;
                if ((frs.O00000o0 == null || frs.O00000o0.getVisibility() != 0) ? false : frs.O00000o0.performClick()) {
                    return true;
                }
                return false;
            }
        });
        SimpleDraweeView simpleDraweeView = this.O00000oo;
        if (simpleDraweeView != null) {
            simpleDraweeView.setImageResource(R.drawable.mi_logo);
        }
        this.O00000Oo.getText().clear();
        this.O00000o.setVisibility(8);
        this.O00000oO.setVisibility(0);
        this.O00000o0.setText((int) R.string.home_member_search_user);
        this.O00000o0.setEnabled(true);
    }

    public void onResume() {
        super.onResume();
        hxi.O00000o0.f957O000000o.O000000o("homeshare_mi_show", new Object[0]);
    }

    public void onDestroyView() {
        super.onDestroyView();
        hxi.O00000o.f952O000000o.O000000o("homeshare_mi_back", new Object[0]);
    }

    public final void O000000o(final String str) {
        if (TextUtils.isEmpty(str)) {
            gqg.O00000Oo((int) R.string.please_inpt_account);
        } else {
            hys.O000000o().O000000o(getActivity(), str, new fsm<UserInfo, fso>() {
                /* class _m_j.frs.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    InputMethodManager inputMethodManager;
                    UserInfo userInfo = (UserInfo) obj;
                    if (userInfo != null && !TextUtils.isEmpty(userInfo.f7549O000000o) && !userInfo.f7549O000000o.equalsIgnoreCase("-1") && !userInfo.f7549O000000o.equalsIgnoreCase("0")) {
                        frs frs = frs.this;
                        frs.O0000Oo0 = 2;
                        if (Build.VERSION.SDK_INT >= 19) {
                            Fade fade = new Fade();
                            TransitionSet transitionSet = new TransitionSet();
                            transitionSet.setDuration(200L);
                            transitionSet.addTransition(fade);
                            TransitionManager.beginDelayedTransition(frs.O0000O0o, transitionSet);
                        }
                        frs.O00000oO.setVisibility(8);
                        frs.O00000o.setVisibility(0);
                        frs.O00000o0.setText((int) R.string.family_member_invite);
                        if (!(frs.getActivity() == null || (inputMethodManager = (InputMethodManager) frs.getActivity().getSystemService("input_method")) == null)) {
                            inputMethodManager.hideSoftInputFromWindow(frs.O00000Oo.getWindowToken(), 0);
                        }
                        frs frs2 = frs.this;
                        frs2.O0000OoO = userInfo;
                        frs2.O00000o.setText(frs.this.O0000OoO.O00000oO);
                        ShareUserRecord shareUserRecord = ShareUserRecord.get(str);
                        if (shareUserRecord != null) {
                            shareUserRecord.nickName = frs.this.O0000OoO.O00000oO;
                            shareUserRecord.url = frs.this.O0000OoO.O00000o0;
                            ShareUserRecord.insert(shareUserRecord);
                        }
                        gyl.O000000o().O000000o(frs.this.O0000OoO.f7549O000000o, frs.this.O00000oo, (BasePostprocessor) null);
                    } else if (frs.this.O0000Oo.size() > 0) {
                        frs.this.O000000o(frs.this.O0000Oo.remove(0));
                    } else {
                        gqg.O00000Oo((int) R.string.sh_user_not_exist);
                        frs frs3 = frs.this;
                        frs3.O0000Oo0 = 1;
                        frs3.O00000o.setVisibility(8);
                        frs3.O00000oO.setVisibility(0);
                        frs3.O00000o0.setText((int) R.string.sh_confirm);
                        frs3.O00000Oo.setText("");
                        frs3.O00000Oo.getText().clear();
                    }
                }

                public final void onFailure(fso fso) {
                    if (fso.f17063O000000o == ErrorCode.ERROR_NETWORK_ERROR.getCode()) {
                        gqg.O00000Oo((int) R.string.sh_network_not_available);
                    } else {
                        gqg.O00000Oo((int) R.string.sh_user_not_exist);
                    }
                }
            });
        }
    }
}
