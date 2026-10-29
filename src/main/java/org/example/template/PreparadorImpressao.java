package org.example.template;

import java.util.ArrayList;
import java.util.List;

public abstract class PreparadorImpressao {

    /** Template method: fixa a ordem dos passos e não pode ser sobrescrito. */
    public final String preparar(String modelo) {
        List<String> passos = new ArrayList<>();
        passos.add(carregarModelo(modelo));
        passos.add(validarModelo());
        passos.add(fatiar());
        passos.add(configurarMaterial());
        if (precisaPosProcessamento()) {
            passos.add(posProcessar());
        }
        return String.join(" -> ", passos);
    }

    // Passo concreto: igual para todas as tecnologias.
    protected String carregarModelo(String modelo) {
        return "Modelo " + modelo + " carregado";
    }

    // Passos abstratos: cada tecnologia implementa o seu.
    protected abstract String validarModelo();

    protected abstract String fatiar();

    // Hooks: têm comportamento padrão e podem ser sobrescritos.
    protected String configurarMaterial() {
        return "Material padrao";
    }

    protected boolean precisaPosProcessamento() {
        return false;
    }

    protected String posProcessar() {
        return "Remocao de suportes";
    }
}
