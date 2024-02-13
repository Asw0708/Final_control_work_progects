package ru.geekbrains_studies.IOBI.Menus;

import ru.geekbrains_studies.IOBI.ConsoleIOBI;
import ru.geekbrains_studies.IOBI.Base.MenuItem;
import ru.geekbrains_studies.IOBI.Base.Menu;

import java.util.ArrayList;

public class StudyMenu extends Menu {
    public StudyMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyDogs, "Обучить собак"));
        menuItems.add(new MenuItem(this::studyCats, "Обучить кошек"));
        menuItems.add(new MenuItem(this::studyHamsters, "Обучить хомяков"));
        menuItems.add(new MenuItem(this::studyHorses, "Обучить лошадей"));
        menuItems.add(new MenuItem(this::studyCamels, "Обучить верблюдов"));
        menuItems.add(new MenuItem(this::studyDonkeys, "Обучить ослов"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    public void studyDogs() {
        ConsoleIOBI.setMenu(new StudyDogMenu());
    }

    public void studyCats() {
        ConsoleIOBI.setMenu(new StudyCatMenu());
    }

    public void studyHamsters() {
        ConsoleIOBI.setMenu(new StudyHamsterMenu());
    }

    public void studyHorses() {
        ConsoleIOBI.setMenu(new StudyHorseMenu());
    }

    public void studyCamels() {
        ConsoleIOBI.setMenu(new StudyCamelMenu());
    }

    public void studyDonkeys() {
        ConsoleIOBI.setMenu(new StudyDonkeyMenu());
    }

    public void back() {
        ConsoleIOBI.setMenu(new MainMenu());
    }
}
