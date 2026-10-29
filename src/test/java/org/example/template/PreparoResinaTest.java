package org.example.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreparoResinaTest {

    @Test
    void devePrepararModeloNoFluxoResina() {
        PreparadorImpressao preparo = new PreparoResina();
        assertEquals(
                "Modelo Busto carregado -> Verificando volume oco e furos de drenagem -> Fatiando em camadas de 0.05mm -> Material padrao -> Lavagem em alcool e cura UV",
                preparo.preparar("Busto")
        );
    }

    @Test
    void deveUsarMaterialPadraoDoHook() {
        PreparadorImpressao preparo = new PreparoResina();
        assertTrue(preparo.preparar("Busto").contains("Material padrao"));
    }
}
