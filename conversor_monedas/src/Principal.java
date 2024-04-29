import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        ConversorDeMoneda conversor = new ConversorDeMoneda();

        System.out.println("Sea bienvenido/a al conversor de moneda");
        System.out.println("1) Dólar =>> Peso argentino\n 2) Peso argentino =>> Dólar \n 3) Dólar =>> Real Brasileño \n 4) Real brasileño =>> Dólar \n 5)Dólar =>> Peso Colombiano \n 6) Peso colombiano =>> Dólar 7) Salir");

        String moneda = conversor.seleccionarMoneda(lectura);
        System.out.println("Escriba el código de la moneda de destino. Tome como guía el menú:  ");
        int eleccion = lectura.nextInt();
        System.out.println("escriba el monto a convertir: ");
        double valor = lectura.nextDouble();





        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        String direccion = "https://v6.exchangerate-api.com/v6/39e11fb698e6b8e85a798f8e/latest/" + moneda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson1 = new Gson();
        ExchangeRateApiResponse miRespuesta = gson1.fromJson(json, ExchangeRateApiResponse.class);

        for (Map.Entry<String, Double> entry : miRespuesta.getConversion_rates().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        conversor.realizarConversion(miRespuesta, eleccion, valor);

        //esto requiere multiplicar el valor que el usuario mete por valor de la moneda de destino. seria en este caso 1 X 854.75


    }
}
