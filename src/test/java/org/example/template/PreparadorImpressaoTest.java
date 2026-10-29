package org.example.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreparadorImpressaoTest {

    @Test
    void deveCarregarModeloComMesmaMensagemParaTodasAsSubclasses() {
        assertTrue(new PreparoFDM().preparar("Chaveiro").startsWith("Modelo Chaveiro carregado"));
        assertTrue(new PreparoResina().preparar("Chaveiro").startsWith("Modelo Chaveiro carregado"));
    }

    @Test
    void deveManterOrdemDosPassosDefinidaPelaClasseBase() {
        String resultado = new PreparoResina().preparar("Chaveiro");

        int carregar = resultado.indexOf("carregado");
        int validar = resultado.indexOf("Verificando");
        int fatiar = resultado.indexOf("Fatiando");
        int material = resultado.indexOf("Material");
        int pos = resultado.indexOf("Lavagem");

        assertTrue(carregar < validar);
        assertTrue(validar < fatiar);
        assertTrue(fatiar < material);
        assertTrue(material < pos);
    }

    @Test
    void deveUsarPosProcessamentoPadraoQuandoHookLigadoSemSobrescreverPasso() {
        PreparadorImpressao preparo = new PreparadorImpressao() {
            @Override
            protected String validarModelo() {
                return "Validando";
            }

            @Override
            protected String fatiar() {
                return "Fatiando";
            }

            @Override
            protected boolean precisaPosProcessamento() {
                return true;
            }
        };

        assertEquals(
                "Modelo X carregado -> Validando -> Fatiando -> Material padrao -> Remocao de suportes",
                preparo.preparar("X")
        );
    }
}
