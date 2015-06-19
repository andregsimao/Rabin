package Rabin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rabin3 extends javax.swing.JFrame implements ActionListener{     
    long codigoPassado[];
    long p,q,x,y;
    boolean goodChoiseOfXandY;
    int numDigRedundant;
    long n;
    String codigoPassadoConcatenado;
    String codigoTraduzidoConcatenado;
    long tXY;
    int MAXMESSAGESIZE;
    boolean ambiguous;
    ChangeCharInt change=new ChangeCharInt();
    public Rabin3() {
        initComponents();          
        setSize(925, 610);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        digiteQField = new javax.swing.JTextField();
        bitsRedundantsField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        digitePField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageTranslatedArea = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        nField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageEmittedArea = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        messageReceivedArea1 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        timeTranslateField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        timeInvasionField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        timeEncryptField = new javax.swing.JTextField();
        encryptButton = new javax.swing.JButton();
        statusPrivateKeysLabel = new javax.swing.JLabel();
        statusMessageLabel = new javax.swing.JLabel();
        xyLabel = new javax.swing.JLabel();
        xyField = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        statusMessageMaxLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        maxMessageSizeField = new javax.swing.JTextField();
        backGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("q:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 120, 50, 60);

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Message translated by receptor: ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(420, 340, 310, 40);

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("n=p*q:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(420, 60, 100, 40);

        digiteQField.setText("Digite q");
        getContentPane().add(digiteQField);
        digiteQField.setBounds(80, 140, 100, 30);

        bitsRedundantsField.setText("Default: 4 digits");
        getContentPane().add(bitsRedundantsField);
        bitsRedundantsField.setBounds(230, 460, 120, 30);

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Public Key:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(420, 20, 150, 40);

        digitePField.setText("Digite p");
        getContentPane().add(digitePField);
        digitePField.setBounds(80, 80, 100, 30);

        jLabel9.setBackground(new java.awt.Color(102, 102, 102));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Number of redundant bits:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 460, 200, 30);

        messageTranslatedArea.setColumns(20);
        messageTranslatedArea.setRows(5);
        messageTranslatedArea.setEnabled(false);
        jScrollPane1.setViewportView(messageTranslatedArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(420, 390, 300, 140);

        jLabel10.setBackground(new java.awt.Color(102, 102, 102));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Private Keys:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 10, 170, 40);

        nField.setEnabled(false);
        getContentPane().add(nField);
        nField.setBounds(530, 70, 100, 30);

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("p:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 60, 50, 60);

        jLabel11.setBackground(new java.awt.Color(102, 102, 102));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Message with emitter:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(30, 200, 240, 40);

        messageEmittedArea.setColumns(20);
        messageEmittedArea.setRows(5);
        jScrollPane2.setViewportView(messageEmittedArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 240, 310, 140);

        jLabel12.setBackground(new java.awt.Color(102, 102, 102));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Time to translate: ");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(740, 450, 170, 40);

        messageReceivedArea1.setColumns(20);
        messageReceivedArea1.setRows(5);
        messageReceivedArea1.setEnabled(false);
        jScrollPane3.setViewportView(messageReceivedArea1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(420, 180, 300, 140);

        jLabel13.setBackground(new java.awt.Color(102, 102, 102));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Message passed to receptor: ");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(420, 130, 280, 40);

        timeTranslateField.setEnabled(false);
        getContentPane().add(timeTranslateField);
        timeTranslateField.setBounds(740, 500, 100, 30);

        jLabel14.setBackground(new java.awt.Color(102, 102, 102));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Time to invasion:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(740, 20, 170, 40);

        timeInvasionField.setEnabled(false);
        getContentPane().add(timeInvasionField);
        timeInvasionField.setBounds(740, 70, 100, 30);

        jLabel15.setBackground(new java.awt.Color(102, 102, 102));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Time to encrypht: ");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(740, 240, 170, 40);

        timeEncryptField.setEnabled(false);
        getContentPane().add(timeEncryptField);
        timeEncryptField.setBounds(740, 290, 100, 30);

        encryptButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        encryptButton.setForeground(new java.awt.Color(0, 0, 255));
        encryptButton.setText("Encrypt!");
        encryptButton.addActionListener(this);
        getContentPane().add(encryptButton);
        encryptButton.setBounds(30, 420, 120, 37);

        statusPrivateKeysLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        statusPrivateKeysLabel.setForeground(new java.awt.Color(255, 0, 0));
        statusPrivateKeysLabel.setText("status private keys");
        getContentPane().add(statusPrivateKeysLabel);
        statusPrivateKeysLabel.setBounds(30, 50, 370, 20);

        statusMessageLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        statusMessageLabel.setForeground(new java.awt.Color(255, 0, 0));
        statusMessageLabel.setText("status message");
        getContentPane().add(statusMessageLabel);
        statusMessageLabel.setBounds(30, 390, 310, 20);

        xyLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        xyLabel.setForeground(new java.awt.Color(204, 204, 204));
        xyLabel.setText("(x,y) with x*p+y*q=1 :");
        getContentPane().add(xyLabel);
        xyLabel.setBounds(30, 180, 150, 20);

        xyField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        xyField.setEnabled(false);
        getContentPane().add(xyField);
        xyField.setBounds(190, 180, 150, 20);

        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(204, 204, 204));
        statusLabel.setText("status bits redundants");
        getContentPane().add(statusLabel);
        statusLabel.setBounds(30, 490, 310, 20);

        statusMessageMaxLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        statusMessageMaxLabel.setForeground(new java.awt.Color(204, 204, 204));
        statusMessageMaxLabel.setText("message size status");
        getContentPane().add(statusMessageMaxLabel);
        statusMessageMaxLabel.setBounds(30, 540, 310, 20);

        jLabel16.setBackground(new java.awt.Color(102, 102, 102));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Maximum message size");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(30, 510, 200, 30);

        maxMessageSizeField.setText("Default: 10000 chars");
        getContentPane().add(maxMessageSizeField);
        maxMessageSizeField.setBounds(230, 510, 120, 30);

        backGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rabin/cryptographyBackGround2.png"))); // NOI18N
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 910, 570);

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
        char aux;
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
        
        messageReceivedArea1.setText(codigoPassadoConcatenado);
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
        if(numDigitsN>41)
            return 1;
        int numCodigos=1;
        while(numCodigos*numDigitsN<=41)
        {
            numCodigos++;           
        }           
        numCodigos--;
        return numCodigos;
    }
    public String printArrayInt(long codigoPassado[])
    {
        String codigo="";
        for(int i=0;i<codigoPassado.length;i++)
        {
            codigo+=Long.toString(codigoPassado[i]);
        }
        return codigo;
    }
    boolean isPrime(long n) 
    {        
        //check if n is a multiple of 2
        if (n%2==0 ||n<=1) return false;
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
    public boolean pqConditionsValid()
    {
        if(!isPrime(p)||!isPrime(q))
            return false;
        else if(p%4!=3||q%4!=3)
            return false;
        else if(p==q)
            return false;
        return true;
    }
    public boolean setPublicKeyLabelAndGetPQ()
    {
        boolean valido;
        try
        {     
            valido=true;
            p=Long.parseLong(digitePField.getText());
            q=Long.parseLong(digiteQField.getText());                
            n=p*q;            
            if(!pqConditionsValid()||p*q<120)//condicao para nao dar problema na hora de achar os w's. Considerando o máximo char de 200:p*q<13000
            {
                valido=false;
                statusPrivateKeysLabel.setText("Set P,Q big distint primes,p=q=3(mod 4),p*q>120");                
            }            
        }
        catch(Exception e)
        {
            valido=false;
            statusPrivateKeysLabel.setText("P and Q must be naturals!!!");
        }
        return valido;
    }
    
    public boolean setXandYAndGoodChoise()
    {
        long a=p;
        long b=q;
        long tB=System.currentTimeMillis();
        long x, yAnt, r, aIni, bIni, sr,quoc;
        aIni = a; bIni = b;
        x = 1; yAnt = 0;
        while (b != 0)
        {
            r = a % b;
            quoc = a/b;
            a = b;
            b = r;
            sr = x - yAnt*quoc;
            x = yAnt;
            yAnt = sr;
        }
        this.x = x;
        this.y = (a - x*aIni)/bIni;
        xyField.setText("(x , y) = ("+x+" , "+y+")");
        // a é o mdc de a e b, deve ser "1" para haver solução.        
        long tE=System.currentTimeMillis();
        tXY=tE-tB;
        if(a==1)
            return true;
        else
            return false;
    }    
    public String[] colectBinaryW1(long w4[][])
    {
        ambiguous=false;
        String resposta[]=new String[w4.length];
        for(int i=0;i<w4.length;i++)
        {
            resposta[i]=colectBinaryW1(w4[i]);
        }        
        if(ambiguous)
            statusMessageLabel.setText("It is ambiguous!");
        else
            statusMessageLabel.setText("");
        return resposta;
    }
    public String colectBinaryW1(long w4[])
    {
        int length=w4.length;
        String resposta;
        String binarios[]=new String[length];
        int numRedundantes=0;
        String redundantes[]=new String[4];
        for(int i=0;i<length;i++)
        {
            binarios[i]=Long.toBinaryString(w4[i]);
            if(isRedundant(binarios[i]))
            {
                redundantes[numRedundantes++]=binarios[i];
            }
        }       
        if(numRedundantes==0)
            return "-1";
        else if(numRedundantes==1)
        {
            long x=integerOfBinary(redundantes[0].substring(0,redundantes[0].length()-numDigRedundant));
            if(x<110 &&x>0)
                return redundantes[0].substring(0,redundantes[0].length()-numDigRedundant);            
        }
        else
        {               
            int numValidos=0;
            String resp="-1";
            long x;
            for(int i=0;i<numRedundantes;i++)
            {
                x=integerOfBinary(redundantes[i].substring(0,redundantes[i].length()-numDigRedundant));
                if(x<110&&x>0)
                {
                    if(numValidos==0)
                        resp=redundantes[i].substring(0,redundantes[i].length()-numDigRedundant);
                  
                    if(numValidos>0 && integerOfBinary(resp)>integerOfBinary(redundantes[i].substring(0,redundantes[i].length()-numDigRedundant)))
                        resp=redundantes[i].substring(0,redundantes[i].length()-numDigRedundant);
                    numValidos++;     
                }
            }    
            if(numValidos>1)
                ambiguous=true;
            return resp;
        }
        return "-1";
    }
    public boolean isRedundant(String binaryOrig)
    {
        String binary=binaryOrig;
        int length=binary.length();
        if(binary.length()<numDigRedundant)
            return false;
        for(;length<2*numDigRedundant;length++)
        {
            binary="0".concat(binary);
        }
        for(int i=0;i<numDigRedundant;i++)
        {            
            if(!Character.toString(binary.charAt(length-1-i)).equals(Character.toString(binary.charAt(length-1-i-numDigRedundant))))
            {
                return false;
            }
        }   
        return true;
    }
    public boolean menorString(String s1, String s2)
    {
        if(s1.length()<s2.length())
            return true;
        else if(s1.length()>s2.length())
            return false;
        else
        {
            if(s1.compareTo(s2)>0)
                return false;
            else
                return true;
        }
    }
    public long[] getCodigo2(String codigo)throws Exception
    {
        long numAtual;
        long arrayAux[]=new long[MAXMESSAGESIZE];
        long codigoLido[];
        int length=0;
        boolean entrou;
        for(int index=0;index<codigo.length();index++)
        {
            numAtual=0; 
            if(Character.isDigit(codigo.charAt(index)))
            {
                for(int cont=0;index<codigo.length()&& cont<numDig(n);cont++, index++)
                {

                    numAtual=numAtual*10+Long.parseLong(Character.toString(codigo.charAt(index)));                
                }            
                index--;
                arrayAux[length]=numAtual;
                length++;  
            }    
        }
        codigoLido=new long[length];
        for(int i=0;i<length;i++)
        {
            codigoLido[i]=arrayAux[i];            
        }
        return codigoLido;
    }
    public void receptorTranslate()throws Exception
    {        
        long tB=System.currentTimeMillis();
        timeTranslateField.setText("Calculating...");         
        long codigoLido[]=getCodigo2(messageReceivedArea1.getText());
        //int codigoLido[]=codigoPassado;
        long w4[][]=findDecimalWs(codigoLido);
        String binaryW1NoRedundant[]=colectBinaryW1(w4);
        boolean valido=true;
        for(int i=0;i<binaryW1NoRedundant.length && valido;i++)
            if(binaryW1NoRedundant[i].equals("-1"))
                valido=false;
        if(valido)    
        {
            long decimalW1[]=integerOfBinary(binaryW1NoRedundant);        
            messageTranslatedArea.setText(messageTranslated(decimalW1));          
            long tE=System.currentTimeMillis();
            timeTranslateField.setText(Double.toString(tE-tB+tXY)+" ms");
        }
        else
        {
            statusMessageLabel.setText("The tern (p,q,redundants) isn't good in Rabin");             
        }    
            
    }
    public String messageTranslated(long decimal[])throws Exception
    {
        codigoTraduzidoConcatenado="";
        for(int i=0;i<decimal.length;i++)
        {
            codigoTraduzidoConcatenado+=intToChar(decimal[i]);
        }
        return codigoTraduzidoConcatenado;
    }
    public void intrusionTranslate()
    {
        long tB=System.currentTimeMillis();
        timeInvasionField.setText("calculating...");
        
        
        
        
        long tE=System.currentTimeMillis();
        timeInvasionField.setText((tE-tB)/1000+" s");        
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
        emptyLabels();
        boolean valido=false;
        setNumDigRedundant();  
        setMaxSize();
        if(setPublicKeyLabelAndGetPQ() && !messageEmittedArea.getText().equals(""))
        {
            if(setXandYAndGoodChoise())
            {                               
                valido=true;
            }
            else
            {
                statusPrivateKeysLabel.setText("x*p+y*q=1 didn't return integers easily!!");
            }
        }
        else if(messageEmittedArea.getText().equals(""))   
        {
            statusMessageLabel.setText("The message is empty!!!");
        }
        return valido;
    }
    public long charToInt(char a)
    {
        return change.charToInt(a);         
    }
    public char intToChar(long a)
    {
        return change.intToChar(a);
    }
    public long[] encontrarValoresBaseExp2Modn(long base, int numValores)
    {
        long valores[]=new long[numValores];
        valores[0]=base;
        for(int i=0;i<numValores-1;i++)        
            valores[i+1]=((valores[i]*valores[i])%n);
        return valores;
    }
    public long []encontrarCombinacaoPotenciasDe2(long exp)
    {       
        String binaryExp=Long.toBinaryString(exp);
        //String binaryExpArray[]=numberToArrayNumbers(binaryExp);
        long combinacao[]=new long[binaryExp.length()];
        for(int i=0;i<combinacao.length;i++)
            combinacao[i]=Long.parseLong(Character.toString(binaryExp.charAt(binaryExp.length()-i-1)));
        return combinacao;
    }
    public long[][] findDecimalWs(long codigo[])throws Exception
    {
        long w[][]=new long[codigo.length][4];      
        int firstPart,secondPart;
        for(int i=0;i<codigo.length;i++)
        {            
            firstPart=(int)((x*(p*powCodExpModn(codigo[i],(q+1)/4))%n)%n);
            if(firstPart<0) firstPart+=n;            
            secondPart=(int)((y*(q*powCodExpModn(codigo[i],(p+1)/4))%n)%n);
            if(secondPart<0) secondPart+=n;
                    //powCodExpModn((p+1)/4))=(long)(Math.pow(codigo[i],((p+1)/4))));            
            w[i][0]=(-firstPart-secondPart)%n;
            if(w[i][0]<0)
                w[i][0]+=n;
            w[i][1]=(-firstPart+secondPart)%n;
            if(w[i][1]<0)
                w[i][1]+=n;
            w[i][2]=(firstPart-secondPart)%n;
            if(w[i][2]<0)
                w[i][2]+=n;
            w[i][3]=(firstPart+secondPart)%n;
            if(w[i][3]<0)
                w[i][3]+=n;
            //System.out.println(w[i][0]+" "+w[i][1]+" "+w[i][2]+" "+w[i][3]);
        }
        return w;
    }
    public long powCodExpModn(long baseMaior, long exp)
    {
        //resultado de Math.pow(codigo[i],((p+1)/4)))%n
        long base=baseMaior%n;
        long resposta;
        int j;
        boolean encontrouPadrao=false;
        //vetor com o numero de potencias de 2 elevados ao index da raiz q forma o numero
        long numExp2[]=encontrarCombinacaoPotenciasDe2(exp);        
                   
        //vetor com o valor de:  (base^(2^i))%n;
        long valorBaseExp2Modn[]=encontrarValoresBaseExp2Modn(base, numExp2.length);
        
        resposta=1;
        for(int i=0;i<numExp2.length;i++)
        {            
            if(numExp2[i]==1)
            {
                resposta=(resposta*valorBaseExp2Modn[i])%n;
            }
        }
        return resposta;
    }
    public void emptyLabels()
    {
        nField.setText("");
        messageReceivedArea1.setText("");
        messageTranslatedArea.setText("");
        timeInvasionField.setText("");
        timeEncryptField.setText("");
        timeTranslateField.setText("");        
        statusPrivateKeysLabel.setText("");
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==encryptButton)
        {
            if(entradasValidas())
            {         
                emptyLabels();
                nField.setText(Long.toString(p*q));  
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
                        receptorTranslate();
                        intrusionTranslate();
                    }
                    catch(Exception ex)
                    {
                        statusMessageLabel.setText("The tern (p,q,redundants) isn't good in Rabin");
                    }
                }
            }
            else
            {
                xyField.setText("");
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
            java.util.logging.Logger.getLogger(Rabin3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rabin3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rabin3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rabin3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rabin3().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JLabel backGround;
    private javax.swing.JTextField bitsRedundantsField;
    private javax.swing.JTextField digitePField;
    private javax.swing.JTextField digiteQField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15, jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea messageEmittedArea;
    private javax.swing.JTextArea messageReceivedArea1;
    private javax.swing.JTextArea messageTranslatedArea;
    private javax.swing.JTextField nField;
    private javax.swing.JTextField xyField;
    private javax.swing.JLabel xyLabel;
    private javax.swing.JTextField timeEncryptField;
    private javax.swing.JTextField timeInvasionField;
    private javax.swing.JTextField timeTranslateField,  maxMessageSizeField;    
    private javax.swing.JButton encryptButton;
    private javax.swing.JLabel statusPrivateKeysLabel;
    private javax.swing.JLabel statusMessageLabel, statusMessageMaxLabel;
    
    // End of variables declaration                   
}