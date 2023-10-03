
import AccesoDatos.*;
import Entidades.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rober
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteData cd = new ClienteData();
        Cliente c1 = cd.buscarCliente(1);
        c1.setApellido("Martinez");
        c1.setNombre("Pablo");
        cd.modicifarCliente(c1);
    }

}
