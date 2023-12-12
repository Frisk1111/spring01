export async function getJson() {
    const response = await fetch('/src/json/province.json');
 
    if (response.ok) {
        return await response.json();
    } else {
        throw new Error('Request failed');
    }
}