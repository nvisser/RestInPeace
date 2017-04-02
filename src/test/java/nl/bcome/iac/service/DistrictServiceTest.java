package nl.bcome.iac.service;

import org.junit.After;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

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

        input.put("Utrecht transwijk", 2009);
        output.put("Utrecht transwijk", 30745);

        input.put("Almere Haven", 2003);
        output.put("Almere Haven", 21637);
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