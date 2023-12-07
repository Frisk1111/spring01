

function createAndAppendElement(type, container) {
    const element = document.createElement(type);  // creare un elemento (serve il type)
    container.appendChild(element); // appendere l'elemento (serve il container)
    return element; // rendere disponibile l'elemento per l'elaborazione
}

function createAndAppendTextNode(text, container) {
    let textNode = document.createTextNode(text);
    container.appendChild(textNode); // appendere l'elemento (serve il container)
    return textNode;
}