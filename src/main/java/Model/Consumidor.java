package Model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor implements Runnable {

    private Compartilhado x;
    private int tempo;

    public Consumidor(Compartilhado x) {
    }

    public void setX(Compartilhado x) {
        this.x = x;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public Compartilhado getX() {
        return x;
    }

    public int getTempo() {
        return tempo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                try {
                    Thread.sleep((int) (Math.random() * getTempo()));
                } catch (InterruptedException e) {
                }
                x.consumir();
                System.out.println("Terminou de consumir.");
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
