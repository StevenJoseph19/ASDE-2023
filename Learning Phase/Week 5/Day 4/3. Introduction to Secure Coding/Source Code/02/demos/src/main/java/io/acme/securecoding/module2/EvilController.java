package io.acme.securecoding.module2;

public class EvilController {
	public Person updateAgeMaliciously(Person p) {
		p.name = "evil";
		p.age = 13;
		return p;
	}
}
