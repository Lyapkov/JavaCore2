package Lesson1;

import Lesson1.base.*;

import java.util.StringJoiner;

public class Cat extends Animal implements Jumping, Run, Salt {
    private static final double DEFAULTSIZERUN = 1000.0;
    private static final double DEFAULTSIZESALT = 300.0;
    private static final double DEFAULTSIZEJUMPING = 1.0;
    private String color;

    public Cat() {
    }

    public Cat(String color, int age) {
        this.color = color;
        this.age = age;
    }

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
        this.sizeRun = DEFAULTSIZERUN;
        this.sizeSalt = DEFAULTSIZESALT;
        this.sizeJumping = DEFAULTSIZEJUMPING;
    }

    public Cat(String name, int age, String color, double sizeRun, double sizeSalt, double sizeJumping) {
        super(name, age);
        this.color = color;
        this.sizeRun = sizeRun;
        this.sizeSalt = sizeSalt;
        this.sizeJumping = sizeJumping;
    }

    public void catInfo() {
        System.out.printf("Кошка. Имя: %s. Цвет: %s. Возраст: %d\n", name, color, age);
    }

    @Override
    public void animalInfo() {
        super.animalInfo();
        catInfo();
    }

    @Override
    public boolean salt(double sizeSalt){
        return (this.sizeSalt >= sizeSalt);
    }

    @Override
    public boolean jump(double sizeJumping) {
        return (this.sizeJumping >= sizeJumping);
    }

    @Override
    public boolean run(double sizeRun) {
        return (this.sizeRun >= sizeRun);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cat.class.getSimpleName() + "[", "]")
                .add("color='" + color + "'")
                .add("age=" + age)
                .add("name='" + name + "'")
                .toString();
    }
}
