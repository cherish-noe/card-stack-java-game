
package card_stacks;

import org.jfree.chart.ChartUtilities;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraphClass
{
    
    public void ShowGraph()
    {
        //System.out.println("Room Dice "+Dice_Distrubution.RoomDice.length);DELETE
        int RemainingCard[][]=new int[Dice_Distrubution.RoomDice.length][2];
        int FinalDrawnCard[][]=new int[Dice_Distrubution.RoomDice.length][2];

        for(int i = 0; i < RemainingCard.length; i++)
        {
            RemainingCard[i][0]=Dice_Distrubution.RoomDice[i][0];
            FinalDrawnCard[i][0]=Dice_Distrubution.RoomDice[i][0];
        }//To save array column
          for(int i=0;i<RemainingCard.length; i++)
        {
            RemainingCard[i][1]=Dice_Distrubution.RoomDice[i][1];

        }
   //-------------Remove Card------------------
        for(int k=0; k<RemainingCard.length; k++)
        {
            for(int m=0;m<Dice_Distrubution.StoreRemove.size(); m++)
            {
              if(RemainingCard[k][0]==Dice_Distrubution.StoreRemove.get(m))
              {
                RemainingCard[k][1]=RemainingCard[k][1]-1;
              }
            }
        }

        for(int c=0;c<FinalDrawnCard.length;c++)
        {
            for(int d=0;d<Dice_Distrubution.DrawnCard.size();d++)
            {
                if(FinalDrawnCard[c][0]==Dice_Distrubution.DrawnCard.get(d))
                {
                    FinalDrawnCard[c][1]=FinalDrawnCard[c][1]+1;
                }
            }
        }
    //Appear Tone
        final String L_Card="Left Card";
        final String D_Card="Drawn_Card";

        final DefaultCategoryDataset dataset=new DefaultCategoryDataset();

        for (int i=0;i<Dice_Distrubution.RoomDice.length;i++)
        {
            dataset.addValue(FinalDrawnCard[i][1],D_Card, String.valueOf(Dice_Distrubution.RoomDice[i][0]));
            dataset.addValue(RemainingCard[i][1], L_Card, String.valueOf(Dice_Distrubution.RoomDice[i][0]));
        }

        JFreeChart barChart = ChartFactory.createBarChart("Card Stacks","Sum","Sum",dataset,PlotOrientation.VERTICAL,true,true,false);

        int width=670;
        int height=450;

        JFrame f=new JFrame();
        f.setBounds(333,100,700,550);//f.setSize(1000,700);
        File BarChart = new File("BarChart.jpeg");

        try
        {
            ChartUtilities.saveChartAsJPEG(BarChart,barChart,width,height);
            ImageIcon icon=new ImageIcon("BarChart.jpeg");
            JLabel label=new JLabel(icon);

            f.add(label);
            f.setVisible(true);
        }
        catch(IOException ex)
        {
            Logger.getLogger(Dice_Program.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

/*******************************************************************************/

}
