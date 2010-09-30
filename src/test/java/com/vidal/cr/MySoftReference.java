package com.vidal.cr;

import java.lang.ref.Reference;

public class MySoftReference<T> {
   private final Reference<T> reference;
   private final int id;

   public MySoftReference(Reference<T> reference, int id) {
      this.reference = reference;
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public Reference<T> getReference() {
      return reference;
   }
}
