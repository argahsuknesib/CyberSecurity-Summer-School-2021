package com.xiaomi.mico.music.patchwall.micoselect;

import android.text.TextUtils;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.MiBrain;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection;
import com.xiaomi.mico.music.patchwall.micoselect.model.MicoSelectInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.FuncN;

public class MicoSelectDataHelper {
    ConcurrentHashMap<String, List<ViewSection>> allViewsMap = new ConcurrentHashMap<>();
    List<Observable<?>> firstObservaleMap = new ArrayList();
    List<MicoSelectInfo> mSelectInfos = new ArrayList();
    ConcurrentHashMap<String, List<ViewSection>> qqMusicViewMap = new ConcurrentHashMap<>();
    List<Observable<?>> secondObservaleMap = new ArrayList();
    List<MicoSelectInfo> waitDataSelects = new ArrayList();

    public MicoSelectDataHelper() {
        handleDataAndMerge();
    }

    public synchronized List<ViewSection> handlerQQmusicData(List<PatchWall.Block> list, String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (list != null) {
            Iterator<PatchWall.Block> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PatchWall.Block next = it.next();
                String str2 = next.blockUiType.name;
                if (!"block_grid".equals(str2) && !"block_grid_circle".equals(str2) && !"block_grid_button".equals(str2) && !"block_grid_has_details".equals(str2)) {
                    it.remove();
                } else if (ContainerUtil.isEmpty(next.items)) {
                    it.remove();
                } else if ("block_grid_has_details".equals(str2)) {
                    if (this.qqMusicViewMap.get("qqmusic_recommend") == null) {
                        ViewSection viewSection = new ViewSection();
                        viewSection.view_type = "title";
                        viewSection.title = str;
                        viewSection.titleType = "music";
                        copyOnWriteArrayList.add(viewSection);
                    }
                    ViewSection viewSection2 = new ViewSection();
                    viewSection2.view_type = "qqmusic_rank";
                    viewSection2.block = next;
                    copyOnWriteArrayList.add(viewSection2);
                    this.qqMusicViewMap.put("qqmusic_rank", copyOnWriteArrayList);
                } else {
                    if (this.qqMusicViewMap.get("qqmusic_rank") != null) {
                        for (ViewSection viewSection3 : this.qqMusicViewMap.get("qqmusic_rank")) {
                            if (TextUtils.equals("title", viewSection3.view_type)) {
                                this.qqMusicViewMap.get("qqmusic_rank").remove(viewSection3);
                            }
                        }
                    }
                    ViewSection viewSection4 = new ViewSection();
                    viewSection4.view_type = "title";
                    viewSection4.title = str;
                    viewSection4.titleType = "music";
                    copyOnWriteArrayList.add(viewSection4);
                    sortItems(next.items);
                    ViewSection viewSection5 = new ViewSection();
                    viewSection5.view_type = "qqmusic_recommend";
                    viewSection5.block = next;
                    copyOnWriteArrayList.add(viewSection5);
                    this.qqMusicViewMap.put("qqmusic_recommend", copyOnWriteArrayList);
                }
            }
        }
        generateQQMusicSort();
        return sortFloors();
    }

    private void generateQQMusicSort() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (this.qqMusicViewMap.get("qqmusic_recommend") != null) {
            copyOnWriteArrayList.addAll(this.qqMusicViewMap.get("qqmusic_recommend"));
        }
        if (this.qqMusicViewMap.get("qqmusic_rank") != null) {
            copyOnWriteArrayList.addAll(this.qqMusicViewMap.get("qqmusic_rank"));
        }
        this.allViewsMap.put("music", copyOnWriteArrayList);
    }

    public synchronized List<ViewSection> handlerKidsAndKaishuData(List<PatchWall.Block> list, String str, String str2) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (list != null) {
            Iterator<PatchWall.Block> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PatchWall.Block next = it.next();
                String str3 = next.blockUiType.name;
                if (!"block_grid".equals(str3) && !"block_grid_circle".equals(str3) && !"block_grid_button".equals(str3) && !"block_grid_panel".equals(str3) && !"block_grid_rich".equals(str3)) {
                    it.remove();
                } else if (ContainerUtil.isEmpty(next.items)) {
                    it.remove();
                } else if (!"block_grid_panel".equals(str3)) {
                    if (TextUtils.equals(str2, "kid")) {
                        ViewSection viewSection = new ViewSection();
                        viewSection.view_type = "title";
                        viewSection.title = str;
                        viewSection.titleType = "kid";
                        copyOnWriteArrayList.add(viewSection);
                        sortItems(next.items);
                        ViewSection viewSection2 = new ViewSection();
                        viewSection2.view_type = "kids";
                        viewSection2.block = next;
                        copyOnWriteArrayList.add(viewSection2);
                        this.allViewsMap.put("kid", copyOnWriteArrayList);
                    } else if (TextUtils.equals(str2, "uncleCassie")) {
                        ViewSection viewSection3 = new ViewSection();
                        viewSection3.view_type = "title";
                        viewSection3.title = str;
                        viewSection3.titleType = "uncleCassie";
                        copyOnWriteArrayList.add(viewSection3);
                        ViewSection viewSection4 = new ViewSection();
                        viewSection4.view_type = "uncleCassie";
                        viewSection4.block = next;
                        copyOnWriteArrayList.add(viewSection4);
                        this.allViewsMap.put("uncleCassie", copyOnWriteArrayList);
                    }
                }
            }
        }
        return sortFloors();
    }

    public synchronized List<ViewSection> handlerCommonData(List<PatchWall.Block> list, String str, String str2) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (list != null) {
            Iterator<PatchWall.Block> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PatchWall.Block next = it.next();
                String str3 = next.blockUiType.name;
                if (!"block_grid".equals(str3) && !"block_grid_circle".equals(str3) && !"block_grid_button".equals(str3) && !"block_grid_rich".equals(str3) && !"block_grid_feature".equals(str3)) {
                    it.remove();
                } else if (ContainerUtil.isEmpty(next.items)) {
                    it.remove();
                } else {
                    sortItems(next.items);
                    if (TextUtils.equals(str, "radio")) {
                        ViewSection viewSection = new ViewSection();
                        viewSection.view_type = "title";
                        viewSection.title = str2;
                        viewSection.titleType = "audioBook";
                        copyOnWriteArrayList.add(viewSection);
                        ViewSection viewSection2 = new ViewSection();
                        viewSection2.view_type = "audioBook";
                        viewSection2.block = next;
                        copyOnWriteArrayList.add(viewSection2);
                        this.allViewsMap.put("audioBook", copyOnWriteArrayList);
                    } else if (TextUtils.equals(str, "miMusic")) {
                        ViewSection viewSection3 = new ViewSection();
                        viewSection3.view_type = "title";
                        viewSection3.title = str2;
                        viewSection3.titleType = "music";
                        copyOnWriteArrayList.add(viewSection3);
                        ViewSection viewSection4 = new ViewSection();
                        viewSection4.view_type = "miMusic";
                        viewSection4.block = next;
                        copyOnWriteArrayList.add(viewSection4);
                        this.allViewsMap.put("music", copyOnWriteArrayList);
                    }
                }
            }
        }
        return sortFloors();
    }

    public synchronized List<ViewSection> handlerDedaoData(List<PatchWall.Block> list, String str, String str2) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (list != null) {
            Iterator<PatchWall.Block> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PatchWall.Block next = it.next();
                String str3 = next.blockUiType.name;
                if (!"block_grid".equals(str3) && !"block_grid_feature".equals(str3)) {
                    it.remove();
                } else if (ContainerUtil.isEmpty(next.items)) {
                    Object[] objArr = {"block items isEmpty= %s", next.title};
                    it.remove();
                } else if (TextUtils.equals(str, "dedao")) {
                    ViewSection viewSection = new ViewSection();
                    viewSection.view_type = "title";
                    viewSection.title = str2;
                    viewSection.titleType = "dedao";
                    copyOnWriteArrayList.add(viewSection);
                    ViewSection viewSection2 = new ViewSection();
                    viewSection2.view_type = "dedao";
                    viewSection2.block = next;
                    copyOnWriteArrayList.add(viewSection2);
                    this.allViewsMap.put("dedao", copyOnWriteArrayList);
                }
            }
        }
        return sortFloors();
    }

    private void sortItems(List<PatchWall.Item> list) {
        Collections.sort(list, $$Lambda$MicoSelectDataHelper$3De9HN4_PQzvZK_HqaTN_ipk5NE.INSTANCE);
    }

    static /* synthetic */ int lambda$sortItems$0(PatchWall.Item item, PatchWall.Item item2) {
        PatchWall.Pos pos = item.itemUiType.pos;
        PatchWall.Pos pos2 = item2.itemUiType.pos;
        if (pos.y > pos2.y) {
            return 1;
        }
        if (pos.y == pos2.y) {
            if (pos.x > pos2.x) {
                return 1;
            }
            if (pos.x == pos2.x) {
                return 0;
            }
        }
        return -1;
    }

    public List<ViewSection> sortFloors() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (MicoSelectInfo micoSelectInfo : this.mSelectInfos) {
            String str = micoSelectInfo.type;
            if (this.allViewsMap.get(str) != null) {
                copyOnWriteArrayList.addAll(this.allViewsMap.get(str));
            }
        }
        return copyOnWriteArrayList;
    }

    public synchronized List<ViewSection> handlerMicoSelectInfo(List<MicoSelectInfo> list) {
        this.mSelectInfos = list;
        if (list != null && list.size() > 0) {
            for (MicoSelectInfo next : list) {
                if (next != null) {
                    if (TextUtils.equals("banner", next.type)) {
                        if (next.cards != null && next.cards.size() > 0) {
                            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                            ViewSection viewSection = new ViewSection();
                            viewSection.view_type = "banner";
                            viewSection.cards = next.cards;
                            copyOnWriteArrayList.add(viewSection);
                            this.allViewsMap.put("banner", copyOnWriteArrayList);
                        }
                    } else if (TextUtils.equals("jin_gang_wei", next.type)) {
                        if (next.cards != null && next.cards.size() > 0) {
                            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                            ViewSection viewSection2 = new ViewSection();
                            viewSection2.view_type = "jin_gang_wei";
                            viewSection2.cards = next.cards;
                            copyOnWriteArrayList2.add(viewSection2);
                            this.allViewsMap.put("jin_gang_wei", copyOnWriteArrayList2);
                        }
                    } else if (!TextUtils.equals("intelligent", next.type)) {
                        this.waitDataSelects.add(next);
                    } else if (next.cards != null && next.cards.size() > 0) {
                        CopyOnWriteArrayList copyOnWriteArrayList3 = new CopyOnWriteArrayList();
                        ViewSection viewSection3 = new ViewSection();
                        viewSection3.view_type = "title";
                        viewSection3.title = next.name;
                        viewSection3.titleType = "intelligent";
                        copyOnWriteArrayList3.add(viewSection3);
                        ViewSection viewSection4 = new ViewSection();
                        viewSection4.view_type = "intelligent";
                        viewSection4.cards = next.cards;
                        copyOnWriteArrayList3.add(viewSection4);
                        this.allViewsMap.put("intelligent", copyOnWriteArrayList3);
                    }
                }
            }
        }
        return sortFloors();
    }

    public synchronized List<ViewSection> handlerNoMicoSelectInfo(List<MicoSelectInfo> list) {
        this.mSelectInfos = list;
        if (list != null && list.size() > 0) {
            for (MicoSelectInfo next : list) {
                if (next != null) {
                    if (TextUtils.equals("banner", next.type)) {
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        if (next.cards != null && next.cards.size() > 0) {
                            ViewSection viewSection = new ViewSection();
                            viewSection.view_type = "banner";
                            viewSection.cards = next.cards;
                            copyOnWriteArrayList.add(viewSection);
                        }
                        this.allViewsMap.put("banner", copyOnWriteArrayList);
                    } else if (TextUtils.equals("intelligent", next.type)) {
                        if (next.cards != null && next.cards.size() > 0) {
                            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                            ViewSection viewSection2 = new ViewSection();
                            viewSection2.view_type = "title";
                            viewSection2.title = next.name;
                            viewSection2.titleType = "intelligent";
                            copyOnWriteArrayList2.add(viewSection2);
                            ViewSection viewSection3 = new ViewSection();
                            viewSection3.view_type = "intelligent";
                            viewSection3.cards = next.cards;
                            copyOnWriteArrayList2.add(viewSection3);
                            this.allViewsMap.put("intelligent", copyOnWriteArrayList2);
                        }
                    } else if (TextUtils.equals("music", next.type)) {
                        CopyOnWriteArrayList copyOnWriteArrayList3 = new CopyOnWriteArrayList();
                        if (next.cards != null && next.cards.size() > 0) {
                            ViewSection viewSection4 = new ViewSection();
                            viewSection4.view_type = "title";
                            viewSection4.title = next.name;
                            copyOnWriteArrayList3.add(viewSection4);
                            ViewSection viewSection5 = new ViewSection();
                            viewSection5.view_type = "singleImage";
                            viewSection5.cards = next.cards;
                            copyOnWriteArrayList3.add(viewSection5);
                            this.allViewsMap.put("music", copyOnWriteArrayList3);
                        }
                    } else if (TextUtils.equals("video", next.type)) {
                        CopyOnWriteArrayList copyOnWriteArrayList4 = new CopyOnWriteArrayList();
                        if (next.cards != null && next.cards.size() > 0) {
                            ViewSection viewSection6 = new ViewSection();
                            viewSection6.view_type = "title";
                            viewSection6.title = next.name;
                            copyOnWriteArrayList4.add(viewSection6);
                            ViewSection viewSection7 = new ViewSection();
                            viewSection7.view_type = "singleImage";
                            viewSection7.cards = next.cards;
                            copyOnWriteArrayList4.add(viewSection7);
                            this.allViewsMap.put("video", copyOnWriteArrayList4);
                        }
                    } else if (TextUtils.equals("jin_gang_wei", next.type) && next.cards != null && next.cards.size() > 0) {
                        CopyOnWriteArrayList copyOnWriteArrayList5 = new CopyOnWriteArrayList();
                        ViewSection viewSection8 = new ViewSection();
                        viewSection8.view_type = "jin_gang_wei";
                        viewSection8.cards = next.cards;
                        copyOnWriteArrayList5.add(viewSection8);
                        this.allViewsMap.put("jin_gang_wei", copyOnWriteArrayList5);
                    }
                }
            }
        }
        return sortFloors();
    }

    public void handleDataAndMerge() {
        this.firstObservaleMap.clear();
        this.secondObservaleMap.clear();
        int size = this.waitDataSelects.size();
        int i = 0;
        if (size > 0 && size <= 2) {
            while (i < size) {
                chooseOnePatchwallObservable(this.firstObservaleMap, this.waitDataSelects.get(i));
                i++;
            }
        } else if (size > 2) {
            int i2 = (size - 1) / 2;
            while (i <= i2) {
                chooseOnePatchwallObservable(this.firstObservaleMap, this.waitDataSelects.get(i));
                i++;
            }
            if (i2 < size) {
                while (true) {
                    i2++;
                    if (i2 < size) {
                        chooseOnePatchwallObservable(this.secondObservaleMap, this.waitDataSelects.get(i2));
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void chooseOnePatchwallObservable(List<Observable<?>> list, MicoSelectInfo micoSelectInfo) {
        if (!hasDevice()) {
            return;
        }
        if (TextUtils.equals(micoSelectInfo.type, "music")) {
            if (AccountProfile.current().isQQMusicSource()) {
                AccountProfile.current().syncQQBindStatus();
                if (AccountProfile.current().isQQAccountAuthValid()) {
                    list.add(qqPatchwallObservable1(micoSelectInfo.name));
                    list.add(qqPatchwallObservable2(micoSelectInfo.name));
                    return;
                }
                return;
            }
            list.add(miPatchwallObservable(micoSelectInfo.name));
        } else if (TextUtils.equals(micoSelectInfo.type, "kid")) {
            list.add(kidsPatchwallObservable(micoSelectInfo.name));
        } else if (TextUtils.equals(micoSelectInfo.type, "audioBook")) {
            list.add(radioPatchwallObservable(micoSelectInfo.name));
        } else if (TextUtils.equals(micoSelectInfo.type, "uncleCassie")) {
            list.add(kaishuPatchwallObservable(micoSelectInfo.name));
        } else if (TextUtils.equals(micoSelectInfo.type, "dedao")) {
            list.add(dedaoPatchwallObservable(micoSelectInfo.name));
        }
    }

    public synchronized Observable<List<ViewSection>> mergePatchwallObservable() {
        if (this.firstObservaleMap.size() == 0) {
            return Observable.unsafeCreate(new Observable.OnSubscribe<List<ViewSection>>() {
                /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass1 */

                public /* bridge */ /* synthetic */ void call(Object obj) {
                    call((Subscriber<? super List<ViewSection>>) ((Subscriber) obj));
                }

                public void call(Subscriber<? super List<ViewSection>> subscriber) {
                    subscriber.onNext(MicoSelectDataHelper.this.sortFloors());
                }
            });
        }
        return Observable.zip(this.firstObservaleMap, new FuncN<List<ViewSection>>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass2 */

            public List<ViewSection> call(Object... objArr) {
                return MicoSelectDataHelper.this.sortFloors();
            }
        });
    }

    public Observable<List<ViewSection>> secondMergePatchwallObservable() {
        if (this.secondObservaleMap.size() == 0) {
            return Observable.unsafeCreate(new Observable.OnSubscribe<List<ViewSection>>() {
                /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass3 */

                public /* bridge */ /* synthetic */ void call(Object obj) {
                    call((Subscriber<? super List<ViewSection>>) ((Subscriber) obj));
                }

                public void call(Subscriber<? super List<ViewSection>> subscriber) {
                    subscriber.onNext(MicoSelectDataHelper.this.sortFloors());
                }
            });
        }
        return Observable.zip(this.secondObservaleMap, new FuncN<List<ViewSection>>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass4 */

            public List<ViewSection> call(Object... objArr) {
                return MicoSelectDataHelper.this.sortFloors();
            }
        });
    }

    public Observable<List<ViewSection>> qqPatchwallObservable1(final String str) {
        return ObservableApiHelper.getQQPatchWallFlowV2(0, 1).onErrorReturn(new Func1<Throwable, PatchWall>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass6 */

            public PatchWall call(Throwable th) {
                return new PatchWall();
            }
        }).flatMap(new Func1<PatchWall, Observable<List<ViewSection>>>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass5 */

            public Observable<List<ViewSection>> call(final PatchWall patchWall) {
                return Observable.unsafeCreate(new Observable.OnSubscribe<List<ViewSection>>() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass5.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        call((Subscriber<? super List<ViewSection>>) ((Subscriber) obj));
                    }

                    public void call(Subscriber<? super List<ViewSection>> subscriber) {
                        if (patchWall != null) {
                            subscriber.onNext(MicoSelectDataHelper.this.handlerQQmusicData(patchWall.blocks, str));
                        }
                    }
                });
            }
        });
    }

    public Observable<List<ViewSection>> qqPatchwallObservable2(final String str) {
        return ObservableApiHelper.getQQPatchWallFlowV2(1, 1).onErrorReturn(new Func1<Throwable, PatchWall>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass8 */

            public PatchWall call(Throwable th) {
                return new PatchWall();
            }
        }).flatMap(new Func1<PatchWall, Observable<List<ViewSection>>>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass7 */

            public Observable<List<ViewSection>> call(final PatchWall patchWall) {
                return Observable.unsafeCreate(new Observable.OnSubscribe<List<ViewSection>>() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass7.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        call((Subscriber<? super List<ViewSection>>) ((Subscriber) obj));
                    }

                    public void call(Subscriber<? super List<ViewSection>> subscriber) {
                        if (patchWall != null) {
                            subscriber.onNext(MicoSelectDataHelper.this.handlerQQmusicData(patchWall.blocks, str));
                        }
                    }
                });
            }
        });
    }

    public Observable<List<ViewSection>> miPatchwallObservable(final String str) {
        return ObservableApiHelper.getMiPatchWallFlow(0, 1).onErrorReturn(new Func1<Throwable, PatchWall>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass10 */

            public PatchWall call(Throwable th) {
                return new PatchWall();
            }
        }).flatMap(new Func1<PatchWall, Observable<List<ViewSection>>>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass9 */

            public Observable<List<ViewSection>> call(final PatchWall patchWall) {
                return Observable.unsafeCreate(new Observable.OnSubscribe<List<ViewSection>>() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass9.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        call((Subscriber<? super List<ViewSection>>) ((Subscriber) obj));
                    }

                    public void call(Subscriber<? super List<ViewSection>> subscriber) {
                        if (patchWall != null) {
                            subscriber.onNext(MicoSelectDataHelper.this.handlerCommonData(patchWall.blocks, "miMusic", str));
                        }
                    }
                });
            }
        });
    }

    public Observable<List<ViewSection>> selectPatchwallObservable() {
        if (hasDevice()) {
            return MicoSelectApi2.getInstance().getObservableSelectInfo(true).flatMap(new Func1<List<MicoSelectInfo>, Observable<List<ViewSection>>>() {
                /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass12 */

                public /* bridge */ /* synthetic */ Object call(Object obj) {
                    return call((List<MicoSelectInfo>) ((List) obj));
                }

                public Observable<List<ViewSection>> call(final List<MicoSelectInfo> list) {
                    return Observable.unsafeCreate(new Observable.OnSubscribe<List<ViewSection>>() {
                        /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass12.AnonymousClass1 */

                        public /* bridge */ /* synthetic */ void call(Object obj) {
                            call((Subscriber<? super List<ViewSection>>) ((Subscriber) obj));
                        }

                        public void call(Subscriber<? super List<ViewSection>> subscriber) {
                            subscriber.onNext(MicoSelectDataHelper.this.handlerMicoSelectInfo(list));
                        }
                    });
                }
            }).flatMap(new Func1<List<ViewSection>, Observable<List<ViewSection>>>() {
                /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass11 */

                public /* bridge */ /* synthetic */ Object call(Object obj) {
                    return call((List<ViewSection>) ((List) obj));
                }

                public Observable<List<ViewSection>> call(List<ViewSection> list) {
                    MicoSelectDataHelper.this.handleDataAndMerge();
                    return MicoSelectDataHelper.this.mergePatchwallObservable();
                }
            });
        }
        return MicoSelectApi2.getInstance().getObservableSelectInfo(false).flatMap(new Func1<List<MicoSelectInfo>, Observable<List<ViewSection>>>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass13 */

            public /* bridge */ /* synthetic */ Object call(Object obj) {
                return call((List<MicoSelectInfo>) ((List) obj));
            }

            public Observable<List<ViewSection>> call(final List<MicoSelectInfo> list) {
                return Observable.unsafeCreate(new Observable.OnSubscribe<List<ViewSection>>() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass13.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        call((Subscriber<? super List<ViewSection>>) ((Subscriber) obj));
                    }

                    public void call(Subscriber<? super List<ViewSection>> subscriber) {
                        subscriber.onNext(MicoSelectDataHelper.this.handlerNoMicoSelectInfo(list));
                    }
                });
            }
        });
    }

    public Observable<List<ViewSection>> kidsPatchwallObservable(final String str) {
        return ObservableApiHelper.getKidsPatchWallFlow(0, 1).onErrorReturn(new Func1<Throwable, PatchWall>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass15 */

            public PatchWall call(Throwable th) {
                return new PatchWall();
            }
        }).flatMap(new Func1<PatchWall, Observable<List<ViewSection>>>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass14 */

            public Observable<List<ViewSection>> call(final PatchWall patchWall) {
                return Observable.unsafeCreate(new Observable.OnSubscribe<List<ViewSection>>() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass14.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        call((Subscriber<? super List<ViewSection>>) ((Subscriber) obj));
                    }

                    public void call(Subscriber<? super List<ViewSection>> subscriber) {
                        if (patchWall != null) {
                            subscriber.onNext(MicoSelectDataHelper.this.handlerKidsAndKaishuData(patchWall.blocks, str, "kid"));
                        }
                    }
                });
            }
        });
    }

    public Observable<List<ViewSection>> kaishuPatchwallObservable(final String str) {
        return ObservableApiHelper.getTopQualityPatchWallFlow(0, 1).onErrorReturn(new Func1<Throwable, PatchWall>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass17 */

            public PatchWall call(Throwable th) {
                return new PatchWall();
            }
        }).flatMap(new Func1<PatchWall, Observable<List<ViewSection>>>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass16 */

            public Observable<List<ViewSection>> call(final PatchWall patchWall) {
                return Observable.unsafeCreate(new Observable.OnSubscribe<List<ViewSection>>() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass16.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        call((Subscriber<? super List<ViewSection>>) ((Subscriber) obj));
                    }

                    public void call(Subscriber<? super List<ViewSection>> subscriber) {
                        if (patchWall != null) {
                            subscriber.onNext(MicoSelectDataHelper.this.handlerKidsAndKaishuData(patchWall.blocks, str, "uncleCassie"));
                        }
                    }
                });
            }
        });
    }

    public Observable<List<ViewSection>> radioPatchwallObservable(final String str) {
        return ObservableApiHelper.getPatchWallFlow(0, 1).onErrorReturn(new Func1<Throwable, PatchWall>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass19 */

            public PatchWall call(Throwable th) {
                return new PatchWall();
            }
        }).flatMap(new Func1<PatchWall, Observable<List<ViewSection>>>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass18 */

            public Observable<List<ViewSection>> call(final PatchWall patchWall) {
                return Observable.unsafeCreate(new Observable.OnSubscribe<List<ViewSection>>() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass18.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        call((Subscriber<? super List<ViewSection>>) ((Subscriber) obj));
                    }

                    public void call(Subscriber<? super List<ViewSection>> subscriber) {
                        if (patchWall != null) {
                            subscriber.onNext(MicoSelectDataHelper.this.handlerCommonData(patchWall.blocks, "radio", str));
                        }
                    }
                });
            }
        });
    }

    public Observable<List<ViewSection>> dedaoPatchwallObservable(final String str) {
        return ObservableApiHelper.getDedaoAuth("269135865337350144").flatMap(new Func1<MiBrain.OAuthInfo, Observable<PatchWall>>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass21 */

            public Observable<PatchWall> call(MiBrain.OAuthInfo oAuthInfo) {
                return ObservableApiHelper.getDedaoPatchWallFlow(oAuthInfo.binded() ? 1 : 0, 0).onErrorReturn(new Func1<Throwable, PatchWall>() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass21.AnonymousClass1 */

                    public PatchWall call(Throwable th) {
                        return new PatchWall();
                    }
                });
            }
        }).flatMap(new Func1<PatchWall, Observable<List<ViewSection>>>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass20 */

            public Observable<List<ViewSection>> call(final PatchWall patchWall) {
                return Observable.unsafeCreate(new Observable.OnSubscribe<List<ViewSection>>() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectDataHelper.AnonymousClass20.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        call((Subscriber<? super List<ViewSection>>) ((Subscriber) obj));
                    }

                    public void call(Subscriber<? super List<ViewSection>> subscriber) {
                        if (patchWall != null) {
                            subscriber.onNext(MicoSelectDataHelper.this.handlerDedaoData(patchWall.blocks, "dedao", str));
                        }
                    }
                });
            }
        });
    }

    public void resetViewStatus() {
        this.allViewsMap.clear();
        this.qqMusicViewMap.clear();
        handleDataAndMerge();
    }

    public boolean hasDevice() {
        Admin.Mico currentMico = MicoManager.getInstance().getCurrentMico();
        return !TextUtils.isEmpty(currentMico.deviceID) && !TextUtils.isEmpty(currentMico.serialNumber);
    }
}
