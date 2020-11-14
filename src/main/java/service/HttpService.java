package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class HttpService {
    private final String clientId = "a42ac97f1b714177a30c049c331b484c";
    private final String ClientSecret = "wIMadnffdC9ky3m9UbsYTEhfeBnhMtAQYVnY9P5Hx8PzrAcThUYudbOCinnJc9bV";
    private final String encodedString = Base64.getEncoder()
            .encodeToString((clientId + ":" + ClientSecret).getBytes());

    public String getDataForToken() {
        String endPoint = "https://allegro.pl/auth/oauth/token?grant_type=client_credentials";
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(endPoint).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Basic " + encodedString);
            BufferedReader inputData = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = inputData.readLine()) != null) {
                content.append(inputLine);
            }
            inputData.close();
            connection.disconnect();
            return String.valueOf(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't fetch data from the " + endPoint);
        }
    }
}
