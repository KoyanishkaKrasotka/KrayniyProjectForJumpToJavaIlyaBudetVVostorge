package ru.jumptojava.kinopoiskz.dto;

public class ImageDto {

    private String imageUrl;

    private String previewUrl;

    public ImageDto() {
    }

    public ImageDto(String imageUrl, String previewUrl) {
        this.imageUrl = imageUrl;
        this.previewUrl = previewUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }
}
