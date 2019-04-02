package rnc;

import org.junit.Test;
import org.junit.Before;

import static org.assertj.core.api.Assertions.*;

public class RomanNumberConverterTest {

  RomanNumberConverter RNC;

  @Before
  public void setup() {
    RNC = new RomanNumberConverter();
  }

  /** ===========================================================
                    Tests simples pour 1 caractère
  =============================================================*/
  @Test
  public void simpleCheckItoR() {
    assertThat(RNC.convertRoman(10))
      .isEqualTo("X");
    assertThat(RNC.convertRoman(42))
      .isEqualTo("");
  }

  @Test
  public void simpleCheckRtoI() {
    assertThat(RNC.convertInt("X"))
      .isEqualTo(10);
    assertThat(RNC.convertInt("LC"))
      .isEqualTo(0);
  }

/** ===========================================================
                    Tests d'intégrité
=============================================================*/
  @Test
  public void checkNullItoR() {
    assertThatThrownBy(() -> RNC.convertRoman(0))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("cannot be null");
  }

  @Test
  public void checkNullRtoI() {
    assertThatThrownBy(() -> RNC.convertInt(null))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("cannot be null");
  }

  @Test
  public void checkValidR() {
    assertThatThrownBy(() -> RNC.convertInt("A"))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("not a valid roman number");
  }

}
