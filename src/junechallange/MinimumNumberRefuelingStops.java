package junechallange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumNumberRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        List<int[]> stationList = new ArrayList<>();
        for (int[] station : stations) {
            stationList.add(station);
        }

        stationList.add(new int[]{target, 0});
        int stationsVisited = 0, curFuel = startFuel, curLoc = 0;
        PriorityQueue<Integer> maxFuelAvailable = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stationList.size(); ++i) {
            int stationLoc = stationList.get(i)[0], stationFuel = stationList.get(i)[1];
            while (maxFuelAvailable.size() > 0 && curLoc + curFuel < stationLoc) {
                curFuel += maxFuelAvailable.remove();
                ++stationsVisited;
            }
        }

        return stationsVisited;
    }
}
