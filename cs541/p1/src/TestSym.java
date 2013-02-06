class TestSym extends Symb
{
   private int value;

   TestSym(String n, int i) {
       super(n);
       value = i;
   }

   public int getValue() {
       return value;
   }

   public String toString() {
       return "(" + getName() + ":" + String.valueOf(getValue()) + ")";
   }
} // class TestSym
