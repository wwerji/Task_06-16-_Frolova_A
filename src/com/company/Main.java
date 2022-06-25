package com.company;

import com.company.HashMap.SimpleHashMap;

import java.io.FileReader;
import java.io.IOException;

public class Main {

    /**
     * 16. Найти в тексте все имена собственные (за таковые считать слова, которые начинаются с
     * большой буквы не в начале предложения) и посчитать, сколько каждое из них
     * встречается
     */

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        try (FileReader reader = new FileReader("C:\\Users\\admin\\Desktop\\Task_06-16-_Frolova_A-main\\src\\com\\company\\text.txt")) {
            int i;
            while ((i = reader.read()) != -1) {
                s.append((char) i);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>(1000);

        int m = 0;
        int n = 0;
        String str = s.toString().replaceAll("\\s+", "");
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) >= 'А' && str.charAt(i) <= 'Я' && str.charAt(i - 1) != '.' && str.charAt(i - 1) != '?' && str.charAt(i - 1) != '!') {
                String key = String.valueOf(str.charAt(i));
                map.put(key, 1);
                m += 1;
            }
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' && str.charAt(i - 1) != '.' && str.charAt(i - 1) != '?' && str.charAt(i - 1) != '!') {
                String key = String.valueOf(str.charAt(i));
                map.put(key, 1);
                n += 1;
            }
        }

        System.out.println("Количество имён собственных:\n" + "RU - " + m + "\nENG - " + n);
    }
}
