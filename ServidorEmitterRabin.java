package Rabin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServidorEmitterRabin extends javax.swing.JFrame implements ActionListener{     
    boolean goodChoiseOfXandY;
    int numDigRedundant;
    long n;
    long codigoPassado[];
    String Mensagem;
    String IPclient, IPserver, porta;
    Socket cliente;
    String codigoPassadoConcatenado;
    int MAXMESSAGESIZE;
    boolean ambiguous;
    ServidorSocket server=new ServidorSocket();
    ChangeCharInt change=new ChangeCharInt();
    public ServidorEmitterRabin() {
        initComponents();   
        
        setSize(925, 610);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        bitsRedundantsField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageEmittedArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        messageReceivedArea1 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        timeEncryptField = new javax.swing.JTextField();
        encryptButton = new javax.swing.JButton();
        statusMessageLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        statusMessageMaxLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        maxMessageSizeField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        backGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("n:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 70, 100, 40);

        bitsRedundantsField.setText("Default: 4 digits");
        getContentPane().add(bitsRedundantsField);
        bitsRedundantsField.setBounds(250, 450, 110, 30);

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Public Key:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 20, 150, 40);

        jLabel9.setBackground(new java.awt.Color(102, 102, 102));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Number of redundant bits:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 450, 230, 30);

        nField.setEnabled(false);
        getContentPane().add(nField);
        nField.setBounds(80, 70, 340, 40);

        jLabel11.setBackground(new java.awt.Color(102, 102, 102));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Message to emit");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(110, 120, 180, 40);

        messageEmittedArea.setColumns(20);
        messageEmittedArea.setRows(5);
        jScrollPane2.setViewportView(messageEmittedArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 160, 390, 220);

        messageReceivedArea1.setColumns(20);
        messageReceivedArea1.setRows(5);
        messageReceivedArea1.setEnabled(false);
        jScrollPane3.setViewportView(messageReceivedArea1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(470, 140, 420, 370);

        jLabel13.setBackground(new java.awt.Color(102, 102, 102));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Message passed to receptor ");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(530, 60, 300, 40);

        jLabel15.setBackground(new java.awt.Color(102, 102, 102));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Time to encrypht: ");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(530, 510, 170, 40);

        timeEncryptField.setEnabled(false);
        getContentPane().add(timeEncryptField);
        timeEncryptField.setBounds(710, 520, 100, 30);

        encryptButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        encryptButton.setForeground(new java.awt.Color(0, 0, 255));
        encryptButton.setText("Encrypt!");
        encryptButton.addActionListener(this);
        getContentPane().add(encryptButton);
        encryptButton.setBounds(10, 410, 160, 40);

        statusMessageLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        statusMessageLabel.setForeground(new java.awt.Color(255, 0, 0));
        statusMessageLabel.setText("status");
        getContentPane().add(statusMessageLabel);
        statusMessageLabel.setBounds(10, 390, 390, 20);

        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(204, 204, 204));
        statusLabel.setText("status bits redundants");
        getContentPane().add(statusLabel);
        statusLabel.setBounds(10, 480, 390, 20);

        statusMessageMaxLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        statusMessageMaxLabel.setForeground(new java.awt.Color(204, 204, 204));
        statusMessageMaxLabel.setText("message size status");
        getContentPane().add(statusMessageMaxLabel);
        statusMessageMaxLabel.setBounds(10, 540, 430, 20);

        jLabel16.setBackground(new java.awt.Color(102, 102, 102));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Maximum message size");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(10, 510, 220, 30);

        maxMessageSizeField.setText("Default: 10000 chars");
        getContentPane().add(maxMessageSizeField);
        maxMessageSizeField.setBounds(250, 510, 110, 30);

        connectButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        connectButton.setForeground(new java.awt.Color(0, 0, 255));
        connectButton.setText("Connect");
        connectButton.addActionListener(this);
        getContentPane().add(connectButton);
        connectButton.setBounds(220, 400, 120, 37);

        backGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rabin/cryptographyBackGround2.png"))); // NOI18N
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 920, 570);

        pack();
    }// </editor-fold>                                                                                              
    int numDig(long currentNum)
    {
        int numDig;
        for(numDig=0;currentNum>0;numDig++)
        {
            currentNum/=10;
        }
        if(numDig==0)
            return 1;
        else
            return numDig;
    }
    public String[] binaryOfInteger(long integer[])
    {       
        String binaryOfInteger[]=new String[integer.length];
        for(int i=0;i<integer.length;i++)
        {
            binaryOfInteger[i]=Long.toBinaryString(integer[i]);   
        }
        return binaryOfInteger;
    }
    public long[] integerOfBinary(String binary[])
    {       
        long integerOfBinary[]=new long[binary.length];
        for(int i=0;i<binary.length;i++)
        {
            integerOfBinary[i]=integerOfBinary(binary[i]);   
        }
        return integerOfBinary;
    }   
    public long integerOfBinary(String binary)
    {
        long integer=0;
        int digit;
        long pot2;
        for(int i=0;i<binary.length();i++)
        {
            digit=Integer.parseInt(Character.toString(binary.charAt(i)));
            pot2=pow2(binary.length()-1-i);
            integer+=digit*pot2;
        }
        return integer;
    }
    public int pow2(int exp)
    {
        int result=1;
        for(int i=0;i<exp;i++)
            result*=2;
        return result;
    }
    public char[] getArrayChar()
    {
        String message=messageEmittedArea.getText();
        int numChars=message.length();
        char messageArray[]=new char[numChars];
        for(int i=0;i<numChars;i++)                  
            messageArray[i]=message.charAt(i);;
        return messageArray;
    }
    public long []passeToArrayNumber1(char primitiveMessage[])
    {
        int numTermos=primitiveMessage.length;
        long passeToArray[]=new long[numTermos];
        for(int i=0;i<numTermos;i++)
        {
            passeToArray[i]=charToInt(primitiveMessage[i]);
        }
        return passeToArray;
    }
    public void emitterEncrypt()
    {
        timeEncryptField.setText("calculating...");
        long tB=System.currentTimeMillis();        
        
        char primitiveMessage[]=getArrayChar();
        long number1Message[]=passeToArrayNumber1(primitiveMessage);
        String binarioSemRedundancia[]=binaryOfInteger(number1Message);    
        String binarioComRedundancia[]=insertRedundance(binarioSemRedundancia);        
        long numberFinal[]=integerOfBinary(binarioComRedundancia);
        //codigoPassadoConcatenado é um String contendo todos os elementos do codigoPassado
        //codigoPassado é array de Strings contendo os códigos w^2(modn)        
        codigoPassado=codeOfIntegerAndKeepMessagePassed2(numberFinal);        
        
        //messageReceivedArea1.setText(codigoPassadoConcatenado);
        long tE=System.currentTimeMillis();
        timeEncryptField.setText(Double.toString(((tE-tB)))+" ms");
    }
    public String[] insertRedundance(String number [])
    {
        String binarioRedundante[]=new String [number.length];
        int numDig, cont;
        for(int i=0;i<number.length;i++)
        {
            binarioRedundante[i]=number [i];
            numDig=number[i].length();
            cont=numDig;
            while(cont<numDigRedundant)
            {
                binarioRedundante[i]="0".concat(binarioRedundante[i]);
                cont++;
            }            
            binarioRedundante[i]=binarioRedundante[i].concat(binarioRedundante[i].substring(binarioRedundante[i].length()-numDigRedundant,binarioRedundante[i].length()));
            if(numDig<numDigRedundant)
                binarioRedundante[i]=binarioRedundante[i].substring(numDigRedundant-numDig);
        }
        return binarioRedundante;
    }
    public long[] codeOfIntegerAndKeepMessagePassed2(long number[])
    {
        codigoPassadoConcatenado="";
        codigoPassado=new long[number.length];
        int numDig;
        for(int i=0;i<number.length;i++)
        {
            numDig=numDig(number[i]*number[i]%n);
            while(numDig<numDig(n))
            {
                codigoPassadoConcatenado+="0";
                numDig++;
            }
            codigoPassadoConcatenado+=((number[i]*number[i])%n);
            codigoPassado[i]=(number[i]*number[i])%n; 
            
            if((i+1)%codigosPorLinha(numDig(n))==0&&i!=number.length-1)
                codigoPassadoConcatenado+="\n";
        }
        return codigoPassado;
    }
    public int codigosPorLinha(int numDigitsN)
    {
        if(numDigitsN>59)
            return 1;
        int numCodigos=1;
        while(numCodigos*numDigitsN<=59)
        {
            numCodigos++;           
        }           
        numCodigos--;
        return numCodigos;
    }
    public void setNumDigRedundant()
    {
        try
        {
            numDigRedundant=Integer.parseInt(bitsRedundantsField.getText());   
            statusLabel.setText("");
        }
        catch(Exception e)
        {
            numDigRedundant=4;
            statusLabel.setText("Invalid number, it was set to 4");            
        }
        if(numDigRedundant<0 || numDigRedundant>10)
        {
            numDigRedundant=4;
            statusLabel.setText("Number too high or too low, it was set to 4");
        }        
    }
    public void setMaxSize()
    {
        try
        {
            MAXMESSAGESIZE=Integer.parseInt(maxMessageSizeField.getText());   
            statusMessageMaxLabel.setText("");
        }
        catch(Exception e)
        {
            MAXMESSAGESIZE=10000;
            statusMessageMaxLabel.setForeground(new java.awt.Color(204, 204, 204));
            statusMessageMaxLabel.setText("Invalid number, it was set to 10000");            
        }
        
    }
    public boolean entradasValidas()
    {
        boolean valido=true;
        setNumDigRedundant();  
        setMaxSize();        
        if(messageEmittedArea.getText().equals(""))   
        {
            statusMessageLabel.setText("The message is empty!!!");
            valido=false;
        }
        return valido;
    }
    public long charToInt(char a)
    {
        return change.charToInt(a);         
    }
    public long get_N_ofReceptor()
    {
        return 7697;
    }/*
    public void configurarConexao()throws UnknownHostException, IOException
    {
        // Campo para exibir IPserver e porta
        IPserver = InetAddress.getLocalHost().getHostAddress();
        porta = "7777";
        
        ServerSocket servidor = new ServerSocket(Integer.parseInt(porta));        
        while (cliente==null) 
        {
            cliente = servidor.accept();
            IPclient = cliente.getLocalAddress().getHostAddress();
        }
        System.out.println("Conectou!");
    }*/
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==encryptButton  && !server.encrypt)
        {            
            n=get_N_ofReceptor();
            nField.setText(Long.toString(n));
            System.out.println("entrou!!");
            if(entradasValidas())
            {        
                System.out.println("entrou!!");              
                emitterEncrypt();
                if(messageReceivedArea1.getText().length()>5*MAXMESSAGESIZE-1)
                {
                    statusMessageMaxLabel.setForeground(new java.awt.Color(255, 0, 0));
                    statusMessageMaxLabel.setText("Size too low to this message!");
                }
                else
                {
                    try
                    {                        
                        server.configurarSaida(codigoPassadoConcatenado);
                        server.setEncrypt(true);
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex);
                        server.setEncrypt(false);
                    }
                }
            }
        }
        else if(e.getSource()==connectButton)
        {
            try
            {
                server.configurarConexao();
            }
            catch(Exception exc)
            {
                System.out.println(exc);
            }
        }
    }   
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServidorEmitterRabin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServidorEmitterRabin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServidorEmitterRabin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServidorEmitterRabin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServidorEmitterRabin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JLabel backGround;
    private javax.swing.JTextField bitsRedundantsField;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15, jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea messageEmittedArea;
    private javax.swing.JTextArea messageReceivedArea1;
    private javax.swing.JTextField nField;
    private javax.swing.JTextField timeEncryptField;
    private javax.swing.JTextField  maxMessageSizeField;    
    private javax.swing.JButton encryptButton;
    private javax.swing.JLabel statusMessageLabel, statusMessageMaxLabel;
    private javax.swing.JButton connectButton;
    // End of variables declaration                   
}
