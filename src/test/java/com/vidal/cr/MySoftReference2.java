package com.vidal.cr;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class MySoftReference2<T> extends SoftReference<T> {
   private final int id;

   public MySoftReference2(T o, int id) {
      super(o);
      this.id = id;
   }

   public MySoftReference2(T o, ReferenceQueue<T> q, int id) {
      super(o, q);
      this.id = id;
   }

   public int getId() {
      return id;
   }
}
