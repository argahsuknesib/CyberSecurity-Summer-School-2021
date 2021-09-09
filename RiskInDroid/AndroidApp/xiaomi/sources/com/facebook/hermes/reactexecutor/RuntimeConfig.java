package com.facebook.hermes.reactexecutor;

import com.facebook.hermes.instrumentation.HermesMemoryDumper;

public final class RuntimeConfig {
    public int bytecodeWarmupPercent;
    public boolean enableSampledStats;
    public boolean es6Symbol;
    public HermesMemoryDumper heapDumper;
    public long heapSizeMB;
    public long tripWireCooldownMS;
    public boolean tripWireEnabled;
    public long tripWireLimitBytes;
}
