package repository;

import java.util.ArrayList;

import com.generation.db.Database;

import model.House;
import model.Room;

/**
 * Serve ad accedere a TUTTE le repository, per poterle mettere in comunicazione tra di loro
 */
public class DatabaseHandler 
{
    private Database db = new Database("config.txt");
    private RoomRepository roomRepo = new RoomRepository(db);
    private HouseRepository houseRepo = new HouseRepository(db);

    //Voglio che lui faccia da intermediario tra TUTTE le repository e il resto del programma
    public ArrayList<Room> selectAllRooms()
    {
        ArrayList<Room> res = roomRepo.selectAll();

        houseRepo.linkAll(res);

        return res;
    }

    public ArrayList<House> selectAllHouses()
    {
        ArrayList<House> res = houseRepo.selectAll();

        roomRepo.linkAll(res);

        return res;
    }

    public void deleteRoomById(int id)
    {
        roomRepo.deleteById(id);
    }

    public void deleteHouseById(int id)
    {
        houseRepo.deleteById(id);
    }

    //aggiungere metodi nelle ENTITÀ
    //writeInsertQuery   -> generaInsert
    //writeUpdateQuery   -> generaUpdate


    //voglio che questa classe offra i metodi
    //selectRoomById(int id)
    //selectHouseById(int id)

    //NEGLI UPDATE NON SI TOCCA LA FK
    //updateRoom(Room r)
    //updateHouse(House h)

    //INSERT (Loro sono uguali identici a prima)
    //insertRoom(Room r)
    //insertHouse(House h)

    //DELETE
    //quando cancellate una casa voglio siano CANCELLATE anche tutte le sue STANZE dal DB
}
