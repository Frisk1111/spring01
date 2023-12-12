<script>
    //sempre tra le parentesi graffe!!
    //altrimenti non sa dove prenderlo!
import {getJson} from '../net.js';
import Provincia from './Provincia.svelte';

let promise= getJson();
</script>

<table>

<tr>

    <th>id</th>
    <th>id_regione</th>
    <th>codice_citta_metropolitana</th>
    <th>nome</th>
    <th>sigla automobilistica</th>
    <th>latitudine</th>
    <th>longitudine</th>

</tr>


{#await promise};
{:then province}
{#each province as provincia}
<!-- <div>{JSON.stringify(province)}</div>     -->

<Provincia provincia={provincia}/>


{/each}
{/await}


</table>


<style>



table, tr, th{
border: 1px solid blue;
border-collapse: collapse;

}



</style>


