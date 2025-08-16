package Model;

public class ExperienceCompetence {
    private Experience e;
    private Competence c;
    private String level;

    public ExperienceCompetence() {
    }

    public ExperienceCompetence(Experience e, Competence c, String level) {
        this.e = e;
        this.c = c;
        this.level = level;
    }

    public Experience getE() {
        return e;
    }

    public void setE(Experience e) {
        this.e = e;
    }

    public Competence getC() {
        return c;
    }

    public void setC(Competence c) {
        this.c = c;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
