package co.com.qvision.certificacion.regres.exceptions;

public class CrearUsuarioException extends AssertionError {
    public static final String CODIGO_RESPUESTA = "EL CODIGO DE RESPUESTA ES INCORRECTO";
    public static final String COMPARACION = "EL NOMBRE Y EL TRABAJO NO COINCIDEN";
    public CrearUsuarioException(String message, Throwable cause) {
        super(message, cause);

    }
}
