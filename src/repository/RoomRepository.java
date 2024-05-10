package repository;

import java.util.ArrayList;

import com.generation.db.Database;

import model.Room;

/**
 * Non mi occupo delle relazioni
 */
public class RoomRepository 
{
    private Database db;

    public RoomRepository (Database db)
    {
        this.db = db;
    }

    public ArrayList<Room> selectAll()
    {
        ArrayList<String> rows = db.select("SELECT * FROM rooms");
        ArrayList<Room> res = new ArrayList<>();

        for(String row : rows)
            res.add(new Room(row));//creo nuova Room e la aggiungo alla lista

        return res;
    }
}
