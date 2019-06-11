package tests.br.com.clinica.controllers;

import br.com.clinica.controllers.SelecaoEspecialidadeController;
import br.com.clinica.controllers.SelecaoMedicoController;
import br.com.clinica.entity.Especialidade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SelecaoMedicoControllerTest {

    private final String TITLE_TEST = "Agendamento de consulta (médico)";
    private final String LABEL_TEST = "Selecione o médico";
    private final String BTN_TEXT_TEST =  "Selecionar";

    private SelecaoMedicoController controller;

    @Before
    public void inicia(){
        controller = new SelecaoMedicoController(new Especialidade());
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