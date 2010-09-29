package com.vidal.cr;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StrongReferenceTest extends AbstractTest {

   @Test
   public void testWithStrongReference() throws Exception {
      List<BigObject> list = new ArrayList<BigObject>();

      for (int i = 0; i < 64; i++) {
         list.add(new BigObject(i));
      }
   }
}
