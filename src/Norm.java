package src;
public class Norm{


    protected static boolean normLOs;
    protected static boolean normInd;
    protected static boolean normAtt;

    public static void setNorms(boolean a, boolean b, boolean c){
        normLOs = a;
        normInd = b;
        normAtt = c;

    }

    public static boolean getNLOs(){
        return normLOs;
    }

    public static boolean getNInd(){
        return normInd;
    }

    public static boolean getNAtt(){
        return normAtt;
    }

    public static void setNLOs(boolean nLOs){
        normLOs = nLOs;
    }

    public static void setNInd(boolean x){
        normInd = x;
    }
    public static void serNAtt(boolean x){
        normAtt = x;
    }

}