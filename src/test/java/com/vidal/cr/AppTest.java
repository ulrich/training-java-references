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
   public void withStrongReference() throws Exception {
      assertTrue(true);
   }

   //@Test
   public void _testSoftReference() throws Exception {
      Set<BigObject> set = new HashSet<BigObject>();
      SoftReference<Object> sr = new SoftReference<Object>(new Object());
      int i = 0;

      while (true) {
         try {
            //set.add(new BigObject());
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

   //@Test
   public void _testSoftReference2() throws Exception {
      Set<BigObject> set = new HashSet<BigObject>();

      for (int j = 0; j < 30000; j++) {
         //set.add(new BigObject());
      }
   }
}
