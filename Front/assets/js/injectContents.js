function inject(){
	document.getElementById("body").innerHTML;
	init();//chama a função que cria o armazenamento da sessão do usuário(localStorage);
}

const alreadyLogged = () => {
	const session = JSON.parse(localStorage.getItem("session"));
	if(session.token != null){
		window.location.href = "./dashboard.html";
	}
}
