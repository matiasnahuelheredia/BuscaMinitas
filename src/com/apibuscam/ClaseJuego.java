package apibuscam;

/**
 * 
 * @author Matias Nahuel Heredia
 * @author Diego Parra
 * @author Rodolfo Kidyba
 * @author Nicolas Vergara
 * @version 1.0 beta 
 */
public class ClaseJuego implements Ijugable{

	/**
	 * indica el numero de filas que tiene el tablero deb juego Buscaminas 
	 */
	int numeroDeFilas;
	/**
	 * indica el numero de columnas que tiene el tablero deb juego Buscaminas 
	 */
	int numeroDeColumnas;

	/**
	 * Contiene el tablero totalmente visible con las minas y numeros incluidos
	 * despues de usar el metodo tablero()
	 * @see #inicializar(int, int, int)
	 */
	char[][]tablero;
    /**
     * indica que parte del tablero es visible con una V
     * 
     */
	char[][]tableroDescubierto;
	/**
     * indica el nuemro de minas que va a tener el tablero
     *  
     */	
	int numeroMinas;



	/**
     * el metodo se encarga de ver si hay una mina en la posicion derecha
     * de las coordenadas x e y que se le ingresan
     * este metodo es interno a la clase
     * @param x ingresa la coordenada x
     * @param y ingresa la coordenada y
     * @param tablero se ingresa el tablero
     * @return true si existe una mina a la derecha y false si no hay una mina a la derecha
     */	
	private boolean hayMinaDerecha(char[][]tablero,int x,int y)

	{
		
		if (x==(tablero.length-1))
		
		{
		
			return false;
		
		}
		
		else
		
		{
			
			if(tablero[x+1][y]=='*')
			
			{ 
				return true;
			
			}
			
			else
			
			{
			 
				return false;
			
			}	

		
		}

	
	}

	/**
     * el metodo se encarga de ver si hay una mina en la posicion izquierda
     * de las coordenadas x e y que se le ingresan
     * este metodo es interno a la clase
     * @param x ingresa la coordenada x
     * @param y ingresa la coordenada y
     * @param tablero se ingresa el tablero
     * @return true si existe una mina a la izquierda y false si no hay una mina a la izquierda
     */	
	private boolean hayMinaIzquierda(char[][]tablero,int x,int y)//indica si hay una mina en la parte izquierda indicando en un principio las coordenadas x e y
	{
		
		if (x==0)
		
		{
		
			return false;
		
		}
		
		else
		
		{
			
			if(tablero[x-1][y]=='*')
			
			{ 
				return true;
			
			}
			
			else
			
			{
			 
				return false;
			
			}	

		
		}

	
	}
	

	/**
     * el metodo se encarga de ver si hay una mina en la posicion arriba
     * de las coordenadas x e y que se le ingresan
     * este metodo es interno a la clase
     * @param x ingresa la coordenada x
     * @param y ingresa la coordenada y
     * @param tablero se ingresa el tablero
     * @return true si existe una mina a la arriba y false si no hay una mina arriba
     */	
	private boolean hayMinaArriba(char[][]tablero,int x,int y)//indica si hay una mina en la parte de superior indicando en un principio las coordenadas x e y
	{
		
		if (y==0)
		
		{
		
			return false;
		
		}
		
		else
		
		{
			
			if(tablero[x][y-1]=='*')
			
			{ tablero();
				return true;
			
			}
			
			else
			
			{
			 
				return false;
			
			}	

		
		}

	
	}
	

	/**
     * el metodo se encarga de ver si hay una mina en la posicion de abajo
     * de las coordenadas x e y que se le ingresan
     * este metodo es interno a la clase
     * @param x ingresa la coordenada x
     * @param y ingresa la coordenada y
     * @param tablero se ingresa el tablero
     * @return true si existe una mina abajo y false si no hay una mina abajo
     */	

	private boolean hayMinaAbajo(char[][]tablero,int x,int y)//indica si hay una mina en la parte inferior indicando en un principio las coordenadas x e y
	{
		
		if (y==(tablero[0].length-1))
		
		{
		
			return false;
		
		}
		
		else
		{
			
			if(tablero[x][y+1]=='*')
			
			{ 
				return true;
			
			}
			
			else
			
			{
			 
				return false;
			
			}	

		
		}

	
	}
	/**
     * el metodo se encarga de ver si hay una mina en la posicion Abajo derecha
     * de las coordenadas x e y que se le ingresan
     * este metodo es interno a la clase
     * @param x ingresa la coordenada x
     * @param y ingresa la coordenada y
     * @param tablero se ingresa el tablero
     * @return true si existe una mina a la Derecha Inferior y false si no hay una mina a la derecha Inferior
     */	

