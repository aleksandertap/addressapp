package ch.makery.address.view;

import ch.makery.address.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.chart.PieChart;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CityStatsController {

    @FXML
    private PieChart city;


    @FXML
    private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

    @FXML
    private void initialize(){
        city.setData(pieChartData);
    }

    public void setPersonData(List<Person> persons) {
        Map<String, Long> cityCounts = persons.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));

        cityCounts.forEach((cityName, count) -> {
            pieChartData.add(new PieChart.Data(cityName + " (" + count + ")", count));
        });

    }

}
