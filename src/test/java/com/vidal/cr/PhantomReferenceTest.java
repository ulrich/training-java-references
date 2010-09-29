package com.vidal.cr;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class PhantomReferenceTest extends TestCase {

   @Test
   public void testWithPhantomReferenceAndReferenceQueueV1() throws Exception {
      List<PhantomReference<BigObject>> list = new ArrayList<PhantomReference<BigObject>>();

      ReferenceQueue<BigObject> queue = new ReferenceQueue<BigObject>();

      for (int i = 0; i < 64; i++) {
         PhantomReference<BigObject> current = new PhantomReference<BigObject>(new BigObject(i), queue);
         System.out.println("Vient de créer l'objet id=" + current.get().getId());
         list.add(current);

         @SuppressWarnings("unchecked")
         Reference<BigObject> r = (Reference<BigObject>) queue.poll();
         if (r != null) {
            System.out.println("L'objet " + r.toString() + " a été garbage collecté!");
         }
      }
   }

   @Test
   public void testWithPhantomReferenceAndReferenceQueueV2() throws Exception {
      List<PhantomReference<BigObject>> list = new ArrayList<PhantomReference<BigObject>>();

      ReferenceQueue<BigObject> queue = new ReferenceQueue<BigObject>();

      for (int i = 0; i < 64; i++) {
         PhantomReference<BigObject> current = new PhantomReference<BigObject>(new BigObject(i), queue);
         System.out.println("Vient de créer l'objet id=" + current.get());
         list.add(current);

         @SuppressWarnings("unchecked")
         Reference<BigObject> r = (Reference<BigObject>) queue.poll();
         if (r != null) {
            System.out.println("L'objet " + r.toString() + " a été garbage collecté!");
         }
      }
   }
}
