import java.io.*;
import java.util.Random;

class MainMatrix {
  public int range=9;
  public static int mainMat[][] = new int [10][10];

  public int RandomGen() {
    Random randomobj = new Random();
    int randomNum = randomobj.nextInt(range) + 1;
    return randomNum;
  }

  public boolean RowCheck(int rownum, int rnum) {
    int count=0;
    while (count < mainMat.length)
    {
      if (mainMat[rownum][count] != rnum )
        count++;
      else
        break;
    }
    if (count == mainMat.length)
      return true;
    else
      return false;
  }

  public boolean ColCheck(int colnum, int rnum) {
    int count=0;
    while (count < mainMat.length) {
      if (mainMat[count][colnum] != rnum)
        count++;
      else
        break;
    }
    if (count == mainMat.length)
      return true;
    else
      return false;
  }

  public boolean BoxCheck(int row, int maxRow, int col, int maxCol, int rnum) {
    int count=0;
    System.out.println("rows and colnum in box = " + row + col + maxCol);
    for (int i=row; i<maxRow; i++) {
      for (int j=col; j<maxCol; j++) {
        if (mainMat[i][j] != rnum)
        {
          count++;
          System.out.println("i and j" + i + j + "found=" + mainMat[i][j]);
          System.out.println("dun");
        } else {
          break;
        }
      }
    }
    System.out.println("Total count =" +count);
    if (count == 9)
      return true;
    else
      return false;
  }
}

class BoxGen {
  MainMatrix man = new MainMatrix();
  int rnum;
  boolean redo;
  boolean isRowOk;
  boolean isColOk;
  boolean isBoxOk;

  public void Box(int row, int maxRow, int col, int maxCol) {
      for (int i=row; i<maxRow; i++) {
        for (int j=col; j<maxCol; j++) {
          do {
            rnum = man.RandomGen();
            System.out.println("rows and colnum in box = " + row + col + maxCol);
            isBoxOk = man.BoxCheck(row,maxRow,col,maxCol,rnum);
            if (isBoxOk) {
              isRowOk = man.RowCheck(i,rnum);
              isColOk = man.ColCheck(j,rnum);
            }

            //debug msgs
            System.out.println("Random number =" + rnum + " Now at pos=" + i + ", " + j);
            System.out.println("Box state =" + isBoxOk);
            System.out.println("Row state =" + isRowOk);
            System.out.println("Col state =" + isColOk);

            if (isBoxOk && isRowOk && isColOk) {
              man.mainMat[i][j] = rnum;
              redo=false;
              System.out.println("Inserted ele =" + man.mainMat[i][j]);
              System.out.println();
            } else {
              redo=true;
            }
          } while (redo);
        }
      }
  }
}

class PrintBox {
  MainMatrix man = new MainMatrix();
  public void PrintMat() {
    System.out.println("START OF PRINTING MAIN MAT");
    for (int i=0; i<man.mainMat.length; i++) {
      for (int j=0; j<man.mainMat[i].length; j++) {
        System.out.println(man.mainMat[i][j]+ " ");
      }
      System.out.println();
    }
  }
}

public class sudoku {
  public static void main(String[] args) {
    System.out.println("SUDOKU");
    BoxGen bg = new BoxGen();
    PrintBox pb = new PrintBox();

    //flow
    bg.Box(0,3,0,3);
    bg.Box(0,3,3,6);
    bg.Box(0,3,6,9);
    bg.Box(3,6,0,3);
    bg.Box(3,6,3,6);
    bg.Box(3,6,6,9);
    bg.Box(6,9,0,3);
    bg.Box(6,9,3,6);
    bg.Box(6,9,6,9);
    pb.PrintMat();
  }
}
