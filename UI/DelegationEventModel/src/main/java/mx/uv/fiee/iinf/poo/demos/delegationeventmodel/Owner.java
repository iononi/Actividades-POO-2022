package mx.uv.fiee.iinf.poo.demos.delegationeventmodel;

/***
 * 
 * Esta clase hace uso de un objeto de tipo EventSource e invoca su método start, así mismo para ser
 * capaz de recibir las 'notificaciones' del proceso finalizado implementa el método requerido por la interfaz
 * TaskFinalized
 * 
 */
public class Owner /*implements TaskFinalized*/ {

    public Owner () {       
        System.out.println ("Long Process started!");
        new EventSource (() -> System.out.println ("Received inside lambda - Process Finished!")).start ();
    }
    
    /***
     * método abstracto requerido por la interfaz implementada
     */
//    @Override
//    public void notificate () {
//        System.out.println ("Long Process Finished!");
//    }
    
    public static void main (String [] args) {
        new Owner ();
    }
}