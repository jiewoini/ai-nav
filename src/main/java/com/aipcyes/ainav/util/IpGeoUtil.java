package com.aipcyes.ainav.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class IpGeoUtil {

    public static GeoInfo parseIp(String ip) {
        GeoInfo info = new GeoInfo();
        try {
            URL url = new URL("https://ip.taobao.com/outGetIpInfo?ip=" + ip + "&accessKey=alibaba-inc");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);

            Scanner scanner = new Scanner(conn.getInputStream(), "UTF-8");
            String response = scanner.useDelimiter("\\A").next();
            scanner.close();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            if (root.get("code").asInt() == 0) {
                JsonNode data = root.get("data");
                info.setCountry(data.get("country").asText());
                info.setProvince(data.get("region").asText());
                info.setCity(data.get("city").asText());
                info.setIsp(data.get("isp").asText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }

    public static class GeoInfo {
        private String country;
        private String province;
        private String city;
        private String isp;

        // Getter 和 Setter
        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }
        public String getProvince() { return province; }
        public void setProvince(String province) { this.province = province; }
        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }
        public String getIsp() { return isp; }
        public void setIsp(String isp) { this.isp = isp; }
    }
}
