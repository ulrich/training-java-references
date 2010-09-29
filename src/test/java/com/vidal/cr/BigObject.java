package com.vidal.cr;

import java.util.ArrayList;
import java.util.List;

public class BigObject {
   private final List<byte[]> list = new ArrayList<byte[]>(1000);
   private final int id;

   public BigObject(int id) {
      this.id = id;
      for (int i = 0; i < 1000; i++) {
         list.add(new byte[1000]);
      }
   }

   public int getId() {
      return id;
   }
}
