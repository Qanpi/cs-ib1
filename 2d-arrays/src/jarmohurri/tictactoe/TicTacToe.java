// Copyright (C) 2020 Jarmo Hurri

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.

package jarmohurri.tictactoe;
public class TicTacToe
{
  public TicTacToe ()
  {
    marks = new Mark [N][N];
  }

  boolean gameOver ()
  {
    int[] rowSums = new int[N];
    int[] colSums = new int[N];
    int diagonalDown = 0, diagonalUp = 0;

    for (int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
        //uses the order of the values in the enum
        int value = marks[i][j].ordinal();

        rowSums[i] += value;
        colSums[j] += value;

        if (i == j) {
          diagonalDown += value;
        } else if (j == N-1 - i) {
          diagonalUp += value;
        }
      }
    }

    if (diagonalUp == N || diagonalUp == 0) return true;
    if (diagonalDown == N || diagonalDown == 0) return true;

    for (int i=0; i<N; i++) {
      if (rowSums[i] == N || rowSums[i] == 0) return true;
      if (colSums[i] == N || colSums[i] == 0) return true;
    }

    return false;
  }
  
  private final int N = 3;
  public Mark[][] marks;

}
