package _m_j;

import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.xiaomi.smarthome.R;
import in.cashify.otex.widget.CircleRoadProgress;
import in.cashify.otex.widget.DiagnoseCameraHeaderView;
import in.cashify.otex.widget.DiagnoseHeaderView;
import in.cashify.otex.widget.DiagnoseMicHeaderView;
import java.util.ArrayList;
import java.util.List;

public final class O0OOOOO extends jz {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<O000000o> f6675O000000o = new ArrayList();
    public View O00000Oo;
    public SparseArray<DiagnoseHeaderView> O00000o0 = new SparseArray<>();

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f6676O000000o;
        public int O00000Oo;
        public CircleRoadProgress.O00000Oo O00000o;
        public long O00000o0;
        public int O00000oO;
        public int O00000oo;
        public int O0000O0o;
        public String O0000OOo;
        public String O0000Oo0;

        public O000000o(int i, int i2, int i3, String str) {
            this.f6676O000000o = i;
            this.O00000oO = i2;
            this.O00000oo = i3;
            this.O0000OOo = str;
        }
    }

    public final O000000o O000000o(int i) {
        if (i < 0 || i >= this.f6675O000000o.size()) {
            return null;
        }
        return this.f6675O000000o.get(i);
    }

    public final void O000000o(List<O000000o> list) {
        this.f6675O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final int getCount() {
        return this.f6675O000000o.size();
    }

    public final int getItemPosition(Object obj) {
        int indexOf = obj instanceof O000000o ? this.f6675O000000o.indexOf(obj) : -1;
        if (indexOf < 0) {
            return -2;
        }
        return indexOf;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0193, code lost:
        if (r7 != null) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        if (r3.f6676O000000o == 3) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
        if (r3.f6676O000000o == 3) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008a, code lost:
        if (r3.f6676O000000o != 3) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e0, code lost:
        if (r3.f6676O000000o == 3) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00eb, code lost:
        if (r3.f6676O000000o == 3) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00f6, code lost:
        if (r3.f6676O000000o != 3) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0176, code lost:
        if (r7 != null) goto L_0x0195;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0152 A[ADDED_TO_REGION] */
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        DiagnoseHeaderView diagnoseHeaderView;
        char c;
        char c2;
        char c3;
        DiagnoseHeaderView diagnoseHeaderView2;
        int i2 = i;
        if (i2 < 0 && i2 >= this.f6675O000000o.size()) {
            return null;
        }
        O000000o o000000o = this.f6675O000000o.get(i2);
        String str = o000000o.O0000Oo0;
        if (this.O00000o0.indexOfKey(i2) < 0) {
            int hashCode = str.hashCode();
            if (hashCode != -1596016259) {
                if (hashCode != 108103) {
                    if (hashCode == 1641107963 && str.equals("front_camera")) {
                        c3 = 0;
                        if (c3 != 0) {
                            diagnoseHeaderView2 = new DiagnoseCameraHeaderView(viewGroup.getContext(), (byte) 0);
                        } else if (c3 != 1) {
                            if (c3 == 2) {
                                diagnoseHeaderView2 = new DiagnoseMicHeaderView(viewGroup.getContext(), (byte) 0);
                            } else {
                                diagnoseHeaderView2 = null;
                            }
                            if (diagnoseHeaderView2 == null) {
                                diagnoseHeaderView2 = new DiagnoseHeaderView(viewGroup.getContext(), R.layout.layout_diagnose_header);
                            }
                            this.O00000o0.put(i2, diagnoseHeaderView2);
                            diagnoseHeaderView = diagnoseHeaderView2;
                        } else {
                            diagnoseHeaderView2 = new DiagnoseCameraHeaderView(viewGroup.getContext(), (byte) 0);
                        }
                        this.O00000Oo = diagnoseHeaderView2;
                        if (diagnoseHeaderView2 == null) {
                        }
                        this.O00000o0.put(i2, diagnoseHeaderView2);
                        diagnoseHeaderView = diagnoseHeaderView2;
                    }
                } else if (str.equals("mic")) {
                    c3 = 2;
                    if (c3 != 0) {
                    }
                    this.O00000Oo = diagnoseHeaderView2;
                    if (diagnoseHeaderView2 == null) {
                    }
                    this.O00000o0.put(i2, diagnoseHeaderView2);
                    diagnoseHeaderView = diagnoseHeaderView2;
                }
            } else if (str.equals("back_camera")) {
                c3 = 1;
                if (c3 != 0) {
                }
                this.O00000Oo = diagnoseHeaderView2;
                if (diagnoseHeaderView2 == null) {
                }
                this.O00000o0.put(i2, diagnoseHeaderView2);
                diagnoseHeaderView = diagnoseHeaderView2;
            }
            c3 = 65535;
            if (c3 != 0) {
            }
            this.O00000Oo = diagnoseHeaderView2;
            if (diagnoseHeaderView2 == null) {
            }
            this.O00000o0.put(i2, diagnoseHeaderView2);
            diagnoseHeaderView = diagnoseHeaderView2;
        } else {
            View valueAt = this.O00000o0.valueAt(i2);
            if (valueAt != null) {
                int hashCode2 = str.hashCode();
                if (hashCode2 != -1596016259) {
                    if (hashCode2 != 108103) {
                        if (hashCode2 == 1641107963 && str.equals("front_camera")) {
                            c2 = 0;
                            if (c2 == 0) {
                                if (c2 != 1) {
                                    if (c2 != 2) {
                                        diagnoseHeaderView = (DiagnoseHeaderView) valueAt;
                                    } else if (valueAt instanceof DiagnoseMicHeaderView) {
                                        diagnoseHeaderView = (DiagnoseMicHeaderView) valueAt;
                                    }
                                } else if (valueAt instanceof DiagnoseCameraHeaderView) {
                                    diagnoseHeaderView = (DiagnoseCameraHeaderView) valueAt;
                                }
                            } else if (valueAt instanceof DiagnoseCameraHeaderView) {
                                diagnoseHeaderView = (DiagnoseCameraHeaderView) valueAt;
                            }
                            this.O00000Oo = diagnoseHeaderView;
                        }
                    } else if (str.equals("mic")) {
                        c2 = 2;
                        if (c2 == 0) {
                        }
                        this.O00000Oo = diagnoseHeaderView;
                    }
                } else if (str.equals("back_camera")) {
                    c2 = 1;
                    if (c2 == 0) {
                    }
                    this.O00000Oo = diagnoseHeaderView;
                }
                c2 = 65535;
                if (c2 == 0) {
                }
                this.O00000Oo = diagnoseHeaderView;
            }
            diagnoseHeaderView = null;
        }
        if (diagnoseHeaderView == null) {
            diagnoseHeaderView = new DiagnoseHeaderView(viewGroup.getContext(), R.layout.layout_diagnose_header);
        }
        ImageView imageView = (ImageView) diagnoseHeaderView.findViewById(R.id.image_diagnose_icon);
        ((TextView) diagnoseHeaderView.findViewById(R.id.tv_test_name)).setText(o000000o.O0000OOo);
        CircleRoadProgress circleRoadProgress = (CircleRoadProgress) diagnoseHeaderView.findViewById(R.id.circleProgress);
        int hashCode3 = str.hashCode();
        if (hashCode3 != -1596016259) {
            if (hashCode3 != 108103) {
                if (hashCode3 == 1641107963 && str.equals("front_camera")) {
                    c = 0;
                    if (c != 0 || c == 1) {
                        View findViewById = diagnoseHeaderView.findViewById(R.id.cameraPreview);
                        ImageView imageView2 = (ImageView) diagnoseHeaderView.findViewById(R.id.image_shape);
                        if (o000000o.f6676O000000o == 3) {
                            if (imageView != null) {
                                imageView.setVisibility(0);
                            }
                            if (findViewById != null) {
                                findViewById.setVisibility(8);
                            }
                            if (imageView2 != null) {
                                imageView2.setVisibility(8);
                            }
                        } else if (o000000o.O00000Oo == 2) {
                            if (imageView != null) {
                                imageView.setVisibility(0);
                            }
                            if (imageView2 != null) {
                                imageView2.setVisibility(8);
                            }
                            if (findViewById != null) {
                                findViewById.setVisibility(8);
                            }
                        } else {
                            if (imageView != null) {
                                imageView.setVisibility(8);
                            }
                            if (imageView2 != null) {
                                imageView2.setVisibility(0);
                            }
                            if (findViewById != null) {
                                findViewById.setVisibility(0);
                            }
                        }
                    } else if (c == 2) {
                        View findViewById2 = diagnoseHeaderView.findViewById(R.id.visualizer_view);
                        ImageView imageView3 = (ImageView) diagnoseHeaderView.findViewById(R.id.image_shape);
                        if (o000000o.f6676O000000o != 3) {
                            if (imageView != null) {
                                imageView.setVisibility(0);
                            }
                            if (findViewById2 != null) {
                                findViewById2.setVisibility(8);
                            }
                        } else if (o000000o.O00000Oo == 2) {
                            if (imageView != null) {
                                imageView.setVisibility(0);
                            }
                            if (findViewById2 != null) {
                                findViewById2.setVisibility(8);
                            }
                        } else {
                            if (imageView != null) {
                                imageView.setVisibility(8);
                            }
                            if (findViewById2 != null) {
                                findViewById2.setVisibility(0);
                            }
                            if (imageView3 != null) {
                                imageView3.setVisibility(0);
                            }
                        }
                        imageView3.setVisibility(8);
                    }
                    if (o000000o.f6676O000000o != 2) {
                        circleRoadProgress.setRoadColor(ContextCompat.O00000o0(viewGroup.getContext(), R.color.arc_fail_color));
                        if (imageView != null) {
                            imageView.setColorFilter(ContextCompat.O00000o0(viewGroup.getContext(), R.color.arc_fail_color));
                            imageView.setImageResource(o000000o.O00000oo);
                        }
                    } else if (o000000o.f6676O000000o == 1) {
                        circleRoadProgress.setRoadColor(ContextCompat.O00000o0(viewGroup.getContext(), R.color.arc_pass_color));
                        if (imageView != null) {
                            imageView.setColorFilter(ContextCompat.O00000o0(viewGroup.getContext(), R.color.arc_pass_color));
                            imageView.setImageResource(o000000o.O00000oo);
                        }
                    } else if (o000000o.f6676O000000o == 3) {
                        if (imageView != null) {
                            imageView.setImageResource(o000000o.O00000oO);
                        }
                        int i3 = o000000o.O00000Oo;
                        if (i3 == 1) {
                            long j = o000000o.O00000o0;
                            CircleRoadProgress.O00000Oo o00000Oo = o000000o.O00000o;
                            ValueAnimator valueAnimator = circleRoadProgress.O0000oOo;
                            if (valueAnimator != null && valueAnimator.isRunning()) {
                                circleRoadProgress.O000000o();
                            }
                            circleRoadProgress.O000000o(0.0f);
                            circleRoadProgress.O0000oo0 = o00000Oo;
                            if (j > 0) {
                                circleRoadProgress.O0000oOo = circleRoadProgress.O000000o(j);
                                circleRoadProgress.O0000oOo.start();
                            }
                            o000000o.O00000Oo = 3;
                        } else if (i3 == 2) {
                            if (o000000o.O0000O0o != 0) {
                                circleRoadProgress.setArcLoadingColor(o000000o.O0000O0o);
                            }
                            long j2 = o000000o.O00000o0;
                            circleRoadProgress.O0000oo0 = o000000o.O00000o;
                            ValueAnimator valueAnimator2 = circleRoadProgress.O0000oOo;
                            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                                circleRoadProgress.O000000o();
                            }
                            circleRoadProgress.O0000oOo = circleRoadProgress.O000000o(j2);
                            circleRoadProgress.O0000oOo.start();
                            o000000o.O0000O0o = 0;
                        } else if (i3 != 3 && i3 == 4) {
                            circleRoadProgress.O000000o();
                        }
                    } else if (imageView != null) {
                        imageView.setImageResource(o000000o.O00000oo);
                    }
                    viewGroup.addView(diagnoseHeaderView);
                    return diagnoseHeaderView;
                }
            } else if (str.equals("mic")) {
                c = 2;
                if (c != 0) {
                }
                View findViewById3 = diagnoseHeaderView.findViewById(R.id.cameraPreview);
                ImageView imageView22 = (ImageView) diagnoseHeaderView.findViewById(R.id.image_shape);
                if (o000000o.f6676O000000o == 3) {
                }
                if (o000000o.f6676O000000o != 2) {
                }
                viewGroup.addView(diagnoseHeaderView);
                return diagnoseHeaderView;
            }
        } else if (str.equals("back_camera")) {
            c = 1;
            if (c != 0) {
            }
            View findViewById32 = diagnoseHeaderView.findViewById(R.id.cameraPreview);
            ImageView imageView222 = (ImageView) diagnoseHeaderView.findViewById(R.id.image_shape);
            if (o000000o.f6676O000000o == 3) {
            }
            if (o000000o.f6676O000000o != 2) {
            }
            viewGroup.addView(diagnoseHeaderView);
            return diagnoseHeaderView;
        }
        c = 65535;
        if (c != 0) {
        }
        View findViewById322 = diagnoseHeaderView.findViewById(R.id.cameraPreview);
        ImageView imageView2222 = (ImageView) diagnoseHeaderView.findViewById(R.id.image_shape);
        if (o000000o.f6676O000000o == 3) {
        }
        if (o000000o.f6676O000000o != 2) {
        }
        viewGroup.addView(diagnoseHeaderView);
        return diagnoseHeaderView;
    }
}
