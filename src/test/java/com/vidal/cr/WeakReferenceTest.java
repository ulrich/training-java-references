package com.vidal.cr;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WeakReferenceTest extends AbstractTest {

   @Test
   public void testWithWeakReferenceAndReferenceQueue() throws Exception {
      List<WeakReference<BigObject>> list = new ArrayList<WeakReference<BigObject>>();

      ReferenceQueue<BigObject> queue = new ReferenceQueue<BigObject>();

      for (int i = 0; i < 64; i++) {
         WeakReference<BigObject> current = new WeakReference<BigObject>(new BigObject(i), queue);
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
