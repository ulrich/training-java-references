package com.vidal.cr;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class SoftReferenceTest extends TestCase {

   @Test
   public void testWithSoftReference() throws Exception {
      List<SoftReference<BigObject>> list = new ArrayList<SoftReference<BigObject>>();

      for (int i = 0; i < 64; i++) {
         list.add(new SoftReference<BigObject>(new BigObject(i)));
      }
   }

   @Test
   public void testWithSoftReferenceAndReferenceQueue() throws Exception {
      List<SoftReference<BigObject>> list = new ArrayList<SoftReference<BigObject>>();

      ReferenceQueue<BigObject> queue = new ReferenceQueue<BigObject>();

      for (int i = 0; i < 64; i++) {
         SoftReference<BigObject> current = new SoftReference<BigObject>(new BigObject(i), queue);
         System.out.println("Vient de créer l'objet id=" + current.get().getId());
         list.add(current);

         @SuppressWarnings("unchecked")
         Reference<BigObject> r = (Reference<BigObject>) queue.poll();
         if (r != null) {
            System.out.println("L'objet " + r.toString() + " a été garbage collecté!");
         }
      }
   }
}
