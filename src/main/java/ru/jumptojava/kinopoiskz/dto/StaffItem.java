package ru.jumptojava.kinopoiskz.dto;

public class StaffItem {

    private Integer staffId;

    private String nameRu;

    private String nameEn;

    private String description;

    private String posterUrl;

    private String professionText;

    private String professionKey;

    public StaffItem() {
    }

    public StaffItem(Integer staffId, String nameRu, String nameEn, String description, String posterUrl, String professionText, String professionKey) {
        this.staffId = staffId;
        this.nameRu = nameRu;
        this.nameEn = nameEn;
        this.description = description;
        this.posterUrl = posterUrl;
        this.professionText = professionText;
        this.professionKey = professionKey;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getProfessionText() {
        return professionText;
    }

    public void setProfessionText(String professionText) {
        this.professionText = professionText;
    }

    public String getProfessionKey() {
        return professionKey;
    }



    public void setProfessionKey(String professionKey) {
        this.professionKey = professionKey;
    }
}
