const apiKey = 'gEDeWAK4aqBfdsi3N9uXGFINbe2lz1ulkOGJIpDP';
const sol = 1000; // El número de sol que deseas consultar

// URL del API de la NASA
const apiUrl = `https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=${sol}&api_key=${apiKey}`;

// Realizar una solicitud GET utilizando Fetch API
fetch(apiUrl)
  .then((response) => {
    if (!response.ok) {
      throw new Error('Error en la solicitud al API');
    }
    return response.json();
  })
  .then((data) => {
    // Los datos de las fotos se encuentran en el objeto 'data'
    console.log(data);

 
    // Aquí puedes procesar los datos o mostrar las imágenes en tu aplicaciónfor ()
    const img = document.getElementById("img");

    for (let index = 0; index < data.photos.length ; index++) {
       const valor=data.photos[index].img_src;
       const imageElement = document.createElement("img");
       imageElement.src=valor;
      img.appendChild(imageElement);
    }
  })
  .catch((error) => {
    console.error('Ocurrió un error:', error);
  });