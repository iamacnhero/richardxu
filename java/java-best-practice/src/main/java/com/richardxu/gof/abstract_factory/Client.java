package com.richardxu.gof.abstract_factory;

/**
 * 设计模式(AbstractFactory): http://code.uml.com.cn/code/brocode2.asp?codeID=12 
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2015年11月21日
 */
public class Client {
	public static void main(String[] args) {
		Country country = new China();
		Person person = country.createPerson();
		Language language = country.createLanguage();
		String words = language.getWords();
		person.speak(words);
	}
}
