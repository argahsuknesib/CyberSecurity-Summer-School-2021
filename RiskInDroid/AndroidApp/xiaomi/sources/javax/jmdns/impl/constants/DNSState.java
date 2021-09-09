package javax.jmdns.impl.constants;

import com.google.android.exoplayer2.C;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public enum DNSState {
    PROBING_1("probing 1", StateClass.probing),
    PROBING_2("probing 2", StateClass.probing),
    PROBING_3("probing 3", StateClass.probing),
    ANNOUNCING_1("announcing 1", StateClass.announcing),
    ANNOUNCING_2("announcing 2", StateClass.announcing),
    ANNOUNCED("announced", StateClass.announced),
    CANCELING_1("canceling 1", StateClass.canceling),
    CANCELING_2("canceling 2", StateClass.canceling),
    CANCELING_3("canceling 3", StateClass.canceling),
    CANCELED("canceled", StateClass.canceled),
    CLOSING("closing", StateClass.closing),
    CLOSED("closed", StateClass.closed);
    
    private final String _name;
    private final StateClass _state;

    enum StateClass {
        probing,
        announcing,
        announced,
        canceling,
        canceled,
        closing,
        closed
    }

    private DNSState(String str, StateClass stateClass) {
        this._name = str;
        this._state = stateClass;
    }

    public final String toString() {
        return this._name;
    }

    /* renamed from: javax.jmdns.impl.constants.DNSState$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f15373O000000o = new int[DNSState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|(3:23|24|26)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f15373O000000o[DNSState.PROBING_1.ordinal()] = 1;
            f15373O000000o[DNSState.PROBING_2.ordinal()] = 2;
            f15373O000000o[DNSState.PROBING_3.ordinal()] = 3;
            f15373O000000o[DNSState.ANNOUNCING_1.ordinal()] = 4;
            f15373O000000o[DNSState.ANNOUNCING_2.ordinal()] = 5;
            f15373O000000o[DNSState.ANNOUNCED.ordinal()] = 6;
            f15373O000000o[DNSState.CANCELING_1.ordinal()] = 7;
            f15373O000000o[DNSState.CANCELING_2.ordinal()] = 8;
            f15373O000000o[DNSState.CANCELING_3.ordinal()] = 9;
            f15373O000000o[DNSState.CANCELED.ordinal()] = 10;
            f15373O000000o[DNSState.CLOSING.ordinal()] = 11;
            try {
                f15373O000000o[DNSState.CLOSED.ordinal()] = 12;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final DNSState advance() {
        switch (AnonymousClass1.f15373O000000o[ordinal()]) {
            case 1:
                return PROBING_2;
            case 2:
                return PROBING_3;
            case 3:
                return ANNOUNCING_1;
            case 4:
                return ANNOUNCING_2;
            case 5:
                return ANNOUNCED;
            case 6:
                return ANNOUNCED;
            case 7:
                return CANCELING_2;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return CANCELING_3;
            case 9:
                return CANCELED;
            case 10:
                return CANCELED;
            case 11:
                return CLOSED;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return CLOSED;
            default:
                return this;
        }
    }

    public final DNSState revert() {
        switch (AnonymousClass1.f15373O000000o[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return PROBING_1;
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
            case 9:
                return CANCELING_1;
            case 10:
                return CANCELED;
            case 11:
                return CLOSING;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return CLOSED;
            default:
                return this;
        }
    }

    public final boolean isProbing() {
        return this._state == StateClass.probing;
    }

    public final boolean isAnnouncing() {
        return this._state == StateClass.announcing;
    }

    public final boolean isAnnounced() {
        return this._state == StateClass.announced;
    }

    public final boolean isCanceling() {
        return this._state == StateClass.canceling;
    }

    public final boolean isCanceled() {
        return this._state == StateClass.canceled;
    }

    public final boolean isClosing() {
        return this._state == StateClass.closing;
    }

    public final boolean isClosed() {
        return this._state == StateClass.closed;
    }
}
