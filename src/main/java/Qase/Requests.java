package Qase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Requests {

    public void setRunResult(int caseId, String status){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.qase.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        QaseInterface qaseInterface = retrofit.create(QaseInterface.class);
        Run run = new Run(caseId, status);

        Call<Run> call = qaseInterface.createPost(run);

        call.enqueue(new Callback<Run>() {
            @Override
            public void onResponse(Call<Run> call, Response<Run> response) {
                if (!response.isSuccessful()){
                    System.out.println("There was a problem! Code : " + response.code());
                }else {
                    System.out.println("the request was sucessful");
                }
            }

            @Override
            public void onFailure(Call<Run> call, Throwable throwable) {
                System.out.println("The request has been failed");
            }
        });
    }

}
