package WeatherView.controller.services.location;

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
            Integer.valueOf(cityAndCountry);
            return validEntry = false;
        } catch (Exception e){
            return validEntry = true;
        }
    }
}
