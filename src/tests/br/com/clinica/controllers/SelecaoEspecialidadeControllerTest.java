package tests.br.com.clinica.controllers;

import br.com.clinica.controllers.SelecaoEspecialidadeController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SelecaoEspecialidadeControllerTest {
    private final String TITLE_TEST = "Agendamento de consulta (especialidade)";
    private final String LABEL_TEST = "Selecione a especialidade";
    private final String BTN_TEXT_TEST =  "Selecionar";

    private SelecaoEspecialidadeController controller;

    @Before
    public void inicia(){
        controller = new SelecaoEspecialidadeController();
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