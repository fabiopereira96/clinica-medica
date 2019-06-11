package tests.br.com.clinica.controllers;

import br.com.clinica.controllers.SelecaoAgendaConsultaController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SelecaoAgendaConsultaControllerTest {

    private final String TITLE_TEST = "Atualização de agenda (selecione a consulta)";
    private final String LABEL_TEST = "Selecione a consulta";
    private final String BTN_TEXT_TEST =  "Editar";

    private SelecaoAgendaConsultaController controller;

    @Before
    public void inicia(){
        controller = new SelecaoAgendaConsultaController();
    }

    @Test
    public void deveRetornarTitleIgualAString(){
        Assert.assertEquals(TITLE_TEST, controller.getTitle());
    }

    @Test
    public void deveRetornarLabelIgualAString(){
        Assert.assertEquals(LABEL_TEST, controller.getLabel());
    }

    @Test
    public void deveRetornarBtnTextIgualAEditar(){
        Assert.assertEquals(BTN_TEXT_TEST, controller.getBtnText());
    }
}