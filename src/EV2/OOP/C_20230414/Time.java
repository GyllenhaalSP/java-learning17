package EV2.OOP.C_20230414;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import java.util.Locale;
import java.util.Scanner;

public class Time {

    public static void main(String[] args) {
        Instant instanteInicial = Instant.now();
        System.out.println("MainJavaTime ===> ");
        Scanner scan_in = new Scanner(System.in);

        System.out.println("\n" + "=".repeat(50));
        System.out.println("## Jugando con LocalDate:");
        Instant instanteLocalDate = Instant.now();
        LocalDate localDateAhora = LocalDate.now();
        System.out.println("localDateAhora = " + localDateAhora);

        LocalDate localDateParsedExamen = LocalDate.parse("2023-05-11");
        System.out.println("localDateParsedExamen = " + localDateParsedExamen);

        LocalDate localDateParsedNacimientoFer = LocalDate.parse("1984-10-22");

        LocalDate localDateOfVacaciones = LocalDate.of(2023, 6, 30);
        System.out.println("localDateOfVacaciones = " + localDateOfVacaciones);

        System.out.println("""

        DateTimeFormatter formatoAñoBarraMesBarraDia = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDateParsedConFormatoEspecial = LocalDate.parse("2023/01/02", formatoAñoBarraMesBarraDia);
        """);

        DateTimeFormatter formatoAñoBarraMesBarraDia = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDateParsedConFormatoEspecial = LocalDate.parse("2023/01/02", formatoAñoBarraMesBarraDia);

        System.out.println("localDateParsedConFormatoEspecial = " + localDateParsedConFormatoEspecial);

        System.out.print("""
        DateTimeFormatter formateadorDeDateTimeEnFrase = DateTimeFormatter.ofPattern("EEEE' 'dd' de 'MMMM' de 'yyyy")
            //.withZone(ZoneId.of("Europe/Madrid"))
            .localizedBy(Locale.forLanguageTag("es-ES"));
        """);
        DateTimeFormatter formateadorDeDateTimeEnFrase = DateTimeFormatter.ofPattern("EEEE' 'dd' de 'MMMM' de 'yyyy")
                // .withZone(ZoneId.of("Europe/Madrid"))
                .localizedBy(Locale.forLanguageTag("es-ES"));
        System.out.println("localDateAhora.format(formateadorDeDateTimeEnFrase) = " +
                localDateAhora.format(formateadorDeDateTimeEnFrase));

        System.out.println("Pulsa ENTER para continuar...");
        scan_in.nextLine();
        System.out.println("\n" + "=".repeat(50));

        System.out.println("## Jugando con LocalTime:");
        Instant instanteLocalTime = Instant.now();
        LocalTime localTimeAhora = LocalTime.now();
        System.out.println("localTimeAhora = " + localTimeAhora);

        LocalTime localTimeParsedExamen = LocalTime.parse("17:30:01");
        System.out.println("localTimeParsedExamen = " + localTimeParsedExamen);

        LocalTime localTimeOfVacaciones = LocalTime.of(13, 59, 59);
        System.out.println("localTimeOfVacaciones = " + localTimeOfVacaciones);

        System.out.print("""

        DateTimeFormatter formatoHoraPuntoMinutoPuntoSegundo = DateTimeFormatter.ofPattern("H.m.s");
        LocalTime localTimeParsedConFormatoEspecial = LocalTime.parse("23.24.25", formatoHoraPuntoMinutoPuntoSegundo);
            """);

        DateTimeFormatter formatoHoraPuntoMinutoPuntoSegundo = DateTimeFormatter.ofPattern("H.m.s");
        LocalTime localTimeParsedConFormatoEspecial = LocalTime.parse("23.24.25", formatoHoraPuntoMinutoPuntoSegundo);
        System.out.println("localTimeParsedConFormatoEspecial = " + localTimeParsedConFormatoEspecial);

        System.out.print("""
        DateTimeFormatter formateadorDeTimeEnFrase = DateTimeFormatter.ofPattern("h' 'B', 'm' minutos y 's' segundos'")
              //.withZone(ZoneId.of("Europe/London"))
              .localizedBy(Locale.forLanguageTag("es-ES"));
          """);
        DateTimeFormatter formateadorDeTimeEnFrase = DateTimeFormatter.ofPattern("h' 'B', 'm' minutos y 's' segundos'")
                // .withZone(ZoneId.of("Europe/London"))
                .localizedBy(Locale.forLanguageTag("es-ES"));
        System.out.println("localTimeAhora.format(formateadorDeTimeEnFrase) = " +
                localTimeAhora.format(formateadorDeTimeEnFrase));

        System.out.println("Pulsa ENTER para continuar...");
        scan_in.nextLine();
        System.out.println("\n" + "=".repeat(50));

        System.out.println("## Jugando con Instant:");
        Instant instanteInstant = Instant.now();
        System.out.println("instanteInicial= " + instanteInicial);
        System.out.println("instanteLocalDate= " + instanteLocalDate);
        System.out.println("instanteLocalTime= " + instanteLocalTime);
        System.out.println("instanteInstant= " + instanteInstant);

        System.out.println("Pulsa ENTER para continuar...");
        scan_in.nextLine();
        System.out.println("\n" + "=".repeat(50));

        System.out.println("\n## Jugando con Duration:");
        Instant instanteDuration = Instant.now();
        System.out.println("instanteDuration= " + instanteDuration);
        System.out.println("Duration.between(instanteInicial, Instant.now()) = "
                + (Duration.between(instanteInicial, Instant.now()).toMillis()) + " milisegundos");

        System.out.println("Pulsa ENTER para continuar...");
        scan_in.nextLine();
        System.out.println("\n" + "=".repeat(50));

        System.out.println("\n## Jugando con Period:");
        System.out.println("Tiempo para el examen: Period.between(localDateAhora, localDateParsedExamen).getDays() = "
                + (Period.between(localDateAhora, localDateParsedExamen).getDays()) + " días");
        System.out.println("Tiempo para las vacaciones: Period.between(localDateAhora, localDateOfVacaciones).getDays() = "
                + (Period.between(localDateAhora, localDateOfVacaciones).getDays()) + " días");
        System.out.println("Edad Fer: Period.between(localDateAhora, localDateParsedNacimientoFer) = "
                + (Period.between(localDateParsedNacimientoFer, localDateAhora)));

        Period edadFer = Period.between(localDateParsedNacimientoFer, localDateAhora);
        System.out.println("Edad Fer: Period.between(localDateParsedNacimientoFer, localDateAhora) = "
                + edadFer.getYears() + " años, " + edadFer.getMonths() + " meses y " + edadFer.getDays() + " días");

        System.out.println("\n" + "=".repeat(50));
        System.out.println("<=== BYE BYE");
        scan_in.close();
    }
}