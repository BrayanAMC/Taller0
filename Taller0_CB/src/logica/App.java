package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import javax.sql.rowset.serial.SQLOutputImpl;

import ucn.*;

public class App {
	
	/**
	 * Displays the room chosen by the user in the form of a matrix with rows and columns graphically
	 * @param funcionOpcion
	 * @param sala1M
	 * @param sala1T
	 * @param sala2M
	 * @param sala2T
	 * @param sala3M
	 * @param sala3T
	 * @param listaSalaSplit
	 * @param listaHorarioSplit
	 * @return
	 */
	private static String[][] llamarSala(String funcionOpcion, String[][] sala1M, String[][] sala1T, String[][] sala2M, String[][] sala2T,
			String[][] sala3M, String[][] sala3T, String[] listaSalaSplit, String[] listaHorarioSplit) {
		
		System.out.println("Asientos disponibles en la Sala "+ listaSalaSplit[Integer.parseInt(funcionOpcion)-1]+" ,horario: "+listaHorarioSplit[Integer.parseInt(funcionOpcion)-1]+". " );
		
		if(listaSalaSplit[Integer.parseInt(funcionOpcion)-1].equals("1")) 
		{
			if(listaHorarioSplit[Integer.parseInt(funcionOpcion)-1].equals("M"))
			{
				
				for(int i=0;i<sala1M.length;i++) 
				{
					for(int j=0;j<sala1M[i].length;j++) 
					{
						System.out.print(sala1M[i][j]+ " ");
						//nota:cambiar matriz de enteros por una de String
						
						
					}
					System.out.println();
				}
				return sala1M;
				
			}
			if(listaHorarioSplit[Integer.parseInt(funcionOpcion)-1].equals("T")) 
			{
				for(int i=0;i<sala1T.length;i++) 
				{
					for(int j=0;j<sala1T[i].length;j++) 
					{
						System.out.print(sala1T[i][j]+ " ");
						//nota:cambiar matriz de enteros por una de String
						
					}
					System.out.println();
				}
				return sala1T;
				
			}
			return null;
			
		}
		if(listaSalaSplit[Integer.parseInt(funcionOpcion)-1].equals("2")) 
		{
			if(listaHorarioSplit[Integer.parseInt(funcionOpcion)-1].equals("M"))
			{
				
				for(int i=0;i<sala2M.length;i++) 
				{
					int columnas = 0;
					for(int j=0;j<sala2M[i].length;j++) 
					{
						
						System.out.print(sala2M[i][j]+ " ");
					}
					System.out.println();
				}
				return sala2M;
				
			}
			if(listaHorarioSplit[Integer.parseInt(funcionOpcion)-1].equals("T")) 
			{
				for(int i=0;i<sala2T.length;i++) 
				{
					for(int j=0;j<sala2T[i].length;j++) 
					{
						System.out.print(sala2T[i][j]+ " ");
						//nota:cambiar matriz de enteros por una de String
						
					}
					System.out.println();
				}
				return sala2T;
			}
			return null;
		}
		if(listaSalaSplit[Integer.parseInt(funcionOpcion)-1].equals("3")) 
		{
			if(listaHorarioSplit[Integer.parseInt(funcionOpcion)-1].equals("M"))
			{
				for(int i=0;i<sala3M.length;i++) 
				{
					for(int j=0;j<sala3M[i].length;j++) 
					{
						System.out.print(sala3M[i][j]+ " ");
						//nota:cambiar matriz de enteros por una de String
						
					}
					System.out.println();
				}
				return sala3M;
			}
			if(listaHorarioSplit[Integer.parseInt(funcionOpcion)-1].equals("T")) 
			{
				for(int i=0;i<sala3T.length;i++) 
				{
					for(int j=0;j<sala3T[i].length;j++) 
					{
						System.out.print(sala3T[i][j]+ " ");
						//nota:cambiar matriz de enteros por una de String
						
					}
					System.out.println();
				}
				return sala3T;
			}
			return null;
		}
		return null;
	}
	/**
	 * It is in charge of decorating the room matrix with the rows of A-J and the columns of 1-31 in addition to inserting the seats that are not valid due to spacing (/) and those that are not occupied (x)
	 * @param sala1M
	 * @param sala1T
	 * @param sala2M
	 * @param sala2T
	 * @param sala3M
	 * @param sala3T
	 */
	private static void distanciamiento(String[][] sala1M, String[][] sala1T, String[][] sala2M, String[][] sala2T, String[][] sala3M, String[][] sala3T) {
		//definiremos los asiento que se pueden ocupar y cuales no 
		//(0) ---> asiento disponible
		//(/) ---> asiento no disponible
		int columnas = 0;
		int filas = 0;
		String [] voca = new String[11];
		voca[0] = "A";
		voca[1] = "B";
		voca[2] = "C";
		voca[3] = "D";
		voca[4] = "E";
		voca[5] = "F";
		voca[6] = "G";
		voca[7] = "H";
		voca[8] = "I";
		voca[9] = "J";
		voca[10] = "K";
		for(int i = 0;i<sala2M.length;i++) 
		{
			for(int j=0;j<sala2M[i].length;j+=2) 
			{
				
				sala1M[i][j+1] = "/";
				sala1M[i][j] = "0";
				sala1T[i][j+1] = "/";
				sala1T[i][j] = "0";
				sala2M[i][j+1] = "/";
				sala2M[i][j] = "0";
				sala2T[i][j+1] = "/";
				sala2T[i][j] = "0";
				sala3M[i][j+1] = "/";
				sala3M[i][j] = "0";
				sala3T[i][j+1] = "/";
				sala3T[i][j] = "0";
				
			}
		}	
		for(int i = 0;i<sala2M.length;i++) 
		{
			
			if(i>0) 
			{
				sala2M[i][0] = voca[filas];
				sala2T[i][0] = voca[filas];
				sala1M[i][0] = voca[filas];
				sala1T[i][0] = voca[filas];
				sala3M[i][0] = voca[filas];
				sala3T[i][0] = voca[filas];
				filas++;
			}
				
			for(int j = 0;j<sala2M[i].length;j++) 
			{
				if(j>0 && i ==0) 
				{
					columnas++;
					sala1M[0][j] =Integer.toString(columnas);
					sala1T[0][j] =Integer.toString(columnas);
					sala2M[0][j] =Integer.toString(columnas);
					sala2T[0][j] =Integer.toString(columnas);
					sala3M[0][j] =Integer.toString(columnas);
					sala3T[0][j] =Integer.toString(columnas);
				}
			}
			
		}
		//relleno con x 
		for(int x = 1;x<5;x++) 
		{
			for(int y=1;y<6;y++) 
			{
				sala1M[x][y] = "x";
				sala1T[x][y] = "x";
				sala2M[x][y] = "x";
				sala2T[x][y] = "x";
				sala3T[x][y] = "x";
			}	
		}
		for(int x = 1;x<5;x++) 
		{
			for(int y=27;y<=31;y++) 
			{
				sala1M[x][y] = "x";
				sala1T[x][y] = "x";
				sala2M[x][y] = "x";
				sala2T[x][y] = "x";
				sala3T[x][y] = "x";
			}	
		}
		for(int x = 11;x<sala1M.length;x++) 
		{
			for(int y=0;y<sala1M[x].length;y++) 
			{
				sala1M[x][y] = "";
				sala1T[x][y] = "";
				sala2M[x][y] = "";
				sala2T[x][y] = "";
				sala3T[x][y] = "";
			}	
		}
		
	}
	/**
	 * This applet reads clientes.txt, separates its parameters by (,) and stores its variables in their respective lists named clientname, Surname, Lrut, Lpass, Lsaldo in parallel and returns a customer counter.
	 * @param LnombreCliente
	 * @param Lapellido
	 * @param Lrut
	 * @param Lpass
	 * @param Lsaldo
	 * @return
	 * @throws IOException
	 */
	public static int leerClientes(String [] LnombreCliente, String [] Lapellido, String [] Lrut, String [] Lpass, double [] Lsaldo) throws IOException{
        int contRut = 0;
		ArchivoEntrada arch = new ArchivoEntrada("clientes.txt");
        while(!arch.isEndFile()){
            Registro regEnt = arch.getRegistro();
            LnombreCliente[contRut] = regEnt.getString();
            Lapellido[contRut] = regEnt.getString();
            String rut = regEnt.getString();
            rut = rut.replace("-","").replace(".", "");
            Lrut[contRut] = rut;
            Lpass[contRut] = regEnt.getString();
            Lsaldo[contRut] = regEnt.getDouble();
            contRut++;
        }
        arch.close();
        return contRut;
    }
	/**
	 * Status.txt is read, its two variables rut ​​and status are separated and entered in the corresponding lists and a counter of passes is returned.
	 * @param Lrut
	 * @param LpaseM
	 * @return
	 * @throws IOException
	 */
	public static int leerStatus(String [] Lrut, String [] LpaseM) throws IOException{

        int contPase = 0;
		ArchivoEntrada arch = new ArchivoEntrada("status.txt");
        while(!arch.isEndFile()){
            Registro regEnt = arch.getRegistro();
            String rut = regEnt.getString();
            rut = rut.replace("-","").replace(".", "");
            Lrut[contPase] = rut;
            LpaseM[contPase] = regEnt.getString();
            contPase++;
        }
        arch.close();
        return contPase;
    }
	/**
	 * This applet reads peliculas.txt, separates the parameters by (,) and enters the lists and returns a peliculas counter.
	 * @param nomPeli
	 * @param tipoPeli
	 * @param recaudacion
	 * @param listaSala
	 * @param listaHorario
	 * @return
	 * @throws FileNotFoundException
	 */
	private static int leerPeliculas(String[] nomPeli, String[] tipoPeli, double[] recaudacion, String[] listaSala,
			String[] listaHorario) throws FileNotFoundException {
		int contPelis = 0;
		Scanner arch = new Scanner(new File("peliculas.txt"));
		while(arch.hasNextLine()) 
		{
			int contLine = 0;
			String line = arch.nextLine();
			String [] partes = line.split(",");
			contLine = partes.length;
			nomPeli[contPelis] = partes[0];
			tipoPeli[contPelis] = partes[1];
			recaudacion[contPelis] = Double.parseDouble(partes[2]);
			for(int i = 3;i<contLine;i+=2) 
			{
				listaSala[contPelis] += partes[i];
				listaHorario[contPelis] += partes[i+1];
			}
			contPelis++;	
		}
		return contPelis;
	}
	/**
	 * This applet registers a user if his data is not found in the system database, it returns ruts counter.
	 * @param vector
	 * @param rut
	 * @param LnombreCliente
	 * @param Lapellido
	 * @param Lrut
	 * @param Lpass
	 * @param Lsaldo
	 * @param contRut
	 * @param contPase
	 * @param LpaseM
	 */
	public static void registrarPersona(int [] vector, String rut, String [] LnombreCliente, String [] Lapellido, String [] Lrut, String [] Lpass, double [] Lsaldo,int contRut, int contPase,String [] LpaseM){
		Scanner scanner = new Scanner(System.in);	
		
		Lrut [contRut] = rut;
		
		StdOut.print("Ingrese su nombre: ");
        String nombre = StdIn.readString();
        LnombreCliente [contRut] = nombre;
        
        StdOut.print("Ingrese su apellido: ");
        String apellido = StdIn.readString();
        Lapellido [contRut] = apellido;
        Lrut [contRut] = rut;
        
        StdOut.print("Ingrese una contraseña: ");
        String pass = StdIn.readString();
        Lpass [contRut] = pass;
        
        StdOut.print("Ingrese saldo a su nueva cuenta: ");
        double saldo = StdIn.readDouble();
        Lsaldo [contRut] = saldo;
        
        StdOut.print("¿Usted tiene el pase de movilidad habilitado? <si - no>: ");
        String status = StdIn.readString();
        if (status.equalsIgnoreCase("si")) {
        	LpaseM[contPase] = "HABILITADO";
        	
        }
        
        if (status.equalsIgnoreCase("no")) {
        	LpaseM[contPase] = "NO HABILITADO";
        }
        
    	while(!status.equalsIgnoreCase("si" ) && !status.equalsIgnoreCase("no")) {
    		StdOut.println("La opción ingresada no es válida. ");
            StdOut.print("¿Usted tiene el pase de movilidad habilitado? <si - no>: ");
    		status = StdIn.readString();
    	}
        
        
        Lsaldo [contRut] = saldo;
        
        contRut++;
        contPase++;
        StdOut.println("Usuario registrado con exito");
        
        vector[0] = contRut ;
        vector [1] = contPase;

    }
	/**
	 * Displays information on the mobility pass status of all clientes on the screen(rutCliente,estadoPaseMovilidad).
	 * @param Lrut
	 * @param LpaseM
	 * @param contPase
	 */
	public static void desplegarStatus(String [] Lrut, String [] LpaseM,int contPase){
        StdOut.println("______________________________________________________");
        StdOut.println("Estado del pase de movilidad por cliente: ");
        StdOut.println("***Rut, Estado ***");
        StdOut.println("");
        for(int i=0; i <contPase;i++){
            
            StdOut.println(Lrut[i]+","+ LpaseM[i]);
        
        }
        StdOut.println("______________________________________________________");
             
    }//End subprogram   
	/**
	 * Displays the basic information of the user plus the information corresponding to their purchased tickets
	 * @param ingresa
	 * @param eRut
	 * @param entradasInfo
	 * @param contInfo
	 * @param rutInfo
	 * @param peliculaInfo
	 * @param salaInfo
	 * @param horarioInfo
	 * @param asientoInfo
	 * @param Lrut
	 * @param LnombreCliente
	 * @param Lapellido
	 * @param Lsaldo
	 * @param contRut
	 */
	public static void informacionUsuario(boolean ingresa,int eRut, int[] entradasInfo,int contInfo,String rutInfo[], String[] peliculaInfo,String [] salaInfo,String [] horarioInfo, String [] asientoInfo,String [] Lrut,String[] LnombreCliente, String [] Lapellido,  double [] Lsaldo,int contRut){
		
        //StdOut.println("______________________________________________________");
        StdOut.println("Información del cliente. ");
        StdOut.println("............................");
        StdOut.println("Rut: "+Lrut[eRut]);
        StdOut.println("Nombre: "+LnombreCliente[eRut]+","+Lapellido[eRut]);
        StdOut.println("Saldo: $"+Lsaldo[eRut]);
        
        StdOut.println(".........................................................");
        StdOut.println("entradas compradas: ");
        for(int j=0; j < contInfo;j++) {
        	if (Lrut[eRut].equalsIgnoreCase(rutInfo[j])) {
        		StdOut.println("____________________________");
            	StdOut.println("Pelicula: "+ peliculaInfo[j]);
            	StdOut.println(" -"+entradasInfo[j]+" entradas ");
            	StdOut.println(" -Sala: "+salaInfo[j]);
            	StdOut.println(" -Horario: "+horarioInfo[j]);
            	StdOut.println(" -Asiento: "+asientoInfo[j]);
            	StdOut.println("____________________________");
            	StdOut.println("");
            }
        
        }
        
        //StdOut.println("______________________________________________________");
             
    }//End subprogram   

