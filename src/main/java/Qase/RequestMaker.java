package Qase;

import com.google.gson.JsonObject;
import okhttp3.*;
import java.io.IOException;

public class RequestMaker {

    OkHttpClient client = new OkHttpClient();
    String url = "https://api.qase.io/v1/result/FLEETBOOK/7";
    String APIToken = "1216cae49f1f29c4d7c11a9c399abd07cf2f2f81";


    public void setRunResult(String caseId, String status, String comment){
        MediaType JSON = MediaType.parse("application/json;charset=utf-8");
        JsonObject object = new JsonObject();
        object.addProperty("case_id", caseId);
        object.addProperty("status", status);
        object.addProperty("comment", comment);

        RequestBody body = RequestBody.create(JSON, object.toString());

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Token", APIToken)
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
