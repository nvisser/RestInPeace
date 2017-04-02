package nl.bcome.iac.service;

import org.junit.After;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by niek on 4/2/17.
 */
public class DistrictServiceTest {
    private Map<String, Integer> input;
    private Map<String, Integer> output;
    private IntegrationTester t;

    @After
    public void tearDown() throws Exception {
        input = null;
        output = null;
        t = null;
    }

    @Before
    public void setUp() throws Exception {
        input = new HashMap<>();
        output = new HashMap<>();
        t = new IntegrationTester();


        input.put("test", 2017);
        output.put("test", 7263);

        input.put("Test wijk", 2017);
        output.put("Test wijk", 16341);

        input.put("Echte wijk", 2005);
        output.put("Echte wijk", 18049);
    }

    @org.junit.Test
    public void getInhabitants() throws Exception {
        this.input.keySet().forEach(k -> {
            int real = ServiceProvider.getParkingService().calcInhabitants(k, input.get(k)).getAmount();
            int expected = output.get(k);
            assertEquals(real, expected);
        });
    }

    @org.junit.Test
    public void integrationTest() throws Exception {
        t.run();
    }

}