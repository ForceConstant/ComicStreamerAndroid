package comicstreamer;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

import comicstreamer.messages.*;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ComicStreamerApiEndpointInterface {
    @GET("/dbinfo")
    Call<DbInfo> getDbInfo();

    @GET("/version")
    Call<DbVersion> getVersion();

    @GET("/deleted")
    Call<Deleted> getDeleted(
            @Query("since") String date
    );

    @GET("/comic/{id}")
    Call<ComicContainer> getComic(@Path("id") Integer id);

    @GET("/comic/{id}/page/{pagenum}")
    Call<ResponseBody> getComicPage(@Path("id") Integer id, @Path("pagenum") Integer pageNum);

    @GET("/comic/{id}/page/{pagenum}/bookmark")
    Call<Status> setBookmark(@Path("id") Integer id, @Path("pagenum") Integer pageNum);

    @GET("/comic/{id}/thumbnail")
    Call<ResponseBody> getThumbnail(@Path("id") Integer id);

    @GET("/comic/{id}/file")
    Call<ResponseBody> getFile(@Path("id") Integer id);

    @GET("/comiclist")
    Call<ComicList> getComicList(@QueryMap Map<String, String> options);

}

