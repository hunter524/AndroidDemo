
public static void main(String[] arg){
//    BaseGroovyDemo.baseFileDemo();
//    def groovyBeanExample = GroovyBeanExample.newInstance();
//    println(groovyBeanExample.name)
    def parent = new Parent()
    parent.configChild {
        name = "child name"
    }

    println parent.child.name
}


