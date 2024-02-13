package ru.geekbrains_studies.Application.Services;

import ru.geekbrains_studies.Animals.Base.Animal;
import ru.geekbrains_studies.Animals.Pets.Hamster.Hamster;
import ru.geekbrains_studies.Application.Base.Service;

import java.util.List;
import java.util.Optional;

public class StudyHamsterService extends Service {


    public List<String> getAvailableHamsterNames() {
        return farm.getHamsters().stream()
                .map(Animal::getName)
                .toList();
    }

    public String educateHamsterCommandHide(String name) {
        Optional<Hamster> result = farm.getHamsters().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandHide();
            db.save(farm);
        }
        return output;
    }

    public String educateHamsterCommandRoll(String name) {
        Optional<Hamster> result = farm.getHamsters().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandRoll();
            db.save(farm);
        }
        return output;
    }

    public String educateHamsterCommandSpin(String name) {
        Optional<Hamster> result = farm.getHamsters().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandSpin();
            db.save(farm);
        }
        return output;
    }

}
