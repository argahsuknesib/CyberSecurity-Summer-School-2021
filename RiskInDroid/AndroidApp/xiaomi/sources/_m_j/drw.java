package _m_j;

import com.google.android.exoplayer2.C;
import com.trello.rxlifecycle.OutsideLifecycleException;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.android.FragmentEvent;
import rx.Observable;
import rx.functions.Func1;

public final class drw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Func1<ActivityEvent, ActivityEvent> f14884O000000o = new Func1<ActivityEvent, ActivityEvent>() {
        /* class _m_j.drw.AnonymousClass1 */

        public final /* synthetic */ Object call(Object obj) {
            ActivityEvent activityEvent = (ActivityEvent) obj;
            switch (AnonymousClass3.f14885O000000o[activityEvent.ordinal()]) {
                case 1:
                    return ActivityEvent.DESTROY;
                case 2:
                    return ActivityEvent.STOP;
                case 3:
                    return ActivityEvent.PAUSE;
                case 4:
                    return ActivityEvent.STOP;
                case 5:
                    return ActivityEvent.DESTROY;
                case 6:
                    throw new OutsideLifecycleException("Cannot bind to Activity lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + activityEvent + " not yet implemented");
            }
        }
    };
    private static final Func1<FragmentEvent, FragmentEvent> O00000Oo = new Func1<FragmentEvent, FragmentEvent>() {
        /* class _m_j.drw.AnonymousClass2 */

        public final /* synthetic */ Object call(Object obj) {
            FragmentEvent fragmentEvent = (FragmentEvent) obj;
            switch (AnonymousClass3.O00000Oo[fragmentEvent.ordinal()]) {
                case 1:
                    return FragmentEvent.DETACH;
                case 2:
                    return FragmentEvent.DESTROY;
                case 3:
                    return FragmentEvent.DESTROY_VIEW;
                case 4:
                    return FragmentEvent.STOP;
                case 5:
                    return FragmentEvent.PAUSE;
                case 6:
                    return FragmentEvent.STOP;
                case 7:
                    return FragmentEvent.DESTROY_VIEW;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    return FragmentEvent.DESTROY;
                case 9:
                    return FragmentEvent.DETACH;
                case 10:
                    throw new OutsideLifecycleException("Cannot bind to Fragment lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + fragmentEvent + " not yet implemented");
            }
        }
    };

    public static <T> drr<T> O000000o(Observable<ActivityEvent> observable) {
        Func1<ActivityEvent, ActivityEvent> func1 = f14884O000000o;
        drx.O000000o(observable, "lifecycle == null");
        drx.O000000o(func1, "correspondingEvents == null");
        return new dru(observable.share(), func1);
    }

    /* renamed from: _m_j.drw$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f14885O000000o = new int[ActivityEvent.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[FragmentEvent.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0097 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00ab */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b5 */
        static {
            try {
                O00000Oo[FragmentEvent.ATTACH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                O00000Oo[FragmentEvent.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                O00000Oo[FragmentEvent.CREATE_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                O00000Oo[FragmentEvent.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                O00000Oo[FragmentEvent.RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            O00000Oo[FragmentEvent.PAUSE.ordinal()] = 6;
            O00000Oo[FragmentEvent.STOP.ordinal()] = 7;
            O00000Oo[FragmentEvent.DESTROY_VIEW.ordinal()] = 8;
            O00000Oo[FragmentEvent.DESTROY.ordinal()] = 9;
            try {
                O00000Oo[FragmentEvent.DETACH.ordinal()] = 10;
            } catch (NoSuchFieldError unused6) {
            }
            f14885O000000o[ActivityEvent.CREATE.ordinal()] = 1;
            f14885O000000o[ActivityEvent.START.ordinal()] = 2;
            f14885O000000o[ActivityEvent.RESUME.ordinal()] = 3;
            f14885O000000o[ActivityEvent.PAUSE.ordinal()] = 4;
            f14885O000000o[ActivityEvent.STOP.ordinal()] = 5;
            try {
                f14885O000000o[ActivityEvent.DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
