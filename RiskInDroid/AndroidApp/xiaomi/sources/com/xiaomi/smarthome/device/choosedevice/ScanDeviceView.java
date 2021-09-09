package com.xiaomi.smarthome.device.choosedevice;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.smartconfig.PushBindEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ScanDeviceView extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<View> f7262O000000o;
    public List<Object> O00000Oo;
    public Queue<Object> O00000o;
    public List<ChooseConnectDeviceAdapter.ScanDeviceType> O00000o0;
    public ConcurrentMap<Object, ChooseConnectDeviceAdapter.ScanDeviceType> O00000oO;
    public O000000o O00000oo;
    private Handler O0000O0o;
    private Map<String, PushBindEntity> O0000OOo;
    private List<ScanResult> O0000Oo;
    private Map<String, PushBindEntity> O0000Oo0;
    private List<ScanResult> O0000OoO;
    private List<BleDevice> O0000Ooo;
    private Map<String, BleDevice> O0000o;
    private Map<String, Integer> O0000o0;
    private List<MiTVDevice> O0000o00;
    private Map<String, ScanResult> O0000o0O;
    private Map<String, ScanResult> O0000o0o;
    private List<MiTVDevice> O0000oO0;

    public interface O000000o {
        void O000000o(int i);
    }

    private static boolean O000000o(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c < 'A' || c > 'Z') {
            return c >= '0' && c <= '9';
        }
        return true;
    }

    public ScanDeviceView(Context context) {
        this(context, null);
    }

    public ScanDeviceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanDeviceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7262O000000o = new ArrayList(7);
        this.O00000Oo = new ArrayList(7);
        this.O00000o0 = new ArrayList(7);
        this.O00000o = new LinkedList();
        this.O00000oO = new ConcurrentHashMap();
        this.O0000O0o = new Handler(Looper.getMainLooper()) {
            /* class com.xiaomi.smarthome.device.choosedevice.ScanDeviceView.AnonymousClass1 */

            public final void handleMessage(Message message) {
                int i = message.what;
                if (i != 100) {
                    if (i == 200) {
                        ScanDeviceView.this.O000000o();
                    }
                } else if (!ScanDeviceView.this.O00000o.isEmpty()) {
                    Object poll = ScanDeviceView.this.O00000o.poll();
                    if (poll == null || ScanDeviceView.this.O00000oO.get(poll) == null) {
                        sendEmptyMessage(100);
                        return;
                    }
                    int addPosition = ScanDeviceView.this.getAddPosition();
                    if (addPosition < ScanDeviceView.this.f7262O000000o.size()) {
                        ScanDeviceView.this.O00000Oo.set(addPosition, poll);
                        ScanDeviceView.this.O00000o0.set(addPosition, ScanDeviceView.this.O00000oO.get(poll));
                        ScanDeviceView scanDeviceView = ScanDeviceView.this;
                        int i2 = AnonymousClass4.f7268O000000o[scanDeviceView.O00000oO.get(poll).ordinal()];
                        if (i2 == 1 || i2 == 2) {
                            ScanResult scanResult = (ScanResult) poll;
                            DeviceFactory.O00000Oo(DeviceFactory.O00000Oo(scanResult), (SimpleDraweeView) scanDeviceView.f7262O000000o.get(addPosition).findViewById(R.id.device_image));
                            ((TextView) scanDeviceView.f7262O000000o.get(addPosition).findViewById(R.id.device_name)).setText(scanDeviceView.O000000o(DeviceFactory.O0000OoO(scanResult)));
                            ((TextView) scanDeviceView.f7262O000000o.get(addPosition).findViewById(R.id.device_num)).setVisibility(8);
                        } else if (i2 == 3) {
                            BleDevice bleDevice = (BleDevice) poll;
                            DeviceFactory.O00000Oo(bleDevice.model, (SimpleDraweeView) scanDeviceView.f7262O000000o.get(addPosition).findViewById(R.id.device_image));
                            ((TextView) scanDeviceView.f7262O000000o.get(addPosition).findViewById(R.id.device_name)).setText(scanDeviceView.O000000o(bleDevice.O0000OOo()));
                            if (bleDevice.O0000Oo0() > 1) {
                                ((TextView) scanDeviceView.f7262O000000o.get(addPosition).findViewById(R.id.device_num)).setVisibility(0);
                                ((TextView) scanDeviceView.f7262O000000o.get(addPosition).findViewById(R.id.device_num)).setText(String.valueOf(bleDevice.O0000Oo0()));
                            } else {
                                ((TextView) scanDeviceView.f7262O000000o.get(addPosition).findViewById(R.id.device_num)).setVisibility(8);
                            }
                        } else if (i2 == 4) {
                            MiTVDevice miTVDevice = (MiTVDevice) poll;
                            DeviceFactory.O00000Oo(miTVDevice.model, (SimpleDraweeView) scanDeviceView.f7262O000000o.get(addPosition).findViewById(R.id.device_image));
                            ((TextView) scanDeviceView.f7262O000000o.get(addPosition).findViewById(R.id.device_name)).setText(scanDeviceView.O000000o(miTVDevice.name));
                            ((TextView) scanDeviceView.f7262O000000o.get(addPosition).findViewById(R.id.device_num)).setVisibility(8);
                        } else if (i2 == 5) {
                            PushBindEntity pushBindEntity = (PushBindEntity) poll;
                            DeviceFactory.O00000Oo(pushBindEntity.f11457O000000o.O00000Oo(), (SimpleDraweeView) scanDeviceView.f7262O000000o.get(addPosition).findViewById(R.id.device_image));
                            ((TextView) scanDeviceView.f7262O000000o.get(addPosition).findViewById(R.id.device_name)).setText(scanDeviceView.O000000o(pushBindEntity.f11457O000000o.O0000Oo0()));
                            ((TextView) scanDeviceView.f7262O000000o.get(addPosition).findViewById(R.id.device_num)).setVisibility(8);
                        }
                        ScanDeviceView scanDeviceView2 = ScanDeviceView.this;
                        View view = scanDeviceView2.f7262O000000o.get(addPosition);
                        view.setVisibility(0);
                        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", 0.65f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.65f, 1.0f));
                        ofPropertyValuesHolder.setInterpolator(new OvershootInterpolator());
                        ofPropertyValuesHolder.setDuration(500L).start();
                        ofPropertyValuesHolder.addListener(new Animator.AnimatorListener(view) {
                            /* class com.xiaomi.smarthome.device.choosedevice.ScanDeviceView.AnonymousClass3 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ View f7265O000000o;

                            public final void onAnimationCancel(Animator animator) {
                            }

                            public final void onAnimationRepeat(Animator animator) {
                            }

                            public final void onAnimationStart(Animator animator) {
                            }

                            {
                                this.f7265O000000o = r2;
                            }

                            public final void onAnimationEnd(Animator animator) {
                                ScanDeviceView.this.O00000Oo();
                                final ImageView imageView = (ImageView) this.f7265O000000o.findViewById(R.id.edge_anim_img);
                                if (imageView != null) {
                                    imageView.setVisibility(0);
                                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, PropertyValuesHolder.ofFloat("scaleX", 0.8f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.8f, 1.0f));
                                    ofPropertyValuesHolder.setDuration(600L);
                                    ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
                                    ofPropertyValuesHolder.start();
                                    ofPropertyValuesHolder.addListener(new Animator.AnimatorListener() {
                                        /* class com.xiaomi.smarthome.device.choosedevice.ScanDeviceView.AnonymousClass3.AnonymousClass1 */

                                        public final void onAnimationCancel(Animator animator) {
                                        }

                                        public final void onAnimationRepeat(Animator animator) {
                                        }

                                        public final void onAnimationStart(Animator animator) {
                                        }

                                        public final void onAnimationEnd(Animator animator) {
                                            imageView.setVisibility(4);
                                        }
                                    });
                                    final ImageView imageView2 = (ImageView) this.f7265O000000o.findViewById(R.id.edge_circle_img);
                                    if (imageView2 != null) {
                                        imageView2.setVisibility(0);
                                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView2, "rotation", 0.0f, 360.0f);
                                        ofFloat.setDuration(500L);
                                        ofFloat.setInterpolator(new LinearInterpolator());
                                        ofFloat.start();
                                        ofFloat.addListener(new Animator.AnimatorListener() {
                                            /* class com.xiaomi.smarthome.device.choosedevice.ScanDeviceView.AnonymousClass3.AnonymousClass2 */

                                            public final void onAnimationCancel(Animator animator) {
                                            }

                                            public final void onAnimationRepeat(Animator animator) {
                                            }

                                            public final void onAnimationStart(Animator animator) {
                                            }

                                            public final void onAnimationEnd(Animator animator) {
                                                imageView2.setVisibility(8);
                                            }
                                        });
                                    }
                                }
                            }
                        });
                        ScanDeviceView.this.O00000oO.remove(poll);
                    }
                    sendEmptyMessageDelayed(100, 500);
                } else if (ScanDeviceView.this.O00000oo != null) {
                    ScanDeviceView.this.O00000Oo();
                }
            }
        };
        this.O0000Oo0 = new HashMap();
        this.O0000o0 = new HashMap();
        this.O0000o0O = new HashMap();
        this.O0000o0o = new HashMap();
        this.O0000o = new HashMap();
        this.O0000oO0 = new ArrayList();
    }

    public void setListener(O000000o o000000o) {
        this.O00000oo = o000000o;
    }

    /* renamed from: com.xiaomi.smarthome.device.choosedevice.ScanDeviceView$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f7268O000000o = new int[ChooseConnectDeviceAdapter.ScanDeviceType.values().length];

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
            f7268O000000o[ChooseConnectDeviceAdapter.ScanDeviceType.AP.ordinal()] = 1;
            f7268O000000o[ChooseConnectDeviceAdapter.ScanDeviceType.AP_DIRECT.ordinal()] = 2;
            f7268O000000o[ChooseConnectDeviceAdapter.ScanDeviceType.BLE.ordinal()] = 3;
            f7268O000000o[ChooseConnectDeviceAdapter.ScanDeviceType.MI_TV.ordinal()] = 4;
            f7268O000000o[ChooseConnectDeviceAdapter.ScanDeviceType.AIOT.ordinal()] = 5;
        }
    }

    public final void O000000o() {
        Object obj;
        boolean z;
        this.O0000O0o.removeMessages(200);
        this.O00000o.clear();
        this.O00000oO.clear();
        this.O0000o0O.clear();
        for (ScanResult next : this.O0000Oo) {
            this.O0000o0O.put(next.BSSID, next);
        }
        this.O0000o0o.clear();
        for (ScanResult next2 : this.O0000OoO) {
            this.O0000o0o.put(next2.BSSID, next2);
        }
        this.O0000o.clear();
        for (BleDevice next3 : this.O0000Ooo) {
            this.O0000o.put(next3.model, next3);
        }
        this.O0000oO0.clear();
        this.O0000oO0.addAll(this.O0000o00);
        this.O0000Oo0.clear();
        this.O0000Oo0.putAll(this.O0000OOo);
        for (final int i = 0; i < this.O00000Oo.size(); i++) {
            if (!(this.f7262O000000o.get(i).getVisibility() == 8 || (obj = this.O00000Oo.get(i)) == null || ((((z = obj instanceof ScanResult)) && this.O0000o0O.get(((ScanResult) obj).BSSID) != null) || ((z && this.O0000o0o.get(((ScanResult) obj).BSSID) != null) || (((obj instanceof BleDevice) && this.O0000o.get(((BleDevice) obj).model) != null) || (((obj instanceof PushBindEntity) && this.O0000Oo0.get(((PushBindEntity) obj).O00000o) != null) || ((obj instanceof MiTVDevice) && this.O0000oO0.contains(obj)))))))) {
                this.O00000Oo.set(i, null);
                this.O00000o0.set(i, null);
                final View view = this.f7262O000000o.get(i);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.0f));
                ofPropertyValuesHolder.setInterpolator(new AccelerateInterpolator());
                ofPropertyValuesHolder.setDuration(300L).start();
                ofPropertyValuesHolder.addListener(new Animator.AnimatorListener() {
                    /* class com.xiaomi.smarthome.device.choosedevice.ScanDeviceView.AnonymousClass2 */

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }

                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        ScanDeviceView.this.O00000Oo();
                        if (ScanDeviceView.this.O00000Oo.get(i) == null) {
                            view.setVisibility(8);
                        }
                    }
                });
            }
        }
        this.O0000o0.clear();
        int i2 = 0;
        for (Object next4 : this.O00000Oo) {
            if (next4 != null) {
                if (next4 instanceof ScanResult) {
                    this.O0000o0.put(((ScanResult) next4).BSSID, Integer.valueOf(i2));
                } else if (next4 instanceof BleDevice) {
                    this.O0000o0.put(((BleDevice) next4).model, Integer.valueOf(i2));
                } else if (next4 instanceof PushBindEntity) {
                    this.O0000o0.put(((PushBindEntity) next4).O00000o, Integer.valueOf(i2));
                }
                i2++;
            }
        }
        for (Map.Entry<String, PushBindEntity> value : this.O0000Oo0.entrySet()) {
            PushBindEntity pushBindEntity = (PushBindEntity) value.getValue();
            if (this.O0000o0.get(pushBindEntity.O00000o) == null) {
                if (getAddPosition() == this.f7262O000000o.size()) {
                    break;
                } else if (this.O00000oO.get(pushBindEntity) == null) {
                    this.O00000o.add(pushBindEntity);
                    this.O00000oO.put(pushBindEntity, ChooseConnectDeviceAdapter.ScanDeviceType.AIOT);
                }
            }
        }
        for (ScanResult next5 : this.O0000o0O.values()) {
            if (this.O0000o0.get(next5.BSSID) == null) {
                if (getAddPosition() == this.f7262O000000o.size()) {
                    break;
                } else if (this.O00000oO.get(next5) == null) {
                    this.O00000o.add(next5);
                    this.O00000oO.put(next5, ChooseConnectDeviceAdapter.ScanDeviceType.AP);
                }
            }
        }
        for (ScanResult next6 : this.O0000o0o.values()) {
            if (this.O0000o0.get(next6.BSSID) == null) {
                if (getAddPosition() == this.f7262O000000o.size()) {
                    break;
                } else if (this.O00000oO.get(next6) == null) {
                    this.O00000o.add(next6);
                    this.O00000oO.put(next6, ChooseConnectDeviceAdapter.ScanDeviceType.AP_DIRECT);
                }
            }
        }
        for (BleDevice next7 : this.O0000o.values()) {
            if (this.O0000o0.get(next7.model) == null) {
                if (getAddPosition() == this.f7262O000000o.size()) {
                    break;
                } else if (this.O00000oO.get(next7) == null) {
                    this.O00000o.add(next7);
                    this.O00000oO.put(next7, ChooseConnectDeviceAdapter.ScanDeviceType.BLE);
                }
            } else {
                Integer num = this.O0000o0.get(next7.model);
                if (num == null) {
                    num = -1;
                }
                if (num.intValue() != -1) {
                    if (next7.O0000Oo0() > 1) {
                        ((TextView) this.f7262O000000o.get(num.intValue()).findViewById(R.id.device_num)).setVisibility(0);
                        ((TextView) this.f7262O000000o.get(num.intValue()).findViewById(R.id.device_num)).setText(String.valueOf(next7.O0000Oo0()));
                    } else {
                        ((TextView) this.f7262O000000o.get(num.intValue()).findViewById(R.id.device_num)).setVisibility(8);
                    }
                }
            }
        }
        for (MiTVDevice next8 : this.O0000oO0) {
            if (!this.O00000Oo.contains(next8)) {
                if (getAddPosition() == this.f7262O000000o.size()) {
                    break;
                } else if (this.O00000oO.get(next8) == null) {
                    this.O00000o.add(next8);
                    this.O00000oO.put(next8, ChooseConnectDeviceAdapter.ScanDeviceType.MI_TV);
                }
            }
        }
        if (!this.O0000O0o.hasMessages(100)) {
            this.O0000O0o.sendEmptyMessageDelayed(100, 800);
        }
        this.O0000O0o.sendEmptyMessageDelayed(200, 3000);
    }

    /* access modifiers changed from: package-private */
    public final String O000000o(String str) {
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        if (!O00oOooo.getLanguage().equalsIgnoreCase("zh") || str.length() <= 6 || getResources().getConfiguration().fontScale > 1.0f) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.substring(0, 6));
        StringBuilder sb2 = new StringBuilder(str.substring(6, str.length()));
        if (O000000o(sb.charAt(sb.length() - 1)) && O000000o(sb2.charAt(0))) {
            while (sb2.length() > 0 && O000000o(sb2.charAt(0))) {
                sb.append(sb2.charAt(0));
                sb2.deleteCharAt(0);
            }
        }
        return sb.toString().trim() + "\n" + sb2.toString().trim();
    }

    public int getAddPosition() {
        Iterator<Object> it = this.O00000Oo.iterator();
        int i = 0;
        while (it.hasNext() && it.next() != null) {
            i++;
        }
        return i;
    }

    public final void O00000Oo() {
        int i = 0;
        for (View visibility : this.f7262O000000o) {
            if (visibility.getVisibility() == 0) {
                i++;
            }
        }
        O000000o o000000o = this.O00000oo;
        if (o000000o != null) {
            o000000o.O000000o(i);
        }
    }
}
