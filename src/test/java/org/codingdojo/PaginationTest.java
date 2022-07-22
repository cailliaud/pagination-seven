package org.codingdojo;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class PaginationTest {

  @Test
  void shouldDisplayPageTwoOfFive() {
    assertThat(Page.render(2, 5)).isEqualTo("1 (2) 3 4 5");
  }

  @Test
  void shouldDisplayPageSixOfSeven_otherCase() {
    assertThat(Page.render(6, 7)).isEqualTo("1 2 3 4 5 (6) 7");
  }

  @Test
  void shouldDisplayFirstLastPreviousAndNext() {
    assertThat(Page.render(5, 9)).isEqualTo("1 ... 4 (5) 6 ... 9");
  }

  @Test
  void shouldDisplayTwoOfNine() {
    assertThat(Page.render(2, 9)).isEqualTo("1 (2) 3 4 5 ... 9");
  }

  @Test
  void shouldDisplayFourOfNine() {
    assertThat(Page.render(4, 9)).isEqualTo("1 2 3 (4) 5 ... 9");
  }

  @Test
  void shouldDisplayEightOfNine() {
    assertThat(Page.render(8, 9)).isEqualTo("1 ... 5 6 7 (8) 9");
  }

  @Test
  void shouldDisplayNineOfNine() {
    assertThat(Page.render(9, 9)).isEqualTo("1 ... 5 6 7 8 (9)");
  }

  // filter the numbers from 1 -> 99
  // 1 | 99 -> KEEP
  // active -> KEEP
  // active < current -> KEEP
  // else ...

  @Test
  void should() {
    int active = 50;
    int last = 99;
    boolean onRight = last - active < 4;
    boolean onLeft = active < 5;

    IntStream.range(1, last + 1)
        .filter(
            it -> {
              if (it == 1 || it == last || it == active) {
                return true;
              }

              if (onRight) {
                return (last - 5 < it);
              }

              if (onLeft) {
                return it < 6;
              }

              return Math.abs(active - it) <= 1;
            })
        .mapToObj(it -> active == it ? String.format("(%d)", it) : String.valueOf(it))
        .forEach(System.out::println);
  }
}
