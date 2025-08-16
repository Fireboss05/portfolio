package DAO;

import Model.ExperienceCompetence;

import java.util.List;

public interface ExperienceCompetenceDAO {
    List<ExperienceCompetence> getAll();

    List<ExperienceCompetence> getByExperienceTitle(String experienceTitle);

    List<ExperienceCompetence> getByCompetenceName(String competenceName);
}
