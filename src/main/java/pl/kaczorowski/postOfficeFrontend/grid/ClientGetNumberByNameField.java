package pl.kaczorowski.postOfficeFrontend.grid;


import com.vaadin.flow.component.html.Label;
import lombok.Getter;
import pl.kaczorowski.postOfficeFrontend.client.ClientClient;


@Getter
public class ClientGetNumberByNameField {

    private ClientClient clientClient = new ClientClient();
    private Label label;

    public ClientGetNumberByNameField(Label label) {
        this.label = label;
    }

    public void fillData(String name) {
        label.setText(String.valueOf(clientClient.getClientByName(name)));
    }

}
