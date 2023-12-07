async function getJson(url, processFunction) {
    // vado a leggere lo stream json contenente le regioni da disco
    // mi ritorna una promise (=promessa che potrà venir mantenuta o fallire)
    const response = await fetch(url);

    // converto la stringa in fomato json in un array di oggetti javascript
    const jsonObject = await response.json();

    // passo i dati ricavati alla funzione di elaborazione dati
    processFunction(jsonObject);
}



async deleteFunction(){


}
/*
  // sintassi nativa per le promise
const prom01 = fetch("http://localhsot/clienti");
const prom02 = prom01.then( response => response.json() )
const prom03 = prom02.then( dati => console.log(dati) );


fetch("json/regioni_updated.json")
    .then( response => response.json() )
    .then( dati => console.log(dati) )
    .error(err => console.log(err) );

*/