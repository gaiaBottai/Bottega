package bar;

public class Main {
    public static void main(String[] args) {
        Rubinetto r1=new Rubinetto();
        for(int i=0;i<11;i++){
            Bevitori b=new Bevitori(r1, "Bevitore"+(i+1));
                b.start();
            
        }
    }
}