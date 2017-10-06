import java.util.ArrayList;
import java.util.Arrays;

public class ArrayPrinter {
    private ArrayList<Integer> array;
    private int currentFrame = 1;

    private String lastQuery = "";

    public ArrayPrinter(Integer[] inputArray) {
        printTitle("JavaBeamerGenerator");
        array = new ArrayList<Integer>(Arrays.asList(inputArray));
        printArray(null, "Instantiate array");
    }

    public ArrayPrinter(Integer[] inputArray, String title) {
        printTitle(title);
        array = new ArrayList<Integer>(Arrays.asList(inputArray));
        printArray(null, "Instantiate array");
    }

    public int get(int index) {
        if (!lastQuery.equals("G"+index)) { // prevent duplicate things
            printArray(index, "Read index " + index);
        }
        lastQuery = "G"+index;
        return array.get(index);
    }

    public int length() {
        return array.size();
    }

    public void set (int index, int value) {
        lastQuery = "";
        array.set(index, value);
        printArray(index, "Set index "+index+" to "+value);
    }

    private void printArray(Integer highlightedElement, String comment) {
        StringBuilder arrayRep = new StringBuilder();
        for (int i = 0; i < array.size(); i++) {
            if (i != 0) {
                arrayRep.append("& ");
            }

            if (highlightedElement == null || highlightedElement != i) {
                arrayRep.append(array.get(i)).append(" ");
            } else {
                arrayRep.append("\\fbox{$").append(array.get(i)).append("$} ");
            }
        }
        // actually print the thing
        System.out.println("\\begin{frame}\n" +
                "\\frametitle{Frame "+currentFrame+"}\n" +
                comment +
                "  \\[\n" +
                "\\left[\n" +
                "\\begin{array}{*{"+array.size()+"}{c}}\n" +
                arrayRep + "\n" +
                "\\end{array}\n" +
                "\\right]\n" +
                "\\]\n" +
                "\\end{frame}");
        currentFrame++;
    }

    private void printTitle(String title) {
        System.out.print("\\documentclass{beamer}\n" +
                " \n" +
                "\\usepackage[utf8]{inputenc}\n" +
                " \n" +
                " \n" +
                "\\title{"+title+"}\n" +
                "\\author{Edward Zhang}\n" +
                "\\date{2017}\n" +
                " \n" +
                " \n" +
                " \n" +
                "\\begin{document}\n" +
                "\\frame{\\titlepage}\n");
    }

    public void end() {
        System.out.println("\\end{document}");
    }
}
