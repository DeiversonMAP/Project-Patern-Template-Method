package org.example.template;

public class PreparoResina extends PreparadorImpressao {

    @Override
    protected String validarModelo() {
        return "Verificando volume oco e furos de drenagem";
    }

    @Override
    protected String fatiar() {
        return "Fatiando em camadas de 0.05mm";
    }

    @Override
    protected boolean precisaPosProcessamento() {
        return true;
    }

    @Override
    protected String posProcessar() {
        return "Lavagem em alcool e cura UV";
    }
}
