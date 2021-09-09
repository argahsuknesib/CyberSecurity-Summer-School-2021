package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import java.io.ByteArrayOutputStream;

public final class WXMediaMessage {
    public String description;
    public IMediaObject mediaObject;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public int sdkVer;
    public byte[] thumbData;
    public String title;

    public static class Builder {
        public static WXMediaMessage fromBundle(Bundle bundle) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
            wXMediaMessage.title = bundle.getString("_wxobject_title");
            wXMediaMessage.description = bundle.getString("_wxobject_description");
            wXMediaMessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
            wXMediaMessage.mediaTagName = bundle.getString("_wxobject_mediatagname");
            wXMediaMessage.messageAction = bundle.getString("_wxobject_message_action");
            wXMediaMessage.messageExt = bundle.getString("_wxobject_message_ext");
            String pathOldToNew = pathOldToNew(bundle.getString("_wxobject_identifier_"));
            if (pathOldToNew != null && pathOldToNew.length() > 0) {
                try {
                    wXMediaMessage.mediaObject = (IMediaObject) Class.forName(pathOldToNew).newInstance();
                    wXMediaMessage.mediaObject.unserialize(bundle);
                    return wXMediaMessage;
                } catch (Exception e) {
                    Log.e("MicroMsg.SDK.WXMediaMessage", "get media object from bundle failed: unknown ident " + pathOldToNew + ", ex = " + e.getMessage());
                }
            }
            return wXMediaMessage;
        }

        private static String pathNewToOld(String str) {
            if (str != null && str.length() != 0) {
                return str.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
            }
            Log.e("MicroMsg.SDK.WXMediaMessage", "pathNewToOld fail, newPath is null");
            return str;
        }

        private static String pathOldToNew(String str) {
            Log.i("MicroMsg.SDK.WXMediaMessage", "pathOldToNew, oldPath = ".concat(String.valueOf(str)));
            if (str == null || str.length() == 0) {
                Log.e("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, oldPath is null");
                return str;
            }
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf == -1) {
                Log.e("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, invalid pos, oldPath = ".concat(String.valueOf(str)));
                return str;
            }
            return "com.tencent.mm.opensdk.modelmsg" + str.substring(lastIndexOf);
        }

        public static Bundle toBundle(WXMediaMessage wXMediaMessage) {
            Bundle bundle = new Bundle();
            bundle.putInt("_wxobject_sdkVer", wXMediaMessage.sdkVer);
            bundle.putString("_wxobject_title", wXMediaMessage.title);
            bundle.putString("_wxobject_description", wXMediaMessage.description);
            bundle.putByteArray("_wxobject_thumbdata", wXMediaMessage.thumbData);
            if (wXMediaMessage.mediaObject != null) {
                bundle.putString("_wxobject_identifier_", pathNewToOld(wXMediaMessage.mediaObject.getClass().getName()));
                wXMediaMessage.mediaObject.serialize(bundle);
            }
            bundle.putString("_wxobject_mediatagname", wXMediaMessage.mediaTagName);
            bundle.putString("_wxobject_message_action", wXMediaMessage.messageAction);
            bundle.putString("_wxobject_message_ext", wXMediaMessage.messageExt);
            return bundle;
        }
    }

    public interface IMediaObject {
        boolean checkArgs();

        void serialize(Bundle bundle);

        int type();

        void unserialize(Bundle bundle);
    }

    public WXMediaMessage() {
        this(null);
    }

    public WXMediaMessage(IMediaObject iMediaObject) {
        this.mediaObject = iMediaObject;
    }

    /* access modifiers changed from: package-private */
    public final boolean checkArgs() {
        String str;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        if (getType() == 8 && ((bArr3 = this.thumbData) == null || bArr3.length == 0)) {
            str = "checkArgs fail, thumbData should not be null when send emoji";
        } else if (getType() == 36 && ((bArr2 = this.thumbData) == null || bArr2.length > 131072)) {
            str = "checkArgs fail, thumbData should not be null or exceed 128kb";
        } else if (getType() == 36 || (bArr = this.thumbData) == null || bArr.length <= 32768) {
            String str2 = this.title;
            if (str2 == null || str2.length() <= 512) {
                String str3 = this.description;
                if (str3 != null && str3.length() > 1024) {
                    str = "checkArgs fail, description is invalid";
                } else if (this.mediaObject == null) {
                    str = "checkArgs fail, mediaObject is null";
                } else {
                    String str4 = this.mediaTagName;
                    if (str4 == null || str4.length() <= 64) {
                        String str5 = this.messageAction;
                        if (str5 == null || str5.length() <= 2048) {
                            String str6 = this.messageExt;
                            if (str6 == null || str6.length() <= 2048) {
                                return this.mediaObject.checkArgs();
                            }
                            str = "checkArgs fail, messageExt is too long";
                        } else {
                            str = "checkArgs fail, messageAction is too long";
                        }
                    } else {
                        str = "checkArgs fail, mediaTagName is too long";
                    }
                }
            } else {
                str = "checkArgs fail, title is invalid";
            }
        } else {
            str = "checkArgs fail, thumbData is invalid";
        }
        Log.e("MicroMsg.SDK.WXMediaMessage", str);
        return false;
    }

    public final int getType() {
        IMediaObject iMediaObject = this.mediaObject;
        if (iMediaObject == null) {
            return 0;
        }
        return iMediaObject.type();
    }

    public final void setThumbImage(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXMediaMessage", "setThumbImage exception:" + e.getMessage());
        }
    }
}
