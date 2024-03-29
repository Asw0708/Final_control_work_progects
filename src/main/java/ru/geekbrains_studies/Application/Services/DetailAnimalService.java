package ru.geekbrains_studies.Application.Services;

import ru.geekbrains_studies.Animals.Base.Animal;
import ru.geekbrains_studies.Application.Base.Service;
import ru.geekbrains_studies.Infrastructure.Shared.DateService;
import ru.geekbrains_studies.IOBI.Colors;

public class DetailAnimalService extends Service {

    public String getAnimalDetail() {
        StringBuilder builder = new StringBuilder();
        String format = Colors.MAGENTA + "\n %-8s | %-14s | %-18s | %-7s | %-20s | %-20s ";
            builder.append(String.format(format, "ИМЯ", "ДАТА РОЖДЕНИЯ", "ВОЗРАСТ(в месяцах)", "РОД", "КАТЕГОРИЯ", "КОМАНДЫ"));
        builder.append("\n-------------------------------------------------------------------");
        for (Animal animal : farm.getAllAnimals()) {
            builder.append(String.format(format,
                    animal.getName(),
                    DateService.dateToString(animal.getBirthday()),
                    animal.getAge(),
                    animal.getType().getName(),
                    animal.getType().getCategory().getName(),
                    animal.getLearnedCommands()));
        }
        builder.append(Colors.RESET);
        return builder.toString();
    }

    public String getAnimalStatistic() {
        return String.format("собак: %d, кошек: %d, хомяков: %d, лошадей: %d, ослов: %d, верблюдов: %d, всего: %d",
                farm.getDogs().size(),
                farm.getCats().size(),
                farm.getHamsters().size(),
                farm.getHorses().size(),
                farm.getCamels().size(),
                farm.getDonkeys().size(),
                farm.getAllAnimals().size());
    }

}
