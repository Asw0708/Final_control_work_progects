package ru.geekbrains_studies.Education;

import ru.geekbrains_studies.Application.Services.DetailAnimalService;

public class MainEducation{
    private final DetailAnimalService service = new DetailAnimalService();

    public String getAnimalDetails(){
        return service.getAnimalDetail();
    }

    public String getAnimalStatistic(){
        return service.getAnimalStatistic();
    }
}
