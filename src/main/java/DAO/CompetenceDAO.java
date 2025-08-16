package DAO;

import Model.Competence;
import java.util.List;

public interface CompetenceDAO {
    List<Competence> getAll();
    Competence getByName(String name);
}
