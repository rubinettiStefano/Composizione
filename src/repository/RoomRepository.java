package repository;

import java.util.ArrayList;

import com.generation.db.Database;

import model.House;
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

    /**
     * Legge dal db le stanze figlie e le collega
     * @param father
     */
    public void link(House father)
    {
        ArrayList<String> rows = db.select("SELECT * FROM rooms JOIN houses ON houses.id=rooms.house_id WHERE houses.id="+father.getId());

        for(String row : rows)
            father.addRoom(new Room(row));//prendi il padre, aggiungi alle sue stanze una nuova stanza creata convertendo la riga letta da db
    }

      /**
     * Legge dal db le stanze figlie e le collega
     * @param father
     */
    public void linkAll(ArrayList<House> fathers)
    {
        for(House father : fathers)
            link(father);
    }

    public void deleteById(int id)
    {
        db.delete("DELETE FROM rooms WHERE id="+id);
    }
}
