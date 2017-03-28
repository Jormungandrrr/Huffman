/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

/**
 *
 * @author Jorrit
 */
public class HuffNode {
    private char character;
    private int frequency;
    private HuffNode left;
    private HuffNode right;
    private String code;
    
    public HuffNode(char character, int frequency)
    {
        this.character = character;
        this.frequency = frequency;
    }
    
    public HuffNode(int frequency, HuffNode left, HuffNode right)
    {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
    
     public String decode(String message){
        StringBuilder sb = new StringBuilder();
        HuffNode knoop = this;
        for (int i = 0; i < message.length(); i++)
        {
            if (message.charAt(i) == '1'){
                knoop = knoop.getRight();
            }
            else {
                knoop = knoop.getLeft();
            }
            if (knoop.getLeft() == null && knoop.getRight() == null) {
                sb.append(knoop.getCharacter());
                knoop = this;
            }
        }
        System.out.println("Message was: " + sb);
        return sb.toString();
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public HuffNode getLeft() {
        return left;
    }

    public void setLeft(HuffNode left) {
        this.left = left;
    }

    public HuffNode getRight() {
        return right;
    }

    public void setRight(HuffNode right) {
        this.right = right;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
     
     
}
