# SerpAPI y Google Scholar API

En esta página se proporciona información detallada sobre dos APIs: SerpAPI y Google Scholar API. A continuación, se describen las ventajas, desventajas, funcionalidades, casos de uso y ejemplos de uso de cada API. Además, se incluyen referencias adicionales para obtener más información sobre estas herramientas.

# SerpAPI

SerpAPI es una herramienta poderosa que permite acceder a los resultados de búsqueda de Google de manera programática. A continuación, se detallan algunas ventajas y desventajas de esta API:

### Ventajas

- Acceso a datos de búsqueda en tiempo real.
- Permite extraer información relevante de los resultados de búsqueda, como títulos, descripciones y URLs.
- Ofrece una interfaz sencilla de usar y una documentación completa.
- Permite, a demás de realizar peticiones HTTP directas, integrar la API a distintos lenguajes de programación por medio de librerías.
- Soporte para distintos motores de búsqueda tales como, Google, Bing, YouTube, EBay, DuckDuckGo, etc.

### Desventajas

- Requiere conocimientos técnicos para su implementación y uso.
- El acceso a la API puede tener costos asociados dependiendo del uso y plan seleccionado.

### Funcionalidades más relevantes

- Búsqueda de resultados orgánicos y patrocinados.
- Extracción de datos estructurados, como snippets enriquecidos y fragmentos destacados.
- Obtención de información sobre anuncios publicitarios.
- Acceso a la herramienta de búsqueda inversa de imágenes.

### Casos de uso

- Obtener datos para investigaciones académicas o de mercado.
- Monitorear la visibilidad y rendimiento de una marca en los resultados de búsqueda.
- Automatizar tareas de extracción de datos relacionados con búsquedas en Google.

### Ejemplo de uso

- Petición GET a endpoint:
    
    `https://serpapi.com/search?api_key=*********&q=5 lenguajes de programacion mas utilizados en 2023`
    
    ![imagen](https://github.com/Amhernandez5508/digital-nao-challenge1/assets/121590490/2f18a28e-5605-4943-bcd3-4cca908eab80)

    
- Integración con Java:
    
    ```java
    String apiKey = "*********";
    Map<String, String> parameter = new HashMap<>();
    
    parameter.put("engine", "google");
    parameter.put("q", "5 lenguajes de programacion mas utilizados en 2023");
    parameter.put("api_key", apiKey);
    
    GoogleSearch search = new GoogleSearch(parameter);
    
    try
    {
      JsonObject results = search.getJson();
      var organic_results = results.get("organic_results");
    }
    catch (SerpApiClientException ex)
    {
      Console.WriteLine("Exception:");
      Console.WriteLine(ex.ToString());
    }
    ```
    

![imagen](https://github.com/Amhernandez5508/digital-nao-challenge1/assets/121590490/bef88915-f473-44ec-b95f-443c08389c8b)

Referencias:
- https://serpapi.com/
- https://serpapi.com/search-api
- https://learn.microsoft.com/es-es/azure/machine-learning/prompt-flow/tools-reference/serp-api-tool?view=azureml-api-2

![imagen](https://github.com/Amhernandez5508/digital-nao-challenge1/assets/121590490/645e2dca-b347-49eb-a1d0-b566c4290433)

---

# **Google Scholar API**

La API de Google Scholar es una herramienta valiosa para acceder a la base de datos académica de Google Scholar de manera programática. A continuación, se detallan algunas ventajas y desventajas de esta API:

### Ventajas:

- Proporciona acceso a una amplia gama de artículos académicos y publicaciones científicas.
- Permite realizar búsquedas avanzadas y filtrar resultados según criterios específicos.
- Ofrece información detallada sobre citas y referencias bibliográficas.
- Permite obtener datos estructurados, como resúmenes, autores y publicaciones relacionadas.
- Facilita el seguimiento de las últimas investigaciones y avances en un campo específico.

### Desventajas:

- El acceso completo a la API puede requerir una suscripción y tener costos asociados.
- Algunas funciones avanzadas pueden requerir conocimientos técnicos para su implementación y uso.

### Funcionalidades más relevantes:

- Búsqueda de artículos y publicaciones académicas.
- Obtención de citas y referencias bibliográficas.
- Filtrado de resultados según autor, fecha de publicación y revista científica.

### Casos de uso:

- Realizar investigaciones académicas y obtener referencias bibliográficas.
- Analizar la influencia y el impacto de un artículo o autor en la comunidad científica.
- Mantenerse actualizado con los últimos avances y descubrimientos en un campo específico.
- Realizar análisis comparativos de investigaciones y estudios científicos.

### Ejemplo de uso

- Petición GET a endpoint:
    
    `https://serpapi.com/search?engine=google_scholar&api_key=*********&q="desarrollo de software”`
    
    ![imagen](https://github.com/Amhernandez5508/digital-nao-challenge1/assets/121590490/00df9c54-3775-4cef-9d91-bd05a04c9991)
    
- Integración con Java:
    
    ```java
    String apiKey = "*********";
    Map<String, String> parameter = new HashMap<>();
    
    parameter.put("engine", "google_scholar");
    parameter.put("q", "desarrollo de software");
    parameter.put("api_key", apyKey);
    
    GoogleSearch search = new GoogleSearch(parameter);
    
    try
    {
      JsonObject results = search.getJson();
      var organic_results = results.get("organic_results");
    }
    catch (SerpApiClientException ex)
    {
      Console.WriteLine("Exception:");
      Console.WriteLine(ex.ToString());
    }
    ```
    

💡 Referencias:

- https://serpapi.com/
- https://serpapi.com/google-scholar-api

  ![imagen](https://github.com/Amhernandez5508/digital-nao-challenge1/assets/121590490/295be4a9-53ca-4622-883e-b3cc9d25d1e1)

