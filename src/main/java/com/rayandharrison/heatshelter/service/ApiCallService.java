package com.rayandharrison.heatshelter.service;

import com.rayandharrison.heatshelter.domain.shelter.Shelter;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

@Service
public class ApiCallService {

    private final static String url = "http://api.data.go.kr/openapi/tn_pubr_public_heat_wve_shltr_api";
    private final static String serviceKey = "key";


    public Shelter getShelter(String search) {
        //get shelter by calling api
        return new Shelter();
    }

    private void callApi() throws IOException {
        StringBuilder urlBuilder = new StringBuilder(url); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*XML/JSON 여부*/
        urlBuilder.append("&" + URLEncoder.encode("shltrNm", "UTF-8") + "=" + URLEncoder.encode("샘실8단지경로당", "UTF-8")); /*쉼터명*/
        urlBuilder.append("&" + URLEncoder.encode("legaldongNm", "UTF-8") + "=" + URLEncoder.encode("강원도 동해시 천곡동", "UTF-8")); /*법정동명*/
        urlBuilder.append("&" + URLEncoder.encode("shltrType", "UTF-8") + "=" + URLEncoder.encode("노인시설", "UTF-8")); /*쉼터유형구분*/
        urlBuilder.append("&" + URLEncoder.encode("operOpenDate", "UTF-8") + "=" + URLEncoder.encode("2019-05-20", "UTF-8")); /*운영시작일자*/
        urlBuilder.append("&" + URLEncoder.encode("operCloseDate", "UTF-8") + "=" + URLEncoder.encode("2019-09-30", "UTF-8")); /*운영종료일자*/
        urlBuilder.append("&" + URLEncoder.encode("fcltyAr", "UTF-8") + "=" + URLEncoder.encode("101", "UTF-8")); /*시설면적*/
        urlBuilder.append("&" + URLEncoder.encode("aceptncPosblCo", "UTF-8") + "=" + URLEncoder.encode("20", "UTF-8")); /*이용가능인원수*/
        urlBuilder.append("&" + URLEncoder.encode("fanHoldCo", "UTF-8") + "=" + URLEncoder.encode("4", "UTF-8")); /*선풍기보유대수*/
        urlBuilder.append("&" + URLEncoder.encode("arcndtnHoldCo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*에어컨보유대수*/
        urlBuilder.append("&" + URLEncoder.encode("nightExtnYn", "UTF-8") + "=" + URLEncoder.encode("N", "UTF-8")); /*야간연장운영여부*/
        urlBuilder.append("&" + URLEncoder.encode("wkendUseYn", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*주말운영여부*/
        urlBuilder.append("&" + URLEncoder.encode("stayngYn", "UTF-8") + "=" + URLEncoder.encode("N", "UTF-8")); /*숙박가능여부*/
        urlBuilder.append("&" + URLEncoder.encode("partclr", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*특이사항*/
        urlBuilder.append("&" + URLEncoder.encode("rdnmadr", "UTF-8") + "=" + URLEncoder.encode("강원도 동해시 샘실1길43", "UTF-8")); /*소재지도로명주소*/
        urlBuilder.append("&" + URLEncoder.encode("lnmadr", "UTF-8") + "=" + URLEncoder.encode("강원도 동해시 천곡동411-1", "UTF-8")); /*소재지지번주소*/
        urlBuilder.append("&" + URLEncoder.encode("institutionNm", "UTF-8") + "=" + URLEncoder.encode("강원도 동해시청 가족과", "UTF-8")); /*관리기관명*/
        urlBuilder.append("&" + URLEncoder.encode("phoneNumber", "UTF-8") + "=" + URLEncoder.encode("033-530-2313", "UTF-8")); /*관리기관전화번호*/
        urlBuilder.append("&" + URLEncoder.encode("latitude", "UTF-8") + "=" + URLEncoder.encode("37.5213121", "UTF-8")); /*위도*/
        urlBuilder.append("&" + URLEncoder.encode("hardness", "UTF-8") + "=" + URLEncoder.encode("129.1070061", "UTF-8")); /*경도*/
        urlBuilder.append("&" + URLEncoder.encode("referenceDate", "UTF-8") + "=" + URLEncoder.encode("2019-09-10", "UTF-8")); /*데이터기준일자*/
        urlBuilder.append("&" + URLEncoder.encode("insttCode", "UTF-8") + "=" + URLEncoder.encode("4210000", "UTF-8")); /*제공기관코드*/
        urlBuilder.append("&" + URLEncoder.encode("insttNm", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*제공기관명*/

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        //json data to domain model

    }
}
