package repository;

import com.generation.db.Database;

/**
 * Serve ad accedere a TUTTE le repository, per poterle mettere in comunicazione tra di loro
 */
public class DatabaseHandler 
{
    private Database db = new Database("config.txt");
    private RoomRepository roomRepo = new RoomRepository(db);
    private HouseRepository houseRepo = new HouseRepository(db);
}
