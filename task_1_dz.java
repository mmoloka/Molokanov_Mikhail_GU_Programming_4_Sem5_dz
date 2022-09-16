import java.util.ArrayList;
import java.util.TreeMap;

/* Дана строка. Необходимо написать метод, который отсортирует слова в строке по длине с помощью TreeMap.
Строки с одинаковой длиной не должны “потеряться”.
Пример:
“Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись”
Результат:
[и], [ты], [Еще], [день, друг, Пора], [Мороз], [солнце], [чудесный, дремлешь, проснись], [красавица], [прелестный] */

public class task_1_dz {

    public static void main(String[] args) {
        String str = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись";
        TreeMap<Integer, ArrayList<String>> tm = new TreeMap<>();
        for (String item : str.split(" ")) {
            int key = item.length();
            ArrayList<String> value = new ArrayList<>();
            if (tm.containsKey(key)) {
                value = tm.get(key);
                value.add(item);
                tm.put(key, value);
            } else {
                value.add(item);
                tm.put(key, value);
            }
        }
        System.out.println(tm.values());
    }
}