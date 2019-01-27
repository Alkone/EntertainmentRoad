package code.service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by valer on 27.01.2019.
 */
public class StationParser {

    public static List<String> getStations(String str){
        String[] arr = str.split(",");
        return Arrays.asList(arr);
    }
}
