package calendario;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class TestBlackBox {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/*
	 Copertura minima			
Test	Giorno	Mese	Anno
1	-5	maggio	1492
2	4	brumaio	2020
3	35	maggio	1492
	 */

	
	@ParameterizedTest
	@CsvSource({
		"-5,maggio,1492,Errore", 
		"4,brumaio,2020,Errore",
		"35,maggio,2020,Errore"
		})
	void testMinimo(int g, String m, int a,String settimana) {
		String sett=Calendario.calend(g,m,a);
		assertTrue("Errore: giorno della settimana errato: doveva essere "+settimana+" ma è "+sett,settimana.contentEquals(sett));
	}

	@ParameterizedTest
	@CsvSource({
		"-5,gennaio,1492,Errore",
		"4,febbraio,2020,Martedi",
		"35,marzo,1581,Errore",
		"0,aprile,1582,Errore",
		"1,maggio,1492,Errore",
		"31,giugno,2020,Errore",
		"32,luglio,1581,Errore",
		"-5,agosto,1582,Errore",
		"4,settembre,1492,Errore",
		"35,ottobre,2020,Errore",
		"0,novembre,1581,Errore",
		"1,dicembre,1582,Mercoledi",
		"31,brumaio,1492,Errore"
	})
	void testMinimoValoriLimite(int g, String m, int a,String settimana) {
		String sett=Calendario.calend(g,m,a);
		assertTrue("Errore: giorno della settimana errato: doveva essere "+settimana+" ma è "+sett,settimana.contentEquals(sett));
	}

/*
Model Calendar
 Parameters:
   giorno : {0,1,28,29,30,31,32}
   mese : {"gennaio","febbraio","aprile"}
   anno : {1492,1582,1583,2020}
   settimana : {"Errore"}

	
 */
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "..\\2way.csv", numLinesToSkip = 1)	
	void test2Way(int g, String m, int a,String settimana) {
		String sett=Calendario.calend(g,m,a);
		assertTrue("Errore: giorno della settimana errato: doveva essere "+settimana+" ma è "+sett,settimana.contentEquals(sett));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "..\\3way.csv", numLinesToSkip = 1)	
	void test3Way(int g, String m, int a,String settimana) {
		String sett=Calendario.calend(g,m,a);
		assertTrue("Errore: giorno della settimana errato: doveva essere "+settimana+" ma è "+sett,settimana.contentEquals(sett));
	}

}
