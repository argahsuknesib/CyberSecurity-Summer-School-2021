package _m_j;

import _m_j.O0OOO0O;
import a.a.a.b;
import a.a.a.e.c.g;
import a.a.a.e.c.l;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.widget.CircleRoadProgress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public final class O0OoOo extends ooooooo implements CircleRoadProgress.O00000Oo {
    public final Handler O00000Oo = new Handler(Looper.myLooper());
    public l O00000o;
    public final List<Integer> O00000o0 = new ArrayList();
    public TextToSpeech O00000oO;
    public int O00000oo = -1;
    public boolean O0000O0o = true;
    public TextView O0000OOo;
    public TextView O0000Oo;
    public View O0000Oo0;
    public TextView O0000OoO;
    public TextView O0000Ooo;
    public Button O0000o0;
    public b O0000o00;
    public AudioManager O0000o0O;

    public class O000000o implements Runnable {
        public O000000o() {
        }

        public final void run() {
            FragmentActivity activity = O0OoOo.this.getActivity();
            if (O0OoOo.this.isAdded() && activity != null) {
                TextToSpeech unused = O0OoOo.this.O00000oO = new TextToSpeech(activity.getApplicationContext(), new O00000Oo());
                O0OoOo.this.O00000oO.setLanguage(Locale.getDefault());
            }
        }
    }

    public static O0OoOo O000000o(l lVar) {
        O0OoOo o0OoOo = new O0OoOo();
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_speaker_diagnose", lVar);
        o0OoOo.setArguments(bundle);
        return o0OoOo;
    }

    private void O000000o(View view, int i) {
        TextView textView = (TextView) view.findViewById(i);
        textView.setBackgroundResource(R.drawable.prompt_boundary);
        textView.setTextColor(getResources().getColor(R.color.otex_text_color_black));
    }

    private void O000000o(TextView textView) {
        if (textView != null && !textView.isEnabled()) {
            textView.setEnabled(true);
            textView.setBackgroundResource(R.drawable.prompt_boundary);
            textView.setTextColor(O00o.O000000o(getActivity(), (int) R.color.otexColorAccent));
        }
    }

    private void O000000o(String str, String str2) {
        TextToSpeech textToSpeech = this.O00000oO;
        if (textToSpeech != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                textToSpeech.speak(str, 1, null, str2);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("utteranceId", str2);
            this.O00000oO.speak(str, 1, hashMap);
        }
    }

    private static boolean O000000o(Context context) {
        try {
            for (String equalsIgnoreCase : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                if (equalsIgnoreCase.equalsIgnoreCase("android.permission.ACCESS_NOTIFICATION_POLICY")) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void O00000Oo(View view, int i) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
    }

    private void O00000oo() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                O0000Oo0();
            } catch (Exception unused) {
                if (O000000o(getContext())) {
                    O0000OoO();
                } else {
                    O0000Ooo();
                }
            }
        } else {
            O0000Oo0();
        }
    }

    private void O0000O0o() {
        if (getView() != null) {
            O000000o(getView(), (int) R.id.button_speaker_count_1);
            O000000o(getView(), (int) R.id.button_speaker_count_2);
            O000000o(getView(), (int) R.id.button_speaker_count_3);
            O000000o(getView(), (int) R.id.button_speaker_count_4);
            O000000o(getView(), (int) R.id.button_speaker_count_5);
            O000000o(getView(), (int) R.id.button_speaker_count_6);
            O000000o(getView(), (int) R.id.button_speaker_count_7);
            O000000o(getView(), (int) R.id.button_speaker_count_8);
        }
    }

    private void O0000Oo() {
        View view = getView();
        if (view != null) {
            O000000o((TextView) view.findViewById(R.id.button_speaker_count_1));
            O000000o((TextView) view.findViewById(R.id.button_speaker_count_2));
            O000000o((TextView) view.findViewById(R.id.button_speaker_count_3));
            O000000o((TextView) view.findViewById(R.id.button_speaker_count_4));
            O000000o((TextView) view.findViewById(R.id.button_speaker_count_5));
            O000000o((TextView) view.findViewById(R.id.button_speaker_count_6));
            O000000o((TextView) view.findViewById(R.id.button_speaker_count_7));
            O000000o((TextView) view.findViewById(R.id.button_speaker_count_8));
        }
    }

    private void O0000Oo0() {
        AudioManager audioManager = this.O0000o0O;
        if (audioManager != null) {
            this.O0000o0O.setStreamVolume(3, audioManager.getStreamMaxVolume(3), 2);
            O0000OOo();
        }
    }

    public final g O00000o() {
        return this.O00000o;
    }

    public final void O00000oO() {
        b bVar = this.O0000o00;
        if (bVar == null) {
            O000000o(new b("se", 4005, false));
        } else {
            O000000o(bVar);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 103) {
            O00000oo();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000o = (l) getArguments().getParcelable("arg_speaker_diagnose");
            if (getContext() != null) {
                this.O0000o0O = (AudioManager) getContext().getSystemService("audio");
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.fragment_speaker_diagnose, viewGroup, false);
    }

    public final void onDestroy() {
        super.onDestroy();
        TextToSpeech textToSpeech = this.O00000oO;
        if (textToSpeech != null) {
            textToSpeech.shutdown();
            this.O00000oO = null;
        }
    }

    public class O00000Oo implements TextToSpeech.OnInitListener {

        /* renamed from: _m_j.O0OoOo$O00000Oo$O00000Oo  reason: collision with other inner class name */
        public class C0063O00000Oo extends UtteranceProgressListener {

            /* renamed from: _m_j.O0OoOo$O00000Oo$O00000Oo$O000000o */
            public class O000000o implements Runnable {
                public O000000o() {
                }

                public final void run() {
                    if (O0OoOo.this.O0000OOo != null) {
                        O0OoOo.this.O0000OOo.setEnabled(true);
                    }
                }
            }

            public C0063O00000Oo() {
            }

            public final void onDone(String str) {
                O0OoOo.this.O00000Oo.post(new O000000o());
            }

            public final void onError(String str) {
            }

            public final void onStart(String str) {
            }
        }

        public class O00000o0 implements TextToSpeech.OnUtteranceCompletedListener {

            public class O000000o implements Runnable {
                public O000000o() {
                }

                public final void run() {
                    if (O0OoOo.this.O0000OOo != null) {
                        O0OoOo.this.O0000OOo.setEnabled(true);
                    }
                }
            }

            public O00000o0() {
            }

            public final void onUtteranceCompleted(String str) {
                O0OoOo.this.O00000Oo.post(new O000000o());
            }
        }

        public O00000Oo() {
        }

        public final void onInit(int i) {
            if (O0OoOo.this.isAdded()) {
                if (O0OoOo.this.O00000oO == null) {
                    O0OoOo.this.O00000Oo.post(new O000000o());
                    return;
                }
                int unused = O0OoOo.this.O00000oo = i;
                if (i == 0) {
                    O0OoOo.this.O0000OOo.setEnabled(true);
                    if (Build.VERSION.SDK_INT >= 15) {
                        O0OoOo.this.O00000oO.setOnUtteranceProgressListener(new C0063O00000Oo());
                    } else {
                        O0OoOo.this.O00000oO.setOnUtteranceCompletedListener(new O00000o0());
                    }
                } else {
                    O0OoOo.this.O00000Oo.post(new O00000o());
                }
            }
        }

        public class O000000o implements Runnable {
            public O000000o() {
            }

            public final void run() {
                b unused = O0OoOo.this.O0000o00 = new b("se", 4004, false);
                ((ExchangeManager) O0OoOo.this.getParentFragment()).O000000o(O0OoOo.this.O00000o0(), Boolean.TRUE);
            }
        }

        public class O00000o implements Runnable {
            public O00000o() {
            }

            public final void run() {
                b unused = O0OoOo.this.O0000o00 = new b("se", 4004, false);
                ((ExchangeManager) O0OoOo.this.getParentFragment()).O000000o(O0OoOo.this.O00000o0(), Boolean.TRUE);
            }
        }
    }

    public class O00000o extends O0OOO0O.O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ O0OOO0O f6687O000000o;

        public O00000o(O0OOO0O o0ooo0o) {
            this.f6687O000000o = o0ooo0o;
        }

        public final boolean O000000o() {
            this.f6687O000000o.dismissAllowingStateLoss();
            return true;
        }

        public final void O00000Oo() {
            if (O0OoOo.this.O0000o0 != null) {
                O0OoOo.this.O0000o0.performClick();
                return;
            }
            ((ExchangeManager) O0OoOo.this.getParentFragment()).O000000o(O0OoOo.this.O00000o0(), Boolean.TRUE);
            b unused = O0OoOo.this.O0000o00 = new b("se", 4001, false, true);
        }
    }

    public class O00000o0 extends O0OOO0O.O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ O0OOO0O f6688O000000o;

        public O00000o0(O0OOO0O o0ooo0o) {
            this.f6688O000000o = o0ooo0o;
        }

        public final boolean O000000o() {
            this.f6688O000000o.dismissAllowingStateLoss();
            if (O0OoOo.this.getContext() == null) {
                return false;
            }
            NotificationManager notificationManager = (NotificationManager) O0OoOo.this.getContext().getSystemService("notification");
            if (Build.VERSION.SDK_INT < 23 || notificationManager == null || notificationManager.isNotificationPolicyAccessGranted()) {
                return true;
            }
            O0OoOo.this.startActivityForResult(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"), 103);
            return true;
        }

        public final void O00000Oo() {
            if (O0OoOo.this.O0000o0 != null) {
                O0OoOo.this.O0000o0.performClick();
                return;
            }
            ((ExchangeManager) O0OoOo.this.getParentFragment()).O000000o(O0OoOo.this.O00000o0(), Boolean.TRUE);
            b unused = O0OoOo.this.O0000o00 = new b("se", 4001, false, true);
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O0000Oo0 = view.findViewById(R.id.layout_vibration);
        this.O0000OOo = (TextView) view.findViewById(R.id.btn_play_sound);
        TextView textView = this.O0000OOo;
        int i = 0;
        if (textView != null) {
            textView.setVisibility(0);
            this.O0000OOo.setOnClickListener(this);
            this.O0000OOo.setEnabled(false);
            this.O0000OOo.setText((int) R.string.otex_play);
        }
        O00000Oo(view, R.id.button_speaker_count_1);
        O00000Oo(view, R.id.button_speaker_count_2);
        O00000Oo(view, R.id.button_speaker_count_3);
        O00000Oo(view, R.id.button_speaker_count_4);
        O00000Oo(view, R.id.button_speaker_count_5);
        O00000Oo(view, R.id.button_speaker_count_6);
        O00000Oo(view, R.id.button_speaker_count_7);
        O00000Oo(view, R.id.button_speaker_count_8);
        this.O0000Oo = (TextView) view.findViewById(R.id.diagnoseTitle);
        TextView textView2 = this.O0000Oo;
        if (textView2 != null) {
            textView2.setText(this.O00000o.O0000Oo);
        }
        this.O0000OoO = (TextView) view.findViewById(R.id.diagnoseMessage);
        TextView textView3 = this.O0000OoO;
        if (textView3 != null) {
            textView3.setText(this.O00000o.O0000OoO);
        }
        this.O0000Ooo = (TextView) view.findViewById(R.id.diagnoseHelp);
        TextView textView4 = this.O0000Ooo;
        if (textView4 != null) {
            textView4.setText(this.O00000o.O0000Ooo);
        }
        this.O0000o0 = (Button) view.findViewById(R.id.nextButton);
        Button button = this.O0000o0;
        if (button != null) {
            if (!this.O00000o.O00000Oo()) {
                i = 8;
            }
            button.setVisibility(i);
            this.O0000o0.setText(this.O00000o.O0000o0);
            this.O0000o0.setOnClickListener(this);
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        new Thread(new O000000o()).start();
    }

    public final void onResume() {
        super.onResume();
        TextView textView = this.O0000OOo;
        if (textView != null) {
            textView.setEnabled(true);
        }
        Button button = this.O0000o0;
        if (button != null) {
            button.setEnabled(true);
        }
        O0000Oo();
        O0000O0o();
        ((ExchangeManager) getParentFragment()).O000000o(O00000Oo(), this, this.O00000o.O0000o);
    }

    public final void onPause() {
        TextToSpeech textToSpeech = this.O00000oO;
        if (textToSpeech != null) {
            textToSpeech.stop();
            TextView textView = this.O0000OOo;
            if (textView != null) {
                textView.setEnabled(true);
            }
        }
        ((ExchangeManager) getParentFragment()).O000000o();
        super.onPause();
    }

    public final void onClick(View view) {
        TextView textView;
        int id = view.getId();
        if (id == R.id.nextButton) {
            TextToSpeech textToSpeech = this.O00000oO;
            if (textToSpeech != null) {
                textToSpeech.stop();
            }
            TextView textView2 = this.O0000OOo;
            if (textView2 != null) {
                textView2.setEnabled(false);
            }
            Button button = this.O0000o0;
            if (button != null) {
                button.setEnabled(false);
            }
            this.O0000o00 = new b("se", 4001, false, true);
            ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
        } else if (id == R.id.btn_play_sound) {
            O0000Oo();
            O0000O0o();
            O00000oo();
        } else if (!this.O0000O0o) {
            if ((id == R.id.button_speaker_count_1 || id == R.id.button_speaker_count_2 || id == R.id.button_speaker_count_3 || id == R.id.button_speaker_count_4 || id == R.id.button_speaker_count_5 || id == R.id.button_speaker_count_6 || id == R.id.button_speaker_count_7 || id == R.id.button_speaker_count_8) && (textView = (TextView) view) != null && !this.O00000o0.isEmpty()) {
                textView.setBackgroundResource(R.drawable.orange_boundary);
                textView.setTextColor(getResources().getColor(R.color.otexColorOrangeLight));
                textView.setEnabled(false);
                if (textView.getText().toString().equalsIgnoreCase(String.valueOf(this.O00000o0.get(0)))) {
                    this.O00000o0.remove(0);
                } else {
                    TextToSpeech textToSpeech2 = this.O00000oO;
                    if (textToSpeech2 != null) {
                        textToSpeech2.stop();
                    }
                    this.O0000o00 = new b("se", 0, false);
                    ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.TRUE);
                    this.O0000O0o = true;
                }
                if (this.O00000o0.isEmpty()) {
                    this.O0000o00 = new b("se", Integer.valueOf(this.O00000o.O0000oO), true);
                    ((ExchangeManager) getParentFragment()).O000000o(O00000o0(), Boolean.FALSE);
                }
            }
        }
    }

    private void O0000OOo() {
        int i;
        if (this.O00000oo == 0) {
            ((ExchangeManager) getParentFragment()).O000000o();
            View view = this.O0000Oo0;
            if (view != null && view.getVisibility() == 8) {
                this.O0000Oo0.setVisibility(0);
            }
            TextView textView = this.O0000Oo;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.O0000OoO;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = this.O0000Ooo;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            this.O0000O0o = false;
            int i2 = this.O00000o.O00000Oo;
            ArrayList arrayList = new ArrayList();
            for (int i3 = 1; i3 < 9; i3++) {
                arrayList.add(Integer.valueOf(i3));
            }
            Collections.shuffle(arrayList);
            this.O00000o0.clear();
            for (int i4 = 0; i4 < i2; i4++) {
                this.O00000o0.add(arrayList.get(i4));
            }
            int i5 = 0;
            while (true) {
                i = i2 - 1;
                if (i5 >= i) {
                    break;
                }
                O000000o(String.valueOf(arrayList.get(i5)), (String) null);
                long j = (long) (this.O00000o.f2617O000000o * 1000);
                TextToSpeech textToSpeech = this.O00000oO;
                if (textToSpeech != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        textToSpeech.playSilentUtterance(j, 1, null);
                    } else {
                        HashMap hashMap = new HashMap();
                        hashMap.put("utteranceId", null);
                        this.O00000oO.playSilence(j, 1, hashMap);
                    }
                }
                i5++;
            }
            O000000o(String.valueOf(arrayList.get(i)), "last_utterance_id");
            TextView textView4 = this.O0000OOo;
            if (textView4 != null) {
                textView4.setText((int) R.string.otex_re_play);
                this.O0000OOo.setEnabled(false);
            }
        }
    }

    private void O0000OoO() {
        if (isAdded()) {
            O0OOO0O O000000o2 = O0OOO0O.O000000o(getString(R.string.speaker_alert_title), this.O00000o.O0000oOo, this.O00000o.O0000o00, this.O00000o.O0000o0);
            O000000o2.f6672O000000o = new O00000o0(O000000o2);
            ee fragmentManager = getFragmentManager();
            if (fragmentManager != null) {
                ei O000000o3 = fragmentManager.O000000o();
                O000000o3.O000000o(O000000o2, O000000o2.getClass().getSimpleName());
                O000000o3.O00000o0();
            }
        }
    }

    private void O0000Ooo() {
        if (isAdded()) {
            O0OOO0O O000000o2 = O0OOO0O.O000000o(getString(R.string.speaker_alert_title), this.O00000o.O0000oOO, this.O00000o.O0000o00, this.O00000o.O0000o0);
            O000000o2.f6672O000000o = new O00000o(O000000o2);
            ei O000000o3 = getChildFragmentManager().O000000o();
            O000000o3.O000000o(O000000o2, O000000o2.getClass().getSimpleName());
            O000000o3.O00000o0();
        }
    }
}
