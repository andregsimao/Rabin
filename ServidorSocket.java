/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rabin;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Andre Simao
 */
public class ServidorSocket {
    
    String Mensagem, N = "10";
    String IPclient, IPserver, porta;
    ServerSocket servidor;
    boolean conectou=false;
    ServerSocket server;
    Socket cliente;    
    boolean encrypt=false;
    public ServidorSocket()    {
       
    }
    public boolean isConnected()
    {
        return conectou;
    }
    public void setEncrypt(boolean con)
    {
        encrypt=con;
    }   
    /*public long getN()
    {
        return ;
    }    
    */
    public void setConnection(boolean con)
    {
        conectou=con;
    }
    public void configurarConexao()throws UnknownHostException, IOException
    {
        // Campo para exibir IPserver e porta
        IPserver = InetAddress.getLocalHost().getHostAddress();
        porta = "7777";        
        server = new ServerSocket(Integer.parseInt(porta));        
        // DetecÃ§Ã£o de nova requisiÃ§Ã£o do cliente.
        cliente=null;
        while (cliente==null) 
        {
            cliente = server.accept();
            IPclient = cliente.getLocalAddress().getHostAddress();
        }
        System.out.println("Conectou!");
    }
    public void configurarSaida(String codigo) throws IOException
    {
        PrintStream saida = new PrintStream(cliente.getOutputStream());  
        saida.println(codigo);  
    }
}
