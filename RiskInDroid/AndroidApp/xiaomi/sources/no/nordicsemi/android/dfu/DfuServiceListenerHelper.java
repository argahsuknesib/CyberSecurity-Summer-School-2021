package no.nordicsemi.android.dfu;

import _m_j.ft;
import _m_j.jah;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class DfuServiceListenerHelper {
    private static LogBroadcastReceiver mLogBroadcastReceiver;
    private static ProgressBroadcastsReceiver mProgressBroadcastReceiver;

    static class LogBroadcastReceiver extends BroadcastReceiver {
        private DfuLogListener mGlobalLogListener;
        private Map<String, DfuLogListener> mListeners;

        private LogBroadcastReceiver() {
            this.mListeners = new HashMap();
        }

        public void setLogListener(DfuLogListener dfuLogListener) {
            this.mGlobalLogListener = dfuLogListener;
        }

        public void setLogListener(String str, DfuLogListener dfuLogListener) {
            this.mListeners.put(str, dfuLogListener);
            this.mListeners.put(DfuServiceListenerHelper.getIncrementedAddress(str), dfuLogListener);
        }

        public boolean removeLogListener(DfuLogListener dfuLogListener) {
            if (this.mGlobalLogListener == dfuLogListener) {
                this.mGlobalLogListener = null;
            }
            Iterator<Map.Entry<String, DfuLogListener>> it = this.mListeners.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (next.getValue() == dfuLogListener) {
                    this.mListeners.remove(next.getKey());
                    break;
                }
            }
            Iterator<Map.Entry<String, DfuLogListener>> it2 = this.mListeners.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next2 = it2.next();
                if (next2.getValue() == dfuLogListener) {
                    this.mListeners.remove(next2.getKey());
                    break;
                }
            }
            return this.mGlobalLogListener == null && this.mListeners.isEmpty();
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS");
            DfuLogListener dfuLogListener = this.mGlobalLogListener;
            DfuLogListener dfuLogListener2 = this.mListeners.get(stringExtra);
            if (dfuLogListener != null || dfuLogListener2 != null) {
                int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_LOG_LEVEL", 0);
                String stringExtra2 = intent.getStringExtra("no.nordicsemi.android.dfu.extra.EXTRA_LOG_INFO");
                if (dfuLogListener != null) {
                    dfuLogListener.onLogEvent(stringExtra, intExtra, stringExtra2);
                }
                if (dfuLogListener2 != null) {
                    dfuLogListener2.onLogEvent(stringExtra, intExtra, stringExtra2);
                }
            }
        }
    }

    static class ProgressBroadcastsReceiver extends BroadcastReceiver {
        private DfuProgressListener mGlobalProgressListener;
        private Map<String, DfuProgressListener> mListeners;

        private ProgressBroadcastsReceiver() {
            this.mListeners = new HashMap();
        }

        public void setProgressListener(DfuProgressListener dfuProgressListener) {
            this.mGlobalProgressListener = dfuProgressListener;
        }

        public void setProgressListener(String str, DfuProgressListener dfuProgressListener) {
            this.mListeners.put(str, dfuProgressListener);
            this.mListeners.put(DfuServiceListenerHelper.getIncrementedAddress(str), dfuProgressListener);
        }

        public boolean removeProgressListener(DfuProgressListener dfuProgressListener) {
            if (this.mGlobalProgressListener == dfuProgressListener) {
                this.mGlobalProgressListener = null;
            }
            Iterator<Map.Entry<String, DfuProgressListener>> it = this.mListeners.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (next.getValue() == dfuProgressListener) {
                    this.mListeners.remove(next.getKey());
                    break;
                }
            }
            Iterator<Map.Entry<String, DfuProgressListener>> it2 = this.mListeners.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next2 = it2.next();
                if (next2.getValue() == dfuProgressListener) {
                    this.mListeners.remove(next2.getKey());
                    break;
                }
            }
            return this.mGlobalProgressListener == null && this.mListeners.isEmpty();
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS");
            DfuProgressListener dfuProgressListener = this.mGlobalProgressListener;
            DfuProgressListener dfuProgressListener2 = this.mListeners.get(stringExtra);
            if (dfuProgressListener != null || dfuProgressListener2 != null) {
                String action = intent.getAction();
                char c = 65535;
                int hashCode = action.hashCode();
                if (hashCode != -2021868104) {
                    if (hashCode == -1282379203 && action.equals("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR")) {
                        c = 1;
                    }
                } else if (action.equals("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS")) {
                    c = 0;
                }
                if (c == 0) {
                    int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", 0);
                    float floatExtra = intent.getFloatExtra("no.nordicsemi.android.dfu.extra.EXTRA_SPEED_B_PER_MS", 0.0f);
                    float floatExtra2 = intent.getFloatExtra("no.nordicsemi.android.dfu.extra.EXTRA_AVG_SPEED_B_PER_MS", 0.0f);
                    int intExtra2 = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", 0);
                    int intExtra3 = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", 0);
                    switch (intExtra) {
                        case -7:
                            if (dfuProgressListener != null) {
                                dfuProgressListener.onDeviceDisconnected(stringExtra);
                                dfuProgressListener.onDfuAborted(stringExtra);
                            }
                            if (dfuProgressListener2 != null) {
                                dfuProgressListener2.onDeviceDisconnected(stringExtra);
                                dfuProgressListener2.onDfuAborted(stringExtra);
                                return;
                            }
                            return;
                        case -6:
                            if (dfuProgressListener != null) {
                                dfuProgressListener.onDeviceDisconnected(stringExtra);
                                dfuProgressListener.onDfuCompleted(stringExtra);
                            }
                            if (dfuProgressListener2 != null) {
                                dfuProgressListener2.onDeviceDisconnected(stringExtra);
                                dfuProgressListener2.onDfuCompleted(stringExtra);
                                return;
                            }
                            return;
                        case -5:
                            if (dfuProgressListener != null) {
                                dfuProgressListener.onDeviceDisconnecting(stringExtra);
                            }
                            if (dfuProgressListener2 != null) {
                                dfuProgressListener2.onDeviceDisconnecting(stringExtra);
                                return;
                            }
                            return;
                        case -4:
                            if (dfuProgressListener != null) {
                                dfuProgressListener.onFirmwareValidating(stringExtra);
                            }
                            if (dfuProgressListener2 != null) {
                                dfuProgressListener2.onFirmwareValidating(stringExtra);
                                return;
                            }
                            return;
                        case -3:
                            if (dfuProgressListener != null) {
                                dfuProgressListener.onEnablingDfuMode(stringExtra);
                            }
                            if (dfuProgressListener2 != null) {
                                dfuProgressListener2.onEnablingDfuMode(stringExtra);
                                return;
                            }
                            return;
                        case -2:
                            if (dfuProgressListener != null) {
                                dfuProgressListener.onDeviceConnected(stringExtra);
                                dfuProgressListener.onDfuProcessStarting(stringExtra);
                            }
                            if (dfuProgressListener2 != null) {
                                dfuProgressListener2.onDeviceConnected(stringExtra);
                                dfuProgressListener2.onDfuProcessStarting(stringExtra);
                                return;
                            }
                            return;
                        case -1:
                            if (dfuProgressListener != null) {
                                dfuProgressListener.onDeviceConnecting(stringExtra);
                            }
                            if (dfuProgressListener2 != null) {
                                dfuProgressListener2.onDeviceConnecting(stringExtra);
                                return;
                            }
                            return;
                        default:
                            if (intExtra == 0) {
                                if (dfuProgressListener != null) {
                                    dfuProgressListener.onDfuProcessStarted(stringExtra);
                                }
                                if (dfuProgressListener2 != null) {
                                    dfuProgressListener2.onDfuProcessStarted(stringExtra);
                                }
                            }
                            if (dfuProgressListener != null) {
                                dfuProgressListener.onProgressChanged(stringExtra, intExtra, floatExtra, floatExtra2, intExtra2, intExtra3);
                            }
                            if (dfuProgressListener2 != null) {
                                dfuProgressListener2.onProgressChanged(stringExtra, intExtra, floatExtra, floatExtra2, intExtra2, intExtra3);
                                return;
                            }
                            return;
                    }
                } else if (c == 1) {
                    int intExtra4 = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", 0);
                    int intExtra5 = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 0);
                    if (dfuProgressListener != null) {
                        dfuProgressListener.onDeviceDisconnected(stringExtra);
                    }
                    if (dfuProgressListener2 != null) {
                        dfuProgressListener2.onDeviceDisconnected(stringExtra);
                    }
                    if (intExtra5 == 1) {
                        if (dfuProgressListener != null) {
                            dfuProgressListener.onError(stringExtra, intExtra4, intExtra5, jah.O000000o(intExtra4));
                        }
                        if (dfuProgressListener2 != null) {
                            dfuProgressListener2.onError(stringExtra, intExtra4, intExtra5, jah.O000000o(intExtra4));
                        }
                    } else if (intExtra5 != 3) {
                        if (dfuProgressListener != null) {
                            dfuProgressListener.onError(stringExtra, intExtra4, intExtra5, jah.O00000Oo(intExtra4));
                        }
                        if (dfuProgressListener2 != null) {
                            dfuProgressListener2.onError(stringExtra, intExtra4, intExtra5, jah.O00000Oo(intExtra4));
                        }
                    } else {
                        if (dfuProgressListener != null) {
                            dfuProgressListener.onError(stringExtra, intExtra4, intExtra5, jah.O00000o0(intExtra4));
                        }
                        if (dfuProgressListener2 != null) {
                            dfuProgressListener2.onError(stringExtra, intExtra4, intExtra5, jah.O00000o0(intExtra4));
                        }
                    }
                }
            }
        }
    }

    public static void registerProgressListener(Context context, DfuProgressListener dfuProgressListener) {
        if (mProgressBroadcastReceiver == null) {
            mProgressBroadcastReceiver = new ProgressBroadcastsReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS");
            intentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR");
            ft.O000000o(context).O000000o(mProgressBroadcastReceiver, intentFilter);
        }
        mProgressBroadcastReceiver.setProgressListener(dfuProgressListener);
    }

    public static void registerProgressListener(Context context, DfuProgressListener dfuProgressListener, String str) {
        if (mProgressBroadcastReceiver == null) {
            mProgressBroadcastReceiver = new ProgressBroadcastsReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS");
            intentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR");
            ft.O000000o(context).O000000o(mProgressBroadcastReceiver, intentFilter);
        }
        mProgressBroadcastReceiver.setProgressListener(str, dfuProgressListener);
    }

    public static void unregisterProgressListener(Context context, DfuProgressListener dfuProgressListener) {
        ProgressBroadcastsReceiver progressBroadcastsReceiver = mProgressBroadcastReceiver;
        if (progressBroadcastsReceiver != null && progressBroadcastsReceiver.removeProgressListener(dfuProgressListener)) {
            ft.O000000o(context).O000000o(mProgressBroadcastReceiver);
            mProgressBroadcastReceiver = null;
        }
    }

    public static void registerLogListener(Context context, DfuLogListener dfuLogListener) {
        if (mLogBroadcastReceiver == null) {
            mLogBroadcastReceiver = new LogBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG");
            ft.O000000o(context).O000000o(mLogBroadcastReceiver, intentFilter);
        }
        mLogBroadcastReceiver.setLogListener(dfuLogListener);
    }

    public static void registerLogListener(Context context, DfuLogListener dfuLogListener, String str) {
        if (mLogBroadcastReceiver == null) {
            mLogBroadcastReceiver = new LogBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG");
            ft.O000000o(context).O000000o(mLogBroadcastReceiver, intentFilter);
        }
        mLogBroadcastReceiver.setLogListener(str, dfuLogListener);
    }

    public static void unregisterLogListener(Context context, DfuLogListener dfuLogListener) {
        LogBroadcastReceiver logBroadcastReceiver = mLogBroadcastReceiver;
        if (logBroadcastReceiver != null && logBroadcastReceiver.removeLogListener(dfuLogListener)) {
            ft.O000000o(context).O000000o(mLogBroadcastReceiver);
            mLogBroadcastReceiver = null;
        }
    }

    public static String getIncrementedAddress(String str) {
        String substring = str.substring(0, 15);
        String substring2 = str.substring(15);
        String format = String.format(Locale.US, "%02X", Integer.valueOf((Integer.valueOf(substring2, 16).intValue() + 1) & 255));
        return substring + format;
    }
}
