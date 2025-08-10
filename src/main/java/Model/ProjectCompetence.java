package Model;

public class ProjectCompetence {
    private Project p;
    private Competence c;
    private String level;

    public ProjectCompetence() {
    }

    public ProjectCompetence(Project p, Competence c, String level) {
        this.p = p;
        this.c = c;
        this.level = level;
    }

    public Project getP() {
        return p;
    }

    public void setP(Project p) {
        this.p = p;
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
