package medlem;


public interface  TypeHobby {
	String type();
}

class Type1 implements TypeHobby{
	@Override
	public String type() {
		return "Hobby1";
	}
}
class Type2 implements TypeHobby{
	@Override
	public String type() {
		return "Hobby2";
	}
}
class Type3 implements TypeHobby{
	@Override
	public String type() {
		return "Hobby3";
	}
}

class Type4 implements TypeHobby{
	@Override
	public String type() {
		return "Hobby4";
	}
}
class Type5 implements TypeHobby{
	@Override
	public String type() {
		return "Hobby5";
	}
}
class Type6 implements TypeHobby{
	@Override
	public String type() {
		return "Hobby6";
	}
}