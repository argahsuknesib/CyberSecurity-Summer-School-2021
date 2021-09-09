package com.xiaomi.mico.api.service;

import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.api.model.MinaResponse;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.api.model.SkillStore;
import java.util.List;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface SkillstoreService {
    @GET("/front_page/my_frequent")
    Observable<Response<MinaResponse<List<SkillStore.SkillV2>>>> frequentSkills(@Query("clientType") String str);

    @GET("/front_page/fun_skills")
    Observable<Response<MinaResponse<List<SkillStore.Skill>>>> funnySkill(@Query("clientType") String str);

    @GET("/front_page/category_list")
    Observable<Response<MinaResponse<List<SkillStore.RankingType>>>> getAllSkillCategoryType(@Query("clientType") String str);

    @GET("/front_page/banners")
    Observable<Response<MinaResponse<Banner>>> getBanners(@Query("clientType") String str);

    @GET("/front_page/category_skills")
    Observable<Response<MinaResponse<List<SkillStore.SkillV2>>>> getCategorySkills(@Query("clientType") String str, @Query("page") int i, @Query("limit") int i2, @Query("categoryId") String str2);

    @GET("/search/popular_skills")
    Observable<Response<MinaResponse<List<SkillStore.Skill>>>> getHotKeys(@Query("clientType") String str);

    @GET("/leaderboard/info")
    Observable<Response<MinaResponse<SkillStore.Ranking>>> getRankingList(@Query("clientType") String str, @Query("leaderboardId") String str2);

    @GET("/leaderboard/all_leaderboards")
    Observable<Response<MinaResponse<List<SkillStore.RankingType>>>> getRankingType(@Query("clientType") String str);

    @GET("/front_page/search_recommend")
    Observable<Response<MinaResponse<String>>> getSearchRecommend(@Query("clientType") String str);

    @GET("/front_page/latest_skills")
    Observable<Response<MinaResponse<List<SkillStore.SkillV2>>>> latestSkills(@Query("clientType") String str);

    @GET("/front_page/more")
    Observable<Response<MinaResponse<List<SkillStore.SkillV2>>>> moreRecommendSkills(@Query("clientType") String str, @Query("page") int i, @Query("limit") int i2);

    @GET("/skill/privacy_detail")
    Observable<Response<MinaResponse<SkillStore.Privacy>>> privacyDetail(@Query("skillId") String str);

    @GET("/search/skills")
    Observable<Response<MinaResponse<List<SkillStore.SkillV2>>>> searchSkills(@Query("clientType") String str, @Query("keyword") String str2);

    @POST("/skill/set_privacy")
    Observable<Response<MinaResponse<Remote.Response.NullInfo>>> setPrivacy(@Field("skillId") String str, @Field("enabled") boolean z);

    @GET("/skill/detail")
    Observable<Response<MinaResponse<SkillStore.SkillDetailV2>>> skillDetail(@Query("clientType") String str, @Query("skillId") String str2);

    @GET("/front_page/all")
    Observable<Response<MinaResponse<List<SkillStore.SectionV2>>>> skillSection(@Query("clientType") String str);

    @GET("/front_page/special_topic")
    Observable<Response<MinaResponse<List<SkillStore.Skill>>>> specialTopicSkill(@Query("clientType") String str);

    @GET("/front_page/weekly_selection")
    Observable<Response<MinaResponse<List<SkillStore.Skill>>>> weeklySelectionSkill(@Query("clientType") String str);
}