	private static void ingresarDatosMatriz(String[][] matrizInventario, 
			String[] lrut, String cantEntradas, String horarioSalaCompleto, String peliOpcion, String filaChoice, String columnaChoice,String rutDefecto,int contRut) {
		//recorrer matriz
		int index = 0;
		for(int i = 0;i<contRut;i++) 
		{
			if(lrut[i].equals(rutDefecto)) 
			{
				index = i;
			}
		}
		for(int i=0;i<matrizInventario.length;i++) 
		{
			for(int j=0;j<matrizInventario[i].length;j++) 
			{
				matrizInventario[0][index] = cantEntradas; //numero entradas
				matrizInventario[1][index] = horarioSalaCompleto; //horario
				matrizInventario[2][index] = peliOpcion; //nombrePelicula
				matrizInventario[3][index] = "fila: "+filaChoice+" columna: "+columnaChoice; //asientos
			}
		}
		
	}
	
	private static String[][] matrizInventario(int cantRuts,int cantStuffs) {
		String [][] matrizInventario = new String[cantStuffs][cantRuts];
		return matrizInventario;
	}
	/**
	 * It is in charge of determining that the seat that the user is valid, not valid due to distancing or that it does not exist / not occupiable (x)
	 * @param filaChoice
	 * @param salaChoice
	 * @param columnaChoice
	 * @return
	 */
	private static String encontrarIndiceFila(String filaChoice, String[][] salaChoice,String columnaChoice ) {
				
		//clannat
		String cantEntradas = "";
		int contadorFilas = 0;
		for(int x=0;x<salaChoice.length;x++) 
		{
			
			for(int y=0;y<salaChoice[x].length;y++) 
			{
				
				if(salaChoice[x][y].equalsIgnoreCase(filaChoice) && !salaChoice[x][y].equalsIgnoreCase(null)) 
				{
					contadorFilas = x;
					//System.out.println("contadorfilas: "+contadorFilas);
				}
				
			}
				
		}
		
		if(salaChoice[contadorFilas][Integer.parseInt(columnaChoice)] == "/") 
		{
			System.out.println("Asiento no cumple con el distanciamiento social necesario. ");
			System.out.println("Elija un asiento nuevamente: ");
			cantEntradas = "0";
			return cantEntradas;
			
		}
		if(salaChoice[contadorFilas][Integer.parseInt(columnaChoice)] == "1") 
		{
			System.out.println("El asiento seleccionado está ocupado.");
			System.out.println("Elija un asiento nuevamente: ");
			//debe volver a elegir otro asiento que sea valido.
			cantEntradas = "0";
			return cantEntradas;
		}
		if(salaChoice[contadorFilas][Integer.parseInt(columnaChoice)] == "0") 
		{
			//System.out.println("Asiento seleccionado correctamente. ");
			salaChoice[contadorFilas][Integer.parseInt(columnaChoice)] = "1";
			return cantEntradas;
		}
		if(salaChoice[contadorFilas][Integer.parseInt(columnaChoice)] == "x") 
		{
			System.out.println("El asiento seleccionado no existe, vuelva a intentarlo. ");
			cantEntradas = "0";
			return cantEntradas;
		} 
		return cantEntradas;
		
		
	}
	/**
	 * Displays the information related to the tickets that a client owns
	 * @param eRut
	 * @param entradasInfo
	 * @param contInfo
	 * @param rutInfo
	 * @param peliculaInfo
	 * @param salaInfo
	 * @param horarioInfo
	 * @param asientoInfo
	 * @param Lrut
	 * @param LnombreCliente
	 * @param Lapellido
	 * @param Lsaldo
	 * @param contRut
	 */
	public static void desplegarEntradas(int eRut, int[] entradasInfo,int contInfo,String rutInfo[], String[] peliculaInfo,String [] salaInfo,String [] horarioInfo, String [] asientoInfo,String [] Lrut,String[] LnombreCliente, String [] Lapellido,  double [] Lsaldo,int contRut){

        //StdOut.println("______________________________________________________");
        StdOut.println("Entradas compradas por el cliente. ");
        StdOut.println(".......................................");
       
        for(int j=0; j < contInfo;j++) {
        	if (Lrut[eRut].equalsIgnoreCase(rutInfo[j])) {
        		StdOut.println("____________________________");
            	StdOut.println("Pelicula: "+ peliculaInfo[j]);
            	StdOut.println(" -"+entradasInfo[j]+" entradas ");
            	StdOut.println(" -Sala: "+salaInfo[j]);
            	StdOut.println(" -Horario: "+horarioInfo[j]);
            	StdOut.println(" -Asiento: "+asientoInfo[j]);
            	StdOut.println("____________________________");
            	StdOut.println("");
            }
        
        }
        
        //StdOut.println("______________________________________________________");
             
    }//End subprogram   
             
