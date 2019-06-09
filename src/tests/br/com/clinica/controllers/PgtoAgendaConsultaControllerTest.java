package tests.br.com.clinica.controllers;

import br.com.clinica.controllers.PgtoAgendaConsultaController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PgtoAgendaConsultaControllerTest {

    private static final String TITLE_TEST = "Pagamento (agendamento de consulta)";

    private PgtoAgendaConsultaController controller;

    @Before
    public void inicia(){
        controller = new PgtoAgendaConsultaController();
    }

    @Test
    public void deveRetornarTitlePagamento(){
        Assert.assertEquals(TITLE_TEST, controller.getTitle());
    }
}
