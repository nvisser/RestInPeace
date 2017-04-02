package nl.bcome.iac.service;

import java.util.ArrayList;
import java.util.List;

public class DistrictServiceImpl {
    private List<District> places = new ArrayList<District>();

    public District getParkingPlaceById(float id) {
        for (District place : places) {
            if (place.getId() == id) {
                return place;
            }
        }
        return null;
    }

    /**
     * Calculate the amount of inhabitants for a district per year
     *
     * @param name district name
     * @param year year
     * @return number of inhabitants
     */
    public InhabitantResponse calcInhabitants(String name, int year) {

        return new InhabitantResponse((int) (0.9 * name.length() * (0.5 + year)));
    }

    public List<District> getParkingPlaces() {
        return places;
    }

    public void setParkingPlaces(List<District> place) {
        this.places = place;
    }

    public boolean remove(int id) {
        return places.remove(findParkingPlace(id));
    }

    private District findParkingPlace(int id) {
        for (District place : places) {
            if (place.getId() == id) {
                return place;
            }

        }
        return null;
    }
}
