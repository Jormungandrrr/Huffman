/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.Comparator;

/**
 *
 * @author Jorrit
 */
public class HuffNodeCompare  implements Comparator<HuffNode> {
     @Override
    public int compare(HuffNode o1, HuffNode o2) {
        if (o1.getFrequency() > o2.getFrequency()) {
            return 1;
        }
        else if(o1.getFrequency() < o2.getFrequency())
        {
            return -1;
        }
        else
        {
            Character c1 = o1.getCharacter();
            Character c2 = o2.getCharacter();

            return c1.compareTo(c2);
        }
    }
}