    /**
     * Executes most of the logic for the Client Menu requirement section c)
     * @param pagoInfo
     * @param eRut
     * @param entradasInfo
     * @param contInfo
     * @param rutInfo
     * @param peliculaInfo
     * @param salaInfo
     * @param horarioInfo
     * @param asientoInfo
     * @param Lrut
     * @param LnombreCliente
     * @param Lapellido
     * @param Lsaldo
     * @param contRut
     * @param cantEntradasAux
     * @param sala1M
     * @param sala1T
     * @param sala2M
     * @param sala2T
     * @param sala3M
     * @param sala3T
     */
	public static void devolucionEntrada(double [] pagoInfo, int eRut, int[] entradasInfo,int contInfo,String rutInfo[], String[] peliculaInfo,String [] salaInfo,String [] horarioInfo, String [] asientoInfo,String [] Lrut,String[] LnombreCliente, String [] Lapellido,  double [] Lsaldo,int contRut, int cantEntradasAux, String[][] sala1M, String[][] sala1T, String[][] sala2M, String[][] sala2T, String[][] sala3M, String[][] sala3T) {
		/*
		System.out.println("-------------------------------");
		for (int i = 0; i < salaInfo.length; i++) {
			System.out.println("sala info tiene: "+salaInfo[i]);
			
		}
		System.out.println("-------------------------------");
		*/
		double totalEntrada = 0; 
		double devolucionEntrada = 0;
		
		
		StdOut.println("Ingrese el nombre de la pelicula de la cual quiere reembolso: ");
		Scanner scann = new Scanner(System.in);
		String pelicula = scann.nextLine();
    	String filaEliminar = "";
    	int contadorPelis = 0;
    	int columnaEliminar = 0;
		int ePeli = 0;
        while (ePeli < contInfo && !peliculaInfo [ePeli].equalsIgnoreCase(pelicula)){
            ePeli++;
        }
        //si no se encuentra
        if (ePeli == contInfo){
            while(ePeli == contInfo){
        		System.out.println("La pelicula ingresada no es válida");
        		System.out.println("Ingrese el nombre de la pelicula nuevamente:: ");
        		pelicula = scann.nextLine();
                
        		ePeli = 0;
                while (ePeli < contInfo && !peliculaInfo [ePeli].equalsIgnoreCase(pelicula)){
                    ePeli++;
                }
            }
        }
        //si se encuentra
        if(ePeli != contInfo) {
        	
        	StdOut.println("Ingresa la cantidad de entradas que va a reembolsar: ");
        	int entrada = StdIn.readInt();
        	
        	while(entrada <0 && entrada > cantEntradasAux) 
        	{
        		System.out.println("la cantidad de entradas ingresada no es válida (sobrepasa o supera las que usted posee) ");
        		StdOut.println("Ingrese la cantidad de entradas que va a reembolsar: ");
            	entrada = StdIn.readInt();
        	}
        	
        	//System.out.println("el numero de entradas es valido");
        	if(entrada == cantEntradasAux) 
        	{
        		//el usuario desea eliminar todas sus entradas
        		//por lo tanto no se le pide cual entrada eliminar 
        		//ni fila ni columna.
        		
        		
        		for (int i = 0; i <entrada; i++) {
        			
					System.out.println("ingrese la fila (A-J) de la entrada "+ i+1+" a eliminar");
					filaEliminar = StdIn.readString();
					System.out.println("ingrese la columna (1-30) de la entrada "+ i+1+" a eliminar");
					columnaEliminar = StdIn.readInt();
					for(int x=0;x<peliculaInfo.length;x++) 
					{
						if(peliculaInfo[x] != null) 
						{
							contadorPelis++;
						}
					}
					for (int j = 0; j <contadorPelis; j++) {
						//System.out.println("hola:"+j);
						if(peliculaInfo[j].equals(pelicula)) 
						{
							
							//System.out.println("entramos!:"+j);
							
							//salainfo --> numero de la sala
							//horarioInfo --> manana o tarde
							String sala = salaInfo[j];
							String horario = horarioInfo[j];
							habilitarAsientos(sala,horario,filaEliminar,columnaEliminar,sala1M,sala1T,sala2M,sala2T,sala3M,sala3T);
							
						}
					}
					
					
				}
        		
        	}
        	else 
        	{
        		//el usuario va a eliminar un numero menor a su cant total de entradas
        		//por lo tanto por cada entrada se le debe preguntar la fila y columna.
        		for (int i = 0; i <entrada; i++) {
        			
					System.out.println("ingrese la fila (A-J) de la entrada "+ i+1+" a eliminar");
					filaEliminar = StdIn.readString();
					System.out.println("ingrese la columna (1-30) de la entrada "+ i+1+" a eliminar");
					columnaEliminar = StdIn.readInt();
					for(int x=0;x<peliculaInfo.length;x++) 
					{
						if(peliculaInfo[x] != null) 
						{
							contadorPelis++;
						}
					}
					for (int j = 0; j <contadorPelis; j++) {
						System.out.println("hola:"+j);
						if(peliculaInfo[j].equals(pelicula)) 
						{
							
							System.out.println("entramos!:"+j);
							//salainfo --> numero de la sala
							//horarioInfo --> manana o tarde
							String sala = salaInfo[j];
							String horario = horarioInfo[j];
							habilitarAsientos(sala,horario,filaEliminar,columnaEliminar,sala1M,sala1T,sala2M,sala2T,sala3M,sala3T);
							
						}
					}
					
					
				}
        	}
        	
        	//Total por entrada 
        	totalEntrada = pagoInfo[ePeli]/ entradasInfo[ePeli] ;
        	double descuento = totalEntrada* 0.20;
        	devolucionEntrada = totalEntrada - descuento;
        	Lsaldo[eRut] = Lsaldo[eRut] + devolucionEntrada;
        	StdOut.println("");
        	StdOut.println("Estimado/a "+ LnombreCliente[eRut]+Lapellido[eRut] +" por políticas de la empresa solo se devolverá el 80% del valor cancelado por cada entrada. ");
        	StdOut.println("Total : "+ totalEntrada);
        	StdOut.println("");        	
        	StdOut.println("Devolución total: "+ devolucionEntrada);
        	StdOut.println("Se ha abonado su saldo el total de la devolución. Ahora su nuevo saldo es $"+Lsaldo[eRut]);

        }

	}
	/**
	 * For each film you get the total amount collected and the amount raised throughout the day.
	 * @param cantPeliculas
	 * @param diaTotal
	 * @param nomPeli
	 * @param recaudacion
	 * @param recaudacionMañana
	 * @param recaudacionTarde
	 */
	
