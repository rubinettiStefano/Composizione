package controller;

import model.House;
import model.Room;

public class Test 
{
    public static void main(String[] args) 
    {
        House h = new House("Torino", "Via Roma 1", 4000, "1870-03-23");

        Room br = new Room(5, 6, "bedroom");
        Room bath = new Room(3, 2, "bath");
        Room k = new Room(2, 2, "kitchen");
        Room lr = new Room(6, 6, "livingroom");

        h.addRoom(br);
        h.addRoom(bath);
        h.addRoom(k);
        h.addRoom(lr);

        System.out.println(h.getPrice());

        //Tu CUCINA K, a che casa APPARTIENI?
        //K, dove si trova casa tua?
        System.out.println(k.getMyHouse().getAddress());
    }

}