	private boolean hayMinaAbajoDer(char[][]tablero,int x,int y)//indica si hay una mina en la parte inferior derecha indicando en un principio las coordenadas x e y
	{
		
		if ((y==(tablero[0].length-1))||(x==(tablero.length-1)))
		
		{
		
			return false;
		
		}
		
		else
		
		{
			
			if(tablero[x+1][y+1]=='*')
			
			{ 
				return true;
			
			}
			
			else
			
			{
			 
				return false;
			
			}	

		
		}

	
	}
	/**
     * el metodo se encarga de ver si hay una mina en la posicion abajo izquierda
     * de las coordenadas x e y que se le ingresan
     * este metodo es interno a la clase
     * @param x ingresa la coordenada x
     * @param y ingresa la coordenada y
     * @param tablero se ingresa el tablero
     * @return true si existe una mina inferior izquierda y false si no hay una mina a la inferior izquierda
     */	
	

	private boolean hayMinaAbajoIzq(char[][]tablero,int x,int y)//indica si hay una mina en la parte inferior izquierda indicando en un principio las coordenadas x e y

	{
		
		if ((y==(tablero[0].length-1))||(x==0))
		
		{
		
			return false;
		
		}
		
		else
		
		{
			
			if(tablero[x-1][y+1]=='*')
			
			{ 
				return true;
			
			}
			
			else
			
			{
			 
				return false;
			
			}	

		
		}

	
	}

	/**
     * el metodo se encarga de ver si hay una mina en la posicion superior izquierda
     * de las coordenadas x e y que se le ingresan
     * este metodo es interno a la clase
     * @param x ingresa la coordenada x
     * @param y ingresa la coordenada y
     * @param tablero se ingresa el tablero
     * @return true si existe una mina superior izquierda y false si no hay una mina a la superior izquierda
     */	
	
	private boolean hayMinaArribaIzq(char[][]tablero,int x,int y)//indica si hay una mina en la parte superior izquierda indicando en un principio las coordenadas x e y

	{
		
		if ((y==0)||(x==0))
		
		{
		
			return false;
		
		}
		
		else
		
		{
			
			if(tablero[x-1][y-1]=='*')
			
			{ 
				return true;
			
			}
			
			else
			
			{
			 
				return false;
			
			}	

		
		}

	
	}

	/**
     * el metodo se encarga de ver si hay una mina en la posicion superior derecha
     * de las coordenadas x e y que se le ingresan
     * este metodo es interno a la clase
     * @param x ingresa la coordenada x
     * @param y ingresa la coordenada y
     * @param tablero se ingresa el tablero
     * @return true si existe una mina en la posicion superior derecha y false si no hay una mina en la posicion superior derecha
     */	
	

	private boolean hayMinaArribaDer(char[][]tablero,int x,int y)//indica si hay una mina en la parte superior derecha indicando en un principio las coordenadas x e y

	{
		
		if (y==0||(x==tablero.length-1))
		
		{
		
			return false;
		
		}
		
		else
		
		{
			
			if(tablero[x+1][y-1]=='*')
			
			{ 
				return true;
			
			}
			
			else
			
			{
			 
				return false;
			
			}	

		
		}

	
	}
	

	/**
     * agrega ceros en los lugares que no hay minas para la inicializacion
     * este metodo es interno a la clase y es usado para agregar ceros en los lugares del tablero
     * que no existen minas
     *  se usa internamente en el metodo inicializar
     *  @see #inicializar(int, int, int)
     */	
	private char[][] agregarCeros()

	{
	
		int cantColumnas= this.tablero.length;
	
		int cantFilas = this.tablero[0].length;
	
		char[][] arr = new char[cantColumnas][cantFilas];
	
		
		for (int y=0;y<cantFilas;y++)
		
		{
			
			for(int x=0; x<cantColumnas;x++)
			
			{
			 	
				if (this.tablero[x][y]=='*')//agrega un cero si no existe una mina y si existe una mina la deja en su lugar
			 	{			    
				
					arr[x][y]='*';
			 	
				}
			 
				else
			 	
				{				

					arr[x][y]='0';
			  
				}
			
			}
		
		}
	
		return arr;
	
	}
	
