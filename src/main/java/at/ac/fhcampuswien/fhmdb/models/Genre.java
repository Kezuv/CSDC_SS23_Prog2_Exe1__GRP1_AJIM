package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.utilities.Filters;

public class Genre {

    private String kindOfGenre;

    public Genre(String kindOfGenre) {
        kindOfGenre.toUpperCase();
        this.kindOfGenre = kindOfGenre;
    }

    public String getKindOfGenre() {
        return kindOfGenre;
    }
}
