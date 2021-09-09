package _m_j;

import _m_j.hen;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.widget.BaseSeekBar;
import com.xiaomi.smarthome.newui.widget.RoundedHorizontalSeekBar;
import com.xiaomi.smarthome.newui.widget.ShiftChooser;

public final class hen {

    public interface O000000o {
        void O000000o(int i);

        void O00000Oo(int i);
    }

    public interface O00000Oo {
        void O000000o(O000000o o000000o);

        void O000000o(Bitmap bitmap);

        void O000000o(String str);

        void O000000o(boolean z);

        void O00000Oo(int i);

        void O00000o(int i);

        void O00000o0(int i);
    }

    public static class O00000o implements O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final ShiftChooser f18844O000000o;

        public final void O000000o(Bitmap bitmap) {
        }

        public O00000o(ShiftChooser shiftChooser) {
            this.f18844O000000o = shiftChooser;
            this.f18844O000000o.setHapticFeedbackEnabled(true);
        }

        public final void O000000o(final O000000o o000000o) {
            this.f18844O000000o.setOnShiftChangedListener(new ShiftChooser.O000000o() {
                /* class _m_j.hen.O00000o.AnonymousClass1 */

                public final void O000000o(int i) {
                    o000000o.O000000o(i);
                }

                public final void O00000Oo(int i) {
                    o000000o.O00000Oo(i);
                }
            });
        }

        public final void O00000Oo(int i) {
            this.f18844O000000o.setTotalShifts(i);
        }

        public final void O000000o(String str) {
            this.f18844O000000o.setText(str);
        }

        public final void O00000o0(int i) {
            this.f18844O000000o.scrollToShift(i, false);
        }

        public final void O00000o(int i) {
            this.f18844O000000o.setThumbColor(i);
        }

        public final void O000000o(boolean z) {
            this.f18844O000000o.setCanChoose(z);
            this.f18844O000000o.setClickable(z);
            this.f18844O000000o.setFocusable(z);
            this.f18844O000000o.updateEnableUI(z);
        }
    }

    public static class O00000o0 implements O00000Oo, BaseSeekBar.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private final RoundedHorizontalSeekBar f18846O000000o;
        private final ImageView O00000Oo;
        private O000000o O00000o;
        private final ImageView O00000o0;

        public O00000o0(RoundedHorizontalSeekBar roundedHorizontalSeekBar) {
            this(roundedHorizontalSeekBar, null, null);
        }

        public <T extends View> O00000o0(RoundedHorizontalSeekBar roundedHorizontalSeekBar, ImageView imageView, ImageView imageView2) {
            this.f18846O000000o = roundedHorizontalSeekBar;
            this.O00000Oo = imageView;
            this.O00000o0 = imageView2;
            roundedHorizontalSeekBar.setOnSeekBarChangeListener(this);
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener(roundedHorizontalSeekBar) {
                    /* class _m_j.$$Lambda$hen$O00000o0$ERUMl3g9xeutu35NWPXpwRYvHgo */
                    private final /* synthetic */ RoundedHorizontalSeekBar f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        hen.O00000o0.this.O00000Oo(this.f$1, view);
                    }
                });
            }
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener(roundedHorizontalSeekBar) {
                    /* class _m_j.$$Lambda$hen$O00000o0$xR1IhEPcVm2mzeIZKMObuelinGU */
                    private final /* synthetic */ RoundedHorizontalSeekBar f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        hen.O00000o0.this.O000000o(this.f$1, view);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O00000Oo(RoundedHorizontalSeekBar roundedHorizontalSeekBar, View view) {
            hzf.O00000oO(view);
            int min = Math.min(roundedHorizontalSeekBar.getMax(), roundedHorizontalSeekBar.getProgress() + 1);
            roundedHorizontalSeekBar.setProgress(min);
            O00000oO(min);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(RoundedHorizontalSeekBar roundedHorizontalSeekBar, View view) {
            hzf.O00000oO(view);
            int max = Math.max(0, roundedHorizontalSeekBar.getProgress() - 1);
            roundedHorizontalSeekBar.setProgress(max);
            O00000oO(max);
        }

        private void O00000oO(int i) {
            O000000o(i);
            O000000o(this.f18846O000000o);
        }

        public final void O000000o(O000000o o000000o) {
            this.O00000o = o000000o;
        }

        public final void O00000o0(int i) {
            this.f18846O000000o.setProgress(i);
        }

        public final void O00000Oo(int i) {
            if (i > 0) {
                this.f18846O000000o.setMax(i - 1);
            }
        }

        public final void O000000o(String str) {
            this.f18846O000000o.setTextInfo(str);
        }

        public final void O00000o(int i) {
            this.f18846O000000o.setForegroundColor(i);
        }

        public final void O000000o(Bitmap bitmap) {
            this.f18846O000000o.setImageIcon(bitmap);
            this.f18846O000000o.setContentPaddingLeft(0.0f);
        }

        public final void O000000o(boolean z) {
            this.f18846O000000o.O000000o(z);
            this.f18846O000000o.setCanSeek(z);
            this.f18846O000000o.setClickable(z);
            this.f18846O000000o.setFocusable(z);
            ImageView imageView = this.O00000o0;
            if (imageView != null) {
                imageView.setEnabled(z);
                if (z) {
                    ImageView imageView2 = this.O00000o0;
                    imageView2.setImageDrawable(new hyn(imageView2.getContext(), R.raw.mj_a_grey_control));
                } else {
                    ImageView imageView3 = this.O00000o0;
                    imageView3.setImageDrawable(new hyn(imageView3.getContext(), R.raw.mj_a_grey_control).O000000o(hyj.O00000Oo));
                }
            }
            ImageView imageView4 = this.O00000Oo;
            if (imageView4 != null) {
                imageView4.setEnabled(z);
                if (z) {
                    this.O00000Oo.setImageDrawable(new hyn(this.O00000o0.getContext(), R.raw.mj_d_grey_control));
                } else {
                    this.O00000Oo.setImageDrawable(new hyn(this.O00000o0.getContext(), R.raw.mj_d_grey_control).O000000o(hyj.O00000Oo));
                }
            }
        }

        public final void O000000o(int i) {
            O000000o o000000o = this.O00000o;
            if (o000000o != null) {
                o000000o.O000000o(i);
            }
        }

        public final void O000000o(BaseSeekBar baseSeekBar) {
            O000000o o000000o = this.O00000o;
            if (o000000o != null) {
                o000000o.O00000Oo(baseSeekBar.getProgress());
            }
        }
    }
}
