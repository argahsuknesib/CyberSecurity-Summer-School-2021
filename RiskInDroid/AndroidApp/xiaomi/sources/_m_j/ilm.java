package _m_j;

import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.model.album.Announcer;
import com.ximalaya.ting.android.opensdk.model.live.program.Program;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.live.schedule.Schedule;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public final class ilm {

    /* renamed from: O000000o  reason: collision with root package name */
    static SimpleDateFormat f1445O000000o = new SimpleDateFormat("yy:MM:dd:HH:mm");

    public static Track O000000o(Radio radio) {
        if (radio == null) {
            return null;
        }
        Track track = new Track();
        track.f12166O000000o = radio.f12166O000000o;
        track.O00000Oo = "radio";
        track.O0000Oo0 = radio.O0000OOo;
        track.O0000Oo = radio.O0000Oo0;
        track.O000O00o = radio.O0000Oo;
        track.O000OO0o = radio.O0000o00;
        track.O000OO = radio.O0000o0;
        track.O000OOOo = radio.O0000o0O;
        track.O000OOo0 = radio.O0000o0o;
        track.O0000o0O = radio.O0000o;
        track.O0000o00 = radio.O0000oO;
        track.O0000OoO = radio.O0000oO0;
        track.O0000oo0 = radio.O0000oOo;
        track.O0000o0O = radio.O0000o;
        track.O0000OOo = true;
        try {
            track.O00oOooO = f1445O000000o.format(new Date(radio.O0000OoO));
            track.O00oOooo = f1445O000000o.format(new Date(radio.O0000Ooo));
        } catch (Exception unused) {
        }
        track.O000O0oo = radio.O0000oo;
        return track;
    }

    public static Radio O000000o(Track track) {
        if (track == null) {
            return null;
        }
        Radio radio = new Radio();
        radio.f12166O000000o = track.f12166O000000o;
        radio.O00000Oo = "radio";
        radio.O0000OOo = track.O0000Oo0;
        radio.O0000Oo = track.O000O00o;
        radio.O0000o00 = track.O000OO0o;
        radio.O0000o0 = track.O000OO;
        radio.O0000o0O = track.O000OOOo;
        radio.O0000o0o = track.O000OOo0;
        radio.O0000o = track.O0000o0O;
        radio.O0000oO0 = track.O0000OoO;
        radio.O0000oO = track.O0000o00;
        radio.O0000oOo = track.O0000oo0;
        radio.O0000o = track.O0000o0O;
        radio.O0000Oo0 = track.O0000Oo;
        radio.O0000oo0 = track.O0000OOo;
        try {
            radio.O0000OoO = f1445O000000o.parse(track.O00oOooO).getTime();
            radio.O0000Ooo = f1445O000000o.parse(track.O00oOooo).getTime();
        } catch (Exception unused) {
        }
        radio.O0000oo = track.O000O0oo;
        return radio;
    }

    public static Schedule O00000Oo(Track track) {
        String str;
        String str2;
        ijs ijs = null;
        if (track == null) {
            return null;
        }
        Schedule schedule = new Schedule();
        schedule.f12166O000000o = track.f12166O000000o;
        schedule.O00000Oo = "schedule";
        schedule.O0000OOo = track.O00oOooO;
        schedule.O0000Oo0 = track.O00oOooo;
        schedule.O0000OoO = track.O0000oo0;
        if (TextUtils.isEmpty(track.O0000o)) {
            str = track.O0000o0o;
        } else {
            str = track.O0000o;
        }
        schedule.O0000Ooo = str;
        Program program = new Program();
        program.f12177O000000o = track.O000O0OO;
        program.O00000Oo = track.O0000Oo0;
        if (TextUtils.isEmpty(track.O0000OoO)) {
            str2 = track.O0000o00;
        } else {
            str2 = track.O0000OoO;
        }
        program.O00000o0 = str2;
        program.O00000oO = track.O000OO0o;
        program.O0000O0o = track.O000OOOo;
        program.O00000oo = track.O000OO;
        program.O0000OOo = track.O000OOo0;
        Announcer O000000o2 = track.O000000o();
        if (O000000o2 != null) {
            ijs = new ijs();
            ijs.f1375O000000o = O000000o2.f12171O000000o;
            ijs.O00000Oo = O000000o2.O00000Oo;
            ijs.O00000o0 = O000000o2.O00000o0;
        }
        if (ijs != null) {
            program.O0000Oo0 = new ArrayList(Arrays.asList(ijs));
        }
        schedule.O0000Oo = program;
        schedule.O0000o00 = track.O000O0Oo;
        schedule.O0000o0 = track.O000OO00;
        schedule.O0000o0O = track.O0000o0O;
        return schedule;
    }
}
