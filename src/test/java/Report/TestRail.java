package Report;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hillel on 08.08.17.
 */
public class TestRail {

    Long runID;

    public static void main(String[] args) throws Exception {
        APIClient client = new APIClient("https://hillelauto.testrail.net");
        client.setUser("rvalek@intersog.com");
        client.setPassword("hillel");

        Map data = new HashMap();
        data.put("status_id", 1);
//        JSONObject r = (JSONObject) client.sendPost(String.format("add_run/%d", projectID), data);
//        this.runID = (Long) r.get("id");

    }



}
