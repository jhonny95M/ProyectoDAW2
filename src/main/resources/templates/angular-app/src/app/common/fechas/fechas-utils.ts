export const obtenerHora = (fechaString: string | Date): string => {
    const fecha = new Date(fechaString);
    const horas = fecha.getHours();
    const minutos = fecha.getMinutes();
    const segundos = fecha.getSeconds();
  
    const horaFormateada = `${agregarCeros(horas)}:${agregarCeros(minutos)}:${agregarCeros(segundos)}`;
  
    return horaFormateada;
  };
  
  // Función auxiliar para agregar ceros a los números menores a 10
  const agregarCeros = (numero: number): string => {
    return numero < 10 ? `0${numero}` : `${numero}`;
  };
  