package pl.kaczorowski.postOfficeFrontend.domain.Client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClientDto {

    private String name;
    private Status status;
    private Integer pin;

    public CreateClientDto(String name, Status status, Integer pin) {
        this.name = name;
        this.status = status;
        this.pin = pin;
    }


}
