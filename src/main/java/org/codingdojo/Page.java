package org.codingdojo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Page {

  public static final int MAX_ELEMENTS_DISPLAYED = 7;
  public static final int DISTANCE_FROM_START = 5;
  public static final int DISTANCE_TO_END = 4;

  private Page() {}

  public static String render(int active, int last) {
    if (last > MAX_ELEMENTS_DISPLAYED) {
      if (active < DISTANCE_FROM_START) {
        return foo(1, DISTANCE_FROM_START, active) + " ... " + last;
      }

      if (DISTANCE_TO_END > last - active) {
        return "1 ... " + foo(last - DISTANCE_TO_END, last, active);
      }

      return String.format("1 ... %d (%d) %d ... %d", active - 1, active, active + 1, last);

    } else {
      return foo(1, last, active);
    }
  }

  private static String foo(int startInclusive, int distanceFromStart, int active) {
    return IntStream.range(startInclusive, distanceFromStart + 1)
        .mapToObj(current -> toRenderedPosition(active, current))
        .collect(Collectors.joining(" "));
  }

  private static String toRenderedPosition(int active, int current) {
    if (current == active) {
      return String.format("(%d)", current);
    }
    return String.valueOf(current);
  }
}
