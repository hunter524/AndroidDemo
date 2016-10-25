class GroovyBeanExample{
    public String name = "just a groovy bean demo!"
}
class Child{
    private String name ;
}
class Parent {
    String name ;
    Child child = new Child();
    void configChild(Closure c) {
        c.delegate = child
//        c.setResolveStrategy (Closure.DELEGATE_FIRST)
                c.setResolveStrategy (Closure.DELEGATE_FIRST)
        c()
    }
}