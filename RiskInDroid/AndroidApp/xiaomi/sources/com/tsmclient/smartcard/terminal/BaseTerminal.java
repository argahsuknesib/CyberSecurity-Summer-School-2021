package com.tsmclient.smartcard.terminal;

import android.content.Context;
import android.util.Log;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import com.tsmclient.smartcard.PrefUtils;
import com.tsmclient.smartcard.exception.InvalidTLVException;
import com.tsmclient.smartcard.exception.NfcEeIOException;
import com.tsmclient.smartcard.exception.TagNotFoundException;
import com.tsmclient.smartcard.handler.config.ResponseImpl;
import com.tsmclient.smartcard.terminal.TerminalManager;
import com.tsmclient.smartcard.terminal.response.ScResponse;
import com.tsmclient.smartcard.tlv.ITLVObject;
import com.tsmclient.smartcard.tlv.ITLVValue;
import com.tsmclient.smartcard.tlv.TLVParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class BaseTerminal implements IScTerminal {
    protected static ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    protected String mCIN;
    protected String mCPLC;
    protected Context mContext;
    protected boolean mInterruptible = true;
    protected boolean mNfcChannelOpen;
    protected String mSeid;
    protected String mTerminalCategory;
    protected TerminalManager.Priority mTerminalPriority;
    protected TerminalType mTerminalType;

    /* access modifiers changed from: protected */
    public String getPrefKey(String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    public abstract void internalClose();

    /* access modifiers changed from: protected */
    public abstract void internalConnect() throws IOException, InterruptedException;

    /* access modifiers changed from: protected */
    public abstract byte[] internalTransmit(byte[] bArr) throws IOException, InterruptedException;

    public BaseTerminal(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public void acquireLock() throws IOException, InterruptedException {
        if (this.mTerminalPriority == null) {
            this.mTerminalPriority = TerminalManager.Priority.DEFAULT;
        }
        TerminalManager.TerminalExtra terminalExtra = TerminalManager.getInstance().getTerminalExtra(this.mTerminalCategory);
        if ((terminalExtra.mTerminalPriority == null || this.mTerminalPriority.ordinal() > terminalExtra.mTerminalPriority.ordinal()) && terminalExtra.mTerminal != null) {
            terminalExtra.mTerminal.close();
        }
        if (this.mInterruptible) {
            terminalExtra.mTermSemaphore.acquire();
        } else {
            terminalExtra.mTermSemaphore.acquireUninterruptibly();
        }
        terminalExtra.mTerminal = this;
        terminalExtra.mTerminalPriority = this.mTerminalPriority;
    }

    /* access modifiers changed from: protected */
    public void releaseLock() {
        TerminalManager.TerminalExtra terminalExtra = TerminalManager.getInstance().getTerminalExtra(this.mTerminalCategory);
        if (terminalExtra.mTerminal == this) {
            terminalExtra.mTerminal = null;
            terminalExtra.mTermSemaphore.drainPermits();
            terminalExtra.mTermSemaphore.release();
        }
    }

    public void open() throws IOException, InterruptedException {
        acquireLock();
        Log.d("NfcEETerminal", "try to connect terminal");
        internalConnect();
        this.mNfcChannelOpen = true;
        Log.d("NfcEETerminal", "terminal opened");
    }

    public synchronized ScResponse transmit(byte[] bArr) throws IOException, InterruptedException {
        byte[] internalTransmit;
        Log.d("NfcEETerminal", "send: " + Coder.bytesToHexString(bArr));
        internalTransmit = internalTransmit(bArr);
        Log.d("NfcEETerminal", "resp: " + Coder.bytesToHexString(internalTransmit));
        if (internalTransmit == null || internalTransmit.length < 2) {
            throw new IOException("response too small");
        }
        byte b = internalTransmit[internalTransmit.length - 2] & 255;
        if (b == 108) {
            bArr[bArr.length - 1] = internalTransmit[internalTransmit.length - 1];
            internalTransmit = internalTransmit(bArr);
        } else if (b == 97) {
            byte[] bArr2 = {bArr[0], -64, 0, 0, 0};
            byte[] bArr3 = new byte[(internalTransmit.length - 2)];
            System.arraycopy(internalTransmit, 0, bArr3, 0, internalTransmit.length - 2);
            while (true) {
                bArr2[4] = internalTransmit[internalTransmit.length - 1];
                internalTransmit = internalTransmit(bArr2);
                if (internalTransmit.length < 2 || internalTransmit[internalTransmit.length - 2] != 97) {
                    internalTransmit = appendResponse(bArr3, internalTransmit, internalTransmit.length);
                } else {
                    bArr3 = appendResponse(bArr3, internalTransmit, internalTransmit.length - 2);
                }
            }
            internalTransmit = appendResponse(bArr3, internalTransmit, internalTransmit.length);
        }
        return new ResponseImpl(internalTransmit);
    }

    public synchronized void close() {
        try {
            internalClose();
            this.mNfcChannelOpen = false;
            releaseLock();
            Log.d("NfcEETerminal", "terminal closed");
        } catch (Throwable th) {
            try {
                Log.e("NfcEETerminal", "closing terminal failed", th);
                releaseLock();
                Log.d("NfcEETerminal", "terminal closed");
            } catch (Throwable th2) {
                releaseLock();
                Log.d("NfcEETerminal", "terminal closed");
                throw th2;
            }
        }
    }

    public boolean isNfcChannelOpen() {
        return this.mNfcChannelOpen;
    }

    public TerminalType getTerminalType() {
        return this.mTerminalType;
    }

    public String getTerminalCategory() {
        return this.mTerminalCategory;
    }

    public boolean isInterruptible() {
        return this.mInterruptible;
    }

    public void setInterruptible(boolean z) {
        this.mInterruptible = z;
    }

    public String getSeid() throws IOException, InterruptedException {
        this.mSeid = PrefUtils.getString(this.mContext, getPrefKey("key_seid"), null);
        if (this.mSeid == null) {
            getSEInfo();
        }
        return this.mSeid;
    }

    public String getCPLC() throws IOException, InterruptedException {
        this.mCPLC = PrefUtils.getString(this.mContext, getPrefKey("key_cplc"), null);
        if (this.mCPLC == null) {
            getSEInfo();
        }
        return this.mCPLC;
    }

    public String getCIN() throws IOException, InterruptedException {
        this.mCIN = PrefUtils.getString(this.mContext, getPrefKey("key_cin"), null);
        if (this.mCIN == null) {
            getSEInfo();
        }
        return this.mCIN;
    }

    public void getSEInfo() throws IOException, InterruptedException {
        try {
            open();
            readSEInfo();
        } finally {
            close();
        }
    }

    public boolean isAppletExist(String str) throws IOException, InterruptedException {
        CommandApdu commandApdu = new CommandApdu(0, 164, 4, 0);
        try {
            open();
            commandApdu.setData(Coder.hexStringToBytes(str));
            return ByteArray.equals(transmit(commandApdu.toBytes()).getStatus(), ScResponse.STATUS_OK);
        } finally {
            close();
        }
    }

    public Map<String, ByteArray> getCardActivationState(String str) throws InterruptedException {
        HashMap hashMap = new HashMap();
        try {
            open();
            ScResponse transmit = transmit(APDUConstants.SELECT_CRS);
            if (!ByteArray.equals(transmit.getStatus(), ScResponse.STATUS_OK)) {
                Log.e("NfcEETerminal", "failed to select CRS, status: " + Coder.bytesToHexString(transmit.getStatus().toBytes()));
                close();
                return null;
            }
            byte[] hexStringToBytes = Coder.hexStringToBytes(str);
            byte[] bArr = new byte[(hexStringToBytes.length + 2 + 5)];
            bArr[0] = 79;
            bArr[1] = (byte) (hexStringToBytes.length & 255);
            System.arraycopy(hexStringToBytes, 0, bArr, 2, hexStringToBytes.length);
            System.arraycopy(APDUConstants.COMM_TAG_GET_STATUS.toBytes(), 0, bArr, hexStringToBytes.length + 2, APDUConstants.COMM_TAG_GET_STATUS.toBytes().length);
            CommandApdu clone = APDUConstants.COMM_PREFIX_GET_STATUS.clone();
            clone.setData(bArr);
            ScResponse transmit2 = transmit(clone.toBytes());
            if (ByteArray.equals(transmit2.getStatus(), ScResponse.STATUS_REFERENCE_NOT_FOUND)) {
                close();
                return hashMap;
            }
            while (true) {
                if (!ByteArray.equals(transmit2.getStatus(), ScResponse.STATUS_MORE_DATA_AVAILABLE) && !ByteArray.equals(transmit2.getStatus(), ScResponse.STATUS_OK)) {
                    break;
                }
                if (clone.getP2() != 1) {
                    clone.setP2(1);
                }
                for (ITLVObject next : TLVParser.parseTLVValue(transmit2.getData()).findTLVList(APDUConstants.TAG_AEF_ENTRANCE)) {
                    hashMap.put(Coder.bytesToHexString(next.getValue().findTLV(APDUConstants.TAG_AID).getValue().toBytes().toBytes()), next.getValue().findTLV(APDUConstants.TAG_LIFESTYLE_STATE).getValue().toBytes());
                }
                if (ByteArray.equals(transmit2.getStatus(), ScResponse.STATUS_OK)) {
                    close();
                    return hashMap;
                }
                transmit2 = transmit(clone.toBytes());
            }
            close();
            return hashMap;
        } catch (InvalidTLVException e) {
            Log.e("NfcEETerminal", "getCardActivationState InvalidTLVException occurred.", e);
        } catch (TagNotFoundException e2) {
            Log.e("NfcEETerminal", "getCardActivationState TagNotFoundException occurred.", e2);
        } catch (IOException e3) {
            Log.e("NfcEETerminal", "getCardActivationState IOException occurred.", e3);
        } catch (Throwable th) {
            close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x013f, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        android.util.Log.e("NfcEETerminal", "failed to active card", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0146, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0147, code lost:
        android.util.Log.e("NfcEETerminal", "failed to active card, resolveActivationConflict TagNotFoundException occurred.", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0150, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        android.util.Log.e("NfcEETerminal", "active card is interrupted. aid: ".concat(java.lang.String.valueOf(r11)), r1);
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0166, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0167, code lost:
        android.util.Log.e("NfcEETerminal", "failed to active card, aid = ".concat(java.lang.String.valueOf(r11)), r1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013f A[ExcHandler: InvalidTLVException (r11v7 'e' com.tsmclient.smartcard.exception.InvalidTLVException A[CUSTOM_DECLARE]), Splitter:B:1:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0150 A[ExcHandler: InterruptedException (r1v2 'e' java.lang.InterruptedException A[CUSTOM_DECLARE]), Splitter:B:1:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0166 A[Catch:{ TagNotFoundException -> 0x0094, IOException -> 0x0166, InterruptedException -> 0x0150, InvalidTLVException -> 0x013f, all -> 0x013d }, ExcHandler: IOException (r1v1 'e' java.io.IOException A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:1:0x0010] */
    public boolean activateCard(String str) {
        int i;
        Log.d("NfcEETerminal", "activateCard appAid:".concat(String.valueOf(str)));
        try {
            open();
            if (!ByteArray.equals(transmit(APDUConstants.SELECT_CRS).getStatus(), ScResponse.STATUS_OK)) {
                close();
                return false;
            }
            ScResponse transmit = transmit(TerminalUtils.buildSetStatusApdu(str, true).toBytes());
            if (!ByteArray.equals(transmit.getStatus(), ScResponse.STATUS_OK)) {
                if (!ByteArray.equals(transmit.getStatus(), ScResponse.STATUS_OPERATION_FAILED)) {
                    if (ByteArray.equals(transmit.getStatus(), ScResponse.STATUS_ACTIVATION_CONFLICT)) {
                        ByteArray data = transmit.getData();
                        if (data == null) {
                            close();
                            return false;
                        }
                        ITLVValue value = TLVParser.parseTLVValue(data).findTLV(APDUConstants.TAG_AEF_ENTRANCE).getValue();
                        if (value == null) {
                            close();
                            return false;
                        }
                        ITLVObject iTLVObject = null;
                        byte[] bArr = {-96, -94};
                        i = 0;
                        while (true) {
                            if (i >= 2) {
                                break;
                            }
                            iTLVObject = value.findTLV(ByteArray.wrap(bArr[i]));
                            break;
                        }
                        if (!(iTLVObject == null || iTLVObject.getValue() == null)) {
                            String bytesToHexString = Coder.bytesToHexString(iTLVObject.getValue().findTLV(APDUConstants.TAG_AID).getValue().toBytes().toBytes());
                            ScResponse transmit2 = transmit(TerminalUtils.buildSetStatusApdu(bytesToHexString, false).toBytes());
                            if (!ByteArray.equals(transmit2.getStatus(), ScResponse.STATUS_OK)) {
                                String byteArray = transmit2.getStatus() == null ? "null" : transmit2.getStatus().toString();
                                Log.d("NfcEETerminal", "resolveActivationConflict deactivate: " + bytesToHexString + ", response: " + byteArray);
                                close();
                                return false;
                            } else if (ByteArray.equals(transmit(TerminalUtils.buildSetStatusApdu(str, true).toBytes()).getStatus(), ScResponse.STATUS_OK)) {
                                close();
                                return true;
                            }
                        }
                        close();
                        return false;
                    }
                    close();
                    return false;
                }
            }
            Log.d("NfcEETerminal", "activateCard appAid:" + str + " success");
            close();
            return true;
        } catch (TagNotFoundException e) {
            Log.e("NfcEETerminal", "resolveActivationConflict TagNotFoundException occurred.", e);
            i++;
        } catch (IOException e2) {
        } catch (InterruptedException e3) {
        } catch (InvalidTLVException e4) {
        } catch (Throwable th) {
            close();
            throw th;
        }
    }

    public boolean deactivateCard(String str) {
        try {
            open();
            if (!ByteArray.equals(transmit(APDUConstants.SELECT_CRS).getStatus(), ScResponse.STATUS_OK)) {
                close();
                return false;
            }
            ScResponse transmit = transmit(TerminalUtils.buildSetStatusApdu(str, false).toBytes());
            if (ByteArray.equals(transmit.getStatus(), ScResponse.STATUS_OK) || ByteArray.equals(transmit.getStatus(), ScResponse.STATUS_OPERATION_FAILED)) {
                Log.d("NfcEETerminal", "deactivateCard appAid:" + str + " success");
                close();
                return true;
            }
            close();
            return false;
        } catch (IOException e) {
            Log.e("NfcEETerminal", "failed to deactivate card, aid = ".concat(String.valueOf(str)), e);
        } catch (InterruptedException e2) {
            Log.e("NfcEETerminal", "deactivate card is interrupted, aid: ".concat(String.valueOf(str)), e2);
            Thread.currentThread().interrupt();
        } catch (Throwable th) {
            close();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void readSEInfo() throws IOException, InterruptedException {
        if (ByteArray.equals(transmit(APDUConstants.SELECT_ISD).getStatus(), ScResponse.STATUS_OK)) {
            ScResponse transmit = transmit(APDUConstants.GET_SEID);
            if (ByteArray.equals(transmit.getStatus(), ScResponse.STATUS_OK)) {
                byte[] bytes = transmit.getData().toBytes();
                if (bytes == null || bytes.length < 45) {
                    throw new NfcEeIOException("data too small returned from se when getting cplc");
                }
                int i = bytes[2] & 255;
                byte[] bArr = new byte[i];
                System.arraycopy(bytes, 3, bArr, 0, i);
                this.mCPLC = Coder.bytesToHexString(bArr);
                PrefUtils.putString(this.mContext, getPrefKey("key_cplc"), this.mCPLC);
                this.mSeid = Coder.encodeMD5(bArr) + this.mCPLC.substring(24, 36);
                PrefUtils.putString(this.mContext, getPrefKey("key_seid"), this.mSeid);
                byte[] bArr2 = new byte[10];
                System.arraycopy(bArr, i - 4, bArr2, 0, 4);
                System.arraycopy(bytes, 15, bArr2, 4, 6);
                this.mCIN = Coder.bytesToHexString(bArr2);
                PrefUtils.putString(this.mContext, getPrefKey("key_cin"), this.mCIN);
                return;
            }
        }
        throw new NfcEeIOException("failed to read se info");
    }

    protected static byte[] appendResponse(byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3 = new byte[(bArr.length + i)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, i);
        return bArr3;
    }
}
