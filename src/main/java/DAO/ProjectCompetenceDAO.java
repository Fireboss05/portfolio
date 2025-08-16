package DAO;

import Model.ProjectCompetence;

import java.util.List;

public interface ProjectCompetenceDAO {
    List<ProjectCompetence> getAll();

    List<ProjectCompetence> getByProjectTitle(String projectTitle);

    List<ProjectCompetence> getByCompetenceName(String competenceName);
}
