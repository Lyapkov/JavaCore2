package Lesson3.Task2;

public class General {

    public static void main(String[] args){
        PhoneDirectory.add("Петров", "89000000001");
        PhoneDirectory.add("Иванов", "89000000002");
        PhoneDirectory.add("Сидоров", "89000000003");
        PhoneDirectory.add("Петров", "89000000004");
        PhoneDirectory.add("Сидоров", "89000000005");
        System.out.println(PhoneDirectory.get("Петров"));
        System.out.println(PhoneDirectory.get("Иванов"));
        System.out.println(PhoneDirectory.get("Сидоров"));
    }

}
