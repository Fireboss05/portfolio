package DAO;

import Model.Project;
import java.util.List;

public interface ProjectDAO {
    List<Project> getAll();
    Project getByTitle(String title);
}
