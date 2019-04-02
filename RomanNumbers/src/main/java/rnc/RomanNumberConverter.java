package rnc;

import java.io.*;

public class RomanNumberConverter {

  public char[] allowedRoman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

  public Conversion[] createConversionMatrix() {
    Conversion[] matrix = new Conversion[7];
    matrix[0] = new Conversion("I", 1);
    matrix[1] = new Conversion("V", 5);
    matrix[2] = new Conversion("X", 10);
    matrix[3] = new Conversion("L", 50);
    matrix[4] = new Conversion("C", 100);
    matrix[5] = new Conversion("D", 500);
    matrix[6] = new Conversion("M", 1000);

    return matrix;
  }


  public String convertRoman(int number) {
    if (number == 0) {
      throw new IllegalArgumentException("Number cannot be null");
    }

    String res = "";
    Conversion[] matrix = createConversionMatrix();

    // Cas simple d'un nombre remarquable
    for (Conversion conv : matrix) {
      if (conv.number == number) {
        res = conv.romanNumber;
      }
    }

    return res;
  }


  public int convertInt(String romanNumber) {
    // Gestion des erreurs
    if (romanNumber == null) {
      throw new IllegalArgumentException("Roman number cannot be null");
    }

    int res = 0;
    Conversion[] matrix = createConversionMatrix();

    // Cas simple d'un seul caractère
    if(romanNumber.length() == 1) {
      for (Conversion conv : matrix) {
        if (conv.romanNumber == romanNumber) {
          res = conv.number;
        }
      }

      // Vérification validité
      boolean valid = false;
      for (char c : allowedRoman) {
        if (romanNumber.charAt(0) == c) { 
          valid = true;
        }
      }
      if (!valid) {
        throw new IllegalArgumentException("Input is not a valid roman number");
      }
    }



    return res;
  }

}
