package pl.kaczorowski.postOfficeFrontend.domain.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private String name;
    private Status status;
    private Integer pin;

}
