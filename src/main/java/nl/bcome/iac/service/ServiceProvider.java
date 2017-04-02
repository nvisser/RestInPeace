package nl.bcome.iac.service;

public class ServiceProvider {
    private static DistrictServiceImpl parkingService = new DistrictServiceImpl();

    public static DistrictServiceImpl getParkingService() {
        return parkingService;
    }
}
