package DSA.Dynamic;

public class PolynomialRecursion {
    public static void main(String[] args) {
        PolynomialRecursion re = new PolynomialRecursion();
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

- Depth is n
- Each level the tree branches to 2.
- Width at level 1 is 2^0 = 1
- Width at level 2 is 2^1 = 2
- Width at level 3 is 2^2 = 4
- Width at level 1 is 2^3 = 8
- Width at level 1 is 2^4 = 16
so 2^n
Total = 2^n + n

space:
depth = n
recursion does not create new arrays. O(1)
total = O(n)

Recursion stack:
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
