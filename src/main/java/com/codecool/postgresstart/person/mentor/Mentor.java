package com.codecool.postgresstart.person.mentor;

import com.codecool.postgresstart.person.Person;

public class Mentor extends Person {
    private String nickName;
    private String city;
    private int favouriteNumber;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getFavouriteNumber() {
        return favouriteNumber;
    }

    public void setFavouriteNumber(int fn) {
        favouriteNumber = fn;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", firstName='" + firstName + "'" +
                ", lastName='" + lastName + "'" +
                ", nickName='" + nickName + "'" +
                ", phoneNumber='" + phoneNumber + "'" +
                ", email='" + email + "'" +
                ", city='" + city + "'" +
                ", favouriteNumber=" + favouriteNumber +
                '}';
    }
}
