package at.ac.fhcampuswien.fhmdb.models;

public class Genre {

    private String kindOfGenre;

    public Genre(String kindOfGenre) {
        this.kindOfGenre = kindOfGenre;
    }

    public String getKindOfGenre() {
        return kindOfGenre;
    }
}
