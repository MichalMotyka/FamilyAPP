package FamilyMembers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONFamilymember {

    //Create Json structure of createFamilyMember request
    public static String getJSON(Object familyMember, int FamilyID) {
        String[] familyName = familyMember.toString().split("familyName=")[1].split(",");
        String[] givenName = familyMember.toString().split("givenName=")[1].split(",");
        return "{\"familyId\":" + FamilyID + "\n" +
                ",\"familyName\":\"" + familyName[0] + "\"\n" +
                ",\"givenName\":\"" + givenName[0] + "\"}";
    }

    //Request which return all family members from specified family
    public static String searchFamilyMember(String json) throws IOException {
        URL url = null;
        try {
            url = new URL("http://localhost:8081/searchFamilyMember");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json;utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = json.getBytes("utf-8");
            os.write(input, 0, input.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        }
    }

    public static String getID(int id) {
        return "{\"familyId\":" + id + "}";
    }

    //Request of creating familymember
    public void registerMember(Object familyMember, int FamilyId) throws IOException {
        String json = FamilyMembers.JSONFamilymember.getJSON(familyMember.toString(), FamilyId);
        URL url = null;
        try {
            url = new URL("http://172.18.0.3:8081/createFamilyMember");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json;utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = json.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }
}
