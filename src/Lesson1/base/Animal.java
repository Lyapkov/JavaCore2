package Lesson1.base;

public abstract class Animal implements Run, Salt, Jumping {
    protected String name;
    protected int age;
    protected boolean isPassed = false;
    protected double sizeRun;
    protected double sizeSalt;
    protected double sizeJumping;

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIsPassed(boolean isPassed){
        this.isPassed = isPassed;
    }

    public boolean getIsPassed(){
        return isPassed;
    }

    public void animalInfo() {
        System.out.println("Животное: " + name + ", возраст: " + age);
    }

    @Override
    public boolean salt(double sizeSalt){
        return (this.sizeSalt >= sizeSalt);
    }

    @Override
    public boolean run(double sizeRun){
        return (this.sizeRun >= sizeRun);
    }

    @Override
    public boolean jump(double sizeJump){
        return (this.sizeJumping >= sizeJump);
    }

}
