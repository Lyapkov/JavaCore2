package Lesson1;

public class General {

    public static void main(String[] args){
        Team team = createTeam();
        Course course = new Course(400, 200, 1);
        System.out.println(team);;
        course.doIt(team);
        team.showResults();
    }

    private static Team createTeam(){
        Cat cat1 = new Cat("Barsik", 3, "Black");
        Cat cat2 = new Cat("Murzik", 4, "Gray", 250, 150, 3);
        Dog dog1 = new Dog("Bobik", 6, "White");
        Dog dog2 = new Dog("Bimka", 10, "Black", 1500, 300, 0.5);
        return new Team("First", cat1, cat2, dog1, dog2);
    }

}
