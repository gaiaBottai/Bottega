package bar;

public class Bevitori extends Thread{
    private Rubinetto r;
   
    public Bevitori(Rubinetto r,String nome){
        super(nome);
        this.r=r;
    }

  
    public void run(){

        String nome=Thread.currentThread().getName(); 
        try{
           //entra
           //aspetta
           int attesa=r.entra();
           Thread.sleep(attesa);

            r.esci();
           
           
            

        }catch(InterruptedException i){
            i.printStackTrace();
        }
    }
}
