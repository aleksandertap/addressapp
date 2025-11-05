package ch.makery.address.repository;

import ch.makery.address.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class PersonRepository {

    private ObservableList<Person> persons = FXCollections.observableArrayList();

    public PersonRepository() {
        this.persons.add(new Person("Hans", "Muster"));
        this.persons.add(new Person("Ruth", "Mueller"));
        this.persons.add(new Person("Heinz", "Kurz"));
        this.persons.add(new Person("Cornelia", "Meier"));
        this.persons.add(new Person("Werner", "Meyer"));
        this.persons.add(new Person("Lydia", "Kunz"));
        this.persons.add(new Person("Anna", "Best"));
        this.persons.add(new Person("Stefan", "Meier"));
        this.persons.add(new Person("Martin", "Mueller"));
    }

    public ObservableList<Person> getPersons() {
        return this.persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons.setAll(persons == null ? List.of() : persons);
    }

    public void addPerson(Person person){
        this.persons.add(person);
    }

    public void addPerson(List<Person> personList) {
        this.persons.addAll(personList);
    }

    public void removePerson(Person person){
        this.persons.remove(person);
    }

    public void clear(){
        this.persons.clear();
    }
}
