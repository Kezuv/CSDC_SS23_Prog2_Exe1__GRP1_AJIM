package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        genreComboBox.setPromptText("Filter by Genre");
        genreComboBox.getItems().addAll("","ACTION", "ADVENTURE", "ANIMATION", "BIOGRAPHY", "COMEDY",
                "CRIME", "DRAMA", "DOCUMENTARY", "FAMILY", "FANTASY", "HISTORY", "HORROR",
                "MUSICAL", "MYSTERY", "ROMANCE", "SCIENCE_FICTION", "SPORT", "THRILLER", "WAR",
                "WESTERN");

        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here
        searchBtn.setOnAction(actionEvent -> {
            observableMovies.clear();

            List<Movie> filteredMovies = new ArrayList<>();

            for (int m = 0; m < allMovies.size(); m ++){
                if (filterByGenre(allMovies.get(m), (String) genreComboBox.getValue())){
                    if (filterByString(allMovies.get(m), searchField.getText())){
                        filteredMovies.add(allMovies.get(m));
                    }
                }
            }

            observableMovies.addAll(filteredMovies);
        });

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if(sortBtn.getText().equals("Sort (asc)")) {
                sortBtn.setText("Sort (desc)");
                observableMovies.sort(Movie::compareTo);
            } else {
                sortBtn.setText("Sort (asc)");
                observableMovies.sort(Collections.reverseOrder(Movie::compareTo));
            }
        });

    }

    public boolean filterByGenre(Movie toCheck, String genreToFilter){

            if (genreToFilter == null || genreToFilter == ""){
                return true;
            }

            if (Movie.getGenresToString(toCheck.getGenres()).contains(genreToFilter)){
                return true;
            }
        return false;
    }

    public boolean filterByString(Movie toCheck, String stringToFilter){

        stringToFilter.toLowerCase();

        if (stringToFilter == ""){
            return true;
        }


        if (toCheck.getTitle().toLowerCase().contains(stringToFilter) ||
                toCheck.getDescription().toLowerCase().contains(stringToFilter)){
                    return true;
        }


        return false;
    }
}