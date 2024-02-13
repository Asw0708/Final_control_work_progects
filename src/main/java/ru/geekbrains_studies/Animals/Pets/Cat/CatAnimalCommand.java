package ru.geekbrains_studies.Animals.Pets.Cat;

import ru.geekbrains_studies.Animals.Base.AnimalCommand;

import java.util.UUID;

public class CatAnimalCommand extends AnimalCommand {
    public static final String SIT = "Сидеть";
    public static final String POUNCE = "Наброситься";
    public static final String SCRATCH = "Царапаться";
    public static final String JUMP = "Прыгать";
    public static final String MEOW = "Мяукать";

    private CatAnimalCommand(UUID id, UUID animalId, String title) {
        super(id, animalId, title);
    }

    public static CatAnimalCommand commandSit(UUID animalId){
        return new CatAnimalCommand(UUID.randomUUID(), animalId, SIT);
    }

    public static CatAnimalCommand commandPounce(UUID animalId){
        return new CatAnimalCommand(UUID.randomUUID(), animalId, POUNCE);
    }

    public static CatAnimalCommand commandScratch(UUID animalId){
        return new CatAnimalCommand(UUID.randomUUID(), animalId, SCRATCH);
    }

    public static CatAnimalCommand commandMeow(UUID animalId){
        return new CatAnimalCommand(UUID.randomUUID(), animalId, MEOW);
    }

    public static CatAnimalCommand commandJump(UUID animalId){
        return new CatAnimalCommand(UUID.randomUUID(), animalId, JUMP);
    }
}
