package com.tsmclient.smartcard.handler;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcF;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.tsmclient.smartcard.exception.UnProcessableCardException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class TagReader {
    private final Activity mActivity;
    private final ReentrantLock mExtraHandlerListLocker;
    private final List<ISmartCardHandler<IsoDep>> mExtraIsoDepHandlerList;
    private final List<ISmartCardHandler<NfcF>> mExtraNfcFHandlerList;
    public final Handler mHandler;
    private final List<ISmartCardHandler<IsoDep>> mIsoDepHandlerList;
    public SmartCardReaderListener mListener;
    private final List<ISmartCardHandler<NfcF>> mNfcFHandlerList;
    private PendingIntent mPendingIntent;
    private boolean mPolling;
    private final AtomicBoolean mStop;
    private final Handler mWorkHandler;
    private HandlerThread mWorkThread;

    public interface SmartCardReaderListener {
        void onCompleteHandle(Bundle bundle);

        void onStartHandleTag();
    }

    public TagReader(Activity activity) {
        this(activity, null, null);
    }

    public TagReader(Activity activity, Handler handler, Handler handler2) {
        this.mExtraHandlerListLocker = new ReentrantLock();
        if (handler == null) {
            this.mWorkThread = new HandlerThread("SCHandlerThread");
            this.mWorkThread.start();
            handler = new Handler(this.mWorkThread.getLooper());
        }
        handler2 = handler2 == null ? new Handler(Looper.getMainLooper()) : handler2;
        this.mWorkHandler = handler;
        this.mHandler = handler2;
        this.mIsoDepHandlerList = new CopyOnWriteArrayList();
        this.mNfcFHandlerList = new CopyOnWriteArrayList();
        this.mExtraIsoDepHandlerList = new ArrayList();
        this.mExtraNfcFHandlerList = new ArrayList();
        this.mActivity = activity;
        this.mStop = new AtomicBoolean();
    }

    public void addSmartCardHandler(ISmartCardHandler iSmartCardHandler) {
        int techType = iSmartCardHandler.getTechType();
        if (techType == 1) {
            this.mIsoDepHandlerList.add(iSmartCardHandler);
        } else if (techType != 2) {
            Log.w("SmartCardReader", "unknown card handler: " + iSmartCardHandler.getClass());
        } else {
            this.mNfcFHandlerList.add(iSmartCardHandler);
        }
    }

    public void addSmartCardExtraHandler(ISmartCardHandler iSmartCardHandler) {
        int techType = iSmartCardHandler.getTechType();
        if (techType == 1) {
            this.mExtraIsoDepHandlerList.add(iSmartCardHandler);
        } else if (techType == 2) {
            this.mExtraNfcFHandlerList.add(iSmartCardHandler);
        }
    }

    public void startPoll() {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this.mActivity);
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            if (this.mPendingIntent == null) {
                Activity activity = this.mActivity;
                this.mPendingIntent = PendingIntent.getActivity(this.mActivity, 0, new Intent(activity, activity.getClass()).addFlags(536870912), 268435456);
            }
            try {
                defaultAdapter.enableForegroundDispatch(this.mActivity, this.mPendingIntent, null, null);
            } catch (IllegalStateException unused) {
            }
            this.mPolling = true;
        }
    }

    public void stopPoll() {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this.mActivity);
        if (defaultAdapter != null && this.mPolling) {
            try {
                defaultAdapter.disableForegroundDispatch(this.mActivity);
            } catch (IllegalStateException unused) {
            }
            this.mPolling = false;
        }
    }

    public boolean isCardPolling() {
        return this.mPolling;
    }

    public void handleTag(final Tag tag) {
        if (this.mStop.get()) {
            Log.w("SmartCardReader", "card reader has stopped to handle tag");
            return;
        }
        SmartCardReaderListener smartCardReaderListener = this.mListener;
        if (smartCardReaderListener != null) {
            smartCardReaderListener.onStartHandleTag();
        }
        this.mWorkHandler.post(new Runnable() {
            /* class com.tsmclient.smartcard.handler.TagReader.AnonymousClass1 */

            public void run() {
                final Bundle bundle = null;
                try {
                    IsoDep isoDep = IsoDep.get(tag);
                    if (isoDep != null) {
                        bundle = TagReader.this.handleIsoDep(isoDep);
                        bundle.putParcelable("nfc_tag", tag);
                    } else {
                        NfcF nfcF = NfcF.get(tag);
                        if (nfcF != null) {
                            bundle = TagReader.this.handleNfcF(nfcF);
                        } else {
                            Log.w("SmartCardReader", "tag is not supported");
                            throw new UnProcessableCardException("SmartCardReaderunsupported card type");
                        }
                    }
                    if (bundle != null) {
                        final SmartCardReaderListener smartCardReaderListener = TagReader.this.mListener;
                        if (smartCardReaderListener != null) {
                            TagReader.this.mHandler.post(new Runnable() {
                                /* class com.tsmclient.smartcard.handler.TagReader.AnonymousClass1.AnonymousClass1 */

                                public void run() {
                                    smartCardReaderListener.onCompleteHandle(bundle);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    throw new IOException("SmartCardReaderfailed to handle tag");
                } catch (IOException unused) {
                    bundle = new Bundle();
                    bundle.putBoolean("success", false);
                    bundle.putInt("error", 1);
                } catch (UnProcessableCardException unused2) {
                    bundle = new Bundle();
                    bundle.putBoolean("success", false);
                    bundle.putInt("error", 2);
                } catch (Exception e) {
                    Log.e("SmartCardReader", "RuntimeException :", e);
                }
            }
        });
    }

    public void lockExtraHandlerListLocker() throws InterruptedException {
        this.mExtraHandlerListLocker.lockInterruptibly();
    }

    public void unLockExtraHandlerListLocker() {
        if (this.mExtraHandlerListLocker.isHeldByCurrentThread()) {
            this.mExtraHandlerListLocker.unlock();
        }
    }

    public Bundle handleIsoDep(IsoDep isoDep) throws IOException {
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", false);
        bundle.putInt("error", 2);
        try {
            isoDep.connect();
            for (ISmartCardHandler next : this.mIsoDepHandlerList) {
                try {
                    bundle = next.onHandleCard(isoDep);
                    Log.d("SmartCardReader", "IsoDep is handled by handler:" + next.getClass());
                    unLockExtraHandlerListLocker();
                    try {
                        isoDep.close();
                    } catch (IOException unused) {
                    }
                    return bundle;
                } catch (UnProcessableCardException unused2) {
                }
            }
            lockExtraHandlerListLocker();
            for (ISmartCardHandler next2 : this.mExtraIsoDepHandlerList) {
                try {
                    bundle = next2.onHandleCard(isoDep);
                    Log.d("SmartCardReader", "IsoDep is handled by extra handler:" + next2.getClass());
                    unLockExtraHandlerListLocker();
                    try {
                        isoDep.close();
                    } catch (IOException unused3) {
                    }
                    return bundle;
                } catch (UnProcessableCardException unused4) {
                }
            }
        } catch (InterruptedException unused5) {
            Log.d("SmartCardReader", "handleIsoDep is interrupted");
            Thread.currentThread().interrupt();
        } catch (Throwable th) {
            unLockExtraHandlerListLocker();
            try {
                isoDep.close();
            } catch (IOException unused6) {
            }
            throw th;
        }
        unLockExtraHandlerListLocker();
        try {
            isoDep.close();
        } catch (IOException unused7) {
        }
        return bundle;
    }

    public Bundle handleNfcF(NfcF nfcF) throws IOException {
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", false);
        bundle.putInt("error", 2);
        try {
            nfcF.connect();
            Iterator<ISmartCardHandler<NfcF>> it = this.mNfcFHandlerList.iterator();
            if (it.hasNext()) {
                ISmartCardHandler next = it.next();
                try {
                    bundle = next.onHandleCard(nfcF);
                    Log.d("SmartCardReader", "NfcF is handled by handler:" + next.getClass());
                    unLockExtraHandlerListLocker();
                    try {
                        nfcF.close();
                    } catch (IOException unused) {
                    }
                    return bundle;
                } catch (UnProcessableCardException unused2) {
                    unLockExtraHandlerListLocker();
                    try {
                        nfcF.close();
                    } catch (IOException unused3) {
                    }
                    return bundle;
                }
            } else {
                lockExtraHandlerListLocker();
                for (ISmartCardHandler next2 : this.mExtraNfcFHandlerList) {
                    try {
                        bundle = next2.onHandleCard(nfcF);
                        Log.d("SmartCardReader", "NfcF is handled by extra handler:" + next2.getClass());
                        unLockExtraHandlerListLocker();
                        try {
                            nfcF.close();
                        } catch (IOException unused4) {
                        }
                        return bundle;
                    } catch (UnProcessableCardException unused5) {
                    }
                }
                unLockExtraHandlerListLocker();
                try {
                    nfcF.close();
                } catch (IOException unused6) {
                }
                return bundle;
            }
        } catch (InterruptedException unused7) {
            Log.d("SmartCardReader", "handleNfcF is interrupted");
            Thread.currentThread().interrupt();
        } catch (Throwable th) {
            unLockExtraHandlerListLocker();
            try {
                nfcF.close();
            } catch (IOException unused8) {
            }
            throw th;
        }
    }

    public void shutdown() {
        this.mStop.set(true);
        HandlerThread handlerThread = this.mWorkThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mWorkThread.interrupt();
        }
        this.mWorkHandler.removeCallbacksAndMessages(null);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void setListener(SmartCardReaderListener smartCardReaderListener) {
        this.mListener = smartCardReaderListener;
    }
}
