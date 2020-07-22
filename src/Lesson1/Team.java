package Lesson1;

import Lesson1.base.Animal;

public class Team {
    private String name;
    private Animal[] animals = new Animal[4];

    Team(String name, Animal animal1, Animal animal2, Animal animal3, Animal animal4){
        this.name = name;
        animals[0] = animal1;
        animals[1] = animal2;
        animals[2] = animal3;
        animals[3] = animal4;
    }

    public String toString(){
        return ("Команда: " + name + ". Состав участников: " + animals[0].getName() + " " + animals[1].getName() + " " + animals[2].getName() + " " + animals[3].getName());
    }

    public Animal[] getAnimals(){
        return animals;
    }

    public void showResults() {
        for (Animal animal : animals) {
            if (animal.getIsPassed())
                System.out.println(animal.getName() + " преодолел полосу препядствий!");
            else
            System.out.println(animal.getName() + " не смог преодолеть полосу препятствий!");
        }
    }
}
