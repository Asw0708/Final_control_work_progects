package ru.geekbrains_studies.IOBI.Menus;

import ru.geekbrains_studies.Education.StudyHamsterEducation;
import ru.geekbrains_studies.IOBI.Colors;
import ru.geekbrains_studies.IOBI.ConsoleIOBI;
import ru.geekbrains_studies.Infrastructure.Shared.IEducable;
import ru.geekbrains_studies.IOBI.Base.MenuItem;
import ru.geekbrains_studies.IOBI.Base.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyHamsterMenu extends Menu {
    private final StudyHamsterEducation education = new StudyHamsterEducation();

    public StudyHamsterMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyRoll, "Обучить катить что-либо"));
        menuItems.add(new MenuItem(this::studyHide, "Обучить скрыться"));
        menuItems.add(new MenuItem(this::studySpin, "Обучить вращаться"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = education.getAvailableHamsterNames();
        if (names.isEmpty()) {
            ConsoleIOBI.println(Colors.RED + "Не найдено ни одного хомяка для обучения" + Colors.RESET);
        }
        ConsoleIOBI.println(Colors.GREEN + "Хомяки для обучения: " + names + Colors.RESET);
        ConsoleIOBI.println(Colors.YELLOW + "Введите имя: " + Colors.RESET);
        String name = ConsoleIOBI.chooseName(names);
        ConsoleIOBI.println(Colors.YELLOW + educable.invoke(name) + Colors.RESET);
    }

    public void studyRoll() {
        educate(education::learnCommandRoll);
    }

    public void studyHide() {
        educate(education::learnCommandHide);
    }

    public void studySpin() {
        educate(education::learnCommandSpin);
    }

    public void back() {
        ConsoleIOBI.setMenu(new StudyMenu());
    }
}
