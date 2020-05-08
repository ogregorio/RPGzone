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
	let password = document.getElementsByName("password")[0];
	let matchPassword = document.getElementsByName("matchpassword")[0];
	let email = document.getElementsByName("email")[0];
	let nick = document.getElementsByName("nickname")[0];
	let bio = document.getElementsByName("bio")[0];
	let profilePicture = document.querySelector("#profile-picture");
	Fetch.getAuth(`http://localhost:9090/account`)
	.then( res => {
		profilePicture.src = res.profilePicture;
		password.value = res.password;
		email.value = res.email;
		nick.value = res.nickName;
		bio.value = res.bio;
		matchPassword.value = res.password;
	})
	.catch(_ => {
		window.alert("Error");
	});
}

const updateProfile = () => {
	let password = document.getElementsByName("password")[0];
	let matchPassword = document.getElementsByName("matchpassword")[0];
	let email = document.getElementsByName("email")[0];
	let nick = document.getElementsByName("nickname")[0];
	let bio = document.getElementsByName("bio")[0];
	
	const token = JSON.parse(localStorage.getItem("session")).token;
	
	const data = {
		"bio" : bio.value,
		"password" : password.value,
		"nickName" : nick.value,
		"email" : email.value
	}
	
	Fetch.putAuth("http://localhost:9090/user", data)
	.then( resp => {
		window.location.href = "./my-profile.html";
	})
	.catch(_ => {
		window.alert("Error");
	});
}


const selectedThisRoom = roomID => {
	Fetch.postAuthWithoutResponse(`http://localhost:9090/rooms/${roomID}` )
	.then( () => {
		window.alert("Insert with success in Room!!!");
		searchRooms();
	})
	.catch (_ => {
		window.alert("Room Full!!!");
	});
}

function isNumeric(str)
{
  var er = /^[0-9]+$/;
  return (er.test(str));
}

const searchKeyword = (props) => {
	const { room, searchField, filters  } = props;
	let finded = false;
	let content = "";
	let searchFieldText = isNumeric(searchField.value) ? searchField.value : ( searchField.value ).toUpperCase();
	
	const waysOfCompare = {
		"compareByNick" : () => {
			window.alert(searchFieldText);
			window.alert(room.roomNick.toUpperCase());
			window.alert(( room.roomNick ).toUpperCase() == searchFieldText);
			return ( room.roomNick ).toUpperCase() == searchFieldText;
		},
		"compareByID" : () => {
			return room.roomID == searchFieldText;
		},
		"compareByPlayer" : () => {
			let findedUser = false;
			room.users.forEach( user => {
				if( ( user.nickName ).toUpperCase() == searchFieldText )
					findedUser = true;
			});
			return findedUser;
		},
		"compareByGame" : () => {
			if(room.roomConfig != null)
				return ( room.roomConfig.game.title ).toUpperCase() == searchFieldText;
			return false;
		},
		"default" : () => {
			return false;
		}
	}
	for(let i = 0; (!finded) && (i < filters.length); i++){
		finded = waysOfCompare[filters[i]]();
	}
	return finded	? `
						<div>
							<span> - ID : ${room.roomID}</span><br/><br/>
							<span> - Room Nick : ${room.roomNick}</span><br/><br/>
							<span> - Room Description : ${room.roomDescription}</span><br/><br/>
							<span> - Room Game : ${ room.roomConfig != null ? room.roomConfig.game.title : "null"}</span><br/><br/>
							<span> - Qtd players : ${ room.qtdeUsersInRoom}</span><br/><br/>
							<button onclick=selectedThisRoom(${room.roomID})>Enter in this room</button>
						</div> ` 
					: " ";
	
}

const searchRooms = () => {
	let myRooms = new Array();
	Fetch.getAuth("http://localhost:9090/rooms/myrooms")
	.then( resp => {
		resp.forEach( room => {
			myRooms.push(room.roomID);
		});
		searchExec(myRooms);
	})
	.catch(_ => {
		console.log("Error Ocurred in request myRooms");
	});
}

const searchExec = myRooms => {
	let filters = document.getElementsByName("option");
	let searchField = document.querySelector("#search");
	let searchResult = document.querySelector("#search-result");
	let content = "";
	Fetch.getAuth("http://localhost:9090/rooms")
	.then( resp => {
		if(searchField.value == ""){
			resp.forEach( room => {
				content +=  (myRooms.indexOf(room.roomID) == -1) 	&&
							(parseInt(room.qtdeUsersInRoom) < 6) 	? 
																	`	<div>
																			<span> - ID : ${room.roomID}</span><br/><br/>
																			<span> - Room Nick : ${room.roomNick}</span><br/><br/>
																			<span> - Room Description : ${room.roomDescription}</span><br/><br/>
																			<span> - Room Game : ${ room.roomConfig != null ? room.roomConfig.game.title : "null"}</span><br/><br/>
																			<span> - Qtd players : ${ room.qtdeUsersInRoom}</span><br/><br/>
																			<button onclick=selectedThisRoom(${room.roomID})>Enter in this room</button>
																		</div>`
																	:
																		" ";
			});
		}
		else{
			resp.forEach( room => {
				content +=  (myRooms.indexOf(room.roomID) == -1) 	&&
							(parseInt(room.qtdeUsersInRoom) < 6)  	?
																		searchKeyword({
																			"room" : room,
																			"searchField" : searchField,
																			"filters" : [
																				filters[0].checked ? "compareByNick" : "default",
																				filters[1].checked ? "compareByID" : "default",
																				filters[2].checked ? "compareByPlayer" : "default",
																				filters[3].checked ? "compareByGame" : "default", 
																			]
																		})
																	: 
																		"";
			});
		}
		searchResult.innerHTML = content;
	})
	.catch(_ => {
		window.alert("Error");
	});
}

const enterInThisRoom = roomID => {
	window.location.href = "./room.html";
}


const redirectSearchRoom = () => window.location.href = "./room-search.html";

const loadMyRooms = () => {
	let roomsResult = document.querySelector("#rooms-result");
	let content = "";
	let count = 0;
	let nullContent = 	`<div>
							<span> - Nothing yet...</span><br/><br/>
							<span style="cursor: pointer;" onclick="redirectSearchRoom();" >     -> CLICK HERE FOR SEARCH ROOMS</span><br/><br/>
						</div>`;
	Fetch.getAuth("http://localhost:9090/rooms/myrooms")
	.then( resp => {
		resp.forEach( room => {
			content += `	<div>
								<span> - ID : ${room.roomID}</span><br/><br/>
								<span> - Room Nick : ${room.roomNick}</span><br/><br/>
								<span> - Room Description : ${room.roomDescription}</span><br/><br/>
								<span> - Room Game : ${ room.roomConfig != null ? room.roomConfig.game.title : "null"}</span><br/><br/>
								<span> - Qtd players : ${ room.qtdeUsersInRoom}</span><br/><br/>
								<button onclick=enterInThisRoom(${room.roomID})>Enter in this room</button>
							</div>`;
			count++;
		});
		
		roomsResult.innerHTML = (count == 0) ? nullContent : content;
	})
	.catch(_ => {
		console.log("Error Ocurred in request myRooms");
	});
}