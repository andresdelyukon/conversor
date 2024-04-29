import java.util.Map;
import java.util.Scanner;

    class ConversorDeMoneda  {

        //linea para hacer un push

        public String seleccionarMoneda(Scanner lectura) {
            System.out.println("Ingrese la moneda de origen, tome como guía el menú: ");
            int eleccion = lectura.nextInt();
            String moneda = "";


            if (eleccion == 1 ) {
                moneda = "USD";

            }else if(eleccion == 3){
                moneda = "USD";
            }
            else if(eleccion == 5){
                moneda = "USD";
            }

            else if (eleccion == 2) {
                moneda = "ARS";

            } else if (eleccion == 4) {
                moneda = "BRL";
            } else if (eleccion == 6) {
                moneda = "COP";
            } else {
                System.out.println("Escriba el código de la moneda (por ejemplo, USD): ");
                // Limpiar el buffer del Scanner antes de leer la próxima entrada
                lectura.nextLine();
                moneda = lectura.nextLine();
            }

            return moneda;
        }

        public void realizarConversion(ExchangeRateApiResponse miRespuesta, int eleccion, double valor) {
            String moneda;
            Scanner lectura = new Scanner(System.in);
            String moneda2 = "";
            if(eleccion == 1){
                moneda = "ARS"; //
                moneda2 = "USD";
            }
            else if(eleccion == 2){
                moneda = "USD";
                moneda2 = "ARS";
            } else if (eleccion == 4) {
                moneda = "USD";
                moneda2 = "BRL";
            } else if (eleccion == 5) {
                moneda = "USD";
                moneda2 = "COP";
            } else if(eleccion== 3){
                moneda = "BRL";
                moneda2 = "USD";
            }else if(eleccion==6){
                moneda = "COP";
                moneda2 = "USD";
            }
            else {
                System.out.println("Escriba el código de la moneda (por ejemplo, USD): ");
                // Limpiar el buffer del Scanner antes de leer la próxima entrada
                lectura.nextLine();
                moneda = lectura.nextLine();
            }

            // Obtener las tasas de conversión del objeto ExchangeRateApiResponse
            Map<String, Double> conversionRates = miRespuesta.getConversion_rates();

            // Obtener la tasa de conversión para la moneda seleccionada
            double tasaDeConversion = conversionRates.get(moneda);

            // Realizar la conversión multiplicando el valor por la tasa de conversión
            double resultado = valor * tasaDeConversion;


            // Imprimir el resultado de la conversión
            System.out.println("El valor de " + valor + " " + moneda2 + " es equivalente a " + resultado + moneda);
        }

    }
