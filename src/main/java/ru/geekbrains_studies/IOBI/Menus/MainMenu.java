package ru.geekbrains_studies.IOBI.Menus;

import ru.geekbrains_studies.Education.MainEducation;
import ru.geekbrains_studies.IOBI.ConsoleIOBI;
import ru.geekbrains_studies.IOBI.Base.MenuItem;
import ru.geekbrains_studies.IOBI.Base.Menu;

import java.util.ArrayList;

public class MainMenu extends Menu {

    private final MainEducation presenter;
    public MainMenu() {
        presenter = new MainEducation();
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::showAnimals, "Показать список животных"));
        menuItems.add(new MenuItem(this::addAnimal, "Добавить новое животное"));
        menuItems.add(new MenuItem(this::studyAnimals, "Обучить животное"));
        menuItems.add(new MenuItem(this::quit, "Выйти"));
    }

    public void quit() {
        ConsoleIOBI.close();
    }

    public void showAnimals() {
        ConsoleIOBI.println(presenter.getAnimalDetails());
    }

    public void addAnimal() {
        ConsoleIOBI.setMenu(new AddAnimalMenu());
    }

    public void studyAnimals() {
        ConsoleIOBI
.setMenu(new StudyMenu());
    }
}
