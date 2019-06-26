package io.iotex.antennaj.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UnitEnumTest {

  @Test
  public void testUnitEum() {
    for (Unit unit : Unit.values()) {
      Unit unit1 = Unit.getEnum(unit.toString());
      assertEquals(unit, unit1);
    }
  }
}
