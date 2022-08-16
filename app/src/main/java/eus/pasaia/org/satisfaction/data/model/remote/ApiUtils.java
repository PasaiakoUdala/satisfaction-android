package eus.pasaia.org.satisfaction.data.model.remote;


public class ApiUtils {
  private ApiUtils() {}

  public static final String BASE_URL = "http://172.28.64.117:3000/";

  public static APIService getAPIService() {

    return RetrofitClient.getClient(BASE_URL).create(APIService.class);
  }
}
