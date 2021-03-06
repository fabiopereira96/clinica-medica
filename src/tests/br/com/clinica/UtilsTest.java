package tests.br.com.clinica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.clinica.Utils;
import br.com.clinica.entity.AgendaMedica;

import static junit.framework.Assert.*;

public class UtilsTest {
	
	@Test
	public void deveRetornarTrueQuandoDatasForemIguals() {
		assertTrue(Utils.datesAreEqual(new Date(), new Date()));
	}
	
	@Test
	public void deveRetornarFalseQuandoDatasForemDiferentes() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		assertFalse(Utils.datesAreEqual(new Date(), calendar.getTime()));
	}
	
	@Test
	public void deveRetornarInt1QuandoDateForSun() {
		assertEquals(1, Utils.getDayId("Sun"));
	}

	@Test
	public void deveRetornarInt2QuandoDateForMon() {
		assertEquals(2, Utils.getDayId("Mon"));
	}
	
	@Test
	public void deveRetornarInt3QuandoDateForTue() {
		assertEquals(3, Utils.getDayId("Tue"));
	}
	
	@Test
	public void deveRetornarInt4QuandoDateForWed() {
		assertEquals(4, Utils.getDayId("Wed"));
	}
	
	@Test
	public void deveRetornarInt5QuandoDateForThu() {
		assertEquals(5, Utils.getDayId("Thu"));
	}
	
	@Test
	public void deveRetornarInt6QuandoDateForFri() {
		assertEquals(6, Utils.getDayId("Fri"));
	}
	
	@Test
	public void deveRetornarInt7QuandoDateForSat() {
		assertEquals(7, Utils.getDayId("Sat"));
	}
	
	@Test
	public void deveRetornarTrueQuandoHorarioEstiverLivre() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		List<AgendaMedica> marcacoes = new ArrayList<>();
		marcacoes.add(new AgendaMedica(calendar.getTime(), null, null));
		assertTrue(Utils.thisHorarioIsFree(marcacoes, new Date()));
	}
	
	@Test
	public void deveRetornarFalseQuandoHorarioNaoEstiverLivre() {
		List<AgendaMedica> marcacoes = new ArrayList<>();
		marcacoes.add(new AgendaMedica(new Date(), null, null));
		assertFalse(Utils.thisHorarioIsFree(marcacoes, new Date()));
	}
}
