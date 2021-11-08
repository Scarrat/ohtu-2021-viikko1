package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto varasto2;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        varasto2 = new Varasto(10,10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void liikaaOtto() {
        varasto.otaVarastosta(11);


        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void liikaaLaitto() {
        varasto.lisaaVarastoon(11);

        assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
     @Test
    public void huonoAlotus() {
        Varasto varasto3 = new Varasto(10,11);

        assertEquals(0, varasto3.paljonkoMahtuu(),vertailuTarkkuus);
    }
    @Test
    public void huonoAlotus2() {
        Varasto varasto4 = new Varasto(-1);

        assertEquals(0, varasto4.paljonkoMahtuu(),vertailuTarkkuus);
    }
    @Test
    public void huonoAlotus3() {
        Varasto varasto5 = new Varasto(0,10);

        assertEquals(0, varasto5.paljonkoMahtuu(),vertailuTarkkuus);
    }@Test
    public void huonoAlotus4() {
        Varasto varasto5 = new Varasto(10,-1);

        assertEquals(10, varasto5.paljonkoMahtuu(),vertailuTarkkuus);
    }
    @Test
    public void eiLisata() {
        varasto.lisaaVarastoon(-1);

        assertEquals(10, varasto.paljonkoMahtuu(),vertailuTarkkuus);
    }
    @Test
    public void eiOteta() {
        varasto.lisaaVarastoon(5);
        varasto.otaVarastosta(-1);

        assertEquals(5, varasto.paljonkoMahtuu(),vertailuTarkkuus);
    }
    @Test
    public void toStringtest() {
        varasto.lisaaVarastoon(5);
        assertEquals(varasto.toString(), varasto.toString());
    }

}