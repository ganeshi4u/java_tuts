import java.util.Random;

class MainMatrix {
  public int range = 9;
  public static int mainMat[][] = new int[10][10];
  private Random randomobj = new Random();

  public int randomGen() {
    return randomobj.nextInt(range) + 1;
  }

  public boolean rowCheck(int rownum, int rnum) {
    int count = 0;
    while (count < mainMat.length && mainMat[rownum][count] != rnum) {
      count++;
    }
    return count == mainMat.length;
  }

  public boolean colCheck(int colnum, int rnum) {
    int count = 0;
    while (count < mainMat.length && mainMat[count][colnum] != rnum) {
      count++;
    }
    return count == mainMat.length;
  }

  public boolean boxCheck(int row, int maxRow, int col, int maxCol, int rnum) {
    int count = 0;
    System.out.println("rows and colnum in box = " + row + col + maxCol);
    for (int i = row; i < maxRow; i++) {
      for (int j = col; j < maxCol && mainMat[i][j] != rnum; j++) {
        count++;
        System.out.println("i and j" + i + j + "found=" + mainMat[i][j]);
        System.out.println("dun");
      }
    }
    System.out.println("Total count =" + count);
    return count == 9;
  }
}

class BoxGen {
  MainMatrix man = new MainMatrix();
  int rnum;
  boolean isRowOk;
  boolean isColOk;
  boolean isBoxOk;

  public void box(int row, int maxRow, int col, int maxCol) {
    for (int i = row; i < maxRow; i++) {
      for (int j = col; j < maxCol; j++) {
        do {
          rnum = man.randomGen();
          System.out.println("rows and colnum in box = " + row + col + maxCol);
          isBoxOk = man.boxCheck(row, maxRow, col, maxCol, rnum);
          if (isBoxOk) {
            isRowOk = man.rowCheck(i, rnum);
            isColOk = man.colCheck(j, rnum);
          }

          // debug msgs
          System.out.println("Random number =" + rnum + " Now at pos=" + i + ", " + j);
          System.out.println("Box state =" + isBoxOk);
          System.out.println("Row state =" + isRowOk);
          System.out.println("Col state =" + isColOk);

          if (isBoxOk && isRowOk && isColOk) {
            man.mainMat[i][j] = rnum;
            System.out.println("Inserted ele =" + man.mainMat[i][j]);
            System.out.println();
          }
        } while (!(isBoxOk && isRowOk && isColOk));
      }
    }
  }
}

class PrintBox {
  MainMatrix man = new MainMatrix();

  public void printMat() {
    System.out.println("START OF PRINTING MAIN MAT");
    for (int i = 0; i < man.mainMat.length; i++) {
      for (int j = 0; j < man.mainMat[i].length; j++) {
        System.out.println(man.mainMat[i][j] + " ");
      }
      System.out.println();
    }
  }
}

public class Sudoku {
  public static void main(String[] args) {
    System.out.println("SUDOKU");
    BoxGen bg = new BoxGen();
    PrintBox pb = new PrintBox();

    // flow
    bg.box(0, 3, 0, 3);
    bg.box(0, 3, 3, 6);
    bg.box(0, 3, 6, 9);
    bg.box(3, 6, 0, 3);
    bg.box(3, 6, 3, 6);
    bg.box(3, 6, 6, 9);
    bg.box(6, 9, 0, 3);
    bg.box(6, 9, 3, 6);
    bg.box(6, 9, 6, 9);
    pb.printMat();
  }
}
