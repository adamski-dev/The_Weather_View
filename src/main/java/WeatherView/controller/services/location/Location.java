package WeatherView.controller.services.location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Location {

    private String name;
    private String country;

    private String cityAndCountry;
    public boolean validEntry = false;

    public Location(String cityAndCountry) {
        this.cityAndCountry = cityAndCountry;
    }

    public String getCity() {return name;}
    public String getCountry() {return country;}
    public String getCityAndCountry() {
        return entryValidation() == true ? cityAndCountry : "number";
    }

	private boolean entryValidation(){
        try {
            Pattern pattern = Pattern.compile("([A-z])\\w+, [A-Z]\\w+");
            Matcher matcher = pattern.matcher(cityAndCountry);
            
            if(matcher.find()){
                validEntry = true;
            }
            
        } catch (Exception e){
            validEntry = false;
        }
        return validEntry;
    }
}
