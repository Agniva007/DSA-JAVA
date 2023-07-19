package Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s) {
        if(s == null || s.isEmpty()) {
            return "";
        }
        int[] arr = new int[256];
        for(char c : s.toCharArray()) {
            arr[c]++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(s.length(), new Comparator<Pair>() {
            public int compare(Pair p, Pair q) {
                return q.freq - p.freq;
            }
        });

        for(int i = 0; i < 256; i++) {
            if(arr[i] > 0) {
                pq.offer(new Pair((char)i , arr[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            while(p.freq != 0) {
                sb.append(p.c);
                p.freq--;
            }
        }
        return sb.toString();
    }
}

class Pair {
    int freq;
    char c;

    public Pair(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}
