package Model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Produtor implements Runnable {

    private Compartilhado x;
    private int tempo;

    public Produtor(Compartilhado x) {
    }

    public Compartilhado getX() {
        return x;
    }

    public int getTempo() {
        return tempo;
    }

    public void setX(Compartilhado x) {
        this.x = x;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                try {
                    Thread.sleep((int) (Math.random() * getTempo()));
                } catch (InterruptedException e) {
                }
                x.produzir();
                System.out.println("Terminou de produzir.");
            } catch (InterruptedException ex) {
                Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
