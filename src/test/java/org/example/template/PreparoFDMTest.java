package org.example.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreparoFDMTest {

    @Test
    void devePrepararModeloNoFluxoFDM() {
        PreparadorImpressao preparo = new PreparoFDM();
        assertEquals(
                "Modelo Busto carregado -> Verificando overhangs -> Fatiando em camadas de 0.2mm -> Material: PLA a 210C",
                preparo.preparar("Busto")
        );
    }

    @Test
    void naoDeveExecutarPosProcessamento() {
        PreparadorImpressao preparo = new PreparoFDM();
        assertFalse(preparo.preparar("Busto").contains("Remocao de suportes"));
    }
}
