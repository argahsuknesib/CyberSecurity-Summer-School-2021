package _m_j;

import a.a.a.b;
import a.a.a.e.c.g;
import a.a.a.e.c.n;
import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.widget.CircleRoadProgress;
import java.util.Random;

public final class O0O0o00 extends ooooooo implements View.OnClickListener, CircleRoadProgress.O00000Oo {
    public n O00000Oo;
    public Vibrator O00000o;
    public View O00000o0;
    public boolean O00000oO;
    public long[] O00000oo;
    public TextView O0000O0o;
    public TextView O0000OOo;
    public TextView O0000Oo;
    public b O0000Oo0;
    public TextView O0000OoO;
    public TextView O0000Ooo;
    public Button O0000o0;
    public TextView O0000o00;
    public TextView O0000o0O;

    public static O0O0o00 O000000o(n nVar) {
        O0O0o00 o0O0o00 = new O0O0o00();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_vibration_diagnose", nVar);
        o0O0o00.setArguments(bundle);
        return o0O0o00;
    }

    private void O000000o(View.OnClickListener onClickListener) {
        this.O0000Oo.setOnClickListener(onClickListener);
        this.O0000OoO.setOnClickListener(onClickListener);
        this.O0000Ooo.setOnClickListener(onClickListener);
        this.O0000o00.setOnClickListener(onClickListener);
    }

    private void O000000o(TextView textView) {
        if (textView != null) {
            textView.setBackgroundResource(R.drawable.prompt_boundary);
            textView.setTextColor(getResources().getColor(R.color.otex_text_color_black));
        }
    }

    public final g O00000o() {
        return this.O00000Oo;
    }