	/**
     * agrega las minas en el tablero que se requieran
     * este metodo es interno a la clase 
     * y es usado para agregar minas en el tablero
     *  se usa internamente en el metodo inicializar
     *  es utilizado por el metodo inicializar
     *  @return regresa una matriz de tipo char que contiene un tablero con minas
     *  @see #inicializar(int, int, int)
     */	

	private char[][] agregarMinasAlTablero(int cantColumnas,int cantFilas,int cantMinas)// agrega una cantidad de minas al tablero en forma aleatoria //add random mines to array
	{
	
		char[][] arr = new char[cantColumnas][cantFilas];
	
		int x=0;
	
		int y=0;	
	
		int count = 0;//contador para la cantidad de minas //mines count

		while (count<cantMinas)
		
		{		
		
			x=(int) Math.round(Math.random()*(cantColumnas-1));
		
			y=(int) Math.round(Math.random()*(cantFilas-1));
		
	
		if (arr[x][y]!='*')//para que no caigan las minas en un mismo lugar  this is so that the mines don't stay at the same time
	
		{
		
				arr[x][y]='*';
		
				count++;
		
			}


		
		}
	
		return arr;
	
	}
	
	/**
     * este metodo es interno a la clase 
     * y es usado para inicializar la propiedad tableroDescubierto
     *  se usa internamente en el metodo inicializar
     *  @see #inicializar(int, int, int)
     *  @param nroColumnas cantidad de columnas del tablero
     *  @param nroFilas cantidad de filas del tablero
     */	

	
	private void iniciarTableroDescubierto(int nroColumnas,int  nroFilas)

	{
	
		char[][] tab = new char[nroColumnas][nroFilas] ;
		
		for (int y=0;y<nroFilas;y++)
		
		{
			
			for (int x=0;x<nroColumnas;x++)
			
			{
			
				tab[x][y]='N';//N es no visible V es visible
			      			  //N is not visible V is visible
			
			} 
		
		}	

	
		this.tableroDescubierto= tab;
	
	}	
	/**
     * este metodo es interno a la clase 
     * y es usado para inicializar la propiedad tablero
     * una vez utilizado los metodos agregarMinasAlTablero y
     * agregarCeros 
     *  se usa internamente en el metodo inicializar
     *  y utiliza los metodos para preguntar si hay una mina en una determinada posicion
     *  ej HayMinaAbajo,hayMinaArriba,etc
     *
     * @see #agregarMinasAlTablero(int, int, int)
     * @see #agregarCeros()
     *  @see #inicializar(int, int, int)
     *  @see #hayMinaAbajo(char[][], int, int)
     *  @see #hayMinaAbajoDer(char[][], int, int)
     *  @see #hayMinaAbajoIzq(char[][], int, int)
     *  @see #hayMinaArriba(char[][], int, int)
     *  @see #hayMinaArribaDer(char[][], int, int)
     *  @see #hayMinaArribaIzq(char[][], int, int)
     *  @see #hayMinaDerecha(char[][], int, int)
     *  @see #hayMinaIzquierda(char[][], int, int)
     */	
	
	private void inicializarNumeros ()//inicializa los numeros que no son minas
	{
	
		int cantColumnas= this.tablero.length;
	
		int cantFilas = this.tablero[0].length;
	
		for (int y=0;y<cantFilas;y++)
	
		{
		
			for (int x=0;x<cantColumnas;x++)
		
			{
			
				if (this.tablero[x][y]!='*')
			
				{	
				
					if(hayMinaDerecha(tablero,x,y))
				
					{
				
						this.tablero[x][y]=(char)(((int)this.tablero[x][y]) +1);
								}
				
					if(hayMinaIzquierda(tablero,x,y))
				
					{
				
						this.tablero[x][y]=(char)(((int)this.tablero[x][y]) +1);
								}
				
					if(hayMinaArriba(tablero,x,y))
				
					{
				
						this.tablero[x][y]=(char)(((int)this.tablero[x][y]) +1);
								}
				
					if(hayMinaAbajo(tablero,x,y))
				
					{
				
						this.tablero[x][y]=(char)(((int)this.tablero[x][y]) +1);
								}
				
					if(hayMinaAbajoDer(tablero,x,y))
				
					{
				
						this.tablero[x][y]=(char)(((int)this.tablero[x][y]) +1);
								}
				
					if(hayMinaAbajoIzq(tablero,x,y))
				
					{
				
						this.tablero[x][y]=(char)(((int)this.tablero[x][y]) +1);
								}
				
					if(hayMinaArribaDer(tablero,x,y))
				
					{
				
						this.tablero[x][y]=(char)(((int)this.tablero[x][y]) +1);
								}
				
					if(hayMinaArribaIzq(tablero,x,y))
				
					{
				
						this.tablero[x][y]=(char)(((int)this.tablero[x][y]) +1);
								}
			
				}
			
		
			}
	
		}


	
	}

