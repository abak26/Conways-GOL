public class GameOfLife
{
  private String[][] gameArray;

  public GameOfLife()
  {
    gameArray=new String[10][10];
    gameArray[1][3]="🟩";
    gameArray[2][4]="🟩";
    gameArray[3][2]="🟩";
    gameArray[3][3]="🟩";
    gameArray[3][4]="🟩";
    for(int i=0;i<gameArray.length;i++)
    {
      for(int j=0;j<gameArray[0].length;j++)
      {
        if(gameArray[i][j]==null)
        {
          gameArray[i][j]="⬛️";
        }
      }
    }
  }

  public boolean isAlive(String cell)
  {
    if(cell.equals("🟩"))
    {
      return true;
    }
    return false;
  }

  public boolean isLonely(int x, int y)
  {
    if(findNeighbors(x,y)<2)
    {
      return true;
    }
    return false;
  }

  public boolean isOvercrowded(int x, int y)
  {
    if(findNeighbors(x,y)>3)
    {
      return true;
    }
    return false;
  }

  public boolean isReproducable(int x, int y)
  {
    if(findNeighbors(x,y)==3)
    {
      return true;
    }
    return false;
  }

  public int findNeighbors(int x, int y)
  {
    int count=0;
    int maxRow=gameArray.length-1;
    int maxCol=gameArray[0].length-1;

    if(x-1>=0 && isAlive(gameArray[x-1][y]))
    {
      count++;
    }
    if(y-1>=0 && isAlive(gameArray[x][y-1]))
    {
      count++;
    }
    if(x+1<=maxRow && isAlive(gameArray[x+1][y]))
    {
      count++;
    }
    if(y+1<=maxCol && isAlive(gameArray[x][y+1]))
    {
      count++;
    }
    if(x-1>=0 && y-1>=0 && isAlive(gameArray[x-1][y-1]))
    {
      count++;
    }
    if(x-1>=0 && y+1<=maxCol && isAlive(gameArray[x-1][y+1]))
    {
      count++;
    }
    if(x+1<=maxRow && y-1>=0 && isAlive(gameArray[x+1][y-1]))
    {
      count++;
    }
    if(x+1<=maxRow && y+1<=maxCol && isAlive(gameArray[x+1][y+1]))
    {
      count++;
    }
    return count; 
  }

  public String loneliness(int x, int y)
  {
    String newCell=gameArray[x][y];
    if(isAlive(gameArray[x][y]) && findNeighbors(x,y)<2)
    {
      newCell="⬛️";
    }
    return newCell;
  }

  public String overcrowding(int x, int y)
  {
    String newCell=gameArray[x][y];
    if(isAlive(gameArray[x][y]) && findNeighbors(x,y)>3)
    {
      newCell="⬛️";
    }
    return newCell;
  }

  public String reproduction(int x, int y)
  {
    String newCell=gameArray[x][y];
    if(isAlive(gameArray[x][y])==false && findNeighbors(x,y)==3)
    {
      newCell="🟩";
    }
    return newCell;
  }

  public String toString()
  {
    String finalArray="";
    String tempArray[][]=new String[10][10];
    for(int a=0;a<gameArray.length;a++)
    {
      for(int b=0;b<gameArray[0].length;b++)
      {
        finalArray+=gameArray[a][b];
      }
      finalArray+="\n";
    }
    finalArray+="\n";
    for(int i=0;i<5;i++)
    {
      for(int j=0;j<gameArray.length;j++)
      {
        for(int k=0;k<gameArray[0].length;k++)
        {
          String newCell="";
          if(isLonely(j,k))
          {
            newCell+=loneliness(j,k);
          }
          else if(isOvercrowded(j,k))
          {
            newCell+=overcrowding(j,k);
          }
          else if(isReproducable(j,k))
          {
            newCell+=reproduction(j,k);
          }
          else
          {
            newCell+=gameArray[j][k];
          }
          tempArray[j][k]=newCell;
          newCell="";                
        }
      }
      gameArray=tempArray;
      tempArray=new String[10][10];
      for(int a=0;a<gameArray.length;a++)
      {
        for(int b=0;b<gameArray[0].length;b++)
        {
          finalArray+=gameArray[a][b];
        }
        finalArray+="\n";
      }
      finalArray+="\n";
    }
    return finalArray;
  }
}
