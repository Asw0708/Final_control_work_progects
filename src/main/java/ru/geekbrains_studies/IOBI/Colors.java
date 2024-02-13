package ru.geekbrains_studies.IOBI;

/**
 * Подцветка текста в консоли
 */
public enum Colors {
    BLUE("\033[0;34m"),
    GREEN("\033[0;32m"),
    MAGENTA("\033[0;35m"),
    RED("\033[0;31m"),
    RESET("\033[0;1m"),
    YELLOW("\033[0;33m");

    private final String code;

    Colors(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
