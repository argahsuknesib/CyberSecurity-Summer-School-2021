package com.miui.tsmclient.entity;

import android.content.Context;
import android.nfc.Tag;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.NfcA;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.net.TSMAuthManager;
import com.miui.tsmclient.util.LogUtils;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.Coder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MifareTag implements Parcelable {
    public static final Parcelable.Creator<MifareTag> CREATOR = new Parcelable.Creator<MifareTag>() {
        /* class com.miui.tsmclient.entity.MifareTag.AnonymousClass1 */

        public final MifareTag createFromParcel(Parcel parcel) {
            return new MifareTag(parcel);
        }

        public final MifareTag[] newArray(int i) {
            return new MifareTag[i];
        }
    };
    private static final ByteArray DEFAULT_KEYA = ByteArray.wrap(new byte[]{-1, -1, -1, -1, -1, -1});
    private static final ByteArray DEFAULT_KEYB = ByteArray.wrap(new byte[]{-1, -1, -1, -1, -1, -1});
    private static final String DEFAULT_SECTOR_DATA = new String(new char[NotificationCompat.FLAG_HIGH_PRIORITY]).replace("\u0000", "0");
    private String mAtqa;
    private String mBlockContent;
    private List<Integer> mEncryptionSectorsId;
    private String mSak;
    private int mSize;
    private String mUid;

    public int describeContents() {
        return 0;
    }

    public MifareTag() {
        this.mEncryptionSectorsId = new ArrayList();
        this.mAtqa = "0400";
        this.mSak = "08";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mUid);
        parcel.writeString(this.mAtqa);
        parcel.writeString(this.mSak);
        parcel.writeInt(this.mSize);
        parcel.writeString(this.mBlockContent);
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    public void setAtqa(String str) {
        this.mAtqa = str;
    }

    public void setSak(String str) {
        this.mSak = str;
    }

    public void setSize(int i) {
        this.mSize = i;
    }

    public void setBlockContent(String str) {
        this.mBlockContent = str;
    }

    public String getUid() {
        return this.mUid;
    }

    public String getAtqa() {
        return this.mAtqa;
    }

    public String getSak() {
        return this.mSak;
    }

    public int getSize() {
        return this.mSize;
    }

    public String getBlockContent() {
        return this.mBlockContent;
    }

    private void readFromParcel(Parcel parcel) {
        this.mUid = parcel.readString();
        this.mAtqa = parcel.readString();
        this.mSak = parcel.readString();
        this.mSize = parcel.readInt();
        this.mBlockContent = parcel.readString();
    }

    private MifareTag(Parcel parcel) {
        this.mEncryptionSectorsId = new ArrayList();
        readFromParcel(parcel);
    }

    public boolean isIssued(Context context) throws AuthApiException {
        return new TSMAuthManager().checkMifareIssued(context, this);
    }

    public static MifareTag parseTag(Tag tag, int i) throws IOException, AuthApiException {
        NfcA nfcA;
        if (tag == null || (nfcA = NfcA.get(tag)) == null) {
            return null;
        }
        MifareTag mifareTag = new MifareTag();
        mifareTag.setUid(Coder.bytesToHexString(tag.getId()));
        MifareClassic mifareClassic = MifareClassic.get(tag);
        if (mifareClassic != null) {
            LogUtils.d("read a mifare card");
            if (i == 2) {
                mifareTag.setUid(String.valueOf(Coder.bytesToInt(tag.getId())));
                mifareTag.setSak(Coder.bytesToHexString(Coder.shortToByte(nfcA.getSak())));
                mifareTag.setAtqa(Coder.bytesToHexString(nfcA.getAtqa()));
                formatSak(mifareTag);
            }
            readMoreContentForTag(mifareClassic, mifareTag);
        } else {
            LogUtils.d("read a other card");
        }
        return mifareTag;
    }

    private static void formatSak(MifareTag mifareTag) {
        StringBuilder sb = new StringBuilder();
        int parseInt = Integer.parseInt(mifareTag.getSak());
        if (parseInt < 10) {
            sb.append("0");
        }
        sb.append(parseInt);
        mifareTag.setSak(sb.toString());
    }

    public int getEncryptionSectorCount() {
        return this.mEncryptionSectorsId.size();
    }

    private static void readMoreContentForTag(MifareClassic mifareClassic, MifareTag mifareTag) throws IOException, AuthApiException {
        if (mifareClassic != null) {
            mifareTag.setSize(mifareClassic.getSize());
            try {
                mifareClassic.connect();
                int sectorCount = mifareClassic.getSectorCount();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < sectorCount; i++) {
                    boolean processAuthenticate = processAuthenticate(mifareClassic, sb, i, 5, true);
                    if (!processAuthenticate) {
                        processAuthenticate = processAuthenticate(mifareClassic, sb, i, 5, false);
                    }
                    if (!processAuthenticate) {
                        LogUtils.d("encryption sector: ".concat(String.valueOf(i)));
                        sb.append(DEFAULT_SECTOR_DATA);
                        mifareTag.mEncryptionSectorsId.add(Integer.valueOf(i));
                    }
                    LogUtils.v("m1 content: " + sb.toString());
                    mifareTag.setBlockContent(sb.toString());
                }
            } finally {
                try {
                    mifareClassic.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    private static boolean processAuthenticate(MifareClassic mifareClassic, StringBuilder sb, int i, int i2, boolean z) {
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return false;
            }
            try {
                if (authenticateWithRetry(mifareClassic, i, MifareClassic.KEY_DEFAULT, z)) {
                    String readSector = readSector(mifareClassic, i);
                    if (!TextUtils.isEmpty(readSector)) {
                        sb.append(readSector);
                        return true;
                    }
                } else {
                    LogUtils.d("failed to authenticate sector with default isKeyA:".concat(String.valueOf(z)));
                }
            } catch (IOException e) {
                LogUtils.e("error occurred when read mifare sector use isKeyA:".concat(String.valueOf(z)), e);
            }
            i2 = i3;
        }
    }

    private static String readSector(MifareClassic mifareClassic, int i) throws IOException {
        StringBuilder sb = new StringBuilder();
        int i2 = i * 4;
        for (int i3 = i2; i3 < i2 + 4; i3++) {
            byte[] readBlock = mifareClassic.readBlock(i3);
            if (readBlock == null || readBlock.length <= 0) {
                return null;
            }
            sb.append(Coder.bytesToHexString(readBlock));
        }
        return sb.toString();
    }

    private static boolean authenticateWithRetry(MifareClassic mifareClassic, int i, byte[] bArr, boolean z) {
        int i2 = 3;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return false;
            }
            try {
                return authenticate(mifareClassic, i, bArr, z);
            } catch (IOException unused) {
                LogUtils.e("failed to auth sector key, is keyA = ".concat(String.valueOf(z)));
                i2 = i3;
            }
        }
    }

    private static boolean authenticate(MifareClassic mifareClassic, int i, byte[] bArr, boolean z) throws IOException {
        byte[] bArr2 = new byte[12];
        if (z) {
            bArr2[0] = 96;
        } else {
            bArr2[0] = 97;
        }
        bArr2[1] = (byte) mifareClassic.sectorToBlock(i);
        byte[] id = mifareClassic.getTag().getId();
        System.arraycopy(id, id.length - 4, bArr2, 2, 4);
        System.arraycopy(bArr, 0, bArr2, 6, 6);
        try {
            return mifareClassic.transceive(bArr2) != null;
        } catch (Exception unused) {
            throw new IOException("failed to auth sector key");
        }
    }

    private JSONArray buildSectors() {
        if (TextUtils.isEmpty(this.mBlockContent)) {
            return new JSONArray();
        }
        ByteArray wrap = ByteArray.wrap(Coder.hexStringToBytes(this.mBlockContent));
        ArrayList arrayList = new ArrayList(16);
        int i = 0;
        while (i < 16) {
            int i2 = i * 64;
            if (wrap.length() < i2 + 64) {
                break;
            }
            ArrayList arrayList2 = new ArrayList(4);
            ByteArray copy = wrap.copy(i2, 64);
            if (i > 0) {
                ByteArray copy2 = copy.copy(0, 16);
                if (!ByteArray.equals(copy2, Block.BLANK)) {
                    arrayList2.add(new Block(0, copy2.toString()));
                }
            }
            ByteArray copy3 = copy.copy(16, 16);
            if (!ByteArray.equals(copy3, Block.BLANK)) {
                arrayList2.add(new Block(1, copy3.toString()));
            }
            ByteArray copy4 = copy.copy(32, 16);
            if (!ByteArray.equals(copy4, Block.BLANK)) {
                arrayList2.add(new Block(2, copy4.toString()));
            }
            String str = DEFAULT_KEYA.toString() + copy.copy(54, 4).toString() + DEFAULT_KEYB.toString();
            if (!str.equals(Block.BLANK.toString())) {
                arrayList2.add(new Block(3, str));
            }
            if (arrayList2.size() != 0) {
                arrayList.add(new Sector(i, arrayList2));
                i++;
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            jSONArray.put(((Sector) arrayList.get(i3)).serialize());
        }
        return jSONArray;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("atqa", getAtqa());
            jSONObject.put("sak", getSak());
            jSONObject.put("uid", getUid());
            jSONObject.put("size", getSize());
            jSONObject.put("sectors", buildSectors());
        } catch (JSONException unused) {
            LogUtils.e("mifareTag parse failed !");
        }
        return jSONObject.toString();
    }
}
