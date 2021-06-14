
package card_stacks;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

/************************Dice_Program Class*************************************/

public class Dice_Program extends JFrame implements ActionListener
{
    static JLabel lblTitle,lblNumOfDice,lblFaces,lblRemove,lblShowCard;
    static JTextField txtNumOfDice,txtFaces,txtRemove;
    static JButton btnStart,btnRoll,btnDraw,btnShuffle,btnPeek,btnReset,btnGraph,btnExit;
    public static int NoOfRemove;

/*********************************Constructor***********************************/

   Dice_Program() 
   {
       this.setTitle("Card Stack");
       this.setBounds(333,100,700,550);
       this.setLayout(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setContentPane(new JLabel(new ImageIcon("bg7.jpg")));
       this.setResizable(false);

       Font f1=new Font("Dialog",Font.BOLD,15);//Building Font object
       Font f2=new Font("Dialog",Font.BOLD,70);
      
       lblNumOfDice=new JLabel("Number of Dice");
       lblNumOfDice.setBounds(90,10,110,20);
       lblNumOfDice.setFont(f1);//For font
       lblNumOfDice.setForeground(Color.WHITE);//For  Font Color
       this.add(lblNumOfDice);

       txtNumOfDice=new JTextField();
       txtNumOfDice.setBounds(100,40,60,50);
       txtNumOfDice.setHorizontalAlignment(SwingConstants.CENTER);
       this.add(txtNumOfDice);

       lblFaces=new JLabel("Dice Face");
       lblFaces.setBounds(297,10,100,20);
       lblFaces.setFont(f1);
       lblFaces.setForeground(Color.WHITE);
       this.add(lblFaces);

       txtFaces=new JTextField();
       txtFaces.setBounds(300,40,60,50);
       txtFaces.setHorizontalAlignment(SwingConstants.CENTER);
       this.add(txtFaces);

       lblRemove=new JLabel("Removed Card");
       lblRemove.setBounds(484,10,110,20);
       lblRemove.setFont(f1);
       lblRemove.setForeground(Color.WHITE);
       this.add(lblRemove);

       txtRemove=new JTextField();
       txtRemove.setBounds(500,40,60,50);
       txtRemove.setHorizontalAlignment(SwingConstants.CENTER);
       this.add(txtRemove);
       

       btnRoll=new JButton("Roll");
       btnRoll.setBounds(70,130,100,40);
       btnRoll.setFont(f1);
       btnRoll.setForeground(Color.WHITE);
       btnRoll.setBackground(Color.RED);
       this.add(btnRoll);
       btnRoll.addActionListener(this);

       btnStart=new JButton("Start");
       btnStart.setBounds(70,190,100,40);
       btnStart.setFont(f1);
       btnStart.setForeground(Color.WHITE);
       btnStart.setBackground(Color.RED);
       this.add(btnStart);
       btnStart.addActionListener(this);
      
       btnDraw=new JButton("Draw");
       btnDraw.setBounds(310,450,100,40);
       btnDraw.setFont(f1);
       btnDraw.setForeground(Color.WHITE);
       btnDraw.setBackground(Color.RED);
       this.add(btnDraw);
       btnDraw.addActionListener(this);

       lblShowCard=new JLabel("Card");
       lblShowCard.setBounds(250,140,200,125);
       lblShowCard.setFont(f2);
       lblShowCard.setHorizontalAlignment(SwingConstants.CENTER);
       this.add(lblShowCard);
       
       btnShuffle=new JButton("Shuffle");
       btnShuffle.setBounds(545,270,100,40);
       btnShuffle.setFont(f1);
       btnShuffle.setForeground(Color.WHITE);
       btnShuffle.setBackground(Color.RED);
       this.add(btnShuffle);
       btnShuffle.addActionListener(this);

       btnPeek=new JButton("Peek");
       btnPeek.setBounds(545,330,100,40);
       btnPeek.setFont(f1);//For font
       btnPeek.setForeground(Color.WHITE);//For Color
       btnPeek.setBackground(Color.RED);
       this.add(btnPeek);
       btnPeek.addActionListener(this);

       btnGraph=new JButton("Graph");
       btnGraph.setBounds(545,390,100,40);
       btnGraph.setForeground(Color.WHITE);
       btnGraph.setBackground(Color.RED);
       btnGraph.setFont(f1);
       this.add(btnGraph);
       btnGraph.addActionListener(this);

       btnReset=new JButton("Reset");
       btnReset.setBounds(556,470,80,40);
       btnReset.setBackground(Color.BLACK);
       btnReset.setFont(f1);
       btnReset.setForeground(Color.WHITE);
       this.add(btnReset);
       btnReset.addActionListener(this);

       btnExit=new JButton("Exit");
       btnExit.setBounds(20,470,80,40);
       btnExit.setBackground(Color.BLACK);
       btnExit.setFont(f1);
       btnExit.setForeground(Color.WHITE);
       this.add(btnExit);
       btnExit.addActionListener(this);

       this.setVisible(true);
   }

/*******************************************************************************/

/*************************Checking Input is Number OR Not***********************/

   public boolean Check_Number(String value)
   {
       StringBuffer strB = new StringBuffer("abcdefghijklmnopqrstuvwxyz");

       for(int i=0;i<strB.length();i++)
       {
           if(value.indexOf(strB.charAt(i))==0)
           {
               return true;
           }
       }
       return false;
   }

/*******************************************************************************/

/****************************Action Performed Method****************************/
    
   public void actionPerformed(ActionEvent ae)
   {
        if(ae.getSource()==btnRoll)
        {
            if(txtNumOfDice.getText().equals(""))//if there is no num of dice
            {
                JOptionPane.showMessageDialog(null, "Please Enter Number of Dice");
            }

            else if (Check_Number(txtNumOfDice.getText())==true)//if num of dice is a,b,c,...,etc
            {
                JOptionPane.showMessageDialog(null, "   Please Enter Number only !!");
            }

            else if(txtFaces.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter Number of Faces");
            }

             else if (Check_Number(txtFaces.getText())==true)
            {
                 JOptionPane.showMessageDialog(null, "   Please Enter Number only !!");

            }

            else if(txtRemove.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Remove the cards!!");
            }

             else if (Check_Number(txtRemove.getText())==true)
            {
                JOptionPane.showMessageDialog(null, "Please Enter Number only");
            }
            
            else
            {
                Dice_Distrubution.Probability(/*txtRemove.getText(),*/txtFaces.getText(),txtNumOfDice.getText());
                JOptionPane.showMessageDialog(null, "     Dice Roll has finished!!");
            }

         }//Roll Button

        else if(ae.getSource()==btnStart)
        {

            if(txtNumOfDice.getText().equals(""))//if there is no num of dice
            {
                JOptionPane.showMessageDialog(null, "Please Enter Number of Dice");
            }

            else if (Check_Number(txtNumOfDice.getText())==true)//if num of dice is a,b,c,...,etc
            {
                JOptionPane.showMessageDialog(null, "   Please Enter Number only !!");
            }

            else if(txtFaces.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter Number of Faces");
            }

             else if (Check_Number(txtFaces.getText())==true)
            {
                 JOptionPane.showMessageDialog(null, "   Please Enter Number only !!");

            }

            else if(txtRemove.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Remove the cards!!");
            }

             else if (Check_Number(txtRemove.getText())==true)
            {
                JOptionPane.showMessageDialog(null, "Please Enter Number only");
            }

            else
            {
                txtRemove.getText();
                NoOfRemove=Integer.parseInt(txtRemove.getText());

                if(NoOfRemove>Dice_Distrubution.TotalCount)
                {
                    JOptionPane.showMessageDialog(null, "Card Stack has only "+ Dice_Distrubution.TotalCount+" Cards. Please remove Cards again!");
                    txtRemove.setText("");
                }

                else
                {
                Dice_Distrubution.Generate(NoOfRemove);
                }
            }
        }//Start Button

        else if(ae.getSource()==btnDraw)
            {
                if(Dice_Distrubution.ShuffleCardDistList.size()==0)
                {
                    if (txtNumOfDice.getText().equals(""))//if there is no num of dice
                    {
                        if(txtFaces.getText().equals(""))
                            {
                                if(txtRemove.getText().equals(""))
                                {
                                    JOptionPane.showMessageDialog(null, "Please generate the card stack first!");
                                }
                            }
                    }
                    else
                    JOptionPane.showMessageDialog(null, "             End of the list"); 
                }
                
                else
                {
                   lblShowCard.setText(String.valueOf(Dice_Distrubution.ShuffleCardDistList.get(0)));

                    Dice_Distrubution.DrawnCard.add(Dice_Distrubution.ShuffleCardDistList.get(0));

                    /**************************Remove Card**************************************/

                    int click;
                    click=Dice_Distrubution.ShuffleCardDistList.remove(0);
                    Dice_Distrubution.StoreRemove.add(click);
                }
        }//Draw Button
        else if(ae.getSource()==btnShuffle)
        {
            Collections.shuffle((Dice_Distrubution.ShuffleCardDistList));//Shuffle Code
        }//Shuffle Button

        else if(ae.getSource()==btnReset)
        {
            if(JOptionPane.showConfirmDialog(null,"Are you sure to reset?", "Confirm Box",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE)==JOptionPane.YES_OPTION)
            {
                Reset();
            }
        }//Reset Button

        else if(ae.getSource()==btnPeek)
        {
            Peek pk=new Peek();
            pk.txafutureRes.setText(String.valueOf(Dice_Distrubution.ShuffleCardDistList));
            pk.txaDrawn.setText(String.valueOf(Dice_Distrubution.DrawnCard));
            pk.txaRemove.setText(String.valueOf(Dice_Distrubution.StoreRemove));
        }//Peek Button

        else if(ae.getSource()==btnGraph)
        {
            GraphClass gc=new GraphClass();
            gc.ShowGraph();
        }//Graph Button
        else if(ae.getSource()==btnExit)
        {
            if(JOptionPane.showConfirmDialog(null, "       Are you sure to exit?","Exit!",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
	     System.exit(0);
	}//Exit Button
   }

/*******************************************************************************/

/*****************************Reset Method**************************************/

   public static void Reset()
   {
       Dice_Distrubution.StoreRemove.clear();
       Dice_Distrubution.DrawnCard.clear();
       Dice_Distrubution.ShuffleCardDistList.clear();
       lblShowCard.setText("Card");
       txtNumOfDice.setText("");
       txtFaces.setText("");
       txtRemove.setText("");
  }

/*******************************************************************************/

  public static void main(String[] args)
  {
       Dice_Program dp=new Dice_Program();
  }

}

/*******************************************************************************/

/******************************Peek Class***************************************/

class Peek extends JFrame implements ActionListener
{
    JLabel lblfutureRes,lblDrawn,lblremove;
    JTextArea txafutureRes,txaDrawn,txaRemove;
    JButton btnBack,btnGraph,btnReset,btnExit;

/****************************Constructor****************************************/
   
    public Peek()
    {
       this.setBounds(333,100,700,550);
       this.setLayout(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setContentPane(new JLabel(new ImageIcon("bg8.jpg")));

       Font f1=new Font("SERIF",Font.BOLD,35);
       Font f2=new Font("Dialog",Font.BOLD,15);

       lblfutureRes=new JLabel("Future Result");
       lblfutureRes.setBounds(15,20,215,50);
       lblfutureRes.setFont(f1);
       lblfutureRes.setForeground(Color.WHITE);
       lblfutureRes.setHorizontalAlignment(SwingConstants.CENTER);
       this.add(lblfutureRes);

       lblDrawn=new JLabel("Drawn");
       lblDrawn.setBounds(265,20,150,50);
       lblDrawn.setFont(f1);
       lblDrawn.setForeground(Color.WHITE);
       lblDrawn.setHorizontalAlignment(SwingConstants.CENTER);
       this.add(lblDrawn);

       lblremove=new JLabel("Remove");
       lblremove.setBounds(500,20,150,50);
       lblremove.setFont(f1);
       lblremove.setForeground(Color.WHITE);
       lblremove.setHorizontalAlignment(SwingConstants.CENTER);
       this.add(lblremove);

       txafutureRes=new JTextArea();
       JScrollPane firScroll=new JScrollPane(txafutureRes,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       firScroll.setBounds(30,100,160,200);
       this.add(firScroll);

       txaDrawn=new JTextArea();
       JScrollPane secScroll=new JScrollPane(txaDrawn,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       secScroll.setBounds(265,100,160,200);
       this.add(secScroll);

       txaRemove=new JTextArea();
       JScrollPane thrScroll=new JScrollPane(txaRemove,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       thrScroll.setBounds(500,100,160,200);
       this.add(thrScroll);

       btnBack=new JButton("Back");
       btnBack.setBounds(535,390,100,40);
       btnBack.setBackground(Color.RED);
       btnBack.setFont(f2);
       btnBack.setForeground(Color.WHITE);
       this.add(btnBack);
       btnBack.addActionListener(this);

       btnGraph=new JButton("Graph");
       btnGraph.setBounds(535,330,100,40);
       btnGraph.setForeground(Color.WHITE);
       btnGraph.setBackground(Color.RED);
       btnGraph.setFont(f2);
       this.add(btnGraph);
       btnGraph.addActionListener(this);

       btnReset=new JButton("Reset");
       btnReset.setBounds(546,460,80,40);
       btnReset.setBackground(Color.BLACK);
       btnReset.setFont(f2);
       btnReset.setForeground(Color.WHITE);
       this.add(btnReset);
       btnReset.addActionListener(this);

       btnExit=new JButton("Exit");
       btnExit.setBounds(20,460,80,40);
       btnExit.setBackground(Color.BLACK);
       btnExit.setFont(f2);
       btnExit.setForeground(Color.WHITE);this.add(btnExit);
       btnExit.addActionListener(this);

       this.setVisible(true);

    }

/*******************************************************************************/

/****************************Action Performed Method****************************/

    public void actionPerformed(ActionEvent pe)
    {
        if(pe.getSource()==btnBack)
        {
            this.dispose();
        }//Back Button

        else if(pe.getSource()==btnReset)
        {
            if(JOptionPane.showConfirmDialog(null,"Are you sure to reset?", "Confirm Box",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE)==JOptionPane.YES_OPTION)
            {
                Dice_Program.Reset();
            }
        }//Reset Button

        else if(pe.getSource()==btnExit)
        {
            if(JOptionPane.showConfirmDialog(null, "Are you sure to exit?","Exit!",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
	     System.exit(0);
	}//Exit Button

         else if(pe.getSource()==btnGraph)
        {
            GraphClass gc=new GraphClass();
            gc.ShowGraph();
        }//Graph Button

    }

/*******************************************************************************/

}

/*******************************************************************************/

