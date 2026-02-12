package Model;

public class ExperienceCompetence implements DisplayableCompetence{
    private Experience e;
    private Competence c;
    private String level;
    private int order;

    public ExperienceCompetence() {
    }

    public ExperienceCompetence(Experience e, Competence c, String level, int order) {
        this.e = e;
        this.c = c;
        this.level = level;
        this.order = order;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String getDisplayTitle() {
        return e.getTitle();
    }

    @Override
    public String getDisplayType() {
        return "Expérience";
    }
}
