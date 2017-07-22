package RestFulTest;

public class Word {
   
    private String code;
    private String description;
    private String data;
    
    public Word(String code, String description, String data){
        this.code = code;
        this.description = description;
        this.data = data.toUpperCase();
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
