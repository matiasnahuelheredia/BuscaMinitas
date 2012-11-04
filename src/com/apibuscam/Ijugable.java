
package apibuscam;
/**
 * 
 * @author Matias Nahuel Heredia
 * @author Diego Parra
 * @author Rodolfo Kidyba
 * @author Nicolas Vergara
 * @version 1.0 beta 
 */
public interface Ijugable

{
	/**
	 *  inicializa el tablero del juego ingresando el numero de columnas
	 *  numero de filas y la cantidad de minas que va a tener el tablero
	 *  el numero de columnas debe ser mayor a 4 menor a 30
	 *  el numero de filas debe ser mayor a 4 menor a 30
	 *  el numero de minas debe ser menor al 30% y mayor al 10% del total de filas por columnas 
	 * @param nroColumnas cantidad de columnas del tablero
	 * @param nroFilas cantidad de filas del tablero
	 * @param nroMinas cantidad de minas que posee el tablero
	 * @return regresa falso si no se pudo inicializar y true  si se inicializo correctamente
	 */
	public abstract boolean inicializar( int nroColumnas,int nroFilas, int nroMinas);
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
	public abstract boolean disparo(int columna, int fila, boolean tipoDisparo);	
	/**
	 *     
	 * @return Regresa el tablero que se va a mostrar en la pantalla
	 */
	public abstract char[][] tablero();
	/**
	 * 
	 * @return Regresa si se gano el juego o no
	 */
	public abstract boolean finalizar();
}
