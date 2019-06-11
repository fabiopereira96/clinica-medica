package tests.br.com.clinica.controllers;

import br.com.clinica.controllers.SelecaoMedicoController;
import br.com.clinica.controllers.SelecaoTipoExameController;
import br.com.clinica.entity.Especialidade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SelecaoTipoExameControllerTest {

    private final String TITLE_TEST = "Agendamento de exame (selecione o tipo)";
    private final String LABEL_TEST = "Selecione o tipo do exame";
    private final String BTN_TEXT_TEST =  "Selecionar";

    private SelecaoTipoExameController controller;

    @Before
    public void inicia(){
        controller = new SelecaoTipoExameController();
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