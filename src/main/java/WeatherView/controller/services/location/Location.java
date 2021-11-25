package WeatherView.controller.services.location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Location {

    private String name;
    private String country;
    private String emptyFlag = "";

    private String cityAndCountry;
    public boolean validEntry = false;

    public Location(String cityAndCountry) {
        this.cityAndCountry = cityAndCountry;
    }

    public String getCity() {return name;}
    public String getCountry() {return country;}
    public String getCityAndCountry() {
        return cityAndCountry;
    }

    private boolean entryValidation(){

        try {
            if(cityAndCountry.equals("")){
                emptyFlag = "empty";
            }
            Pattern pattern = Pattern.compile("([A-z])\\w+, [A-Z]\\w+");
            Matcher matcher = pattern.matcher(cityAndCountry);

            if(matcher.find()){
                validEntry = true;
            }
        } catch (Exception e){}
        return validEntry;
    }

    public boolean isValidEntry(){
        if (entryValidation()){ return true;}
        return false;
    }

    public boolean isEmptyFlag(){
        if (emptyFlag.equals("empty")){
            return true;
        }
        return false;
    }
}
