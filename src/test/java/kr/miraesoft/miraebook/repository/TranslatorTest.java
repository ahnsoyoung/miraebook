package kr.miraesoft.miraebook.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import kr.miraesoft.miraebook.domain.Translator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/applicationContext.xml"})
public class TranslatorTest {

	@Inject 
	TranslatorRepository translatorRepository;


	@Test
	public void test() {
		// begin
		Translator translator = new  Translator(0, "Ȳ����");
		
		// then
		assertEquals("Ȳ����", translator.getName());
		
	}

	@Before
	public void ����������() {
		// begin
		Translator translator1 = new  Translator(1, "�ȼҿ�");
		Translator translator2 = new  Translator(2, "�庸��");
		// when
		translatorRepository.save(translator1);
		translatorRepository.save(translator2);
		// then
		assertEquals(2, translatorRepository.count());
		
	}
	

	@Test
	public void ������������������() {
		// begin
		Translator translator = new  Translator();
		translator.setId(1);
		
		// when
		translator = translatorRepository.findOne(translator.getId());
		// then
		assertEquals("�ȼҿ�", translator.getName());
	}
	


	@Test
	public void ��������������Ʈ��������() {
		// begin
		
		// when
		List<Translator> list = translatorRepository.findAll();
		// then
		assertEquals(2, list.size());
	}
	
	@Test
	public void ���������������ϱ�(){
		// begin
		
		// when 
		translatorRepository.save(new Translator(1,"�����"));
		Translator translator1 = translatorRepository.findOne(1);
		Translator translator2 = translatorRepository.findOne(2);


		// then
		assertEquals("�����", translator1.getName());
		assertEquals("�庸��", translator2.getName());
	}
	
	@Test
	public void ���������������ϱ�(){
		//when
		translatorRepository.deleteAll();
		
		//then
		assertEquals(0, translatorRepository.findAll().size());
	}

}
