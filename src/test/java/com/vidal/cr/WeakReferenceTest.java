package com.vidal.cr;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WeakReferenceTest extends AbstractTest {
   List<BigObject> list2 = new ArrayList<BigObject>();

   @Test
   public void testWithWeakReferenceAndReferenceQueue() throws Exception {
      List<WeakReference<BigObject>> list = new ArrayList<WeakReference<BigObject>>();

      ReferenceQueue<BigObject> queue = new ReferenceQueue<BigObject>();

      for (int i = 0; i < 64; i++) {
         BigObject bigObject = new BigObject(i);
         list2.add(bigObject);
         WeakReference<BigObject> current = new WeakReference<BigObject>(bigObject, queue);
         System.out.println("Vient de cr�er l'objet id=" + current.get().getId());
         list.add(current);

         @SuppressWarnings("unchecked")
         Reference<BigObject> r = (Reference<BigObject>) queue.poll();
         if (r != null) {
            System.out.println("L'objet " + r.toString() + " a �t� garbage collect�!");
         }
      }
   }
}
