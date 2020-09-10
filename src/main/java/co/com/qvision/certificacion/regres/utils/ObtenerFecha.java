package co.com.qvision.certificacion.regres.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ObtenerFecha {
    private ObtenerFecha() {

    }

    public static String fechaDelServicio(String fecha) {
        return fecha.split("T")[0];
    }

    public static String fechaDelSistema() {
        return new SimpleDateFormat("yyyy-MM").format(new Date());
    }
}
