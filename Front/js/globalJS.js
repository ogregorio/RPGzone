function injectFavicon(){

    var element = document.getElementsByTagName('head')[0];
        element.innerHTML +=
    `
    <link rel="shortcut icon" href="../assets/favicon.png" />
    <meta name="theme-color" content="#5e2a53">
    
    `;
    }
 
/* Execution trace */
injectFavicon();