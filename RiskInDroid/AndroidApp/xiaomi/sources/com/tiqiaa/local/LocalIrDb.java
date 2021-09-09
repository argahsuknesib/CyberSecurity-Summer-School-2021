package com.tiqiaa.local;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tiqiaa.icontrol.util.LanguageUtils;
import com.tiqiaa.icontrol.util.PhoneHelper;
import com.tiqiaa.icontrol.util.StringUtil;
import com.tiqiaa.remote.entity.AirMode;
import com.tiqiaa.remote.entity.Brand;
import com.tiqiaa.remote.entity.Infrared;
import com.tiqiaa.remote.entity.IrMatchMark;
import com.tiqiaa.remote.entity.IrMatchPageInfo;
import com.tiqiaa.remote.entity.Key;
import com.tiqiaa.remote.entity.MatchPage;
import com.tiqiaa.remote.entity.Page;
import com.tiqiaa.remote.entity.Remote;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public final class LocalIrDb {
    private static LocalIrDb irDb;
    private final Context mContext;
    private final String path;
    private long prevBrandId = -1;
    private int prevMachineType = -1;
    private String prevResultString = "";
    private int prevSearchCount;
    private String prevSearchString = "";

    public static class PhysicalRemoteMatchResult {
        public List<String> ids;
        public int total_count;
    }

    public static class SearchCount {
        public int count;
        public int degree;
    }

    private native DbRemote[] fetchMatchRemotes(int i, int i2);

    private native DbRemote fetchRemote(String str, long j, int i);

    private native DbBrand[] getBrandListByMachineType(int i, int i2);

    private native void initSdk(Context context, String str, int i);

    private native boolean initSdk2(Context context, String str, String str2);

    private native void irdbClose();

    private native DbInfrared irdbGetAirCode(int i, int i2, int i3, int i4, byte[] bArr);

    private native DbIrKey[] irdbGetTestKeys(String str);

    private native int irdbInitKeyMatch(int i, int i2, long j, int[] iArr, int[] iArr2, int i3, int i4);

    private native int irdbInitKeywordSearch(int i, int i2, long j, String[] strArr, int i3);

    private native boolean irdbOpen(Context context, String str);

    private native String[] irdbPhysicalRemoteMatch(int i, int i2, long j, long j2, int[] iArr, String[] strArr);

    public static native long nextId();

    private native DbRemote nsadl(String str, long j, int i);

    private native DbRemote[] nsali(long j);

    public final native String[] getAirIRPNameAndRemotes(byte[] bArr, long j);

    public final native int getAirRemoteModeMask(String str);

    public final native long getBrandId(String str);

    public final native String getIRMarkData(byte[] bArr, int i);

    public final native String getIRPName(byte[] bArr, int i);

    public final native boolean isAirRemoteSinglePower(String str);

    public final native boolean isa();

    public static synchronized LocalIrDb getIrDb(Context context) {
        LocalIrDb localIrDb;
        synchronized (LocalIrDb.class) {
            if (irDb == null) {
                irDb = new LocalIrDb(context);
            }
            irDb.open();
            localIrDb = irDb;
        }
        return localIrDb;
    }

    private LocalIrDb(Context context) {
        String str;
        this.mContext = context.getApplicationContext();
        try {
            str = String.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).applicationInfo.dataDir) + "/.irdb.db";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str = null;
        }
        this.path = str;
    }

    public final boolean isa(String str) {
        return initSdk2(this.mContext, this.path, str);
    }

    public final void initSdk(String str, int i, int i2) {
        initSdk(this.mContext, str, (i & 65535) | ((i2 & 65535) << 16));
        open();
    }

    public final boolean open() {
        return irdbOpen(this.mContext, this.path);
    }

    public final void close() {
        resetSearchResult();
        irdbClose();
    }

    static final class DbBrand {
        String brand_cn = "";
        String brand_en = "";
        long brand_id;
        String brand_pinyin = "";
        String brand_tw = "";
        String remarks = "";

        private DbBrand(long j, String str, String str2, String str3, String str4, String str5) {
            this.brand_id = j;
            if (str != null) {
                this.brand_cn = str;
            }
            if (str2 != null) {
                this.brand_en = str2;
            }
            if (str3 != null) {
                this.brand_tw = str3;
            }
            if (str4 != null) {
                this.brand_pinyin = str4;
            }
            if (str5 != null) {
                this.remarks = str5;
            }
        }

        /* access modifiers changed from: package-private */
        public final Brand toBrand() {
            Brand brand = new Brand();
            brand.setId(this.brand_id);
            brand.setBrand_cn(this.brand_cn);
            brand.setBrand_en(this.brand_en);
            brand.setBrand_tw(this.brand_tw);
            brand.setPinyin(this.brand_pinyin);
            brand.setRemarks(this.remarks);
            return brand;
        }
    }

    static final class DbInfrared {
        int freq = 0;
        int functionType;
        byte[] infaredValue;
        int ir_mark = 0;
        int mark = 0;
        int priority = 0;
        int quality = 0;

        private DbInfrared(int i, int i2, int i3, byte[] bArr, int i4, int i5) {
            this.mark = i;
            this.freq = i2;
            this.functionType = i3;
            this.infaredValue = bArr;
            this.priority = i4;
            this.ir_mark = i5;
        }

        /* access modifiers changed from: package-private */
        public final Infrared toInfrared(long j, int i) {
            Infrared infrared = new Infrared();
            infrared.setId(LocalIrDb.nextId());
            infrared.setKey_id(j);
            infrared.setKey_type(i);
            infrared.setFunc(this.functionType);
            infrared.setData(this.infaredValue);
            int i2 = this.freq;
            if (i2 == 0) {
                i2 = 38000;
            }
            infrared.setFreq(i2);
            infrared.setMark(this.mark);
            infrared.setIr_mark(this.ir_mark);
            infrared.setQuality(this.quality);
            infrared.setPriority(this.priority);
            return infrared;
        }
    }

    static final class DbIrKey {
        DbInfrared[] irList;
        int keyType;
        String name = "";
        int protocol = 0;

        private DbIrKey(int i, String str, DbInfrared[] dbInfraredArr, int i2) {
            this.keyType = i;
            if (str != null) {
                this.name = str;
            }
            this.irList = dbInfraredArr;
            this.protocol = i2;
        }

        /* access modifiers changed from: package-private */
        public final Key toKey(String str, long j, int i) {
            Key key = new Key();
            key.setId(j);
            key.setName(this.name);
            key.setType(i);
            key.setRemote_id(str);
            key.setProtocol(this.protocol);
            return key;
        }
    }

    static final class DbRemote {
        long author_id = 1;
        DbBrand brand;
        long brand_id = 0;
        String id;
        DbIrKey[] keyList;
        int langauge = 0;
        int layout_id = 0;
        int machineType = -1;
        String model = "";
        int usedTimes = 0;
        String version = "86";

        private DbRemote(String str, int i, DbIrKey[] dbIrKeyArr) {
            this.id = str;
            this.usedTimes = i;
            this.keyList = dbIrKeyArr;
        }

        private DbRemote(String str, int i, int i2, int i3, int i4, String str2, DbBrand dbBrand, DbIrKey[] dbIrKeyArr) {
            this.id = str;
            this.machineType = i;
            this.layout_id = i2;
            this.langauge = i3;
            this.usedTimes = i4;
            if (str2 != null) {
                this.model = str2;
            }
            this.brand = dbBrand;
            this.keyList = dbIrKeyArr;
        }

        /* access modifiers changed from: package-private */
        public final Remote toRemote() {
            Remote remote = new Remote();
            remote.setId(this.id);
            remote.setType(this.machineType);
            remote.setBrand_id(this.brand_id);
            remote.setModel(this.model);
            remote.setAuthor_id(this.author_id);
            remote.setLayout_id(this.layout_id);
            remote.setApp_ver(this.version);
            remote.setLang(this.langauge);
            remote.setDownload_count(this.usedTimes);
            DbBrand dbBrand = this.brand;
            if (dbBrand != null) {
                Brand brand2 = dbBrand.toBrand();
                remote.setBrand_id(brand2.getId());
                remote.setBrand(brand2);
            }
            return remote;
        }
    }

    private static String[] splitKeyword(String str) {
        List<String> div_word;
        if (str == null || str.length() == 0 || (div_word = StringUtil.div_word(str)) == null || div_word.size() == 0) {
            return null;
        }
        String[] strArr = (String[]) div_word.toArray(new String[0]);
        Locale locale = Locale.getDefault();
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = strArr[i].toUpperCase(locale);
        }
        return strArr;
    }

    public final Remote downloadReomte(String str, long j) {
        long nextId;
        if (str == null || str.length() == 0) {
            return null;
        }
        int lang = LanguageUtils.getLang();
        DbRemote fetchRemote = fetchRemote(str, j, lang);
        if (fetchRemote == null) {
            fetchRemote = nsadl(str, j, lang);
        }
        if (fetchRemote == null) {
            return null;
        }
        Remote remote = fetchRemote.toRemote();
        DbIrKey[] dbIrKeyArr = fetchRemote.keyList;
        ArrayList arrayList = new ArrayList();
        if (dbIrKeyArr == null || dbIrKeyArr.length == 0) {
            remote.setKeys(arrayList);
            return remote;
        }
        HashSet hashSet = new HashSet();
        for (DbIrKey dbIrKey : dbIrKeyArr) {
            do {
                nextId = nextId();
            } while (hashSet.contains(Long.valueOf(nextId)));
            hashSet.add(Long.valueOf(nextId));
            int i = dbIrKey.keyType;
            Key key = dbIrKey.toKey(str, nextId, i);
            DbInfrared[] dbInfraredArr = dbIrKey.irList;
            ArrayList arrayList2 = new ArrayList();
            if (dbInfraredArr != null) {
                for (DbInfrared infrared : dbInfraredArr) {
                    arrayList2.add(infrared.toInfrared(nextId, i));
                }
            } else if (remote.getType() == 2) {
                key.getProtocol();
            }
            key.setInfrareds(arrayList2);
            arrayList.add(key);
        }
        remote.setKeys(arrayList);
        return remote;
    }

    private List<Remote> getMatchRemotes(int i, int i2, boolean z) {
        return convertMatchRemotes(fetchMatchRemotes(i, i2), z);
    }

    private List<Remote> convertMatchRemotes(DbRemote[] dbRemoteArr, boolean z) {
        DbRemote[] dbRemoteArr2 = dbRemoteArr;
        ArrayList arrayList = new ArrayList();
        if (dbRemoteArr2 == null || dbRemoteArr2.length == 0) {
            return arrayList;
        }
        for (DbRemote dbRemote : dbRemoteArr2) {
            if (dbRemote != null) {
                Remote remote = dbRemote.toRemote();
                if (!z) {
                    arrayList.add(remote);
                } else {
                    String str = dbRemote.id;
                    DbIrKey[] dbIrKeyArr = dbRemote.keyList;
                    ArrayList arrayList2 = new ArrayList();
                    if (dbIrKeyArr == null || dbIrKeyArr.length == 0) {
                        remote.setKeys(arrayList2);
                        arrayList.add(remote);
                    } else {
                        for (DbIrKey dbIrKey : dbIrKeyArr) {
                            long nextId = nextId();
                            int i = dbIrKey.keyType;
                            Key key = dbIrKey.toKey(str, nextId, i);
                            arrayList2.add(key);
                            DbInfrared[] dbInfraredArr = dbIrKey.irList;
                            ArrayList arrayList3 = new ArrayList();
                            if (dbInfraredArr != null) {
                                for (DbInfrared infrared : dbInfraredArr) {
                                    arrayList3.add(infrared.toInfrared(nextId, i));
                                }
                            }
                            key.setInfrareds(arrayList3);
                        }
                        remote.setKeys(arrayList2);
                        arrayList.add(remote);
                    }
                }
            }
        }
        return arrayList;
    }

    private static int[] copyMarks(List<MatchPage.IRMark> list) {
        if (list != null && !list.isEmpty()) {
            int[] iArr = new int[(list.size() * 2)];
            int i = 0;
            for (MatchPage.IRMark next : list) {
                int ir_mark = next.getIr_mark();
                if (ir_mark != 0) {
                    int i2 = i + 1;
                    iArr[i] = next.getKey_type();
                    i = i2 + 1;
                    iArr[i2] = ir_mark;
                }
            }
            if (i > 0) {
                int[] iArr2 = new int[i];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                return iArr2;
            }
        }
        return null;
    }

    private int prepareMatch(MatchPage matchPage, boolean z) {
        int irdbInitKeyMatch = irdbInitKeyMatch(matchPage.getAppliance_type(), matchPage.getLang(), matchPage.getBrand_id(), copyMarks(matchPage.getOkMarks()), copyMarks(matchPage.getWrongMarks()), matchPage.getNext_key(), ((z || !PhoneHelper.checkNet()) ? 0 : 1) << 8);
        resetSearchResult();
        return irdbInitKeyMatch;
    }

    public final List<Remote> matchRemotes(MatchPage matchPage, boolean z) {
        if (matchPage != null && prepareMatch(matchPage, z) > 0) {
            return getMatchRemotes(0, 30, true);
        }
        return null;
    }

    private int prepareSerach(String str, int i, int i2, long j, boolean z, boolean z2) {
        String[] strArr;
        String[] splitKeyword = splitKeyword(str);
        int i3 = 0;
        if (splitKeyword == null || splitKeyword.length <= 0) {
            strArr = splitKeyword;
        } else {
            Arrays.sort(splitKeyword);
            int length = splitKeyword.length;
            String[] strArr2 = new String[(length * 2)];
            Locale locale = Locale.getDefault();
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                String str2 = splitKeyword[i4];
                strArr2[i5] = str2;
                String fullPinYin = StringUtil.getFullPinYin(str2);
                if (fullPinYin != null) {
                    fullPinYin = fullPinYin.trim().toUpperCase(locale);
                }
                if (fullPinYin != null && fullPinYin.length() > 0 && !fullPinYin.equals(str2)) {
                    strArr2[i5 + 1] = fullPinYin;
                }
                i4++;
                i5 += 2;
            }
            strArr = strArr2;
        }
        if (!z2 && PhoneHelper.checkNet()) {
            i3 = 1;
        }
        int i6 = i3 << 8;
        if (z) {
            i6 |= 1;
        }
        return irdbInitKeywordSearch(i, i2, j, strArr, i6);
    }

    private void resetSearchResult() {
        this.prevSearchString = "";
        this.prevResultString = "";
        this.prevSearchCount = 0;
        this.prevMachineType = -1;
        this.prevBrandId = -1;
    }

    public final SearchCount getSearchCount(Page page, boolean z, boolean z2) {
        if (page == null) {
            return null;
        }
        int searchCount0 = getSearchCount0(page, z, z2);
        SearchCount searchCount = new SearchCount();
        searchCount.count = searchCount0;
        String str = this.prevResultString;
        searchCount.degree = str == null ? 0 : str.length();
        return searchCount;
    }

    private int getSearchCount0(Page page, boolean z, boolean z2) {
        int i;
        int i2;
        int prepareSerach;
        if (page == null) {
            return 0;
        }
        String keyword = page.getKeyword();
        int appliance_type = page.getAppliance_type();
        long brand_id = page.getBrand_id();
        if (keyword != null) {
            keyword = keyword.trim().toUpperCase(Locale.getDefault());
            i = keyword.length();
        } else {
            i = 0;
        }
        if (appliance_type == this.prevMachineType && this.prevBrandId == brand_id) {
            if (i == 0) {
                if (this.prevResultString == null) {
                    return this.prevSearchCount;
                }
            } else if (keyword.equals(this.prevSearchString) || keyword.equals(this.prevResultString)) {
                return this.prevSearchCount;
            } else {
                String str = this.prevResultString;
                if (str != null && !str.equals(this.prevSearchString) && keyword.startsWith(this.prevResultString)) {
                    return this.prevSearchCount;
                }
            }
        }
        this.prevSearchString = i > 0 ? keyword : null;
        this.prevMachineType = appliance_type;
        this.prevBrandId = brand_id;
        int lang = page.getLang();
        String str2 = keyword;
        int i3 = i;
        while (true) {
            i2 = i3;
            prepareSerach = prepareSerach(str2, appliance_type, lang, brand_id, z, z2);
            if (prepareSerach != 0 || i2 <= 1) {
                break;
            }
            str2 = str2.substring(0, i2 - 1).trim();
            i3 = str2.length();
            if (i3 == 0) {
                i2 = i3;
                break;
            }
        }
        if (i2 <= 0) {
            str2 = null;
        }
        this.prevResultString = str2;
        this.prevSearchCount = prepareSerach;
        return prepareSerach;
    }

    public final List<Remote> searchReomtes(Page page, boolean z, boolean z2) {
        if (page == null) {
            return null;
        }
        int page2 = page.getPage();
        int searchCount0 = getSearchCount0(page, z, z2);
        if (searchCount0 <= 0 || page2 < 0 || page2 * 30 > searchCount0) {
            return null;
        }
        List<Remote> matchRemotes = getMatchRemotes(page2, 30, true);
        if (matchRemotes.size() < 30) {
            resetSearchResult();
        }
        return matchRemotes;
    }

    public final SearchCount getSearchCount(Page page) {
        return getSearchCount(page, false, false);
    }

    public final SearchCount getSearchCount(Page page, boolean z) {
        return getSearchCount(page, false, z);
    }

    public final List<Remote> searchReomtes(Page page) {
        return searchReomtes(page, false, false);
    }

    public final List<Remote> searchReomtes(Page page, boolean z) {
        return searchReomtes(page, false, z);
    }

    public final int getMatchCount(Page page) {
        return getSearchCount0(page, true, false);
    }

    public final int getMatchCount(Page page, boolean z) {
        return getSearchCount0(page, true, z);
    }

    public final List<Remote> matchReomtes(Page page) {
        return searchReomtes(page, true, false);
    }

    public final List<Remote> matchReomtes(Page page, boolean z) {
        return searchReomtes(page, true, z);
    }

    public final List<Remote> matchRemotes(MatchPage matchPage) {
        return matchRemotes(matchPage, false);
    }

    public final List<Remote> getNoScreenAirRemotes(long j) {
        return convertMatchRemotes(nsali(j), true);
    }

    public final PhysicalRemoteMatchResult physicalRemoteMatch(IrMatchPageInfo irMatchPageInfo) {
        List<IrMatchMark> marks;
        if (irMatchPageInfo == null || (marks = irMatchPageInfo.getMarks()) == null || marks.size() == 0) {
            return null;
        }
        long brand_id = irMatchPageInfo.getBrand_id();
        if (brand_id == 0) {
            return null;
        }
        int size = marks.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            IrMatchMark irMatchMark = marks.get(i2);
            int key_type = irMatchMark.getKey_type();
            String mark = irMatchMark.getMark();
            if (!(mark == null || mark.length() == 0)) {
                iArr[i] = key_type;
                strArr[i] = mark;
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        int[] iArr2 = new int[i];
        String[] strArr2 = new String[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        System.arraycopy(strArr, 0, strArr2, 0, i);
        String[] irdbPhysicalRemoteMatch = irdbPhysicalRemoteMatch(irMatchPageInfo.getAppliance_type(), irMatchPageInfo.getLangue(), 0, brand_id, iArr2, strArr2);
        if (irdbPhysicalRemoteMatch == null || irdbPhysicalRemoteMatch.length == 0) {
            return null;
        }
        int parseInt = Integer.parseInt(irdbPhysicalRemoteMatch[0]);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 1; i3 < irdbPhysicalRemoteMatch.length; i3++) {
            String str = irdbPhysicalRemoteMatch[i3];
            if (str != null) {
                arrayList.add(str);
            }
        }
        PhysicalRemoteMatchResult physicalRemoteMatchResult = new PhysicalRemoteMatchResult();
        physicalRemoteMatchResult.total_count = parseInt;
        physicalRemoteMatchResult.ids = arrayList;
        return physicalRemoteMatchResult;
    }

    public final Infrared getAirCode(int i, int i2, int i3, int i4, byte[] bArr) {
        DbInfrared irdbGetAirCode;
        if (i <= 0 || bArr == null || bArr.length == 0 || (irdbGetAirCode = irdbGetAirCode(i, i2, i3, i4, bArr)) == null) {
            return null;
        }
        return irdbGetAirCode.toInfrared(nextId(), i2);
    }

    public final List<AirMode> getAirRemoteModes(String str) {
        ArrayList arrayList = new ArrayList(5);
        int airRemoteModeMask = getAirRemoteModeMask(str);
        if (airRemoteModeMask > 0) {
            if ((airRemoteModeMask & 1) != 0) {
                arrayList.add(AirMode.AUTO);
            }
            if ((airRemoteModeMask & 2) != 0) {
                arrayList.add(AirMode.WIND);
            }
            if ((airRemoteModeMask & 4) != 0) {
                arrayList.add(AirMode.DRY);
            }
            if ((airRemoteModeMask & 8) != 0) {
                arrayList.add(AirMode.HOT);
            }
            if ((airRemoteModeMask & 16) != 0) {
                arrayList.add(AirMode.COOL);
            }
        }
        return arrayList;
    }

    public final List<Key> getTestKeys(String str) {
        ArrayList arrayList = new ArrayList();
        DbIrKey[] irdbGetTestKeys = irdbGetTestKeys(str);
        if (irdbGetTestKeys == null || irdbGetTestKeys.length == 0) {
            return arrayList;
        }
        for (DbIrKey dbIrKey : irdbGetTestKeys) {
            long nextId = nextId();
            int i = dbIrKey.keyType;
            Key key = dbIrKey.toKey(str, nextId, i);
            arrayList.add(key);
            DbInfrared[] dbInfraredArr = dbIrKey.irList;
            ArrayList arrayList2 = new ArrayList();
            if (dbInfraredArr != null) {
                arrayList2.add(dbInfraredArr[0].toInfrared(nextId, i));
            }
            key.setInfrareds(arrayList2);
        }
        return arrayList;
    }

    public final List<Brand> getBrandListOfMachineType(int i, int i2) {
        DbBrand[] brandListByMachineType = getBrandListByMachineType(i, i2);
        if (brandListByMachineType == null || brandListByMachineType.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DbBrand dbBrand : brandListByMachineType) {
            if (dbBrand != null) {
                arrayList.add(dbBrand.toBrand());
            }
        }
        return arrayList;
    }
}
