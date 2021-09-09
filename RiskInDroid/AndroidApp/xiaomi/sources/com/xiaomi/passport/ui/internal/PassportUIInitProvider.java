package com.xiaomi.passport.ui.internal;

import _m_j.egt;
import _m_j.ixe;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;
import com.xiaomi.accountsdk.service.UnifiedDeviceInfoFetcherImpl;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016JK\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0016J9\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PassportUIInitProvider;", "Landroid/content/ContentProvider;", "()V", "delete", "", "uri", "Landroid/net/Uri;", "selection", "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class PassportUIInitProvider extends ContentProvider {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f6253O000000o = new O000000o((byte) 0);
    private static final String O00000Oo = PassportUIInitProvider.class.getSimpleName();

    public final int delete(Uri uri, String str, String[] strArr) {
        ixe.O00000o0(uri, "uri");
        return 0;
    }

    public final String getType(Uri uri) {
        ixe.O00000o0(uri, "uri");
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        ixe.O00000o0(uri, "uri");
        return null;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        ixe.O00000o0(uri, "uri");
        return null;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        ixe.O00000o0(uri, "uri");
        return 0;
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PassportUIInitProvider$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.content.Context, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil$GlobalConfig, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final boolean onCreate() {
        try {
            egt egt = egt.f15254O000000o;
            Context context = getContext();
            ixe.O000000o((Object) context, "context");
            egt.O000000o(context);
            HashedDeviceIdUtil.GlobalConfig instance = HashedDeviceIdUtil.GlobalConfig.getInstance();
            ixe.O000000o((Object) instance, "HashedDeviceIdUtil.GlobalConfig.getInstance()");
            instance.setUnifiedDeviceIdFetcher(new UnifiedDeviceInfoFetcherImpl());
            return false;
        } catch (Exception e) {
            Throwable th = e;
            Log.i(O00000Oo, "Failed to auto initialize the PassportUI SDK", th);
            throw th;
        }
    }
}
