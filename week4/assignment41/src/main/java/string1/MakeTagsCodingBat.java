package main.java.string1;

public class MakeTagsCodingBat {
    public static void main(String[] args) {
        MakeTagsCodingBat object = new MakeTagsCodingBat();

        System.out.println("makeTags(\"i\", \"Yay\") = "+ object.makeTags("i", "Yay"));
        System.out.println("makeTags(\"i\", \"Hello\") = "+ object.makeTags("i", "Hello"));
        System.out.println("makeTags(\"cite\", \"Yay\") = "+ object.makeTags("cite", "Yay"));
    }

    /**
     * The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text.
     * In this example, the "i" tag makes <i> and </i> which surround the word "Yay".
     * Given tag and word strings, create the HTML string with tags around the word,
     * e.g. "<i>Yay</i>".
     * makeTags("i", "Yay") → "<i>Yay</i>"
     * makeTags("i", "Hello") → "<i>Hello</i>"
     * makeTags("cite", "Yay") → "<cite>Yay</cite>"
     */

    public String makeTags(String tag, String word) {
        String sufix = "<" + tag + ">";
        String prefix = "</" + tag + ">";

        return sufix + word + prefix;
    }
}
