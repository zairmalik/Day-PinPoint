package com.learn.uzair.daypinpoint;

import java.util.HashMap;

/**
 * Created by user on 9/23/2017.
 */

class YearCode {

    int leapYear(int year){
        HashMap<Integer,Integer> leapCode = new HashMap<>();

        leapCode.put(2000,0);
        leapCode.put(2004,5);
        leapCode.put(2008,3);
        leapCode.put(2012,1);
        leapCode.put(2016,6);
        leapCode.put(2020,4);
        leapCode.put(2024,2);
        leapCode.put(2028,0);
        leapCode.put(2032,5);
        leapCode.put(2036,3);
        leapCode.put(2040,1);
        leapCode.put(2044,6);
        leapCode.put(2048,4);
        leapCode.put(2052,2);
        leapCode.put(2056,0);
        leapCode.put(2060,5);
        leapCode.put(2064,3);
        leapCode.put(2068,1);
        leapCode.put(2072,6);
        leapCode.put(2076,6);
        leapCode.put(2080,2);
        leapCode.put(2084,0);
        leapCode.put(2088,5);
        leapCode.put(2092,3);
        leapCode.put(2096,1);

        return leapCode.get(year);
    }

    int normalYear(int year){
        HashMap<Integer,Integer> normalCode = new HashMap<>();

        normalCode.put(2001,1);
        normalCode.put(2002,2);
        normalCode.put(2003,3);
        normalCode.put(2005,6);
        normalCode.put(2006,0);
        normalCode.put(2007,1);
        normalCode.put(2009,4);
        normalCode.put(2010,5);
        normalCode.put(2011,6);
        normalCode.put(2013,2);
        normalCode.put(2014,3);
        normalCode.put(2015,4);
        normalCode.put(2017,0);
        normalCode.put(2018,1);
        normalCode.put(2019,2);
        normalCode.put(2021,5);
        normalCode.put(2022,6);
        normalCode.put(2023,0);
        normalCode.put(2025,3);
        normalCode.put(2026,4);
        normalCode.put(2027,5);
        normalCode.put(2029,1);
        normalCode.put(2030,2);
        normalCode.put(2031,3);
        normalCode.put(2033,6);
        normalCode.put(2034,0);
        normalCode.put(2035,1);
        normalCode.put(2037,3);
        normalCode.put(2038,4);
        normalCode.put(2039,5);
        normalCode.put(2041,2);
        normalCode.put(2042,3);
        normalCode.put(2043,4);
        normalCode.put(2045,0);
        normalCode.put(2046,1);
        normalCode.put(2047,2);
        normalCode.put(2049,5);
        normalCode.put(2050,6);
        normalCode.put(2051,0);
        normalCode.put(2053,3);
        normalCode.put(2054,4);
        normalCode.put(2055,5);
        normalCode.put(2057,1);
        normalCode.put(2058,2);
        normalCode.put(2059,3);
        normalCode.put(2061,6);
        normalCode.put(2062,0);
        normalCode.put(2063,1);
        normalCode.put(2065,4);
        normalCode.put(2066,5);
        normalCode.put(2067,6);
        normalCode.put(2069,2);
        normalCode.put(2070,3);
        normalCode.put(2071,4);
        normalCode.put(2073,0);
        normalCode.put(2074,2);
        normalCode.put(2075,2);
        normalCode.put(2077,5);
        normalCode.put(2078,6);
        normalCode.put(2079,0);
        normalCode.put(2081,3);
        normalCode.put(2082,4);
        normalCode.put(2083,5);
        normalCode.put(2085,1);
        normalCode.put(2086,2);
        normalCode.put(2087,3);
        normalCode.put(2089,6);
        normalCode.put(2090,0);
        normalCode.put(2091,1);
        normalCode.put(2093,4);
        normalCode.put(2094,5);
        normalCode.put(2095,6);
        normalCode.put(2097,2);
        normalCode.put(2098,3);
        normalCode.put(2099,4);

        return normalCode.get(year);
    }
}
