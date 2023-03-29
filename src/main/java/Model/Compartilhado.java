package Model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Compartilhado {

    private int buffer;
    private int tamanhoBuffer;

    public Compartilhado() {
    }

    public Compartilhado(int buffer, int tamanhoBuffer) {
    }

    public int getBuffer() {
        return buffer;
    }

    public int getTamanhoBuffer() {
        return tamanhoBuffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public void setTamanhoBuffer(int tamanhoBuffer) {
        this.tamanhoBuffer = tamanhoBuffer;
    }

    public synchronized void consumir() throws InterruptedException {

        while(buffer == 0){
            wait();
        }
                
        if (buffer > 0) {
            setBuffer(getBuffer() - 1);
            notifyAll();
        }

        System.out.println("Buffer: " + buffer);
    }

    public synchronized void produzir() throws InterruptedException {

        while(buffer == tamanhoBuffer){
            wait();
        }
                
        if (buffer < tamanhoBuffer) {
            setBuffer(getBuffer() + 1);
            notifyAll();
        }
        
        System.out.println("Buffer: " + buffer);

    }

}
