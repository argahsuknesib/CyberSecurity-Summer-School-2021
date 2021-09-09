package com.tiqiaa.database;

import _m_j.bdf;
import com.tiqiaa.tv.entity.TvForenotice;
import com.tiqiaa.tv.entity.TvShow;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TvForenoticeCacheHelper {
    public static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public void cacheTvForenotices(final Date date, final List<TvForenotice> list) {
        new Thread(new Runnable() {
            /* class com.tiqiaa.database.TvForenoticeCacheHelper.AnonymousClass1 */

            public void run() {
                for (TvForenotice tvForenotice : list) {
                    tvForenotice.setCacheDate(new Date());
                    if (date != null) {
                        tvForenotice.setPlayDate(TvForenoticeCacheHelper.DATE_FORMAT.format(tvForenotice.getPt()));
                    }
                    tvForenotice.setType(0);
                    if (tvForenotice.getTvshow_img() != null) {
                        DataBaseManager.getInstance().saveShowImg(tvForenotice.getTvshow_img());
                    }
                    DataBaseManager.getInstance().saveTvForenotice(tvForenotice);
                }
                TvForenoticeCacheHelper.this.clearOverdueCachedFornotices();
            }
        }).start();
    }

    public List<TvForenotice> getCachedTvForenotices(Date date) {
        return DataBaseManager.getInstance().getCachedTvForenotices(DATE_FORMAT.format(date));
    }

    public List<TvForenotice> getCachedTvForenotices(Date date, int i) {
        List<TvForenotice> cachedTvForenotices = DataBaseManager.getInstance().getCachedTvForenotices(DATE_FORMAT.format(date), i);
        ArrayList arrayList = new ArrayList();
        if (cachedTvForenotices == null) {
            return null;
        }
        for (TvForenotice next : cachedTvForenotices) {
            if (!arrayList.contains(next)) {
                arrayList.add(next);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public void saveAppoitedForenotice(TvForenotice tvForenotice) {
        tvForenotice.setCacheDate(new Date());
        tvForenotice.setType(1);
        DataBaseManager.getInstance().saveOrUpdateTvForenotice(tvForenotice);
    }

    public List<TvForenotice> getAppointedForenotices() {
        return DataBaseManager.getInstance().getAppointedForenotices();
    }

    public void removeAppointForenotice(TvForenotice tvForenotice) {
        DataBaseManager.getInstance().deleteTvForenotice(tvForenotice);
    }

    public List<TvForenotice> getAllCachedTvForenotices() {
        return DataBaseManager.getInstance().getAllCachedTvForenotices();
    }

    public void cacheTvShow(TvShow tvShow) {
        if (tvShow.getPreviews() != null && tvShow.getPreviews().size() > 0) {
            tvShow.setPreviews_json(bdf.O000000o(tvShow.getPreviews()));
        }
        tvShow.setType(0);
        tvShow.setCacheTime(new Date());
        DataBaseManager.getInstance().saveTvshow(tvShow);
    }

    public void saveFavoriteTvShow(TvShow tvShow) {
        if (tvShow.getPreviews() != null && tvShow.getPreviews().size() > 0) {
            tvShow.setPreviews_json(bdf.O000000o(tvShow.getPreviews()));
        }
        tvShow.setType(1);
        DataBaseManager.getInstance().saveOrUpdateTvshow(tvShow);
    }

    public List<TvShow> getAllSavedTvShow() {
        return DataBaseManager.getInstance().getAllSavedTvShows();
    }

    public List<TvShow> getAllFavoriteTvShow() {
        return DataBaseManager.getInstance().getAllFavoriteTvShows();
    }

    public void removeFavoriteTvShow(TvShow tvShow) {
        tvShow.setType(0);
        DataBaseManager.getInstance().saveOrUpdateTvshow(tvShow);
    }

    public TvShow getTvShowByShowId(int i) {
        return DataBaseManager.getInstance().getSavedTvShowById(i);
    }

    public List<TvForenotice> getTvForenotices(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int findTvForenoticeByshowid : iArr) {
            List<TvForenotice> findTvForenoticeByshowid2 = DataBaseManager.getInstance().findTvForenoticeByshowid(findTvForenoticeByshowid);
            if (findTvForenoticeByshowid2 != null && findTvForenoticeByshowid2.size() > 0) {
                arrayList.addAll(findTvForenoticeByshowid2);
            }
        }
        return arrayList;
    }

    public void clearOverdueCachedFornotices() {
        DataBaseManager.getInstance().deleteOverdueCachedForenotice(10800000);
        DataBaseManager.getInstance().deleteOverdueAppointedForenotice();
        DataBaseManager.getInstance().deleteOverdueCachedTvShow(10800000);
    }
}
