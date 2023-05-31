package EV3.ejercicioempresaprogramacionprivate.empresaprogramacionprivate;

import EV3.ejercicioempresaprogramacionprivate.empresaprogramacionprivate.excepciones.ParametroInvalidoException;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Empresa {

  private String nombre;
  private Map<String, Empleado> mapaEmpleados;
  static final String PATH_PROGRAMADORES = "programadores.csv";
  static final String PATH_GERENTES = "gerentes.csv";
  static final String PATH_EMPLEADOS = "empleados.csv";
  static final String SALTO_LINEA = "\n";

  public Empresa(String nombre) {
    this.nombre = nombre;
    this.mapaEmpleados = new HashMap<>();
  }

  public String getNombre() {
    return nombre;
  }

  public Map<String, Empleado> getMapaEmpleados() {
    return mapaEmpleados;
  }

  public void addEmpleado(Empleado empleado) throws ParametroInvalidoException {
    if(mapaEmpleados.containsKey(empleado.getDniEmpleado())) {
      throw new ParametroInvalidoException("El empleado con DNI "+empleado.getDniEmpleado()+" ya existe");
    } else {
      mapaEmpleados.put(empleado.getDniEmpleado(), empleado);
    }
  }

  public void guardarEnCSV(String nombreTipo) {
    if (nombreTipo.equalsIgnoreCase(TipoEmpleado.PROGRAMADOR.toString())){
      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_PROGRAMADORES))){
        for (Empleado empleado : mapaEmpleados.values()) {
          if (empleado instanceof Programador){
            bufferedWriter.write(empleado.toCsvLine());
            bufferedWriter.newLine();
          }
        }
        System.out.println(SALTO_LINEA + "Guardado en el archivo '"+PATH_PROGRAMADORES+"'"+SALTO_LINEA);
      } catch (IOException e) {
        System.out.println("Error al guardar en el archivo '"+PATH_PROGRAMADORES+"': "+e.getMessage());
      }
    }else if (nombreTipo.equalsIgnoreCase(TipoEmpleado.GERENTE.toString())){
      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_GERENTES))){
        for (Empleado empleado : mapaEmpleados.values()) {
          if (empleado instanceof Gerente){
              bufferedWriter.write(empleado.toCsvLine());
              bufferedWriter.newLine();
          }
        }
        System.out.println(SALTO_LINEA+"Guardado en el archivo '"+PATH_GERENTES+"'"+SALTO_LINEA);
      } catch (IOException e) {
          System.out.println("Error al guardar en el archivo '"+PATH_GERENTES+"': "+e.getMessage());
      }
    }else{
      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_EMPLEADOS))){
        for (Empleado empleado : mapaEmpleados.values()) {
          bufferedWriter.write(empleado.toCsvLine());
          bufferedWriter.newLine();
        }
        System.out.println(SALTO_LINEA+"Guardado en el archivo '"+PATH_EMPLEADOS+"'"+SALTO_LINEA);
      } catch (IOException e) {
        System.out.println("Error al guardar en el archivo '"+PATH_EMPLEADOS+"': "+e.getMessage());
      }
    }
  }

  public void cargarDesdeCSV(String archivoCargar) {
    Empleado empleado;
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(archivoCargar))) {
      String linea;
      String[] datos;
      while ((linea = bufferedReader.readLine()) != null) {
        datos = linea.split(Empleado.SEPARADOR_CSV);
        if (datos[4].equalsIgnoreCase(TipoEmpleado.PROGRAMADOR.toString())) {
          empleado = new Programador(datos[0], datos[1], Double.parseDouble(datos[2]), Boolean.parseBoolean(datos[3]), LocalDate.parse(datos[5]));
          addEmpleado(empleado);
        } else {
          try {
            empleado = new Gerente(datos[0], datos[1], Double.parseDouble(datos[2]), datos[3], LocalDate.parse(datos[5]));
            addEmpleado(empleado);
          }catch (NumberFormatException e){
            System.out.println("El campo sueldo del archivo: '" + archivoCargar + "' está mal formado y no es parseable. Se ha seteado el sueldo a 0.");
            empleado = new Gerente(datos[0], datos[1], 0.0, datos[3], LocalDate.parse(datos[5]));
            addEmpleado(empleado);
          }
        }
      }
    } catch (IOException e) {
      System.out.println("Error al cargar desde el archivo '" + archivoCargar + "': " + e.getMessage());
    } catch (ParametroInvalidoException e) {
      System.out.println("Error al crear el usuario. "+e.getMessage());
    }
  }

  @Override
  public String toString() {
    return SALTO_LINEA+nombre+SALTO_LINEA+toStringEmpleados();
  }

  public String toStringEmpleados() {
    String empleados = "Lista de empleados:"+SALTO_LINEA;
    for (Empleado empleado : mapaEmpleados.values()) {
      empleados += empleado.toString() + SALTO_LINEA;
    }
    return empleados;
  }

  public String toStringProgramadores() {
    String programadores = SALTO_LINEA+"Lista de programadores:"+SALTO_LINEA;
    for (Empleado empleado: mapaEmpleados.values()){
        if (empleado instanceof Programador){
            programadores += empleado + SALTO_LINEA;
        }
    }
    return programadores;
  }

  public String toStringOrdenSueldo() {
    ArrayList<Empleado> listaEmpleados = new ArrayList<>(mapaEmpleados.values());
    listaEmpleados.sort(Empleado.COMPARATOR_SUELDO.reversed());
    String listaEmpleadosOrdenadosPorSueldo = SALTO_LINEA+"Lista de empleados ordenados por sueldo:"+SALTO_LINEA;
    for(Empleado empleado: listaEmpleados){
      listaEmpleadosOrdenadosPorSueldo += empleado + SALTO_LINEA;
    }
    return listaEmpleadosOrdenadosPorSueldo;
  }

  public String toStringOrdenNombre() {
    ArrayList<Empleado> listaEmpleados = new ArrayList<>(mapaEmpleados.values());
    Collections.sort(listaEmpleados);
    String listaEmpleadosOrdenadosPorNombre = SALTO_LINEA+"Lista de empleados ordenados por nombre:"+SALTO_LINEA;
    for(Empleado empleado: listaEmpleados){
      listaEmpleadosOrdenadosPorNombre += empleado + SALTO_LINEA;
    }
    return listaEmpleadosOrdenadosPorNombre;
  }
}