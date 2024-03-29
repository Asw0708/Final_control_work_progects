package ru.geekbrains_studies.Education;

import ru.geekbrains_studies.Application.Services.StudyHorseService;

import java.util.List;

public class StudyHorseEducation {
    private final StudyHorseService service = new StudyHorseService();
    public List<String> getAvailableHorseNames() {
        return service.getAvailableHorseNames();
    }

    public String learnCommandCanter(String name) {
        return service.educateHorseCommandCanter(name);
    }

    public String learnCommandTrot(String name) {
        return service.educateHorseCommandTrot(name);
    }

    public String learnCommandGallop(String name) {
        return service.educateHorseCommandGallop(name);
    }

    public String learnCommandJump(String name) {
        return service.educateHorseCommandJump(name);
    }

}
