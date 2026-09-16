package ru.jumptojava.kinopoiskz.dto;

public class SimilarFilmItem {

    private Integer filmId;

    private String nameRu;

    private String nameEn;

    private String nameOriginal;

    private String posterUrl;

    private String posterUrlPreview;

    private String relationType;

    public SimilarFilmItem() {
    }

    public SimilarFilmItem(Integer filmId, String nameRu, String nameEn, String nameOriginal, String posterUrl, String posterUrlPreview, String relationType) {
        this.filmId = filmId;
        this.nameRu = nameRu;
        this.nameEn = nameEn;
        this.nameOriginal = nameOriginal;
        this.posterUrl = posterUrl;
        this.posterUrlPreview = posterUrlPreview;
        this.relationType = relationType;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public void setNameOriginal(String nameOriginal) {
        this.nameOriginal = nameOriginal;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getPosterUrlPreview() {
        return posterUrlPreview;
    }

    public void setPosterUrlPreview(String posterUrlPreview) {
        this.posterUrlPreview = posterUrlPreview;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }
}
