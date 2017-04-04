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
import java.io.PrintWriter;

/**
 *
 * @author Jorrit
 */
public class Export {

    private FileOutputStream fos;
    private ObjectOutputStream oos;
    
    public void export(String code, HuffNode rootNode) throws FileNotFoundException, IOException {
        fos = new FileOutputStream("code.txt");
        PrintWriter out = new PrintWriter(fos);
        out.println(code);
        out.flush();
        System.out.println("code exported");
        
        fos = new FileOutputStream("huffnode.ser");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(rootNode);
        oos.flush();
        System.out.println("node exported");
    }
    
}
