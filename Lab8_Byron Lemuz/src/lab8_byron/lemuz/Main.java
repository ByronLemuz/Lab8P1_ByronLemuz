import jdk.swing.interop.SwingInterOpUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {






    public static void main(String[] args) {
        ArrayList<superHeroe> marvel = new ArrayList<superHeroe>();
        ArrayList<superHeroe> dc = new ArrayList<superHeroe>();

        Mazo p1 = new Mazo();
        Mazo p2 = new Mazo();


        p1.addPokemon(new Pokemon("Skyleon",280,80));
        p1.addPokemon(new Pokemon("Gyarados",300,50));
        p1.addPokemon(new Pokemon("Blaziken",200,150));

        p2.addPokemon(new Pokemon("Togepi",75,80));
        p2.addPokemon(new Pokemon("Jigglypuff",30,100));
        p2.addPokemon(new Pokemon("Giratina",40,15));

        marvel.add(new superHeroe("Batman","Batman","Juan Belalcazar","Ciudad Gótica","marvel"));
        dc.add(new superHeroe("Batman","Batman","Juan Belalcazar","Ciudad Gótica","DC"));
        Scanner lector = new Scanner(System.in);
        boolean status = true;
        while(status){
            int opc = Menu();

            switch (opc){
                case 1:
                    int contador = 1;

                    // definiremos quién inicia
                    Pokemon starterP1 = p1.getLuckiestPoke();
                    Pokemon starterP2 = p2.getLuckiestPoke();

                    System.out.printf("%s vs %s\n",starterP1,starterP2);

                    boolean startsp1 = false;
                    boolean startsp2 = false;

                    if(starterP1.getSuerte() > starterP2.getSuerte()){
                        startsp1 = true;
                    }
                    else{
                        startsp2 = true;
                    }

                    while(p1.getRemainingPokemon()!=0 && p2.getRemainingPokemon()!=0){

                        starterP1 = p1.getLuckiestPoke();
                        starterP2 = p2.getLuckiestPoke();
                        System.out.printf("Ronda : %d\n",contador);
                        if(startsp1){
                            System.out.printf(" %s Ataca primero\n %s Ataca segundo\n",starterP1.getNombre(),starterP2.getNombre());
                            starterP1.atacar(starterP2,p2);
                            starterP2.atacar(starterP1,p1);
                            System.out.println("************");
                            System.out.printf("%s vida:%d\n %s vida:%d\n",starterP1.getNombre(),starterP1.getVida(),starterP2.getNombre(),starterP2.getVida());





                        }
                        else if(startsp2){
                            System.out.printf(" %s Ataca primero\n %s Ataca segundo\n",starterP2.getNombre(),starterP1.getNombre());
                            starterP1.atacar(starterP2,p2);
                            starterP2.atacar(starterP1,p1);

                            System.out.println("************");
                            System.out.printf("%s vida:%d\n %s vida:%d\n",starterP2.getNombre(),starterP2.getVida(),starterP1.getNombre(),starterP1.getVida());




                        }
                        contador++;

                    }
                    if (p1.getRemainingPokemon()==0){
                        System.out.println("GANA JUGADOR 2");
                    }
                    else{
                        System.out.println("GANA JUGADOR 1");
                    }


                    break;


                case 2:
                    int thirdopc = SubMenu2();
                    switch(thirdopc){
                        case 2:
                            System.out.println("Ingrese nombre:");
                            String nombre = lector.nextLine();



                            for(int i =0; i<marvel.size();i++){
                                superHeroe actual = marvel.get(i);

                                if(actual.getNombre().equals(nombre)){
                                    System.out.printf("Nombre %s , Nombre real %s Nombre de súper héroe, ciudad %s, franquicia %s",actual.getNombre(),actual.getNombreReal(),actual.getNombreSuperh(),actual.getCiudad(),actual.getFranquicia());
                                    break;
                                }

                            }

                            for (int i =0 ;i<dc.size();i++){
                                superHeroe actual = marvel.get(i);

                                if(actual.getNombre().equals(nombre)){
                                    System.out.printf("Nombre %s , Nombre real %s Nombre de súper héroe, ciudad %s, franquicia %s",actual.getNombre(),actual.getNombreReal(),actual.getNombreSuperh(),actual.getCiudad(),actual.getFranquicia());
                                    break;
                                }
                            }

                            System.out.println("EL super héroe no fue encontrado");

                            break;
                        case 1:
                            String name,namesuperh,realname,city,franchise;
                            System.out.println("Ingrese nombre:");
                            name = lector.nextLine();
                            System.out.println("Ingrese nombre de super héroe:");
                            namesuperh = lector.nextLine();
                            System.out.println("Ingrese nombre real:");
                            realname = lector.nextLine();
                            System.out.println("Ingrese ciudad:");
                            city = lector.nextLine();
                            System.out.println("Ingrese franquicia:");
                            franchise = lector.nextLine().toUpperCase();

                            boolean isDuplicated = false;


                            for(int i =0; i<marvel.size();i++){
                                superHeroe actual = marvel.get(i);

                                if(actual.getNombre().equals(name)){
                                    System.out.printf("Nombre %s , Nombre real %s Nombre de súper héroe, ciudad %s, franquicia %s",actual.getNombre(),actual.getNombreReal(),actual.getNombreSuperh(),actual.getCiudad(),actual.getFranquicia());
                                    isDuplicated = true;
                                    break;
                                }

                            }

                            for (int i =0 ;i<dc.size();i++){
                                superHeroe actual = marvel.get(i);

                                if(actual.getNombre().equals(name)){
                                    System.out.printf("Nombre %s , Nombre real %s Nombre de súper héroe, ciudad %s, franquicia %s",actual.getNombre(),actual.getNombreReal(),actual.getNombreSuperh(),actual.getCiudad(),actual.getFranquicia());
                                    isDuplicated = true;
                                    break;
                                }
                            }
                            if(isDuplicated){
                                System.out.println("Ese nombre ya existe.");
                                break;
                            }

                            if(franchise.equals("DC") || franchise.equals("MARVEL")){
                                if(franchise.equals("DC")){
                                    System.out.println("Súper héreo añadido exitosamente");
                                    dc.add(new superHeroe(name,namesuperh,realname,city,franchise));
                                }
                                else{
                                    System.out.println("Súper héreo añadido exitosamente");
                                    marvel.add(new superHeroe(name,namesuperh,realname,city,franchise));
                                }
                            }
                            break;
                case 3:
                    status = false;
                    break;
            }
                    break;

                case 3:
                    status = false;
        }
    }}


    public static int Menu(){
        Scanner lector = new Scanner(System.in);
        System.out.println("1. Ejercicio 1 ");
        System.out.println("2. Ejercicio 2");
        System.out.println("3. Salir");
        System.out.println("Ingrese una opción: ");


        int opcion = lector.nextInt();
        return opcion;

    }


    public static int SubMenu2(){

        System.out.println("1. Agregar");
        System.out.println("2. Buscar");
        Scanner lector = new Scanner(System.in);
        int opc = lector.nextInt();
        return opc ;
    }
}