package basic.services;

class Display {
    private class InnerDisplay {
        public void display() {
            System.out.println("Private inner class method called");
        }
    }

    void display() {
        System.out.println("Outer class (Display) method called");
        InnerDisplay innerDisplay = new InnerDisplay();
        innerDisplay.display();
    }
}

public class main {

    public static void main(String args[]) {
        Display object = new Display();

        object.display();
    }
}