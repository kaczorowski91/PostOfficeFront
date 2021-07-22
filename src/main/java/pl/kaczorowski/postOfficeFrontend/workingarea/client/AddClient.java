package pl.kaczorowski.postOfficeFrontend.workingarea.client;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import org.springframework.web.client.HttpServerErrorException;
import pl.kaczorowski.postOfficeFrontend.MainView;
import pl.kaczorowski.postOfficeFrontend.client.ClientClient;
import pl.kaczorowski.postOfficeFrontend.domain.Client.Status;
import pl.kaczorowski.postOfficeFrontend.grid.ClientGridGetClients;
import pl.kaczorowski.postOfficeFrontend.domain.Client.CreateClientDto;


@Getter
public class AddClient {
    private VerticalLayout addClientLayout = new VerticalLayout();
    private MainView mainView;
    private TextField name = new TextField("Name:");
    ListBox<String> statusBox = new ListBox<>();
    private TextField pin = new TextField("Pin");
    private Button createClient = new Button("Create Client");
    private Button cancel = new Button("Cancel");
    private ClientClient clientClient = new ClientClient();
    private ClientGridGetClients clientGridGetClients = new ClientGridGetClients();

    public AddClient(MainView mainView) {
        this.mainView = mainView;
        addClientLayout.add(name, statusBox, pin, new HorizontalLayout(createClient, cancel));
        createNewUser();
        cancelCreateClient();
    }

    private void createNewUser() {
        statusBox.setItems(String.valueOf(Status.REGULAR), String.valueOf(Status.VIP), String.valueOf(Status.URGENT));
        statusBox.setValue(String.valueOf(Status.REGULAR));

        createClient.addClickListener(event -> {
            if (pin.getValue().equals("")) {
                pin.setValue(String.valueOf(1234));
                System.out.println(pin);
            }
            try {
                CreateClientDto createClientDto = new CreateClientDto(
                        name.getValue(),
                        Status.valueOf(statusBox.getValue()),
                        Integer.parseInt(pin.getValue())
                );
                clientClient.createClient(createClientDto);
                clearFields();
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().removeAll();
                mainView.getSecondPanel().setVisible(true);
                mainView.getSecondPanel().addComponentAsFirst(clientGridGetClients.getClientDtoListGrid());
                mainView.getSecondPanel().setSizeFull();
                clientGridGetClients.fillDataClients();

            } catch (NumberFormatException e) {
                Notification.show("PIN SHOULD BE NUMBER");
                pin.clear();

            } catch (HttpServerErrorException e) {
                Notification.show("PIN IS NO CORRECT");
                pin.clear();

            }
        });
    }

    private void cancelCreateClient() {
        cancel.addClickListener(event -> {
            clearFields();
            mainView.getSecondPanel().removeAll();
            mainView.getAccordion().close();
        });
    }

    private void clearFields() {
        name.clear();
        pin.clear();
        statusBox.clear();
    }

}
