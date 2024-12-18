package informaticassa.cat.registra_temps;

import informaticassa.cat.registra_temps.entities.*;
import java.sql.Date;
import java.sql.Time;

/**
 * @author Miquel Fajardo <miquel.fajardo@protonmail.com>
 */

public class DadesProva {
    public static TreballadorEntity getTreballador1() {
        return new TreballadorEntity("Miquel", "Serra", "Lopez", "40000000A", "mserra1", "contrasenya", true, true);
    }
    public static TreballadorEntity getTreballador2() {
        return new TreballadorEntity("Maria", "Serra", "Pla", "50000000A", "mserra2", "contrasenya", false, true);
    }

    public static JornadaEntity getJornada1() {
        return new JornadaEntity("Completa seguida", 8, "Jornada completa seguida  de dilluns a divendres");
    }
    public static JornadaEntity getJornada2() {
        return new JornadaEntity("Completa partida", 8, "Jornada completa partida de dilluns a divendres");
    }
    public static JornadaEntity getJornada3() {
        return new JornadaEntity("Cap de setmana", 16, "Jornada cap de setmana");
    }

    public static HorariJornadaEntity getHorariJornada1() {
        return new HorariJornadaEntity("Dilluns", Time.valueOf("08:00:00"), Time.valueOf("13:00:00"), 1L);
    }
    public static HorariJornadaEntity getHorariJornada2() {
        return new HorariJornadaEntity("Dilluns", Time.valueOf("15:00:00"), Time.valueOf("18:00:00"), 1L);
    }

    public static TreballadorJornadaEntity getTreballadorJornada1() {
        return new TreballadorJornadaEntity(1L, 1L, Date.valueOf("2024-01-01"), null);
    }
    public static TreballadorJornadaEntity getTreballadorJornada2() {
        return new TreballadorJornadaEntity(2L, 2L, Date.valueOf("2024-10-01"), null);
    }

    public static FitxatgeEntity getFitxatge1() {
        return new FitxatgeEntity(1L, Date.valueOf("2024-01-01"), Time.valueOf("07:57:30"), Time.valueOf("16:29:31"));
    }
    public static FitxatgeEntity getFitxatge2() {
        return new FitxatgeEntity(1L, Date.valueOf("2024-01-02"), Time.valueOf("07:59:30"), null);
    }

    public static TipusPausaEntity getTipusPausa1() {
        return new TipusPausaEntity("Dinar", true);
    }
    public static TipusPausaEntity getTipusPausa2() {
        return new TipusPausaEntity("Esmorzar", true);
    }

    public static PausaFitxatgeEntity getPausaFitxatge1() {
        return new PausaFitxatgeEntity(1L, 1L, Time.valueOf("13:33:20"), Time.valueOf("14:02:30"));
    }
    public static PausaFitxatgeEntity getPausaFitxatge2() {
        return new PausaFitxatgeEntity(2L, 1L, Time.valueOf("13:11:20"), null);
    }

    public static ModificacioFitxatgeEntity getModificacioFitxatge1() {
        return new ModificacioFitxatgeEntity(1L, 1L, null, Time.valueOf("14:07:30"));
    }
    public static ModificacioFitxatgeEntity getModificacioFitxatge2() {
        return new ModificacioFitxatgeEntity(1L, 2L,  Time.valueOf("13:27:30"), null);
    }

    public static TipusAbsenciaEntity getTipusAbsencia1() { return new TipusAbsenciaEntity("Vacances"); }
    public static TipusAbsenciaEntity getTipusAbsencia2() { return new TipusAbsenciaEntity("Dia personal"); }

    public static AbsenciaEntity getAbsencia1() {
        return new AbsenciaEntity(1L, 2L,  Date.valueOf("2024-08-01"), null,  Date.valueOf("2024-08-15"), null, true, null);
    }
    public static AbsenciaEntity getAbsencia2() {
        return new AbsenciaEntity(1L, 1L,  Date.valueOf("2024-07-01"),  Time.valueOf("08:00:00"),  Date.valueOf("2024-07-01"), Time.valueOf("10:00:00"), false, null);
    }
}