	/**
	 *  inicializa el tablero del juego ingresando el numero de columnas
	 *  numero de filas y la cantidad de minas que va a tener el tablero
	 *  el numero de columnas debe ser mayor a 4 menor a 30
	 *  el numero de filas debe ser mayor a 4 menor a 30
	 *  el numero de minas debe ser menor al 30% y mayor al 10% del total de filas por columnas
	 *  utiliza los metodos  iniciarTableroDescubierto(nroColumnas,nroFilas);
	 *  inicializarNumeros (); y agregarCeros(); agregarMinasAlTablero(nroColumnas,nroFilas,nroMinas)
	 * @see #iniciarTableroDescubierto(int, int)
	 * @see #inicializarNumeros()
	 * @see #agregarCeros()
	 * @see #agregarMinasAlTablero(int, int, int)
	 * @param nroColumnas cantidad de columnas del tablero
	 * @param nroFilas cantidad de filas del tablero
	 * @param nroMinas cantidad de minas que posee el tablero
	 * @return regresa falso si no se pudo inicializar y true  si se inicializo correctamente
	 */
	public boolean inicializar(int nroColumnas,int nroFilas, int nroMinas)//inicializa el tablero
	{
	    
	    boolean valida= false;
	    
	    int celdas = nroColumnas * nroFilas;
	    int valormin = (int) Math.round(celdas*0.10);
	    int valormax = (int) Math.round(celdas*0.30);
		if (nroColumnas>3 && nroColumnas<31 && nroFilas>3 && nroFilas<31 && nroMinas> valormin && nroMinas<valormax)
		{
				this.tablero = agregarMinasAlTablero(nroColumnas,nroFilas,nroMinas);
				
				this.numeroMinas = nroMinas;
	
				this.numeroDeFilas= nroFilas;
	
				this.numeroDeColumnas = nroColumnas;
	
				this.tablero = agregarCeros();
	
				iniciarTableroDescubierto(nroColumnas,nroFilas);
	
				inicializarNumeros ();
				
				valida= true;
		}
		
		return valida;
	
	}
	/**
	 *     
	 * @return Regresa el tablero que se va a mostrar en la pantalla
	 */
	public char[][] tablero()
	
