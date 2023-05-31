package EV3.examen3evaluacion.ej2;

public abstract class Animal {
  String nombre;
  int edad;
  float peso;
  TipoAnimal tipo;

  public Animal(String nombre, int edad, float peso, TipoAnimal tipo)  {
    this.nombre = nombre;
    this.edad = edad;
    this.peso = peso;
    this.tipo = tipo;
  }

  public String getNombre(){
    return nombre;
  }

  public int getEdad() {
    return edad;
  }

  public float getPeso() {
    return peso;
  }

  public TipoAnimal getTipo(){
    return tipo;
  }

  public boolean comprobarNombre() throws ParametroInvalidoException{
    if (this.nombre.equalsIgnoreCase("")){
      throw new ParametroInvalidoException("Nombre vacío");
    }else{
      return true;
    }
  }

  public boolean comprobarEdad() throws ParametroInvalidoException{
    if(this.edad < 0){
      throw new ParametroInvalidoException("Edad inválida: "+ edad);
    }else{
      return true;
    }
  }

  public boolean comprobarPeso() throws ParametroInvalidoException{
    if (this.peso <= 0 ){
      throw new ParametroInvalidoException("Peso inválido: "+ peso);
    }else {
      return true;
    }
  }

  @Override
  public String toString() {
    return tipo+": "+nombre+", "+edad+" años, '"+String.format("%.2f", peso)+"' kilos";
  }
}
