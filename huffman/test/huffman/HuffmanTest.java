/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorrit
 */
public class HuffmanTest {
    Huffman hm = new Huffman();
    String input = "bananen";
    public HuffmanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Huffman.
     * @throws java.io.IOException
     */
    @Test
    public void testMain() throws IOException {
        System.out.println("main");
        String[] args = null;
    }

    /**
     * Test of getFrequence method, of class Huffman.
     */
    @Test
    public void testGetFrequence() {
        
        System.out.println("getFrequence");
        HashMap<String, Integer> expResult = new HashMap<String, Integer>();
        expResult.put("n", 3);
        expResult.put("a", 2);
        expResult.put("b", 1);
        expResult.put("e", 1);
        HashMap<String, Integer> result = hm.getFrequence(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of sortFrequence method, of class Huffman.
     */
    @Test
    public void testSortFrequence() {
        System.out.println("sortFrequence");
        HashMap<String, Integer> freq = hm.getFrequence(input);
        PriorityQueue<HuffNode> pfreq = hm.sortFrequence(freq);
        HuffNode h;
        h = pfreq.remove();assertEquals('b', h.getCharacter());
        h = pfreq.remove();assertEquals('e', h.getCharacter());
        h = pfreq.remove();assertEquals('a', h.getCharacter());
        h = pfreq.remove();assertEquals('n', h.getCharacter());
    }

    /**
     * Test of createTree method, of class Huffman.
     */
    @Test
    public void testCreateTree() {
        System.out.println("createTree");
         HashMap<String, Integer> freq = hm.getFrequence(input);
        PriorityQueue<HuffNode> pfreq = hm.sortFrequence(freq);
        HuffNode h = hm.createTree(pfreq);
        assertNotNull(h);
        assertEquals('n', h.getLeft().getCharacter());
        assertEquals('a', h.getRight().getRight().getCharacter());
        assertEquals('e', h.getRight().getLeft().getRight().getCharacter());
        assertEquals('b', h.getRight().getLeft().getLeft().getCharacter());
    }

    /**
     * Test of createCodes method, of class Huffman.
     */
    @Test
    public void testCreateCodes() {
        System.out.println("createCodes");
        HashMap<String, Integer> freq = hm.getFrequence(input);
        PriorityQueue<HuffNode> pfreq = hm.sortFrequence(freq);
        HuffNode h = hm.createTree(pfreq);
        HashMap<Character, String> expResult = new HashMap<>();
        expResult.put('n', "0");
        expResult.put('b', "100");
        expResult.put('e', "101");
        expResult.put('a', "11");
        HashMap<Character, String> result = hm.createCodes(h, "");
        assertEquals(expResult, result);
    }

    /**
     * Test of encode method, of class Huffman.
     */
    @Test
    public void testEncode() {
        System.out.println("encode");
        HashMap<String, Integer> freq = hm.getFrequence(input);
        PriorityQueue<HuffNode> pfreq = hm.sortFrequence(freq);
        HuffNode h = hm.createTree(pfreq);
        HashMap<Character, String> characterCodes = hm.createCodes(h, "");
        String expResult = "1001101101010";
        String result = hm.encode(characterCodes, input);
        assertEquals(expResult, result);
    }

    /**
     * Test of decode method, of class Huffman.
     */
    @Test
    public void testDecode() {
        System.out.println("decode");
        HashMap<String, Integer> freq = hm.getFrequence(input);
        PriorityQueue<HuffNode> pfreq = hm.sortFrequence(freq);
        HuffNode h = hm.createTree(pfreq);
        String code = "1001101101010";
        String expResult = "bananen";
        String result = hm.decode(code, h);
        assertEquals(expResult, result);
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
        String result = "";
         for (String s : randomStrings) {
             result += " " + s;
         }
        return result;
    }

    /**
     * Test of Start method, of class Huffman.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println(generateRandomWords(1000));
        String input = "test";
        Huffman instance = new Huffman();
        instance.Start(input);
    }
    
}
