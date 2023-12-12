<script>
// import EachDemo from './EachDemo.svelte';
// import Tasto from './Tasto.svelte';
import Province from './componenti/Province.svelte';
   
    function memorizzaNumero() {
        console.log("memorizzaNumero");
    }
 
    function eseguiOperazione() {
        console.log("eseguiOperazione");
    }
</script>
 
<svelte:head>
   
</svelte:head>
 
<section>
    <h1>Welcome</h1>
 
    <!-- <EachDemo/> -->
    <Province/>
 
   
</section>
 
<style>
 
    h1 {
        width: 100%;
    }
 
</style>

