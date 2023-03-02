package View;

import Controller.DataController;
import Controller.PersonDto;
import Model.Domains;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.Timestamp;

public class DomainsInterface {
    public void init(Integer id){
        Stage domainsStage = new Stage();

        DataController dataController = new DataController();
        PersonDto personDto = new PersonDto(id);
        TableView<Domains> tableDomains = new TableView<>(dataController.getDomainsByPerson(personDto));

        TableColumn<Domains, Integer> idDomainsColumn = new TableColumn<>("id");
        idDomainsColumn.setMinWidth(50);
        idDomainsColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableDomains.getColumns().add(idDomainsColumn);

        TableColumn<Domains, String> webNameColumn = new TableColumn<>("Имя");
        webNameColumn.setMinWidth(150);
        webNameColumn.setCellValueFactory(new PropertyValueFactory<>("webName"));
        tableDomains.getColumns().add(webNameColumn);

        TableColumn<Domains, String> domainNameColumn = new TableColumn<>("Имя домена");
        domainNameColumn.setMinWidth(150);
        domainNameColumn.setCellValueFactory(new PropertyValueFactory<>("domainName"));
        tableDomains.getColumns().add(domainNameColumn);

        TableColumn<Domains, String> ipColumn = new TableColumn<>("ip");
        ipColumn.setMinWidth(100);
        ipColumn.setCellValueFactory(new PropertyValueFactory<>("ip"));
        tableDomains.getColumns().add(ipColumn);

        TableColumn<Domains, Timestamp> dateRegColumn = new TableColumn<>("Дата регистрации");
        dateRegColumn.setMinWidth(150);
        dateRegColumn.setCellValueFactory(new PropertyValueFactory<>("dateReg"));
        tableDomains.getColumns().add(dateRegColumn);

        TableColumn<Domains, String> countryRegColumn = new TableColumn<>("Страна регистрации");
        countryRegColumn.setMinWidth(100);
        countryRegColumn.setCellValueFactory(new PropertyValueFactory<>("countryReg"));
        tableDomains.getColumns().add(countryRegColumn);

        TableColumn<Domains, Integer> personIDColumn = new TableColumn<>("id владельца");
        personIDColumn.setMinWidth(50);
        personIDColumn.setCellValueFactory(new PropertyValueFactory<>("personId"));
        tableDomains.getColumns().add(personIDColumn);

        StackPane root = new StackPane();
        root.getChildren().add(tableDomains);

        Scene scene = new Scene(root,795,200);

        domainsStage.setTitle("Person");
        domainsStage.setScene(scene);
        domainsStage.initModality(Modality.APPLICATION_MODAL);
        domainsStage.setResizable(false);
        domainsStage.showAndWait();
    }
}
