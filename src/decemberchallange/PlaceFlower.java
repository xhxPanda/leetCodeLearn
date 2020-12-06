package decemberchallange;

public class PlaceFlower {
    public boolean canPlaceFlowers (int[] flowerbed, int n) {
        if(flowerbed.length == 0) {
            return true;
        }
        if(flowerbed.length == 1 && flowerbed[0] == 1 && n == 0) {
            return true;
        }
        int i = 0;
        int len = flowerbed.length;
        while (i < len) {
            if (flowerbed[i] == 0) {
                int next = i == len-1 ? 0 : flowerbed[i+1];
                int pre = i == 0 ? 0 : flowerbed[i-1];
                if (next == 0 && pre == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
                if (n <= 0) {
                    return true;
                }
            }
            i++;
        }

        return false;
    }
}
