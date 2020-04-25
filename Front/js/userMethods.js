const loadUser = () => {
	let nick = document.querySelector("#nick-field");
	let id = document.querySelector("#id-field");
	let lastLogin = document.querySelector("#last-login-field");
	let proState = document.querySelector("#pro-state-field");
	let totalPlayers = document.querySelector("#total-players-field");
	Fetch.getAuth(`http://localhost:9090/account`)
	.then( res => {
		nick.innerHTML = "My nick: " + res.nickName;
		id.innerHTML = "My ID: " + res.userID;
		lastLogin.innerHTML = "My Last Login: " + res.lastLogin;
		proState.innerHTML = "My PRO state: " + res.pro;
	})
	.catch(_ => {
		window.alert("Error");
	});
	
	Fetch.getAuth("http://localhost:9090/user/account/quantity")
	.then( res => {
		totalPlayers.innerHTML = "Total Players: " + res;
	})
	.catch(_ => {
		window.alert("Error");
	});
}

const loadProfile = () => {
	let profilePicture = document.querySelector("#profile-picture");
	Fetch.getAuth(`http://localhost:9090/account`)
	.then( res => {
		profilePicture.src = res.profilePicture;
	})
	.catch(_ => {
		window.alert("Error");
	});
	
}

const updateProfile = () => {
	let password = document.getElementsByName("password")[0].value;
	let matchPassword = document.getElementsByName("matchpassword")[0].value;
	let email = document.getElementsByName("email")[0].value;
	let nick = document.getElementsByName("nickname")[0].value;
	let bio = document.getElementsByName("bio")[0].value;
	
	const token = JSON.parse(localStorage.getItem("session")).token;
	
	const data = {
		"bio" : bio,
		"password" : password,
		"nickName" : nick,
		"email" : email
	}
	
	Fetch.putAuth("http://localhost:9090/user", data)
	.then( resp => {
		console.log(resp);
	})
	.catch(_ => {
		window.alert("Error");
	});
}