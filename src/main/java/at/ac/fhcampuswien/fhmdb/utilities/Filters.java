package at.ac.fhcampuswien.fhmdb.utilities;

import at.ac.fhcampuswien.fhmdb.models.Movie;

public class Filters {
    public static boolean filterByGenre(Movie toCheck, String genreToFilter){
        if (genreToFilter == null || genreToFilter == ""){
            return true;
        }
        if (Movie.getGenresToString(toCheck.getGenres()).contains(genreToFilter)){
            return true;
        }
        return false;
    }

    public static boolean filterByString(Movie toCheck, String stringToFilter){
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
    public static String cleanString (String stringToFilter){
        char[] arrayToClean = stringToFilter.toCharArray();
        StringBuilder cleanString = new StringBuilder();

        for(char i : arrayToClean) {
            if (i >= 97 && i <= 122 || i == 32) {
                cleanString.append(i);
            }
        }
        return cleanString.toString();
    }
}
