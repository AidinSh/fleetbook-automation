package Qase;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface QaseInterface {

    @Headers({"Token: 1216cae49f1f29c4d7c11a9c399abd07cf2f2f81"})
    @POST("v1/result/FLEETBOOK/5")
    Call<Run> createPost(@Body Run run);
}
