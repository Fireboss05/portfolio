package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Experience {

    private String title;
    private String company;
    private String contract_type;

    private String start_date;
    private String end_date;

    private String city;
    private String region;
    private String country;

    private List<String> missions;

    private String type;

    public Experience(){

    }

    public Experience(String title, String company, String contract_type, String start_date, String end_date, String city, String region, String country, List<String> missions, String type) {
        this.title = (title != null) ? title : "Missing Title";
        this.company = (company != null) ? company : "Missing Company";
        this.contract_type = (contract_type != null) ? contract_type : "Missing Contract Type";
        this.start_date = (start_date != null) ? start_date : "Missing Start Date";
        this.end_date = (end_date != null) ? end_date : "Missing End Date";
        this.city = (city != null) ? city : "Missing City";
        this.region = (region != null) ? region : "Missing Region";
        this.country = (country != null) ? country : "Missing Country";
        this.missions = (missions != null) ? missions : new ArrayList<>();
        this.type = (type != null) ? type : "Missing Type";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getMissions() {
        return missions;
    }

    public void setMissions(List<String> missions) {
        this.missions = missions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        //TODO change to something more accurate, like title + company + date or IDK, for the moment it's reflective of the BDD implementation but can be improved
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        //TODO change to something more accurate, like title + company + date or IDK, for the moment it's reflective of the BDD implementation but can be improved
        return Objects.hashCode(title);
    }
}
