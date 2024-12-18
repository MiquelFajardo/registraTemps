package informaticassa.cat.registra_temps;

import informaticassa.cat.registra_temps.entities.*;
import informaticassa.cat.registra_temps.repositories.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

@SpringBootTest(classes=RegistraTempsApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EntitiesTest {
    @Autowired
    private TreballadorRepository treballadorRepository;
    @Autowired
    private JornadaRepository jornadaRepository;
    @Autowired
    private HorariJornadaRepository horariJornadaRepository;
    @Autowired
    private TreballadorJornadaRepository treballadorJornadaRepository;
    @Autowired
    private FitxatgeRepository fitxatgeRepository;
    @Autowired
    private TipusPausaRepository tipusPausaRepository;
    @Autowired
    private PausaFitxatgeRepository pausaFitxatgeRepository;
    @Autowired
    private ModificacioFitxatgeRepository modificacioFitxatgeRepository;
    @Autowired
    private TipusAbsenciaRepository tipusAbsenciaRepository;
    @Autowired
    private AbsenciaRepository absenciaRepository;

    @Test
    @Order(1)
    public void testTreballador() {
        TreballadorEntity treballador1 = DadesProva.getTreballador1();
        TreballadorEntity treballador2 = DadesProva.getTreballador2();
        treballadorRepository.save(treballador1);
        treballadorRepository.save(treballador2);
        List<TreballadorEntity> treballadors = treballadorRepository.findAll();
        assertEquals(treballadors.get(0).getNom(), treballador1.getNom());
        assertEquals(2, treballadors.size());
    }

    @Test
    @Order(2)
    public void testJornada() {
        JornadaEntity jornada1 = DadesProva.getJornada1();
        JornadaEntity jornada2 = DadesProva.getJornada2();
        JornadaEntity jornada3 = DadesProva.getJornada3();
        jornadaRepository.save(jornada1);
        jornadaRepository.save(jornada2);
        jornadaRepository.save(jornada3);
        List<JornadaEntity> jornades = jornadaRepository.findAll();
        assertEquals(jornades.get(0).getNom(), jornada1.getNom());
        assertEquals(3, jornades.size());
    }

    @Test
    @Order(3)
    public void testHorariJornada() {
        HorariJornadaEntity horariJornada1 = DadesProva.getHorariJornada1();
        HorariJornadaEntity horariJornada2 = DadesProva.getHorariJornada2();
        horariJornadaRepository.save(horariJornada1);
        horariJornadaRepository.save(horariJornada2);
        List<HorariJornadaEntity> horarisJornades = horariJornadaRepository.findAll();
        assertEquals(horarisJornades.get(0).getDia(), horariJornada1.getDia());
        assertEquals(2, horarisJornades.size());
    }

    @Test
    @Order(4)
    public void testTreballadorJornada() {
        TreballadorJornadaEntity treballadorJornada1 = DadesProva.getTreballadorJornada1();
        TreballadorJornadaEntity treballadorJornada2 = DadesProva.getTreballadorJornada2();
        treballadorJornadaRepository.save(treballadorJornada1);
        treballadorJornadaRepository.save(treballadorJornada2);
        List<TreballadorJornadaEntity> treballadorJornades = treballadorJornadaRepository.findAll();
        assertEquals(treballadorJornades.get(0).getTreballador().getId(), treballadorJornada1.getTreballador().getId());
        assertEquals(2, treballadorJornades.size());
    }

    @Test
    @Order(5)
    public void testFitxatges() {
        FitxatgeEntity fitxatge1 = DadesProva.getFitxatge1();
        FitxatgeEntity fitxatge2 = DadesProva.getFitxatge2();
        fitxatgeRepository.save(fitxatge1);
        fitxatgeRepository.save(fitxatge2);
        List<FitxatgeEntity> fitxatges = fitxatgeRepository.findAll();
        assertEquals(fitxatges.get(0).getHoraEntrada(),fitxatge1.getHoraEntrada());
        assertEquals(2, fitxatges.size());
    }

    @Test
    @Order(6)
    public void testTipusPausa() {
        TipusPausaEntity tipusPausa1 = DadesProva.getTipusPausa1();
        TipusPausaEntity tipusPausa2 = DadesProva.getTipusPausa2();
        tipusPausaRepository.save(tipusPausa1);
        tipusPausaRepository.save(tipusPausa2);
        List<TipusPausaEntity> tipusPauses = tipusPausaRepository.findAll();
        assertEquals(tipusPauses.get(0).getNom(), tipusPausa1.getNom());
        assertEquals(2, tipusPauses.size());
    }

    @Test
    @Order(7)
    public void testPausaFitxatge() {
        PausaFitxatgeEntity pausaFitxatge1 = DadesProva.getPausaFitxatge1();
        PausaFitxatgeEntity pausaFitxatge2 = DadesProva.getPausaFitxatge2();
        pausaFitxatgeRepository.save(pausaFitxatge1);
        pausaFitxatgeRepository.save(pausaFitxatge2);
        List<PausaFitxatgeEntity> pauses = pausaFitxatgeRepository.findAll();
        assertEquals(pauses.get(0).getHoraFinal(), pausaFitxatge1.getHoraFinal());
        assertEquals(2, pauses.size());
    }

    @Test
    @Order(8)
    public void testModificacioFitxatge() {
        ModificacioFitxatgeEntity modificacioFitxatge1 = DadesProva.getModificacioFitxatge1();
        ModificacioFitxatgeEntity modificacioFitxatge2 = DadesProva.getModificacioFitxatge2();
        modificacioFitxatgeRepository.save(modificacioFitxatge1);
        modificacioFitxatgeRepository.save(modificacioFitxatge2);
        List<ModificacioFitxatgeEntity> modificacions = modificacioFitxatgeRepository.findAll();
        assertEquals(modificacions.get(0).getHoraSortidaAntiga(), modificacioFitxatge1.getHoraSortidaAntiga());
        assertEquals(2, modificacions.size());
    }

    @Test
    @Order(9)
    public void testTipusAbsencia() {
        TipusAbsenciaEntity tipusAbsencia1 = DadesProva.getTipusAbsencia1();
        TipusAbsenciaEntity tipusAbsencia2 = DadesProva.getTipusAbsencia2();
        tipusAbsenciaRepository.save(tipusAbsencia1);
        tipusAbsenciaRepository.save(tipusAbsencia2);
        List<TipusAbsenciaEntity> tipusAbsencies = tipusAbsenciaRepository.findAll();
        assertEquals(tipusAbsencies.get(0).getNom(), tipusAbsencia1.getNom());
        assertEquals(2, tipusAbsencies.size());
    }

    @Test
    @Order(10)
    public void testAbsencia() {
        AbsenciaEntity absencia1 = DadesProva.getAbsencia1();
        AbsenciaEntity absencia2 = DadesProva.getAbsencia2();
        absenciaRepository.save(absencia1);
        absenciaRepository.save(absencia2);
        List<AbsenciaEntity> absencies = absenciaRepository.findAll();
        assertEquals(absencies.get(0).getDataFinal(), absencia1.getDataFinal());
        assertEquals(2, absencies.size());
    }
}
