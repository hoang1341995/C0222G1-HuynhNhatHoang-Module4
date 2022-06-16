public class test {
    public static void main(String[] args) {
        int r = 13;
        int l = 9;
        String a;
        for (; l < r; l++) {
            a = ""+l;
            if (a.charAt(0) == a.charAt(a.length()-1)&&l>10){
                System.out.println(l);
            }
        }
    }
}
