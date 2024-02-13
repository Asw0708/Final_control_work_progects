package ru.geekbrains_studies.IOBI.Menus;

import ru.geekbrains_studies.Education.StudyHorseEducation;
import ru.geekbrains_studies.IOBI.Colors;
import ru.geekbrains_studies.IOBI.ConsoleIOBI;
import ru.geekbrains_studies.Infrastructure.Shared.IEducable;
import ru.geekbrains_studies.IOBI.Base.MenuItem;
import ru.geekbrains_studies.IOBI.Base.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyHorseMenu extends Menu {

    private final StudyHorseEducation education = new StudyHorseEducation();

    public StudyHorseMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyTrot, "Обучить бегу рысью"));
        menuItems.add(new MenuItem(this::studyCanter, "Обучить шагу"));
        menuItems.add(new MenuItem(this::studyGallop, "Обучить галопу"));
        menuItems.add(new MenuItem(this::studyJump, "Обучить прыжку"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = education.getAvailableHorseNames();
        if (names.isEmpty()) {
            ConsoleIOBI.println(Colors.RED + "Не найдено ни одного коня/лошади для обучения" + Colors.RESET);
        }
        ConsoleIOBI.println(Colors.GREEN + "Кони/лошади для обучения: " + names + Colors.RESET);
        ConsoleIOBI.println(Colors.YELLOW + "Введите имя: " + Colors.RESET);
        String name = ConsoleIOBI.chooseName(names);
        ConsoleIOBI.println(Colors.YELLOW + educable.invoke(name) + Colors.RESET);
    }

    public void studyTrot() {
        educate(education::learnCommandTrot);
    }

    public void studyCanter() {
        educate(education::learnCommandCanter);
    }

    public void studyJump() {
        educate(education::learnCommandJump);
    }

    public void studyGallop() {
        educate(education::learnCommandGallop);
    }

    public void back() {
        ConsoleIOBI.setMenu(new StudyMenu());
    }
}