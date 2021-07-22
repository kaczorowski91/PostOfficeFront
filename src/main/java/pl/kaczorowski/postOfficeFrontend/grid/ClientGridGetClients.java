package pl.kaczorowski.postOfficeFrontend.grid;

import com.vaadin.flow.component.grid.Grid;
import lombok.Getter;
import pl.kaczorowski.postOfficeFrontend.client.ClientClient;
import pl.kaczorowski.postOfficeFrontend.domain.Client.ClientDtoList;

@Getter
public class ClientGridGetClients {

    private ClientClient clientClient = new ClientClient();
    private Grid<ClientDtoList> clientDtoListGrid = new Grid<>(ClientDtoList.class);


    public ClientGridGetClients() {
        clientDtoListGrid.setColumns("name", "number");
    }

    public void fillDataClients() {
        clientDtoListGrid.setItems(clientClient.getClients());
    }
}
