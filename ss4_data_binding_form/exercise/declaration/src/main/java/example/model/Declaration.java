package example.model;

public class Declaration {
    private String name;
    private String yearOfBirthday;
    private String country;
    private String gender;
    private String idCard;
    private String vehicles;
    private String license;
    private String seatNumber;
    private String startDay;
    private String endtDay;
    private String declare;

    public Declaration() {
    }

    public Declaration(String name, String yearOfBirthday, String country, String gender, String idCard, String vehicles, String license, String seatNumber, String startDay, String endtDay, String declare) {
        this.name = name;
        this.yearOfBirthday = yearOfBirthday;
        this.country = country;
        this.gender = gender;
        this.idCard = idCard;
        this.vehicles = vehicles;
        this.license = license;
        this.seatNumber = seatNumber;
        this.startDay = startDay;
        this.endtDay = endtDay;
        this.declare = declare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirthday() {
        return yearOfBirthday;
    }

    public void setYearOfBirthday(String yearOfBirthday) {
        this.yearOfBirthday = yearOfBirthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicles() {
        return vehicles;
    }

    public void setVehicles(String vehicles) {
        this.vehicles = vehicles;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndtDay() {
        return endtDay;
    }

    public void setEndtDay(String endtDay) {
        this.endtDay = endtDay;
    }

    public String getDeclare() {
        return declare;
    }

    public void setDeclare(String declare) {
        this.declare = declare;
    }
}
