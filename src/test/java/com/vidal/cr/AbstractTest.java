package com.vidal.cr;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

public class AbstractTest extends TestCase {

   public AbstractTest() {
      FileOutputStream fos;
      try {
         fos = new FileOutputStream("log.txt");
         PrintStream ps = new PrintStream(fos);
         System.setOut(ps);
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }
}
