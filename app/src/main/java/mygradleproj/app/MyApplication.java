package mygradleproj.app;


import mygradleproj.services.Service;

/**
 * Application main class.
 */
public class MyApplication {
   /**
   Main method for the application.
    @param args
    */
    public static void main(final String[] args) {


        Service service = new Service();
        service.printMessage();
    }

}
