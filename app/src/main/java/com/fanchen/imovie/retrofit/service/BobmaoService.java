package com.fanchen.imovie.retrofit.service;

import com.fanchen.imovie.annotation.JsoupSource;
import com.fanchen.imovie.annotation.JsoupType;
import com.fanchen.imovie.annotation.MethodSource;
import com.fanchen.imovie.annotation.MethodType;
import com.fanchen.imovie.annotation.RetrofitSource;
import com.fanchen.imovie.annotation.RetrofitType;
import com.fanchen.imovie.entity.face.IBangumiMoreRoot;
import com.fanchen.imovie.entity.face.IHomeRoot;
import com.fanchen.imovie.entity.face.IPlayUrls;
import com.fanchen.imovie.entity.face.IVideoDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * 山猫视频
 * Created by fanchen on 2017/12/23.
 */
@RetrofitType(RetrofitSource.BOBMAO_API)
public interface BobmaoService {
    /**
     *
     * @param path
     * @return
     */
    @GET("{path}/")
    @JsoupType(JsoupSource.BOBMAO)
    @MethodType(value = MethodSource.HOME)
    @RetrofitType(isJsoupResponse = JsoupSource.TYPE_VIDEO)
    Call<IHomeRoot> home(@Path("path") String path);

    /**
     *
     * @param page
     * @param searchword
     * @return
     */
    @GET("search/{searchword}-{page}.html")
    @JsoupType(JsoupSource.BOBMAO)
    @MethodType(value = MethodSource.SEARCH)
    @RetrofitType(isJsoupResponse = JsoupSource.TYPE_VIDEO)
    Call<IBangumiMoreRoot> search(@Path("page") Integer page, @Path("searchword") String searchword);

    /**
     *
     * @param pid
     * @param page
     * @return
     */
    @GET("{path}/index-{page}.html")
    @JsoupType(JsoupSource.BOBMAO)
    @MethodType(value = MethodSource.MORE)
    @RetrofitType(isJsoupResponse = JsoupSource.TYPE_VIDEO)
    Call<IBangumiMoreRoot> more(@Path("path") String pid, @Path("page") Integer page);

    /**
     * @param path
     * @return
     */
    @GET
    @JsoupType(JsoupSource.BOBMAO)
    @MethodType(value = MethodSource.DETAILS)
    @RetrofitType(isJsoupResponse = JsoupSource.TYPE_VIDEO)
    Call<IVideoDetails> details(@Url String path);


    /**
     * @param path
     * @return
     */
    @GET
    @JsoupType(JsoupSource.BOBMAO)
    @MethodType(value = MethodSource.PLAYURL)
    @RetrofitType(isJsoupResponse = JsoupSource.TYPE_VIDEO)
    Call<IPlayUrls> playUrl(@Url String path);
}
