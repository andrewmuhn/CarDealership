package com.pluralsight.CarDealership.consoleapp.utils;

import java.util.*;

public class CreateMenu {
    private HashMap<String, String> options;
    private String menuHeader;
    private boolean indentBool;
    static Scanner scanner = new Scanner(System.in);

    public CreateMenu(HashMap<String, String> options, String menuHeader, boolean indentBool) {
        this.options = options;
        this.menuHeader = menuHeader;
        this.indentBool = indentBool;
    }

    public CreateMenu(HashMap<String, String> options, String menuHeader) {
        this.options = options;
        this.menuHeader = menuHeader;
        this.indentBool = false;
    }

    public Integer createMenu() {
        Integer menuChoice;
        String indent = indentBool ? "\t" : "";
        ArrayList<Integer> menuOptions = new ArrayList<Integer>();
        HashMap<String, String> colorOptions = new HashMap<>();
        colorOptions.put("Reset", "\u001b[0m");
        colorOptions.put("Black", "\u001b[30m");
        colorOptions.put("Red", "\u001b[31m");
        colorOptions.put("Green", "\u001b[32m");
        colorOptions.put("Yellow", "\u001b[33m");
        colorOptions.put("Blue", "\u001b[34m");
        colorOptions.put("Magenta", "\u001b[35m");
        colorOptions.put("Cyan", "\u001b[36m");
        colorOptions.put("White", "\u001b[37m");

        colorOptions.put("BrBlack", "\u001b[30;1m");
        colorOptions.put("BrRed", "\u001b[31;1m");
        colorOptions.put("BrGreen", "\u001b[32;1m");
        colorOptions.put("BrYellow", "\u001b[33;1m");
        colorOptions.put("BrBlue", "\u001b[34;1m");
        colorOptions.put("BrMagenta", "\u001b[35;1m");
        colorOptions.put("BrCyan", "\u001b[36;1m");
        colorOptions.put("BrWhite", "\u001b[37;1m");

        colorOptions.put("BgBlack", "\u001b[40;1m");
        colorOptions.put("BgRed", "\u001b[41;1m");
        colorOptions.put("BgGreen", "\u001b[42;1m");
        colorOptions.put("BgYellow", "\u001b[43;1m");
        colorOptions.put("BgBlue", "\u001b[44;1m");
        colorOptions.put("BgMagenta", "\u001b[45;1m");
        colorOptions.put("BgCyan", "\u001b[46;1m");
        colorOptions.put("BgWhite", "\u001b[47;1m");

        colorOptions.put("BrBgBlack", "\u001b[40;1m");
        colorOptions.put("BrBgRed", "\u001b[41;1m");
        colorOptions.put("BrBgGreen", "\u001b[42;1m");
        colorOptions.put("BrBgYellow", "\u001b[43;1m");
        colorOptions.put("BrBgBlue", "\u001b[44;1m");
        colorOptions.put("BrBgMagenta", "\u001b[45;1m");
        colorOptions.put("BrBgCyan", "\u001b[46;1m");
        colorOptions.put("BrBgWhite", "\u001b[47;1m");

        List<Map.Entry<String, String>> entries = new ArrayList<>(options.entrySet());
        for (int i = 0; i < entries.size(); i++) {
            menuOptions.add(i + 1);
        }
        menuOptions.add(99);

        while (true) {
            System.out.printf("%s%s\n", indent, menuHeader);
            for (int i = 0; i < entries.size(); i++) {
                Map.Entry<String, String> entry = entries.get(i);
                System.out.printf("%s\t%s%d. %s\n", indent, colorOptions.get(entry.getValue()), i + 1, entry.getKey());
                System.out.print(colorOptions.get("Reset"));
            }
            System.out.printf("%s\t%s%d. %s\n", indent, colorOptions.get("BrRed"), 99, "Exit");
            System.out.print(colorOptions.get("Reset"));
            menuChoice = scanner.nextInt();
            if (menuOptions.contains(menuChoice)) {
                break;
            } else {
                printWrongChoice(menuOptions);
            }
        }
        return menuChoice;
    }
    private void printWrongChoice(ArrayList<Integer> menuOptions) {
        String baseString = "Input invalid. Please respond with ";
        if (menuOptions.size() == 1) {
            System.out.printf("%s%d\n", baseString, menuOptions.get(0));
        } else if (menuOptions.size() == 2) {
            System.out.printf("%s%d or %d\n", baseString, menuOptions.get(0), menuOptions.get(1));
        } else if (menuOptions.size() > 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < menuOptions.size() - 1; i++) {
                sb.append(menuOptions.get(i)).append(", ");
            }
            sb.append("or ").append(menuOptions.get(menuOptions.size() - 1));
            System.out.printf("%s%s\n", baseString, sb.toString());
        }
    }
}
