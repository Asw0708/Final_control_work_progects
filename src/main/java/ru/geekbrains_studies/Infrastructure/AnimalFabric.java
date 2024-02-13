package ru.geekbrains_studies.Infrastructure;

import ru.geekbrains_studies.Infrastructure.Shared.DateService;
import ru.geekbrains_studies.Animals.Base.Animal;
import ru.geekbrains_studies.Animals.Pets.Dog.Dog;
import ru.geekbrains_studies.Animals.Pets.Cat.Cat;
import ru.geekbrains_studies.Animals.Pets.Hamster.Hamster;
import ru.geekbrains_studies.Animals.PackAnimals.Camel.Camel;
import ru.geekbrains_studies.Animals.PackAnimals.Donkey.Donkey;
import ru.geekbrains_studies.Animals.PackAnimals.Horse.Horse;



import java.util.Collections;
import java.util.List;

public class AnimalFabric {

    public static void fillAnimals(List<Animal> animals) {
        addDogs(animals);
        addCats(animals);
        addHamsters(animals);
        addHorses(animals);
        addCamels(animals);
        addDonkeys(animals);
        shuffle(animals);
    }

    private static void shuffle(List<Animal> animals) {
        Collections.shuffle(animals);
    }

    private static void addDogs(List<Animal> animals) {
        Dog fido = Dog.create("Fido", DateService.stringToDate("01-01-2020"));
        fido.commandSit();
        fido.commandStay();
        fido.commandFetch();
        animals.add(fido);

        Dog buddy = Dog.create("Buddy", DateService.stringToDate("10-12-2018"));
        buddy.commandSit();
        buddy.commandPaw();
        buddy.commandBark();
        animals.add(buddy);

        Dog bella = Dog.create("Bella", DateService.stringToDate("11-11-2019"));
        bella.commandSit();
        bella.commandStay();
        bella.commandRoll();
        animals.add(bella);
    }

    private static void addCats(List<Animal> animals) {
        Cat whiskers = Cat.create("Whiskers", DateService.stringToDate("15-05-2019"));
        whiskers.commandSit();
        whiskers.commandPounce();
        animals.add(whiskers);

        Cat smudge = Cat.create("Smudge", DateService.stringToDate("20-02-2020"));
        smudge.commandSit();
        smudge.commandPounce();
        smudge.commandScratch();
        animals.add(smudge);

        Cat oliver = Cat.create("Oliver", DateService.stringToDate("30-06-2020"));
        oliver.commandMeow();
        oliver.commandScratch();
        oliver.commandJump();
        animals.add(oliver);
    }

    private static void addHamsters(List<Animal> animals) {
        Hamster hammy = Hamster.create("Hammy", DateService.stringToDate("10-03-2021"));
        hammy.commandRoll();
        hammy.commandHide();
        animals.add(hammy);

        Hamster peanut = Hamster.create("Peanut", DateService.stringToDate("10-03-2021"));
        peanut.commandRoll();
        peanut.commandSpin();
        animals.add(peanut);
    }

    private static void addHorses(List<Animal> animals) {
        Horse thunder = Horse.create("Thunder", DateService.stringToDate("15-07-2021"));
        thunder.commandTrot();
        thunder.commandCanter();
        thunder.commandGallop();
        animals.add(thunder);

        Horse storm = Horse.create("Storm", DateService.stringToDate("05-05-2014"));
        storm.commandTrot();
        storm.commandCanter();
        animals.add(storm);

        Horse blaze = Horse.create("Blaze", DateService.stringToDate("29-02-2016"));
        blaze.commandTrot();
        blaze.commandJump();
        blaze.commandGallop();
        animals.add(blaze);
    }


    private static void addDonkeys(List<Animal> animals) {
        Donkey eeyore = Donkey.create("Eeyore", DateService.stringToDate("18-09-2017"));
        eeyore.commandWalk();
        eeyore.commandCarryLoad();
        eeyore.commandBray();
        animals.add(eeyore);

        Donkey burro = Donkey.create("Burro", DateService.stringToDate("23-01-2019"));
        burro.commandWalk();
        burro.commandBray();
        burro.commandKick();
        animals.add(burro);
    }

    private static void addCamels(List<Animal> animals) {
        Camel sandy = Camel.create("Sandy", DateService.stringToDate("03-11-2016"));
        sandy.commandWalk();
        sandy.commandCarryLoad();
        animals.add(sandy);

        Camel dune = Camel.create("Dune", DateService.stringToDate("12-12-2018"));
        dune.commandWalk();
        dune.commandSit();
        animals.add(dune);

        Camel sahara = Camel.create("Sahara", DateService.stringToDate("14-08-2015"));
        sahara.commandWalk();
        sahara.commandRun();
        animals.add(sahara);
    }

}
