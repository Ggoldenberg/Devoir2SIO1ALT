package sio.gestionpermis;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import sio.gestionpermis.Model.Eleve;
import sio.gestionpermis.Model.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GestionPermisController implements Initializable
{
    private ArrayList<Eleve> lesEleves;
    Eleve nbFautesModif;
    Eleve eleve;
    @FXML
    private ComboBox cboTests;
    @FXML
    private TextField txtNomEleve;
    @FXML
    private Button btnInscription;
    @FXML
    private ComboBox cboEleves;
    @FXML
    private TableView<Test> tvTests;
    @FXML
    private CheckBox chkTermine;
    @FXML
    private Button btnModifier;
    @FXML
    private TableColumn tcNomTest;
    @FXML
    private TableColumn tcNbFautes;
    @FXML
    private TableColumn tcTermine;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        lesEleves = new ArrayList<>();
        initDatas();
        cboTests.getItems().addAll("Test n°1","Test n°2","Test n°3","Test n°4","Test n°5");
        cboTests.getSelectionModel().selectFirst();

        cboEleves.getItems().addAll("Enzo", "Noa", "Lilou");
        cboEleves.getSelectionModel().selectFirst();

        tcNomTest.setCellValueFactory(new PropertyValueFactory<>("nomTest"));
        tcNbFautes.setCellValueFactory(new PropertyValueFactory<>("nbFautes"));
        tcTermine.setCellValueFactory(new PropertyValueFactory<>("estTermine"));


        tcNbFautes.setCellFactory(tc -> new TextFieldTableCell<>(new IntegerStringConverter()));
        tcNbFautes.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent event) {
                TableColumn.CellEditEvent<Object, Object> cellEditEvent = null;
                nbFautesModif.getLesTests().get(cellEditEvent.getTablePosition().getRow()).setNbFautes(Integer.parseInt(cellEditEvent.getNewValue().toString()));

            }
        });

        // A chaque changement dans la CombBox des élèves : partie MODIFICATION
        cboEleves.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                if(newValue!=null)
                {
                    tcNomTest.setCellValueFactory(new PropertyValueFactory<>("nomTest"));
                    tcNbFautes.setCellValueFactory(new PropertyValueFactory<>("nbFautes"));
                    tcTermine.setCellValueFactory(new PropertyValueFactory<>("estTermine"));
                    tvTests.setItems(FXCollections.observableArrayList(eleve.getLesTests()));
                }
            }
        });

    }
    @FXML
    public void btnInscriptionClicked(Event event)
    {
        if (txtNomEleve.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("");
            alert.setContentText("Veuillez saisir le nom de l'élève");
            alert.showAndWait();
        }else if (chkTermine.isSelected()==false)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("");
            alert.setContentText("Vous ne pouvez pas vous inscrire à ce test car il n'est pas terminé");
            alert.showAndWait();
        }

        Eleve nvEleve = new Eleve(txtNomEleve.getText());
        lesEleves.add(nvEleve);
        cboEleves.getItems().add(nvEleve);

        Eleve eleve = (Eleve) cboEleves.getSelectionModel().getSelectedItem();
        tvTests.setItems(FXCollections.observableArrayList(eleve.getLesTests()));





    }

    public void initDatas()
    {
        Eleve eleve1 = new Eleve("Enzo");
        Eleve eleve2 = new Eleve("Noa");
        Eleve eleve3 = new Eleve("Lilou");

        Test test1 = new Test("Test n°1",0,false);
        Test test2 = new Test("Test n°2",0,false);
        Test test3 = new Test("Test n°3",0,false);
        Test test4 = new Test("Test n°4",0,false);
        Test test5 = new Test("Test n°5",0,false);

        eleve1.ajouterTest(test1);eleve1.ajouterTest(test2);
        eleve2.ajouterTest(test3);
        eleve3.ajouterTest(test4);eleve3.ajouterTest(test5);

        lesEleves.add(eleve1);lesEleves.add(eleve2);lesEleves.add(eleve3);
    }

    // NE PAS MODIFIER CE CODE
    // Cette méthode permet de retrouver dans la liste
    // des élèves, l'élève dont le nom est passé en paramètre.
    // Soit on le trouve et dans ce cas on retourne l'objet
    // Soit on ne le trouve pas et dans ce cas on retourne null;
    public Eleve rechercherEleve(String nomEleve)
    {
        Eleve unEleve = null;
        for (Eleve eleve : lesEleves)
        {
            if(eleve.getNomEleve().equals(nomEleve))
            {
                unEleve = eleve;
                break;
            }
        }
        return unEleve;
    }

    @FXML
    public void btnModifierClicked(Event event)
    {
        // A vous de jouer

    }
}