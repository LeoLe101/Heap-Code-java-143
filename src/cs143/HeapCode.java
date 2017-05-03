package cs143;

public class HeapCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Heap<String> str = new Heap<>();
        str.add("Aa");
        str.add("Ba");
        str.add("Ca");
        str.add("Da");
        str.add("Ea");
        System.out.println(str);
        str.remove();
        System.out.println(str);
    }

}
