package repository;

import java.util.ArrayList;

import com.generation.db.Database;

import model.House;
import model.Room;

public class HouseRepository 
{
    private Database db;

    public HouseRepository (Database db)
    {
        this.db = db;
    }

    public ArrayList<House> selectAll()
    {
        ArrayList<String> rows = db.select("SELECT * FROM houses");
        ArrayList<House> res = new ArrayList<>();

        for(String row : rows)
            res.add(new House(row));//creo nuova Room e la aggiungo alla lista

        return res;
    }

    public ArrayList<House> selectWhere(String condizione)
    {
        ArrayList<String> rows = db.select("SELECT * FROM houses WHERE "+condizione);
        ArrayList<House> res = new ArrayList<>();

        for(String row : rows)
            res.add(new House(row));//creo nuova Room e la aggiungo alla lista

        return res;
    }  

     /**
     * Legge dal db la casa padre e la collega
     * @param father
     */
    public void link(Room son)
    {
        ArrayList<String> rows = db.select("SELECT * FROM houses JOIN rooms ON houses.id=rooms.house_id WHERE rooms.id="+son.getId());

        House h = new House(rows.get(0));//converto l'unica riga letta
        h.addRoom(son);//le collego
    }

   
    public void linkAll(ArrayList<Room> sons)
    {
        ArrayList<Integer> houses_id = new ArrayList<>();

        for(Room r : sons)
        {
            if(!houses_id.contains(r.getHouse_id()))
                houses_id.add(r.getHouse_id());
        }
        //1) Da riga 56 a 62, estraggo dalla lista di Stanze la lista degli ID delle case ad esse collegate

        String valoriIn =   houses_id
                            .toString()
                            .replace("[", "(")
                            .replace(", ", ",")
                            .replace("]", ")");

        //2) riga 65, formatto quella lista per avere il formato (id1,id2,ecc..)
        ArrayList<House> houses = selectWhere("id IN "+valoriIn);
        //3) RIGA 72, leggo dal db le case con quegli id
        for(House h : houses)//scorri tutte le case
        {
            for(Room r : sons)//per ogni casa scorri tutte le stanze
            {
                if(r.getHouse_id().equals(h.getId()))//se PREDICATO JOIN TRUE, rooms.FK = houses.PK
                    h.addRoom(r);//collega
            }
        }
        //4) riga 74-81 -> scorro tutte le case lette, aggiungo alle loro stanze le stanze con la FK
        //uguale alla PK della casa
    }
}







 //   /**
    //  * Legge dal db le case padri e le collega
    //  * @param father
    //  */
    // public void linkAll(ArrayList<Room> sons)
    // {

    //     String query =  "SELECT                                             "+
    //                     "    houses.id,                                     "+
    //                     "    city,                                          "+
    //                     "    address,                                       "+
    //                     "    smp,                                           "+
    //                     "    constructiondate                               "+
    //                     "    rooms.id,                                      "+
    //                     "    house_id                                       "+
    //                     "FROM                                               "+
    //                     "    rooms                                          "+
    //                     "    JOIN houses ON houses.id=rooms.house_id;       ";
    //     ArrayList<String> rows = db.select(query);


    //     ArrayList<Integer> houses_ids = new ArrayList<>();

    //     for(String row : rows)
    //     {
    //         Integer id = Integer.parseInt(row.split(",")[0]);
    //         if(!houses_ids.contains(id))
    //             houses_ids.add(id);
    //     }

    //     for(Integer id : houses_ids)
    //     {
    //         for(String row : rows)
    //         {
    //             if(Integer.parseInt(row.split(",")[0]) == id)
    //             {
    //                 House h = new House(row);
    //                 for(Room r: sons)
    //                 {
    //                     if(r.getHouse_id()==h.getId())
    //                         h.addRoom(r);
    //                 }
    //             }
    //         }
    //     }
    // }
