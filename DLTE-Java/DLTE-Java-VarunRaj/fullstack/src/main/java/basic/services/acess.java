package basic.services;
class acesstwo{
    public int x=1;
    protected int y=1;
    public int z=1;
    int m=4;
    public void meth(){
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}
public class acess{
    public static void main(String[] args) {
        acesstwo ac=new acesstwo();
        System.out.println(ac.z);
    }
}
