package DSA.Dynamic;

public class RecursionExample {
    public static void main(String[] args) {
        RecursionExample re = new RecursionExample();
        re.dib(5);

    }

    private void dib(int i) {
        if (i <= 1) {
            return;
        }
        dib(i - 1);
        dib(i - 1);
    }


/*
               (5)
              /   \
            (4)   (4)
           /   \  /   \
         (3)   (3)   (3)   (3)
        /  \   /  \  /  \   /  \
      (2)  (2)(2) (2)(2) (2)(2) (2)
      / \  / \ / \ / \ / \ / \ / \ / \
(1)(1)(1)(1)(1)(1)(1)(1)(1)(1)(1)(1)(1)(1)(1)(1)


Push: dib(4)     <-- First call
Push: dib(3)     <-- First recursive call
Push: dib(2)     <-- First recursive call
___________block repeated_________
Push: dib(1) ❌  <-- Base case, returns
Pop: dib(1) ✅   <-- Function completes
Push: dib(1) ❌  <-- Second recursive call
Pop: dib(1) ✅   <-- Function completes
Pop: dib(2) ✅   <-- Both dib(1) calls finished
___________________________________________

Push: dib(2)     <-- Second recursive call of dib(3)
____________________________________________
Push: dib(1) ❌  <-- Base case, returns
Pop: dib(1) ✅   <-- Function completes
Push: dib(1) ❌  <-- Second recursive call
Pop: dib(1) ✅   <-- Function completes
Pop: dib(2) ✅   <-- Both dib(1) calls finished
Pop: dib(3) ✅   <-- Both dib(2) calls finished. Added new block
______________________________________________________
Push: dib(3)     <-- Second recursive call of dib(4)
______________________________________________________
Push: dib(2)     <-- First recursive call
Push: dib(1) ❌  <-- Base case, returns
Pop: dib(1) ✅   <-- Function completes
Push: dib(1) ❌  <-- Second recursive call
Pop: dib(1) ✅   <-- Function completes
Pop: dib(2) ✅   <-- Both dib(1) calls finished

Push: dib(2)     <-- Second recursive call of dib(3)
Push: dib(1) ❌

 */

}
