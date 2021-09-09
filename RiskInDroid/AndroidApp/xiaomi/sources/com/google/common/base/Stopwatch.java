package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated = true)
public final class Stopwatch {
    private long elapsedNanos;
    private boolean isRunning;
    private long startTick;
    private final Ticker ticker;

    public static Stopwatch createUnstarted() {
        return new Stopwatch();
    }

    public static Stopwatch createUnstarted(Ticker ticker2) {
        return new Stopwatch(ticker2);
    }

    public static Stopwatch createStarted() {
        return new Stopwatch().start();
    }

    public static Stopwatch createStarted(Ticker ticker2) {
        return new Stopwatch(ticker2).start();
    }

    Stopwatch() {
        this.ticker = Ticker.systemTicker();
    }

    Stopwatch(Ticker ticker2) {
        this.ticker = (Ticker) Preconditions.checkNotNull(ticker2, "ticker");
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    @CanIgnoreReturnValue
    public final Stopwatch start() {
        Preconditions.checkState(!this.isRunning, "This stopwatch is already running.");
        this.isRunning = true;
        this.startTick = this.ticker.read();
        return this;
    }

    @CanIgnoreReturnValue
    public final Stopwatch stop() {
        long read = this.ticker.read();
        Preconditions.checkState(this.isRunning, "This stopwatch is already stopped.");
        this.isRunning = false;
        this.elapsedNanos += read - this.startTick;
        return this;
    }

    @CanIgnoreReturnValue
    public final Stopwatch reset() {
        this.elapsedNanos = 0;
        this.isRunning = false;
        return this;
    }

    private long elapsedNanos() {
        return this.isRunning ? (this.ticker.read() - this.startTick) + this.elapsedNanos : this.elapsedNanos;
    }

    public final long elapsed(TimeUnit timeUnit) {
        return timeUnit.convert(elapsedNanos(), TimeUnit.NANOSECONDS);
    }

    @GwtIncompatible
    public final Duration elapsed() {
        return Duration.ofNanos(elapsedNanos());
    }

    public final String toString() {
        long elapsedNanos2 = elapsedNanos();
        TimeUnit chooseUnit = chooseUnit(elapsedNanos2);
        double d = (double) elapsedNanos2;
        double convert = (double) TimeUnit.NANOSECONDS.convert(1, chooseUnit);
        Double.isNaN(d);
        Double.isNaN(convert);
        double d2 = d / convert;
        return Platform.formatCompact4Digits(d2) + " " + abbreviate(chooseUnit);
    }

    private static TimeUnit chooseUnit(long j) {
        if (TimeUnit.DAYS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.DAYS;
        }
        if (TimeUnit.HOURS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.HOURS;
        }
        if (TimeUnit.MINUTES.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MINUTES;
        }
        if (TimeUnit.SECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.SECONDS;
        }
        if (TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MILLISECONDS;
        }
        if (TimeUnit.MICROSECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MICROSECONDS;
        }
        return TimeUnit.NANOSECONDS;
    }

    /* renamed from: com.google.common.base.Stopwatch$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit = new int[TimeUnit.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.NANOSECONDS.ordinal()] = 1;
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 2;
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 3;
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.SECONDS.ordinal()] = 4;
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MINUTES.ordinal()] = 5;
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.HOURS.ordinal()] = 6;
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static String abbreviate(TimeUnit timeUnit) {
        switch (AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }
}
