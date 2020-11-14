import dto.TokenDto;
import service.HttpService;
import service.mappers.TokenMapper;

import java.util.Base64;

public class Main {
    public static void main(String[] args) {
//        final String clientId = "a42ac97f1b714177a30c049c331b484c";
//        final String ClientSecret = "wIMadnffdC9ky3m9UbsYTEhfeBnhMtAQYVnY9P5Hx8PzrAcThUYudbOCinnJc9bV";
//        String originalInput = clientId + ":" + ClientSecret;
//
//        System.out.println(encodedString);

//        TokenMapper tokenMapper = new TokenMapper();
//        System.out.println(tokenMapper.toTokenDto());

        HttpService httpService = new HttpService();
        System.out.println(httpService.getDataForToken());

    }
}
