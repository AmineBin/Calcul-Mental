package com.example.calcul_mental;



public enum TypeOperation {
    PLUS("+"),
    MOIN("-"),
    MULTIPLIER("X"),
    DIVISER(":");

    private String symbole;

    TypeOperation(String s) {
        this.symbole=s;
    }

    public String getSymbole() {
        return symbole;
    }
    public static Integer calcul(TypeOperation typeoperation, Integer PremierElem,Integer DeuxiemeElem){
        switch (typeoperation){
            case PLUS:
                return PremierElem+DeuxiemeElem;
            case MOIN:
                return PremierElem-DeuxiemeElem;
            case DIVISER:
                return PremierElem/DeuxiemeElem;
            case MULTIPLIER:
                return PremierElem*DeuxiemeElem;
            default:
                return 0;
        }
    }
}

