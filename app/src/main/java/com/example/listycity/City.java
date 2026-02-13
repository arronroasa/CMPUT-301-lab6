package com.example.listycity;

/**
 * This is a class that defines a city
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * The constructor for a city
     * @param city
     *      The name of the city
     * @param province
     *      The name of the province
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the name of a city
     * @return
     *      Returns a string
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Gets the name of a city's province
     * @return
     *      Returns a string
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares the names of two cities
     * @param o
     *      The city to compare to
     * @return
     *      Returns an integer
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
}

