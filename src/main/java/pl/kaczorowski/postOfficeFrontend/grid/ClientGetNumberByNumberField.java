package pl.kaczorowski.postOfficeFrontend.grid;

import com.vaadin.flow.component.html.Label;
import lombok.Getter;
import pl.kaczorowski.postOfficeFrontend.client.ClientClient;

@Getter
public class ClientGetNumberByNumberField {

    private ClientClient clientClient = new ClientClient();
    private Label label;

    public ClientGetNumberByNumberField(Label label) {
        this.label = label;
    }

    public void fillData(Integer number) {
        label.setText(String.valueOf(clientClient.getClientByNumber(number)));
    }
}
