package Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Project {
    static final String PROJECT_IMAGE_PATH = "./images/projets/";

    private String name;
    private String title;
    private String description;
    @JsonProperty("image")
    private String imageFilename;
    private Vignette vignette;
    @JsonProperty("detail_file_name")
    private String detailFileName;

    public Project(){

    }
    public Project(String name, String title, String description, String imageFilename, String detailFileName) {
        this.name = (name != null) ? name : "missing_name";
        this.title = (title != null) ? title : "Missing Title";
        this.description = (description != null) ? description : "Missing Description";
        this.imageFilename = (imageFilename != null) ? imageFilename : "default.png";
        this.detailFileName = (detailFileName != null) ? detailFileName : "default";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return PROJECT_IMAGE_PATH + imageFilename;
    }

    public Vignette getVignette() {
        return vignette;
    }

    public void setVignette(Vignette vignette) {
        this.vignette = vignette;
    }

    public String getDetailFileName() {
        return detailFileName;
    }

    public void setDetailFileName(String detailFileName) {
        this.detailFileName = detailFileName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
