package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains behaviour for tests
 */
class CityListTest {

    /**
     * Test city list
     * @return
     *      Returns a list
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.addCity(mockCity());
        return cityList;
    }

    /**
     * Test city information
     * @return
     *      Returns a city object
     */
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * Tests the addCity method
     */
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.addCity(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    /**
     * Tests the exception throw for the addCity method
     */
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.addCity(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.addCity(city);
        });
    }

    /**
     * Tests the getCity method
     */
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    /**
     * Tests the hasCity method
     */
    @Test
    void testHasCity() {
        // Create mock city list and add new city
        CityList cityList = mockCityList();
        City newCity = new City("Vancouver", "British Columbia");
        cityList.addCity(newCity);

        // Method should return true
        assertTrue(cityList.hasCity(newCity));
    }

    /**
     * Test the deleteCity method
     */
    @Test
    void testDeleteCity() {
        // Create mock city list and add new city
        CityList cityList = mockCityList();
        City newCity = new City("Vancouver", "British Columbia");
        cityList.addCity(newCity);

        // Verify that the city is in the list initially
        assertTrue(cityList.getCities().contains(newCity));

        // Delete the city and verify that it is no longer in the list
        cityList.delete(newCity);
        assertFalse(cityList.getCities().contains(newCity));

        // Now that the city is not in the list, check that the exception is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(newCity);
        });
    }

    /**
     * Tests the countCities method
     */
    @Test
    void testCountCities() {
        // Create mock city list
        CityList cityList = mockCityList();
        City city2 = new City("Vancouver", "British Columbia");
        cityList.addCity(city2);

        // City list size should be 2
        assertEquals(2, cityList.countCities());
    }
}