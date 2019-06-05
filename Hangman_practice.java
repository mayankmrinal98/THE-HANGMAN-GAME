import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.awt.Font.ITALIC;


class Hangman_practiceinit extends JFrame
{
    private HP hp;
    private int chancesLeft;
    private JLabel[] anslabel;
    //   private JTextField entrytext;
    private JLabel attemptTakenLabel;
    private JLabel attemptTakenShowLabel;
    private JLabel chancesLeftLabel;
    private JLabel chancesLeftShowLabel;
    private String selectedWord;
    private JButton submitChoiceButton;
    private JButton[] entrybutton;
    private JButton[] eachbuttonflag;
    private int finalflag;
    private int buttonflag[];
    private int wordlength;
    private JLabel dhintlabel;
    private JLabel addhintlabel;
    private JLabel dhintshowlabel;
    private JLabel addhintshowLabel;
    private int finalcount=0;
    private JButton addhintBtn;
    private int addhintflag;
    private JLabel imageLabel;
    private ImageIcon image1;
    private ImageIcon image2;
    private ImageIcon image3;
    private ImageIcon image4;
    private ImageIcon image5;
    private ImageIcon image3add;
    private ImageIcon titleimage;
    private int effsize;
    private JLabel titlelabel;
    private int lives;
    private deadclass DC;
    private successclass SC;

