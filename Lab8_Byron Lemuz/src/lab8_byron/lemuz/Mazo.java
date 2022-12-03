import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mazo {

    int remainingPokemons = 0;
    boolean inicia = false;

    ArrayList<Pokemon> collection = new ArrayList<Pokemon>();

    Mazo(){

    }
    void addPokemon(Pokemon poke){
        this.collection.add(poke);
        if(getRemainingPokemon()>=3){
            System.out.println("El mazo ya está lleno");
            return;
        }
        this.remainingPokemons += 1;
    }

    Pokemon getLuckiestPoke(){
        Pokemon luckiestOne = this.collection.get(0);
        int max = 0;
        for(int i = 0; i<this.collection.size();i++){
            Pokemon actual = this.collection.get(i);
            if(actual.getSuerte()> max){
                max = actual.getSuerte();
                luckiestOne = actual;
            }

        }
        return luckiestOne;
    }

    int getRemainingPokemon(){
        return this.remainingPokemons;
    }

    void updatePokemons(){
        ArrayList<Pokemon> currentOnes = this.collection;
        ArrayList<Pokemon> aliveOnes = new ArrayList<>();

        for(int i=0; i<currentOnes.size();i++){
            if(currentOnes.get(i).alive == true){
                this.collection.remove(currentOnes.get(i));
            }
        }
    }
}
