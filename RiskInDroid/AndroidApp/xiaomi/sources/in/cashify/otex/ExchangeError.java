package in.cashify.otex;

public class ExchangeError {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f12255O000000o;
    public final Kind O00000Oo;

    public enum Kind {
        INVALID_RESPONSE(402, "Invalid server response"),
        ROOTED_DEVICE_NOT_SUPPORTED(403, "Unsupported rooted device"),
        EMULATOR_NOT_SUPPORTED(405, "Unsupported Emulator"),
        DEVICE_NOT_SUPPORTED(406, "Unsupported Device"),
        DEVICE_NOT_ELIGIBLE(407, "Ineligible Device"),
        EXCHANGE_NOT_VALID(408, "Invalid Exchange!"),
        SERVER_ERROR(410, "server error"),
        INVALID_PIN_CODE(411, "Invalid postal code"),
        DUPLICATE_DEVICE(416, "Unsupported duplicate device"),
        PERMISSION_NOT_GRANTED(417, "READ_PHONE_STATE permission not granted to start diagnose"),
        UNKNOWN_ERROR(499, "Unknown Error");
        

        /* renamed from: a  reason: collision with root package name */
        public final int f12256a;
        public String b;

        /* access modifiers changed from: public */
        Kind(int i, String str) {
            this.f12256a = i;
            this.b = str;
        }

        public static Kind valueOfInt(int i) {
            for (Kind kind : values()) {
                if (kind.getCode() == i) {
                    return kind;
                }
            }
            return UNKNOWN_ERROR;
        }

        public final int getCode() {
            return this.f12256a;
        }

        public final String getDetail() {
            return this.b;
        }

        public final void setDetail(String str) {
            this.b = str;
        }
    }

    public ExchangeError(String str, int i) {
        this.f12255O000000o = str;
        this.O00000Oo = Kind.valueOfInt(i);
        this.O00000Oo.setDetail(str);
    }

    public ExchangeError(String str, Kind kind) {
        this.f12255O000000o = str;
        this.O00000Oo = kind;
    }
}
