/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import huffman.HuffNode;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Jorrit
 */
public class Import {
    String code = "";
    FileInputStream fis;
    ObjectInputStream ois;
    
    public String getCode() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("code.txt");
        BufferedReader br = new BufferedReader(fr);
        code = br.readLine();
        return code;
    }
    
    public HuffNode getRootNode() throws FileNotFoundException, IOException, ClassNotFoundException{
        fis = new FileInputStream("huffnode.ser");
        ois = new ObjectInputStream(fis);
        HuffNode result = (HuffNode) ois.readObject();
        ois.close();
        return result;
    }
}
