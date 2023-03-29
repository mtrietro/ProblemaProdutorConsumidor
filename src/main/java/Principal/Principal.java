package Principal;
import Model.*;

public class Principal {

    public static void main(String[] args) {
        
        //Cria o recurso compartilhado entre produto e consumidor
        Compartilhado recurso = new Compartilhado();
        // recurso.setBuffer(5);
        recurso.setTamanhoBuffer(10);
        
        
        //Cria os consumidores
        Consumidor c1 = new Consumidor(recurso);
        Consumidor c2 = new Consumidor(recurso);
        
        //Define o tempo de atraso do consumidor
        c1.setTempo(100);
        c1.setX(recurso);
        c2.setTempo(1000);
        c2.setX(recurso);
        
        //Cria os produtor
        Produtor p1 = new Produtor(recurso);
        Produtor p2 = new Produtor(recurso);
        
        //Define o tempo de atraso do produto
        p1.setTempo(50);
        p1.setX(recurso);
        
        p2.setTempo(1000);
        p2.setX(recurso);
        
        //Cria as Threads dos consumidores e produtores
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(p1);
        Thread t3 = new Thread(c2);
        Thread t4 = new Thread(p2);
        
        //Inicia as Threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
