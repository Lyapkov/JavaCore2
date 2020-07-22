package Lesson1;

import Lesson1.base.Animal;

public class Course {
    private double sizeRun;
    private double sizeJump;
    private double sizeSalt;

    Course(double sizeRun, double sizeSalt, double sizeJump){
        this.sizeRun = sizeRun;
        this.sizeJump = sizeJump;
        this.sizeSalt = sizeSalt;
    }

    public void doIt(Team team){
        for (Animal animal: team.getAnimals()) {
            if (animal.run(sizeRun) && animal.salt(sizeSalt) && animal.jump(sizeJump))
                animal.setIsPassed(true);
        }
    }
}