    Hangman_practiceinit(HP h,int l)
    {

        setLayout(null);
        hp=h;
        lives=l;


        titlelabel=new JLabel();
        titlelabel.setBounds(500,5,500,120);
        //titleimage=new ImageIcon("")
        titleimage=new ImageIcon("HangmanLogo.png");
        titlelabel.setIcon(titleimage);
        //add(imageLabel);
        //titlelabel.setFont("HANGMAN", Font.BOLD,30);
        add(titlelabel);


        hp.spacesindex();
        int i;
        effsize=hp.reteffsize();
        addhintflag=0;
        int temp=0;
        finalflag=0;

        image1 =new ImageIcon("1.png");
        image2 =new ImageIcon("2.png");
        image3 =new ImageIcon("2+.png");
        image4 =new ImageIcon("3.png");
        image5 =new ImageIcon("4.png");


        imageLabel=new JLabel();
        imageLabel.setBounds(990,200,80,150);
        imageLabel.setIcon(image1);
        add(imageLabel);

        addhintBtn=new JButton("Additional Hint");
        //hintBtn.setBounds();
        addhintBtn.setBounds(990,460,170,20);
        add(addhintBtn);

        buttonflag=new int[26];
        eachbuttonflag=new JButton[26];

        dhintlabel=new JLabel("Hint  :  ");
        dhintlabel.setBounds(490,280,150,30);
        dhintlabel.setFont(new Font("Tahoma",Font.PLAIN,18));

        add(dhintlabel);

        //dhintshowlabel=new JLabel();

        //dhintshowlabel.setText(hp.retselectedhint1());

        dhintshowlabel=new JLabel("<html><div style='text-align: left;'>"+hp.retselectedhint1()+"</div></html>");
        dhintshowlabel.setBounds(660,280,600,30);
        dhintshowlabel.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(dhintshowlabel);


        addhintlabel=new JLabel();
        addhintlabel.setBounds(430,320,190,60);
        add(addhintlabel);

        addhintshowLabel=new JLabel();
        addhintshowLabel.setBounds(630,320,400,60);
        add(addhintshowLabel);


        for( i=0;i<26;i++)
            buttonflag[i]=0;


        chancesLeft=l;
        selectedWord=hp.retword();
        wordlength=selectedWord.length();
        anslabel=new JLabel[wordlength];

        for( i=0;i<wordlength;i++)
        {
            anslabel[i]=new JLabel();
            anslabel[i].setBounds(480+temp,200,30,30);
            temp+=35;
            //anslabel[i].setBackground(Color.MAGENTA);

            anslabel[i].setText("__");
            anslabel[i].setFont(new Font("Tahoma",Font.BOLD,25));

            if(selectedWord.charAt(i) != ' ')add(anslabel[i]);

        }

       /// anslabel=new JLabel[hp.retwordlength()];
        //     entry=new JTextField();
        attemptTakenLabel=new JLabel("Keys Already Pressed");
        attemptTakenShowLabel=new JLabel();
        chancesLeftLabel=new JLabel("Chances Left");
        chancesLeftShowLabel=new JLabel();
        chancesLeftShowLabel.setText(Integer.toString(chancesLeft));
        entrybutton=new JButton[26];
        int k='A';

        for( i=0;i<26;i++)
        {
            Character strtemp=(char)k;
            String str=Character.toString(strtemp);
            entrybutton[i]=new JButton(str);
            // System.out.println(Character.toString((char)(k)));
            k++;
        }
         temp=0;
        for( i=0;i<7;i++)
        {
            entrybutton[i].setBounds(330+temp,450,60,20);
            add(entrybutton[i]);
            temp+=90;
        }
        temp=0;
        for( i=7;i<13;i++)
        {
            entrybutton[i].setBounds(390+temp,480,60,20);
            add(entrybutton[i]);
            temp+=90;
        }
        temp=0;
        for( i=13;i<20;i++)
        {
            entrybutton[i].setBounds(330+temp,510,60,20);
            add(entrybutton[i]);
            temp+=90;
        }
        temp=0;
        for( i=20;i<26;i++)
        {
            entrybutton[i].setBounds(390+temp,540,60,20);
            add(entrybutton[i]);
            temp+=90;
        }
        temp=0;
        for(i=0;i<hp.retwordlength();i++)
        {
            anslabel[i]=new JLabel();
            anslabel[i].setBounds(430+temp,275,40,20);
            add(anslabel[i]);
            temp+=60;
        }
        attemptTakenLabel.setBounds(800,460,200,20);
        //add(attemptTakenLabel);
        attemptTakenShowLabel.setBounds(800,490,200,20);
        //add(attemptTakenShowLabel);
        chancesLeftLabel.setBounds(1030,500,150,20);
        add(chancesLeftLabel);
        chancesLeftShowLabel.setBounds(1060,520,50,20);
        add(chancesLeftShowLabel);


        addhintBtn.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(addhintflag==1)
                    JOptionPane.showMessageDialog(null,"You have already used additional hint");
                else {

                    if(chancesLeft==4)
                    {
                        imageLabel.setIcon(image2);
                        add(imageLabel);
                    }

                    if(chancesLeft==3)
                    {
                        imageLabel.setIcon(image3);
                        add(imageLabel);
                    }

                    if(chancesLeft==2)
                    {
                        imageLabel.setIcon(image4);
                        add(imageLabel);
                    }

                    if(chancesLeft==1)
                    {
                        imageLabel.setIcon(image5);
                        add(imageLabel);
                    }


                    if (chancesLeft <= 1) {
                        JOptionPane.showMessageDialog(null, "You can only opt for additional hint if chances left are more than 1");
                    } else {
                        addhintlabel.setText("Additional Hint :     ");
                        addhintlabel.setFont(new Font("Tahoma",Font.PLAIN,18));
                        //addhintshowLabel.setText(h.retselectedhint2());
                        addhintshowLabel.setText("<html><div style='text-align: left;'>"+hp.retselectedhint2()+"</div></html>");

                       // =new JLabel("<html><div style='text-align: left;'>"+hp.retselectedhint1()+"</div></html>");

                        addhintshowLabel.setFont(new Font("Tahoma",Font.PLAIN,18));

                        chancesLeft--;
                        chancesLeftShowLabel.setText(Integer.toString(chancesLeft));
                    }

                    addhintflag = 1;
                }
            }
        }));


        for(int w=0;w<entrybutton.length;w++)
     {
         int m=w;

/*         System.out.print("wordlength : ");
         System.out.println(wordlength);
         System.out.print("effsize : ");
         System.out.println(effsize);*/
         entrybutton[m].addActionListener((new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 String c=entrybutton[m].getText();
                 int tempflag=0;
                if(buttonflag[m]==1)
                    JOptionPane.showMessageDialog(null,"You have already pressed this key");
                else {
                           // System.out.println(wordlength-effsize);
                        for (int k = 0; k < wordlength; k++) {
                            if (selectedWord.charAt(k) == c.charAt(0)) {

                                anslabel[k].setText(c);
                                entrybutton[m].setBackground(Color.green);

                                finalcount++;

                              //  System.out.println(finalcount);

                                tempflag=1;
                                if(finalcount==effsize)
                                {
                                     SC=new successclass(selectedWord);
                                }
                                //   System.out.println(selectedWord);
                               /* for(int p=0;p<wordlength;p++)
                                {
                                    if(anslabel[p].getText().length()0)
                                    {

                                    }
                                }*/
                            }


                        }

                        if(tempflag==0)
                        {
                            chancesLeft--;
                            entrybutton[m].setBackground(Color.red);

                            if(chancesLeft==4)
                            {
                                imageLabel.setIcon(image2);
                                add(imageLabel);
                            }

                            if(chancesLeft==3)
                            {
                                imageLabel.setIcon(image3);
                                add(imageLabel);
                            }

                            if(chancesLeft==2)
                            {
                                imageLabel.setIcon(image4);
                                add(imageLabel);
                            }

                            if(chancesLeft==1)
                            {
                                imageLabel.setIcon(image5);
                                add(imageLabel);
                            }




                            if(chancesLeft>=1)
                            chancesLeftShowLabel.setText(Integer.toString(chancesLeft));
                            else
                            {
                                //chancesLeft--;
                                chancesLeftShowLabel.setText(Integer.toString(chancesLeft));
                                DC=new deadclass(selectedWord);
                            }

                            /*Graphics */


                        }

                        buttonflag[m] = 1;
                    }
             }
         }));
     }
    }


}






