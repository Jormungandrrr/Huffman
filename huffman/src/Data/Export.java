/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import huffman.HuffNode;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.BitSet;

/**
 *
 * @author Jorrit
 */
public class Export {

    private FileOutputStream fos;
    private ObjectOutputStream oos;
    
    public void export(String code, HuffNode rootNode) throws FileNotFoundException, IOException {
        
        BitSet set = new BitSet();
        for (int i = 0; i < code.length(); i++) {
            Character c = code.charAt(i);
            boolean value = false;
            switch (c) {
                case '1':
                    value = true;
                    break;
                case '0':
                    value = false;
                    break;
            }
            set.set(i, value);
        }
        
        fos = new FileOutputStream("code.bin");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(set);
        oos.flush();
        
        fos = new FileOutputStream("huffnode.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(rootNode);
        oos.flush();
    }
    
}
