package DAO;

import Model.Project;
import java.util.List;

public interface ProjectDAO {
    List<Project> getAll();
    Project getByName(String name);
    Project getByTitle(String title);
}
