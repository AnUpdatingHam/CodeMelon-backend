import okhttp3.*;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ChineseGPT {
    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    private static final String API_KEY = "4M7s6tJ4tZ1TnDY2o13NoSYt";
    private static final String SECRET_KEY = "ExC7ckoUvw2fGZN6y3VroomZXpMsJ6fd";

    static String getAccessToken() throws IOException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=" + API_KEY + "&client_secret=" + SECRET_KEY);
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String responseBody = response.body().string();
            return new JSONObject(responseBody).getString("access_token");
        }
    }

    public static void main(String[] args) {
        try {
            String access_token = getAccessToken();
            String baseUrl = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/eb-instant?access_token=" + access_token;

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入问题 (输入 'exit' 退出程序):");
            String input;

            while (!(input = reader.readLine()).equals("exit")) {
                HashMap<String, String> msg = new HashMap<>();
                msg.put("role", "user");
                msg.put("content", input);

                HashMap<String, Object> requestBody = new HashMap<>();
                requestBody.put("messages", new ArrayList<HashMap>() {{ add(msg); }});

                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                RequestBody body = RequestBody.create(mediaType, new JSONObject(requestBody).toString());

                Request request = new Request.Builder()
                        .url(baseUrl)
                        .post(body)
                        .addHeader("Content-Type", "application/json")
                        .build();

                try (Response response = HTTP_CLIENT.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code " + response);
                    }
                    JSONObject jsonResponse = new JSONObject(response.body().string());
                    String result = jsonResponse.getString("result");
                    System.out.println("\n人工智障：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("\n请输入问题 (输入 'exit' 退出程序):");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
