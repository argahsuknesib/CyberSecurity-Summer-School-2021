package com.xiaomi.smarthome.uwb.mico;

import _m_j.gsy;
import _m_j.iwb;
import _m_j.ixe;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.smarthome.library.log.LogType;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0007\n\u0000\n\u0000*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "com/xiaomi/smarthome/uwb/mico/UwbMicoPlayerViewModel$mMicoBaseActionImpl$2$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class UwbMicoPlayerViewModel$mMicoBaseActionImpl$2 extends Lambda implements iwb<AnonymousClass1> {
    public static final UwbMicoPlayerViewModel$mMicoBaseActionImpl$2 INSTANCE = new UwbMicoPlayerViewModel$mMicoBaseActionImpl$2();

    UwbMicoPlayerViewModel$mMicoBaseActionImpl$2() {
        super(0);
    }

    public final AnonymousClass1 invoke() {
        return new MicoBaseAction() {
            /* class com.xiaomi.smarthome.uwb.mico.UwbMicoPlayerViewModel$mMicoBaseActionImpl$2.AnonymousClass1 */

            public final void playOrPause(boolean z) {
                Class<?> cls;
                Class<?> cls2;
                StringBuilder sb = new StringBuilder("playOrPause: ");
                MicoBaseAction mBaseControlChannel = UwbMicoPlayerManager.INSTANCE.getMBaseControlChannel();
                String str = null;
                sb.append((Object) ((mBaseControlChannel == null || (cls2 = mBaseControlChannel.getClass()) == null) ? null : cls2.getSimpleName()));
                sb.append(" play == ");
                sb.append(z);
                ToastUtil.showToastDebug(sb.toString());
                LogType logType = LogType.LOG_UWB;
                StringBuilder sb2 = new StringBuilder("playOrPause: ");
                MicoBaseAction mBaseControlChannel2 = UwbMicoPlayerManager.INSTANCE.getMBaseControlChannel();
                if (!(mBaseControlChannel2 == null || (cls = mBaseControlChannel2.getClass()) == null)) {
                    str = cls.getSimpleName();
                }
                sb2.append((Object) str);
                sb2.append(" play == ");
                sb2.append(z);
                gsy.O000000o(logType, "", 4, "zxtUwbMicoPlayerViewModel", sb2.toString());
                MicoBaseAction mBaseControlChannel3 = UwbMicoPlayerManager.INSTANCE.getMBaseControlChannel();
                if (mBaseControlChannel3 != null) {
                    mBaseControlChannel3.playOrPause(z);
                }
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
             arg types: [java.lang.String, java.lang.String]
             candidates:
              _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
              _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
              _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
              _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
            public final void prev() {
                Class<?> cls;
                Class<?> cls2;
                MicoBaseAction mBaseControlChannel = UwbMicoPlayerManager.INSTANCE.getMBaseControlChannel();
                String str = null;
                ToastUtil.showToastDebug(ixe.O000000o("prev ", (Object) ((mBaseControlChannel == null || (cls2 = mBaseControlChannel.getClass()) == null) ? null : cls2.getSimpleName())));
                LogType logType = LogType.LOG_UWB;
                MicoBaseAction mBaseControlChannel2 = UwbMicoPlayerManager.INSTANCE.getMBaseControlChannel();
                if (!(mBaseControlChannel2 == null || (cls = mBaseControlChannel2.getClass()) == null)) {
                    str = cls.getSimpleName();
                }
                gsy.O000000o(logType, "", 4, "zxtUwbMicoPlayerViewModel", ixe.O000000o("prev ", (Object) str));
                MicoBaseAction mBaseControlChannel3 = UwbMicoPlayerManager.INSTANCE.getMBaseControlChannel();
                if (mBaseControlChannel3 != null) {
                    mBaseControlChannel3.prev();
                }
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
             arg types: [java.lang.String, java.lang.String]
             candidates:
              _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
              _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
              _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
              _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
            public final void next() {
                Class<?> cls;
                Class<?> cls2;
                MicoBaseAction mBaseControlChannel = UwbMicoPlayerManager.INSTANCE.getMBaseControlChannel();
                String str = null;
                ToastUtil.showToastDebug(ixe.O000000o("next ", (Object) ((mBaseControlChannel == null || (cls2 = mBaseControlChannel.getClass()) == null) ? null : cls2.getSimpleName())));
                LogType logType = LogType.LOG_UWB;
                MicoBaseAction mBaseControlChannel2 = UwbMicoPlayerManager.INSTANCE.getMBaseControlChannel();
                if (!(mBaseControlChannel2 == null || (cls = mBaseControlChannel2.getClass()) == null)) {
                    str = cls.getSimpleName();
                }
                gsy.O000000o(logType, "", 4, "zxtUwbMicoPlayerViewModel", ixe.O000000o("next ", (Object) str));
                MicoBaseAction mBaseControlChannel3 = UwbMicoPlayerManager.INSTANCE.getMBaseControlChannel();
                if (mBaseControlChannel3 != null) {
                    mBaseControlChannel3.next();
                }
            }

            public final void modifyVolumeByValue(int i) {
                Class<?> cls;
                Class<?> cls2;
                StringBuilder sb = new StringBuilder("modifyVolume: ");
                MicoBaseAction mBaseControlChannel = UwbMicoPlayerManager.INSTANCE.getMBaseControlChannel();
                String str = null;
                sb.append((Object) ((mBaseControlChannel == null || (cls2 = mBaseControlChannel.getClass()) == null) ? null : cls2.getSimpleName()));
                sb.append(' ');
                sb.append(i);
                ToastUtil.showToastDebug(sb.toString());
                LogType logType = LogType.LOG_UWB;
                StringBuilder sb2 = new StringBuilder("modifyVolume: ");
                MicoBaseAction mBaseControlChannel2 = UwbMicoPlayerManager.INSTANCE.getMBaseControlChannel();
                if (!(mBaseControlChannel2 == null || (cls = mBaseControlChannel2.getClass()) == null)) {
                    str = cls.getSimpleName();
                }
                sb2.append((Object) str);
                sb2.append(' ');
                sb2.append(i);
                gsy.O000000o(logType, "", 4, "zxtUwbMicoPlayerViewModel", sb2.toString());
                MicoBaseAction mBaseControlChannel3 = UwbMicoPlayerManager.INSTANCE.getMBaseControlChannel();
                if (mBaseControlChannel3 != null) {
                    mBaseControlChannel3.modifyVolumeByValue(i);
                }
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
             arg types: [java.lang.String, java.lang.String]
             candidates:
              _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
              _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
              _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
              _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
            public final void seek(long j) {
                Class<?> cls;
                Class<?> cls2;
                MicoBaseAction mSeekControlChannel = UwbMicoPlayerManager.INSTANCE.getMSeekControlChannel();
                String str = null;
                ToastUtil.showToastDebug(ixe.O000000o("seek: ", (Object) ((mSeekControlChannel == null || (cls2 = mSeekControlChannel.getClass()) == null) ? null : cls2.getSimpleName())));
                LogType logType = LogType.LOG_UWB;
                MicoBaseAction mSeekControlChannel2 = UwbMicoPlayerManager.INSTANCE.getMSeekControlChannel();
                if (!(mSeekControlChannel2 == null || (cls = mSeekControlChannel2.getClass()) == null)) {
                    str = cls.getSimpleName();
                }
                gsy.O000000o(logType, "", 4, "zxtUwbMicoPlayerViewModel", ixe.O000000o("seek: ", (Object) str));
                MicoBaseAction mSeekControlChannel3 = UwbMicoPlayerManager.INSTANCE.getMSeekControlChannel();
                if (mSeekControlChannel3 != null) {
                    mSeekControlChannel3.seek(j);
                }
            }
        };
    }
}
