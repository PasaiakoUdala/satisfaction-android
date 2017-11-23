package eus.pasaia.org.satisfaction;

import eus.pasaia.org.satisfaction.modelos.Satisfaction;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ikerib on 22/11/2017.
 */

public interface Service {
    public static final String BASE_URL = "http://172.28.64.147:3000/";

//    @POST("satisfaction")
//    Call<Satisfaction> createUser(@Body Satisfaction satisfaction);

  @POST("/posts")
  @FormUrlEncoded
  Call<Satisfaction> saveSatisfaction(
      @Field("kokapena") String kokapena,
      @Field("saila") String saila,
      @Field("galdera") String galdera,
      @Field("emaitza") Integer emaitza
  );

}
