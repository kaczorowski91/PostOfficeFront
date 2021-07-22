package pl.kaczorowski.postOfficeFrontend.menu;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;
import lombok.Setter;
import pl.kaczorowski.postOfficeFrontend.MainView;
import pl.kaczorowski.postOfficeFrontend.grid.ClientGetNumberByNameField;
import pl.kaczorowski.postOfficeFrontend.grid.ClientGridGetClients;
import pl.kaczorowski.postOfficeFrontend.workingarea.client.AddClient;
import pl.kaczorowski.postOfficeFrontend.workingarea.client.FindClientByName;
import pl.kaczorowski.postOfficeFrontend.workingarea.client.FindClientByNumber;

@Getter
@Setter
public class ClientMenu {
    private Button createClient = new Button("Create client");
    private Button showQueue = new Button("Show Queue");
    private Button findClientByName = new Button("Find Client by Name");
    private Button findClientByNumber = new Button("Find Client by Number");

    private VerticalLayout clientLayout = new VerticalLayout();
    private ClientGridGetClients clientGridGetClients;
    private ClientGetNumberByNameField clientGetNumberByNameField;

    public ClientMenu(MainView mainView) {

        createClient.addClickListener(event -> {
            AddClient addClient = new AddClient(mainView);
            addClient.getAddClientLayout().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().add(addClient.getAddClientLayout());
        });

        showQueue.addClickListener(event -> {
            clientGridGetClients = new ClientGridGetClients();
            clientGridGetClients.getClientDtoListGrid().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().setVisible(true);
            mainView.getSecondPanel().addComponentAsFirst(clientGridGetClients.getClientDtoListGrid());
            mainView.getSecondPanel().setSizeFull();
            clientGridGetClients.fillDataClients();
        });

        findClientByName.addClickListener(event -> {
            FindClientByName findClientByName = new FindClientByName(mainView);
            findClientByName.getFindClientByNameLayout().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().add(findClientByName.getFindClientByNameLayout());

        });

        findClientByNumber.addClickListener(event -> {
            FindClientByNumber findClientByNumber = new FindClientByNumber(mainView);
            findClientByNumber.getFindClientByNumberLayout().setVisible(true);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().add(findClientByNumber.getFindClientByNumberLayout());

        });

        clientLayout.add(showQueue, createClient,findClientByName,findClientByNumber);

    }

    public VerticalLayout getUserLayout() {
        return clientLayout;
    }
}
