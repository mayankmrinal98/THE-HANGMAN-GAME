import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
//import javax.m.Player;
import sun.audio.*;
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
import static java.awt.font.TextAttribute.FONT;


class mainclassinit  extends JFrame
{

        private JLabel titlelabel;
        private JButton easybtn;
        private JButton mediumbtn;
        private JButton hardbtn;
        private JButton startgamebtn;
        private ImageIcon titleimage;
        private Hangman_practice secondmainclass;
        private int lives=0;
        private int btnflag[];
        private JLabel[] Instructionlabel;
        private String[] instructiondatastring;
        private JLabel instruction;


       public void sound()
        {
           // System.out.println("sjefbdjfbd,");
            AudioPlayer AP=AudioPlayer.player;
            AudioStream AS;
            AudioData AD;
            ContinuousAudioDataStream loop=null;
            try {
                AS = new AudioStream((new FileInputStream("PUBG.wav")));
                AD=AS.getData();
                loop=new ContinuousAudioDataStream(AD);
            }
            catch(IOException error){}
            AP.start(loop);
        }

        mainclassinit()
        {
            setLayout(null);
            //this.sound();

          //  MediaPlayer mediaPlayer = Manager.createRealizedPlayer(media);
          //  mediaPlayer.start()
            //final int[] btnflag = {0};
            Color levels=Color.decode("#ffffff");

            instruction =new JLabel("LEVELS");
            instruction.setBounds(610,520,90,30);
            instruction.setFont(new Font("Tahoma",Font.BOLD,20));
            instruction.setForeground(levels);
            add(instruction);

            instructiondatastring=new String[8];
            instructiondatastring[0]="Do you have what it takes to save your neck from the noose ?";
            instructiondatastring[1]="If you think you do, then read on...";
            instructiondatastring[2]="Hangman is a word-guessing game in which you get a couple of hints and limited number of attempts to guess the letters of the word.";
            instructiondatastring[3]="The game has some easy-to-understand rules (unlike the mails of a certain Assistant Professor) ";
            instructiondatastring[4]="1. The first hint is vague to give you the idea of what kind of word it is.";
            instructiondatastring[5]="2. You can click on any letter to see if it is there in that word. If you're wrong, you lose one life.";
            instructiondatastring[6]="3. If you want you can get an additional hint to give more info about that specific word. This additional hint will cost you a life and it can't be used if you have one life left.";
            instructiondatastring[7]="4. If you can guess the word with lives remaining, you win! Otherwise you lose, you hang,     you die.";

            Instructionlabel=new JLabel[8];
            int stringtemp=0;

            Color mycolor=Color.decode("#660033");


            for(int i=0;i<8;i++)
            {
               Instructionlabel[i]=new JLabel("<html><div style='text-align: left;'>"+instructiondatastring[i]+"</div></html>");
                //Instructionlabel[i]=new JLabel("keghr");
                Instructionlabel[i].setBounds(300,160+stringtemp,800,60);
                Instructionlabel[i].setFont(new Font("Tahoma",Font.BOLD,15));
                Instructionlabel[i].setForeground(mycolor);
                add(Instructionlabel[i]);
                stringtemp+=40;

            }

            btnflag=new int[1];

            titlelabel=new JLabel();
            titlelabel.setBounds(520,5,500,120);
            //titleimage=new ImageIcon("")
            titleimage=new ImageIcon("HangmanLogo.png");
            titlelabel.setIcon(titleimage);
            //add(imageLabel);
            //titlelabel.setFont("HANGMAN", Font.BOLD,30);
            add(titlelabel);

            easybtn=new JButton("Noob");
            easybtn.setBounds(330,580,120,20);
            add(easybtn);

            mediumbtn=new JButton("Rookie");
            mediumbtn.setBounds(590,580,120,20);
            add(mediumbtn);

            hardbtn=new JButton("Pro");
            hardbtn.setBounds(850,580,120,20);
            add(hardbtn);

            startgamebtn=new JButton("!!!  GO  !!!");
            startgamebtn.setBounds(580,640,150,20);
            add(startgamebtn);

            easybtn.addActionListener((new ActionListener() {
              //  int b=btnflag
                @Override
                public void actionPerformed(ActionEvent e) {
                    lives=5;

                    //if(btnflag[0]==1)

                    JOptionPane.showMessageDialog(null,"Easy Level Seleted. Click GO when ready!!");
                    btnflag[0] =1;
                }
            }));

            mediumbtn.addActionListener((new ActionListener() {
               // int b=btnflag
                @Override
                public void actionPerformed(ActionEvent e) {
                    lives=4;
                    JOptionPane.showMessageDialog(null,"Medium Level Seleted. Click GO when ready!!");
                    btnflag[0] =1;
                }
            }));

            hardbtn.addActionListener((new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lives=3;
                    JOptionPane.showMessageDialog(null,"Hard Level Seleted. Click GO when ready!!");
                    btnflag[0] =1;
                }
            }));

            startgamebtn.addActionListener((new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(btnflag[0]==0)
                        JOptionPane.showMessageDialog(null,"Level not selected. Please select level.");
                    else
                    secondmainclass=new Hangman_practice(lives);

                }
            }));


        }

}



class mainclass {
    mainclass()
    {
        mainclassinit jf1=new mainclassinit();
        jf1.setSize(1500,1000);
        //jf1.sound();
        jf1.getContentPane().setBackground(new Color(128,190,128));
        jf1.setVisible(true);
        jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