	public static void Taquilla(int cantPeliculas, double [] diaTotal, String [] nomPeli, double[] recaudacion, double [] recaudacionMañana, double [] recaudacionTarde) {
		StdOut.println("Montos recaudados por Pelicula: ");
		StdOut.println("......................................");
		
		for( int i = 0; i < cantPeliculas;i++) {
			StdOut.println("____________________________________________________");
        	StdOut.println("Pelicula: "+ nomPeli[i]);
        	StdOut.println("   - Monto recaudado total: $ " + recaudacion[i] );
        	StdOut.println("   - Monto total recaudado en el día: $ "+ diaTotal[i]);
        	StdOut.println("   - Monto total recaudado en la Mañana : $ "+recaudacionMañana[i]);
        	StdOut.println("   - Monto total recaudaddo en la Tarde : $ "+recaudacionTarde[i]);
        	StdOut.println("____________________________________________________");
        	StdOut.println("");
			
		}

	}
	
	
	/**
	 * For each film you get the total amount collected
	 * @param cantPeliculas
	 * @param nomPeli
	 * @param recaudacion
	 */
	public static void TaquillaSinCompra(int cantPeliculas, String [] nomPeli, double[] recaudacion) {
		StdOut.println("El día de hoy no se ha recaudado dinero ya que no se han realizado compras de entradas. ");
		StdOut.println("");
		
		StdOut.println("Montos recaudados por Pelicula: ");
		StdOut.println("......................................");
		
		for( int i = 0; i < cantPeliculas;i++) {
    		StdOut.println("____________________________");
        	StdOut.println("Pelicula: "+ nomPeli[i]);
        	StdOut.println("   - Monto recaudado total: $ " + recaudacion[i] );
        	StdOut.println("____________________________");
        	StdOut.println("");
			
		}

	}
	/**
	 * This applet ensures that a seat returns to the “enabled” state after a user has requested a refund.
	 * @param sala
	 * @param horario
	 * @param filaEliminar
	 * @param columnaEliminar
	 * @param sala1m
	 * @param sala1t
	 * @param sala2m
	 * @param sala2t
	 * @param sala3m
	 * @param sala3t
	 */
	
	private static void habilitarAsientos(String sala, String horario, String filaEliminar,
			int columnaEliminar, String[][] sala1m, String[][] sala1t, String[][] sala2m, String[][] sala2t, String[][] sala3m, String[][] sala3t) {
		int fila = trabajarFila(filaEliminar);
		
		if(sala.equals("1") && horario.equals("M")) 
		{
			sala1m[fila][columnaEliminar] = "0";
			System.out.println("sala: 1 horario M ,asiento fila: "+filaEliminar+" columna: "+columnaEliminar+" eliminado");
		}
		if(sala.equals("1") && horario.equals("T")) 
		{
			sala1t[fila][columnaEliminar] = "0";
			System.out.println("sala: 1 horario T ,asiento fila: "+filaEliminar+" columna: "+columnaEliminar+" eliminado");
		}
		if(sala.equals("2") && horario.equals("M")) 
		{
			sala2m[fila][columnaEliminar] = "0";
			System.out.println("sala: 2 horario M ,asiento fila: "+filaEliminar+" columna: "+columnaEliminar+" eliminado");
		}
		if(sala.equals("2") && horario.equals("T")) 
		{
			sala2t[fila][columnaEliminar] = "0";
			System.out.println("sala: 2 horario T ,asiento fila: "+filaEliminar+" columna: "+columnaEliminar+" eliminado");
		}
		if(sala.equals("3") && horario.equals("M")) 
		{
			sala3m[fila][columnaEliminar] = "0";
			System.out.println("sala: 3 horario M ,asiento fila: "+filaEliminar+" columna: "+columnaEliminar+" eliminado");
		}
		if(sala.equals("3") && horario.equals("T")) 
		{
			sala3t[fila][columnaEliminar] = "0";
			System.out.println("sala: 3 horario T ,asiento fila: "+filaEliminar+" columna: "+columnaEliminar+" eliminado");
		}
		
	}
	/**
	 * It is responsible for deciding which row to work depending on which letter of the alphabet was entered as a row
	 * @param filaEliminar
	 * @return
	 */

	private static int trabajarFila(String filaEliminar) {
		if(filaEliminar.equalsIgnoreCase("a")) 
		{
			return 1;
		}
		if(filaEliminar.equalsIgnoreCase("b")) 
		{
			return 2;
		}
		if(filaEliminar.equalsIgnoreCase("c")) 
		{
			return 3;
		}
		if(filaEliminar.equalsIgnoreCase("d")) 
		{
			return 4;
		}
		if(filaEliminar.equalsIgnoreCase("e")) 
		{
			return 5;
		}
		if(filaEliminar.equalsIgnoreCase("f")) 
		{
			return 6;
		}
		if(filaEliminar.equalsIgnoreCase("g")) 
		{
			return 7;
		}
		if(filaEliminar.equalsIgnoreCase("h")) 
		{
			return 8;
		}
		if(filaEliminar.equalsIgnoreCase("i")) 
		{
			return 9;
		}
		if(filaEliminar.equalsIgnoreCase("j")) 
		{
			return 10;
		}
		return 0;
	}
	/**
	 * This applet writes the updated data to clientes.txt
	 * @param contRut
	 * @param LnombreCliente
	 * @param Lapellido
	 * @param Lrut
	 * @param Lpass
	 * @param Lsaldo
	 * @throws IOException
	 */

	public static void guardarClientes(int contRut,String [] LnombreCliente, String [] Lapellido, String [] Lrut, String [] Lpass, double [] Lsaldo ) throws IOException {
		
		ArchivoSalida archivo = new ArchivoSalida ("clientes.txt");
		for(int i = 0; i < contRut; i++) {
			Registro registro = new Registro (5);
			registro.agregarCampo(LnombreCliente[i]);
			registro.agregarCampo(Lapellido[i]);
			registro.agregarCampo(Lrut[i]);
			registro.agregarCampo(Lpass[i]);
			registro.agregarCampo(Lsaldo[i]);
			
			archivo.writeRegistro(registro);
			
		}
		archivo.close();
	}
	/**
	 * This applet writes the updated data to status.txt
	 * @param contRut
	 * @param Lrut
	 * @param LpaseM
	 * @throws IOException
	 */
	
	public static void guardarStatus(int contRut,String [] Lrut, String [] LpaseM ) throws IOException {
		
		ArchivoSalida archivo = new ArchivoSalida ("status.txt");
		for(int i = 0; i < contRut; i++) {
			Registro registro = new Registro (2);
			registro.agregarCampo(Lrut[i]);
			registro.agregarCampo(LpaseM[i]);

			archivo.writeRegistro(registro);
			
		}
		archivo.close();
	}
	/**
	 * This applet writes the updated data to movies.txt
	 * @param contPelis
	 * @param nomPeli
	 * @param tipoPeli
	 * @param recaudacion
	 * @param listaSala
	 * @param listaHorario
	 * @param listaSalaSplitAux
	 * @param listaHorarioSplitAux
	 * @throws IOException
	 */
	
