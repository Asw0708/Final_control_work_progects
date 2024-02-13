package ru.geekbrains_studies.Animals.Pets.Hamster;

import ru.geekbrains_studies.Animals.Base.AnimalCommand;

import java.util.UUID;

public class HamsterAnimalCommand extends AnimalCommand {

    public static final String ROLL = "Свернуть";
    public static final String HIDE = "Спрятаться";
    public static final String SPIN = "Крутиться";
    private HamsterAnimalCommand(UUID id, UUID animalId, String title) {
        super(id, animalId, title);
    }

    public static HamsterAnimalCommand commandRoll(UUID animalId){
        return new HamsterAnimalCommand(UUID.randomUUID(), animalId, ROLL);
    }

    public static HamsterAnimalCommand commandHide(UUID animalId){
        return new HamsterAnimalCommand(UUID.randomUUID(), animalId, HIDE);
    }

    public static HamsterAnimalCommand commandSpin(UUID animalId){
        return new HamsterAnimalCommand(UUID.randomUUID(), animalId, SPIN);
    }

}
