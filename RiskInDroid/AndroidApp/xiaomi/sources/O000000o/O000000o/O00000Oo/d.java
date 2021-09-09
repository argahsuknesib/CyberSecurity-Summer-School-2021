package O000000o.O000000o.O00000Oo;

import _m_j.O00O00o0;
import _m_j.O00o0;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.hannto.print.bean.PhotoBean;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class d {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Uri f381O000000o = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    public HashMap<String, ArrayList<PhotoBean>> O00000Oo = new HashMap<>();
    public ArrayList<PhotoBean> O00000o = new ArrayList<>();
    public ArrayList<PhotoBean> O00000o0 = new ArrayList<>();
    public List<O00O00o0> O00000oO = new ArrayList();
    public boolean O00000oo = false;
    public SimpleDateFormat O0000O0o;
    public Thread O0000OOo;
    public int O0000Oo = 1;
    public a O0000Oo0 = a.Single;
    public O000000o O0000OoO;

    public interface O000000o {
        void a();

        void a(String str);
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final d f382O000000o = new d();
    }

    public enum a {
        Single,
        Multiple
    }

    public /* synthetic */ d() {
        this.O0000O0o = _m_j.O00000Oo.O000000o() ? new SimpleDateFormat("yyyy年MM月dd日") : new SimpleDateFormat("yyyy,MMM,dd", Locale.ENGLISH);
    }

    public static d O000000o() {
        return O00000Oo.f382O000000o;
    }

    private void O00000Oo() {
        List<O00O00o0> list;
        try {
            if (this.O00000Oo.size() != 0) {
                for (Map.Entry next : this.O00000Oo.entrySet()) {
                    O00O00o0 o00O00o0 = new O00O00o0();
                    String str = (String) next.getKey();
                    ArrayList<PhotoBean> arrayList = (ArrayList) next.getValue();
                    if (!(arrayList == null || arrayList.size() == 0)) {
                        o00O00o0.O00000Oo = str;
                        boolean z = false;
                        o00O00o0.O00000o0 = arrayList.get(0).counts;
                        arrayList.get(1);
                        o00O00o0.f6625O000000o = arrayList.get(1).imageUri;
                        o00O00o0.O00000o = arrayList;
                        if ("Camera".equals(str)) {
                            if (this.O00000oo) {
                                o00O00o0.O00000o.add(1, new PhotoBean());
                            }
                            list = this.O00000oO;
                        } else if (!"WeiXin".equals(str)) {
                            this.O00000oO.add(o00O00o0);
                        } else if (this.O00000oO.size() <= 0 || !"Camera".equals(this.O00000oO.get(0).O00000Oo)) {
                            list = this.O00000oO;
                        } else {
                            list = this.O00000oO;
                            z = true;
                        }
                        list.add(z, o00O00o0);
                    }
                }
                Collections.sort(this.O00000oO, new O00o0());
                if (this.O0000OoO != null) {
                    this.O0000OoO.a();
                }
            } else if (this.O0000OoO != null) {
                this.O0000OoO.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
            O000000o o000000o = this.O0000OoO;
            if (o000000o != null) {
                o000000o.a(e.getMessage());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a5, code lost:
        if (r10.startsWith(r0) != false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c5, code lost:
        if (r10.startsWith(r0) != false) goto L_0x00c7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0124 A[Catch:{ Exception -> 0x01b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0164 A[Catch:{ Exception -> 0x01b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0170  */
    public static /* synthetic */ void O000000o(d dVar, Context context) {
        String str;
        long j;
        boolean z;
        boolean z2;
        String str2;
        try {
            String substring = dVar.O0000O0o.format(new Date()).substring(0, 5);
            Cursor query = context.getContentResolver().query(f381O000000o, null, "(mime_type=? or mime_type=? or mime_type=?) and _size>0", new String[]{"image/jpeg", "image/jpg", "image/png"}, "date_modified DESC");
            if (query != null && query.getCount() != 0) {
                String str3 = null;
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("_data"));
                    int i = query.getInt(query.getColumnIndex("_size"));
                    String string2 = query.getString(query.getColumnIndexOrThrow("_id"));
                    if (!TextUtils.isEmpty(string)) {
                        String path = Uri.parse(string).getPath();
                        Uri withAppendedPath = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, string2);
                        if (!TextUtils.isEmpty(path)) {
                            File file = new File(path);
                            if (file.exists()) {
                                String name = file.getParentFile().getName();
                                if ("Camera".equals(name)) {
                                    j = query.getLong(query.getColumnIndex("datetaken"));
                                    str = dVar.O0000O0o.format(new Date(j));
                                } else {
                                    j = query.getLong(query.getColumnIndex("date_modified"));
                                    str = dVar.O0000O0o.format(new Date(1000 * j));
                                }
                                str = str.substring(5);
                                ArrayList arrayList = dVar.O00000Oo.get(name);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    dVar.O00000Oo.put(name, arrayList);
                                }
                                PhotoBean photoBean = new PhotoBean(false, "");
                                photoBean.imagePath = path;
                                photoBean.imageUri = withAppendedPath;
                                photoBean.mLastModifyTimeStampt = j;
                                photoBean.size = i;
                                SimpleDateFormat simpleDateFormat = dVar.O0000O0o;
                                try {
                                    Calendar instance = Calendar.getInstance();
                                    instance.setTime(new Date(System.currentTimeMillis()));
                                    Calendar calendar = simpleDateFormat.getCalendar();
                                    if (calendar.get(1) == instance.get(1) && calendar.get(6) - instance.get(6) == 0) {
                                        z = true;
                                        if (z) {
                                            str = _m_j.O00000Oo.O000000o() ? "今天" : "Today";
                                        }
                                        SimpleDateFormat simpleDateFormat2 = dVar.O0000O0o;
                                        Calendar instance2 = Calendar.getInstance();
                                        instance2.setTime(new Date(System.currentTimeMillis()));
                                        Calendar calendar2 = simpleDateFormat2.getCalendar();
                                        if (calendar2.get(1) == instance2.get(1) && calendar2.get(6) - instance2.get(6) == -1) {
                                            z2 = true;
                                            str2 = z2 ? _m_j.O00000Oo.O000000o() ? "昨天" : "Yesterday" : str;
                                            photoBean.time = str2;
                                            if (arrayList.size() == 0 || !str2.equals(str3)) {
                                                PhotoBean photoBean2 = new PhotoBean(true, str2);
                                                photoBean2.time = str2;
                                                arrayList.add(photoBean2);
                                            }
                                            photoBean.position = arrayList.size();
                                            arrayList.add(photoBean);
                                            ((PhotoBean) arrayList.get(0)).counts++;
                                            str3 = str2;
                                        }
                                        z2 = false;
                                        if (z2) {
                                        }
                                        photoBean.time = str2;
                                        PhotoBean photoBean22 = new PhotoBean(true, str2);
                                        photoBean22.time = str2;
                                        arrayList.add(photoBean22);
                                        photoBean.position = arrayList.size();
                                        arrayList.add(photoBean);
                                        ((PhotoBean) arrayList.get(0)).counts++;
                                        str3 = str2;
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                z = false;
                                if (z) {
                                }
                                SimpleDateFormat simpleDateFormat22 = dVar.O0000O0o;
                                try {
                                    Calendar instance22 = Calendar.getInstance();
                                    instance22.setTime(new Date(System.currentTimeMillis()));
                                    Calendar calendar22 = simpleDateFormat22.getCalendar();
                                    z2 = true;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                                if (z2) {
                                }
                                photoBean.time = str2;
                                PhotoBean photoBean222 = new PhotoBean(true, str2);
                                photoBean222.time = str2;
                                arrayList.add(photoBean222);
                                photoBean.position = arrayList.size();
                                arrayList.add(photoBean);
                                ((PhotoBean) arrayList.get(0)).counts++;
                                str3 = str2;
                            }
                        }
                    }
                }
                query.close();
                dVar.O00000Oo();
            } else if (dVar.O0000OoO != null) {
                dVar.O0000OoO.a();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            O000000o o000000o = dVar.O0000OoO;
            if (o000000o != null) {
                o000000o.a(e3.getMessage());
            }
        }
    }
}
