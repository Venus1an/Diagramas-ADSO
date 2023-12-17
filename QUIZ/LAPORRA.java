package porra;
import java.util.Scanner;
public class LAPORRA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        int numjugadores=0;
        int tamanoMatriz=0;
        int tamM=0;
        int tamN=0;
        int aux=1;
        int temp=0;
        boolean end=true;
        int contador=1;
        int jugadoresActivos=0;
        String listaJugadoresEli="";


        int [] jugadores;

        System.out.println("Juego LA PORRA");

        do {//LLave del do-while
            System.out.println("Digite el número de jugadores:");
            numjugadores = sc.nextInt();
            if(numjugadores<=0){
                System.out.println("Digite un número mayor a 0");
            }
        }while(numjugadores<=0);//LLave del do-while

        jugadoresActivos=numjugadores;
        jugadores = new int [numjugadores];

       /* do {
            System.out.println("Digite el tamaño (par) del tablero a jugar:  ejemplo: 4 Jugadores ---> 50");
            tamanoMatriz = sc.nextInt();
            if(tamanoMatriz%2!=0){
                System.out.println("Digite un número que sea par");
            }
        }while(tamanoMatriz<=1 || tamanoMatriz%2!=0);
        

        for(int i=0;i<tamanoMatriz;i++){

        }*/

        do {//LLave del do-while
            System.out.println("Digite el valor de las filas: ");
            tamM = sc.nextInt();
            System.out.println("Digite el valor de las columnas: ");
            tamN = sc.nextInt();

            if(tamM<0 || tamN<0){
                System.out.println("Digite valores positivos.");
            }
        }while(tamM<0 || tamN<0);//LLave del do-while


        int matriz[][]= new int[tamM][tamN];

        for(int i=0;i< matriz.length;i++){//LLave del for
            for(int j=0;j<matriz[0].length;j++){
                matriz[i][j]=aux;
                aux++;
            }
        }//LLave del for

        for (int i = 0; i < jugadores.length; i++) {//LLave del for
            do {

                System.out.println(" Jugador " + (i + 1) + " Digite su número a participar: ");
                jugadores[i] = sc.nextInt();

                if(jugadores[i] <= 0 || jugadores[i]>=aux){
                    System.out.println("El numero debe ser menor al máximo de la matriz.");
                }
            }while (jugadores[i] <= 0 || jugadores[i]>=aux) ;
        }//LLave del for



        while(end){//LLave del while
            for(int i=0;i<matriz.length;i++){
                for(int j=0;j<matriz[0].length;j++){
                    if(matriz[i][j]!=-1) {
                        System.out.print(matriz[i][j] + " ");
                    }else {
                        System.out.print("x ");
                    }
                }
                System.out.println("");
            }
            int tempFila=0;
            int tempColumna=0;
            do {
                System.out.println("Jugador "+contador+" Digite un numero a eliminar: ");
                temp = sc.nextInt();
                tempFila=temp/tamN;
                tempColumna=(temp%tamN)-1;
                //corrige posicion de ultima columna ado que inicia en 1
                if(temp%tamN==0){
                    tempFila--;
                    tempColumna=tamN-1;
                }
                if(temp <= 0 || temp>=aux){
                    System.out.println("El numero debe ser menor al máximo de la matriz.");
                }else if (matriz[tempFila][tempColumna]==-1){
                    System.out.println("Este número ya fue eliminado, ingrese uno distinto");
                }

            }while(temp <= 0 || temp>aux || matriz[tempFila][tempColumna]==-1);
            matriz[tempFila][tempColumna]=-1;
            for(int i=0;i<jugadores.length;i++){
                if(jugadores[i]==temp && (i+1)!=contador){
                    System.out.println("Jugador: "+(i+1)+" fue eliminado");
                    jugadoresActivos--;
                    listaJugadoresEli+=String.valueOf(i+1);
                }
            }

            contador++;

            for(int i=0;i<listaJugadoresEli.length();i++){
                if(listaJugadoresEli.charAt(i)==contador){
                    contador++;
                    i=0;
                }
            }

            if(contador>=numjugadores){
                contador=1;
            }

            if(jugadoresActivos==1){
                break;
            }
        }//LLave del while
