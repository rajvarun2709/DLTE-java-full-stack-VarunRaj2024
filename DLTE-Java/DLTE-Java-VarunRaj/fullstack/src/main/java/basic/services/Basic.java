package basic.services;
public class Basic {
    protected void display()
    {
        System.out.println("Hello");
    }
}
class Board extends Basic {
    public static void main(String args[])
    {
        Board obj = new Board();
        obj.display();
    }
}