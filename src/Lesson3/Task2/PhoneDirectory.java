package Lesson3.Task2;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhoneDirectory {
    
    private static HashMap<String, Set<String>> phones = new HashMap<>();
    
    public static void add(String lastName, String phone){
        phones.computeIfAbsent(lastName, k -> new HashSet<>()).add(phone); /* Как задать правило добавления в массив */
    }

    public static Set<String> get(String lastName){
        return phones.get(lastName);
    }

}
