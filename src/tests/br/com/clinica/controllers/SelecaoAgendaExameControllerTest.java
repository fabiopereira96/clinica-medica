package tests.br.com.clinica.controllers;

import br.com.clinica.controllers.SelecaoAgendaExameController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SelecaoAgendaExameControllerTest {
    private final String TITLE_TEST = "Atualização de agenda (selecione o exame)";
    private final String LABEL_TEST = "Selecione o exame";
    private final String BTN_TEXT_TEST =  "Editar";

    private SelecaoAgendaExameController controller;

    @Before
    public void inicia(){
        controller = new SelecaoAgendaExameController();
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