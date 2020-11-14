package service.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.TokenDto;
import service.HttpService;

public class TokenMapper {
    public TokenDto toTokenDto() {
        try {
            HttpService httpService = new HttpService();
            String content = httpService.getDataForToken();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(content, TokenDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Can't get token", e);
        }
    }
}
