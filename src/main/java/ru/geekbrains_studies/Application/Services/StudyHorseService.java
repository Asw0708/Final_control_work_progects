package ru.geekbrains_studies.Application.Services;

import ru.geekbrains_studies.Animals.Base.Animal;
import ru.geekbrains_studies.Animals.PackAnimals.Horse.Horse;
import ru.geekbrains_studies.Application.Base.Service;

import java.util.List;
import java.util.Optional;

public class StudyHorseService extends Service {


    public List<String> getAvailableHorseNames() {
        return farm.getHorses().stream()
                .map(Animal::getName)
                .toList();
    }

    public String educateHorseCommandCanter(String name) {
        Optional<Horse> result = farm.getHorses().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandCanter();
            db.save(farm);
        }
        return output;
    }

    public String educateHorseCommandTrot(String name) {
        Optional<Horse> result = farm.getHorses().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandTrot();
            db.save(farm);
        }
        return output;
    }

    public String educateHorseCommandGallop(String name) {
        Optional<Horse> result = farm.getHorses().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandGallop();
            db.save(farm);
        }
        return output;
    }

    public String educateHorseCommandJump(String name) {
        Optional<Horse> result = farm.getHorses().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandJump();
            db.save(farm);
        }
        return output;
    }

}
