package br.edu.unifal;

public class Calculator {

    public int add(int v1,int v2){
        return v1 + v2;
    }

    public float divide(int v1,int v2) throws DivisionByZeroException{
        if (v2 == 0){
            throw (new DivisionByZeroException("Erro, divisao por zero"));
        }else {
            return (float) v1 /v2;
        }
    }



}
