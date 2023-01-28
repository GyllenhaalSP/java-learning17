package EV2.OOP.C_230203;

/**
 * La clase Time representa una hora determinada, un momento de un día. Esta
 * representación cuenta con un valor para hora, minuto y segundo.
 */
public class Time {
    /**
     * valor de hora, debe tener siempre un valor entre 0 y 23
     */
    int hora;

    /**
     * valor de minuto, debe tener siempre un valor entre 0 y 59
     */
    int minuto;

    /**
     * valor de segundo, debe tener siempre un valor entre 0 y 59
     */
    int segundo;

    /**
     * Constructor que inicializa los tres atributos de Hora: hora, minuto y segundo a 0.
     */

    public Time() {
        this(0, 0, 0);
    }

    /**
     * Constructor que inicializa los tres atributos de Hora: hora, minuto y segundo
     *
     * @param hora    Valor inicial para hora
     * @param minuto  Valor inicial para minuto
     * @param segundo Valor inicial para segundo
     */
    public Time(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    /**
     * Constructor que inicializa dos atributos de Hora: hora y minuto
     *
     * @param hora   Valor inicial para hora
     * @param minuto Valor inicial para minuto
     */
    public Time(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    /**
     * Método que permite concatenar Strings con objetos de tipo Time. Nos permitirá
     * llamar a println() pasando una instancia de Time.
     *
     * @return String con la representación de Time separando la hora, los minutos y
     * los segundos con el caracter "dos puntos"
     */
    public String toString() {
        return (hora < 10 ? "0" + hora:hora)
            + ":"
            + (minuto < 10 ? "0" + minuto:minuto)
            + ":"
            + (segundo < 10 ? "0" + segundo:segundo);
    }

    /**
     * Añade secs segundos
     *
     * @param secs Segundos a añadir a la instancia de Time
     * @return true si se ha podido añadir, false si el parámetro no era válido y el
     * objeto no se ha modificado
     */
    public boolean addSeconds(int secs) {
        if (secs < 0) {
            return false;
        } else {
            segundo += secs;
                addExtraSeconds();
                addExtraMinutes();
                addExtraHours();
            return true;
        }
    }

    /**
     * Añade mins minutos
     *
     * @param mins Minutos a añadir a la instancia de Time
     * @return true si se ha podido añadir, false si el parámetro no era válido y el
     * objeto no se ha modificado
     */
    public boolean addMinutes(int mins) {
        if (mins < 0) {
            return false;
        } else {
            minuto += mins;
            addExtraMinutes();
            addExtraHours();
            return true;
        }
    }

    /**
     * Añade hours horas
     *
     * @param hours Horas a añadir a la instancia de Time
     * @return true si se ha podido añadir, false si el parámetro no era válido y el
     * objeto no se ha modificado
     */
    public boolean addHoras(int hours) {
        if (hours < 0) {
            return false;
        } else {
            hora += hours;
            addExtraHours();
            return true;
        }
    }

    /**
     * Reinicia los segundos cada vez que los segundos sobrepasan 60.
     */
    public void addExtraSeconds() {
        if (segundo >= 60) {
            while (segundo >= 60) {
                segundo -= 60;
                minuto++;
            }
        }
    }

    /**
     * Añade horas cada vez que los minutos sobrepasan 60.
     */
    public void addExtraMinutes() {
        if (minuto >= 60) {
            while (minuto >= 60) {
                minuto -= 60;
                hora++;
            }
        }
    }

    /**
     * Reinicia las horas cada vez que las horas sobrepasan 24.
     */
    public void addExtraHours(){
        if (hora >= 24) {
            while (hora >= 24) {
                hora -= 24;
            }

        }
    }

}