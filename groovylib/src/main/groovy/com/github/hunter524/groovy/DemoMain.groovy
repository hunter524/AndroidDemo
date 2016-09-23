public static void main(String[] arg){
    System.out.println("print")
    def var = "println"
    def a = 1
    def b = 2
    def c = a+b
    def d = method(new Object());
    System.out.println(d);
//    new File("E:/").listFiles().eachWithIndex {
//        print it;
//    }
}
int method(String arg) {
    return 1;
}
int method(Object arg) {
    return 2;
}
//Object o = "Object";
//int result = method(o);
