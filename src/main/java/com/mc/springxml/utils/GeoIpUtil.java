package com.mc.springxml.utils;

import java.net.InetAddress;

import com.maxmind.db.CHMCache;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CountryResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class GeoIpUtil {

	public static String[] getCountry(String ip) {
		String country[] = {"US","en"};
		try {
			DatabaseReader read = new DatabaseReader.Builder(GeoIpUtil.class.getResourceAsStream("/config/Country.mmdb")).withCache(new CHMCache()).build();
			
			CountryResponse tr = read.country(InetAddress.getByName(ip));
			switch(tr.getCountry().getIsoCode()) {
			case "US":
				country[0] = "US";
				country[1] = "en";
				break;
			case "KR":
				country[0] = "KR";
				country[1] = "ko";
				break;
			default :
				country[0] = "US";
				country[1] = "en";
				break;
			}
			
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		
		return country;
	}
	
}
