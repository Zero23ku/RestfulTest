package RestFulTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Time {

    private String code;
    private String description;
    private String data;
    private String newData;
    private Date auxDate;
 
    //Must have no-argument constructor
    public Time(){
    
    }
    public Time(String code, String description, String data){
        this.code = code;
        this.description = description;
        
        //Current date format in string
        SimpleDateFormat format = new SimpleDateFormat("ddmmyy hhmmss S X");
        try {
            //Try to parse string into date with current format
            auxDate = format.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Set new format
        format = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm:ss.SSXXX");
        //Save date with new format as String
        this.newData = format.format(auxDate);
        this.data = newData;
    }
    
    public String getCode(){
        return this.code;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public String getData(){
        return this.data;
    }
    
    @Override
    public String toString(){
        return new StringBuffer("{\"code\":\"").append(this.code)
                   .append("\",\"description\":\"").append(this.description)
                   .append("\",\"data\":\"").append(this.data)
                   .append("\"}").toString();
    }
    
}
