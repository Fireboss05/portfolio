package DAO;

import Model.Experience;
import java.util.List;

public interface ExperienceDAO {
    List<Experience> getAll();
    Experience getByTitle(String title);
}

