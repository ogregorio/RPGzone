const sessionStore = {
	"token" : null
}

const init = () => {
	let session = JSON.parse( localStorage.getItem("session") );
	if(!session){
		session = sessionStore;
		localStorage.setItem("session", JSON.stringify(session));
	}
}