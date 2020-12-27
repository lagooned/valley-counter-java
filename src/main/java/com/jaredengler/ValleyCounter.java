package com.jaredengler;

public class ValleyCounter {

  int countValleys(int steps, String path) {

    if (steps < 2 || steps != path.length()) {
      return -1;
    }

    int valleys = 0;
    int level = 0;

    for (int i = 0; i < path.length(); i++) {
      char token = path.charAt(i);
      if (token == 'U') {
        if (level == -1)
          valleys += 1;
        level += 1;
      }
      else if (token == 'D')
        level -= 1;
      else
        return -1;

    }

    return valleys;

  }

}
