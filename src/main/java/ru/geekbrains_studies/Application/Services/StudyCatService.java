package ru.geekbrains_studies.Application.Services;

import ru.geekbrains_studies.Animals.Base.Animal;
import ru.geekbrains_studies.Animals.Pets.Cat.Cat;
import ru.geekbrains_studies.Application.Base.Service;

import java.util.List;
import java.util.Optional;

public class StudyCatService extends Service {

    //#region study cats
    public List<String> getAvailableCatNames() {
        return farm.getCats().stream()
                .map(Animal::getName)
                .toList();
    }

    public String educateCatCommandSit(String name) {
        Optional<Cat> result = farm.getCats().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandSit();
            db.save(farm);
        }
        return output;
    }

    public String educateCatCommandPounce(String name) {
        Optional<Cat> result = farm.getCats().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandPounce();
            db.save(farm);
        }
        return output;
    }

    public String educateCatCommandScratch(String name) {
        Optional<Cat> result = farm.getCats().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandScratch();
            db.save(farm);
        }
        return output;
    }

    public String educateCatCommandMeow(String name) {
        Optional<Cat> result = farm.getCats().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandMeow();
            db.save(farm);
        }
        return output;
    }

    public String educateCatCommandJump(String name) {
        Optional<Cat> result = farm.getCats().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandJump();
            db.save(farm);
        }
        return output;
    }


}
