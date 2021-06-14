
package card_stacks;

import java.util.*;

/*************************Dice_Distrubution Class*******************************/

public class Dice_Distrubution
{
    public static int[] ProbabilityCard=null;
    public static int[][] RoomDice=null;

    public static ArrayList<Integer> CardDistList=new ArrayList<Integer>();
    public static ArrayList<Integer> ShuffleCardDistList=new ArrayList<Integer>();
    public static ArrayList<Integer> StoreRemove=new ArrayList<Integer>();
    public static ArrayList<Integer> DrawnCard=new ArrayList<Integer>();
    public static int DiceRemove,DiceFace,DiceQty,EndSum;
    public static int CheckRemove,CheckFace,CheckQty;
    public static int TotalCount=0;

/**************************Probability Method***********************************/

    public static void Probability(String numFace,String numDice)
    {
        DiceFace=Integer.parseInt(numFace);
        DiceQty=Integer.parseInt(numDice);

        EndSum = DiceQty * DiceFace;

        ProbabilityCard = new int[EndSum - DiceQty + 1];//for2d6 12-2=10+1=11

        Random rand = new Random();
        for(int iter = 1; iter <= 10000; iter++)
        {
            int throw1,throw2=0;
            for(int dq = 1; dq <= DiceQty; dq++)
            {
                throw1 = 1 + rand.nextInt(DiceFace);
                throw2 = throw2 + throw1;
            }//inner loop
            ProbabilityCard[throw2 - DiceQty]++;
        }//outer loop

        int TotalCardCount=1;

        for(int a = 0; a < DiceQty; a++)
        {
            TotalCardCount = TotalCardCount * DiceFace;
        }

        
        int[] CountCard = new int[EndSum - DiceQty + 1];
        //System.out.println("Length of Probability card="+ProbabilityCard.length);DELETE
        //System.out.println("\n"+DiceQty +"d"+DiceFace+"Dice of Sum      count      Time\n");DELETE

        TotalCount=0;

        for(int i = 0; i < ProbabilityCard.length; i++)
        {
            int min=ProbabilityCard[i];
            //System.out.println("min="+min);DELETE
            int result=min*TotalCardCount/10000;  //Calculate min probability
            CountCard[i]=result;

            //System.out.println( i + DiceQty + "---------------" + ProbabilityCard[i] + "----------" + CountCard[i]);DELETE
            TotalCount+=CountCard[i];
            //System.out.println("TotalCount"+TotalCount);DELETE
        }//end of loop
        //System.out.println("Total Count Card : "+TotalCount);DELETE
        //System.out.println("");DELETE

/*--------------------- To Save 2 array row and Column ------------------------*/
        int row= ProbabilityCard.length;
        RoomDice=new int[row][2];//to show Dice no and time
        //row=11 for 2d6
        for (int i = 0; i < row; i++)
        {
            int num=i+DiceQty;
            RoomDice[i][0]=num;//to fill data first column of roll dice
        }
        //To save array Column

        for (int i = 0; i < row; i++)
        {
            RoomDice[i][1]=CountCard[i];
        }

        /*for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                //System.out.println(RoomDice[i][j]);DELETE
            }

            //System.out.println("");DELETE
        }

/*-------------------------To Save Array List and Shuffle------------------------*/

       int rowCard=0,columnCard=0;

       for (int i = 0; i < ProbabilityCard.length; i++)
       {
           rowCard=RoomDice[i][0];
           columnCard=RoomDice[i][1];

           for (int j = 0; j < columnCard; j++)
           {
               CardDistList.add(rowCard);//@@
               //System.out.println(CardDistList);//To delete
           }
       }

        //System.out.println("\nBefore Shuffle Arraylist :"+CardDistList);DELETE

        ShuffleCardDistList=CardDistList;
        Collections.shuffle((ShuffleCardDistList));//shuff
        //System.out.println("\nAfter Shuffle ArrayList :"+ ShuffleCardDistList);DELETE

    }

/*******************************************************************************/

/***************************Generate Method*************************************/

    public static void Generate(int numRemove)
    {

        DiceRemove=numRemove;//Integer.parseInt(numRemove);

       int a;

        for (int r = 0; r < DiceRemove; r++)
        {
            a=ShuffleCardDistList.remove(r);//remove(0)
            StoreRemove.add(a);
        }

        //System.out.println("\n Remove Card :"+StoreRemove);DELETE
        //System.out.println("\n Remaining Remove Card :"+ShuffleCardDistList);DELETE
    }

/*******************************************************************************/

}

/*******************************************************************************/
