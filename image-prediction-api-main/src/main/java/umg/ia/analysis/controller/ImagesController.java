package umg.ia.analysis.controller;


//import org.springframework.http.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

import okhttp3.*;
import umg.ia.analysis.model.Herramientas;
import umg.ia.analysis.service.HerramientasService;

@RestController
@RequestMapping("/images")
@CrossOrigin("*")
public class ImagesController {

    @Autowired
    private HerramientasService herramientasService;


    private static final String PREDICTION_KEY = "f6d0be6923de432bb370fd0205a124c3";
    //private static final String ENDPOINT_URL = "https://customvisioniatools-prediction.cognitiveservices.azure.com/customvision/v3.0/Prediction/a4f44e76-7ba2-4d13-8fb5-dff6c209f437/classify/iterations/ToolsClassification/image";
    private static final String ENDPOINT_URL = "https://customvisioniatools-prediction.cognitiveservices.azure.com/customvision/v3.0/Prediction/a4f44e76-7ba2-4d13-8fb5-dff6c209f437/classify/iterations/ToolsClassification1/image";

    @GetMapping("/find-by-category")
    public List<Herramientas> getHerramientas(@RequestParam("categoria") String categoria) {
        System.out.println("CATEGORIA : " + categoria);
        return herramientasService.findPorCategoria(categoria);
    }

    @PostMapping("/prediction-img")
    public ResponseEntity<List<Herramientas>> analyzeImage(@RequestParam("file") MultipartFile file) throws IOException {
        // Crear un cliente HTTP para realizar la solicitud
        OkHttpClient client = new OkHttpClient();

        // Convertir el archivo recibido en un array de bytes
        byte[] byteData = convertMultipartFileToBytes(file);

        // Crear el cuerpo de la solicitud con el tipo de medio 'application/octet-stream'
        RequestBody requestBody = RequestBody.create(byteData, MediaType.parse("application/octet-stream"));

        // Construir la solicitud HTTP, estableciendo la URL y añadiendo las cabeceras necesarias
        Request request = new Request.Builder()
                .url(ENDPOINT_URL) // URL del endpoint
                .post(requestBody) // Cuerpo de la solicitud
                .addHeader("Prediction-Key", PREDICTION_KEY) // Añadir la clave de predicción
                .addHeader("Content-Type", "application/octet-stream") // Establecer el tipo de contenido
                .build();

        JsonNode predictionsNode = null;
        // Ejecutar la solicitud y manejar la respuesta
        try (Response response = client.newCall(request).execute()) {
            // Verificar si la respuesta no fue exitosa y lanzar una excepción en caso contrario
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Convertir la respuesta a un objeto JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResponse = response.body().string(); // Obtener la respuesta en formato String
            Object responseObject = objectMapper.readValue(jsonResponse, Object.class); // Convertir la respuesta en un objeto

            // Acceder a las propiedades del objeto JSON
            String id = objectMapper.convertValue(responseObject, JsonNode.class).get("id").asText(); // Obtener el ID
            String project = objectMapper.convertValue(responseObject, JsonNode.class).get("project").asText(); // Obtener el proyecto
            String created = objectMapper.convertValue(responseObject, JsonNode.class).get("created").asText(); // Obtener la fecha de creación

            // Acceder a las predicciones del objeto JSON
            predictionsNode = objectMapper.convertValue(responseObject, JsonNode.class).get("predictions");
        }

        // Devolver una respuesta HTTP con la lista de herramientas encontradas según la categoría de la predicción
        return ResponseEntity.ok(herramientasService.findPorCategoria(predictionsNode.get(0).get("tagName").asText()));
    }


   /* String urlImage = "https://aka.ms/azsdk/image-analysis/sample.jpg";
    @GetMapping("/analizar-url/{url}")
    public ResponseEntity<String> analizar(@RequestParam("url") String url) {

        ImageAnalysisOptions options = new ImageAnalysisOptions()
                .setLanguage("en")
                ;

        ImageAnalysisClient client = new ImageAnalysisClientBuilder()
                .endpoint(endpoint)
                .credential(new KeyCredential(key))
                .buildClient();

        ImageAnalysisResult result = client.analyzeFromUrl(
                url, // imageUrl: the URL of the image to analyze
                Arrays.asList(VisualFeatures.CAPTION), // visualFeatures
                options);

        return ResponseEntity.ok("DESCRIPCION DE IMAGEN: " +  traducirTexto(result.getCaption().getText()));
    }

    @PostMapping("/analizar-img")
    public ResponseEntity<Map<String, String>> analizarImg(@RequestParam("file") MultipartFile file) throws IOException {

        File tempFile = convertMultiPartToFile(file);

        ImageAnalysisOptions options = new ImageAnalysisOptions().setLanguage("en");

        ImageAnalysisClient client = new ImageAnalysisClientBuilder()
                .endpoint(endpoint)
                .credential(new KeyCredential(key))
                .buildClient();

        ImageAnalysisResult result = client.analyze(
                BinaryData.fromFile(tempFile.toPath()), // imageData: Image file loaded into memory as BinaryData
                Arrays.asList(VisualFeatures.CAPTION), // visualFeatures
                options); //new ImageAnalysisOptions().setGenderNeutralCaption(true)
        //return ResponseEntity.ok(traducirTexto(result.getCaption().getText()));
        System.out.println("EN : " + result.getCaption().getText());
        Map<String, String> response = new HashMap<>();
        response.put("message", traducirTexto(result.getCaption().getText()));
        return ResponseEntity.ok(response);
    }
*/

    /* @GetMapping("/prueba-traductor")
      public ResponseEntity<String> translate() throws IOException {
          TranslatorText traslate = new TranslatorText();
          String response =  traslate.traducirTexto();
          System.out.println("TRADUCCION : " + response);
          return ResponseEntity.ok(response);
      }*/
/*
    public String traducirTexto(String texto){
        TranslatorText traslate = new TranslatorText();
        String response =  traslate.traducirTexto(texto);
        return response;
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        }
        return convertedFile;
    }
*/
    public byte[] convertMultipartFileToBytes(MultipartFile file) {
        try {
            return file.getBytes();
        } catch (IOException e) {
            // Manejo de errores
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/find-by-code/{codigo}")
    public ResponseEntity<Herramientas> getHerramienta(@RequestParam("codigo") String codigo) {
        return ResponseEntity.ok(herramientasService.findByCodigo(codigo));
    }
}