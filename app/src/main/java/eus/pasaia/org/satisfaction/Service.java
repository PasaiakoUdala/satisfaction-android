package eus.pasaia.org.satisfaction;

import eus.pasaia.org.satisfaction.modelos.Satisfaction;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by ikerib on 22/11/2017.
 */

public interface Service {
    public static final String BASE_URL = "http://localhost:3000";

    @POST("satisfaction")
    Call<Satisfaction> createUser(@Body Satisfaction satisfaction);

}
