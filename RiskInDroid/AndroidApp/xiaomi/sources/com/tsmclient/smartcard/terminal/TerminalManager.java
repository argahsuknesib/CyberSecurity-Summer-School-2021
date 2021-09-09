package com.tsmclient.smartcard.terminal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class TerminalManager {
    private static volatile TerminalManager sInstance;
    private final Map<String, TerminalExtra> mTerminalInfoMap = new HashMap();

    public enum Priority {
        LOW,
        DEFAULT,
        HIGH
    }

    private TerminalManager() {
    }

    public static TerminalManager getInstance() {
        if (sInstance == null) {
            synchronized (TerminalManager.class) {
                if (sInstance == null) {
                    sInstance = new TerminalManager();
                }
            }
        }
        return sInstance;
    }

    /* access modifiers changed from: package-private */
    public TerminalExtra getTerminalExtra(String str) {
        TerminalExtra terminalExtra;
        synchronized (this.mTerminalInfoMap) {
            terminalExtra = this.mTerminalInfoMap.get(str);
            if (terminalExtra == null) {
                terminalExtra = new TerminalExtra();
                this.mTerminalInfoMap.put(str, terminalExtra);
            }
        }
        return terminalExtra;
    }

    static class TerminalExtra {
        Semaphore mTermSemaphore = new Semaphore(1);
        IScTerminal mTerminal;
        Priority mTerminalPriority;

        TerminalExtra() {
        }
    }
}
