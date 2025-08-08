package Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vignette{
    static final String PROJECT_VIGNETTE_IMAGE_PATH = "./images/projets/vignettes/";

    private String title;
    private String description;
    @JsonProperty("image")
    private String imageFilename;

    public Vignette(){

    }

    public Vignette(String title, String description, String imageFilename) {
        this.title = title;
        this.description = description;
        this.imageFilename = imageFilename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageFilename() {
        return imageFilename;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }

    public String getImagePath() {
        return PROJECT_VIGNETTE_IMAGE_PATH + imageFilename;
    }
}
