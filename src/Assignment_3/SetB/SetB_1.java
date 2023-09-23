package Assignment_3.SetB;

import java.util.LinkedList;
import java.util.ListIterator;
public class SetB_1 {
    public static void main(String[] args) {
        // Step 1: Construct a linked list containing colors
        LinkedList<String> colorList = new LinkedList<>();
        colorList.add("red");
        colorList.add("blue");
        colorList.add("yellow");
        colorList.add("orange");

        // Step 2: Display the contents of the list using an Iterator
        System.out.println("Colors in the list:");
        for (String color : colorList) {
            System.out.println(color);
        }



        // Step 3: Display the contents of the list in reverse using a ListIterator
        System.out.println("\nColors in reverse order:");
        ListIterator<String> listIterator = colorList.listIterator(colorList.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // Step 4: Create another list containing pink and green
        LinkedList<String> additionalColors = new LinkedList<>();
        additionalColors.add("pink");
        additionalColors.add("green");

        // Insert the elements of the additionalColors list between blue and yellow
        int index = colorList.indexOf("yellow");
        colorList.addAll(index, additionalColors);

        // Display the updated list
        System.out.println("\nUpdated list with pink and green inserted:");
        for (String color : colorList) {
            System.out.println(color);
        }
    }
}
