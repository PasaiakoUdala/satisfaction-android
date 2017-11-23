package eus.pasaia.org.satisfaction.data.model.remote;

import eus.pasaia.org.satisfaction.data.model.Satisfaction;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
  @POST("/satisfaction")
  @FormUrlEncoded
  Call<Satisfaction> saveSatisfaction(
    @Field("galdera") String galdera,
    @Field("emaitza") Integer emaitza,
    @Field("saila") String saila,
    @Field("kokalekua") String kokalekua
  );
}