	public static void guardarPeliculas (int contPelis, String[] nomPeli, String[] tipoPeli, double[] recaudacion, String[] listaSala,String[] listaHorario, String[] listaSalaSplitAux, String[] listaHorarioSplitAux) throws IOException {

		ArchivoSalida archivo = new ArchivoSalida ("peliculas.txt");
		
		for(int i = 0; i < contPelis; i++) {
			int contline = 0;
			contline = listaSalaSplitAux.length+listaHorarioSplitAux.length;
			Registro registro = new Registro (3 + contline);
			registro.agregarCampo(nomPeli[i]);
			registro.agregarCampo(tipoPeli[i]);
			registro.agregarCampo(recaudacion[i]);
			String [] listilla = listaSala[i].split("");
			String [] horilla = listaHorario[i].split("");
			contline = listilla.length+horilla.length;
			
			for(int j = 0;j<contline/2;j++) 
		    {
				
				registro.agregarCampo(listilla[j]);
				registro.agregarCampo(horilla[j]);
			}
			
			

			archivo.writeRegistro(registro);
			
		}
		archivo.close();
	}
	
	
	public static void main(String[] args) throws IOException {
		String [] listaFilasCanceladas = new String[99];
		String [] listaColumnasCanceladas = new String[99];
		//Clientes
        String [] LnombreCliente = new String [9999];
        String [] Lapellido = new String [9999];
        String [] Lrut = new String [9999];
        String [] Lpass = new String [9999];
        double[] Lsaldo = new double [9999];
        
        //status
        String [] LpaseM = new String[9999];
        //peliculas
        String [] nomPeli = new String[999];
		String [] tipoPeli = new String[999];
		double [] recaudacion = new double[999];
		String [] listaSala = new String[99];
		String [] listaHorario = new String[99];
		for(int i = 0;i<listaSala.length;i++) 
		{
			listaSala[i] = "";
			listaHorario[i] = "";
		}
		//crear matrices
		String [][] sala1M = new String[12][32];
		String [][] sala1T = new String[12][32];
		String [][] sala2M = new String[12][32];
		String [][] sala2T = new String[12][32];
		String [][] sala3M = new String[12][32];
		String [][] sala3T = new String[12][32];
		
		int cantEntradasAux = 0;
		
		distanciamiento(sala1M,sala1T,sala2M,sala2T,sala3M,sala3T);
		
		
		//pagos
		double totalPago [] = new double [999];
		
		//infoUsuario
		String rutInfo [] = new String [999];
		int entradasInfo [] = new int [999];
		String peliculaInfo [] = new String [999];
		String salaInfo [] = new String [999];
		String horarioInfo [] = new String [999];		
		String asientoInfo [] = new String [999];
		double pagoInfo[] = new double [999];
		
		//Taquilla
		String peliculaRecaudacion [] = new String[999] ;
		double recaudacionTotal [] = new double[999];
		double diaTotal [] = new double[999];
		
		double recaudacionMañana [] = new double[999];
		double recaudacionTarde [] = new double[999];
		
		double rMañana = 0;
		double rTarde = 0;
		double recaudacionT = 0;
		
		boolean ingresa = false;
		
		String sala = "";
		String horario = "";
		String asiento2 = "";
		
		int contInfo = 0;
		
        
        //RF1 Leer los datos
        int contRut = leerClientes(LnombreCliente,Lapellido,Lrut,Lpass,Lsaldo);
        int contPase= leerStatus(Lrut,LpaseM);
        int cantPeliculas = leerPeliculas(nomPeli,tipoPeli,recaudacion,listaSala,listaHorario);
        String[] listaSalaSplitAux = new String[cantPeliculas];
        String[] listaHorarioSplitAux = new String[cantPeliculas];
        //crear matriz inventario
        int cantStuff = 4;//1)#entradas,2)horario,3)nombrePelicula,4)asientos,esto esta sujeto a cambios
        String [][] matrizInventario = matrizInventario(contRut,cantStuff);
        //fin RF1
        Scanner scanner = new Scanner(System.in);	
        
		//desplegarClientes(Lrut, LnombreCliente, Lapellido, Lpass, Lsaldo,contRut);
		//desplegarStatus(Lrut, LpaseM, contPase);
		
		String rut = "null";
		String opcion = "null";
		String clavePriv = "null";
		String pass = "null";
		
		boolean error = false;
		boolean taquilla = false;
		boolean devolucion = false;
		
		//Empieza  el menú principal
		while(!rut.equalsIgnoreCase("fin") && !clavePriv.equals("fin")&& !pass.equalsIgnoreCase("fin")){
            StdOut.println("Ingrese su rut <cerrar sesion = 'fin'>: ");
            rut = StdIn.readString();
            rut = rut.replace("-","").replace(".","").replace("_","");
            String rutDefecto = rut;
            
            if(rut.equalsIgnoreCase("ADMIN")){
                StdOut.println("Ingrese su contraseña: ");
                
                clavePriv = StdIn.readString();
                
                if (clavePriv.equals("ADMIN")) {
                    StdOut.println("______________________________________________________________________________");
                    StdOut.println("MENU ADMIN: ");
                    StdOut.println("");
                    StdOut.println("1) Taquilla. ");
                    StdOut.println("2) Información cliente. ");
                    StdOut.println("3) Salir. ");
                    StdOut.println("______________________________________________________________________________");
                    StdOut.println("");
                    StdOut.println("Ingrese una opción: ");
                    opcion = StdIn.readString();
                    
                    if (opcion.equalsIgnoreCase("1")) {
                    	
                    	if(taquilla == true)
                    	{
                    		Taquilla(cantPeliculas, diaTotal, nomPeli, recaudacion,recaudacionMañana,recaudacionTarde);

                    	}//si no a comprado nada que no deje entrar a esta opcion.
                    	
                    	else 
                    	{
                    		TaquillaSinCompra(cantPeliculas, nomPeli, recaudacion);
                    	}
                    	
                    	
                    }
                    
                    if (opcion.equalsIgnoreCase("2")) {
                    	StdOut.println("Información Cliente. ");
                    	StdOut.println("....................... ");
                    	
                    	StdOut.println("Ingrese el rut de un cliente: ");
                    	String rut1 = StdIn.readString();
                    	rut1 = rut1.replace("-","").replace(".", "");
                		int erut = 0;
                        while (erut < contRut && !Lrut[erut].equalsIgnoreCase(rut1)){
                            erut++;
                        }
                        
                        //si no se encuentra
                        if (erut == contRut){
                            while(erut == contRut){
                        		System.out.println("El rut ingresado no es válida");
                        		System.out.println("Ingrese el rut nuevamente: ");
                        		rut1 = StdIn.readString();
                        		rut1 = rut1.replace("-","").replace(".", "");
                                
                        		erut = 0;
                                while (erut < contRut && !Lrut[erut].equalsIgnoreCase(rut1)){
                                    erut++;
                                }
                            }
                        }
                        //si se encuentra
                        else {
                        	informacionUsuario(ingresa,erut,entradasInfo,contInfo,rutInfo,peliculaInfo,salaInfo,horarioInfo, asientoInfo,Lrut,LnombreCliente, Lapellido, Lsaldo,contRut);

                        	
                        }
                    	
                    	
                    }
                    
                    while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3") && !opcion.equals("4") ){
                        StdOut.print("La opción ingresada no es válida, por favor vuelva a intentarlo. ");
                        StdOut.println("Ingrese una opcion : ");
                        opcion=StdIn.readString();
                    }
                }
                //rut distinto de admin
                else {
                	   	
                    while(!clavePriv.equals("ADMIN") && !clavePriv.equalsIgnoreCase("fin")){
                    	StdOut.println("Contrasena invalida.: ");
                    	StdOut.println("Ingrese su contraseña <cerrar sesion = 'fin'>: ");
                        clavePriv = StdIn.readString();
                    }
                }

            }
            //Rut normal
            else { //otros ruts
            	String [] peliTemporal = new String[999];
            	            	
            	int eRut = 0;
                while (eRut < contRut && !Lrut[eRut].equalsIgnoreCase(rut)){
                    eRut++;
                }
                //rut no encontrado, registrar?
                //mod 22.09.2021
                if (eRut == contRut && !rut.equalsIgnoreCase("fin") ){
                	

                    StdOut.println("Rut no encontrado.");
                    StdOut.println("Desea registrarlo? <si - no: ");
                    String opcion2 = StdIn.readString();
                    
                    if (opcion2.equalsIgnoreCase("si")) {
                    	int [] vector = new int[2];
                    	registrarPersona(vector, rut, LnombreCliente, Lapellido, Lrut, Lpass, Lsaldo,contRut,contPase,LpaseM);
                    	
                    	contRut= vector[0];
                    	contPase = vector[1];
                    }
                    
                    if (opcion2.equalsIgnoreCase("no")) {
                    	
                     	while(eRut == contRut && !rut.equalsIgnoreCase("fin")){
                     		StdOut.println("Ingresar Rut < cerrar sesión = 'fin' >: ");
    						rut = StdIn.readString();
    						rut = rut.replace("-","").replace(".","").replace("_","");
                     	}
                    }

                    while (!opcion2.equalsIgnoreCase("si")&& !opcion2.equalsIgnoreCase("no")){
                        StdOut.print("La opción ingresada no es válida, por favor vuelva a intentarlo. ");
                        StdOut.println("Desea registrarlo? Ingresa una opción: ");
                        
                        opcion2=StdIn.readString();
                    }
                                  	
                }
                
                //Se encontró el rut
                if (eRut != contRut){
                	
                	StdOut.println("Ingresar contraseña;");
                	pass = StdIn.readString();
                    
                	StdOut.println("Verificando Contraseña... ");
                	//Se busca la contraseña
                	int ePass = 0;
                    while (ePass < contRut && !Lpass [ePass].equalsIgnoreCase(pass)){
                        ePass++;
                    }
                    
                    //si contraseña no se encuentra
                    
                    if (ePass != eRut){
                        
                        while(ePass != eRut && !pass.equalsIgnoreCase("fin")){
                            StdOut.println("La contraseña es incorrecta.");
                            StdOut.println("Ingrese la contraseña nuevamente <cerrar sesion = 'fin'> :");
                            pass = StdIn.readString();
                            ePass = 0;
                            while (ePass < contRut && !Lpass[ePass].equals(pass)){
                                ePass++;
                            }
                            
                        }    
                    }
                    //Si se encuentra la contraseña/ comienza el bloque a reparar
                    if(ePass == eRut) {
                    	
                    	//ciclo while para volver a entrar
                    	//condicion del while?
                    	do{
	                        StdOut.println("______________________________________________________________________________");
	                        StdOut.println("MENU CLIENTE: ");
	                        StdOut.println("");
	                        StdOut.println("1) Comprar entrada. ");
	                        StdOut.println("2) Información de Usuario. ");
	                        StdOut.println("3) Devolución de Entrada. ");
	                        StdOut.println("4) Cartelera. ");
	                        StdOut.println("5) Cerrar Sesión. ");
	                        StdOut.println("______________________________________________________________________________");
	                        StdOut.println("");
	                        StdOut.println("Ingrese una opción: ");
	                        opcion = StdIn.readString();
	                        
	                        StdOut.println("________________________________________");
	                        StdOut.println("");
	                        
	                        
	                        if (opcion.equalsIgnoreCase("1")) {
	                        	//a) comprar entradas
	                        	asiento2 = "";
	                        	System.out.println("Cartelera:");
	                        	System.out.println("....................");
	                        	
	                        	
	                        	StdOut.println("");
	                        	
	                        	for(int i = 0;i<cantPeliculas;i++) 
	                        	{
	                        		System.out.println(i+1+") "+nomPeli[i]);
	                        	}
	                        	System.out.println("");
	                        	
	                        	//declaracion de variables
	                        	String funcionOpcion = "";
	                        	String peliOpcion = "";
	                        	String cantEntradas ="";
	                        	String filaChoice = ""; //la fila que elige el usuario x entrada
	                        	String columnaChoice = "";//la columna que elige el usuario x entrada
	                        	String auxCancelarSala = "";
                    			String auxCancelarHorario = "";
                    			String auxSala="";
                    			String auxHorario="";
	                        	int contadorAux = 0;
	                        	//String [] listaFilasCanceladas = new String[Integer.parseInt(cantEntradas)];
                    			//String [] listaColumnasCanceladas = new String[Integer.parseInt(cantEntradas)];
	                        	System.out.println("Ingrese el nombre de la pelicula que desea ver: ");
	                        	System.out.println("");
	                        	peliOpcion = scanner.nextLine();
	                        	
	                            int ePeli = 0;
	                            while(ePeli < cantPeliculas && !nomPeli[ePeli].equals(peliOpcion)){
	                                ePeli++;
	                            }
	                            
	                            int eRecaudacion = 0;
	                            while(eRecaudacion < cantPeliculas && !nomPeli[eRecaudacion].equals(peliOpcion)){
	                                eRecaudacion++;
	                            }
	                            
	                            if (ePeli == cantPeliculas){
	                                while(ePeli == cantPeliculas){
		                        		System.out.println("La pelicula ingresada no es válida");
		                        		System.out.println("Ingrese el nombre de la pelicula nuevamente:: ");
	                                    peliOpcion = scanner.nextLine();
	                                    
	                                    ePeli = 0;
	                                    while(ePeli < cantPeliculas && !nomPeli[ePeli].equalsIgnoreCase(peliOpcion)){
	                                        ePeli++;
	                                    }
	                                }
	                            }
	                            
	                            

	                        	
	                        	while(contadorAux == 0) {

		                        	
									for(int j= 0;j<cantPeliculas;j++) 
		                        	{
		                        		
		                        		if(nomPeli[j].equals(peliOpcion)) 
		                        		{
		                        			//la pelicula ingresada existe
		                        			//desplegar salas y horarios
		                        			String line = listaSala[j];
		                        			String [] listaSalaSplit = line.split("");
		                        			listaSalaSplitAux = line.split("");
		                        			String line2 = listaHorario[j];
		                        			String [] listaHorarioSplit = line2.split("");
		                        			listaHorarioSplitAux = line2.split("");
		                        			System.out.println("Sala/s y Horario/s disponible/s de "+ "'"+ nomPeli[j]+ "' :");
		                        			
		                        			StdOut.println("Función: ");
		                        			StdOut.println("..........");
		                        			
		                        			
		                        			for(int k = 0;k<listaSalaSplit.length;k++) 
		                        			{
		                        				int kAux = k+1;
		                        				System.out.println(kAux +")" + "sala: "+listaSalaSplit[k]+", horario: "+listaHorarioSplit[k]);
		                        				
		                        			}
		                        			
		                        			System.out.println("");
		                        			
		                        			System.out.println("Seleccione la funcion que desea ver: ");		                        		
		                        			funcionOpcion = scanner.nextLine();
		                        			System.out.println("");
		                        			auxCancelarSala = listaSalaSplit[Integer.parseInt(funcionOpcion)-1];
	                        				auxCancelarHorario = listaHorarioSplit[Integer.parseInt(funcionOpcion)-1];
	                        				auxSala = listaSalaSplit[Integer.parseInt(funcionOpcion)-1];
		                        			auxHorario = listaHorarioSplit[Integer.parseInt(funcionOpcion)-1];
		                        			
		                        			String horarioSalaCompleto = "";
		                        			int funcionOptn2 = Integer.parseInt(funcionOpcion);
		                        			
		                        			for(int k = 0;k<listaSalaSplit.length;k++) 
		                        			{
		                        				int kAux2 = k+1;
		                        				
		                        				//System.out.println("funcion "+kAux2+") "+", sala: "+listaSalaSplit[k]+" ,horario: "+listaHorarioSplit[k]);
		                        				sala = listaSalaSplit[k] ;
		                        				
		                        				if (listaHorarioSplit[k].equalsIgnoreCase("M")) {
		                        					horario = "Mañana";      
		                        					
		                        				}
		                         				if (listaHorarioSplit[k].equalsIgnoreCase("T")) {
		                        					horario = "Tarde";            			
		                        					
		                        				}
		                        				
		                        				if(kAux2 == funcionOptn2) 
		                        				{
		                        					horarioSalaCompleto = "sala: "+listaSalaSplit[k]+" ,horario: "+listaHorarioSplit[k];
		                        					
		                        				}
		                        			}
		                        
		                        			//tener matrices de salas?
		                        			//desplegar asiento de la sala.
		                        			String [][] salaChoice = llamarSala(funcionOpcion,sala1M,sala1T,sala2M,sala2T,sala3M,sala3T,listaSalaSplit,listaHorarioSplit);
		                        			try {
			                        			System.out.println("Ingrese cantidad de entradas que desee comprar: ");
			                        			cantEntradas = scanner.nextLine();
			                        			cantEntradasAux = Integer.parseInt(cantEntradas);
			                        			//String [] listaFilasCanceladas = new String[Integer.parseInt(cantEntradas)];
			                        			//String [] listaColumnasCanceladas = new String[Integer.parseInt(cantEntradas)];
		                        				
		                        			}catch (Exception e){
		                        	            error = true;
		                        	            System.out.println("Error!. Ha ocurrido la siguiente excepción: " + "***"+e+"***");
		                        				
		                        			}

		                        			String cantAsientos = "";
		                        			
		                        			for(int k = 0;k<Integer.parseInt(cantEntradas);k++) 
		                        			{
		                        				//esto se repite por cantidad de entradas que desea comprar
		                        				//no puede comprar 2 veces el mismo asiento
		                        				//no puede comprar asientos retenidos por distanciamiento
		                        				
		                        				
			                        			System.out.println("Ingresar fila < A - J >:");
			                        			filaChoice = scanner.nextLine();
			                        			
			                                    while (!filaChoice.equalsIgnoreCase("A") && !filaChoice.equalsIgnoreCase("B") && !filaChoice.equalsIgnoreCase("C") && !filaChoice.equalsIgnoreCase("D") && !filaChoice.equalsIgnoreCase("E") && !filaChoice.equalsIgnoreCase("F") && !filaChoice.equalsIgnoreCase("G") && !filaChoice.equalsIgnoreCase("H") && !filaChoice.equalsIgnoreCase("I") && !filaChoice.equalsIgnoreCase("J") ){
			                                        StdOut.print("La opción ingresada no es válida, por favor vuelva a intentarlo. ");
			                                        StdOut.println("Ingrese una fila < A - J >: ");
			                                        filaChoice = scanner.nextLine();
			                                    }
			                                    
			                        			System.out.println("ingresar columna < 1 - 30 >: ");
			                        			columnaChoice = scanner.nextLine();
			                        			
			                                    while (!columnaChoice.equals("1") && !columnaChoice.equals("2") && !columnaChoice.equals("3") && !columnaChoice.equals("4") && !columnaChoice.equals("5") && !columnaChoice.equals("6") && !columnaChoice.equals("7") && !columnaChoice.equals("8") && !columnaChoice.equals("9") && !columnaChoice.equals("10") && !columnaChoice.equals("11") && !columnaChoice.equals("12") && !columnaChoice.equals("13") && !columnaChoice.equals("14") && !columnaChoice.equals("15") && !columnaChoice.equals("16") && !columnaChoice.equals("17") && !columnaChoice.equals("18") && !columnaChoice.equals("19") && !columnaChoice.equals("20") && !columnaChoice.equals("21") && !columnaChoice.equals("22") && !columnaChoice.equals("23") && !columnaChoice.equals("24") && !columnaChoice.equals("25") && !columnaChoice.equals("26") && !columnaChoice.equals("27") && !columnaChoice.equals("28") && !columnaChoice.equals("29") && !columnaChoice.equals("30")){
			                                        StdOut.print("La opción ingresada no es válida, por favor vuelva a intentarlo. ");
			                                        StdOut.println("Ingresar columna < 1 - 30 >: ");			                                        
			                                        columnaChoice = StdIn.readString();
			                                    }
			                        			
			                        			asiento2 += filaChoice +"-"+ columnaChoice+" "; 
			                        			System.out.println("El asiento seleccionado es válido, y se encuentra en Fila '"+filaChoice+"', Columna: '"+columnaChoice+"'");
			                        			
			                        			
			                        			
			                        			cantAsientos = encontrarIndiceFila(filaChoice,salaChoice,columnaChoice);
			                        			//System.out.println("cantEntradas: "+cantEntradas);
			                        			if(cantAsientos.equals("0"))
			                        			{
			                        				k = k-1;
			                        			}
			                        			
			                        			//listaFilasCanceladas[k] = filaChoice;
			                        			//listaColumnasCanceladas[k] = columnaChoice;
			                        			
		                        			}
		                        			//ingresarDatosMatriz(matrizInventario,Lrut,cantEntradas,horarioSalaCompleto,peliOpcion,filaChoice,columnaChoice,rutDefecto,contRut);
		                        			//System.out.println("verificamos que la matriz inventario este bien");
		                        			for(int i=0;i<matrizInventario.length;i++) 
		                    				{
		                    					for(int m=0;m<matrizInventario[i].length;m++) 
		                    					{
		                    						//System.out.print(matrizInventario[i][m]+ " ");
		                    						//nota:cambiar matriz de enteros por una de String
		                    						
		                    						
		                    					}
		                    					//System.out.println();
		                    				}//24.09.21
		                        			contadorAux = 1;
		                        			
		                        		}
		                        	}
		                        	
		                        	if (tipoPeli[ePeli].equalsIgnoreCase("liberada")) {
		                        		
		                        		if (LpaseM[eRut].equalsIgnoreCase("HABILITADO") ){
		                        			totalPago[eRut] = 4000 * cantEntradasAux;
		                        			double descuento = (totalPago[eRut] *0.15);
		                        			
		                        			totalPago[eRut] = totalPago[eRut] - descuento;
		                        			
		                        			StdOut.println("Se le ha realizado un descuento de 15% por contar con el pase de movilidad. ");
		                        			StdOut.println("Total: $"+ (totalPago[eRut]+descuento));
		                        			StdOut.println("Descuento: $"+descuento);
		                        			StdOut.println("");
		                        			StdOut.println("Total a pagar: $"+ totalPago[eRut]);
		                        			

		                        		}
		                        		else {
		                        			totalPago[eRut] = 4000 * cantEntradasAux;
		                        			StdOut.println("Total a pagar $"+totalPago[eRut]);
		                        			
		                        		}
		                        		
		                        	}
		                        	
		                        	if (tipoPeli[ePeli].equalsIgnoreCase("estreno")) {
		                        		
		                        		if (LpaseM[eRut].equalsIgnoreCase("HABILITADO") ){
		                        			totalPago[eRut] = 5500 * cantEntradasAux; 		
		                        			double descuento = (totalPago[eRut] *0.15);
		                        			
		                        			totalPago[eRut] = totalPago[eRut] - descuento;
		                        			
		                        			StdOut.println("Se le ha realizado un descuento de 15% por contar con el pase de movilidad. ");
		                        			StdOut.println("Total: $"+ (totalPago[eRut]+descuento));
		                        			StdOut.println("Descuento: $"+descuento);
		                        			StdOut.println("");
		                        			StdOut.println("Total a pagar: $"+ totalPago[eRut]);
		                        			
		                        		}
		                        		
		                        		else {
		                        			totalPago[eRut] = 5500 * cantEntradasAux;
		                        			StdOut.println("Total a pagar $"+totalPago[eRut]);
		                        			
		                        		}
		                        		
		                        	} // fin del if estreno
		                        	
		                        	String opcion2 = ""; //para la opcion de si desea realizar la compra 
		                        	
		                        	StdOut.println("¿Está seguro de realizar la compra? <si - no>: ");
		                        	opcion2 = StdIn.readString();
		                        	//si realiza la compra
		                        	
		                        	if(opcion2.equalsIgnoreCase("si")) {
		                        		taquilla = true;
		                        		devolucion = true; 
		                        		//saldo mayor al total
		                        		if (Lsaldo[eRut] > totalPago[eRut]) {
			                        		Lsaldo[eRut] = Lsaldo[eRut] - totalPago[eRut];
			                        		StdOut.println("Nuevo saldo: " + Lsaldo[eRut]);
		                        			
		                        		}
		                        		//saldo menor al total
		                        		else {
		                        			StdOut.println("Usted no tiene saldo suficiemte para realizar esta compra. ");
		                        			StdOut.println("Saldo: $" + Lsaldo[eRut]);
		                        			StdOut.println("");	
				                        				                        	
				                        	StdOut.println("¿Desea cargar su saldo? <si - no>: ");
				                        	String opcion3 = StdIn.readString();
				                        	//cargar saldo
				                        	
				                        	if (opcion3.equalsIgnoreCase("si")) {
				                        		StdOut.println("Ingrese la cantidad de saldo que desea cargar: ");	
				                        		double saldo = StdIn.readInt();
				                        		Lsaldo[eRut] = Lsaldo[eRut] + saldo ;
				                        		
				                        		StdOut.println("Su nuevo saldo es: $"+ Lsaldo[eRut]);

				                        		while(saldo < 0) {
				                        			StdOut.println("La cantidad ingresada no es válida. ");	
				                        			StdOut.println("Ingrese la cantidad de saldo que desea cargar: ");	
				                        			
				                        			saldo = StdIn.readInt();
				                        			
				                        		}
				                        		
				                        	}
				                        	//no carga saldo
				                        	if (opcion3.equalsIgnoreCase("no")) {
				                        		taquilla = false;
				                        		StdOut.println("Compra cancelada. ");	
				                        		
				                        	}
				                        	
				                        	while(!opcion3.equalsIgnoreCase("si" ) && !opcion3.equalsIgnoreCase("no")) {
				                        		StdOut.println("La opción ingresada no es válida. ");
				                        		StdOut.println("¿Desea cargar su saldo? <si - no>: ");
				                        		opcion3 = StdIn.readString();
				                        	}
		                        			
		                        		}
		                        		
		                        		//fuera
		                        		
		                        		rutInfo[contInfo] = rut;
		                        		entradasInfo[contInfo] = cantEntradasAux ;
		                        		peliculaInfo[contInfo] = nomPeli[ePeli];
		                        		salaInfo [contInfo] = auxSala;
		                        		horarioInfo [contInfo] = auxHorario ;		
		                        		asientoInfo [contInfo] = asiento2;
		                        		pagoInfo[contInfo] = totalPago[eRut];
		                        		
		                        		//Recaudacion listas
		                        		diaTotal [cantPeliculas] = recaudacionT;
		                        		recaudacionMañana [cantPeliculas] = rMañana;
		                        		recaudacionTarde [cantPeliculas] = rTarde;
		                        		
		                        		
		                        		
		                        		if (horario.equalsIgnoreCase("Mañana")) {
		                        			
		                        			rMañana = rMañana + totalPago[eRut];
		                        			
		                        			recaudacionMañana [ePeli] = rMañana;
		                        			
		                        		}
		                        		if (horario.equalsIgnoreCase("Tarde")) {
		                        			rTarde = rTarde + totalPago[eRut];
		                        			
		                        			recaudacionTarde [ePeli] = rTarde;
		                        			
		                        		}
		                        		
		                        		//totales
		                        		recaudacionT= recaudacionT + totalPago[eRut];
		                        		
		                        		recaudacion[ePeli] = recaudacion[ePeli] + totalPago[eRut];
		                        		diaTotal[ePeli] = recaudacionT;
		                        		ingresa = true;
		                        		
		                        		contInfo++;
		                        	}
		                        	
		                        	if(opcion2.equalsIgnoreCase("no")) {
		                        		//el asiento asignado debemos devolverlo a su estado original
		                        		//buscar la funcion
		                        		//buscar los asientos de dicha funcion
		                        		StdOut.println("Compra cancelada. ");
		                        		
		                        		devolucionAsientos(auxCancelarSala,auxCancelarHorario,listaFilasCanceladas,listaColumnasCanceladas,sala1M,sala1T,sala2M,sala2T,sala3M,sala3T,cantEntradasAux);
		                        	}
		                        	
		                        	while(!opcion2.equalsIgnoreCase("si" ) && !opcion2.equalsIgnoreCase("no")) {
		                        		StdOut.println("La opción ingresada no es válida. ");
		                        		StdOut.println("¿Está seguro de realizar la compra? <si - no>: ");
		                        		opcion2 = StdIn.readString();
		                        	}
		                        	
		                        	//si la pelicula no se encuentra
		                        	

		                   
	                        	}//end while

	                        }
	                        
	                        if (opcion.equalsIgnoreCase("2")) {
	                        	informacionUsuario(ingresa,eRut,entradasInfo,contInfo,rutInfo,peliculaInfo,salaInfo,horarioInfo, asientoInfo,Lrut,LnombreCliente, Lapellido, Lsaldo,contRut);	                        	
	                        }
	                        
	                        if (opcion.equalsIgnoreCase("3")) {
	                        	if(devolucion == true)
	                        	{
	                        		desplegarEntradas(eRut, entradasInfo,contInfo,rutInfo, peliculaInfo, salaInfo, horarioInfo, asientoInfo, Lrut,LnombreCliente, Lapellido,  Lsaldo,contRut);
		                        	devolucionEntrada(pagoInfo, eRut, entradasInfo,contInfo,rutInfo,peliculaInfo,salaInfo,horarioInfo, asientoInfo,Lrut, LnombreCliente, Lapellido, Lsaldo,contRut,cantEntradasAux,sala1M,sala1T,sala2M,sala2T,sala3M,sala3T);
	                        	}//si no a comprado nada que no deje entrar a esta opcion.
	                        	else 
	                        	{
	                        		System.out.println("usted no a comprado ninguna entrada,compre antes de querer reembolsar ");
	                        	}
	                        	
	                        	
	                        	//incompleto
	                        }
	                        
	                        if (opcion.equalsIgnoreCase("4")) {
	                        	
	                        	StdOut.println("*** Cartelera *** ");
	                        	StdOut.println("------------------------");
	                        	
	                        	for(int j= 0;j<cantPeliculas;j++) {
	                        		                        		
                        			String line = listaSala[j];
                        			String listaSalaSplit[] = line.split("");
                        			String line2 = listaHorario[j];
                        			String listaHorarioSplit[] = line2.split("");
                        			System.out.println(nomPeli[j]+ "' :");
                        			StdOut.println("");
                        			
                        			StdOut.println("Funciones: ");
                        			StdOut.println("..............");
                        			
                        			
                        			for(int k = 0;k<listaSalaSplit.length;k++) 
                        			{
                        				int kAux = k+1;
                        				System.out.println(kAux +")" + "sala: "+listaSalaSplit[k]+", horario: "+listaHorarioSplit[k]);
                        			}
                        			
                        			StdOut.println("_______________________________");
	                        		
	                        	}
	                        	
	                        }
	                     	
	                        while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3") && !opcion.equals("4") && !opcion.equals("5") ){
	                            StdOut.print("La opción ingresada no es válida, por favor vuelva a intentarlo. ");
	                            StdOut.println("Ingrese una opcion : ");
	                            opcion=StdIn.readString();
	                        }
                    	}while(!opcion.equals("5"));   
                    	
                    }//hasta aqui el bloque a reparar
                    
                }            	
            }

            
            System.out.println("Sesión finalizada. ");
            
		}// while
		
        guardarClientes(contRut,LnombreCliente, Lapellido, Lrut, Lpass, Lsaldo );
        guardarStatus(contRut,Lrut,LpaseM );
        guardarPeliculas (cantPeliculas, nomPeli,tipoPeli, recaudacion,listaSala,listaHorario,listaSalaSplitAux,listaHorarioSplitAux);
        
	} //Fin del MAIN
	/**
	 * Returns a seat to enabled mode, this by changing the status from 1: occupied to 0: unoccupied
	 * @param auxCancelarSala
	 * @param auxCancelarHorario
	 * @param listaFilasCanceladas
	 * @param listaColumnasCanceladas
	 * @param sala1M
	 * @param sala1T
	 * @param sala2M
	 * @param sala2T
	 * @param sala3M
	 * @param sala3T
	 * @param cantEntradasAux
	 */

	private static void devolucionAsientos(String auxCancelarSala, String auxCancelarHorario,
			String[] listaFilasCanceladas, String[] listaColumnasCanceladas, String[][] sala1M, String[][] sala1T, String[][] sala2M, String[][] sala2T, String[][] sala3M, String[][] sala3T, int cantEntradasAux) {
		String [] filasABC = trabajarAbcedario(listaFilasCanceladas,cantEntradasAux);
		
		
		if(auxCancelarSala.equals("1") && auxCancelarHorario.equals("M") ) 
		{
			for (int i = 0; i <cantEntradasAux ; i++) {
				sala1M[Integer.parseInt(filasABC[i])][Integer.parseInt(listaColumnasCanceladas[i])] = "0";
			}
			
		}
		if(auxCancelarSala.equals("1") && auxCancelarHorario.equals("T") ) 
		{
			for (int i = 0; i <cantEntradasAux ; i++) {
				sala1T[Integer.parseInt(filasABC[i])][Integer.parseInt(listaColumnasCanceladas[i])] = "0";
			}
			
		}
		if(auxCancelarSala.equals("2") && auxCancelarHorario.equals("M") ) 
		{
			for (int i = 0; i <cantEntradasAux ; i++) {
				sala2M[Integer.parseInt(filasABC[i])][Integer.parseInt(listaColumnasCanceladas[i])] = "0";
			}
		}
		if(auxCancelarSala.equals("2") && auxCancelarHorario.equals("T") ) 
		{
			for (int i = 0; i <cantEntradasAux ; i++) {
				sala2T[Integer.parseInt(filasABC[i])][Integer.parseInt(listaColumnasCanceladas[i])] = "0";
			}
		}
		if(auxCancelarSala.equals("3") && auxCancelarHorario.equals("M") ) 
		{
			for (int i = 0; i <cantEntradasAux ; i++) {
				sala3M[Integer.parseInt(filasABC[i])][Integer.parseInt(listaColumnasCanceladas[i])] = "0";
			}
			
		}
		if(auxCancelarSala.equals("3") && auxCancelarHorario.equals("T") ) 
		{
			for (int i = 0; i <cantEntradasAux ; i++) {
				sala3T[Integer.parseInt(filasABC[i])][Integer.parseInt(listaColumnasCanceladas[i])] = "0";
			}
			
		}
		
	}
	/**
	 * Decide which letter of the alphabet corresponds to which row number in the matrix of the rooms
	 * @param listaFilasCanceladas
	 * @param cantEntradasAux
	 * @return
	 */

	private static String[] trabajarAbcedario(String[] listaFilasCanceladas, int cantEntradasAux) {
		String [] filas = new String[cantEntradasAux];
		for (int i = 0; i < cantEntradasAux; i++) {
			if(listaFilasCanceladas[i].equalsIgnoreCase("a")) 
			{
				filas[i] = "1";
			}
			if(listaFilasCanceladas[i].equalsIgnoreCase("b")) 
			{
				filas[i] = "2";
			}
			if(listaFilasCanceladas[i].equalsIgnoreCase("c")) 
			{
				filas[i] = "3";
			}
			if(listaFilasCanceladas[i].equalsIgnoreCase("d")) 
			{
				filas[i] = "4";
			}
			if(listaFilasCanceladas[i].equalsIgnoreCase("e")) 
			{
				filas[i] = "5";
			}
			if(listaFilasCanceladas[i].equalsIgnoreCase("f")) 
			{
				filas[i] = "6";
			}
			if(listaFilasCanceladas[i].equalsIgnoreCase("g")) 
			{
				filas[i] = "7";
			}
			if(listaFilasCanceladas[i].equalsIgnoreCase("h")) 
			{
				filas[i] = "8";
			}
			if(listaFilasCanceladas[i].equalsIgnoreCase("i")) 
			{
				filas[i] = "9";
			}
			if(listaFilasCanceladas[i].equalsIgnoreCase("j")) 
			{
				filas[i] = "10";
			}
		}
		return filas;
	}

}// Fin de la app
