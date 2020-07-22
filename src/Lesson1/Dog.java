package Lesson1;


import Lesson1.base.*;

public class Dog extends Animal implements Jumping, Salt, Run {
    private static final double DEFAULTSIZERUN = 500.0;
    private static final double DEFAULTSIZESALT = 200.0;
    private static final double DEFAULTSIZEJUMPING = 2.0;
    private String color;

    public Dog(String color, int age) {
        this.color = color;
    }

    public Dog(String name, int age, String color) {
        super(name, age);
        this.color = color;
        this.sizeRun = DEFAULTSIZERUN;
        this.sizeSalt = DEFAULTSIZESALT;
        this.sizeJumping = DEFAULTSIZEJUMPING;
    }

    public Dog(String name, int age, String color, double sizeRun, double sizeSalt, double sizeJumping) {
        super(name, age);
        this.color = color;
        this.sizeRun = sizeRun;
        this.sizeSalt = sizeSalt;
        this.sizeJumping = sizeJumping;
    }

    public void dogInfo() {
        System.out.printf("Собака. Имя: %s. Цвет: %s. Возраст: %d\n", name, color, age);
    }

    @Override
    public void animalInfo() {
        dogInfo();
    }

    @Override
    public boolean jump(double sizeJump) {
        return (this.sizeJumping >= sizeJump);
    }

    @Override
    public boolean salt(double sizeSalt) {
        return (this.sizeSalt >= sizeSalt);
    }

    @Override
    public boolean run(double sizeRun) {
        return (this.sizeRun >= sizeRun);
    }
}
