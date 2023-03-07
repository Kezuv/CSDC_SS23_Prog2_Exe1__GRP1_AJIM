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
            filteredMovies.addAll(filterByGenre(allMovies, (String) genreComboBox.getValue()));
            observableMovies.addAll(filterByString(filteredMovies, searchField.getText()));
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

    public List<Movie> filterByGenre(List<Movie> allMovies, String genreToFilter){

        List<Movie> filteredList = new ArrayList<>();
            if (genreToFilter == null || genreToFilter == ""){
                return allMovies;
            }

            for (int i = 0; i < allMovies.size(); i++){
                    if (Movie.getGenresToString(allMovies.get(i).getGenres()).contains(genreToFilter)){
                        filteredList.add(allMovies.get(i));
                    }
                }
            return filteredList;
    }

    public List<Movie> filterByString(List<Movie> filteredByGenre, String stringToFilter){
        List<Movie> filteredList = new ArrayList<>();

        stringToFilter.toLowerCase();

        if (stringToFilter == ""){
            return filteredByGenre;
        }


        for (int i = 0; i < filteredByGenre.size(); i ++){
                if (filteredByGenre.get(i).getTitle().toLowerCase().contains(stringToFilter) ||
                    filteredByGenre.get(i).getDescription().toLowerCase().contains(stringToFilter)){
                    filteredList.add(filteredByGenre.get(i));
                }
        }

        return filteredList;
    }
}