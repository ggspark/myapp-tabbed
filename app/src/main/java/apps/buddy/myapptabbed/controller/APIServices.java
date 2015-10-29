package apps.buddy.myapptabbed.controller;


import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.realm.RealmObject;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * @author Gaurav Gupta <gaurav@thegauravgupta.com>
 * @since 29/Oct/2015
 */
public class APIServices {
    //TODO: Change API_URL
    static final String API_URL = "http://api.themoviedb.org/3";

    private static Gson gson = new GsonBuilder()
            .setExclusionStrategies(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return f.getDeclaringClass().equals(RealmObject.class);
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }
            })
            .create();
    //Create a rest adapter with our settings
    private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(API_URL)
            .setConverter(new GsonConverter(gson))
            .build();

    private static final Service API_SERVICE = REST_ADAPTER.create(Service.class);

    public static Service getService() {
        return API_SERVICE;
    }

    //Create a service interface to query API
    public interface Service {
        //TODO: Change the API Services
        @GET("/movie/now_playing")
        void getNowPlaying(@Query("api_key") String key, @Query("page") int page, Callback<Object> cb);
    }
}

