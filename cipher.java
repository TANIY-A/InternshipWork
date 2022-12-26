/***********************************************************************
 * File    - Cipher
 * Author  - Taniya Thomas
 * Description - Encryption and decryption of text using Caesar Cipher
 * Date     - 2/12/2022
 ************************************************************************/
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//Encryption function
class Cipher extends JFrame implements ItemListener,ActionListener {
    String msg,out,temp,temp1;
    int key;
    public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public static String encrypt(String message, int shiftKey){
        message = message.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < message.length(); i++) {
          int charPosition = alphabet.indexOf(message.charAt(i));
          if(message.charAt(i) == ' '){
            cipherText +=" ";
          }
          int keyVal = (shiftKey + charPosition) % 26;
          char replaceVal = alphabet.charAt(keyVal);
          cipherText += replaceVal;
        }
        return cipherText;
    } 
    //Decryption function
    public static String decrypt(String cipherText, int shiftKey) {
        cipherText = cipherText.toLowerCase();
        String message = "";
        for (int i = 0; i < cipherText.length(); i++) {
          if(cipherText.charAt(i) == ' '){
            message +=" ";
            i++;
            continue;
          }
          int charPosition = alphabet.indexOf(cipherText.charAt(i));
          int keyVal = (charPosition - shiftKey) % 26;
          if (keyVal < 0) {
            keyVal = alphabet.length() + keyVal;
          }
          char replaceVal = alphabet.charAt(keyVal);
          message += replaceVal;
        }
        return message;
      }

    // Setting Components
    static JFrame f;
    static JLabel t,l, l1,l2,l3,m,o;
    static JTextArea message,output;
    static JButton set,reset;
    static JComboBox c1,c2;
   
   
    // main class
    public static void main(String[] args)
    {
      
        // create a new frame
        f = new JFrame("Cipher's World");
 
        // create a object
        Cipher s = new Cipher();

        //Setting label
        t= new JLabel("Cipher");
        t.setFont(new Font("Snap ITC",Font.PLAIN,30));
        t.setHorizontalAlignment(JLabel.CENTER);
        t.setHorizontalTextPosition(JLabel.CENTER);
        t.setVerticalAlignment(JLabel.CENTER);
        t.setVerticalTextPosition(JLabel.CENTER);
        l = new JLabel("Choose is yours");
        l2 = new JLabel("Select the mod ");
        m = new JLabel("Enter the message  :   ");
        o= new JLabel("Processed data  :    ");
        o.setBackground(Color.blue);
         // set color of text
         t.setForeground(Color.darkGray);
         l.setForeground(Color.red);
         l2.setForeground(Color.red);
         m.setForeground(Color.black);
        String s1[] = { "Choose", "Encrypt", "Decrypt" };
        String mod[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25"};
        // create checkbox
        c1 = new JComboBox(s1);
        c2 = new JComboBox(mod);
        set= new JButton("Set");
        reset= new JButton("Reset");
       
        message= new JTextArea("");
        message.setBorder(BorderFactory.createLineBorder(Color.black,2));
//        message.setSize(10,3);
//        message.setBounds(20,20,30,10);
        output = new JTextArea("");
        output.setBorder(BorderFactory.createLineBorder(Color.black,2));
        // create a new panel
       JPanel p = new JPanel();
       JPanel p1 = new JPanel(new GridLayout());// added a layout manager
       JPanel p2 = new JPanel();
       JPanel p3 = new JPanel();
       JPanel p4 = new JPanel(new GridLayout());// added a layout manager
       JPanel p5 = new JPanel();
       JPanel p6 = new JPanel();
       JPanel p7 = new JPanel();
       //Adding components to panel
       p.add(t);
       p1.add(m);
       p1.add(message);
       p7.add(p1);
       p2.add(l);
       p2.add(c1);
       p3.add(l2);
       p3.add(c2); 
       p4.add(o);
       p4.add(output);
       p6.add(p4);//added the panel with layout manager to panel without manager
       p5.add(set);
       p5.add(reset);
        // add panel to frame
        f.add(p);
        f.add(p7);
        f.add(p2);
        f.add(p3);
        f.add(p6);
        f.add(p5);
         // setting frame
         
         f.setSize(400, 400);
         f.setResizable(true);
         f.setVisible(true);
         f.setLayout(new GridLayout(6,1));
         f.setBackground(Color.LIGHT_GRAY);
         f.setDefaultCloseOperation(EXIT_ON_CLOSE); //for terminating the execution for program after closing the window
        
    // addItemListener and ActionListener
        c1.addItemListener(s);
        c2.addItemListener(s);
        set.addActionListener(s);
        reset.addActionListener(s);
 
    }
    public void itemStateChanged(ItemEvent e)
    {
        if (e.getSource() == c1) {
            temp1=c1.getSelectedItem().toString();
        }
        if (e.getSource() == c2){
             temp=c2.getSelectedItem().toString();
             
        }
    }
    public void actionPerformed(ActionEvent a) {
          if(a.getSource()== set && temp1=="Encrypt"){
              msg=message.getText();
              key=Integer.parseInt(temp);
              output.setText(encrypt(msg, key));
              
          }
          if(a.getSource()== set && temp1=="Decrypt"){
            msg=message.getText();
            key=Integer.parseInt(temp);
            output.setText(decrypt(msg, key));
            
        }
          if(a.getSource()== reset){
            message.setText(" ");
            output.setText(" ");  
        }
        
    }
}
