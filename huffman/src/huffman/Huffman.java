/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author Jorrit
 */
public class Huffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Huffman hm = new Huffman();
        hm.getFrequence(hm.generateRandomWords(20));
        
    }
    
    public Map<String, Integer> getFrequence(String input){
        Map<String, Integer> words = new HashMap();
        for ( String s : input.split("")) {
            Integer count = words.get(s);
            if (count == null) {
                words.put(s,1);
            }
            else {
                words.put(s,count + 1);
            }
        }
        return words;
    }
    
        public static PriorityQueue<HuffNode> sortFrequence(Map<String, Integer> hashMap) {
        List<HuffNode> HuffNodes = new LinkedList<>();
        PriorityQueue<HuffNode> pq;
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String key = (String) pair.getKey();
            int value = (int) pair.getValue();
            HuffNodes.add(new HuffNode(key.charAt(0), value));
        }

        Comparator<HuffNode> comparator = new HuffNodeCompare();
        pq = new PriorityQueue<>(HuffNodes.size(), comparator);

        for (HuffNode huff : HuffNodes) {
            pq.add(huff);
        }
        return pq;
    }
    
    
     public String generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return Arrays.toString(randomStrings);
    }
    
}
