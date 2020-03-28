import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayDeque;

// ArrayDeque is "likely to be faster than Stack when used as a stack" 
public class BalancedBrackets {
  public static void main(String[] args) {
    // create HashMap to match opening brackets with closing brackets
    HashMap<Character, Character> map = new HashMap();
    map.put('(', ')');
    map.put('[', ']');
    map.put('{', '}');

    // test each expression for validity
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    while (t-- > 0) {
      String expression = scan.next();
      System.out.println(isBalanced(expression, map) ? "YES" : "NO");
    }
    scan.close();
  }

  private static boolean isBalanced(String expression, HashMap<Character, Character> map) {
    if ((expression.length() % 2) != 0) {
      return false; // odd length Strings are not balanced
    }
    ArrayDeque<Character> deque = new ArrayDeque(); // use deque as a stack
    for (int i = 0; i < expression.length(); i++) {
      Character ch = expression.charAt(i);
      if (map.containsKey(ch)) {
        deque.push(ch);
      } else if (deque.isEmpty() || ch != map.get(deque.pop())) {
        return false;
      }
    }
    return deque.isEmpty();
  }
}