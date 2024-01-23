package api;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DbPush {
    static OkHttpClient staticClient;

    public static void init(){
        staticClient = new OkHttpClient();
    }

    public static void push(String cve, String msg, String time, String srcAddress) throws IOException{

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"cve\": \""+cve+"\",\n\t\"msg\": \""+msg+"\",\n\t\"time\": \""+time+"\",\n\t\"src_address\": \""+srcAddress+"\"\n}");
        Request request = new Request.Builder()
          .url("http://localhost:3001/api/users?=")
          .post(body)
          .addHeader("Content-Type", "application/json")
          .addHeader("User-Agent", "insomnia/2023.5.8")
          .build();
        
        Response response = staticClient.newCall(request).execute();
        response.close();
    }
}
