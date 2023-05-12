import org.w3c.dom.Node;

import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<>();

        // Insert some key-value pairs into the BST.
        bst.put("Masha", 1);
        bst.put("Igor", 2);
        bst.put("Ivan", 3);



        // get keys of bst
        for (String key : bst) {
            System.out.println("Key is " + key);
        }
        int value = bst.get("Masha");
        System.out.println("Value for 'Masha': " + value);

        bst.delete("Ivan");

        int size = bst.size();
        System.out.println("Size of BST: " + size);

//        System.out.println(value);
    }

}