	{
		
		char[][] arraytab = new char[this.tablero.length][this.tablero[0].length] ;
			for (int y=0; y<this.tablero[0].length;y++)	

			{
			
				for (int x=0;x<this.tablero.length;x++)
			
				{
				
					if (tableroDescubierto[x][y]=='V')
				
					{			
				
						arraytab[x][y] = this.tablero[x][y];
				
					}
				
					else
				
					{
						if (tableroDescubierto[x][y]=='B')
							
						{			
					
							arraytab[x][y] = 'B';
					
						}
						else
						{
						arraytab[x][y] = '+';
						}
					}
			
				}
        	  
			}
		return arraytab;
		
	}
	/**
	 * este metodo se encarga de poner todo el tablero visible
	 */
	private void visibilizarTableroDescubierto()//visibilisa todo el tablero este metodo se implementa cuando perdes
	{
	
		
		for (int y=0;y<this.tableroDescubierto[0].length;y++)
		
		{
			
			for (int x=0;x<this.tableroDescubierto.length;x++)
			
			{
			
				this.tableroDescubierto[x][y]='V';
				//N es no visible V es visible
                //N is not visible V is visible
			} 
		
		}	

	
	}
	/**
     * en el buscaminas al hacer click  genera se una cordenada x e y
     * el metodo se encarga de generar un disparo a partir de estas cordenadas
     * y abrir el tablero y de decir si se pudo o no realizar correctamente el disparo 
     * existen dos tipos de disparos el de bandera que se indica con un false
     * y pone una bandera para que si se indica esa cordenada posteriormente
     * no se pierda el juego ya que en ese lugar anteriormente se
     * indico que hay una mina
     * si se hace 2 disparos de bandera continuos se eliminara la bandera
     * y el disparo comun descubre una o varias casillas dependiendo si toca un numero cero o no 
     
     * @param columna cordenada x 
     * @param fila cordenada y
     * @param tipoDisparo false si se desea colocar o sacar una bandera y true si se desea realizar un disparo normal 
     * @return regresa si se efectuo correctamente el disparo
     */
	public boolean disparo(int columna, int fila, boolean tipoDisparo) //descubre una o varias casillas dependiendo si toca un numero cero o no 
    														//y devuelve verdadero si en las cordenadas habia una mina
	{
		boolean tocoMina = false ;
		
			
		if ( tipoDisparo == true )//disparo directo si casilla es no visible
		{
				if ( tableroDescubierto [ columna ][ fila ]=='N')// si la casilla es no visible
				{
					if ( tablero [ columna ][ fila ]=='*')// se fija si es una mina
					{
						tableroDescubierto [ columna ][ fila ]='V';
						visibilizarTableroDescubierto ();
						tocoMina = true ;
					}
					else
					{
						if ( tablero [ columna ][ fila ]!='0')// tomamos que si es un numero distinto de cero entonces es el caso base
						{
							tableroDescubierto [ columna ][ fila ]='V';
						}
						else
						{
							tableroDescubierto [ columna ][ fila ]='V';
							if ( fila != this . tablero [ 0 ]. length - 1 )// recorre hacia abajo si toca un cero hasta dar con un numero  
								// y no se sale de el maximo de filas del tablero ( this . tablero [ 0 ]. length - 1 )
							{
								disparo ( columna , fila + 1 , true );
							}
							if ( fila != 0 )// recorre hacia arriba si toca un cero hasta dar con un numero
							{
								disparo ( columna , fila - 1 , true );
							}
							if ( columna != this . tablero . length - 1 )// recorre hacia derecha si toca un cero hasta dar con un numero
							{
								disparo ( columna + 1 , fila , true );
							}
							if ( columna != 0 )// recorre hacia izquierda si toca un cero hasta dar con un numero
							{
								disparo ( columna - 1 , fila , true );
							}
							if (( columna != 0 )&&( fila != 0 ))// recorre hacia izquierda superior si toca un cero hasta dar con un numero
							{
								disparo ( columna - 1 , fila - 1 , true );
							}
							if (( columna != this . tablero . length - 1 )&&( fila != 0 ))// recorre hacia derecha superior si toca un cero hasta dar con un numero
							{
								disparo ( columna + 1 , fila - 1 , true );
							}
							if (( columna != 0 )&&( fila != this . tablero [ 0 ]. length - 1 ))// recorre hacia derecha inferior si toca un cero hasta dar con un numero
							{
								disparo ( columna - 1 , fila + 1 , true );
							}
							if (( columna != this . tablero . length - 1 )&&( fila != 0 ))// recorre hacia izquierda inferior si toca un cero hasta dar con un numero
							{
								disparo ( columna + 1 , fila - 1 , true );
							}


						}

					}
				}
				
			
			
		}
		else
		{
			if (( tableroDescubierto [ columna ][ fila ]!='B')&&(tableroDescubierto [ columna ][ fila ]!='V'))
			{
				System.out.println("pone bandera");
			tableroDescubierto [ columna ][ fila ]='B';
			}
			else
			{
				if (( tableroDescubierto [ columna ][ fila ]=='B'))
						{
						tableroDescubierto [ columna ][ fila ]='N';
						}
			}
		}
		return tocoMina;
	}	

	/**
	 * Regresa si se gano el juego o no
	 * @return Regresa si se gano el juego o no
	 */
	public boolean finalizar()
	{
		int count=0;
		for (int y=0;y<this.numeroDeColumnas;y++)
		{
			for (int x=0;x<this.numeroDeFilas;x++)
			{
				if (tableroDescubierto[x][y]=='N' || tableroDescubierto[x][y]=='B')
				{
					count++;
				}
			}
		}
		if (numeroMinas==count)
		{
		return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	
	
}
