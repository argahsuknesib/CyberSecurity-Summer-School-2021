package _m_j;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

final class iza extends ContextWrapper {

    /* renamed from: O000000o  reason: collision with root package name */
    public Toast f1656O000000o;

    iza(Context context, Toast toast) {
        super(context);
        this.f1656O000000o = toast;
    }

    public final Context getApplicationContext() {
        return new O000000o(this, getBaseContext().getApplicationContext(), (byte) 0);
    }

    final class O000000o extends ContextWrapper {
        /* synthetic */ O000000o(iza iza, Context context, byte b) {
            this(context);
        }

        private O000000o(Context context) {
            super(context);
        }

        public final Object getSystemService(String str) {
            if ("window".equals(str)) {
                return new O00000Oo(iza.this, (WindowManager) getBaseContext().getSystemService(str), (byte) 0);
            }
            return super.getSystemService(str);
        }
    }

    final class O00000Oo implements WindowManager {
        private final WindowManager O00000Oo;

        /* synthetic */ O00000Oo(iza iza, WindowManager windowManager, byte b) {
            this(windowManager);
        }

        private O00000Oo(WindowManager windowManager) {
            this.O00000Oo = windowManager;
        }

        public final Display getDefaultDisplay() {
            return this.O00000Oo.getDefaultDisplay();
        }

        public final void removeViewImmediate(View view) {
            this.O00000Oo.removeViewImmediate(view);
        }

        public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
            try {
                Log.d("WindowManagerWrapper", "WindowManager's addView(view, params) has been hooked.");
                this.O00000Oo.addView(view, layoutParams);
            } catch (WindowManager.BadTokenException e) {
                Log.i("WindowManagerWrapper", e.getMessage());
            } catch (Throwable th) {
                Log.e("WindowManagerWrapper", "[addView]", th);
            }
        }

        public final void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
            this.O00000Oo.updateViewLayout(view, layoutParams);
        }

        public final void removeView(View view) {
            this.O00000Oo.removeView(view);
        }
    }
}
