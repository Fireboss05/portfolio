package Model;

public class ProjectCompetence implements DisplayableCompetence {
    private Project p;
    private Competence c;
    private String level;
    private int order;

    public ProjectCompetence() {
    }

    public ProjectCompetence(Project p, Competence c, String level, int order) {
        this.p = p;
        this.c = c;
        this.level = level;
        this.order = order;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String getDisplayTitle() {
        return p.getTitle();
    }

    @Override
    public String getDisplayType() {
        return "Projet";
    }
}
