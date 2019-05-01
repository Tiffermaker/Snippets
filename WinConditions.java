/**
 * Snippet of code to calculate the winning conditions of a game called Ringgz (explanation below)
 * and stores the result in an array for later interpretation (the winner depends on the amount of players and who has which color)
 * Relevant rule explanation:
 * There is a board with a 5x5 grid of "tiles".
 * Every tile can contain either a "base" or up to 4 rings, each of a different size.
 * Every ring has 1 out of 4 colors.
 * A color gets a point when it contains the majority of rings on the tile.
 * In the case of a tie, no one gets a point.
 * In the case of a base, the color does not get a point (bases are used to block other players, but those rules are not relevant to this snippet).
 * There are 5 enums to represent the rings present: NONEE = empty/none, REDDD = red, BLUEE = blue, GREEN = green, and YELLO = yellow.
 * This function is only called after the game has concluded, in order to find the winner, so the board does not change.
 */

public void calculate() {
  int size = board.getSize();
  int rings = 4;
  int[] counter;
  int ringCounter;
  for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {
      counter = new int[4];	//0 = red, 1 = blue, 2 = green, 3 = yellow
      ringCounter = 0;
      for (int k = 0; k < rings; k++) { //reset counter before next tile counting attempt
        counter[k] = 0;
      }
      for (int k = 0; k < rings; k++) {	//count colors in current tile
        switch (board.getTile(i, j).getColor(k)) {
          case NONEE:
            break;
          case REDDD:
            counter[0]++;
            ringCounter++;
            break;
          case BLUEE:
            counter[1]++;
            ringCounter++;
            break;
          case GREEN:
            counter[2]++;
            ringCounter++;
            break;
          case YELLO:
            counter[3]++;
            ringCounter++;
            break;
          case RBASE:
          case BBASE:
          case GBASE:
          case YBASE:
          case SBASE:
            k = rings;
            break;
          default:
            break;
        }
      }
      if (!(ringCounter == 0)) {
        if (ringCounter == 1) {
          for (int k = 0; k < rings; k++) {
            if (counter[k] == 1) {
              scores[k]++;
              break;
            }
          }
        } else if (ringCounter == 2) {
          for (int k = 0; k < rings; k++) {
            if (counter[k] == 2) {
              scores[k]++;
              break;
            }
          }
        } else if (ringCounter == 3) {
          for (int k = 0; k < rings; k++) {
            if (counter[k] == 2 || counter[k] == 3) {
              scores[k]++;
              break;
            }
          }
        } else {
      //variable to keep track of the color that has occupied 2 spots (5 for tie or none)
          int store = 5;
          for (int k = 0; k < rings; k++) {
            if (counter[k] == 3 || counter[k] == 4) {
              scores[k]++;
              break;
            }
            if (counter[k] == 2) {
              if (store == 5) {
                store = k;
              } else {
                store = 5;
              }
            }
          }
          if (!(store == 5)) {
            scores[store]++;
          }
        }
      }
    }
  }
}
