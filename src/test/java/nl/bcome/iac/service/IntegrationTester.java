package nl.bcome.iac.service;

import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

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
public class IntegrationTester {
    private String REST_SERVICE_URL = "http://localhost:8080/rest/DistrictService/districts/%s/%d";
    private Map<String, Integer> input = new HashMap<>();
    private Map<String, InhabitantResponse> output = new HashMap<>();
    private int i = 0, fail = 0, success = 0;

    IntegrationTester() {
        input.put("test", 2017);
        output.put("test", new InhabitantResponse(7263));

        input.put("Test wijk", 2017);
        output.put("Test wijk", new InhabitantResponse(16341));

        input.put("Echte wijk", 2005);
        output.put("Echte wijk", new InhabitantResponse(18049));

        input.put("Utrecht transwijk", 2009);
        output.put("Utrecht transwijk", new InhabitantResponse(30745));

        input.put("Almere Haven", 2003);
        output.put("Almere Haven", new InhabitantResponse(21637));
    }

    void run() throws Exception {
        System.out.println("Running integration test. Make sure your webservice is running.");
        for (String k : input.keySet()) {
            this.i += 1;
            final URL u = new URL(String.format(REST_SERVICE_URL,
                    URLEncoder.encode(k, "UTF-8"),
                    input.get(k)
            ));

            final InhabitantResponse resp = new Gson().fromJson(new InputStreamReader(u.openStream()), InhabitantResponse.class);
            System.out.print(String.format("Test result for district=%s year=%d: ", k, input.get(k)));
            if (resp.getAmount() != output.get(k).getAmount()) {
                System.out.print("Fail." + " ");
                this.fail += 1;
            } else {
                System.out.print("Success." + " ");
                this.success += 1;
            }
            System.out.println("Expected " + output.get(k).getAmount() + ", got " + resp.getAmount());
        }
        System.out.println("Integration tests done. " + String.format("Tests run: %d, Failures: %d, Success: %d", this.i, this.fail, this.success));
    }
}
