import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class successclassinit extends JFrame{

    private JLabel titlelabel;
    private ImageIcon titleimage;
    private String selectedword;
    private JLabel answerconfirmationlabel;
    private JLabel answerconfirmationlabel2;
    private ImageIcon jokerimage;
    private JLabel jokerimagelabel;
    private JLabel wellplayedlabel;
    private JButton playagainbutton;
    private JButton exitbutton;


    successclassinit(String sw)
    {
        setLayout(null);
        selectedword=sw;
        titlelabel=new JLabel();
        titlelabel.setBounds(520,5,500,120);
        titleimage=new ImageIcon("HangmanLogo.png");
        titlelabel.setIcon(titleimage);
        add(titlelabel);


        answerconfirmationlabel=new JLabel();
        answerconfirmationlabel=new JLabel("<html><div style='text-align: centre;'>"+"Yeah!! You guessed it right. "+"</div></html>");
        answerconfirmationlabel.setBounds(510,170,700,30);
        answerconfirmationlabel.setFont(new Font("Tahoma",Font.BOLD,18));
        Color mycolor=Color.decode("#660033");
        answerconfirmationlabel.setForeground(mycolor);
        add(answerconfirmationlabel);

        answerconfirmationlabel2=new JLabel();
        answerconfirmationlabel2=new JLabel("<html><div style='text-align: centre;'>"+selectedword+ " is indeed the correct anwser."+"</div></html>");
        answerconfirmationlabel2.setBounds(450,200,700,60);
        answerconfirmationlabel2.setFont(new Font("Tahoma",Font.BOLD,18));
       // Color mycolor=Color.decode("#660033");
        answerconfirmationlabel2.setForeground(mycolor);
        add(answerconfirmationlabel2);

        jokerimage=new ImageIcon("joker.gif");

        jokerimagelabel=new JLabel();
        jokerimagelabel.setBounds(420,300,498,205);
        jokerimagelabel.setIcon(jokerimage);
        add(jokerimagelabel);

        wellplayedlabel=new JLabel();
        wellplayedlabel=new JLabel("<html><div style='text-align: centre;'>"+"!!!   WELL PLAYED   !!! "+"</div></html>");
        wellplayedlabel.setBounds(470,550,700,50);
        wellplayedlabel.setFont(new Font("Tahoma",Font.BOLD,35));
         mycolor=Color.decode("#000000");
        wellplayedlabel.setForeground(mycolor);
        add(wellplayedlabel);

        playagainbutton=new JButton("Play Again");
        playagainbutton.setBounds(400,620,150,30);
        playagainbutton.setFont(new Font("Tahoma",Font.BOLD,15));
        add(playagainbutton);

        playagainbutton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainclass m=new mainclass();
            }
        }));

        exitbutton=new JButton("Exit");
        exitbutton.setBounds(790,620,150,30);
        exitbutton.setFont(new Font("Tahoma",Font.BOLD,15));
        add(exitbutton);

        exitbutton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        }));

    }
}


class successclass
{
    private String selectedword;

    successclass(String s)
    {
        selectedword=s;
        successclassinit jf=new successclassinit(selectedword);
        //jf.setComponents();
        jf.setSize(1500,1000);
        jf.setVisible(true);
        Color bgcolor=Color.decode("#1cb6c3");
        jf.getContentPane().setBackground(bgcolor);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}