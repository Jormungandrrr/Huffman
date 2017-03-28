/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

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
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Huffman.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFrequence method, of class Huffman.
     */
    @Test
    public void testGetFrequence() {
        System.out.println("getFrequence");
        String input = "";
        Huffman instance = new Huffman();
        Map<String, Integer> expResult = null;
        Map<String, Integer> result = instance.getFrequence(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortFrequence method, of class Huffman.
     */
    @Test
    public void testSortFrequence() {
        System.out.println("sortFrequence");
        Map<String, Integer> hashMap = null;
        Huffman instance = new Huffman();
        PriorityQueue<HuffNode> expResult = null;
        PriorityQueue<HuffNode> result = instance.sortFrequence(hashMap);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTree method, of class Huffman.
     */
    @Test
    public void testCreateTree() {
        System.out.println("createTree");
        PriorityQueue<HuffNode> q = null;
        Huffman instance = new Huffman();
        HuffNode expResult = null;
        HuffNode result = instance.createTree(q);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCodes method, of class Huffman.
     */
    @Test
    public void testCreateCodes() {
        System.out.println("createCodes");
        HuffNode node = null;
        String code = "";
        Huffman instance = new Huffman();
        HashMap<Character, String> expResult = null;
        HashMap<Character, String> result = instance.createCodes(node, code);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encode method, of class Huffman.
     */
    @Test
    public void testEncode() {
        System.out.println("encode");
        HashMap<Character, String> codeWithString = null;
        String message = "";
        Huffman instance = new Huffman();
        String expResult = "";
        String result = instance.encode(codeWithString, message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decode method, of class Huffman.
     */
    @Test
    public void testDecode() {
        System.out.println("decode");
        String message = "";
        HuffNode rootNode = null;
        Huffman instance = new Huffman();
        String expResult = "";
        String result = instance.decode(message, rootNode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
