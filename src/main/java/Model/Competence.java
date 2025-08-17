package Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Competence {
    private String name;
    @JsonProperty("detail_file_name")
    private String detailFileName;

    public Competence() {
    }

    public Competence(String name, String detailFileName) {
        this.name = name;
        this.detailFileName = detailFileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Competence that = (Competence) o;
        return Objects.equals(name, that.name) && Objects.equals(detailFileName, that.detailFileName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name) ^ Objects.hashCode(detailFileName);
    }
}
