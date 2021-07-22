package pl.kaczorowski.postOfficeFrontend;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import pl.kaczorowski.postOfficeFrontend.menu.ClientMenu;

@Route
public class MainView extends AppLayout {

    private ClientMenu clientMenu = new ClientMenu(this);
    private HorizontalLayout firstPanel = new HorizontalLayout();
    private HorizontalLayout secondPanel = new HorizontalLayout();
    private Accordion accordion = new Accordion();
    private Label menuLabel = new Label("POST OFFICE QUEUE APP");


    public MainView() {
        firstPanel.add(menuLabel);
        firstPanel.add(setAccordion());
        setContent(new HorizontalLayout(firstPanel, secondPanel));
    }

    public Accordion getAccordion() {
        return accordion;
    }

    private Accordion setAccordion() {
        accordion.add("Client", clientMenu.getClientLayout());
        accordion.addOpenedChangeListener(event -> secondPanel.removeAll());
        accordion.close();
        return accordion;
    }

    public HorizontalLayout getSecondPanel() {
        return secondPanel;
    }
}

