package com.Arraydemo;
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

  public static void main(String[] args) {

      List<Dog> pets = new ArrayList<> ();
              pets.add(new Dog("BullDog", 10, 10.4f));
      System.out.println("Dog List:" + pets);
              pets.add(new Dog("Labrador", 12, 12.4f));
      System.out.println("Dog List:" + pets);
              pets.add(new Dog("Beagle", 15, 20.5f));
      System.out.println("Dog List:" + pets);
              pets.add(new Dog("German Shepherd", 8, 14.5f));
      System.out.println("Dog List:" + pets);
              pets.add(new Dog("Poodle", 3, 3.5f));
       System.out.println("Dog List:" + pets);

  }


}
