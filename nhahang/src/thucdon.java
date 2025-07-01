public class thucdon {
    String monchay;
    String monman;
    String douong;
    thucdon() { }
    public thucdon(String c, String m, String n){
        monchay = c;
        monman = m;
        douong = n;
    }
    public static void in(String[]args){
        thucdon myObj = new thucdon("c", "b", "a");
        System.out.println(myObj.monchay);
    }
}