    public final void O00000oO() {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = new b("vib", 4005, false);
        }
        O000000o(this.O0000Oo0);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000Oo = (n) getArguments().getParcelable("arg_vibration_diagnose");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.fragment_vibration_diagnose, viewGroup, false);
        this.O00000o0 = inflate;
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O0000o0O = (TextView) view.findViewById(R.id.diagnoseActionButton);
        TextView textView = this.O0000o0O;
        int i = 0;
        if (textView != null) {
            textView.setVisibility(0);
            this.O0000o0O.setOnClickListener(this);
            this.O0000o0O.setText((int) R.string.otex_start);
        }
        this.O0000Oo = (TextView) view.findViewById(R.id.button_vibration_count_0);
        this.O0000OoO = (TextView) view.findViewById(R.id.button_vibration_count_1);
        this.O0000Ooo = (TextView) view.findViewById(R.id.button_vibration_count_2);
        this.O0000o00 = (TextView) view.findViewById(R.id.button_vibration_count_3);
        this.O0000O0o = (TextView) view.findViewById(R.id.diagnoseTitle);
        TextView textView2 = this.O0000O0o;
        if (textView2 != null) {
            textView2.setText(this.O00000Oo.O0000Oo);
        }
        this.O0000OOo = (TextView) view.findViewById(R.id.diagnoseMessage);
        TextView textView3 = this.O0000OOo;
        if (textView3 != null) {
            textView3.setText(this.O00000Oo.O0000OoO);
        }
        this.O0000o0 = (Button) view.findViewById(R.id.nextButton);
        Button button = this.O0000o0;
        if (button != null) {
            if (!this.O00000Oo.O00000Oo()) {
                i = 8;
            }
            button.setVisibility(i);
            this.O0000o0.setText(this.O00000Oo.O0000o0);
            this.O0000o0.setOnClickListener(this);
        }
    }

    public final void onResume() {
        super.onResume();
        if (!O000000o("android.permission.VIBRATE")) {
            if (this.O00000oO) {
                this.O0000Oo0 = new b("wf", 4002, false);
                ((ExchangeManager) getParentFragment()).O000000o(O00000Oo(), this, this.O00000Oo.O0000o);
                return;
            }
            requestPermissions(new String[]{"android.permission.VIBRATE"}, 0);
            this.O00000oO = true;
        } else if (getActivity() == null || ooooooo.O000000o(getActivity(), 3) || this.O00000oO) {
            TextView textView = this.O0000o0O;
            if (textView != null) {
                textView.setEnabled(true);
            }
            O000000o(this.O0000Oo);
            O000000o(this.O0000OoO);
            O000000o(this.O0000Ooo);
            O000000o(this.O0000o00);
            ((ExchangeManager) getParentFragment()).O000000o(O00000Oo(), this, this.O00000Oo.O0000o);
        } else {
            O000000o();
            this.O00000oO = true;
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void onPause() {
        Vibrator vibrator = this.O00000o;
        if (vibrator != null) {
            vibrator.cancel();
            this.O00000o = null;
        }
        ((ExchangeManager) getParentFragment()).O000000o();
        super.onPause();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x013c, code lost:
        if ((r8.length / 2) == 0) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0146, code lost:
        if ((r8.length / 2) == 1) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0150, code lost:
        if ((r8.length / 2) == 2) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015a, code lost:
        if ((r8.length / 2) == 3) goto L_0x015e;
     */
    public final void onClick(View view) {
        int id = view.getId();
        boolean z = true;
        if (id == R.id.nextButton) {
            Button button = this.O0000o0;
            if (button != null) {
                button.setEnabled(false);
            }
            TextView textView = this.O0000o0O;
            if (textView != null) {
                textView.setEnabled(false);
            }
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
            this.O0000Oo0 = new b("vib", 4001, false, true);
            return;
        }
        if (id == R.id.diagnoseActionButton) {
            ((ExchangeManager) getParentFragment()).O000000o();
            TextView textView2 = this.O0000O0o;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = this.O0000OOo;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            View view2 = this.O00000o0;
            if (view2 != null) {
                View findViewById = view2.findViewById(R.id.layout_vibration);
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                    ((TextView) this.O00000o0.findViewById(R.id.diagnoseHelp)).setText(this.O00000Oo.O0000Ooo);
                    this.O0000o0O.setText((int) R.string.otex_retry);
                }
            }
            if (isAdded()) {
                int nextInt = (new Random().nextInt(1000) % 3) + 1;
                this.O00000oo = new long[(nextInt * 2)];
                for (int i = 0; i < this.O00000Oo.f2619O000000o; i++) {
                    if (i < nextInt) {
                        long[] jArr = this.O00000oo;
                        int i2 = i * 2;
                        jArr[i2] = 1000;
                        jArr[i2 + 1] = 1000;
                    }
                }
                O000000o(this);
                if (O000000o("android.permission.VIBRATE") && getActivity() != null) {
                    this.O00000o = (Vibrator) getActivity().getSystemService("vibrator");
                    Vibrator vibrator = this.O00000o;
                    if (vibrator == null || !vibrator.hasVibrator()) {
                        O000000o(false);
                        return;
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        this.O00000o.vibrate(this.O00000oo, -1, new AudioAttributes.Builder().setUsage(4).build());
                        return;
                    } else {
                        this.O00000o.vibrate(this.O00000oo, -1);
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            O000000o((View.OnClickListener) null);
            TextView textView4 = this.O0000o0O;
            if (textView4 != null) {
                textView4.setText((int) R.string.otex_retry);
                this.O0000o0O.setEnabled(false);
            }
            TextView textView5 = (TextView) view;
            textView5.setBackgroundResource(R.drawable.orange_boundary);
            textView5.setTextColor(getResources().getColor(R.color.otexColorOrangeLight));
            long[] jArr2 = this.O00000oo;
            if (!(jArr2 == null || jArr2.length == 0)) {
                if (id != R.id.button_vibration_count_0) {
                    if (id != R.id.button_vibration_count_1) {
                        if (id != R.id.button_vibration_count_2) {
                            if (id != R.id.button_vibration_count_3) {
                                return;
                            }
                        }
                    }
                }
                z = false;
                O000000o(z);
                return;
            }
        }
        O000000o(false);
    }

    private void O000000o(boolean z) {
        ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.valueOf(!z));
        this.O0000Oo0 = new b("vib", Integer.valueOf(z ? 1 : 0), z);
    }
}
