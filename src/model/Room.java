package model;

/**
 * Io sono una stanza, faccio parte di una casa
 * OGGETTO FIGLIO
 */
public class Room 
{
    private final static String[] VALIDTYPES = new String[]{"kitchen","bath","bedroom","livingroom","balcony","closet"};

    private static void exitProgram()
    {
        System.out.println("Invalid Data for Room, program terminated");
        System.exit(-1);
    }
    private Integer id;
    private Integer side1,side2;
    private House myHouse;//RIFERIMENTO AL PADRE
    private Integer house_id;//CHIAVE ESTERNA
    private String type;

    public Room(Integer side1,Integer side2,String type)
    {
        this.side1 = side1;
        this.side2 = side2;
        this.type = type;

        if(!isValid())
            exitProgram();
    }

    public Room(String csv)
    {

        String[] parti = csv.split(",");
        this.id = Integer.parseInt(parti[0]);
        this.side1 = Integer.parseInt(parti[1]);
        this.side2 = Integer.parseInt(parti[2]);
        this.type = parti[3];
        this.house_id = Integer.parseInt(parti[4]);

        if(!isValid())
            exitProgram();
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getHouse_id() {
        return house_id;
    }


    public void setHouse_id(Integer house_id) {
        this.house_id = house_id;
    }


    public House getMyHouse() {
        return myHouse;
    }

    public void setMyHouse(House myHouse) 
    {
        this.myHouse = myHouse;
        this.house_id = myHouse.getId();
    }

    public Integer getSide1() {
        return side1;
    }

    public void setSide1(Integer side1) {
        this.side1 = side1;
        if(!hasValidSides())
            exitProgram();
    }

    public Integer getSide2() {
        return side2;
    }

    public void setSide2(Integer side2) {
        this.side2 = side2;
        if(!hasValidSides())
            exitProgram();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        if(!hasValidType())
            exitProgram();
    }

    public Integer getArea()
    {
        return side1*side2;
    }

    private boolean hasValidSides()
    {
        return side1!=null && side1>0 && side2!=null && side2>0;
    }

    private boolean hasValidType()
    {
        // for(int i=0;i<VALIDTYPES.length;i++)
        // {
        //     String t = VALIDTYPES[i];
        //     if(type.equals(t))
        //         return true;
        // }
        //Scorri ogni elemento di tipo String del vettore VALIDTYPES
        if(type==null)
            return false;

        for(String t : VALIDTYPES)
            if(type.equals(t))
                return true;

        return false;
    }

    public boolean isValid()
    {
        return hasValidSides() && hasValidType();
    }
    
}
