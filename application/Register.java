package application;

import user.*;
import utils.Reader;
public class Register {
	
	public static Normal newUser() {
		return new Normal(Reader.readString("email"), Reader.readString("password"), Reader.readString("nickname"), Reader.readString("type"), Reader.readBoolean("pro"), User.generateUserID() );
	}
}
