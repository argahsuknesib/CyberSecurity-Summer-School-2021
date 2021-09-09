package com.tiqiaa.database;

import _m_j.bdf;
import _m_j.bpu;
import _m_j.bpw;
import _m_j.bpx;
import _m_j.bqe;
import _m_j.bqf;
import android.content.Context;
import android.database.Cursor;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.tiqiaa.icontrol.util.LogUtil;
import com.tiqiaa.remote.entity.Brand;
import com.tiqiaa.remote.entity.Infrared;
import com.tiqiaa.remote.entity.Key;
import com.tiqiaa.remote.entity.MatchKey;
import com.tiqiaa.remote.entity.Remote;
import com.tiqiaa.remote.entity.Room;
import com.tiqiaa.tv.entity.ChannelNum;
import com.tiqiaa.tv.entity.City;
import com.tiqiaa.tv.entity.CityProvider;
import com.tiqiaa.tv.entity.Province;
import com.tiqiaa.tv.entity.TvChannel;
import com.tiqiaa.tv.entity.TvForenotice;
import com.tiqiaa.tv.entity.TvProvider;
import com.tiqiaa.tv.entity.TvShow;
import com.tiqiaa.tv.entity.TvShowImg;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBaseManager {
    public static Context context;
    private static DbUtils db;
    private static String dbPath;

    public static void init(Context context2) {
        context = context2;
        installDB();
        dbPath = context.getDatabasePath("tv.db").getAbsolutePath();
        DbUtils O000000o2 = DbUtils.O000000o(context, dbPath, 9, new DbUtils.O000000o() {
            /* class com.tiqiaa.database.DataBaseManager.AnonymousClass1 */

            public void onUpgrade(DbUtils dbUtils, int i, int i2) {
                LogUtil.e("DataBaseManager", "db upgrade from verion " + i + " to " + i2);
                if (i < 9) {
                    DataBaseManager.copyUpdDB();
                    Context context = DataBaseManager.context;
                    DbUtils O000000o2 = DbUtils.O000000o(context, context.getDatabasePath("tv_upd.db").getAbsolutePath(), i2, null);
                    try {
                        dbUtils.O000000o("DROP TABLE tb_city_provider");
                        dbUtils.O000000o("DROP TABLE tb_province");
                        List O000000o3 = O000000o2.O000000o(CityProvider.class);
                        List O000000o4 = O000000o2.O000000o(Province.class);
                        List O000000o5 = O000000o2.O000000o(City.class);
                        dbUtils.O00000Oo((List<?>) O000000o3);
                        dbUtils.O00000Oo((List<?>) O000000o4);
                        dbUtils.O000000o((List<?>) O000000o5);
                        DataBaseManager.deleteUpdDb();
                    } catch (Exception e) {
                        LogUtil.e("DataBaseManager", "update db failed!".concat(String.valueOf(e)));
                    }
                }
            }
        });
        db = O000000o2;
        O000000o2.O00000Oo = true;
    }

    static class Singlenton {
        private static DataBaseManager instance = new DataBaseManager();

        private Singlenton() {
        }

        public static DataBaseManager getInstance() {
            return instance;
        }
    }

    public static DataBaseManager getInstance() {
        return Singlenton.getInstance();
    }

    private static void installDB() {
        FileOutputStream fileOutputStream;
        try {
            byte[] bArr = new byte[256];
            File file = new File(context.getDatabasePath("tv.db").getAbsolutePath());
            if (!file.exists()) {
                File file2 = new File(file.getParent());
                if ((file2.exists() || file2.mkdirs()) && file.createNewFile()) {
                    Throwable th = null;
                    try {
                        InputStream resourceAsStream = DataBaseManager.class.getResourceAsStream("tv.db");
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            while (true) {
                                int read = resourceAsStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            if (resourceAsStream != null) {
                                resourceAsStream.close();
                            }
                        } catch (Throwable th2) {
                            if (th == null) {
                                th = th2;
                            } else if (th != th2) {
                                th.addSuppressed(th2);
                            }
                            if (resourceAsStream != null) {
                                resourceAsStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (th != null) {
                            if (th != th) {
                                th.addSuppressed(th);
                            }
                            th = th;
                        }
                        throw th;
                    }
                }
            }
        } catch (IOException e) {
            LogUtil.e("DataBaseManager", "install db file failed!");
            e.printStackTrace();
        }
    }

    public static void copyUpdDB() {
        FileOutputStream fileOutputStream;
        try {
            byte[] bArr = new byte[256];
            File file = new File(context.getDatabasePath("tv_upd.db").getAbsolutePath());
            if (!file.exists() || file.delete()) {
                File file2 = new File(file.getParent());
                if ((file2.exists() || file2.mkdirs()) && file.createNewFile()) {
                    Throwable th = null;
                    try {
                        InputStream resourceAsStream = DataBaseManager.class.getResourceAsStream("tv.db");
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            while (true) {
                                int read = resourceAsStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.close();
                            if (resourceAsStream != null) {
                                resourceAsStream.close();
                            }
                        } catch (Throwable th2) {
                            if (th == null) {
                                th = th2;
                            } else if (th != th2) {
                                th.addSuppressed(th2);
                            }
                            if (resourceAsStream != null) {
                                resourceAsStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (th != null) {
                            if (th != th) {
                                th.addSuppressed(th);
                            }
                            th = th;
                        }
                        throw th;
                    }
                }
            }
        } catch (IOException e) {
            LogUtil.e("DataBaseManager", "install db file failed!");
            e.printStackTrace();
        }
    }

    public static void deleteUpdDb() {
        File file = new File(context.getDatabasePath("tv_upd.db").getAbsolutePath());
        if (!file.exists() || !file.delete()) {
        }
    }

    public List<Province> getProvinces() {
        try {
            return db.O000000o(Province.class);
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "get provinces error");
            e.printStackTrace();
            return null;
        }
    }

    public List<City> getCities() {
        try {
            return db.O000000o(City.class);
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "get cities error");
            e.printStackTrace();
            return null;
        }
    }

    public List<City> getProvinceCities(int i) {
        try {
            bpu O000000o2 = bpu.O000000o(City.class);
            O000000o2.O000000o(bpx.O000000o("province_id", "=", Integer.valueOf(i)));
            return db.O00000Oo(O000000o2);
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "get cities error");
            e.printStackTrace();
            return null;
        }
    }

    public List<TvProvider> getProvidersFromCity(int i) {
        try {
            bpu O000000o2 = bpu.O000000o(CityProvider.class);
            O000000o2.O000000o(bpx.O000000o("city_id", "=", Integer.valueOf(i)));
            List<CityProvider> O00000Oo = db.O00000Oo(O000000o2);
            ArrayList arrayList = new ArrayList();
            for (CityProvider provider_id : O00000Oo) {
                arrayList.add(getTvProvidersById(provider_id.getProvider_id()));
            }
            return arrayList;
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "get cities error");
            e.printStackTrace();
            return null;
        }
    }

    public TvProvider getTvProvidersById(int i) {
        try {
            return (TvProvider) db.O000000o(TvProvider.class, Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveTvForenotice(TvForenotice tvForenotice) {
        try {
            db.O00000Oo(tvForenotice);
            if (tvForenotice.getTvshow_img() != null) {
                getInstance().saveShowImg(tvForenotice.getTvshow_img());
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                db.O000000o(tvForenotice, "playDate");
            } catch (DbException e2) {
                e2.printStackTrace();
            }
        }
    }

    public List<TvForenotice> getCachedTvForenotices(String str) {
        try {
            bpu O000000o2 = bpu.O000000o(TvForenotice.class);
            O000000o2.O000000o(bpx.O000000o("playDate", "=", str));
            O000000o2.O00000Oo(bpx.O000000o("type", "=", "0"));
            return db.O00000Oo(O000000o2);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("DataBaseManager", "getCachedTvForenotices failed!");
            return null;
        }
    }

    public List<ChannelNum> getChannelNums() {
        try {
            return db.O000000o(ChannelNum.class);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("DataBaseManager", "getChannelNums from db failed!");
            return null;
        }
    }

    public List<TvForenotice> getAllCachedTvForenotices() {
        try {
            return db.O000000o(TvForenotice.class);
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "getAllCachedTvForenotices error:" + e.getLocalizedMessage());
            return null;
        }
    }

    public List<TvForenotice> getCachedTvForenotices(String str, int i) {
        try {
            bpu O000000o2 = bpu.O000000o(TvForenotice.class);
            O000000o2.O000000o(bpx.O000000o("playDate", "=", str));
            O000000o2.O00000Oo(bpx.O000000o("channel_id", "=", Integer.valueOf(i)));
            return db.O00000Oo(O000000o2);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("DataBaseManager", "getCachedTvForenotices failed!");
            return null;
        }
    }

    public List<TvForenotice> getAppointedForenotices() {
        try {
            bpu O000000o2 = bpu.O000000o(TvForenotice.class);
            O000000o2.O000000o(bpx.O000000o("type", "=", 1));
            return db.O00000Oo(O000000o2);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("DataBaseManager", "getCachedTvForenotices failed!");
            return null;
        }
    }

    public void saveOrUpdateTvForenotice(TvForenotice tvForenotice) {
        try {
            db.O00000Oo(tvForenotice);
            db.O00000Oo(tvForenotice);
            if (tvForenotice.getTvshow_img() != null) {
                getInstance().saveShowImg(tvForenotice.getTvshow_img());
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("DataBaseManager", "save tvforenotice failed, try update!");
            try {
                db.O000000o(tvForenotice, "type");
                db.O00000Oo(tvForenotice);
                if (tvForenotice.getTvshow_img() != null) {
                    getInstance().saveShowImg(tvForenotice.getTvshow_img());
                }
            } catch (Exception unused) {
                e.printStackTrace();
                LogUtil.e("DataBaseManager", "saveOrUpdateTvForenotice failed!");
            }
        }
    }

    public void deleteTvForenotice(TvForenotice tvForenotice) {
        try {
            tvForenotice.setType(0);
            db.O000000o(tvForenotice, "type");
        } catch (Exception unused) {
            LogUtil.e("DataBaseManager", "deleteTvForenotice failed!");
        }
    }

    public void saveTvshow(TvShow tvShow) {
        try {
            db.O00000Oo(tvShow);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("DataBaseManager", "save tvshow failed!");
        }
    }

    public List<TvShow> getAllSavedTvShows() {
        try {
            return db.O000000o(TvShow.class);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("DataBaseManager", "getAllSavedTvShows");
            return null;
        }
    }

    public List<TvShow> getAllFavoriteTvShows() {
        try {
            bpu O000000o2 = bpu.O000000o(TvShow.class);
            O000000o2.O000000o(bpx.O000000o("type", "=", 1));
            return db.O00000Oo(O000000o2);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("DataBaseManager", "getAllSavedTvShows");
            return null;
        }
    }

    public TvShow getSavedTvShowById(int i) {
        try {
            return (TvShow) db.O000000o(TvShow.class, Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveOrUpdateTvshow(TvShow tvShow) {
        try {
            db.O00000Oo(tvShow);
        } catch (Exception e) {
            try {
                db.O000000o(tvShow, "type");
            } catch (Exception unused) {
                e.printStackTrace();
                LogUtil.e("DataBaseManager", "saveOrUpdateTvshow tvshow failed!");
            }
        }
    }

    public List<TvForenotice> findTvForenoticeByshowid(int i) {
        try {
            bpu O000000o2 = bpu.O000000o(TvForenotice.class);
            O000000o2.O000000o(bpx.O000000o("fid2", "=", Integer.valueOf(i)));
            O000000o2.O00000o0(bpx.O000000o("fid2", "=", 0).O00000Oo("fid", "=", Integer.valueOf(i)));
            return db.O00000Oo(O000000o2);
        } catch (Exception unused) {
            LogUtil.e("DataBaseManager", "findTvForenoticeByshowid failed!");
            return null;
        }
    }

    public List<Room> getAllRooms() {
        try {
            return db.O000000o(Room.class);
        } catch (Exception e) {
            LogUtil.printException(e);
            return null;
        }
    }

    public List<Remote> getAllRemotesInRoom(Room room) {
        List<String> remote_ids;
        if (room == null || (remote_ids = room.getRemote_ids()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String remoteById : remote_ids) {
            Remote remoteById2 = getRemoteById(remoteById);
            if (remoteById2 != null) {
                arrayList.add(remoteById2);
            }
        }
        room.setRemotes(arrayList);
        return arrayList;
    }

    public Remote getRemoteById(String str) {
        try {
            Remote remote = (Remote) db.O000000o(Remote.class, str);
            fillRemoteData(remote);
            return remote;
        } catch (Exception e) {
            LogUtil.printException(e);
            return null;
        }
    }

    private void fillRemoteData(Remote remote) {
        remote.setBrand(getBrandById(remote.getBrand_id()));
        List<Key> keysByRemoteId = getKeysByRemoteId(remote.getId());
        if (keysByRemoteId != null) {
            for (Key next : keysByRemoteId) {
                next.setInfrareds(getInfraredsByKeyId(next.getId()));
            }
            remote.setKeys(keysByRemoteId);
        }
    }

    public Brand getBrandById(long j) {
        try {
            return (Brand) db.O000000o(Brand.class, Long.valueOf(j));
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "获取brand失败");
            LogUtil.printException(e);
            return null;
        }
    }

    public List<Remote> getAllRemotes() {
        try {
            List<Remote> O000000o2 = db.O000000o(Remote.class);
            if (O000000o2 != null && O000000o2.size() > 0) {
                for (Remote fillRemoteData : O000000o2) {
                    fillRemoteData(fillRemoteData);
                }
            }
            return O000000o2;
        } catch (Exception unused) {
            return null;
        }
    }

    public List<Remote> getRemotesByType(int i) {
        try {
            bpu O000000o2 = bpu.O000000o(Remote.class);
            O000000o2.O000000o(bpx.O000000o("type", "=", Integer.valueOf(i)));
            List<Remote> O00000Oo = db.O00000Oo(O000000o2);
            if (O00000Oo != null && O00000Oo.size() > 0) {
                for (Remote fillRemoteData : O00000Oo) {
                    fillRemoteData(fillRemoteData);
                }
            }
            return O00000Oo;
        } catch (Exception unused) {
            return null;
        }
    }

    public List<Infrared> getAllInfrareds() {
        try {
            return db.O000000o(Infrared.class);
        } catch (Exception e) {
            LogUtil.printException(e);
            return null;
        }
    }

    public boolean saveRemote(Remote remote) {
        try {
            db.O00000Oo(remote);
            List<Key> keys = remote.getKeys();
            if (keys == null) {
                return true;
            }
            saveOrUpdateAllKeys(keys);
            for (Key next : keys) {
                List<Infrared> infrareds = next.getInfrareds();
                List<Infrared> infraredsByKeyId = getInfraredsByKeyId(next.getId());
                if ((infraredsByKeyId == null || infraredsByKeyId.size() == 0) && infrareds != null) {
                    saveAllInfrareds(infrareds);
                }
            }
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    private void saveOrUpdateAllKeys(List<Key> list) {
        DbUtils dbUtils;
        try {
            db.O00000Oo((List<?>) list);
        } catch (Exception e) {
            LogUtil.printException(e);
            try {
                dbUtils = db;
                String[] strArr = {"remoteId"};
                if (list != null && list.size() != 0 && dbUtils.O00000Oo(list.get(0).getClass())) {
                    dbUtils.O000000o();
                    for (Key O000000o2 : list) {
                        dbUtils.O000000o(bpw.O000000o(dbUtils, O000000o2, strArr));
                    }
                    dbUtils.O00000Oo();
                    dbUtils.O00000o0();
                }
            } catch (Exception e2) {
                LogUtil.printException(e2);
            }
        } catch (Throwable th) {
            dbUtils.O00000o0();
            throw th;
        }
    }

    private void saveAllInfrareds(List<Infrared> list) {
        try {
            db.O00000Oo((List<?>) list);
        } catch (Exception e) {
            LogUtil.printException(e);
        }
    }

    public boolean saveInfrared(Infrared infrared) {
        try {
            db.O00000Oo(infrared);
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public boolean saveOrUpdateRoom(Room room) {
        try {
            room.setRemote_ids_json(bdf.O000000o(room.getRemote_ids()));
            db.O000000o(room);
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public void updateRoomRemotes(Room room) {
        try {
            room.setRemote_ids_json(bdf.O000000o(room.getRemote_ids()));
            db.O000000o(room, "remote_ids_json");
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "更新房间中遥控器数据失败");
            LogUtil.printException(e);
        }
    }

    public boolean deleteRemote(Remote remote) {
        try {
            db.O00000o0(remote);
            delKeysByRemoteId(remote.getId());
            List<Key> keys = remote.getKeys();
            if (keys == null) {
                return true;
            }
            for (Key id : keys) {
                delInfraredsByKeyId(id.getId());
            }
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public boolean deleteRemoteById(String str) {
        try {
            Remote remoteById = getRemoteById(str);
            if (remoteById == null) {
                return true;
            }
            deleteRemote(remoteById);
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public boolean saveOrUpdateRemote(Remote remote) {
        try {
            db.O000000o(remote);
            List<Key> keys = remote.getKeys();
            if (keys == null) {
                return true;
            }
            for (Key next : keys) {
                db.O000000o(next);
                List<Infrared> infrareds = next.getInfrareds();
                delInfraredsByKeyId(next.getId());
                if (infrareds != null) {
                    for (Infrared O000000o2 : infrareds) {
                        db.O000000o(O000000o2);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public List<Key> getKeysByRemoteId(String str) {
        try {
            bpu O000000o2 = bpu.O000000o(Key.class);
            O000000o2.O000000o(bpx.O000000o("remoteId", "=", str));
            return db.O00000Oo(O000000o2);
        } catch (Exception e) {
            LogUtil.printException(e);
            return null;
        }
    }

    public List<Infrared> getInfraredsByKeyId(long j) {
        try {
            bpu O000000o2 = bpu.O000000o(Infrared.class);
            O000000o2.O000000o(bpx.O000000o("keyId", "=", Long.valueOf(j)));
            return db.O00000Oo(O000000o2);
        } catch (Exception e) {
            LogUtil.printException(e);
            return null;
        }
    }

    public void delKeysByRemoteId(String str) {
        try {
            db.O00000o0((List<?>) getKeysByRemoteId(str));
        } catch (Exception e) {
            LogUtil.printException(e);
        }
    }

    public void delInfraredsByKeyId(long j) {
        try {
            db.O00000o0((List<?>) getInfraredsByKeyId(j));
        } catch (Exception e) {
            LogUtil.printException(e);
        }
    }

    public boolean saveRoom(Room room) {
        try {
            room.setRemote_ids_json(bdf.O000000o(room.getRemote_ids()));
            db.O00000Oo(room);
            if (room.getRemotes() == null || room.getRemotes().size() <= 0) {
                return true;
            }
            for (Remote saveOrUpdateRemote : room.getRemotes()) {
                saveOrUpdateRemote(saveOrUpdateRemote);
            }
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public boolean deleteRoom(Room room) {
        try {
            db.O00000o0(room);
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public void refreshRemoteInDB(String str, Remote remote) {
        try {
            saveRemote(remote);
            List<Room> allRooms = getAllRooms();
            if (allRooms == null) {
                return;
            }
            if (allRooms.size() != 0) {
                for (Room next : allRooms) {
                    if (next.getRemote_ids().contains(str)) {
                        next.getRemote_ids().remove(str);
                        next.getRemote_ids().add(remote.getId());
                    }
                    updateRoomRemotes(next);
                }
            }
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "刷新遥控器数据失败...");
            LogUtil.printException(e);
        }
    }

    public void deleteOverdueCachedForenotice(long j) {
        try {
            db.O000000o((Class<?>) TvForenotice.class, bpx.O000000o("cacheDate", "<", Long.valueOf(new Date().getTime() - j)).O00000Oo("type", "!=", 1));
        } catch (Exception e) {
            LogUtil.printException(e);
        }
    }

    public void deleteOverdueCachedTvShow(long j) {
        try {
            db.O000000o((Class<?>) TvShow.class, bpx.O000000o("cacheDate", "<", Long.valueOf(new Date().getTime() - j)).O00000Oo("type", "!=", 1));
        } catch (Exception e) {
            LogUtil.printException(e);
        }
    }

    public void deleteOverdueAppointedForenotice() {
        try {
            Date date = new Date();
            bpu O000000o2 = bpu.O000000o(TvForenotice.class);
            O000000o2.O000000o(bpx.O000000o("pt", "<", date).O00000Oo("type", "=", "1"));
            List<TvForenotice> O00000Oo = db.O00000Oo(O000000o2);
            if (O00000Oo != null) {
                db.O00000o0((List<?>) O00000Oo);
                ArrayList arrayList = new ArrayList();
                for (TvForenotice tvForenotice : O00000Oo) {
                    if (tvForenotice.getTvshow_img() != null) {
                        arrayList.add(tvForenotice.getTvshow_img());
                    }
                }
                if (arrayList.size() > 0) {
                    db.O00000o0((List<?>) arrayList);
                }
            }
        } catch (Exception e) {
            LogUtil.printException(e);
        }
    }

    public void updateMatchKeyTable(List<MatchKey> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    dropMatchKey();
                    db.O00000Oo((List<?>) list);
                    context.getSharedPreferences("match_key_update_date", 0).edit().putString("lastUpDateDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date())).commit();
                }
            } catch (Exception e) {
                LogUtil.e("DataBaseManager", "更新遥控器匹配序列表失败。。。");
                LogUtil.printException(e);
            }
        }
    }

    public List<MatchKey> getMatchKeyByType(int i) {
        try {
            bpu O000000o2 = bpu.O000000o(MatchKey.class);
            O000000o2.O000000o(bpx.O000000o("appliance_type", "=", Integer.valueOf(i)));
            return db.O00000Oo(O000000o2);
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "获取匹配按键失败。");
            LogUtil.printException(e);
            return null;
        }
    }

    public boolean dropMatchKey() {
        try {
            db.O000000o((Class<?>) MatchKey.class, (bpx) null);
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public boolean dropBrands() {
        try {
            db.O000000o((Class<?>) Brand.class, (bpx) null);
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public boolean dropProvinces() {
        try {
            db.O000000o((Class<?>) Province.class, (bpx) null);
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public boolean dropCities() {
        try {
            db.O000000o((Class<?>) City.class, (bpx) null);
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public boolean dropProviders() {
        try {
            db.O000000o((Class<?>) TvProvider.class, (bpx) null);
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public boolean dropCityProviders() {
        try {
            DbUtils dbUtils = db;
            Class<CityProvider> cls = CityProvider.class;
            if (!dbUtils.O00000Oo((Class<?>) cls)) {
                return true;
            }
            dbUtils.O000000o("DROP TABLE ".concat(String.valueOf(bqf.O000000o(cls))));
            bqe.O00000Oo(dbUtils, cls);
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public void saveBrands(List<Brand> list) {
        if (list != null) {
            try {
                db.O000000o((List<?>) list);
            } catch (Exception e) {
                LogUtil.printException(e);
            }
        }
    }

    public boolean saveBrand(Brand brand) {
        try {
            db.O00000Oo(brand);
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public List<Brand> getBrands() {
        try {
            return db.O000000o(Brand.class);
        } catch (Exception e) {
            LogUtil.printException(e);
            return null;
        }
    }

    public boolean saveShowImg(TvShowImg tvShowImg) {
        try {
            db.O00000Oo(tvShowImg);
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public TvShowImg getTvShowImgByshowId(int i) {
        try {
            bpu O000000o2 = bpu.O000000o(TvShowImg.class);
            O000000o2.O000000o(bpx.O000000o("tvshow_id", "=", Integer.valueOf(i)));
            List O00000Oo = db.O00000Oo(O000000o2);
            if (O00000Oo == null || O00000Oo.size() <= 0) {
                return null;
            }
            return (TvShowImg) O00000Oo.get(0);
        } catch (Exception e) {
            LogUtil.printException(e);
            return null;
        }
    }

    public boolean saveCities(List<City> list) {
        try {
            db.O00000Oo((List<?>) list);
            return true;
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "刷新城市表失败");
            LogUtil.printException(e);
            return true;
        }
    }

    public boolean saveProviders(List<TvProvider> list) {
        try {
            db.O00000Oo((List<?>) list);
            return true;
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "刷新运营商表失败");
            LogUtil.printException(e);
            return true;
        }
    }

    public boolean saveProvince(List<Province> list) {
        try {
            db.O00000Oo((List<?>) list);
            return true;
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "刷新省份表失败");
            LogUtil.printException(e);
            return true;
        }
    }

    public boolean saveCityProviders(List<CityProvider> list) {
        try {
            db.O00000Oo((List<?>) list);
            return true;
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "城市运营商映射表失败");
            LogUtil.printException(e);
            return true;
        }
    }

    public boolean saveAllTvChannels(List<TvChannel> list) {
        try {
            db.O00000Oo((List<?>) list);
            return true;
        } catch (Exception e) {
            LogUtil.printException(e);
            return false;
        }
    }

    public TvChannel getChannelById(int i) {
        try {
            return (TvChannel) db.O000000o(TvChannel.class, Integer.valueOf(i));
        } catch (Exception e) {
            LogUtil.printException(e);
            return null;
        }
    }

    public <T> List<T> getAllRecords(bpu bpu) {
        try {
            return db.O00000Oo(bpu);
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "getAllRecords failed!".concat(String.valueOf(e)));
            return null;
        }
    }

    public City getCityByName(String str) {
        try {
            Cursor O00000Oo = db.O00000Oo("SELECT * FROM tb_city WHERE length(trim(city_name))>0 AND '" + str + "' LIKE trim(city_name) || '%';");
            if (O00000Oo == null || O00000Oo.getCount() <= 0) {
                O00000Oo.close();
                return null;
            }
            O00000Oo.moveToFirst();
            City city = new City();
            city.setCity_id(O00000Oo.getInt(O00000Oo.getColumnIndex("city_id")));
            city.setCity_name(O00000Oo.getString(O00000Oo.getColumnIndex("city_name")));
            city.setId(O00000Oo.getInt(O00000Oo.getColumnIndex("id")));
            city.setProvince_id(O00000Oo.getInt(O00000Oo.getColumnIndex("province_id")));
            O00000Oo.close();
            return city;
        } catch (DbException unused) {
            return null;
        }
    }

    public Province getProvinceByName(String str) {
        try {
            Cursor O00000Oo = db.O00000Oo("SELECT * FROM tb_province WHERE length(trim(province_name))>0 AND '" + str + "' LIKE trim(province_name) || '%';");
            if (O00000Oo == null || O00000Oo.getCount() <= 0) {
                O00000Oo.close();
                return null;
            }
            O00000Oo.moveToFirst();
            Province province = new Province();
            province.setProvince_name(O00000Oo.getString(O00000Oo.getColumnIndex("province_name")));
            province.setId(O00000Oo.getInt(O00000Oo.getColumnIndex("id")));
            province.setProvince_id(O00000Oo.getInt(O00000Oo.getColumnIndex("province_id")));
            O00000Oo.close();
            return province;
        } catch (DbException unused) {
            return null;
        }
    }

    public Cursor execQuery(String str) {
        try {
            return db.O00000Oo(str);
        } catch (DbException unused) {
            return null;
        }
    }

    public void saveOrUpdataAll(List<Brand> list) {
        db.O00000Oo = true;
        beginTransaction();
        try {
            db.O000000o((List<?>) list);
        } catch (DbException e) {
            e.printStackTrace();
        }
        endTransaction();
    }

    public void beginTransaction() {
        try {
            Method declaredMethod = DbUtils.class.getDeclaredMethod("beginTransaction", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(db, new Object[0]);
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "beginTransaction got an exception!" + e.getClass());
            e.printStackTrace();
        }
    }

    public void endTransaction() {
        Class<DbUtils> cls = DbUtils.class;
        try {
            Method declaredMethod = cls.getDeclaredMethod("setTransactionSuccessful", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(db, new Object[0]);
            Method declaredMethod2 = cls.getDeclaredMethod("endTransaction", new Class[0]);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(db, new Object[0]);
        } catch (Exception e) {
            LogUtil.e("DataBaseManager", "endTransaction got an exception!" + e.getClass());
            e.printStackTrace();
        }
    }
}
