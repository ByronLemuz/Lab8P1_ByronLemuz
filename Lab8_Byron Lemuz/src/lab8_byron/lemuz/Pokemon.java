import java.util.Random;
public class Pokemon {
    String nombre;
    int vida;
    int ataque;
    int suerte;

    boolean alive = true;

    Random rand = new Random();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getSuerte() {
        return suerte;
    }

    public void setSuerte(int suerte) {
        this.suerte = suerte;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public void atacar(Pokemon p2,Mazo oponente){
        System.out.printf("%s Ataca a %s\n",this.nombre,p2.getNombre());
        System.out.printf("%s | Puntos de vida :%d\n",this.getNombre(),this.getVida());
        p2.vida -= this.ataque;


        if(p2.vida<=0){
            p2.alive = false;
            System.out.printf("%s mata a %s\n",this.nombre,p2.getNombre());
            oponente.remainingPokemons--;
            oponente.collection.remove(p2);
        }

    }
    Pokemon(String nombre, int vida, int ataque){
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.suerte = rand.nextInt(((5-1)+1)+1);
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
