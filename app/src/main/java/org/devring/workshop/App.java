/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.devring.workshop;

public class App {
    public String getGreeting() {
        return "Hello World!" ;
    }

    public String getOs() {
        return System.getProperty("os.name");
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
