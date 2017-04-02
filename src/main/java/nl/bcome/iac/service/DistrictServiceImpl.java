package nl.bcome.iac.service;

import java.util.ArrayList;
import java.util.List;

/*
 Copyright 2017 Niek Visser

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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
