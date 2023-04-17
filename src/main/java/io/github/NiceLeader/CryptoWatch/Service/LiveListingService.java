package io.github.NiceLeader.CryptoWatch.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.NiceLeader.CryptoWatch.model.CurrentListing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

public class LiveListingService {
    public static final String URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/map";

    @Value("${api.coinmarketcap.key}")
    private String apiKey;

    public final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public LiveListingService(RestTemplateBuilder restTempleBuilder, ObjectMapper ObjectMapper) {
        this.restTemplate = restTempleBuilder.build();
        this.objectMapper =  ObjectMapper;
    }

    public CurrentListing getLiveListing(String coin, String currency) {
        URI url = new UriTemplate(URL).expand(coin, currency, apiKey);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return convert(response);
    }
    private CurrentListing convert(ResponseEntity<String> response) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            return new CurrentListing(
                    root.path("data").path("name").asText(),
                    root.path("data").path("quote").path("USD").path("price").decimalValue(),
                    root.path("data").path("quote").path("USD").path("volume_24h").decimalValue(),
                    root.path("data").path("quote").path("USD").path("percent_change_24h").decimalValue(),
                    root.path("data").path("quote").path("USD").path("market_cap").decimalValue()
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
}

