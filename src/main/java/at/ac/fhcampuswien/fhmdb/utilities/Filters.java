package at.ac.fhcampuswien.fhmdb.utilities;

import at.ac.fhcampuswien.fhmdb.models.Movie;

public class Filters {
    public static String cleanString (String stringToFilter){
        char[] arrayToClean = stringToFilter.toLowerCase().toCharArray();
        StringBuilder cleanString = new StringBuilder();

        for(char i : arrayToClean) {
            if ((i >= 97 && i <= 122) || (i == 32) || (i >= 48 && i <=57)) {
                cleanString.append(i);
            }
        }
        return cleanString.toString();
    }

    public static boolean filterByString(Movie toCheck, String stringToFilter){
        if (stringToFilter == ""){
            return true;
        }
        if (cleanString(toCheck.getTitle()).contains(cleanString(stringToFilter)) ||
                cleanString(toCheck.getDescription()).contains(cleanString(stringToFilter))){
            return true;
        }
        return false;
    }

    public static boolean filterByGenre(Movie toCheck, String genreToFilter){
        if (genreToFilter == null || genreToFilter == ""){
            return true;
        }
        if (Movie.getGenresToString(toCheck.getGenres()).contains(genreToFilter)){
            return true;
        }
        return false;
    }
}
