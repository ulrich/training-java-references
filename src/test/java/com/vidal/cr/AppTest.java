package com.vidal.cr;

import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

   @Test
   public void testSoftReference() throws Exception {
      Set<byte[]> s = new HashSet<byte[]>();
      SoftReference<Object> sr = new SoftReference<Object>(new Object());
      int i = 0;

      while (true) {
         try {
            s.add(new byte[1000]);
         } catch (OutOfMemoryError e) {
            // ignore
         }
         if (sr.get() == null) {
            System.out.println("Soft reference is cleared. Success!");
            break;
         }
         i++;
         System.out.println("Soft reference is not yet cleared. Iteration " + i);
      }
   }
}
