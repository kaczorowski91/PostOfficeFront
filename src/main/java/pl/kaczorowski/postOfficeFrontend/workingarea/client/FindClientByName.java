package pl.kaczorowski.postOfficeFrontend.workingarea.client;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import pl.kaczorowski.postOfficeFrontend.MainView;
import pl.kaczorowski.postOfficeFrontend.client.ClientClient;
import pl.kaczorowski.postOfficeFrontend.grid.ClientGetNumberByNameField;

@Getter
public class FindClientByName {
    private VerticalLayout findClientByNameLayout = new VerticalLayout();
    private MainView mainView;
    private TextField name = new TextField("Name:");
    private Button findClient = new Button("Find Client");
    private Button cancel = new Button("Cancel");
    private ClientClient clientClient = new ClientClient();
    private ClientGetNumberByNameField clientGetNumberByNameField;
    private Label label = new Label("");


    public FindClientByName(MainView mainView) {
        this.mainView = mainView;
        findClientByNameLayout.add(name, findClient, cancel);
        findUserByName();
        cancelFindUserByName();

    }

    private void findUserByName() {
        findClient.addClickListener(event -> {

            clientGetNumberByNameField = new ClientGetNumberByNameField(label);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().setVisible(true);
            mainView.getSecondPanel().setSizeFull();
            clientGetNumberByNameField.fillData(name.getValue());
            mainView.getSecondPanel().add(new VerticalLayout(label));
            label.setVisible(true);

        });
    }

    private void cancelFindUserByName() {
        cancel.addClickListener(event -> {
            clearFields();
            mainView.getSecondPanel().removeAll();
            mainView.getAccordion().close();
        });
    }

    private void clearFields() {
        name.clear();
    }

}
