package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class testAnimal {
    @Test
    public void test(){
        List<Animal> animalList = new ArrayList<>();
        Animal a1 = new Animal();
        a1.setCateGory("cat");
        a1.setName("1");
        animalList.add(a1);
        Animal a2 = new Animal();
        a2.setCateGory("cat");
        a2.setName("2");
        animalList.add(a2);
        Animal a3 = new Animal();
        a3.setCateGory("cat");
        a3.setName("3");
        animalList.add(a3);
        System.out.println("before adjust:");
        for(Animal animal:animalList){
            System.out.println(animal.getName());
        }
        for(Animal animal:animalList){
            animal.setName("1");
        }
        System.out.println("after adjust:");
        for(Animal animal:animalList){
            System.out.println(animal.getName());
        }
    }
}
