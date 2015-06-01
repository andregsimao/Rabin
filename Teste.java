package Rabin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teste{     
    long codigoPassado[];
    int p,q,x,y;
    boolean goodChoiseOfXandY;
    int numDigRedundant;
    int n;
    String codigoPassadoConcatenado;
    String codigoTraduzidoConcatenado;
    String messageEmitted;
    int MAXMESSAGESIZE=10000;
    ChangeCharInt change=new ChangeCharInt();
    public Teste() {
        p=379;
        q=563;
        n=p*q;
        numDigRedundant=4;
        setXandYAndGoodChoise();
        System.out.println("x= "+x+" y= "+y+" n= "+n);
        messageEmitted="a";       
        //System.out.println(Integer.toBinaryString(200));
        //System.out.println(integerOfBinary("11001000001000"));
        //System.out.println(Integer.toBinaryString(12808));
        //String binary[]=new String[1];
        //binary[0]="110001";
        //String binary[]=new String[4];
        //binary[0]="11110";
        //binary[1]="11110111";
        //binary[2]="1010101";
        //binary[3]="111111";
        //System.out.println(integerOfBinary(binary[0])+" "+integerOfBinary(binary[1])+" "+integerOfBinary(binary[2])+" "+integerOfBinary(binary[3])+" ");
        //System.out.println(change.charToInt('a'));
        System.out.println("a");
        System.out.println(change.charToInt('a'));
        System.out.println(Long.toBinaryString(change.charToInt('a')));
        System.out.println("10111011");
        System.out.println(integerOfBinary("10111011"));        
        System.out.println((187*187)%n);       
        emitterEncrypt();       
        receptorTranslate();
    }                
    public void receptorTranslate()
    {                 
        int codigoLido[]=getCodigo2(codigoPassadoConcatenado);
        System.out.println("codigo lido: "+codigoLido[0]);
        int w4[][]=findDecimalWs(codigoLido);
        System.out.println("w's: "+(w4[0][0])+" "+(w4[0][1])+" "+(w4[0][2])+" "+(w4[0][3]));
        System.out.println("w's: "+Integer.toBinaryString(w4[0][0])+" "+Integer.toBinaryString(w4[0][1])+" "+Integer.toBinaryString(w4[0][2])+" "+Integer.toBinaryString(w4[0][3]));
        String binaryW1NoRedundant[]=colectBinaryW1(w4);
        //System.out.println("Binario sem redundancia: "+binaryW1NoRedundant[0]);
        long decimalW1[]=integerOfBinary(binaryW1NoRedundant);        
        //System.out.println("Decimal w1: "+decimalW1[0]);
        System.out.println("Mensagem traduzida: "+messageTranslated(decimalW1));        
    }
    public boolean setXandYAndGoodChoise()
    {
        int a=p;
        int b=q;
        int x, yAnt, r, aIni, bIni, sr,quoc;
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
        // a é o mdc de a e b, deve ser "1" para haver solução.   
        if(a==1)
            return true;
        else
            return false;
    }
    public int[][] findDecimalWs(int codigo[])
    {
        int w[][]=new int[codigo.length][4];      
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
        int pot2;
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
        String message=messageEmitted;
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
        char primitiveMessage[]=getArrayChar();
        long number1Message[]=passeToArrayNumber1(primitiveMessage);
        System.out.println(number1Message[0]);
        String binarioSemRedundancia[]=binaryOfInteger(number1Message);    
        System.out.println(binarioSemRedundancia[0]);
        String binarioComRedundancia[]=insertRedundance(binarioSemRedundancia);  
        System.out.println(binarioComRedundancia[0]);
        long numberFinal[]=integerOfBinary(binarioComRedundancia);
        System.out.println(numberFinal[0]);
        //codigoPassadoConcatenado é um String contendo todos os elementos do codigoPassado
        //codigoPassado é array de Strings contendo os códigos w^2(modn)        
        codigoPassado=codeOfIntegerAndKeepMessagePassed2(numberFinal);
        System.out.println(codigoPassado[0]);
        System.out.println("codigo passado concatenado: "+codigoPassadoConcatenado);
        
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
    public String printArrayInt(int codigoPassado[])
    {
        String codigo="";
        for(int i=0;i<codigoPassado.length;i++)
        {
            codigo+=Integer.toString(codigoPassado[i]);
        }
        return codigo;
    }
    
    
    public String[] colectBinaryW1(int w4[][])
    {
        String resposta[]=new String[w4.length];
        for(int i=0;i<w4.length;i++)
        {
            resposta[i]=colectBinaryW1(w4[i]);
        }
        return resposta;
    }
    public String colectBinaryW1(int w4[])
    {
        int length=w4.length;
        String resposta;
        String binarios[]=new String[length];
        int numRedundantes=0;
        String redundantes[]=new String[4];
        for(int i=0;i<length;i++)
        {
            binarios[i]=Integer.toBinaryString(w4[i]);
            if(isRedundant(binarios[i]))
            {
                redundantes[numRedundantes++]=binarios[i];
            }
        }       
        if(numRedundantes==0)
            return "-1";
        else if(numRedundantes==1)
        {
            return redundantes[0].substring(0,redundantes[0].length()-numDigRedundant);            
        }
        else
        {
            System.out.println("It is ambiguous!");
            return redundantes[0].substring(0,redundantes[0].length()-numDigRedundant);
        }
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
    public int[] getCodigo2(String codigo)
    {
        int numAtual;
        int arrayAux[]=new int[MAXMESSAGESIZE];
        int codigoLido[];
        int length=0;
        boolean entrou;
        for(int index=0;index<codigo.length();index++)
        {
            numAtual=0; 
            if(Character.isDigit(codigo.charAt(index)))
            {
                for(int cont=0;index<codigo.length()&& cont<numDig(n);cont++, index++)
                {

                    numAtual=numAtual*10+Integer.parseInt(Character.toString(codigo.charAt(index)));                
                }            
                index--;
                arrayAux[length]=numAtual;
                length++;  
            }    
        }
        codigoLido=new int[length];
        for(int i=0;i<length;i++)
        {
            codigoLido[i]=arrayAux[i];            
        }
        return codigoLido;
    }
    
    public String messageTranslated(long decimal[])
    {
        codigoTraduzidoConcatenado="";
        for(int i=0;i<decimal.length;i++)
        {
            codigoTraduzidoConcatenado+=intToChar(decimal[i]);
        }
        return codigoTraduzidoConcatenado;
    }
    
    public long charToInt(char a)
    {
        return change.charToInt(a);       
    }
    public char intToChar(long a)
    {
        return change.intToChar(a);
    }
    public int[] encontrarValoresBaseExp2Modn(int base, int numValores)
    {
        int valores[]=new int[numValores];
        valores[0]=base;
        for(int i=0;i<numValores-1;i++)        
            valores[i+1]=((valores[i]*valores[i])%n);
        return valores;
    }
    public int []encontrarCombinacaoPotenciasDe2(int exp)
    {       
        String binaryExp=Integer.toBinaryString(exp);
        //String binaryExpArray[]=numberToArrayNumbers(binaryExp);
        int combinacao[]=new int[binaryExp.length()];
        for(int i=0;i<combinacao.length;i++)
            combinacao[i]=Integer.parseInt(Character.toString(binaryExp.charAt(binaryExp.length()-i-1)));
        return combinacao;
    }
    
    public int powCodExpModn(int baseMaior, int exp)
    {
        //resultado de Math.pow(codigo[i],((p+1)/4)))%n
        int base=baseMaior%n;
        int resposta;
        int j;
        boolean encontrouPadrao=false;
        //vetor com o numero de potencias de 2 elevados ao index da raiz q forma o numero
        int numExp2[]=encontrarCombinacaoPotenciasDe2(exp);        
                   
        //vetor com o valor de:  (base^(2^i))%n;
        int valorBaseExp2Modn[]=encontrarValoresBaseExp2Modn(base, numExp2.length);
        
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
    public static void main(String args[]) {
        Teste t=new Teste();
    }    
    // End of variables declaration                   
}
