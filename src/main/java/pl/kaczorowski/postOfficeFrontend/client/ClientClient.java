package pl.kaczorowski.postOfficeFrontend.client;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.kaczorowski.postOfficeFrontend.domain.Client.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

public class ClientClient {

    private RestTemplate restTemplate = new RestTemplate();

    public void createClient(final CreateClientDto createClientDto) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/client")
                .queryParam("Name", createClientDto.getName())
                .queryParam("Status", createClientDto.getStatus())
                .queryParam("Pin", createClientDto.getPin())
                .build().encode().toUri();
        restTemplate.postForObject(url, createClientDto, ClientDto.class);
    }

    public List<ClientDtoList> getClients() {
        try {
            ClientDtoList[] clientResponse = restTemplate.getForObject(
                    "http://localhost:8080/v1/client", ClientDtoList[].class);
            return Arrays.asList(ofNullable(clientResponse).orElse(new ClientDtoList[0]));
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public String getClientByName(final String name) {
        try {
            URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/client/name/")
                    .path(name).build().encode().toUri();
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            return "USER NOT FOUND";
        }
    }

    public String getClientByNumber(final Integer number) {
        try {
            URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/client/number/")
                    .path(String.valueOf(number)).build().encode().toUri();
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            return "USER NOT FOUND";
        }
    }

}
