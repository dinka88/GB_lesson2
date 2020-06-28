package ru.dinka88.advlvl.lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Яблоко", "Груша", "Вишня", "Слива", "Вишня", "Груша", "Клубника",
                "Яблоко", "Арбуз", "Черешня", "Вишня", "Персик", "Арбуз", "Персик", "Яблоко",
                "Черешня", "Персик", "Абрикос", "Черешня");
        Set<String> food = new HashSet<>(words);
        System.out.println(food);

        score(words);
        PhoneBook book = new PhoneBook();
        book.add(9161254578L, "Петров");
        book.add(9165478963L, "Иванов");
        book.add(9165478587L, "Петров");
        book.add(9166598564L, "Сидоров");
        book.add(9166654120L, "Иванов");

        System.out.println(book);
        System.out.println(book.get("Иванов"));


    }

    static void score(List<String> words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String item = words.get(i);
            Integer current = map.getOrDefault(item, 0);
            int newValue = current + 1;
            map.put(item, newValue);
        }
        System.out.println(map);
    }

}
