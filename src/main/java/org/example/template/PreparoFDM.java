package org.example.template;

public class PreparoFDM extends PreparadorImpressao {

    @Override
    protected String validarModelo() {
        return "Verificando overhangs";
    }

    @Override
    protected String fatiar() {
        return "Fatiando em camadas de 0.2mm";
    }

    @Override
    protected String configurarMaterial() {
        return "Material: PLA a 210C";
    }
}
