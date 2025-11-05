package ch.makery.address;

import ch.makery.address.model.Person;
import ch.makery.address.repository.PersonRepository;
import ch.makery.address.util.FileUtil;
import ch.makery.address.view.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.File;


public class MainApp extends Application {

    private Stage primaryStage;
    private FileUtil fileUtil = new FileUtil();
    private PersonRepository personRepository = new PersonRepository();
    private ViewManager viewManager = new  ViewManager();

    public MainApp() {
    }

    public PersonRepository getPersonRepository() {
        return this.personRepository;
    }

    public ObservableList<Person> getPersonData() {
        return this.personRepository.getPersons();
    }

    public Stage getPrimaryStage() {
        return this.primaryStage;
    }

    public ViewManager getViewManager() {
        return this.viewManager;
    }

    public FileUtil getFileUtil() {
        return this.fileUtil;
    }


    // ainult salvestab/loeb eelistuse
    public void setPersonFilePath(File file) {
        fileUtil.setPersonFilePath(file);
        if (file != null) {
            this.primaryStage.setTitle("AddressApp - " + file.getName());
        } else {
            this.primaryStage.setTitle("AddressApp");
        }
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");
        this.primaryStage.getIcons().add(new Image(MainApp.class.getResourceAsStream("/images/address_book.png")));

        this.viewManager.setMainApp(this);
        this.viewManager.initRootLayout();
        this.viewManager.showPersonOverview();
    }

    public static void main(String[] args) {
        launch(args);
    }

}