package RestFulTest;

import java.text.ParseException;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Stateless
@Path("restful")
public class TimeService {
       
    @GET
    @Path("/time")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response returnTime(@QueryParam("value") String currentDate) throws ParseException{
        
        try{
            Time time = new Time("00","OK", currentDate); 
            return Response.status(200).entity(time.toString()).build();
        }catch(Exception e){
            return Response.status(500).build();
        }
    }
    
    @POST
    @Path("/word")
    @Produces(MediaType.APPLICATION_JSON)
    public Response returnWord(@FormParam(value = "data") String data) throws JSONException{

        JSONObject json = new JSONObject(data);
        String auxData = json.getString("data");
        
        if(auxData.length() == 0 || auxData.length() > 4 || isNumerical(auxData) ){
            return Response.status(400).build();
        }
        
        try{
            Word word = new Word("00","OK",auxData);  
            return Response.status(200).entity(word.toString()).build();
        }catch(Exception e){
            return Response.status(500).build();
        }
    }
    
    public boolean isNumerical(String input){
        try{
            double d = Double.parseDouble(input);
        }catch( NumberFormatException e){
            return false;
        }
        return true;
    }
}
