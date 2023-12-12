<script>
    const colors = ['red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'violet'];
    let selected = colors[1];
 
    function click() {
        alert("Click()");
    }
 
    $: console.log(selected);
 
    const lettere = ['a', 'b', 'c', 'd', 'e']
</script>
 
<p>colore selezionato {selected}</p>
<p style="color: {selected}">lorem ipsum....</p>
 
{#each lettere as lettera, indice}
    <p style="color: {selected}">{indice} - {lettera}</p>
{/each}
 
{#each colors as colore, indice}
    <button style="background: {colore}" on:click={() => selected = colore}>
        {indice}
    </button>
{/each}