class data{
    private String name;
    private String hint1;
    private String hint2;
    data(String name,String hint1,String hint2){
        this.name=name;
        this.hint1=hint1;
        this.hint2=hint2;
    }
    public String getname() {
        return name;
    }
    public String gethint1() {
        return hint1;
    }
    public String gethint2() {
        return hint2;
    }
}

class BufferReader
{
    void readfromCSV(Collection <data> col)
    {
        FileInputStream fis = null;
        BufferedReader reader = null;

        try {
            fis = new FileInputStream("Hangman2.csv");
            reader = new BufferedReader(new InputStreamReader(fis));

            // System.out.println("Reading File line by line using BufferedReader");

            String line = reader.readLine();
            while(line != null){
                line = reader.readLine();
                if(line!=null)
                {
                    String[] s=line.split(",");
                  //  for(int i=0;i<s.length;i++) {
                    //    System.out.print(s[i]+" ");

                    //}
                    //System.out.println(s[0]+" "+s[1]+" "+s[2]);
                   // System.out.println("");
                    col.add(new data(s[0],s[1],s[2]));
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BufferReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BufferReader.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(BufferReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}


class HP
{
    //private String[] words  = new String[]{"Apple","Orange","Peach","Mango","Banana"};
   // ArrayList<String>words;/*new ArrayList<String>;*/
    ArrayList<Integer>spacesindex=new ArrayList<Integer>();
    private int selectedwordindex;
    private int chances;
    //private int flag;
    private int wordlength;
    private String selectedword;
    private String selectedhint1;
    private String selectedhint2;
    private int effectivesize=0;
    //ArrayList<data> dt;

    BufferReader bf;
    ArrayList<data> dAL;


    HP()
    {


        bf=new BufferReader();
        dAL=new ArrayList<data>();
        bf.readfromCSV(dAL);

        //words.add(new data("APPLE","Fruit","Keeps the doctor away"));
    }
    void setselectedindex()
    {
        Random r=new Random();
        selectedwordindex=r.nextInt(dAL.size());
       // selectedword=words.get(selectedwordindex);
            selectedword=dAL.get(selectedwordindex).getname();
            selectedhint1=dAL.get(selectedwordindex).gethint1();
            selectedhint2=dAL.get(selectedwordindex).gethint2();
//        System.out.println(words.get(selectedwordindex));

    }


    void printdAL()
    {
        for(int i=0;i<dAL.size();i++)
        {
            System.out.println(dAL.get(i).getname()+" "+dAL.get(i).gethint1()+" "+dAL.get(i).gethint2());
        }
    }

    public String retselectedword()
    {
        return selectedword;
    }

    public String retselectedhint1()
    {
        return selectedhint1;
    }

    public String retselectedhint2()
    {
        return selectedhint2;
    }

    public int reteffsize()
    {
        return effectivesize;
    }

    public void spacesindex()
    {
        for(int i=0;i<selectedword.length();i++)
        {
            if(selectedword.charAt(i) == ' ')
            {
                spacesindex.add(i);
            }
        }
        effectivesize=selectedword.length()-spacesindex.size();
    }

    public String retword()
    {
        return dAL.get(selectedwordindex).getname();
    }

    /*void setchances()
    {
        chances= dAL.get(selectedwordindex).getname().length();
    }

    public int retchances()
    {
        return chances;
    }
    void setwordlength()
    {
        wordlength=dAL.get(selectedwordindex).getname().length();
    }*/

    int retwordlength()
    {
        return wordlength;
    }

}






public class Hangman_practice {
    //private HP h;
    private int lives;
   // public static void main(String args[])
    Hangman_practice(int l)
    {
        /*BufferReader bf=new BufferReader();
        ArrayList<data> dAL=new ArrayList<data>();
        bf.readfromCSV(dAL);*/
        lives=l;
        HP h=new HP();
      //  h.printdAL();
        h.setselectedindex();
        Hangman_practiceinit jf1=new Hangman_practiceinit(h,lives);
        jf1.setSize(1500,1000);
        jf1.getContentPane().setBackground(new Color(128,190,128));
        jf1.setVisible(true);
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}