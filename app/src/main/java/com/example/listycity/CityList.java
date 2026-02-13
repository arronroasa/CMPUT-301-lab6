package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * Adds a city to list if city does not already exist in array
     * @param city
     *      This is a candidate city to add
     */
    public void addCity(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether a city is currently in the list
     * @param city
     *      The city to be checked
     * @return
     *      Returns a boolean
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list
     * @param city
     *      The city to be deleted
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Counts the number of cities in the list
     * @return
     *      Returns the size of the list
     */
    public int countCities() {
        return cities.size();
    }
}
