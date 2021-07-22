package pl.kaczorowski.postOfficeFrontend.workingarea.client;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Getter;
import pl.kaczorowski.postOfficeFrontend.MainView;
import pl.kaczorowski.postOfficeFrontend.client.ClientClient;
import pl.kaczorowski.postOfficeFrontend.grid.ClientGetNumberByNumberField;

@Getter
public class FindClientByNumber {
    private VerticalLayout findClientByNumberLayout = new VerticalLayout();
    private MainView mainView;
    private TextField number = new TextField("Number:");
    private Button findClient = new Button("Find Client");
    private Button cancel = new Button("Cancel");
    private ClientClient clientClient = new ClientClient();
    private ClientGetNumberByNumberField clientGetNumberByNumberField;
    private Label label = new Label("");


    public FindClientByNumber(MainView mainView) {
        this.mainView = mainView;
        findClientByNumberLayout.add(number, findClient, cancel);
        findUserByName();
        cancelFindUserByName();

    }

    private void findUserByName() {
        findClient.addClickListener(event -> {

            clientGetNumberByNumberField = new ClientGetNumberByNumberField(label);
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().removeAll();
            mainView.getSecondPanel().setVisible(true);
            mainView.getSecondPanel().setSizeFull();
            clientGetNumberByNumberField.fillData(Integer.parseInt(number.getValue()));
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
        number.clear();
    }

}
