package com.jaredengler;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValleyCounterShould {

  private final int MAX_STEPS = 1000;

  private ValleyCounter valleyCounter;

  @BeforeEach
  void setup() {
    valleyCounter = new ValleyCounter();
  }

  @Test
  void returnsAnInteger() {
    assertThat(valleyCounter.countValleys(0, ""), isA(int.class));
  }

  @Test
  void returnsInvalidWhenstepsLessThan2() {
    assertThat(valleyCounter.countValleys(1, "U"), is(-1));
  }

  @Test
  void returnsInvalidWhenInputsDontMatch() {
    IntStream.range(2, MAX_STEPS).parallel().forEach(i -> {
      assertThat(valleyCounter.countValleys(i, ""), is(-1));
    });

    IntStream.range(2, MAX_STEPS / 2).parallel().forEach(i -> {
      assertThat(valleyCounter.countValleys(0, "ud".toUpperCase().repeat(i)), is(-1));
    });
  }

  @Test
  void returnInvalidWhenStepsDontSolelyContainUandD() {
    assertThat(valleyCounter.countValleys(2, "ud".toUpperCase()), is(not(-1)));
    assertThat(valleyCounter.countValleys(2, "fd".toUpperCase()), is(-1));
  }

  @Test
  void returnCorrectNumberOfValleys() {
    assertThat(valleyCounter.countValleys(8, "UDDDUDUU"), is(1));
  }
}
