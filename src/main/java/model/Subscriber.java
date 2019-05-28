package model;

import exceptions.CSVFormatException;

public class Subscriber {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private int phoneNumber;
    private String address;
    private String countryOfOrigin;
    private String job;

    public Subscriber(String firstName, String middleName, String lastName, int age, int phoneNumber, String address, String countryOfOrigin, String job) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
        this.countryOfOrigin = countryOfOrigin;
        this.job = job;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "%10s%18s%15s%15s%25s",
                firstName,
                middleName,
                lastName,
                phoneNumber,
                address
        );
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String toCSV() {
        return firstName + "," +
                middleName + "," +
                lastName + "," +
                age + "," +
                phoneNumber + "," +
                address + "," +
                countryOfOrigin + "," +
                job;
    }

    public static Subscriber fromCSV(String csv) throws CSVFormatException {
        String[] values = csv.split(",");
        try {
            return new Subscriber(
                    values[0],
                    values[1],
                    values[2],
                    Integer.parseInt(values[3]),
                    Integer.parseInt(values[4]),
                    values[5],
                    values[6],
                    values[7]
            );
        } catch (NumberFormatException e) {
            throw new CSVFormatException(e.getMessage());
        }
    }
}
