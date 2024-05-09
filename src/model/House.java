package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class House 
{
    private static void exitProgram()
    {
        System.out.println("Invalid Data for House, program terminated");
        System.exit(-1);
    }

    private String city,address;
    private  LocalDate constructionDate;
    private ArrayList<Room> rooms;
    private Integer smp; //Square Meter Price, prezzo al metro quadro
    /**
     * 
     * @param city
     * @param address
     * @param smp
     * @param constructionDateString  in db format "yyyy-MM-dd"
     */                                                            
    public House(String city, String address, Integer smp,String constructionDateString ) 
    {
        this.city               = city;
        this.address            = address;
        this.smp                = smp;
        this.constructionDate   = LocalDate.parse(constructionDateString);
        this.rooms              = new ArrayList<>();

        if(!isValid())
            exitProgram();
    }

    public String getCity() 
    {
        return city;
    }

    public void setCity(String city) 
    {
        this.city = city;
        if(!hasValidCity())
            exitProgram();
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
        if(!hasValidAddress())
            exitProgram();
    }

    public Integer getSmp() 
    {
        return smp;
    }

    public void setSmp(Integer smp) 
    {
        this.smp = smp;
        if(!hasValidSmp())
            exitProgram();
    }

    public LocalDate getConstructionDate() 
    {
        return constructionDate;
    }

    public void setConstructionDate(String constructionDateString) 
    {
        this.constructionDate   = LocalDate.parse(constructionDateString);
    }

    private boolean hasValidCity()
    {
        return city!=null && !city.isBlank(); 
    }

    private boolean hasValidAddress()
    {
        return address!=null && !address.isBlank(); 
    }

    private boolean hasValidSmp()
    {
        return smp!=null && smp>=0; 
    }

    public boolean isValid()
    {
        return hasValidCity() && hasValidAddress() &&  hasValidSmp();
    }

    

}
