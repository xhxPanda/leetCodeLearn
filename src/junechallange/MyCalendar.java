package junechallange;

import java.util.TreeMap;

public class MyCalendar {
    private TreeMap<Integer, Integer> treeMap;
    public MyCalendar() {
        treeMap = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
        Integer floorkey = treeMap.floorKey(start);
        if(floorkey != null && start < treeMap.get(floorkey) ) {
            return false;
        }
        Integer ceilingkey = treeMap.ceilingKey(start);
        if(ceilingkey != null && ceilingkey < end) {
            return false;
        }
        treeMap.put(start, end);
        return true;
    }
}