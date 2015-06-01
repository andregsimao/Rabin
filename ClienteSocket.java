/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rabin;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Andre Simao
 */
public class ClienteSocket {
    String Mensagem, N = "10";
    String IPclient, IPserver, porta;
    Socket cliente;
    static boolean codigorecepted=false;
    static boolean conectou=false;
    boolean sendKey=false;
    boolean translate=false;
    public ClienteSocket()
    {
        
    }
    public void setConnection(boolean con)
    {
        conectou=con;
    }
    public void setSendKey(boolean con)
    {
        sendKey=con;
    }
    
    public void setTranslate(boolean con)
    {
        translate=con;
    }
    public void sendN()
    {
        
    }
    public boolean isconnected()
    {
        return conectou;
    }
    public String receberMensagemPelaConexao()throws UnknownHostException, IOException 
    {
        // Realiza a leitura da mensagem
            Scanner s;
            s = new Scanner(cliente.getInputStream());
            Mensagem = s.nextLine();
            //System.out.println(Mensagem); 
            codigorecepted=true;
            return Mensagem;                   
    }    
    public boolean codeRecepted()
    {
        return codigorecepted;
    }
    public void configurarConexao() throws IOException
    {
        IPserver = "192.168.0.108";
        porta = "7777";
        IPclient = InetAddress.getLocalHost().getHostAddress();        
        // Conexão ao servidor
        cliente = new Socket(IPserver, Integer.parseInt(porta));
    }
    
}
