package controller;

import java.util.ArrayList;

import model.House;
import model.Room;
import repository.DatabaseHandler;

public class ToStringListe
{
    public static void main(String[] args) 
    {
        DatabaseHandler dbh = new DatabaseHandler();
        // ArrayList<Room> tutteLeStanze = dbh.selectAllRooms();

        // Room stanzaACaso = tutteLeStanze.get(0);

        // System.out.println(stanzaACaso.getMyHouse().getCity());
        ArrayList<House> tutteLeCase = dbh.selectAllHouses();

        House casaAtorino = tutteLeCase.get(0);

        System.out.println(casaAtorino.getArea());

    }
}
