package Lesson3;

import java.util.HashMap;

public class Task1 {

    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();
        String[] words = new String[]{"1", "1", "1", "2", "2", "3", "4", "5", "6", "7", "7", "8", "9"};
        for (String word: words){
            map.merge(word, 1, Integer::sum);
        }
        System.out.println(map);
    }

}
