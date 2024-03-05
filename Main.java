import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);

        int numOfGames = 0;// מספר המשחקים הרצוי

        int playerOne = 0;// בודק מספר ניצחונות של שחקן ראשון
        int playerTwo = 0;// בודק מספר ניצחונות של שחקן שני
        System.out.println("Enter the number of games you want to play: ");
        numOfGames = in.nextInt();

        for(int i = 1;i<=numOfGames; i++)
        {
            System.out.println("Its game number: " + i);

            if(ManageGame() == 1)
            {
                playerTwo++;
            }
            else
            {
                playerOne++;
            }

        }

        System.out.println("The final score is ");
        System.out.println("Player1 won " + playerOne + " games" );
        System.out.println("Player2 won " + playerTwo + " games" );

    }

    public static int RemoveMatches(int matchesLeft, int maxMatches)
    {
        Scanner in = new Scanner(System.in);
        int matchesToRemove = 0;

        System.out.println("Enter how many matches you want to remove: ");

        matchesToRemove = in.nextInt();

        if(matchesToRemove <= 0 || matchesToRemove > maxMatches || matchesLeft > matchesLeft)
        {
            System.out.println("Worng input try again");
            return -1;
        }

        return matchesLeft - matchesToRemove;

    }

    public static void ShowTable(int matchesLeft, int turn, int maxToRemove)
    {
        System.out.println("The max number of macthes on the table are " +  matchesLeft);
        System.out.println("The max number of macthes you can remove are " +  maxToRemove);

        for(int i=0;i<matchesLeft;i++)
        {
            System.out.print("-");
        }
        for(int i=0;i<matchesLeft;i++)
        {
            System.out.print("|");
        }
        for(int i=0;i<matchesLeft;i++)
        {
            System.out.print("-");
        }
        if(turn==1)
        {
            System.out.println("Player1 its your turn");
        }
        else
        {
            System.out.println("Player2 its your turn");
        }

    }

    public static int GetNextPlayer(int turn)
    {
        if(turn==1)
        {
            return 2;
        }
        else
        {
            return 1;
        }
    }

    public static int ManageGame()
    {
        Scanner in = new Scanner(System.in);
        int matchesLeft = 0;//  num of matches left
        int MaxnumOfMatches = 0;// max num of matches is the game
        int maxMatchesToRemove = 0;// max num of matches that can be removed every turn
        int begin = 0;// who starts

        do
        {
            System.out.println("Enter who begin, press 1 or 2");
            begin = in.nextInt();
        }
        while(begin != 1 && begin != 2);
        {
            System.out.println("The player that begins is player" + begin);
        }

        do
        {
            System.out.println("Enter the max num of matches in the game ");
            MaxnumOfMatches = in.nextInt();
        }
        while(MaxnumOfMatches<=0);
        {
            System.out.println("The max number of matches is " + MaxnumOfMatches);
        }
        do
        {
            System.out.println("Enter the max mactches that can be removed every turn");
            maxMatchesToRemove = in.nextInt();
        }
        while( maxMatchesToRemove<=0 &&  maxMatchesToRemove>MaxnumOfMatches);
        {
            System.out.println("The max of matches that can be removed each turn are " + maxMatchesToRemove);
        }

        while(MaxnumOfMatches > 0)
        {
            ShowTable( MaxnumOfMatches, begin, maxMatchesToRemove );

            do
            {
                matchesLeft = RemoveMatches(MaxnumOfMatches, maxMatchesToRemove );
            }
            while( matchesLeft == -1);
            {

            }
            MaxnumOfMatches = matchesLeft;
            if(MaxnumOfMatches !=0)
            {
                begin = GetNextPlayer(begin);
            }
        }
        if(begin==1)
        {
            System.out.println("Player 1 won the game");
            return 0;
        }
        else
        {
            System.out.println("Player 2 won the game");
            return 1;
        }

    }

}