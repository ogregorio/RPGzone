
const sessionStore = {
	"token" : null
}

const init = () => {
	let session = JSON.parse( localStorage.getItem("session") );
	if(!session){
		session = sessionStore;
		localStorage.setItem("session", JSON.stringify(session));
	}
}//em qualque página precisa antes de tudo iniciar o armazenamento local da sessão

function injectFavicon(){

    let element = document.getElementsByTagName('head')[0];
        element.innerHTML +=
    `
    <link rel="shortcut icon" href="../assets/favicon.png" />
    <meta name="theme-color" content="#5e2a53">
    
    `;
}



function inject(){
	init();//chama a função que cria o armazenamento da sessão do usuário(localStorage);
}

function setWallpaperTime(){
	var data = new Date(); 
	var hour = data.getHours();
	var body = document.getElementsByTagName("body")[0];
	body.style.backgroundSize = 'cover';
	switch (hour) {
		case 0:
			body.style.backgroundImage = 'url("../assets/background-day/12.png")';
			break;
		case 1:
			body.style.backgroundImage = 'url("../assets/background-day/12.png")';
			break;
		case 2:
			body.style.backgroundImage = 'url("../assets/background-day/12.png")';
			break;
		case 3:
			body.style.backgroundImage = 'url("../assets/background-day/12.png")';
			break;
		case 4:
			body.style.backgroundImage = 'url("../assets/background-day/12.png")';
			break;
		case 5:
			body.style.backgroundImage = 'url("../assets/background-day/1.png")';
			break;
		case 6:
			body.style.backgroundImage = 'url("../assets/background-day/1.png")';
			break;
		case 7:
			body.style.backgroundImage = 'url("../assets/background-day/2.png")';
			break;
		case 8:
			body.style.backgroundImage = 'url("../assets/background-day/2.png")';
			break;
		case 9:
			body.style.backgroundImage = 'url("../assets/background-day/3.png")';
			break;
		case 10:
			body.style.backgroundImage = 'url("../assets/background-day/3.png")';
			break;
		case 11:
			body.style.backgroundImage = 'url("../assets/background-day/4.png")';
			break;
		case 12:
			body.style.backgroundImage = 'url("../assets/background-day/4.png")';
			break;
		case 13:
			body.style.backgroundImage = 'url("../assets/background-day/5.png")';
			break;
		case 14:
			body.style.backgroundImage = 'url("../assets/background-day/5.png")';
			break;
		case 15:
			body.style.backgroundImage = 'url("../assets/background-day/6.png")';
			break;
		case 16:
			body.style.backgroundImage = 'url("../assets/background-day/7.png")';
			break;
		case 17:
			body.style.backgroundImage = 'url("../assets/background-day/8.png")';
			break;
		case 18:
			body.style.backgroundImage = 'url("../assets/background-day/9.png")';
			break;
		case 19:
			body.style.backgroundImage = 'url("../assets/background-day/10.png")';
			break;
		case 20:
			body.style.backgroundImage = 'url("../assets/background-day/10.png")';
			break;
		case 21:
			body.style.backgroundImage = 'url("../assets/background-day/11.png")';
			break;
		case 22:
			body.style.backgroundImage = 'url("../assets/background-day/11.png")';
			break;
		case 23:
			body.style.backgroundImage = 'url("../assets/background-day/12.png")';
			break;
	}
}

/* Execution trace */
injectFavicon();
inject();
setWallpaperTime();
