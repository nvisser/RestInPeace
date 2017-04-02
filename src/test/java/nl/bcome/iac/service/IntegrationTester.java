package nl.bcome.iac.service;

import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

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
