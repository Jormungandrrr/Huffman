/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import Data.Export;
import Data.Import;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Jorrit
 */
public class Huffman {
    
    Export expo = new Export();
    Import impo = new Import();
    HashMap<Character, String> codedList = new HashMap<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Huffman hm = new Huffman();
        String input = "dit is een super coole test";
        hm.Start(input);
    }
    
    public void Start(String input) throws IOException, FileNotFoundException, ClassNotFoundException
    {
       
        Map<String, Integer> frequenceMap = this.getFrequence(input);
        PriorityQueue<HuffNode> sortedFrequence = this.sortFrequence(frequenceMap);
        this.createTree(sortedFrequence);
        HashMap<Character, String> codedMap =  this.createCodes(sortedFrequence.peek(), "");
        this.expo.export(this.encode(codedMap, input), sortedFrequence.peek());
        this.decode(this.impo.getCode(), this.impo.getRootNode());
        System.out.println("Done.");
    }
    
    public HashMap<String, Integer> getFrequence(String input){
        HashMap<String, Integer> words = new HashMap();
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
    
        public PriorityQueue<HuffNode> sortFrequence(Map<String, Integer> hashMap) {
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
        
     public HuffNode createTree(PriorityQueue<HuffNode> q) {
        HuffNode n1 = q.poll();
        HuffNode n2 = q.poll();

        int frequency = n1.getFrequency() + n2.getFrequency();
        q.add(new HuffNode(frequency, n1, n2));

        if (q.size() > 1) {
            createTree(q);
        }

        return q.peek();
    }
     
    public HashMap<Character, String> createCodes(HuffNode node, String code) {
        if (node != null)
        {
            createCodes(node.getLeft(), code + "0");
            createCodes(node.getRight(), code + "1");
            if (node.getLeft()== null && node.getRight()== null)
                codedList.put(node.getCharacter(), code);
        }
        return codedList;
    }
    
    public String encode(HashMap<Character, String> charWithCode, String message)
    {
        StringBuilder sb = new StringBuilder();
        for (Character c : message.toCharArray())
        {
            sb.append(charWithCode.get(c));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public String decode(String code, HuffNode rootNode)
    {
        StringBuilder sb = new StringBuilder();
        HuffNode node = rootNode;
        for (int i = 0; i < code.length(); i++)
        {
            if (code.charAt(i) == '1'){
                node = node.getRight();
            }
            else {
                node = node.getLeft();
            }
            if (node.getLeft() == null && node.getRight() == null) {
                sb.append(node.getCharacter());
                node = rootNode;
            }
        }
        System.out.println("message was: " + sb.toString());
        return sb.toString();
    }
}
