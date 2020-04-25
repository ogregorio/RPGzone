
const signUp = () => {
	if(inputIsValid()){
		const data = {
			"password" : `${document.getElementsByName("password")[0].value}`,
			"nickName" : `${document.getElementsByName("nickname")[0].value}`,
			"email" : `${document.getElementsByName("email")[0].value}`,
			"type" : "normal"
		}
		Fetch.post("http://localhost:9090/user", data)
		.then( () => {
			let session = JSON.parse(localStorage.getItem("session"));
			session.token = null;
			localStorage.setItem("session", JSON.stringify(session));
			setTimeout( () => {
				window.location.href = "./home.html";
			}, 1000);
		});
	}
}

const inputIsValid = () => {
	return document.getElementsByName("password")[0].value == document.getElementsByName("matchpassword")[0].value;
}

const signIn = () => {
	const session = JSON.parse( localStorage.getItem("session") );
	const data = {
		"password" : `${document.getElementsByName("password")[0].value}`,
		"nickName" : `${document.getElementsByName("nickname")[0].value}`
	}
	Fetch.post("http://localhost:9090/auth/login", data)
	.then( resp => {
		//resp.token já é o token
		session.token = resp.token;//armazenando o token jwt para o usuário estar autenticado em requisições posteriores
		localStorage.setItem("session", JSON.stringify(session));
		setTimeout( () => {
			window.location.href = "./dashboard.html";
		}, 1000);
	})
	.catch(_ => {
		window.alert("An Error occurred with your credentials try sign up in sign up page");
	});
}