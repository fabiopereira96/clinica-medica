package tests.br.com.clinica.controllers;

import br.com.clinica.controllers.PgtoAgendaExameController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PgtoAgendaExameControllerTest {

    private static final String TITLE_TEST = "Pagamento (agendamento de exame)";

    private PgtoAgendaExameController controller;

    @Before
    public void inicia(){
        controller = new PgtoAgendaExameController();
    }

    @Test
    public void deveRetornarTitlePagamento(){
        Assert.assertEquals(TITLE_TEST, controller.getTitle());
    }
}