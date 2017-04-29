package comicstreamer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import comicstreamer.messages.Comic;
import comicstreamer.messages.ComicContainer;
import comicstreamer.messages.ComicList;
import comicstreamer.messages.DbInfo;
import comicstreamer.messages.DbVersion;
import comicstreamer.messages.Deleted;
import comicstreamer.messages.Deletedcomic;
import comicstreamer.messages.Status;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.Route;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ComicStreamer {
    private static ComicStreamerApiEndpointInterface apiService;
    private static OkHttpClient okHttpClient;
    private static String hostName;

    public ComicStreamer(String hostName, final String username, final String password, final boolean allowUntrusted) {

        this.hostName = hostName;

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Integer.class, new IntegerRuntimeTypeAdapter());
        Gson gson = gsonBuilder.create();

        OkHttpClient.Builder clientBuilder = new OkHttpClient().newBuilder();

        if (  allowUntrusted) {
            final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    X509Certificate[] cArrr = new X509Certificate[0];
                    return cArrr;
                }

                @Override
                public void checkServerTrusted(final X509Certificate[] chain,
                                               final String authType) throws CertificateException {
                }

                @Override
                public void checkClientTrusted(final X509Certificate[] chain,
                                               final String authType) throws CertificateException {
                }
            }};


            SSLContext sslContext = null;
            try {
                sslContext = SSLContext.getInstance("SSL");

                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }


            clientBuilder.sslSocketFactory(sslContext.getSocketFactory());

            HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            clientBuilder.hostnameVerifier( hostnameVerifier);
        }

        if (!username.isEmpty()){
            clientBuilder.authenticator(new Authenticator() {
                @Override
                public Request authenticate(Route route, okhttp3.Response response) throws IOException {
                    String credential = Credentials.basic(username, password);
                    return response.request().newBuilder()
                            .header("Authorization", credential)
                            .build();
                }
            });
        }
        okHttpClient = clientBuilder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(hostName)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                //.addConverterFactory(ScalarsConverterFactory.create())
                .build();

        apiService = retrofit.create(ComicStreamerApiEndpointInterface.class);

    }

    public DbInfo getDBInfo() throws IOException {
        Call<DbInfo> call = apiService.getDbInfo();

        return call.execute().body();
    }


    public DbVersion getVersion() throws IOException {
        Call<DbVersion> call = apiService.getVersion();

        return call.execute().body();
    }

    public List<Deletedcomic> getDeleted(String sinceDate) throws IOException {
        Call<Deleted> call = apiService.getDeleted(sinceDate);

        Deleted deleted = call.execute().body();
        return deleted.getDeletedcomics();
    }

    public byte[] getComicPage(Integer id, Integer pageNum) throws IOException {
        Call<ResponseBody> call = apiService.getComicPage(id, pageNum);

        byte[] res;
        Response response = call.execute();
        try {
            res = ((ResponseBody) response.body()).bytes();
        } finally {
            ((ResponseBody) response.body()).close();
        }
        return res;
    }

    public boolean setBookmark(Integer id, Integer pageNum) throws IOException {
        Call<Status> call = apiService.setBookmark(id, pageNum);

        Status res = call.execute().body();
        return res.getStatus() == 0;
    }

    public byte[] getThumbnail(Integer id) throws IOException {
        // Maybe I want to use picasso to download image.
        Call<ResponseBody> call = apiService.getThumbnail(id);

        byte[] res;
        Response response = call.execute();
        try {
            res = ((ResponseBody) response.body()).bytes();
        } finally {
            ((ResponseBody) response.body()).close();
        }
        return res;
    }

    public byte[] getFile(Integer id) throws IOException {
        Call<ResponseBody> call = apiService.getFile(id);

        byte[] res;
        Response response = call.execute();
        try {
            res = ((ResponseBody) response.body()).bytes();
        } finally {
            ((ResponseBody) response.body()).close();
        }
        return res;
    }

    public Comic getComicInfo(Integer id) throws IOException {
        Call<ComicContainer> call = apiService.getComic(id);

        ComicContainer comic = call.execute().body();
        return comic.getComics().get(0);
    }

    public String getThumbnailUrl(Integer id) {
        return new String(hostName + "/comic/" + id + "/thumbnail");
    }

    public String getPageUrl(Integer id, Integer pageNum){
        return new String(hostName + "/comic/" + id + "/page/" + pageNum);
    }


    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }


    public ArrayList<Comic> getComicList(String series) throws IOException
    {
        Map<String, String> data = new HashMap<>();
        data.put("order", "id");
//        data.put("per_page", "101");
        data.put("series", series);

        /*
        series
                    filter by series (wildcard accepted)
                title
                    filter by issue title (wildcard accepted)
                path
                    filter by file path (wildcard accepted)
                character
                    filter by character (wildcard accepted)
                team
                    filter by team (wildcard accepted)
                location
                    filter by location (wildcard accepted)
                storyarc
                    filter by story arc (wildcard accepted)
                genre
                    filter by genre (wildcard accepted)
                tag
                    filter by generic tag (wildcard accepted)
                volume
                    filter by volume (wildcard accepted)
                publisher
                    filter by publisher (wildcard accepted)
                credit
                    filter by creator credit (wildcard accepted)
                    should be a name optionally followed by a ":" and the role. e.g:
                        credit=Brian*Vaughn
                        credit=*Buscema:inker
                start_date
                    the beginning publication date of the resultset
                end_date
                    the end publication date of the resultset
                added_since
                    only comics added the to database since given date
                lastread_since
                    only comics that have been read since given date
					(Set this value to something like "1970" to filter out unread comics)
                per_page
                    max amount of results to be returned
                offset
                    the starting offset of the query resultset
                order
                    order by given key.  if key has "-" prepended, order descending
                    available sort keys:
                        series, title, volume, issue, publisher, path, modified, added, lastread, date

         */

        Call<ComicList> call = apiService.getComicList(data);

        ComicList list = call.execute().body();
        return (ArrayList<Comic>)(list.getComics());
    }
}

