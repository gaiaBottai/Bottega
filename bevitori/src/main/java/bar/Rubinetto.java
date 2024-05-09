package bar;

public class Rubinetto {

   private int conta=0;
    private int litri = 100;

   
    public synchronized int entra(){
        
        String nome=Thread.currentThread().getName();
        int attesa=1000+(int)(Math.random()*5000);
        int occupa=0;
        System.out.println(nome+" sta aspettando "+(attesa/1000)+" secondi");
        try {
            while ((litri<=0)||(conta>=3)) {
                System.out.println("e' in attesa");
                wait();
               
            }


            if((litri>=0) && (litri<=100)){
            conta++;
            

             occupa=2000+(int)(Math.random()*3000);
           System.out.println(nome+" e' entrato per "+(occupa/1000)+" secondi");

            int consumo=1+(int)(Math.random())*4;
                System.out.println(nome+" consuma "+(consumo)+" litri");

              
            }


           if(litri<=0){
            System.out.println(nome+ " ha finito il vino");
            Thread.interrupted();
           }
          
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        return occupa;
    }

    public synchronized void esci() {
        String nome=Thread.currentThread().getName();
        conta--;
        System.out.println(nome+" ha smesso di bere ed e' uscito");
        notify();
      
    }

}